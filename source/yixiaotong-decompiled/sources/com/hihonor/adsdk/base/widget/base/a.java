package com.hihonor.adsdk.base.widget.base;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.alipay.sdk.util.i;
import com.hihonor.adsdk.base.ErrorCode;
import com.hihonor.adsdk.base.HnAds;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public abstract class a extends Activity {
    private static final String hnadsd = "BaseActivity";

    protected void hnadsa(int i) {
    }

    protected void hnadsa(Bundle bundle) {
    }

    protected boolean hnadsa() {
        boolean zIsInitialized = HnAds.get().isInitialized();
        if (!zIsInitialized) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsd, "checkSdkInitialized, sdk has not init, current page is {" + getClass().getCanonicalName() + i.d, new Object[0]);
        }
        return zIsInitialized;
    }

    protected boolean hnadsa(Intent intent) {
        return true;
    }

    protected abstract void hnadsb(Bundle bundle);

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        if (!hnadsa()) {
            super.onCreate(bundle);
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsd, "onCreate, sdk has not init, current page is {" + getClass().getCanonicalName() + i.d, new Object[0]);
            hnadsa(ErrorCode.AD_CODE_SDK_INIT_FAIL);
            finish();
            return;
        }
        if (hnadsa(getIntent())) {
            hnadsa(bundle);
            super.onCreate(bundle);
            hnadsb(bundle);
        } else {
            super.onCreate(bundle);
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsd, "onCreate, checkInitArgs is no matcher, current page is {" + getClass().getCanonicalName() + i.d, new Object[0]);
            hnadsa(ErrorCode.AD_CODE_BUNDLE_PARAM_NO_MATCH);
            finish();
        }
    }
}
