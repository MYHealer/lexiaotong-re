package com.opos.mobad.cmn.a;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.RemoteException;
import com.heytap.msp.mobad.api.R;
import com.opos.mobad.ad.privacy.ComplianceInfo;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class d implements com.opos.mobad.ad.privacy.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private b f6748a;
    private com.opos.mobad.t.b b;
    private Dialog c;
    private com.opos.mobad.ad.privacy.b.a d;
    private boolean e = false;
    private com.opos.mobad.t.a.AbstractBinderC0999a f = new com.opos.mobad.t.a.AbstractBinderC0999a() { // from class: com.opos.mobad.cmn.a.d.2
        @Override // com.opos.mobad.t.a
        public void a() {
            com.opos.cmn.an.f.a.b("PrivacyShowManager", "onActivityOnDestory");
            d.this.b = null;
            if (d.this.d != null) {
                d.this.d.a();
            }
        }

        @Override // com.opos.mobad.t.a
        public void a(com.opos.mobad.t.b bVar) {
            d.this.b = bVar;
        }

        @Override // com.opos.mobad.t.a
        public void a(Map map) throws RemoteException {
        }
    };

    public d(b bVar) {
        this.f6748a = bVar;
    }

    private String a(Context context, int i) {
        Resources resources;
        int i2;
        if (context == null) {
            return "";
        }
        if (i == 0) {
            resources = context.getResources();
            i2 = R.string.opos_mob_privacy_title;
        } else if (i == 1) {
            resources = context.getResources();
            i2 = R.string.opos_mob_permission_title;
        } else {
            if (i != 2) {
                return "";
            }
            resources = context.getResources();
            i2 = R.string.opos_mob_app_desc_title;
        }
        return resources.getString(i2);
    }

    private String a(ComplianceInfo complianceInfo, int i) {
        if (i == 0) {
            return complianceInfo.a();
        }
        if (i != 1) {
            return i != 2 ? "" : complianceInfo.c();
        }
        return complianceInfo.b();
    }

    private void a(Activity activity, int i, ComplianceInfo complianceInfo, com.opos.mobad.ad.privacy.b.a aVar) {
        com.opos.cmn.an.f.a.a("PrivacyShowManager", "showAsDialog " + complianceInfo);
        this.d = aVar;
        b();
        this.c = com.opos.mobad.ui.b.e.a(activity, a(activity, i), a(complianceInfo, i), i == 1 ? complianceInfo.d() : null, new com.opos.mobad.ui.b.e.b() { // from class: com.opos.mobad.cmn.a.d.1
            @Override // com.opos.mobad.ui.b.e.b
            public void a() {
                if (d.this.d == null) {
                    return;
                }
                d.this.d.a();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        Dialog dialog = this.c;
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    private void b(Context context, int i, ComplianceInfo complianceInfo, com.opos.mobad.ad.privacy.b.a aVar) {
        com.opos.cmn.an.f.a.a("PrivacyShowManager", "showAsProxyContentView " + complianceInfo);
        if (this.f6748a == null) {
            com.opos.cmn.an.f.a.a("PrivacyShowManager", "null video player");
            return;
        }
        this.d = aVar;
        c();
        this.b = null;
        if (i == 1) {
            this.f6748a.b(context, complianceInfo, this.f);
        } else if (i == 0) {
            this.f6748a.a(context, complianceInfo, this.f);
        } else {
            this.f6748a.c(context, complianceInfo, this.f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        com.opos.mobad.t.b bVar = this.b;
        if (bVar != null) {
            try {
                bVar.a();
            } catch (Exception unused) {
                com.opos.cmn.an.f.a.b("PrivacyShowManager", "close fail");
            }
            this.b = null;
        }
    }

    @Override // com.opos.mobad.ad.privacy.b
    public void a() {
        this.e = true;
        com.opos.mobad.service.c.c(new Runnable() { // from class: com.opos.mobad.cmn.a.d.3
            @Override // java.lang.Runnable
            public void run() {
                d.this.f6748a = null;
                d.this.b();
                d.this.c();
            }
        });
    }

    @Override // com.opos.mobad.ad.privacy.b
    public void a(Context context, int i, ComplianceInfo complianceInfo, com.opos.mobad.ad.privacy.b.a aVar) {
        String str;
        if (this.e) {
            str = "privacy show but destroy";
        } else if (context == null) {
            str = "null context";
        } else {
            if (complianceInfo != null) {
                if (context instanceof Activity) {
                    a((Activity) context, i, complianceInfo, aVar);
                    return;
                } else {
                    b(context, i, complianceInfo, aVar);
                    return;
                }
            }
            str = "illegal data";
        }
        com.opos.cmn.an.f.a.a("PrivacyShowManager", str);
    }
}
