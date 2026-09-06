package com.adprof.sdk;

import android.text.TextUtils;
import android.util.Log;
import com.qq.e.comm.managers.setting.GlobalSetting;
import com.ubixnow.ooooo.o0OO000o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;
import org.json.JSONTokener;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class fh extends ih {
    public static final String z = i5.a("YmxvY2tfY2xpY2s=");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public double f1173a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f295a;
    public String q;
    public String r;
    public String s;
    public String t;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f294a = 0;
    public int e = 0;
    public int f = 0;
    public int g = 0;
    public String u = "";
    public int h = 0;
    public boolean b = false;
    public int i = 0;
    public int j = 0;
    public String v = "";
    public String w = "";
    public String x = "";
    public String y = "";

    @Override // com.adprof.sdk.mh
    public u7 a() {
        return v7.a().m721a();
    }

    @Override // com.adprof.sdk.mh
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean mo622a() {
        z1.a().getClass();
        Iterator it = new ArrayList().iterator();
        while (it.hasNext()) {
            if (((mh) this).f468b.equals(String.valueOf((Integer) it.next()))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.adprof.sdk.mh
    public String a(Map map) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        if (m686a(map)) {
            try {
                JSONObject jSONObject = new JSONObject(new JSONTokener(super.a(map)));
                if (map.get("ad_type") == null) {
                    try {
                        i = Integer.parseInt(this.o);
                    } catch (Exception unused) {
                        i = 1000000;
                    }
                    jSONObject.put("ad_type", i);
                }
                if (map.get("requestid") == null) {
                    jSONObject.put("requestid", this.p);
                }
                if (map.get("slotid") == null) {
                    jSONObject.put("slotid", this.q);
                }
                if (map.get("cost") == null) {
                    long j = this.f294a;
                    if (j > 0) {
                        jSONObject.put("cost", j);
                    }
                }
                if (map.get("ecpm") == null) {
                    jSONObject.put("ecpm", this.t);
                }
                if (map.get(o0OO000o.o00O00oO) == null) {
                    jSONObject.put(o0OO000o.o00O00oO, c8.a().m587a());
                }
                if (map.get("ad_id") == null) {
                    jSONObject.put("ad_id", this.s);
                }
                if (map.get(GlobalSetting.CUSTOM_INFO_KEY) == null) {
                    jSONObject.put(GlobalSetting.CUSTOM_INFO_KEY, this.r);
                }
                if (map.get("sessionid") == null) {
                    jSONObject.put("sessionid", l.c);
                }
                if (map.get("action") == null && (i5 = this.f) != 0) {
                    jSONObject.put("action", i5);
                }
                if (map.get("m_t") == null && (i4 = this.e) != 0) {
                    jSONObject.put("m_t", i4);
                }
                if (map.get("click_t") == null && (i3 = this.g) != 0) {
                    jSONObject.put("click_t", i3);
                }
                if (map.get("uclick_t") == null && !TextUtils.isEmpty(this.u)) {
                    jSONObject.put("uclick_t", this.u);
                }
                if (map.get(com.hihonor.adsdk.base.g.j.e.a.W0) == null) {
                    try {
                        if (Integer.parseInt(this.o) == 1) {
                            jSONObject.put(com.hihonor.adsdk.base.g.j.e.a.W0, this.h);
                        }
                    } catch (Exception unused2) {
                    }
                }
                if (map.get("sensitivity") == null) {
                    double d = this.f1173a;
                    if (d != 0.0d && this.g == 3) {
                        jSONObject.put("sensitivity", d);
                    }
                }
                map.get("slide_percent");
                if (map.get("full_click") == null) {
                    jSONObject.put("full_click", this.b);
                }
                if (map.get("ddp") == null) {
                    jSONObject.put("ddp", this.i);
                }
                if (map.get("bid_floor") == null && (i2 = this.j) > 0) {
                    jSONObject.put("bid_floor", i2);
                }
                String str = z;
                if (map.get(str) == null && "click".equals(jSONObject.opt("eventid"))) {
                    jSONObject.put(str, this.f295a);
                }
                if ("open_deeplink_start".equals(jSONObject.opt("eventid"))) {
                    if (map.get("dp_pkg") == null) {
                        jSONObject.put("dp_pkg", this.v);
                    }
                    if (map.get("dp_link_25") == null) {
                        jSONObject.put("dp_link_25", this.w);
                    }
                }
                if ("feed_back".equals(jSONObject.opt("eventid"))) {
                    if (map.get("fb_type") == null) {
                        jSONObject.put("fb_type", this.x);
                    }
                    if (map.get("fb_detail") == null) {
                        jSONObject.put("fb_detail", this.y);
                    }
                }
                jSONObject.put("appid", AdprofSdk.getInstance().getAppId());
                return jSONObject.toString();
            } catch (Exception e) {
                pk.d(Log.getStackTraceString(e));
            }
        }
        return super.a(map);
    }
}
