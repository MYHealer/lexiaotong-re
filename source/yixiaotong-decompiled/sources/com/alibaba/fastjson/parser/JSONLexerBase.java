package com.alibaba.fastjson.parser;

import client.android.yixiaotong.v3.comman.AppTypeIdUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.google.android.exoplayer2.C;
import com.huawei.hms.ads.ez;
import java.io.Closeable;
import java.lang.ref.SoftReference;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import kotlin.text.Typography;
import okio.internal.BufferKt;
import org.apache.commons.io.IOUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public abstract class JSONLexerBase implements JSONLexer, Closeable {
    private static final Map<String, Integer> DEFAULT_KEYWORDS;
    protected static final int INT_MULTMIN_RADIX_TEN = -214748364;
    protected static final int INT_N_MULTMAX_RADIX_TEN = -214748364;
    protected static final long MULTMIN_RADIX_TEN = -922337203685477580L;
    protected static final long N_MULTMAX_RADIX_TEN = -922337203685477580L;
    private static final ThreadLocal<SoftReference<char[]>> SBUF_REF_LOCAL;
    protected static final int[] digits;
    protected static final char[] typeFieldName;
    protected int bp;
    protected char ch;
    protected int eofPos;
    protected boolean hasSpecial;
    protected int np;
    protected int pos;
    protected char[] sbuf;
    protected int sp;
    protected int token;
    protected int features = JSON.DEFAULT_PARSER_FEATURE;
    protected Calendar calendar = null;
    public int matchStat = 0;
    protected Map<String, Integer> keywods = DEFAULT_KEYWORDS;

    public static final boolean isWhitespace(char c) {
        return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == '\f' || c == '\b';
    }

    public abstract String addSymbol(int i, int i2, int i3, SymbolTable symbolTable);

    protected abstract void arrayCopy(int i, char[] cArr, int i2, int i3);

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public abstract byte[] bytesValue();

    protected abstract boolean charArrayCompare(char[] cArr);

    public abstract char charAt(int i);

    protected abstract void copyTo(int i, int i2, char[] cArr);

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final int getBufferPosition() {
        return this.bp;
    }

    public Calendar getCalendar() {
        return this.calendar;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final char getCurrent() {
        return this.ch;
    }

    public abstract int indexOf(char c, int i);

    public abstract boolean isEOF();

    protected void lexError(String str, Object... objArr) {
        this.token = 1;
    }

    public final int matchStat() {
        return this.matchStat;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public abstract char next();

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public abstract String numberString();

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final int pos() {
        return this.pos;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final void resetStringPosition() {
        this.sp = 0;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public abstract String stringVal();

    public abstract String subString(int i, int i2);

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final int token() {
        return this.token;
    }

    static {
        HashMap map = new HashMap();
        map.put("null", 8);
        map.put("new", 9);
        map.put(ez.Code, 6);
        map.put(ez.V, 7);
        map.put("undefined", 23);
        DEFAULT_KEYWORDS = map;
        SBUF_REF_LOCAL = new ThreadLocal<>();
        typeFieldName = ("\"" + JSON.DEFAULT_TYPE_KEY + "\":\"").toCharArray();
        digits = new int[103];
        for (int i = 48; i <= 57; i++) {
            digits[i] = i - 48;
        }
        for (int i2 = 97; i2 <= 102; i2++) {
            digits[i2] = i2 - 87;
        }
        for (int i3 = 65; i3 <= 70; i3++) {
            digits[i3] = i3 - 55;
        }
    }

    public JSONLexerBase() {
        ThreadLocal<SoftReference<char[]>> threadLocal = SBUF_REF_LOCAL;
        SoftReference<char[]> softReference = threadLocal.get();
        if (softReference != null) {
            this.sbuf = softReference.get();
            threadLocal.set(null);
        }
        if (this.sbuf == null) {
            this.sbuf = new char[64];
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final void nextToken() {
        this.sp = 0;
        while (true) {
            this.pos = this.bp;
            char c = this.ch;
            if (c == '\"') {
                scanString();
                return;
            }
            if (c == ',') {
                next();
                this.token = 16;
                return;
            }
            if (c >= '0' && c <= '9') {
                scanNumber();
                return;
            }
            if (c == '-') {
                scanNumber();
                return;
            }
            if (c != '\f' && c != '\r' && c != ' ') {
                if (c == ':') {
                    next();
                    this.token = 17;
                    return;
                }
                if (c == 'N') {
                    scanNULL();
                    return;
                }
                if (c == '[') {
                    next();
                    this.token = 14;
                    return;
                }
                if (c == ']') {
                    next();
                    this.token = 15;
                    return;
                }
                if (c == 'f') {
                    scanFalse();
                    return;
                }
                if (c == 'n') {
                    scanNullOrNew();
                    return;
                }
                if (c == '{') {
                    next();
                    this.token = 12;
                    return;
                }
                if (c == '}') {
                    next();
                    this.token = 13;
                    return;
                }
                if (c == 'S') {
                    scanSet();
                    return;
                }
                if (c == 'T') {
                    scanTreeSet();
                    return;
                }
                if (c == 't') {
                    scanTrue();
                    return;
                }
                if (c != 'u') {
                    switch (c) {
                        case '\b':
                        case '\t':
                        case '\n':
                            break;
                        default:
                            switch (c) {
                                case '\'':
                                    if (!isEnabled(Feature.AllowSingleQuotes)) {
                                        throw new JSONException("Feature.AllowSingleQuotes is false");
                                    }
                                    scanStringSingleQuote();
                                    return;
                                case '(':
                                    next();
                                    this.token = 10;
                                    return;
                                case ')':
                                    next();
                                    this.token = 11;
                                    return;
                                default:
                                    if (!isEOF()) {
                                        lexError("illegal.char", String.valueOf((int) this.ch));
                                        next();
                                        return;
                                    } else {
                                        if (this.token == 20) {
                                            throw new JSONException("EOF error");
                                        }
                                        this.token = 20;
                                        int i = this.eofPos;
                                        this.bp = i;
                                        this.pos = i;
                                        return;
                                    }
                            }
                    }
                } else {
                    scanUndefined();
                    return;
                }
            }
            next();
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:103:0x0073 A[SYNTHETIC] */
    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final void nextToken(int i) {
        this.sp = 0;
        while (true) {
            if (i == 2) {
                char c = this.ch;
                if (c >= '0' && c <= '9') {
                    this.pos = this.bp;
                    scanNumber();
                    return;
                }
                if (c == '\"') {
                    this.pos = this.bp;
                    scanString();
                    return;
                } else if (c == '[') {
                    this.token = 14;
                    next();
                    return;
                } else if (c == '{') {
                    this.token = 12;
                    next();
                    return;
                }
            } else if (i == 4) {
                char c2 = this.ch;
                if (c2 == '\"') {
                    this.pos = this.bp;
                    scanString();
                    return;
                }
                if (c2 >= '0' && c2 <= '9') {
                    this.pos = this.bp;
                    scanNumber();
                    return;
                } else if (c2 == '[') {
                    this.token = 14;
                    next();
                    return;
                } else if (c2 == '{') {
                    this.token = 12;
                    next();
                    return;
                }
            } else if (i == 12) {
                char c3 = this.ch;
                if (c3 == '{') {
                    this.token = 12;
                    next();
                    return;
                } else if (c3 == '[') {
                    this.token = 14;
                    next();
                    return;
                }
            } else {
                if (i == 18) {
                    nextIdent();
                    return;
                }
                if (i != 20) {
                    switch (i) {
                        case 14:
                            char c4 = this.ch;
                            if (c4 == '[') {
                                this.token = 14;
                                next();
                            } else if (c4 == '{') {
                                this.token = 12;
                                next();
                            }
                            break;
                        case 15:
                            if (this.ch == ']') {
                                this.token = 15;
                                next();
                            }
                            if (this.ch == 26) {
                                this.token = 20;
                            }
                            break;
                        case 16:
                            char c5 = this.ch;
                            if (c5 == ',') {
                                this.token = 16;
                                next();
                            } else if (c5 == '}') {
                                this.token = 13;
                                next();
                            } else if (c5 == ']') {
                                this.token = 15;
                                next();
                            } else if (c5 == 26) {
                                this.token = 20;
                            }
                            break;
                    }
                    return;
                }
                if (this.ch == 26) {
                    this.token = 20;
                    return;
                }
            }
            char c6 = this.ch;
            if (c6 == ' ' || c6 == '\n' || c6 == '\r' || c6 == '\t' || c6 == '\f' || c6 == '\b') {
                next();
            } else {
                nextToken();
                return;
            }
        }
    }

    public final void nextIdent() {
        while (isWhitespace(this.ch)) {
            next();
        }
        char c = this.ch;
        if (c == '_' || Character.isLetter(c)) {
            scanIdent();
        } else {
            nextToken();
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final void nextTokenWithColon() {
        nextTokenWithChar(':');
    }

    public final void nextTokenWithComma() {
        nextTokenWithChar(':');
    }

    public final void nextTokenWithChar(char c) {
        this.sp = 0;
        while (true) {
            char c2 = this.ch;
            if (c2 == c) {
                next();
                nextToken();
                return;
            } else if (c2 == ' ' || c2 == '\n' || c2 == '\r' || c2 == '\t' || c2 == '\f' || c2 == '\b') {
                next();
            } else {
                throw new JSONException("not match " + c + " - " + this.ch);
            }
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final String tokenName() {
        return JSONToken.name(this.token);
    }

    public final String stringDefaultValue() {
        if (isEnabled(Feature.InitStringFieldAsEmpty)) {
            return "";
        }
        return null;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final Number integerValue() throws NumberFormatException {
        char c;
        long j;
        long j2;
        boolean z = false;
        if (this.np == -1) {
            this.np = 0;
        }
        int i = this.np;
        int i2 = this.sp + i;
        char cCharAt = charAt(i2 - 1);
        if (cCharAt == 'B') {
            i2--;
            c = 'B';
        } else if (cCharAt == 'L') {
            i2--;
            c = 'L';
        } else if (cCharAt != 'S') {
            c = ' ';
        } else {
            i2--;
            c = 'S';
        }
        if (charAt(this.np) == '-') {
            i++;
            j = Long.MIN_VALUE;
            z = true;
        } else {
            j = -9223372036854775807L;
        }
        if (i < i2) {
            j2 = -digits[charAt(i)];
            i++;
        } else {
            j2 = 0;
        }
        while (i < i2) {
            int i3 = i + 1;
            int i4 = digits[charAt(i)];
            if (j2 < BufferKt.OVERFLOW_ZONE) {
                return new BigInteger(numberString());
            }
            long j3 = j2 * 10;
            long j4 = i4;
            if (j3 < j + j4) {
                return new BigInteger(numberString());
            }
            j2 = j3 - j4;
            i = i3;
        }
        if (!z) {
            long j5 = -j2;
            if (j5 > 2147483647L || c == 'L') {
                return Long.valueOf(j5);
            }
            if (c == 'S') {
                return Short.valueOf((short) j5);
            }
            if (c == 'B') {
                return Byte.valueOf((byte) j5);
            }
            return Integer.valueOf((int) j5);
        }
        if (i <= this.np + 1) {
            throw new NumberFormatException(numberString());
        }
        if (j2 < -2147483648L || c == 'L') {
            return Long.valueOf(j2);
        }
        if (c == 'S') {
            return Short.valueOf((short) j2);
        }
        if (c == 'B') {
            return Byte.valueOf((byte) j2);
        }
        return Integer.valueOf((int) j2);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final void nextTokenWithColon(int i) {
        nextTokenWithChar(':');
    }

    public final void nextTokenWithComma(int i) {
        nextTokenWithChar(',');
    }

    public final void nextTokenWithChar(char c, int i) {
        this.sp = 0;
        while (true) {
            char c2 = this.ch;
            if (c2 == c) {
                next();
                while (true) {
                    if (i == 2) {
                        char c3 = this.ch;
                        if (c3 >= '0' && c3 <= '9') {
                            this.pos = this.bp;
                            scanNumber();
                            return;
                        } else if (c3 == '\"') {
                            this.pos = this.bp;
                            scanString();
                            return;
                        }
                    } else if (i == 4) {
                        char c4 = this.ch;
                        if (c4 == '\"') {
                            this.pos = this.bp;
                            scanString();
                            return;
                        } else if (c4 >= '0' && c4 <= '9') {
                            this.pos = this.bp;
                            scanNumber();
                            return;
                        }
                    } else if (i == 12) {
                        char c5 = this.ch;
                        if (c5 == '{') {
                            this.token = 12;
                            next();
                            return;
                        } else if (c5 == '[') {
                            this.token = 14;
                            next();
                            return;
                        }
                    } else if (i == 14) {
                        char c6 = this.ch;
                        if (c6 == '[') {
                            this.token = 14;
                            next();
                            return;
                        } else if (c6 == '{') {
                            this.token = 12;
                            next();
                            return;
                        }
                    }
                    if (isWhitespace(this.ch)) {
                        next();
                    } else {
                        nextToken();
                        return;
                    }
                }
            } else if (isWhitespace(c2)) {
                next();
            } else {
                throw new JSONException("not match " + i + " - " + this.ch);
            }
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public float floatValue() {
        return Float.parseFloat(numberString());
    }

    public double doubleValue() {
        return Double.parseDouble(numberString());
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public void config(Feature feature, boolean z) {
        this.features = Feature.config(this.features, feature, z);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final boolean isEnabled(Feature feature) {
        return Feature.isEnabled(this.features, feature);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final String scanSymbol(SymbolTable symbolTable) {
        skipWhitespace();
        char c = this.ch;
        if (c == '\"') {
            return scanSymbol(symbolTable, Typography.quote);
        }
        if (c == '\'') {
            if (!isEnabled(Feature.AllowSingleQuotes)) {
                throw new JSONException("syntax error");
            }
            return scanSymbol(symbolTable, '\'');
        }
        if (c == '}') {
            next();
            this.token = 13;
            return null;
        }
        if (c == ',') {
            next();
            this.token = 16;
            return null;
        }
        if (c == 26) {
            this.token = 20;
            return null;
        }
        if (!isEnabled(Feature.AllowUnQuotedFieldNames)) {
            throw new JSONException("syntax error");
        }
        return scanSymbolUnQuoted(symbolTable);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final String scanSymbol(SymbolTable symbolTable, char c) {
        String strAddSymbol;
        this.np = this.bp;
        this.sp = 0;
        boolean z = false;
        int i = 0;
        while (true) {
            char next = next();
            if (next == c) {
                this.token = 4;
                if (!z) {
                    int i2 = this.np;
                    strAddSymbol = addSymbol(i2 == -1 ? 0 : i2 + 1, this.sp, i, symbolTable);
                } else {
                    strAddSymbol = symbolTable.addSymbol(this.sbuf, 0, this.sp, i);
                }
                this.sp = 0;
                next();
                return strAddSymbol;
            }
            if (next == 26) {
                throw new JSONException("unclosed.str");
            }
            if (next == '\\') {
                if (!z) {
                    int i3 = this.sp;
                    char[] cArr = this.sbuf;
                    if (i3 >= cArr.length) {
                        int length = cArr.length * 2;
                        if (i3 <= length) {
                            i3 = length;
                        }
                        char[] cArr2 = new char[i3];
                        System.arraycopy(cArr, 0, cArr2, 0, cArr.length);
                        this.sbuf = cArr2;
                    }
                    arrayCopy(this.np + 1, this.sbuf, 0, this.sp);
                    z = true;
                }
                char next2 = next();
                if (next2 == '\"') {
                    i = (i * 31) + 34;
                    putChar(Typography.quote);
                } else if (next2 != '\'') {
                    if (next2 != 'F') {
                        if (next2 == '\\') {
                            i = (i * 31) + 92;
                            putChar(IOUtils.DIR_SEPARATOR_WINDOWS);
                        } else if (next2 == 'b') {
                            i = (i * 31) + 8;
                            putChar('\b');
                        } else if (next2 != 'f') {
                            if (next2 == 'n') {
                                i = (i * 31) + 10;
                                putChar('\n');
                            } else if (next2 == 'r') {
                                i = (i * 31) + 13;
                                putChar('\r');
                            } else if (next2 != 'x') {
                                switch (next2) {
                                    case '/':
                                        i = (i * 31) + 47;
                                        putChar(IOUtils.DIR_SEPARATOR_UNIX);
                                        break;
                                    case '0':
                                        i = (i * 31) + next2;
                                        putChar((char) 0);
                                        break;
                                    case '1':
                                        i = (i * 31) + next2;
                                        putChar((char) 1);
                                        break;
                                    case '2':
                                        i = (i * 31) + next2;
                                        putChar((char) 2);
                                        break;
                                    case '3':
                                        i = (i * 31) + next2;
                                        putChar((char) 3);
                                        break;
                                    case '4':
                                        i = (i * 31) + next2;
                                        putChar((char) 4);
                                        break;
                                    case '5':
                                        i = (i * 31) + next2;
                                        putChar((char) 5);
                                        break;
                                    case '6':
                                        i = (i * 31) + next2;
                                        putChar((char) 6);
                                        break;
                                    case '7':
                                        i = (i * 31) + next2;
                                        putChar((char) 7);
                                        break;
                                    default:
                                        switch (next2) {
                                            case 't':
                                                i = (i * 31) + 9;
                                                putChar('\t');
                                                break;
                                            case AppTypeIdUtil.Drink4GCostControl_1 /* 117 */:
                                                int i4 = Integer.parseInt(new String(new char[]{next(), next(), next(), next()}), 16);
                                                i = (i * 31) + i4;
                                                putChar((char) i4);
                                                break;
                                            case 'v':
                                                i = (i * 31) + 11;
                                                putChar((char) 11);
                                                break;
                                            default:
                                                this.ch = next2;
                                                throw new JSONException("unclosed.str.lit");
                                        }
                                        break;
                                }
                            } else {
                                char next3 = next();
                                this.ch = next3;
                                char next4 = next();
                                this.ch = next4;
                                int[] iArr = digits;
                                char c2 = (char) ((iArr[next3] * 16) + iArr[next4]);
                                i = (i * 31) + c2;
                                putChar(c2);
                            }
                        }
                    }
                    i = (i * 31) + 12;
                    putChar('\f');
                } else {
                    i = (i * 31) + 39;
                    putChar('\'');
                }
            } else {
                i = (i * 31) + next;
                if (z) {
                    int i5 = this.sp;
                    char[] cArr3 = this.sbuf;
                    if (i5 == cArr3.length) {
                        putChar(next);
                    } else {
                        this.sp = i5 + 1;
                        cArr3[i5] = next;
                    }
                } else {
                    this.sp++;
                }
            }
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final String scanSymbolUnQuoted(SymbolTable symbolTable) {
        boolean[] zArr = com.alibaba.fastjson.util.IOUtils.firstIdentifierFlags;
        int i = this.ch;
        if (i < zArr.length && !zArr[i]) {
            throw new JSONException("illegal identifier : " + this.ch);
        }
        boolean[] zArr2 = com.alibaba.fastjson.util.IOUtils.identifierFlags;
        this.np = this.bp;
        this.sp = 1;
        while (true) {
            char next = next();
            if (next < zArr2.length && !zArr2[next]) {
                break;
            }
            i = (i * 31) + next;
            this.sp++;
        }
        this.ch = charAt(this.bp);
        this.token = 18;
        if (this.sp == 4 && i == 3392903 && charAt(this.np) == 'n' && charAt(this.np + 1) == 'u' && charAt(this.np + 2) == 'l' && charAt(this.np + 3) == 'l') {
            return null;
        }
        return addSymbol(this.np, this.sp, i, symbolTable);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final void scanString() {
        this.np = this.bp;
        this.hasSpecial = false;
        while (true) {
            char next = next();
            if (next == '\"') {
                this.token = 4;
                this.ch = next();
                return;
            }
            if (next == 26) {
                throw new JSONException("unclosed string : " + next);
            }
            if (next == '\\') {
                if (!this.hasSpecial) {
                    this.hasSpecial = true;
                    int i = this.sp;
                    char[] cArr = this.sbuf;
                    if (i >= cArr.length) {
                        int length = cArr.length * 2;
                        if (i <= length) {
                            i = length;
                        }
                        char[] cArr2 = new char[i];
                        System.arraycopy(cArr, 0, cArr2, 0, cArr.length);
                        this.sbuf = cArr2;
                    }
                    copyTo(this.np + 1, this.sp, this.sbuf);
                }
                char next2 = next();
                if (next2 == '\"') {
                    putChar(Typography.quote);
                } else if (next2 != '\'') {
                    if (next2 != 'F') {
                        if (next2 == '\\') {
                            putChar(IOUtils.DIR_SEPARATOR_WINDOWS);
                        } else if (next2 == 'b') {
                            putChar('\b');
                        } else if (next2 != 'f') {
                            if (next2 == 'n') {
                                putChar('\n');
                            } else if (next2 == 'r') {
                                putChar('\r');
                            } else if (next2 != 'x') {
                                switch (next2) {
                                    case '/':
                                        putChar(IOUtils.DIR_SEPARATOR_UNIX);
                                        break;
                                    case '0':
                                        putChar((char) 0);
                                        break;
                                    case '1':
                                        putChar((char) 1);
                                        break;
                                    case '2':
                                        putChar((char) 2);
                                        break;
                                    case '3':
                                        putChar((char) 3);
                                        break;
                                    case '4':
                                        putChar((char) 4);
                                        break;
                                    case '5':
                                        putChar((char) 5);
                                        break;
                                    case '6':
                                        putChar((char) 6);
                                        break;
                                    case '7':
                                        putChar((char) 7);
                                        break;
                                    default:
                                        switch (next2) {
                                            case 't':
                                                putChar('\t');
                                                break;
                                            case AppTypeIdUtil.Drink4GCostControl_1 /* 117 */:
                                                putChar((char) Integer.parseInt(new String(new char[]{next(), next(), next(), next()}), 16));
                                                break;
                                            case 'v':
                                                putChar((char) 11);
                                                break;
                                            default:
                                                this.ch = next2;
                                                throw new JSONException("unclosed string : " + next2);
                                        }
                                        break;
                                }
                            } else {
                                char next3 = next();
                                char next4 = next();
                                int[] iArr = digits;
                                putChar((char) ((iArr[next3] * 16) + iArr[next4]));
                            }
                        }
                    }
                    putChar('\f');
                } else {
                    putChar('\'');
                }
            } else if (this.hasSpecial) {
                int i2 = this.sp;
                char[] cArr3 = this.sbuf;
                if (i2 == cArr3.length) {
                    putChar(next);
                } else {
                    this.sp = i2 + 1;
                    cArr3[i2] = next;
                }
            } else {
                this.sp++;
            }
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final int intValue() {
        int i;
        boolean z;
        int i2 = 0;
        if (this.np == -1) {
            this.np = 0;
        }
        int i3 = this.np;
        int i4 = this.sp + i3;
        if (charAt(i3) == '-') {
            i3++;
            i = Integer.MIN_VALUE;
            z = true;
        } else {
            i = C.RATE_UNSET_INT;
            z = false;
        }
        if (i3 < i4) {
            int i5 = i3 + 1;
            i2 = -digits[charAt(i3)];
            i3 = i5;
        }
        while (i3 < i4) {
            int i6 = i3 + 1;
            char cCharAt = charAt(i3);
            if (cCharAt == 'L' || cCharAt == 'S' || cCharAt == 'B') {
                i3 = i6;
                break;
            }
            int i7 = digits[cCharAt];
            if (i2 < -214748364) {
                throw new NumberFormatException(numberString());
            }
            int i8 = i2 * 10;
            if (i8 < i + i7) {
                throw new NumberFormatException(numberString());
            }
            i2 = i8 - i7;
            i3 = i6;
        }
        if (!z) {
            return -i2;
        }
        if (i3 > this.np + 1) {
            return i2;
        }
        throw new NumberFormatException(numberString());
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.sbuf.length <= 8192) {
            SBUF_REF_LOCAL.set(new SoftReference<>(this.sbuf));
        }
        this.sbuf = null;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final boolean isRef() {
        return this.sp == 4 && charAt(this.np + 1) == '$' && charAt(this.np + 2) == 'r' && charAt(this.np + 3) == 'e' && charAt(this.np + 4) == 'f';
    }

    public int scanType(String str) {
        int i;
        this.matchStat = 0;
        char[] cArr = typeFieldName;
        if (!charArrayCompare(cArr)) {
            return -2;
        }
        int length = this.bp + cArr.length;
        int length2 = str.length();
        for (int i2 = 0; i2 < length2; i2++) {
            if (str.charAt(i2) != charAt(length + i2)) {
                return -1;
            }
        }
        int i3 = length + length2;
        if (charAt(i3) != '\"') {
            return -1;
        }
        int i4 = i3 + 1;
        char cCharAt = charAt(i4);
        this.ch = cCharAt;
        if (cCharAt == ',') {
            int i5 = i3 + 2;
            this.ch = charAt(i5);
            this.bp = i5;
            this.token = 16;
            return 3;
        }
        if (cCharAt == '}') {
            i4 = i3 + 2;
            char cCharAt2 = charAt(i4);
            this.ch = cCharAt2;
            if (cCharAt2 == ',') {
                this.token = 16;
                i = i3 + 3;
                this.ch = charAt(i);
            } else if (cCharAt2 == ']') {
                this.token = 15;
                i = i3 + 3;
                this.ch = charAt(i);
            } else {
                if (cCharAt2 == '}') {
                    this.token = 13;
                    i = i3 + 3;
                    this.ch = charAt(i);
                } else {
                    if (cCharAt2 != 26) {
                        return -1;
                    }
                    this.token = 20;
                }
                this.matchStat = 4;
            }
            i4 = i;
            this.matchStat = 4;
        }
        this.bp = i4;
        return this.matchStat;
    }

    public final boolean matchField(char[] cArr) {
        if (!charArrayCompare(cArr)) {
            return false;
        }
        int length = this.bp + cArr.length;
        this.bp = length;
        char cCharAt = charAt(length);
        this.ch = cCharAt;
        if (cCharAt == '{') {
            next();
            this.token = 12;
            return true;
        }
        if (cCharAt == '[') {
            next();
            this.token = 14;
            return true;
        }
        nextToken();
        return true;
    }

    public String scanFieldString(char[] cArr) {
        this.matchStat = 0;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return stringDefaultValue();
        }
        int length = cArr.length;
        int i = length + 1;
        if (charAt(this.bp + length) != '\"') {
            this.matchStat = -1;
            return stringDefaultValue();
        }
        int iIndexOf = indexOf(Typography.quote, this.bp + cArr.length + 1);
        if (iIndexOf == -1) {
            throw new JSONException("unclosed str");
        }
        int length2 = this.bp + cArr.length + 1;
        String strSubString = subString(length2, iIndexOf - length2);
        int length3 = this.bp + cArr.length;
        do {
            length3++;
            if (length3 >= iIndexOf) {
                int i2 = this.bp;
                int length4 = i + (iIndexOf - ((cArr.length + i2) + 1)) + 1;
                int i3 = length4 + 1;
                char cCharAt = charAt(i2 + length4);
                if (cCharAt == ',') {
                    this.bp += length4;
                    next();
                    this.matchStat = 3;
                    return strSubString;
                }
                if (cCharAt == '}') {
                    char cCharAt2 = charAt(this.bp + i3);
                    if (cCharAt2 == ',') {
                        this.token = 16;
                        this.bp += length4 + 1;
                        next();
                    } else if (cCharAt2 == ']') {
                        this.token = 15;
                        this.bp += length4 + 1;
                        next();
                    } else if (cCharAt2 == '}') {
                        this.token = 13;
                        this.bp += length4 + 1;
                        next();
                    } else {
                        if (cCharAt2 != 26) {
                            this.matchStat = -1;
                            return stringDefaultValue();
                        }
                        this.token = 20;
                        this.bp += length4 + 1;
                        this.ch = (char) 26;
                    }
                    this.matchStat = 4;
                    return strSubString;
                }
                this.matchStat = -1;
                return stringDefaultValue();
            }
        } while (charAt(length3) != '\\');
        this.matchStat = -1;
        return stringDefaultValue();
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public String scanString(char c) {
        this.matchStat = 0;
        char cCharAt = charAt(this.bp);
        if (cCharAt == 'n') {
            if (charAt(this.bp + 1) != 'u' || charAt(this.bp + 2) != 'l' || charAt(this.bp + 3) != 'l') {
                this.matchStat = -1;
                return null;
            }
            if (charAt(this.bp + 4) != c) {
                this.matchStat = -1;
                return null;
            }
            this.bp += 4;
            next();
            this.matchStat = 3;
            return null;
        }
        if (cCharAt != '\"') {
            this.matchStat = -1;
            return stringDefaultValue();
        }
        int i = this.bp + 1;
        int iIndexOf = indexOf(Typography.quote, i);
        if (iIndexOf == -1) {
            throw new JSONException("unclosed str");
        }
        String strSubString = subString(this.bp + 1, iIndexOf - i);
        int i2 = this.bp;
        do {
            i2++;
            if (i2 >= iIndexOf) {
                int i3 = this.bp;
                int i4 = iIndexOf - (i3 + 1);
                if (charAt(i3 + i4 + 2) != c) {
                    this.matchStat = -1;
                    return strSubString;
                }
                this.bp += i4 + 2;
                next();
                this.matchStat = 3;
                return strSubString;
            }
        } while (charAt(i2) != '\\');
        this.matchStat = -1;
        return stringDefaultValue();
    }

    public String scanFieldSymbol(char[] cArr, SymbolTable symbolTable) {
        int i = 0;
        this.matchStat = 0;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return null;
        }
        int length = cArr.length;
        int i2 = length + 1;
        if (charAt(this.bp + length) != '\"') {
            this.matchStat = -1;
            return null;
        }
        while (true) {
            int i3 = i2 + 1;
            char cCharAt = charAt(this.bp + i2);
            if (cCharAt == '\"') {
                int i4 = this.bp;
                int length2 = cArr.length + i4 + 1;
                String strAddSymbol = addSymbol(length2, ((i4 + i3) - length2) - 1, i, symbolTable);
                int i5 = i2 + 2;
                char cCharAt2 = charAt(this.bp + i3);
                if (cCharAt2 == ',') {
                    this.bp += i2 + 1;
                    next();
                    this.matchStat = 3;
                    return strAddSymbol;
                }
                if (cCharAt2 != '}') {
                    this.matchStat = -1;
                    return null;
                }
                char cCharAt3 = charAt(this.bp + i5);
                if (cCharAt3 == ',') {
                    this.token = 16;
                    this.bp += i2 + 2;
                    next();
                } else if (cCharAt3 == ']') {
                    this.token = 15;
                    this.bp += i2 + 2;
                    next();
                } else if (cCharAt3 == '}') {
                    this.token = 13;
                    this.bp += i2 + 2;
                    next();
                } else {
                    if (cCharAt3 != 26) {
                        this.matchStat = -1;
                        return null;
                    }
                    this.token = 20;
                    this.bp += i2 + 2;
                    this.ch = (char) 26;
                }
                this.matchStat = 4;
                return strAddSymbol;
            }
            i = (i * 31) + cCharAt;
            if (cCharAt == '\\') {
                this.matchStat = -1;
                return null;
            }
            i2 = i3;
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public Enum<?> scanEnum(Class<?> cls, SymbolTable symbolTable, char c) {
        String strScanSymbolWithSeperator = scanSymbolWithSeperator(symbolTable, c);
        if (strScanSymbolWithSeperator == null) {
            return null;
        }
        return Enum.valueOf(cls, strScanSymbolWithSeperator);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public String scanSymbolWithSeperator(SymbolTable symbolTable, char c) {
        int i = 0;
        this.matchStat = 0;
        char cCharAt = charAt(this.bp);
        if (cCharAt == 'n') {
            if (charAt(this.bp + 1) != 'u' || charAt(this.bp + 2) != 'l' || charAt(this.bp + 3) != 'l') {
                this.matchStat = -1;
                return null;
            }
            if (charAt(this.bp + 4) != c) {
                this.matchStat = -1;
                return null;
            }
            this.bp += 4;
            next();
            this.matchStat = 3;
            return null;
        }
        if (cCharAt != '\"') {
            this.matchStat = -1;
            return null;
        }
        int i2 = 1;
        while (true) {
            int i3 = i2 + 1;
            char cCharAt2 = charAt(this.bp + i2);
            if (cCharAt2 == '\"') {
                int i4 = this.bp;
                int i5 = i4 + 1;
                String strAddSymbol = addSymbol(i5, ((i4 + i3) - i5) - 1, i, symbolTable);
                if (charAt(this.bp + i3) != c) {
                    this.matchStat = -1;
                    return strAddSymbol;
                }
                this.bp += i2 + 1;
                next();
                this.matchStat = 3;
                return strAddSymbol;
            }
            i = (i * 31) + cCharAt2;
            if (cCharAt2 == '\\') {
                this.matchStat = -1;
                return null;
            }
            i2 = i3;
        }
    }

    public Collection<String> scanFieldStringArray(char[] cArr, Class<?> cls) {
        Collection<String> arrayList;
        int i;
        this.matchStat = 0;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return null;
        }
        if (cls.isAssignableFrom(HashSet.class)) {
            arrayList = new HashSet<>();
        } else if (cls.isAssignableFrom(ArrayList.class)) {
            arrayList = new ArrayList<>();
        } else {
            try {
                arrayList = (Collection) cls.newInstance();
            } catch (Exception e) {
                throw new JSONException(e.getMessage(), e);
            }
        }
        int length = cArr.length;
        int i2 = length + 1;
        if (charAt(this.bp + length) != '[') {
            this.matchStat = -1;
            return null;
        }
        int i3 = length + 2;
        char cCharAt = charAt(this.bp + i2);
        while (cCharAt == '\"') {
            int i4 = i3;
            while (true) {
                i = i4 + 1;
                char cCharAt2 = charAt(this.bp + i4);
                if (cCharAt2 == '\"') {
                    break;
                }
                if (cCharAt2 == '\\') {
                    this.matchStat = -1;
                    return null;
                }
                i4 = i;
            }
            int i5 = this.bp;
            int i6 = i3 + i5;
            arrayList.add(subString(i6, ((i5 + i) - i6) - 1));
            int i7 = i4 + 2;
            char cCharAt3 = charAt(this.bp + i);
            if (cCharAt3 != ',') {
                if (cCharAt3 != ']') {
                    this.matchStat = -1;
                    return null;
                }
                int i8 = i4 + 3;
                char cCharAt4 = charAt(this.bp + i7);
                if (cCharAt4 == ',') {
                    this.bp += i4 + 2;
                    next();
                    this.matchStat = 3;
                    return arrayList;
                }
                if (cCharAt4 != '}') {
                    this.matchStat = -1;
                    return null;
                }
                char cCharAt5 = charAt(this.bp + i8);
                if (cCharAt5 == ',') {
                    this.token = 16;
                    this.bp += i4 + 3;
                    next();
                } else if (cCharAt5 == ']') {
                    this.token = 15;
                    this.bp += i4 + 3;
                    next();
                } else if (cCharAt5 == '}') {
                    this.token = 13;
                    this.bp += i4 + 3;
                    next();
                } else {
                    if (cCharAt5 != 26) {
                        this.matchStat = -1;
                        return null;
                    }
                    this.bp += i4 + 3;
                    this.token = 20;
                    this.ch = (char) 26;
                }
                this.matchStat = 4;
                return arrayList;
            }
            int i9 = i4 + 3;
            cCharAt = charAt(this.bp + i7);
            i3 = i9;
        }
        this.matchStat = -1;
        return null;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public Collection<String> scanStringArray(Class<?> cls, char c) {
        Collection<String> arrayList;
        int i;
        char cCharAt;
        this.matchStat = 0;
        if (cls.isAssignableFrom(HashSet.class)) {
            arrayList = new HashSet<>();
        } else if (cls.isAssignableFrom(ArrayList.class)) {
            arrayList = new ArrayList<>();
        } else {
            try {
                arrayList = (Collection) cls.newInstance();
            } catch (Exception e) {
                throw new JSONException(e.getMessage(), e);
            }
        }
        char cCharAt2 = charAt(this.bp);
        if (cCharAt2 == 'n') {
            if (charAt(this.bp + 1) != 'u' || charAt(this.bp + 2) != 'l' || charAt(this.bp + 3) != 'l') {
                this.matchStat = -1;
                return null;
            }
            if (charAt(this.bp + 4) != c) {
                this.matchStat = -1;
                return null;
            }
            this.bp += 4;
            next();
            this.matchStat = 3;
            return null;
        }
        if (cCharAt2 != '[') {
            this.matchStat = -1;
            return null;
        }
        char cCharAt3 = charAt(this.bp + 1);
        int i2 = 2;
        while (true) {
            if (cCharAt3 == 'n' && charAt(this.bp + i2) == 'u' && charAt(this.bp + i2 + 1) == 'l' && charAt(this.bp + i2 + 2) == 'l') {
                int i3 = i2 + 3;
                i = i2 + 4;
                cCharAt = charAt(this.bp + i3);
            } else {
                if (cCharAt3 != '\"') {
                    this.matchStat = -1;
                    return null;
                }
                int i4 = i2;
                while (true) {
                    int i5 = i4 + 1;
                    char cCharAt4 = charAt(this.bp + i4);
                    if (cCharAt4 == '\"') {
                        int i6 = this.bp;
                        int i7 = i2 + i6;
                        arrayList.add(subString(i7, ((i6 + i5) - i7) - 1));
                        i = i4 + 2;
                        cCharAt = charAt(this.bp + i5);
                        break;
                    }
                    if (cCharAt4 == '\\') {
                        this.matchStat = -1;
                        return null;
                    }
                    i4 = i5;
                }
            }
            if (cCharAt != ',') {
                if (cCharAt != ']') {
                    this.matchStat = -1;
                    return null;
                }
                if (charAt(this.bp + i) != c) {
                    this.matchStat = -1;
                    return arrayList;
                }
                this.bp += i;
                next();
                this.matchStat = 3;
                return arrayList;
            }
            cCharAt3 = charAt(this.bp + i);
            i2 = i + 1;
        }
    }

    public int scanFieldInt(char[] cArr) {
        int i;
        char cCharAt;
        this.matchStat = 0;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return 0;
        }
        int length = cArr.length;
        int i2 = length + 1;
        char cCharAt2 = charAt(this.bp + length);
        if (cCharAt2 < '0' || cCharAt2 > '9') {
            this.matchStat = -1;
            return 0;
        }
        int i3 = digits[cCharAt2];
        while (true) {
            i = i2 + 1;
            cCharAt = charAt(this.bp + i2);
            if (cCharAt < '0' || cCharAt > '9') {
                break;
            }
            i3 = (i3 * 10) + digits[cCharAt];
            i2 = i;
        }
        if (cCharAt == '.') {
            this.matchStat = -1;
            return 0;
        }
        if (i3 < 0) {
            this.matchStat = -1;
            return 0;
        }
        if (cCharAt == ',') {
            this.bp += i2;
            next();
            this.matchStat = 3;
            this.token = 16;
            return i3;
        }
        if (cCharAt != '}') {
            this.matchStat = -1;
            return 0;
        }
        char cCharAt3 = charAt(this.bp + i);
        if (cCharAt3 == ',') {
            this.token = 16;
            this.bp += i2 + 1;
            next();
        } else if (cCharAt3 == ']') {
            this.token = 15;
            this.bp += i2 + 1;
            next();
        } else if (cCharAt3 == '}') {
            this.token = 13;
            this.bp += i2 + 1;
            next();
        } else {
            if (cCharAt3 != 26) {
                this.matchStat = -1;
                return 0;
            }
            this.token = 20;
            this.bp += i2 + 1;
            this.ch = (char) 26;
        }
        this.matchStat = 4;
        return i3;
    }

    public boolean scanBoolean(char c) {
        boolean z = false;
        this.matchStat = 0;
        char cCharAt = charAt(this.bp);
        int i = 5;
        if (cCharAt == 't') {
            if (charAt(this.bp + 1) != 'r' || charAt(this.bp + 2) != 'u' || charAt(this.bp + 3) != 'e') {
                this.matchStat = -1;
                return false;
            }
            cCharAt = charAt(this.bp + 4);
            z = true;
        } else if (cCharAt != 'f') {
            i = 1;
        } else {
            if (charAt(this.bp + 1) != 'a' || charAt(this.bp + 2) != 'l' || charAt(this.bp + 3) != 's' || charAt(this.bp + 4) != 'e') {
                this.matchStat = -1;
                return false;
            }
            cCharAt = charAt(this.bp + 5);
            i = 6;
        }
        if (cCharAt != c) {
            this.matchStat = -1;
            return z;
        }
        this.bp += i - 1;
        next();
        this.matchStat = 3;
        return z;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public int scanInt(char c) {
        char cCharAt;
        this.matchStat = 0;
        char cCharAt2 = charAt(this.bp);
        if (cCharAt2 < '0' || cCharAt2 > '9') {
            this.matchStat = -1;
            return 0;
        }
        int i = digits[cCharAt2];
        int i2 = 1;
        while (true) {
            int i3 = i2 + 1;
            cCharAt = charAt(this.bp + i2);
            if (cCharAt < '0' || cCharAt > '9') {
                break;
            }
            i = (i * 10) + digits[cCharAt];
            i2 = i3;
        }
        if (cCharAt == '.') {
            this.matchStat = -1;
            return 0;
        }
        if (i < 0) {
            this.matchStat = -1;
            return 0;
        }
        if (cCharAt != c) {
            this.matchStat = -1;
            return i;
        }
        this.bp += i2;
        next();
        this.matchStat = 3;
        this.token = 16;
        return i;
    }

    public boolean scanFieldBoolean(char[] cArr) {
        int i;
        boolean z;
        this.matchStat = 0;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return false;
        }
        int length = cArr.length;
        int i2 = length + 1;
        char cCharAt = charAt(this.bp + length);
        if (cCharAt == 't') {
            int i3 = length + 2;
            if (charAt(this.bp + i2) != 'r') {
                this.matchStat = -1;
                return false;
            }
            int i4 = length + 3;
            if (charAt(this.bp + i3) != 'u') {
                this.matchStat = -1;
                return false;
            }
            i = length + 4;
            if (charAt(this.bp + i4) != 'e') {
                this.matchStat = -1;
                return false;
            }
            z = true;
        } else {
            if (cCharAt != 'f') {
                this.matchStat = -1;
                return false;
            }
            int i5 = length + 2;
            if (charAt(this.bp + i2) != 'a') {
                this.matchStat = -1;
                return false;
            }
            int i6 = length + 3;
            if (charAt(this.bp + i5) != 'l') {
                this.matchStat = -1;
                return false;
            }
            int i7 = length + 4;
            if (charAt(this.bp + i6) != 's') {
                this.matchStat = -1;
                return false;
            }
            i = length + 5;
            if (charAt(this.bp + i7) != 'e') {
                this.matchStat = -1;
                return false;
            }
            z = false;
        }
        int i8 = i + 1;
        char cCharAt2 = charAt(this.bp + i);
        if (cCharAt2 == ',') {
            this.bp += i;
            next();
            this.matchStat = 3;
            this.token = 16;
            return z;
        }
        if (cCharAt2 != '}') {
            this.matchStat = -1;
            return false;
        }
        char cCharAt3 = charAt(this.bp + i8);
        if (cCharAt3 == ',') {
            this.token = 16;
            this.bp += i + 1;
            next();
        } else if (cCharAt3 == ']') {
            this.token = 15;
            this.bp += i + 1;
            next();
        } else if (cCharAt3 == '}') {
            this.token = 13;
            this.bp += i + 1;
            next();
        } else {
            if (cCharAt3 != 26) {
                this.matchStat = -1;
                return false;
            }
            this.token = 20;
            this.bp += i + 1;
            this.ch = (char) 26;
        }
        this.matchStat = 4;
        return z;
    }

    public long scanFieldLong(char[] cArr) {
        int i;
        char cCharAt;
        this.matchStat = 0;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return 0L;
        }
        int length = cArr.length;
        int i2 = length + 1;
        char cCharAt2 = charAt(this.bp + length);
        if (cCharAt2 < '0' || cCharAt2 > '9') {
            this.matchStat = -1;
            return 0L;
        }
        long j = digits[cCharAt2];
        while (true) {
            i = i2 + 1;
            cCharAt = charAt(this.bp + i2);
            if (cCharAt < '0' || cCharAt > '9') {
                break;
            }
            j = (j * 10) + ((long) digits[cCharAt]);
            i2 = i;
        }
        if (cCharAt == '.') {
            this.matchStat = -1;
            return 0L;
        }
        if (j < 0) {
            this.matchStat = -1;
            return 0L;
        }
        if (cCharAt == ',') {
            this.bp += i2;
            next();
            this.matchStat = 3;
            this.token = 16;
            return j;
        }
        if (cCharAt != '}') {
            this.matchStat = -1;
            return 0L;
        }
        char cCharAt3 = charAt(this.bp + i);
        if (cCharAt3 == ',') {
            this.token = 16;
            this.bp += i2 + 1;
            next();
        } else if (cCharAt3 == ']') {
            this.token = 15;
            this.bp += i2 + 1;
            next();
        } else if (cCharAt3 == '}') {
            this.token = 13;
            this.bp += i2 + 1;
            next();
        } else {
            if (cCharAt3 != 26) {
                this.matchStat = -1;
                return 0L;
            }
            this.token = 20;
            this.bp += i2 + 1;
            this.ch = (char) 26;
        }
        this.matchStat = 4;
        return j;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public long scanLong(char c) {
        char cCharAt;
        this.matchStat = 0;
        char cCharAt2 = charAt(this.bp);
        if (cCharAt2 < '0' || cCharAt2 > '9') {
            this.matchStat = -1;
            return 0L;
        }
        long j = digits[cCharAt2];
        int i = 1;
        while (true) {
            int i2 = i + 1;
            cCharAt = charAt(this.bp + i);
            if (cCharAt < '0' || cCharAt > '9') {
                break;
            }
            j = (j * 10) + ((long) digits[cCharAt]);
            i = i2;
        }
        if (cCharAt == '.') {
            this.matchStat = -1;
            return 0L;
        }
        if (j < 0) {
            this.matchStat = -1;
            return 0L;
        }
        if (cCharAt != c) {
            this.matchStat = -1;
            return j;
        }
        this.bp += i;
        next();
        this.matchStat = 3;
        this.token = 16;
        return j;
    }

    public final float scanFieldFloat(char[] cArr) {
        int i;
        char cCharAt;
        this.matchStat = 0;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return 0.0f;
        }
        int length = cArr.length;
        int i2 = length + 1;
        char cCharAt2 = charAt(this.bp + length);
        if (cCharAt2 < '0' || cCharAt2 > '9') {
            this.matchStat = -1;
            return 0.0f;
        }
        while (true) {
            i = i2 + 1;
            cCharAt = charAt(this.bp + i2);
            if (cCharAt < '0' || cCharAt > '9') {
                break;
            }
            i2 = i;
        }
        if (cCharAt == '.') {
            int i3 = i2 + 2;
            char cCharAt3 = charAt(this.bp + i);
            if (cCharAt3 < '0' || cCharAt3 > '9') {
                this.matchStat = -1;
                return 0.0f;
            }
            while (true) {
                i = i3 + 1;
                cCharAt = charAt(this.bp + i3);
                if (cCharAt < '0' || cCharAt > '9') {
                    break;
                }
                i3 = i;
            }
        }
        int i4 = this.bp;
        int length2 = cArr.length + i4;
        float f = Float.parseFloat(subString(length2, ((i4 + i) - length2) - 1));
        if (cCharAt == ',') {
            this.bp += i - 1;
            next();
            this.matchStat = 3;
            this.token = 16;
            return f;
        }
        if (cCharAt != '}') {
            this.matchStat = -1;
            return 0.0f;
        }
        char cCharAt4 = charAt(this.bp + i);
        if (cCharAt4 == ',') {
            this.token = 16;
            this.bp += i;
            next();
        } else if (cCharAt4 == ']') {
            this.token = 15;
            this.bp += i;
            next();
        } else if (cCharAt4 == '}') {
            this.token = 13;
            this.bp += i;
            next();
        } else {
            if (cCharAt4 != 26) {
                this.matchStat = -1;
                return 0.0f;
            }
            this.bp += i;
            this.token = 20;
            this.ch = (char) 26;
        }
        this.matchStat = 4;
        return f;
    }

    public final float scanFloat(char c) {
        int i;
        char cCharAt;
        this.matchStat = 0;
        char cCharAt2 = charAt(this.bp);
        if (cCharAt2 < '0' || cCharAt2 > '9') {
            this.matchStat = -1;
            return 0.0f;
        }
        int i2 = 1;
        while (true) {
            i = i2 + 1;
            cCharAt = charAt(this.bp + i2);
            if (cCharAt < '0' || cCharAt > '9') {
                break;
            }
            i2 = i;
        }
        if (cCharAt == '.') {
            int i3 = i2 + 2;
            char cCharAt3 = charAt(this.bp + i);
            if (cCharAt3 < '0' || cCharAt3 > '9') {
                this.matchStat = -1;
                return 0.0f;
            }
            while (true) {
                i = i3 + 1;
                cCharAt = charAt(this.bp + i3);
                if (cCharAt < '0' || cCharAt > '9') {
                    break;
                }
                i3 = i;
            }
        }
        int i4 = this.bp;
        float f = Float.parseFloat(subString(i4, ((i4 + i) - i4) - 1));
        if (cCharAt != c) {
            this.matchStat = -1;
            return f;
        }
        this.bp += i - 1;
        next();
        this.matchStat = 3;
        this.token = 16;
        return f;
    }

    /* JADX WARN: Code duplicated, block: B:37:0x007b A[ADDED_TO_REGION] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x007d -> B:34:0x006e). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final double scanFieldDouble(char[] r10) {
        /*
            Method dump skipped, instruction units count: 257
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexerBase.scanFieldDouble(char[]):double");
    }

    /* JADX WARN: Code duplicated, block: B:35:0x0071 A[ADDED_TO_REGION] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x0073 -> B:32:0x0063). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final double scanFieldDouble(char r11) {
        /*
            r10 = this;
            r0 = 0
            r10.matchStat = r0
            int r0 = r10.bp
            char r0 = r10.charAt(r0)
            r1 = 0
            r3 = -1
            r4 = 48
            if (r0 < r4) goto La1
            r5 = 57
            if (r0 > r5) goto La1
            r0 = 1
            r6 = r0
        L16:
            int r7 = r10.bp
            int r8 = r6 + 1
            int r7 = r7 + r6
            char r7 = r10.charAt(r7)
            if (r7 < r4) goto L25
            if (r7 > r5) goto L25
            r6 = r8
            goto L16
        L25:
            r9 = 46
            if (r7 != r9) goto L48
            int r7 = r10.bp
            int r6 = r6 + 2
            int r7 = r7 + r8
            char r7 = r10.charAt(r7)
            if (r7 < r4) goto L45
            if (r7 > r5) goto L45
        L36:
            int r1 = r10.bp
            int r8 = r6 + 1
            int r1 = r1 + r6
            char r7 = r10.charAt(r1)
            if (r7 < r4) goto L48
            if (r7 > r5) goto L48
            r6 = r8
            goto L36
        L45:
            r10.matchStat = r3
            return r1
        L48:
            r1 = 101(0x65, float:1.42E-43)
            if (r7 == r1) goto L50
            r1 = 69
            if (r7 != r1) goto L7d
        L50:
            int r1 = r10.bp
            int r2 = r8 + 1
            int r1 = r1 + r8
            char r1 = r10.charAt(r1)
            r6 = 43
            if (r1 == r6) goto L65
            r6 = 45
            if (r1 != r6) goto L62
            goto L65
        L62:
            r7 = r1
        L63:
            r8 = r2
            goto L6f
        L65:
            int r1 = r10.bp
            int r8 = r8 + 2
            int r1 = r1 + r2
            char r1 = r10.charAt(r1)
            r7 = r1
        L6f:
            if (r7 < r4) goto L7d
            if (r7 > r5) goto L7d
            int r1 = r10.bp
            int r2 = r8 + 1
            int r1 = r1 + r8
            char r7 = r10.charAt(r1)
            goto L63
        L7d:
            int r1 = r10.bp
            int r2 = r1 + r8
            int r2 = r2 - r1
            int r2 = r2 - r0
            java.lang.String r1 = r10.subString(r1, r2)
            double r1 = java.lang.Double.parseDouble(r1)
            if (r7 != r11) goto L9e
            int r11 = r10.bp
            int r8 = r8 - r0
            int r11 = r11 + r8
            r10.bp = r11
            r10.next()
            r11 = 3
            r10.matchStat = r11
            r11 = 16
            r10.token = r11
            return r1
        L9e:
            r10.matchStat = r3
            return r1
        La1:
            r10.matchStat = r3
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexerBase.scanFieldDouble(char):double");
    }

    public final void scanTrue() {
        if (this.ch != 't') {
            throw new JSONException("error parse true");
        }
        next();
        if (this.ch != 'r') {
            throw new JSONException("error parse true");
        }
        next();
        if (this.ch != 'u') {
            throw new JSONException("error parse true");
        }
        next();
        if (this.ch != 'e') {
            throw new JSONException("error parse true");
        }
        next();
        char c = this.ch;
        if (c != ' ' && c != ',' && c != '}' && c != ']' && c != '\n' && c != '\r' && c != '\t' && c != 26 && c != '\f' && c != '\b' && c != ':') {
            throw new JSONException("scan true error");
        }
        this.token = 6;
    }

    public final void scanTreeSet() {
        if (this.ch != 'T') {
            throw new JSONException("error parse true");
        }
        next();
        if (this.ch != 'r') {
            throw new JSONException("error parse true");
        }
        next();
        if (this.ch != 'e') {
            throw new JSONException("error parse true");
        }
        next();
        if (this.ch != 'e') {
            throw new JSONException("error parse true");
        }
        next();
        if (this.ch != 'S') {
            throw new JSONException("error parse true");
        }
        next();
        if (this.ch != 'e') {
            throw new JSONException("error parse true");
        }
        next();
        if (this.ch != 't') {
            throw new JSONException("error parse true");
        }
        next();
        char c = this.ch;
        if (c != ' ' && c != '\n' && c != '\r' && c != '\t' && c != '\f' && c != '\b' && c != '[' && c != '(') {
            throw new JSONException("scan set error");
        }
        this.token = 22;
    }

    public final void scanNullOrNew() {
        if (this.ch != 'n') {
            throw new JSONException("error parse null or new");
        }
        next();
        char c = this.ch;
        if (c != 'u') {
            if (c != 'e') {
                throw new JSONException("error parse e");
            }
            next();
            if (this.ch != 'w') {
                throw new JSONException("error parse w");
            }
            next();
            char c2 = this.ch;
            if (c2 != ' ' && c2 != ',' && c2 != '}' && c2 != ']' && c2 != '\n' && c2 != '\r' && c2 != '\t' && c2 != 26 && c2 != '\f' && c2 != '\b') {
                throw new JSONException("scan true error");
            }
            this.token = 9;
            return;
        }
        next();
        if (this.ch != 'l') {
            throw new JSONException("error parse l");
        }
        next();
        if (this.ch != 'l') {
            throw new JSONException("error parse l");
        }
        next();
        char c3 = this.ch;
        if (c3 != ' ' && c3 != ',' && c3 != '}' && c3 != ']' && c3 != '\n' && c3 != '\r' && c3 != '\t' && c3 != 26 && c3 != '\f' && c3 != '\b') {
            throw new JSONException("scan true error");
        }
        this.token = 8;
    }

    public final void scanNULL() {
        if (this.ch != 'N') {
            throw new JSONException("error parse NULL");
        }
        next();
        if (this.ch == 'U') {
            next();
            if (this.ch != 'L') {
                throw new JSONException("error parse U");
            }
            next();
            if (this.ch != 'L') {
                throw new JSONException("error parse NULL");
            }
            next();
            char c = this.ch;
            if (c != ' ' && c != ',' && c != '}' && c != ']' && c != '\n' && c != '\r' && c != '\t' && c != 26 && c != '\f' && c != '\b') {
                throw new JSONException("scan NULL error");
            }
            this.token = 8;
        }
    }

    public final void scanUndefined() {
        if (this.ch != 'u') {
            throw new JSONException("error parse false");
        }
        next();
        if (this.ch != 'n') {
            throw new JSONException("error parse false");
        }
        next();
        if (this.ch != 'd') {
            throw new JSONException("error parse false");
        }
        next();
        if (this.ch != 'e') {
            throw new JSONException("error parse false");
        }
        next();
        if (this.ch != 'f') {
            throw new JSONException("error parse false");
        }
        next();
        if (this.ch != 'i') {
            throw new JSONException("error parse false");
        }
        next();
        if (this.ch != 'n') {
            throw new JSONException("error parse false");
        }
        next();
        if (this.ch != 'e') {
            throw new JSONException("error parse false");
        }
        next();
        if (this.ch != 'd') {
            throw new JSONException("error parse false");
        }
        next();
        char c = this.ch;
        if (c != ' ' && c != ',' && c != '}' && c != ']' && c != '\n' && c != '\r' && c != '\t' && c != 26 && c != '\f' && c != '\b') {
            throw new JSONException("scan false error");
        }
        this.token = 23;
    }

    public final void scanFalse() {
        if (this.ch != 'f') {
            throw new JSONException("error parse false");
        }
        next();
        if (this.ch != 'a') {
            throw new JSONException("error parse false");
        }
        next();
        if (this.ch != 'l') {
            throw new JSONException("error parse false");
        }
        next();
        if (this.ch != 's') {
            throw new JSONException("error parse false");
        }
        next();
        if (this.ch != 'e') {
            throw new JSONException("error parse false");
        }
        next();
        char c = this.ch;
        if (c != ' ' && c != ',' && c != '}' && c != ']' && c != '\n' && c != '\r' && c != '\t' && c != 26 && c != '\f' && c != '\b' && c != ':') {
            throw new JSONException("scan false error");
        }
        this.token = 7;
    }

    public final void scanIdent() {
        this.np = this.bp - 1;
        this.hasSpecial = false;
        do {
            this.sp++;
            next();
        } while (Character.isLetterOrDigit(this.ch));
        Integer num = this.keywods.get(stringVal());
        if (num != null) {
            this.token = num.intValue();
        } else {
            this.token = 18;
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final boolean isBlankInput() {
        int i = 0;
        while (true) {
            char cCharAt = charAt(i);
            if (cCharAt == 26) {
                return true;
            }
            if (!isWhitespace(cCharAt)) {
                return false;
            }
            i++;
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final void skipWhitespace() {
        while (this.ch < com.alibaba.fastjson.util.IOUtils.whitespaceFlags.length && com.alibaba.fastjson.util.IOUtils.whitespaceFlags[this.ch]) {
            next();
        }
    }

    private final void scanStringSingleQuote() {
        this.np = this.bp;
        this.hasSpecial = false;
        while (true) {
            char next = next();
            if (next == '\'') {
                this.token = 4;
                next();
                return;
            }
            if (next == 26) {
                throw new JSONException("unclosed single-quote string");
            }
            if (next == '\\') {
                if (!this.hasSpecial) {
                    this.hasSpecial = true;
                    int i = this.sp;
                    char[] cArr = this.sbuf;
                    if (i > cArr.length) {
                        char[] cArr2 = new char[i * 2];
                        System.arraycopy(cArr, 0, cArr2, 0, cArr.length);
                        this.sbuf = cArr2;
                    }
                    copyTo(this.np + 1, this.sp, this.sbuf);
                }
                char next2 = next();
                if (next2 == '\"') {
                    putChar(Typography.quote);
                } else if (next2 != '\'') {
                    if (next2 != 'F') {
                        if (next2 == '\\') {
                            putChar(IOUtils.DIR_SEPARATOR_WINDOWS);
                        } else if (next2 == 'b') {
                            putChar('\b');
                        } else if (next2 != 'f') {
                            if (next2 == 'n') {
                                putChar('\n');
                            } else if (next2 == 'r') {
                                putChar('\r');
                            } else if (next2 != 'x') {
                                switch (next2) {
                                    case '/':
                                        putChar(IOUtils.DIR_SEPARATOR_UNIX);
                                        break;
                                    case '0':
                                        putChar((char) 0);
                                        break;
                                    case '1':
                                        putChar((char) 1);
                                        break;
                                    case '2':
                                        putChar((char) 2);
                                        break;
                                    case '3':
                                        putChar((char) 3);
                                        break;
                                    case '4':
                                        putChar((char) 4);
                                        break;
                                    case '5':
                                        putChar((char) 5);
                                        break;
                                    case '6':
                                        putChar((char) 6);
                                        break;
                                    case '7':
                                        putChar((char) 7);
                                        break;
                                    default:
                                        switch (next2) {
                                            case 't':
                                                putChar('\t');
                                                break;
                                            case AppTypeIdUtil.Drink4GCostControl_1 /* 117 */:
                                                putChar((char) Integer.parseInt(new String(new char[]{next(), next(), next(), next()}), 16));
                                                break;
                                            case 'v':
                                                putChar((char) 11);
                                                break;
                                            default:
                                                this.ch = next2;
                                                throw new JSONException("unclosed single-quote string");
                                        }
                                        break;
                                }
                            } else {
                                char next3 = next();
                                char next4 = next();
                                int[] iArr = digits;
                                putChar((char) ((iArr[next3] * 16) + iArr[next4]));
                            }
                        }
                    }
                    putChar('\f');
                } else {
                    putChar('\'');
                }
            } else if (this.hasSpecial) {
                int i2 = this.sp;
                char[] cArr3 = this.sbuf;
                if (i2 == cArr3.length) {
                    putChar(next);
                } else {
                    this.sp = i2 + 1;
                    cArr3[i2] = next;
                }
            } else {
                this.sp++;
            }
        }
    }

    public final void scanSet() {
        if (this.ch != 'S') {
            throw new JSONException("error parse true");
        }
        next();
        if (this.ch != 'e') {
            throw new JSONException("error parse true");
        }
        next();
        if (this.ch != 't') {
            throw new JSONException("error parse true");
        }
        next();
        char c = this.ch;
        if (c != ' ' && c != '\n' && c != '\r' && c != '\t' && c != '\f' && c != '\b' && c != '[' && c != '(') {
            throw new JSONException("scan set error");
        }
        this.token = 21;
    }

    protected final void putChar(char c) {
        int i = this.sp;
        char[] cArr = this.sbuf;
        if (i == cArr.length) {
            char[] cArr2 = new char[cArr.length * 2];
            System.arraycopy(cArr, 0, cArr2, 0, cArr.length);
            this.sbuf = cArr2;
        }
        char[] cArr3 = this.sbuf;
        int i2 = this.sp;
        this.sp = i2 + 1;
        cArr3[i2] = c;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final void scanNumber() {
        char c;
        boolean z;
        char c2;
        this.np = this.bp;
        if (this.ch == '-') {
            this.sp++;
            next();
        }
        while (true) {
            c = this.ch;
            if (c < '0' || c > '9') {
                break;
            }
            this.sp++;
            next();
        }
        if (c == '.') {
            this.sp++;
            next();
            while (true) {
                char c3 = this.ch;
                if (c3 < '0' || c3 > '9') {
                    break;
                }
                this.sp++;
                next();
            }
            z = true;
        } else {
            z = false;
        }
        char c4 = this.ch;
        if (c4 != 'L' && c4 != 'S' && c4 != 'B') {
            if (c4 == 'F' || c4 == 'D') {
                this.sp++;
                next();
            } else if (c4 == 'e' || c4 == 'E') {
                this.sp++;
                next();
                char c5 = this.ch;
                if (c5 == '+' || c5 == '-') {
                    this.sp++;
                    next();
                }
                while (true) {
                    c2 = this.ch;
                    if (c2 < '0' || c2 > '9') {
                        break;
                    }
                    this.sp++;
                    next();
                }
                if (c2 == 'D' || c2 == 'F') {
                    this.sp++;
                    next();
                }
            }
            this.token = 3;
        }
        this.sp++;
        next();
        if (!z) {
            this.token = 2;
            return;
        }
        this.token = 3;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final long longValue() throws NumberFormatException {
        boolean z;
        long j;
        long j2;
        int i = this.np;
        int i2 = this.sp + i;
        if (charAt(i) == '-') {
            i++;
            j = Long.MIN_VALUE;
            z = true;
        } else {
            z = false;
            j = -9223372036854775807L;
        }
        if (i < i2) {
            j2 = -digits[charAt(i)];
            i++;
        } else {
            j2 = 0;
        }
        while (i < i2) {
            int i3 = i + 1;
            char cCharAt = charAt(i);
            if (cCharAt == 'L' || cCharAt == 'S' || cCharAt == 'B') {
                i = i3;
                break;
            }
            int i4 = digits[cCharAt];
            if (j2 < BufferKt.OVERFLOW_ZONE) {
                throw new NumberFormatException(numberString());
            }
            long j3 = j2 * 10;
            long j4 = i4;
            if (j3 < j + j4) {
                throw new NumberFormatException(numberString());
            }
            j2 = j3 - j4;
            i = i3;
        }
        if (!z) {
            return -j2;
        }
        if (i > this.np + 1) {
            return j2;
        }
        throw new NumberFormatException(numberString());
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final Number decimalValue(boolean z) {
        char cCharAt = charAt((this.np + this.sp) - 1);
        if (cCharAt == 'F') {
            return Float.valueOf(Float.parseFloat(numberString()));
        }
        if (cCharAt == 'D') {
            return Double.valueOf(Double.parseDouble(numberString()));
        }
        if (z) {
            return decimalValue();
        }
        return Double.valueOf(doubleValue());
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final BigDecimal decimalValue() {
        return new BigDecimal(numberString());
    }
}
