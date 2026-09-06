package com.ubixnow.ooooo;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class oOo00ooO {
    public static final int OooO = 9;
    public static final int OooO00o = 1;
    public static final int OooO0O0 = 2;
    public static final int OooO0OO = 3;
    public static final int OooO0Oo = 4;
    public static final int OooO0o = 6;
    public static final int OooO0o0 = 5;
    public static final int OooO0oO = 7;
    public static final int OooO0oo = 8;
    public static final int OooOO0 = 10;
    public static final int OooOO0O = 11;
    public static final int OooOO0o = 12;
    public static final int OooOOO = 14;
    public static final int OooOOO0 = 13;
    public static final int OooOOOO = 15;
    public static final int OooOOOo = 16;
    public static final int OooOOo = 18;
    public static final int OooOOo0 = 17;
    public static final Charset OooOOoo = Charset.forName("UTF-8");
    public static final Charset OooOo00 = Charset.forName("ISO-8859-1");
    public static final Object OooOo0 = new Object();

    private oOo00ooO() {
    }

    private static int OooO00o(Object obj) {
        return obj instanceof byte[] ? Arrays.hashCode((byte[]) obj) : obj.hashCode();
    }

    public static <K, V> int OooO00o(Map<K, V> map) {
        int iOooO00o = 0;
        if (map == null) {
            return 0;
        }
        for (Map.Entry<K, V> entry : map.entrySet()) {
            iOooO00o += OooO00o(entry.getValue()) ^ OooO00o(entry.getKey());
        }
        return iOooO00o;
    }

    public static <K, V> int OooO00o(Map<K, V> map, int i, int i2, int i3) {
        int iOooO0oO = oO00o00.OooO0oO(i);
        int iOooO0Oo = 0;
        for (Map.Entry<K, V> entry : map.entrySet()) {
            K key = entry.getKey();
            V value = entry.getValue();
            if (key == null || value == null) {
                throw new IllegalStateException("keys and values in maps cannot be null");
            }
            int iOooO00o = oO00o00.OooO00o(1, i2, key) + oO00o00.OooO00o(2, i3, value);
            iOooO0Oo += iOooO0oO + iOooO00o + oO00o00.OooO0Oo(iOooO00o);
        }
        return iOooO0Oo;
    }

    public static int OooO00o(double[] dArr) {
        if (dArr == null || dArr.length == 0) {
            return 0;
        }
        return Arrays.hashCode(dArr);
    }

    public static int OooO00o(float[] fArr) {
        if (fArr == null || fArr.length == 0) {
            return 0;
        }
        return Arrays.hashCode(fArr);
    }

    public static int OooO00o(int[] iArr) {
        if (iArr == null || iArr.length == 0) {
            return 0;
        }
        return Arrays.hashCode(iArr);
    }

    public static int OooO00o(long[] jArr) {
        if (jArr == null || jArr.length == 0) {
            return 0;
        }
        return Arrays.hashCode(jArr);
    }

    public static int OooO00o(Object[] objArr) {
        int length;
        int iHashCode;
        if (objArr == null) {
            length = 0;
            iHashCode = 0;
        } else {
            length = objArr.length;
            iHashCode = 0;
        }
        for (int i = 0; i < length; i++) {
            Object obj = objArr[i];
            if (obj != null) {
                iHashCode = (iHashCode * 31) + obj.hashCode();
            }
        }
        return iHashCode;
    }

    public static int OooO00o(boolean[] zArr) {
        if (zArr == null || zArr.length == 0) {
            return 0;
        }
        return Arrays.hashCode(zArr);
    }

    public static int OooO00o(byte[][] bArr) {
        int length;
        int iHashCode;
        if (bArr == null) {
            length = 0;
            iHashCode = 0;
        } else {
            length = bArr.length;
            iHashCode = 0;
        }
        for (int i = 0; i < length; i++) {
            byte[] bArr2 = bArr[i];
            if (bArr2 != null) {
                iHashCode = (iHashCode * 31) + Arrays.hashCode(bArr2);
            }
        }
        return iHashCode;
    }

    private static Object OooO00o(int i) {
        switch (i) {
            case 1:
                return Double.valueOf(0.0d);
            case 2:
                return Float.valueOf(0.0f);
            case 3:
            case 4:
            case 6:
            case 16:
            case 18:
                return 0L;
            case 5:
            case 7:
            case 13:
            case 14:
            case 15:
            case 17:
                return 0;
            case 8:
                return Boolean.FALSE;
            case 9:
                return "";
            case 10:
            case 11:
            default:
                throw new IllegalArgumentException("Type: " + i + " is not a primitive type.");
            case 12:
                return oO0O000.OooOOOo;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V> Map<K, V> OooO00o(oO00o000 oo00o000, Map<K, V> map, oOo000Oo.OooO0OO oooO0OO, int i, int i2, V v, int i3, int i4) throws IOException {
        Map<K, V> mapOooO00o = oooO0OO.OooO00o(map);
        int iOooO0Oo = oo00o000.OooO0Oo(oo00o000.OooOOOo());
        Object objOooO00o = null;
        while (true) {
            int iOooOo0o = oo00o000.OooOo0o();
            if (iOooOo0o == 0) {
                break;
            }
            if (iOooOo0o == i3) {
                objOooO00o = oo00o000.OooO0o0(i);
            } else if (iOooOo0o == i4) {
                if (i2 == 11) {
                    oo00o000.OooO00o((oOo0000O) v);
                } else {
                    v = (V) oo00o000.OooO0o0(i2);
                }
            } else if (!oo00o000.OooOO0(iOooOo0o)) {
                break;
            }
        }
        oo00o000.OooO00o(0);
        oo00o000.OooO0OO(iOooO0Oo);
        if (objOooO00o == null) {
            objOooO00o = OooO00o(i);
        }
        if (v == 0) {
            v = OooO00o(i2);
        }
        mapOooO00o.put(objOooO00o, v);
        return mapOooO00o;
    }

    public static <K, V> void OooO00o(oO00o00 oo00o00, Map<K, V> map, int i, int i2, int i3) throws IOException {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            K key = entry.getKey();
            V value = entry.getValue();
            if (key == null || value == null) {
                throw new IllegalStateException("keys and values in maps cannot be null");
            }
            int iOooO00o = oO00o00.OooO00o(1, i2, key) + oO00o00.OooO00o(2, i3, value);
            oo00o00.OooOO0o(i, 2);
            oo00o00.OooOOOO(iOooO00o);
            oo00o00.OooO0O0(1, i2, key);
            oo00o00.OooO0O0(2, i3, value);
        }
    }

    public static void OooO00o(oO0OOO00 oo0ooo00, oO0OOO00 oo0ooo01) {
        oO00o0 oo00o0 = oo0ooo00.OooO0O0;
        if (oo00o0 != null) {
            oo0ooo01.OooO0O0 = oo00o0.clone();
        }
    }

    private static boolean OooO00o(Object obj, Object obj2) {
        if (obj == null || obj2 == null) {
            throw new IllegalStateException("keys and values in maps cannot be null");
        }
        return ((obj instanceof byte[]) && (obj2 instanceof byte[])) ? Arrays.equals((byte[]) obj, (byte[]) obj2) : obj.equals(obj2);
    }

    public static <K, V> boolean OooO00o(Map<K, V> map, Map<K, V> map2) {
        if (map == map2) {
            return true;
        }
        if (map == null) {
            return map2.size() == 0;
        }
        if (map2 == null) {
            return map.size() == 0;
        }
        if (map.size() != map2.size()) {
            return false;
        }
        for (Map.Entry<K, V> entry : map.entrySet()) {
            if (!map2.containsKey(entry.getKey()) || !OooO00o(entry.getValue(), map2.get(entry.getKey()))) {
                return false;
            }
        }
        return true;
    }

    public static boolean OooO00o(double[] dArr, double[] dArr2) {
        if (dArr == null || dArr.length == 0) {
            return dArr2 == null || dArr2.length == 0;
        }
        return Arrays.equals(dArr, dArr2);
    }

    public static boolean OooO00o(float[] fArr, float[] fArr2) {
        if (fArr == null || fArr.length == 0) {
            return fArr2 == null || fArr2.length == 0;
        }
        return Arrays.equals(fArr, fArr2);
    }

    public static boolean OooO00o(int[] iArr, int[] iArr2) {
        if (iArr == null || iArr.length == 0) {
            return iArr2 == null || iArr2.length == 0;
        }
        return Arrays.equals(iArr, iArr2);
    }

    public static boolean OooO00o(long[] jArr, long[] jArr2) {
        if (jArr == null || jArr.length == 0) {
            return jArr2 == null || jArr2.length == 0;
        }
        return Arrays.equals(jArr, jArr2);
    }

    public static boolean OooO00o(Object[] objArr, Object[] objArr2) {
        int length;
        int i;
        int length2 = objArr == null ? 0 : objArr.length;
        if (objArr2 == null) {
            length = 0;
            i = 0;
        } else {
            length = objArr2.length;
            i = 0;
        }
        int i2 = i;
        while (true) {
            if (i >= length2 || objArr[i] != null) {
                while (i2 < length && objArr2[i2] == null) {
                    i2++;
                }
                boolean z = i >= length2;
                boolean z2 = i2 >= length;
                if (z && z2) {
                    return true;
                }
                if (z != z2 || !objArr[i].equals(objArr2[i2])) {
                    return false;
                }
                i++;
                i2++;
            } else {
                i++;
            }
        }
    }

    public static boolean OooO00o(boolean[] zArr, boolean[] zArr2) {
        if (zArr == null || zArr.length == 0) {
            return zArr2 == null || zArr2.length == 0;
        }
        return Arrays.equals(zArr, zArr2);
    }

    public static boolean OooO00o(byte[][] bArr, byte[][] bArr2) {
        int length;
        int i;
        int length2 = bArr == null ? 0 : bArr.length;
        if (bArr2 == null) {
            length = 0;
            i = 0;
        } else {
            length = bArr2.length;
            i = 0;
        }
        int i2 = i;
        while (true) {
            if (i >= length2 || bArr[i] != null) {
                while (i2 < length && bArr2[i2] == null) {
                    i2++;
                }
                boolean z = i >= length2;
                boolean z2 = i2 >= length;
                if (z && z2) {
                    return true;
                }
                if (z != z2 || !Arrays.equals(bArr[i], bArr2[i2])) {
                    return false;
                }
                i++;
                i2++;
            } else {
                i++;
            }
        }
    }

    public static byte[] OooO00o(String str) {
        return str.getBytes(OooOo00);
    }

    public static byte[] OooO0O0(String str) {
        return str.getBytes(OooOOoo);
    }

    public static String OooO0OO(String str) {
        return new String(str.getBytes(OooOo00), OooOOoo);
    }
}
