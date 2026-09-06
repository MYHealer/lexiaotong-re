package com.stub;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.location.Location;
import android.location.LocationManager;
import android.media.AudioAttributes;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Build;
import android.util.TypedValue;
import com.tianyu.util.DtcLoader;
import com.tianyu.util.a;
import dalvik.system.DexFile;
import java.io.File;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\21418324.dex */
public final class StubApp extends Application {
    private static Context d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Application f8525a = null;
    public static String strEntryApplication = "entryRunApplication";
    private static Application b = null;
    private static String c = "libjiagu";
    private static boolean loadFromLib = false;
    private static boolean needX86Bridge = false;
    private static boolean returnIntern = true;
    public static boolean isIsolated = false;
    private static String e = null;
    private static String f = null;
    private static String g = null;
    private static String h = null;
    private static String i = null;
    private static Map<Integer, String> j = new ConcurrentHashMap();
    private static Map<String, Set<String>> perm = new ConcurrentHashMap();

    public static native void fcmark();

    public static native void interface11(int i2);

    public static native Enumeration<String> interface12(DexFile dexFile);

    public static native long interface13(int i2, long j2, long j3, long j4, int i3, int i4, long j5);

    public static native String interface14(int i2);

    public static native AssetFileDescriptor interface17(AssetManager assetManager, String str);

    public static native InputStream interface18(Class cls, String str);

    public static native InputStream interface19(ClassLoader classLoader, String str);

    public static native InputStream interface199(AssetManager assetManager, String str);

    public static native void interface20();

    public static native void interface21(Application application);

    public static native void interface22(int i2, String[] strArr, int[] iArr);

    public static native void interface24(Activity activity, String[] strArr, int i2);

    public static native ZipEntry interface30(ZipFile zipFile, String str);

    public static native void interface5(Application application);

    public static native InputStream interface51(Resources resources, int i2);

    public static native InputStream interface52(Resources resources, int i2, TypedValue typedValue);

    public static native AssetFileDescriptor interface53(Resources resources, int i2);

    public static native MediaPlayer interface54(Context context, int i2);

    public static native MediaPlayer interface55(Context context, int i2, AudioAttributes audioAttributes, int i3);

    public static native int interface56(SoundPool soundPool, Context context, int i2, int i3);

    public static native String interface6(String str);

    public static native boolean interface7(Application application, Context context);

    public static native boolean interface8(Application application, Context context);

    public static native void interface99(Application application);

    public static native Location mark(LocationManager locationManager, String str);

    public static native void mark();

    public static native void mark(Location location);

    public static native synchronized Object n0013();

    public static native synchronized void n00130(Object obj);

    public static native synchronized boolean n00131(Object obj);

    public static native synchronized Object n001313(Object obj, int i2);

    public static native synchronized Object n00133(Object obj);

    public static native synchronized void n001330(Object obj, Object obj2);

    public static native synchronized Object n001333(Object obj, Object obj2);

    public static native synchronized Object n010333(Object obj, Object obj2);

    public static native void n0110();

    public static native int n0111();

    public static native void n01110(int i2);

    public static native int n01111(int i2);

    public static native void n011110(boolean z, int i2);

    public static native void n011111111310(int i2, int i3, int i4, int i5, boolean z, boolean z2, Object obj, boolean z3);

    public static native Object n011112333(int i2, int i3, long j2, Object obj, Object obj2);

    public static native long n01112(int i2);

    public static native Object n0111233(int i2, long j2, Object obj);

    public static native Object n01113(int i2);

    public static native void n011130(int i2, Object obj);

    public static native boolean n011131(int i2, Object obj);

    public static native double n011132(int i2, Object obj);

    public static native Object n011133(int i2, Object obj);

    public static native Object n01113333(int i2, Object obj, Object obj2, Object obj3);

    public static native long n0112();

    public static native void n01120(long j2);

    public static native int n01121(long j2);

    public static native void n011210(long j2, int i2);

    public static native float n011211(long j2, int i2);

    public static native void n0112110(long j2, int i2, boolean z);

    public static native float n0112111(long j2, int i2, float f2);

    public static native void n01121110(long j2, int i2, int i3, int i4);

