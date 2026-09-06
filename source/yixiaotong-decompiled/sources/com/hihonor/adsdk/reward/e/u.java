package com.hihonor.adsdk.reward.e;

import android.content.Context;
import android.view.View;
import com.hihonor.adsdk.common.video.AdVideoSize;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class u extends b {
    public u(View view, Context context) {
        super(view, context);
    }

    @Override // com.hihonor.adsdk.reward.e.b
    protected void v() {
        this.I.setVideoViewSize(new AdVideoSize(this.Q, this.R), 1, this.Q);
    }
}
