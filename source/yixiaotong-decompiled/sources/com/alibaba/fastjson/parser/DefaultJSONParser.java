package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.deserializer.ASMJavaBeanDeserializer;
import com.alibaba.fastjson.parser.deserializer.CollectionResolveFieldDeserializer;
import com.alibaba.fastjson.parser.deserializer.ExtraProcessor;
import com.alibaba.fastjson.parser.deserializer.ExtraTypeProvider;
import com.alibaba.fastjson.parser.deserializer.FieldDeserializer;
import com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer;
import com.alibaba.fastjson.parser.deserializer.ListResolveFieldDeserializer;
import com.alibaba.fastjson.parser.deserializer.MapResolveFieldDeserializer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.serializer.IntegerCodec;
import com.alibaba.fastjson.serializer.LongCodec;
import com.alibaba.fastjson.serializer.StringCodec;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.Closeable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import kotlin.text.Typography;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class DefaultJSONParser extends AbstractJSONParser implements Closeable {
    public static final int NONE = 0;
    public static final int NeedToResolve = 1;
    public static final int TypeNameRedirect = 2;
    private static final Set<Class<?>> primitiveClasses;
    protected ParserConfig config;
    protected ParseContext context;
    private ParseContext[] contextArray;
    private int contextArrayIndex;
    private DateFormat dateFormat;
    private String dateFormatPattern;
    private List<ExtraProcessor> extraProcessors;
    private List<ExtraTypeProvider> extraTypeProviders;
    protected final Object input;
    protected final JSONLexer lexer;
    private int resolveStatus;
    private List<ResolveTask> resolveTaskList;
    protected final SymbolTable symbolTable;

    public ParserConfig getConfig() {
        return this.config;
    }

    public ParseContext getContext() {
        return this.context;
    }

    public String getDateFomartPattern() {
        return this.dateFormatPattern;
    }

    public List<ExtraProcessor> getExtraProcessorsDirect() {
        return this.extraProcessors;
    }

    public List<ExtraTypeProvider> getExtraTypeProvidersDirect() {
        return this.extraTypeProviders;
    }

    public JSONLexer getLexer() {
        return this.lexer;
    }

    public int getResolveStatus() {
        return this.resolveStatus;
    }

    public List<ResolveTask> getResolveTaskListDirect() {
        return this.resolveTaskList;
    }

    public SymbolTable getSymbolTable() {
        return this.symbolTable;
    }

    public void setConfig(ParserConfig parserConfig) {
        this.config = parserConfig;
    }

    public void setDateFomrat(DateFormat dateFormat) {
        this.dateFormat = dateFormat;
    }

    public void setDateFormat(String str) {
        this.dateFormatPattern = str;
        this.dateFormat = null;
    }

    public void setResolveStatus(int i) {
        this.resolveStatus = i;
    }

    static {
        HashSet hashSet = new HashSet();
        primitiveClasses = hashSet;
        hashSet.add(Boolean.TYPE);
        hashSet.add(Byte.TYPE);
        hashSet.add(Short.TYPE);
        hashSet.add(Integer.TYPE);
        hashSet.add(Long.TYPE);
        hashSet.add(Float.TYPE);
        hashSet.add(Double.TYPE);
        hashSet.add(Boolean.class);
        hashSet.add(Byte.class);
        hashSet.add(Short.class);
        hashSet.add(Integer.class);
        hashSet.add(Long.class);
        hashSet.add(Float.class);
        hashSet.add(Double.class);
        hashSet.add(BigInteger.class);
        hashSet.add(BigDecimal.class);
        hashSet.add(String.class);
    }

    public DateFormat getDateFormat() {
        if (this.dateFormat == null) {
            this.dateFormat = new SimpleDateFormat(this.dateFormatPattern);
        }
        return this.dateFormat;
    }

    public DefaultJSONParser(String str) {
        this(str, ParserConfig.getGlobalInstance(), JSON.DEFAULT_PARSER_FEATURE);
    }

    public DefaultJSONParser(String str, ParserConfig parserConfig) {
        this(str, new JSONScanner(str, JSON.DEFAULT_PARSER_FEATURE), parserConfig);
    }

    public DefaultJSONParser(String str, ParserConfig parserConfig, int i) {
        this(str, new JSONScanner(str, i), parserConfig);
    }

    public DefaultJSONParser(char[] cArr, int i, ParserConfig parserConfig, int i2) {
        this(cArr, new JSONScanner(cArr, i, i2), parserConfig);
    }

    public DefaultJSONParser(JSONLexer jSONLexer) {
        this(jSONLexer, ParserConfig.getGlobalInstance());
    }

    public DefaultJSONParser(JSONLexer jSONLexer, ParserConfig parserConfig) {
        this((Object) null, jSONLexer, parserConfig);
    }

    public DefaultJSONParser(Object obj, JSONLexer jSONLexer, ParserConfig parserConfig) {
        this.dateFormatPattern = JSON.DEFFAULT_DATE_FORMAT;
        this.contextArray = new ParseContext[8];
        this.contextArrayIndex = 0;
        this.resolveStatus = 0;
        this.extraTypeProviders = null;
        this.extraProcessors = null;
        this.lexer = jSONLexer;
        this.input = obj;
        this.config = parserConfig;
        this.symbolTable = parserConfig.getSymbolTable();
        jSONLexer.nextToken(12);
    }

    public String getInput() {
        Object obj = this.input;
        if (obj instanceof char[]) {
            return new String((char[]) this.input);
        }
        return obj.toString();
    }

    /* JADX WARN: Code duplicated, block: B:146:0x02dc  */
    /* JADX WARN: Code duplicated, block: B:157:0x0315 A[Catch: all -> 0x04d8, TryCatch #1 {all -> 0x04d8, blocks: (B:14:0x0044, B:17:0x0057, B:21:0x0073, B:74:0x019d, B:75:0x01a3, B:77:0x01b0, B:79:0x01b8, B:81:0x01c6, B:82:0x01d0, B:84:0x01db, B:85:0x01de, B:87:0x01e8, B:95:0x0201, B:96:0x0207, B:88:0x01ef, B:90:0x01f3, B:100:0x0210, B:101:0x0217, B:102:0x0218, B:104:0x0220, B:106:0x0224, B:107:0x0227, B:112:0x0239, B:114:0x0241, B:116:0x024b, B:118:0x025a, B:120:0x0260, B:122:0x026c, B:125:0x0271, B:127:0x0277, B:147:0x02dd, B:149:0x02e3, B:152:0x02ec, B:153:0x02f1, B:129:0x0282, B:131:0x028a, B:133:0x0294, B:134:0x0299, B:135:0x02a5, B:138:0x02ae, B:140:0x02b4, B:141:0x02b9, B:143:0x02bf, B:144:0x02c5, B:145:0x02d1, B:154:0x02f2, B:155:0x0312, B:157:0x0315, B:158:0x0319, B:162:0x0326, B:165:0x0330, B:167:0x033f, B:169:0x034a, B:170:0x0352, B:171:0x0355, B:182:0x037f, B:184:0x0388, B:186:0x0391, B:189:0x03a1, B:190:0x03c3, B:177:0x0363, B:179:0x036d, B:181:0x037c, B:180:0x0372, B:193:0x03c8, B:195:0x03dc, B:198:0x03e3, B:201:0x03ed, B:202:0x03f2, B:205:0x03f7, B:207:0x03fc, B:211:0x0407, B:213:0x0414, B:215:0x041a, B:218:0x0422, B:219:0x0425, B:221:0x0434, B:224:0x0441, B:225:0x0444, B:227:0x044a, B:230:0x0454, B:233:0x045d, B:234:0x0479, B:222:0x043c, B:235:0x047a, B:237:0x0489, B:238:0x048d, B:240:0x0496, B:243:0x049d, B:246:0x04a9, B:247:0x04cb, B:24:0x0085, B:25:0x00a7, B:27:0x00aa, B:32:0x00bb, B:34:0x00c3, B:37:0x00d3, B:38:0x00ed, B:39:0x00ee, B:40:0x00f3, B:49:0x0104, B:51:0x0111, B:53:0x011a, B:56:0x0123, B:57:0x0145, B:52:0x0116, B:63:0x014f, B:65:0x0157, B:68:0x0168, B:69:0x018c, B:70:0x018d, B:71:0x0192, B:72:0x0193, B:248:0x04cc, B:249:0x04d1, B:250:0x04d2, B:251:0x04d7), top: B:256:0x0044, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:160:0x0321 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:161:0x0323  */
    /* JADX WARN: Code duplicated, block: B:162:0x0326 A[Catch: all -> 0x04d8, TRY_LEAVE, TryCatch #1 {all -> 0x04d8, blocks: (B:14:0x0044, B:17:0x0057, B:21:0x0073, B:74:0x019d, B:75:0x01a3, B:77:0x01b0, B:79:0x01b8, B:81:0x01c6, B:82:0x01d0, B:84:0x01db, B:85:0x01de, B:87:0x01e8, B:95:0x0201, B:96:0x0207, B:88:0x01ef, B:90:0x01f3, B:100:0x0210, B:101:0x0217, B:102:0x0218, B:104:0x0220, B:106:0x0224, B:107:0x0227, B:112:0x0239, B:114:0x0241, B:116:0x024b, B:118:0x025a, B:120:0x0260, B:122:0x026c, B:125:0x0271, B:127:0x0277, B:147:0x02dd, B:149:0x02e3, B:152:0x02ec, B:153:0x02f1, B:129:0x0282, B:131:0x028a, B:133:0x0294, B:134:0x0299, B:135:0x02a5, B:138:0x02ae, B:140:0x02b4, B:141:0x02b9, B:143:0x02bf, B:144:0x02c5, B:145:0x02d1, B:154:0x02f2, B:155:0x0312, B:157:0x0315, B:158:0x0319, B:162:0x0326, B:165:0x0330, B:167:0x033f, B:169:0x034a, B:170:0x0352, B:171:0x0355, B:182:0x037f, B:184:0x0388, B:186:0x0391, B:189:0x03a1, B:190:0x03c3, B:177:0x0363, B:179:0x036d, B:181:0x037c, B:180:0x0372, B:193:0x03c8, B:195:0x03dc, B:198:0x03e3, B:201:0x03ed, B:202:0x03f2, B:205:0x03f7, B:207:0x03fc, B:211:0x0407, B:213:0x0414, B:215:0x041a, B:218:0x0422, B:219:0x0425, B:221:0x0434, B:224:0x0441, B:225:0x0444, B:227:0x044a, B:230:0x0454, B:233:0x045d, B:234:0x0479, B:222:0x043c, B:235:0x047a, B:237:0x0489, B:238:0x048d, B:240:0x0496, B:243:0x049d, B:246:0x04a9, B:247:0x04cb, B:24:0x0085, B:25:0x00a7, B:27:0x00aa, B:32:0x00bb, B:34:0x00c3, B:37:0x00d3, B:38:0x00ed, B:39:0x00ee, B:40:0x00f3, B:49:0x0104, B:51:0x0111, B:53:0x011a, B:56:0x0123, B:57:0x0145, B:52:0x0116, B:63:0x014f, B:65:0x0157, B:68:0x0168, B:69:0x018c, B:70:0x018d, B:71:0x0192, B:72:0x0193, B:248:0x04cc, B:249:0x04d1, B:250:0x04d2, B:251:0x04d7), top: B:256:0x0044, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:165:0x0330 A[Catch: all -> 0x04d8, TRY_ENTER, TryCatch #1 {all -> 0x04d8, blocks: (B:14:0x0044, B:17:0x0057, B:21:0x0073, B:74:0x019d, B:75:0x01a3, B:77:0x01b0, B:79:0x01b8, B:81:0x01c6, B:82:0x01d0, B:84:0x01db, B:85:0x01de, B:87:0x01e8, B:95:0x0201, B:96:0x0207, B:88:0x01ef, B:90:0x01f3, B:100:0x0210, B:101:0x0217, B:102:0x0218, B:104:0x0220, B:106:0x0224, B:107:0x0227, B:112:0x0239, B:114:0x0241, B:116:0x024b, B:118:0x025a, B:120:0x0260, B:122:0x026c, B:125:0x0271, B:127:0x0277, B:147:0x02dd, B:149:0x02e3, B:152:0x02ec, B:153:0x02f1, B:129:0x0282, B:131:0x028a, B:133:0x0294, B:134:0x0299, B:135:0x02a5, B:138:0x02ae, B:140:0x02b4, B:141:0x02b9, B:143:0x02bf, B:144:0x02c5, B:145:0x02d1, B:154:0x02f2, B:155:0x0312, B:157:0x0315, B:158:0x0319, B:162:0x0326, B:165:0x0330, B:167:0x033f, B:169:0x034a, B:170:0x0352, B:171:0x0355, B:182:0x037f, B:184:0x0388, B:186:0x0391, B:189:0x03a1, B:190:0x03c3, B:177:0x0363, B:179:0x036d, B:181:0x037c, B:180:0x0372, B:193:0x03c8, B:195:0x03dc, B:198:0x03e3, B:201:0x03ed, B:202:0x03f2, B:205:0x03f7, B:207:0x03fc, B:211:0x0407, B:213:0x0414, B:215:0x041a, B:218:0x0422, B:219:0x0425, B:221:0x0434, B:224:0x0441, B:225:0x0444, B:227:0x044a, B:230:0x0454, B:233:0x045d, B:234:0x0479, B:222:0x043c, B:235:0x047a, B:237:0x0489, B:238:0x048d, B:240:0x0496, B:243:0x049d, B:246:0x04a9, B:247:0x04cb, B:24:0x0085, B:25:0x00a7, B:27:0x00aa, B:32:0x00bb, B:34:0x00c3, B:37:0x00d3, B:38:0x00ed, B:39:0x00ee, B:40:0x00f3, B:49:0x0104, B:51:0x0111, B:53:0x011a, B:56:0x0123, B:57:0x0145, B:52:0x0116, B:63:0x014f, B:65:0x0157, B:68:0x0168, B:69:0x018c, B:70:0x018d, B:71:0x0192, B:72:0x0193, B:248:0x04cc, B:249:0x04d1, B:250:0x04d2, B:251:0x04d7), top: B:256:0x0044, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:167:0x033f A[Catch: all -> 0x04d8, TryCatch #1 {all -> 0x04d8, blocks: (B:14:0x0044, B:17:0x0057, B:21:0x0073, B:74:0x019d, B:75:0x01a3, B:77:0x01b0, B:79:0x01b8, B:81:0x01c6, B:82:0x01d0, B:84:0x01db, B:85:0x01de, B:87:0x01e8, B:95:0x0201, B:96:0x0207, B:88:0x01ef, B:90:0x01f3, B:100:0x0210, B:101:0x0217, B:102:0x0218, B:104:0x0220, B:106:0x0224, B:107:0x0227, B:112:0x0239, B:114:0x0241, B:116:0x024b, B:118:0x025a, B:120:0x0260, B:122:0x026c, B:125:0x0271, B:127:0x0277, B:147:0x02dd, B:149:0x02e3, B:152:0x02ec, B:153:0x02f1, B:129:0x0282, B:131:0x028a, B:133:0x0294, B:134:0x0299, B:135:0x02a5, B:138:0x02ae, B:140:0x02b4, B:141:0x02b9, B:143:0x02bf, B:144:0x02c5, B:145:0x02d1, B:154:0x02f2, B:155:0x0312, B:157:0x0315, B:158:0x0319, B:162:0x0326, B:165:0x0330, B:167:0x033f, B:169:0x034a, B:170:0x0352, B:171:0x0355, B:182:0x037f, B:184:0x0388, B:186:0x0391, B:189:0x03a1, B:190:0x03c3, B:177:0x0363, B:179:0x036d, B:181:0x037c, B:180:0x0372, B:193:0x03c8, B:195:0x03dc, B:198:0x03e3, B:201:0x03ed, B:202:0x03f2, B:205:0x03f7, B:207:0x03fc, B:211:0x0407, B:213:0x0414, B:215:0x041a, B:218:0x0422, B:219:0x0425, B:221:0x0434, B:224:0x0441, B:225:0x0444, B:227:0x044a, B:230:0x0454, B:233:0x045d, B:234:0x0479, B:222:0x043c, B:235:0x047a, B:237:0x0489, B:238:0x048d, B:240:0x0496, B:243:0x049d, B:246:0x04a9, B:247:0x04cb, B:24:0x0085, B:25:0x00a7, B:27:0x00aa, B:32:0x00bb, B:34:0x00c3, B:37:0x00d3, B:38:0x00ed, B:39:0x00ee, B:40:0x00f3, B:49:0x0104, B:51:0x0111, B:53:0x011a, B:56:0x0123, B:57:0x0145, B:52:0x0116, B:63:0x014f, B:65:0x0157, B:68:0x0168, B:69:0x018c, B:70:0x018d, B:71:0x0192, B:72:0x0193, B:248:0x04cc, B:249:0x04d1, B:250:0x04d2, B:251:0x04d7), top: B:256:0x0044, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:169:0x034a A[Catch: all -> 0x04d8, TryCatch #1 {all -> 0x04d8, blocks: (B:14:0x0044, B:17:0x0057, B:21:0x0073, B:74:0x019d, B:75:0x01a3, B:77:0x01b0, B:79:0x01b8, B:81:0x01c6, B:82:0x01d0, B:84:0x01db, B:85:0x01de, B:87:0x01e8, B:95:0x0201, B:96:0x0207, B:88:0x01ef, B:90:0x01f3, B:100:0x0210, B:101:0x0217, B:102:0x0218, B:104:0x0220, B:106:0x0224, B:107:0x0227, B:112:0x0239, B:114:0x0241, B:116:0x024b, B:118:0x025a, B:120:0x0260, B:122:0x026c, B:125:0x0271, B:127:0x0277, B:147:0x02dd, B:149:0x02e3, B:152:0x02ec, B:153:0x02f1, B:129:0x0282, B:131:0x028a, B:133:0x0294, B:134:0x0299, B:135:0x02a5, B:138:0x02ae, B:140:0x02b4, B:141:0x02b9, B:143:0x02bf, B:144:0x02c5, B:145:0x02d1, B:154:0x02f2, B:155:0x0312, B:157:0x0315, B:158:0x0319, B:162:0x0326, B:165:0x0330, B:167:0x033f, B:169:0x034a, B:170:0x0352, B:171:0x0355, B:182:0x037f, B:184:0x0388, B:186:0x0391, B:189:0x03a1, B:190:0x03c3, B:177:0x0363, B:179:0x036d, B:181:0x037c, B:180:0x0372, B:193:0x03c8, B:195:0x03dc, B:198:0x03e3, B:201:0x03ed, B:202:0x03f2, B:205:0x03f7, B:207:0x03fc, B:211:0x0407, B:213:0x0414, B:215:0x041a, B:218:0x0422, B:219:0x0425, B:221:0x0434, B:224:0x0441, B:225:0x0444, B:227:0x044a, B:230:0x0454, B:233:0x045d, B:234:0x0479, B:222:0x043c, B:235:0x047a, B:237:0x0489, B:238:0x048d, B:240:0x0496, B:243:0x049d, B:246:0x04a9, B:247:0x04cb, B:24:0x0085, B:25:0x00a7, B:27:0x00aa, B:32:0x00bb, B:34:0x00c3, B:37:0x00d3, B:38:0x00ed, B:39:0x00ee, B:40:0x00f3, B:49:0x0104, B:51:0x0111, B:53:0x011a, B:56:0x0123, B:57:0x0145, B:52:0x0116, B:63:0x014f, B:65:0x0157, B:68:0x0168, B:69:0x018c, B:70:0x018d, B:71:0x0192, B:72:0x0193, B:248:0x04cc, B:249:0x04d1, B:250:0x04d2, B:251:0x04d7), top: B:256:0x0044, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:172:0x0359  */
    /* JADX WARN: Code duplicated, block: B:184:0x0388 A[Catch: all -> 0x04d8, TryCatch #1 {all -> 0x04d8, blocks: (B:14:0x0044, B:17:0x0057, B:21:0x0073, B:74:0x019d, B:75:0x01a3, B:77:0x01b0, B:79:0x01b8, B:81:0x01c6, B:82:0x01d0, B:84:0x01db, B:85:0x01de, B:87:0x01e8, B:95:0x0201, B:96:0x0207, B:88:0x01ef, B:90:0x01f3, B:100:0x0210, B:101:0x0217, B:102:0x0218, B:104:0x0220, B:106:0x0224, B:107:0x0227, B:112:0x0239, B:114:0x0241, B:116:0x024b, B:118:0x025a, B:120:0x0260, B:122:0x026c, B:125:0x0271, B:127:0x0277, B:147:0x02dd, B:149:0x02e3, B:152:0x02ec, B:153:0x02f1, B:129:0x0282, B:131:0x028a, B:133:0x0294, B:134:0x0299, B:135:0x02a5, B:138:0x02ae, B:140:0x02b4, B:141:0x02b9, B:143:0x02bf, B:144:0x02c5, B:145:0x02d1, B:154:0x02f2, B:155:0x0312, B:157:0x0315, B:158:0x0319, B:162:0x0326, B:165:0x0330, B:167:0x033f, B:169:0x034a, B:170:0x0352, B:171:0x0355, B:182:0x037f, B:184:0x0388, B:186:0x0391, B:189:0x03a1, B:190:0x03c3, B:177:0x0363, B:179:0x036d, B:181:0x037c, B:180:0x0372, B:193:0x03c8, B:195:0x03dc, B:198:0x03e3, B:201:0x03ed, B:202:0x03f2, B:205:0x03f7, B:207:0x03fc, B:211:0x0407, B:213:0x0414, B:215:0x041a, B:218:0x0422, B:219:0x0425, B:221:0x0434, B:224:0x0441, B:225:0x0444, B:227:0x044a, B:230:0x0454, B:233:0x045d, B:234:0x0479, B:222:0x043c, B:235:0x047a, B:237:0x0489, B:238:0x048d, B:240:0x0496, B:243:0x049d, B:246:0x04a9, B:247:0x04cb, B:24:0x0085, B:25:0x00a7, B:27:0x00aa, B:32:0x00bb, B:34:0x00c3, B:37:0x00d3, B:38:0x00ed, B:39:0x00ee, B:40:0x00f3, B:49:0x0104, B:51:0x0111, B:53:0x011a, B:56:0x0123, B:57:0x0145, B:52:0x0116, B:63:0x014f, B:65:0x0157, B:68:0x0168, B:69:0x018c, B:70:0x018d, B:71:0x0192, B:72:0x0193, B:248:0x04cc, B:249:0x04d1, B:250:0x04d2, B:251:0x04d7), top: B:256:0x0044, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:186:0x0391 A[Catch: all -> 0x04d8, TRY_LEAVE, TryCatch #1 {all -> 0x04d8, blocks: (B:14:0x0044, B:17:0x0057, B:21:0x0073, B:74:0x019d, B:75:0x01a3, B:77:0x01b0, B:79:0x01b8, B:81:0x01c6, B:82:0x01d0, B:84:0x01db, B:85:0x01de, B:87:0x01e8, B:95:0x0201, B:96:0x0207, B:88:0x01ef, B:90:0x01f3, B:100:0x0210, B:101:0x0217, B:102:0x0218, B:104:0x0220, B:106:0x0224, B:107:0x0227, B:112:0x0239, B:114:0x0241, B:116:0x024b, B:118:0x025a, B:120:0x0260, B:122:0x026c, B:125:0x0271, B:127:0x0277, B:147:0x02dd, B:149:0x02e3, B:152:0x02ec, B:153:0x02f1, B:129:0x0282, B:131:0x028a, B:133:0x0294, B:134:0x0299, B:135:0x02a5, B:138:0x02ae, B:140:0x02b4, B:141:0x02b9, B:143:0x02bf, B:144:0x02c5, B:145:0x02d1, B:154:0x02f2, B:155:0x0312, B:157:0x0315, B:158:0x0319, B:162:0x0326, B:165:0x0330, B:167:0x033f, B:169:0x034a, B:170:0x0352, B:171:0x0355, B:182:0x037f, B:184:0x0388, B:186:0x0391, B:189:0x03a1, B:190:0x03c3, B:177:0x0363, B:179:0x036d, B:181:0x037c, B:180:0x0372, B:193:0x03c8, B:195:0x03dc, B:198:0x03e3, B:201:0x03ed, B:202:0x03f2, B:205:0x03f7, B:207:0x03fc, B:211:0x0407, B:213:0x0414, B:215:0x041a, B:218:0x0422, B:219:0x0425, B:221:0x0434, B:224:0x0441, B:225:0x0444, B:227:0x044a, B:230:0x0454, B:233:0x045d, B:234:0x0479, B:222:0x043c, B:235:0x047a, B:237:0x0489, B:238:0x048d, B:240:0x0496, B:243:0x049d, B:246:0x04a9, B:247:0x04cb, B:24:0x0085, B:25:0x00a7, B:27:0x00aa, B:32:0x00bb, B:34:0x00c3, B:37:0x00d3, B:38:0x00ed, B:39:0x00ee, B:40:0x00f3, B:49:0x0104, B:51:0x0111, B:53:0x011a, B:56:0x0123, B:57:0x0145, B:52:0x0116, B:63:0x014f, B:65:0x0157, B:68:0x0168, B:69:0x018c, B:70:0x018d, B:71:0x0192, B:72:0x0193, B:248:0x04cc, B:249:0x04d1, B:250:0x04d2, B:251:0x04d7), top: B:256:0x0044, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:189:0x03a1 A[Catch: all -> 0x04d8, TRY_ENTER, TryCatch #1 {all -> 0x04d8, blocks: (B:14:0x0044, B:17:0x0057, B:21:0x0073, B:74:0x019d, B:75:0x01a3, B:77:0x01b0, B:79:0x01b8, B:81:0x01c6, B:82:0x01d0, B:84:0x01db, B:85:0x01de, B:87:0x01e8, B:95:0x0201, B:96:0x0207, B:88:0x01ef, B:90:0x01f3, B:100:0x0210, B:101:0x0217, B:102:0x0218, B:104:0x0220, B:106:0x0224, B:107:0x0227, B:112:0x0239, B:114:0x0241, B:116:0x024b, B:118:0x025a, B:120:0x0260, B:122:0x026c, B:125:0x0271, B:127:0x0277, B:147:0x02dd, B:149:0x02e3, B:152:0x02ec, B:153:0x02f1, B:129:0x0282, B:131:0x028a, B:133:0x0294, B:134:0x0299, B:135:0x02a5, B:138:0x02ae, B:140:0x02b4, B:141:0x02b9, B:143:0x02bf, B:144:0x02c5, B:145:0x02d1, B:154:0x02f2, B:155:0x0312, B:157:0x0315, B:158:0x0319, B:162:0x0326, B:165:0x0330, B:167:0x033f, B:169:0x034a, B:170:0x0352, B:171:0x0355, B:182:0x037f, B:184:0x0388, B:186:0x0391, B:189:0x03a1, B:190:0x03c3, B:177:0x0363, B:179:0x036d, B:181:0x037c, B:180:0x0372, B:193:0x03c8, B:195:0x03dc, B:198:0x03e3, B:201:0x03ed, B:202:0x03f2, B:205:0x03f7, B:207:0x03fc, B:211:0x0407, B:213:0x0414, B:215:0x041a, B:218:0x0422, B:219:0x0425, B:221:0x0434, B:224:0x0441, B:225:0x0444, B:227:0x044a, B:230:0x0454, B:233:0x045d, B:234:0x0479, B:222:0x043c, B:235:0x047a, B:237:0x0489, B:238:0x048d, B:240:0x0496, B:243:0x049d, B:246:0x04a9, B:247:0x04cb, B:24:0x0085, B:25:0x00a7, B:27:0x00aa, B:32:0x00bb, B:34:0x00c3, B:37:0x00d3, B:38:0x00ed, B:39:0x00ee, B:40:0x00f3, B:49:0x0104, B:51:0x0111, B:53:0x011a, B:56:0x0123, B:57:0x0145, B:52:0x0116, B:63:0x014f, B:65:0x0157, B:68:0x0168, B:69:0x018c, B:70:0x018d, B:71:0x0192, B:72:0x0193, B:248:0x04cc, B:249:0x04d1, B:250:0x04d2, B:251:0x04d7), top: B:256:0x0044, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:193:0x03c8 A[Catch: all -> 0x04d8, TryCatch #1 {all -> 0x04d8, blocks: (B:14:0x0044, B:17:0x0057, B:21:0x0073, B:74:0x019d, B:75:0x01a3, B:77:0x01b0, B:79:0x01b8, B:81:0x01c6, B:82:0x01d0, B:84:0x01db, B:85:0x01de, B:87:0x01e8, B:95:0x0201, B:96:0x0207, B:88:0x01ef, B:90:0x01f3, B:100:0x0210, B:101:0x0217, B:102:0x0218, B:104:0x0220, B:106:0x0224, B:107:0x0227, B:112:0x0239, B:114:0x0241, B:116:0x024b, B:118:0x025a, B:120:0x0260, B:122:0x026c, B:125:0x0271, B:127:0x0277, B:147:0x02dd, B:149:0x02e3, B:152:0x02ec, B:153:0x02f1, B:129:0x0282, B:131:0x028a, B:133:0x0294, B:134:0x0299, B:135:0x02a5, B:138:0x02ae, B:140:0x02b4, B:141:0x02b9, B:143:0x02bf, B:144:0x02c5, B:145:0x02d1, B:154:0x02f2, B:155:0x0312, B:157:0x0315, B:158:0x0319, B:162:0x0326, B:165:0x0330, B:167:0x033f, B:169:0x034a, B:170:0x0352, B:171:0x0355, B:182:0x037f, B:184:0x0388, B:186:0x0391, B:189:0x03a1, B:190:0x03c3, B:177:0x0363, B:179:0x036d, B:181:0x037c, B:180:0x0372, B:193:0x03c8, B:195:0x03dc, B:198:0x03e3, B:201:0x03ed, B:202:0x03f2, B:205:0x03f7, B:207:0x03fc, B:211:0x0407, B:213:0x0414, B:215:0x041a, B:218:0x0422, B:219:0x0425, B:221:0x0434, B:224:0x0441, B:225:0x0444, B:227:0x044a, B:230:0x0454, B:233:0x045d, B:234:0x0479, B:222:0x043c, B:235:0x047a, B:237:0x0489, B:238:0x048d, B:240:0x0496, B:243:0x049d, B:246:0x04a9, B:247:0x04cb, B:24:0x0085, B:25:0x00a7, B:27:0x00aa, B:32:0x00bb, B:34:0x00c3, B:37:0x00d3, B:38:0x00ed, B:39:0x00ee, B:40:0x00f3, B:49:0x0104, B:51:0x0111, B:53:0x011a, B:56:0x0123, B:57:0x0145, B:52:0x0116, B:63:0x014f, B:65:0x0157, B:68:0x0168, B:69:0x018c, B:70:0x018d, B:71:0x0192, B:72:0x0193, B:248:0x04cc, B:249:0x04d1, B:250:0x04d2, B:251:0x04d7), top: B:256:0x0044, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:198:0x03e3 A[Catch: all -> 0x04d8, TRY_ENTER, TryCatch #1 {all -> 0x04d8, blocks: (B:14:0x0044, B:17:0x0057, B:21:0x0073, B:74:0x019d, B:75:0x01a3, B:77:0x01b0, B:79:0x01b8, B:81:0x01c6, B:82:0x01d0, B:84:0x01db, B:85:0x01de, B:87:0x01e8, B:95:0x0201, B:96:0x0207, B:88:0x01ef, B:90:0x01f3, B:100:0x0210, B:101:0x0217, B:102:0x0218, B:104:0x0220, B:106:0x0224, B:107:0x0227, B:112:0x0239, B:114:0x0241, B:116:0x024b, B:118:0x025a, B:120:0x0260, B:122:0x026c, B:125:0x0271, B:127:0x0277, B:147:0x02dd, B:149:0x02e3, B:152:0x02ec, B:153:0x02f1, B:129:0x0282, B:131:0x028a, B:133:0x0294, B:134:0x0299, B:135:0x02a5, B:138:0x02ae, B:140:0x02b4, B:141:0x02b9, B:143:0x02bf, B:144:0x02c5, B:145:0x02d1, B:154:0x02f2, B:155:0x0312, B:157:0x0315, B:158:0x0319, B:162:0x0326, B:165:0x0330, B:167:0x033f, B:169:0x034a, B:170:0x0352, B:171:0x0355, B:182:0x037f, B:184:0x0388, B:186:0x0391, B:189:0x03a1, B:190:0x03c3, B:177:0x0363, B:179:0x036d, B:181:0x037c, B:180:0x0372, B:193:0x03c8, B:195:0x03dc, B:198:0x03e3, B:201:0x03ed, B:202:0x03f2, B:205:0x03f7, B:207:0x03fc, B:211:0x0407, B:213:0x0414, B:215:0x041a, B:218:0x0422, B:219:0x0425, B:221:0x0434, B:224:0x0441, B:225:0x0444, B:227:0x044a, B:230:0x0454, B:233:0x045d, B:234:0x0479, B:222:0x043c, B:235:0x047a, B:237:0x0489, B:238:0x048d, B:240:0x0496, B:243:0x049d, B:246:0x04a9, B:247:0x04cb, B:24:0x0085, B:25:0x00a7, B:27:0x00aa, B:32:0x00bb, B:34:0x00c3, B:37:0x00d3, B:38:0x00ed, B:39:0x00ee, B:40:0x00f3, B:49:0x0104, B:51:0x0111, B:53:0x011a, B:56:0x0123, B:57:0x0145, B:52:0x0116, B:63:0x014f, B:65:0x0157, B:68:0x0168, B:69:0x018c, B:70:0x018d, B:71:0x0192, B:72:0x0193, B:248:0x04cc, B:249:0x04d1, B:250:0x04d2, B:251:0x04d7), top: B:256:0x0044, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:200:0x03eb  */
    /* JADX WARN: Code duplicated, block: B:203:0x03f3  */
    /* JADX WARN: Code duplicated, block: B:205:0x03f7 A[Catch: all -> 0x04d8, TryCatch #1 {all -> 0x04d8, blocks: (B:14:0x0044, B:17:0x0057, B:21:0x0073, B:74:0x019d, B:75:0x01a3, B:77:0x01b0, B:79:0x01b8, B:81:0x01c6, B:82:0x01d0, B:84:0x01db, B:85:0x01de, B:87:0x01e8, B:95:0x0201, B:96:0x0207, B:88:0x01ef, B:90:0x01f3, B:100:0x0210, B:101:0x0217, B:102:0x0218, B:104:0x0220, B:106:0x0224, B:107:0x0227, B:112:0x0239, B:114:0x0241, B:116:0x024b, B:118:0x025a, B:120:0x0260, B:122:0x026c, B:125:0x0271, B:127:0x0277, B:147:0x02dd, B:149:0x02e3, B:152:0x02ec, B:153:0x02f1, B:129:0x0282, B:131:0x028a, B:133:0x0294, B:134:0x0299, B:135:0x02a5, B:138:0x02ae, B:140:0x02b4, B:141:0x02b9, B:143:0x02bf, B:144:0x02c5, B:145:0x02d1, B:154:0x02f2, B:155:0x0312, B:157:0x0315, B:158:0x0319, B:162:0x0326, B:165:0x0330, B:167:0x033f, B:169:0x034a, B:170:0x0352, B:171:0x0355, B:182:0x037f, B:184:0x0388, B:186:0x0391, B:189:0x03a1, B:190:0x03c3, B:177:0x0363, B:179:0x036d, B:181:0x037c, B:180:0x0372, B:193:0x03c8, B:195:0x03dc, B:198:0x03e3, B:201:0x03ed, B:202:0x03f2, B:205:0x03f7, B:207:0x03fc, B:211:0x0407, B:213:0x0414, B:215:0x041a, B:218:0x0422, B:219:0x0425, B:221:0x0434, B:224:0x0441, B:225:0x0444, B:227:0x044a, B:230:0x0454, B:233:0x045d, B:234:0x0479, B:222:0x043c, B:235:0x047a, B:237:0x0489, B:238:0x048d, B:240:0x0496, B:243:0x049d, B:246:0x04a9, B:247:0x04cb, B:24:0x0085, B:25:0x00a7, B:27:0x00aa, B:32:0x00bb, B:34:0x00c3, B:37:0x00d3, B:38:0x00ed, B:39:0x00ee, B:40:0x00f3, B:49:0x0104, B:51:0x0111, B:53:0x011a, B:56:0x0123, B:57:0x0145, B:52:0x0116, B:63:0x014f, B:65:0x0157, B:68:0x0168, B:69:0x018c, B:70:0x018d, B:71:0x0192, B:72:0x0193, B:248:0x04cc, B:249:0x04d1, B:250:0x04d2, B:251:0x04d7), top: B:256:0x0044, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:207:0x03fc A[Catch: all -> 0x04d8, TryCatch #1 {all -> 0x04d8, blocks: (B:14:0x0044, B:17:0x0057, B:21:0x0073, B:74:0x019d, B:75:0x01a3, B:77:0x01b0, B:79:0x01b8, B:81:0x01c6, B:82:0x01d0, B:84:0x01db, B:85:0x01de, B:87:0x01e8, B:95:0x0201, B:96:0x0207, B:88:0x01ef, B:90:0x01f3, B:100:0x0210, B:101:0x0217, B:102:0x0218, B:104:0x0220, B:106:0x0224, B:107:0x0227, B:112:0x0239, B:114:0x0241, B:116:0x024b, B:118:0x025a, B:120:0x0260, B:122:0x026c, B:125:0x0271, B:127:0x0277, B:147:0x02dd, B:149:0x02e3, B:152:0x02ec, B:153:0x02f1, B:129:0x0282, B:131:0x028a, B:133:0x0294, B:134:0x0299, B:135:0x02a5, B:138:0x02ae, B:140:0x02b4, B:141:0x02b9, B:143:0x02bf, B:144:0x02c5, B:145:0x02d1, B:154:0x02f2, B:155:0x0312, B:157:0x0315, B:158:0x0319, B:162:0x0326, B:165:0x0330, B:167:0x033f, B:169:0x034a, B:170:0x0352, B:171:0x0355, B:182:0x037f, B:184:0x0388, B:186:0x0391, B:189:0x03a1, B:190:0x03c3, B:177:0x0363, B:179:0x036d, B:181:0x037c, B:180:0x0372, B:193:0x03c8, B:195:0x03dc, B:198:0x03e3, B:201:0x03ed, B:202:0x03f2, B:205:0x03f7, B:207:0x03fc, B:211:0x0407, B:213:0x0414, B:215:0x041a, B:218:0x0422, B:219:0x0425, B:221:0x0434, B:224:0x0441, B:225:0x0444, B:227:0x044a, B:230:0x0454, B:233:0x045d, B:234:0x0479, B:222:0x043c, B:235:0x047a, B:237:0x0489, B:238:0x048d, B:240:0x0496, B:243:0x049d, B:246:0x04a9, B:247:0x04cb, B:24:0x0085, B:25:0x00a7, B:27:0x00aa, B:32:0x00bb, B:34:0x00c3, B:37:0x00d3, B:38:0x00ed, B:39:0x00ee, B:40:0x00f3, B:49:0x0104, B:51:0x0111, B:53:0x011a, B:56:0x0123, B:57:0x0145, B:52:0x0116, B:63:0x014f, B:65:0x0157, B:68:0x0168, B:69:0x018c, B:70:0x018d, B:71:0x0192, B:72:0x0193, B:248:0x04cc, B:249:0x04d1, B:250:0x04d2, B:251:0x04d7), top: B:256:0x0044, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:210:0x0406  */
    /* JADX WARN: Code duplicated, block: B:213:0x0414 A[Catch: all -> 0x04d8, TryCatch #1 {all -> 0x04d8, blocks: (B:14:0x0044, B:17:0x0057, B:21:0x0073, B:74:0x019d, B:75:0x01a3, B:77:0x01b0, B:79:0x01b8, B:81:0x01c6, B:82:0x01d0, B:84:0x01db, B:85:0x01de, B:87:0x01e8, B:95:0x0201, B:96:0x0207, B:88:0x01ef, B:90:0x01f3, B:100:0x0210, B:101:0x0217, B:102:0x0218, B:104:0x0220, B:106:0x0224, B:107:0x0227, B:112:0x0239, B:114:0x0241, B:116:0x024b, B:118:0x025a, B:120:0x0260, B:122:0x026c, B:125:0x0271, B:127:0x0277, B:147:0x02dd, B:149:0x02e3, B:152:0x02ec, B:153:0x02f1, B:129:0x0282, B:131:0x028a, B:133:0x0294, B:134:0x0299, B:135:0x02a5, B:138:0x02ae, B:140:0x02b4, B:141:0x02b9, B:143:0x02bf, B:144:0x02c5, B:145:0x02d1, B:154:0x02f2, B:155:0x0312, B:157:0x0315, B:158:0x0319, B:162:0x0326, B:165:0x0330, B:167:0x033f, B:169:0x034a, B:170:0x0352, B:171:0x0355, B:182:0x037f, B:184:0x0388, B:186:0x0391, B:189:0x03a1, B:190:0x03c3, B:177:0x0363, B:179:0x036d, B:181:0x037c, B:180:0x0372, B:193:0x03c8, B:195:0x03dc, B:198:0x03e3, B:201:0x03ed, B:202:0x03f2, B:205:0x03f7, B:207:0x03fc, B:211:0x0407, B:213:0x0414, B:215:0x041a, B:218:0x0422, B:219:0x0425, B:221:0x0434, B:224:0x0441, B:225:0x0444, B:227:0x044a, B:230:0x0454, B:233:0x045d, B:234:0x0479, B:222:0x043c, B:235:0x047a, B:237:0x0489, B:238:0x048d, B:240:0x0496, B:243:0x049d, B:246:0x04a9, B:247:0x04cb, B:24:0x0085, B:25:0x00a7, B:27:0x00aa, B:32:0x00bb, B:34:0x00c3, B:37:0x00d3, B:38:0x00ed, B:39:0x00ee, B:40:0x00f3, B:49:0x0104, B:51:0x0111, B:53:0x011a, B:56:0x0123, B:57:0x0145, B:52:0x0116, B:63:0x014f, B:65:0x0157, B:68:0x0168, B:69:0x018c, B:70:0x018d, B:71:0x0192, B:72:0x0193, B:248:0x04cc, B:249:0x04d1, B:250:0x04d2, B:251:0x04d7), top: B:256:0x0044, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:214:0x0419  */
    /* JADX WARN: Code duplicated, block: B:217:0x0420 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:221:0x0434 A[Catch: all -> 0x04d8, TryCatch #1 {all -> 0x04d8, blocks: (B:14:0x0044, B:17:0x0057, B:21:0x0073, B:74:0x019d, B:75:0x01a3, B:77:0x01b0, B:79:0x01b8, B:81:0x01c6, B:82:0x01d0, B:84:0x01db, B:85:0x01de, B:87:0x01e8, B:95:0x0201, B:96:0x0207, B:88:0x01ef, B:90:0x01f3, B:100:0x0210, B:101:0x0217, B:102:0x0218, B:104:0x0220, B:106:0x0224, B:107:0x0227, B:112:0x0239, B:114:0x0241, B:116:0x024b, B:118:0x025a, B:120:0x0260, B:122:0x026c, B:125:0x0271, B:127:0x0277, B:147:0x02dd, B:149:0x02e3, B:152:0x02ec, B:153:0x02f1, B:129:0x0282, B:131:0x028a, B:133:0x0294, B:134:0x0299, B:135:0x02a5, B:138:0x02ae, B:140:0x02b4, B:141:0x02b9, B:143:0x02bf, B:144:0x02c5, B:145:0x02d1, B:154:0x02f2, B:155:0x0312, B:157:0x0315, B:158:0x0319, B:162:0x0326, B:165:0x0330, B:167:0x033f, B:169:0x034a, B:170:0x0352, B:171:0x0355, B:182:0x037f, B:184:0x0388, B:186:0x0391, B:189:0x03a1, B:190:0x03c3, B:177:0x0363, B:179:0x036d, B:181:0x037c, B:180:0x0372, B:193:0x03c8, B:195:0x03dc, B:198:0x03e3, B:201:0x03ed, B:202:0x03f2, B:205:0x03f7, B:207:0x03fc, B:211:0x0407, B:213:0x0414, B:215:0x041a, B:218:0x0422, B:219:0x0425, B:221:0x0434, B:224:0x0441, B:225:0x0444, B:227:0x044a, B:230:0x0454, B:233:0x045d, B:234:0x0479, B:222:0x043c, B:235:0x047a, B:237:0x0489, B:238:0x048d, B:240:0x0496, B:243:0x049d, B:246:0x04a9, B:247:0x04cb, B:24:0x0085, B:25:0x00a7, B:27:0x00aa, B:32:0x00bb, B:34:0x00c3, B:37:0x00d3, B:38:0x00ed, B:39:0x00ee, B:40:0x00f3, B:49:0x0104, B:51:0x0111, B:53:0x011a, B:56:0x0123, B:57:0x0145, B:52:0x0116, B:63:0x014f, B:65:0x0157, B:68:0x0168, B:69:0x018c, B:70:0x018d, B:71:0x0192, B:72:0x0193, B:248:0x04cc, B:249:0x04d1, B:250:0x04d2, B:251:0x04d7), top: B:256:0x0044, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:222:0x043c A[Catch: all -> 0x04d8, TryCatch #1 {all -> 0x04d8, blocks: (B:14:0x0044, B:17:0x0057, B:21:0x0073, B:74:0x019d, B:75:0x01a3, B:77:0x01b0, B:79:0x01b8, B:81:0x01c6, B:82:0x01d0, B:84:0x01db, B:85:0x01de, B:87:0x01e8, B:95:0x0201, B:96:0x0207, B:88:0x01ef, B:90:0x01f3, B:100:0x0210, B:101:0x0217, B:102:0x0218, B:104:0x0220, B:106:0x0224, B:107:0x0227, B:112:0x0239, B:114:0x0241, B:116:0x024b, B:118:0x025a, B:120:0x0260, B:122:0x026c, B:125:0x0271, B:127:0x0277, B:147:0x02dd, B:149:0x02e3, B:152:0x02ec, B:153:0x02f1, B:129:0x0282, B:131:0x028a, B:133:0x0294, B:134:0x0299, B:135:0x02a5, B:138:0x02ae, B:140:0x02b4, B:141:0x02b9, B:143:0x02bf, B:144:0x02c5, B:145:0x02d1, B:154:0x02f2, B:155:0x0312, B:157:0x0315, B:158:0x0319, B:162:0x0326, B:165:0x0330, B:167:0x033f, B:169:0x034a, B:170:0x0352, B:171:0x0355, B:182:0x037f, B:184:0x0388, B:186:0x0391, B:189:0x03a1, B:190:0x03c3, B:177:0x0363, B:179:0x036d, B:181:0x037c, B:180:0x0372, B:193:0x03c8, B:195:0x03dc, B:198:0x03e3, B:201:0x03ed, B:202:0x03f2, B:205:0x03f7, B:207:0x03fc, B:211:0x0407, B:213:0x0414, B:215:0x041a, B:218:0x0422, B:219:0x0425, B:221:0x0434, B:224:0x0441, B:225:0x0444, B:227:0x044a, B:230:0x0454, B:233:0x045d, B:234:0x0479, B:222:0x043c, B:235:0x047a, B:237:0x0489, B:238:0x048d, B:240:0x0496, B:243:0x049d, B:246:0x04a9, B:247:0x04cb, B:24:0x0085, B:25:0x00a7, B:27:0x00aa, B:32:0x00bb, B:34:0x00c3, B:37:0x00d3, B:38:0x00ed, B:39:0x00ee, B:40:0x00f3, B:49:0x0104, B:51:0x0111, B:53:0x011a, B:56:0x0123, B:57:0x0145, B:52:0x0116, B:63:0x014f, B:65:0x0157, B:68:0x0168, B:69:0x018c, B:70:0x018d, B:71:0x0192, B:72:0x0193, B:248:0x04cc, B:249:0x04d1, B:250:0x04d2, B:251:0x04d7), top: B:256:0x0044, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:224:0x0441 A[Catch: all -> 0x04d8, TryCatch #1 {all -> 0x04d8, blocks: (B:14:0x0044, B:17:0x0057, B:21:0x0073, B:74:0x019d, B:75:0x01a3, B:77:0x01b0, B:79:0x01b8, B:81:0x01c6, B:82:0x01d0, B:84:0x01db, B:85:0x01de, B:87:0x01e8, B:95:0x0201, B:96:0x0207, B:88:0x01ef, B:90:0x01f3, B:100:0x0210, B:101:0x0217, B:102:0x0218, B:104:0x0220, B:106:0x0224, B:107:0x0227, B:112:0x0239, B:114:0x0241, B:116:0x024b, B:118:0x025a, B:120:0x0260, B:122:0x026c, B:125:0x0271, B:127:0x0277, B:147:0x02dd, B:149:0x02e3, B:152:0x02ec, B:153:0x02f1, B:129:0x0282, B:131:0x028a, B:133:0x0294, B:134:0x0299, B:135:0x02a5, B:138:0x02ae, B:140:0x02b4, B:141:0x02b9, B:143:0x02bf, B:144:0x02c5, B:145:0x02d1, B:154:0x02f2, B:155:0x0312, B:157:0x0315, B:158:0x0319, B:162:0x0326, B:165:0x0330, B:167:0x033f, B:169:0x034a, B:170:0x0352, B:171:0x0355, B:182:0x037f, B:184:0x0388, B:186:0x0391, B:189:0x03a1, B:190:0x03c3, B:177:0x0363, B:179:0x036d, B:181:0x037c, B:180:0x0372, B:193:0x03c8, B:195:0x03dc, B:198:0x03e3, B:201:0x03ed, B:202:0x03f2, B:205:0x03f7, B:207:0x03fc, B:211:0x0407, B:213:0x0414, B:215:0x041a, B:218:0x0422, B:219:0x0425, B:221:0x0434, B:224:0x0441, B:225:0x0444, B:227:0x044a, B:230:0x0454, B:233:0x045d, B:234:0x0479, B:222:0x043c, B:235:0x047a, B:237:0x0489, B:238:0x048d, B:240:0x0496, B:243:0x049d, B:246:0x04a9, B:247:0x04cb, B:24:0x0085, B:25:0x00a7, B:27:0x00aa, B:32:0x00bb, B:34:0x00c3, B:37:0x00d3, B:38:0x00ed, B:39:0x00ee, B:40:0x00f3, B:49:0x0104, B:51:0x0111, B:53:0x011a, B:56:0x0123, B:57:0x0145, B:52:0x0116, B:63:0x014f, B:65:0x0157, B:68:0x0168, B:69:0x018c, B:70:0x018d, B:71:0x0192, B:72:0x0193, B:248:0x04cc, B:249:0x04d1, B:250:0x04d2, B:251:0x04d7), top: B:256:0x0044, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:230:0x0454 A[Catch: all -> 0x04d8, TRY_ENTER, TryCatch #1 {all -> 0x04d8, blocks: (B:14:0x0044, B:17:0x0057, B:21:0x0073, B:74:0x019d, B:75:0x01a3, B:77:0x01b0, B:79:0x01b8, B:81:0x01c6, B:82:0x01d0, B:84:0x01db, B:85:0x01de, B:87:0x01e8, B:95:0x0201, B:96:0x0207, B:88:0x01ef, B:90:0x01f3, B:100:0x0210, B:101:0x0217, B:102:0x0218, B:104:0x0220, B:106:0x0224, B:107:0x0227, B:112:0x0239, B:114:0x0241, B:116:0x024b, B:118:0x025a, B:120:0x0260, B:122:0x026c, B:125:0x0271, B:127:0x0277, B:147:0x02dd, B:149:0x02e3, B:152:0x02ec, B:153:0x02f1, B:129:0x0282, B:131:0x028a, B:133:0x0294, B:134:0x0299, B:135:0x02a5, B:138:0x02ae, B:140:0x02b4, B:141:0x02b9, B:143:0x02bf, B:144:0x02c5, B:145:0x02d1, B:154:0x02f2, B:155:0x0312, B:157:0x0315, B:158:0x0319, B:162:0x0326, B:165:0x0330, B:167:0x033f, B:169:0x034a, B:170:0x0352, B:171:0x0355, B:182:0x037f, B:184:0x0388, B:186:0x0391, B:189:0x03a1, B:190:0x03c3, B:177:0x0363, B:179:0x036d, B:181:0x037c, B:180:0x0372, B:193:0x03c8, B:195:0x03dc, B:198:0x03e3, B:201:0x03ed, B:202:0x03f2, B:205:0x03f7, B:207:0x03fc, B:211:0x0407, B:213:0x0414, B:215:0x041a, B:218:0x0422, B:219:0x0425, B:221:0x0434, B:224:0x0441, B:225:0x0444, B:227:0x044a, B:230:0x0454, B:233:0x045d, B:234:0x0479, B:222:0x043c, B:235:0x047a, B:237:0x0489, B:238:0x048d, B:240:0x0496, B:243:0x049d, B:246:0x04a9, B:247:0x04cb, B:24:0x0085, B:25:0x00a7, B:27:0x00aa, B:32:0x00bb, B:34:0x00c3, B:37:0x00d3, B:38:0x00ed, B:39:0x00ee, B:40:0x00f3, B:49:0x0104, B:51:0x0111, B:53:0x011a, B:56:0x0123, B:57:0x0145, B:52:0x0116, B:63:0x014f, B:65:0x0157, B:68:0x0168, B:69:0x018c, B:70:0x018d, B:71:0x0192, B:72:0x0193, B:248:0x04cc, B:249:0x04d1, B:250:0x04d2, B:251:0x04d7), top: B:256:0x0044, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:232:0x045c  */
    /* JADX WARN: Code duplicated, block: B:235:0x047a A[Catch: all -> 0x04d8, TryCatch #1 {all -> 0x04d8, blocks: (B:14:0x0044, B:17:0x0057, B:21:0x0073, B:74:0x019d, B:75:0x01a3, B:77:0x01b0, B:79:0x01b8, B:81:0x01c6, B:82:0x01d0, B:84:0x01db, B:85:0x01de, B:87:0x01e8, B:95:0x0201, B:96:0x0207, B:88:0x01ef, B:90:0x01f3, B:100:0x0210, B:101:0x0217, B:102:0x0218, B:104:0x0220, B:106:0x0224, B:107:0x0227, B:112:0x0239, B:114:0x0241, B:116:0x024b, B:118:0x025a, B:120:0x0260, B:122:0x026c, B:125:0x0271, B:127:0x0277, B:147:0x02dd, B:149:0x02e3, B:152:0x02ec, B:153:0x02f1, B:129:0x0282, B:131:0x028a, B:133:0x0294, B:134:0x0299, B:135:0x02a5, B:138:0x02ae, B:140:0x02b4, B:141:0x02b9, B:143:0x02bf, B:144:0x02c5, B:145:0x02d1, B:154:0x02f2, B:155:0x0312, B:157:0x0315, B:158:0x0319, B:162:0x0326, B:165:0x0330, B:167:0x033f, B:169:0x034a, B:170:0x0352, B:171:0x0355, B:182:0x037f, B:184:0x0388, B:186:0x0391, B:189:0x03a1, B:190:0x03c3, B:177:0x0363, B:179:0x036d, B:181:0x037c, B:180:0x0372, B:193:0x03c8, B:195:0x03dc, B:198:0x03e3, B:201:0x03ed, B:202:0x03f2, B:205:0x03f7, B:207:0x03fc, B:211:0x0407, B:213:0x0414, B:215:0x041a, B:218:0x0422, B:219:0x0425, B:221:0x0434, B:224:0x0441, B:225:0x0444, B:227:0x044a, B:230:0x0454, B:233:0x045d, B:234:0x0479, B:222:0x043c, B:235:0x047a, B:237:0x0489, B:238:0x048d, B:240:0x0496, B:243:0x049d, B:246:0x04a9, B:247:0x04cb, B:24:0x0085, B:25:0x00a7, B:27:0x00aa, B:32:0x00bb, B:34:0x00c3, B:37:0x00d3, B:38:0x00ed, B:39:0x00ee, B:40:0x00f3, B:49:0x0104, B:51:0x0111, B:53:0x011a, B:56:0x0123, B:57:0x0145, B:52:0x0116, B:63:0x014f, B:65:0x0157, B:68:0x0168, B:69:0x018c, B:70:0x018d, B:71:0x0192, B:72:0x0193, B:248:0x04cc, B:249:0x04d1, B:250:0x04d2, B:251:0x04d7), top: B:256:0x0044, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:237:0x0489 A[Catch: all -> 0x04d8, TryCatch #1 {all -> 0x04d8, blocks: (B:14:0x0044, B:17:0x0057, B:21:0x0073, B:74:0x019d, B:75:0x01a3, B:77:0x01b0, B:79:0x01b8, B:81:0x01c6, B:82:0x01d0, B:84:0x01db, B:85:0x01de, B:87:0x01e8, B:95:0x0201, B:96:0x0207, B:88:0x01ef, B:90:0x01f3, B:100:0x0210, B:101:0x0217, B:102:0x0218, B:104:0x0220, B:106:0x0224, B:107:0x0227, B:112:0x0239, B:114:0x0241, B:116:0x024b, B:118:0x025a, B:120:0x0260, B:122:0x026c, B:125:0x0271, B:127:0x0277, B:147:0x02dd, B:149:0x02e3, B:152:0x02ec, B:153:0x02f1, B:129:0x0282, B:131:0x028a, B:133:0x0294, B:134:0x0299, B:135:0x02a5, B:138:0x02ae, B:140:0x02b4, B:141:0x02b9, B:143:0x02bf, B:144:0x02c5, B:145:0x02d1, B:154:0x02f2, B:155:0x0312, B:157:0x0315, B:158:0x0319, B:162:0x0326, B:165:0x0330, B:167:0x033f, B:169:0x034a, B:170:0x0352, B:171:0x0355, B:182:0x037f, B:184:0x0388, B:186:0x0391, B:189:0x03a1, B:190:0x03c3, B:177:0x0363, B:179:0x036d, B:181:0x037c, B:180:0x0372, B:193:0x03c8, B:195:0x03dc, B:198:0x03e3, B:201:0x03ed, B:202:0x03f2, B:205:0x03f7, B:207:0x03fc, B:211:0x0407, B:213:0x0414, B:215:0x041a, B:218:0x0422, B:219:0x0425, B:221:0x0434, B:224:0x0441, B:225:0x0444, B:227:0x044a, B:230:0x0454, B:233:0x045d, B:234:0x0479, B:222:0x043c, B:235:0x047a, B:237:0x0489, B:238:0x048d, B:240:0x0496, B:243:0x049d, B:246:0x04a9, B:247:0x04cb, B:24:0x0085, B:25:0x00a7, B:27:0x00aa, B:32:0x00bb, B:34:0x00c3, B:37:0x00d3, B:38:0x00ed, B:39:0x00ee, B:40:0x00f3, B:49:0x0104, B:51:0x0111, B:53:0x011a, B:56:0x0123, B:57:0x0145, B:52:0x0116, B:63:0x014f, B:65:0x0157, B:68:0x0168, B:69:0x018c, B:70:0x018d, B:71:0x0192, B:72:0x0193, B:248:0x04cc, B:249:0x04d1, B:250:0x04d2, B:251:0x04d7), top: B:256:0x0044, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:243:0x049d A[Catch: all -> 0x04d8, TRY_ENTER, TryCatch #1 {all -> 0x04d8, blocks: (B:14:0x0044, B:17:0x0057, B:21:0x0073, B:74:0x019d, B:75:0x01a3, B:77:0x01b0, B:79:0x01b8, B:81:0x01c6, B:82:0x01d0, B:84:0x01db, B:85:0x01de, B:87:0x01e8, B:95:0x0201, B:96:0x0207, B:88:0x01ef, B:90:0x01f3, B:100:0x0210, B:101:0x0217, B:102:0x0218, B:104:0x0220, B:106:0x0224, B:107:0x0227, B:112:0x0239, B:114:0x0241, B:116:0x024b, B:118:0x025a, B:120:0x0260, B:122:0x026c, B:125:0x0271, B:127:0x0277, B:147:0x02dd, B:149:0x02e3, B:152:0x02ec, B:153:0x02f1, B:129:0x0282, B:131:0x028a, B:133:0x0294, B:134:0x0299, B:135:0x02a5, B:138:0x02ae, B:140:0x02b4, B:141:0x02b9, B:143:0x02bf, B:144:0x02c5, B:145:0x02d1, B:154:0x02f2, B:155:0x0312, B:157:0x0315, B:158:0x0319, B:162:0x0326, B:165:0x0330, B:167:0x033f, B:169:0x034a, B:170:0x0352, B:171:0x0355, B:182:0x037f, B:184:0x0388, B:186:0x0391, B:189:0x03a1, B:190:0x03c3, B:177:0x0363, B:179:0x036d, B:181:0x037c, B:180:0x0372, B:193:0x03c8, B:195:0x03dc, B:198:0x03e3, B:201:0x03ed, B:202:0x03f2, B:205:0x03f7, B:207:0x03fc, B:211:0x0407, B:213:0x0414, B:215:0x041a, B:218:0x0422, B:219:0x0425, B:221:0x0434, B:224:0x0441, B:225:0x0444, B:227:0x044a, B:230:0x0454, B:233:0x045d, B:234:0x0479, B:222:0x043c, B:235:0x047a, B:237:0x0489, B:238:0x048d, B:240:0x0496, B:243:0x049d, B:246:0x04a9, B:247:0x04cb, B:24:0x0085, B:25:0x00a7, B:27:0x00aa, B:32:0x00bb, B:34:0x00c3, B:37:0x00d3, B:38:0x00ed, B:39:0x00ee, B:40:0x00f3, B:49:0x0104, B:51:0x0111, B:53:0x011a, B:56:0x0123, B:57:0x0145, B:52:0x0116, B:63:0x014f, B:65:0x0157, B:68:0x0168, B:69:0x018c, B:70:0x018d, B:71:0x0192, B:72:0x0193, B:248:0x04cc, B:249:0x04d1, B:250:0x04d2, B:251:0x04d7), top: B:256:0x0044, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:271:0x038f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:272:0x03dc A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:273:0x03ed A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:274:0x044a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:275:0x045d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:276:0x0496 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:277:0x04a9 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:74:0x019d A[Catch: all -> 0x04d8, TryCatch #1 {all -> 0x04d8, blocks: (B:14:0x0044, B:17:0x0057, B:21:0x0073, B:74:0x019d, B:75:0x01a3, B:77:0x01b0, B:79:0x01b8, B:81:0x01c6, B:82:0x01d0, B:84:0x01db, B:85:0x01de, B:87:0x01e8, B:95:0x0201, B:96:0x0207, B:88:0x01ef, B:90:0x01f3, B:100:0x0210, B:101:0x0217, B:102:0x0218, B:104:0x0220, B:106:0x0224, B:107:0x0227, B:112:0x0239, B:114:0x0241, B:116:0x024b, B:118:0x025a, B:120:0x0260, B:122:0x026c, B:125:0x0271, B:127:0x0277, B:147:0x02dd, B:149:0x02e3, B:152:0x02ec, B:153:0x02f1, B:129:0x0282, B:131:0x028a, B:133:0x0294, B:134:0x0299, B:135:0x02a5, B:138:0x02ae, B:140:0x02b4, B:141:0x02b9, B:143:0x02bf, B:144:0x02c5, B:145:0x02d1, B:154:0x02f2, B:155:0x0312, B:157:0x0315, B:158:0x0319, B:162:0x0326, B:165:0x0330, B:167:0x033f, B:169:0x034a, B:170:0x0352, B:171:0x0355, B:182:0x037f, B:184:0x0388, B:186:0x0391, B:189:0x03a1, B:190:0x03c3, B:177:0x0363, B:179:0x036d, B:181:0x037c, B:180:0x0372, B:193:0x03c8, B:195:0x03dc, B:198:0x03e3, B:201:0x03ed, B:202:0x03f2, B:205:0x03f7, B:207:0x03fc, B:211:0x0407, B:213:0x0414, B:215:0x041a, B:218:0x0422, B:219:0x0425, B:221:0x0434, B:224:0x0441, B:225:0x0444, B:227:0x044a, B:230:0x0454, B:233:0x045d, B:234:0x0479, B:222:0x043c, B:235:0x047a, B:237:0x0489, B:238:0x048d, B:240:0x0496, B:243:0x049d, B:246:0x04a9, B:247:0x04cb, B:24:0x0085, B:25:0x00a7, B:27:0x00aa, B:32:0x00bb, B:34:0x00c3, B:37:0x00d3, B:38:0x00ed, B:39:0x00ee, B:40:0x00f3, B:49:0x0104, B:51:0x0111, B:53:0x011a, B:56:0x0123, B:57:0x0145, B:52:0x0116, B:63:0x014f, B:65:0x0157, B:68:0x0168, B:69:0x018c, B:70:0x018d, B:71:0x0192, B:72:0x0193, B:248:0x04cc, B:249:0x04d1, B:250:0x04d2, B:251:0x04d7), top: B:256:0x0044, inners: #0 }] */
    public final Object parseObject(Map map, Object obj) {
        Object objScanSymbolUnQuoted;
        boolean z;
        char current;
        char c;
        boolean z2;
        JSONObject jSONObject;
        ParseContext context;
        Object object;
        char current2;
        String strStringVal;
        Object obj2;
        JSONScanner jSONScanner;
        Object time;
        Object object2;
        Object objCreateInstance;
        JSONLexer jSONLexer = this.lexer;
        if (jSONLexer.token() == 8) {
            jSONLexer.next();
            return null;
        }
        if (jSONLexer.token() != 12 && jSONLexer.token() != 16) {
            throw new JSONException("syntax error, expect {, actual " + jSONLexer.tokenName());
        }
        ParseContext context2 = getContext();
        boolean z3 = false;
        while (true) {
            try {
                jSONLexer.skipWhitespace();
                char current3 = jSONLexer.getCurrent();
                if (isEnabled(Feature.AllowArbitraryCommas)) {
                    while (current3 == ',') {
                        jSONLexer.next();
                        jSONLexer.skipWhitespace();
                        current3 = jSONLexer.getCurrent();
                    }
                }
                if (current3 == '\"') {
                    objScanSymbolUnQuoted = jSONLexer.scanSymbol(this.symbolTable, Typography.quote);
                    jSONLexer.skipWhitespace();
                    if (jSONLexer.getCurrent() != ':') {
                        throw new JSONException("expect ':' at " + jSONLexer.pos() + ", name " + objScanSymbolUnQuoted);
                    }
                } else {
                    if (current3 == '}') {
                        jSONLexer.next();
                        jSONLexer.resetStringPosition();
                        jSONLexer.nextToken();
                        setContext(context2);
                        return map;
                    }
                    if (current3 == '\'') {
                        if (!isEnabled(Feature.AllowSingleQuotes)) {
                            throw new JSONException("syntax error");
                        }
                        objScanSymbolUnQuoted = jSONLexer.scanSymbol(this.symbolTable, '\'');
                        jSONLexer.skipWhitespace();
                        if (jSONLexer.getCurrent() != ':') {
                            throw new JSONException("expect ':' at " + jSONLexer.pos());
                        }
                    } else {
                        if (current3 == 26) {
                            throw new JSONException("syntax error");
                        }
                        if (current3 == ',') {
                            throw new JSONException("syntax error");
                        }
                        if ((current3 < '0' || current3 > '9') && current3 != '-') {
                            if (current3 == '{' || current3 == '[') {
                                jSONLexer.nextToken();
                                objScanSymbolUnQuoted = parse();
                                z = true;
                            } else {
                                if (!isEnabled(Feature.AllowUnQuotedFieldNames)) {
                                    throw new JSONException("syntax error");
                                }
                                objScanSymbolUnQuoted = jSONLexer.scanSymbolUnQuoted(this.symbolTable);
                                jSONLexer.skipWhitespace();
                                char current4 = jSONLexer.getCurrent();
                                if (current4 != ':') {
                                    throw new JSONException("expect ':' at " + jSONLexer.pos() + ", actual " + current4);
                                }
                            }
                            if (!z) {
                                jSONLexer.next();
                                jSONLexer.skipWhitespace();
                            }
                            current = jSONLexer.getCurrent();
                            jSONLexer.resetStringPosition();
                            if (objScanSymbolUnQuoted != JSON.DEFAULT_TYPE_KEY && !isEnabled(Feature.DisableSpecialKeyDetect)) {
                                String strScanSymbol = jSONLexer.scanSymbol(this.symbolTable, Typography.quote);
                                Class<?> clsLoadClass = TypeUtils.loadClass(strScanSymbol);
                                if (clsLoadClass != null) {
                                    jSONLexer.nextToken(16);
                                    if (jSONLexer.token() != 13) {
                                        setResolveStatus(2);
                                        if (this.context != null && !(obj instanceof Integer)) {
                                            popContext();
                                        }
                                        Object objDeserialze = this.config.getDeserializer(clsLoadClass).deserialze(this, clsLoadClass, obj);
                                        setContext(context2);
                                        return objDeserialze;
                                    }
                                    jSONLexer.nextToken(16);
                                    try {
                                        ObjectDeserializer deserializer = this.config.getDeserializer(clsLoadClass);
                                        if (deserializer instanceof ASMJavaBeanDeserializer) {
                                            objCreateInstance = ((ASMJavaBeanDeserializer) deserializer).createInstance(this, clsLoadClass);
                                        } else {
                                            objCreateInstance = deserializer instanceof JavaBeanDeserializer ? ((JavaBeanDeserializer) deserializer).createInstance(this, clsLoadClass) : null;
                                        }
                                        if (objCreateInstance == null) {
                                            objCreateInstance = clsLoadClass == Cloneable.class ? new HashMap() : clsLoadClass.newInstance();
                                        }
                                        setContext(context2);
                                        return objCreateInstance;
                                    } catch (Exception e) {
                                        throw new JSONException("create instance error", e);
                                    }
                                }
                                map.put(JSON.DEFAULT_TYPE_KEY, strScanSymbol);
                            } else {
                                if (objScanSymbolUnQuoted != "$ref" && !isEnabled(Feature.DisableSpecialKeyDetect)) {
                                    jSONLexer.nextToken(4);
                                    if (jSONLexer.token() != 4) {
                                        throw new JSONException("illegal ref, " + JSONToken.name(jSONLexer.token()));
                                    }
                                    String strStringVal2 = jSONLexer.stringVal();
                                    jSONLexer.nextToken(13);
                                    if ("@".equals(strStringVal2)) {
                                        if (getContext() != null) {
                                            ParseContext context3 = getContext();
                                            Object object3 = context3.getObject();
                                            if ((object3 instanceof Object[]) || (object3 instanceof Collection)) {
                                                object2 = object3;
                                            } else if (context3.getParentContext() != null) {
                                                object2 = context3.getParentContext().getObject();
                                            } else {
                                                object2 = null;
                                            }
                                        } else {
                                            object2 = null;
                                        }
                                    } else if ("..".equals(strStringVal2)) {
                                        ParseContext parentContext = context2.getParentContext();
                                        if (parentContext.getObject() != null) {
                                            object2 = parentContext.getObject();
                                        } else {
                                            addResolveTask(new ResolveTask(parentContext, strStringVal2));
                                            setResolveStatus(1);
                                            object2 = null;
                                        }
                                    } else {
                                        if ("$".equals(strStringVal2)) {
                                            ParseContext parentContext2 = context2;
                                            while (parentContext2.getParentContext() != null) {
                                                parentContext2 = parentContext2.getParentContext();
                                            }
                                            if (parentContext2.getObject() != null) {
                                                object2 = parentContext2.getObject();
                                            } else {
                                                addResolveTask(new ResolveTask(parentContext2, strStringVal2));
                                                setResolveStatus(1);
                                            }
                                        } else {
                                            addResolveTask(new ResolveTask(context2, strStringVal2));
                                            setResolveStatus(1);
                                        }
                                        object2 = null;
                                    }
                                    if (jSONLexer.token() != 13) {
                                        throw new JSONException("syntax error");
                                    }
                                    jSONLexer.nextToken(16);
                                    setContext(context2);
                                    return object2;
                                }
                                if (!z3) {
                                    setContext(map, obj);
                                    z3 = true;
                                }
                                if (map.getClass() == JSONObject.class) {
                                    if (objScanSymbolUnQuoted == null) {
                                        objScanSymbolUnQuoted = "null";
                                    } else {
                                        objScanSymbolUnQuoted = objScanSymbolUnQuoted.toString();
                                    }
                                }
                                if (current == '\"') {
                                    jSONLexer.scanString();
                                    strStringVal = jSONLexer.stringVal();
                                    if (jSONLexer.isEnabled(Feature.AllowISO8601DateFormat)) {
                                        jSONScanner = new JSONScanner(strStringVal);
                                        if (jSONScanner.scanISO8601DateIfMatch()) {
                                            obj2 = strStringVal;
                                            time = strStringVal;
                                            time = jSONScanner.getCalendar().getTime();
                                        }
                                        obj2 = strStringVal;
                                        time = strStringVal;
                                        jSONScanner.close();
                                        obj2 = time;
                                    }
                                    obj2 = strStringVal;
                                    map.put(objScanSymbolUnQuoted, obj2);
                                } else if ((current < '0' && current <= '9') || current == '-') {
                                    jSONLexer.scanNumber();
                                    map.put(objScanSymbolUnQuoted, jSONLexer.token() == 2 ? jSONLexer.integerValue() : jSONLexer.decimalValue(isEnabled(Feature.UseBigDecimal)));
                                } else if (current == '[') {
                                    jSONLexer.nextToken();
                                    JSONArray jSONArray = new JSONArray();
                                    parseArray(jSONArray, objScanSymbolUnQuoted);
                                    map.put(objScanSymbolUnQuoted, jSONArray);
                                    if (jSONLexer.token() == 13) {
                                        jSONLexer.nextToken();
                                        setContext(context2);
                                        return map;
                                    }
                                    c = 16;
                                    if (jSONLexer.token() != 16) {
                                        throw new JSONException("syntax error");
                                    }
                                } else if (current == '{') {
                                    jSONLexer.nextToken();
                                    if (obj == null && obj.getClass() == Integer.class) {
                                        z2 = true;
                                    } else {
                                        z2 = false;
                                    }
                                    jSONObject = new JSONObject(isEnabled(Feature.OrderedField));
                                    if (z2) {
                                        context = null;
                                    } else {
                                        context = setContext(context2, jSONObject, objScanSymbolUnQuoted);
                                    }
                                    object = parseObject(jSONObject, objScanSymbolUnQuoted);
                                    if (context != null && jSONObject != object) {
                                        context.setObject(map);
                                    }
                                    checkMapResolve(map, objScanSymbolUnQuoted.toString());
                                    if (map.getClass() == JSONObject.class) {
                                        map.put(objScanSymbolUnQuoted.toString(), object);
                                    } else {
                                        map.put(objScanSymbolUnQuoted, object);
                                    }
                                    if (z2) {
                                        setContext(context2, object, objScanSymbolUnQuoted);
                                    }
                                    if (jSONLexer.token() == 13) {
                                        jSONLexer.nextToken();
                                        setContext(context2);
                                        setContext(context2);
                                        return map;
                                    }
                                    c = 16;
                                    if (jSONLexer.token() != 16) {
                                        throw new JSONException("syntax error, " + jSONLexer.tokenName());
                                    }
                                } else {
                                    jSONLexer.nextToken();
                                    Object obj3 = parse();
                                    if (map.getClass() == JSONObject.class) {
                                        objScanSymbolUnQuoted = objScanSymbolUnQuoted.toString();
                                    }
                                    map.put(objScanSymbolUnQuoted, obj3);
                                    if (jSONLexer.token() == 13) {
                                        jSONLexer.nextToken();
                                        setContext(context2);
                                        return map;
                                    }
                                    c = 16;
                                    if (jSONLexer.token() != 16) {
                                        throw new JSONException("syntax error, position at " + jSONLexer.pos() + ", name " + objScanSymbolUnQuoted);
                                    }
                                }
                                jSONLexer.skipWhitespace();
                                current2 = jSONLexer.getCurrent();
                                if (current2 == ',') {
                                    if (current2 == '}') {
                                        throw new JSONException("syntax error, position at " + jSONLexer.pos() + ", name " + objScanSymbolUnQuoted);
                                    }
                                    jSONLexer.next();
                                    jSONLexer.resetStringPosition();
                                    jSONLexer.nextToken();
                                    setContext(map, obj);
                                    setContext(context2);
                                    return map;
                                }
                                jSONLexer.next();
                                c = 16;
                            }
                        } else {
                            jSONLexer.resetStringPosition();
                            jSONLexer.scanNumber();
                            objScanSymbolUnQuoted = jSONLexer.token() == 2 ? jSONLexer.integerValue() : jSONLexer.decimalValue(true);
                            if (jSONLexer.getCurrent() != ':') {
                                throw new JSONException("expect ':' at " + jSONLexer.pos() + ", name " + objScanSymbolUnQuoted);
                            }
                        }
                    }
                }
                z = false;
                if (!z) {
                    jSONLexer.next();
                    jSONLexer.skipWhitespace();
                }
                current = jSONLexer.getCurrent();
                jSONLexer.resetStringPosition();
                if (objScanSymbolUnQuoted != JSON.DEFAULT_TYPE_KEY) {
                }
                if (objScanSymbolUnQuoted != "$ref") {
                }
                if (!z3) {
                    setContext(map, obj);
                    z3 = true;
                }
                if (map.getClass() == JSONObject.class) {
                    if (objScanSymbolUnQuoted == null) {
                        objScanSymbolUnQuoted = "null";
                    } else {
                        objScanSymbolUnQuoted = objScanSymbolUnQuoted.toString();
                    }
                }
                if (current == '\"') {
                    jSONLexer.scanString();
                    strStringVal = jSONLexer.stringVal();
                    if (jSONLexer.isEnabled(Feature.AllowISO8601DateFormat)) {
                        jSONScanner = new JSONScanner(strStringVal);
                        if (jSONScanner.scanISO8601DateIfMatch()) {
                            obj2 = strStringVal;
                            time = strStringVal;
                            time = jSONScanner.getCalendar().getTime();
                        }
                        obj2 = strStringVal;
                        time = strStringVal;
                        jSONScanner.close();
                        obj2 = time;
                    }
                    obj2 = strStringVal;
                    map.put(objScanSymbolUnQuoted, obj2);
                } else if (current < '0') {
                    if (current == '[') {
                        jSONLexer.nextToken();
                        JSONArray jSONArray2 = new JSONArray();
                        parseArray(jSONArray2, objScanSymbolUnQuoted);
                        map.put(objScanSymbolUnQuoted, jSONArray2);
                        if (jSONLexer.token() == 13) {
                            jSONLexer.nextToken();
                            setContext(context2);
                            return map;
                        }
                        c = 16;
                        if (jSONLexer.token() != 16) {
                            throw new JSONException("syntax error");
                        }
                    } else if (current == '{') {
                        jSONLexer.nextToken();
                        if (obj == null) {
                            z2 = false;
                        } else {
                            z2 = false;
                        }
                        jSONObject = new JSONObject(isEnabled(Feature.OrderedField));
                        if (z2) {
                            context = setContext(context2, jSONObject, objScanSymbolUnQuoted);
                        } else {
                            context = null;
                        }
                        object = parseObject(jSONObject, objScanSymbolUnQuoted);
                        if (context != null) {
                            context.setObject(map);
                        }
                        checkMapResolve(map, objScanSymbolUnQuoted.toString());
                        if (map.getClass() == JSONObject.class) {
                            map.put(objScanSymbolUnQuoted.toString(), object);
                        } else {
                            map.put(objScanSymbolUnQuoted, object);
                        }
                        if (z2) {
                            setContext(context2, object, objScanSymbolUnQuoted);
                        }
                        if (jSONLexer.token() == 13) {
                            jSONLexer.nextToken();
                            setContext(context2);
                            setContext(context2);
                            return map;
                        }
                        c = 16;
                        if (jSONLexer.token() != 16) {
                            throw new JSONException("syntax error, " + jSONLexer.tokenName());
                        }
                    } else {
                        jSONLexer.nextToken();
                        Object obj4 = parse();
                        if (map.getClass() == JSONObject.class) {
                            objScanSymbolUnQuoted = objScanSymbolUnQuoted.toString();
                        }
                        map.put(objScanSymbolUnQuoted, obj4);
                        if (jSONLexer.token() == 13) {
                            jSONLexer.nextToken();
                            setContext(context2);
                            return map;
                        }
                        c = 16;
                        if (jSONLexer.token() != 16) {
                            throw new JSONException("syntax error, position at " + jSONLexer.pos() + ", name " + objScanSymbolUnQuoted);
                        }
                    }
                } else if (current == '[') {
                    jSONLexer.nextToken();
                    JSONArray jSONArray3 = new JSONArray();
                    parseArray(jSONArray3, objScanSymbolUnQuoted);
                    map.put(objScanSymbolUnQuoted, jSONArray3);
                    if (jSONLexer.token() == 13) {
                        jSONLexer.nextToken();
                        setContext(context2);
                        return map;
                    }
                    c = 16;
                    if (jSONLexer.token() != 16) {
                        throw new JSONException("syntax error");
                    }
                } else if (current == '{') {
                    jSONLexer.nextToken();
                    if (obj == null) {
                        z2 = false;
                    } else {
                        z2 = false;
                    }
                    jSONObject = new JSONObject(isEnabled(Feature.OrderedField));
                    if (z2) {
                        context = setContext(context2, jSONObject, objScanSymbolUnQuoted);
                    } else {
                        context = null;
                    }
                    object = parseObject(jSONObject, objScanSymbolUnQuoted);
                    if (context != null) {
                        context.setObject(map);
                    }
                    checkMapResolve(map, objScanSymbolUnQuoted.toString());
                    if (map.getClass() == JSONObject.class) {
                        map.put(objScanSymbolUnQuoted.toString(), object);
                    } else {
                        map.put(objScanSymbolUnQuoted, object);
                    }
                    if (z2) {
                        setContext(context2, object, objScanSymbolUnQuoted);
                    }
                    if (jSONLexer.token() == 13) {
                        jSONLexer.nextToken();
                        setContext(context2);
                        setContext(context2);
                        return map;
                    }
                    c = 16;
                    if (jSONLexer.token() != 16) {
                        throw new JSONException("syntax error, " + jSONLexer.tokenName());
                    }
                } else {
                    jSONLexer.nextToken();
                    Object obj5 = parse();
                    if (map.getClass() == JSONObject.class) {
                        objScanSymbolUnQuoted = objScanSymbolUnQuoted.toString();
                    }
                    map.put(objScanSymbolUnQuoted, obj5);
                    if (jSONLexer.token() == 13) {
                        jSONLexer.nextToken();
                        setContext(context2);
                        return map;
                    }
                    c = 16;
                    if (jSONLexer.token() != 16) {
                        throw new JSONException("syntax error, position at " + jSONLexer.pos() + ", name " + objScanSymbolUnQuoted);
                    }
                }
                jSONLexer.skipWhitespace();
                current2 = jSONLexer.getCurrent();
                if (current2 == ',') {
                    if (current2 == '}') {
                        throw new JSONException("syntax error, position at " + jSONLexer.pos() + ", name " + objScanSymbolUnQuoted);
                    }
                    jSONLexer.next();
                    jSONLexer.resetStringPosition();
                    jSONLexer.nextToken();
                    setContext(map, obj);
                    setContext(context2);
                    return map;
                }
                jSONLexer.next();
                c = 16;
            } catch (Throwable th) {
                setContext(context2);
                throw th;
            }
        }
    }

    public <T> T parseObject(Class<T> cls) {
        return (T) parseObject((Type) cls);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> T parseObject(Type type) {
        if (this.lexer.token() == 8) {
            this.lexer.nextToken();
            return null;
        }
        if (this.lexer.token() == 4) {
            type = TypeUtils.unwrap(type);
            if (type == byte[].class) {
                T t = (T) this.lexer.bytesValue();
                this.lexer.nextToken();
                return t;
            }
            if (type == char[].class) {
                String strStringVal = this.lexer.stringVal();
                this.lexer.nextToken();
                return (T) strStringVal.toCharArray();
            }
        }
        try {
            return (T) this.config.getDeserializer(type).deserialze(this, type, null);
        } catch (JSONException e) {
            throw e;
        } catch (Throwable th) {
            throw new JSONException(th.getMessage(), th);
        }
    }

    public <T> List<T> parseArray(Class<T> cls) {
        ArrayList arrayList = new ArrayList();
        parseArray((Class<?>) cls, (Collection) arrayList);
        return arrayList;
    }

    public void parseArray(Class<?> cls, Collection collection) {
        parseArray((Type) cls, collection);
    }

    public void parseArray(Type type, Collection collection) {
        parseArray(type, collection, null);
    }

    public void parseArray(Type type, Collection collection, Object obj) {
        ObjectDeserializer deserializer;
        if (this.lexer.token() == 21 || this.lexer.token() == 22) {
            this.lexer.nextToken();
        }
        if (this.lexer.token() != 14) {
            throw new JSONException("exepct '[', but " + JSONToken.name(this.lexer.token()));
        }
        if (Integer.TYPE == type) {
            deserializer = IntegerCodec.instance;
            this.lexer.nextToken(2);
        } else if (String.class == type) {
            deserializer = StringCodec.instance;
            this.lexer.nextToken(4);
        } else {
            deserializer = this.config.getDeserializer(type);
            this.lexer.nextToken(deserializer.getFastMatchToken());
        }
        ParseContext context = getContext();
        setContext(collection, obj);
        int i = 0;
        while (true) {
            try {
                if (isEnabled(Feature.AllowArbitraryCommas)) {
                    while (this.lexer.token() == 16) {
                        this.lexer.nextToken();
                    }
                }
                if (this.lexer.token() != 15) {
                    Object objDeserialze = null;
                    if (Integer.TYPE == type) {
                        collection.add(IntegerCodec.instance.deserialze(this, null, null));
                    } else if (String.class == type) {
                        if (this.lexer.token() == 4) {
                            objDeserialze = this.lexer.stringVal();
                            this.lexer.nextToken(16);
                        } else {
                            Object obj2 = parse();
                            if (obj2 != null) {
                                objDeserialze = obj2.toString();
                            }
                        }
                        collection.add(objDeserialze);
                    } else {
                        if (this.lexer.token() == 8) {
                            this.lexer.nextToken();
                        } else {
                            objDeserialze = deserializer.deserialze(this, type, Integer.valueOf(i));
                        }
                        collection.add(objDeserialze);
                        checkListResolve(collection);
                    }
                    if (this.lexer.token() == 16) {
                        this.lexer.nextToken(deserializer.getFastMatchToken());
                    }
                    i++;
                } else {
                    setContext(context);
                    this.lexer.nextToken(16);
                    return;
                }
            } catch (Throwable th) {
                setContext(context);
                throw th;
            }
        }
    }

    public Object[] parseArray(Type[] typeArr) {
        Object objCast;
        Class<?> componentType;
        boolean zIsArray;
        int i = 8;
        if (this.lexer.token() == 8) {
            this.lexer.nextToken(16);
            return null;
        }
        int i2 = 14;
        if (this.lexer.token() != 14) {
            throw new JSONException("syntax error : " + this.lexer.tokenName());
        }
        Object[] objArr = new Object[typeArr.length];
        if (typeArr.length == 0) {
            this.lexer.nextToken(15);
            if (this.lexer.token() != 15) {
                throw new JSONException("syntax error");
            }
            this.lexer.nextToken(16);
            return new Object[0];
        }
        this.lexer.nextToken(2);
        int i3 = 0;
        while (i3 < typeArr.length) {
            if (this.lexer.token() == i) {
                this.lexer.nextToken(16);
                objCast = null;
            } else {
                Type type = typeArr[i3];
                if (type == Integer.TYPE || type == Integer.class) {
                    if (this.lexer.token() == 2) {
                        objCast = Integer.valueOf(this.lexer.intValue());
                        this.lexer.nextToken(16);
                    } else {
                        objCast = TypeUtils.cast(parse(), type, this.config);
                    }
                } else if (type == String.class) {
                    if (this.lexer.token() == 4) {
                        objCast = this.lexer.stringVal();
                        this.lexer.nextToken(16);
                    } else {
                        objCast = TypeUtils.cast(parse(), type, this.config);
                    }
                } else {
                    if (i3 == typeArr.length - 1 && (type instanceof Class)) {
                        Class cls = (Class) type;
                        zIsArray = cls.isArray();
                        componentType = cls.getComponentType();
                    } else {
                        componentType = null;
                        zIsArray = false;
                    }
                    if (zIsArray && this.lexer.token() != i2) {
                        ArrayList arrayList = new ArrayList();
                        ObjectDeserializer deserializer = this.config.getDeserializer(componentType);
                        int fastMatchToken = deserializer.getFastMatchToken();
                        if (this.lexer.token() != 15) {
                            while (true) {
                                arrayList.add(deserializer.deserialze(this, type, null));
                                if (this.lexer.token() != 16) {
                                    break;
                                }
                                this.lexer.nextToken(fastMatchToken);
                            }
                            if (this.lexer.token() != 15) {
                                throw new JSONException("syntax error :" + JSONToken.name(this.lexer.token()));
                            }
                        }
                        objCast = TypeUtils.cast(arrayList, type, this.config);
                    } else {
                        objCast = this.config.getDeserializer(type).deserialze(this, type, null);
                    }
                }
            }
            objArr[i3] = objCast;
            if (this.lexer.token() == 15) {
                break;
            }
            if (this.lexer.token() != 16) {
                throw new JSONException("syntax error :" + JSONToken.name(this.lexer.token()));
            }
            if (i3 == typeArr.length - 1) {
                this.lexer.nextToken(15);
            } else {
                this.lexer.nextToken(2);
            }
            i3++;
            i = 8;
            i2 = 14;
        }
        if (this.lexer.token() != 15) {
            throw new JSONException("syntax error");
        }
        this.lexer.nextToken(16);
        return objArr;
    }

    public void parseObject(Object obj) {
        Object objDeserialze;
        Class<?> cls = obj.getClass();
        Map<String, FieldDeserializer> fieldDeserializers = this.config.getFieldDeserializers(cls);
        if (this.lexer.token() != 12 && this.lexer.token() != 16) {
            throw new JSONException("syntax error, expect {, actual " + this.lexer.tokenName());
        }
        while (true) {
            String strScanSymbol = this.lexer.scanSymbol(this.symbolTable);
            if (strScanSymbol == null) {
                if (this.lexer.token() == 13) {
                    this.lexer.nextToken(16);
                    return;
                } else if (this.lexer.token() != 16 || !isEnabled(Feature.AllowArbitraryCommas)) {
                }
            }
            FieldDeserializer value = fieldDeserializers.get(strScanSymbol);
            if (value == null && strScanSymbol != null) {
                for (Map.Entry<String, FieldDeserializer> entry : fieldDeserializers.entrySet()) {
                    if (strScanSymbol.equalsIgnoreCase(entry.getKey())) {
                        value = entry.getValue();
                        break;
                    }
                }
            }
            if (value == null) {
                if (!isEnabled(Feature.IgnoreNotMatch)) {
                    throw new JSONException("setter not found, class " + cls.getName() + ", property " + strScanSymbol);
                }
                this.lexer.nextTokenWithColon();
                parse();
                if (this.lexer.token() == 13) {
                    this.lexer.nextToken();
                    return;
                }
            } else {
                Class<?> fieldClass = value.getFieldClass();
                Type fieldType = value.getFieldType();
                if (fieldClass == Integer.TYPE) {
                    this.lexer.nextTokenWithColon(2);
                    objDeserialze = IntegerCodec.instance.deserialze(this, fieldType, null);
                } else if (fieldClass == String.class) {
                    this.lexer.nextTokenWithColon(4);
                    objDeserialze = StringCodec.deserialze(this);
                } else if (fieldClass == Long.TYPE) {
                    this.lexer.nextTokenWithColon(2);
                    objDeserialze = LongCodec.instance.deserialze(this, fieldType, null);
                } else {
                    ObjectDeserializer deserializer = this.config.getDeserializer(fieldClass, fieldType);
                    this.lexer.nextTokenWithColon(deserializer.getFastMatchToken());
                    objDeserialze = deserializer.deserialze(this, fieldType, null);
                }
                value.setValue(obj, objDeserialze);
                if (this.lexer.token() != 16 && this.lexer.token() == 13) {
                    this.lexer.nextToken(16);
                    return;
                }
            }
        }
    }

    public Object parseArrayWithType(Type type) {
        if (this.lexer.token() == 8) {
            this.lexer.nextToken();
            return null;
        }
        Type[] actualTypeArguments = ((ParameterizedType) type).getActualTypeArguments();
        if (actualTypeArguments.length != 1) {
            throw new JSONException("not support type " + type);
        }
        Type type2 = actualTypeArguments[0];
        if (type2 instanceof Class) {
            ArrayList arrayList = new ArrayList();
            parseArray((Class<?>) type2, (Collection) arrayList);
            return arrayList;
        }
        if (type2 instanceof WildcardType) {
            WildcardType wildcardType = (WildcardType) type2;
            Type type3 = wildcardType.getUpperBounds()[0];
            if (Object.class.equals(type3)) {
                if (wildcardType.getLowerBounds().length == 0) {
                    return parse();
                }
                throw new JSONException("not support type : " + type);
            }
            ArrayList arrayList2 = new ArrayList();
            parseArray((Class<?>) type3, (Collection) arrayList2);
            return arrayList2;
        }
        if (type2 instanceof TypeVariable) {
            TypeVariable typeVariable = (TypeVariable) type2;
            Type[] bounds = typeVariable.getBounds();
            if (bounds.length != 1) {
                throw new JSONException("not support : " + typeVariable);
            }
            Type type4 = bounds[0];
            if (type4 instanceof Class) {
                ArrayList arrayList3 = new ArrayList();
                parseArray((Class<?>) type4, (Collection) arrayList3);
                return arrayList3;
            }
        }
        if (type2 instanceof ParameterizedType) {
            ArrayList arrayList4 = new ArrayList();
            parseArray((ParameterizedType) type2, arrayList4);
            return arrayList4;
        }
        throw new JSONException("TODO : " + type);
    }

    public void acceptType(String str) {
        JSONLexer jSONLexer = this.lexer;
        jSONLexer.nextTokenWithColon();
        if (jSONLexer.token() != 4) {
            throw new JSONException("type not match error");
        }
        if (str.equals(jSONLexer.stringVal())) {
            jSONLexer.nextToken();
            if (jSONLexer.token() == 16) {
                jSONLexer.nextToken();
                return;
            }
            return;
        }
        throw new JSONException("type not match error");
    }

    public Object getObject(String str) {
        for (int i = 0; i < this.contextArrayIndex; i++) {
            if (str.equals(this.contextArray[i].getPath())) {
                return this.contextArray[i].getObject();
            }
        }
        return null;
    }

    public void checkListResolve(Collection collection) {
        if (this.resolveStatus == 1) {
            if (collection instanceof List) {
                int size = collection.size() - 1;
                ResolveTask lastResolveTask = getLastResolveTask();
                lastResolveTask.setFieldDeserializer(new ListResolveFieldDeserializer(this, (List) collection, size));
                lastResolveTask.setOwnerContext(this.context);
                setResolveStatus(0);
                return;
            }
            ResolveTask lastResolveTask2 = getLastResolveTask();
            lastResolveTask2.setFieldDeserializer(new CollectionResolveFieldDeserializer(this, collection));
            lastResolveTask2.setOwnerContext(this.context);
            setResolveStatus(0);
        }
    }

    public void checkMapResolve(Map map, String str) {
        if (this.resolveStatus == 1) {
            MapResolveFieldDeserializer mapResolveFieldDeserializer = new MapResolveFieldDeserializer(map, str);
            ResolveTask lastResolveTask = getLastResolveTask();
            lastResolveTask.setFieldDeserializer(mapResolveFieldDeserializer);
            lastResolveTask.setOwnerContext(this.context);
            setResolveStatus(0);
        }
    }

    public Object parseObject(Map map) {
        return parseObject(map, null);
    }

    public JSONObject parseObject() {
        JSONObject jSONObject = new JSONObject(isEnabled(Feature.OrderedField));
        parseObject((Map) jSONObject);
        return jSONObject;
    }

    public final void parseArray(Collection collection) {
        parseArray(collection, (Object) null);
    }

    public final void parseArray(Collection collection, Object obj) {
        Object object;
        Number numberDecimalValue;
        String strStringVal;
        Object time;
        JSONLexer lexer = getLexer();
        if (lexer.token() == 21 || lexer.token() == 22) {
            lexer.nextToken();
        }
        if (lexer.token() != 14) {
            throw new JSONException("syntax error, expect [, actual " + JSONToken.name(lexer.token()) + ", pos " + lexer.pos());
        }
        lexer.nextToken(4);
        ParseContext context = getContext();
        setContext(collection, obj);
        int i = 0;
        while (true) {
            try {
                if (isEnabled(Feature.AllowArbitraryCommas)) {
                    while (lexer.token() == 16) {
                        lexer.nextToken();
                    }
                }
                int i2 = lexer.token();
                if (i2 == 2) {
                    Number numberIntegerValue = lexer.integerValue();
                    lexer.nextToken(16);
                    object = numberIntegerValue;
                } else if (i2 == 3) {
                    if (lexer.isEnabled(Feature.UseBigDecimal)) {
                        numberDecimalValue = lexer.decimalValue(true);
                    } else {
                        numberDecimalValue = lexer.decimalValue(false);
                    }
                    object = numberDecimalValue;
                    lexer.nextToken(16);
                } else if (i2 == 4) {
                    strStringVal = lexer.stringVal();
                    lexer.nextToken(16);
                    if (lexer.isEnabled(Feature.AllowISO8601DateFormat)) {
                        JSONScanner jSONScanner = new JSONScanner(strStringVal);
                        if (jSONScanner.scanISO8601DateIfMatch()) {
                            object = strStringVal;
                            time = strStringVal;
                            time = jSONScanner.getCalendar().getTime();
                        }
                        object = strStringVal;
                        time = strStringVal;
                        jSONScanner.close();
                        object = time;
                    }
                } else if (i2 == 6) {
                    Boolean bool = Boolean.TRUE;
                    lexer.nextToken(16);
                    object = bool;
                } else if (i2 != 7) {
                    object = null;
                    object = null;
                    if (i2 == 8) {
                        lexer.nextToken(4);
                    } else if (i2 == 12) {
                        object = parseObject(new JSONObject(isEnabled(Feature.OrderedField)), Integer.valueOf(i));
                    } else {
                        if (i2 == 20) {
                            throw new JSONException("unclosed jsonArray");
                        }
                        if (i2 == 23) {
                            lexer.nextToken(4);
                        } else if (i2 == 14) {
                            JSONArray jSONArray = new JSONArray();
                            parseArray(jSONArray, Integer.valueOf(i));
                            object = jSONArray;
                        } else {
                            if (i2 == 15) {
                                lexer.nextToken(16);
                                setContext(context);
                                return;
                            }
                            object = parse();
                        }
                    }
                } else {
                    Boolean bool2 = Boolean.FALSE;
                    lexer.nextToken(16);
                    object = bool2;
                }
                object = strStringVal;
                collection.add(object);
                checkListResolve(collection);
                if (lexer.token() == 16) {
                    lexer.nextToken(4);
                }
                i++;
            } catch (Throwable th) {
                setContext(context);
                throw th;
            }
        }
    }

    public List<ResolveTask> getResolveTaskList() {
        if (this.resolveTaskList == null) {
            this.resolveTaskList = new ArrayList(2);
        }
        return this.resolveTaskList;
    }

    public void addResolveTask(ResolveTask resolveTask) {
        if (this.resolveTaskList == null) {
            this.resolveTaskList = new ArrayList(2);
        }
        this.resolveTaskList.add(resolveTask);
    }

    public ResolveTask getLastResolveTask() {
        List<ResolveTask> list = this.resolveTaskList;
        return list.get(list.size() - 1);
    }

    public List<ExtraProcessor> getExtraProcessors() {
        if (this.extraProcessors == null) {
            this.extraProcessors = new ArrayList(2);
        }
        return this.extraProcessors;
    }

    public List<ExtraTypeProvider> getExtraTypeProviders() {
        if (this.extraTypeProviders == null) {
            this.extraTypeProviders = new ArrayList(2);
        }
        return this.extraTypeProviders;
    }

    public void setContext(ParseContext parseContext) {
        if (isEnabled(Feature.DisableCircularReferenceDetect)) {
            return;
        }
        this.context = parseContext;
    }

    public void popContext() {
        if (isEnabled(Feature.DisableCircularReferenceDetect)) {
            return;
        }
        this.context = this.context.getParentContext();
        ParseContext[] parseContextArr = this.contextArray;
        int i = this.contextArrayIndex;
        parseContextArr[i - 1] = null;
        this.contextArrayIndex = i - 1;
    }

    public ParseContext setContext(Object obj, Object obj2) {
        if (isEnabled(Feature.DisableCircularReferenceDetect)) {
            return null;
        }
        return setContext(this.context, obj, obj2);
    }

    public ParseContext setContext(ParseContext parseContext, Object obj, Object obj2) {
        if (isEnabled(Feature.DisableCircularReferenceDetect)) {
            return null;
        }
        ParseContext parseContext2 = new ParseContext(parseContext, obj, obj2);
        this.context = parseContext2;
        addContext(parseContext2);
        return this.context;
    }

    private void addContext(ParseContext parseContext) {
        int i = this.contextArrayIndex;
        this.contextArrayIndex = i + 1;
        ParseContext[] parseContextArr = this.contextArray;
        if (i >= parseContextArr.length) {
            ParseContext[] parseContextArr2 = new ParseContext[(parseContextArr.length * 3) / 2];
            System.arraycopy(parseContextArr, 0, parseContextArr2, 0, parseContextArr.length);
            this.contextArray = parseContextArr2;
        }
        this.contextArray[i] = parseContext;
    }

    public Object parse() {
        return parse(null);
    }

    public Object parseKey() {
        if (this.lexer.token() == 18) {
            String strStringVal = this.lexer.stringVal();
            this.lexer.nextToken(16);
            return strStringVal;
        }
        return parse(null);
    }

    public Object parse(Object obj) {
        JSONLexer lexer = getLexer();
        int i = lexer.token();
        if (i == 2) {
            Number numberIntegerValue = lexer.integerValue();
            lexer.nextToken();
            return numberIntegerValue;
        }
        if (i == 3) {
            Number numberDecimalValue = lexer.decimalValue(isEnabled(Feature.UseBigDecimal));
            lexer.nextToken();
            return numberDecimalValue;
        }
        if (i == 4) {
            String strStringVal = lexer.stringVal();
            lexer.nextToken(16);
            if (lexer.isEnabled(Feature.AllowISO8601DateFormat)) {
                JSONScanner jSONScanner = new JSONScanner(strStringVal);
                try {
                    if (jSONScanner.scanISO8601DateIfMatch()) {
                        return jSONScanner.getCalendar().getTime();
                    }
                } finally {
                    jSONScanner.close();
                }
            }
            return strStringVal;
        }
        if (i == 12) {
            return parseObject(new JSONObject(isEnabled(Feature.OrderedField)), obj);
        }
        if (i == 14) {
            JSONArray jSONArray = new JSONArray();
            parseArray(jSONArray, obj);
            return jSONArray;
        }
        switch (i) {
            case 6:
                lexer.nextToken();
                return Boolean.TRUE;
            case 7:
                lexer.nextToken();
                return Boolean.FALSE;
            case 8:
                lexer.nextToken();
                return null;
            case 9:
                lexer.nextToken(18);
                if (lexer.token() != 18) {
                    throw new JSONException("syntax error");
                }
                lexer.nextToken(10);
                accept(10);
                long jLongValue = lexer.integerValue().longValue();
                accept(2);
                accept(11);
                return new Date(jLongValue);
            default:
                switch (i) {
                    case 20:
                        if (lexer.isBlankInput()) {
                            return null;
                        }
                        throw new JSONException("unterminated json string, pos " + lexer.getBufferPosition());
                    case 21:
                        lexer.nextToken();
                        HashSet hashSet = new HashSet();
                        parseArray(hashSet, obj);
                        return hashSet;
                    case 22:
                        lexer.nextToken();
                        TreeSet treeSet = new TreeSet();
                        parseArray(treeSet, obj);
                        return treeSet;
                    case 23:
                        lexer.nextToken();
                        return null;
                    default:
                        throw new JSONException("syntax error, pos " + lexer.getBufferPosition());
                }
        }
    }

    public void config(Feature feature, boolean z) {
        getLexer().config(feature, z);
    }

    public boolean isEnabled(Feature feature) {
        return getLexer().isEnabled(feature);
    }

    public final void accept(int i) {
        JSONLexer lexer = getLexer();
        if (lexer.token() == i) {
            lexer.nextToken();
            return;
        }
        throw new JSONException("syntax error, expect " + JSONToken.name(i) + ", actual " + JSONToken.name(lexer.token()));
    }

    public final void accept(int i, int i2) {
        JSONLexer lexer = getLexer();
        if (lexer.token() == i) {
            lexer.nextToken(i2);
            return;
        }
        throw new JSONException("syntax error, expect " + JSONToken.name(i) + ", actual " + JSONToken.name(lexer.token()));
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        JSONLexer lexer = getLexer();
        try {
            if (isEnabled(Feature.AutoCloseSource) && lexer.token() != 20) {
                throw new JSONException("not close json text, token : " + JSONToken.name(lexer.token()));
            }
            lexer.close();
        } catch (Throwable th) {
            lexer.close();
            throw th;
        }
    }

    public void handleResovleTask(Object obj) {
        Object object;
        List<ResolveTask> list = this.resolveTaskList;
        if (list == null) {
            return;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            ResolveTask resolveTask = this.resolveTaskList.get(i);
            FieldDeserializer fieldDeserializer = resolveTask.getFieldDeserializer();
            if (fieldDeserializer != null) {
                Object object2 = resolveTask.getOwnerContext() != null ? resolveTask.getOwnerContext().getObject() : null;
                String referenceValue = resolveTask.getReferenceValue();
                if (referenceValue.startsWith("$")) {
                    object = getObject(referenceValue);
                } else {
                    object = resolveTask.getContext().getObject();
                }
                fieldDeserializer.setValue(object2, object);
            }
        }
    }

    public static class ResolveTask {
        private final ParseContext context;
        private FieldDeserializer fieldDeserializer;
        private ParseContext ownerContext;
        private final String referenceValue;

        public ParseContext getContext() {
            return this.context;
        }

        public FieldDeserializer getFieldDeserializer() {
            return this.fieldDeserializer;
        }

        public ParseContext getOwnerContext() {
            return this.ownerContext;
        }

        public String getReferenceValue() {
            return this.referenceValue;
        }

        public void setFieldDeserializer(FieldDeserializer fieldDeserializer) {
            this.fieldDeserializer = fieldDeserializer;
        }

        public void setOwnerContext(ParseContext parseContext) {
            this.ownerContext = parseContext;
        }

        public ResolveTask(ParseContext parseContext, String str) {
            this.context = parseContext;
            this.referenceValue = str;
        }
    }
}
