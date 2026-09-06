package com.byazt.uk;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import client.android.yixiaotong.v3.comman.AppTypeIdUtil;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public interface uj extends IInterface {
    void c(String str, int i, String str2) throws RemoteException;

    @com.byazt.zqa.c(c = {0, 1, 87, AppTypeIdUtil.NewDevice4GBathOTA})
    public static abstract class c extends Binder implements uj {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public c() {
            attachInterface(this, "com.bytedance.pangle.IPluginInstallListener");
        }

        public static uj c(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.bytedance.pangle.IPluginInstallListener");
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof uj)) {
                return (uj) iInterfaceQueryLocalInterface;
            }
            return new C0289c(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1) {
                if (i == 1598968902) {
                    parcel2.writeString("com.bytedance.pangle.IPluginInstallListener");
                    return true;
                }
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel.enforceInterface("com.bytedance.pangle.IPluginInstallListener");
            c(parcel.readString(), parcel.readInt(), parcel.readString());
            parcel2.writeNoException();
            return true;
        }

        /* JADX INFO: renamed from: com.byazt.uk.uj$c$c, reason: collision with other inner class name */
        @com.byazt.zqa.c(c = {0, 1, 87, MediaPlayer.MEDIA_PLAYER_OPTION_AE_TAR_LUFS})
        private static class C0289c implements uj {
            public static uj c;
            public IBinder tt;

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.tt;
            }

            public C0289c(IBinder iBinder) {
                this.tt = iBinder;
            }

            @Override // com.byazt.uk.uj
            public void c(String str, int i, String str2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bytedance.pangle.IPluginInstallListener");
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeString(str2);
                    if (!this.tt.transact(1, parcelObtain, parcelObtain2, 0) && c.c() != null) {
                        c.c().c(str, i, str2);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static uj c() {
            return C0289c.c;
        }
    }
}