    public static native void n011211110(long j2, int i2, float f2, float f3, float f4);

    public static native void n011211330(long j2, float f2, float f3, Object obj, Object obj2);

    public static native long n011212(long j2, int i2);

    public static native void n0112120(long j2, int i2, long j3);

    public static native int n0112121(long j2, int i2, double d2);

    public static native double n0112122(long j2, int i2, double d2);

    public static native void n011212230(long j2, int i2, long j3, long j4, Object obj);

    public static native Object n011213(long j2, int i2);

    public static native void n0112130(long j2, int i2, Object obj);

    public static native int n0112131(long j2, int i2, Object obj);

    public static native long n01121312(long j2, int i2, Object obj, int i3);

    public static native void n01121320(long j2, int i2, Object obj, long j3);

    public static native long n01122(long j2);

    public static native void n011220(long j2, long j3);

    public static native int n011221(long j2, long j3);

    public static native void n0112210(long j2, long j3, int i2);

    public static native void n011230(long j2, Object obj);

    public static native int n011231(long j2, Object obj);

    public static native void n0112310(long j2, Object obj, int i2);

    public static native int n0112311(long j2, Object obj, int i2);

    public static native void n01123110(long j2, Object obj, int i2, int i3);

    public static native long n0112312(long j2, Object obj, int i2);

    public static native Object n0112313(long j2, Object obj, int i2);

    public static native long n0112322(long j2, Object obj, long j3);

    public static native Object n011233(long j2, Object obj);

    public static native void n011233110(long j2, Object obj, Object obj2, int i2, int i3);

    public static native long n01123312(long j2, Object obj, Object obj2, int i2);

    public static native Object n01123313(long j2, Object obj, Object obj2, int i2);

    public static native long n0112332(long j2, Object obj, Object obj2);

    public static native void n011233230(long j2, Object obj, Object obj2, long j3, Object obj3);

    public static native void n0112332310(long j2, Object obj, Object obj2, long j3, Object obj3, int i2);

    public static native void n01123330(long j2, Object obj, Object obj2, Object obj3);

    public static native Object n0113();

    public static native void n01130(Object obj);

    public static native int n01131(Object obj);

    public static native void n011310(Object obj, int i2);

    public static native int n011311(Object obj, int i2);

    public static native int n0113111(Object obj, int i2, int i3);

    public static native Object n01131111123(Object obj, int i2, int i3, int i4, int i5, float f2, double d2);

    public static native Object n011311113(Object obj, int i2, int i3, int i4, int i5);

    public static native Object n01131113(Object obj, int i2, int i3, int i4);

    public static native Object n0113113(Object obj, int i2, int i3);

    public static native Object n01131133(Object obj, int i2, int i3, Object obj2);

    public static native Object n011313(Object obj, int i2);

    public static native void n0113130(Object obj, int i2, Object obj2);

    public static native void n011313110(Object obj, int i2, Object obj2, int i3, int i4);

    public static native void n0113131310(Object obj, int i2, Object obj2, int i3, Object obj3, int i4);

    public static native Object n0113133(Object obj, int i2, Object obj2);

    public static native long n01132(Object obj);

    public static native void n011320(Object obj, long j2);

    public static native Object n0113233(Object obj, long j2, Object obj2);

    public static native Object n01133(Object obj);

    public static native void n011330(Object obj, Object obj2);

    public static native int n011331(Object obj, Object obj2);

    public static native void n0113310(Object obj, Object obj2, int i2);

    public static native void n011331110(Object obj, Object obj2, int i2, int i3, int i4);

    public static native Object n0113313(Object obj, Object obj2, int i2);

    public static native Object n011333(Object obj, Object obj2);

    public static native int n0113331(Object obj, Object obj2, Object obj3);

    public static native int n011333111(Object obj, Object obj2, Object obj3, int i2, boolean z);

    public static native Object n0113331111113(Object obj, Object obj2, Object obj3, int i2, int i3, int i4, boolean z, boolean z2, boolean z3);

    public static native Object n0113333(Object obj, Object obj2, Object obj3);

    public static native int n01133331(Object obj, Object obj2, Object obj3, Object obj4);

    public static native void pmark(Context context);

    public static native void rmark();

    public native synchronized void n11030(Object obj);

