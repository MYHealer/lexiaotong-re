package com.kwad.sdk.api.core;

import android.app.Activity;
import android.os.Bundle;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public interface KSLifecycleListener {
    void onActivityCreated(Activity activity, Bundle bundle);

    void onActivityDestroyed(Activity activity);

    void onActivityPaused(Activity activity);

    void onActivityResumed(Activity activity);

    void onActivityStopped(Activity activity);

    void onBackToBackground();

    void onBackToForeground();
}
