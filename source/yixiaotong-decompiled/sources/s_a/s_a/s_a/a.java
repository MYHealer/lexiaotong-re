package s_a.s_a.s_a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public interface a extends IInterface {

    /* JADX INFO: renamed from: s_a.s_a.s_a.a$a, reason: collision with other inner class name */
    public static abstract class AbstractBinderC1187a extends Binder implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String f9738a = s_a.s_a.s_a.c.a.a("Y29tLmhleXRhcC5vcGVuaWQuSU9wZW5JRA==");

        /* JADX INFO: renamed from: s_a.s_a.s_a.a$a$a, reason: collision with other inner class name */
        public static class C1188a implements a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public IBinder f9739a;

            public C1188a(IBinder iBinder) {
                this.f9739a = iBinder;
            }

            @Override // s_a.s_a.s_a.a
            public String a(String str, String str2, String str3) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(AbstractBinderC1187a.f9738a);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeString(str3);
                    this.f9739a.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f9739a;
            }
        }

        public static a a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(f9738a);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof a)) ? new C1188a(iBinder) : (a) iInterfaceQueryLocalInterface;
        }
    }

    String a(String str, String str2, String str3);
}
