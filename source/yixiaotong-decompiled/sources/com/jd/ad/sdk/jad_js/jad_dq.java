package com.jd.ad.sdk.jad_js;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public abstract class jad_dq {

    public static /* synthetic */ class jad_an {
    }

    public static class jad_bo extends jad_dq {
        public volatile boolean jad_an;

        public jad_bo() {
            super(null);
        }

        @Override // com.jd.ad.sdk.jad_js.jad_dq
        public void jad_bo() {
            if (this.jad_an) {
                throw new IllegalStateException("Already released");
            }
        }
    }

    public jad_dq() {
    }

    public /* synthetic */ jad_dq(jad_an jad_anVar) {
        this();
    }

    public static jad_dq jad_an() {
        return new jad_bo();
    }

    public abstract void jad_bo();
}
