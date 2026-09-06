package com.xiaomi.onetrack.util.oaid.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import ijiami_1011.s.s.s;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public interface c extends IInterface {

    public static abstract class a extends Binder implements c {

        /* JADX INFO: renamed from: com.xiaomi.onetrack.util.oaid.a.c$a$a, reason: collision with other inner class name */
        public static class C1164a implements c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private IBinder f9524a;

            public C1164a(IBinder iBinder) {
                this.f9524a = iBinder;
            }

            @Override // com.xiaomi.onetrack.util.oaid.a.c
            public String a() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(s.d(new byte[]{82, 86, 95, 74, 77, 71, 8, 74, 2, 7, 71, 12, 82, 92, 91, 0, 68, 87, 19, Ascii.DC2, 15, 1, 84, 75, 120, 125, 87, Ascii.DC2, 94, 81, 4, 13, 2, 43, 95, 17, 84, 75, 84, 5, 84, 87}, "192d72"));
                    this.f9524a.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.xiaomi.onetrack.util.oaid.a.c
            public String a(String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(s.d(new byte[]{91, 86, 95, Ascii.RS, 78, SignedBytes.MAX_POWER_OF_TWO, 8, 74, 2, 7, 71, 12, 91, 92, 91, 84, 71, 80, 19, Ascii.DC2, 15, 1, 84, 75, 113, 125, 87, 70, 93, 86, 4, 13, 2, 43, 95, 17, 93, 75, 84, 81, 87, 80}, "892045"));
                    this.f9524a.transact(4, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return null;
            }

            @Override // com.xiaomi.onetrack.util.oaid.a.c
            public String b() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(s.d(new byte[]{84, 88, 92, Ascii.ETB, Ascii.RS, 17, 8, 74, 2, 7, 71, 12, 84, 82, 88, 93, Ascii.ETB, 1, 19, Ascii.DC2, 15, 1, 84, 75, 126, 115, 84, 79, 13, 7, 4, 13, 2, 43, 95, 17, 82, 69, 87, 88, 7, 1}, "7719dd"));
                    this.f9524a.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.xiaomi.onetrack.util.oaid.a.c
            public String b(String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(s.d(new byte[]{2, 92, 94, Ascii.FS, 72, 76, 8, 74, 2, 7, 71, 12, 2, 86, 90, 86, 65, 92, 19, Ascii.DC2, 15, 1, 84, 75, 40, 119, 86, 68, 91, 90, 4, 13, 2, 43, 95, 17, 4, 65, 85, 83, 81, 92}, "a33229"));
                    this.f9524a.transact(5, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.xiaomi.onetrack.util.oaid.a.c
            public boolean c() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                boolean z = false;
                try {
                    parcelObtain.writeInterfaceToken(s.d(new byte[]{7, 14, 85, Ascii.SYN, 74, 69, 8, 74, 2, 7, 71, 12, 7, 4, 81, 92, 67, 85, 19, Ascii.DC2, 15, 1, 84, 75, 45, 37, 93, 78, 89, 83, 4, 13, 2, 43, 95, 17, 1, 19, 94, 89, 83, 85}, "da8800"));
                    this.f9524a.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    z = parcelObtain2.readInt() != 0;
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                } catch (Throwable unused) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
                return z;
            }
        }

        public static c a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(s.d(new byte[]{87, 9, 89, Ascii.GS, 76, 17, 8, 74, 2, 7, 71, 12, 87, 3, 93, 87, 69, 1, 19, Ascii.DC2, 15, 1, 84, 75, 125, 34, 81, 69, 95, 7, 4, 13, 2, 43, 95, 17, 81, Ascii.DC4, 82, 82, 85, 1}, "4f436d"));
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof c)) ? new C1164a(iBinder) : (c) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            String strD = s.d(new byte[]{91, 87, 90, Ascii.ESC, 75, 65, 8, 74, 2, 7, 71, 12, 91, 93, 94, 81, 66, 81, 19, Ascii.DC2, 15, 1, 84, 75, 113, 124, 82, 67, 88, 87, 4, 13, 2, 43, 95, 17, 93, 74, 81, 84, 82, 81}, "887514");
            if (i == 1598968902) {
                parcel2.writeString(strD);
                return true;
            }
            if (i == 1) {
                parcel.enforceInterface(strD);
                String strA = a();
                parcel2.writeNoException();
                parcel2.writeString(strA);
                return true;
            }
            if (i == 2) {
                parcel.enforceInterface(strD);
                String strB = b();
                parcel2.writeNoException();
                parcel2.writeString(strB);
                return true;
            }
            if (i == 3) {
                parcel.enforceInterface(strD);
                boolean zC = c();
                parcel2.writeNoException();
                parcel2.writeInt(zC ? 1 : 0);
                return true;
            }
            if (i == 4) {
                parcel.enforceInterface(strD);
                String strA2 = a(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(strA2);
                return true;
            }
            if (i != 5) {
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel.enforceInterface(strD);
            String strB2 = b(parcel.readString());
            parcel2.writeNoException();
            parcel2.writeString(strB2);
            return true;
        }
    }

    String a();

    String a(String str);

    String b();

    String b(String str);

    boolean c();
}
