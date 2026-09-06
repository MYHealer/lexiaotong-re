package com.meishu.sdk.core.service;

import android.app.Application;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import com.meishu.sdk.core.utils.LogUtil;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class MsLifeCycleContent extends ContentProvider {
    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0025  */
    @Override // android.content.ContentProvider
    public boolean onCreate() {
        Application application;
        Context context = getContext();
        Handler handler = d.f4860a;
        try {
            if (context instanceof Application) {
                application = (Application) context;
            } else if (context != null) {
                Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
                if (origApplicationContext instanceof Application) {
                    application = (Application) origApplicationContext;
                } else {
                    application = null;
                }
            } else {
                application = null;
            }
            if (application == null) {
                LogUtil.e("MsLifecycleUtil", "register error: no application from " + context);
            } else if (d.f.compareAndSet(false, true)) {
                application.registerActivityLifecycleCallbacks(new c());
            } else {
                LogUtil.e("MsLifecycleUtil", "register skipped: already registered");
            }
        } catch (Throwable th) {
            d.f.set(false);
            LogUtil.e("MsLifecycleUtil", "register error", th);
        }
        return true;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}
