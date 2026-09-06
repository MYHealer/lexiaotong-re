package com.kwad.components.ad.reward.monitor;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public enum LivePlayMonitorType {
    AD_LIVE_IMPL_LOAD_ERROR(1),
    LIVE_PLAY_MODULE_RELEASE_INNER_EXCEPTION(9);

    private int type;

    public final int getValue() {
        return this.type;
    }

    LivePlayMonitorType(int i) {
        this.type = i;
    }
}
