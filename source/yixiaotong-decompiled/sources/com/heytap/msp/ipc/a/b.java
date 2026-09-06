package com.heytap.msp.ipc.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.heytap.msp.ipc.common.exception.IPCBridgeExecuteException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final b f3397a = new b();
    private final Map<String, a> b = new ConcurrentHashMap();

    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        IBinder f3400a;
        ServiceConnection b;
        List<f.a> c = new CopyOnWriteArrayList();

        public a(IBinder iBinder, ServiceConnection serviceConnection) {
            this.f3400a = iBinder;
            this.b = serviceConnection;
        }

        public void a(ComponentName componentName) {
            for (f.a aVar : this.c) {
                if (aVar != null) {
                    aVar.a(componentName);
                }
            }
        }

        public void a(f.a aVar) {
            this.c.add(aVar);
        }

        public void b(ComponentName componentName) {
            for (f.a aVar : this.c) {
                if (aVar != null) {
                    aVar.b(componentName);
                }
            }
        }
    }

    private b() {
    }

    static b a() {
        return f3397a;
    }

    public synchronized IBinder a(Context context, Intent intent, int i, final f.a aVar) throws IPCBridgeExecuteException {
        a aVar2;
        j.b("BinderManager", "getBinderSync");
        final String str = intent.getPackage() + "/" + intent.getAction();
        j.a("BinderManager", "key:" + str);
        aVar2 = this.b.get(str);
        if (aVar2 == null || aVar2.f3400a == null) {
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            j.a("BinderManager", "bindService");
            if (!context.bindService(intent, new ServiceConnection() { // from class: com.heytap.msp.ipc.a.b.1
                @Override // android.content.ServiceConnection
                public void onNullBinding(ComponentName componentName) {
                    j.a("BinderManager", "onNullBinding:" + componentName);
                    countDownLatch.countDown();
                }

                @Override // android.content.ServiceConnection
                public void onServiceConnected(final ComponentName componentName, IBinder iBinder) {
                    j.a("BinderManager", "onServiceConnected");
                    try {
                        iBinder.linkToDeath(new IBinder.DeathRecipient() { // from class: com.heytap.msp.ipc.a.b.1.1
                            @Override // android.os.IBinder.DeathRecipient
                            public void binderDied() {
                                j.a("BinderManager", "binderDied");
                                a aVar3 = (a) b.this.b.remove(str);
                                if (aVar3 != null) {
                                    aVar3.b(componentName);
                                }
                            }
                        }, 0);
                    } catch (RemoteException unused) {
                    }
                    a aVar3 = new a(iBinder, this);
                    aVar3.a(aVar);
                    if (b.this.b.put(str, aVar3) != null) {
                        aVar3.a(componentName);
                    }
                    countDownLatch.countDown();
                }

                @Override // android.content.ServiceConnection
                public void onServiceDisconnected(ComponentName componentName) {
                    j.a("BinderManager", "onServiceDisconnected");
                    a aVar3 = (a) b.this.b.remove(str);
                    if (aVar3 != null) {
                        aVar3.b(componentName);
                    }
                }
            }, 1)) {
                j.c("BinderManager", "bindService failed");
                throw new IPCBridgeExecuteException("bindService failed", 101005);
            }
            try {
                j.a("BinderManager", "wait to connect");
                boolean zAwait = countDownLatch.await(i, TimeUnit.MILLISECONDS);
                j.a("BinderManager", "get iBinder from saved map");
                aVar2 = this.b.get(str);
                if (aVar2 == null && !zAwait) {
                    j.c("BinderManager", "service refused");
                    throw new IPCBridgeExecuteException("service refused", 101004);
                }
            } catch (InterruptedException e) {
                j.c("BinderManager", "wait time out");
                throw new IPCBridgeExecuteException(e, 101005);
            }
        } else {
            aVar2.c.add(aVar);
        }
        return aVar2 != null ? aVar2.f3400a : null;
    }
}
