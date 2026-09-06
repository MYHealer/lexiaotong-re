package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.text.TextUtils;
import com.cdo.oaps.ad.OapsKey;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile f f1811a;

    private f() {
    }

    public static f a() {
        if (f1811a == null) {
            synchronized (f.class) {
                if (f1811a == null) {
                    f1811a = new f();
                }
            }
        }
        return f1811a;
    }

    public void a(double d, an.b bVar) {
        cs csVarA = cs.a();
        String strC = csVarA.c(z.f1849a);
        HashMap<String, String> map = new HashMap<>();
        map.put("v", "" + d);
        map.put(com.umeng.analytics.pro.am.x, "android");
        map.put(OapsKey.KEY_TYPE, a(bn.a((Context) null).d()));
        map.put("bdr", a(bn.a((Context) null).b()));
        an anVar = new an(csVarA.a(strC, map));
        anVar.a(bVar);
        anVar.b();
    }

    public String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException | NullPointerException unused) {
            return str;
        }
    }

    public DexClassLoader a(String str, String str2, String str3, ClassLoader classLoader) {
        try {
            File file = new File(str);
            if (!file.exists()) {
                return null;
            }
            file.setReadOnly();
            return new DexClassLoader(str, str2, str3, classLoader);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }
}
