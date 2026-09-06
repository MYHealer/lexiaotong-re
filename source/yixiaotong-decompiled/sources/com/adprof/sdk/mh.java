package com.adprof.sdk;

import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import com.cdo.oaps.ad.OapsKey;
import com.ubixnow.ooooo.o0OO000o;
import com.yfanads.android.utils.YFAdsConst;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public abstract class mh {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1308a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f465a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Map f467a;
    public int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public String f468b;
    public int c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public String f469c;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public String f470d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;
    public String k;
    public String l;
    public String m;
    public String n;
    public int d = -1;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public StringBuilder f466a = new StringBuilder("timedt,ac_type,category");

    public abstract u7 a();

    public final void a(StringBuilder sb, Object obj) {
        if (obj.toString().startsWith("{") || (obj instanceof Integer) || (obj instanceof Long)) {
            sb.append(obj);
        } else {
            sb.append("\"" + obj + "\"");
        }
    }

    public final void a(JSONObject jSONObject) throws JSONException {
        long jCurrentTimeMillis;
        int i;
        jSONObject.put("eventid", this.f465a);
        jSONObject.put("ac_type", this.f468b);
        jSONObject.put("oaid", a() != null ? a().b() : he.m644a().i());
        jSONObject.put("deviceid", a() != null ? a().b() : he.m644a().i());
        jSONObject.put("vender", this.i);
        jSONObject.put("brand", this.h);
        AtomicInteger atomicInteger = he.f346a;
        String str = g8.f312a;
        jSONObject.put("os_ver", Build.VERSION.RELEASE);
        jSONObject.put(com.umeng.analytics.pro.am.x, 1);
        jSONObject.put(OapsKey.KEY_PKG, he.m644a().m650b());
        jSONObject.put("d_m", m684a());
        jSONObject.put(OapsKey.KEY_PKG, he.m644a().m650b());
        int i2 = 0;
        try {
            int i3 = this.d;
            if (i3 <= -1) {
                he.m644a().getClass();
                try {
                    i = g8.f311a.f288a;
                } catch (Throwable th) {
                    pk.b("getActiveNetworkType error: ", th);
                    i = 0;
                }
                i3 = Integer.parseInt(String.valueOf(i));
                this.d = i3;
            }
            i2 = i3;
        } catch (Exception unused) {
        }
        jSONObject.put("net_t", i2);
        if (TextUtils.isEmpty(this.f470d)) {
            jCurrentTimeMillis = System.currentTimeMillis();
        } else {
            try {
                jCurrentTimeMillis = Long.parseLong(this.f470d);
            } catch (Exception unused2) {
                jCurrentTimeMillis = System.currentTimeMillis();
            }
        }
        jSONObject.put("ts", jCurrentTimeMillis);
        jSONObject.put(o0OO000o.o00O0O0O, this.f469c);
        jSONObject.put("appver", he.m644a().m651c());
        jSONObject.put("ver", AdprofSdk.getVersionName());
        if (!TextUtils.isEmpty(!TextUtils.isEmpty(he.m644a().m647a()) ? he.m644a().m647a() : "")) {
            jSONObject.put("and_id", !TextUtils.isEmpty(he.m644a().m647a()) ? he.m644a().m647a() : "");
        }
        if (!TextUtils.isEmpty(!TextUtils.isEmpty(he.m644a().f()) ? he.m644a().f() : "")) {
            jSONObject.put("imei", TextUtils.isEmpty(he.m644a().f()) ? "" : he.m644a().f());
        }
        if (!TextUtils.isEmpty(this.m)) {
            jSONObject.put(com.umeng.analytics.pro.d.C, this.m);
        }
        if (!TextUtils.isEmpty(this.n)) {
            jSONObject.put(com.umeng.analytics.pro.d.D, this.n);
        }
        if ("init".equals(this.f465a)) {
            he.m644a().getClass();
            jSONObject.put("sha1", (Object) null);
            jSONObject.put("ua", this.l);
            he.m644a().getClass();
            jSONObject.put("sha1", (Object) null);
            jSONObject.put("ise", this.f1308a);
            jSONObject.put("sr", this.k);
            jSONObject.put("sw", this.b);
            jSONObject.put("sh", this.c);
            jSONObject.put(LiveConfigKey.STANDARD, this.g);
            jSONObject.put(YFAdsConst.REPORT_DT, this.f);
            jSONObject.put("dm", m684a());
            jSONObject.put("tz", "Asia/Shanghai".equals(TimeZone.getDefault().getID()) ? "8" : TimeZone.getDefault().getID());
            jSONObject.put("sa", this.j);
        }
    }

    /* JADX INFO: renamed from: a */
    public abstract boolean mo622a();

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m686a(Map map) {
        if (map != null) {
            return map.get(com.huawei.openalliance.ad.constant.x.cy) == null && map.get("ac_type") == null;
        }
        return true;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public String m684a() {
        if (TextUtils.isEmpty(this.e)) {
            if (b8.f90a == null) {
                b8.f90a = Build.MODEL;
            }
            this.e = b8.f90a;
        }
        return this.e;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void mo685a() {
        if (TextUtils.isEmpty(this.f470d)) {
            this.f470d = String.valueOf(System.currentTimeMillis());
        }
        in.a().a(new kh(this));
    }

    public void a(lh lhVar) {
        SQLiteDatabase sQLiteDatabaseA;
        try {
            if (!mo622a() && !TextUtils.isEmpty(AdprofSdk.getInstance().getAppId())) {
                HashMap map = new HashMap();
                if (this.f467a == null) {
                    this.f467a = new HashMap();
                }
                if (this.f467a != null) {
                    map.remove("options");
                    if (this.f467a == null) {
                        this.f467a = new HashMap();
                    }
                    map.putAll(this.f467a);
                }
                map.put("appid", AdprofSdk.getInstance().getAppId());
                map.put("ver", AdprofSdk.getVersionName());
                String strA = a((Map) map);
                if (TextUtils.isEmpty(strA)) {
                    return;
                }
                if (pk.f594a) {
                    pk.d("statistic dc_debug item = " + strA);
                }
                sk skVar = sk.f1425a;
                if (skVar == null || (sQLiteDatabaseA = skVar.a()) == null) {
                    return;
                }
                HashMap map2 = new HashMap();
                map2.put("item", a.b(strA, "adprof_private_a"));
                map2.put("encryption", 1);
                List listAsList = Arrays.asList(map2.keySet().toArray());
                StringBuilder sb = new StringBuilder("insert or replace into ");
                sb.append(OapsKey.KEY_POINT);
                StringBuilder sb2 = new StringBuilder("(");
                StringBuilder sb3 = new StringBuilder("(");
                int i = 0;
                while (i < listAsList.size()) {
                    sb2.append(listAsList.get(i));
                    sb3.append("?");
                    i++;
                    if (i < listAsList.size()) {
                        sb2.append(", ");
                        sb3.append(", ");
                    }
                }
                sb2.append(")");
                sb3.append(")");
                sb.append((CharSequence) sb2).append(" values ").append((CharSequence) sb3);
                qk qkVar = new qk();
                qkVar.f681a = listAsList;
                qkVar.f682a = map2;
                qkVar.f1388a = sb.toString();
                sk.a(sQLiteDatabaseA, qkVar, new lh(this, null));
            }
        } catch (Throwable th) {
            oh.b(th);
            pk.b("PointEntitySuper insert db error", th);
        }
    }

    public void a(String str) {
        if (pk.f594a) {
            pk.a("PointEntitySuper setCategory category = " + str);
        }
        this.f465a = str;
    }

    /* JADX WARN: Code duplicated, block: B:36:0x0131  */
    public String a(Map map) {
        String string;
        Object objValueOf;
        if (map.isEmpty()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        if (m686a(map)) {
            JSONObject jSONObject = new JSONObject();
            try {
                a(jSONObject);
                return jSONObject.toString();
            } catch (Exception e) {
                pk.b(Log.getStackTraceString(e));
            }
        }
        sb.append("{\"eventid\":\"").append(map.get("eventid")).append("\",\"ac_type\":\"");
        sb.append(map.get("ac_type")).append("\",");
        if (!"init".equals(map.get("eventid"))) {
            map.remove("sha1");
            map.remove("ua");
            map.remove("ise");
            map.remove("sr");
            map.remove("sw");
            map.remove("sh");
            map.remove(LiveConfigKey.STANDARD);
            map.remove(YFAdsConst.REPORT_DT);
            map.remove("dm");
            map.remove("tz");
            map.remove("sa");
        }
        map.remove("eventid");
        map.remove("ac_type");
        boolean z = false;
        for (Map.Entry entry : map.entrySet()) {
            Object value = entry.getValue();
            if (value != null) {
                if (z) {
                    sb.append(",");
                }
                this.f466a.append("," + entry.getKey());
                sb.append("\"" + entry.getKey() + "\":");
                if (value instanceof Integer) {
                    objValueOf = Integer.valueOf(Integer.parseInt(value.toString()));
                } else {
                    if (value instanceof Long) {
                        objValueOf = Long.valueOf(Long.parseLong(value.toString()));
                    } else {
                        if (value instanceof String) {
                            if (Arrays.asList("motion_before", "motion_after").contains((String) entry.getKey())) {
                                string = value.toString();
                            } else {
                                string = t8.a((String) value);
                            }
                        } else {
                            string = value.toString();
                        }
                        a(sb, string);
                    }
                    z = true;
                }
                a(sb, objValueOf);
                z = true;
            }
        }
        sb.append(com.alipay.sdk.util.i.d);
        return sb.toString();
    }
}
