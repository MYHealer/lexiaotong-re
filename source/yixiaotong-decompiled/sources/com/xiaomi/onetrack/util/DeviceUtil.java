package com.xiaomi.onetrack.util;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.provider.Settings;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class DeviceUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f9501a = 15;
    public static final int b = 6;
    private static final int e = 15;
    private static Method f;
    private static Method g;
    private static Object h;
    private static Method i;
    private static Method j;
    private static volatile String k;
    private static volatile String l;
    private static String m;
    private static String n;
    private static String o;
    private static String p;
    private static volatile boolean q;
    private static final String c = ijiami_1011.s.s.s.d(new byte[]{115, 80, Ascii.DC2, 81, 81, 84, 52, 16, 15, 14}, "75d821");
    private static final String d = ijiami_1011.s.s.s.d(new byte[0], "bf1664");
    private static final String r = ijiami_1011.s.s.s.d(new byte[]{5, 81, 9, 9, 5, 2, 81, 84, 86, 82, 1, 85, 5, 81, 9, 9}, "5a9952");

    public static class GAIDClient {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final String f9502a = ijiami_1011.s.s.s.d(new byte[]{34, 119, 47, 38, 32, 15, 8, 1, 8, Ascii.SYN}, "e6fbcc");

        public static final class AdvertisingConnection implements ServiceConnection {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private static final int f9503a = 30000;
            private boolean b;
            private IBinder c;

            private AdvertisingConnection() {
                this.b = false;
            }

            public /* synthetic */ AdvertisingConnection(h hVar) {
                this();
            }

            public IBinder a() {
                IBinder iBinder = this.c;
                if (iBinder != null) {
                    return iBinder;
                }
                if (iBinder == null && !this.b) {
                    synchronized (this) {
                        wait(30000L);
                        if (this.c == null) {
                            throw new InterruptedException(ijiami_1011.s.s.s.d(new byte[]{43, 12, Ascii.DC2, 70, 81, 91, 15, 10, 3, 1, 69, 69, 10, 17, 70, 5, 93, 90, 15, 1, 5, Ascii.SYN, 17, 17, 12, 14, 3, 9, 71, SignedBytes.MAX_POWER_OF_TWO, 65, 16, 9, 66, 86, 10, 10, 4, 10, 3, Ascii.DC2, 68, 13, 5, Ascii.US, 66, 66, 0, Ascii.ETB, Ascii.NAK, 15, 5, 87}, "ecff24"));
                        }
                    }
                }
                return this.c;
            }

            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                synchronized (this) {
                    this.c = iBinder;
                    notifyAll();
                }
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
                this.b = true;
                this.c = null;
            }
        }

        public static final class a implements IInterface {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private IBinder f9504a;

            public a(IBinder iBinder) {
                this.f9504a = iBinder;
            }

            public String a() {
                if (this.f9504a == null) {
                    return "";
                }
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ijiami_1011.s.s.s.d(new byte[]{83, 86, 9, 74, 81, 87, 14, 3, 10, 7, Ascii.US, 4, 94, 93, Ascii.SYN, 11, 95, 92, 79, 3, 11, 17, Ascii.US, 4, 84, 74, 74, 13, 82, 93, 15, 16, 15, 4, 88, 0, 66, Ascii.ETB, 13, 10, 66, 93, 19, 10, 7, 14, Ascii.US, 44, 113, 93, Ascii.DC2, 1, 68, 76, 8, Ascii.ETB, 15, 12, 86, 44, 84, 106, 1, Ascii.SYN, SignedBytes.MAX_POWER_OF_TWO, 81, 2, 1}, "09dd68"));
                    this.f9504a.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            public boolean a(boolean z) {
                if (this.f9504a == null) {
                    return false;
                }
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ijiami_1011.s.s.s.d(new byte[]{5, 9, 14, Ascii.US, 86, 12, 14, 3, 10, 7, Ascii.US, 4, 8, 2, 17, 94, 88, 7, 79, 3, 11, 17, Ascii.US, 4, 2, Ascii.NAK, 77, 88, 85, 6, 15, 16, 15, 4, 88, 0, Ascii.DC4, 72, 10, 95, 69, 6, 19, 10, 7, 14, Ascii.US, 44, 39, 2, Ascii.NAK, 84, 67, Ascii.ETB, 8, Ascii.ETB, 15, 12, 86, 44, 2, 53, 6, 67, 71, 10, 2, 1}, "ffc11c"));
                    parcelObtain.writeInt(z ? 1 : 0);
                    this.f9504a.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f9504a;
            }
        }

        private GAIDClient() {
        }

        public static String a(Context context) {
            if (!c(context)) {
                p.a(f9502a, ijiami_1011.s.s.s.d(new byte[]{117, 87, 88, 83, 84, 93, 65, Ascii.DC4, 10, 3, 72, 69, 65, 93, 69, 66, 81, 91, 4, 68, 15, 17, 17, 11, 93, 76, Ascii.ETB, 85, 78, 89, 8, 8, 7, 0, 93, 0}, "287488"));
                return "";
            }
            AdvertisingConnection advertisingConnection = new AdvertisingConnection(null);
            try {
                try {
                    Intent intent = new Intent(ijiami_1011.s.s.s.d(new byte[]{91, 91, 93, 74, 5, 94, 14, 3, 10, 7, Ascii.US, 4, 86, 80, 66, 11, 11, 85, 79, 3, 11, 17, Ascii.US, 4, 92, 71, Ascii.RS, 13, 6, 84, 15, 16, 15, 4, 88, 0, 74, 26, 67, 1, 16, 71, 8, 7, 3, 76, 98, 49, 121, 102, 100}, "840db1"));
                    intent.setPackage(ijiami_1011.s.s.s.d(new byte[]{80, 88, 15, Ascii.US, 81, 14, 14, 3, 10, 7, Ascii.US, 4, 93, 83, 16, 94, 95, 5, 79, 3, 11, 17}, "37b16a"));
                    if (context.bindService(intent, advertisingConnection, 1)) {
                        return new a(advertisingConnection.a()).a();
                    }
                } catch (Exception e) {
                    p.a(f9502a, ijiami_1011.s.s.s.d(new byte[]{103, 17, 80, 74, 76, Ascii.SYN, 38, 11, 9, 5, 93, 0, Ascii.SYN, 37, 113, 113, 113, Ascii.SYN, 7, 5, 15, 14, 84, 1, Ascii.SYN}, "6d5856"), e);
                }
                return "";
            } finally {
                context.unbindService(advertisingConnection);
            }
        }

        public static boolean b(Context context) {
            if (!c(context)) {
                p.a(f9502a, ijiami_1011.s.s.s.d(new byte[]{113, 11, 94, 84, 8, 92, 65, Ascii.DC4, 10, 3, 72, 69, 69, 1, 67, 69, 13, 90, 4, 68, 15, 17, 17, 11, 89, 16, 17, 82, Ascii.DC2, 88, 8, 8, 7, 0, 93, 0}, "6d13d9"));
                return false;
            }
            AdvertisingConnection advertisingConnection = new AdvertisingConnection(null);
            try {
                try {
                    Intent intent = new Intent(ijiami_1011.s.s.s.d(new byte[]{83, 14, 84, 76, 4, 11, 14, 3, 10, 7, Ascii.US, 4, 94, 5, 75, 13, 10, 0, 79, 3, 11, 17, Ascii.US, 4, 84, Ascii.DC2, Ascii.ETB, 11, 7, 1, 15, 16, 15, 4, 88, 0, 66, 79, 74, 7, 17, Ascii.DC2, 8, 7, 3, 76, 98, 49, 113, 51, 109}, "0a9bcd"));
                    intent.setPackage(ijiami_1011.s.s.s.d(new byte[]{5, 86, 95, Ascii.EM, 84, 95, 14, 3, 10, 7, Ascii.US, 4, 8, 93, SignedBytes.MAX_POWER_OF_TWO, 88, 90, 84, 79, 3, 11, 17}, "f92730"));
                    if (context.bindService(intent, advertisingConnection, 1)) {
                        return new a(advertisingConnection.a()).a(true);
                    }
                } catch (Exception e) {
                    p.a(f9502a, ijiami_1011.s.s.s.d(new byte[]{99, SignedBytes.MAX_POWER_OF_TWO, 92, 71, 65, Ascii.EM, 38, 11, 9, 5, 93, 0, Ascii.DC2, 92, 74, 121, 81, 84, 8, 16, 39, 6, 101, Ascii.ETB, 83, 86, 82, 92, 86, 94, 36, 10, 7, 0, 93, 0, 86, Ascii.NAK, 95, 84, 81, 85, 4, 0, 70}, "259589"), e);
                }
                return false;
            } finally {
                context.unbindService(advertisingConnection);
            }
        }

        private static boolean c(Context context) {
            try {
                context.getPackageManager().getPackageInfo(ijiami_1011.s.s.s.d(new byte[]{2, 93, 91, 75, 2, 87, 5, Ascii.SYN, 9, 11, 85, 75, Ascii.ETB, 87, 88, 1, 10, 87, 6}, "a26ec9"), 16384);
                return true;
            } catch (PackageManager.NameNotFoundException unused) {
                return false;
            }
        }
    }

    static {
        try {
            f = Class.forName(ijiami_1011.s.s.s.d(new byte[]{2, 8, 1, 16, 95, 88, 5, 74, 9, 17, Ascii.US, 54, 26, Ascii.NAK, 17, 7, 93, 97, 19, 11, Ascii.SYN, 7, 67, 17, 10, 3, Ascii.SYN}, "cfeb01")).getMethod(ijiami_1011.s.s.s.d(new byte[]{81, 84, 77}, "61925c"), String.class);
        } catch (Throwable th) {
            p.b(ijiami_1011.s.s.s.d(new byte[]{118, 92, Ascii.DC4, 94, 2, 87, 52, 16, 15, 14}, "29b7a2"), ijiami_1011.s.s.s.d(new byte[]{65, 127, 6, SignedBytes.MAX_POWER_OF_TWO, 52, Ascii.ETB, 14, Ascii.DC4, 70, 11, 95, 12, 70, Ascii.CAN, 5, 85, 13, 9, 4, 0, 70, 7, 73, 95, Ascii.DC2}, "28c4de") + th.getMessage());
        }
    }

    public static String a(Context context) {
        if (!TextUtils.isEmpty(k)) {
            return k;
        }
        g(context);
        return !TextUtils.isEmpty(k) ? k : "";
    }

    private static String a(String str) {
        try {
            Method method = f;
            if (method != null) {
                return String.valueOf(method.invoke(null, str));
            }
        } catch (Exception e2) {
            p.a(c, ijiami_1011.s.s.s.d(new byte[]{1, 3, Ascii.NAK, 53, 67, 13, 17, 68, 0, 3, 88, 9, 3, 2, 65, 0, 73, 88, 65}, "ffae1b") + e2.getMessage());
        }
        return null;
    }

    public static void a() {
        m = null;
    }

    private static boolean a(List<String> list) {
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (!b(it.next())) {
                return true;
            }
        }
        return false;
    }

    private static String[] a(Class<?> cls, Class<?> cls2, TelephonyManager telephonyManager, SubscriptionManager subscriptionManager) {
        return new String[2];
    }

    public static String b() {
        return Build.MODEL;
    }

    public static String b(Context context) {
        if (!TextUtils.isEmpty(n)) {
            return n;
        }
        String strA = a(context);
        if (TextUtils.isEmpty(strA)) {
            return "";
        }
        String strC = com.xiaomi.onetrack.d.d.c(strA);
        n = strC;
        return strC;
    }

    private static boolean b(String str) {
        return (str == null || str.length() != 15 || str.matches(ijiami_1011.s.s.s.d(new byte[]{103, 84, Ascii.CAN, 66}, "9d2f7d"))) ? false : true;
    }

    private static String[] b(Class<?> cls, Class<?> cls2, TelephonyManager telephonyManager, SubscriptionManager subscriptionManager) {
        return new String[2];
    }

    public static String c() {
        return a(ijiami_1011.s.s.s.d(new byte[]{Ascii.DC4, 90, 72, Ascii.DC4, Ascii.SYN, 13, 5, 17, 5, Ascii.SYN, Ascii.US, 8, 7, 71, 13, 1, 16, 12, 0, 9, 3}, "f5fddb"));
    }

    public static String c(Context context) {
        if (!TextUtils.isEmpty(l)) {
            return l;
        }
        g(context);
        return !TextUtils.isEmpty(l) ? l : "";
    }

    private static boolean c(String str) {
        return str != null && str.length() >= 6 && str.length() <= 15 && !str.matches(ijiami_1011.s.s.s.d(new byte[]{108, 84, Ascii.EM, Ascii.DC4}, "2d3052"));
    }

    public static String d() {
        return Build.MANUFACTURER;
    }

    public static String d(Context context) {
        if (!TextUtils.isEmpty(o)) {
            return o;
        }
        String strC = c(context);
        if (TextUtils.isEmpty(strC)) {
            return "";
        }
        String strC2 = com.xiaomi.onetrack.d.d.c(strC);
        o = strC2;
        return strC2;
    }

    public static String e(Context context) {
        if (!TextUtils.isEmpty(m)) {
            return m;
        }
        if (GAIDClient.b(context)) {
            return "";
        }
        String strA = GAIDClient.a(context);
        if (TextUtils.isEmpty(strA)) {
            return "";
        }
        m = strA;
        return strA;
    }

    public static void e() {
        com.xiaomi.onetrack.util.oaid.a.a().b();
    }

    public static List<String> f(Context context) {
        List<String> listG = g(context);
        ArrayList arrayList = new ArrayList();
        if (listG != null && !listG.isEmpty()) {
            for (int i2 = 0; i2 < listG.size(); i2++) {
                if (!TextUtils.isEmpty(listG.get(i2))) {
                    arrayList.add(i2, com.xiaomi.onetrack.d.d.c(listG.get(i2)));
                }
            }
        }
        return arrayList;
    }

    public static boolean f() {
        return com.xiaomi.onetrack.util.oaid.a.a().c();
    }

    private static List<String> g() {
        return null;
    }

    public static List<String> g(Context context) {
        return null;
    }

    public static List<String> h(Context context) {
        return null;
    }

    private static boolean h() {
        if (ijiami_1011.s.s.s.d(new byte[]{6, 74, 81, Ascii.NAK}, "b95f43").equals(a(ijiami_1011.s.s.s.d(new byte[]{73, 85, 17, 75, 12, 17, Ascii.NAK, 74, Ascii.DC4, 3, 85, 12, 86, Ascii.RS, 14, 77, 9, Ascii.SYN, 8, Ascii.ETB, 15, 15, Ascii.US, 6, 86, 94, 5, 81, 2}, "90c8eb")))) {
            return true;
        }
        String str = Build.DEVICE;
        return ijiami_1011.s.s.s.d(new byte[]{90, 6, Ascii.SYN, 88, 12, 1, 62, 19, 3, Ascii.SYN, 110, 15, 84, 92}, "6ee053").equals(str) || ijiami_1011.s.s.s.d(new byte[]{14, 84, Ascii.ETB, 93, 11, 1, 62, 19, 3, Ascii.SYN, 110, 17, 6, 83}, "b7d523").equals(str) || ijiami_1011.s.s.s.d(new byte[]{46, 123, 10, 85, 82, 81, 81, 86, 84}, "f68ecb").equals(str) || ijiami_1011.s.s.s.d(new byte[]{112, 123, 80, 84, 87, 80, 81, 86, 85}, "86bdfc").equals(str) || ijiami_1011.s.s.s.d(new byte[]{3, 71, 15, 86, 92, 13}, "b5b72d").equals(str) || ijiami_1011.s.s.s.d(new byte[]{43, 120, 6, 5, 9, 87, 81, 85, 87}, "c5458c").equals(str) || ijiami_1011.s.s.s.d(new byte[]{44, 47, 5, 82, 0, 85, 81, 85, 84}, "db7b1a").equals(str);
    }

    public static String i(Context context) {
        try {
            List<String> listH = h(context);
            if (listH == null) {
                return "";
            }
            for (int i2 = 0; i2 < listH.size(); i2++) {
                listH.set(i2, com.xiaomi.onetrack.d.d.h(listH.get(i2)));
            }
            return listH.toString();
        } catch (Throwable th) {
            p.b(p.a(c), ijiami_1011.s.s.s.d(new byte[]{5, 3, 65, 40, 93, 0, 8, 40, 15, 17, 69, 40, 6, 83, Ascii.NAK, 7, 81, 12, 13, 1, 2, 67}, "bf5a0e"), th);
            return "";
        }
    }

    private static boolean i() {
        return false;
    }

    public static String j(Context context) {
        return com.xiaomi.onetrack.util.oaid.a.a().a(context);
    }

    public static String k(Context context) {
        try {
            if (z.b(p)) {
                return p;
            }
            String string = Settings.System.getString(context.getContentResolver(), ijiami_1011.s.s.s.d(new byte[]{80, 92, 82, 67, 13, 93, 5, 59, 15, 6}, "1261b4"));
            if (!z.b(string) || r.equals(string)) {
                return "";
            }
            p = string;
            return string;
        } catch (Throwable th) {
            p.a(p.a(c), ijiami_1011.s.s.s.d(new byte[]{2, 80, 16, 2, 12, 86, 19, 11, 15, 6, 17, 1, 69, 65, 12, 17, 13, 69, 0, 6, 10, 7, 11}, "e5dcb2") + th.getMessage());
            return "";
        }
    }

    private static List<String> l(Context context) {
        return null;
    }

    private static List<String> m(Context context) {
        return null;
    }
}
