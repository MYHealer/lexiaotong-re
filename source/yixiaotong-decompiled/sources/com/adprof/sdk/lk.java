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
public class lk extends a6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f1290a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public jk f451a;

    public lk(Activity activity, d dVar, Bundle bundle, String str, r5 r5Var) throws IllegalStateException {
        super(activity, str, r5Var);
        this.f1290a = dVar;
        a().requestWindowFeature(1);
        b(activity, 7, bundle, dVar);
    }

    public kl a() {
        d dVar = this.f1290a;
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
    /* JADX INFO: renamed from: a */
    public void mo660a() {
    }

    @Override // com.adprof.sdk.q5
    public void a(Configuration configuration) {
    }

    @Override // com.adprof.sdk.q5
    public void a(Bundle bundle) {
    }

    @Override // com.adprof.sdk.q5
    /* JADX INFO: renamed from: a */
    public boolean mo661a() {
        return false;
    }

    @Override // com.adprof.sdk.q5
    public void b() {
        ((q5) this).f662a.onSetContentView(((q5) this).f660a);
        WindowManager.LayoutParams attributes = a().getWindow().getAttributes();
        attributes.dimAmount = 0.0f;
        a().getWindow().setAttributes(attributes);
        jk jkVar = new jk(((q5) this).f1378a, this.f1290a);
        this.f451a = jkVar;
        jkVar.setInteractionListener(new kk(this));
        RelativeLayout relativeLayout = this.b;
        if (relativeLayout == null) {
            relativeLayout = ((q5) this).f660a;
        }
        relativeLayout.addView(this.f451a, new ViewGroup.LayoutParams(-1, -1));
        if (a() != null) {
            ((a2) a()).a(this.f1290a, br.b.V, m677a());
            n1.f1315a.m689a(this.f1290a.e());
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
        jk jkVar = this.f451a;
        if (jkVar != null) {
            ll.a(((x0) jkVar).f821a);
            z5 z5Var = ((yj) jkVar).f866a;
            if (z5Var != null) {
                z5Var.f898a = null;
                z5Var.g();
                ((yj) jkVar).f866a = null;
            }
            c2 c2Var = jkVar.f394a;
            if (c2Var != null) {
                c2Var.b();
                jkVar.f394a = null;
            }
            pe peVar = jkVar.f397a;
            if (peVar != null) {
                if (peVar instanceof rl) {
                    ((rl) peVar).setOnAnimationCompleteListener(null);
                }
                jkVar.f397a.a();
            }
            x6 x6Var = jkVar.f398a;
            if (x6Var != null) {
                try {
                    if (x6Var.isShowing()) {
                        jkVar.f398a.dismiss();
                    }
                } catch (Throwable th) {
                    pk.b("RewardView", "Error dismissing skipInterceptDialog: " + th.getMessage());
                }
                jkVar.f398a = null;
            }
            yg ygVar = jkVar.f399a;
            if (ygVar != null) {
                ygVar.b();
                jkVar.f399a = null;
            }
            FBView fBView = jkVar.f1250a;
            if (fBView != null) {
                hp.m656a((View) fBView);
                jkVar.f1250a = null;
            }
            try {
                k9 k9Var = jkVar.f395a;
                if (k9Var != null) {
                    k9Var.a();
                    jkVar.f395a = null;
                }
            } catch (Throwable unused) {
            }
            ((yj) jkVar).f865a = null;
            hp.m656a((View) null);
            l8 l8Var = ((yj) jkVar).f864a;
            if (l8Var != null) {
                l8Var.a();
                ((yj) jkVar).f864a.b();
            }
            d dVar = ((x0) jkVar).f821a;
            if (dVar != null) {
                dVar.m596a();
            }
            this.f451a = null;
        }
        super.c();
    }

    @Override // com.adprof.sdk.q5
    public void d() {
        jk jkVar = this.f451a;
        if (jkVar != null) {
            z5 z5Var = ((yj) jkVar).f866a;
            if (z5Var != null) {
                z5Var.c();
            }
            l8 l8Var = ((yj) jkVar).f864a;
            if (l8Var != null) {
                l8Var.d();
            }
            yg ygVar = jkVar.f399a;
            if (ygVar != null) {
                ygVar.c();
            }
        }
    }

    @Override // com.adprof.sdk.q5
    public void e() {
        jk jkVar = this.f451a;
        if (jkVar != null) {
            x6 x6Var = jkVar.f398a;
            if (x6Var == null || !x6Var.isShowing()) {
                z5 z5Var = ((yj) jkVar).f866a;
                if (z5Var != null) {
                    z5Var.d();
                }
                l8 l8Var = ((yj) jkVar).f864a;
                if (l8Var != null) {
                    l8Var.e();
                }
                yg ygVar = jkVar.f399a;
                if (ygVar != null) {
                    ygVar.d();
                }
            }
        }
    }

    @Override // com.adprof.sdk.q5
    public void f() {
    }

    public final void g() {
        d dVar = this.f1290a;
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

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public final HashMap m677a() {
        ((yj) this.f451a).f863a.getClass();
        HashMap map = new HashMap();
        int i = ie.f1229a;
        int i2 = this.f1290a.g;
        if (i2 > 0) {
            map.put("mcr", Integer.valueOf(i2));
        }
        return map;
    }
}
