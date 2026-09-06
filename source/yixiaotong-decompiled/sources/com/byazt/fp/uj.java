package com.byazt.fp;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import client.android.yixiaotong.v3.comman.AppTypeIdUtil;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.facebook.imageutils.JfifUtil;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
public interface uj extends IInterface {
    boolean c() throws RemoteException;

    String n() throws RemoteException;

    String tt() throws RemoteException;

    String uj() throws RemoteException;

    String ve() throws RemoteException;

    @com.byazt.zqa.c(c = {0, 1, JfifUtil.MARKER_SOS, AppTypeIdUtil.NewDevice4GBathOTA})
    public static abstract class c extends Binder implements uj {
        public static uj c(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.asus.msa.SupplementaryDID.IDidAidlInterface");
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof uj)) {
                return (uj) iInterfaceQueryLocalInterface;
            }
            return new C0154c(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                boolean zC = c();
                parcel2.writeNoException();
                parcel2.writeInt(zC ? 1 : 0);
                return true;
            }
            if (i == 2) {
                parcel.enforceInterface("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                String strTt = tt();
                parcel2.writeNoException();
                parcel2.writeString(strTt);
                return true;
            }
            if (i == 3) {
                parcel.enforceInterface("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                String strVe = ve();
                parcel2.writeNoException();
                parcel2.writeString(strVe);
                return true;
            }
            if (i == 4) {
                parcel.enforceInterface("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                String strUj = uj();
                parcel2.writeNoException();
                parcel2.writeString(strUj);
                return true;
            }
            if (i != 5) {
                if (i == 1598968902) {
                    parcel2.writeString("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                    return true;
                }
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel.enforceInterface("com.asus.msa.SupplementaryDID.IDidAidlInterface");
            String strN = n();
            parcel2.writeNoException();
            parcel2.writeString(strN);
            return true;
        }

        /* JADX INFO: renamed from: com.byazt.fp.uj$c$c, reason: collision with other inner class name */
        @com.byazt.zqa.c(c = {0, 1, JfifUtil.MARKER_SOS, MediaPlayer.MEDIA_PLAYER_OPTION_AE_TAR_LUFS})
        private static class C0154c implements uj {
            public IBinder c;

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.c;
            }

            public C0154c(IBinder iBinder) {
                this.c = iBinder;
            }

            @Override // com.byazt.fp.uj
            public boolean c() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                    this.c.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.fp.uj
            public String tt() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                    this.c.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.fp.uj
            public String ve() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                    this.c.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.fp.uj
            public String uj() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                    this.c.transact(4, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.fp.uj
            public String n() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                    this.c.transact(5, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }
    }
}