    public native synchronized boolean n110331(Object obj, Object obj2);

    public native void n1110();

    public native int n1111();

    public native void n11110(int i2);

    public native boolean n11111(int i2);

    public native void n111110(int i2, int i3);

    public native boolean n111111(int i2, int i3);

    public native boolean n111111111(float f2, float f3, float f4, float f5, boolean z);

    public native Object n111111133(int i2, int i3, int i4, int i5, Object obj);

    public native Object n11111133(int i2, int i3, int i4, Object obj);

    public native void n1111130(int i2, int i3, Object obj);

    public native Object n11113(int i2);

    public native void n111130(int i2, Object obj);

    public native boolean n1111311(int i2, Object obj, boolean z);

    public native int n111132321(int i2, Object obj, long j2, Object obj2, long j3);

    public native Object n111133(int i2, Object obj);

    public native boolean n11113311(int i2, Object obj, Object obj2, int i3);

    public native long n1112();

    public native void n11120(long j2);

    public native boolean n11121(long j2);

    public native void n111210(long j2, int i2);

    public native long n111212(long j2, boolean z);

    public native boolean n111221(long j2, long j3);

    public native void n11123310(long j2, Object obj, Object obj2, boolean z);

    public native Object n1113();

    public native void n11130(Object obj);

    public native int n11131(Object obj);

    public native void n111310(Object obj, int i2);

    public native void n111311110(Object obj, int i2, int i3, int i4, int i5);

    public native void n11131220(Object obj, int i2, long j2, long j3);

    public native void n1113130(Object obj, boolean z, Object obj2);

    public native long n1113132(Object obj, int i2, Object obj2);

    public native Object n111323(Object obj, long j2);

    public native Object n11133(Object obj);

    public native void n111330(Object obj, Object obj2);

    public native void n1113310(Object obj, Object obj2, int i2);

    public native void n11133110(Object obj, Object obj2, boolean z, int i2);

    public native int n111331331(Object obj, Object obj2, int i2, Object obj3, Object obj4);

    public native void n11133220(Object obj, Object obj2, long j2, long j3);

    public native Object n111333(Object obj, Object obj2);

    public native void n11133310(Object obj, Object obj2, Object obj3, int i2);

    public native Object n1113333(Object obj, Object obj2, Object obj3);

    public static String getSoPath1() {
        return f;
    }

    public static String getSoPath2() {
        return g;
    }

    public static String getDir() {
        return h;
    }

    public static Context getAppContext() {
        return d;
    }

    public static Context getOrigApplicationContext(Context context) {
        if (context == f8525a) {
            return b;
        }
        return context;
    }

    private static Application a(Context context) {
        ClassLoader classLoader;
        Class<?> clsLoadClass;
        try {
            if (b == null && (classLoader = context.getClassLoader()) != null && (clsLoadClass = classLoader.loadClass(strEntryApplication)) != null) {
                b = (Application) clsLoadClass.newInstance();
            }
        } catch (Exception e2) {
        }
        return b;
    }

