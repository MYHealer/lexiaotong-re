package com.hihonor.adsdk.base.dialog.installnotify;

import android.content.Context;
import com.hihonor.adsdk.base.R;
import com.hihonor.adsdk.base.bean.InstallNotifyBean;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class d extends b {
    public d(Context context, InstallNotifyBean installNotifyBean) {
        super(context, installNotifyBean);
    }

    @Override // com.hihonor.adsdk.base.dialog.installnotify.b
    public int hnadsa() {
        return R.layout.honor_ads_install_notify_confirm_layout;
    }

    @Override // com.hihonor.adsdk.base.dialog.installnotify.b
    protected int hnadsb() {
        return 2;
    }
}
