package com.kwad.sdk.wrapper;

import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
final class c extends ContextThemeWrapper implements b {
    private Resources.Theme aEc;
    private int aEd;
    private final ContextThemeWrapper btQ;
    private LayoutInflater mInflater;

    @Override // com.kwad.sdk.wrapper.b
    public final Context getDelegatedContext() {
        return this.btQ;
    }

    c(ContextThemeWrapper contextThemeWrapper) {
        super(contextThemeWrapper, 0);
        this.btQ = contextThemeWrapper;
        this.aEd = m.getThemeResId(contextThemeWrapper);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final void registerComponentCallbacks(ComponentCallbacks componentCallbacks) {
        this.btQ.registerComponentCallbacks(componentCallbacks);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final void unregisterComponentCallbacks(ComponentCallbacks componentCallbacks) {
        this.btQ.unregisterComponentCallbacks(componentCallbacks);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final Context getApplicationContext() {
        return j.wrapContextIfNeed(StubApp.getOrigApplicationContext(this.btQ.getApplicationContext()));
    }

    @Override // android.content.ContextWrapper
    public final Context getBaseContext() {
        return super.getBaseContext();
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        return f.XT().getResources();
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final AssetManager getAssets() {
        return f.XT().getResources().getAssets();
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final void setTheme(int i) {
        this.aEd = i;
        super.setTheme(i);
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Resources.Theme getTheme() {
        Resources.Theme theme;
        try {
            theme = super.getTheme();
        } catch (Exception e) {
            e.printStackTrace();
            theme = null;
        }
        Resources.Theme theme2 = this.aEc;
        if (theme2 == null || theme2 == theme) {
            this.aEc = j.replaceTheme(theme, theme2, this.aEd);
        }
        return this.aEc;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final ClassLoader getClassLoader() {
        return j.replaceExternalClassLoader(super.getClassLoader());
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Object getSystemService(String str) {
        if (!"layout_inflater".equals(str)) {
            return this.btQ.getSystemService(str);
        }
        if (this.mInflater == null) {
            this.mInflater = m.a(this.btQ, this);
        }
        return this.mInflater;
    }
}
