package com.alipay.sdk.widget;

import android.app.Activity;
import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.widget.FrameLayout;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public abstract class g extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected Activity f1676a;

    public abstract void a();

    public abstract void a(String str);

    public abstract boolean b();

    public g(Activity activity) {
        super(activity);
        this.f1676a = activity;
    }

    public void a(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        CookieSyncManager.createInstance(StubApp.getOrigApplicationContext(this.f1676a.getApplicationContext())).sync();
        CookieManager.getInstance().setCookie(str, str2);
        CookieSyncManager.getInstance().sync();
    }
}
