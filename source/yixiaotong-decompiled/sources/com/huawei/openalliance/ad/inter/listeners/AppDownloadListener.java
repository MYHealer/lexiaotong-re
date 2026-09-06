package com.huawei.openalliance.ad.inter.listeners;

import com.huawei.openalliance.ad.download.app.AppStatus;
import com.huawei.openalliance.ad.inter.data.AppInfo;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public interface AppDownloadListener {
    void Code(AppStatus appStatus, AppInfo appInfo);

    void Code(AppInfo appInfo);

    void Code(AppInfo appInfo, int i);

    void Code(String str);

    void V(AppInfo appInfo);
}
