package com.huawei.hms.ads;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.huawei.openalliance.ad.activity.PPSNotificationActivity;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.utils.ac;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class gd extends gi {
    private static final int C = 1;
    private static final String I = "AppInstalledNotification";
    private AdContentData B;
    private int S;
    private com.huawei.openalliance.ad.inter.data.AppInfo Z;

    public gd(Context context, AdContentData adContentData, String str) {
        com.huawei.openalliance.ad.inter.data.AppInfo appInfo;
        super(context);
        this.B = adContentData;
        this.Z = adContentData.y();
        if (TextUtils.isEmpty(str) || (appInfo = this.Z) == null) {
            return;
        }
        appInfo.V(str);
    }

    private PendingIntent Code(String str) {
        if (!F()) {
            return null;
        }
        Intent intent = new Intent();
        intent.setAction(str);
        intent.setPackage(this.Code.getPackageName());
        intent.putExtra("type", 1);
        intent.putExtra("appInfo", this.Z);
        intent.putExtra(gf.I, this.S);
        intent.putExtra("contentRecord", this.B);
        return PendingIntent.getBroadcast(this.Code, Code(), intent, 201326592);
    }

    private boolean D() {
        com.huawei.openalliance.ad.inter.data.AppInfo appInfo = this.Z;
        return (appInfo == null || appInfo.p() != 1 || TextUtils.isEmpty(this.Z.q())) ? false : true;
    }

    private boolean F() {
        com.huawei.openalliance.ad.inter.data.AppInfo appInfo = this.Z;
        return (appInfo == null || TextUtils.isEmpty(appInfo.Code())) ? false : true;
    }

    private PendingIntent V(String str) {
        if (!F()) {
            return null;
        }
        Intent intent = new Intent(this.Code, (Class<?>) PPSNotificationActivity.class);
        intent.setAction(str);
        intent.putExtra("type", 1);
        intent.putExtra("appInfo", this.Z);
        intent.putExtra(gf.I, this.S);
        intent.putExtra("contentRecord", this.B);
        return PendingIntent.getActivity(this.Code, Code(), intent, 201326592);
    }

    private void V(Notification.Builder builder) {
        PackageInfo packageInfoV;
        Drawable drawableLoadIcon;
        if (!F() || this.Code == null || (packageInfoV = com.huawei.openalliance.ad.utils.h.V(this.Code, this.Z.Code())) == null || packageInfoV.applicationInfo == null || (drawableLoadIcon = packageInfoV.applicationInfo.loadIcon(this.Code.getPackageManager())) == null) {
            return;
        }
        builder.setLargeIcon(ac.Code(drawableLoadIcon));
    }

    @Override // com.huawei.hms.ads.gi
    protected String B() {
        return I;
    }

    @Override // com.huawei.hms.ads.gi
    protected String C() {
        com.huawei.openalliance.ad.inter.data.AppInfo appInfo = this.Z;
        return appInfo != null ? com.huawei.openalliance.ad.utils.bc.V(appInfo.q()) : "";
    }

    @Override // com.huawei.hms.ads.gi
    int Code() {
        if (F()) {
            return this.Z.Code().hashCode();
        }
        return 1;
    }

    public void Code(int i) {
        this.S = i;
    }

    @Override // com.huawei.hms.ads.gi
    void Code(Notification.Builder builder) {
        if (builder == null || !F()) {
            return;
        }
        V(builder);
        builder.setDeleteIntent(Code(gk.V));
    }

    @Override // com.huawei.hms.ads.gi
    public void I() {
        if (D()) {
            gk.Code(this.Code).Code(this.Z.Code());
            super.I();
            if (this.B == null || !com.huawei.openalliance.ad.utils.bg.d(this.Code)) {
                return;
            }
            gh.I(this.Code, this.B);
        }
    }

    @Override // com.huawei.hms.ads.gi
    protected PendingIntent S() {
        return V(gk.Code);
    }

    public int V() {
        return this.S;
    }

    @Override // com.huawei.hms.ads.gi
    protected String Z() {
        com.huawei.openalliance.ad.inter.data.AppInfo appInfo = this.Z;
        return appInfo != null ? appInfo.L() : "";
    }
}
