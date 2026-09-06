package com.miui.zeus.mimo.sdk;

import android.app.Activity;
import android.view.ViewGroup;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.miui.zeus.mimo.sdk.ad.splash.SplashAdImpl;
import com.miui.zeus.mimo.sdk.ad.splash.SplashAdUIController;
import com.miui.zeus.mimo.sdk.ad.splash.SplashAdView;
import com.miui.zeus.mimo.sdk.bean.MimoAdInfo;
import com.miui.zeus.mimo.sdk.diagnosis.DiagnosisStep;
import com.miui.zeus.mimo.sdk.utils.error.MimoAdError;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class g3 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Activity f5434a;
    public final /* synthetic */ SplashAdImpl b;

    public g3(SplashAdImpl splashAdImpl, Activity activity) {
        this.b = splashAdImpl;
        this.f5434a = activity;
    }

    @Override // java.lang.Runnable
    public void run() {
        SplashAdImpl splashAdImpl = this.b;
        String str = SplashAdImpl.t;
        splashAdImpl.g.getUpId();
        f9.a(this.f5434a);
        this.b.n = new SplashAdUIController();
        SplashAdImpl splashAdImpl2 = this.b;
        SplashAdUIController splashAdUIController = splashAdImpl2.n;
        splashAdUIController.e = splashAdImpl2.c;
        splashAdUIController.i = splashAdImpl2.d;
        r3 r3Var = splashAdImpl2.e;
        splashAdUIController.d = r3Var;
        SplashAdView splashAdView = splashAdUIController.g;
        if (splashAdView != null) {
            splashAdView.setDownloadListener(r3Var);
        }
        SplashAdImpl splashAdImpl3 = this.b;
        SplashAdUIController splashAdUIController2 = splashAdImpl3.n;
        MimoAdInfo mimoAdInfo = splashAdImpl3.f5377a;
        ViewGroup viewGroup = splashAdImpl3.o;
        splashAdUIController2.getClass();
        try {
            Activity activityA = b.a(viewGroup);
            splashAdUIController2.c = splashAdImpl3;
            splashAdUIController2.f = mimoAdInfo.u;
            splashAdUIController2.b = mimoAdInfo;
            splashAdUIController2.f5342a = viewGroup;
            SplashAdView splashAdView2 = new SplashAdView(activityA);
            splashAdUIController2.g = splashAdView2;
            splashAdView2.setMute(splashAdUIController2.i);
            splashAdUIController2.g.setDownloadListener(splashAdUIController2.d);
            splashAdUIController2.g.setSplashInteractionListener(splashAdUIController2);
            splashAdUIController2.g.setAdInfo(activityA, mimoAdInfo, 2);
        } catch (Exception e) {
            m.b(ijiami_1011.s.s.s.d(new byte[]{97, 65, 94, 87, 70, 80, 32, 0, 51, 43, 114, 10, 92, 69, SignedBytes.MAX_POWER_OF_TWO, 89, 89, 84, 4, Ascii.SYN}, "212658"), ijiami_1011.s.s.s.d(new byte[]{71, 91, 10, 66, 121, 1, 65, 33, Ascii.RS, 1, 84, Ascii.NAK, SignedBytes.MAX_POWER_OF_TWO, 90, 10, 91, 2}, "43e58e"), e);
            MimoAdError mimoAdError = MimoAdError.ERROR_3001;
            m4 m4VarA = m4.a(DiagnosisStep.KEY_EXCEPTION_WHEN_CREATE_AD_VIEW, e);
            m.b(ijiami_1011.s.s.s.d(new byte[]{99, Ascii.SYN, 94, 84, 68, 14, 32, 0, 51, 43, 114, 10, 94, Ascii.DC2, SignedBytes.MAX_POWER_OF_TWO, 90, 91, 10, 4, Ascii.SYN}, "0f257f"), ijiami_1011.s.s.s.d(new byte[]{13, 93, Ascii.ETB, 91, 4, 76, 51, 1, 8, 6, 84, Ascii.ETB, 37, 83, 10, 94, 7, 81, 65, 1, Ascii.DC4, 16, 94, Ascii.ETB, 77, 81, 12, 86, 7, 8}, "c2c2b5") + mimoAdError.ERROR_CODE + ijiami_1011.s.s.s.d(new byte[]{Ascii.CAN, 85, 65, SignedBytes.MAX_POWER_OF_TWO, 14, 66, 79, 9, Ascii.NAK, 5, 12}, "4032a0") + mimoAdError.ERROR_MSG);
            f3 f3Var = splashAdUIController2.c;
            if (f3Var != null) {
                f3Var.a(mimoAdError, m4VarA);
            }
        }
    }
}
