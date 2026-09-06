package com.meishu.sdk.core.service;

import android.app.Activity;

/* JADX INFO: compiled from: OnAppStateListener.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public interface e {
    void onActivityDestroyed(Activity activity);

    void onActivityPause(Activity activity);

    void onActivityResume(Activity activity);

    boolean onAppStateUpdate(boolean z);
}
