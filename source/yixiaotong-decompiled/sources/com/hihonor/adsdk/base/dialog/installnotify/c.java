package com.hihonor.adsdk.base.dialog.installnotify;

import android.content.Context;
import com.hihonor.adsdk.base.R;
import com.hihonor.adsdk.base.bean.InstallNotifyBean;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class c extends b {
    public c(Context context, InstallNotifyBean installNotifyBean) {
        super(context, installNotifyBean);
    }

    @Override // com.hihonor.adsdk.base.dialog.installnotify.b
    public int hnadsa() {
        return R.layout.honor_ads_install_notify_bottom_layout;
    }

    @Override // com.hihonor.adsdk.base.dialog.installnotify.b
    protected int hnadsb() {
        return 3;
    }
}
