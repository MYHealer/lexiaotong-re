package com.byazt.aq;

import com.byazt.nr.m;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.huawei.hms.ads.ClickAreaSource;
import com.huawei.hms.ads.jsb.constant.Constant;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.io.encoding.Base64;
import okio.Utf8;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 1950, 34})
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f1975a;
    public int aw;
    public int az;
    public String b;
    public boolean bm;
    public int bx;
    public float c;
    public long ca = -1;
    public JSONObject cf;
    public String cl;
    public String cu;
    public String d;
    public float da;
    public String di;
    public boolean dz;
    public List<String> e;
    public int ej;
    public String eo;
    public int f;
    public int g;
    public String gk;
    public String gr;
    public String gt;
    public String gu;
    public boolean gx;
    public int gy;
    public double h;
    public int hd;
    public int hg;
    public int hj;
    public int hq;
    public float i;
    public double ic;
    public int ij;
    public List<c> ir;
    public int is;
    public String iu;
    public String iy;
    public String j;
    public boolean jg;
    public int jt;
    public int k;
    public int kk;
    public boolean kp;
    public int kz;
    public boolean l;
    public int lo;
    public int lr;
    public boolean lt;
    public String m;
    public int ma;
    public double md;
    public boolean mm;
    public boolean mq;
    public String my;
    public boolean n;
    public int nb;
    public String nc;
    public String nl;
    public boolean nt;
    public String nu;
    public String nx;
    public boolean ny;
    public String or;
    public int os;
    public int oz;
    public int p;
    public boolean pe;
    public int pf;
    public boolean pl;
    public double pn;
    public String pu;
    public JSONObject q;
    public boolean qp;
    public String qy;
    public int r;
    public String rh;
    public String rl;
    public int s;
    public int sd;
    public double sl;
    public float sp;
    public int sv;
    public double t;
    public boolean tk;
    public boolean to;
    public float tt;
    public boolean tx;
    public String u;
    public float uj;
    public int v;
    public float ve;
    public String vi;
    public JSONObject vp;
    public int w;
    public float x;
    public int xd;
    public int y;
    public int yf;
    public JSONObject yo;
    public String yp;
    public int yv;
    public String z;
    public String zb;
    public boolean zm;

    private void md(String str) {
        this.cl = str;
    }

    public JSONObject a() {
        return this.cf;
    }

    public void a(double d) {
        this.ic = d;
    }

    public void a(float f) {
        this.sp = f;
    }

    public void a(int i) {
        this.ij = i;
    }

    public void a(String str) {
        this.nu = str;
    }

    public void a(boolean z) {
        this.l = z;
    }

    public String aw() {
        return this.cu;
    }

    public int az() {
        return this.xd;
    }

    public int b() {
        return this.lo;
    }

    public int bm() {
        return this.pf;
    }

    public String bx() {
        return this.zb;
    }

    public void c(double d) {
        this.pn = d;
    }

    public void c(float f) {
        this.c = f;
    }

    public void c(int i) {
        this.az = i;
    }

    public void c(long j) {
        this.ca = j;
    }

    public void c(String str) {
        this.nx = str;
    }

    public void c(List<c> list) {
        this.ir = list;
    }

    public void c(boolean z) {
        this.dz = z;
    }

    public boolean c() {
        return this.dz;
    }

    public int cf() {
        return this.g;
    }

    public List<String> cl() {
        return this.e;
    }

    public double cu() {
        return this.md;
    }

    public void cu(int i) {
        this.hq = i;
    }

    public String d() {
        return this.gr;
    }

    public void d(int i) {
        this.ej = i;
    }

    public String da() {
        return this.nx;
    }

    public void da(int i) {
        this.pf = i;
    }

    public void da(String str) {
        this.rl = str;
    }

    public void da(boolean z) {
        this.kp = z;
    }

    public boolean di() {
        return this.mm;
    }

    public int dz() {
        return this.oz;
    }

    public int ej() {
        return this.gy;
    }

    public void eo(int i) {
        this.g = i;
    }

    public boolean eo() {
        return this.zm;
    }

    public int f() {
        return this.y;
    }

    public String g() {
        return this.j;
    }

    public boolean gk() {
        return this.pe;
    }

    public String gr() {
        return this.rh;
    }

    public void gr(int i) {
        this.ma = i;
    }

    public void gr(String str) {
        this.nl = str;
    }

    public double gt() {
        return this.t;
    }

    public void gt(int i) {
        this.oz = i;
    }

    public void gt(String str) {
        this.b = str;
    }

    public String gu() {
        return this.nu;
    }

    public void gu(int i) {
        this.y = i;
    }

    public void gu(String str) {
        this.di = str;
    }

    public int gx() {
        return this.sd;
    }

    public int gy() {
        return this.k;
    }

    public String h() {
        return this.gu;
    }

    public void h(int i) {
        this.f = i;
    }

    public int hd() {
        return this.nb;
    }

    public String hg() {
        return this.iy;
    }

    public int hj() {
        return this.ma;
    }

    public String hq() {
        return this.di;
    }

    public int i() {
        return this.ij;
    }

    public void i(float f) {
        this.da = f;
    }

    public void i(int i) {
        this.nb = i;
    }

    public void i(String str) {
        this.gt = str;
    }

    public void i(boolean z) {
        this.tk = z;
    }

    public boolean ic() {
        return this.qp;
    }

    public int ij() {
        return this.hj;
    }

    public String ir() {
        return this.iu;
    }

    public boolean is() {
        return this.ny;
    }

    public int iu() {
        return this.v;
    }

    public String iy() {
        return this.nc;
    }

    public int j() {
        return this.os;
    }

    public JSONObject jg() {
        return this.vp;
    }

    public int jt() {
        return this.hq;
    }

    public boolean kk() {
        return this.lt;
    }

    public boolean kp() {
        return this.l;
    }

    public int kz() {
        return this.ej;
    }

    public int l() {
        return this.sv;
    }

    public int lo() {
        return this.aw;
    }

    public int lr() {
        return this.bx;
    }

    public int lt() {
        return this.hd;
    }

    public float m() {
        return this.x;
    }

    public void m(int i) {
        this.lo = i;
    }

    public void m(String str) {
        this.zb = str;
    }

    public void m(boolean z) {
        this.nt = z;
    }

    public int ma() {
        return this.r;
    }

    public String md() {
        return this.qy;
    }

    public void md(int i) {
        this.k = i;
    }

    public boolean mm() {
        return this.pl;
    }

    public double my() {
        return this.sl;
    }

    public void my(int i) {
        this.os = i;
    }

    public void my(String str) {
        this.pu = str;
    }

    public void my(boolean z) {
        this.pe = z;
    }

    public int n() {
        return this.w;
    }

    public void n(double d) {
        this.h = d;
    }

    public void n(float f) {
        this.f1975a = f;
    }

    public void n(int i) {
        this.kz = i;
    }

    public void n(String str) {
        this.m = str;
    }

    public void n(JSONObject jSONObject) {
        this.cf = jSONObject;
    }

    public void n(boolean z) {
        this.bm = z;
    }

    public String nb() {
        return this.d;
    }

    public long nc() {
        return this.ca;
    }

    public boolean nl() {
        return this.gx;
    }

    public int nt() {
        return this.hg;
    }

    public float nu() {
        return this.i;
    }

    public void nu(int i) {
        this.kk = i;
    }

    public void nu(String str) {
        this.or = str;
    }

    public void nu(boolean z) {
        this.gx = z;
    }

    public boolean ny() {
        return this.jg;
    }

    public int or() {
        return this.p;
    }

    public void or(int i) {
        this.xd = i;
    }

    public boolean os() {
        return this.kp;
    }

    public String oz() {
        return this.b;
    }

    public String p() {
        return this.rl;
    }

    public void p(int i) {
        this.sd = i;
    }

    public void p(String str) {
        this.gk = str;
    }

    public String pf() {
        return this.eo;
    }

    public String pl() {
        return this.vi;
    }

    public int pn() {
        return this.f;
    }

    public double pu() {
        return this.ic;
    }

    public String q() {
        return this.pu;
    }

    public double qp() {
        return this.h;
    }

    public void qp(int i) {
        this.gy = i;
    }

    public String qy() {
        return this.m;
    }

    public void qy(int i) {
        this.s = i;
    }

    public void qy(String str) {
        this.j = str;
    }

    public JSONObject r() {
        return this.q;
    }

    public float rh() {
        return this.da;
    }

    public void rh(int i) {
        this.v = i;
    }

    public void rh(String str) {
        this.cu = str;
    }

    public void rh(boolean z) {
        this.mm = z;
    }

    public String rl() {
        return this.z;
    }

    public void rl(int i) {
        this.r = i;
    }

    public void rl(String str) {
        this.iu = str;
    }

    public int s() {
        return this.kk;
    }

    public float sl() {
        return this.c;
    }

    public void sl(int i) {
        this.bx = i;
    }

    public void sl(String str) {
        this.qy = str;
    }

    public void sl(boolean z) {
        this.tx = z;
    }

    public int sp() {
        return this.kz;
    }

    public void sp(float f) {
        this.x = f;
    }

    public void sp(int i) {
        this.yv = i;
    }

    public void sp(String str) {
        this.rh = str;
    }

    public void sp(boolean z) {
        this.lt = z;
    }

    public String sv() {
        return this.or;
    }

    public float t() {
        return this.tt;
    }

    public void t(int i) {
        this.sv = i;
    }

    public void t(String str) {
        this.gu = str;
    }

    public void t(boolean z) {
        this.jg = z;
    }

    public int tk() {
        return this.lr;
    }

    public boolean to() {
        return this.bm;
    }

    public int tt() {
        return this.az;
    }

    public void tt(double d) {
        this.sl = d;
    }

    public void tt(float f) {
        this.tt = f;
    }

    public void tt(int i) {
        this.is = i;
    }

    public void tt(String str) {
        this.u = str;
    }

    public void tt(List<String> list) {
        this.e = list;
    }

    public void tt(JSONObject jSONObject) {
        this.q = jSONObject;
    }

    public void tt(boolean z) {
        this.n = z;
    }

    public boolean tx() {
        return this.to;
    }

    public void u(int i) {
        this.aw = i;
    }

    public void u(String str) {
        this.gr = str;
    }

    public void u(boolean z) {
        this.pl = z;
    }

    public boolean u() {
        return this.n;
    }

    public int uj() {
        return this.jt;
    }

    public void uj(double d) {
        this.md = d;
    }

    public void uj(float f) {
        this.uj = f;
    }

    public void uj(int i) {
        this.w = i;
    }

    public void uj(String str) {
        this.z = str;
    }

    public void uj(JSONObject jSONObject) {
        this.vp = jSONObject;
    }

    public void uj(boolean z) {
        this.qp = z;
    }

    public boolean v() {
        return this.tk;
    }

    public int ve() {
        return this.is;
    }

    public void ve(double d) {
        this.t = d;
    }

    public void ve(float f) {
        this.ve = f;
    }

    public void ve(int i) {
        this.jt = i;
    }

    public void ve(String str) {
        this.yp = str;
    }

    public void ve(JSONObject jSONObject) {
        this.yo = jSONObject;
    }

    public void ve(boolean z) {
        this.zm = z;
    }

    public List<c> vi() {
        return this.ir;
    }

    public String vp() {
        return this.nl;
    }

    public boolean w() {
        return this.nt;
    }

    public double x() {
        return this.pn;
    }

    public void x(float f) {
        this.i = f;
    }

    public void x(int i) {
        this.p = i;
    }

    public void x(String str) {
        this.my = str;
    }

    public void x(boolean z) {
        this.to = z;
    }

    public int xd() {
        return this.yf;
    }

    public boolean y() {
        return this.tx;
    }

    public int yf() {
        return this.s;
    }

    public boolean yo() {
        return this.mq;
    }

    public float yp() {
        return this.f1975a;
    }

    public void yp(int i) {
        this.hd = i;
    }

    public void yp(String str) {
        this.d = str;
    }

    public void yp(boolean z) {
        this.mq = z;
    }

    public String yv() {
        return this.my;
    }

    public void yv(int i) {
        this.hg = i;
    }

    public void yv(String str) {
        this.nc = str;
    }

    public float z() {
        return this.sp;
    }

    public void z(int i) {
        this.lr = i;
    }

    public void z(String str) {
        this.eo = str;
    }

    public void z(boolean z) {
        this.ny = z;
    }

    public int zb() {
        return this.yv;
    }

    public void zb(int i) {
        this.hj = i;
    }

    public String zm() {
        return this.cl;
    }

    public void zm(int i) {
        this.yf = i;
    }

    public void zm(String str) {
        this.iy = str;
    }

    public static a c(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        a aVar = new a();
        aVar.tt(jSONObject.optString("adType", "embeded"));
        aVar.z(jSONObject.optString("clickArea", ClickAreaSource.CREATIVE));
        aVar.m(jSONObject.optString("clickTigger", "click"));
        aVar.ve(jSONObject.optString(TtmlNode.ATTR_TTS_FONT_FAMILY, "PingFangSC"));
        aVar.uj(jSONObject.optString(TtmlNode.ATTR_TTS_TEXT_ALIGN, TtmlNode.LEFT));
        aVar.n(jSONObject.optString("color", "#999999"));
        aVar.a(jSONObject.optString("bgColor", "transparent"));
        aVar.sp(jSONObject.optString("bgImgUrl", ""));
        aVar.md(jSONObject.optString("bgImgData", ""));
        aVar.x(jSONObject.optString("borderColor", "#000000"));
        aVar.i(jSONObject.optString("borderStyle", "solid"));
        aVar.da(jSONObject.optString("heightMode", "auto"));
        aVar.sl(jSONObject.optString("widthMode", "fixed"));
        aVar.t(jSONObject.optString("interactText", ""));
        aVar.ve(jSONObject.optBoolean("isShowBgControl", false));
        aVar.u(jSONObject.optString("interactBgColor", ""));
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("interactPosition");
        if (jSONObjectOptJSONObject != null) {
            aVar.sp(jSONObjectOptJSONObject.optInt("translateY", 0));
            aVar.x(jSONObjectOptJSONObject.optInt("translateX", 0));
            aVar.uj(jSONObjectOptJSONObject.optDouble("scaleX", 0.0d));
            aVar.n(jSONObjectOptJSONObject.optDouble("scaleY", 0.0d));
        }
        aVar.yp(jSONObject.optString("interactType", ""));
        aVar.n(jSONObject.optInt("interactSlideDirection", -1));
        aVar.nu(jSONObject.optString("justifyHorizontal", "space-around"));
        aVar.rh(jSONObject.optString("justifyVertical", "flex-start"));
        aVar.tt(jSONObject.optDouble("timingStart"));
        aVar.ve(jSONObject.optDouble("timingEnd"));
        aVar.uj((float) jSONObject.optDouble("width", 0.0d));
        aVar.ve((float) jSONObject.optDouble("height", 0.0d));
        aVar.c((float) jSONObject.optDouble("borderRadius", 0.0d));
        aVar.tt((float) jSONObject.optDouble("borderSize", 0.0d));
        aVar.tt(jSONObject.optBoolean("interactValidate", false));
        aVar.i((float) jSONObject.optDouble(TtmlNode.ATTR_TTS_FONT_SIZE, 0.0d));
        aVar.n((float) jSONObject.optDouble("paddingBottom", 0.0d));
        aVar.a((float) jSONObject.optDouble("paddingLeft", 0.0d));
        aVar.sp((float) jSONObject.optDouble("paddingRight", 0.0d));
        aVar.x((float) jSONObject.optDouble("paddingTop", 0.0d));
        aVar.uj(jSONObject.optBoolean("lineFeed", false));
        aVar.i(jSONObject.optInt("lineCount", 0));
        aVar.a(jSONObject.optDouble("lineHeight", 1.2d));
        aVar.yp(jSONObject.optInt("letterSpacing", 0));
        aVar.n(jSONObject.optBoolean("isDataFixed", false));
        aVar.z(jSONObject.optInt(TtmlNode.ATTR_TTS_FONT_WEIGHT));
        aVar.a(jSONObject.optBoolean("lineLimit"));
        aVar.m(jSONObject.optInt("position"));
        aVar.my(jSONObject.optString("align"));
        aVar.sp(jSONObject.optBoolean("useLeft"));
        aVar.x(jSONObject.optBoolean("useRight"));
        aVar.i(jSONObject.optBoolean("useTop"));
        aVar.da(jSONObject.optBoolean("useBottom"));
        aVar.gt(jSONObject.optString("data"));
        aVar.tt(jSONObject.optJSONObject("i18n"));
        aVar.t(jSONObject.optInt("marginLeft"));
        aVar.u(jSONObject.optInt("marginRight"));
        aVar.da(jSONObject.optInt("marginTop"));
        aVar.sl(jSONObject.optInt("marginBottom"));
        aVar.nu(jSONObject.optInt("tagMaxCount"));
        aVar.sl(jSONObject.optBoolean("allowTextFlow"));
        aVar.rh(jSONObject.optInt("textFlowType"));
        aVar.my(jSONObject.optInt("textFlowDuration"));
        aVar.gt(jSONObject.optInt(TtmlNode.LEFT));
        aVar.rl(jSONObject.optInt(TtmlNode.RIGHT));
        aVar.qy(jSONObject.optInt(Constant.MAP_KEY_TOP));
        aVar.gu(jSONObject.optInt("bottom"));
        aVar.rl(jSONObject.optString("alignItems", "flex-start"));
        aVar.qy(jSONObject.optString(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, ""));
        aVar.c(jSONObject.optBoolean("loop", false));
        aVar.gr(jSONObject.optInt("zIndex"));
        aVar.h(jSONObject.optInt("interactVisibleTime"));
        aVar.zm(jSONObject.optInt("interactHiddenTime"));
        aVar.u(jSONObject.optBoolean("interactEnableMask"));
        aVar.yp(jSONObject.optBoolean("interactWontHide"));
        aVar.c(jSONObject.optString("bgGradient"));
        aVar.eo(jSONObject.optInt("areaType"));
        aVar.zb(jSONObject.optInt("interactSlideThreshold", 0));
        aVar.qp(jSONObject.optInt("interactBottomDistance", com.byazt.sr.uj.c() ? 0 : 120));
        aVar.rh(jSONObject.optBoolean("openPlayableLandingPage", false));
        aVar.ve(jSONObject.optJSONObject("video"));
        aVar.uj(jSONObject.optJSONObject("image"));
        aVar.or(jSONObject.optInt("borderShadowExtent"));
        aVar.z(jSONObject.optBoolean("bgGauseBlur"));
        aVar.cu(jSONObject.optInt("bgGauseBlurRadius"));
        aVar.m(jSONObject.optBoolean("showTimeProgress", false));
        aVar.nu(jSONObject.optBoolean("showPlayButton", false));
        aVar.c(jSONObject.optDouble("bgColorCg", 0.0d));
        aVar.a(jSONObject.optInt("bgMaterialCenterCalcColor", 0));
        aVar.tt(jSONObject.optInt("borderTopLeftRadius", 0));
        aVar.c(jSONObject.optInt("borderTopRightRadius", 0));
        aVar.uj(jSONObject.optInt("borderBottomLeftRadius", 0));
        aVar.ve(jSONObject.optInt("borderBottomRightRadius", 0));
        aVar.n(jSONObject.optJSONObject("interactI18n"));
        aVar.gr(jSONObject.optString("imageObjectFit"));
        aVar.zm(jSONObject.optString("interactTitle"));
        aVar.d(jSONObject.optInt("interactTextPositionTop"));
        aVar.gu(jSONObject.optString("imageLottieTosPath"));
        aVar.t(jSONObject.optBoolean("animationsLoop"));
        aVar.yv(jSONObject.optInt("lottieAppNameMaxLength"));
        aVar.md(jSONObject.optInt("lottieAdDescMaxLength"));
        aVar.p(jSONObject.optInt("lottieAdTitleMaxLength"));
        aVar.p(jSONObject.optString("imageFlipSlideType"));
        aVar.my(jSONObject.optBoolean("isClickEventIntercept"));
        if (jSONObject.has("filterColor")) {
            ArrayList arrayList = new ArrayList();
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("filterColor");
            if (jSONArrayOptJSONArray != null) {
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    arrayList.add(jSONArrayOptJSONArray.optString(i));
                }
                aVar.tt(arrayList);
            }
        }
        try {
            JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("animations");
            if (jSONArrayOptJSONArray2 != null) {
                ArrayList arrayList2 = new ArrayList();
                for (int i2 = 0; i2 < jSONArrayOptJSONArray2.length(); i2++) {
                    JSONObject jSONObject2 = jSONArrayOptJSONArray2.getJSONObject(i2);
                    c cVar = new c();
                    cVar.ve(jSONObject2.optString("animationType"));
                    cVar.c(jSONObject2.optDouble("animationDuration"));
                    cVar.tt(jSONObject2.optDouble("animationScaleX"));
                    cVar.ve(jSONObject2.optDouble("animationScaleY"));
                    cVar.uj(jSONObject2.optString("animationTimeFunction"));
                    cVar.uj(jSONObject2.optDouble("animationDelay"));
                    cVar.a(jSONObject2.optInt("animationIterationCount"));
                    cVar.n(jSONObject2.optString("animationDirection"));
                    cVar.n(jSONObject2.optDouble("animationInterval"));
                    cVar.c(jSONObject2.optInt("animationBorderWidth"));
                    cVar.c(jSONObject2.optLong("key"));
                    cVar.tt(jSONObject2.optInt("animationEffectWidth"));
                    cVar.ve(jSONObject2.optInt("animationSwing", 1));
                    cVar.uj(jSONObject2.optInt("animationTranslateX"));
                    cVar.n(jSONObject2.optInt("animationTranslateY"));
                    cVar.tt(jSONObject2.optString("animationRippleBackgroundColor"));
                    cVar.c(jSONObject2.optString("animationScaleDirection"));
                    cVar.sp(jSONObject2.optInt("animationFadeStart"));
                    cVar.x(jSONObject2.optInt("animationFadeEnd"));
                    cVar.a(jSONObject2.optString("animationFillMode"));
                    cVar.i(jSONObject2.optInt("animationBounceHeight"));
                    if (aVar.my() > 0.0d) {
                        cVar.uj(cVar.yp() + aVar.my());
                    }
                    arrayList2.add(cVar);
                }
                aVar.c(arrayList2);
            }
            if (jSONObject.has("triggerSlideMinDistance")) {
                aVar.yv(jSONObject.optString("triggerSlideDirection", "0"));
                aVar.c(jSONObject.optLong("triggerSlideMinDistance", 0L));
            }
        } catch (Exception e) {
            m.c(e);
        }
        return aVar;
    }

    public int mq() {
        List<c> list = this.ir;
        if (list == null) {
            return 0;
        }
        for (c cVar : list) {
            if ("translate".equals(cVar.i()) && cVar.sp() < 0) {
                return -cVar.sp();
            }
        }
        return 0;
    }

    public void sd() {
        c(this, this.yo);
    }

    public void k() {
        c(this, this.vp);
    }

    public String ca() {
        return ("flip".equals(this.gk) || "slide".equals(this.gk)) ? this.gk : "slide";
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private void c(a aVar, JSONObject jSONObject) {
        if (aVar == null || jSONObject == null) {
            return;
        }
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            next.hashCode();
            byte b = -1;
            switch (next.hashCode()) {
                case -2067713583:
                    if (next.equals("isShowBgControl")) {
                        b = 0;
                    }
                    break;
                case -1965619659:
                    if (next.equals("clickArea")) {
                        b = 1;
                    }
                    break;
                case -1912831834:
                    if (next.equals("triggerSlideDirection")) {
                        b = 2;
                    }
                    break;
                case -1885934767:
                    if (next.equals("bgImgUrl")) {
                        b = 3;
                    }
                    break;
                case -1822062213:
                    if (next.equals("lineCount")) {
                        b = 4;
                    }
                    break;
                case -1821293778:
                    if (next.equals("openPlayableLandingPage")) {
                        b = 5;
                    }
                    break;
                case -1813937113:
                    if (next.equals("lineLimit")) {
                        b = 6;
                    }
                    break;
                case -1578250488:
                    if (next.equals("interactBgColor")) {
                        b = 7;
                    }
                    break;
                case -1501175880:
                    if (next.equals("paddingLeft")) {
                        b = 8;
                    }
                    break;
                case -1422965251:
                    if (next.equals("adType")) {
                        b = 9;
                    }
                    break;
                case -1383228885:
                    if (next.equals("bottom")) {
                        b = 10;
                    }
                    break;
                case -1224696685:
                    if (next.equals(TtmlNode.ATTR_TTS_FONT_FAMILY)) {
                        b = 11;
                    }
                    break;
                case -1221029593:
                    if (next.equals("height")) {
                        b = 12;
                    }
                    break;
                case -1065511464:
                    if (next.equals(TtmlNode.ATTR_TTS_TEXT_ALIGN)) {
                        b = 13;
                    }
                    break;
                case -1063257157:
                    if (next.equals("alignItems")) {
                        b = 14;
                    }
                    break;
                case -1046708884:
                    if (next.equals("interactValidate")) {
                        b = 15;
                    }
                    break;
                case -1044792121:
                    if (next.equals("marginTop")) {
                        b = 16;
                    }
                    break;
                case -1019884910:
                    if (next.equals("useBottom")) {
                        b = 17;
                    }
                    break;
                case -1005195314:
                    if (next.equals("triggerSlideMinDistance")) {
                        b = Ascii.DC2;
                    }
                    break;
                case -962590849:
                    if (next.equals(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION)) {
                        b = 19;
                    }
                    break;
                case -912366651:
                    if (next.equals("tagMaxCount")) {
                        b = Ascii.DC4;
                    }
                    break;
                case -848877971:
                    if (next.equals("interactHiddenTime")) {
                        b = Ascii.NAK;
                    }
                    break;
                case -836058546:
                    if (next.equals("useTop")) {
                        b = Ascii.SYN;
                    }
                    break;
                case -734428249:
                    if (next.equals(TtmlNode.ATTR_TTS_FONT_WEIGHT)) {
                        b = Ascii.ETB;
                    }
                    break;
                case -731417480:
                    if (next.equals("zIndex")) {
                        b = Ascii.CAN;
                    }
                    break;
                case -709393864:
                    if (next.equals("timingStart")) {
                        b = Ascii.EM;
                    }
                    break;
                case -515807685:
                    if (next.equals("lineHeight")) {
                        b = 26;
                    }
                    break;
                case -321658193:
                    if (next.equals("textFlowDuration")) {
                        b = Ascii.ESC;
                    }
                    break;
                case -295409451:
                    if (next.equals("useRight")) {
                        b = Ascii.FS;
                    }
                    break;
                case -289173127:
                    if (next.equals("marginBottom")) {
                        b = Ascii.GS;
                    }
                    break;
                case -204859874:
                    if (next.equals("bgColor")) {
                        b = Ascii.RS;
                    }
                    break;
                case -191748762:
                    if (next.equals("isClickEventIntercept")) {
                        b = Ascii.US;
                    }
                    break;
                case -148259282:
                    if (next.equals("useLeft")) {
                        b = 32;
                    }
                    break;
                case -51738487:
                    if (next.equals("widthMode")) {
                        b = 33;
                    }
                    break;
                case 115029:
                    if (next.equals(Constant.MAP_KEY_TOP)) {
                        b = 34;
                    }
                    break;
                case 3076010:
                    if (next.equals("data")) {
                        b = 35;
                    }
                    break;
                case 3317767:
                    if (next.equals(TtmlNode.LEFT)) {
                        b = 36;
                    }
                    break;
                case 3327652:
                    if (next.equals("loop")) {
                        b = 37;
                    }
                    break;
                case 90130308:
                    if (next.equals("paddingTop")) {
                        b = 38;
                    }
                    break;
                case 92903173:
                    if (next.equals("align")) {
                        b = 39;
                    }
                    break;
                case 94842723:
                    if (next.equals("color")) {
                        b = 40;
                    }
                    break;
                case 108511772:
                    if (next.equals(TtmlNode.RIGHT)) {
                        b = 41;
                    }
                    break;
                case 113126854:
                    if (next.equals("width")) {
                        b = 42;
                    }
                    break;
                case 164611121:
                    if (next.equals("timingEnd")) {
                        b = 43;
                    }
                    break;
                case 202355100:
                    if (next.equals("paddingBottom")) {
                        b = 44;
                    }
                    break;
                case 247204452:
                    if (next.equals("allowTextFlow")) {
                        b = 45;
                    }
                    break;
                case 302841174:
                    if (next.equals("interactWontHide")) {
                        b = 46;
                    }
                    break;
                case 365601008:
                    if (next.equals(TtmlNode.ATTR_TTS_FONT_SIZE)) {
                        b = 47;
                    }
                    break;
                case 428975654:
                    if (next.equals("justifyVertical")) {
                        b = 48;
                    }
                    break;
                case 439444041:
                    if (next.equals("interactVisibleTime")) {
                        b = 49;
                    }
                    break;
                case 713848971:
                    if (next.equals("paddingRight")) {
                        b = 50;
                    }
                    break;
                case 722830999:
                    if (next.equals("borderColor")) {
                        b = 51;
                    }
                    break;
                case 737768677:
                    if (next.equals("borderStyle")) {
                        b = 52;
                    }
                    break;
                case 747804969:
                    if (next.equals("position")) {
                        b = 53;
                    }
                    break;
                case 791643104:
                    if (next.equals("isDataFixed")) {
                        b = 54;
                    }
                    break;
                case 975087886:
                    if (next.equals("marginRight")) {
                        b = 55;
                    }
                    break;
                case 1110826708:
                    if (next.equals("justifyHorizontal")) {
                        b = 56;
                    }
                    break;
                case 1122368895:
                    if (next.equals("interactPosition")) {
                        b = 57;
                    }
                    break;
                case 1188229042:
                    if (next.equals("lineFeed")) {
                        b = 58;
                    }
                    break;
                case 1332036739:
                    if (next.equals("interactText")) {
                        b = 59;
                    }
                    break;
                case 1332055696:
                    if (next.equals("interactType")) {
                        b = 60;
                    }
                    break;
                case 1349188574:
                    if (next.equals("borderRadius")) {
                        b = Base64.padSymbol;
                    }
                    break;
                case 1360828714:
                    if (next.equals("clickTigger")) {
                        b = 62;
                    }
                    break;
                case 1490178922:
                    if (next.equals("heightMode")) {
                        b = Utf8.REPLACEMENT_BYTE;
                    }
                    break;
                case 1761274325:
                    if (next.equals("textFlowType")) {
                        b = SignedBytes.MAX_POWER_OF_TWO;
                    }
                    break;
                case 1824903757:
                    if (next.equals("borderSize")) {
                        b = 65;
                    }
                    break;
                case 1970934485:
                    if (next.equals("marginLeft")) {
                        b = 66;
                    }
                    break;
                case 2111078717:
                    if (next.equals("letterSpacing")) {
                        b = 67;
                    }
                    break;
            }
            switch (b) {
                case 0:
                    aVar.ve(jSONObject.optBoolean(next, false));
                    break;
                case 1:
                    aVar.z(jSONObject.optString(next));
                    break;
                case 2:
                    aVar.yv(jSONObject.optString(next));
                    break;
                case 3:
                    aVar.sp(jSONObject.optString(next));
                    break;
                case 4:
                    aVar.i(jSONObject.optInt(next));
                    break;
                case 5:
                    aVar.rh(jSONObject.optBoolean(next));
                    break;
                case 6:
                    aVar.a(jSONObject.optBoolean(next));
                    break;
                case 7:
                    aVar.u(jSONObject.optString(next));
                    break;
                case 8:
                    aVar.a((float) jSONObject.optDouble(next));
                    break;
                case 9:
                    aVar.tt(jSONObject.optString(next));
                    break;
                case 10:
                    aVar.gu(jSONObject.optInt(next));
                    break;
                case 11:
                    aVar.ve(jSONObject.optString(next));
                    break;
                case 12:
                    aVar.ve((float) jSONObject.optDouble(next));
                    break;
                case 13:
                    aVar.uj(jSONObject.optString(next));
                    break;
                case 14:
                    aVar.rl(jSONObject.optString(next));
                    break;
                case 15:
                    aVar.tt(jSONObject.optBoolean(next));
                    break;
                case 16:
                    aVar.da(jSONObject.optInt(next));
                    break;
                case 17:
                    aVar.da(jSONObject.optBoolean(next));
                    break;
                case 18:
                    aVar.c(jSONObject.optLong(next));
                    break;
                case 19:
                    aVar.qy(jSONObject.optString(next));
                    break;
                case 20:
                    aVar.nu(jSONObject.optInt(next));
                    break;
                case 21:
                    aVar.zm(jSONObject.optInt(next));
                    break;
                case 22:
                    aVar.i(jSONObject.optBoolean(next));
                    break;
                case 23:
                    aVar.z(jSONObject.optInt(next));
                    break;
                case 24:
                    aVar.gr(jSONObject.optInt(next));
                    break;
                case 25:
                    aVar.tt(jSONObject.optDouble(next));
                    break;
                case 26:
                    aVar.a(jSONObject.optDouble(next));
                    break;
                case 27:
                    aVar.my(jSONObject.optInt(next));
                    break;
                case 28:
                    aVar.x(jSONObject.optBoolean(next));
                    break;
                case 29:
                    aVar.sl(jSONObject.optInt(next));
                    break;
                case 30:
                    aVar.a(jSONObject.optString(next));
                    break;
                case 31:
                    aVar.yp(jSONObject.optBoolean(next));
                    break;
                case 32:
                    aVar.sp(jSONObject.optBoolean(next));
                    break;
                case 33:
                    aVar.sl(jSONObject.optString(next));
                    break;
                case 34:
                    aVar.qy(jSONObject.optInt(next));
                    break;
                case 35:
                    aVar.gt(jSONObject.optString(next));
                    break;
                case 36:
                    aVar.gt(jSONObject.optInt(next));
                    break;
                case 37:
                    aVar.c(jSONObject.optBoolean(next));
                    break;
                case 38:
                    aVar.x((float) jSONObject.optDouble(next));
                    break;
                case 39:
                    aVar.my(jSONObject.optString(next));
                    break;
                case 40:
                    aVar.n(jSONObject.optString(next));
                    break;
                case 41:
                    aVar.rl(jSONObject.optInt(next));
                    break;
                case 42:
                    aVar.uj((float) jSONObject.optDouble(next));
                    break;
                case 43:
                    aVar.ve(jSONObject.optDouble(next));
                    break;
                case 44:
                    aVar.n((float) jSONObject.optDouble(next));
                    break;
                case 45:
                    aVar.sl(jSONObject.optBoolean(next));
                    break;
                case 46:
                    aVar.yp(jSONObject.optBoolean(next));
                    break;
                case 47:
                    aVar.i((float) jSONObject.optDouble(next));
                    break;
                case 48:
                    aVar.rh(jSONObject.optString(next));
                    break;
                case 49:
                    aVar.h(jSONObject.optInt(next));
                    break;
                case 50:
                    aVar.sp((float) jSONObject.optDouble(next));
                    break;
                case 51:
                    aVar.x(jSONObject.optString(next));
                    break;
                case 52:
                    aVar.i(jSONObject.optString(next));
                    break;
                case 53:
                    aVar.m(jSONObject.optInt(next));
                    break;
                case 54:
                    aVar.n(jSONObject.optBoolean(next));
                    break;
                case 55:
                    aVar.u(jSONObject.optInt(next));
                    break;
                case 56:
                    aVar.nu(jSONObject.optString(next));
                    break;
                case 57:
                    JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(next);
                    if (jSONObjectOptJSONObject != null) {
                        aVar.sp(jSONObjectOptJSONObject.optInt("translateY", 0));
                        aVar.x(jSONObjectOptJSONObject.optInt("translateX", 0));
                        aVar.uj(jSONObjectOptJSONObject.optDouble("scaleX", 0.0d));
                        aVar.n(jSONObjectOptJSONObject.optDouble("scaleY", 0.0d));
                    }
                    break;
                case 58:
                    aVar.uj(jSONObject.optBoolean(next));
                    break;
                case 59:
                    aVar.t(jSONObject.optString(next));
                    break;
                case 60:
                    aVar.yp(jSONObject.optString(next));
                    break;
                case 61:
                    aVar.c((float) jSONObject.optDouble(next));
                    break;
                case 62:
                    aVar.m(jSONObject.optString(next));
                    break;
                case 63:
                    aVar.da(jSONObject.optString(next));
                    break;
                case 64:
                    aVar.rh(jSONObject.optInt(next));
                    break;
                case 65:
                    aVar.tt((float) jSONObject.optDouble(next));
                    break;
                case 66:
                    aVar.t(jSONObject.optInt(next));
                    break;
                case 67:
                    aVar.yp(jSONObject.optInt(next));
                    break;
            }
        }
    }
}
