package com.miui.zeus.mimo.sdk.ad.reward.view;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
final /* synthetic */ class RewardPlayablePBottomView$$Lambda$1 implements Runnable {
    private final RewardPlayablePBottomView arg$1;

    private RewardPlayablePBottomView$$Lambda$1(RewardPlayablePBottomView rewardPlayablePBottomView) {
        this.arg$1 = rewardPlayablePBottomView;
    }

    public static Runnable lambdaFactory$(RewardPlayablePBottomView rewardPlayablePBottomView) {
        return new RewardPlayablePBottomView$$Lambda$1(rewardPlayablePBottomView);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.arg$1.a();
    }
}
