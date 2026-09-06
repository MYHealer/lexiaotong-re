package com.jd.ad.sdk.jad_te;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public abstract class jad_iv {
    public static final jad_iv jad_an = new jad_bo();
    public static final jad_iv jad_bo;
    public static final jad_iv jad_cp;
    public static final com.jd.ad.sdk.jad_ju.jad_iv<jad_iv> jad_dq;
    public static final boolean jad_er;

    public static class jad_an extends jad_iv {
        @Override // com.jd.ad.sdk.jad_te.jad_iv
        public int jad_an(int i, int i2, int i3, int i4) {
            return 2;
        }

        @Override // com.jd.ad.sdk.jad_te.jad_iv
        public float jad_bo(int i, int i2, int i3, int i4) {
            return Math.max(i3 / i, i4 / i2);
        }
    }

    public static class jad_bo extends jad_iv {
        @Override // com.jd.ad.sdk.jad_te.jad_iv
        public int jad_an(int i, int i2, int i3, int i4) {
            return jad_iv.jad_er ? 2 : 1;
        }

        @Override // com.jd.ad.sdk.jad_te.jad_iv
        public float jad_bo(int i, int i2, int i3, int i4) {
            if (jad_iv.jad_er) {
                return Math.min(i3 / i, i4 / i2);
            }
            int iMax = Math.max(i2 / i4, i / i3);
            if (iMax == 0) {
                return 1.0f;
            }
            return 1.0f / Integer.highestOneBit(iMax);
        }
    }

    public static class jad_cp extends jad_iv {
        @Override // com.jd.ad.sdk.jad_te.jad_iv
        public int jad_an(int i, int i2, int i3, int i4) {
            return 2;
        }

        @Override // com.jd.ad.sdk.jad_te.jad_iv
        public float jad_bo(int i, int i2, int i3, int i4) {
            return 1.0f;
        }
    }

    static {
        jad_an jad_anVar = new jad_an();
        jad_bo = new jad_cp();
        jad_cp = jad_anVar;
        jad_dq = com.jd.ad.sdk.jad_ju.jad_iv.jad_an("com.jd.ad.sdk.glide.load.resource.bitmap.Downsampler.DownsampleStrategy", jad_anVar);
        jad_er = true;
    }

    public abstract int jad_an(int i, int i2, int i3, int i4);

    public abstract float jad_bo(int i, int i2, int i3, int i4);
}
