package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.util.Base64;
import com.alibaba.fastjson.util.IOUtils;
import com.huawei.hms.ads.ez;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.lang.ref.SoftReference;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import kotlin.text.Typography;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public final class SerializeWriter extends Writer {
    private static final ThreadLocal<SoftReference<char[]>> bufLocal = new ThreadLocal<>();
    protected char[] buf;
    protected int count;
    private int features;
    private final Writer writer;

    public void reset() {
        this.count = 0;
    }

    public int size() {
        return this.count;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SerializeWriter() {
        this((Writer) null);
    }

    public SerializeWriter(Writer writer) {
        this.writer = writer;
        this.features = JSON.DEFAULT_GENERATE_FEATURE;
        ThreadLocal<SoftReference<char[]>> threadLocal = bufLocal;
        SoftReference<char[]> softReference = threadLocal.get();
        if (softReference != null) {
            this.buf = softReference.get();
            threadLocal.set(null);
        }
        if (this.buf == null) {
            this.buf = new char[1024];
        }
    }

    public SerializeWriter(SerializerFeature... serializerFeatureArr) {
        this((Writer) null, serializerFeatureArr);
    }

    public SerializeWriter(Writer writer, SerializerFeature... serializerFeatureArr) {
        this.writer = writer;
        ThreadLocal<SoftReference<char[]>> threadLocal = bufLocal;
        SoftReference<char[]> softReference = threadLocal.get();
        if (softReference != null) {
            this.buf = softReference.get();
            threadLocal.set(null);
        }
        if (this.buf == null) {
            this.buf = new char[1024];
        }
        int mask = 0;
        for (SerializerFeature serializerFeature : serializerFeatureArr) {
            mask |= serializerFeature.getMask();
        }
        this.features = mask;
    }

    public int getBufferLength() {
        return this.buf.length;
    }

    public SerializeWriter(int i) {
        this((Writer) null, i);
    }

    public SerializeWriter(Writer writer, int i) {
        this.writer = writer;
        if (i <= 0) {
            throw new IllegalArgumentException("Negative initial size: " + i);
        }
        this.buf = new char[i];
    }

    public void config(SerializerFeature serializerFeature, boolean z) {
        if (z) {
            this.features |= serializerFeature.getMask();
            if (serializerFeature == SerializerFeature.WriteEnumUsingToString) {
                this.features &= ~SerializerFeature.WriteEnumUsingName.getMask();
                return;
            } else {
                if (serializerFeature == SerializerFeature.WriteEnumUsingName) {
                    this.features &= ~SerializerFeature.WriteEnumUsingToString.getMask();
                    return;
                }
                return;
            }
        }
        this.features = (~serializerFeature.getMask()) & this.features;
    }

    public boolean isEnabled(SerializerFeature serializerFeature) {
        return SerializerFeature.isEnabled(this.features, serializerFeature);
    }

    @Override // java.io.Writer
    public void write(int i) {
        int i2 = 1;
        int i3 = this.count + 1;
        if (i3 <= this.buf.length) {
            i2 = i3;
        } else if (this.writer == null) {
            expandCapacity(i3);
            i2 = i3;
        } else {
            flush();
        }
        this.buf[this.count] = (char) i;
        this.count = i2;
    }

    public void write(char c) {
        int i = 1;
        int i2 = this.count + 1;
        if (i2 <= this.buf.length) {
            i = i2;
        } else if (this.writer == null) {
            expandCapacity(i2);
            i = i2;
        } else {
            flush();
        }
        this.buf[this.count] = c;
        this.count = i;
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i, int i2) {
        int i3;
        if (i < 0 || i > cArr.length || i2 < 0 || (i3 = i + i2) > cArr.length || i3 < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (i2 == 0) {
            return;
        }
        int i4 = this.count + i2;
        if (i4 > this.buf.length) {
            if (this.writer == null) {
                expandCapacity(i4);
            } else {
                do {
                    char[] cArr2 = this.buf;
                    int length = cArr2.length;
                    int i5 = this.count;
                    int i6 = length - i5;
                    System.arraycopy(cArr, i, cArr2, i5, i6);
                    this.count = this.buf.length;
                    flush();
                    i2 -= i6;
                    i += i6;
                } while (i2 > this.buf.length);
                i4 = i2;
            }
        }
        System.arraycopy(cArr, i, this.buf, this.count, i2);
        this.count = i4;
    }

    public void expandCapacity(int i) {
        char[] cArr = this.buf;
        int length = ((cArr.length * 3) / 2) + 1;
        if (length >= i) {
            i = length;
        }
        char[] cArr2 = new char[i];
        System.arraycopy(cArr, 0, cArr2, 0, this.count);
        this.buf = cArr2;
    }

    @Override // java.io.Writer
    public void write(String str, int i, int i2) {
        int i3;
        int i4 = this.count + i2;
        if (i4 > this.buf.length) {
            if (this.writer == null) {
                expandCapacity(i4);
            } else {
                while (true) {
                    char[] cArr = this.buf;
                    int length = cArr.length;
                    int i5 = this.count;
                    int i6 = length - i5;
                    i3 = i + i6;
                    str.getChars(i, i3, cArr, i5);
                    this.count = this.buf.length;
                    flush();
                    i2 -= i6;
                    if (i2 <= this.buf.length) {
                        break;
                    } else {
                        i = i3;
                    }
                }
                i4 = i2;
                i = i3;
            }
        }
        str.getChars(i, i2 + i, this.buf, this.count);
        this.count = i4;
    }

    public void writeTo(Writer writer) throws IOException {
        if (this.writer != null) {
            throw new UnsupportedOperationException("writer not null");
        }
        writer.write(this.buf, 0, this.count);
    }

    public void writeTo(OutputStream outputStream, String str) throws IOException {
        writeTo(outputStream, Charset.forName(str));
    }

    public void writeTo(OutputStream outputStream, Charset charset) throws IOException {
        if (this.writer != null) {
            throw new UnsupportedOperationException("writer not null");
        }
        outputStream.write(new String(this.buf, 0, this.count).getBytes(charset));
    }

    @Override // java.io.Writer, java.lang.Appendable
    public SerializeWriter append(CharSequence charSequence) {
        String string = charSequence == null ? "null" : charSequence.toString();
        write(string, 0, string.length());
        return this;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public SerializeWriter append(CharSequence charSequence, int i, int i2) {
        if (charSequence == null) {
            charSequence = "null";
        }
        String string = charSequence.subSequence(i, i2).toString();
        write(string, 0, string.length());
        return this;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public SerializeWriter append(char c) {
        write(c);
        return this;
    }

    public char[] toCharArray() {
        if (this.writer != null) {
            throw new UnsupportedOperationException("writer not null");
        }
        int i = this.count;
        char[] cArr = new char[i];
        System.arraycopy(this.buf, 0, cArr, 0, i);
        return cArr;
    }

    public byte[] toBytes(String str) {
        if (this.writer != null) {
            throw new UnsupportedOperationException("writer not null");
        }
        if (str == null) {
            str = "UTF-8";
        }
        return new SerialWriterStringEncoder(Charset.forName(str)).encode(this.buf, 0, this.count);
    }

    public String toString() {
        return new String(this.buf, 0, this.count);
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.writer != null && this.count > 0) {
            flush();
        }
        if (this.buf.length <= 8192) {
            bufLocal.set(new SoftReference<>(this.buf));
        }
        this.buf = null;
    }

    @Override // java.io.Writer
    public void write(String str) {
        if (str == null) {
            writeNull();
        } else {
            write(str, 0, str.length());
        }
    }

    public void writeInt(int i) {
        if (i == Integer.MIN_VALUE) {
            write("-2147483648");
            return;
        }
        int iStringSize = i < 0 ? IOUtils.stringSize(-i) + 1 : IOUtils.stringSize(i);
        int i2 = this.count + iStringSize;
        if (i2 > this.buf.length) {
            if (this.writer == null) {
                expandCapacity(i2);
            } else {
                char[] cArr = new char[iStringSize];
                IOUtils.getChars(i, iStringSize, cArr);
                write(cArr, 0, iStringSize);
                return;
            }
        }
        IOUtils.getChars(i, i2, this.buf);
        this.count = i2;
    }

    public void writeByteArray(byte[] bArr) {
        int length = bArr.length;
        boolean zIsEnabled = isEnabled(SerializerFeature.UseSingleQuotes);
        char c = zIsEnabled ? '\'' : Typography.quote;
        if (length == 0) {
            write(zIsEnabled ? "''" : "\"\"");
            return;
        }
        char[] cArr = Base64.CA;
        int i = (length / 3) * 3;
        int i2 = length - 1;
        int i3 = this.count;
        int i4 = (((i2 / 3) + 1) << 2) + i3;
        int i5 = i4 + 2;
        if (i5 > this.buf.length) {
            if (this.writer != null) {
                write(c);
                int i6 = 0;
                while (i6 < i) {
                    int i7 = i6 + 2;
                    int i8 = ((bArr[i6 + 1] & 255) << 8) | ((bArr[i6] & 255) << 16);
                    i6 += 3;
                    int i9 = i8 | (bArr[i7] & 255);
                    write(cArr[(i9 >>> 18) & 63]);
                    write(cArr[(i9 >>> 12) & 63]);
                    write(cArr[(i9 >>> 6) & 63]);
                    write(cArr[i9 & 63]);
                }
                int i10 = length - i;
                if (i10 > 0) {
                    int i11 = ((bArr[i] & 255) << 10) | (i10 == 2 ? (bArr[i2] & 255) << 2 : 0);
                    write(cArr[i11 >> 12]);
                    write(cArr[(i11 >>> 6) & 63]);
                    write(i10 == 2 ? cArr[i11 & 63] : '=');
                    write('=');
                }
                write(c);
                return;
            }
            expandCapacity(i5);
        }
        this.count = i5;
        int i12 = i3 + 1;
        this.buf[i3] = c;
        int i13 = 0;
        while (i13 < i) {
            int i14 = i13 + 2;
            int i15 = ((bArr[i13 + 1] & 255) << 8) | ((bArr[i13] & 255) << 16);
            i13 += 3;
            int i16 = i15 | (bArr[i14] & 255);
            char[] cArr2 = this.buf;
            cArr2[i12] = cArr[(i16 >>> 18) & 63];
            cArr2[i12 + 1] = cArr[(i16 >>> 12) & 63];
            int i17 = i12 + 3;
            cArr2[i12 + 2] = cArr[(i16 >>> 6) & 63];
            i12 += 4;
            cArr2[i17] = cArr[i16 & 63];
        }
        int i18 = length - i;
        if (i18 > 0) {
            int i19 = ((bArr[i] & 255) << 10) | (i18 == 2 ? (bArr[i2] & 255) << 2 : 0);
            char[] cArr3 = this.buf;
            cArr3[i4 - 3] = cArr[i19 >> 12];
            cArr3[i4 - 2] = cArr[(i19 >>> 6) & 63];
            cArr3[i4 - 1] = i18 == 2 ? cArr[i19 & 63] : '=';
            cArr3[i4] = '=';
        }
        this.buf[i4 + 1] = c;
    }

    public void writeFloatAndChar(float f, char c) {
        String string = Float.toString(f);
        if (string.endsWith(".0")) {
            string = string.substring(0, string.length() - 2);
        }
        write(string);
        write(c);
    }

    public void writeDoubleAndChar(double d, char c) {
        String string = Double.toString(d);
        if (string.endsWith(".0")) {
            string = string.substring(0, string.length() - 2);
        }
        write(string);
        write(c);
    }

    public void writeBooleanAndChar(boolean z, char c) {
        if (z) {
            if (c == ',') {
                write("true,");
                return;
            } else if (c == ']') {
                write("true]");
                return;
            } else {
                write(ez.Code);
                write(c);
                return;
            }
        }
        if (c == ',') {
            write("false,");
        } else if (c == ']') {
            write("false]");
        } else {
            write(ez.V);
            write(c);
        }
    }

    public void writeCharacterAndChar(char c, char c2) {
        writeString(Character.toString(c));
        write(c2);
    }

    public void writeEnum(Enum<?> r2, char c) {
        if (r2 == null) {
            writeNull();
            write(',');
        } else if (isEnabled(SerializerFeature.WriteEnumUsingName)) {
            writeEnumValue(r2.name(), c);
        } else if (isEnabled(SerializerFeature.WriteEnumUsingToString)) {
            writeEnumValue(r2.toString(), c);
        } else {
            writeIntAndChar(r2.ordinal(), c);
        }
    }

    private void writeEnumValue(String str, char c) {
        if (isEnabled(SerializerFeature.UseSingleQuotes)) {
            write('\'');
            write(str);
            write('\'');
            write(c);
            return;
        }
        write(Typography.quote);
        write(str);
        write(Typography.quote);
        write(c);
    }

    public void writeIntAndChar(int i, char c) {
        if (i == Integer.MIN_VALUE) {
            write("-2147483648");
            write(c);
            return;
        }
        int iStringSize = this.count + (i < 0 ? IOUtils.stringSize(-i) + 1 : IOUtils.stringSize(i));
        int i2 = iStringSize + 1;
        if (i2 > this.buf.length) {
            if (this.writer != null) {
                writeInt(i);
                write(c);
                return;
            }
            expandCapacity(i2);
        }
        IOUtils.getChars(i, iStringSize, this.buf);
        this.buf[iStringSize] = c;
        this.count = i2;
    }

    public void writeLongAndChar(long j, char c) throws IOException {
        if (j == Long.MIN_VALUE) {
            write("-9223372036854775808");
            write(c);
            return;
        }
        int iStringSize = this.count + (j < 0 ? IOUtils.stringSize(-j) + 1 : IOUtils.stringSize(j));
        int i = iStringSize + 1;
        if (i > this.buf.length) {
            if (this.writer != null) {
                writeLong(j);
                write(c);
                return;
            }
            expandCapacity(i);
        }
        IOUtils.getChars(j, iStringSize, this.buf);
        this.buf[iStringSize] = c;
        this.count = i;
    }

    public void writeLong(long j) {
        if (j == Long.MIN_VALUE) {
            write("-9223372036854775808");
            return;
        }
        int iStringSize = j < 0 ? IOUtils.stringSize(-j) + 1 : IOUtils.stringSize(j);
        int i = this.count + iStringSize;
        if (i > this.buf.length) {
            if (this.writer == null) {
                expandCapacity(i);
            } else {
                char[] cArr = new char[iStringSize];
                IOUtils.getChars(j, iStringSize, cArr);
                write(cArr, 0, iStringSize);
                return;
            }
        }
        IOUtils.getChars(j, i, this.buf);
        this.count = i;
    }

    public void writeNull() {
        write("null");
    }

    private void writeStringWithDoubleQuote(String str, char c) {
        writeStringWithDoubleQuote(str, c, true);
    }

    /* JADX WARN: Code duplicated, block: B:196:0x03b2 A[PHI: r4 r5
  0x03b2: PHI (r4v33 int) = (r4v28 int), (r4v34 int) binds: [B:215:0x03e4, B:195:0x03b0] A[DONT_GENERATE, DONT_INLINE]
  0x03b2: PHI (r5v25 int) = (r5v19 int), (r5v26 int) binds: [B:215:0x03e4, B:195:0x03b0] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:197:0x03b5 A[PHI: r4 r5 r7
  0x03b5: PHI (r4v30 int) = (r4v28 int), (r4v29 int), (r4v34 int) binds: [B:215:0x03e4, B:207:0x03c7, B:195:0x03b0] A[DONT_GENERATE, DONT_INLINE]
  0x03b5: PHI (r5v22 int) = (r5v19 int), (r5v21 int), (r5v26 int) binds: [B:215:0x03e4, B:207:0x03c7, B:195:0x03b0] A[DONT_GENERATE, DONT_INLINE]
  0x03b5: PHI (r7v16 int) = (r7v2 int), (r7v14 int), (r7v2 int) binds: [B:215:0x03e4, B:207:0x03c7, B:195:0x03b0] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:69:0x0179  */
    private void writeStringWithDoubleQuote(String str, char c, boolean z) {
        if (str == null) {
            writeNull();
            if (c != 0) {
                write(c);
                return;
            }
            return;
        }
        int length = str.length();
        int i = this.count + length;
        int i2 = i + 2;
        if (c != 0) {
            i2 = i + 3;
        }
        char c2 = 'z';
        char c3 = '\b';
        if (i2 > this.buf.length) {
            if (this.writer != null) {
                write(Typography.quote);
                int i3 = 0;
                while (i3 < str.length()) {
                    char cCharAt = str.charAt(i3);
                    if (isEnabled(SerializerFeature.BrowserSecure)) {
                        if ((cCharAt < '0' || cCharAt > '9') && ((cCharAt < 'a' || cCharAt > 'z') && ((cCharAt < 'A' || cCharAt > 'Z') && cCharAt != ',' && cCharAt != '.' && cCharAt != '_'))) {
                            write(org.apache.commons.io.IOUtils.DIR_SEPARATOR_WINDOWS);
                            write('u');
                            write(IOUtils.DIGITS[(cCharAt >>> '\f') & 15]);
                            write(IOUtils.DIGITS[(cCharAt >>> '\b') & 15]);
                            write(IOUtils.DIGITS[(cCharAt >>> 4) & 15]);
                            write(IOUtils.DIGITS[cCharAt & 15]);
                        } else {
                            write(cCharAt);
                        }
                    } else if (isEnabled(SerializerFeature.BrowserCompatible)) {
                        if (cCharAt == c3 || cCharAt == '\f' || cCharAt == '\n' || cCharAt == '\r' || cCharAt == '\t' || cCharAt == '\"' || cCharAt == '/' || cCharAt == '\\') {
                            write(org.apache.commons.io.IOUtils.DIR_SEPARATOR_WINDOWS);
                            write(IOUtils.replaceChars[cCharAt]);
                        } else if (cCharAt < ' ') {
                            write(org.apache.commons.io.IOUtils.DIR_SEPARATOR_WINDOWS);
                            write('u');
                            write('0');
                            write('0');
                            int i4 = cCharAt * 2;
                            write(IOUtils.ASCII_CHARS[i4]);
                            write(IOUtils.ASCII_CHARS[i4 + 1]);
                        } else if (cCharAt >= 127) {
                            write(org.apache.commons.io.IOUtils.DIR_SEPARATOR_WINDOWS);
                            write('u');
                            write(IOUtils.DIGITS[(cCharAt >>> '\f') & 15]);
                            write(IOUtils.DIGITS[(cCharAt >>> '\b') & 15]);
                            write(IOUtils.DIGITS[(cCharAt >>> 4) & 15]);
                            write(IOUtils.DIGITS[cCharAt & 15]);
                        } else {
                            write(cCharAt);
                        }
                    } else if ((cCharAt < IOUtils.specicalFlags_doubleQuotes.length && IOUtils.specicalFlags_doubleQuotes[cCharAt] != 0) || (cCharAt == '/' && isEnabled(SerializerFeature.WriteSlashAsSpecial))) {
                        write(org.apache.commons.io.IOUtils.DIR_SEPARATOR_WINDOWS);
                        if (IOUtils.specicalFlags_doubleQuotes[cCharAt] == 4) {
                            write('u');
                            write(IOUtils.DIGITS[(cCharAt >>> '\f') & 15]);
                            write(IOUtils.DIGITS[(cCharAt >>> '\b') & 15]);
                            write(IOUtils.DIGITS[(cCharAt >>> 4) & 15]);
                            write(IOUtils.DIGITS[cCharAt & 15]);
                        } else {
                            write(IOUtils.replaceChars[cCharAt]);
                        }
                    } else {
                        write(cCharAt);
                    }
                    i3++;
                    c3 = '\b';
                }
                write(Typography.quote);
                if (c != 0) {
                    write(c);
                    return;
                }
                return;
            }
            expandCapacity(i2);
        }
        int i5 = this.count;
        int i6 = i5 + 1;
        int i7 = i6 + length;
        char[] cArr = this.buf;
        cArr[i5] = Typography.quote;
        int i8 = 0;
        str.getChars(0, length, cArr, i6);
        this.count = i2;
        int i9 = -1;
        if (isEnabled(SerializerFeature.BrowserSecure)) {
            for (int i10 = i6; i10 < i7; i10++) {
                char c4 = this.buf[i10];
                if ((c4 < '0' || c4 > '9') && ((c4 < 'a' || c4 > 'z') && ((c4 < 'A' || c4 > 'Z') && c4 != ',' && c4 != '.' && c4 != '_'))) {
                    i2 += 5;
                    i9 = i10;
                }
            }
            if (i2 > this.buf.length) {
                expandCapacity(i2);
            }
            this.count = i2;
            while (i9 >= i6) {
                char[] cArr2 = this.buf;
                char c5 = cArr2[i9];
                if ((c5 < '0' || c5 > '9') && ((c5 < 'a' || c5 > c2) && ((c5 < 'A' || c5 > 'Z') && c5 != ',' && c5 != '.' && c5 != '_'))) {
                    int i11 = i9 + 1;
                    System.arraycopy(cArr2, i11, cArr2, i9 + 6, (i7 - i9) - 1);
                    char[] cArr3 = this.buf;
                    cArr3[i9] = org.apache.commons.io.IOUtils.DIR_SEPARATOR_WINDOWS;
                    cArr3[i11] = 'u';
                    cArr3[i9 + 2] = IOUtils.DIGITS[(c5 >>> '\f') & 15];
                    this.buf[i9 + 3] = IOUtils.DIGITS[(c5 >>> '\b') & 15];
                    this.buf[i9 + 4] = IOUtils.DIGITS[(c5 >>> 4) & 15];
                    this.buf[i9 + 5] = IOUtils.DIGITS[c5 & 15];
                    i7 += 5;
                }
                i9--;
                c2 = 'z';
            }
            if (c != 0) {
                char[] cArr4 = this.buf;
                int i12 = this.count;
                cArr4[i12 - 2] = Typography.quote;
                cArr4[i12 - 1] = c;
                return;
            }
            this.buf[this.count - 1] = Typography.quote;
            return;
        }
        if (isEnabled(SerializerFeature.BrowserCompatible)) {
            for (int i13 = i6; i13 < i7; i13++) {
                char c6 = this.buf[i13];
                if (c6 == '\"' || c6 == '/' || c6 == '\\' || c6 == '\b' || c6 == '\f' || c6 == '\n' || c6 == '\r' || c6 == '\t') {
                    i2++;
                } else {
                    if (c6 < ' ' || c6 >= 127) {
                        i2 += 5;
                    }
                }
                i9 = i13;
            }
            if (i2 > this.buf.length) {
                expandCapacity(i2);
            }
            this.count = i2;
            while (i9 >= i6) {
                char[] cArr5 = this.buf;
                char c7 = cArr5[i9];
                if (c7 == '\b' || c7 == '\f' || c7 == '\n' || c7 == '\r' || c7 == '\t') {
                    int i14 = i9 + 1;
                    System.arraycopy(cArr5, i14, cArr5, i9 + 2, (i7 - i9) - 1);
                    char[] cArr6 = this.buf;
                    cArr6[i9] = org.apache.commons.io.IOUtils.DIR_SEPARATOR_WINDOWS;
                    cArr6[i14] = IOUtils.replaceChars[c7];
                } else {
                    if (c7 == '\"' || c7 == '/' || c7 == '\\') {
                        int i15 = i9 + 1;
                        System.arraycopy(cArr5, i15, cArr5, i9 + 2, (i7 - i9) - 1);
                        char[] cArr7 = this.buf;
                        cArr7[i9] = org.apache.commons.io.IOUtils.DIR_SEPARATOR_WINDOWS;
                        cArr7[i15] = c7;
                    } else {
                        if (c7 < ' ') {
                            int i16 = i9 + 1;
                            System.arraycopy(cArr5, i16, cArr5, i9 + 6, (i7 - i9) - 1);
                            char[] cArr8 = this.buf;
                            cArr8[i9] = org.apache.commons.io.IOUtils.DIR_SEPARATOR_WINDOWS;
                            cArr8[i16] = 'u';
                            cArr8[i9 + 2] = '0';
                            cArr8[i9 + 3] = '0';
                            int i17 = c7 * 2;
                            cArr8[i9 + 4] = IOUtils.ASCII_CHARS[i17];
                            this.buf[i9 + 5] = IOUtils.ASCII_CHARS[i17 + 1];
                        } else if (c7 >= 127) {
                            int i18 = i9 + 1;
                            System.arraycopy(cArr5, i18, cArr5, i9 + 6, (i7 - i9) - 1);
                            char[] cArr9 = this.buf;
                            cArr9[i9] = org.apache.commons.io.IOUtils.DIR_SEPARATOR_WINDOWS;
                            cArr9[i18] = 'u';
                            cArr9[i9 + 2] = IOUtils.DIGITS[(c7 >>> '\f') & 15];
                            this.buf[i9 + 3] = IOUtils.DIGITS[(c7 >>> '\b') & 15];
                            this.buf[i9 + 4] = IOUtils.DIGITS[(c7 >>> 4) & 15];
                            this.buf[i9 + 5] = IOUtils.DIGITS[c7 & 15];
                        }
                        i7 += 5;
                    }
                    i9--;
                }
                i7++;
                i9--;
            }
            if (c != 0) {
                char[] cArr10 = this.buf;
                int i19 = this.count;
                cArr10[i19 - 2] = Typography.quote;
                cArr10[i19 - 1] = c;
                return;
            }
            this.buf[this.count - 1] = Typography.quote;
            return;
        }
        if (z) {
            char c8 = 0;
            int i20 = -1;
            int i21 = -1;
            for (int i22 = i6; i22 < i7; i22++) {
                char c9 = this.buf[i22];
                if (c9 == 8232) {
                    i8++;
                    i2 += 4;
                    if (i20 == -1) {
                        i20 = i22;
                        i21 = i20;
                    } else {
                        i21 = i22;
                    }
                    c8 = c9;
                } else if (c9 >= ']') {
                    if (c9 >= 127 && c9 <= 160) {
                        if (i20 == -1) {
                            i20 = i22;
                        }
                        i8++;
                        i2 += 4;
                        i21 = i22;
                        c8 = c9;
                    }
                } else if (isSpecial(c9, this.features)) {
                    i8++;
                    if (c9 < IOUtils.specicalFlags_doubleQuotes.length && IOUtils.specicalFlags_doubleQuotes[c9] == 4) {
                        i2 += 4;
                    }
                    if (i20 == -1) {
                        i20 = i22;
                        i21 = i20;
                    } else {
                        i21 = i22;
                    }
                    c8 = c9;
                }
            }
            if (i8 > 0) {
                int i23 = i2 + i8;
                if (i23 > this.buf.length) {
                    expandCapacity(i23);
                }
                this.count = i23;
                if (i8 == 1) {
                    if (c8 == 8232) {
                        int i24 = i21 + 1;
                        char[] cArr11 = this.buf;
                        System.arraycopy(cArr11, i24, cArr11, i21 + 6, (i7 - i21) - 1);
                        char[] cArr12 = this.buf;
                        cArr12[i21] = org.apache.commons.io.IOUtils.DIR_SEPARATOR_WINDOWS;
                        cArr12[i24] = 'u';
                        cArr12[i21 + 2] = '2';
                        cArr12[i21 + 3] = '0';
                        cArr12[i21 + 4] = '2';
                        cArr12[i21 + 5] = '8';
                    } else if (c8 < IOUtils.specicalFlags_doubleQuotes.length && IOUtils.specicalFlags_doubleQuotes[c8] == 4) {
                        int i25 = i21 + 1;
                        char[] cArr13 = this.buf;
                        System.arraycopy(cArr13, i25, cArr13, i21 + 6, (i7 - i21) - 1);
                        char[] cArr14 = this.buf;
                        cArr14[i21] = org.apache.commons.io.IOUtils.DIR_SEPARATOR_WINDOWS;
                        cArr14[i25] = 'u';
                        cArr14[i21 + 2] = IOUtils.DIGITS[(c8 >>> '\f') & 15];
                        this.buf[i21 + 3] = IOUtils.DIGITS[(c8 >>> '\b') & 15];
                        this.buf[i21 + 4] = IOUtils.DIGITS[(c8 >>> 4) & 15];
                        this.buf[i21 + 5] = IOUtils.DIGITS[c8 & 15];
                    } else {
                        int i26 = i21 + 1;
                        char[] cArr15 = this.buf;
                        System.arraycopy(cArr15, i26, cArr15, i21 + 2, (i7 - i21) - 1);
                        char[] cArr16 = this.buf;
                        cArr16[i21] = org.apache.commons.io.IOUtils.DIR_SEPARATOR_WINDOWS;
                        cArr16[i26] = IOUtils.replaceChars[c8];
                    }
                } else if (i8 > 1) {
                    for (int i27 = i20 - i6; i27 < str.length(); i27++) {
                        char cCharAt2 = str.charAt(i27);
                        if ((cCharAt2 < IOUtils.specicalFlags_doubleQuotes.length && IOUtils.specicalFlags_doubleQuotes[cCharAt2] != 0) || (cCharAt2 == '/' && isEnabled(SerializerFeature.WriteSlashAsSpecial))) {
                            int i28 = i20 + 1;
                            this.buf[i20] = org.apache.commons.io.IOUtils.DIR_SEPARATOR_WINDOWS;
                            if (IOUtils.specicalFlags_doubleQuotes[cCharAt2] == 4) {
                                char[] cArr17 = this.buf;
                                cArr17[i28] = 'u';
                                cArr17[i20 + 2] = IOUtils.DIGITS[(cCharAt2 >>> '\f') & 15];
                                this.buf[i20 + 3] = IOUtils.DIGITS[(cCharAt2 >>> '\b') & 15];
                                int i29 = i20 + 5;
                                this.buf[i20 + 4] = IOUtils.DIGITS[(cCharAt2 >>> 4) & 15];
                                i20 += 6;
                                this.buf[i29] = IOUtils.DIGITS[cCharAt2 & 15];
                            } else {
                                i20 += 2;
                                this.buf[i28] = IOUtils.replaceChars[cCharAt2];
                            }
                        } else if (cCharAt2 == 8232) {
                            char[] cArr18 = this.buf;
                            cArr18[i20] = org.apache.commons.io.IOUtils.DIR_SEPARATOR_WINDOWS;
                            cArr18[i20 + 1] = 'u';
                            cArr18[i20 + 2] = IOUtils.DIGITS[(cCharAt2 >>> '\f') & 15];
                            this.buf[i20 + 3] = IOUtils.DIGITS[(cCharAt2 >>> '\b') & 15];
                            int i30 = i20 + 5;
                            this.buf[i20 + 4] = IOUtils.DIGITS[(cCharAt2 >>> 4) & 15];
                            i20 += 6;
                            this.buf[i30] = IOUtils.DIGITS[cCharAt2 & 15];
                        } else {
                            this.buf[i20] = cCharAt2;
                            i20++;
                        }
                    }
                }
            }
        }
        if (c != 0) {
            char[] cArr19 = this.buf;
            int i31 = this.count;
            cArr19[i31 - 2] = Typography.quote;
            cArr19[i31 - 1] = c;
            return;
        }
        this.buf[this.count - 1] = Typography.quote;
    }

    public void writeFieldNull(char c, String str) {
        write(c);
        writeFieldName(str);
        writeNull();
    }

    public void writeFieldEmptyList(char c, String str) {
        write(c);
        writeFieldName(str);
        write(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
    }

    public void writeFieldNullString(char c, String str) {
        write(c);
        writeFieldName(str);
        if (isEnabled(SerializerFeature.WriteNullStringAsEmpty)) {
            writeString("");
        } else {
            writeNull();
        }
    }

    public void writeFieldNullBoolean(char c, String str) {
        write(c);
        writeFieldName(str);
        if (isEnabled(SerializerFeature.WriteNullBooleanAsFalse)) {
            write(ez.V);
        } else {
            writeNull();
        }
    }

    public void writeFieldNullList(char c, String str) {
        write(c);
        writeFieldName(str);
        if (isEnabled(SerializerFeature.WriteNullListAsEmpty)) {
            write(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
        } else {
            writeNull();
        }
    }

    public void writeFieldNullNumber(char c, String str) {
        write(c);
        writeFieldName(str);
        if (isEnabled(SerializerFeature.WriteNullNumberAsZero)) {
            write('0');
        } else {
            writeNull();
        }
    }

    public void writeFieldValue(char c, String str, char c2) {
        write(c);
        writeFieldName(str);
        if (c2 == 0) {
            writeString("\u0000");
        } else {
            writeString(Character.toString(c2));
        }
    }

    public void writeFieldValue(char c, String str, boolean z) {
        char c2 = isEnabled(SerializerFeature.UseSingleQuotes) ? '\'' : Typography.quote;
        int i = z ? 4 : 5;
        int length = str.length();
        int i2 = this.count + length + 4 + i;
        if (i2 > this.buf.length) {
            if (this.writer != null) {
                write(c);
                writeString(str);
                write(':');
                write(z);
                return;
            }
            expandCapacity(i2);
        }
        int i3 = this.count;
        this.count = i2;
        char[] cArr = this.buf;
        cArr[i3] = c;
        int i4 = i3 + length;
        cArr[i3 + 1] = c2;
        str.getChars(0, length, cArr, i3 + 2);
        this.buf[i4 + 2] = c2;
        if (z) {
            System.arraycopy(":true".toCharArray(), 0, this.buf, i4 + 3, 5);
        } else {
            System.arraycopy(":false".toCharArray(), 0, this.buf, i4 + 3, 6);
        }
    }

    public void write(boolean z) {
        if (z) {
            write(ez.Code);
        } else {
            write(ez.V);
        }
    }

    public void writeFieldValue(char c, String str, int i) {
        if (i == Integer.MIN_VALUE || !isEnabled(SerializerFeature.QuoteFieldNames)) {
            writeFieldValue1(c, str, i);
            return;
        }
        char c2 = isEnabled(SerializerFeature.UseSingleQuotes) ? '\'' : Typography.quote;
        int iStringSize = i < 0 ? IOUtils.stringSize(-i) + 1 : IOUtils.stringSize(i);
        int length = str.length();
        int i2 = this.count + length + 4 + iStringSize;
        if (i2 > this.buf.length) {
            if (this.writer != null) {
                writeFieldValue1(c, str, i);
                return;
            }
            expandCapacity(i2);
        }
        int i3 = this.count;
        this.count = i2;
        char[] cArr = this.buf;
        cArr[i3] = c;
        int i4 = i3 + length;
        cArr[i3 + 1] = c2;
        str.getChars(0, length, cArr, i3 + 2);
        char[] cArr2 = this.buf;
        cArr2[i4 + 2] = c2;
        cArr2[i4 + 3] = ':';
        IOUtils.getChars(i, this.count, cArr2);
    }

    public void writeFieldValue1(char c, String str, int i) {
        write(c);
        writeFieldName(str);
        writeInt(i);
    }

    public void writeFieldValue(char c, String str, long j) {
        if (j == Long.MIN_VALUE || !isEnabled(SerializerFeature.QuoteFieldNames)) {
            writeFieldValue1(c, str, j);
            return;
        }
        char c2 = isEnabled(SerializerFeature.UseSingleQuotes) ? '\'' : Typography.quote;
        int iStringSize = j < 0 ? IOUtils.stringSize(-j) + 1 : IOUtils.stringSize(j);
        int length = str.length();
        int i = this.count + length + 4 + iStringSize;
        if (i > this.buf.length) {
            if (this.writer != null) {
                write(c);
                writeFieldName(str);
                writeLong(j);
                return;
            }
            expandCapacity(i);
        }
        int i2 = this.count;
        this.count = i;
        char[] cArr = this.buf;
        cArr[i2] = c;
        int i3 = i2 + length;
        cArr[i2 + 1] = c2;
        str.getChars(0, length, cArr, i2 + 2);
        char[] cArr2 = this.buf;
        cArr2[i3 + 2] = c2;
        cArr2[i3 + 3] = ':';
        IOUtils.getChars(j, this.count, cArr2);
    }

    public void writeFieldValue1(char c, String str, long j) {
        write(c);
        writeFieldName(str);
        writeLong(j);
    }

    public void writeFieldValue(char c, String str, float f) {
        write(c);
        writeFieldName(str);
        if (f == 0.0f) {
            write('0');
            return;
        }
        if (Float.isNaN(f)) {
            writeNull();
            return;
        }
        if (Float.isInfinite(f)) {
            writeNull();
            return;
        }
        String string = Float.toString(f);
        if (string.endsWith(".0")) {
            string = string.substring(0, string.length() - 2);
        }
        write(string);
    }

    public void writeFieldValue(char c, String str, double d) {
        write(c);
        writeFieldName(str);
        if (d == 0.0d) {
            write('0');
            return;
        }
        if (Double.isNaN(d)) {
            writeNull();
            return;
        }
        if (Double.isInfinite(d)) {
            writeNull();
            return;
        }
        String string = Double.toString(d);
        if (string.endsWith(".0")) {
            string = string.substring(0, string.length() - 2);
        }
        write(string);
    }

    public void writeFieldValue(char c, String str, String str2) {
        if (isEnabled(SerializerFeature.QuoteFieldNames)) {
            if (isEnabled(SerializerFeature.UseSingleQuotes)) {
                write(c);
                writeFieldName(str);
                if (str2 == null) {
                    writeNull();
                    return;
                } else {
                    writeString(str2);
                    return;
                }
            }
            if (isEnabled(SerializerFeature.BrowserSecure)) {
                write(c);
                writeStringWithDoubleQuote(str, ':');
                writeStringWithDoubleQuote(str2, (char) 0);
                return;
            } else {
                if (isEnabled(SerializerFeature.BrowserCompatible)) {
                    write(c);
                    writeStringWithDoubleQuote(str, ':');
                    writeStringWithDoubleQuote(str2, (char) 0);
                    return;
                }
                writeFieldValueStringWithDoubleQuote(c, str, str2, true);
                return;
            }
        }
        write(c);
        writeFieldName(str);
        if (str2 == null) {
            writeNull();
        } else {
            writeString(str2);
        }
    }

    /* JADX WARN: Code duplicated, block: B:28:0x0096 A[PHI: r5 r10
  0x0096: PHI (r5v26 int) = (r5v20 int), (r5v27 int) binds: [B:47:0x00c7, B:27:0x0094] A[DONT_GENERATE, DONT_INLINE]
  0x0096: PHI (r10v14 int) = (r10v9 int), (r10v15 int) binds: [B:47:0x00c7, B:27:0x0094] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:29:0x0099 A[PHI: r5 r9 r10
  0x0099: PHI (r5v23 int) = (r5v20 int), (r5v22 int), (r5v27 int) binds: [B:47:0x00c7, B:39:0x00ab, B:27:0x0094] A[DONT_GENERATE, DONT_INLINE]
  0x0099: PHI (r9v11 int) = (r9v2 int), (r9v9 int), (r9v2 int) binds: [B:47:0x00c7, B:39:0x00ab, B:27:0x0094] A[DONT_GENERATE, DONT_INLINE]
  0x0099: PHI (r10v11 int) = (r10v9 int), (r10v10 int), (r10v15 int) binds: [B:47:0x00c7, B:39:0x00ab, B:27:0x0094] A[DONT_GENERATE, DONT_INLINE]] */
    private void writeFieldValueStringWithDoubleQuote(char c, String str, String str2, boolean z) {
        int length;
        int i;
        int length2 = str.length();
        int i2 = this.count;
        if (str2 == null) {
            i = i2 + length2 + 8;
            length = 4;
        } else {
            length = str2.length();
            i = i2 + length2 + length + 6;
        }
        int i3 = 0;
        if (i > this.buf.length) {
            if (this.writer != null) {
                write(c);
                writeStringWithDoubleQuote(str, ':', z);
                writeStringWithDoubleQuote(str2, (char) 0, z);
                return;
            }
            expandCapacity(i);
        }
        char[] cArr = this.buf;
        int i4 = this.count;
        cArr[i4] = c;
        int i5 = i4 + 2;
        int i6 = i5 + length2;
        cArr[i4 + 1] = Typography.quote;
        str.getChars(0, length2, cArr, i5);
        this.count = i;
        char[] cArr2 = this.buf;
        cArr2[i6] = Typography.quote;
        int i7 = i6 + 2;
        cArr2[i6 + 1] = ':';
        if (str2 == null) {
            cArr2[i7] = 'n';
            cArr2[i6 + 3] = 'u';
            cArr2[i6 + 4] = 'l';
            cArr2[i6 + 5] = 'l';
            return;
        }
        int i8 = i6 + 3;
        cArr2[i7] = Typography.quote;
        int i9 = i8 + length;
        str2.getChars(0, length, cArr2, i8);
        if (z && !isEnabled(SerializerFeature.DisableCheckSpecialChar)) {
            int i10 = -1;
            int i11 = -1;
            char c2 = 0;
            for (int i12 = i8; i12 < i9; i12++) {
                char c3 = this.buf[i12];
                if (c3 == 8232) {
                    i3++;
                    i += 4;
                    if (i10 == -1) {
                        i10 = i12;
                        i11 = i10;
                    } else {
                        i11 = i12;
                    }
                    c2 = c3;
                } else if (c3 >= ']') {
                    if (c3 >= 127 && c3 <= 160) {
                        if (i10 == -1) {
                            i10 = i12;
                        }
                        i3++;
                        i += 4;
                        i11 = i12;
                        c2 = c3;
                    }
                } else if (isSpecial(c3, this.features)) {
                    i3++;
                    if (c3 < IOUtils.specicalFlags_doubleQuotes.length && IOUtils.specicalFlags_doubleQuotes[c3] == 4) {
                        i += 4;
                    }
                    if (i10 == -1) {
                        i10 = i12;
                        i11 = i10;
                    } else {
                        i11 = i12;
                    }
                    c2 = c3;
                }
            }
            if (i3 > 0) {
                int i13 = i + i3;
                if (i13 > this.buf.length) {
                    expandCapacity(i13);
                }
                this.count = i13;
                if (i3 == 1) {
                    if (c2 == 8232) {
                        int i14 = i11 + 1;
                        char[] cArr3 = this.buf;
                        System.arraycopy(cArr3, i14, cArr3, i11 + 6, (i9 - i11) - 1);
                        char[] cArr4 = this.buf;
                        cArr4[i11] = org.apache.commons.io.IOUtils.DIR_SEPARATOR_WINDOWS;
                        cArr4[i14] = 'u';
                        cArr4[i11 + 2] = '2';
                        cArr4[i11 + 3] = '0';
                        cArr4[i11 + 4] = '2';
                        cArr4[i11 + 5] = '8';
                    } else if (c2 < IOUtils.specicalFlags_doubleQuotes.length && IOUtils.specicalFlags_doubleQuotes[c2] == 4) {
                        int i15 = i11 + 1;
                        char[] cArr5 = this.buf;
                        System.arraycopy(cArr5, i15, cArr5, i11 + 6, (i9 - i11) - 1);
                        char[] cArr6 = this.buf;
                        cArr6[i11] = org.apache.commons.io.IOUtils.DIR_SEPARATOR_WINDOWS;
                        cArr6[i15] = 'u';
                        cArr6[i11 + 2] = IOUtils.DIGITS[(c2 >>> '\f') & 15];
                        this.buf[i11 + 3] = IOUtils.DIGITS[(c2 >>> '\b') & 15];
                        this.buf[i11 + 4] = IOUtils.DIGITS[(c2 >>> 4) & 15];
                        this.buf[i11 + 5] = IOUtils.DIGITS[c2 & 15];
                    } else {
                        int i16 = i11 + 1;
                        char[] cArr7 = this.buf;
                        System.arraycopy(cArr7, i16, cArr7, i11 + 2, (i9 - i11) - 1);
                        char[] cArr8 = this.buf;
                        cArr8[i11] = org.apache.commons.io.IOUtils.DIR_SEPARATOR_WINDOWS;
                        cArr8[i16] = IOUtils.replaceChars[c2];
                    }
                } else if (i3 > 1) {
                    for (int i17 = i10 - i8; i17 < str2.length(); i17++) {
                        char cCharAt = str2.charAt(i17);
                        if ((cCharAt < IOUtils.specicalFlags_doubleQuotes.length && IOUtils.specicalFlags_doubleQuotes[cCharAt] != 0) || (cCharAt == '/' && isEnabled(SerializerFeature.WriteSlashAsSpecial))) {
                            int i18 = i10 + 1;
                            this.buf[i10] = org.apache.commons.io.IOUtils.DIR_SEPARATOR_WINDOWS;
                            if (IOUtils.specicalFlags_doubleQuotes[cCharAt] == 4) {
                                char[] cArr9 = this.buf;
                                cArr9[i18] = 'u';
                                cArr9[i10 + 2] = IOUtils.DIGITS[(cCharAt >>> '\f') & 15];
                                this.buf[i10 + 3] = IOUtils.DIGITS[(cCharAt >>> '\b') & 15];
                                int i19 = i10 + 5;
                                this.buf[i10 + 4] = IOUtils.DIGITS[(cCharAt >>> 4) & 15];
                                i10 += 6;
                                this.buf[i19] = IOUtils.DIGITS[cCharAt & 15];
                            } else {
                                i10 += 2;
                                this.buf[i18] = IOUtils.replaceChars[cCharAt];
                            }
                        } else if (cCharAt == 8232) {
                            char[] cArr10 = this.buf;
                            cArr10[i10] = org.apache.commons.io.IOUtils.DIR_SEPARATOR_WINDOWS;
                            cArr10[i10 + 1] = 'u';
                            cArr10[i10 + 2] = IOUtils.DIGITS[(cCharAt >>> '\f') & 15];
                            this.buf[i10 + 3] = IOUtils.DIGITS[(cCharAt >>> '\b') & 15];
                            int i20 = i10 + 5;
                            this.buf[i10 + 4] = IOUtils.DIGITS[(cCharAt >>> 4) & 15];
                            i10 += 6;
                            this.buf[i20] = IOUtils.DIGITS[cCharAt & 15];
                        } else {
                            this.buf[i10] = cCharAt;
                            i10++;
                        }
                    }
                }
            }
        }
        this.buf[this.count - 1] = Typography.quote;
    }

    static final boolean isSpecial(char c, int i) {
        if (c == ' ') {
            return false;
        }
        if (c == '/' && SerializerFeature.isEnabled(i, SerializerFeature.WriteSlashAsSpecial)) {
            return true;
        }
        if (c <= '#' || c == '\\') {
            return c <= 31 || c == '\\' || c == '\"';
        }
        return false;
    }

    public void writeFieldValue(char c, String str, Enum<?> r4) {
        if (r4 == null) {
            write(c);
            writeFieldName(str);
            writeNull();
        } else if (isEnabled(SerializerFeature.WriteEnumUsingName)) {
            writeEnumFieldValue(c, str, r4.name());
        } else if (isEnabled(SerializerFeature.WriteEnumUsingToString)) {
            writeEnumFieldValue(c, str, r4.toString());
        } else {
            writeFieldValue(c, str, r4.ordinal());
        }
    }

    private void writeEnumFieldValue(char c, String str, String str2) {
        if (isEnabled(SerializerFeature.UseSingleQuotes)) {
            writeFieldValue(c, str, str2);
        } else {
            writeFieldValueStringWithDoubleQuote(c, str, str2, false);
        }
    }

    public void writeFieldValue(char c, String str, BigDecimal bigDecimal) {
        write(c);
        writeFieldName(str);
        if (bigDecimal == null) {
            writeNull();
        } else {
            write(bigDecimal.toString());
        }
    }

    public void writeString(String str, char c) {
        if (isEnabled(SerializerFeature.UseSingleQuotes)) {
            writeStringWithSingleQuote(str);
            write(c);
        } else {
            writeStringWithDoubleQuote(str, c);
        }
    }

    public void writeString(String str) {
        if (isEnabled(SerializerFeature.UseSingleQuotes)) {
            writeStringWithSingleQuote(str);
        } else {
            writeStringWithDoubleQuote(str, (char) 0);
        }
    }

    private void writeStringWithSingleQuote(String str) {
        int i = 0;
        if (str == null) {
            int i2 = this.count + 4;
            if (i2 > this.buf.length) {
                expandCapacity(i2);
            }
            "null".getChars(0, 4, this.buf, this.count);
            this.count = i2;
            return;
        }
        int length = str.length();
        int i3 = this.count + length + 2;
        if (i3 > this.buf.length) {
            if (this.writer != null) {
                write('\'');
                while (i < str.length()) {
                    char cCharAt = str.charAt(i);
                    if (cCharAt <= '\r' || cCharAt == '\\' || cCharAt == '\'' || (cCharAt == '/' && isEnabled(SerializerFeature.WriteSlashAsSpecial))) {
                        write(org.apache.commons.io.IOUtils.DIR_SEPARATOR_WINDOWS);
                        write(IOUtils.replaceChars[cCharAt]);
                    } else {
                        write(cCharAt);
                    }
                    i++;
                }
                write('\'');
                return;
            }
            expandCapacity(i3);
        }
        int i4 = this.count;
        int i5 = i4 + 1;
        int i6 = i5 + length;
        char[] cArr = this.buf;
        cArr[i4] = '\'';
        str.getChars(0, length, cArr, i5);
        this.count = i3;
        int i7 = -1;
        char c = 0;
        for (int i8 = i5; i8 < i6; i8++) {
            char c2 = this.buf[i8];
            if (c2 <= '\r' || c2 == '\\' || c2 == '\'' || (c2 == '/' && isEnabled(SerializerFeature.WriteSlashAsSpecial))) {
                i++;
                i7 = i8;
                c = c2;
            }
        }
        int i9 = i3 + i;
        if (i9 > this.buf.length) {
            expandCapacity(i9);
        }
        this.count = i9;
        if (i == 1) {
            char[] cArr2 = this.buf;
            int i10 = i7 + 1;
            System.arraycopy(cArr2, i10, cArr2, i7 + 2, (i6 - i7) - 1);
            char[] cArr3 = this.buf;
            cArr3[i7] = org.apache.commons.io.IOUtils.DIR_SEPARATOR_WINDOWS;
            cArr3[i10] = IOUtils.replaceChars[c];
        } else if (i > 1) {
            char[] cArr4 = this.buf;
            int i11 = i7 + 1;
            System.arraycopy(cArr4, i11, cArr4, i7 + 2, (i6 - i7) - 1);
            char[] cArr5 = this.buf;
            cArr5[i7] = org.apache.commons.io.IOUtils.DIR_SEPARATOR_WINDOWS;
            cArr5[i11] = IOUtils.replaceChars[c];
            int i12 = i6 + 1;
            for (int i13 = i7 - 1; i13 >= i5; i13--) {
                char c3 = this.buf[i13];
                if (c3 <= '\r' || c3 == '\\' || c3 == '\'' || (c3 == '/' && isEnabled(SerializerFeature.WriteSlashAsSpecial))) {
                    char[] cArr6 = this.buf;
                    int i14 = i13 + 1;
                    System.arraycopy(cArr6, i14, cArr6, i13 + 2, (i12 - i13) - 1);
                    char[] cArr7 = this.buf;
                    cArr7[i13] = org.apache.commons.io.IOUtils.DIR_SEPARATOR_WINDOWS;
                    cArr7[i14] = IOUtils.replaceChars[c3];
                    i12++;
                }
            }
        }
        this.buf[this.count - 1] = '\'';
    }

    public void writeFieldName(String str) {
        writeFieldName(str, false);
    }

    public void writeFieldName(String str, boolean z) {
        if (str == null) {
            write("null:");
            return;
        }
        if (isEnabled(SerializerFeature.UseSingleQuotes)) {
            if (isEnabled(SerializerFeature.QuoteFieldNames)) {
                writeStringWithSingleQuote(str);
                write(':');
                return;
            } else {
                writeKeyWithSingleQuoteIfHasSpecial(str);
                return;
            }
        }
        if (isEnabled(SerializerFeature.QuoteFieldNames)) {
            writeStringWithDoubleQuote(str, ':', z);
        } else {
            writeKeyWithDoubleQuoteIfHasSpecial(str);
        }
    }

    private void writeKeyWithDoubleQuoteIfHasSpecial(String str) {
        byte[] bArr = IOUtils.specicalFlags_doubleQuotes;
        int length = str.length();
        boolean z = true;
        int i = this.count + length + 1;
        int i2 = 0;
        if (i > this.buf.length) {
            if (this.writer != null) {
                if (length == 0) {
                    write(Typography.quote);
                    write(Typography.quote);
                    write(':');
                    return;
                }
                int i3 = 0;
                while (true) {
                    if (i3 < length) {
                        char cCharAt = str.charAt(i3);
                        if (cCharAt < bArr.length && bArr[cCharAt] != 0) {
                            break;
                        } else {
                            i3++;
                        }
                    } else {
                        z = false;
                        break;
                    }
                }
                if (z) {
                    write(Typography.quote);
                }
                while (i2 < length) {
                    char cCharAt2 = str.charAt(i2);
                    if (cCharAt2 < bArr.length && bArr[cCharAt2] != 0) {
                        write(org.apache.commons.io.IOUtils.DIR_SEPARATOR_WINDOWS);
                        write(IOUtils.replaceChars[cCharAt2]);
                    } else {
                        write(cCharAt2);
                    }
                    i2++;
                }
                if (z) {
                    write(Typography.quote);
                }
                write(':');
                return;
            }
            expandCapacity(i);
        }
        if (length == 0) {
            int i4 = this.count;
            if (i4 + 3 > this.buf.length) {
                expandCapacity(i4 + 3);
            }
            char[] cArr = this.buf;
            int i5 = this.count;
            cArr[i5] = Typography.quote;
            cArr[i5 + 1] = Typography.quote;
            this.count = i5 + 3;
            cArr[i5 + 2] = ':';
            return;
        }
        int i6 = this.count;
        int i7 = i6 + length;
        str.getChars(0, length, this.buf, i6);
        this.count = i;
        int i8 = i6;
        boolean z2 = false;
        while (i8 < i7) {
            char[] cArr2 = this.buf;
            char c = cArr2[i8];
            if (c < bArr.length && bArr[c] != 0) {
                if (!z2) {
                    i += 3;
                    if (i > cArr2.length) {
                        expandCapacity(i);
                    }
                    this.count = i;
                    char[] cArr3 = this.buf;
                    int i9 = i8 + 1;
                    System.arraycopy(cArr3, i9, cArr3, i8 + 3, (i7 - i8) - 1);
                    char[] cArr4 = this.buf;
                    System.arraycopy(cArr4, i2, cArr4, 1, i8);
                    char[] cArr5 = this.buf;
                    cArr5[i6] = Typography.quote;
                    cArr5[i9] = org.apache.commons.io.IOUtils.DIR_SEPARATOR_WINDOWS;
                    i8 += 2;
                    cArr5[i8] = IOUtils.replaceChars[c];
                    i7 += 2;
                    this.buf[this.count - 2] = Typography.quote;
                    z2 = true;
                } else {
                    i++;
                    if (i > cArr2.length) {
                        expandCapacity(i);
                    }
                    this.count = i;
                    char[] cArr6 = this.buf;
                    int i10 = i8 + 1;
                    System.arraycopy(cArr6, i10, cArr6, i8 + 2, i7 - i8);
                    char[] cArr7 = this.buf;
                    cArr7[i8] = org.apache.commons.io.IOUtils.DIR_SEPARATOR_WINDOWS;
                    cArr7[i10] = IOUtils.replaceChars[c];
                    i7++;
                    i8 = i10;
                }
            }
            i8++;
            i2 = 0;
        }
        this.buf[this.count - 1] = ':';
    }

    private void writeKeyWithSingleQuoteIfHasSpecial(String str) {
        byte[] bArr = IOUtils.specicalFlags_singleQuotes;
        int length = str.length();
        boolean z = true;
        int i = this.count + length + 1;
        int i2 = 0;
        if (i > this.buf.length) {
            if (this.writer != null) {
                if (length == 0) {
                    write('\'');
                    write('\'');
                    write(':');
                    return;
                }
                int i3 = 0;
                while (true) {
                    if (i3 < length) {
                        char cCharAt = str.charAt(i3);
                        if (cCharAt < bArr.length && bArr[cCharAt] != 0) {
                            break;
                        } else {
                            i3++;
                        }
                    } else {
                        z = false;
                        break;
                    }
                }
                if (z) {
                    write('\'');
                }
                while (i2 < length) {
                    char cCharAt2 = str.charAt(i2);
                    if (cCharAt2 < bArr.length && bArr[cCharAt2] != 0) {
                        write(org.apache.commons.io.IOUtils.DIR_SEPARATOR_WINDOWS);
                        write(IOUtils.replaceChars[cCharAt2]);
                    } else {
                        write(cCharAt2);
                    }
                    i2++;
                }
                if (z) {
                    write('\'');
                }
                write(':');
                return;
            }
            expandCapacity(i);
        }
        if (length == 0) {
            int i4 = this.count;
            if (i4 + 3 > this.buf.length) {
                expandCapacity(i4 + 3);
            }
            char[] cArr = this.buf;
            int i5 = this.count;
            cArr[i5] = '\'';
            cArr[i5 + 1] = '\'';
            this.count = i5 + 3;
            cArr[i5 + 2] = ':';
            return;
        }
        int i6 = this.count;
        int i7 = i6 + length;
        str.getChars(0, length, this.buf, i6);
        this.count = i;
        int i8 = i6;
        boolean z2 = false;
        while (i8 < i7) {
            char[] cArr2 = this.buf;
            char c = cArr2[i8];
            if (c < bArr.length && bArr[c] != 0) {
                if (!z2) {
                    i += 3;
                    if (i > cArr2.length) {
                        expandCapacity(i);
                    }
                    this.count = i;
                    char[] cArr3 = this.buf;
                    int i9 = i8 + 1;
                    System.arraycopy(cArr3, i9, cArr3, i8 + 3, (i7 - i8) - 1);
                    char[] cArr4 = this.buf;
                    System.arraycopy(cArr4, i2, cArr4, 1, i8);
                    char[] cArr5 = this.buf;
                    cArr5[i6] = '\'';
                    cArr5[i9] = org.apache.commons.io.IOUtils.DIR_SEPARATOR_WINDOWS;
                    i8 += 2;
                    cArr5[i8] = IOUtils.replaceChars[c];
                    i7 += 2;
                    this.buf[this.count - 2] = '\'';
                    z2 = true;
                } else {
                    i++;
                    if (i > cArr2.length) {
                        expandCapacity(i);
                    }
                    this.count = i;
                    char[] cArr6 = this.buf;
                    int i10 = i8 + 1;
                    System.arraycopy(cArr6, i10, cArr6, i8 + 2, i7 - i8);
                    char[] cArr7 = this.buf;
                    cArr7[i8] = org.apache.commons.io.IOUtils.DIR_SEPARATOR_WINDOWS;
                    cArr7[i10] = IOUtils.replaceChars[c];
                    i7++;
                    i8 = i10;
                }
            }
            i8++;
            i2 = 0;
        }
        this.buf[i - 1] = ':';
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() {
        Writer writer = this.writer;
        if (writer == null) {
            return;
        }
        try {
            writer.write(this.buf, 0, this.count);
            this.writer.flush();
            this.count = 0;
        } catch (IOException e) {
            throw new JSONException(e.getMessage(), e);
        }
    }
}
