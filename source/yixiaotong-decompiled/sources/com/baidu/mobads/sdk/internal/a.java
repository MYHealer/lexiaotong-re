package com.baidu.mobads.sdk.internal;

import android.text.TextUtils;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.cdo.oaps.ad.OapsKey;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f1705a = "none";
    public static final String b = "text";
    public static final String c = "static_image";
    public static final String d = "gif";
    public static final String e = "rich_media";
    public static final String f = "html";
    public static final String g = "hybrid";
    public static final String h = "video";
    public static final String i = "live";
    private static final long j = 1750000;
    private String A;
    private String B;
    private String C;
    private String D;
    private String E;
    private String F;
    private String G;
    private int H;
    private String I;
    private int J;
    private int K;
    private int L;
    private int M;
    private int N;
    private int O;
    private String P;
    private List<String> R;
    private JSONObject S;
    private long T;
    private long U;
    private String V;
    private String W;
    private String X;
    private String Y;
    private String Z;
    private String aa;
    private String ab;
    private JSONObject ac;
    private int ad;
    private int ae;
    private int af;
    private List<String> ag;
    private String ai;
    private String aj;
    private JSONObject an;
    private JSONObject ao;
    private int ap;
    private String aq;
    private String k;
    private String l;
    private String m;
    private String n;
    private int o;
    private int p;
    private String q;
    private long r;
    private int s;
    private String u;
    private String v;
    private String w;
    private String x;
    private String y;
    private String z;
    private int t = 1;
    private String Q = "none";
    private int ah = 0;
    private int ak = 0;
    private int al = 0;
    private int am = 0;

    public static boolean a(int i2) {
        return (i2 < 28 || 31 == i2 || 32 == i2 || 38 == i2 || 39 == i2 || 40 == i2 || 42 < i2) ? false : true;
    }

    public String B() {
        return this.w;
    }

    public int C() {
        return this.ap;
    }

    public String D() {
        return this.aq;
    }

    public String E() {
        return this.x;
    }

    public String F() {
        return this.D;
    }

    public String G() {
        return this.C;
    }

    public String H() {
        return this.E;
    }

    public String I() {
        return this.F;
    }

    public String J() {
        return this.G;
    }

    public long K() {
        return this.U;
    }

    public List<String> L() {
        return this.R;
    }

    public String M() {
        return this.V;
    }

    public JSONObject N() {
        return this.S;
    }

    public String O() {
        return this.Y;
    }

    public String P() {
        return this.Z;
    }

    public String Q() {
        return this.aa;
    }

    public int S() {
        return this.af;
    }

    public List<String> T() {
        return this.ag;
    }

    public JSONObject U() {
        return this.ac;
    }

    public int V() {
        return this.ad;
    }

    public int W() {
        return this.ae;
    }

    public int X() {
        return this.ah;
    }

    public String Z() {
        return this.ai;
    }

    public String a() {
        return this.k;
    }

    public int ab() {
        if (this.ak > 0) {
            return this.al;
        }
        return 0;
    }

    public int ac() {
        return this.am;
    }

    public String b() {
        return this.l;
    }

    public String c() {
        return this.m;
    }

    public String d() {
        return this.n;
    }

    public int e() {
        return this.o;
    }

    public int f() {
        return this.p;
    }

    public String g() {
        return this.q;
    }

    public String h() {
        return this.W;
    }

    public String i() {
        return this.X;
    }

    public long j() {
        return this.r;
    }

    public int k() {
        return this.s;
    }

    public int l() {
        return this.t;
    }

    public String m() {
        return this.y;
    }

    public String n() {
        return this.z;
    }

    public String o() {
        return this.A;
    }

    public String p() {
        return this.B;
    }

    public int q() {
        return this.H;
    }

    public String r() {
        return this.I;
    }

    public int s() {
        return this.J;
    }

    public int t() {
        return this.K;
    }

    public int u() {
        return this.L;
    }

    public int v() {
        return this.M;
    }

    public int w() {
        return this.N;
    }

    public int x() {
        return this.O;
    }

    public String y() {
        return this.Q;
    }

    public long z() {
        return this.T;
    }

    /* JADX WARN: Code duplicated, block: B:41:0x0145  */
    public static a a(JSONObject jSONObject) {
        JSONObject jSONObject2;
        if (jSONObject == null) {
            return null;
        }
        a aVar = new a();
        aVar.ao = jSONObject;
        aVar.S = jSONObject.optJSONObject("remoteParams");
        aVar.k = jSONObject.optString("tit");
        aVar.l = jSONObject.optString("desc");
        aVar.m = jSONObject.optString(com.huawei.openalliance.ad.constant.x.cL);
        aVar.n = jSONObject.optString("w_picurl");
        aVar.o = jSONObject.optInt(IAdInterListener.AdReqParam.WIDTH);
        aVar.p = jSONObject.optInt(IAdInterListener.AdReqParam.HEIGHT);
        aVar.q = jSONObject.optString("appname");
        aVar.W = jSONObject.optString("adLogo");
        aVar.X = jSONObject.optString("baiduLogo");
        aVar.ad = jSONObject.optInt("region_click", 2);
        aVar.ae = jSONObject.optInt("dl_dialog", 2);
        aVar.ab = jSONObject.optString("btn");
        try {
            String strOptString = jSONObject.optString("control_flags");
            if (!TextUtils.isEmpty(strOptString)) {
                String strOptString2 = new JSONObject(strOptString).optString("innovate");
                if (!TextUtils.isEmpty(strOptString2)) {
                    JSONObject jSONObject3 = new JSONObject(strOptString2);
                    aVar.Y = jSONObject3.optString("gjico");
                    aVar.Z = jSONObject3.optString("gjtxt");
                    aVar.aa = jSONObject3.optString("gjurl");
                }
            }
            String strOptString3 = jSONObject.optString("cloud_control");
            if (!TextUtils.isEmpty(strOptString3)) {
                JSONObject jSONObject4 = new JSONObject(strOptString3);
                if (jSONObject4.has("cta") && jSONObject4.optInt("cta", 1) == 0) {
                    aVar.ab = "";
                }
                if (jSONObject4.has("marketing")) {
                    int iOptInt = jSONObject4.optInt("marketing", 0);
                    if (iOptInt == 1) {
                        JSONArray jSONArrayOptJSONArray = jSONObject4.optJSONArray("marketing_logo");
                        if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                            int i2 = 0;
                            for (int i3 = 2; i2 < i3; i3 = 2) {
                                String strOptString4 = jSONArrayOptJSONArray.optString(i2);
                                if (!TextUtils.isEmpty(strOptString4)) {
                                    JSONObject jSONObject5 = new JSONObject(strOptString4);
                                    aVar.Y = jSONObject5.optString("gjico", aVar.Y);
                                    aVar.Z = jSONObject5.optString("gjtxt", aVar.Z);
                                    aVar.aa = jSONObject5.optString("gjurl", aVar.aa);
                                }
                                i2++;
                            }
                        }
                    } else if (iOptInt == 0) {
                        aVar.Y = "";
                        aVar.Z = "";
                        aVar.aa = "";
                    }
                }
                JSONArray jSONArrayOptJSONArray2 = jSONObject4.optJSONArray("btn_style");
                if (jSONArrayOptJSONArray2 == null || jSONArrayOptJSONArray2.length() <= 0) {
                    jSONObject2 = null;
                } else {
                    String strOptString5 = jSONArrayOptJSONArray2.optString(0);
                    if (TextUtils.isEmpty(strOptString5)) {
                        jSONObject2 = null;
                    } else {
                        jSONObject2 = new JSONObject(strOptString5);
                    }
                }
                if (jSONObject2 != null) {
                    aVar.af = jSONObject2.optInt("type", 0);
                    JSONArray jSONArrayOptJSONArray3 = jSONObject2.optJSONArray("colors");
                    if (jSONArrayOptJSONArray3 != null && jSONArrayOptJSONArray3.length() == 4) {
                        aVar.ag = new ArrayList();
                        for (int i4 = 0; i4 < jSONArrayOptJSONArray3.length(); i4++) {
                            aVar.ag.add(jSONArrayOptJSONArray3.optString(i4));
                        }
                    }
                }
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        aVar.ac = jSONObject.optJSONObject("monitors");
        aVar.r = jSONObject.optLong("sz");
        aVar.s = jSONObject.optInt("auto_play", 0);
        aVar.t = jSONObject.optInt("auto_play_non_wifi", 1);
        aVar.y = jSONObject.optString(OapsKey.KEY_PAGEKEY);
        aVar.H = jSONObject.optInt("act");
        aVar.I = jSONObject.optString("apo", "");
        aVar.u = jSONObject.optString("bidlayer", "");
        aVar.v = jSONObject.optString("ads_bidlayer", "");
        aVar.w = jSONObject.optString("enc_bid_price", "");
        aVar.x = jSONObject.optString("author_display_name", "");
        aVar.J = jSONObject.optInt("container_width");
        aVar.K = jSONObject.optInt("container_height");
        aVar.L = jSONObject.optInt("size_type");
        int iOptInt2 = jSONObject.optInt("style_type");
        aVar.M = iOptInt2;
        aVar.N = a(jSONObject, iOptInt2, 29);
        aVar.z = jSONObject.optString("vurl", "");
        aVar.O = jSONObject.optInt("duration", 0);
        String strOptString6 = jSONObject.optString("live_flv", "");
        aVar.A = strOptString6;
        if (TextUtils.isEmpty(strOptString6)) {
            aVar.A = jSONObject.optString("live_hls", "");
        }
        aVar.P = jSONObject.optString("type");
        aVar.B = jSONObject.optString(f, null);
        aVar.D = jSONObject.optString("app_version", "");
        aVar.C = jSONObject.optString("publisher", "");
        aVar.G = jSONObject.optString("permission_link", "");
        aVar.E = jSONObject.optString("privacy_link", "");
        aVar.F = jSONObject.optString("function_link", "");
        aVar.ah = jSONObject.optInt("media_player_render", 0);
        aVar.ai = jSONObject.optString("qk", "");
        aVar.aj = jSONObject.optString("buyer", "");
        aVar.ak = jSONObject.optInt("is_ecafd_direct_ad", 0);
        aVar.al = jSONObject.optInt("ecafd_promote_bind", 0);
        aVar.am = jSONObject.optInt("ecafd_promote_order", 0);
        aVar.ap = jSONObject.optInt("act_time", 0);
        aVar.aq = jSONObject.optString("act_text", "");
        try {
            String strOptString7 = jSONObject.optString("media_key");
            if (!TextUtils.isEmpty(strOptString7)) {
                aVar.an = new JSONObject(strOptString7);
            }
        } catch (Throwable th2) {
            az.b(th2);
        }
        try {
            JSONArray jSONArrayOptJSONArray4 = jSONObject.optJSONArray("morepics");
            if (jSONArrayOptJSONArray4 != null && jSONArrayOptJSONArray4.length() > 0) {
                aVar.R = new ArrayList();
                for (int i5 = 0; i5 < jSONArrayOptJSONArray4.length(); i5++) {
                    aVar.R.add(jSONArrayOptJSONArray4.getString(i5));
                }
            }
        } catch (Exception unused) {
        }
        if (TextUtils.isEmpty(aVar.B)) {
            String str = aVar.P;
            if (str != null) {
                if (str.equals("text")) {
                    aVar.P = "text";
                } else if (aVar.P.equals("image")) {
                    if (!TextUtils.isEmpty(aVar.n)) {
                        int iLastIndexOf = aVar.n.toLowerCase(Locale.getDefault()).lastIndexOf(46);
                        if ((iLastIndexOf >= 0 ? aVar.n.toLowerCase(Locale.getDefault()).substring(iLastIndexOf) : "").contains(".gif")) {
                            aVar.Q = "gif";
                        } else {
                            aVar.Q = c;
                        }
                    }
                } else if (aVar.P.equals(com.kuaishou.weapon.p0.t.w)) {
                    aVar.Q = e;
                } else if (aVar.P.equals("video")) {
                    aVar.Q = "video";
                } else if (aVar.P.equals("live")) {
                    aVar.Q = "live";
                }
            }
        } else {
            aVar.Q = f;
        }
        JSONObject jSONObject6 = aVar.S;
        if (jSONObject6 != null) {
            aVar.T = jSONObject6.optLong("createTime", 0L);
            aVar.U = aVar.S.optLong("expireTime", j);
            aVar.W = aVar.S.optString("adLogo", z.aO);
            aVar.X = aVar.S.optString("baiduLogo", z.aP);
            aVar.V = aVar.S.optString("uniqueId", "");
        }
        return aVar;
    }

    public String a(String str) {
        if (this.an == null) {
            return null;
        }
        JSONObject jSONObject = this.ao;
        JSONObject jSONObjectOptJSONObject = jSONObject != null ? jSONObject.optJSONObject("apo") : null;
        String strOptString = this.an.optString(str);
        if (TextUtils.isEmpty(strOptString)) {
            return null;
        }
        if (TextUtils.equals(strOptString, "fallback") && jSONObjectOptJSONObject != null) {
            return jSONObjectOptJSONObject.optString("fallback");
        }
        if (TextUtils.equals(strOptString, "page") && jSONObjectOptJSONObject != null) {
            return jSONObjectOptJSONObject.optString("page");
        }
        JSONObject jSONObject2 = this.ao;
        if (jSONObject2 != null) {
            return jSONObject2.optString(strOptString);
        }
        return null;
    }

    public static List<a> a(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                try {
                    arrayList.add(a(jSONArray.getJSONObject(i2)));
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        }
        return arrayList;
    }

    private static int a(JSONObject jSONObject, int i2, int i3) {
        String[] strArrSplit;
        int i4 = 0;
        if (jSONObject != null) {
            try {
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("st_op");
                if (jSONObjectOptJSONObject != null) {
                    String strOptString = jSONObjectOptJSONObject.optString("tp_id");
                    if (!TextUtils.isEmpty(strOptString) && strOptString.startsWith("opt_style_") && (strArrSplit = strOptString.substring(10).split("_")) != null && strArrSplit.length > 0) {
                        i4 = Integer.parseInt(strArrSplit[0]);
                    }
                }
            } catch (Throwable th) {
                bv.a().d(th.getMessage());
            }
        }
        if (a(i4)) {
            i2 = i4;
        } else if (!a(i2)) {
            i2 = i3;
        }
        if (i2 == 42) {
            return 41;
        }
        return i2;
    }

    public String A() {
        return !TextUtils.isEmpty(this.v) ? this.v : this.u;
    }

    public String R() {
        String str = this.ab;
        return (str == null || str.length() <= 4) ? this.ab : "";
    }

    public JSONObject Y() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("uniqueId", this.V);
            jSONObject.put("tit", this.k);
            jSONObject.put("desc", this.l);
            jSONObject.put(OapsKey.KEY_PAGEKEY, this.y);
            jSONObject.put("appname", this.q);
            jSONObject.put("act", this.H);
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }

    public String aa() {
        if (TextUtils.isEmpty(this.aj)) {
            return "";
        }
        try {
            long j2 = Long.parseLong(this.aj);
            int length = this.aj.length();
            return (j2 <= 100000 || length <= 5) ? "" : this.aj.substring(length - 4, length);
        } catch (Throwable th) {
            az.b(th);
            return "";
        }
    }
}
