package com.heytap.mspsdk.core;

import android.app.Application;
import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import com.heytap.msp.IMspCoreBinder;
import com.heytap.mspsdk.log.MspLog;
import com.opos.process.bridge.provider.BridgeDispatchException;
import com.opos.process.bridge.provider.BridgeExecuteException;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Context f3464a;
    private static AtomicBoolean e = new AtomicBoolean(false);
    private volatile IMspCoreBinder b;
    private volatile com.heytap.mspsdk.guide.b c;
    private IBinder.DeathRecipient d;

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final e f3465a = new e(null);
    }

    private e() {
        this.b = null;
        this.c = null;
        this.d = new IBinder.DeathRecipient() { // from class: com.heytap.mspsdk.core.e$$ExternalSyntheticLambda0
            @Override // android.os.IBinder.DeathRecipient
            public final void binderDied() {
                this.f$0.e();
            }
        };
    }

    /* synthetic */ e(SdkRunTime$1 sdkRunTime$1) {
        this();
    }

    public static e a() {
        return a.f3465a;
    }

    private synchronized IMspCoreBinder b(ArrayList<String> arrayList) {
        try {
            IMspCoreBinder iMspCoreBinderAsInterface = IMspCoreBinder.Stub.asInterface(new com.heytap.mspsdk.core.a(f3464a).a());
            a(iMspCoreBinderAsInterface);
            iMspCoreBinderAsInterface.call("getMspCoreBinder", null, null);
            MspLog.iIgnore("SdkRunTime", "connect success by provider");
            return iMspCoreBinderAsInterface;
        } catch (RemoteException | BridgeDispatchException | BridgeExecuteException | IllegalArgumentException e2) {
            if (arrayList != null) {
                arrayList.add(e2.getMessage());
            }
            e2.printStackTrace();
            MspLog.w("SdkRunTime", e2);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e() {
        MspLog.iIgnore("SdkRunTime", "binderDied");
        this.b = null;
        d.a();
    }

    public void a(Context context) {
        if (StubApp.getOrigApplicationContext(context.getApplicationContext()) != null) {
            context = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
        f3464a = context;
        if (context instanceof Application) {
            ((Application) context).registerActivityLifecycleCallbacks(com.heytap.mspsdk.common.a.a());
        } else {
            MspLog.e("SdkRunTime", "context is not Application");
        }
        e.set(true);
    }

    public synchronized void a(IMspCoreBinder iMspCoreBinder) {
        try {
            if (this.b == null) {
                this.b = iMspCoreBinder;
                try {
                    this.b.asBinder().linkToDeath(this.d, 0);
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void a(com.heytap.mspsdk.guide.b bVar) {
        if (!e.get()) {
            throw new RuntimeException("MspSdk.init() must be invoked at first!");
        }
        this.c = bVar;
    }

    public synchronized boolean a(ArrayList<String> arrayList) {
        if (this.b == null || !this.b.asBinder().pingBinder()) {
            return b(arrayList) != null;
        }
        MspLog.iIgnore("SdkRunTime", "ping OK");
        return true;
    }

    public Context b() {
        return f3464a;
    }

    public synchronized IMspCoreBinder c() {
        return this.b;
    }

    public void d() {
        this.c = null;
    }
}
