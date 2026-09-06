package com.yfanads.android.adx.components.rewardvideo;

import android.os.CountDownTimer;
import java.util.Arrays;

/* JADX INFO: compiled from: AdxRewardVideoActivity.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public final class c extends CountDownTimer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int[] f9583a;
    public final /* synthetic */ AdxRewardVideoActivity b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(AdxRewardVideoActivity adxRewardVideoActivity, long j, int[] iArr) {
        super(j, 1000L);
        this.b = adxRewardVideoActivity;
        this.f9583a = iArr;
    }

    @Override // android.os.CountDownTimer
    public final void onFinish() {
        if (this.f9583a[0] != 0) {
            AdxRewardVideoActivity adxRewardVideoActivity = this.b;
            adxRewardVideoActivity.r = false;
            adxRewardVideoActivity.p = true;
            adxRewardVideoActivity.d();
            adxRewardVideoActivity.i();
            adxRewardVideoActivity.e();
            adxRewardVideoActivity.b.a();
            adxRewardVideoActivity.h = 0;
            adxRewardVideoActivity.g = 0;
            adxRewardVideoActivity.c();
            com.yfanads.android.adx.utils.a.a("AdxRewardVideoActivity startAfterClickTimer completeExperience onFinish");
        }
    }

    @Override // android.os.CountDownTimer
    public final void onTick(long j) {
        this.f9583a[0] = (int) (j / 1000);
        com.yfanads.android.adx.utils.a.a("AdxRewardVideoActivity startAfterClickTimer onTick time=" + Arrays.toString(this.f9583a));
        if (this.f9583a[0] == 0) {
            AdxRewardVideoActivity adxRewardVideoActivity = this.b;
            adxRewardVideoActivity.r = false;
            adxRewardVideoActivity.p = true;
            adxRewardVideoActivity.d();
            adxRewardVideoActivity.i();
            adxRewardVideoActivity.e();
            adxRewardVideoActivity.b.a();
            adxRewardVideoActivity.h = 0;
            adxRewardVideoActivity.g = 0;
            adxRewardVideoActivity.c();
            com.yfanads.android.adx.utils.a.a("AdxRewardVideoActivity startAfterClickTimer completeExperience " + Arrays.toString(this.f9583a));
        }
    }
}
