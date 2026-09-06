package com.xiaomi.onetrack.util.oaid.a;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.common.base.Ascii;
import ijiami_1011.s.s.s;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public interface a extends IInterface {

    /* JADX INFO: renamed from: com.xiaomi.onetrack.util.oaid.a.a$a, reason: collision with other inner class name */
    public static final class C1163a implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private IBinder f9522a;

        public C1163a(IBinder iBinder) {
            this.f9522a = iBinder;
        }

        @Override // com.xiaomi.onetrack.util.oaid.a.a
        public String a() {
            String string;
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                parcelObtain.writeInterfaceToken(s.d(new byte[]{84, 9, 12, Ascii.FS, 3, 67, Ascii.DC4, Ascii.ETB, 72, 15, 66, 4, Ascii.EM, 53, Ascii.DC4, 66, Ascii.DC2, 92, 4, 9, 3, 12, 69, 4, 69, Ascii.US, 37, 123, 38, Ascii.RS, 40, 32, 15, 6, 112, 12, 83, 10, 40, 92, Ascii.SYN, 85, 19, 2, 7, 1, 84}, "7fa2b0"));
                this.f9522a.transact(3, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                string = parcelObtain2.readString();
            } catch (Throwable th) {
                parcelObtain.recycle();
                parcelObtain2.recycle();
                th.printStackTrace();
                string = null;
            }
            parcelObtain.recycle();
            parcelObtain2.recycle();
            return string;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this.f9522a;
        }
    }

    String a();
}
