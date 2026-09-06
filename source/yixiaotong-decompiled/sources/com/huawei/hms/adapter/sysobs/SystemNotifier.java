package com.huawei.hms.adapter.sysobs;

import android.content.Intent;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public interface SystemNotifier {
    void notifyNoticeObservers(int i);

    void notifyObservers(int i);

    void notifyObservers(Intent intent, String str);

    void registerObserver(SystemObserver systemObserver);

    void unRegisterObserver(SystemObserver systemObserver);
}
