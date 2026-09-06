package com.adprof.sdk;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class m5 implements m7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f1301a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ kl f461a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ n5 f462a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ String f463a;

    public m5(n5 n5Var, kl klVar, d dVar, String str) {
        this.f462a = n5Var;
        this.f461a = klVar;
        this.f1301a = dVar;
        this.f463a = str;
    }

    @Override // com.adprof.sdk.m7
    public void a(boolean z, int i) {
        try {
            pk.d(" open dp result = " + z + " code = " + i);
            if (z) {
                kl klVar = this.f461a;
                if (klVar != null) {
                    klVar.a(this.f1301a, "open_deeplink_success");
                }
                ul ulVarA = vl.a(this.f1301a);
                if (ulVarA == null || !"1".equals(ulVarA.q)) {
                    return;
                }
                n5.b = this.f1301a;
                Activity activityA = n5.a(q1.a());
                n5.f1319a = activityA != null ? new WeakReference(activityA) : null;
                return;
            }
            kl klVar2 = this.f461a;
            if (klVar2 != null) {
                klVar2.a(this.f1301a, "open_deeplink_fail");
            }
            if (vl.c(this.f1301a)) {
                if (TextUtils.isEmpty(this.f1301a.n)) {
                    return;
                }
                this.f462a.b(this.f1301a, "openDeeplink");
            } else {
                if (n5.a(this.f463a)) {
                    return;
                }
                Context context = AdprofSdk.getInstance().getContext();
                Toast.makeText(context, context.getResources().getString(R.string.adprof_app_not_installed) + "   " + this.f463a, 0).show();
            }
        } catch (Throwable th) {
            pk.a(th);
            oh.b(th);
        }
    }
}
