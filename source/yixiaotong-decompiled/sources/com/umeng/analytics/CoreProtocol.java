package com.umeng.analytics;

import android.content.Context;
import com.stub.StubApp;
import com.umeng.analytics.pro.o;
import com.umeng.commonsdk.framework.UMLogDataProtocol;
import com.umeng.commonsdk.framework.UMSenderStateNotify;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class CoreProtocol implements UMLogDataProtocol, UMSenderStateNotify {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Context f9073a;

    /* JADX INFO: renamed from: com.umeng.analytics.CoreProtocol$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* synthetic */ CoreProtocol(AnonymousClass1 anonymousClass1) {
        this();
    }

    private CoreProtocol() {
    }

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final CoreProtocol f9074a = new CoreProtocol(null);

        private a() {
        }
    }

    public static CoreProtocol getInstance(Context context) {
        if (f9073a == null && context != null) {
            f9073a = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
        return a.f9074a;
    }

    @Override // com.umeng.commonsdk.framework.UMLogDataProtocol
    public void workEvent(Object obj, int i) {
        o.a(f9073a).a(obj, i);
    }

    @Override // com.umeng.commonsdk.framework.UMLogDataProtocol
    public void removeCacheData(Object obj) {
        o.a(f9073a).a(obj);
    }

    @Override // com.umeng.commonsdk.framework.UMLogDataProtocol
    public JSONObject setupReportData(long j) {
        return o.a(f9073a).a(j);
    }

    @Override // com.umeng.commonsdk.framework.UMSenderStateNotify
    public void onConnectionAvailable() {
        o.a(f9073a).a();
    }

    @Override // com.umeng.commonsdk.framework.UMSenderStateNotify
    public void onSenderIdle() {
        o.a(f9073a).b();
    }
}
