package org.repackage.com.vivo.identifier;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import com.google.android.exoplayer2.ExoPlayer;
import com.huawei.hms.ml.camera.CountryCodeBean;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class IdentifierIdClient {
    private static String A = null;
    private static volatile IdentifierIdClient B = null;
    private static volatile DataBaseOperation C = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f9731a = "VMS_IDLG_SDK_Client";
    private static final String b = "content://com.vivo.vms.IdProvider/IdentifierId";
    private static final String c = "persist.sys.identifierid.supported";
    private static final String d = "appid";
    private static final String e = "type";
    private static final String f = "OAID";
    private static final String g = "VAID";
    private static final String h = "AAID";
    private static final int i = 0;
    private static final int j = 1;
    private static final int k = 2;
    private static final int l = 4;
    private static final int m = 11;
    private static final int n = 2000;
    private static Context o;
    private static boolean p;
    private static IdentifierIdObserver q;
    private static IdentifierIdObserver r;
    private static IdentifierIdObserver s;
    private static Object t = new Object();
    private static HandlerThread u;
    private static Handler v;
    private static String w;
    private static String x;
    private static String y;
    private static String z;

    public boolean a() {
        return p;
    }

    private IdentifierIdClient() {
    }

    public static IdentifierIdClient a(Context context) {
        if (B == null) {
            synchronized (IdentifierIdClient.class) {
                o = StubApp.getOrigApplicationContext(context.getApplicationContext());
                B = new IdentifierIdClient();
            }
        }
        if (C == null) {
            synchronized (IdentifierIdClient.class) {
                o = StubApp.getOrigApplicationContext(context.getApplicationContext());
                g();
                C = new DataBaseOperation(o);
                d();
            }
        }
        return B;
    }

    private static void g() {
        HandlerThread handlerThread = new HandlerThread("SqlWorkThread");
        u = handlerThread;
        handlerThread.start();
        v = new Handler(u.getLooper()) { // from class: org.repackage.com.vivo.identifier.IdentifierIdClient.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 11) {
                    String unused = IdentifierIdClient.w = IdentifierIdClient.C.a(message.getData().getInt("type"), message.getData().getString("appid"));
                    synchronized (IdentifierIdClient.t) {
                        IdentifierIdClient.t.notify();
                    }
                    return;
                }
                Log.e(IdentifierIdClient.f9731a, "message type valid");
            }
        };
    }

    public String b() {
        if (!a()) {
            return null;
        }
        String str = x;
        if (str != null) {
            return str;
        }
        a(0, (String) null);
        if (q == null) {
            a(o, 0, null);
        }
        return x;
    }

    public String a(String str) {
        if (!a()) {
            return null;
        }
        String str2 = y;
        if (str2 != null) {
            return str2;
        }
        a(1, str);
        if (r == null && y != null) {
            a(o, 1, str);
        }
        return y;
    }

    public String b(String str) {
        if (!a()) {
            return null;
        }
        String str2 = z;
        if (str2 != null) {
            return str2;
        }
        a(2, str);
        if (s == null && z != null) {
            a(o, 2, str);
        }
        return z;
    }

    public String c() {
        if (!a()) {
            return null;
        }
        a(4, (String) null);
        return A;
    }

    public void a(int i2, String str) {
        synchronized (t) {
            b(i2, str);
            long jUptimeMillis = SystemClock.uptimeMillis();
            try {
                t.wait(ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
            if (SystemClock.uptimeMillis() - jUptimeMillis >= ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS) {
                Log.d(f9731a, "query timeout");
            } else if (i2 == 0) {
                x = w;
                w = null;
            } else if (i2 != 1) {
                if (i2 == 2) {
                    String str2 = w;
                    if (str2 != null) {
                        z = str2;
                        w = null;
                    } else {
                        Log.e(f9731a, "get aaid failed");
                    }
                } else if (i2 != 4) {
                }
                A = w;
                w = null;
            } else {
                String str3 = w;
                if (str3 != null) {
                    y = str3;
                    w = null;
                } else {
                    Log.e(f9731a, "get vaid failed");
                }
            }
        }
    }

    private void b(int i2, String str) {
        Message messageObtainMessage = v.obtainMessage();
        messageObtainMessage.what = 11;
        Bundle bundle = new Bundle();
        bundle.putInt("type", i2);
        if (i2 == 1 || i2 == 2) {
            bundle.putString("appid", str);
        }
        messageObtainMessage.setData(bundle);
        v.sendMessage(messageObtainMessage);
    }

    public static void d() {
        p = "1".equals(a(c, "0"));
    }

    public static String a(String str, String str2) {
        try {
            try {
                Class<?> cls = Class.forName(CountryCodeBean.ANDRIOD_SYSTEMPROP);
                String str3 = (String) cls.getMethod("get", String.class, String.class).invoke(cls, str, "unknown");
                return str3;
            } catch (Exception e2) {
                e2.printStackTrace();
                return str2;
            }
        } catch (Throwable unused) {
            return str2;
        }
    }

    private static void a(Context context, int i2, String str) {
        if (i2 == 0) {
            q = new IdentifierIdObserver(B, 0, null);
            context.getContentResolver().registerContentObserver(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID"), true, q);
        } else if (i2 == 1) {
            r = new IdentifierIdObserver(B, 1, str);
            context.getContentResolver().registerContentObserver(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/VAID_" + str), false, r);
        } else {
            if (i2 != 2) {
                return;
            }
            s = new IdentifierIdObserver(B, 2, str);
            context.getContentResolver().registerContentObserver(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/AAID_" + str), false, s);
        }
    }
}
