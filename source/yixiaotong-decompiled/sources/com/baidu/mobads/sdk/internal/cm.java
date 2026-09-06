package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.mobads.sdk.api.IXAdContainerFactory;
import com.huawei.hms.ml.camera.CountryCodeBean;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
public class cm {
    public static final String b = "404";
    public static final int c = 843;
    protected final bv d = bv.a();
    private Context h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f1774a = z.b;
    private static cm g = new cm();
    public static volatile String e = "";
    public static volatile String f = "";
    private static AtomicBoolean i = new AtomicBoolean(false);
    private static String j = "";
    private static AtomicBoolean k = new AtomicBoolean(false);
    private static String l = "";

    public static cm a() {
        return g;
    }

    public void a(Context context) {
        if (this.h == null) {
            this.h = context;
        }
    }

    private cm() {
    }

    public void a(String str, String str2, String str3) {
        try {
            HashMap<String, String> map = new HashMap<>();
            map.put("ad", str3);
            map.put("stacktrace", str2);
            a(str, b, map);
        } catch (Exception e2) {
            this.d.a(e2);
        }
    }

    private void a(String str, String str2, HashMap<String, String> map) {
        Uri.Builder builder = new Uri.Builder();
        try {
            Uri.Builder builderAppendQueryParameter = builder.appendQueryParameter("type", str2).appendQueryParameter("subtype", String.valueOf(c)).appendQueryParameter(com.umeng.analytics.pro.am.bc, "9.450").appendQueryParameter("appsid", a("appsid", new Object[0])).appendQueryParameter("v", "android_" + d() + "_4.1.30");
            Context context = this.h;
            builderAppendQueryParameter.appendQueryParameter("pack", context != null ? context.getPackageName() : "").appendQueryParameter("sn", a("encodedSn", this.h)).appendQueryParameter("cuid", a("encodedCUID", this.h)).appendQueryParameter(com.umeng.analytics.pro.am.x, "android").appendQueryParameter("osv", bn.a(this.h).c()).appendQueryParameter("romn", b()).appendQueryParameter("romv", c()).appendQueryParameter("bdr", "" + bn.a(this.h).a()).appendQueryParameter("brd", "" + a(bn.a(this.h).e()));
            if (str != null && str.length() > 128) {
                int iIndexOf = str.indexOf(10);
                if (iIndexOf <= 0) {
                    iIndexOf = 127;
                }
                str = str.substring(0, iIndexOf);
            }
            builder.appendQueryParameter("reason", str);
            if (map != null) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    builder.appendQueryParameter(entry.getKey(), entry.getValue());
                }
            }
        } catch (Throwable th) {
            this.d.a(th);
        }
        an anVar = new an(f1774a, "POST");
        anVar.a(builder);
        anVar.b();
    }

    private String a(String str, Object... objArr) {
        IXAdContainerFactory iXAdContainerFactoryC;
        aa aaVarA = aa.a();
        if (aaVarA == null || (iXAdContainerFactoryC = aaVarA.c()) == null) {
            return "";
        }
        Object remoteParam = iXAdContainerFactoryC.getRemoteParam(str, objArr);
        return remoteParam instanceof String ? (String) remoteParam : "";
    }

    private String d() {
        String str = cn.e;
        if (!"0.0".equals(str)) {
            return str;
        }
        try {
            double dB = cb.b(cb.a(this.h));
            return dB > 0.0d ? String.valueOf(dB) : str;
        } catch (Throwable th) {
            this.d.a(th);
            return str;
        }
    }

    private String a(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    public String b() {
        try {
            if (i.compareAndSet(false, true)) {
                Class<?> cls = Class.forName("com.huawei.system.BuildEx");
                String str = (String) cls.getMethod("getOsBrand", new Class[0]).invoke(cls, new Object[0]);
                if (!TextUtils.isEmpty(str)) {
                    j = str;
                }
            }
            return j;
        } catch (Throwable th) {
            this.d.a(th);
            return j;
        }
    }

    public String c() {
        try {
            if (k.get()) {
                return l;
            }
            if (!i.get()) {
                b();
            }
            if (j.equalsIgnoreCase("")) {
                k.set(true);
                return "";
            }
            if (k.compareAndSet(false, true)) {
                String strA = a("hw_sc.build.platform.version", "");
                if (!TextUtils.isEmpty(strA)) {
                    l = strA;
                }
            }
            return l;
        } catch (Throwable th) {
            this.d.a(th);
            return l;
        }
    }

    private String a(String str, String str2) {
        try {
            Class<?> cls = Class.forName(CountryCodeBean.ANDRIOD_SYSTEMPROP);
            String str3 = (String) cls.getDeclaredMethod("get", String.class).invoke(cls, str);
            return TextUtils.isEmpty(str3) ? str2 : str3;
        } catch (Throwable th) {
            this.d.a(th);
            return str2;
        }
    }
}
