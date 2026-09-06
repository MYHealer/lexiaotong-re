package com.adprof.sdk;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Arrays;
import org.apache.commons.io.IOUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class q6 implements Serializable, Comparable {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public transient int f666a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public transient String f667a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final byte[] f668a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final char[] f665a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final q6 f1379a = new q6((byte[]) new byte[0].clone());

    public q6(byte[] bArr) {
        this.f668a = bArr;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        int i = objectInputStream.readInt();
        if (i < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + i);
        }
        byte[] bArr = new byte[i];
        int i2 = 0;
        while (i2 < i) {
            int i3 = objectInputStream.read(bArr, i2, i - i2);
            if (i3 == -1) {
                throw new EOFException();
            }
            i2 += i3;
        }
        q6 q6Var = new q6(bArr);
        try {
            Field declaredField = q6.class.getDeclaredField("a");
            declaredField.setAccessible(true);
            declaredField.set(this, q6Var.f668a);
        } catch (IllegalAccessException unused) {
            throw new AssertionError();
        } catch (NoSuchFieldException unused2) {
            throw new AssertionError();
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeInt(this.f668a.length);
        objectOutputStream.write(this.f668a);
    }

    public byte a(int i) {
        return this.f668a[i];
    }

    public int a() {
        return this.f668a.length;
    }

    public q6 a(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException("beginIndex < 0");
        }
        byte[] bArr = this.f668a;
        if (i2 > bArr.length) {
            throw new IllegalArgumentException("endIndex > length(" + this.f668a.length + ")");
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
        return new q6(bArr2);
    }

    /* JADX INFO: renamed from: a */
    public String mo627a() {
        byte[] bArr = this.f668a;
        char[] cArr = new char[bArr.length * 2];
        int i = 0;
        for (byte b : bArr) {
            int i2 = i + 1;
            char[] cArr2 = f665a;
            cArr[i] = cArr2[(b >> 4) & 15];
            i += 2;
            cArr[i2] = cArr2[b & 15];
        }
        return new String(cArr);
    }

    public void a(l6 l6Var) {
        byte[] bArr = this.f668a;
        l6Var.a(bArr, 0, bArr.length);
    }

    public boolean a(int i, byte[] bArr, int i2, int i3) {
        if (i >= 0) {
            byte[] bArr2 = this.f668a;
            if (i <= bArr2.length - i3 && i2 >= 0 && i2 <= bArr.length - i3 && eo.a(bArr2, i, bArr, i2, i3)) {
                return true;
            }
        }
        return false;
    }

    public String b() {
        String str = this.f667a;
        if (str != null) {
            return str;
        }
        String str2 = new String(this.f668a, eo.f1157a);
        this.f667a = str2;
        return str2;
    }

    /* JADX WARN: Code duplicated, block: B:12:0x002b A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:13:0x002d A[ORIG_RETURN, RETURN] */
    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        q6 q6Var = (q6) obj;
        int iA = a();
        int iA2 = q6Var.a();
        int iMin = Math.min(iA, iA2);
        for (int i = 0; i < iMin; i++) {
            int iA3 = a(i) & 255;
            int iA4 = q6Var.a(i) & 255;
            if (iA3 != iA4) {
                if (iA3 < iA4) {
                    return -1;
                }
                return 1;
            }
        }
        if (iA == iA2) {
            return 0;
        }
        if (iA < iA2) {
            return -1;
        }
        return 1;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof q6) {
            q6 q6Var = (q6) obj;
            int iA = q6Var.a();
            byte[] bArr = this.f668a;
            if (iA == bArr.length && q6Var.a(0, bArr, 0, bArr.length)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int i = this.f666a;
        if (i != 0) {
            return i;
        }
        int iHashCode = Arrays.hashCode(this.f668a);
        this.f666a = iHashCode;
        return iHashCode;
    }

    public String toString() {
        if (this.f668a.length == 0) {
            return "[size=0]";
        }
        String strB = b();
        int length = strB.length();
        int length2 = 0;
        int i = 0;
        while (true) {
            if (length2 >= length) {
                length2 = strB.length();
                break;
            }
            if (i != 64) {
                int iCodePointAt = strB.codePointAt(length2);
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
            return (this.f668a.length <= 64 ? new StringBuilder("[hex=").append(mo627a()).append("]") : new StringBuilder("[size=").append(this.f668a.length).append(" hex=").append(a(0, 64).mo627a()).append("…]")).toString();
        }
        String strReplace = strB.substring(0, length2).replace("\\", "\\\\").replace(IOUtils.LINE_SEPARATOR_UNIX, "\\n").replace("\r", "\\r");
        return (length2 < strB.length() ? new StringBuilder("[size=").append(this.f668a.length).append(" text=").append(strReplace).append("…]") : new StringBuilder("[text=").append(strReplace).append("]")).toString();
    }
}
