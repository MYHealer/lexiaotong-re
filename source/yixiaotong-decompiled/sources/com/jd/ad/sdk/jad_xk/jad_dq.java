package com.jd.ad.sdk.jad_xk;

import android.text.TextUtils;
import com.alipay.sdk.sys.a;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.byazt.hs.sl;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import com.cdo.oaps.ad.Launcher;
import com.cdo.oaps.ad.OapsKey;
import com.jd.ad.sdk.dl.common.CommonConstants;
import com.jd.ad.sdk.fdt.utils.JsonUtils;
import com.jd.ad.sdk.logger.Logger;
import com.kuaishou.weapon.p0.t;
import com.umeng.analytics.pro.am;
import com.yfanads.android.utils.YFAdsConst;
import java.io.Serializable;
import org.json.JSONObject;

/* JADX INFO: compiled from: Event.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_dq implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f4589a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public int i;
    public int j;
    public String jad_ad;
    public int jad_al;
    public int jad_an;
    public String jad_be;
    public String jad_bm;
    public int jad_bo;
    public String jad_cf;
    public int jad_cn;
    public String jad_cp;
    public String jad_dg;
    public int jad_do;
    public String jad_dq;
    public String jad_eh;
    public int jad_en;
    public String jad_ep;
    public String jad_er;
    public String jad_fi;
    public int jad_fo;
    public String jad_fq;
    public String jad_fs;
    public String jad_gj;
    public int jad_gp;
    public String jad_gr;
    public String jad_hj;
    public String jad_hk;
    public int jad_hq;
    public int jad_hs;
    public int jad_hu;
    public String jad_ik;
    public String jad_il;
    public int jad_ir;
    public int jad_it;
    public int jad_iv;
    public String jad_jl;
    public String jad_jm;
    public int jad_js;
    public int jad_jt;
    public int jad_ju;
    public String jad_jw;
    public String jad_km;
    public int jad_kn;
    public int jad_kt;
    public int jad_kv;
    public int jad_kx;
    public String jad_lo;
    public int jad_lu;
    public int jad_lw;
    public String jad_ly;
    public int jad_mp;
    public int jad_mv;
    public int jad_mx;
    public String jad_mz;
    public String jad_na;
    public int jad_nq;
    public int jad_nw;
    public com.jd.ad.sdk.dl.model.jad_an jad_ny;
    public String jad_ob;
    public int jad_or;
    public int jad_ox;
    public int jad_oz;
    public int jad_pa;
    public String jad_pc;
    public int jad_ps;
    public int jad_py;
    public int jad_qb;
    public String jad_qd;
    public String jad_qt;
    public int jad_qz;
    public int jad_ra;
    public int jad_rc;
    public String jad_re;
    public double jad_ru;
    public String jad_sb;
    public String jad_sd;
    public jad_jw jad_sf;
    public int jad_sv;
    public String jad_tc;
    public int jad_te;
    public String jad_tg;
    public double jad_tw;
    public int jad_ud;
    public int jad_uf;
    public String jad_uh;
    public int jad_ux;
    public String jad_ve;
    public int jad_vg;
    public int jad_vi;
    public String jad_vy;
    public int jad_wf;
    public int jad_wh;
    public int jad_wj;
    public String jad_wz;
    public String jad_xa;
    public int jad_xg;
    public String jad_xi;
    public int jad_xk;
    public String jad_yb;
    public int jad_yh;
    public int jad_yj;
    public int jad_yl;
    public String jad_zc;
    public int jad_zi;
    public int jad_zk;
    public int jad_zm;
    public String k;
    public String l;
    public String m;
    public String n;
    public String o;
    public String p;
    public String q;
    public String r;
    public int s;

    public jad_dq(int i, String str) {
        this(i, new JSONObject(str));
    }

    public final void jad_an(JSONObject jSONObject) {
        try {
            int iOptInt = jSONObject.optInt(OapsKey.KEY_TYPE);
            this.jad_bo = iOptInt;
            if (iOptInt == 1) {
                this.jad_cp = jSONObject.optString("adrid");
                this.jad_fs = jSONObject.optString("pid");
                this.jad_jt = jSONObject.optInt("pfid");
                this.jad_hu = jSONObject.optInt(OapsKey.KEY_ADAPTER_TYPE);
                this.jad_wh = jSONObject.optInt("sen");
                this.jad_iv = jSONObject.optInt("tpid");
                this.jad_zk = jSONObject.optInt("plwd");
                this.jad_al = jSONObject.optInt("plht");
                this.jad_lw = jSONObject.optInt("rem");
                this.jad_lu = jSONObject.optInt("tcbr");
                this.jad_yh = jSONObject.optInt("dstp");
                this.jad_zi = jSONObject.optInt("srtp");
                this.jad_ps = jSONObject.optInt("ipl");
                this.jad_ru = jSONObject.optDouble("toti", 0.0d);
            }
            if (this.jad_bo == 2) {
                this.jad_cp = jSONObject.optString("adrid");
                this.jad_fs = jSONObject.optString("pid");
                this.jad_jt = jSONObject.optInt("pfid");
                this.jad_hu = jSONObject.optInt(OapsKey.KEY_ADAPTER_TYPE);
                this.jad_iv = jSONObject.optInt("tpid");
                this.jad_wh = jSONObject.optInt("sen");
                this.jad_lw = jSONObject.optInt("rem");
                this.jad_fo = jSONObject.optInt("sddu");
                this.jad_mv = jSONObject.optInt("alct");
                this.jad_nw = jSONObject.optInt("jdad");
                this.jad_ox = jSONObject.optInt("adat");
                this.jad_wf = jSONObject.optInt("catp");
                this.jad_xg = jSONObject.optInt("msst");
                this.jad_yh = jSONObject.optInt("dstp");
                this.jad_zi = jSONObject.optInt("srtp");
                this.jad_ps = jSONObject.optInt("ipl");
            }
            String str = r7;
            String str2 = "srtp";
            if (this.jad_bo == 3) {
                this.jad_cp = jSONObject.optString("adrid");
                this.jad_fs = jSONObject.optString("pid");
                this.jad_jt = jSONObject.optInt("pfid");
                this.jad_hu = jSONObject.optInt(OapsKey.KEY_ADAPTER_TYPE);
                this.jad_er = jSONObject.optString("exid");
                this.jad_iv = jSONObject.optInt("tpid");
                this.jad_wh = jSONObject.optInt("sen");
                this.jad_lw = jSONObject.optInt("rem");
                this.jad_mx = jSONObject.optInt("imm");
                this.jad_gp = jSONObject.optInt("sedu");
                this.jad_hq = jSONObject.optInt("dedu");
                this.jad_qz = jSONObject.optInt("sspt");
                this.jad_ra = jSONObject.optInt("scav");
                this.jad_ox = jSONObject.optInt("adat");
                this.jad_wf = jSONObject.optInt("catp");
                this.jad_yh = jSONObject.optInt("dstp");
                this.jad_zi = jSONObject.optInt(str2);
                str2 = str2;
                this.jad_ps = jSONObject.optInt(str);
                str = str;
                this.jad_ny = new com.jd.ad.sdk.dl.model.jad_an(jSONObject.optJSONObject("cons"));
            }
            if (this.jad_bo == 4) {
                this.jad_cp = jSONObject.optString("adrid");
                this.jad_fs = jSONObject.optString("pid");
                this.jad_jt = jSONObject.optInt("pfid");
                this.jad_hu = jSONObject.optInt(OapsKey.KEY_ADAPTER_TYPE);
                this.jad_jw = jSONObject.optString("clid");
                this.jad_iv = jSONObject.optInt("tpid");
                this.jad_kx = jSONObject.optInt("clf");
                this.jad_wh = jSONObject.optInt("sen");
                this.jad_lw = jSONObject.optInt("rem");
                this.jad_en = jSONObject.optInt("dety");
                this.jad_ir = jSONObject.optInt("scdu");
                this.jad_js = jSONObject.optInt("dcdu");
                this.jad_kt = jSONObject.optInt("ecdu");
                this.jad_qz = jSONObject.optInt("sspt");
                this.jad_ra = jSONObject.optInt("scav");
                this.jad_ox = jSONObject.optInt("adat");
                this.jad_py = jSONObject.optInt("atst");
                this.jad_wf = jSONObject.optInt("catp");
                this.jad_yh = jSONObject.optInt("dstp");
                this.jad_zi = jSONObject.optInt(str2);
                this.jad_ps = jSONObject.optInt(str);
                this.jad_sv = jSONObject.optInt("vpst");
                this.jad_tw = jSONObject.optDouble("vpdt", 0.0d);
                if (this.jad_kx == CommonConstants.ClickFrom.AD.ordinal()) {
                    this.jad_ux = jSONObject.optInt("sims");
                    this.jad_vy = jSONObject.optString("ifp");
                    this.jad_wz = jSONObject.optString("ip");
                    this.jad_xa = jSONObject.optString("vpc");
                    this.jad_yb = jSONObject.optString("abi");
                    this.jad_hs = jSONObject.optInt("jbr");
                    this.jad_zc = jSONObject.optString("vir");
                    this.jad_ad = jSONObject.optString(t.q);
                    this.jad_be = jSONObject.optString("lau");
                    this.jad_cf = jSONObject.optString("awa");
                    this.jad_dg = jSONObject.optString("moce");
                    this.jad_eh = jSONObject.optString("malrun");
                    this.jad_fi = jSONObject.optString("appct");
                    this.jad_hj = jSONObject.optString(YFAdsConst.LP);
                    this.jad_ik = jSONObject.optString("pip");
                    this.jad_jl = jSONObject.optString("qem");
                    this.jad_km = jSONObject.optString("dne");
                    this.f4589a = jSONObject.optString("bra");
                    this.b = jSONObject.optString("bri");
                    this.c = jSONObject.optString("pro");
                    this.d = jSONObject.optString("bat");
                    this.e = jSONObject.optString("hoo");
                    this.f = jSONObject.optString("open");
                    this.g = jSONObject.optString("dbg");
                    this.h = jSONObject.optString("cpty");
                    this.i = jSONObject.optInt("phsc");
                    this.j = jSONObject.optInt("rebl");
                    this.k = jSONObject.optString("hdwa");
                    this.l = jSONObject.optString("osut");
                    this.m = jSONObject.optString("hwml");
                    this.n = jSONObject.optString("sysm");
                    this.o = jSONObject.optString("sysd");
                    this.p = jSONObject.optString("frds");
                    this.q = jSONObject.optString("board");
                    this.r = jSONObject.optString("cpfq");
                    this.s = jSONObject.optInt("plug");
                }
            }
            if (this.jad_bo == 5) {
                this.jad_qb = jSONObject.optInt("extp");
                this.jad_rc = jSONObject.optInt("ercd");
                String strOptString = jSONObject.optString("erin");
                this.jad_sd = strOptString;
                if (!TextUtils.isEmpty(strOptString) && this.jad_an > 0 && !this.jad_sd.startsWith("###")) {
                    this.jad_sd = "###" + this.jad_an + "_" + this.jad_sd;
                }
                this.jad_bm = jSONObject.optString("rid");
                this.jad_wh = jSONObject.optInt("sen");
                this.jad_pa = jSONObject.optInt("crt");
            }
            if (this.jad_bo == 6) {
                this.jad_xi = jSONObject.optString("iid");
                this.jad_yj = jSONObject.optInt("init");
                this.jad_oz = jSONObject.optInt("idu");
            }
            this.jad_ly = jSONObject.optString("ts");
            this.jad_mz = jSONObject.optString(am.x);
            this.jad_na = jSONObject.optString("osv");
            this.jad_ob = jSONObject.optString("did");
            this.jad_qd = jSONObject.optString("bi");
            this.jad_pc = jSONObject.optString("oid");
            this.jad_re = jSONObject.optString(a.h);
            this.jad_sf = new jad_jw(jSONObject.optJSONObject(com.hihonor.adsdk.base.g.j.e.a.H0));
            this.jad_te = jSONObject.optInt("swd");
            this.jad_uf = jSONObject.optInt("sht");
            this.jad_vg = jSONObject.optInt("ct");
            this.jad_tg = jSONObject.optString(Launcher.Host.MK);
            this.jad_uh = jSONObject.optString(LiveConfigKey.MEDIUM);
            this.jad_vi = jSONObject.optInt("svb");
            this.jad_wj = jSONObject.optInt("jdi");
            this.jad_xk = jSONObject.optInt("qqi");
            this.jad_yl = jSONObject.optInt("wci");
            this.jad_zm = jSONObject.optInt("tbi");
            this.jad_cn = jSONObject.optInt("tmi");
            this.jad_do = jSONObject.optInt("pddi");
            this.jad_ep = jSONObject.optString("tz");
            this.jad_fq = jSONObject.optString(a.i);
            this.jad_gr = jSONObject.optString("asv");
            this.jad_dq = jSONObject.optString(IAdInterListener.AdReqParam.APID);
            this.jad_hs = jSONObject.optInt("jbr");
            this.jad_it = jSONObject.optInt("af");
            this.jad_ju = jSONObject.optInt("atsv");
            this.jad_kv = jSONObject.optInt("ihrd");
            this.jad_sb = jSONObject.optString("pn");
            this.jad_tc = jSONObject.optString("sc");
            this.jad_ud = jSONObject.optInt("hos");
            this.jad_ve = jSONObject.optString("hosv");
            this.jad_gj = jSONObject.optString("sav");
            this.jad_hk = jSONObject.optString("mt");
            this.jad_il = jSONObject.optString("hwv");
            this.jad_jm = jSONObject.optString("ca");
            this.jad_kn = jSONObject.optInt("ppi");
            this.jad_lo = jSONObject.optString("cc");
            this.jad_mp = jSONObject.optInt("sof");
            this.jad_nq = jSONObject.optInt(sl.c);
            this.jad_or = jSONObject.optInt("em");
            this.jad_qt = jSONObject.optString("soaid");
        } catch (Exception e) {
            Logger.w("parse event from json ", e.getMessage());
        }
    }

    public String toString() {
        return jad_an().toString();
    }

    public jad_dq(int i, JSONObject jSONObject) {
        this.jad_oz = 0;
        this.jad_pa = 0;
        if (jSONObject == null) {
            return;
        }
        this.jad_an = i;
        jad_an(jSONObject);
    }

    public JSONObject jad_an() {
        String str;
        String str2;
        String str3;
        String str4;
        JSONObject jSONObject = new JSONObject();
        try {
            JsonUtils.put(jSONObject, OapsKey.KEY_TYPE, Integer.valueOf(this.jad_bo));
            if (this.jad_bo == 1) {
                JsonUtils.put(jSONObject, "adrid", this.jad_cp);
                JsonUtils.put(jSONObject, "pid", this.jad_fs);
                JsonUtils.put(jSONObject, "pfid", Integer.valueOf(this.jad_jt));
                JsonUtils.put(jSONObject, OapsKey.KEY_ADAPTER_TYPE, Integer.valueOf(this.jad_hu));
                JsonUtils.put(jSONObject, "tpid", Integer.valueOf(this.jad_iv));
                JsonUtils.put(jSONObject, "plwd", Integer.valueOf(this.jad_zk));
                JsonUtils.put(jSONObject, "plht", Integer.valueOf(this.jad_al));
                JsonUtils.put(jSONObject, "sen", Integer.valueOf(this.jad_wh));
                JsonUtils.put(jSONObject, "rem", Integer.valueOf(this.jad_lw));
                JsonUtils.put(jSONObject, "tcbr", Integer.valueOf(this.jad_lu));
                JsonUtils.put(jSONObject, "dstp", Integer.valueOf(this.jad_yh));
                JsonUtils.put(jSONObject, "srtp", Integer.valueOf(this.jad_zi));
                JsonUtils.put(jSONObject, "ipl", Integer.valueOf(this.jad_ps));
                JsonUtils.put(jSONObject, "toti", Double.valueOf(this.jad_ru));
            }
            if (this.jad_bo == 2) {
                JsonUtils.put(jSONObject, "adrid", this.jad_cp);
                JsonUtils.put(jSONObject, "pid", this.jad_fs);
                JsonUtils.put(jSONObject, "pfid", Integer.valueOf(this.jad_jt));
                JsonUtils.put(jSONObject, OapsKey.KEY_ADAPTER_TYPE, Integer.valueOf(this.jad_hu));
                JsonUtils.put(jSONObject, "tpid", Integer.valueOf(this.jad_iv));
                JsonUtils.put(jSONObject, "sen", Integer.valueOf(this.jad_wh));
                JsonUtils.put(jSONObject, "rem", Integer.valueOf(this.jad_lw));
                JsonUtils.put(jSONObject, "sddu", Integer.valueOf(this.jad_fo));
                JsonUtils.put(jSONObject, "alct", Integer.valueOf(this.jad_mv));
                JsonUtils.put(jSONObject, "jdad", Integer.valueOf(this.jad_nw));
                JsonUtils.put(jSONObject, "adat", Integer.valueOf(this.jad_ox));
                JsonUtils.put(jSONObject, "catp", Integer.valueOf(this.jad_wf));
                JsonUtils.put(jSONObject, "msst", Integer.valueOf(this.jad_xg));
                JsonUtils.put(jSONObject, "dstp", Integer.valueOf(this.jad_yh));
                JsonUtils.put(jSONObject, "srtp", Integer.valueOf(this.jad_zi));
                str = "ipl";
                JsonUtils.put(jSONObject, str, Integer.valueOf(this.jad_ps));
            } else {
                str = "ipl";
            }
            String str5 = "dstp";
            if (this.jad_bo == 3) {
                JsonUtils.put(jSONObject, "adrid", this.jad_cp);
                JsonUtils.put(jSONObject, "pid", this.jad_fs);
                JsonUtils.put(jSONObject, "pfid", Integer.valueOf(this.jad_jt));
                JsonUtils.put(jSONObject, OapsKey.KEY_ADAPTER_TYPE, Integer.valueOf(this.jad_hu));
                JsonUtils.put(jSONObject, "exid", this.jad_er);
                JsonUtils.put(jSONObject, "tpid", Integer.valueOf(this.jad_iv));
                JsonUtils.put(jSONObject, "sen", Integer.valueOf(this.jad_wh));
                JsonUtils.put(jSONObject, "rem", Integer.valueOf(this.jad_lw));
                JsonUtils.put(jSONObject, "imm", Integer.valueOf(this.jad_mx));
                JsonUtils.put(jSONObject, "sedu", Integer.valueOf(this.jad_gp));
                JsonUtils.put(jSONObject, "dedu", Integer.valueOf(this.jad_hq));
                JsonUtils.put(jSONObject, "sspt", Integer.valueOf(this.jad_qz));
                JsonUtils.put(jSONObject, "scav", Integer.valueOf(this.jad_ra));
                JsonUtils.put(jSONObject, "adat", Integer.valueOf(this.jad_ox));
                JsonUtils.put(jSONObject, str, Integer.valueOf(this.jad_ps));
                JsonUtils.put(jSONObject, "cons", this.jad_ny.jad_an());
                str2 = "catp";
                JsonUtils.put(jSONObject, str2, Integer.valueOf(this.jad_wf));
                JsonUtils.put(jSONObject, str5, Integer.valueOf(this.jad_yh));
                str5 = str5;
                str3 = "srtp";
                JsonUtils.put(jSONObject, str3, Integer.valueOf(this.jad_zi));
            } else {
                str2 = "catp";
                str3 = "srtp";
            }
            String str6 = str3;
            String str7 = str2;
            if (this.jad_bo == 4) {
                JsonUtils.put(jSONObject, "adrid", this.jad_cp);
                JsonUtils.put(jSONObject, "pid", this.jad_fs);
                JsonUtils.put(jSONObject, "pfid", Integer.valueOf(this.jad_jt));
                JsonUtils.put(jSONObject, OapsKey.KEY_ADAPTER_TYPE, Integer.valueOf(this.jad_hu));
                JsonUtils.put(jSONObject, "clid", this.jad_jw);
                JsonUtils.put(jSONObject, "tpid", Integer.valueOf(this.jad_iv));
                JsonUtils.put(jSONObject, "clf", Integer.valueOf(this.jad_kx));
                JsonUtils.put(jSONObject, "sen", Integer.valueOf(this.jad_wh));
                JsonUtils.put(jSONObject, "rem", Integer.valueOf(this.jad_lw));
                JsonUtils.put(jSONObject, "dety", Integer.valueOf(this.jad_en));
                JsonUtils.put(jSONObject, "scdu", Integer.valueOf(this.jad_ir));
                JsonUtils.put(jSONObject, "dcdu", Integer.valueOf(this.jad_js));
                JsonUtils.put(jSONObject, "ecdu", Integer.valueOf(this.jad_kt));
                JsonUtils.put(jSONObject, "sspt", Integer.valueOf(this.jad_qz));
                JsonUtils.put(jSONObject, "scav", Integer.valueOf(this.jad_ra));
                JsonUtils.put(jSONObject, "adat", Integer.valueOf(this.jad_ox));
                JsonUtils.put(jSONObject, "atst", Integer.valueOf(this.jad_py));
                JsonUtils.put(jSONObject, str7, Integer.valueOf(this.jad_wf));
                JsonUtils.put(jSONObject, str5, Integer.valueOf(this.jad_yh));
                JsonUtils.put(jSONObject, str6, Integer.valueOf(this.jad_zi));
                JsonUtils.put(jSONObject, str4, Integer.valueOf(this.jad_ps));
                JsonUtils.put(jSONObject, "vpst", Integer.valueOf(this.jad_sv));
                JsonUtils.put(jSONObject, "vpdt", Double.valueOf(this.jad_tw));
                if (this.jad_kx == CommonConstants.ClickFrom.AD.ordinal()) {
                    str4 = str;
                    JsonUtils.put(jSONObject, "sims", Integer.valueOf(this.jad_ux));
                    JsonUtils.put(jSONObject, "ifp", this.jad_vy);
                    JsonUtils.put(jSONObject, "ip", this.jad_wz);
                    JsonUtils.put(jSONObject, "vpc", this.jad_xa);
                    JsonUtils.put(jSONObject, "abi", this.jad_yb);
                    JsonUtils.put(jSONObject, "jbr", Integer.valueOf(this.jad_hs));
                    JsonUtils.put(jSONObject, "vir", this.jad_zc);
                    JsonUtils.put(jSONObject, t.q, this.jad_ad);
                    JsonUtils.put(jSONObject, "lau", this.jad_be);
                    JsonUtils.put(jSONObject, "awa", this.jad_cf);
                    JsonUtils.put(jSONObject, "moce", this.jad_dg);
                    JsonUtils.put(jSONObject, "malrun", this.jad_eh);
                    JsonUtils.put(jSONObject, "appct", this.jad_fi);
                    JsonUtils.put(jSONObject, YFAdsConst.LP, this.jad_hj);
                    JsonUtils.put(jSONObject, "pip", this.jad_ik);
                    JsonUtils.put(jSONObject, "qem", this.jad_jl);
                    JsonUtils.put(jSONObject, "dne", this.jad_km);
                    JsonUtils.put(jSONObject, "bra", this.f4589a);
                    JsonUtils.put(jSONObject, "bri", this.b);
                    JsonUtils.put(jSONObject, "pro", this.c);
                    JsonUtils.put(jSONObject, "bat", this.d);
                    JsonUtils.put(jSONObject, "hoo", this.e);
                    JsonUtils.put(jSONObject, "open", this.f);
                    JsonUtils.put(jSONObject, "dbg", this.g);
                    JsonUtils.put(jSONObject, "cpty", this.h);
                    JsonUtils.put(jSONObject, "phsc", Integer.valueOf(this.i));
                    JsonUtils.put(jSONObject, "rebl", Integer.valueOf(this.j));
                    JsonUtils.put(jSONObject, "hdwa", this.k);
                    JsonUtils.put(jSONObject, "osut", this.l);
                    JsonUtils.put(jSONObject, "hwml", this.m);
                    JsonUtils.put(jSONObject, "sysm", this.n);
                    JsonUtils.put(jSONObject, "sysd", this.o);
                    JsonUtils.put(jSONObject, "frds", this.p);
                    JsonUtils.put(jSONObject, "board", this.q);
                    JsonUtils.put(jSONObject, "cpfq", this.r);
                    JsonUtils.put(jSONObject, "plug", Integer.valueOf(this.s));
                }
            }
            str4 = str;
            if (this.jad_bo == 5) {
                JsonUtils.put(jSONObject, "extp", Integer.valueOf(this.jad_qb));
                JsonUtils.put(jSONObject, "ercd", Integer.valueOf(this.jad_rc));
                JsonUtils.put(jSONObject, "erin", this.jad_sd);
                JsonUtils.put(jSONObject, "rid", this.jad_bm);
                if (this.jad_qb == 3) {
                    JsonUtils.put(jSONObject, "sen", Integer.valueOf(this.jad_wh));
                } else {
                    JsonUtils.put(jSONObject, "sen", 0);
                }
                JsonUtils.put(jSONObject, "crt", Integer.valueOf(this.jad_pa));
            }
            if (this.jad_bo == 6) {
                JsonUtils.put(jSONObject, "iid", this.jad_xi);
                JsonUtils.put(jSONObject, "init", Integer.valueOf(this.jad_yj));
                JsonUtils.put(jSONObject, "idu", Integer.valueOf(this.jad_oz));
            }
            JsonUtils.put(jSONObject, a.h, this.jad_re);
            JsonUtils.put(jSONObject, "bi", this.jad_qd);
            JsonUtils.put(jSONObject, "oid", this.jad_pc);
            JsonUtils.put(jSONObject, "ts", this.jad_ly);
            JsonUtils.put(jSONObject, am.x, this.jad_mz);
            JsonUtils.put(jSONObject, "osv", this.jad_na);
            JsonUtils.put(jSONObject, "did", this.jad_ob);
            JsonUtils.put(jSONObject, com.hihonor.adsdk.base.g.j.e.a.H0, this.jad_sf.jad_an());
            JsonUtils.put(jSONObject, "swd", Integer.valueOf(this.jad_te));
            JsonUtils.put(jSONObject, "sht", Integer.valueOf(this.jad_uf));
            JsonUtils.put(jSONObject, "ct", Integer.valueOf(this.jad_vg));
            JsonUtils.put(jSONObject, Launcher.Host.MK, this.jad_tg);
            JsonUtils.put(jSONObject, LiveConfigKey.MEDIUM, this.jad_uh);
            JsonUtils.put(jSONObject, "svb", Integer.valueOf(this.jad_vi));
            JsonUtils.put(jSONObject, "jdi", Integer.valueOf(this.jad_wj));
            JsonUtils.put(jSONObject, "qqi", Integer.valueOf(this.jad_xk));
            JsonUtils.put(jSONObject, "wci", Integer.valueOf(this.jad_yl));
            JsonUtils.put(jSONObject, "tbi", Integer.valueOf(this.jad_zm));
            JsonUtils.put(jSONObject, "tmi", Integer.valueOf(this.jad_cn));
            JsonUtils.put(jSONObject, "pddi", Integer.valueOf(this.jad_do));
            JsonUtils.put(jSONObject, "tz", this.jad_ep);
            JsonUtils.put(jSONObject, a.i, this.jad_fq);
            JsonUtils.put(jSONObject, "asv", this.jad_gr);
            JsonUtils.put(jSONObject, IAdInterListener.AdReqParam.APID, this.jad_dq);
            JsonUtils.put(jSONObject, "jbr", Integer.valueOf(this.jad_hs));
            JsonUtils.put(jSONObject, "af", Integer.valueOf(this.jad_it));
            JsonUtils.put(jSONObject, "atsv", Integer.valueOf(this.jad_ju));
            JsonUtils.put(jSONObject, "ihrd", Integer.valueOf(this.jad_kv));
            JsonUtils.put(jSONObject, "pn", this.jad_sb);
            JsonUtils.put(jSONObject, "sc", this.jad_tc);
            JsonUtils.put(jSONObject, "hos", Integer.valueOf(this.jad_ud));
            JsonUtils.put(jSONObject, "hosv", this.jad_ve);
            JsonUtils.put(jSONObject, "sav", this.jad_gj);
            JsonUtils.put(jSONObject, "mt", this.jad_hk);
            JsonUtils.put(jSONObject, "hwv", this.jad_il);
            JsonUtils.put(jSONObject, "ca", this.jad_jm);
            JsonUtils.put(jSONObject, "ppi", Integer.valueOf(this.jad_kn));
            JsonUtils.put(jSONObject, "cc", this.jad_lo);
            JsonUtils.put(jSONObject, "sof", Integer.valueOf(this.jad_mp));
            JsonUtils.put(jSONObject, sl.c, Integer.valueOf(this.jad_nq));
            JsonUtils.put(jSONObject, "em", Integer.valueOf(this.jad_or));
            JsonUtils.put(jSONObject, "soaid", this.jad_qt);
        } catch (Exception e) {
            Logger.w("Event to json ", e.getMessage());
        }
        return jSONObject;
    }
}
