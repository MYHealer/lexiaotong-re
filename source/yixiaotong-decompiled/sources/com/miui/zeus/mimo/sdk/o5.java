package com.miui.zeus.mimo.sdk;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.google.common.base.Ascii;
import com.miui.zeus.mimo.sdk.base.BaseAdImpl;
import com.miui.zeus.mimo.sdk.diagnosis.DiagnosisStep;
import com.miui.zeus.mimo.sdk.server.api.AdRequest;
import com.miui.zeus.mimo.sdk.server.http.Error;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class o5 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AdRequest f5549a;
    public final /* synthetic */ p5 b;

    public o5(p5 p5Var, AdRequest adRequest) {
        this.b = p5Var;
        this.f5549a = adRequest;
    }

    @Override // java.lang.Runnable
    public void run() {
        m.d(p5.b, ijiami_1011.s.s.s.d(new byte[]{69, Ascii.NAK, 86, 19, 71, 49, 4, Ascii.NAK, 19, 7, 66, 17}, "6a7a3c"));
        try {
            try {
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) y8.f5752a.getSystemService(ijiami_1011.s.s.s.d(new byte[]{1, 93, 90, 91, 85, 82, Ascii.NAK, 13, 16, 11, 69, Ascii.FS}, "b24501"))).getActiveNetworkInfo();
                if (activeNetworkInfo == null || !activeNetworkInfo.isConnectedOrConnecting()) {
                    p4 p4Var = this.f5549a.d;
                    if (p4Var != null) {
                        ((BaseAdImpl.a) p4Var).a(new a7(Error.NETWORK.value(), ijiami_1011.s.s.s.d(new byte[]{95, 11, Ascii.DC4, 8, 80, 71, Ascii.SYN, 11, Ascii.DC4, 9}, "1d4f53")));
                    }
                    this.b.a(this.f5549a, l5.a(Error.NETWORK, new i5(DiagnosisStep.KEY_FAIL_WHEN_NO_NETWORK, ijiami_1011.s.s.s.d(new byte[]{12, 9, Ascii.CAN, 11, 86, 77, Ascii.SYN, 11, Ascii.DC4, 9}, "bf8e39"))));
                    return;
                }
            } catch (Exception unused) {
            }
            r4 r4Var = this.b.f5561a;
            AdRequest adRequest = this.f5549a;
            synchronized (r4Var) {
                if (r4Var.b.size() < 20) {
                    r4Var.b.add(adRequest);
                    x8.i.execute(new q4(r4Var, adRequest));
                } else {
                    r4Var.f5582a.add(adRequest);
                }
            }
        } catch (Exception e) {
            p4 p4Var2 = this.f5549a.d;
            if (p4Var2 != null) {
                ((BaseAdImpl.a) p4Var2).a(new a7());
            }
            this.b.a(this.f5549a, l5.a(Error.UNKNOWN, new i5(DiagnosisStep.KEY_EXCEPTION_WHEN_START_AD_REQUEST, (String) null, e)));
        }
    }
}
