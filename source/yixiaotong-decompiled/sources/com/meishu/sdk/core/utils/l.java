package com.meishu.sdk.core.utils;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.meishu.sdk.core.AdSdk;
import com.meishu.sdk.core.exception.ErrorCodeUtil;

/* JADX INFO: compiled from: DeviceUtil.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class l implements com.meishu.sdk.core.oaid.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f4917a;

    /* JADX INFO: compiled from: DeviceUtil.java */
    public class a implements com.meishu.sdk.core.oaid.honor.a.c {
        public a(l lVar) {
        }

        public void a(String str) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (TextUtils.isEmpty(j.f4912a)) {
                j.f4912a = str;
            }
            AdSdk.getSharedPreferences().edit().putString("honor_oaid", str).apply();
            q.a().b("honor_oaid", str);
        }
    }

    public l(Context context) {
        this.f4917a = context;
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        j.f4912a = str;
        try {
            String strC = f1.c(str);
            AdSdk.getSharedPreferences().edit().putString("oaid_e", strC).apply();
            q.a().b("oaid_e", strC);
        } catch (Exception e) {
            e.printStackTrace();
            AdSdk.getSharedPreferences().edit().putString("oaid", str).apply();
            q.a().b("oaid", str);
        }
    }

    public void a(Exception exc) {
        try {
            LogUtil.d("DeviceUtil", exc.getMessage());
            if (Build.MANUFACTURER.equalsIgnoreCase("honor")) {
                com.meishu.sdk.core.oaid.honor.a aVar = new com.meishu.sdk.core.oaid.honor.a();
                aVar.f4823a = new a(this);
                aVar.a(this.f4917a);
            } else {
                Context context = this.f4917a;
                if (Build.VERSION.SDK_INT >= 28) {
                    try {
                        Class.forName("com.bun.miitmdid.interfaces.IIdentifierListener");
                        new MiitHelper().prepare(context, new k());
                    } catch (ClassNotFoundException unused) {
                    } catch (Throwable th) {
                        AdSdk.setOaid_errno(ErrorCodeUtil.OAID_INIT_ERROR);
                        LogUtil.e("DeviceUtil", "oaid sdk init error");
                        th.printStackTrace();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
