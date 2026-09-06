package com.hihonor.adsdk.base.dialog.installnotify;

import com.hihonor.adsdk.base.init.ActivateStyle;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public interface AdInstallNotify {
    void installNotifyClick(ActivateStyle activateStyle, int i);

    void installNotifyDismiss(ActivateStyle activateStyle, long j, int i, int i2);

    void installNotifyShow(ActivateStyle activateStyle);
}
