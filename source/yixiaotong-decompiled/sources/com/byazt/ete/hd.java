package com.byazt.ete;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.huawei.openalliance.ad.constant.bf;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 8, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_TOTAL_CACHED_LEN})
public class hd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f2176a;
    public ic c;
    public int da = 0;
    public int i;
    public int n;
    public long sp;
    public int tt;
    public int uj;
    public int ve;
    public long x;

    public void c(int i) {
        this.tt = i;
    }

    public void tt(int i) {
        this.ve = i;
        if (i == 2) {
            this.n++;
        }
    }

    public void ve(int i) {
        this.uj = i;
    }

    public hd(ic icVar) {
        this.c = icVar;
    }

    public hd(ic icVar, JSONObject jSONObject) {
        this.c = icVar;
        if (jSONObject != null) {
            this.tt = jSONObject.optInt("req_type", 0);
            this.ve = jSONObject.optInt(com.hihonor.adsdk.base.g.j.e.a.hnadsd, 0);
            this.uj = jSONObject.optInt(bf.aW, 0);
            this.n = jSONObject.optInt("reuse_count", 0);
            this.f2176a = jSONObject.optLong("object_create_time", 0L);
            this.sp = jSONObject.optLong(com.hihonor.adsdk.base.g.j.e.a.U0, 0L);
            this.x = jSONObject.optLong("final_ts", 0L);
            this.i = jSONObject.optInt("final_status", 0);
        }
    }

    public void c(JSONObject jSONObject, boolean z) {
        int iValueOf;
        int iValueOf2;
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("ca_send_ts", this.c.xg());
            jSONObject.put("ca_bid_rst", this.uj);
            jSONObject.put("ca_reuse_cnt", this.n);
            jSONObject.put("ca_obj_ts", this.f2176a);
            jSONObject.put("ca_fnl_st", this.i);
            jSONObject.put("ca_rpt_show_cnt", this.da);
            jSONObject.put("ca_libra_group", x.c(com.byazt.aas.nb.sl(this.c)).u());
            jSONObject.put("ca_ad_index", this.c.fq());
            if (z) {
                String str = this.c.qy() + this.c.uj();
                Integer numRemove = com.byazt.vvt.c.tt().remove(str);
                if (numRemove == null) {
                    iValueOf = 1;
                } else {
                    iValueOf = Integer.valueOf(numRemove.intValue() + 1);
                }
                com.byazt.vvt.c.tt().put(str, iValueOf);
                jSONObject.put("meta_show_count", iValueOf);
                String str2 = com.byazt.aas.nb.u(this.c) + this.c.uj();
                Integer numRemove2 = com.byazt.vvt.c.ve().remove(str2);
                if (numRemove2 == null) {
                    iValueOf2 = 1;
                } else {
                    iValueOf2 = Integer.valueOf(numRemove2.intValue() + 1);
                }
                com.byazt.vvt.c.ve().put(str2, iValueOf2);
                jSONObject.put("meta_origin_show_count", iValueOf2);
                com.byazt.vvt.ve.c(this.c);
                JSONObject jSONObjectC = com.byazt.vvt.ve.c(com.byazt.aas.nb.sl(this.c), this.c.jl());
                if (jSONObjectC != null) {
                    try {
                        JSONObject jSONObject2 = new JSONObject(jSONObjectC.toString());
                        int iSl = com.byazt.aas.nb.sl(this.c);
                        x.ve veVarC = x.c(iSl);
                        x.n nVarNu = veVarC != null ? veVarC.nu() : null;
                        if (nVarNu != null && nVarNu.tt() && nVarNu.ve() > 0) {
                            com.byazt.dj.tt ttVarIj = this.c.ij();
                            long jC = com.byazt.wi.tt.c().c(iSl, ttVarIj != null ? ttVarIj.uj() : null);
                            if (jC > 0) {
                                jSONObject2.put("dynamic_tmax", jC);
                            }
                            jSONObject2.put("dynamic_tmax_type", nVarNu.n());
                        }
                        jSONObjectC = jSONObject2;
                    } catch (Throwable unused) {
                    }
                    jSONObject.put("ca_interval_info", jSONObjectC);
                }
            }
        } catch (JSONException unused2) {
        }
    }

    public JSONObject c() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("req_type", this.tt);
            jSONObject.put(com.hihonor.adsdk.base.g.j.e.a.hnadsd, this.ve);
            jSONObject.put(bf.aW, this.uj);
            jSONObject.put("reuse_count", this.n);
            jSONObject.put("object_create_time", this.f2176a);
            jSONObject.put(com.hihonor.adsdk.base.g.j.e.a.U0, this.sp);
            jSONObject.put("final_ts", this.x);
            jSONObject.put("final_status", this.i);
            jSONObject.put("show_count", this.da);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public void tt() {
        this.f2176a = System.currentTimeMillis();
    }

    public void ve() {
        this.sp = System.currentTimeMillis();
        this.da++;
        uj(1);
    }

    public void uj(int i) {
        this.i = i;
        this.x = System.currentTimeMillis();
    }
}
