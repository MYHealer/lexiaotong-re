package com.byazt.gi;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.text.TextUtils;
import client.android.yixiaotong.v3.comman.AppTypeIdUtil;
import com.byazt.gq.t;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
public interface uj extends IInterface {
    void c(tt ttVar) throws RemoteException;

    @com.byazt.zqa.c(c = {0, 1, 678, AppTypeIdUtil.NewDevice4GBathOTA})
    public static abstract class c extends Binder implements uj {
        public static String c = "";

        public static uj c(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(c);
            if (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof uj)) {
                return new C0160c(iBinder);
            }
            return (uj) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface(c);
                c(parcel.readInt() != 0 ? tt.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                return true;
            }
            if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel2.writeString(c);
            return true;
        }

        /* JADX INFO: renamed from: com.byazt.gi.uj$c$c, reason: collision with other inner class name */
        @com.byazt.zqa.c(c = {0, 1, 678, MediaPlayer.MEDIA_PLAYER_OPTION_AE_TAR_LUFS})
        private static class C0160c implements uj {
            public IBinder c;

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.c;
            }

            public C0160c(IBinder iBinder) {
                if (TextUtils.isEmpty(c.c)) {
                    JSONObject jSONObjectI = t.i();
                    String unused = c.c = com.byazt.i.ve.c(jSONObjectI.optString("t"), jSONObjectI.optString("s"));
                }
                this.c = iBinder;
            }

            @Override // com.byazt.gi.uj
            public void c(tt ttVar) throws RemoteException {
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
