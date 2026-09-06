package com.yfanads.android.lifecycle;

import android.app.Activity;
import android.os.Bundle;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public interface BFLifecycleListener extends LifecycleListener {
    @Override // com.yfanads.android.lifecycle.LifecycleListener
    default void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // com.yfanads.android.lifecycle.LifecycleListener
    default void onActivityDestroyed(Activity activity) {
    }

    @Override // com.yfanads.android.lifecycle.LifecycleListener
    default void onActivityPaused(Activity activity) {
    }

    @Override // com.yfanads.android.lifecycle.LifecycleListener
    default void onActivityResumed(Activity activity) {
    }
}
