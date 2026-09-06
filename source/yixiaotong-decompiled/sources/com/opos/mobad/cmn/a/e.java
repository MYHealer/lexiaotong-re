package com.opos.mobad.cmn.a;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.KeyEvent;
import com.heytap.msp.mobad.api.R;
import com.opos.mobad.ad.privacy.ComplianceInfo;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class e {
    private Activity b;
    private com.opos.mobad.ui.b.e.a c;
    private com.opos.mobad.activity.webview.b.c d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f6752a = false;
    private a e = new a() { // from class: com.opos.mobad.cmn.a.e.2
        @Override // com.opos.mobad.cmn.a.a
        public void a() {
            Activity activity = e.this.b;
            if (e.this.f6752a || activity == null || activity.isFinishing() || activity.isDestroyed()) {
                return;
            }
            com.opos.cmn.an.f.a.b("PrivacyWebPresenter", "finish remote");
            activity.finish();
        }
    };

    public e(com.opos.mobad.activity.webview.b.c cVar) {
        this.d = cVar;
        if (cVar != null) {
            cVar.a();
        }
    }

    private String a(Context context, int i) {
        Resources resources;
        int i2;
        if (context == null) {
            return "";
        }
        if (i == 3) {
            resources = context.getResources();
            i2 = R.string.opos_mob_privacy_title;
        } else if (i == 4) {
            resources = context.getResources();
            i2 = R.string.opos_mob_permission_title;
        } else {
            if (i != 5) {
                return "";
            }
            resources = context.getResources();
            i2 = R.string.opos_mob_app_desc_title;
        }
        return resources.getString(i2);
    }

    private String a(ComplianceInfo complianceInfo, int i) {
        if (i == 3) {
            return complianceInfo.a();
        }
        if (i != 4) {
            return i != 5 ? "" : complianceInfo.c();
        }
        return complianceInfo.b();
    }

    public void a() {
        this.f6752a = true;
        this.c.a();
        com.opos.mobad.activity.webview.b.c cVar = this.d;
        if (cVar != null) {
            cVar.b();
            this.d = null;
        }
        this.e = null;
    }

    public void a(Activity activity, int i, ComplianceInfo complianceInfo) {
        if (this.f6752a) {
            return;
        }
        if (activity == null) {
            com.opos.cmn.an.f.a.a("PrivacyWebPresenter", "null activity");
            return;
        }
        if (complianceInfo == null) {
            com.opos.cmn.an.f.a.a("PrivacyWebPresenter", "illegal data");
            return;
        }
        this.b = activity;
        com.opos.mobad.ui.b.e.a aVarA = com.opos.mobad.ui.b.e.a(StubApp.getOrigApplicationContext(activity.getApplicationContext()), a(activity, i), a(complianceInfo, i), i == 4 ? complianceInfo.d() : null, new com.opos.mobad.ui.b.e.b() { // from class: com.opos.mobad.cmn.a.e.1
            @Override // com.opos.mobad.ui.b.e.b
            public void a() {
                if (e.this.f6752a) {
                    return;
                }
                e.this.e.a();
            }
        });
        this.c = aVarA;
        activity.setContentView(aVarA);
    }

    public boolean a(int i, KeyEvent keyEvent) {
        com.opos.cmn.an.f.a.b("PrivacyWebPresenter", "onKeyDown keyCode = " + i);
        if (i != 4) {
            return false;
        }
        a aVar = this.e;
        if (aVar == null) {
            return true;
        }
        aVar.a();
        return true;
    }
}
