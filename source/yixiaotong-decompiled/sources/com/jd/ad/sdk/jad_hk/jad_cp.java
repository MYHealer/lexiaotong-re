package com.jd.ad.sdk.jad_hk;

import java.io.Serializable;
import java.util.Arrays;
import org.apache.commons.io.IOUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_cp implements Serializable, Comparable<jad_cp> {
    public static final char[] jad_dq = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    public static final jad_cp jad_er = new jad_cp((byte[]) new byte[0].clone());
    public final byte[] jad_an;
    public transient int jad_bo;
    public transient String jad_cp;

    public jad_cp(byte[] bArr) {
        this.jad_an = bArr;
    }

    public static jad_cp jad_an(String str) {
        jad_cp jad_cpVar = new jad_cp(str.getBytes(jad_ob.jad_an));
        jad_cpVar.jad_cp = str;
        return jad_cpVar;
    }

    /* JADX WARN: Code duplicated, block: B:12:0x002b A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:13:0x002d A[ORIG_RETURN, RETURN] */
    @Override // java.lang.Comparable
    public int compareTo(jad_cp jad_cpVar) {
        jad_cp jad_cpVar2 = jad_cpVar;
        int iJad_cp = jad_cp();
        int iJad_cp2 = jad_cpVar2.jad_cp();
        int iMin = Math.min(iJad_cp, iJad_cp2);
        for (int i = 0; i < iMin; i++) {
            int iJad_an = jad_an(i) & 255;
            int iJad_an2 = jad_cpVar2.jad_an(i) & 255;
            if (iJad_an != iJad_an2) {
                if (iJad_an < iJad_an2) {
                    return -1;
                }
                return 1;
            }
        }
        if (iJad_cp == iJad_cp2) {
            return 0;
        }
        if (iJad_cp < iJad_cp2) {
            return -1;
        }
        return 1;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof jad_cp) {
            jad_cp jad_cpVar = (jad_cp) obj;
            int iJad_cp = jad_cpVar.jad_cp();
            byte[] bArr = this.jad_an;
            if (iJad_cp == bArr.length && jad_cpVar.jad_an(0, bArr, 0, bArr.length)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int i = this.jad_bo;
        if (i != 0) {
            return i;
        }
        int iHashCode = Arrays.hashCode(this.jad_an);
        this.jad_bo = iHashCode;
        return iHashCode;
    }

    public byte jad_an(int i) {
        return this.jad_an[i];
    }

    public jad_cp jad_an(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException("beginIndex < 0");
        }
        byte[] bArr = this.jad_an;
        if (i2 > bArr.length) {
            throw new IllegalArgumentException(jad_pc.jad_an("endIndex > length(").append(this.jad_an.length).append(")").toString());
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
        return new jad_cp(bArr2);
    }

    public String jad_an() {
        byte[] bArr = this.jad_an;
        char[] cArr = new char[bArr.length * 2];
        int i = 0;
        for (byte b : bArr) {
            int i2 = i + 1;
            char[] cArr2 = jad_dq;
            cArr[i] = cArr2[(b >> 4) & 15];
            i += 2;
            cArr[i2] = cArr2[b & 15];
        }
        return new String(cArr);
    }

    public boolean jad_an(int i, jad_cp jad_cpVar, int i2, int i3) {
        return jad_cpVar.jad_an(i2, this.jad_an, i, i3);
    }

    public boolean jad_an(int i, byte[] bArr, int i2, int i3) {
        if (i >= 0) {
            byte[] bArr2 = this.jad_an;
            if (i <= bArr2.length - i3 && i2 >= 0 && i2 <= bArr.length - i3 && jad_ob.jad_an(bArr2, i, bArr, i2, i3)) {
                return true;
            }
        }
        return false;
    }

    public byte[] jad_bo() {
        return this.jad_an;
    }

    public int jad_cp() {
        return this.jad_an.length;
    }

    public String jad_dq() {
        String str = this.jad_cp;
        if (str != null) {
            return str;
        }
        String str2 = new String(this.jad_an, jad_ob.jad_an);
        this.jad_cp = str2;
        return str2;
    }

    public String toString() {
        if (this.jad_an.length == 0) {
            return "[size=0]";
        }
        String strJad_dq = jad_dq();
        int length = strJad_dq.length();
        int length2 = 0;
        int i = 0;
        while (true) {
            if (length2 >= length) {
                length2 = strJad_dq.length();
                break;
            }
            if (i != 64) {
                int iCodePointAt = strJad_dq.codePointAt(length2);
                if ((Character.isISOControl(iCodePointAt) && iCodePointAt != 10 && iCodePointAt != 13) || iCodePointAt == 65533) {
                    length2 = -1;
                    break;
                }
                i++;
                length2 += Character.charCount(iCodePointAt);
            } else {
                break;
            }
        }
        if (length2 == -1) {
            return (this.jad_an.length <= 64 ? jad_pc.jad_an("[hex=").append(jad_an()).append("]") : jad_pc.jad_an("[size=").append(this.jad_an.length).append(" hex=").append(jad_an(0, 64).jad_an()).append("…]")).toString();
        }
        String strReplace = strJad_dq.substring(0, length2).replace("\\", "\\\\").replace(IOUtils.LINE_SEPARATOR_UNIX, "\\n").replace("\r", "\\r");
        return (length2 < strJad_dq.length() ? jad_pc.jad_an("[size=").append(this.jad_an.length).append(" text=").append(strReplace).append("…]") : new StringBuilder("[text=").append(strReplace).append("]")).toString();
    }
}
