package org.repackage.com.meizu.flyme.openidsdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.ubixnow.ooooo.oOOOoo00;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
class b {
    private static volatile b e;
    private static boolean f;
    private BroadcastReceiver h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    OpenId f9726a = new OpenId("udid");
    OpenId b = new OpenId("oaid");
    OpenId d = new OpenId("vaid");
    OpenId c = new OpenId("aaid");
    private SupportInfo g = new SupportInfo();

    private b() {
    }

    private static String a(PackageManager packageManager, String str) {
        ProviderInfo providerInfoResolveContentProvider;
        if (packageManager == null || (providerInfoResolveContentProvider = packageManager.resolveContentProvider(str, 0)) == null || (providerInfoResolveContentProvider.applicationInfo.flags & 1) == 0) {
            return null;
        }
        return providerInfoResolveContentProvider.packageName;
    }

    private static ValueData a(Cursor cursor) {
        String str;
        ValueData valueData = new ValueData(null, 0);
        if (cursor == null) {
            str = "parseValue fail, cursor is null.";
        } else {
            if (!cursor.isClosed()) {
                cursor.moveToFirst();
                int columnIndex = cursor.getColumnIndex(oOOOoo00.OooOo0o);
                if (columnIndex >= 0) {
                    valueData.f9725a = cursor.getString(columnIndex);
                } else {
                    a("parseValue fail, index < 0.");
                }
                int columnIndex2 = cursor.getColumnIndex("code");
                if (columnIndex2 >= 0) {
                    valueData.b = cursor.getInt(columnIndex2);
                } else {
                    a("parseCode fail, index < 0.");
                }
                int columnIndex3 = cursor.getColumnIndex("expired");
                if (columnIndex3 >= 0) {
                    valueData.c = cursor.getLong(columnIndex3);
                } else {
                    a("parseExpired fail, index < 0.");
                }
                return valueData;
            }
            str = "parseValue fail, cursor is closed.";
        }
        a(str);
        return valueData;
    }

    public static final b a() {
        if (e == null) {
            synchronized (b.class) {
                if (e == null) {
                    e = new b();
                }
            }
        }
        return e;
    }

    static void a(String str) {
        if (f) {
            Log.d("OpenIdManager", str);
        }
    }

    public static void a(boolean z) {
        f = z;
    }

    private static boolean a(Context context) {
        a("querySupport version : 1.0.8");
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = context.getContentResolver().query(Uri.parse("content://com.meizu.flyme.openidsdk/"), null, null, new String[]{"supported"}, null);
                if (cursorQuery == null) {
                    return false;
                }
                ValueData valueDataA = a(cursorQuery);
                return 1000 != valueDataA.b || "0".equals(valueDataA.f9725a);
            } catch (Exception e2) {
                a("querySupport, Exception : " + e2.getMessage());
            }
        } finally {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v21 */
    /* JADX WARN: Type inference failed for: r0v22 */
    /* JADX WARN: Type inference failed for: r0v23 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9, types: [java.lang.String] */
    private String b(Context context, OpenId openId) throws Throwable {
        String str;
        String strConcat;
        String str2;
        a("queryId : " + openId.c);
        ?? r0 = 0;
        str = null;
        r0 = 0;
        String str3 = null;
        Cursor cursor = null;
        try {
            try {
                Cursor cursorQuery = context.getContentResolver().query(Uri.parse("content://com.meizu.flyme.openidsdk/"), null, null, new String[]{openId.c}, null);
                try {
                    if (cursorQuery == null) {
                        if (a(context, false)) {
                            strConcat = "forceQuery isSupported : ".concat(String.valueOf(a(context, true)));
                            a(strConcat);
                            r0 = str3;
                        }
                        return r0;
                    }
                    ValueData valueDataA = a(cursorQuery);
                    str2 = valueDataA.f9725a;
                    openId.a(str2);
                    openId.a(valueDataA.c);
                    openId.a(valueDataA.b);
                    a(openId.c + " errorCode : " + openId.d);
                    if (valueDataA.b != 1000) {
                        b(context);
                        if (!a(context, false)) {
                            r0 = str2;
                            r0 = str2;
                            strConcat = "not support, forceQuery isSupported: ".concat(String.valueOf(a(context, true)));
                            str3 = str2;
                            a(strConcat);
                            r0 = str3;
                        }
                        return r0;
                    }
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                } catch (Exception e2) {
                    e = e2;
                    str = str3;
                    cursor = cursorQuery;
                    a("queryId, Exception : " + e.getMessage());
                    if (cursor != null) {
                        cursor.close();
                    }
                    r0 = str;
                } catch (Throwable th) {
                    th = th;
                    r0 = cursorQuery;
                    if (r0 != 0) {
                        r0.close();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e3) {
            e = e3;
            str = null;
        }
        return r0;
    }

    private static String b(PackageManager packageManager, String str) {
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
            if (packageInfo != null) {
                return packageInfo.versionName;
            }
            return null;
        } catch (Exception e2) {
            e2.printStackTrace();
            a("getAppVersion, Exception : " + e2.getMessage());
            return null;
        }
    }

    private synchronized void b(Context context) {
        if (this.h != null) {
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.meizu.flyme.openid.ACTION_OPEN_ID_CHANGE");
        a aVar = new a();
        this.h = aVar;
        context.registerReceiver(aVar, intentFilter, "com.meizu.flyme.openid.permission.OPEN_ID_CHANGE", null);
    }

    final String a(Context context, OpenId openId) {
        String str;
        if (openId == null) {
            str = "getId, openId = null.";
        } else {
            if (openId.a()) {
                return openId.b;
            }
            if (a(context, true)) {
                return b(context, openId);
            }
            str = "getId, isSupported = false.";
        }
        a(str);
        return null;
    }

    final boolean a(Context context, boolean z) {
        if (this.g.a() && !z) {
            return this.g.b();
        }
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            return false;
        }
        String strA = a(packageManager, "com.meizu.flyme.openidsdk");
        if (TextUtils.isEmpty(strA)) {
            return false;
        }
        String strB = b(packageManager, strA);
        if (this.g.a() && this.g.a(strB)) {
            a("use same version cache, safeVersion : ".concat(String.valueOf(strB)));
            return this.g.b();
        }
        this.g.b(strB);
        boolean zA = a(context);
        a("query support, result : ".concat(String.valueOf(zA)));
        this.g.a(zA);
        return zA;
    }
}
