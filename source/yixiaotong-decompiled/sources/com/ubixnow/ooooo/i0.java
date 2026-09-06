package com.ubixnow.ooooo;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public interface i0 extends IInterface {

    public static abstract class OooO00o extends Binder implements i0 {
        private static final String OooO00o = "com.hihonor.cloudservice.oaid.IOAIDService";

        /* JADX INFO: renamed from: com.ubixnow.ooooo.i0$OooO00o$OooO00o, reason: collision with other inner class name */
        public static class C1137OooO00o implements i0 {
            public IBinder OooO00o;

            public C1137OooO00o(IBinder iBinder) {
                this.OooO00o = iBinder;
            }

            @Override // com.ubixnow.ooooo.i0
            public void OooO00o(h0.OooO00o oooO00o) throws Throwable {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcel = null;
                try {
                    Parcel parcelObtain2 = Parcel.obtain();
                    try {
                        parcelObtain2.writeInterfaceToken(OooO00o.OooO00o);
                        if (oooO00o == null) {
                            oooO00o = null;
                        }
                        parcelObtain2.writeStrongBinder(oooO00o);
                        this.OooO00o.transact(2, parcelObtain2, parcelObtain, 0);
                        parcelObtain.readException();
                        parcelObtain.recycle();
                        parcelObtain2.recycle();
                    } catch (Throwable th) {
                        th = th;
                        parcel = parcelObtain2;
                        parcelObtain.recycle();
                        parcel.recycle();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }

            @Override // com.ubixnow.ooooo.i0
            public void OooO0O0(h0.OooO00o oooO00o) throws Throwable {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcel = null;
                try {
                    Parcel parcelObtain2 = Parcel.obtain();
                    try {
                        parcelObtain2.writeInterfaceToken(OooO00o.OooO00o);
                        if (oooO00o == null) {
                            oooO00o = null;
                        }
                        parcelObtain2.writeStrongBinder(oooO00o);
                        this.OooO00o.transact(3, parcelObtain2, parcelObtain, 0);
                        parcelObtain.readException();
                        parcelObtain.recycle();
                        parcelObtain2.recycle();
                    } catch (Throwable th) {
                        th = th;
                        parcel = parcelObtain2;
                        parcelObtain.recycle();
                        parcel.recycle();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.OooO00o;
            }
        }
    }

    void OooO00o(h0.OooO00o oooO00o) throws RemoteException;

    void OooO0O0(h0.OooO00o oooO00o) throws RemoteException;
}
