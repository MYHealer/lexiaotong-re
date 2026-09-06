package com.umeng.commonsdk.statistics.common;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.ads.identifier.internal.IAdvertisingIdService;
import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: compiled from: AdvertisingId.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class a {

    /* JADX INFO: renamed from: com.umeng.commonsdk.statistics.common.a$1, reason: invalid class name */
    /* JADX INFO: compiled from: AdvertisingId.java */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* JADX INFO: renamed from: com.umeng.commonsdk.statistics.common.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AdvertisingId.java */
    private static final class C1152a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f9253a;
        private final boolean b;

        /* JADX INFO: Access modifiers changed from: private */
        public String b() {
            return this.f9253a;
        }

        public boolean a() {
            return this.b;
        }

        C1152a(String str, boolean z) {
            this.f9253a = str;
            this.b = z;
        }
    }

    public static String a(Context context) {
        try {
            C1152a c1152aC = c(context);
            if (c1152aC != null && !c1152aC.a()) {
                return c1152aC.b();
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public static String b(Context context) {
        try {
            C1152a c1152aC = c(context);
            if (c1152aC == null) {
                return null;
            }
            return c1152aC.b();
        } catch (Exception unused) {
            return null;
        }
    }

    private static C1152a c(Context context) throws Exception {
        AnonymousClass1 anonymousClass1 = null;
        if (Looper.myLooper() == Looper.getMainLooper()) {
            return null;
        }
        context.getPackageManager().getPackageInfo("com.android.vending", 0);
        b bVar = new b(anonymousClass1);
        Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
        intent.setPackage("com.google.android.gms");
        if (context.bindService(intent, bVar, 1)) {
            try {
                try {
                    c cVar = new c(bVar.a());
                    boolean zA = cVar.a(true);
                    C1152a c1152a = new C1152a(zA ? "" : cVar.a(), zA);
                    context.unbindService(bVar);
                    return c1152a;
                } catch (Exception e) {
                    throw e;
                }
            } catch (Throwable th) {
                context.unbindService(bVar);
                throw th;
            }
        }
        throw new IOException("Google Play connection failed");
    }

    /* JADX INFO: compiled from: AdvertisingId.java */
    private static final class b implements ServiceConnection {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        boolean f9254a;
        private final LinkedBlockingQueue<IBinder> b;

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }

        private b() {
            this.f9254a = false;
            this.b = new LinkedBlockingQueue<>(1);
        }

        /* synthetic */ b(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.b.put(iBinder);
            } catch (InterruptedException unused) {
            }
        }

        public IBinder a() throws InterruptedException {
            if (this.f9254a) {
                throw new IllegalStateException();
            }
            this.f9254a = true;
            return this.b.take();
        }
    }

    /* JADX INFO: compiled from: AdvertisingId.java */
    private static final class c implements IInterface {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private IBinder f9255a;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this.f9255a;
        }

        public c(IBinder iBinder) {
            this.f9255a = iBinder;
        }

        public String a() throws RemoteException {
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                parcelObtain.writeInterfaceToken(IAdvertisingIdService.DESCRIPTOR);
                this.f9255a.transact(1, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                return parcelObtain2.readString();
            } finally {
                parcelObtain2.recycle();
                parcelObtain.recycle();
            }
        }

        public boolean a(boolean z) throws RemoteException {
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                parcelObtain.writeInterfaceToken(IAdvertisingIdService.DESCRIPTOR);
                parcelObtain.writeInt(z ? 1 : 0);
                this.f9255a.transact(2, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                return parcelObtain2.readInt() != 0;
            } finally {
                parcelObtain2.recycle();
                parcelObtain.recycle();
            }
        }
    }
}
