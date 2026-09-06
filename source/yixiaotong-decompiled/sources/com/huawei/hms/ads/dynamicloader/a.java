package com.huawei.hms.ads.dynamicloader;

import android.R;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.view.LayoutInflater;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class a extends ContextWrapper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f3837a;
    private Resources.Theme b;
    private LayoutInflater c;

    public a(Context context) {
        super(context);
    }

    private void a() {
        if (this.b == null) {
            this.b = getResources().newTheme();
            Resources.Theme theme = getBaseContext().getTheme();
            if (theme != null) {
                this.b.setTo(theme);
            }
        }
        this.b.applyStyle(this.f3837a, true);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final AssetManager getAssets() {
        return getResources().getAssets();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Object getSystemService(String str) {
        if (!"layout_inflater".equals(str)) {
            return super.getSystemService(str);
        }
        if (this.c == null) {
            this.c = LayoutInflater.from(getBaseContext()).cloneInContext(this);
        }
        return this.c;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final Resources.Theme getTheme() {
        Resources.Theme theme = this.b;
        if (theme != null) {
            return theme;
        }
        int i = this.f3837a;
        int i2 = getApplicationInfo().targetSdkVersion;
        if (i == 0) {
            if (i2 < 11) {
                i = R.style.Theme;
            } else if (i2 >= 14) {
                i = i2 < 24 ? R.style.Theme.DeviceDefault : R.style.Theme.DeviceDefault.Light.DarkActionBar;
            } else {
                i = R.style.Theme.Holo;
            }
        }
        this.f3837a = i;
        a();
        return this.b;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final void setTheme(int i) {
        if (this.f3837a != i) {
            this.f3837a = i;
            a();
        }
    }
}
