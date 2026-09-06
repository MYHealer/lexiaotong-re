package com.adprof.sdk;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.util.Log;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class ba implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IBinder f1070a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ea f94a;

    public ba(ea eaVar, IBinder iBinder) {
        this.f94a = eaVar;
        this.f1070a = iBinder;
    }

    @Override // java.lang.Runnable
    public void run() throws Throwable {
        Object hbVar;
        try {
            Binder.getCallingPid();
            IBinder iBinder = this.f1070a;
            Parcel parcel = null;
            Parcel parcel2 = null;
            if (iBinder == null) {
                hbVar = null;
            } else {
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.hihonor.cloudservice.oaid.IOAIDService");
                hbVar = (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof ib)) ? new hb(this.f1070a) : (ib) iInterfaceQueryLocalInterface;
            }
            try {
                pk.a("AdvertisingIdPlatform", "onServiceConnected-debug4-" + hbVar);
                ca caVar = this.f94a.f241a;
                hb hbVar2 = (hb) hbVar;
                hbVar2.getClass();
                Parcel parcelObtain = Parcel.obtain();
                try {
                    Parcel parcelObtain2 = Parcel.obtain();
                    try {
                        parcelObtain2.writeInterfaceToken("com.hihonor.cloudservice.oaid.IOAIDService");
                        if (caVar == null) {
                            caVar = null;
                        }
                        parcelObtain2.writeStrongBinder(caVar);
                        hbVar2.f1209a.transact(2, parcelObtain2, parcelObtain, 0);
                        parcelObtain.readException();
                        parcelObtain.recycle();
                        parcelObtain2.recycle();
                        pk.a("AdvertisingIdPlatform", "onServiceConnected-debug5-");
                        da daVar = this.f94a.f242a;
                        hb hbVar3 = (hb) hbVar;
                        hbVar3.getClass();
                        Parcel parcelObtain3 = Parcel.obtain();
                        try {
                            Parcel parcelObtain4 = Parcel.obtain();
                            try {
                                parcelObtain4.writeInterfaceToken("com.hihonor.cloudservice.oaid.IOAIDService");
                                parcelObtain4.writeStrongBinder(daVar != null ? daVar : null);
                                hbVar3.f1209a.transact(3, parcelObtain4, parcelObtain3, 0);
                                parcelObtain3.readException();
                                parcelObtain3.recycle();
                                parcelObtain4.recycle();
                                pk.a("AdvertisingIdPlatform", "onServiceConnected-debug6-");
                            } catch (Throwable th) {
                                th = th;
                                parcel2 = parcelObtain4;
                                parcelObtain3.recycle();
                                parcel2.recycle();
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        parcel = parcelObtain2;
                        parcelObtain.recycle();
                        parcel.recycle();
                        throw th;
                    }
                } catch (Throwable th4) {
                    th = th4;
                }
            } catch (Exception e) {
                e = e;
                pk.a("AdvertisingIdPlatform", "onServiceConnected4");
                Log.e("AdvertisingIdPlatform", "onServiceConnected error:" + e.getMessage());
                this.f94a.f243a.countDown();
                this.f94a.f243a.countDown();
                this.f94a.a();
            }
        } catch (Exception e2) {
            e = e2;
        }
    }
}
