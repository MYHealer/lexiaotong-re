package com.ubixnow.ooooo;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import com.ubixnow.utils.myoaid.impl.huawei.AdvertisingIdClient;
import java.io.Closeable;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class l0 {
    private static final Uri OooO00o = new Uri.Builder().scheme("content").authority("com.huawei.hwid.pps.apiprovider").path("/oaid_scp/get").build();
    private static final Uri OooO0O0 = new Uri.Builder().scheme("content").authority("com.huawei.hwid.pps.apiprovider").path("/oaid/query").build();

    public class OooO00o implements Runnable {
        public final /* synthetic */ n0.OooO0O0 OooO00o;
        public final /* synthetic */ Context OooO0O0;

        public OooO00o(n0.OooO0O0 oooO0O0, Context context) {
            this.OooO00o = oooO0O0;
            this.OooO0O0 = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.OooO00o.OooO0OO()) {
                Log.d("InfoProviderUtil", "within key update interval.");
                return;
            }
            this.OooO00o.OooO0O0();
            this.OooO00o.OooO00o(l0.OooO0o0(this.OooO0O0));
        }
    }

    public class OooO0O0 implements Runnable {
        public final /* synthetic */ Context OooO00o;
        public final /* synthetic */ n0.OooO0O0 OooO0O0;

        public OooO0O0(Context context, n0.OooO0O0 oooO0O0) {
            this.OooO00o = context;
            this.OooO0O0 = oooO0O0;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.OooO0O0.OooO00o(l0.OooO0o0(this.OooO00o));
        }
    }

    public static AdvertisingIdClient.Info OooO00o(Context context) {
        if (context == null || !OooO00o(context, OooO00o)) {
            return null;
        }
        String string = Settings.Global.getString(context.getContentResolver(), "pps_oaid_c");
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        n0.OooO0O0 oooO0O0OooO00o = n0.OooO0O0.OooO00o(context);
        String strOooO00o = oooO0O0OooO00o.OooO00o();
        if (TextUtils.isEmpty(strOooO00o)) {
            Log.d("InfoProviderUtil", "scp is empty");
            p0.OooO00o.execute(new OooO00o(oooO0O0OooO00o, context));
            if (oooO0O0OooO00o.OooO0o0()) {
                return new AdvertisingIdClient.Info("00000000-0000-0000-0000-000000000000", true);
            }
            oooO0O0OooO00o.OooO0Oo();
            return null;
        }
        String strOooO00o2 = n0.OooO00o(string, strOooO00o);
        if (!TextUtils.isEmpty(strOooO00o2)) {
            return new AdvertisingIdClient.Info(strOooO00o2, "00000000-0000-0000-0000-000000000000".equalsIgnoreCase(strOooO00o2));
        }
        Log.d("InfoProviderUtil", "decrypt oaid failed.");
        p0.OooO00o.execute(new OooO0O0(context, oooO0O0OooO00o));
        return null;
    }

    private static boolean OooO00o(Context context, Uri uri) {
        Integer numOooO0O0;
        if (context == null || uri == null || (numOooO0O0 = p0.OooO0O0(context)) == null || 30462100 > numOooO0O0.intValue()) {
            return false;
        }
        return p0.OooO00o(context, uri);
    }

    public static AdvertisingIdClient.Info OooO0OO(Context context) {
        if (context == null || !OooO0Oo(context)) {
            return new AdvertisingIdClient.Info("00000000-0000-0000-0000-000000000000", true);
        }
        try {
            Cursor cursorQuery = context.getContentResolver().query(OooO0O0, null, null, null, null);
            if (cursorQuery == null || !cursorQuery.moveToFirst()) {
                AdvertisingIdClient.Info info = new AdvertisingIdClient.Info("00000000-0000-0000-0000-000000000000", true);
                p0.OooO00o(cursorQuery);
                return info;
            }
            int columnIndexOrThrow = cursorQuery.getColumnIndexOrThrow("oaid");
            int columnIndexOrThrow2 = cursorQuery.getColumnIndexOrThrow("limit_track");
            String string = cursorQuery.getString(columnIndexOrThrow);
            AdvertisingIdClient.Info info2 = new AdvertisingIdClient.Info(string, "00000000-0000-0000-0000-000000000000".equalsIgnoreCase(string) ? true : Boolean.valueOf(cursorQuery.getString(columnIndexOrThrow2)).booleanValue());
            p0.OooO00o(cursorQuery);
            return info2;
        } catch (Throwable th) {
            try {
                Log.w("InfoProviderUtil", "query oaid via provider ex: " + th.getClass().getSimpleName());
                return new AdvertisingIdClient.Info("00000000-0000-0000-0000-000000000000", true);
            } finally {
                p0.OooO00o((Closeable) null);
            }
        }
    }

    public static boolean OooO0Oo(Context context) {
        return OooO00o(context, OooO0O0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String OooO0o0(Context context) {
        if (context == null) {
            return "";
        }
        Cursor cursorQuery = null;
        try {
            cursorQuery = context.getContentResolver().query(OooO00o, null, null, null, null);
            if (cursorQuery != null && cursorQuery.moveToFirst()) {
                String string = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("op_wk"));
                p0.OooO00o(cursorQuery);
                return string;
            }
            p0.OooO00o(cursorQuery);
            return "";
        } catch (Throwable th) {
            try {
                Log.w("InfoProviderUtil", "get remote key ex: " + th.getClass().getSimpleName());
                return "";
            } finally {
                p0.OooO00o(cursorQuery);
            }
        }
    }
}
