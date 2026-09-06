package com.huawei.hms.ads;

import android.content.Context;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public interface b {
    String getAppDetailUrl();

    String getPermissionUrl();

    String getPrivacyLink();

    void showPermissionPage(Context context);

    void showPrivacyPolicy(Context context);
}
