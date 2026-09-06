package com.kwad.components.core.offline.b.a;

import android.app.Application;
import android.content.Context;
import android.view.LayoutInflater;
import com.kwad.components.offline.api.core.api.IOfflineCompoWrapper;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class n extends IOfflineCompoWrapper {
    public n(String str) {
        super(str);
    }

    @Override // com.kwad.components.offline.api.core.api.IOfflineCompoWrapper
    public final Context wrapContextIfNeed(Context context) {
        return com.kwad.library.b.c.c.m(context, this.mOfflinePackageName);
    }

    @Override // com.kwad.components.offline.api.core.api.IOfflineCompoWrapper
    public final LayoutInflater wrapInflaterIfNeed(LayoutInflater layoutInflater) {
        return com.kwad.library.b.c.c.a(layoutInflater, this.mOfflinePackageName);
    }

    @Override // com.kwad.components.offline.api.core.api.IOfflineCompoWrapper
    public final Context unwrapContextIfNeed(Context context) {
        return com.kwad.library.b.c.c.unwrapContextIfNeed(context);
    }

    @Override // com.kwad.components.offline.api.core.api.IOfflineCompoWrapper
    public final Application wrapGetApplication(Context context) {
        return com.kwad.sdk.wrapper.m.Yb();
    }

    @Override // com.kwad.components.offline.api.core.api.IOfflineCompoWrapper
    public final Application wrapApp(Application application) {
        return com.kwad.library.b.c.c.c(application, this.mOfflinePackageName);
    }
}
