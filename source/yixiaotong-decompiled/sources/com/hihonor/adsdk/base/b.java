package com.hihonor.adsdk.base;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class b extends AdSlot {
    private int hnadsa;

    public b(AdSlot.Builder builder) {
        super(builder);
        this.hnadsa = 0;
    }

    public void hnadsa(int i) {
        this.hnadsa = i;
    }

    public static int hnadsa(AdSlot adSlot) {
        if (adSlot instanceof b) {
            return ((b) adSlot).hnadsa;
        }
        return 0;
    }
}
