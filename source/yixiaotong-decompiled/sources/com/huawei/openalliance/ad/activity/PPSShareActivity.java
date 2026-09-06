package com.huawei.openalliance.ad.activity;

import android.content.DialogInterface;
import android.content.res.Configuration;
import android.os.Bundle;
import com.huawei.hms.ads.base.R;
import com.huawei.hms.ads.fh;
import com.huawei.hms.ads.ld;
import com.huawei.hms.ads.le;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.data.ImageInfo;
import com.huawei.openalliance.ad.utils.SafeIntent;
import com.huawei.openalliance.ad.utils.ad;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class PPSShareActivity extends d {
    private static final String Code = "PPSShareActivity";
    private static final String V = "shareClick";
    private com.huawei.openalliance.ad.views.dialog.b Z;
    private boolean I = true;
    private final DialogInterface.OnDismissListener B = new DialogInterface.OnDismissListener() { // from class: com.huawei.openalliance.ad.activity.PPSShareActivity.1
        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            PPSShareActivity.this.finish();
        }
    };

    static {
        StubApp.interface11(35589);
    }

    private le V() {
        SafeIntent safeIntent = (SafeIntent) getIntent();
        try {
            le leVar = new le(safeIntent.getStringExtra("title"), safeIntent.getStringExtra(ld.L), safeIntent.getStringExtra(ld.f3875a), safeIntent.getStringExtra("cshareUrl"));
            leVar.Code(getPackageManager().getApplicationInfo(getPackageName(), 0).icon);
            leVar.B(safeIntent.getStringExtra("contentId"));
            leVar.S(safeIntent.getStringExtra("slotId"));
            leVar.C(safeIntent.getStringExtra("templateId"));
            leVar.Code((ImageInfo) ad.V(safeIntent.getStringExtra(ld.f), ImageInfo.class, new Class[0]));
            leVar.Code((AdContentData) ad.V(safeIntent.getStringExtra(ld.g), AdContentData.class, new Class[0]));
            return leVar;
        } catch (RuntimeException e) {
            fh.I(Code, "getIntentParams runtime exception: %s", e.getClass().getSimpleName());
            return null;
        } catch (Throwable th) {
            fh.I(Code, "getIntentParams error: %s", th.getClass().getSimpleName());
            return null;
        }
    }

    protected void Code() {
        setContentView(R.layout.hiad_activity_share);
    }

    @Override // com.huawei.openalliance.ad.activity.d, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        com.huawei.openalliance.ad.views.dialog.b bVar = this.Z;
        if (bVar != null) {
            bVar.V();
        }
    }

    @Override // com.huawei.openalliance.ad.activity.d, android.app.Activity
    protected native void onCreate(Bundle bundle);

    @Override // com.huawei.openalliance.ad.activity.d, android.app.Activity
    protected void onDestroy() {
        fh.V(Code, "onDestroy");
        super.onDestroy();
        com.huawei.openalliance.ad.views.dialog.b bVar = this.Z;
        if (bVar != null) {
            bVar.V();
        }
    }

    @Override // com.huawei.openalliance.ad.activity.d, android.app.Activity
    protected void onResume() {
        super.onResume();
        fh.V(Code, "onResume");
        if (this.I) {
            this.I = false;
            return;
        }
        com.huawei.openalliance.ad.views.dialog.b bVar = this.Z;
        if (bVar != null) {
            bVar.V();
        }
    }
}
