package com.umeng.commonsdk.service;

import android.content.Context;
import android.text.TextUtils;
import com.stub.StubApp;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.framework.UMFrUtils;
import com.umeng.commonsdk.utils.UMUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class UMGlobalContext {
    private static final String TAG = "UMGlobalContext";
    private String mAppVersion;
    private String mAppkey;
    private Context mApplicationContext;
    private String mChannel;
    private String mProcessName;

    /* JADX INFO: renamed from: com.umeng.commonsdk.service.UMGlobalContext$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* synthetic */ UMGlobalContext(AnonymousClass1 anonymousClass1) {
        this();
    }

    private UMGlobalContext() {
        this.mProcessName = "";
    }

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final UMGlobalContext f9241a = new UMGlobalContext(null);

        private a() {
        }
    }

    public static UMGlobalContext getInstance(Context context) {
        if (a.f9241a.mApplicationContext == null && context != null) {
            a.f9241a.mApplicationContext = context;
        }
        return a.f9241a;
    }

    public static Context getAppContext(Context context) {
        if (a.f9241a.mApplicationContext == null && context != null) {
            a.f9241a.mApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
        return a.f9241a.mApplicationContext;
    }

    public static Context getAppContext() {
        return a.f9241a.mApplicationContext;
    }

    public String getAppkey() {
        if (TextUtils.isEmpty(this.mAppkey)) {
            this.mAppkey = UMConfigure.sAppkey;
        }
        return this.mAppkey;
    }

    public String getChannel() {
        if (TextUtils.isEmpty(this.mChannel)) {
            this.mChannel = UMConfigure.sChannel;
        }
        return this.mChannel;
    }

    public String getProcessName(Context context) {
        if (TextUtils.isEmpty(this.mProcessName)) {
            if (context != null) {
                Context context2 = a.f9241a.mApplicationContext;
                if (context2 != null) {
                    this.mProcessName = UMFrUtils.getCurrentProcessName(context2);
                } else {
                    this.mProcessName = UMFrUtils.getCurrentProcessName(context);
                }
            } else {
                this.mProcessName = UMFrUtils.getCurrentProcessName(a.f9241a.mApplicationContext);
            }
        }
        return this.mProcessName;
    }

    public String getAppVersion() {
        if (TextUtils.isEmpty(this.mAppVersion)) {
            this.mAppVersion = UMUtils.getAppVersionName(this.mApplicationContext);
        }
        return this.mAppVersion;
    }

    public boolean isMainProcess(Context context) {
        return UMUtils.isMainProgress(context);
    }

    public String toString() {
        if (a.f9241a.mApplicationContext == null) {
            return "uninitialized.";
        }
        StringBuilder sb = new StringBuilder("[");
        sb.append("appkey:" + this.mAppkey + ",");
        sb.append("channel:" + this.mChannel + ",");
        sb.append("procName:" + this.mProcessName + "]");
        return sb.toString();
    }
}
