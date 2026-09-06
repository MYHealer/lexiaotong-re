package com.adprof.sdk;

import android.view.View;
import com.adprof.sdk.base.fb.FBView;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class ff extends fn.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ pf f1171a;

    public ff(pf pfVar) {
        this.f1171a = pfVar;
    }

    @Override // com.adprof.sdk.fn.a
    public void callback(Exception exc) {
        pf pfVar = this.f1171a;
        pfVar.getClass();
        try {
            ul ulVarA = vl.a(pfVar.f582a);
            if (ulVarA != null && !"1".equals(ulVarA.m)) {
                return;
            }
        } catch (Exception e) {
            pk.c("NativeBaseTemp setupFeedbackView check feedbackEnable error", e);
        }
        FBView fBView = pfVar.f580a;
        if (fBView != null) {
            hp.m656a((View) fBView);
            pfVar.f580a = null;
        }
        FBView fBView2 = new FBView(pfVar.getContext());
        pfVar.f580a = fBView2;
        pfVar.addView(fBView2);
        pfVar.f580a.setAdUnit(pfVar.f582a);
        pfVar.f580a.setLayoutParams(pfVar.f582a);
        pfVar.post(new nf(pfVar));
    }
}
