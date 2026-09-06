package com.kwad.components.core.n;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class a extends com.kwad.sdk.mvp.a {
    public List<com.kwad.components.core.n.a.a> abk = new ArrayList();
    private final b<?> abl;
    public final Context mContext;
    public final View mRootView;

    public a(b<?> bVar) {
        this.abl = bVar;
        this.mContext = bVar.mContext;
        this.mRootView = bVar.mRootView;
    }

    @Override // com.kwad.sdk.mvp.a
    public void release() {
        this.abk.clear();
    }

    public final void iM() {
        this.abl.finish();
    }

    @Deprecated
    public final Activity getActivity() {
        return this.abl.getActivity();
    }
}
