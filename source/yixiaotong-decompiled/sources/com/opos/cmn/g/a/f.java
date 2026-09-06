package com.opos.cmn.g.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import com.google.android.gms.ads.identifier.internal.IAdvertisingIdService;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class f {

    static /* synthetic */ class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f6156a;
        private final boolean b;

        b(String str, boolean z) {
            this.f6156a = str;
            this.b = z;
        }

        public String a() {
            return this.f6156a;
        }

        public boolean b() {
            return this.b;
        }
    }

    private static final class c implements ServiceConnection {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        boolean f6157a;
        private final LinkedBlockingQueue<IBinder> b;

        private c() {
            this.f6157a = false;
            this.b = new LinkedBlockingQueue<>(1);
        }

        /* synthetic */ c(a aVar) {
            this();
        }

        public IBinder a() {
            if (this.f6157a) {
                throw new IllegalStateException();
            }
            this.f6157a = true;
            return this.b.take();
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.b.put(iBinder);
            } catch (InterruptedException unused) {
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    private static final class d implements IInterface {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private IBinder f6158a;

        public d(IBinder iBinder) {
            this.f6158a = iBinder;
        }

        public String a() {
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                parcelObtain.writeInterfaceToken(IAdvertisingIdService.DESCRIPTOR);
                this.f6158a.transact(1, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                return parcelObtain2.readString();
            } finally {
                parcelObtain2.recycle();
                parcelObtain.recycle();
            }
        }

        public boolean a(boolean z) {
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                parcelObtain.writeInterfaceToken(IAdvertisingIdService.DESCRIPTOR);
                parcelObtain.writeInt(z ? 1 : 0);
                this.f6158a.transact(2, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                return parcelObtain2.readInt() != 0;
            } finally {
                parcelObtain2.recycle();
                parcelObtain.recycle();
            }
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this.f6158a;
        }
    }

    public static synchronized b a(Context context) {
        a aVar = null;
        if (Looper.getMainLooper() == Looper.myLooper()) {
            com.opos.cmn.an.f.a.c("GoogleAdIdUtils", "Cannot call in the main thread, You must call in the other thread");
            return null;
        }
        context.getPackageManager().getPackageInfo("com.android.vending", 0);
        c cVar = new c(aVar);
        Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
        intent.setPackage("com.google.android.gms");
        if (!context.bindService(intent, cVar, 1)) {
            return null;
        }
        try {
            d dVar = new d(cVar.a());
            b bVar = new b(dVar.a(), dVar.a(true));
            context.unbindService(cVar);
            return bVar;
        } catch (Throwable th) {
            context.unbindService(cVar);
            throw th;
        }
    }
}
