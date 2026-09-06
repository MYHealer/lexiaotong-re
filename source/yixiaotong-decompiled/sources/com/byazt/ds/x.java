package com.byazt.ds;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.alipay.sdk.cons.b;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 1480, 71})
public class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile JSONObject f2116a;
    public final Context c;
    public final SharedPreferences n;
    public volatile JSONObject sp;
    public final com.byazt.gj.x tt;
    public final SharedPreferences uj;
    public final SharedPreferences ve;

    public static String c() {
        return "embed_applog_stats";
    }

    public com.byazt.gj.x bm() {
        return this.tt;
    }

    public boolean c(ArrayList<com.byazt.tv.c> arrayList) {
        return true;
    }

    public SharedPreferences n() {
        return this.n;
    }

    public JSONObject sp() {
        return this.sp;
    }

    public String zm() {
        return null;
    }

    public x(Context context, com.byazt.gj.x xVar) {
        this.c = context;
        this.tt = xVar;
        this.n = com.byazt.nys.tt.tt(context, "embed_applog_stats", 0);
        this.ve = com.byazt.nys.tt.tt(context, "embed_header_custom", 0);
        this.uj = com.byazt.nys.tt.tt(context, "embed_last_sp_session", 0);
    }

    public String tt() {
        return this.tt.sp();
    }

    public String ve() {
        return this.uj.getString("session_last_day", "");
    }

    public void c(String str, int i) {
        this.uj.edit().putString("session_last_day", str).putInt("session_order", i).apply();
    }

    public int uj() {
        return this.uj.getInt("session_order", 0);
    }

    public boolean a() {
        return this.tt.tt();
    }

    public void c(JSONObject jSONObject) {
        if (com.byazt.yv.da.tt) {
            com.byazt.yv.da.c("setConfig, " + jSONObject.toString(), null);
        }
        this.sp = jSONObject;
        long jCurrentTimeMillis = System.currentTimeMillis();
        SharedPreferences.Editor editorEdit = this.n.edit();
        long jOptInt = jSONObject.optInt("session_interval", 0);
        if (jOptInt > 0 && jOptInt <= 604800) {
            editorEdit.putLong("session_interval", jOptInt * 1000);
        } else {
            editorEdit.remove("session_interval");
        }
        long jOptInt2 = jSONObject.optInt("batch_event_interval", 0);
        if (jOptInt2 > 0 && jOptInt2 <= 604800) {
            editorEdit.putLong("batch_event_interval", jOptInt2 * 1000);
        } else {
            editorEdit.remove("batch_event_interval");
        }
        int iOptInt = jSONObject.optInt("send_launch_timely", 0);
        if (iOptInt > 0 && iOptInt <= 604800) {
            editorEdit.putInt("send_launch_timely", iOptInt);
        } else {
            editorEdit.remove("send_launch_timely");
        }
        long jOptInt3 = jSONObject.optInt("abtest_fetch_interval", 0);
        if (jOptInt3 > 20 && jOptInt3 <= 604800) {
            editorEdit.putLong("abtest_fetch_interval", jOptInt3 * 1000);
        } else {
            editorEdit.remove("abtest_fetch_interval");
        }
        boolean zOptBoolean = jSONObject.optBoolean("bav_log_collect", true);
        if (zOptBoolean) {
            editorEdit.putBoolean("bav_log_collect", true);
        } else {
            editorEdit.remove("bav_log_collect");
        }
        com.byazt.yv.da.c = zOptBoolean;
        if (jSONObject.optBoolean("bav_ab_config", false)) {
            editorEdit.putBoolean("bav_ab_config", true);
        } else {
            editorEdit.remove("bav_ab_config");
        }
        int iOptInt2 = jSONObject.optInt("bav_monitor_rate", 0);
        if (iOptInt2 > 0 && iOptInt2 <= 100) {
            editorEdit.putInt("bav_monitor_rate", iOptInt2);
            com.byazt.yv.sp.c(true);
        } else {
            editorEdit.remove("bav_monitor_rate");
            com.byazt.yv.sp.c(false);
        }
        editorEdit.putLong("app_log_last_config_time", jCurrentTimeMillis);
        editorEdit.apply();
    }

    public long x() {
        return this.n.getLong("app_log_last_config_time", 0L);
    }

    public int i() {
        return this.n.getInt("bav_monitor_rate", 0);
    }

    public String da() {
        return this.tt.ve();
    }

    public String sl() {
        return this.tt.uj();
    }

    public String t() {
        return this.tt.n();
    }

    public String u() {
        return this.tt.a();
    }

    public void tt(JSONObject jSONObject) {
        this.ve.edit().putString("header_custom_info", jSONObject != null ? jSONObject.toString() : "").apply();
    }

    public String yp() {
        return this.ve.getString("header_custom_info", null);
    }

    public String z() {
        return this.ve.getString("ab_sdk_version", "");
    }

    public String m() {
        return this.ve.getString("user_unique_id", null);
    }

    public boolean nu() {
        if (this.tt.x() == 0) {
            String strC = com.byazt.yv.u.c(this.c);
            if (!TextUtils.isEmpty(strC)) {
                this.tt.c(strC.contains(com.huawei.openalliance.ad.constant.x.bQ) ? 2 : 1);
            } else {
                this.tt.c(0);
            }
        }
        return this.tt.x() == 1;
    }

    public long rh() {
        return this.n.getLong("abtest_fetch_interval", 0L);
    }

    public void ve(JSONObject jSONObject) {
        com.byazt.yv.da.c("setAbConfig, " + jSONObject.toString(), null);
        this.ve.edit().putString("ab_configure", jSONObject.toString()).apply();
        this.f2116a = null;
    }

    public String my() {
        if (!TextUtils.isEmpty(this.tt.my())) {
            return this.tt.my();
        }
        return this.ve.getString("ab_version", null);
    }

    public JSONObject gt() {
        JSONObject jSONObject = this.f2116a;
        if (jSONObject == null) {
            synchronized (this) {
                try {
                    if (rl()) {
                        jSONObject = new JSONObject(this.ve.getString("ab_configure", ""));
                    }
                } catch (JSONException unused) {
                }
                if (jSONObject == null) {
                    jSONObject = new JSONObject();
                }
                this.f2116a = jSONObject;
            }
        }
        return jSONObject;
    }

    public boolean rl() {
        return this.n.getBoolean("bav_ab_config", false);
    }

    public boolean qy() {
        return this.n.getBoolean("bav_log_collect", false);
    }

    public long gu() {
        return this.n.getLong("session_interval", 30000L);
    }

    public long gr() {
        return this.n.getLong("batch_event_interval", 30000L);
    }

    public String yv() {
        return this.tt.c();
    }

    public String p() {
        return this.n.getString(b.b, null);
    }

    public String md() {
        return this.tt.sl();
    }

    public int h() {
        return this.tt.yp();
    }

    public int d() {
        return this.tt.z();
    }

    public int eo() {
        return this.tt.m();
    }

    public String zb() {
        return this.tt.t();
    }

    public String or() {
        return this.tt.u();
    }

    public String cu() {
        return this.tt.rh();
    }

    public String qp() {
        return this.tt.gt();
    }

    public String nb() {
        return this.tt.rl();
    }

    public String pf() {
        return this.tt.qy();
    }

    public String bx() {
        return this.tt.h() == null ? "" : this.tt.h();
    }

    public String sv() {
        return this.tt.d() == null ? "" : this.tt.d();
    }

    public boolean aw() {
        return this.tt.zm();
    }

    public boolean ic() {
        return this.tt.yv();
    }

    public String hd() {
        return this.tt.md();
    }

    public CharSequence lr() {
        return this.tt.gu();
    }
}
