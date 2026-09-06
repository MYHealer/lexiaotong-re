package com.unionpay.b;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.unionpay.UPQuerySEPayInfoCallback;
import com.unionpay.UPSEInfoResp;
import com.unionpay.tsmservice.mi.UPTsmAddon;
import com.unionpay.tsmservice.mi.request.QueryVendorPayStatusRequestParams;
import com.unionpay.utils.UPUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f9314a;
    private UPQuerySEPayInfoCallback b;
    private UPTsmAddon c;
    private String d = "";
    private String e = "";
    private boolean f;
    private QueryVendorPayStatusRequestParams g;
    private final Handler.Callback h;
    private final Handler i;
    private final UPTsmAddon.UPTsmConnectionListener j;

    public g(Context context, UPQuerySEPayInfoCallback uPQuerySEPayInfoCallback) {
        this.f = false;
        h hVar = new h(this);
        this.h = hVar;
        this.i = new Handler(hVar);
        this.j = new i(this);
        this.f9314a = context;
        this.b = uPQuerySEPayInfoCallback;
        this.f = true;
        System.loadLibrary("entryexpro");
        String strA = UPUtils.a(this.f9314a, "mode");
        String str = strA != null ? strA : "";
        try {
            Integer.decode(com.unionpay.utils.b.d(str) ? str : "02").intValue();
        } catch (Exception unused) {
        }
    }

    static /* synthetic */ void a(g gVar, int i, String str) {
        if (i != 4000) {
            return;
        }
        gVar.a(gVar.d, gVar.e, UPSEInfoResp.ERROR_NOT_SUPPORT, str);
    }

    static /* synthetic */ void a(g gVar, Bundle bundle) {
        Context context;
        gVar.d = bundle.getString("vendorPayName");
        gVar.e = bundle.getString("vendorPayAliasType");
        int i = bundle.getInt("vendorPayStatus");
        String string = bundle.getString("errorDesc");
        int i2 = bundle.getInt("cardNumber", 0);
        if (!TextUtils.isEmpty(gVar.e) && (context = gVar.f9314a) != null) {
            UPUtils.a(context, gVar.e, "se_type");
        }
        if (i != 0) {
            if (i == 1) {
                gVar.a(gVar.d, gVar.e, UPSEInfoResp.ERROR_NOT_READY, "not ready");
                return;
            } else if (i == 2 || i == 3 || i == 4) {
                gVar.a(gVar.d, gVar.e, UPSEInfoResp.ERROR_NOT_SUPPORT, string);
                return;
            } else {
                gVar.a(gVar.d, gVar.e, UPSEInfoResp.ERROR_NOT_SUPPORT, string);
                return;
            }
        }
        if (i2 <= 0) {
            gVar.a(gVar.d, gVar.e, UPSEInfoResp.ERROR_NOT_READY, "card number 0");
            return;
        }
        String str = gVar.d;
        String str2 = gVar.e;
        gVar.c();
        UPQuerySEPayInfoCallback uPQuerySEPayInfoCallback = gVar.b;
        if (uPQuerySEPayInfoCallback != null) {
            uPQuerySEPayInfoCallback.onResult(str, str2, i2, bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, String str3, String str4) {
        c();
        UPQuerySEPayInfoCallback uPQuerySEPayInfoCallback = this.b;
        if (uPQuerySEPayInfoCallback != null) {
            uPQuerySEPayInfoCallback.onError(str, str2, str3, str4);
        }
    }

    private boolean a(String str) {
        PackageInfo packageInfo = null;
        try {
            packageInfo = this.f9314a.getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException | Exception unused) {
        }
        if (packageInfo == null) {
            return false;
        }
        com.unionpay.utils.j.a("tsm-client", "tsm version code=" + packageInfo.versionCode);
        return packageInfo.versionCode >= 8;
    }

    static /* synthetic */ UPQuerySEPayInfoCallback b(g gVar) {
        gVar.b = null;
        return null;
    }

    private void c() {
        UPTsmAddon uPTsmAddon = this.c;
        if (uPTsmAddon != null) {
            uPTsmAddon.removeConnectionListener(this.j);
            this.c.unbind();
        }
    }

    public final int a() {
        String str;
        String str2;
        String str3;
        String str4;
        if (this.f9314a == null || this.b == null) {
            return UPSEInfoResp.PARAM_ERROR;
        }
        if (a("com.unionpay.tsmservice.mi")) {
            UPTsmAddon uPTsmAddon = UPTsmAddon.getInstance(this.f9314a);
            this.c = uPTsmAddon;
            uPTsmAddon.addConnectionListener(this.j);
            com.unionpay.utils.j.c("uppay-spay", "type se  bind service");
            UPTsmAddon uPTsmAddon2 = this.c;
            if (uPTsmAddon2 == null || uPTsmAddon2.isConnected()) {
                UPTsmAddon uPTsmAddon3 = this.c;
                if (uPTsmAddon3 != null && uPTsmAddon3.isConnected()) {
                    com.unionpay.utils.j.c("uppay", "tsm service already connected");
                    b();
                }
            } else {
                com.unionpay.utils.j.c("uppay", "bind service");
                if (!this.c.bind()) {
                    str = this.d;
                    str2 = this.e;
                    str3 = UPSEInfoResp.ERROR_NONE;
                    str4 = "Tsm service bind fail";
                }
            }
            return UPSEInfoResp.SUCCESS;
        }
        if (com.unionpay.utils.b.d(this.f9314a, "com.unionpay.tsmservice.mi")) {
            str = this.d;
            str2 = this.e;
            str3 = UPSEInfoResp.ERROR_NOT_SUPPORT;
            str4 = "Mi Tsm service apk version is low";
        } else {
            str = this.d;
            str2 = this.e;
            str3 = UPSEInfoResp.ERROR_TSM_UNINSTALLED;
            str4 = "Mi Tsm service apk is not installed";
        }
        a(str, str2, str3, str4);
        return UPSEInfoResp.SUCCESS;
    }

    public final boolean b() {
        try {
            com.unionpay.utils.j.c("uppay", "getVendorPayStatus()");
            if (this.g == null) {
                this.g = new QueryVendorPayStatusRequestParams();
            }
            if (this.c.queryVendorPayStatus(this.g, new j(this.i)) != 0) {
                com.unionpay.utils.j.c("uppay", "ret != 0");
                a(this.d, this.e, UPSEInfoResp.ERROR_NOT_SUPPORT, "Mi Tsm service apk version is low");
                return false;
            }
            Handler handler = this.i;
            handler.sendMessageDelayed(Message.obtain(handler, 4, 4000, 0, ""), 5000L);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
