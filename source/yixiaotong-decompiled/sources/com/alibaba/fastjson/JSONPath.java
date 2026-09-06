package com.alibaba.fastjson;

import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.parser.deserializer.ASMJavaBeanDeserializer;
import com.alibaba.fastjson.parser.deserializer.FieldDeserializer;
import com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.serializer.ASMJavaBeanSerializer;
import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.JavaBeanSerializer;
import com.alibaba.fastjson.serializer.ObjectSerializer;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.util.IOUtils;
import com.cdo.oaps.ad.OapsKey;
import com.huawei.openalliance.ad.constant.x;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.regex.Pattern;
import org.apache.commons.io.FilenameUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class JSONPath implements ObjectSerializer {
    private static int CACHE_SIZE = 1024;
    private static ConcurrentMap<String, JSONPath> pathCache = new ConcurrentHashMap(128, 0.75f, 1);
    private ParserConfig parserConfig;
    private final String path;
    private Segement[] segments;
    private SerializeConfig serializeConfig;

    interface Filter {
        boolean apply(JSONPath jSONPath, Object obj, Object obj2, Object obj3);
    }

    enum Operator {
        EQ,
        NE,
        GT,
        GE,
        LT,
        LE,
        LIKE,
        NOT_LIKE,
        RLIKE,
        NOT_RLIKE,
        IN,
        NOT_IN,
        BETWEEN,
        NOT_BETWEEN
    }

    interface Segement {
        Object eval(JSONPath jSONPath, Object obj, Object obj2);
    }

    public String getPath() {
        return this.path;
    }

    public JSONPath(String str) {
        this(str, SerializeConfig.getGlobalInstance(), ParserConfig.getGlobalInstance());
    }

    public JSONPath(String str, SerializeConfig serializeConfig, ParserConfig parserConfig) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException();
        }
        this.path = str;
        this.serializeConfig = serializeConfig;
        this.parserConfig = parserConfig;
    }

    protected void init() {
        if (this.segments != null) {
            return;
        }
        if ("*".equals(this.path)) {
            this.segments = new Segement[]{WildCardSegement.instance};
        } else {
            this.segments = new JSONPathParser(this.path).explain();
        }
    }

    public Object eval(Object obj) {
        if (obj == null) {
            return null;
        }
        init();
        int i = 0;
        Object objEval = obj;
        while (true) {
            Segement[] segementArr = this.segments;
            if (i >= segementArr.length) {
                return objEval;
            }
            objEval = segementArr[i].eval(this, obj, objEval);
            i++;
        }
    }

    public boolean contains(Object obj) {
        if (obj == null) {
            return false;
        }
        init();
        Object objEval = obj;
        int i = 0;
        while (true) {
            Segement[] segementArr = this.segments;
            if (i >= segementArr.length) {
                return true;
            }
            objEval = segementArr[i].eval(this, obj, objEval);
            if (objEval == null) {
                return false;
            }
            i++;
        }
    }

    public boolean containsValue(Object obj, Object obj2) {
        Object objEval = eval(obj);
        if (objEval == obj2) {
            return true;
        }
        if (objEval == null) {
            return false;
        }
        if (objEval instanceof Iterable) {
            Iterator it = ((Iterable) objEval).iterator();
            while (it.hasNext()) {
                if (eq(it.next(), obj2)) {
                    return true;
                }
            }
            return false;
        }
        return eq(objEval, obj2);
    }

    public int size(Object obj) {
        if (obj == null) {
            return -1;
        }
        init();
        int i = 0;
        Object objEval = obj;
        while (true) {
            Segement[] segementArr = this.segments;
            if (i < segementArr.length) {
                objEval = segementArr[i].eval(this, obj, objEval);
                i++;
            } else {
                return evalSize(objEval);
            }
        }
    }

    public void arrayAdd(Object obj, Object... objArr) {
        if (objArr == null || objArr.length == 0 || obj == null) {
            return;
        }
        init();
        int i = 0;
        Object obj2 = null;
        Object objEval = obj;
        int i2 = 0;
        while (true) {
            Segement[] segementArr = this.segments;
            if (i2 >= segementArr.length) {
                break;
            }
            if (i2 == segementArr.length - 1) {
                obj2 = objEval;
            }
            objEval = segementArr[i2].eval(this, obj, objEval);
            i2++;
        }
        if (objEval == null) {
            throw new JSONPathException("value not found in path " + this.path);
        }
        if (objEval instanceof Collection) {
            Collection collection = (Collection) objEval;
            int length = objArr.length;
            while (i < length) {
                collection.add(objArr[i]);
                i++;
            }
            return;
        }
        Class<?> cls = objEval.getClass();
        if (cls.isArray()) {
            int length2 = Array.getLength(objEval);
            Object objNewInstance = Array.newInstance(cls.getComponentType(), objArr.length + length2);
            System.arraycopy(objEval, 0, objNewInstance, 0, length2);
            while (i < objArr.length) {
                Array.set(objNewInstance, length2 + i, objArr[i]);
                i++;
            }
            Segement[] segementArr2 = this.segments;
            Segement segement = segementArr2[segementArr2.length - 1];
            if (segement instanceof PropertySegement) {
                ((PropertySegement) segement).setValue(this, obj2, objNewInstance);
                return;
            } else {
                if (segement instanceof ArrayAccessSegement) {
                    ((ArrayAccessSegement) segement).setValue(this, obj2, objNewInstance);
                    return;
                }
                throw new UnsupportedOperationException();
            }
        }
        throw new UnsupportedOperationException();
    }

    public boolean set(Object obj, Object obj2) {
        if (obj == null) {
            return false;
        }
        init();
        Object objEval = obj;
        int i = 0;
        while (true) {
            Segement[] segementArr = this.segments;
            if (i < segementArr.length) {
                if (i == segementArr.length - 1) {
                    break;
                }
                objEval = segementArr[i].eval(this, obj, objEval);
                if (objEval != null) {
                    i++;
                }
            }
            objEval = null;
            break;
        }
        if (objEval == null) {
            return false;
        }
        Segement[] segementArr2 = this.segments;
        Segement segement = segementArr2[segementArr2.length - 1];
        if (segement instanceof PropertySegement) {
            ((PropertySegement) segement).setValue(this, objEval, obj2);
            return true;
        }
        if (segement instanceof ArrayAccessSegement) {
            return ((ArrayAccessSegement) segement).setValue(this, objEval, obj2);
        }
        throw new UnsupportedOperationException();
    }

    public static Object eval(Object obj, String str) {
        return compile(str).eval(obj);
    }

    public static int size(Object obj, String str) {
        JSONPath jSONPathCompile = compile(str);
        return jSONPathCompile.evalSize(jSONPathCompile.eval(obj));
    }

    public static boolean contains(Object obj, String str) {
        if (obj == null) {
            return false;
        }
        return compile(str).contains(obj);
    }

    public static boolean containsValue(Object obj, String str, Object obj2) {
        return compile(str).containsValue(obj, obj2);
    }

    public static void arrayAdd(Object obj, String str, Object... objArr) {
        compile(str).arrayAdd(obj, objArr);
    }

    public static void set(Object obj, String str, Object obj2) {
        compile(str).set(obj, obj2);
    }

    public static JSONPath compile(String str) {
        JSONPath jSONPath = pathCache.get(str);
        if (jSONPath != null) {
            return jSONPath;
        }
        JSONPath jSONPath2 = new JSONPath(str);
        if (pathCache.size() >= CACHE_SIZE) {
            return jSONPath2;
        }
        pathCache.putIfAbsent(str, jSONPath2);
        return pathCache.get(str);
    }

    static class JSONPathParser {
        private char ch;
        private int level;
        private final String path;
        private int pos;

        static boolean isDigitFirst(char c) {
            return c == '-' || c == '+' || (c >= '0' && c <= '9');
        }

        public JSONPathParser(String str) {
            this.path = str;
            next();
        }

        void next() {
            String str = this.path;
            int i = this.pos;
            this.pos = i + 1;
            this.ch = str.charAt(i);
        }

        boolean isEOF() {
            return this.pos >= this.path.length();
        }

        Segement readSegement() {
            while (!isEOF()) {
                skipWhitespace();
                char c = this.ch;
                if (c == '@') {
                    next();
                    return SelfSegement.instance;
                }
                if (c != '$') {
                    if (c != '.') {
                        if (c == '[') {
                            return parseArrayAccess();
                        }
                        if (this.level == 0) {
                            return new PropertySegement(readName());
                        }
                        throw new UnsupportedOperationException();
                    }
                    next();
                    if (this.ch == '*') {
                        if (!isEOF()) {
                            next();
                        }
                        return WildCardSegement.instance;
                    }
                    String name = readName();
                    if (this.ch == '(') {
                        next();
                        if (this.ch == ')') {
                            if (!isEOF()) {
                                next();
                            }
                            if (OapsKey.KEY_SIZE.equals(name)) {
                                return SizeSegement.instance;
                            }
                            throw new UnsupportedOperationException();
                        }
                        throw new UnsupportedOperationException();
                    }
                    return new PropertySegement(name);
                }
                next();
            }
            return null;
        }

        public final void skipWhitespace() {
            while (this.ch < IOUtils.whitespaceFlags.length && IOUtils.whitespaceFlags[this.ch]) {
                next();
            }
        }

        Segement parseArrayAccess() {
            boolean z;
            String[] strArr;
            String str;
            String str2;
            accept('[');
            int i = 0;
            if (this.ch == '?') {
                next();
                accept('(');
                if (this.ch == '@') {
                    next();
                    accept(FilenameUtils.EXTENSION_SEPARATOR);
                }
                z = true;
            } else {
                z = false;
            }
            if (z || IOUtils.firstIdentifier(this.ch)) {
                String name = readName();
                skipWhitespace();
                if (z && this.ch == ')') {
                    next();
                    accept(']');
                    return new FilterSegement(new NotNullSegement(name));
                }
                if (this.ch == ']') {
                    next();
                    return new FilterSegement(new NotNullSegement(name));
                }
                Operator op = readOp();
                skipWhitespace();
                if (op == Operator.BETWEEN || op == Operator.NOT_BETWEEN) {
                    boolean z2 = op == Operator.NOT_BETWEEN;
                    Object value = readValue();
                    if (!"and".equalsIgnoreCase(readName())) {
                        throw new JSONPathException(this.path);
                    }
                    Object value2 = readValue();
                    if (value == null || value2 == null) {
                        throw new JSONPathException(this.path);
                    }
                    if (JSONPath.isInt(value.getClass()) && JSONPath.isInt(value2.getClass())) {
                        return new FilterSegement(new IntBetweenSegement(name, ((Number) value).longValue(), ((Number) value2).longValue(), z2));
                    }
                    throw new JSONPathException(this.path);
                }
                if (op == Operator.IN || op == Operator.NOT_IN) {
                    boolean z3 = op == Operator.NOT_IN;
                    accept('(');
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(readValue());
                    while (true) {
                        skipWhitespace();
                        if (this.ch != ',') {
                            break;
                        }
                        next();
                        arrayList.add(readValue());
                    }
                    accept(')');
                    if (z) {
                        accept(')');
                    }
                    accept(']');
                    boolean z4 = true;
                    boolean z5 = true;
                    boolean z6 = true;
                    for (Object obj : arrayList) {
                        if (obj != null) {
                            Class<?> cls = obj.getClass();
                            if (z4 && cls != Byte.class && cls != Short.class && cls != Integer.class && cls != Long.class) {
                                z4 = false;
                                z6 = false;
                            }
                            if (z5 && cls != String.class) {
                                z5 = false;
                            }
                        } else if (z4) {
                            z4 = false;
                        }
                    }
                    if (arrayList.size() == 1 && arrayList.get(0) == null) {
                        if (z3) {
                            return new FilterSegement(new NotNullSegement(name));
                        }
                        return new FilterSegement(new NullSegement(name));
                    }
                    if (z4) {
                        if (arrayList.size() == 1) {
                            return new FilterSegement(new IntOpSegement(name, ((Number) arrayList.get(0)).longValue(), z3 ? Operator.NE : Operator.EQ));
                        }
                        int size = arrayList.size();
                        long[] jArr = new long[size];
                        while (i < size) {
                            jArr[i] = ((Number) arrayList.get(i)).longValue();
                            i++;
                        }
                        return new FilterSegement(new IntInSegement(name, jArr, z3));
                    }
                    if (z5) {
                        if (arrayList.size() == 1) {
                            return new FilterSegement(new StringOpSegement(name, (String) arrayList.get(0), z3 ? Operator.NE : Operator.EQ));
                        }
                        String[] strArr2 = new String[arrayList.size()];
                        arrayList.toArray(strArr2);
                        return new FilterSegement(new StringInSegement(name, strArr2, z3));
                    }
                    if (z6) {
                        int size2 = arrayList.size();
                        Long[] lArr = new Long[size2];
                        while (i < size2) {
                            Number number = (Number) arrayList.get(i);
                            if (number != null) {
                                lArr[i] = Long.valueOf(number.longValue());
                            }
                            i++;
                        }
                        return new FilterSegement(new IntObjInSegement(name, lArr, z3));
                    }
                    throw new UnsupportedOperationException();
                }
                char c = this.ch;
                if (c == '\'' || c == '\"') {
                    String string = readString();
                    if (z) {
                        accept(')');
                    }
                    accept(']');
                    if (op == Operator.RLIKE) {
                        return new FilterSegement(new RlikeSegement(name, string, false));
                    }
                    if (op == Operator.NOT_RLIKE) {
                        return new FilterSegement(new RlikeSegement(name, string, true));
                    }
                    if (op == Operator.LIKE || op == Operator.NOT_LIKE) {
                        while (string.indexOf("%%") != -1) {
                            string = string.replaceAll("%%", "%");
                        }
                        boolean z7 = op == Operator.NOT_LIKE;
                        int iIndexOf = string.indexOf(37);
                        if (iIndexOf == -1) {
                            if (op == Operator.LIKE) {
                                op = Operator.EQ;
                            } else {
                                op = Operator.NE;
                            }
                        } else {
                            String[] strArrSplit = string.split("%");
                            String[] strArr3 = null;
                            if (iIndexOf == 0) {
                                if (string.charAt(string.length() - 1) == '%') {
                                    int length = strArrSplit.length - 1;
                                    String[] strArr4 = new String[length];
                                    System.arraycopy(strArrSplit, 1, strArr4, 0, length);
                                    str = null;
                                    str2 = null;
                                    strArr3 = strArr4;
                                } else {
                                    String str3 = strArrSplit[strArrSplit.length - 1];
                                    if (strArrSplit.length > 2) {
                                        int length2 = strArrSplit.length - 2;
                                        strArr = new String[length2];
                                        System.arraycopy(strArrSplit, 1, strArr, 0, length2);
                                        str2 = str3;
                                        str = null;
                                        strArr3 = strArr;
                                    } else {
                                        str2 = str3;
                                        str = null;
                                    }
                                }
                            } else if (string.charAt(string.length() - 1) == '%') {
                                str = null;
                                str2 = null;
                                strArr3 = strArrSplit;
                            } else if (strArrSplit.length == 1) {
                                str = strArrSplit[0];
                                str2 = null;
                            } else if (strArrSplit.length == 2) {
                                str = strArrSplit[0];
                                str2 = strArrSplit[1];
                            } else {
                                String str4 = strArrSplit[0];
                                String str5 = strArrSplit[strArrSplit.length - 1];
                                int length3 = strArrSplit.length - 2;
                                strArr = new String[length3];
                                System.arraycopy(strArrSplit, 1, strArr, 0, length3);
                                str = str4;
                                str2 = str5;
                                strArr3 = strArr;
                            }
                            return new FilterSegement(new MatchSegement(name, str, str2, strArr3, z7));
                        }
                    }
                    return new FilterSegement(new StringOpSegement(name, string, op));
                }
                if (isDigitFirst(c)) {
                    long longValue = readLongValue();
                    if (z) {
                        accept(')');
                    }
                    accept(']');
                    return new FilterSegement(new IntOpSegement(name, longValue, op));
                }
                if (this.ch == 'n' && "null".equals(readName())) {
                    if (z) {
                        accept(')');
                    }
                    accept(']');
                    if (op == Operator.EQ) {
                        return new FilterSegement(new NullSegement(name));
                    }
                    if (op == Operator.NE) {
                        return new FilterSegement(new NotNullSegement(name));
                    }
                    throw new UnsupportedOperationException();
                }
                throw new UnsupportedOperationException();
            }
            int i2 = this.pos - 1;
            while (this.ch != ']' && !isEOF()) {
                next();
            }
            String strSubstring = this.path.substring(i2, this.pos - 1);
            if (!isEOF()) {
                accept(']');
            }
            return buildArraySegement(strSubstring);
        }

        protected long readLongValue() {
            int i = this.pos - 1;
            char c = this.ch;
            if (c == '+' || c == '-') {
                next();
            }
            while (true) {
                char c2 = this.ch;
                if (c2 < '0' || c2 > '9') {
                    break;
                }
                next();
            }
            return Long.parseLong(this.path.substring(i, this.pos - 1));
        }

        protected Object readValue() {
            skipWhitespace();
            if (isDigitFirst(this.ch)) {
                return Long.valueOf(readLongValue());
            }
            char c = this.ch;
            if (c == '\"' || c == '\'') {
                return readString();
            }
            if (c == 'n') {
                if ("null".equals(readName())) {
                    return null;
                }
                throw new JSONPathException(this.path);
            }
            throw new UnsupportedOperationException();
        }

        protected Operator readOp() {
            Operator operator;
            char c = this.ch;
            if (c == '=') {
                next();
                operator = Operator.EQ;
            } else if (c == '!') {
                next();
                accept('=');
                operator = Operator.NE;
            } else if (c == '<') {
                next();
                if (this.ch == '=') {
                    next();
                    operator = Operator.LE;
                } else {
                    operator = Operator.LT;
                }
            } else if (c == '>') {
                next();
                if (this.ch == '=') {
                    next();
                    operator = Operator.GE;
                } else {
                    operator = Operator.GT;
                }
            } else {
                operator = null;
            }
            if (operator != null) {
                return operator;
            }
            String name = readName();
            if ("not".equalsIgnoreCase(name)) {
                skipWhitespace();
                String name2 = readName();
                if ("like".equalsIgnoreCase(name2)) {
                    return Operator.NOT_LIKE;
                }
                if ("rlike".equalsIgnoreCase(name2)) {
                    return Operator.NOT_RLIKE;
                }
                if ("in".equalsIgnoreCase(name2)) {
                    return Operator.NOT_IN;
                }
                if ("between".equalsIgnoreCase(name2)) {
                    return Operator.NOT_BETWEEN;
                }
                throw new UnsupportedOperationException();
            }
            if ("like".equalsIgnoreCase(name)) {
                return Operator.LIKE;
            }
            if ("rlike".equalsIgnoreCase(name)) {
                return Operator.RLIKE;
            }
            if ("in".equalsIgnoreCase(name)) {
                return Operator.IN;
            }
            if ("between".equalsIgnoreCase(name)) {
                return Operator.BETWEEN;
            }
            throw new UnsupportedOperationException();
        }

        String readName() {
            skipWhitespace();
            if (!IOUtils.firstIdentifier(this.ch)) {
                throw new JSONPathException("illeal jsonpath syntax. " + this.path);
            }
            StringBuffer stringBuffer = new StringBuffer();
            while (!isEOF()) {
                char c = this.ch;
                if (c == '\\') {
                    next();
                    stringBuffer.append(this.ch);
                    next();
                } else {
                    if (!IOUtils.isIdent(c)) {
                        break;
                    }
                    stringBuffer.append(this.ch);
                    next();
                }
            }
            if (isEOF() && IOUtils.isIdent(this.ch)) {
                stringBuffer.append(this.ch);
            }
            return stringBuffer.toString();
        }

        String readString() {
            char c = this.ch;
            next();
            int i = this.pos - 1;
            while (this.ch != c && !isEOF()) {
                next();
            }
            String strSubstring = this.path.substring(i, isEOF() ? this.pos : this.pos - 1);
            accept(c);
            return strSubstring;
        }

        void accept(char c) {
            if (this.ch != c) {
                throw new JSONPathException("expect '" + c + ", but '" + this.ch + "'");
            }
            if (isEOF()) {
                return;
            }
            next();
        }

        public Segement[] explain() {
            String str = this.path;
            if (str == null || str.isEmpty()) {
                throw new IllegalArgumentException();
            }
            Segement[] segementArr = new Segement[8];
            while (true) {
                Segement segement = readSegement();
                if (segement == null) {
                    break;
                }
                int i = this.level;
                this.level = i + 1;
                segementArr[i] = segement;
            }
            int i2 = this.level;
            if (i2 == 8) {
                return segementArr;
            }
            Segement[] segementArr2 = new Segement[i2];
            System.arraycopy(segementArr, 0, segementArr2, 0, i2);
            return segementArr2;
        }

        Segement buildArraySegement(String str) {
            int length = str.length();
            int i = 0;
            char cCharAt = str.charAt(0);
            int i2 = length - 1;
            char cCharAt2 = str.charAt(i2);
            int iIndexOf = str.indexOf(44);
            if (str.length() > 2 && cCharAt == '\'' && cCharAt2 == '\'') {
                if (iIndexOf == -1) {
                    return new PropertySegement(str.substring(1, i2));
                }
                String[] strArrSplit = str.split(",");
                String[] strArr = new String[strArrSplit.length];
                while (i < strArrSplit.length) {
                    String str2 = strArrSplit[i];
                    strArr[i] = str2.substring(1, str2.length() - 1);
                    i++;
                }
                return new MultiPropertySegement(strArr);
            }
            int iIndexOf2 = str.indexOf(58);
            if (iIndexOf == -1 && iIndexOf2 == -1) {
                return new ArrayAccessSegement(Integer.parseInt(str));
            }
            if (iIndexOf != -1) {
                String[] strArrSplit2 = str.split(",");
                int[] iArr = new int[strArrSplit2.length];
                while (i < strArrSplit2.length) {
                    iArr[i] = Integer.parseInt(strArrSplit2[i]);
                    i++;
                }
                return new MultiIndexSegement(iArr);
            }
            if (iIndexOf2 != -1) {
                String[] strArrSplit3 = str.split(x.bQ);
                int length2 = strArrSplit3.length;
                int[] iArr2 = new int[length2];
                for (int i3 = 0; i3 < strArrSplit3.length; i3++) {
                    String str3 = strArrSplit3[i3];
                    if (!str3.isEmpty()) {
                        iArr2[i3] = Integer.parseInt(str3);
                    } else if (i3 == 0) {
                        iArr2[i3] = 0;
                    } else {
                        throw new UnsupportedOperationException();
                    }
                }
                int i4 = iArr2[0];
                int i5 = length2 > 1 ? iArr2[1] : -1;
                int i6 = length2 == 3 ? iArr2[2] : 1;
                if (i5 >= 0 && i5 < i4) {
                    throw new UnsupportedOperationException("end must greater than or equals start. start " + i4 + ",  end " + i5);
                }
                if (i6 <= 0) {
                    throw new UnsupportedOperationException("step must greater than zero : " + i6);
                }
                return new RangeSegement(i4, i5, i6);
            }
            throw new UnsupportedOperationException();
        }
    }

    static class SelfSegement implements Segement {
        public static final SelfSegement instance = new SelfSegement();

        @Override // com.alibaba.fastjson.JSONPath.Segement
        public Object eval(JSONPath jSONPath, Object obj, Object obj2) {
            return obj2;
        }

        SelfSegement() {
        }
    }

    static class SizeSegement implements Segement {
        public static final SizeSegement instance = new SizeSegement();

        SizeSegement() {
        }

        @Override // com.alibaba.fastjson.JSONPath.Segement
        public Integer eval(JSONPath jSONPath, Object obj, Object obj2) {
            return Integer.valueOf(jSONPath.evalSize(obj2));
        }
    }

    static class PropertySegement implements Segement {
        private final String propertyName;

        public PropertySegement(String str) {
            this.propertyName = str;
        }

        @Override // com.alibaba.fastjson.JSONPath.Segement
        public Object eval(JSONPath jSONPath, Object obj, Object obj2) {
            return jSONPath.getPropertyValue(obj2, this.propertyName, true);
        }

        public void setValue(JSONPath jSONPath, Object obj, Object obj2) {
            jSONPath.setPropertyValue(obj, this.propertyName, obj2);
        }
    }

    static class MultiPropertySegement implements Segement {
        private final String[] propertyNames;

        public MultiPropertySegement(String[] strArr) {
            this.propertyNames = strArr;
        }

        @Override // com.alibaba.fastjson.JSONPath.Segement
        public Object eval(JSONPath jSONPath, Object obj, Object obj2) {
            ArrayList arrayList = new ArrayList(this.propertyNames.length);
            for (String str : this.propertyNames) {
                arrayList.add(jSONPath.getPropertyValue(obj2, str, true));
            }
            return arrayList;
        }
    }

    static class WildCardSegement implements Segement {
        public static WildCardSegement instance = new WildCardSegement();

        WildCardSegement() {
        }

        @Override // com.alibaba.fastjson.JSONPath.Segement
        public Object eval(JSONPath jSONPath, Object obj, Object obj2) {
            return jSONPath.getPropertyValues(obj2);
        }
    }

    static class ArrayAccessSegement implements Segement {
        private final int index;

        public ArrayAccessSegement(int i) {
            this.index = i;
        }

        @Override // com.alibaba.fastjson.JSONPath.Segement
        public Object eval(JSONPath jSONPath, Object obj, Object obj2) {
            return jSONPath.getArrayItem(obj2, this.index);
        }

        public boolean setValue(JSONPath jSONPath, Object obj, Object obj2) {
            return jSONPath.setArrayItem(jSONPath, obj, this.index, obj2);
        }
    }

    static class MultiIndexSegement implements Segement {
        private final int[] indexes;

        public MultiIndexSegement(int[] iArr) {
            this.indexes = iArr;
        }

        @Override // com.alibaba.fastjson.JSONPath.Segement
        public Object eval(JSONPath jSONPath, Object obj, Object obj2) {
            ArrayList arrayList = new ArrayList(this.indexes.length);
            int i = 0;
            while (true) {
                int[] iArr = this.indexes;
                if (i >= iArr.length) {
                    return arrayList;
                }
                arrayList.add(jSONPath.getArrayItem(obj2, iArr[i]));
                i++;
            }
        }
    }

    static class RangeSegement implements Segement {
        private final int end;
        private final int start;
        private final int step;

        public RangeSegement(int i, int i2, int i3) {
            this.start = i;
            this.end = i2;
            this.step = i3;
        }

        @Override // com.alibaba.fastjson.JSONPath.Segement
        public Object eval(JSONPath jSONPath, Object obj, Object obj2) {
            int iIntValue = SizeSegement.instance.eval(jSONPath, obj, obj2).intValue();
            int i = this.start;
            if (i < 0) {
                i += iIntValue;
            }
            int i2 = this.end;
            if (i2 < 0) {
                i2 += iIntValue;
            }
            ArrayList arrayList = new ArrayList(((i2 - i) / this.step) + 1);
            while (i <= i2 && i < iIntValue) {
                arrayList.add(jSONPath.getArrayItem(obj2, i));
                i += this.step;
            }
            return arrayList;
        }
    }

    static class NotNullSegement implements Filter {
        private final String propertyName;

        public NotNullSegement(String str) {
            this.propertyName = str;
        }

        @Override // com.alibaba.fastjson.JSONPath.Filter
        public boolean apply(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            return jSONPath.getPropertyValue(obj3, this.propertyName, false) != null;
        }
    }

    static class NullSegement implements Filter {
        private final String propertyName;

        public NullSegement(String str) {
            this.propertyName = str;
        }

        @Override // com.alibaba.fastjson.JSONPath.Filter
        public boolean apply(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            return jSONPath.getPropertyValue(obj3, this.propertyName, false) == null;
        }
    }

    static class IntInSegement implements Filter {
        private final boolean not;
        private final String propertyName;
        private final long[] values;

        public IntInSegement(String str, long[] jArr, boolean z) {
            this.propertyName = str;
            this.values = jArr;
            this.not = z;
        }

        @Override // com.alibaba.fastjson.JSONPath.Filter
        public boolean apply(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            Object propertyValue = jSONPath.getPropertyValue(obj3, this.propertyName, false);
            if (propertyValue == null) {
                return false;
            }
            if (propertyValue instanceof Number) {
                long jLongValue = ((Number) propertyValue).longValue();
                for (long j : this.values) {
                    if (j == jLongValue) {
                        return !this.not;
                    }
                }
            }
            return this.not;
        }
    }

    static class IntBetweenSegement implements Filter {
        private final long endValue;
        private final boolean not;
        private final String propertyName;
        private final long startValue;

        public IntBetweenSegement(String str, long j, long j2, boolean z) {
            this.propertyName = str;
            this.startValue = j;
            this.endValue = j2;
            this.not = z;
        }

        @Override // com.alibaba.fastjson.JSONPath.Filter
        public boolean apply(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            Object propertyValue = jSONPath.getPropertyValue(obj3, this.propertyName, false);
            if (propertyValue == null) {
                return false;
            }
            if (propertyValue instanceof Number) {
                long jLongValue = ((Number) propertyValue).longValue();
                if (jLongValue >= this.startValue && jLongValue <= this.endValue) {
                    return !this.not;
                }
            }
            return this.not;
        }
    }

    static class IntObjInSegement implements Filter {
        private final boolean not;
        private final String propertyName;
        private final Long[] values;

        public IntObjInSegement(String str, Long[] lArr, boolean z) {
            this.propertyName = str;
            this.values = lArr;
            this.not = z;
        }

        @Override // com.alibaba.fastjson.JSONPath.Filter
        public boolean apply(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            int i = 0;
            Object propertyValue = jSONPath.getPropertyValue(obj3, this.propertyName, false);
            if (propertyValue == null) {
                Long[] lArr = this.values;
                int length = lArr.length;
                while (i < length) {
                    if (lArr[i] == null) {
                        return !this.not;
                    }
                    i++;
                }
                return this.not;
            }
            if (propertyValue instanceof Number) {
                long jLongValue = ((Number) propertyValue).longValue();
                Long[] lArr2 = this.values;
                int length2 = lArr2.length;
                while (i < length2) {
                    Long l = lArr2[i];
                    if (l != null && l.longValue() == jLongValue) {
                        return !this.not;
                    }
                    i++;
                }
            }
            return this.not;
        }
    }

    static class StringInSegement implements Filter {
        private final boolean not;
        private final String propertyName;
        private final String[] values;

        public StringInSegement(String str, String[] strArr, boolean z) {
            this.propertyName = str;
            this.values = strArr;
            this.not = z;
        }

        @Override // com.alibaba.fastjson.JSONPath.Filter
        public boolean apply(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            Object propertyValue = jSONPath.getPropertyValue(obj3, this.propertyName, false);
            for (String str : this.values) {
                if (str == propertyValue) {
                    return !this.not;
                }
                if (str != null && str.equals(propertyValue)) {
                    return !this.not;
                }
            }
            return this.not;
        }
    }

    static class IntOpSegement implements Filter {
        private final Operator op;
        private final String propertyName;
        private final long value;

        public IntOpSegement(String str, long j, Operator operator) {
            this.propertyName = str;
            this.value = j;
            this.op = operator;
        }

        @Override // com.alibaba.fastjson.JSONPath.Filter
        public boolean apply(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            Object propertyValue = jSONPath.getPropertyValue(obj3, this.propertyName, false);
            if (propertyValue == null || !(propertyValue instanceof Number)) {
                return false;
            }
            long jLongValue = ((Number) propertyValue).longValue();
            if (this.op == Operator.EQ) {
                return jLongValue == this.value;
            }
            if (this.op == Operator.NE) {
                return jLongValue != this.value;
            }
            if (this.op == Operator.GE) {
                return jLongValue >= this.value;
            }
            if (this.op == Operator.GT) {
                return jLongValue > this.value;
            }
            if (this.op == Operator.LE) {
                return jLongValue <= this.value;
            }
            return this.op == Operator.LT && jLongValue < this.value;
        }
    }

    static class MatchSegement implements Filter {
        private final String[] containsValues;
        private final String endsWithValue;
        private final int minLength;
        private final boolean not;
        private final String propertyName;
        private final String startsWithValue;

        public MatchSegement(String str, String str2, String str3, String[] strArr, boolean z) {
            this.propertyName = str;
            this.startsWithValue = str2;
            this.endsWithValue = str3;
            this.containsValues = strArr;
            this.not = z;
            int length = str2 != null ? str2.length() : 0;
            length = str3 != null ? length + str3.length() : length;
            if (strArr != null) {
                for (String str4 : strArr) {
                    length += str4.length();
                }
            }
            this.minLength = length;
        }

        @Override // com.alibaba.fastjson.JSONPath.Filter
        public boolean apply(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            int length;
            Object propertyValue = jSONPath.getPropertyValue(obj3, this.propertyName, false);
            if (propertyValue == null) {
                return false;
            }
            String string = propertyValue.toString();
            if (string.length() < this.minLength) {
                return this.not;
            }
            String str = this.startsWithValue;
            if (str == null) {
                length = 0;
            } else {
                if (!string.startsWith(str)) {
                    return this.not;
                }
                length = this.startsWithValue.length();
            }
            String[] strArr = this.containsValues;
            if (strArr != null) {
                for (String str2 : strArr) {
                    int iIndexOf = string.indexOf(str2, length);
                    if (iIndexOf == -1) {
                        return this.not;
                    }
                    length = iIndexOf + str2.length();
                }
            }
            String str3 = this.endsWithValue;
            return (str3 == null || string.endsWith(str3)) ? !this.not : this.not;
        }
    }

    static class RlikeSegement implements Filter {
        private final boolean not;
        private final Pattern pattern;
        private final String propertyName;

        public RlikeSegement(String str, String str2, boolean z) {
            this.propertyName = str;
            this.pattern = Pattern.compile(str2);
            this.not = z;
        }

        @Override // com.alibaba.fastjson.JSONPath.Filter
        public boolean apply(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            Object propertyValue = jSONPath.getPropertyValue(obj3, this.propertyName, false);
            if (propertyValue == null) {
                return false;
            }
            boolean zMatches = this.pattern.matcher(propertyValue.toString()).matches();
            return this.not ? !zMatches : zMatches;
        }
    }

    static class StringOpSegement implements Filter {
        private final Operator op;
        private final String propertyName;
        private final String value;

        public StringOpSegement(String str, String str2, Operator operator) {
            this.propertyName = str;
            this.value = str2;
            this.op = operator;
        }

        @Override // com.alibaba.fastjson.JSONPath.Filter
        public boolean apply(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            Object propertyValue = jSONPath.getPropertyValue(obj3, this.propertyName, false);
            if (this.op == Operator.EQ) {
                return this.value.equals(propertyValue);
            }
            if (this.op == Operator.NE) {
                return !this.value.equals(propertyValue);
            }
            if (propertyValue == null) {
                return false;
            }
            int iCompareTo = this.value.compareTo(propertyValue.toString());
            if (this.op == Operator.GE) {
                return iCompareTo <= 0;
            }
            if (this.op == Operator.GT) {
                return iCompareTo < 0;
            }
            if (this.op == Operator.LE) {
                return iCompareTo >= 0;
            }
            return this.op == Operator.LT && iCompareTo > 0;
        }
    }

    public static class FilterSegement implements Segement {
        private final Filter filter;

        public FilterSegement(Filter filter) {
            this.filter = filter;
        }

        @Override // com.alibaba.fastjson.JSONPath.Segement
        public Object eval(JSONPath jSONPath, Object obj, Object obj2) {
            if (obj2 == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (obj2 instanceof Iterable) {
                for (Object obj3 : (Iterable) obj2) {
                    if (this.filter.apply(jSONPath, obj, obj2, obj3)) {
                        arrayList.add(obj3);
                    }
                }
                return arrayList;
            }
            if (this.filter.apply(jSONPath, obj, obj2, obj2)) {
                return obj2;
            }
            return null;
        }
    }

    protected Object getArrayItem(Object obj, int i) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof List) {
            List list = (List) obj;
            if (i >= 0) {
                if (i < list.size()) {
                    return list.get(i);
                }
                return null;
            }
            if (Math.abs(i) <= list.size()) {
                return list.get(list.size() + i);
            }
            return null;
        }
        if (obj.getClass().isArray()) {
            int length = Array.getLength(obj);
            if (i >= 0) {
                if (i < length) {
                    return Array.get(obj, i);
                }
                return null;
            }
            if (Math.abs(i) <= length) {
                return Array.get(obj, length + i);
            }
            return null;
        }
        throw new UnsupportedOperationException();
    }

    public boolean setArrayItem(JSONPath jSONPath, Object obj, int i, Object obj2) {
        if (obj instanceof List) {
            List list = (List) obj;
            if (i >= 0) {
                list.set(i, obj2);
            } else {
                list.set(list.size() + i, obj2);
            }
            return true;
        }
        if (obj.getClass().isArray()) {
            int length = Array.getLength(obj);
            if (i >= 0) {
                if (i < length) {
                    Array.set(obj, i, obj2);
                }
            } else if (Math.abs(i) <= length) {
                Array.set(obj, length + i, obj2);
            }
            return true;
        }
        throw new UnsupportedOperationException();
    }

    protected Collection<Object> getPropertyValues(Object obj) {
        JavaBeanSerializer javaBeanSerializer = getJavaBeanSerializer(obj.getClass());
        if (javaBeanSerializer != null) {
            try {
                return javaBeanSerializer.getFieldValues(obj);
            } catch (Exception e) {
                throw new JSONPathException("jsonpath error, path " + this.path, e);
            }
        }
        if (obj instanceof Map) {
            return ((Map) obj).values();
        }
        throw new UnsupportedOperationException();
    }

    static boolean eq(Object obj, Object obj2) {
        if (obj == obj2) {
            return true;
        }
        if (obj == null || obj2 == null) {
            return false;
        }
        if (obj.getClass() == obj2.getClass()) {
            return obj.equals(obj2);
        }
        if (obj instanceof Number) {
            if (obj2 instanceof Number) {
                return eqNotNull((Number) obj, (Number) obj2);
            }
            return false;
        }
        return obj.equals(obj2);
    }

    static boolean eqNotNull(Number number, Number number2) {
        Class<?> cls = number.getClass();
        boolean zIsInt = isInt(cls);
        Class<?> cls2 = number.getClass();
        boolean zIsInt2 = isInt(cls2);
        if (zIsInt && zIsInt2) {
            return number.longValue() == number2.longValue();
        }
        boolean zIsDouble = isDouble(cls);
        boolean zIsDouble2 = isDouble(cls2);
        return ((zIsDouble && zIsDouble2) || ((zIsDouble && zIsInt) || (zIsDouble2 && zIsInt))) && number.doubleValue() == number2.doubleValue();
    }

    protected static boolean isDouble(Class<?> cls) {
        return cls == Float.class || cls == Double.class;
    }

    protected static boolean isInt(Class<?> cls) {
        return cls == Byte.class || cls == Short.class || cls == Integer.class || cls == Long.class;
    }

    protected Object getPropertyValue(Object obj, String str, boolean z) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Map) {
            return ((Map) obj).get(str);
        }
        JavaBeanSerializer javaBeanSerializer = getJavaBeanSerializer(obj.getClass());
        if (javaBeanSerializer != null) {
            try {
                return javaBeanSerializer.getFieldValue(obj, str);
            } catch (Exception e) {
                throw new JSONPathException("jsonpath error, path " + this.path + ", segement " + str, e);
            }
        }
        if (obj instanceof List) {
            List list = (List) obj;
            ArrayList arrayList = new ArrayList(list.size());
            for (int i = 0; i < list.size(); i++) {
                arrayList.add(getPropertyValue(list.get(i), str, z));
            }
            return arrayList;
        }
        throw new JSONPathException("jsonpath error, path " + this.path + ", segement " + str);
    }

    protected boolean setPropertyValue(Object obj, String str, Object obj2) {
        JavaBeanDeserializer innterSerializer;
        if (obj instanceof Map) {
            ((Map) obj).put(str, obj2);
            return true;
        }
        ObjectDeserializer deserializer = this.parserConfig.getDeserializer(obj.getClass());
        if (deserializer instanceof JavaBeanDeserializer) {
            innterSerializer = (JavaBeanDeserializer) deserializer;
        } else {
            innterSerializer = deserializer instanceof ASMJavaBeanDeserializer ? ((ASMJavaBeanDeserializer) deserializer).getInnterSerializer() : null;
        }
        if (innterSerializer != null) {
            FieldDeserializer fieldDeserializer = innterSerializer.getFieldDeserializer(str);
            if (fieldDeserializer == null) {
                return false;
            }
            fieldDeserializer.setValue(obj, obj2);
            return true;
        }
        throw new UnsupportedOperationException();
    }

    protected JavaBeanSerializer getJavaBeanSerializer(Class<?> cls) {
        ObjectSerializer objectWriter = this.serializeConfig.getObjectWriter(cls);
        if (objectWriter instanceof JavaBeanSerializer) {
            return (JavaBeanSerializer) objectWriter;
        }
        if (objectWriter instanceof ASMJavaBeanSerializer) {
            return ((ASMJavaBeanSerializer) objectWriter).getJavaBeanSerializer();
        }
        return null;
    }

    int evalSize(Object obj) {
        if (obj == null) {
            return -1;
        }
        if (obj instanceof Collection) {
            return ((Collection) obj).size();
        }
        if (obj instanceof Object[]) {
            return ((Object[]) obj).length;
        }
        if (obj.getClass().isArray()) {
            return Array.getLength(obj);
        }
        int i = 0;
        if (obj instanceof Map) {
            Iterator it = ((Map) obj).values().iterator();
            while (it.hasNext()) {
                if (it.next() != null) {
                    i++;
                }
            }
            return i;
        }
        JavaBeanSerializer javaBeanSerializer = getJavaBeanSerializer(obj.getClass());
        if (javaBeanSerializer == null) {
            return -1;
        }
        try {
            List<Object> fieldValues = javaBeanSerializer.getFieldValues(obj);
            int i2 = 0;
            while (i < fieldValues.size()) {
                if (fieldValues.get(i) != null) {
                    i2++;
                }
                i++;
            }
            return i2;
        } catch (Exception e) {
            throw new JSONException("evalSize error : " + this.path, e);
        }
    }

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i) throws IOException {
        jSONSerializer.write(this.path);
    }
}
