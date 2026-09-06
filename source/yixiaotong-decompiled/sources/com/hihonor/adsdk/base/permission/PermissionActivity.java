package com.hihonor.adsdk.base.permission;

import android.content.Intent;
import android.os.Bundle;
import androidx.core.app.ActivityCompat;
import com.hihonor.adsdk.common.b.b;
import com.hihonor.adsdk.common.f.c;
import com.hihonor.adsdk.common.f.d0;
import com.hihonor.adsdk.common.safe.SafeIntent;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public final class PermissionActivity extends com.hihonor.adsdk.base.widget.base.a {
    private static final String hnadse = "PermissionActivity";
    private static final int hnadsf = 0;

    static {
        StubApp.interface11(32110);
    }

    @Override // com.hihonor.adsdk.base.widget.base.a
    protected boolean hnadsa(Intent intent) {
        if (intent == null) {
            return false;
        }
        return new SafeIntent(intent).hasExtra(a.hnadsc);
    }

    @Override // com.hihonor.adsdk.base.widget.base.a
    protected void hnadsb(Bundle bundle) {
        d0.hnadsa(getWindow());
        hnadsb();
    }

    @Override // android.app.Activity
    public native void onRequestPermissionsResult(int i, String[] strArr, int[] iArr);

    private void hnadsb() {
        String str = hnadse;
        b.hnadsc(str, "request permission.", new Object[0]);
        String[] stringArrayExtra = new SafeIntent(getIntent()).getStringArrayExtra(a.hnadsc);
        if (c.hnadsb(stringArrayExtra)) {
            b.hnadsc(str, "permissions is empty, activity finish.", new Object[0]);
            finish();
        } else {
            ActivityCompat.requestPermissions(this, stringArrayExtra, 0);
        }
    }
}
