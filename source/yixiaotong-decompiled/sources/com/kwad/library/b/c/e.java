package com.kwad.library.b.c;

import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.res.Resources;
import android.view.ContextThemeWrapper;
import com.kwad.sdk.utils.ab;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
final class e extends ContextThemeWrapper implements d {
    private String aDT;
    private final ContextThemeWrapper aEb;
    private Resources.Theme aEc;
    private int aEd;

    @Override // android.content.ContextWrapper
    public final Context getBaseContext() {
        return this.aEb;
    }

    @Override // com.kwad.library.b.c.d
    public final Context getDelegatedContext() {
        return this.aEb;
    }

    e(ContextThemeWrapper contextThemeWrapper, String str) {
        super(contextThemeWrapper, 0);
        this.aEb = contextThemeWrapper;
        this.aDT = str;
        try {
            Object objA = ab.a((Object) contextThemeWrapper, "android.view.ContextThemeWrapper", "getThemeResId");
            if (objA != null) {
                this.aEd = ((Integer) objA).intValue();
            }
        } catch (Throwable unused) {
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final void registerComponentCallbacks(ComponentCallbacks componentCallbacks) {
        this.aEb.registerComponentCallbacks(componentCallbacks);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final void unregisterComponentCallbacks(ComponentCallbacks componentCallbacks) {
        this.aEb.unregisterComponentCallbacks(componentCallbacks);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final Context getApplicationContext() {
        return c.m(StubApp.getOrigApplicationContext(this.aEb.getApplicationContext()), this.aDT);
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        return c.a(this.aEb.getResources(), this.aDT);
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
            this.aEc = c.a(theme, theme2, this.aEd, this.aDT);
        }
        return this.aEc;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final ClassLoader getClassLoader() {
        return c.a(super.getClassLoader(), this.aDT);
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Object getSystemService(String str) {
        return c.wrapSystemService(this.aEb.getSystemService(str), str, this);
    }
}
