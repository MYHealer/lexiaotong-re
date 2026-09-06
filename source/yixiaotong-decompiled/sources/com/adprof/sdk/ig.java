package com.adprof.sdk;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.WebSettings;
import java.util.HashSet;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public abstract class ig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile a3 f1231a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static volatile ae f380a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static volatile jg f381a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final String f382a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final HashSet f383a;
    public static volatile a3 b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static volatile String f384b;
    public static volatile a3 c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public static volatile String f385c;
    public static volatile a3 d;
    public static a3 e;
    public static a3 f;

    static {
        String property = System.getProperty("http.agent");
        f382a = property;
        f385c = property;
        f381a = null;
        f383a = new HashSet();
    }

    public static String a() {
        return TextUtils.isEmpty(f384b) ? f385c : f384b;
    }

    public static String a(final Context context) {
        qh.a(context);
        String str = f384b;
        if (TextUtils.isEmpty(str)) {
            synchronized (ig.class) {
                str = f384b;
                if (str == null) {
                    in.a().a(new Runnable() { // from class: com.adprof.sdk.ig$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() {
                            ig.m657a(context);
                        }
                    });
                }
            }
        }
        return str;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static void m657a(Context context) {
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            f384b = WebSettings.getDefaultUserAgent(context);
            if (pk.f594a) {
                pk.a("getUA time " + (System.currentTimeMillis() - jCurrentTimeMillis) + " \n  ua = " + f384b);
            }
            sl.a("user-agent-cache", f384b);
        } catch (Exception e2) {
            if (!TextUtils.isEmpty(f385c)) {
                f384b = f385c;
            }
            pk.b("Failed to get user agent", e2);
        }
    }
}
