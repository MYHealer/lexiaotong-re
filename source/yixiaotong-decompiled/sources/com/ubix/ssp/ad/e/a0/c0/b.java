package com.ubix.ssp.ad.e.a0.c0;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.ubix.ssp.ad.e.a0.u;
import com.ubix.ssp.ad.e.a0.v;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile String f8635a = "";
    private static Object b = new Object();
    private static long c;

    class a implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f8636a;
        final /* synthetic */ Context b;

        /* JADX INFO: renamed from: com.ubix.ssp.ad.e.a0.c0.b$a$a, reason: collision with other inner class name */
        class RunnableC1064a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f8637a;

            RunnableC1064a(String str) {
                this.f8637a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    u.e("onOAIDGetComplete " + this.f8637a);
                    v.b(a.this.b, "ubix_sp_seed", "seed", Base64.encodeToString(this.f8637a.getBytes(), 10));
                    v.a(a.this.b, "ubix_sp_seed", "seed_expired", System.currentTimeMillis() + 864000000);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }

        a(boolean z, Context context) {
            this.f8636a = z;
            this.b = context;
        }

        @Override // com.ubix.ssp.ad.e.a0.c0.c
        public void a(Exception exc) {
            String strD = v.d(this.b, "ubix_sp_seed", "seed");
            if (!TextUtils.isEmpty(strD)) {
                String unused = b.f8635a = new String(Base64.decode(strD.getBytes(), 10));
                if (b.f8635a == null) {
                    String unused2 = b.f8635a = "";
                    return;
                }
                return;
            }
            String strD2 = v.d(this.b, "ubix_sp_seed", "oaid");
            if (TextUtils.isEmpty(strD2)) {
                String unused3 = b.f8635a = "";
            } else {
                String unused4 = b.f8635a = strD2;
            }
        }

        @Override // com.ubix.ssp.ad.e.a0.c0.c
        public void a(String str) {
            try {
                String unused = b.f8635a = str;
                try {
                    com.ubix.ssp.ad.e.a0.c.y();
                    com.ubix.ssp.ad.e.a0.c.d.execute(new RunnableC1064a(str));
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            } catch (Exception unused2) {
            }
        }

        @Override // com.ubix.ssp.ad.e.a0.c0.c
        public boolean a() {
            return this.f8636a;
        }
    }

    private b() {
    }

    public static String a(Context context) {
        try {
            if (!TextUtils.isEmpty(com.ubix.ssp.ad.d.b.f)) {
                return "";
            }
            String strD = v.d(context, "ubix_sp_seed", "android_id");
            return TextUtils.isEmpty(strD) ? new String(Base64.decode(strD.getBytes(), 10)) : "";
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public static String a(Context context, boolean z) {
        b(context, z);
        return b(context);
    }

    public static String b(Context context) {
        String str;
        try {
            if (TextUtils.isEmpty(f8635a) || f8635a.startsWith("00000")) {
                String strD = v.d(context, "ubix_sp_seed", "seed");
                if (TextUtils.isEmpty(strD)) {
                    str = v.d(context, "ubix_sp_seed", "oaid");
                    if (!TextUtils.isEmpty(str)) {
                    }
                } else {
                    str = new String(Base64.decode(strD.getBytes(), 10));
                }
                f8635a = str;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return f8635a;
    }

    public static void b(Context context, boolean z) {
        synchronized (b) {
            if (System.currentTimeMillis() - c > com.ubix.ssp.ad.d.b.s) {
                c = System.currentTimeMillis();
                com.ubix.ssp.ad.e.a0.c0.a.a(context, new a(z, context));
            }
        }
    }
}
