package com.byazt.na;

import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Arrays;
import org.apache.commons.io.IOUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 662, 15})
public class uj implements Serializable, Comparable<uj> {
    public static final char[] c = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    public static final Charset tt = Charset.forName("UTF-8");
    public static final uj ve = c(new byte[0]);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient String f2490a;
    public transient int n;
    public final byte[] uj;

    public uj(byte[] bArr) {
        this.uj = bArr;
    }

    public static uj c(byte... bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("data == null");
        }
        return new uj((byte[]) bArr.clone());
    }

    public String c() {
        String str = this.f2490a;
        if (str != null) {
            return str;
        }
        String str2 = new String(this.uj, tt);
        this.f2490a = str2;
        return str2;
    }

    public static uj c(String str) {
        if (str == null) {
            throw new IllegalArgumentException("s == null");
        }
        uj ujVar = new uj(str.getBytes(da.c));
        ujVar.f2490a = str;
        return ujVar;
    }

    public String tt() {
        byte[] bArr = this.uj;
        char[] cArr = new char[bArr.length * 2];
        int i = 0;
        for (byte b : bArr) {
            int i2 = i + 1;
            char[] cArr2 = c;
            cArr[i] = cArr2[(b >> 4) & 15];
            i += 2;
            cArr[i2] = cArr2[b & 15];
        }
        return new String(cArr);
    }

    public uj c(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException("beginIndex < 0");
        }
        byte[] bArr = this.uj;
        if (i2 > bArr.length) {
            throw new IllegalArgumentException("endIndex > length(" + this.uj.length + ")");
        }
        int i3 = i2 - i;
        if (i3 < 0) {
            throw new IllegalArgumentException("endIndex < beginIndex");
        }
        if (i == 0 && i2 == bArr.length) {
            return this;
        }
        byte[] bArr2 = new byte[i3];
        System.arraycopy(bArr, i, bArr2, 0, i3);
        return new uj(bArr2);
    }

    public byte c(int i) {
        return this.uj[i];
    }

    public int ve() {
        return this.uj.length;
    }

    public byte[] uj() {
        return (byte[]) this.uj.clone();
    }

    public boolean c(int i, uj ujVar, int i2, int i3) {
        return ujVar.c(i2, this.uj, i, i3);
    }

    public boolean c(int i, byte[] bArr, int i2, int i3) {
        if (i < 0) {
            return false;
        }
        byte[] bArr2 = this.uj;
        return i <= bArr2.length - i3 && i2 >= 0 && i2 <= bArr.length - i3 && da.c(bArr2, i, bArr, i2, i3);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof uj) {
            uj ujVar = (uj) obj;
            int iVe = ujVar.ve();
            byte[] bArr = this.uj;
            if (iVe == bArr.length && ujVar.c(0, bArr, 0, bArr.length)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int i = this.n;
        if (i != 0) {
            return i;
        }
        int iHashCode = Arrays.hashCode(this.uj);
        this.n = iHashCode;
        return iHashCode;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public int compareTo(uj ujVar) {
        int iVe = ve();
        int iVe2 = ujVar.ve();
        int iMin = Math.min(iVe, iVe2);
        for (int i = 0; i < iMin; i++) {
            int iC = c(i) & 255;
            int iC2 = ujVar.c(i) & 255;
            if (iC != iC2) {
                return iC < iC2 ? -1 : 1;
            }
        }
        if (iVe == iVe2) {
            return 0;
        }
        return iVe < iVe2 ? -1 : 1;
    }

    public String toString() {
        if (this.uj.length == 0) {
            return "[size=0]";
        }
        String strC = c();
        int iC = c(strC, 64);
        if (iC == -1) {
            if (this.uj.length <= 64) {
                return "[hex=" + tt() + "]";
            }
            return "[size=" + this.uj.length + " hex=" + c(0, 64).tt() + "…]";
        }
        String strReplace = strC.substring(0, iC).replace("\\", "\\\\").replace(IOUtils.LINE_SEPARATOR_UNIX, "\\n").replace("\r", "\\r");
        return iC < strC.length() ? "[size=" + this.uj.length + " text=" + strReplace + "…]" : "[text=" + strReplace + "]";
    }

    public static int c(String str, int i) {
        int length = str.length();
        int iCharCount = 0;
        int i2 = 0;
        while (iCharCount < length) {
            if (i2 == i) {
                return iCharCount;
            }
            int iCodePointAt = str.codePointAt(iCharCount);
            if ((Character.isISOControl(iCodePointAt) && iCodePointAt != 10 && iCodePointAt != 13) || iCodePointAt == 65533) {
                return -1;
            }
            i2++;
            iCharCount += Character.charCount(iCodePointAt);
        }
        return str.length();
    }
}
