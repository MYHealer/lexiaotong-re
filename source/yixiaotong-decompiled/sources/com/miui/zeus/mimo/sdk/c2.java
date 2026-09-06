package com.miui.zeus.mimo.sdk;

import android.view.View;
import com.miui.zeus.mimo.sdk.ad.reward.RewardVideoAdActivityNewPE;
import com.miui.zeus.mimo.sdk.bean.MimoAdInfo;
import com.miui.zeus.mimo.sdk.common.ViewMeasureHelper;
import com.miui.zeus.mimo.sdk.track.info.AdEvent;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class c2 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ z1 f5383a;
    public final /* synthetic */ RewardVideoAdActivityNewPE b;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f5384a;

        public a(View view) {
            this.f5384a = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            MimoAdInfo mimoAdInfo = c2.this.b.c;
            if (mimoAdInfo != null) {
                mimoAdInfo.V = true;
                this.f5384a.setTag(Boolean.TRUE);
                AdEvent adEvent = AdEvent.VIEW;
                RewardVideoAdActivityNewPE rewardVideoAdActivityNewPE = c2.this.b;
                MimoAdInfo mimoAdInfo2 = rewardVideoAdActivityNewPE.c;
                String str = rewardVideoAdActivityNewPE.b;
                o6 o6Var = rewardVideoAdActivityNewPE.d.f5396a;
                String strValueOf = String.valueOf(mimoAdInfo2.v());
                k6 k6Var = new k6();
                k6Var.f = str;
                k6Var.b = o6Var;
                k6Var.c = strValueOf;
                b.a(adEvent, mimoAdInfo2, (n6) null, k6Var);
                b2 b2Var = c2.this.b.e;
                if (b2Var != null) {
                    b2Var.onAdPresent();
                }
            }
        }
    }

    public c2(RewardVideoAdActivityNewPE rewardVideoAdActivityNewPE, z1 z1Var) {
        this.b = rewardVideoAdActivityNewPE;
        this.f5383a = z1Var;
    }

    @Override // java.lang.Runnable
    public void run() {
        RewardVideoAdActivityNewPE rewardVideoAdActivityNewPE = this.b;
        z1 z1Var = this.f5383a;
        rewardVideoAdActivityNewPE.f5305a = z1Var;
        View rootView = z1Var.getRootView();
        this.b.setContentView(rootView);
        RewardVideoAdActivityNewPE rewardVideoAdActivityNewPE2 = this.b;
        rewardVideoAdActivityNewPE2.d = new ViewMeasureHelper(rewardVideoAdActivityNewPE2.f5305a.getRootView(), null, null, null, false, false, true);
        this.b.d.a(new a(rootView));
    }
}
