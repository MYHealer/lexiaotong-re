package com.ubix.ssp.ad.core.util.myoaid.impl.huawei;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import com.ubix.ssp.ad.e.a0.u;
import java.io.Closeable;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Uri f8597a = new Uri.Builder().scheme("content").authority("com.huawei.hwid.pps.apiprovider").path("/oaid_scp/get").build();
    private static final Uri b = new Uri.Builder().scheme("content").authority("com.huawei.hwid.pps.apiprovider").path("/oaid/query").build();

    class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ e.b f8598a;
        final /* synthetic */ Context b;

        a(e.b bVar, Context context) {
            this.f8598a = bVar;
            this.b = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f8598a.c()) {
                Log.d("InfoProviderUtil", "within key update interval.");
                return;
            }
            this.f8598a.b();
            this.f8598a.a(c.e(this.b));
        }
    }

    class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f8599a;
        final /* synthetic */ e.b b;

        b(Context context, e.b bVar) {
            this.f8599a = context;
            this.b = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.b.a(c.e(this.f8599a));
        }
    }

    public static AdvertisingIdClient.Info a(Context context) {
        if (context == null || !a(context, f8597a)) {
            return null;
        }
        String string = Settings.Global.getString(context.getContentResolver(), "pps_oaid_c");
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        e.b bVarA = e.b.a(context);
        String strA = bVarA.a();
        if (TextUtils.isEmpty(strA)) {
            Log.d("InfoProviderUtil", "scp is empty");
            f.f8603a.execute(new a(bVarA, context));
            if (bVarA.e()) {
                return new AdvertisingIdClient.Info("00000000-0000-0000-0000-000000000000", true);
            }
            bVarA.d();
            return null;
        }
        String strA2 = e.a(string, strA);
        if (!TextUtils.isEmpty(strA2)) {
            return new AdvertisingIdClient.Info(strA2, "00000000-0000-0000-0000-000000000000".equalsIgnoreCase(strA2));
        }
        Log.d("InfoProviderUtil", "decrypt oaid failed.");
        f.f8603a.execute(new b(context, bVarA));
        return null;
    }

    private static boolean a(Context context, Uri uri) {
        Integer numB;
        if (context == null || uri == null || (numB = f.b(context)) == null || 30462100 > numB.intValue()) {
            return false;
        }
        return f.a(context, uri);
    }

    public static AdvertisingIdClient.Info c(Context context) {
        if (context == null || !d(context)) {
            return new AdvertisingIdClient.Info("00000000-0000-0000-0000-000000000000", true);
        }
        try {
            Cursor cursorQuery = context.getContentResolver().query(b, null, null, null, null);
            if (cursorQuery == null || !cursorQuery.moveToFirst()) {
                AdvertisingIdClient.Info info = new AdvertisingIdClient.Info("00000000-0000-0000-0000-000000000000", true);
                f.a(cursorQuery);
                return info;
            }
            int columnIndexOrThrow = cursorQuery.getColumnIndexOrThrow("oaid");
            int columnIndexOrThrow2 = cursorQuery.getColumnIndexOrThrow("limit_track");
            String string = cursorQuery.getString(columnIndexOrThrow);
            AdvertisingIdClient.Info info2 = new AdvertisingIdClient.Info(string, "00000000-0000-0000-0000-000000000000".equalsIgnoreCase(string) ? true : Boolean.valueOf(cursorQuery.getString(columnIndexOrThrow2)).booleanValue());
            f.a(cursorQuery);
            return info2;
        } catch (Throwable th) {
            try {
                Log.w("InfoProviderUtil", "query oaid via provider ex: " + th.getClass().getSimpleName());
                return new AdvertisingIdClient.Info("00000000-0000-0000-0000-000000000000", true);
            } finally {
                f.a((Closeable) null);
            }
        }
    }

    public static boolean d(Context context) {
        return a(context, b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String e(Context context) {
        if (context == null) {
            return "";
        }
        Cursor cursorQuery = null;
        try {
            cursorQuery = context.getContentResolver().query(f8597a, null, null, null, null);
            if (cursorQuery != null && cursorQuery.moveToFirst()) {
                String string = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("op_wk"));
                u.e("InfoProviderUtil", " op_wk=" + string);
                f.a(cursorQuery);
                return string;
            }
            f.a(cursorQuery);
            return "";
        } catch (Throwable th) {
            try {
                Log.w("InfoProviderUtil", "get remote key ex: " + th.getClass().getSimpleName());
                return "";
            } finally {
                f.a(cursorQuery);
            }
        }
    }
}
