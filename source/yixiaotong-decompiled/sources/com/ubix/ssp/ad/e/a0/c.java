package com.ubix.ssp.ad.e.a0;

import android.R;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.Dialog;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.widget.LinearLayout;
import client.android.yixiaotong.util.TimeUtils;
import com.byazt.hv.TTDownloadField;
import com.huawei.hms.ml.camera.CountryCodeBean;
import com.stub.StubApp;
import com.ubixnow.ooooo.oOo00o00;
import com.yfanads.android.qapp.Val;
import java.io.File;
import java.io.FileFilter;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Context f8631a = null;
    public static int b = 0;
    public static String c = "";
    private static boolean z;
    public static Executor d = y();
    public static ScheduledExecutorService e = z();
    public static ExecutorService f = A();
    private static HashMap<String, Long> g = new HashMap<>();
    private static String h = "";
    private static final Object i = new Object();
    private static String j = "";
    private static int k = 0;
    private static String l = "";
    private static String m = "";
    private static long n = 0;
    public static long o = 0;
    public static String p = "";
    public static int q = -1;
    private static String r = "";
    private static String s = "";
    private static String t = "";
    private static String u = "";
    private static String v = "";
    private static String w = "";
    private static int x = -1;
    private static int y = 0;
    public static String A = "0";
    public static String B = "0";

    class a implements ThreadFactory {
        a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "Ubix.OtherRequestExecuteThread");
        }
    }

    class b implements FileFilter {
        b() {
        }

        @Override // java.io.FileFilter
        public boolean accept(File file) {
            return Pattern.matches("cpu[0-9]", file.getName());
        }
    }

    /* JADX INFO: renamed from: com.ubix.ssp.ad.e.a0.c$c, reason: collision with other inner class name */
    class ThreadFactoryC1062c implements ThreadFactory {
        ThreadFactoryC1062c() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "Ubix.RequestCommonExecuteThread");
        }
    }

    class d implements ThreadFactory {
        d() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "Ubix.ResourceLoadThread");
        }
    }

    class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f8632a;

        e(Context context) {
            this.f8632a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                k.a(k.e(this.f8632a).getAbsolutePath(), 104857600L);
                k.a(k.f(this.f8632a).getAbsolutePath(), 209715200L);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    class f implements Runnable {
        f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.t();
        }
    }

    class g implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f8633a = 0;
        final /* synthetic */ h b;
        final /* synthetic */ ArrayList c;

        g(h hVar, ArrayList arrayList) {
            this.b = hVar;
            this.c = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                int iA = new t().a(c.f8631a);
                if (iA != 0) {
                    int i = this.f8633a + 1;
                    this.f8633a = i;
                    if (i <= 20) {
                        return;
                    }
                }
                h hVar = this.b;
                if (hVar != null) {
                    hVar.a(iA, this.f8633a);
                }
                if (this.c.get(0) != null) {
                    ((ScheduledFuture) this.c.get(0)).cancel(true);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public interface h {
        void a(int i, int i2);
    }

    private c() {
    }

    public static ExecutorService A() {
        if (f == null) {
            f = new ThreadPoolExecutor(5, 5, 0L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new d());
        }
        return f;
    }

    public static boolean B() {
        try {
            if (System.currentTimeMillis() - e("isDebugMode") > com.ubix.ssp.ad.d.b.s) {
                h("isDebugMode");
                Calendar calendar = Calendar.getInstance();
                String str = calendar.get(2) + com.huawei.openalliance.ad.constant.x.A + calendar.get(5);
                String strD = v.d(f8631a, "ubix_sp_world", "DEBUG_ON");
                if (!TextUtils.isEmpty(strD) && strD.equals(str)) {
                    z = true;
                    return true;
                }
                String strD2 = d("sys.usb.config");
                if (!TextUtils.isEmpty(strD2)) {
                    if (!strD2.contains("adb")) {
                        z = false;
                        return false;
                    }
                    v.b(f8631a, "ubix_sp_world", "DEBUG_ON", str);
                    z = true;
                    return true;
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return z;
    }

    public static boolean C() {
        ActivityManager activityManager;
        Context context = f8631a;
        if (context != null && (activityManager = (ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY)) != null && activityManager.getRunningAppProcesses() != null) {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : activityManager.getRunningAppProcesses()) {
                if (runningAppProcessInfo.processName.equals(f8631a.getPackageName()) && runningAppProcessInfo.importance == 100) {
                    return true;
                }
            }
        }
        return false;
    }

    public static int D() {
        try {
            int i2 = b;
            if (i2 != 0) {
                return i2;
            }
            Class<?> cls = Class.forName("com.huawei.system.BuildEx");
            if ("harmony".equalsIgnoreCase(cls.getMethod("getOsBrand", new Class[0]).invoke(cls, new Object[0]).toString())) {
                b = 3;
                return 3;
            }
        } catch (Throwable unused) {
        }
        b = 1;
        return 1;
    }

    public static Activity a() {
        try {
            Class<?> cls = Class.forName(Val.AT);
            Object objInvoke = cls.getMethod(Val.CAT, new Class[0]).invoke(null, new Object[0]);
            Field declaredField = cls.getDeclaredField("mActivities");
            declaredField.setAccessible(true);
            for (Object obj : ((Map) declaredField.get(objInvoke)).values()) {
                Class<?> cls2 = obj.getClass();
                Field declaredField2 = cls2.getDeclaredField("paused");
                declaredField2.setAccessible(true);
                if (!declaredField2.getBoolean(obj)) {
                    Field declaredField3 = cls2.getDeclaredField(TTDownloadField.TT_ACTIVITY);
                    declaredField3.setAccessible(true);
                    return (Activity) declaredField3.get(obj);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return null;
    }

    public static Dialog a(Context context, View view) {
        try {
            try {
                if (!(context instanceof Activity) || ((Activity) context).isFinishing()) {
                    context = a();
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            if (context == null) {
                return null;
            }
            return a(context, view, true);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static Dialog a(Context context, View view, boolean z2) {
        Dialog dialog;
        try {
            try {
                dialog = new Dialog(context, R.style.Theme.DeviceDefault.Light.Dialog.NoActionBar);
                try {
                    dialog.getWindow().requestFeature(1);
                    dialog.setContentView(view);
                    dialog.setCancelable(false);
                    dialog.setCanceledOnTouchOutside(false);
                    dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
                    dialog.getWindow().setLayout(-1, -1);
                } catch (Throwable th) {
                    th = th;
                    th.printStackTrace();
                }
            } catch (Throwable unused) {
                return new Dialog(context);
            }
        } catch (Throwable th2) {
            th = th2;
            dialog = null;
        }
        return dialog;
    }

    public static Drawable a(Context context, int i2, int i3) {
        float f2 = i3;
        float[] fArr = {f2, f2, f2, f2, f2, f2, f2, f2};
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(i2);
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadii(fArr);
        return gradientDrawable;
    }

    public static Drawable a(Context context, int i2, int i3, int i4) {
        float f2 = i3;
        float[] fArr = {f2, f2, f2, f2, f2, f2, f2, f2};
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(i2);
        gradientDrawable.setCornerRadii(fArr);
        gradientDrawable.setStroke(4, i4);
        return gradientDrawable;
    }

    public static Drawable a(Context context, int i2, int i3, int i4, int i5) {
        float f2 = i3;
        float[] fArr = {f2, f2, f2, f2, f2, f2, f2, f2};
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(i2);
        gradientDrawable.setCornerRadii(fArr);
        gradientDrawable.setStroke(i5, i4);
        return gradientDrawable;
    }

    public static GradientDrawable a(int i2, int i3, int i4) {
        return a(i2, i3, i4, GradientDrawable.Orientation.TOP_BOTTOM);
    }

    public static GradientDrawable a(int i2, int i3, int i4, GradientDrawable.Orientation orientation) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setOrientation(orientation);
        gradientDrawable.setGradientType(0);
        gradientDrawable.setColors(new int[]{i2, i3});
        float f2 = i4;
        gradientDrawable.setCornerRadii(new float[]{f2, f2, f2, f2, f2, f2, f2, f2});
        return gradientDrawable;
    }

    public static String a(Context context) {
        String string;
        ActivityInfo activityInfo;
        synchronized (i) {
            try {
                u.e("run getAL");
                Intent intent = new Intent(new String(Base64.decode("YW5kcm9pZC5pbnRlbnQuYWN0aW9uLk1BSU4=", 0)));
                intent.addCategory(new String(Base64.decode("YW5kcm9pZC5pbnRlbnQuY2F0ZWdvcnkuTEFVTkNIRVI=", 0)));
                PackageManager packageManager = context.getPackageManager();
                StringBuilder sb = new StringBuilder();
                Object objInvoke = packageManager.getClass().getMethod(new String(Base64.decode("cXVlcnlJbnRlbnRBY3Rpdml0aWVz", 0)), Intent.class, Integer.TYPE).invoke(packageManager, intent, 131072);
                if (objInvoke instanceof List) {
                    List list = (List) objInvoke;
                    String str = new String(Base64.decode("Y29tLmFuZHJvaWQu", 0));
                    for (int i2 = 0; i2 < list.size(); i2++) {
                        ResolveInfo resolveInfo = (ResolveInfo) list.get(i2);
                        if (resolveInfo != null && (activityInfo = resolveInfo.activityInfo) != null && !TextUtils.isEmpty(activityInfo.packageName)) {
                            try {
                                if (!((Boolean) resolveInfo.getClass().getField(new String(Base64.decode("c3lzdGVt", 0))).get(resolveInfo)).booleanValue()) {
                                    if (!resolveInfo.activityInfo.packageName.startsWith(str)) {
                                        if (i2 == list.size() - 1) {
                                            sb.append(resolveInfo.activityInfo.packageName);
                                        } else {
                                            sb.append(resolveInfo.activityInfo.packageName).append(",");
                                        }
                                    }
                                }
                            } catch (Throwable th) {
                                th.printStackTrace();
                            }
                        }
                    }
                }
                string = sb.toString();
            } catch (Throwable th2) {
                th2.printStackTrace();
                throw new RuntimeException(th2.getMessage());
            }
        }
        return string;
    }

    public static String a(Context context, String str) {
        try {
            PackageInfo packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(str, 1);
            if (packageArchiveInfo == null) {
                return "";
            }
            ApplicationInfo applicationInfo = packageArchiveInfo.applicationInfo;
            applicationInfo.sourceDir = str;
            applicationInfo.publicSourceDir = str;
            return applicationInfo.packageName;
        } catch (Throwable unused) {
            u.a("this file is not valid apk");
            return "";
        }
    }

    public static String a(com.ubix.ssp.ad.e.y.a.a.c cVar) {
        if (cVar == null || !cVar.o) {
            return null;
        }
        return cVar.n;
    }

    public static String a(String str) {
        try {
            return String.valueOf(new SimpleDateFormat(TimeUtils.FORMATDATETIME).parse(str).getTime() / 1000);
        } catch (ParseException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static String a(boolean z2) {
        try {
            if (!z2) {
                return s;
            }
            long jE = e("getAndroidId");
            if (jE != 0) {
                return s;
            }
            if (System.currentTimeMillis() - jE > com.ubix.ssp.ad.d.b.s) {
                h("getAndroidId");
                String string = Settings.Secure.getString(f8631a.getContentResolver(), "android_id");
                s = string;
                if (TextUtils.isEmpty(string)) {
                    s = "";
                } else {
                    v.a(e(), "ubix_sp_seed", "android_id_expired", System.currentTimeMillis() + 864000000);
                    v.b(e(), "ubix_sp_seed", "android_id", Base64.encodeToString(s.getBytes(), 10));
                }
            }
            return s;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void a(int i2, int i3, String str) {
        StringBuilder sbAppend;
        String str2;
        String strA;
        boolean z2;
        StringBuilder sbAppend2;
        String string;
        long jCurrentTimeMillis = System.currentTimeMillis();
        long jC = v.c(f8631a, "ubix_sp_dungeon1", "throw_time");
        if (jC != 0 || (i2 == 2 && !TextUtils.isEmpty(str))) {
            if (jC == 0) {
                v.a(f8631a, "ubix_sp_dungeon1", "throw_time", System.currentTimeMillis());
            }
            if (System.currentTimeMillis() - jC > com.ubix.ssp.ad.d.b.I || (i2 == 2 && !TextUtils.isEmpty(str))) {
                long jC2 = v.c(f8631a, "ubix_sp_dungeon1", com.hihonor.adsdk.base.g.j.e.a.s);
                if (System.currentTimeMillis() - jC2 > com.ubix.ssp.ad.d.b.H) {
                    boolean z3 = true;
                    if (i2 == 1) {
                        try {
                            strA = a(f8631a);
                        } catch (Throwable th) {
                            str2 = "error=" + th.getMessage();
                            strA = null;
                            z2 = true;
                        }
                    } else {
                        z3 = TextUtils.isEmpty(str);
                        strA = str;
                    }
                    z2 = z3;
                    str2 = "";
                    v.a(f8631a, "ubix_sp_dungeon1", com.hihonor.adsdk.base.g.j.e.a.s, System.currentTimeMillis());
                    if (strA != null) {
                        u.e("shouldGetAppList " + strA);
                        if (z2) {
                            String strEncodeToString = Base64.encodeToString(strA.getBytes(StandardCharsets.UTF_8), 2);
                            p.a(strEncodeToString);
                            v.b(f8631a, "ubix_sp_mansion", "ubix_sp_vindicator", strEncodeToString);
                        }
                        HashMap<String, Object> map = new HashMap<>();
                        HashMap map2 = new HashMap();
                        map2.put("ubix_tx_pkg_list", strA);
                        map2.put("ubix_tx_oaid", com.ubix.ssp.ad.d.b.e);
                        map2.put("ubix_tx_android_id", com.ubix.ssp.ad.d.b.f);
                        map2.put("ubix_tx_granted", i2 + "");
                        map2.put("ubix_tx_custom_granted", i3 + "");
                        map.put("EVENT_ATTRS", map2);
                        long jElapsedRealtime = SystemClock.elapsedRealtime() - jCurrentTimeMillis;
                        map.put("EVENT_DURATION", Long.valueOf(jElapsedRealtime > 0 ? jElapsedRealtime : 0L));
                        com.ubix.ssp.ad.e.w.f.a(f8631a).j(map);
                        return;
                    }
                    sbAppend2 = !TextUtils.isEmpty(str2) ? new StringBuilder("list is empty?last msg:").append(str2).append(" bt=") : new StringBuilder("list is empty bt=");
                } else {
                    sbAppend = new StringBuilder("not you,skip! rt=").append(jC2);
                }
                string = sbAppend.append(";now=").append(System.currentTimeMillis()).toString();
            } else {
                sbAppend2 = new StringBuilder("run next time,now=");
            }
            sbAppend = sbAppend2.append(jC);
            string = sbAppend.append(";now=").append(System.currentTimeMillis()).toString();
        } else {
            v.a(f8631a, "ubix_sp_dungeon1", "throw_time", System.currentTimeMillis());
            string = "Yokoso";
        }
        if (TextUtils.isEmpty(string)) {
            return;
        }
        u.e(string);
    }

    public static void a(Context context, Intent intent, String str) {
        u.b("--intent:" + intent);
        if (!TextUtils.isEmpty(str)) {
            intent.putExtra("android.intent.extra.REFERRER", Uri.parse("android-app://" + str));
        }
        context.startActivity(intent);
        u.b("has app deepLink jump success");
    }

    public static void a(Context context, String str, String str2) {
        u.b("--url:" + str);
        try {
            a(context, c(str), str2);
            u.b("has app deepLink jump success");
        } catch (Exception e2) {
            u.d("no app deepLink jump failed");
            u.d(e2.toString());
        }
    }

    public static void a(h hVar) {
        try {
            z();
            ArrayList arrayList = new ArrayList();
            arrayList.add(e.scheduleAtFixedRate(new g(hVar, arrayList), 0L, 500L, TimeUnit.MILLISECONDS));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void a(Object obj, String str) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Method method = obj.getClass().getMethod(str, Integer.TYPE);
        if (!method.isAccessible()) {
            method.setAccessible(true);
        }
        method.invoke(obj, 131072);
    }

    public static boolean a(Activity activity) {
        try {
            Class<?> cls = Class.forName(Val.AT);
            Object objInvoke = cls.getMethod(Val.CAT, new Class[0]).invoke(null, new Object[0]);
            Field declaredField = cls.getDeclaredField("mActivities");
            declaredField.setAccessible(true);
            for (Object obj : ((Map) declaredField.get(objInvoke)).values()) {
                Class<?> cls2 = obj.getClass();
                Field declaredField2 = cls2.getDeclaredField("stopped");
                declaredField2.setAccessible(true);
                Field declaredField3 = cls2.getDeclaredField(TTDownloadField.TT_ACTIVITY);
                declaredField3.setAccessible(true);
                if (((Activity) declaredField3.get(obj)) == activity) {
                    return !declaredField2.getBoolean(obj);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return false;
    }

    public static boolean a(Context context, Intent intent) {
        try {
            return !context.getPackageManager().queryIntentActivities(intent, 0).isEmpty();
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [android.view.View, android.widget.LinearLayout] */
    /* JADX WARN: Type inference failed for: r13v10 */
    /* JADX WARN: Type inference failed for: r13v11 */
    /* JADX WARN: Type inference failed for: r13v12 */
    /* JADX WARN: Type inference failed for: r13v5, types: [android.view.View, android.widget.RelativeLayout, com.ubix.ssp.ad.e.z.h] */
    /* JADX WARN: Type inference failed for: r13v7 */
    /* JADX WARN: Type inference failed for: r13v8 */
    /* JADX WARN: Type inference failed for: r13v9 */
    /* JADX WARN: Type inference failed for: r14v0, types: [android.app.Dialog] */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v7, types: [android.view.View, android.widget.RelativeLayout, com.ubix.ssp.ad.e.z.h] */
    /* JADX WARN: Type inference failed for: r4v9 */
    /* JADX WARN: Type inference failed for: r8v2, types: [android.app.Dialog] */
    /* JADX WARN: Type inference failed for: r8v7, types: [android.view.View, android.widget.LinearLayout] */
    public static boolean a(Context context, Bundle bundle, com.ubix.ssp.ad.e.z.h.c cVar, com.ubix.ssp.ad.e.z.h.b bVar) {
        ?? fVar;
        ?? fVar2;
        Context contextA = context;
        try {
            try {
                if (!(contextA instanceof Activity) || ((Activity) contextA).isFinishing()) {
                    contextA = a();
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            if (contextA == null) {
                return false;
            }
            try {
                try {
                    int i2 = bundle.getInt("TYPE", 0);
                    if (i2 == 1) {
                        fVar2 = new com.ubix.ssp.ad.e.z.g(contextA);
                    } else if (i2 == 0) {
                        fVar2 = new com.ubix.ssp.ad.e.z.a(contextA);
                    } else if (i2 == 4) {
                        fVar2 = new com.ubix.ssp.ad.e.z.d(contextA);
                    } else if (i2 == 3) {
                        fVar2 = new com.ubix.ssp.ad.e.z.b(contextA);
                    } else {
                        fVar2 = i2 == 6 ? new com.ubix.ssp.ad.e.z.f(contextA) : new com.ubix.ssp.ad.e.z.e(contextA);
                    }
                    ?? dialog = new Dialog(contextA, R.style.Theme.DeviceDefault.Light.Dialog.NoActionBar);
                    if (i2 == 4) {
                        if (dialog.getWindow() != null) {
                            GradientDrawable gradientDrawable = new GradientDrawable();
                            gradientDrawable.setShape(0);
                            gradientDrawable.setColor(-1);
                            gradientDrawable.setStroke(2, Color.parseColor("#ffffff"));
                            gradientDrawable.setCornerRadius(8.0f);
                            dialog.getWindow().setBackgroundDrawable(gradientDrawable);
                        }
                        dialog.setCanceledOnTouchOutside(true);
                        dialog.setCancelable(true);
                    } else if (i2 == 6) {
                        Window window = dialog.getWindow();
                        window.setLayout(-1, -2);
                        window.setBackgroundDrawableResource(R.color.transparent);
                        window.setDimAmount(0.3f);
                        window.addFlags(2);
                        window.setGravity(80);
                    } else {
                        if (i2 == 1) {
                            GradientDrawable gradientDrawable2 = new GradientDrawable();
                            gradientDrawable2.setShape(0);
                            gradientDrawable2.setColor(-1);
                            gradientDrawable2.setStroke(2, Color.parseColor("#ffffff"));
                            gradientDrawable2.setCornerRadius(32.0f);
                            dialog.getWindow().setBackgroundDrawable(gradientDrawable2);
                        }
                        dialog.setCanceledOnTouchOutside(false);
                        dialog.setCancelable(false);
                    }
                    ?? linearLayout = new LinearLayout(e());
                    linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                    linearLayout.addView(fVar2);
                    linearLayout.setGravity(17);
                    dialog.setContentView(linearLayout);
                    dialog.show();
                    fVar2.a(dialog, cVar, bVar);
                    fVar2.setData(bundle);
                    fVar2.requestLayout();
                } catch (Throwable unused) {
                    int i3 = bundle.getInt("TYPE", 0);
                    if (i3 == 1) {
                        fVar = new com.ubix.ssp.ad.e.z.g(contextA);
                    } else if (i3 == 0) {
                        fVar = new com.ubix.ssp.ad.e.z.a(contextA);
                    } else if (i3 == 4) {
                        fVar = new com.ubix.ssp.ad.e.z.d(contextA);
                    } else if (i3 == 3) {
                        fVar = new com.ubix.ssp.ad.e.z.b(contextA);
                    } else {
                        fVar = i3 == 6 ? new com.ubix.ssp.ad.e.z.f(contextA) : new com.ubix.ssp.ad.e.z.e(contextA);
                    }
                    ?? dialog2 = new Dialog(contextA);
                    ?? linearLayout2 = new LinearLayout(e());
                    linearLayout2.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                    linearLayout2.addView(fVar);
                    linearLayout2.setGravity(17);
                    dialog2.setContentView(linearLayout2);
                    dialog2.setCancelable(false);
                    dialog2.setCanceledOnTouchOutside(false);
                    dialog2.show();
                    fVar.a(dialog2, cVar, bVar);
                    fVar.setData(bundle);
                    fVar.requestLayout();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                return false;
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        return true;
    }

    public static boolean a(Context context, String str, JSONObject jSONObject) {
        Cursor cursorQuery;
        try {
            ContentResolver contentResolver = context.getContentResolver();
            if (contentResolver == null) {
                return false;
            }
            cursorQuery = contentResolver.query(Uri.parse(str), null, jSONObject.toString(), null, null, null);
            if (cursorQuery == null) {
                if (cursorQuery != null) {
                    try {
                        cursorQuery.close();
                    } catch (Throwable unused) {
                    }
                }
                return false;
            }
            try {
                Bundle extras = cursorQuery.getExtras();
                if (extras == null) {
                    try {
                        cursorQuery.close();
                    } catch (Throwable unused2) {
                    }
                    return false;
                }
                if (extras.getInt("code") != 0) {
                    extras.getString("msg");
                    try {
                        cursorQuery.close();
                    } catch (Throwable unused3) {
                    }
                    return false;
                }
                try {
                    cursorQuery.close();
                    return true;
                } catch (Throwable unused4) {
                    return true;
                }
            } catch (Throwable unused5) {
            }
        } catch (Throwable unused6) {
            cursorQuery = null;
        }
        if (cursorQuery != null) {
            try {
                cursorQuery.close();
            } catch (Throwable unused7) {
            }
        }
        return false;
    }

    public static boolean a(com.ubix.ssp.ad.e.y.a.a.b bVar) {
        if (bVar == null) {
            return false;
        }
        return a(bVar.n, bVar.g, bVar.A, bVar.z, bVar.C, bVar.B, bVar.F);
    }

    public static boolean a(String str, String str2) {
        try {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            Intent launchIntentForPackage = f8631a.getPackageManager().getLaunchIntentForPackage(str);
            if (!TextUtils.isEmpty(str2)) {
                launchIntentForPackage.putExtra("android.intent.extra.REFERRER", Uri.parse("android-app://" + str));
            }
            launchIntentForPackage.addFlags(805339136);
            f8631a.startActivity(launchIntentForPackage);
            return true;
        } catch (Exception e2) {
            u.d("isCanPackageNameLaunch", "Exception " + e2.getMessage());
            return false;
        }
    }

    public static boolean a(String... strArr) {
        if (strArr == null) {
            return false;
        }
        for (String str : strArr) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
        }
        return true;
    }

    public static int b(boolean z2) {
        if (!z2) {
            return 0;
        }
        try {
            if (x == -1) {
                long jE = e("getCarrierCode");
                if (com.ubix.ssp.ad.e.a0.d0.c.a(f8631a, "android.permission.READ_PHONE_STATE") && System.currentTimeMillis() - jE > com.ubix.ssp.ad.d.b.s) {
                    h("getCarrierCode");
                    int i2 = Integer.parseInt(((TelephonyManager) f8631a.getSystemService("phone")).getSimOperator());
                    x = i2;
                    return i2;
                }
                x = 0;
            }
            return x;
        } catch (Exception unused) {
            x = 0;
            return 0;
        }
    }

    private static PackageInfo b(Context context, String str) {
        PackageManager packageManager;
        try {
            if (!TextUtils.isEmpty(str) && context != null && (packageManager = context.getPackageManager()) != null) {
                return packageManager.getPackageInfo(str, 128);
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public static Bitmap b(String str) {
        try {
            new BitmapFactory.Options().inPreferredConfig = Bitmap.Config.RGB_565;
            try {
                com.ubix.ssp.ad.e.v.a aVarB = com.ubix.ssp.ad.e.v.e.b();
                aVarB.c(str);
                Bitmap bitmapB = aVarB.b(str);
                if (bitmapB != null) {
                    return j.a(Bitmap.createScaledBitmap(bitmapB, bitmapB.getWidth() / 50, bitmapB.getHeight() / 50, false), 5, false);
                }
                return null;
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static String b() {
        try {
            if (!TextUtils.isEmpty(m)) {
                return m;
            }
            PackageManager packageManager = f8631a.getPackageManager();
            return packageManager.getApplicationInfo(f8631a.getPackageName(), 128).loadLabel(packageManager).toString();
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public static String b(Context context) {
        String strC;
        long jE = e("getHmsVersionCode");
        if (jE != 0) {
            return v;
        }
        if (System.currentTimeMillis() - jE > com.ubix.ssp.ad.d.b.s) {
            h("getHmsVersionCode");
            if (!TextUtils.isEmpty(v)) {
                return v;
            }
            try {
                strC = c(context, "com.huawei.hwid");
            } catch (Exception unused) {
                strC = "";
            }
        } else {
            strC = "";
        }
        if (TextUtils.isEmpty(strC)) {
            return v;
        }
        v = strC;
        return strC;
    }

    public static boolean b(Context context, Bundle bundle, com.ubix.ssp.ad.e.z.h.c cVar, com.ubix.ssp.ad.e.z.h.b bVar) {
        com.ubix.ssp.ad.e.z.h bVar2;
        try {
            if (!(context instanceof Activity) || ((Activity) context).isFinishing()) {
                context = a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (context == null) {
            return false;
        }
        try {
            int i2 = bundle.getInt("TYPE", 0);
            if (i2 == 1) {
                bVar2 = new com.ubix.ssp.ad.e.z.g(context);
            } else if (i2 == 0) {
                bVar2 = new com.ubix.ssp.ad.e.z.a(context);
            } else if (i2 == 2) {
                bVar2 = new com.ubix.ssp.ad.e.z.e(context);
            } else {
                bVar2 = i2 == 3 ? new com.ubix.ssp.ad.e.z.b(context) : null;
            }
            l lVar = new l(bVar2, -2, -2);
            lVar.b(((Activity) context).getWindow().getDecorView(), 17);
            bVar2.a(lVar, cVar, bVar);
            bVar2.setData(bundle);
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static Intent c(String str) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.addFlags(805339136);
        intent.setData(Uri.parse(str));
        return intent;
    }

    public static String c() {
        try {
            if ("0".equals(A)) {
                if (A.contains("kernel")) {
                    return "";
                }
                if (!"0".equals(A)) {
                    return A.trim();
                }
                String strA = new i().a("cat /proc/sys/kernel/random/boot_id", 1000).a();
                A = strA;
                if (strA.contains("kernel")) {
                    A = "kernel";
                    return "";
                }
                if (A.toLowerCase().contains("cannot")) {
                    A = "";
                    return "";
                }
            }
            return A.trim();
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public static String c(Context context) {
        String strC;
        long jE = e("getHuaweiAgVersionCode");
        if (jE != 0) {
            return u;
        }
        if (System.currentTimeMillis() - jE > com.ubix.ssp.ad.d.b.s) {
            h("getHuaweiAgVersionCode");
            if (!TextUtils.isEmpty(u)) {
                return u;
            }
            try {
                strC = c(context, com.huawei.openalliance.ad.constant.x.af);
            } catch (Exception unused) {
                strC = "";
            }
        } else {
            strC = "";
        }
        if (TextUtils.isEmpty(strC)) {
            return u;
        }
        u = strC;
        return strC;
    }

    private static String c(Context context, String str) {
        PackageInfo packageInfoB = b(context, str);
        if (packageInfoB == null) {
            return null;
        }
        return String.valueOf(packageInfoB.versionCode);
    }

    public static String c(boolean z2) {
        String str;
        if (!z2) {
            w = "0";
            return "0";
        }
        if (TextUtils.isEmpty(w)) {
            try {
                if (!com.ubix.ssp.ad.e.a0.d0.c.a(f8631a, "android.permission.READ_PHONE_STATE")) {
                    w = "0";
                    return "0";
                }
                long jE = e("getSimOperatorType");
                if (TextUtils.isEmpty(w) && System.currentTimeMillis() - jE > com.ubix.ssp.ad.d.b.s) {
                    h("getSimOperatorType");
                    String simOperator = ((TelephonyManager) f8631a.getSystemService("phone")).getSimOperator();
                    if ("46001".equals(simOperator) || "46006".equals(simOperator) || "46009".equals(simOperator)) {
                        str = "2";
                    } else if ("46000".equals(simOperator) || "46002".equals(simOperator) || "46004".equals(simOperator) || "46007".equals(simOperator)) {
                        str = "1";
                    } else if ("46003".equals(simOperator) || "46005".equals(simOperator) || "46011".equals(simOperator)) {
                        str = "3";
                    } else {
                        w = "0";
                    }
                    w = str;
                }
            } catch (Exception e2) {
                w = "0";
                e2.printStackTrace();
            }
        }
        return w;
    }

    public static int d(Context context) {
        try {
            return StubApp.getOrigApplicationContext(context.getApplicationContext()).getPackageManager().getApplicationInfo(n(), 0).icon;
        } catch (Exception e2) {
            e2.printStackTrace();
            return R.drawable.stat_sys_download;
        }
    }

    public static String d() {
        try {
            if (!TextUtils.isEmpty(r)) {
                return r;
            }
            String string = f8631a.getSharedPreferences("device_info", 0).getString(oOo00o00.OooO0o, null);
            if (!TextUtils.isEmpty(string)) {
                return string;
            }
            SharedPreferences sharedPreferences = f8631a.getSharedPreferences("ubix_sp_fake_seed", 0);
            if (!sharedPreferences.contains("FAKE_ID")) {
                String str = "u." + UUID.randomUUID().toString().replace(com.huawei.openalliance.ad.constant.x.A, "");
                sharedPreferences.edit().putString("FAKE_ID", str).apply();
                r = str;
                return str;
            }
            String string2 = sharedPreferences.getString("FAKE_ID", "");
            if (!TextUtils.isEmpty(string2)) {
                r = string2;
                return string2;
            }
            String str2 = "u." + UUID.randomUUID().toString().replace(com.huawei.openalliance.ad.constant.x.A, "") + "DO.NOT.TOUCH.MY.ID";
            sharedPreferences.edit().putString("FAKE_ID", str2).apply();
            r = str2;
            return str2;
        } catch (Throwable unused) {
            return "u." + UUID.randomUUID().toString().replace(com.huawei.openalliance.ad.constant.x.A, "") + "EXCEPTION";
        }
    }

    private static String d(String str) {
        try {
            Class<?> cls = Class.forName(CountryCodeBean.ANDRIOD_SYSTEMPROP);
            return (String) cls.getDeclaredMethod("get", String.class).invoke(cls, str);
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public static int e(Context context) {
        int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    private static long e(String str) {
        HashMap<String, Long> map = g;
        if (map == null) {
            g = new HashMap<>();
            return 0L;
        }
        Long l2 = map.get(str);
        if (l2 == null) {
            return 0L;
        }
        return l2.longValue();
    }

    public static Context e() {
        return f8631a;
    }

    public static String f() {
        return Locale.getDefault().getCountry();
    }

    public static String f(Context context) {
        String strC;
        long jE = e("getVivoStoreVersionCode");
        if (jE != 0) {
            return t;
        }
        if (System.currentTimeMillis() - jE > com.ubix.ssp.ad.d.b.s) {
            h("getVivoStoreVersionCode");
            if (!TextUtils.isEmpty(t)) {
                return t;
            }
            try {
                strC = c(context, "com.bbk.appstore");
            } catch (Exception unused) {
                strC = "";
            }
        } else {
            strC = "";
        }
        if (TextUtils.isEmpty(strC)) {
            return t;
        }
        t = strC;
        return strC;
    }

    private static void f(String str) {
        try {
            String str2 = c;
            if (str2 != "0") {
                if (str2 == "0" || str2 == "") {
                    String strD = d(str);
                    if (!TextUtils.isEmpty(strD)) {
                        c = strD;
                    } else {
                        c = "0";
                        c = "0";
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static long g() {
        try {
            long j2 = n;
            if (j2 > 0) {
                return j2;
            }
            long jC = v.c(f8631a, "ubix_sp_world", "create_time");
            n = jC;
            if (jC > 0) {
                return jC;
            }
            File parentFile = k.d(f8631a).getParentFile();
            if (parentFile != null && parentFile.exists()) {
                Context context = f8631a;
                long jLastModified = parentFile.lastModified();
                n = jLastModified;
                v.a(context, "ubix_sp_world", "create_time", jLastModified);
                return n;
            }
            File parentFile2 = k.b(f8631a).getParentFile();
            if (parentFile2 != null && parentFile2.exists()) {
                Context context2 = f8631a;
                long jLastModified2 = parentFile2.lastModified();
                n = jLastModified2;
                v.a(context2, "ubix_sp_world", "create_time", jLastModified2);
                return n;
            }
            return n;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static boolean g(Context context) {
        NetworkInfo activeNetworkInfo;
        try {
            if (!com.ubix.ssp.ad.e.a0.d0.c.a(context, com.kuaishou.weapon.p0.g.b) || (activeNetworkInfo = ((ConnectivityManager) StubApp.getOrigApplicationContext(context.getApplicationContext()).getSystemService("connectivity")).getActiveNetworkInfo()) == null) {
                return false;
            }
            return activeNetworkInfo.isAvailable();
        } catch (Throwable unused) {
            return true;
        }
    }

    public static boolean g(String str) {
        PackageInfo packageInfo;
        try {
            packageInfo = f8631a.getPackageManager().getPackageInfo(str, 0);
        } catch (Exception unused) {
            packageInfo = null;
        }
        return packageInfo != null;
    }

    public static String h() {
        try {
            if (!TextUtils.isEmpty(j)) {
                return j;
            }
            String id = TimeZone.getDefault().getID();
            j = id;
            return id;
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    private static void h(String str) {
        HashMap<String, Long> map = g;
        if (map == null) {
            return;
        }
        map.put(str, Long.valueOf(System.currentTimeMillis()));
    }

    public static boolean h(Context context) {
        try {
            return ((context.getResources().getConfiguration().screenLayout & 15) >= 3) || (context.getResources().getConfiguration().smallestScreenWidthDp >= 600);
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public static int i() {
        try {
            boolean zA = com.ubix.ssp.ad.e.a0.d0.c.a(f8631a, com.kuaishou.weapon.p0.g.b);
            long jE = e("getNetType");
            if (zA && System.currentTimeMillis() - jE > com.ubix.ssp.ad.d.b.s) {
                h("getNetType");
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) f8631a.getSystemService("connectivity")).getActiveNetworkInfo();
                if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                    int type = activeNetworkInfo.getType();
                    if (type != 0) {
                        if (type != 1) {
                            y = 0;
                            return 0;
                        }
                        y = 1;
                        return 1;
                    }
                    int subtype = activeNetworkInfo.getSubtype();
                    String subtypeName = activeNetworkInfo.getSubtypeName();
                    if (subtype == 20) {
                        y = 5;
                        return 5;
                    }
                    switch (subtype) {
                        case 1:
                        case 2:
                        case 4:
                        case 7:
                        case 11:
                        case 16:
                            y = 2;
                            return 2;
                        case 3:
                        case 5:
                        case 6:
                        case 8:
                        case 9:
                        case 10:
                        case 12:
                        case 14:
                        case 15:
                        case 17:
                            y = 3;
                            return 3;
                        case 13:
                            y = 4;
                            return 4;
                        default:
                            if (subtypeName.equalsIgnoreCase("TD-SCDMA") || subtypeName.equalsIgnoreCase("WCDMA") || subtypeName.equalsIgnoreCase("CDMA2000")) {
                                y = 3;
                                return 3;
                            }
                            break;
                    }
                }
                y = 0;
                return 0;
            }
            return y;
        } catch (Exception unused) {
            return 1;
        }
    }

    public static boolean i(Context context) {
        try {
            if (com.ubix.ssp.ad.e.a0.d0.c.a(context, com.kuaishou.weapon.p0.g.b)) {
                return ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo().getType() == 1;
            }
            return g(context);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static int j() {
        try {
            return new File("/sys/devices/system/cpu/").listFiles(new b()).length;
        } catch (Exception e2) {
            e2.printStackTrace();
            return 1;
        }
    }

    public static void j(Context context) {
        try {
            y();
            d.execute(new e(context));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static int k() {
        try {
            DisplayMetrics displayMetrics = StubApp.getOrigApplicationContext(f8631a.getApplicationContext()).getResources().getDisplayMetrics();
            return displayMetrics.widthPixels > displayMetrics.heightPixels ? 2 : 1;
        } catch (Exception unused) {
            return 0;
        }
    }

    public static void k(Context context) {
        Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
        f8631a = origApplicationContext;
        com.ubix.ssp.ad.e.a0.b.a(origApplicationContext);
    }

    public static String l() {
        f("hw_sc.build.platform.version");
        if (D() == 3) {
            return (TextUtils.isEmpty(c) || c.equals("0")) ? Build.VERSION.RELEASE : c;
        }
        return Build.VERSION.RELEASE;
    }

    public static PackageInfo m() {
        try {
            Context context = f8631a;
            if (context == null) {
                return null;
            }
            return b(context, context.getPackageName());
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static String n() {
        try {
            if (!TextUtils.isEmpty(l)) {
                return l;
            }
            Context context = f8631a;
            if (context != null) {
                String strD = v.d(context, "ubix_sp_world", com.hihonor.adsdk.base.download.marketdownload.a.hnadse);
                if (!TextUtils.isEmpty(strD)) {
                    l = strD;
                    return strD;
                }
                String packageName = f8631a.getPackageName();
                l = packageName;
                v.b(f8631a, "ubix_sp_world", com.hihonor.adsdk.base.download.marketdownload.a.hnadse, packageName);
            }
            return l;
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String o() {
        try {
            WindowManager windowManager = (WindowManager) f8631a.getSystemService("window");
            DisplayMetrics displayMetrics = new DisplayMetrics();
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            return displayMetrics.widthPixels + "x" + displayMetrics.heightPixels;
        } catch (Exception unused) {
            return "720x1280";
        }
    }

    public static int p() {
        try {
            String strD = d("gsm.sim.state");
            if (TextUtils.isEmpty(strD)) {
                return 0;
            }
            return strD.toUpperCase().contains("LOADED") ? 1 : 2;
        } catch (Throwable th) {
            th.printStackTrace();
            return 0;
        }
    }

    public static int q() {
        if (f8631a == null) {
            return -1;
        }
        return new t().a(f8631a);
    }

    public static int r() {
        try {
            int i2 = q;
            if (i2 != -1) {
                return i2;
            }
            ApplicationInfo applicationInfo = f8631a.getPackageManager().getApplicationInfo(f8631a.getPackageName(), 0);
            if (applicationInfo == null) {
                return 0;
            }
            int i3 = applicationInfo.targetSdkVersion;
            q = i3;
            return i3;
        } catch (Throwable th) {
            th.printStackTrace();
            return 0;
        }
    }

    public static String s() {
        try {
            if (!"0".equals(B)) {
                return B.trim();
            }
            String strA = new i().a("cd /data/data;stat  .;", 1000).a();
            if (strA.toLowerCase().contains("cannot")) {
                B = "";
                return "";
            }
            String strSubstring = strA.substring(strA.indexOf("Access:") + 7, strA.lastIndexOf("Modify"));
            String[] strArrSplit = (strSubstring.contains("+") ? strSubstring.substring(strSubstring.indexOf("Access:") + 7, strSubstring.lastIndexOf("+")) : strSubstring.substring(strSubstring.indexOf("Access:") + 7)).split("\\.");
            String str = a(strArrSplit[0]) + "." + strArrSplit[1];
            B = str;
            return str.trim();
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public static String t() {
        try {
            if (!TextUtils.isEmpty(h)) {
                return h;
            }
            String defaultUserAgent = WebSettings.getDefaultUserAgent(f8631a);
            h = defaultUserAgent;
            if (!TextUtils.isEmpty(defaultUserAgent)) {
                v.b(f8631a, "ubix_sp_beacon", com.alipay.sdk.cons.b.b, h);
            }
            return TextUtils.isEmpty(h) ? "" : h;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void u() {
        try {
            y();
            d.execute(new f());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX WARN: Code duplicated, block: B:15:0x005f A[Catch: all -> 0x0063, TRY_LEAVE, TryCatch #0 {all -> 0x0063, blocks: (B:5:0x0014, B:7:0x0024, B:9:0x0038, B:14:0x005c, B:15:0x005f, B:12:0x0040), top: B:21:0x0014 }] */
    public static int v() {
        if (System.currentTimeMillis() - e("getVPNStatus") > com.ubix.ssp.ad.d.b.s) {
            h("getVPNStatus");
            try {
                if (com.ubix.ssp.ad.e.a0.d0.c.a(f8631a, com.kuaishou.weapon.p0.g.b)) {
                    ConnectivityManager connectivityManager = (ConnectivityManager) f8631a.getSystemService("connectivity");
                    NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
                    if (networkCapabilities == null || !networkCapabilities.hasTransport(4)) {
                        k = 2;
                    } else {
                        k = 1;
                    }
                } else if (ProxySelector.getDefault().select(URI.create("https://adx-cfg-u1.ubixioe.com")).get(0).type() != Proxy.Type.DIRECT) {
                    k = 1;
                } else {
                    k = 2;
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return k;
    }

    public static String w() {
        try {
            if (!TextUtils.isEmpty(p)) {
                return p;
            }
            PackageInfo packageInfoM = m();
            if (packageInfoM == null) {
                return "";
            }
            String str = packageInfoM.versionName;
            p = str;
            return str;
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public static long x() {
        long j2 = o;
        if (j2 != 0) {
            return j2;
        }
        long jC = v.c(f8631a, "ubix_sp_world", "v291");
        if (jC <= 0) {
            Context context = f8631a;
            jC = System.currentTimeMillis();
            v.a(context, "ubix_sp_world", "v291", jC);
        }
        o = jC;
        return jC;
    }

    public static Executor y() {
        if (d == null) {
            d = Executors.newFixedThreadPool(1, new ThreadFactoryC1062c());
        }
        return d;
    }

    public static ScheduledExecutorService z() {
        if (e == null) {
            e = Executors.newScheduledThreadPool(1, new a());
        }
        return e;
    }
}
