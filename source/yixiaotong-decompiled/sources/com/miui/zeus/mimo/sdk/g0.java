package com.miui.zeus.mimo.sdk;

import android.view.View;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.miui.zeus.mimo.sdk.ad.interstitial.InterstitialUIController;
import com.miui.zeus.mimo.sdk.diagnosis.DiagnosisStep;
import com.miui.zeus.mimo.sdk.utils.error.MimoAdError;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class g0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e0 f5429a;
    public final /* synthetic */ InterstitialUIController b;

    public g0(InterstitialUIController interstitialUIController, e0 e0Var) {
        this.b = interstitialUIController;
        this.f5429a = e0Var;
    }

    @Override // java.lang.Runnable
    public void run() {
        String strD;
        e0 e0Var;
        try {
            InterstitialUIController interstitialUIController = this.b;
            if (interstitialUIController.b == null) {
                u8 u8Var = new u8(y8.f5752a);
                interstitialUIController.b = u8Var;
                u8Var.setHeight(-1);
                interstitialUIController.b.setWidth(-1);
                interstitialUIController.b.setOutsideDismiss(false);
                interstitialUIController.b.setOnWindowListener(new f0(interstitialUIController));
            }
            InterstitialUIController interstitialUIController2 = this.b;
            if (interstitialUIController2.d == null) {
                interstitialUIController2.d = interstitialUIController2.e.findViewById(android.R.id.content);
            }
            if (this.b.d != null && (e0Var = this.f5429a) != null && e0Var.getRootView() != null) {
                InterstitialUIController interstitialUIController3 = this.b;
                e0 e0Var2 = this.f5429a;
                interstitialUIController3.j = e0Var2;
                u8 u8Var2 = interstitialUIController3.b;
                View rootView = e0Var2.getRootView();
                u8Var2.removeAllViews();
                u8Var2.c = rootView;
                u8Var2.addView(rootView);
                InterstitialUIController interstitialUIController4 = this.b;
                u8 u8Var3 = interstitialUIController4.b;
                View view = interstitialUIController4.d;
                u8Var3.getClass();
                try {
                    u8Var3.f5635a.showAtLocation(view, 17, 0, 0);
                    return;
                } catch (Exception e) {
                    m.a(u8.h, ijiami_1011.s.s.s.d(new byte[]{65, 10, 95, 67, 115, 66, 45, 11, 5, 3, 69, 12, 93, 12, 16, 81, Ascii.DC2, 12, 65}, "2b0426"), e);
                    return;
                }
            }
            if (this.b.d == null) {
                strD = ijiami_1011.s.s.s.d(new byte[]{83, 91, 5, 12, 13, 71, 55, 13, 3, Ascii.NAK, 17, 12, 65, Ascii.NAK, 8, 17, 14, 89}, "25fdb5");
            } else {
                strD = this.f5429a == null ? ijiami_1011.s.s.s.d(new byte[]{69, 91, 88, 87, 14, Ascii.DC4, 34, 11, 8, Ascii.SYN, 84, 11, 70, 100, 95, 86, Ascii.SYN, 67, 8, Ascii.ETB, 70, 12, 68, 9, 94}, "2263ac") : ijiami_1011.s.s.s.d(new byte[]{49, 89, 15, 82, 89, 69, 34, 11, 8, Ascii.SYN, 84, 11, Ascii.DC2, 102, 8, 83, 65, Ascii.FS, 19, 11, 9, Ascii.SYN, 103, 12, 3, 71, 65, 95, 69, Ascii.DC2, 15, 17, 10, 14}, "f0a662");
            }
            m.b(ijiami_1011.s.s.s.d(new byte[]{126, 87, Ascii.SYN, 83, 16, 68, Ascii.NAK, 13, Ascii.DC2, 11, 80, 9, 98, 112, 33, 89, 12, 67, 19, 11, 10, 14, 84, Ascii.ETB}, "79b6b7"), ijiami_1011.s.s.s.d(new byte[]{9, 11, 37, SignedBytes.MAX_POWER_OF_TWO, 92, 89, Ascii.NAK, 1, 32, 3, 88, 9, 3, 1, 92}, "fef298") + strD);
            this.b.b(MimoAdError.ERROR_3001, m4.a(DiagnosisStep.KEY_EXCEPTION_WHEN_CREATE_AD_VIEW, strD));
        } catch (Exception e2) {
            m.b(ijiami_1011.s.s.s.d(new byte[]{122, 88, 66, 87, 67, 65, Ascii.NAK, 13, Ascii.DC2, 11, 80, 9, 102, 127, 117, 93, 95, 70, 19, 11, 10, 14, 84, Ascii.ETB}, "366212"), ijiami_1011.s.s.s.d(new byte[]{88, 95, 119, 70, 84, 3, Ascii.NAK, 1, 32, 3, 88, 9, 82, 85}, "71441b"), e2);
            this.b.b(MimoAdError.ERROR_3001, m4.a(DiagnosisStep.KEY_EXCEPTION_WHEN_CREATE_AD_VIEW, e2));
        }
    }
}
