package com.fancy;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _el implements IInterface {
    public IBinder _a;

    public _el(IBinder iBinder) {
        this._a = iBinder;
    }

    public final void _a(_e5._a _aVar) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.hihonor.cloudservice.oaid.IOAIDService");
            if (_aVar == null) {
                _aVar = null;
            }
            parcelObtain.writeStrongBinder(_aVar);
            this._a.transact(3, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
        } catch (Exception unused) {
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    public final void _a(_e5._b _bVar) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.hihonor.cloudservice.oaid.IOAIDService");
            if (_bVar == null) {
                _bVar = null;
            }
            parcelObtain.writeStrongBinder(_bVar);
            this._a.transact(2, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
        } catch (Exception unused) {
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this._a;
    }
}
