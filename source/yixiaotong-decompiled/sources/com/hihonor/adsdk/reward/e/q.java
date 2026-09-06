package com.hihonor.adsdk.reward.e;

import android.content.Context;
import android.view.View;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class q extends b {
    private static final String W = "RewardHolderBaseHorizontalByMaxAdaptFolding";

    public q(View view, Context context) {
        super(view, context);
    }

    @Override // com.hihonor.adsdk.reward.e.b
    protected void v() {
        this.I.setVideoViewSize(this.P, 1, this.R);
        if (this.I.getFinalPlayerSize().getHeight() > this.Q) {
            com.hihonor.adsdk.common.b.b.hnadsc(W, "zoomVideoBaseHorizontalByMaxAdaptFolding() resize for horizontal & horizontal", new Object[0]);
            w();
        }
    }
}
