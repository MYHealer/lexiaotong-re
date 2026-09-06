package com.umeng.analytics.pro;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: HuaweiDeviceIdSupplier.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
class ad implements z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f9092a = "com.uodis.opendevice.aidl.OpenDeviceIdentifierService";
    private static final int b = 1;
    private static final int c = 2;

    /* JADX INFO: renamed from: com.umeng.analytics.pro.ad$1, reason: invalid class name */
    /* JADX INFO: compiled from: HuaweiDeviceIdSupplier.java */
    static /* synthetic */ class AnonymousClass1 {
    }

    ad() {
    }

    @Override // com.umeng.analytics.pro.z
    public String a(Context context) {
        a aVar = new a(null);
        Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
        intent.setPackage("com.huawei.hwid");
        if (context.bindService(intent, aVar, 1)) {
            try {
                return new b(aVar.a()).a();
            } catch (Exception unused) {
            } finally {
                context.unbindService(aVar);
            }
        }
        return null;
    }

    /* JADX INFO: compiled from: HuaweiDeviceIdSupplier.java */
    private static final class a implements ServiceConnection {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        boolean f9093a;
        private final LinkedBlockingQueue<IBinder> b;

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }

        private a() {
            this.f9093a = false;
            this.b = new LinkedBlockingQueue<>();
        }

        /* synthetic */ a(AnonymousClass1 anonymousClass1) {
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
            if (this.f9093a) {
                throw new IllegalStateException();
            }
            this.f9093a = true;
            return this.b.poll(5L, TimeUnit.SECONDS);
        }
    }

    /* JADX INFO: compiled from: HuaweiDeviceIdSupplier.java */
    private static final class b implements IInterface {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private IBinder f9094a;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this.f9094a;
        }

        public b(IBinder iBinder) {
            this.f9094a = iBinder;
        }

        public String a() throws RemoteException {
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                parcelObtain.writeInterfaceToken(ad.f9092a);
                this.f9094a.transact(1, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                return parcelObtain2.readString();
            } finally {
                parcelObtain2.recycle();
                parcelObtain.recycle();
            }
        }

        public boolean b() throws RemoteException {
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                parcelObtain.writeInterfaceToken(ad.f9092a);
                this.f9094a.transact(2, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                return parcelObtain2.readInt() != 0;
            } finally {
                parcelObtain2.recycle();
                parcelObtain.recycle();
            }
        }
    }
}
