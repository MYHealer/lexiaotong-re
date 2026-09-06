package com.hihonor.adsdk.common.f.e0;

import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.Vector;
import org.apache.commons.io.IOUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public final class e {
    private static String hnadsa;

    class a implements PrivilegedAction<String> {
        a() {
        }

        @Override // java.security.PrivilegedAction
        /* JADX INFO: renamed from: hnadsa, reason: merged with bridge method [inline-methods] */
        public String run() {
            return System.getProperty("line.separator");
        }
    }

    private static class b extends ArrayList<String> implements d {
        private b() {
        }

        @Override // java.util.ArrayList, java.util.AbstractList, java.util.List, com.hihonor.adsdk.common.f.e0.d
        public /* bridge */ /* synthetic */ String get(int i) {
            return (String) super.get(i);
        }

        @Override // java.util.ArrayList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
        /* JADX INFO: renamed from: hnadsa, reason: merged with bridge method [inline-methods] */
        public boolean add(String str) {
            return super.add(str);
        }

        @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
        /* JADX INFO: renamed from: hnadsb, reason: merged with bridge method [inline-methods] */
        public String set(int i, String str) {
            return (String) super.set(i, str);
        }

        /* synthetic */ b(a aVar) {
            this();
        }

        @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
        /* JADX INFO: renamed from: hnadsa, reason: merged with bridge method [inline-methods] */
        public void add(int i, String str) {
            super.add(i, str);
        }

        @Override // com.hihonor.adsdk.common.f.e0.d
        public String[] hnadsa() {
            int size = size();
            String[] strArr = new String[size];
            for (int i = 0; i != size; i++) {
                strArr[i] = get(i);
            }
            return strArr;
        }

        @Override // com.hihonor.adsdk.common.f.e0.d
        public String[] hnadsa(int i, int i2) {
            String[] strArr = new String[i2 - i];
            for (int i3 = i; i3 != size() && i3 != i2; i3++) {
                strArr[i3 - i] = get(i3);
            }
            return strArr;
        }
    }

    static {
        try {
            hnadsa = (String) AccessController.doPrivileged(new a());
        } catch (Exception unused) {
            try {
                hnadsa = String.format("%n", new Object[0]);
            } catch (Exception unused2) {
                hnadsa = IOUtils.LINE_SEPARATOR_UNIX;
            }
        }
    }

    public static String hnadsa() {
        return hnadsa;
    }

    public static byte[] hnadsa(char[] cArr) {
        int length = cArr.length;
        byte[] bArr = new byte[length];
        for (int i = 0; i != length; i++) {
            bArr[i] = (byte) cArr[i];
        }
        return bArr;
    }

    public static String hnadsb(String str) {
        char[] charArray = str.toCharArray();
        boolean z = false;
        for (int i = 0; i != charArray.length; i++) {
            char c = charArray[i];
            if ('A' <= c && 'Z' >= c) {
                charArray[i] = (char) (c + ' ');
                z = true;
            }
        }
        return z ? new String(charArray) : str;
    }

    public static String hnadsc(byte[] bArr) {
        char[] cArr = new char[bArr.length];
        int iHnadsa = f.hnadsa(bArr, cArr);
        if (iHnadsa >= 0) {
            return new String(cArr, 0, iHnadsa);
        }
        throw new IllegalArgumentException("Invalid UTF-8 input");
    }

    public static byte[] hnadsa(String str) {
        int length = str.length();
        byte[] bArr = new byte[length];
        for (int i = 0; i != length; i++) {
            bArr[i] = (byte) str.charAt(i);
        }
        return bArr;
    }

    public static String hnadsc(String str) {
        char[] charArray = str.toCharArray();
        boolean z = false;
        for (int i = 0; i != charArray.length; i++) {
            char c = charArray[i];
            if ('a' <= c && 'z' >= c) {
                charArray[i] = (char) (c - ' ');
                z = true;
            }
        }
        return z ? new String(charArray) : str;
    }

    public static int hnadsa(String str, byte[] bArr, int i) {
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            bArr[i + i2] = (byte) str.charAt(i2);
        }
        return length;
    }

    public static String hnadsb(byte[] bArr) {
        return new String(hnadsa(bArr));
    }

    public static d hnadsb() {
        return new b(null);
    }

    public static boolean hnadsa(String str, String str2) {
        boolean z = str.length() == str2.length();
        int length = str.length();
        for (int i = 0; i != length; i++) {
            z &= str.charAt(i) == str2.charAt(i);
        }
        return z;
    }

    public static char[] hnadsa(byte[] bArr) {
        int length = bArr.length;
        char[] cArr = new char[length];
        for (int i = 0; i != length; i++) {
            cArr[i] = (char) (bArr[i] & 255);
        }
        return cArr;
    }

    public static String[] hnadsa(String str, char c) {
        int i;
        Vector vector = new Vector();
        boolean z = true;
        while (true) {
            if (!z) {
                break;
            }
            int iIndexOf = str.indexOf(c);
            if (iIndexOf > 0) {
                vector.addElement(str.substring(0, iIndexOf));
                str = str.substring(iIndexOf + 1);
            } else {
                vector.addElement(str);
                z = false;
            }
        }
        int size = vector.size();
        String[] strArr = new String[size];
        for (i = 0; i != size; i++) {
            strArr[i] = (String) vector.elementAt(i);
        }
        return strArr;
    }
}
