package com.ubix.ssp.open.comm;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.alipay.sdk.widget.j;
import com.huawei.openalliance.ad.constant.x;
import com.stub.StubApp;
import com.ubix.ssp.ad.e.a0.m;
import com.ubix.ssp.ad.e.a0.u;
import com.ubix.ssp.ad.e.s.a;
import com.ubix.ssp.ad.e.s.b;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class AdActivity extends Activity {
    public static final String INSTALL_ACTION = "YW5kcm9pZC5pbnRlbnQuYWN0aW9uLlBBQ0tBR0VfQURERUQ=";
    private a apkBr;
    private String packageName;
    private int notifyId = -1;
    String path = null;
    boolean isSimple = false;

    static {
        StubApp.interface11(52560);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        com.ubix.ssp.ad.d.a aVar;
        super.onActivityResult(i, i2, intent);
        try {
            if (i2 != -1) {
                u.b("未能安装" + i2 + x.bQ + i);
            } else if (!TextUtils.isEmpty(this.packageName) && (aVar = b.b.get(this.packageName)) != null) {
                b.b.remove(this.packageName);
                b.c().a(StubApp.getOrigApplicationContext(getApplicationContext()), this.packageName, aVar, j.j, this.path);
            }
        } catch (Throwable th) {
            try {
                th.printStackTrace();
            } finally {
                finish();
            }
        }
    }

    @Override // android.app.Activity
    protected native void onCreate(Bundle bundle);

    @Override // android.app.Activity
    protected void onDestroy() {
        com.ubix.ssp.ad.d.a aVar;
        super.onDestroy();
        try {
            a aVar2 = this.apkBr;
            if (aVar2 != null) {
                unregisterReceiver(aVar2);
            }
            if (!TextUtils.isEmpty(this.packageName) && (aVar = b.b.get(this.packageName)) != null) {
                b.b.remove(this.packageName);
                b.c().a(StubApp.getOrigApplicationContext(getApplicationContext()), this.packageName, aVar, j.j, this.path);
            }
        } catch (Exception unused) {
        }
        try {
            if (this.notifyId != -1) {
                Intent intent = new Intent();
                intent.setAction("ACTION_INSTALLED");
                intent.putExtra("service_intent_notify_id", this.notifyId);
                intent.putExtra("service_intent_pkg_extra", this.packageName);
                m.a(StubApp.getOrigApplicationContext(getApplicationContext())).b(intent);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
