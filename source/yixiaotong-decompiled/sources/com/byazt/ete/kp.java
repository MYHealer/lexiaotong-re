package com.byazt.ete;

import android.text.TextUtils;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 8, 667})
public class kp {
    public static long c = 27000;
    public static int tt;
    public static int ve;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f2182a;
    public boolean d;
    public double da;
    public float eo;
    public boolean gr;
    public int gt;
    public boolean gu;
    public int h;
    public boolean i;
    public boolean m;
    public boolean md;
    public double my;
    public int n;
    public double nu;
    public int or;
    public boolean p;
    public int qy;
    public boolean rh;
    public int rl;
    public String sl;
    public boolean sp;
    public int t;
    public int u;
    public String uj;
    public double x;
    public int yp;
    public b yv;
    public int z;
    public int zb;
    public ArrayList<g> zm;

    public static long c() {
        return c;
    }

    public static long tt() {
        return tt;
    }

    public static boolean ve() {
        return ve == 1;
    }

    public kp(JSONObject jSONObject) {
        this.qy = 0;
        this.gu = false;
        this.gr = false;
        this.zm = new ArrayList<>();
        this.eo = 1.0f;
        this.or = 0;
        if (jSONObject == null) {
            return;
        }
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("reward");
        if (jSONObjectOptJSONObject != null) {
            JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("retain_dialog_config");
            if (jSONArrayOptJSONArray != null) {
                this.zm = new ArrayList<>();
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    JSONObject jSONObjectOptJSONObject2 = jSONArrayOptJSONArray.optJSONObject(i);
                    if (jSONObjectOptJSONObject2 != null) {
                        this.zm.add(new g(jSONObjectOptJSONObject2));
                    }
                }
            }
            this.yv = new b(jSONObjectOptJSONObject);
            this.md = jSONObjectOptJSONObject.optBoolean("endcard_transform_enabled", false);
            this.or = jSONObjectOptJSONObject.optInt("video_no_play_start", 0);
        }
        JSONObject jSONObjectOptJSONObject3 = jSONObject.optJSONObject("reward_data");
        if (jSONObjectOptJSONObject3 != null) {
            this.n = jSONObjectOptJSONObject3.optInt("reward_amount", 0);
            this.uj = jSONObjectOptJSONObject3.optString("reward_name", "");
            this.f2182a = jSONObjectOptJSONObject3.optBoolean("reward_info_show", false);
            this.u = jSONObjectOptJSONObject3.optInt("reward_back_type", 0);
            this.yp = jSONObjectOptJSONObject3.optInt("reward_backup_timing", 0);
            this.z = jSONObjectOptJSONObject3.optInt("reward_backup_duration", Integer.MAX_VALUE);
            this.h = jSONObjectOptJSONObject3.optInt("reward_is_callback", 0);
            this.d = jSONObjectOptJSONObject3.optBoolean("reward_need_click", false);
            this.eo = (float) jSONObjectOptJSONObject3.optDouble("reward_speed_time", 1.0d);
            JSONObject jSONObjectOptJSONObject4 = jSONObjectOptJSONObject3.optJSONObject("reward_advanced_config");
            if (jSONObjectOptJSONObject4 != null) {
                JSONObject jSONObjectOptJSONObject5 = jSONObjectOptJSONObject4.optJSONObject("easy_playable");
                if (jSONObjectOptJSONObject5 != null) {
                    this.sp = jSONObjectOptJSONObject5.optBoolean("enable");
                    double dOptDouble = jSONObjectOptJSONObject5.optDouble("propose_reward", 0.0d);
                    this.x = dOptDouble;
                    if (dOptDouble < 0.0d) {
                        this.x = 0.0d;
                    }
                }
                JSONObject jSONObjectOptJSONObject6 = jSONObjectOptJSONObject4.optJSONObject("play_complete");
                if (jSONObjectOptJSONObject6 != null) {
                    this.i = jSONObjectOptJSONObject6.optBoolean("enable");
                    double dOptDouble2 = jSONObjectOptJSONObject6.optDouble("propose_reward", 0.0d);
                    this.da = dOptDouble2;
                    if (dOptDouble2 < 0.0d) {
                        this.da = 0.0d;
                    }
                    this.sl = jSONObjectOptJSONObject6.optString("tip_toast");
                    this.t = jSONObjectOptJSONObject6.optInt("min_duration");
                }
                JSONObject jSONObjectOptJSONObject7 = jSONObjectOptJSONObject4.optJSONObject("playable_interactive");
                if (jSONObjectOptJSONObject7 != null) {
                    this.m = jSONObjectOptJSONObject7.optBoolean("enable");
                    this.nu = jSONObjectOptJSONObject7.optDouble("propose_reward", 0.0d);
                }
                JSONObject jSONObjectOptJSONObject8 = jSONObjectOptJSONObject4.optJSONObject("click_landing");
                if (jSONObjectOptJSONObject8 != null) {
                    this.rh = jSONObjectOptJSONObject8.optBoolean("enable");
                    this.my = jSONObjectOptJSONObject8.optDouble("propose_reward", 0.0d);
                    this.gt = jSONObjectOptJSONObject8.optInt("landing_view_time", 5);
                }
            }
        }
        this.rl = jSONObject.optInt("reward_full_play_time", 30);
        this.qy = jSONObject.optInt("reward_full_time_type", 0);
        this.p = jSONObject.optBoolean("interstitial_bg_transparent", false);
        this.zb = jSONObject.optInt("template_sign", 0);
        this.gu = jSONObject.optBoolean("__is_use_local_time", false);
        this.gr = jSONObject.optBoolean("__is_click_landing_reward", false);
    }

    public static void c(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("app_common_config");
        if (jSONObjectOptJSONObject != null) {
            try {
                c = jSONObjectOptJSONObject.optLong("reward_time_limited", 27000L);
                tt = jSONObjectOptJSONObject.optInt("reward_force_close_max_count", 0);
                ve = jSONObjectOptJSONObject.optInt("reward_local_countdown_close_style", 0);
            } catch (Exception unused) {
            }
        }
    }

    public static void c(com.byazt.it.n nVar) {
        nVar.put("reward_time_limited", c);
        nVar.put("reward_force_close_max_count", tt);
        nVar.put("reward_local_countdown_close_style", ve);
    }

    public static void tt(com.byazt.it.n nVar) {
        c = nVar.get("reward_time_limited", 27000L);
        tt = nVar.get("reward_force_close_max_count", 0);
        ve = nVar.get("reward_local_countdown_close_style", 0);
    }

    public void tt(JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            ArrayList<g> arrayList = this.zm;
            if (arrayList != null && arrayList.size() != 0) {
                Iterator<g> it = this.zm.iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next().c());
                }
            }
            jSONObject2.put("retain_dialog_config", jSONArray);
            b bVar = this.yv;
            if (bVar != null) {
                bVar.c(jSONObject2);
            }
            jSONObject2.put("endcard_transform_enabled", this.md);
            jSONObject2.put("video_no_play_start", this.or);
            jSONObject.put("reward", jSONObject2);
        } catch (JSONException e) {
            com.byazt.nr.m.c(e);
        }
        try {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("reward_name", this.uj);
            jSONObject3.put("reward_amount", this.n);
            jSONObject3.put("reward_info_show", this.f2182a);
            jSONObject3.put("reward_back_type", this.u);
            jSONObject3.put("reward_backup_timing", this.yp);
            jSONObject3.put("reward_backup_duration", this.z);
            jSONObject3.put("reward_is_callback", this.h);
            jSONObject3.put("reward_need_click", this.d);
            jSONObject3.put("reward_speed_time", this.eo);
            JSONObject jSONObject4 = new JSONObject();
            JSONObject jSONObject5 = new JSONObject();
            jSONObject5.put("enable", this.sp);
            jSONObject5.put("propose_reward", this.x);
            jSONObject4.put("easy_playable", jSONObject5);
            JSONObject jSONObject6 = new JSONObject();
            jSONObject6.put("enable", this.i);
            jSONObject6.put("propose_reward", this.da);
            jSONObject6.put("tip_toast", this.sl);
            jSONObject6.put("min_duration", this.t);
            jSONObject4.put("play_complete", jSONObject6);
            JSONObject jSONObject7 = new JSONObject();
            jSONObject7.put("enable", this.m);
            jSONObject7.put("propose_reward", this.nu);
            jSONObject4.put("playable_interactive", jSONObject7);
            JSONObject jSONObject8 = new JSONObject();
            jSONObject8.put("enable", this.rh);
            jSONObject8.put("propose_reward", this.my);
            jSONObject8.put("landing_view_time", this.gt);
            jSONObject4.put("click_landing", jSONObject8);
            jSONObject3.put("reward_advanced_config", jSONObject4);
            jSONObject.put("reward_data", jSONObject3);
        } catch (JSONException e2) {
            com.byazt.nr.m.c(e2);
        }
        try {
            jSONObject.put("reward_full_play_time", this.rl);
            jSONObject.put("reward_full_time_type", this.qy);
            jSONObject.put("interstitial_bg_transparent", this.p);
            jSONObject.put("template_sign", this.zb);
            jSONObject.put("__is_use_local_time", this.gu);
            jSONObject.put("__is_click_landing_reward", this.gr);
        } catch (JSONException e3) {
            com.byazt.nr.m.c(e3);
        }
    }

    private static kp h(ic icVar) {
        if (icVar == null) {
            return null;
        }
        return icVar.xd();
    }

    public static String c(ic icVar) {
        kp kpVarH = h(icVar);
        return kpVarH == null ? "" : kpVarH.uj;
    }

    public static int tt(ic icVar) {
        kp kpVarH = h(icVar);
        if (kpVarH == null) {
            return 0;
        }
        return kpVarH.n;
    }

    public static boolean ve(ic icVar) {
        kp kpVarH = h(icVar);
        if (kpVarH == null) {
            return false;
        }
        return kpVarH.f2182a;
    }

    public static boolean uj(ic icVar) {
        kp kpVarH = h(icVar);
        return kpVarH != null && kpVarH.u == 1;
    }

    public static boolean n(ic icVar) {
        kp kpVarH = h(icVar);
        if (kpVarH == null) {
            return false;
        }
        return kpVarH.sp;
    }

    public static double a(ic icVar) {
        kp kpVarH = h(icVar);
        if (kpVarH == null) {
            return 0.0d;
        }
        return kpVarH.x;
    }

    public static boolean sp(ic icVar) {
        kp kpVarH = h(icVar);
        if (kpVarH == null) {
            return false;
        }
        return kpVarH.i;
    }

    public static double x(ic icVar) {
        kp kpVarH = h(icVar);
        if (kpVarH == null) {
            return 0.0d;
        }
        return kpVarH.da;
    }

    public static String i(ic icVar) {
        kp kpVarH = h(icVar);
        if (kpVarH == null) {
            return "";
        }
        return TextUtils.isEmpty(kpVarH.sl) ? "别急着跳过，继续观看完整视频，可获得更多额外奖励～" : kpVarH.sl;
    }

    public static int da(ic icVar) {
        kp kpVarH = h(icVar);
        if (kpVarH == null) {
            return KSImageLoader.InnerImageLoadingListener.MAX_DURATION;
        }
        int iMax = Math.max(kpVarH.t, 30);
        return (iMax <= 60 ? iMax : 30) * 1000;
    }

    public static boolean sl(ic icVar) {
        kp kpVarH = h(icVar);
        if (kpVarH == null) {
            return false;
        }
        return kpVarH.m;
    }

    public static double t(ic icVar) {
        kp kpVarH = h(icVar);
        if (kpVarH == null) {
            return 0.0d;
        }
        return kpVarH.nu;
    }

    public static boolean u(ic icVar) {
        kp kpVarH = h(icVar);
        if (kpVarH == null) {
            return false;
        }
        return kpVarH.rh;
    }

    public static int yp(ic icVar) {
        kp kpVarH = h(icVar);
        if (kpVarH == null) {
            return 5;
        }
        return Math.max(5, kpVarH.gt);
    }

    public static float c(ic icVar, int i) {
        double dA;
        if (i == 0) {
            return 1.0f;
        }
        if (i == 1) {
            dA = a(icVar);
        } else if (i == 2) {
            dA = x(icVar);
        } else {
            if (i != 3) {
                return 0.0f;
            }
            dA = t(icVar);
        }
        return (float) dA;
    }

    public static int z(ic icVar) {
        int i;
        kp kpVarH = h(icVar);
        if (kpVarH != null && (i = kpVarH.rl) >= 10 && i <= 60) {
            return i;
        }
        return 30;
    }

    public static int m(ic icVar) {
        kp kpVarH = h(icVar);
        if (kpVarH == null) {
            return 0;
        }
        return kpVarH.qy;
    }

    public static boolean nu(ic icVar) {
        kp kpVarH = h(icVar);
        if (kpVarH != null && kpVarH.gu) {
            return my.uj(icVar) || m(icVar) == 1 || m(icVar) == 2;
        }
        return false;
    }

    public static boolean rh(ic icVar) {
        kp kpVarH = h(icVar);
        return kpVarH != null && kpVarH.gu && m(icVar) == 1;
    }

    public static boolean my(ic icVar) {
        kp kpVarH = h(icVar);
        if (kpVarH != null && kpVarH.gr) {
            return u(icVar);
        }
        return false;
    }

    public static void c(ic icVar, boolean z) {
        kp kpVarH = h(icVar);
        if (kpVarH != null) {
            kpVarH.gu = z;
        }
    }

    public static void tt(ic icVar, boolean z) {
        kp kpVarH = h(icVar);
        if (kpVarH != null) {
            kpVarH.gr = z;
        }
    }

    public static ArrayList<g> gt(ic icVar) {
        kp kpVarH = h(icVar);
        if (kpVarH != null) {
            return kpVarH.zm;
        }
        return new ArrayList<>();
    }

    public static boolean rl(ic icVar) {
        kp kpVarH = h(icVar);
        return kpVarH != null && kpVarH.yp == 1;
    }

    public static int tt(ic icVar, int i) {
        int i2;
        kp kpVarH = h(icVar);
        return (kpVarH != null && (i2 = kpVarH.z) > 0) ? Math.min(i, i2) : i;
    }

    public static b qy(ic icVar) {
        kp kpVarH = h(icVar);
        if (kpVarH != null) {
            return kpVarH.yv;
        }
        return null;
    }

    public static boolean gu(ic icVar) {
        kp kpVarH = h(icVar);
        if (kpVarH != null) {
            return kpVarH.p;
        }
        return false;
    }

    public static boolean gr(ic icVar) {
        kp kpVarH = h(icVar);
        if (kpVarH == null) {
            return false;
        }
        return kpVarH.md;
    }

    public static boolean ve(ic icVar, boolean z) {
        kp kpVarH = h(icVar);
        return (kpVarH != null && z && kpVarH.or == 1) ? false : true;
    }

    public static boolean zm(ic icVar) {
        kp kpVarH = h(icVar);
        return kpVarH != null && kpVarH.h == 1;
    }

    public static float yv(ic icVar) {
        kp kpVarH = h(icVar);
        if (kpVarH == null) {
            return 1.0f;
        }
        return kpVarH.eo;
    }

    public static boolean p(ic icVar) {
        kp kpVarH = h(icVar);
        if (kpVarH == null) {
            return false;
        }
        return kpVarH.d;
    }

    public static int md(ic icVar) {
        kp kpVarH = h(icVar);
        if (kpVarH == null) {
            return 0;
        }
        return kpVarH.zb;
    }
}