    public static void ChangeTopApplication() {
        try {
            interface7(b, f8525a.getBaseContext());
        } catch (Exception e2) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [java.lang.reflect.Method] */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v4 */
    @Override // android.app.Application
    public final void onCreate() {
        System.currentTimeMillis();
        super.onCreate();
        if (!isIsolated) {
            ChangeTopApplication();
            if (b != null) {
                b.onCreate();
            }
            interface21(b);
            ?? r5 = this;
            if (b != null) {
                r5 = b;
            }
            Context context = d;
            if (r5 != 0 && context != null && a.a(context)) {
                try {
                    ?? declaredMethod = Class.forName(a.a("s\u007f}>zw>rx>Bu`\u007fbdcDy}u")).getDeclaredMethod(a.a("BuwycdubQsdyfydiSq||Rqs{c"), Application.class);
                    declaredMethod.setAccessible(true);
                    declaredMethod.invoke(null, new Object[]{r5});
                } catch (Exception e2) {
                }
            }
        }
    }

    @Override // android.content.ContextWrapper
    protected final void attachBaseContext(Context context) throws Throwable {
        boolean zA;
        System.currentTimeMillis();
        super.attachBaseContext(context);
        a.b();
        d = context;
        if (f8525a == null) {
            f8525a = this;
        }
        if (b == null) {
            Boolean boolValueOf = Boolean.valueOf(a.a());
            Boolean bool = false;
            Boolean bool2 = false;
            if (Build.CPU_ABI.contains("64") || Build.CPU_ABI2.contains("64")) {
                bool = true;
            }
            if (Build.CPU_ABI.contains("mips") || Build.CPU_ABI2.contains("mips")) {
                bool2 = true;
            }
            if (boolValueOf.booleanValue() && needX86Bridge) {
                System.loadLibrary("X86Bridge");
            }
            if (loadFromLib) {
                if (boolValueOf.booleanValue() && !needX86Bridge) {
                    System.loadLibrary("jiagu_x86");
                } else {
                    System.loadLibrary("jiagu");
                }
            } else {
                String absolutePath = context.getFilesDir().getParentFile().getAbsolutePath();
                try {
                    absolutePath = context.getFilesDir().getParentFile().getCanonicalPath();
                } catch (Exception e2) {
                }
                String str = absolutePath + "/.jiagu";
                i = a(str, bool.booleanValue(), bool2.booleanValue());
                e = a(str, false, false);
                f = str + File.separator + e;
                g = str + File.separator + i;
                h = str;
                if (bool2.booleanValue()) {
                    a.a(context, c + "_mips.so", str, e);
                } else if (boolValueOf.booleanValue() && !needX86Bridge) {
                    a.a(context, c + "_x86.so", str, e);
                } else {
                    a.a(context, c + ".so", str, e);
                }
                if (bool.booleanValue() && !bool2.booleanValue()) {
                    if (boolValueOf.booleanValue() && !needX86Bridge) {
                        zA = a.a(context, c + "_x64.so", str, i);
                    } else {
                        zA = a.a(context, c + "_a64.so", str, i);
                    }
                    if (zA) {
                        System.load(str + "/" + i);
                    } else {
                        System.load(str + "/" + e);
                    }
                } else {
                    System.load(str + "/" + e);
                }
            }
        }
        DtcLoader.init();
        if (!isIsolated) {
            interface5(f8525a);
            if (b == null) {
                b = a(context);
                if (b != null) {
                    try {
                        Method declaredMethod = Application.class.getDeclaredMethod("attach", Context.class);
                        if (declaredMethod != null) {
                            declaredMethod.setAccessible(true);
                            declaredMethod.invoke(b, context);
                        }
                        interface99(b);
                        interface8(b, context);
                        return;
                    } catch (Exception e3) {
                        throw new RuntimeException("Failed to call attachBaseContext.", e3);
                    }
                }
                System.exit(1);
            }
        }
    }

    private static String a(String str, boolean z, boolean z2) {
        String str2 = c;
        if (Build.VERSION.SDK_INT < 23) {
            str2 = str2 + str.hashCode();
        }
        if (z && !z2) {
            return str2 + "_64.so";
        }
        return str2 + ".so";
    }

    public static String getString2(int i2) {
        String strInterface14 = j.get(Integer.valueOf(i2));
        if (strInterface14 == null) {
            strInterface14 = interface14(i2);
            j.put(Integer.valueOf(i2), strInterface14);
        }
        if (strInterface14 != null && returnIntern) {
            return strInterface14.intern();
        }
        return strInterface14;
    }

    public static String getString2(String str) {
        try {
            return getString2(Integer.parseInt(str));
        } catch (NumberFormatException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static boolean isX86Arch() {
        return a.a();
    }

    public static void put(Object obj, String[] strArr) {
        try {
            String canonicalName = obj.getClass().getCanonicalName();
            Set<String> set = perm.get(canonicalName);
            if (set != null) {
                set.addAll(Arrays.asList(strArr));
            } else {
                Set<String> setNewSetFromMap = Collections.newSetFromMap(new ConcurrentHashMap());
                Collections.addAll(setNewSetFromMap, strArr);
                Set<String> setPut = perm.put(canonicalName, setNewSetFromMap);
                if (setPut != null) {
                    setPut.addAll(Arrays.asList(strArr));
                }
            }
        } catch (Exception e2) {
        }
    }
}
