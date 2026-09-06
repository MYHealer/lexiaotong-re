package com.huawei.openalliance.ad.ipc;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.text.TextUtils;
import com.huawei.hms.ads.cp;
import com.huawei.hms.ads.fh;
import com.huawei.openalliance.ad.constant.dh;
import com.huawei.openalliance.ad.utils.bj;
import com.huawei.openalliance.ad.utils.z;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public abstract class c<SERVICE extends IInterface> implements com.huawei.openalliance.ad.ipc.a.InterfaceC0536a {
    private static final String B = "install_service_timeout_task";
    protected static final long Code = 3000;
    private static final String Z = "BaseAidlSer";
    protected com.huawei.openalliance.ad.ipc.a I;
    private SERVICE S;
    protected Context V;
    private final String C = B + hashCode();
    private boolean F = false;
    private final byte[] D = new byte[0];
    private Set<a> L = new CopyOnWriteArraySet();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ServiceConnection f4470a = new ServiceConnection() { // from class: com.huawei.openalliance.ad.ipc.c.2
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                fh.Code(c.this.V(), "onServiceConnected comp name: %s pkgName: %s", componentName.getClassName(), componentName.getPackageName());
                if (!c.this.F().equalsIgnoreCase(componentName.getClassName())) {
                    c.this.Code("pps remote service name not match, disconnect service.");
                    c.this.Code((IInterface) null);
                    return;
                }
                bj.Code(c.this.C);
                fh.V(c.this.V(), "PPS remote service connected: %d", Long.valueOf(System.currentTimeMillis()));
                c.this.Code(c.this.Code(iBinder));
                c.this.Code(componentName);
                if (c.this.S() && c.this.D()) {
                    fh.I(c.this.V(), "request is already timeout");
                    return;
                }
                IInterface iInterfaceA = c.this.a();
                if (iInterfaceA != null) {
                    ArrayList arrayList = new ArrayList(c.this.L);
                    c.this.L.clear();
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        ((a) it.next()).Code(iInterfaceA);
                    }
                }
            } catch (Throwable th) {
                fh.I(c.this.V(), "BaseASM Service, service error: %s", th.getClass().getSimpleName());
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            fh.V(c.this.V(), "PPS remote service disconnected");
            c.this.Code((IInterface) null);
            c.this.C();
        }
    };

    public static abstract class a<SERVICE extends IInterface> {
        private com.huawei.openalliance.ad.ipc.a Code;

        public abstract void Code(SERVICE service);

        public void Code(com.huawei.openalliance.ad.ipc.a aVar) {
            this.Code = aVar;
        }

        public abstract void Code(String str);

        protected void finalize() {
            try {
                super.finalize();
                com.huawei.openalliance.ad.utils.i.I(new Runnable() { // from class: com.huawei.openalliance.ad.ipc.c.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (a.this.Code == null || z.B(a.this.Code.Code())) {
                            return;
                        }
                        a.this.Code.I();
                    }
                });
            } catch (Throwable th) {
                fh.V(c.Z, "finalize err: %s", th.getClass().getSimpleName());
            }
        }
    }

    public c(Context context) {
        this.V = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.I = new com.huawei.openalliance.ad.ipc.a(context, V(), this);
    }

    private void Code(long j) {
        bj.Code(this.C);
        Code(false);
        bj.Code(new Runnable() { // from class: com.huawei.openalliance.ad.ipc.c.1
            @Override // java.lang.Runnable
            public void run() {
                fh.V(c.this.V(), "bind timeout " + System.currentTimeMillis());
                c.this.Code(true);
                c.this.Code("service bind timeout");
            }
        }, this.C, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void Code(SERVICE service) {
        this.S = service;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(String str) {
        try {
            ArrayList arrayList = new ArrayList(this.L);
            this.L.clear();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((a) it.next()).Code(str);
            }
        } catch (Throwable th) {
            try {
                fh.I(V(), "notifyServiceCallFail " + th.getClass().getSimpleName());
            } finally {
                this.L.clear();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(boolean z) {
        synchronized (this.D) {
            this.F = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean D() {
        boolean z;
        synchronized (this.D) {
            z = this.F;
        }
        return z;
    }

    private boolean L() {
        try {
            fh.V(V(), "bindService " + System.currentTimeMillis());
            B();
            Intent intent = new Intent(I());
            String strZ = Z();
            fh.V(V(), "bind service pkg: " + strZ);
            intent.setPackage(strZ);
            if (!cp.B(this.V) && com.huawei.openalliance.ad.utils.h.Code(strZ)) {
                String strZ2 = com.huawei.openalliance.ad.utils.h.Z(this.V, strZ);
                boolean zIsEmpty = TextUtils.isEmpty(strZ2);
                fh.V(V(), "is sign empty: %s", Boolean.valueOf(zIsEmpty));
                if (!zIsEmpty && !dh.Code(this.V, strZ, strZ2)) {
                    return false;
                }
            }
            boolean zBindService = this.V.bindService(intent, this.f4470a, 1);
            fh.V(V(), "bind service result: %s", Boolean.valueOf(zBindService));
            if (!zBindService) {
                Code("bind service failed");
            }
            return zBindService;
        } catch (SecurityException unused) {
            fh.I(V(), "bindService SecurityException");
            Code("bindService SecurityException");
            return false;
        } catch (Exception e) {
            fh.I(V(), "bindService " + e.getClass().getSimpleName());
            Code("bindService " + e.getClass().getSimpleName());
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized SERVICE a() {
        return this.S;
    }

    protected abstract void B();

    protected void C() {
    }

    protected abstract SERVICE Code(IBinder iBinder);

    @Override // com.huawei.openalliance.ad.ipc.a.InterfaceC0536a
    public synchronized void Code() {
        this.V.unbindService(this.f4470a);
        this.S = null;
    }

    protected abstract void Code(ComponentName componentName);

    /* JADX WARN: Multi-variable type inference failed */
    protected void Code(a aVar, long j) {
        fh.Code(V(), "handleTask");
        aVar.Code(this.I);
        this.I.V();
        IInterface iInterfaceA = a();
        if (iInterfaceA != null) {
            aVar.Code(iInterfaceA);
            return;
        }
        this.L.add(aVar);
        if (L() && S()) {
            Code(j);
        }
    }

    protected abstract String F();

    protected abstract String I();

    protected boolean S() {
        return false;
    }

    protected String V() {
        return "";
    }

    protected abstract String Z();
}
