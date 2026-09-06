package com.kwad.components.core.proxy;

import android.app.Activity;
import androidx.lifecycle.Lifecycle;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class c implements a {
    private final WeakReference<Activity> aiL;
    private com.kwad.components.core.proxy.launchdialog.d aiM;
    private com.kwad.components.core.proxy.launchdialog.d aiN;

    @Override // com.kwad.components.core.proxy.a
    public final com.kwad.components.core.proxy.launchdialog.d vA() {
        return this.aiM;
    }

    @Override // com.kwad.components.core.proxy.a
    public final com.kwad.components.core.proxy.launchdialog.d vB() {
        return this.aiN;
    }

    public c(Activity activity) {
        this.aiL = new WeakReference<>(activity);
    }

    public final boolean d(Activity activity) {
        WeakReference<Activity> weakReference;
        if (activity == null || (weakReference = this.aiL) == null || weakReference.get() == null) {
            return false;
        }
        return this.aiL.get().equals(activity);
    }

    @Override // com.kwad.components.core.proxy.a
    public final String getPageName() {
        WeakReference<Activity> weakReference = this.aiL;
        if (weakReference == null || weakReference.get() == null) {
            return null;
        }
        return this.aiL.get().toString();
    }

    public final void a(Lifecycle.Event event) {
        this.aiM = this.aiN;
        this.aiN = new com.kwad.components.core.proxy.launchdialog.d(event);
    }
}
