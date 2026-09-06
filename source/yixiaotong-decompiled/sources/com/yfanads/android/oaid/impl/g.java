package com.yfanads.android.oaid.impl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.yfanads.android.libs.utils.Util;
import com.yfanads.android.oaid.repackage.com.hihonor.cloudservice.oaid.IOAIDCallBack;
import com.yfanads.android.oaid.repackage.com.hihonor.cloudservice.oaid.IOAIDService;
import com.yfanads.android.utils.YFLog;
import java.util.List;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: HonorImpl.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public final class g implements com.yfanads.android.oaid.ifs.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f9660a;
    public a b;

    /* JADX INFO: compiled from: HonorImpl.java */
    public class a implements ServiceConnection {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.yfanads.android.oaid.ifs.a f9661a;

        public a(com.yfanads.android.oaid.ifs.a aVar) {
            this.f9661a = aVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(IOAIDService iOAIDService, boolean z) {
            if (z) {
                this.f9661a.onOAIDGetFail(new com.yfanads.android.oaid.a("User has disabled advertising identifier"));
                return;
            }
            try {
                iOAIDService.getOAID(g.this.new b(this.f9661a));
            } catch (Exception e) {
                this.f9661a.onOAIDGetFail(new com.yfanads.android.oaid.a(e));
                Log.e("HiHonorServiceConnection", "onServiceConnected error:" + e.getMessage());
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Log.i("HiHonorServiceConnection", "onServiceConnected ");
            try {
                final IOAIDService iOAIDServiceAsInterface = IOAIDService.Stub.asInterface(iBinder);
                iOAIDServiceAsInterface.isOAIDTrackingLimited(g.this.new c(new d() { // from class: com.yfanads.android.oaid.impl.g$a$$ExternalSyntheticLambda0
                    @Override // com.yfanads.android.oaid.impl.g.d
                    public final void a(boolean z) {
                        this.f$0.a(iOAIDServiceAsInterface, z);
                    }
                }));
            } catch (Exception e) {
                this.f9661a.onOAIDGetFail(new com.yfanads.android.oaid.a(e));
                Log.e("HiHonorServiceConnection", "onServiceConnected error:" + e.getMessage());
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
            g.this.b = null;
        }
    }

    /* JADX INFO: compiled from: HonorImpl.java */
    public class b extends IOAIDCallBack.Stub {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.yfanads.android.oaid.ifs.a f9662a;

        public b(com.yfanads.android.oaid.ifs.a aVar) {
            this.f9662a = aVar;
        }

        @Override // com.yfanads.android.oaid.repackage.com.hihonor.cloudservice.oaid.IOAIDCallBack
        public final void basicTypes(int i, long j, boolean z, float f, double d, String str) throws RemoteException {
        }

        @Override // com.yfanads.android.oaid.repackage.com.hihonor.cloudservice.oaid.IOAIDCallBack
        public final void handleResult(int i, Bundle bundle) throws RemoteException {
            Log.d("OAID", "OAIDCallBack handleResult retCode=" + i + "|" + bundle);
            try {
                if (i != 0 || bundle == null) {
                    this.f9662a.onOAIDGetFail(new com.yfanads.android.oaid.a("has no oaid "));
                } else {
                    String string = bundle.getString("oa_id_flag");
                    Log.i(Util.TAG, "handleResult oaid " + string);
                    this.f9662a.onOAIDGetSuccess(string);
                }
                g gVar = g.this;
                a aVar = gVar.b;
                try {
                    Context context = gVar.f9660a;
                    if (context == null || aVar == null) {
                        return;
                    }
                    context.unbindService(aVar);
                } catch (Exception unused) {
                }
            } catch (Throwable th) {
                g gVar2 = g.this;
                a aVar2 = gVar2.b;
                try {
                    Context context2 = gVar2.f9660a;
                    if (context2 != null && aVar2 != null) {
                        context2.unbindService(aVar2);
                    }
                } catch (Exception unused2) {
                }
                throw th;
            }
        }
    }

    /* JADX INFO: compiled from: HonorImpl.java */
    public class c extends IOAIDCallBack.Stub {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final d f9663a;

        public c(d dVar) {
            this.f9663a = dVar;
        }

        @Override // com.yfanads.android.oaid.repackage.com.hihonor.cloudservice.oaid.IOAIDCallBack
        public final void basicTypes(int i, long j, boolean z, float f, double d, String str) throws RemoteException {
        }

        @Override // com.yfanads.android.oaid.repackage.com.hihonor.cloudservice.oaid.IOAIDCallBack
        public final void handleResult(int i, Bundle bundle) throws RemoteException {
            Log.d("OAID", "OAIDCallBack handleResult retCode=" + i + "|" + bundle);
            if (i != 0 || bundle == null) {
                return;
            }
            boolean z = bundle.getBoolean("oa_id_limit_state");
            Log.i(Util.TAG, "handleResult isLimit " + z);
            if (!z) {
                this.f9663a.a(false);
                return;
            }
            this.f9663a.a(true);
            g gVar = g.this;
            a aVar = gVar.b;
            try {
                Context context = gVar.f9660a;
                if (context == null || aVar == null) {
                    return;
                }
                context.unbindService(aVar);
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: compiled from: HonorImpl.java */
    public interface d {
        void a(boolean z);
    }

    public g(Context context) {
        this.f9660a = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.yfanads.android.oaid.ifs.a aVar) {
        try {
            if (this.b == null) {
                this.b = new a(aVar);
            }
            a aVar2 = this.b;
            try {
                Context context = this.f9660a;
                if (context != null && aVar2 != null) {
                    context.unbindService(aVar2);
                }
            } catch (Exception unused) {
            }
            a(this.f9660a);
        } catch (Exception e) {
            YFLog.debug("runOnSubThread " + e.getMessage());
            aVar.onOAIDGetFail(new com.yfanads.android.oaid.a(e));
        }
    }

    @Override // com.yfanads.android.oaid.ifs.b
    public final boolean a() {
        Context context = this.f9660a;
        if (context == null) {
            return false;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            Intent intent = new Intent("com.hihonor.id.HnOaIdService");
            intent.setPackage("com.hihonor.id");
            List<ResolveInfo> listQueryIntentServices = packageManager != null ? packageManager.queryIntentServices(intent, 0) : null;
            if (listQueryIntentServices != null) {
                return !listQueryIntentServices.isEmpty();
            }
            return false;
        } catch (Exception e) {
            Log.w("OAID", "supported " + e.getMessage());
            return false;
        }
    }

    @Override // com.yfanads.android.oaid.ifs.b
    public final void a(final com.yfanads.android.oaid.ifs.a aVar) {
        if (this.f9660a != null) {
            Executors.newSingleThreadExecutor().execute(new Runnable() { // from class: com.yfanads.android.oaid.impl.g$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.b(aVar);
                }
            });
        }
    }

    public final void a(Context context) {
        Intent intent = new Intent();
        intent.setAction("com.hihonor.id.HnOaIdService");
        intent.setPackage("com.hihonor.id");
        a aVar = this.b;
        if (aVar != null) {
            Log.i("OAID", "bind service result: " + context.bindService(intent, aVar, 1));
        }
    }
}
