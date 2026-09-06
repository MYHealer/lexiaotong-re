package com.jg.ids.a;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\93504.dex */
public final class d implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private IBinder f4591a;

    public d(IBinder iBinder) {
        this.f4591a = iBinder;
    }

    @Override // com.jg.ids.a.b
    public final boolean a() {
        boolean z = false;
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.asus.msa.SupplementaryDID.IDidAidlInterface");
            this.f4591a.transact(1, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            z = parcelObtain2.readInt() != 0;
        } catch (Throwable th) {
        } finally {
            try {
                parcelObtain2.recycle();
                parcelObtain.recycle();
            } catch (Throwable th2) {
            }
        }
        return z;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f4591a;
    }

    @Override // com.jg.ids.a.b
    public final String b() {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.asus.msa.SupplementaryDID.IDidAidlInterface");
            this.f4591a.transact(2, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            String string = parcelObtain2.readString();
            try {
                parcelObtain2.recycle();
                parcelObtain.recycle();
                return string;
            } catch (Throwable th) {
                return string;
            }
        } catch (Throwable th2) {
            try {
                parcelObtain2.recycle();
                parcelObtain.recycle();
            } catch (Throwable th3) {
            }
            throw th2;
        }
    }

    @Override // com.jg.ids.a.b
    public final String c() {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.asus.msa.SupplementaryDID.IDidAidlInterface");
            this.f4591a.transact(3, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            String string = parcelObtain2.readString();
            try {
                parcelObtain2.recycle();
                parcelObtain.recycle();
                return string;
            } catch (Throwable th) {
                return string;
            }
        } catch (Throwable th2) {
            try {
                parcelObtain2.recycle();
                parcelObtain.recycle();
            } catch (Throwable th3) {
            }
            throw th2;
        }
    }

    @Override // com.jg.ids.a.b
    public final String d() {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.asus.msa.SupplementaryDID.IDidAidlInterface");
            this.f4591a.transact(4, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            String string = parcelObtain2.readString();
            try {
                parcelObtain2.recycle();
                parcelObtain.recycle();
                return string;
            } catch (Throwable th) {
                return string;
            }
        } catch (Throwable th2) {
            try {
                parcelObtain2.recycle();
                parcelObtain.recycle();
            } catch (Throwable th3) {
            }
            throw th2;
        }
    }

    @Override // com.jg.ids.a.b
    public final String e() {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.asus.msa.SupplementaryDID.IDidAidlInterface");
            this.f4591a.transact(5, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            return parcelObtain2.readString();
        } catch (RemoteException e) {
            return "";
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }
}
