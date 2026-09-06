package org.repackage.com.meizu.flyme.openidsdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import java.util.ArrayList;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
final class a extends BroadcastReceiver {
    a() {
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        OpenId openId;
        if (context == null || intent == null) {
            return;
        }
        int intExtra = intent.getIntExtra("openIdNotifyFlag", 0);
        b.a("shouldUpdateId, notifyFlag : ".concat(String.valueOf(intExtra)));
        if (intExtra == 1) {
            if (!TextUtils.equals(intent.getStringExtra("openIdPackage"), context.getPackageName())) {
                return;
            }
        } else if (intExtra == 2) {
            ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("openIdPackageList");
            if (stringArrayListExtra == null || !stringArrayListExtra.contains(context.getPackageName())) {
                return;
            }
        } else if (intExtra != 0) {
            return;
        }
        String stringExtra = intent.getStringExtra("openIdType");
        b bVarA = b.a();
        if ("oaid".equals(stringExtra)) {
            openId = bVarA.b;
        } else if ("vaid".equals(stringExtra)) {
            openId = bVarA.d;
        } else if ("aaid".equals(stringExtra)) {
            openId = bVarA.c;
        } else {
            openId = "udid".equals(stringExtra) ? bVarA.f9726a : null;
        }
        if (openId == null) {
            return;
        }
        openId.b();
    }
}
