package com.oplus.instant.router.g;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.text.TextUtils;
import com.cdo.oaps.ad.OapsKey;
import com.oplus.instant.router.callback.Callback;
import com.stub.StubApp;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Handler f5779a;
    private static Handler b;
    private static com.oplus.instant.router.callback.a c = new com.oplus.instant.router.callback.a();

    class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f5780a;
        final /* synthetic */ String b;
        final /* synthetic */ Map c;
        final /* synthetic */ Map d;
        final /* synthetic */ Map e;
        final /* synthetic */ Map f;

        a(Context context, String str, Map map, Map map2, Map map3, Map map4) {
            this.f5780a = context;
            this.b = str;
            this.c = map;
            this.d = map2;
            this.e = map3;
            this.f = map4;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (h.c(this.f5780a) < 1100) {
                e.c(e.c, new Exception("platform not found"));
            } else {
                e.c(this.b, this.f5780a, this.c, this.d, this.e, this.f);
            }
        }
    }

    class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f5781a;
        final /* synthetic */ Context b;
        final /* synthetic */ Map c;
        final /* synthetic */ Map d;
        final /* synthetic */ Map e;
        final /* synthetic */ Map f;

        b(String str, Context context, Map map, Map map2, Map map3, Map map4) {
            this.f5781a = str;
            this.b = context;
            this.c = map;
            this.d = map2;
            this.e = map3;
            this.f = map4;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.d(this.f5781a, this.b, this.c, this.d, this.e, this.f);
        }
    }

    class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f5782a;
        final /* synthetic */ Intent b;
        final /* synthetic */ Callback c;

        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                e.b(c.this.c);
            }
        }

        c(Context context, Intent intent, Callback callback) {
            this.f5782a = context;
            this.b = intent;
            this.c = callback;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (!(this.f5782a instanceof Activity)) {
                    this.b.addFlags(268435456);
                }
                this.f5782a.startActivity(this.b);
                e.f5779a.post(new a());
            } catch (Exception e) {
                e.c(this.c, e);
            }
        }
    }

    class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Callback f5784a;
        final /* synthetic */ Throwable b;

        d(Callback callback, Throwable th) {
            this.f5784a = callback;
            this.b = th;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.d(this.f5784a, this.b);
        }
    }

    private static ContentValues a(Context context, String str, Map<String, String> map, Map<String, String> map2, Map<String, String> map3, Map<String, String> map4, String str2, String str3) {
        ContentValues contentValues = new ContentValues();
        a(contentValues, OapsKey.KEY_SIGN_TYPE, map.get(OapsKey.KEY_SIGN_TYPE));
        a(contentValues, "req_url", com.oplus.instant.router.g.b.a(context, str2, str));
        a(contentValues, "from", "ins_sdk");
        a(contentValues, "origin", str3);
        a(contentValues, "encrypt", 1);
        a(contentValues, "EXTRA_DEEPLINK_PARAMS", map2);
        a(contentValues, "EXTRA_STAT_PARAMS", map3);
        a(contentValues, "EXTRA_EXTEND_PARAMS", map4);
        return contentValues;
    }

    public static Cursor a(Context context, Uri uri) {
        try {
            return context.getContentResolver().query(uri, null, null, null, null);
        } catch (Throwable th) {
            com.oplus.instant.router.g.d.a("RequestUtil", th);
            return null;
        }
    }

    private static Uri a(String str, String str2) {
        Uri uri = Uri.parse(str);
        return Uri.parse((com.oplus.instant.router.a.b() ? new StringBuilder("content://tv.") : new StringBuilder("content://")).append(uri.getScheme()).append("_").append(uri.getHost()).append("/").append(str2).toString());
    }

    private static String a(Map<String, ?> map) {
        StringBuilder sb = new StringBuilder();
        for (String str : map.keySet()) {
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append(str).append("=").append(map.get(str));
        }
        return sb.toString();
    }

    private static void a(ContentValues contentValues, String str, int i) {
        contentValues.put(str, Integer.valueOf(i));
    }

    private static void a(ContentValues contentValues, String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        contentValues.put(str, str2);
    }

    private static void a(ContentValues contentValues, String str, Map<String, ?> map) {
        if (map == null || map.size() <= 0) {
            return;
        }
        contentValues.put(str, a(map));
    }

    private static void a(Context context, String str) throws com.oplus.instant.router.c.a {
        if (!h.b(context)) {
            throw new com.oplus.instant.router.c.a(104, str);
        }
    }

    public static synchronized void a(Context context, String str, Map<String, String> map, Map<String, String> map2, Map<String, String> map3, Map<String, String> map4, Callback callback) {
        c();
        Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
        if (com.oplus.instant.router.g.c.a(origApplicationContext, str, map4)) {
            callback = com.oplus.instant.router.g.c.a(context, str, callback);
        }
        if (str.startsWith("hap://app/") && map4 != null && "1".equals(map4.get("in_one_task"))) {
            callback = new com.oplus.instant.router.callback.c(context, str, callback);
        }
        c.a(callback);
        f5779a.post(new a(origApplicationContext, str, map2, map, map3, map4));
    }

    private static void a(Exception exc, Context context, String str, Callback callback) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
        if (intent.resolveActivity(context.getPackageManager()) == null) {
            c(callback, exc);
            return;
        }
        if (b == null) {
            b = new Handler(Looper.getMainLooper());
        }
        b.post(new c(context, intent, callback));
    }

    private static void a(Map<String, String> map, String str) throws com.oplus.instant.router.c.a {
        if (!map.containsKey("origin")) {
            throw new com.oplus.instant.router.c.a(102, str);
        }
        if (!map.containsKey("secret")) {
            throw new com.oplus.instant.router.c.a(103, str);
        }
    }

    public static boolean a(String str) {
        Uri uri;
        if (TextUtils.isEmpty(str) || (uri = Uri.parse(str)) == null) {
            return false;
        }
        if (!"oaps".equals(uri.getScheme()) && !"hap".equals(uri.getScheme())) {
            return false;
        }
        if (!"oaps".equals(uri.getScheme()) || "instant".equals(uri.getHost())) {
            return !TextUtils.isEmpty(uri.getPath());
        }
        return false;
    }

    private static Uri b(String str, String str2) {
        Uri uri = Uri.parse(str);
        return Uri.parse((com.oplus.instant.router.a.b() ? new StringBuilder("content://tv.preload_") : new StringBuilder("content://preload_")).append(uri.getScheme()).append("_").append(uri.getHost()).append("/").append(str2).toString());
    }

    private static Map<String, Object> b(Map<String, String> map) {
        HashMap map2 = new HashMap();
        map2.putAll(map);
        map2.put("ts", String.valueOf(System.currentTimeMillis()));
        map2.put("version", h.a());
        return map2;
    }

    public static void b(Context context, String str, Map<String, String> map, Map<String, String> map2, Map<String, String> map3, Map<String, String> map4, Callback callback) {
        c();
        c.a(callback);
        f5779a.post(new b(str, context, map2, map, map3, map4));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Callback callback) {
        Callback.Response response = new Callback.Response();
        response.setCode(1);
        response.setMsg("success");
        callback.onResponse(response);
    }

    private static synchronized void c() {
        Handler handler = f5779a;
        if (handler == null || handler.getLooper() == null) {
            HandlerThread handlerThread = new HandlerThread("instant-req");
            handlerThread.start();
            if (handlerThread.getLooper() != null) {
                f5779a = new Handler(handlerThread.getLooper());
            } else {
                f5779a = new Handler();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(Callback callback, Throwable th) {
        if (g.a()) {
            f5779a.post(new d(callback, th));
        } else {
            d(callback, th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:8:0x0017  */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x007e, code lost:
    
        if (r13.startsWith("hap://") != false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0092, code lost:
    
        if (r13.startsWith("hap://") != false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0094, code lost:
    
        r0 = r0;
        r0 = r0;
        a(r0, r14, r13, com.oplus.instant.router.g.e.c);
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0099, code lost:
    
        return;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.SecurityException] */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.lang.Exception] */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.lang.IllegalArgumentException] */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r0v6, types: [java.lang.Throwable] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void c(String str, Context context, Map<String, String> map, Map<String, String> map2, Map<String, String> map3, Map<String, String> map4) {
        String queryParameter;
        if (str != null) {
            try {
                try {
                    if (str.contains(OapsKey.KEY_PKG)) {
                        try {
                            queryParameter = Uri.parse(str).getQueryParameter(OapsKey.KEY_PKG);
                        } catch (Exception unused) {
                            queryParameter = "";
                        }
                    } else {
                        queryParameter = "";
                    }
                } catch (Throwable th) {
                    th = th;
                    ?? r0 = th;
                    r0 = th;
                    c(c, th);
                    return;
                }
            } catch (IllegalArgumentException e) {
                th = e;
                if (th.getMessage().contains("Unknown URL content")) {
                }
                ?? r1 = th;
                r1 = th;
                c(c, th);
                return;
            } catch (SecurityException e2) {
                th = e2;
                if (th.getMessage().contains("Failed to find provider hap_app")) {
                }
                ?? r2 = th;
                r2 = th;
                c(c, th);
                return;
            }
        } else {
            queryParameter = "";
        }
        a(context, queryParameter);
        a(map, queryParameter);
        Map<String, Object> mapB = b(map);
        String str2 = (String) mapB.get("secret");
        String str3 = (String) mapB.get("origin");
        Uri uriA = a(str, com.oplus.instant.router.g.b.a(context, str2, a((Map<String, ?>) mapB)));
        ContentValues contentValuesA = a(context, str, map, map2, map3, map4, str2, str3);
        context.getContentResolver().registerContentObserver(uriA, false, new com.oplus.instant.router.e.a(context, mapB, c, uriA));
        context.getContentResolver().insert(uriA, contentValuesA);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d(Callback callback, Throwable th) {
        Callback.Response response = new Callback.Response();
        response.setCode(-8);
        response.setMsg(th.getMessage());
        callback.onResponse(response);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:8:0x0013  */
    public static void d(String str, Context context, Map<String, String> map, Map<String, String> map2, Map<String, String> map3, Map<String, String> map4) {
        String queryParameter;
        if (str != null) {
            try {
                if (str.contains(OapsKey.KEY_PKG)) {
                    try {
                        queryParameter = Uri.parse(str).getQueryParameter(OapsKey.KEY_PKG);
                    } catch (Exception unused) {
                        queryParameter = "";
                    }
                } else {
                    queryParameter = "";
                }
            } catch (Throwable th) {
                c(c, th);
                return;
            }
        } else {
            queryParameter = "";
        }
        a(context, queryParameter);
        a(map, queryParameter);
        Map<String, Object> mapB = b(map);
        String str2 = (String) mapB.get("secret");
        String str3 = (String) mapB.get("origin");
        Uri uriB = b(str, com.oplus.instant.router.g.b.a(context, str2, a((Map<String, ?>) mapB)));
        ContentValues contentValuesA = a(context, str, map, map2, map3, map4, str2, str3);
        context.getContentResolver().registerContentObserver(uriB, false, new com.oplus.instant.router.e.a(context, mapB, c, uriB));
        context.getContentResolver().insert(uriB, contentValuesA);
    }
}
