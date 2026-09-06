package com.miui.zeus.mimo.sdk;

import com.miui.zeus.mimo.sdk.ad.reward.view.RewardPSkipCountDownView;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class l2 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5516a;
    public final /* synthetic */ long b;
    public final /* synthetic */ j2 c;

    public l2(j2 j2Var, int i, long j) {
        this.c = j2Var;
        this.f5516a = i;
        this.b = j;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.c.a(this.f5516a, this.b)) {
            return;
        }
        j2 j2Var = this.c;
        j2Var.y = true;
        w3 w3Var = j2Var.g;
        if (w3Var != null) {
            w3Var.onGetReward(this.f5516a);
        }
        this.c.a(this.f5516a);
        RewardPSkipCountDownView rewardPSkipCountDownView = this.c.i;
        if (rewardPSkipCountDownView != null) {
            rewardPSkipCountDownView.a();
        }
    }
}
