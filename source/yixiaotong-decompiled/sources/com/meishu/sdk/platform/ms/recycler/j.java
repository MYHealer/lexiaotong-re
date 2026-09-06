package com.meishu.sdk.platform.ms.recycler;

import com.meishu.sdk.core.ad.recycler.RecylcerAdInteractionListener;
import com.meishu.sdk.platform.ms.splash.ShakeResult;
import com.meishu.sdk.platform.ms.splash.ShakeUtil;

/* JADX INFO: compiled from: MeishuPreRenderAdapter.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class j implements ShakeUtil.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f5211a;
    public final /* synthetic */ i b;

    public j(i iVar, long j) {
        this.b = iVar;
        this.f5211a = j;
    }

    @Override // com.meishu.sdk.platform.ms.splash.ShakeUtil.c
    public void onShake(int i, boolean z, int i2, ShakeResult shakeResult) {
        RecylcerAdInteractionListener recylcerAdInteractionListener;
        ShakeUtil.getInstance().a(this.b.i);
        if (this.b.f5193a.a().getCbc() == 0 && (recylcerAdInteractionListener = this.b.d) != null) {
            recylcerAdInteractionListener.onAdClicked();
        }
        if (shakeResult != null) {
            shakeResult.setTotalTurnTime(System.currentTimeMillis() - this.f5211a);
        }
        this.b.f5193a.a().setClkActType(i);
        this.b.f5193a.a().setClkPower(i2);
        this.b.f5193a.a().setShakeResult(shakeResult);
        com.meishu.sdk.core.utils.f.a(this.b.f5193a, i2 >= 50);
    }
}
