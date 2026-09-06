package com.miui.zeus.mimo.sdk.ad.reward;

import android.os.Build;
import android.os.Bundle;
import com.miui.zeus.mimo.sdk.bean.MimoAdInfo;
import com.miui.zeus.mimo.sdk.z1;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class RewardVideoAdActivityMiniGame extends RewardVideoAdActivityNewPE {
    static {
        StubApp.interface11(46515);
    }

    @Override // com.miui.zeus.mimo.sdk.ad.reward.RewardVideoAdActivityNewPE
    public z1 a(MimoAdInfo mimoAdInfo) {
        return mimoAdInfo.y() ? new RewardPlayableView(this) : new RewardView(this);
    }

    @Override // com.miui.zeus.mimo.sdk.ad.reward.RewardVideoAdActivityNewPE
    public void a() {
        if (Build.VERSION.SDK_INT == 26) {
            return;
        }
        super.a();
    }

    @Override // com.miui.zeus.mimo.sdk.ad.reward.RewardVideoAdActivityNewPE, android.app.Activity
    public native void onCreate(Bundle bundle);
}
