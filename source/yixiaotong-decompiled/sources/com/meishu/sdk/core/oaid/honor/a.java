package com.meishu.sdk.core.oaid.honor;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.os.Parcel;

/* JADX INFO: compiled from: HonorOaidUtil.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c f4823a;
    public ServiceConnection b = new ServiceConnectionC0798a();

    /* JADX INFO: renamed from: com.meishu.sdk.core.oaid.honor.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: HonorOaidUtil.java */
    public class ServiceConnectionC0798a implements ServiceConnection {
        public ServiceConnectionC0798a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                b bVar = a.this.new b();
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    try {
                        parcelObtain.writeInterfaceToken("com.hihonor.cloudservice.oaid.IOAIDService");
                        parcelObtain.writeStrongBinder(bVar);
                        iBinder.transact(2, parcelObtain, parcelObtain2, 0);
                        parcelObtain2.readException();
                        parcelObtain2.recycle();
                    } catch (Throwable th) {
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        throw th;
                    }
                } catch (Exception unused) {
                    parcelObtain2.recycle();
                }
                parcelObtain.recycle();
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    /* JADX INFO: compiled from: HonorOaidUtil.java */
    public class b extends com.meishu.sdk.core.oaid.honor.b {
        public b() {
        }
    }

    /* JADX INFO: compiled from: HonorOaidUtil.java */
    public interface c {
    }

    public void a(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            packageManager.getPackageInfo("com.hihonor.id", 0);
            Intent intent = new Intent("com.hihonor.id.HnOaIdService");
            intent.setPackage("com.hihonor.id");
            if (!packageManager.queryIntentServices(intent, 0).isEmpty()) {
                try {
                    Intent intent2 = new Intent();
                    intent2.setAction("com.hihonor.id.HnOaIdService");
                    intent2.setPackage("com.hihonor.id");
                    context.bindService(intent2, this.b, 1);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        } catch (Throwable unused) {
        }
    }
}
