package com.byazt.gi;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.text.TextUtils;
import com.byazt.gq.t;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
public interface ve extends IInterface {
    void c(tt ttVar, uj ujVar) throws RemoteException;

    @com.byazt.zqa.c(c = {0, 1, 678, 24})
    public static abstract class c extends Binder implements ve {
        public static String c = "";

        public static ve c(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(c);
            if (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof ve)) {
                return new C0161c(iBinder);
            }
            return (ve) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1598968902) {
                parcel2.writeString(c);
                return true;
            }
            if (i == 1) {
                parcel.enforceInterface(c);
                c(parcel.readInt() != 0 ? tt.CREATOR.createFromParcel(parcel) : null, uj.c.c(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            }
            return super.onTransact(i, parcel, parcel2, i2);
        }

        /* JADX INFO: renamed from: com.byazt.gi.ve$c$c, reason: collision with other inner class name */
        @com.byazt.zqa.c(c = {0, 1, 678, 1241})
        private static class C0161c implements ve {
            public IBinder c;

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.c;
            }

            public C0161c(IBinder iBinder) {
                if (TextUtils.isEmpty(c.c)) {
                    JSONObject jSONObjectI = t.i();
                    String unused = c.c = com.byazt.i.ve.c(jSONObjectI.optString(com.kuaishou.weapon.p0.t.k), jSONObjectI.optString("s"));
                }
                this.c = iBinder;
            }

            @Override // com.byazt.gi.ve
            public void c(tt ttVar, uj ujVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(c.c);
                    if (ttVar != null) {
                        parcelObtain.writeInt(1);
                        ttVar.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(ujVar != null ? ujVar.asBinder() : null);
                    this.c.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }
    }
}
