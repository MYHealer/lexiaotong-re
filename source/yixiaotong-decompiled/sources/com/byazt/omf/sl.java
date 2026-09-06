package com.byazt.omf;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
public interface sl extends IInterface {
    void c() throws RemoteException;

    void tt() throws RemoteException;

    void ve() throws RemoteException;

    @com.byazt.zqa.c(c = {0, 1, 31, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_VERSION})
    public static abstract class c extends Binder implements sl {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public c() {
            attachInterface(this, "com.bytedance.sdk.openadsdk.core.ICommonDialogListener");
        }

        public static sl c(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.bytedance.sdk.openadsdk.core.ICommonDialogListener");
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof sl)) {
                return (sl) iInterfaceQueryLocalInterface;
            }
            return new C0237c(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface("com.bytedance.sdk.openadsdk.core.ICommonDialogListener");
                c();
                parcel2.writeNoException();
                return true;
            }
            if (i == 2) {
                parcel.enforceInterface("com.bytedance.sdk.openadsdk.core.ICommonDialogListener");
                tt();
                parcel2.writeNoException();
                return true;
            }
            if (i != 3) {
                if (i == 1598968902) {
                    parcel2.writeString("com.bytedance.sdk.openadsdk.core.ICommonDialogListener");
                    return true;
                }
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel.enforceInterface("com.bytedance.sdk.openadsdk.core.ICommonDialogListener");
            ve();
            parcel2.writeNoException();
            return true;
        }

        /* JADX INFO: renamed from: com.byazt.omf.sl$c$c, reason: collision with other inner class name */
        @com.byazt.zqa.c(c = {0, 1, 31, 1717})
        private static class C0237c implements sl {
            public static sl c;
            public IBinder tt;

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.tt;
            }

            public C0237c(IBinder iBinder) {
                this.tt = iBinder;
            }

            @Override // com.byazt.omf.sl
            public void c() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.core.ICommonDialogListener");
                    if (!this.tt.transact(1, parcelObtain, parcelObtain2, 0) && c.uj() != null) {
                        c.uj().c();
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.omf.sl
            public void tt() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.core.ICommonDialogListener");
                    if (!this.tt.transact(2, parcelObtain, parcelObtain2, 0) && c.uj() != null) {
                        c.uj().tt();
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.omf.sl
            public void ve() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.core.ICommonDialogListener");
                    if (!this.tt.transact(3, parcelObtain, parcelObtain2, 0) && c.uj() != null) {
                        c.uj().ve();
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static sl uj() {
            return C0237c.c;
        }
    }
}
