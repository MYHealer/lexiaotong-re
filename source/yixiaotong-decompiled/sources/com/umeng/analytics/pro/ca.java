package com.umeng.analytics.pro;

import java.util.BitSet;

/* JADX INFO: compiled from: TTupleProtocol.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class ca extends bo {

    /* JADX INFO: compiled from: TTupleProtocol.java */
    public static class a implements bw {
        @Override // com.umeng.analytics.pro.bw
        public bu a(ci ciVar) {
            return new ca(ciVar);
        }
    }

    public ca(ci ciVar) {
        super(ciVar);
    }

    @Override // com.umeng.analytics.pro.bu
    public Class<? extends cc> D() {
        return cf.class;
    }

    public void a(BitSet bitSet, int i) throws bb {
        for (byte b : b(bitSet, i)) {
            a(b);
        }
    }

    public BitSet b(int i) throws bb {
        int iCeil = (int) Math.ceil(((double) i) / 8.0d);
        byte[] bArr = new byte[iCeil];
        for (int i2 = 0; i2 < iCeil; i2++) {
            bArr[i2] = u();
        }
        return a(bArr);
    }

    public static BitSet a(byte[] bArr) {
        BitSet bitSet = new BitSet();
        for (int i = 0; i < bArr.length * 8; i++) {
            if ((bArr[(bArr.length - (i / 8)) - 1] & (1 << (i % 8))) > 0) {
                bitSet.set(i);
            }
        }
        return bitSet;
    }

    public static byte[] b(BitSet bitSet, int i) {
        int iCeil = (int) Math.ceil(((double) i) / 8.0d);
        byte[] bArr = new byte[iCeil];
        for (int i2 = 0; i2 < bitSet.length(); i2++) {
            if (bitSet.get(i2)) {
                int i3 = (iCeil - (i2 / 8)) - 1;
                bArr[i3] = (byte) ((1 << (i2 % 8)) | bArr[i3]);
            }
        }
        return bArr;
    }
}
