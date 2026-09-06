package com.ta.utdid2.a.a;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class f {

    /* JADX INFO: renamed from: com.ta.utdid2.a.a.f$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 {
    }

    private static class a {
        public int[] d;
        public int x;
        public int y;

        private a() {
            this.d = new int[256];
        }

        /* synthetic */ a(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    public static byte[] a(byte[] bArr) {
        a aVarA;
        if (bArr == null || (aVarA = a("QrMgt8GGYI6T52ZY5AnhtxkLzb8egpFn3j5JELI8H6wtACbUnZ5cc3aYTsTRbmkAkRJeYbtx92LPBWm7nBO9UIl7y5i5MQNmUZNf5QENurR5tGyo7yJ2G0MBjWvy6iAtlAbacKP0SwOUeUWx5dsBdyhxa7Id1APtybSdDgicBDuNjI0mlZFUzZSS9dmN8lBD0WTVOMz0pRZbR3cysomRXOO1ghqjJdTcyDIxzpNAEszN8RMGjrzyU7Hjbmwi6YNK")) == null) {
            return null;
        }
        return a(bArr, aVarA);
    }

    private static a a(String str) {
        AnonymousClass1 anonymousClass1 = null;
        if (str == null) {
            return null;
        }
        a aVar = new a(anonymousClass1);
        for (int i = 0; i < 256; i++) {
            aVar.d[i] = i;
        }
        aVar.x = 0;
        aVar.y = 0;
        int length = 0;
        int iCharAt = 0;
        for (int i2 = 0; i2 < 256; i2++) {
            try {
                iCharAt = ((str.charAt(length) + aVar.d[i2]) + iCharAt) % 256;
                int i3 = aVar.d[i2];
                aVar.d[i2] = aVar.d[iCharAt];
                aVar.d[iCharAt] = i3;
                length = (length + 1) % str.length();
            } catch (Exception unused) {
                return null;
            }
        }
        return aVar;
    }

    private static byte[] a(byte[] bArr, a aVar) {
        if (bArr == null || aVar == null) {
            return null;
        }
        int i = aVar.x;
        int i2 = aVar.y;
        for (int i3 = 0; i3 < bArr.length; i3++) {
            i = (i + 1) % 256;
            i2 = (aVar.d[i] + i2) % 256;
            int i4 = aVar.d[i];
            aVar.d[i] = aVar.d[i2];
            aVar.d[i2] = i4;
            int i5 = (aVar.d[i] + aVar.d[i2]) % 256;
            bArr[i3] = (byte) (aVar.d[i5] ^ bArr[i3]);
        }
        aVar.x = i;
        aVar.y = i2;
        return bArr;
    }
}
