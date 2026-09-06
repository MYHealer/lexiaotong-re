package com.byazt.ng;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.alipay.sdk.tid.b;
import com.byazt.nys.PluginConstants;
import com.byazt.vx.eo;
import com.byazt.vx.qy;
import com.byazt.vx.rl;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.ubixnow.ooooo.o0OO000o;
import com.umeng.analytics.pro.am;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SEEK_INTERRUPT, 20})
public class c implements com.byazt.fo.tt {
    public static final String ve = UUID.randomUUID().toString();
    public final String c;
    public final JSONObject tt;

    @Override // com.byazt.fo.tt
    public JSONObject c(String str) {
        return this.tt;
    }

    public c(String str, JSONObject jSONObject) {
        this.c = str;
        this.tt = jSONObject;
    }

    @Override // com.byazt.fo.tt
    public long c() {
        JSONObject jSONObject = this.tt;
        if (jSONObject != null) {
            JSONObject jSONObjectOptJSONObject = jSONObject.has("params") ? this.tt.optJSONObject("params") : this.tt;
            if (jSONObjectOptJSONObject != null) {
                return jSONObjectOptJSONObject.optLong(b.f);
            }
        }
        return 0L;
    }

    @Override // com.byazt.fo.tt
    public long tt() {
        JSONObject jSONObject = this.tt;
        if (jSONObject != null) {
            JSONObject jSONObjectOptJSONObject = jSONObject.has("params") ? this.tt.optJSONObject("params") : this.tt;
            if (jSONObjectOptJSONObject != null) {
                String strOptString = jSONObjectOptJSONObject.optString("event_extra");
                if (!TextUtils.isEmpty(strOptString)) {
                    try {
                        return new JSONObject(strOptString).optLong("eventIndex");
                    } catch (JSONException unused) {
                    }
                }
            }
        }
        return 0L;
    }

