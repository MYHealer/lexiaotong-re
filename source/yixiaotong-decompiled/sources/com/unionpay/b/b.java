package com.unionpay.b;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ExoPlayer;
import com.huawei.nfc.sdk.service.HwOpenPayTask;
import com.unionpay.UPQuerySEPayInfoCallback;
import com.unionpay.UPSEInfoResp;
import com.unionpay.tsmservice.UPTsmAddon;
import com.unionpay.tsmservice.data.Constant;
import com.unionpay.tsmservice.request.QueryVendorPayStatusRequestParams;
import com.unionpay.utils.UPUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f9309a;
    private UPQuerySEPayInfoCallback b;
    private UPTsmAddon c;
    private boolean f;
    private QueryVendorPayStatusRequestParams h;
    private final Handler.Callback i;
    private final Handler j;
    private final UPTsmAddon.UPTsmConnectionListener k;
    private String d = "";
    private String e = "";
    private boolean g = false;

    public b(Context context, UPQuerySEPayInfoCallback uPQuerySEPayInfoCallback) {
        this.f = false;
        c cVar = new c(this);
        this.i = cVar;
        this.j = new Handler(cVar);
        this.k = new e(this);
        this.f9309a = context;
        this.b = uPQuerySEPayInfoCallback;
        this.f = true;
        System.loadLibrary("entryexpro");
    }

    static /* synthetic */ void a(b bVar, int i, String str) {
        if (i != 4000) {
            return;
        }
        bVar.a(bVar.d, bVar.e, UPSEInfoResp.ERROR_NOT_SUPPORT, str);
    }

    static /* synthetic */ void a(b bVar, Bundle bundle) {
        Context context;
        bVar.d = bundle.getString("vendorPayName");
        bVar.e = bundle.getString("vendorPayAliasType");
        int i = bundle.getInt("vendorPayStatus");
        String string = bundle.getString("errorDesc");
        int i2 = bundle.getInt("cardNumber", 0);
        if (!TextUtils.isEmpty(bVar.e) && (context = bVar.f9309a) != null) {
            UPUtils.a(context, bVar.e, "se_type");
        }
        if (i == 0) {
            if (i2 > 0) {
                bVar.a(bVar.d, bVar.e, i2, bundle);
                return;
            } else {
                bVar.a(bVar.d, bVar.e, UPSEInfoResp.ERROR_NOT_READY, "card number 0");
                return;
            }
        }
        if (i == 1) {
            bVar.a(bVar.d, bVar.e, UPSEInfoResp.ERROR_NOT_READY, "not ready");
        } else if (i == 2 || i == 3 || i == 4) {
            bVar.a(bVar.d, bVar.e, UPSEInfoResp.ERROR_NOT_SUPPORT, string);
        } else {
            bVar.a(bVar.d, bVar.e, UPSEInfoResp.ERROR_NOT_SUPPORT, string);
        }
    }

    private void a(String str, String str2, int i, Bundle bundle) {
        d();
        UPQuerySEPayInfoCallback uPQuerySEPayInfoCallback = this.b;
        if (uPQuerySEPayInfoCallback != null) {
            uPQuerySEPayInfoCallback.onResult(str, str2, i, bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, String str3, String str4) {
        d();
        UPQuerySEPayInfoCallback uPQuerySEPayInfoCallback = this.b;
        if (uPQuerySEPayInfoCallback != null) {
            uPQuerySEPayInfoCallback.onError(str, str2, str3, str4);
        }
    }

    private boolean a(String str) {
        PackageInfo packageInfo = null;
        try {
            packageInfo = this.f9309a.getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException | Exception unused) {
        }
        if (packageInfo == null) {
            return false;
        }
        com.unionpay.utils.j.a("tsm-client", "tsm version code=" + packageInfo.versionCode);
        return packageInfo.versionCode >= 18;
    }

    static /* synthetic */ void b(b bVar, Bundle bundle) {
        if (bundle != null) {
            bVar.d = "Huawei Pay";
            bVar.e = "04";
            if (!"0000".equals(bundle.getString(Constant.KEY_RESULT_CODE))) {
                bVar.a(bVar.d, bVar.e, UPSEInfoResp.ERROR_NOT_READY, "not ready");
            } else {
                bVar.a(bVar.d, bVar.e, bundle.getInt("cardNumber"), bundle);
            }
        }
    }

    static /* synthetic */ UPQuerySEPayInfoCallback c(b bVar) {
        bVar.b = null;
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        String str;
        String str2;
        String str3;
        String str4;
        if (!a("com.unionpay.tsmservice")) {
            if (com.unionpay.utils.b.d(this.f9309a, "com.unionpay.tsmservice")) {
                str = this.d;
                str2 = this.e;
                str3 = UPSEInfoResp.ERROR_NOT_SUPPORT;
                str4 = "Tsm service apk version is low";
            } else {
                str = this.d;
                str2 = this.e;
                str3 = UPSEInfoResp.ERROR_TSM_UNINSTALLED;
                str4 = "Tsm service apk is not installed";
            }
            a(str, str2, str3, str4);
            return;
        }
        UPTsmAddon uPTsmAddon = UPTsmAddon.getInstance(this.f9309a);
        this.c = uPTsmAddon;
        uPTsmAddon.addConnectionListener(this.k);
        com.unionpay.utils.j.c("uppay-spay", "type se  bind service");
        UPTsmAddon uPTsmAddon2 = this.c;
        if (uPTsmAddon2 != null && !uPTsmAddon2.isConnected()) {
            com.unionpay.utils.j.c("uppay", "bind service");
            if (this.c.bind()) {
                return;
            }
            a(this.d, this.e, UPSEInfoResp.ERROR_NONE, "Tsm service bind fail");
            return;
        }
        UPTsmAddon uPTsmAddon3 = this.c;
        if (uPTsmAddon3 == null || !uPTsmAddon3.isConnected()) {
            return;
        }
        com.unionpay.utils.j.c("uppay", "tsm service already connected");
        b();
    }

    static /* synthetic */ void c(b bVar, Bundle bundle) {
        if (bundle != null) {
            bVar.d = "Huawei Pay";
            bVar.e = "04";
            String string = bundle.getString("errorCode");
            bVar.a(bVar.d, bVar.e, "0002".equals(string) ? UPSEInfoResp.ERROR_NOT_READY : UPSEInfoResp.ERROR_NOT_SUPPORT, bundle.getString("errorDesc"));
        }
    }

    private void d() {
        UPTsmAddon uPTsmAddon = this.c;
        if (uPTsmAddon != null) {
            uPTsmAddon.removeConnectionListener(this.k);
            this.c.unbind();
        }
    }

    static /* synthetic */ void e(b bVar) {
        HwOpenPayTask hwOpenPayTask = new HwOpenPayTask(bVar.f9309a);
        com.unionpay.utils.j.c("uppay", "queryHwPayStatus start");
        bVar.j.sendEmptyMessageDelayed(4003, C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS);
        hwOpenPayTask.getUnionOnlinePayStatus(new f(bVar));
    }

    static /* synthetic */ boolean g(b bVar) {
        bVar.g = true;
        return true;
    }

    public final int a() {
        if (this.f9309a == null || this.b == null) {
            return UPSEInfoResp.PARAM_ERROR;
        }
        this.g = false;
        if (com.unionpay.utils.b.b()) {
            HwOpenPayTask hwOpenPayTask = new HwOpenPayTask(this.f9309a);
            com.unionpay.utils.j.c("uppay", "supportCapacity");
            this.j.sendEmptyMessageDelayed(4005, ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
            hwOpenPayTask.supportCapacity("UNIONONLINEPAY", new d(this));
        } else {
            c();
        }
        return UPSEInfoResp.SUCCESS;
    }

    public final boolean b() {
        try {
            com.unionpay.utils.j.c("uppay", "getVendorPayStatus()");
            if (this.h == null) {
                this.h = new QueryVendorPayStatusRequestParams();
            }
            if (this.c.queryVendorPayStatus(this.h, new a(this.j)) != 0) {
                com.unionpay.utils.j.c("uppay", "ret != 0");
                a(this.d, this.e, UPSEInfoResp.ERROR_NOT_SUPPORT, "Tsm service apk version is low");
                return false;
            }
            Handler handler = this.j;
            handler.sendMessageDelayed(Message.obtain(handler, 4, 4000, 0, ""), 5000L);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
