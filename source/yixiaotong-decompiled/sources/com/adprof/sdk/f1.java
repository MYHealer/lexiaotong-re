package com.adprof.sdk;

import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public final class f1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1161a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f285a;

    public final void a(int i, String str) {
        pk.d("loadLocalData code = " + i + "    msg = " + str + ' ');
        String str2 = null;
        try {
            String strA = sl.a("config");
            if (!TextUtils.isEmpty(strA)) {
                String strA2 = g1.a(strA, AdprofSdk.getInstance().getAppSecret(), false);
                if (TextUtils.isEmpty(strA2)) {
                    pk.e("本地配置数据解密失败，可能数据格式不正确");
                } else {
                    str2 = strA2;
                }
            }
        } catch (Exception e) {
            pk.b("读取本地配置数据失败: " + e.getMessage());
        }
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        pk.a("使用本地配置文件");
        try {
            Intrinsics.checkNotNull(str2);
            a(str2);
        } catch (Throwable th) {
            pk.a(th);
            oh.b(th);
        }
    }

    public final void b(String str) {
        try {
            sl.a("config", g1.a(str, AdprofSdk.getInstance().getAppSecret()));
            pk.d("配置数据已加密保存到本地");
        } catch (Exception e) {
            pk.b("保存本地配置数据失败: " + e.getMessage());
        }
    }

    public final void a(String str) {
        pk.d("使用配置文件：" + str);
        a1 a1Var = new a1(new JSONObject(str));
        d1 d1VarA = d1.f1121a.a();
        List<r1> list = a1Var.f1022a;
        d1VarA.getClass();
        for (r1 r1Var : list) {
            if (d1VarA.b == null) {
                d1VarA.b = new SparseArray();
            }
            SparseArray sparseArray = d1VarA.b;
            Intrinsics.checkNotNull(sparseArray);
            sparseArray.put(r1Var.f1394a, r1Var);
        }
        d1 d1VarA2 = d1.f1121a.a();
        List<e2> list2 = a1Var.b;
        d1VarA2.getClass();
        for (e2 e2Var : list2) {
            if (d1VarA2.f208a == null) {
                d1VarA2.f208a = new SparseArray();
            }
            SparseArray sparseArray2 = d1VarA2.f208a;
            Intrinsics.checkNotNull(sparseArray2);
            sparseArray2.put(e2Var.f1140a, e2Var);
        }
        d1 d1VarA3 = d1.f1121a.a();
        List<v0> list3 = a1Var.c;
        d1VarA3.getClass();
        for (v0 v0Var : list3) {
            if (d1VarA3.f209a == null) {
                d1VarA3.f209a = new ArrayList();
            }
            ArrayList arrayList = d1VarA3.f209a;
            Intrinsics.checkNotNull(arrayList);
            arrayList.add(v0Var);
        }
        d1.f1121a.a().f210a = a1Var.f5a;
        ArrayList arrayList2 = new ArrayList();
        List list4 = a1Var.c;
        if (list4 != null) {
            Iterator it = list4.iterator();
            while (it.hasNext()) {
                arrayList2.add(((v0) it.next()).b);
            }
        }
    }

    public final void a(int i) {
        try {
            fh fhVar = new fh();
            ((mh) fhVar).f468b = "100";
            fhVar.a("sdk_config_fail");
            oh.a((d) null, fhVar);
            oh.a((wd) null, fhVar);
            oh.a(fhVar);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("error_code", String.valueOf(i));
            ((mh) fhVar).f469c = jSONObject.toString();
            fhVar.mo685a();
        } catch (Throwable th) {
            oh.b(th);
            pk.d("sendPointEvent = " + Log.getStackTraceString(th));
        }
    }

    public final void a(long j) {
        try {
            fh fhVar = new fh();
            ((mh) fhVar).f468b = "100";
            fhVar.a("sdk_config_suc");
            oh.a((d) null, fhVar);
            oh.a((wd) null, fhVar);
            oh.a(fhVar);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("cost", String.valueOf(j));
            ((mh) fhVar).f469c = jSONObject.toString();
            fhVar.mo685a();
        } catch (Throwable th) {
            oh.b(th);
            pk.d("sendPointEvent = " + Log.getStackTraceString(th));
        }
    }

    public final void a() {
        this.f285a = System.currentTimeMillis();
        int i = Integer.parseInt(StringsKt.trim((CharSequence) AdprofSdk.getInstance().getAppId()).toString());
        HashMap map = new HashMap();
        map.put(com.hihonor.adsdk.base.g.j.e.a.hnadsu, Integer.valueOf(i));
        map.put("sdk_version", AdprofSdk.getVersionName());
        map.put(com.umeng.analytics.pro.am.x, 2);
        map.put("os_version", Build.VERSION.RELEASE);
        map.put("device_id", g1.a(he.m644a().i()));
        map.put("device_id_type", 4);
        map.put("app_package_name", he.m644a().m650b());
        map.put("app_version", he.m644a().m651c());
        String string = new JSONObject(map).toString();
        if (pk.f594a) {
            pk.a("配置请求参数：" + string);
        }
        String strA = g1.a(string, AdprofSdk.getInstance().getAppSecret());
        if (pk.f594a) {
            pk.d("配置加密结果：" + strA);
            pk.d("配置解密结果：" + g1.a(strA, AdprofSdk.getInstance().getAppSecret(), false));
        }
        oh.a("sdk_config_req", "", null, null, null);
        long jCurrentTimeMillis = System.currentTimeMillis() / ((long) 1000);
        yk ykVar = new yk("https://sdkconf.buluken.com/sdk_config/v3/config");
        ykVar.c = strA;
        ykVar.f882b.put("Content-Type", "application/hex");
        ykVar.f882b.put("X-ADS-TIME", String.valueOf(jCurrentTimeMillis));
        String lowerCase = g1.a(jCurrentTimeMillis + AdprofSdk.getInstance().getAppSecret()).toLowerCase();
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase()");
        ykVar.f882b.put("X-ADS-KEY", lowerCase);
        ykVar.f882b.put("ClientId", AdprofSdk.getInstance().getAppId());
        e1 e1Var = new e1(this);
        ykVar.b = "POST";
        ykVar.a(e1Var);
    }
}
