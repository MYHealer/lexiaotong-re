package com.xiaomi.onetrack.util.oaid.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.common.base.Ascii;
import ijiami_1011.s.s.s;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public interface d extends IInterface {

    public static abstract class a extends Binder implements d {

        /* JADX INFO: renamed from: com.xiaomi.onetrack.util.oaid.a.d$a$a, reason: collision with other inner class name */
        public static class C1165a implements d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public IBinder f9525a;

            public C1165a(IBinder iBinder) {
                this.f9525a = iBinder;
            }

            public String a(String str, String str2, String str3) {
                String string;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    try {
                        parcelObtain.writeInterfaceToken(s.d(new byte[]{84, 13, 12, Ascii.RS, 81, 87, Ascii.CAN, 16, 7, Ascii.DC2, Ascii.US, 10, 71, 7, 15, 89, 93, Ascii.FS, 40, 43, Ascii.SYN, 7, 95, 44, 115}, "7ba092"));
                        parcelObtain.writeString(str);
                        parcelObtain.writeString(str2);
                        parcelObtain.writeString(str3);
                        this.f9525a.transact(1, parcelObtain, parcelObtain2, 0);
                        parcelObtain2.readException();
                        string = parcelObtain2.readString();
                        parcelObtain.recycle();
                        parcelObtain2.recycle();
                    } catch (Exception e) {
                        e.printStackTrace();
                        parcelObtain.recycle();
                        parcelObtain2.recycle();
                        string = null;
                    }
                    return string;
                } catch (Throwable th) {
                    parcelObtain.recycle();
                    parcelObtain2.recycle();
                    throw th;
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f9525a;
            }
        }

        public static d a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(s.d(new byte[]{6, 90, 92, 72, 92, 82, Ascii.CAN, 16, 7, Ascii.DC2, Ascii.US, 10, Ascii.NAK, 80, 95, 15, 80, Ascii.EM, 40, 43, Ascii.SYN, 7, 95, 44, 33}, "e51f47"));
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof d)) ? new C1165a(iBinder) : (d) iInterfaceQueryLocalInterface;
        }
    }
}