    public static JSONObject c(uj ujVar, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.putOpt("device_info", rl.c());
            if (ujVar != null) {
                jSONObject2.putOpt("type", ujVar.c);
                jSONObject2.putOpt("link_id", ujVar.tt);
                jSONObject2.putOpt(MediationConstant.EXTRA_ADN_NAME, ujVar.ve);
                jSONObject2.putOpt("ad_sdk_version", ujVar.uj);
                jSONObject2.putOpt("rit_cpm", ujVar.sp);
                if (!TextUtils.isEmpty(ujVar.x)) {
                    jSONObject2.putOpt("discount", ujVar.x);
                }
                jSONObject2.putOpt("mediation_rit", ujVar.f2514a);
                jSONObject2.putOpt("adtype", Integer.valueOf(ujVar.rh));
                jSONObject2.putOpt(com.hihonor.adsdk.base.g.j.e.a.hnadst, ujVar.t);
                jSONObject2.putOpt("error_code", Integer.valueOf(ujVar.z));
                jSONObject2.putOpt("creative_id", ujVar.u);
                jSONObject2.putOpt("exchange_rate", ujVar.qy);
                jSONObject2.putOpt("msdk_session_id", ve);
                jSONObject2.putOpt("is_trusteeship_monetize", Integer.valueOf(com.byazt.bp.tt.tt().tt()));
                String strTt = com.byazt.vq.c.c().tt(com.byazt.bp.tt.tt().nu());
                if (strTt != null) {
                    jSONObject2.putOpt("app_abtest", strTt);
                }
                c(jSONObject2, ujVar);
                ve(jSONObject2, ujVar);
                tt(ujVar, jSONObject);
                if (!"total_load_fail".equalsIgnoreCase(ujVar.c) && !"adapter_request_fail".equalsIgnoreCase(ujVar.c)) {
                    jSONObject2.putOpt("req_id", TextUtils.isEmpty(ujVar.n) ? ujVar.tt + "_" + ujVar.f2514a : ujVar.n);
                }
                jSONObject2.putOpt(am.O, com.byazt.bp.tt.tt().t());
                com.byazt.nbs.c cVarC = com.byazt.bp.tt.tt().c(MediationConstant.ADN_PANGLE);
                if (cVarC != null) {
                    jSONObject2.putOpt("app_id", cVarC.tt());
                } else {
                    jSONObject2.putOpt("app_id", com.byazt.bp.c.t().u());
                }
                if (ujVar.da != 0) {
                    jSONObject2.putOpt("waterfall_id", Long.valueOf(ujVar.da));
                }
                if (!TextUtils.isEmpty(ujVar.sl)) {
                    jSONObject2.putOpt("version", ujVar.sl);
                }
                if (ujVar.gu != null && ujVar.gu.size() > 0) {
                    for (String str : ujVar.gu.keySet()) {
                        Object obj = ujVar.gu.get(str);
                        if (!TextUtils.isEmpty(str) && obj != null) {
                            jSONObject2.putOpt(str, obj);
                        }
                    }
                }
            }
            if (jSONObject != null) {
                String strTt2 = com.byazt.vq.c.c().tt(com.byazt.bp.tt.tt().rh());
                if (strTt2 != null) {
                    jSONObject.putOpt("simple_app_abtest", strTt2);
                }
                jSONObject.putOpt("has_server_cache_config", Boolean.valueOf(com.byazt.bp.tt.tt().my()));
            }
            jSONObject2.putOpt("event_extra", jSONObject != null ? jSONObject.toString() : null);
            jSONObject2.putOpt("app_version", eo.ve());
            jSONObject2.putOpt("conn_type", Integer.valueOf(qy.tt()));
            tt(jSONObject2, ujVar);
            jSONObject2.putOpt("mediation_sdk_version", com.byazt.yl.tt.tt());
            jSONObject2.putOpt(PluginConstants.KEY_PLUGIN_VERSION, com.byazt.yl.tt.uj());
            try {
                jSONObject2.put("device_score", Double.parseDouble(com.byazt.whk.c.c().c("DeviceRate", "bytebench_value", com.byazt.vxy.c.uj())));
            } catch (NumberFormatException unused) {
                jSONObject2.put("device_score", -1);
            }
        } catch (Throwable th) {
            try {
                c(jSONObject2, th, ujVar);
            } catch (Throwable unused2) {
            }
        }
        return jSONObject2;
    }

    private static void c(JSONObject jSONObject, uj ujVar) throws JSONException {
        if (jSONObject == null || ujVar == null) {
            return;
        }
        if (ujVar.gt != -1) {
            jSONObject.putOpt("result", Integer.valueOf(ujVar.gt));
        }
        if (ujVar.rl != -1) {
            jSONObject.putOpt(o0OO000o.o000o0oo, Integer.valueOf(ujVar.rl));
        }
        if (ujVar.nu != null) {
            jSONObject.putOpt("show_sort", ujVar.nu);
        }
        if (ujVar.m != null) {
            jSONObject.putOpt("load_sort", ujVar.m);
        }
        if (ujVar.yp != null) {
            jSONObject.putOpt("req_bidding_type", ujVar.yp);
        }
        jSONObject.putOpt(MediationConstant.KEY_GM_PRIME_RIT, ujVar.i);
    }

    private static void tt(JSONObject jSONObject, uj ujVar) throws JSONException {
        if (jSONObject != null && ujVar != null) {
            if (TextUtils.equals(ujVar.c, "sdk_init")) {
                jSONObject.putOpt(b.f, Long.valueOf(com.byazt.yf.da.tt()));
                return;
            }
            if (TextUtils.equals(ujVar.c, "start_up")) {
                jSONObject.putOpt(b.f, Long.valueOf(com.byazt.yf.da.ve()));
                return;
            } else if (ujVar.c() != -1) {
                jSONObject.putOpt(b.f, Long.valueOf(ujVar.c()));
                return;
            } else {
                jSONObject.putOpt(b.f, Long.valueOf(System.currentTimeMillis()));
                return;
            }
        }
        jSONObject.putOpt(b.f, Long.valueOf(System.currentTimeMillis()));
    }

    private static void tt(uj ujVar, JSONObject jSONObject) {
        if (ujVar != null) {
            if ("media_request".equals(ujVar.c) || "media_fill".equals(ujVar.c) || "media_fill_fail".equals(ujVar.c) || "get_bidding_adm_to_adn".equals(ujVar.c) || "bidding_adm_load".equals(ujVar.c) || "bidding_adm_load_fail".equals(ujVar.c) || "bidding_win_event".equals(ujVar.c) || "media_show_is_ready".equals(ujVar.c) || "media_will_show".equals(ujVar.c) || "media_show".equals(ujVar.c) || "media_show_fail".equals(ujVar.c) || "media_show_listen".equals(ujVar.c) || "media_show_fail_listen".equals(ujVar.c) || "media_click_listen".equals(ujVar.c) || "sdk_init".equals(ujVar.c) || "sdk_init_end".equals(ujVar.c) || "get_config_start".equals(ujVar.c) || "get_config_final".equals(ujVar.c) || "mediation_request".equals(ujVar.c) || "mediation_fill".equals(ujVar.c) || "mediation_request_end".equals(ujVar.c) || "total_load_fail".equals(ujVar.c)) {
                ujVar.c("grouping_params", com.byazt.qe.tt.c(com.byazt.bp.c.t().rl()));
                JSONObject jSONObjectTt = com.byazt.qe.tt.tt(com.byazt.bp.c.t().rl());
                if (jSONObjectTt != null) {
                    ujVar.c("user_defined_grouping_params", jSONObjectTt.toString());
                } else {
                    ujVar.c("user_defined_grouping_params", null);
                }
                com.byazt.psp.uj.c(ujVar.i, ujVar.c, ujVar.rh, jSONObject);
            }
        }
    }

    private static void ve(JSONObject jSONObject, uj ujVar) throws JSONException {
        if (jSONObject == null || ujVar == null) {
            return;
        }
        if ("media_fill_fail".equals(ujVar.c) || "media_fill".equals(ujVar.c) || "bidding_adm_load".equals(ujVar.c) || "bidding_adm_load_fail".equals(ujVar.c) || "mediation_fill".equals(ujVar.c) || "mediation_request_end".equals(ujVar.c) || "mediation_video_cached".equals(ujVar.c) || "get_config_final".equals(ujVar.c) || "sdk_init_end".equals(ujVar.c) || "sdk_backstage".equals(ujVar.c) || "mediation_request".equals(ujVar.c) || "rit_map_query".equals(ujVar.c) || "return_bidding_result".equals(ujVar.c)) {
            jSONObject.putOpt("duration", Long.valueOf(ujVar.my));
        }
    }

    private static void c(JSONObject jSONObject, Throwable th, uj ujVar) throws JSONException {
        if (jSONObject != null && th != null) {
            String strOptString = jSONObject.optString("event_extra");
            if (!TextUtils.isEmpty(strOptString)) {
                JSONObject jSONObject2 = new JSONObject(strOptString);
                jSONObject2.putOpt("err_msg_comm", th.toString());
                jSONObject.putOpt("event_extra", jSONObject2.toString());
            }
        }
        if (ujVar == null || th == null) {
            return;
        }
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.putOpt("comm_eventId", ujVar.gu.get(com.hihonor.adsdk.base.g.j.e.a.v));
        jSONObject3.putOpt("err_msg_comm", th.toString());
    }

    public String ve() {
        if (TextUtils.isEmpty(this.c) || this.tt == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("localId", this.c);
            jSONObject.putOpt(NotificationCompat.CATEGORY_EVENT, this.tt);
        } catch (Throwable unused) {
        }
        return jSONObject.toString();
    }

    public String toString() {
        return "AdEvent{localId='" + this.c + "', event=" + this.tt + '}';
    }
}
