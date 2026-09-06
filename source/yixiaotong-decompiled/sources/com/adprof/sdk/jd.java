package com.adprof.sdk;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import com.adprof.sdk.base.fb.FBView;
import com.huawei.openalliance.ad.constant.br;
import java.util.HashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class jd extends a6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f1246a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public vc f392a;

    public jd(Activity activity, d dVar, Bundle bundle, String str, r5 r5Var) throws IllegalStateException {
        super(activity, str, r5Var);
        this.f1246a = dVar;
        a().requestWindowFeature(1);
        b(activity, 7, bundle, dVar);
    }

    public kl a() {
        d dVar = this.f1246a;
        if (dVar == null) {
            return null;
        }
        kl klVar = dVar.f185a;
        if (klVar != null) {
            return klVar;
        }
        a2 a2Var = new a2();
        a2Var.a(dVar);
        return a2Var;
    }

    @Override // com.adprof.sdk.q5
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void mo660a() {
    }

    @Override // com.adprof.sdk.q5
    public void a(Configuration configuration) {
    }

    @Override // com.adprof.sdk.q5
    public void a(Bundle bundle) {
    }

    @Override // com.adprof.sdk.q5
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean mo661a() {
        return false;
    }

    @Override // com.adprof.sdk.q5
    public void b() {
        ((q5) this).f662a.onSetContentView(((q5) this).f660a);
        WindowManager.LayoutParams attributes = a().getWindow().getAttributes();
        attributes.dimAmount = 0.0f;
        a().getWindow().setAttributes(attributes);
        hd hdVar = new hd(((q5) this).f1378a, this.f1246a);
        this.f392a = hdVar;
        hdVar.setInteractionListener(new id(this));
        RelativeLayout relativeLayout = this.b;
        if (relativeLayout == null) {
            relativeLayout = ((q5) this).f660a;
        }
        relativeLayout.addView(this.f392a, new ViewGroup.LayoutParams(-1, -1));
        if (a() != null) {
            kl klVarA = a();
            d dVar = this.f1246a;
            this.f392a.f769a.getClass();
            HashMap map = new HashMap();
            int i = ie.f1229a;
            ((a2) klVarA).a(dVar, br.b.V, map);
            n1.f1315a.m689a(this.f1246a.e());
        }
        g();
    }

    @Override // com.adprof.sdk.q5
    public void c() {
        String str = ((q5) this).f663a;
        if (str != null) {
            s5.a(str, "action.reward.video.close");
        } else {
            pk.e("Tried to broadcast a video event without a broadcast identifier to send to.");
        }
        vc vcVar = this.f392a;
        if (vcVar != null) {
            hd hdVar = (hd) vcVar;
            ll.a(((x0) hdVar).f821a);
            z5 z5Var = ((vc) hdVar).f772a;
            if (z5Var != null) {
                z5Var.f898a = null;
                z5Var.g();
                ((vc) hdVar).f772a = null;
            }
            c2 c2Var = hdVar.f339a;
            if (c2Var != null) {
                c2Var.b();
                hdVar.f339a = null;
            }
            pe peVar = hdVar.f342a;
            if (peVar != null) {
                if (peVar instanceof rl) {
                    ((rl) peVar).setOnAnimationCompleteListener(null);
                }
                hdVar.f342a.a();
            }
            yg ygVar = hdVar.f343a;
            if (ygVar != null) {
                ygVar.b();
                hdVar.f343a = null;
            }
            FBView fBView = hdVar.f338a;
            if (fBView != null) {
                hp.m656a((View) fBView);
                hdVar.f338a = null;
            }
            try {
                k9 k9Var = hdVar.f340a;
                if (k9Var != null) {
                    k9Var.a();
                    hdVar.f340a = null;
                }
            } catch (Throwable unused) {
            }
            ((vc) hdVar).f771a = null;
            l8 l8Var = ((vc) hdVar).f770a;
            if (l8Var != null) {
                l8Var.a();
                ((vc) hdVar).f770a.b();
            }
            d dVar = ((x0) hdVar).f821a;
            if (dVar != null) {
                dVar.m596a();
            }
            this.f392a = null;
        }
        super.c();
    }

    @Override // com.adprof.sdk.q5
    public void d() {
        vc vcVar = this.f392a;
        if (vcVar != null) {
            hd hdVar = (hd) vcVar;
            z5 z5Var = ((vc) hdVar).f772a;
            if (z5Var != null) {
                z5Var.c();
            }
            yg ygVar = hdVar.f343a;
            if (ygVar != null) {
                ygVar.c();
            }
            l8 l8Var = ((vc) hdVar).f770a;
            if (l8Var != null) {
                l8Var.d();
            }
        }
    }

    @Override // com.adprof.sdk.q5
    public void e() {
        vc vcVar = this.f392a;
        if (vcVar != null) {
            hd hdVar = (hd) vcVar;
            z5 z5Var = ((vc) hdVar).f772a;
            if (z5Var != null) {
                z5Var.d();
            }
            yg ygVar = hdVar.f343a;
            if (ygVar != null) {
                ygVar.d();
            }
            l8 l8Var = ((vc) hdVar).f770a;
            if (l8Var != null) {
                l8Var.e();
            }
        }
    }

    @Override // com.adprof.sdk.q5
    public void f() {
    }

    public final void g() {
        d dVar = this.f1246a;
        if (dVar.f201c) {
            return;
        }
        dVar.f201c = true;
        String str = ((q5) this).f663a;
        if (str != null) {
            s5.a(str, "action.reward.video.show");
        } else {
            pk.e("Tried to broadcast a video event without a broadcast identifier to send to.");
        }
    }
}
