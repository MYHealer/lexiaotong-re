package com.adprof.sdk;

import java.io.IOException;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class uh extends di {
    public uh(b9 b9Var, Class cls) {
        super(b9Var, cls);
    }

    @Override // com.adprof.sdk.di
    public Object a(ei eiVar) throws IOException {
        long jM611a = eiVar.m611a();
        ((l6) eiVar.f258a).a(jM611a);
        l6 l6Var = (l6) eiVar.f258a;
        l6Var.getClass();
        Charset charset = eo.f1157a;
        eo.a(l6Var.f1279a, 0L, jM611a);
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        }
        if (jM611a > 2147483647L) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + jM611a);
        }
        if (jM611a == 0) {
            return "";
        }
        dl dlVar = l6Var.f436a;
        int i = dlVar.f1133a;
        if (((long) i) + jM611a > dlVar.b) {
            return new String(l6Var.m672a(jM611a), charset);
        }
        String str = new String(dlVar.f226a, i, (int) jM611a, charset);
        int i2 = (int) (((long) dlVar.f1133a) + jM611a);
        dlVar.f1133a = i2;
        l6Var.f1279a -= jM611a;
        if (i2 == dlVar.b) {
            l6Var.f436a = dlVar.a();
            el.a(dlVar);
        }
        return str;
    }

    @Override // com.adprof.sdk.di
    public void a(fi fiVar, Object obj) throws IOException {
        char cCharAt;
        int i;
        String str = (String) obj;
        l6 l6Var = (l6) fiVar.f1174a;
        l6Var.getClass();
        int length = str.length();
        if (length < 0) {
            throw new IllegalArgumentException("endIndex < beginIndex: " + length + " < 0");
        }
        if (length > str.length()) {
            throw new IllegalArgumentException("endIndex > string.length: " + length + " > " + str.length());
        }
        int i2 = 0;
        while (i2 < length) {
            char cCharAt2 = str.charAt(i2);
            if (cCharAt2 < 128) {
                dl dlVarA = l6Var.a(1);
                byte[] bArr = dlVarA.f226a;
                int i3 = dlVarA.b - i2;
                int iMin = Math.min(length, 8192 - i3);
                int i4 = i2 + 1;
                bArr[i2 + i3] = (byte) cCharAt2;
                while (true) {
                    i2 = i4;
                    if (i2 >= iMin || (cCharAt = str.charAt(i2)) >= 128) {
                        break;
                    }
                    i4 = i2 + 1;
                    bArr[i2 + i3] = (byte) cCharAt;
                }
                int i5 = dlVarA.b;
                int i6 = (i3 + i2) - i5;
                dlVarA.b = i5 + i6;
                l6Var.f1279a += (long) i6;
            } else {
                if (cCharAt2 < 2048) {
                    i = (cCharAt2 >> 6) | 192;
                } else if (cCharAt2 < 55296 || cCharAt2 > 57343) {
                    l6Var.m671a((cCharAt2 >> '\f') | 224);
                    i = ((cCharAt2 >> 6) & 63) | 128;
                } else {
                    int i7 = i2 + 1;
                    char cCharAt3 = i7 < length ? str.charAt(i7) : (char) 0;
                    if (cCharAt2 > 56319 || cCharAt3 < 56320 || cCharAt3 > 57343) {
                        l6Var.m671a(63);
                        i2 = i7;
                    } else {
                        int i8 = (((cCharAt2 & (-55297)) << 10) | ((-56321) & cCharAt3)) + 65536;
                        l6Var.m671a((i8 >> 18) | 240);
                        l6Var.m671a(((i8 >> 12) & 63) | 128);
                        l6Var.m671a(((i8 >> 6) & 63) | 128);
                        l6Var.m671a((i8 & 63) | 128);
                        i2 += 2;
                    }
                }
                l6Var.m671a(i);
                l6Var.m671a((cCharAt2 & '?') | 128);
                i2++;
            }
        }
    }

    @Override // com.adprof.sdk.di
    public int a(Object obj) {
        long j;
        String str = (String) obj;
        int length = str.length();
        if (length < 0) {
            throw new IllegalArgumentException("endIndex < beginIndex: " + length + " < 0");
        }
        if (length > str.length()) {
            throw new IllegalArgumentException("endIndex > string.length: " + length + " > " + str.length());
        }
        long j2 = 0;
        int i = 0;
        while (i < length) {
            char cCharAt = str.charAt(i);
            if (cCharAt < 128) {
                j2++;
            } else {
                if (cCharAt < 2048) {
                    j = 2;
                } else if (cCharAt < 55296 || cCharAt > 57343) {
                    j = 3;
                } else {
                    int i2 = i + 1;
                    char cCharAt2 = i2 < length ? str.charAt(i2) : (char) 0;
                    if (cCharAt > 56319 || cCharAt2 < 56320 || cCharAt2 > 57343) {
                        j2++;
                        i = i2;
                    } else {
                        j2 += 4;
                        i += 2;
                    }
                }
                j2 += j;
            }
            i++;
        }
        return (int) j2;
    }
}
