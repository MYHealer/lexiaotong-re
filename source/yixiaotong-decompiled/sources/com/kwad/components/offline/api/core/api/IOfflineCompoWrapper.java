package com.kwad.components.offline.api.core.api;

import android.app.Application;
import android.content.Context;
import android.view.LayoutInflater;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public abstract class IOfflineCompoWrapper {
    protected String mOfflinePackageName;

    @Deprecated
    public abstract Context unwrapContextIfNeed(Context context);

    public abstract Application wrapApp(Application application);

    public abstract Context wrapContextIfNeed(Context context);

    public abstract Application wrapGetApplication(Context context);

    public abstract LayoutInflater wrapInflaterIfNeed(LayoutInflater layoutInflater);

    public IOfflineCompoWrapper(String str) {
        this.mOfflinePackageName = str;
    }
}
