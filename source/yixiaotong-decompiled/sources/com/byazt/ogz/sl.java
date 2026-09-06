package com.byazt.ogz;

import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.mobads.sdk.internal.bn;
import com.byazt.aas.eo;
import com.byazt.aas.gr;
import com.byazt.aas.md;
import com.byazt.aas.yv;
import com.byazt.aas.zb;
import com.byazt.aas.zm;
import com.byazt.el.SSWebView;
import com.byazt.ete.aw;
import com.byazt.ete.cu;
import com.byazt.ete.d;
import com.byazt.ete.f;
import com.byazt.ete.gu;
import com.byazt.ete.kp;
import com.byazt.ete.nb;
import com.byazt.ete.or;
import com.byazt.ete.pu;
import com.byazt.nr.m;
import com.byazt.nr.rh;
import com.byazt.omf.gt;
import com.byazt.omf.p;
import com.byazt.ouz.rl;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.google.android.exoplayer2.C;
import com.yfanads.android.libs.net.UrlConst;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 1190, 158})
public class sl implements n {
    public static int n = Integer.MAX_VALUE;
    public static final String oq = null;
    public static int uj = Integer.MAX_VALUE;
    public static int ve = Integer.MAX_VALUE;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile com.byazt.it.n f2549a;
    public int ab;
    public int an;
    public int az;
    public String b;
    public int bj;
    public String bm;
    public final AtomicInteger bn;
    public int bp;
    public boolean br;
    public int bs;
    public long bw;
    public JSONObject by;
    public JSONObject bz;
    public String ca;
    public aw cf;
    public int cg;
    public boolean cj;
    public volatile SharedPreferences ck;
    public boolean cl;
    public boolean cs;
    public float cx;
    public volatile boolean cy;
    public String d;
    public int db;
    public String dh;
    public float di;
    public boolean dn;
    public boolean dp;
    public volatile boolean dr;
    public String e;
    public int ef;
    public int ej;
    public Map<String, Object> ek;
    public int em;
    public JSONObject en;
    public final Object ew;
    public Object ey;
    public int fb;
    public boolean fe;
    public SharedPreferences fk;
    public String fq;
    public JSONObject fr;
    public JSONObject ft;
    public int fv;
    public int gc;
    public boolean ge;
    public String gk;
    public String gl;
    public boolean hc;
    public boolean hg;
    public Boolean hl;
    public JSONObject hm;
    public JSONObject hs;
    public int hy;
    public List<Integer> hz;
    public tt id;

    /* JADX INFO: renamed from: if, reason: not valid java name */
    public boolean f924if;
    public int ij;
    public int il;
    public String is;
    public int iw;
    public int ix;
    public boolean iy;
    public sp jc;
    public int jf;
    public float jg;
    public boolean jl;
    public long jm;
    public boolean js;
    public String jt;
    public boolean jy;
    public float k;
    public int ka;
    public int ki;
    public com.byazt.mw.c kk;
    public float kn;
    public boolean kq;
    public volatile SharedPreferences ku;
    public final int kz;
    public float la;
    public String lr;
    public int ls;
    public long lt;
    public int lv;
    public boolean lw;
    public boolean lx;
    public float ly;
    public JSONObject lz;
    public int mc;
    public JSONObject mf;
    public JSONObject mk;
    public boolean mn;
    public final String mq;
    public int mu;
    public String nc;
    public int ne;
    public int nh;
    public int nl;
    public String nm;
    public volatile int nq;
    public String nx;
    public JSONObject o;
    public int op;
    public JSONObject pa;
    public boolean pb;
    public String pe;
    public int ph;
    public int pi;
    public int pl;
    public int po;
    public int pr;
    public JSONObject pu;
    public volatile com.byazt.it.ve px;
    public int pz;
    public nb q;
    public t qe;
    public int qi;
    public JSONObject qt;
    public int ra;
    public JSONArray ri;
    public int rm;
    public String rp;
    public JSONObject ru;
    public float sd;
    public int sf;
    public volatile com.byazt.it.ve sp;
    public int st;
    public boolean sy;
    public JSONObject te;
    public int tj;
    public String to;
    public JSONObject tp;
    public JSONObject ts;
    public JSONArray tu;
    public String tw;
    public int ul;
    public a up;
    public int ur;
    public JSONObject uv;
    public int vi;
    public rl vl;
    public int vr;
    public int vt;
    public boolean vx;
    public Boolean vz;
    public int w;
    public boolean wj;
    public int wn;
    public boolean wo;
    public int wq;
    public int wy;
    public int x;
    public int xg;
    public boolean xl;
    public Boolean xo;
    public String xr;
    public String xv;
    public Boolean xw;
    public String xx;
    public int yg;
    public int ym;
    public int ys;
    public int yt;
    public Boolean yw;
    public volatile int yx;
    public int zo;
    public int zr;
    public static final int[] ox = {1, 3, 5};
    public static volatile boolean na = false;
    public static volatile boolean dw = true;
    public int i = Integer.MAX_VALUE;
    public Set<String> da = Collections.synchronizedSet(new HashSet());
    public int sl = Integer.MAX_VALUE;
    public int t = Integer.MAX_VALUE;
    public int u = Integer.MAX_VALUE;
    public int yp = Integer.MAX_VALUE;
    public String z = null;
    public int m = Integer.MAX_VALUE;
    public int nu = Integer.MAX_VALUE;
    public int rh = Integer.MAX_VALUE;
    public int my = Integer.MIN_VALUE;
    public int gt = Integer.MIN_VALUE;
    public int rl = Integer.MIN_VALUE;
    public int qy = Integer.MIN_VALUE;
    public int gu = 0;
    public int gr = Integer.MAX_VALUE;
    public int zm = Integer.MAX_VALUE;
    public int yv = Integer.MAX_VALUE;
    public int p = -1;
    public int md = Integer.MIN_VALUE;
    public int h = Integer.MIN_VALUE;
    public String eo = null;
    public int c = 0;
    public int zb = Integer.MIN_VALUE;
    public int or = Integer.MAX_VALUE;
    public int tt = 10;
    public int cu = Integer.MAX_VALUE;
    public com.byazt.dz.tt qp = null;
    public int nb = 1;
    public com.byazt.tl.uj pf = null;
    public boolean bx = false;
    public int sv = Integer.MAX_VALUE;
    public int aw = Integer.MIN_VALUE;
    public final Map<String, c> ic = new ConcurrentHashMap();
    public Map<String, com.byazt.ku.uj> hd = new HashMap();
    public Set<String> l = Collections.synchronizedSet(new HashSet());
    public final List<Object> lo = new CopyOnWriteArrayList();
    public JSONObject tk = null;
    public String kp = "";
    public int tx = Integer.MAX_VALUE;
    public int v = Integer.MAX_VALUE;
    public long os = 0;
    public Set<String> oz = new ConcurrentSkipListSet();
    public Set<String> r = new ConcurrentSkipListSet();
    public Set<String> s = new ConcurrentSkipListSet();
    public int y = Integer.MAX_VALUE;
    public int iu = Integer.MAX_VALUE;
    public long j = 2147483647L;
    public int dz = Integer.MAX_VALUE;
    public int ma = Integer.MAX_VALUE;
    public int yf = Integer.MAX_VALUE;
    public int f = Integer.MAX_VALUE;
    public int ir = Integer.MAX_VALUE;
    public int g = 0;
    public long hj = 0;
    public int xd = 0;
    public long hq = 0;
    public int ny = Integer.MAX_VALUE;
    public JSONObject nt = null;
    public JSONObject gx = null;
    public Set<String> gy = null;
    public Set<String> mm = null;
    public JSONObject pn = null;
    public int yo = 3;
    public int vp = Integer.MAX_VALUE;

    public static String n() {
        return "tt_sdk_settings_other_bst";
    }

    public boolean br() {
        return this.f924if;
    }

    public sp bw() {
        return this.jc;
    }

    public void c(int i) {
        this.iu = i;
    }

    public aw cf() {
        return this.cf;
    }

    public boolean cg() {
        return this.nb == 1;
    }

    public boolean cl() {
        return Build.VERSION.SDK_INT < this.yt;
    }

    public JSONObject cs() {
        return this.by;
    }

    public void d() {
        this.is = "api-access.pangolin-sdk-toutiao-b.com";
    }

    public boolean dh() {
        return this.iy;
    }

    public boolean dn() {
        return this.lx;
    }

    public boolean ek() {
        return this.kq;
    }

    public boolean em() {
        return this.sy;
    }

    public JSONObject f() {
        return this.o;
    }

    public boolean fb() {
        return this.pb;
    }

    public int fq() {
        return this.ab;
    }

    public int fr() {
        return this.ys;
    }

    public JSONObject gy() {
        return this.lz;
    }

    public t hl() {
        return this.qe;
    }

    public int hz() {
        return this.wn;
    }

    public com.byazt.tl.uj ij() {
        return this.pf;
    }

    public boolean il() {
        return this.dr;
    }

    public int iy() {
        int i = this.ne;
        if (i <= 0) {
            return 1;
        }
        return i;
    }

    public boolean jl() {
        return this.dp;
    }

    public boolean jy() {
        return this.wj;
    }

    public boolean k() {
        return this.an != 1;
    }

    public boolean ka() {
        return this.ge;
    }

    public tt ku() {
        return this.id;
    }

    public JSONObject kz() {
        return this.tp;
    }

    public int la() {
        return this.mc;
    }

    public boolean mc() {
        return this.br;
    }

    public JSONObject mm() {
        return this.ts;
    }

    public JSONArray mq() {
        return this.ri;
    }

    public boolean nc() {
        return this.pr == 1;
    }

    public JSONObject nq() {
        return this.uv;
    }

    public JSONObject nt() {
        return this.nt;
    }

    public boolean ox() {
        return this.xl;
    }

    public JSONObject pn() {
        return this.pa;
    }

    public JSONObject po() {
        return this.fr;
    }

    public boolean qe() {
        return this.js;
    }

    public boolean qi() {
        return this.pi == 1;
    }

    public boolean rh() {
        return this.em == 1;
    }

    public boolean tk() {
        if (this.iu == Integer.MAX_VALUE) {
            this.iu = 1;
        }
        return this.iu == 1;
    }

    public String tt() {
        return this.d;
    }

    public boolean tw() {
        return this.hy == 1;
    }

    public boolean uj() {
        return this.qi == 1;
    }

    public int ul() {
        return this.zo;
    }

    public int up() {
        return this.vt;
    }

    public boolean uv() {
        return this.lw;
    }

    public JSONObject vi() {
        return this.te;
    }

    public JSONObject vp() {
        return this.hs;
    }

    public int wq() {
        return this.tj;
    }

    public int xg() {
        return this.wy;
    }

    public boolean xo() {
        return this.vx;
    }

    public int xr() {
        return this.bs;
    }

    public int xv() {
        return this.st;
    }

    public boolean xw() {
        return this.jy;
    }

    public boolean xx() {
        return this.wo;
    }

    public boolean yg() {
        return this.cj;
    }

    public boolean ym() {
        return this.bx;
    }

    public JSONObject yo() {
        return this.ft;
    }

    public boolean ys() {
        return this.nh != 1;
    }

    public a yt() {
        return this.up;
    }

    public int yv() {
        return this.gu;
    }

    public sl() {
        int iVe = com.byazt.hef.tt.ve();
        this.kz = iVe;
        this.vi = iVe;
        this.mq = "live_sdk_conf";
        this.ij = Integer.MAX_VALUE;
        this.az = Integer.MAX_VALUE;
        this.is = null;
        this.jt = null;
        this.w = Integer.MAX_VALUE;
        this.nl = Integer.MAX_VALUE;
        this.ej = Integer.MAX_VALUE;
        this.pl = 0;
        this.di = 0.0f;
        this.jg = 0.0f;
        this.hg = false;
        this.sd = 8.5f;
        this.k = 7.3f;
        this.gk = null;
        this.e = null;
        this.pe = null;
        this.nx = "apps.bytesfield.com";
        this.iw = Integer.MAX_VALUE;
        this.bj = Integer.MAX_VALUE;
        this.bp = 0;
        this.ph = 2;
        this.dr = false;
        this.ly = -1.0f;
        this.cx = 2.14748365E9f;
        this.mf = null;
        this.fv = Integer.MAX_VALUE;
        this.st = 2;
        this.en = null;
        this.o = null;
        this.hc = false;
        this.ab = 3;
        this.an = 0;
        this.ne = 1;
        this.ix = Integer.MAX_VALUE;
        this.tp = null;
        this.pr = 0;
        this.gl = null;
        this.ru = null;
        this.op = 0;
        this.tj = 0;
        this.nm = null;
        this.il = 1;
        this.pb = true;
        this.sy = false;
        this.uv = null;
        this.ul = 1;
        this.xr = "跳过";
        this.ys = 0;
        this.up = new a();
        this.xg = 0;
        this.sf = 0;
        this.fq = "";
        this.xv = "95d9ae8de4e66aaf458fdd49879c67fa";
        this.rp = "https://sf3-fe-tos.pglstatp-toutiao.com/obj/csj-sdk-static/uchain/20108/uchain_dsl.bin";
        this.ra = -1;
        this.bw = -1L;
        this.yt = 0;
        this.jm = 2147483647L;
        this.ym = Integer.MAX_VALUE;
        this.jf = Integer.MAX_VALUE;
        this.vr = Integer.MAX_VALUE;
        this.ls = Integer.MAX_VALUE;
        this.wq = Integer.MAX_VALUE;
        this.ef = Integer.MAX_VALUE;
        this.fb = Integer.MAX_VALUE;
        this.nq = Integer.MAX_VALUE;
        this.ku = null;
        this.mk = null;
        this.by = null;
        this.fr = null;
        this.ck = null;
        this.ey = new Object();
        this.f2549a = null;
        this.qt = null;
        this.fe = false;
        this.ge = false;
        this.br = false;
        this.dn = false;
        this.hz = new ArrayList();
        this.cs = false;
        this.la = -1.0f;
        this.po = -1;
        this.kn = -1.0f;
        this.ka = -1;
        this.mc = 0;
        this.x = 0;
        this.jc = new sp();
        this.qe = null;
        this.jy = true;
        this.jl = false;
        this.yg = 0;
        this.cg = Integer.MAX_VALUE;
        this.f924if = false;
        this.xl = false;
        this.lx = false;
        this.wn = 0;
        this.qi = 1;
        this.ek = new HashMap();
        this.tw = "";
        this.hl = null;
        this.xo = null;
        this.bz = null;
        this.js = true;
        this.wj = true;
        this.dp = false;
        this.cj = false;
        this.wo = false;
        this.lv = Integer.MAX_VALUE;
        this.cy = true;
        this.yx = Integer.MAX_VALUE;
        this.lw = true;
        this.zo = 0;
        this.zr = 0;
        this.bn = new AtomicInteger(-1);
        this.ur = -1;
        this.mu = -1;
        this.rm = -1;
        this.vz = null;
        this.yw = null;
        this.bs = 1000;
        this.nh = 1;
        this.pi = 0;
        this.hy = 0;
        this.ki = -1;
        this.kq = false;
        this.vx = true;
        this.db = Integer.MAX_VALUE;
        this.gc = Integer.MAX_VALUE;
        this.pz = Integer.MAX_VALUE;
        this.ew = new Object();
        this.d = com.byazt.vxy.c.uj();
    }

    public com.byazt.it.n ve() {
        if (this.f2549a == null) {
            this.f2549a = com.byazt.vif.uj.tt(this.d, n());
        }
        return this.f2549a;
    }

    public static String a() {
        return com.byazt.xo.c.x() ? "tt_sdk_lp_w_list_bst" : "tt_sdk_lp_w_list";
    }

    public static String sp() {
        return com.byazt.xo.c.x() ? "tt_sdk_settings_slot_bst" : "tt_sdk_settings_slot";
    }

    public static String x() {
        return com.byazt.xo.c.x() ? "tt_sdk_settings_slot_splash_bst" : "tt_sdk_settings_slot_splash";
    }

    public com.byazt.it.ve i() {
        if (this.px == null) {
            this.px = com.byazt.vif.uj.c(this.d, sp());
        }
        if (eo.tt() != 1) {
            return null;
        }
        return this.px;
    }

    private com.byazt.it.ve mn() {
        if (this.sp == null) {
            this.sp = com.byazt.vif.uj.c(this.d, a());
        }
        return this.sp;
    }

    public boolean da() {
        if (this.ki == -1) {
            this.ki = ve().getInt("stats_report_register_info", 0);
        }
        return this.ki == 1;
    }

    private void sl(int i) {
        if (i <= 0) {
            i = 1;
        }
        com.byazt.ga.sp.c(i);
    }

    public boolean sl() {
        if (this.bn.get() == -1) {
            this.bn.set(ve().get("lottie_disable_os7_and_below", 0));
        }
        return this.bn.get() == 1;
    }

    public int t() {
        if (this.ur == -1) {
            this.ur = ve().get("lottie_image_cache_resource_limit", 30);
        }
        return this.ur;
    }

    public boolean u() {
        if (this.mu == -1) {
            this.mu = ve().get("lottie_zip_download_disable", false) ? 1 : 0;
        }
        return this.mu == 1;
    }

    public boolean yp() {
        if (this.rm == -1) {
            this.rm = ve().getInt("video_size_gap_report", 0);
        }
        return this.rm == 1;
    }

    public JSONObject z() {
        if (this.hm == null) {
            String str = ve().get("settings_json_str", "");
            if (!TextUtils.isEmpty(str)) {
                String strVe = com.byazt.nr.c.ve(str);
                if (!TextUtils.isEmpty(strVe)) {
                    try {
                        this.hm = new JSONObject(strVe);
                    } catch (JSONException e) {
                        m.c(e);
                    }
                }
            }
        }
        return this.hm;
    }

    @Override // com.byazt.ogz.n
    public synchronized void c() {
        try {
            ve();
            this.dr = true;
            this.ma = this.f2549a.get("adlog_exception_batch", 100);
            this.nc = this.f2549a.get("url_stats", "api-access.pangolin-sdk-toutiao1.com");
            this.qi = this.f2549a.get("open_mini_game", 1);
            this.ca = this.f2549a.get("img_bucket", "https://sf3-fe-tos.pglstatp-toutiao.com/obj/csj-sdk-static/csj_assets/");
            this.cl = this.f2549a.get("enable_apm_pv", false);
            this.jt = this.f2549a.get("url_alog", "log-api.pangolin-sdk-toutiao-b.com/service/2/app_log/");
            this.to = this.f2549a.get("xpath", "");
            this.lt = this.f2549a.get("data_time", 0L);
            this.az = this.f2549a.get("fetch_template", 3600);
            this.ij = this.f2549a.get("vbtt", 5);
            this.lr = this.f2549a.get("template_ids", this.gl);
            this.b = this.f2549a.get("pyload_h5", this.gl);
            this.q = nb.c(this.f2549a.get("insert_js_config", this.gl));
            this.tx = this.f2549a.get("splash_check_type", 1);
            this.yf = this.f2549a.get("adlog_debug", 0);
            this.dz = this.f2549a.get("adlog_batch", 10);
            this.j = this.f2549a.get("adlog_interval", 5000L);
            this.gu = this.f2549a.get("splash_enable_rotate", 0);
            this.rh = this.f2549a.get("enable_kite", 0);
            this.ma = this.f2549a.get("adlog_exception_batch", 100);
            this.f = this.f2549a.get("adlog_monitor", 1);
            this.p = this.f2549a.get("enable_ttvideo", -1);
            this.md = this.f2549a.get("enable_zaid", 0);
            this.h = this.f2549a.get("player_stats_check_switch", 1);
            this.gr = this.f2549a.get("enable_cdn_opt", 0);
            this.yv = this.f2549a.get("download_button_effect", 0);
            this.xd = this.f2549a.get("enable_dl_ext", this.g);
            this.aw = this.f2549a.get("enable_oaid_frequency", 0);
            this.hq = this.f2549a.get("ext_use_type", this.hj);
            this.ir = this.f2549a.get("enable_glgpu", 0);
            this.c = this.f2549a.get("launch_strategy", 0);
            this.zb = this.f2549a.get("dl_popup_duration", 1000);
            this.or = this.f2549a.get("opt_show_check", 0);
            this.vl = rl.c(this.f2549a.get("tpl_timeout_ctrl", ""), this.d);
            this.mc = this.f2549a.get("enableUChainDownLoad", 0);
            SSWebView.setMaxWebViewCount(this.f2549a.get("open_webview_count", 0));
            String str = this.f2549a.get("digest", "");
            if (!TextUtils.isEmpty(str)) {
                try {
                    this.pu = new JSONObject(str);
                } catch (Exception e) {
                    m.c(e);
                }
            }
            String str2 = this.f2549a.get("pitaya_general_settings", "");
            if (!TextUtils.isEmpty(str2)) {
                try {
                    this.nt = new JSONObject(str2);
                } catch (Exception e2) {
                    m.c(e2);
                }
            }
            String str3 = this.f2549a.get("dl_notification", "");
            if (!TextUtils.isEmpty(str3)) {
                try {
                    this.hs = new JSONObject(str3);
                } catch (Exception unused) {
                }
            }
            String str4 = this.f2549a.get("live_stream_cof", "");
            if (!TextUtils.isEmpty(str4)) {
                try {
                    this.lz = new JSONObject(str4);
                } catch (Exception e3) {
                    m.uj("parse exception", "e:" + e3.getMessage());
                }
            }
            String str5 = this.f2549a.get("volume", "");
            if (!TextUtils.isEmpty(str5)) {
                try {
                    this.ts = new JSONObject(str5);
                } catch (Exception unused2) {
                }
            }
            String str6 = this.f2549a.get("brightness", "");
            if (!TextUtils.isEmpty(str5)) {
                try {
                    this.pa = new JSONObject(str6);
                } catch (Exception unused3) {
                }
            }
            String str7 = this.f2549a.get("video_start", "");
            if (!TextUtils.isEmpty(str5)) {
                try {
                    this.ft = new JSONObject(str7);
                } catch (Exception unused4) {
                }
            }
            this.ix = this.f2549a.get("disable_show_url", 0);
            String str8 = this.f2549a.get("sensor_direction", "");
            if (!TextUtils.isEmpty(str8)) {
                try {
                    this.tp = new JSONObject(str8);
                } catch (Exception e4) {
                    m.uj("parse ex", "e:" + e4.getMessage());
                }
            }
            String str9 = this.f2549a.get("pitaya_business_conf", "");
            if (!TextUtils.isEmpty(str9)) {
                try {
                    this.te = new JSONObject(str9);
                } catch (Exception e5) {
                    m.uj("parse exception", "e:" + e5.getMessage());
                }
            }
            String str10 = this.f2549a.get("pitaya_applog_event_filter", "");
            if (!TextUtils.isEmpty(str10)) {
                try {
                    this.ri = new JSONArray(str10);
                } catch (Exception e6) {
                    m.uj("parse exception", "e:" + e6.getMessage());
                }
            }
            String str11 = this.f2549a.get("http_drop", "");
            if (!TextUtils.isEmpty(str11)) {
                try {
                    this.pn = new JSONObject(str11);
                } catch (Exception e7) {
                    m.c(e7);
                }
            }
            this.yo = this.f2549a.get("stats_batch", 5);
            this.vp = this.f2549a.get("max_memory_event_count", 10000);
            this.ny = this.f2549a.get("switch_audio_focus", 0);
            this.cu = this.f2549a.get("download_receiver_enable", 1);
            this.vi = this.f2549a.get("event_switch", this.kz);
            this.tt = this.f2549a.get("pre_fetch_cnt", 10);
            this.y = this.f2549a.get("if_both_open", 0);
            this.bm = this.f2549a.get("tpl_infos", this.gl);
            this.bw = this.f2549a.get("gnd_prefetch_cache_ttl", 0L);
            this.ra = this.f2549a.get("gnd_prefetch_cache_size", 5);
            this.cx = this.f2549a.get("global_sample", 1.0f);
            this.v = this.f2549a.get("app_list_control", 0);
            this.w = this.f2549a.get("max_tpl_cnts", 100);
            this.nl = this.f2549a.get("fetch_tpl_timeout_ctrl", 5000);
            this.ej = this.f2549a.get("interact_show_after_time", 500);
            this.pl = this.f2549a.get("fetch_tpl_timeout_ctrl_bad_device", 300);
            this.di = this.f2549a.get("tpl_render_error_rate_h5", 4.5f);
            this.hg = this.f2549a.get("tpl_enable_render_timeout_opt", false);
            this.jg = this.f2549a.get("tpl_render_error_rate_native", 1.0f);
            this.br = this.f2549a.get("enable", false);
            this.sd = this.f2549a.get("mid_value", 8.5f);
            this.k = this.f2549a.get("low_value", 7.3f);
            this.iy = this.f2549a.get("open_single_abi", false);
            this.lv = this.f2549a.get("show_callback_mult", 0);
            this.bj = this.f2549a.get("webview_cache_count", 0);
            this.bp = this.f2549a.get("webview_cache_count_v3", 0);
            this.ph = this.f2549a.get("webview_render_concurrent_count", 2);
            this.dh = this.f2549a.get("policy_url", oq);
            this.hl = Boolean.valueOf(this.f2549a.get("use_mediation_map", false));
            this.os = this.f2549a.get("hit_app_list_time", 0L);
            this.oz.clear();
            this.eo = this.f2549a.get("apm_pv_config", "");
            this.gk = this.f2549a.get("dyn_draw_engine_url", "https://sf3-fe-tos.pglstatp-toutiao.com/obj/ad-pattern/renderer/package.json");
            this.e = this.f2549a.get("play_component_ugen_engine_url", "");
            this.pe = this.f2549a.get("local_res_zip_url", "");
            this.nx = this.f2549a.get("ad_pkg_info_url", "apps.bytesfield.com");
            this.iw = this.f2549a.get("sp_key_if_sp_cache", 1);
            this.my = this.f2549a.get("express_gesture_enable", 0);
            this.rl = this.f2549a.get("opt_click_chain", 0);
            this.qy = this.f2549a.get("main_start_downloader", 0);
            this.gt = this.f2549a.get("app_express_gesture_priority", -1);
            this.xr = this.f2549a.get("splash_close_text", "跳过");
            this.sv = this.f2549a.get("network_module", 1);
            com.byazt.yr.c.c().c(this.sv != 2);
            this.i = this.f2549a.get("web_upload_enable", 0);
            Set<String> set = this.f2549a.get("web_upload_content_type", Collections.synchronizedSet(new HashSet()));
            this.da.clear();
            if (set != null && set.size() != 0) {
                Iterator<String> it = set.iterator();
                while (it.hasNext()) {
                    this.da.add(it.next());
                }
            }
            this.sl = this.f2549a.get("web_upload_send_restowv", 0);
            this.t = this.f2549a.get("web_upload_max_single_file", 2);
            this.u = this.f2549a.get("web_upload_max_zip_file", 5);
            this.nu = this.f2549a.get("web_upload_max_retry", 0);
            this.z = this.f2549a.get("web_upload_report_url", "https://api-access.pangolin-sdk-toutiao.com/v2/inspect/aegis/client/page/");
            this.m = this.f2549a.get("web_upload_storage_type", 0);
            this.yp = this.f2549a.get("web_upload_report_only_wifi", 0);
            Set<String> set2 = this.f2549a.get("hit_app_list_data", Collections.synchronizedSet(new HashSet()));
            if (set2 != null && !set2.isEmpty()) {
                Iterator<String> it2 = set2.iterator();
                while (it2.hasNext()) {
                    this.oz.add(it2.next());
                }
            }
            synchronized (this.r) {
                this.r.clear();
                Set<String> set3 = this.f2549a.get("scheme_list_data", Collections.synchronizedSet(new HashSet()));
                if (set3 != null && !set3.isEmpty()) {
                    Iterator<String> it3 = set3.iterator();
                    while (it3.hasNext()) {
                        this.r.add(it3.next());
                    }
                }
            }
            synchronized (this.s) {
                this.s.clear();
                Set<String> set4 = this.f2549a.get("top_scheme_list_data", Collections.synchronizedSet(new HashSet()));
                if (set4 != null && !set4.isEmpty()) {
                    Iterator<String> it4 = set4.iterator();
                    while (it4.hasNext()) {
                        this.s.add(it4.next());
                    }
                }
            }
            String str12 = this.f2549a.get("download_sdk_config", "");
            this.kp = str12;
            if (!TextUtils.isEmpty(str12)) {
                try {
                    this.tk = new JSONObject(this.kp);
                } catch (JSONException e8) {
                    m.ve("TTSdkSettings", e8);
                }
            }
            String str13 = this.f2549a.get("thread_config", "");
            if (!TextUtils.isEmpty(str13)) {
                try {
                    this.o = new JSONObject(str13);
                    com.byazt.jv.c.tt();
                } catch (JSONException e9) {
                    m.ve("TTSdkSettings", e9);
                }
            }
            this.ly = this.f2549a.get("call_stack_rate", 0.0f);
            this.fv = this.f2549a.get("read_video_from_cache", 1);
            this.st = this.f2549a.get("brand_video_cache_count", 2);
            this.hc = this.f2549a.get("enable_bw_screen_detection", false);
            this.ab = this.f2549a.get("splash_card_show_max_count", 3);
            this.qp = com.byazt.dz.tt.c(this.f2549a.get("clog_config", this.gl));
            this.pf = com.byazt.tl.uj.c(this.f2549a.get("oncall_upload", ""));
            this.nb = this.f2549a.get("feedback_opt", 1);
            this.bx = this.f2549a.get("check_live_room", false);
            this.pb = this.f2549a.get("can_init_live", true);
            this.sy = this.f2549a.get("new_app_list", false);
            String str14 = this.f2549a.get("plugin_update_state", "");
            if (!TextUtils.isEmpty(str14)) {
                try {
                    this.uv = new JSONObject(str14);
                } catch (JSONException e10) {
                    m.c(e10);
                }
            }
            String str15 = this.f2549a.get("antispam_autoclick_detect", "");
            if (!TextUtils.isEmpty(str15)) {
                try {
                    this.mk = new JSONObject(str15);
                    com.byazt.dna.n nVarTt = gr.tt();
                    if (nVarTt != null) {
                        nVarTt.updateHARSettings(this.mk);
                    }
                } catch (JSONException e11) {
                    m.c(e11);
                }
            }
            String str16 = this.f2549a.get("plugin_retry_opt", "");
            if (!TextUtils.isEmpty(str16)) {
                try {
                    this.by = new JSONObject(str16);
                } catch (JSONException e12) {
                    m.c(e12);
                }
            }
            String str17 = this.f2549a.get("plugin_downloader_settings", "");
            if (!TextUtils.isEmpty(str17)) {
                try {
                    this.fr = new JSONObject(str17);
                } catch (JSONException e13) {
                    m.c(e13);
                }
            }
            String str18 = this.f2549a.get("app_live_config", "");
            if (!TextUtils.isEmpty(str18)) {
                try {
                    this.id = tt.c(new JSONObject(str18));
                } catch (JSONException unused5) {
                }
            }
            String str19 = this.f2549a.get("pglam", "");
            if (!TextUtils.isEmpty(str19)) {
                try {
                    JSONObject jSONObject = new JSONObject(str19);
                    this.ru = jSONObject;
                    com.byazt.aas.ve.c(jSONObject);
                    ve = this.ru.optInt("pgl_4TypeEncrypt_close", 0);
                    uj = this.ru.optInt("pgl_soIntegrity_check", 0);
                    n = this.ru.optInt("pgl_soverfailstrategy_enable", 0);
                } catch (JSONException e14) {
                    m.c(e14);
                }
            }
            this.op = this.f2549a.get("pglam_main_enable", 0);
            this.tj = this.f2549a.get("pglam_dns_check_enable", 0);
            this.nm = this.f2549a.get("pglam_clazz_check", "");
            this.il = this.f2549a.get("ud_enable", 1);
            this.ys = js().getInt("is_kv_cache_type", 0);
            this.xg = js().getInt("kv_init_type", 0);
            this.yg = this.f2549a.get("open_dl_type", 0);
            this.xx = this.f2549a.get("app_dl_scheme_list", "");
            int i = this.f2549a.get("lp_url_sw", 0);
            this.sf = i;
            if (i == 1) {
                this.fq = mn().get("lp_list", "");
            }
            this.xv = js().getString("md5", "");
            String string = js().getString("url", "");
            this.rp = string;
            com.byazt.ppf.ve.c(this.xv, string, this.d);
            Boolean boolValueOf = Boolean.valueOf(this.f2549a.get("rule_engine_enable", false));
            this.xw = boolValueOf;
            try {
                if (boolValueOf.booleanValue()) {
                    JSONArray jSONArray = new JSONArray(this.f2549a.get("rule_engine_list", ""));
                    this.tu = jSONArray;
                    com.byazt.jze.tt.c(jSONArray, this.d);
                }
            } catch (Throwable unused6) {
            }
            this.ul = this.f2549a.get("is_open_isw", 1);
            String str20 = this.f2549a.get("live_sdk_conf", this.gl);
            if (!TextUtils.isEmpty(str20)) {
                this.cf = aw.c(str20);
            }
            this.x = this.f2549a.get("npth_enable_type", 0);
            this.an = this.f2549a.get("scheme_get_type", 0);
            this.ne = this.f2549a.get("scheme_get_num", 1);
            this.pr = this.f2549a.get("if_query_all_package", 0);
            this.jy = this.f2549a.get("is_sp_send_meta", true);
            this.jc = sp.c(this.f2549a.get("opt_config", ""));
            this.qe = t.c(this.f2549a.get("user_interaction_config", ""));
            this.up = a.c(this.f2549a.get("kv_config", ""));
            this.jl = this.f2549a.get("is_first_plugin_resources", false);
            this.cg = this.f2549a.get("m_vids_join", 0);
            this.yt = this.f2549a.get("mini_event_upload_version", 0);
            this.jm = this.f2549a.get("bg_web_readd_t", C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS);
            this.ym = this.f2549a.get("title_priority", 0);
            this.jf = this.f2549a.get("splash_video_opt_enable", 0);
            this.zm = this.f2549a.get("support_live_code", -1);
            this.vr = this.f2549a.get("gesture_through_enable", 0);
            this.ls = this.f2549a.get("disable_effects", 0);
            this.wq = this.f2549a.get("enable_layout_restrict", 0);
            this.ef = this.f2549a.get("refresh_req_num", 2);
            this.fb = this.f2549a.get("refresh_max_times", 1);
            this.nq = this.f2549a.get("settings_open", 1);
            this.em = this.f2549a.get("shake_trigger_control", 0);
            this.f924if = this.f2549a.get("preload_switch", false);
            this.xl = this.f2549a.get("cache_ana_lru_switch", false);
            this.lx = this.f2549a.get("cache_ana_expire_switch", false);
            this.wn = this.f2549a.get("preload_time_point", 0);
            this.js = this.f2549a.get("is_adapt_density", true);
            this.wj = this.f2549a.get("is_adapt_landscape", true);
            this.mn = this.f2549a.get("app_info_cache_switch", false);
            this.cy = this.f2549a.get("disable_easy_playable", true);
            this.yx = this.f2549a.get("enable_target_34", 1);
            try {
                String str21 = this.f2549a.get("dex_strategy", "");
                if (!TextUtils.isEmpty(str21)) {
                    this.bz = new JSONObject(str21);
                }
            } catch (JSONException unused7) {
            }
            this.lw = this.f2549a.get("disable_repeat_render", true);
            this.zo = this.f2549a.get("status_bar_adapt", 0);
            this.bs = this.f2549a.get("jump_shield_short_duration", 1000);
            this.nh = this.f2549a.get("replace_dummy_video", 1);
            this.vt = this.f2549a.get("template_pull_timeout", -1);
            this.wy = this.f2549a.get("template_pull_type", 0);
            this.dp = this.f2549a.get("view_check_by_window", false);
            this.cj = this.f2549a.get("shake_twist_bind_show", false);
            this.wo = this.f2549a.get("view_check_by_click", false);
            this.vz = Boolean.valueOf(this.f2549a.get("node_line_enable", false));
            this.yw = Boolean.valueOf(this.f2549a.get("node_line_detail_enable", false));
            m.c("Tme_node_line", " local n_l_en:" + this.vz);
            m.c("Tme_node_line", " local n_l_d_en:" + this.yw);
            this.db = this.f2549a.get("dynamic_ugen_v3", 0);
            this.gc = this.f2549a.get("creative_ugen_v3", 0);
            this.pz = this.f2549a.get("creative_ugen_v2", 0);
            this.dn = this.f2549a.get("enable", true);
            this.cs = this.f2549a.get("session_enable", false);
            this.la = this.f2549a.get("feature_stack_rate", 0.0f);
            this.po = this.f2549a.get("view_traverse_depth", 20);
            this.kn = this.f2549a.get("feature_chain_factor", 1.0f);
            this.ka = this.f2549a.get("feature_req_switch", 0);
            this.kq = this.f2549a.get("ignore_query_result", false);
            sl(this.f2549a.get("lottie_composition_cache_size", 20));
            this.ur = this.f2549a.get("lottie_image_cache_resource_limit", 30);
            this.mu = this.f2549a.get("lottie_zip_download_disable", false) ? 1 : 0;
            m();
            this.pi = this.f2549a.get("endcard_lazy", 0);
            this.hy = this.f2549a.get("is_adapt_two_finger", 0);
            this.vx = this.f2549a.get("enable_dynamic_clear_cache", true);
            cu.tt(this.f2549a);
            kp.tt(this.f2549a);
            com.byazt.ete.x.c(this.f2549a);
            d.c(this.f2549a);
            or.c(this.f2549a);
            pu.tt(this.f2549a);
            gu.c(this.f2549a);
            String str22 = this.f2549a.get("video_cache_config", "");
            if (!TextUtils.isEmpty(str22)) {
                try {
                    JSONObject jSONObject2 = new JSONObject(str22);
                    this.en = jSONObject2;
                    com.byazt.ri.c.c(jSONObject2);
                } catch (JSONException e15) {
                    m.c(e15);
                }
            }
            String str23 = this.f2549a.get("log_rate_conf", "");
            if (!TextUtils.isEmpty(str23)) {
                try {
                    this.mf = new JSONObject(str23);
                } catch (Exception unused8) {
                }
            }
            try {
                this.tw = this.f2549a.get("ad_slot_conf_block", "");
                JSONObject jSONObject3 = new JSONObject(this.tw);
                if (jSONObject3.length() > 0) {
                    this.ek.clear();
                    Iterator<String> itKeys = jSONObject3.keys();
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        this.ek.put(next, jSONObject3.opt(next));
                    }
                }
            } catch (Exception unused9) {
            }
            nu();
            com.byazt.lj.c.c(true);
        } catch (Throwable th) {
            throw th;
        }
    }

    public void m() {
        com.byazt.dl.a.c().c(this.f2549a.get("req_exemption_cfg", ""));
    }

    public static void nu() {
        sl slVarTt = gt.tt();
        if (slVarTt != null) {
            boolean zNy = slVarTt.ny();
            if (com.byazt.yxi.ve.tt(com.byazt.omf.x.m().nb()).booleanValue(1) != zNy) {
                com.byazt.omf.x.m().nb().apply(com.byazt.yxi.uj.c().c(10).c(Void.class).c(0, new zb().c("downloadPath", com.byazt.yih.i.c(zNy))).tt());
            }
            if (slVarTt.pb && slVarTt.cf != null) {
                com.byazt.apd.tt.c().tt();
            }
            com.byazt.omf.eo.ve();
            com.byazt.la.c.c().c(gt.getContext());
            com.byazt.nr.da.ve().postDelayed(new Runnable() { // from class: com.byazt.ogz.sl.1
                @Override // java.lang.Runnable
                public void run() {
                    com.byazt.qqc.ve.c().c(gt.tt().pn());
                }
            }, C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS);
        }
    }

    private static c uj(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        String strOptString = jSONObject.optString("code_id");
        boolean zC = md.c(jSONObject, "enable_bidding_cache", false);
        long jC = md.c(jSONObject, "bidding_cache_skip_time", 0L);
        boolean zC2 = md.c(jSONObject, "enable_bidding_pre_fetch", false);
        int iC = md.c(jSONObject, "auto_play", 1);
        int iC2 = md.c(jSONObject, "rv_preload", 2);
        int iC3 = md.c(jSONObject, "nv_preload", 1);
        int iC4 = md.c(jSONObject, "sp_preload", 0);
        int iC5 = md.c(jSONObject, "skip_time_displayed", 0);
        int iC6 = md.c(jSONObject, "reg_creative_control", 1);
        int iC7 = md.c(jSONObject, "rv_skip_time", 0);
        int iC8 = md.c(jSONObject, "iv_skip_time", 0);
        int iC9 = md.c(jSONObject, "stop_time", 1500);
        boolean zC3 = md.c(jSONObject, "close_on_click", false);
        int iC10 = md.c(jSONObject, "splash_load_type", 2);
        int iC11 = md.c(jSONObject, "splash_buffer_time", 100);
        int iC12 = md.c(jSONObject, "time_out_control", 2000);
        int iC13 = md.c(jSONObject, "time_out_control_type", 0);
        int iC14 = md.c(jSONObject, "slot_type", -1);
        return c.c().c(strOptString).x(iC).i(iC2).da(iC3).sl(iC5).t(iC6).a(iC7).uj(iC4).n(iC9).ve(iC12).u(iC10).yp(iC11).sp(iC8).ve(zC3).z(iC13).c(jC).tt(zC).c(zC2).tt(iC14).c(md.c(jSONObject, "refresh_rit_sw", 0));
    }

    private void n(JSONObject jSONObject) {
        Object objRemove = jSONObject.remove("ad_slot_conf_list");
        Object objRemove2 = jSONObject.remove("ad_slot_conf_block");
        String string = jSONObject.toString();
        try {
            jSONObject.putOpt("ad_slot_conf_list", objRemove);
            jSONObject.putOpt("ad_slot_conf_block", objRemove2);
            this.hm = new JSONObject(string);
            ve().put("settings_json_str", com.byazt.nr.c.tt(string));
        } catch (JSONException e) {
            m.c(e);
        }
    }

    @Override // com.byazt.ogz.n
    public void ve(final JSONObject jSONObject) {
        com.byazt.by.n.tt ttVar;
        n(jSONObject);
        this.gk = c(jSONObject, "dyn_draw_engine_url", "https://sf3-fe-tos.pglstatp-toutiao.com/obj/ad-pattern/renderer/package.json");
        this.e = jSONObject.optString("play_component_ugen_engine_url", "");
        this.is = jSONObject.optString("ads_url", "api-access.pangolin-sdk-toutiao.com");
        this.jt = jSONObject.optString("app_log_url", "log-api.pangolin-sdk-toutiao-b.com/service/2/app_log/");
        this.to = jSONObject.optString("xpath");
        this.pu = jSONObject.optJSONObject("digest");
        this.lt = jSONObject.optLong("data_time");
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("feq_policy");
        com.byazt.by.n.tt ttVar2 = new com.byazt.by.n.tt();
        if (jSONObjectOptJSONObject != null) {
            ttVar2.c(jSONObjectOptJSONObject.optLong("duration") * 1000);
            ttVar2.c(jSONObjectOptJSONObject.optInt("max"));
            ttVar2.c((float) jSONObjectOptJSONObject.optDouble("agg_multiple"));
        }
        this.ij = jSONObject.optInt("vbtt", 5);
        this.az = jSONObject.optInt("fetch_tpl_interval", 3600);
        this.dh = jSONObject.optString("privacy_url", oq);
        this.hl = Boolean.valueOf(jSONObject.optBoolean("use_mediation_map"));
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("abtest");
        if (jSONObjectOptJSONObject2 != null) {
            ttVar2.c(jSONObjectOptJSONObject2.optString("version"));
            ttVar2.tt(jSONObjectOptJSONObject2.optString("param"));
        } else {
            com.byazt.by.n.c().sp();
        }
        this.fv = jSONObject.optInt("read_video_from_cache", 1);
        this.hc = jSONObject.optBoolean("enable_bw_screen_detection", false);
        a(jSONObject.optJSONObject("web_upload"));
        JSONObject jSONObjectOptJSONObject3 = jSONObject.optJSONObject("log_rate_conf");
        this.mf = jSONObjectOptJSONObject3;
        if (jSONObjectOptJSONObject3 != null) {
            this.cx = (float) jSONObjectOptJSONObject3.optDouble("global_sample", 1.0d);
            if (this.mf.has("call_stack_rate")) {
                this.ly = (float) this.mf.optDouble("call_stack_rate");
            } else {
                this.ly = this.cx;
            }
        } else {
            this.cx = 1.0f;
        }
        this.la = 0.0f;
        this.po = 20;
        this.kn = 1.0f;
        this.ka = 0;
        JSONObject jSONObject2 = this.mf;
        if (jSONObject2 != null) {
            this.la = (float) jSONObject2.optDouble("feature_stack_rate", 0.0d);
            this.po = this.mf.optInt("view_traverse_depth", 20);
            this.kn = (float) this.mf.optDouble("feature_chain_factor", 1.0d);
            this.ka = this.mf.optInt("feature_req_switch", 0);
        }
        this.b = jSONObject.optString("pyload_h5");
        this.q = nb.c(jSONObject.optJSONObject("insert_js_config"));
        this.tx = sp(jSONObject);
        m.uj("splashLoad", "setting-》mSplashCheckType=" + this.tx);
        this.y = jSONObject.optInt("if_both_open", 0);
        this.iu = jSONObject.optInt("support_tnc", Integer.MAX_VALUE);
        this.v = jSONObject.optInt("al", 1);
        this.w = jSONObject.optInt("max_tpl_cnts", 100);
        com.byazt.by.ve.c().tt(jSONObject);
        JSONObject jSONObjectOptJSONObject4 = jSONObject.optJSONObject("app_common_config");
        if (jSONObjectOptJSONObject4 != null) {
            this.nc = jSONObjectOptJSONObject4.optString("stats_url", "api-access.pangolin-sdk-toutiao1.com");
            this.qi = jSONObjectOptJSONObject4.optInt("mini_game_preload", 1);
            this.ca = jSONObjectOptJSONObject4.optString("img_bucket", "https://sf3-fe-tos.pglstatp-toutiao.com/obj/csj-sdk-static/csj_assets/");
            this.cl = jSONObjectOptJSONObject4.optBoolean("enable_apm_pv", false);
            this.iy = jSONObjectOptJSONObject4.optBoolean("open_single_abi", false);
            this.lv = jSONObjectOptJSONObject4.optBoolean("show_callback_mult", false) ? 1 : 0;
            this.nl = jSONObjectOptJSONObject4.optInt("fetch_tpl_timeout_ctrl", 5000);
            this.ej = jSONObjectOptJSONObject4.optInt("interact_show_after_time", 500);
            this.pl = jSONObjectOptJSONObject4.optInt("fetch_tpl_timeout_ctrl_bad_device", 300);
            this.di = (float) jSONObjectOptJSONObject4.optDouble("tpl_render_error_rate_h5", 4.5d);
            this.jg = (float) jSONObjectOptJSONObject4.optDouble("tpl_render_error_rate_native", 1.0d);
            this.hg = jSONObjectOptJSONObject4.optBoolean("tpl_enable_render_timeout_opt", false);
            String strOptString = jSONObjectOptJSONObject4.optString("tpl_timeout_ctrl");
            if (!TextUtils.isEmpty(strOptString)) {
                this.vl = rl.c(strOptString, this.d);
            }
            this.iw = jSONObjectOptJSONObject4.optInt("if_sp_cache", 1);
            ttVar2.c(jSONObjectOptJSONObject4.optBoolean("is_spl_cache_remove_change", false));
            this.my = jSONObjectOptJSONObject4.optInt("express_gesture_enable", 0);
            this.rl = jSONObjectOptJSONObject4.optInt("opt_click_chain", 0);
            this.qy = jSONObjectOptJSONObject4.optInt("main_start_downloader", 0);
            this.gt = jSONObjectOptJSONObject4.optInt("app_express_gesture_priority", -1);
            this.bj = jSONObjectOptJSONObject4.optInt("webview_cache_count", 0);
            this.bp = jSONObjectOptJSONObject4.optInt("webview_cache_count_v3", 0);
            this.ph = jSONObjectOptJSONObject4.optInt("webview_render_concurrent_count", 2);
            this.gu = jSONObjectOptJSONObject4.optInt("splash_enable_rotate", 0);
            this.nx = jSONObjectOptJSONObject4.optString("ad_pkg_info_url", "apps.bytesfield.com");
            this.xr = jSONObjectOptJSONObject4.optString("splash_close_text", "跳过");
            this.sv = jSONObjectOptJSONObject4.optInt("network_module", 1);
            ttVar2.tt(jSONObjectOptJSONObject4.optInt("cypher_version", 40001));
            com.byazt.yr.c.c().c(this.sv != 2);
            this.yf = jSONObjectOptJSONObject4.optInt("adlog_debug", 0);
            this.dz = jSONObjectOptJSONObject4.optInt("adlog_batch", 10);
            this.j = jSONObjectOptJSONObject4.optLong("adlog_interval", 5000L);
            this.rh = jSONObjectOptJSONObject4.optInt("enable_kite", 0);
            this.ma = jSONObjectOptJSONObject4.optInt("adlog_exception_batch", 100);
            this.f = jSONObjectOptJSONObject4.optInt("adlog_monitor", 1);
            this.p = jSONObjectOptJSONObject4.optInt("enable_ttvideo", -1);
            this.md = jSONObjectOptJSONObject4.optInt("enable_zaid", 0);
            this.h = jSONObjectOptJSONObject4.optInt("player_stats_check_switch", 1);
            this.gr = jSONObjectOptJSONObject4.optInt("enable_cdn_opt", 0);
            this.yv = jSONObjectOptJSONObject4.optInt("download_button_effect", 0);
            this.hq = jSONObjectOptJSONObject4.optLong("ext_use_type", this.hj);
            this.ir = jSONObjectOptJSONObject4.optInt("enable_glgpu", 0);
            this.xd = jSONObjectOptJSONObject4.optInt("enable_dl_ext", this.g);
            this.aw = jSONObjectOptJSONObject4.optInt("enable_oaid_frequency", 0);
            this.cu = jSONObjectOptJSONObject4.optInt("download_receiver_enable", 1);
            this.c = jSONObjectOptJSONObject4.optInt("launch_strategy", 0);
            this.zb = jSONObjectOptJSONObject4.optInt("dl_popup_duration", 1000);
            this.or = jSONObjectOptJSONObject4.optInt("opt_show_check", 0);
            this.em = jSONObjectOptJSONObject4.optInt("shake_trigger_control", 0);
            this.nt = jSONObjectOptJSONObject4.optJSONObject("pitaya_general_settings");
            this.pn = jSONObjectOptJSONObject4.optJSONObject("http_drop");
            this.yo = jSONObjectOptJSONObject4.optInt("stats_batch", 5);
            this.vp = jSONObjectOptJSONObject4.optInt("max_memory_event_count", 10000);
            this.lz = jSONObjectOptJSONObject4.optJSONObject("live_stream_cof");
            this.hs = jSONObjectOptJSONObject4.optJSONObject("dl_notification");
            this.ix = jSONObjectOptJSONObject4.optInt("disable_show_url", 0);
            this.ts = jSONObjectOptJSONObject4.optJSONObject("volume");
            this.pa = jSONObjectOptJSONObject4.optJSONObject("brightness");
            this.ft = jSONObjectOptJSONObject4.optJSONObject("video_start");
            this.tp = jSONObjectOptJSONObject4.optJSONObject("sensor_direction");
            this.te = jSONObjectOptJSONObject4.optJSONObject("pitaya_business_conf");
            this.ri = jSONObjectOptJSONObject4.optJSONArray("pitaya_applog_event_filter");
            ttVar2.ve(jSONObjectOptJSONObject4.optInt("spl_cache_conf", 30));
            ttVar2.uj(jSONObjectOptJSONObject4.optInt("spl_thread_conf", 1));
            ttVar2.n(jSONObjectOptJSONObject4.optInt("spl_common_conf", 0));
            ttVar2.a(jSONObjectOptJSONObject4.optInt("spl_cache_expired", 0));
            ttVar2.ve(jSONObjectOptJSONObject4.optString("drop_cache_black_conf", ""));
            ttVar2.c(this.te);
            ttVar2.sp(jSONObjectOptJSONObject4.optInt("splash_render_timeout_backup", 100));
            com.byazt.qpp.c.C0259c c0259c = new com.byazt.qpp.c.C0259c();
            c0259c.c(jSONObjectOptJSONObject4.optInt("store_isolate_conf", 3));
            c0259c.c();
            JSONObject jSONObjectOptJSONObject5 = jSONObjectOptJSONObject4.optJSONObject("client_intelligence_conf");
            if (jSONObjectOptJSONObject5 != null) {
                this.fe = jSONObjectOptJSONObject5.optBoolean("net_rating");
                this.qt = jSONObjectOptJSONObject5.optJSONObject("net_rating_config");
                this.ge = jSONObjectOptJSONObject5.optBoolean("device_rating");
            }
            JSONObject jSONObjectOptJSONObject6 = jSONObjectOptJSONObject4.optJSONObject("bytebench_rating");
            if (jSONObjectOptJSONObject6 != null) {
                this.br = jSONObjectOptJSONObject6.optBoolean("enable");
                this.sd = (float) jSONObjectOptJSONObject6.optDouble("mid_value");
                this.k = (float) jSONObjectOptJSONObject6.optDouble("low_value");
            }
            this.dn = true;
            this.hz.add(1);
            this.hz.add(3);
            this.hz.add(5);
            this.cs = true;
            JSONObject jSONObjectOptJSONObject7 = jSONObjectOptJSONObject4.optJSONObject("realtime_feature");
            if (jSONObjectOptJSONObject7 != null) {
                this.dn = jSONObjectOptJSONObject7.optBoolean("enable", true);
                JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject7.optJSONArray("time_window");
                this.hz.clear();
                if (jSONArrayOptJSONArray != null) {
                    for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                        this.hz.add(Integer.valueOf(jSONArrayOptJSONArray.optInt(i)));
                    }
                } else {
                    this.hz.add(1);
                    this.hz.add(3);
                    this.hz.add(5);
                }
                this.cs = jSONObjectOptJSONObject7.optBoolean("session_enable", false);
            }
            JSONObject jSONObject3 = this.mf;
            if (jSONObject3 == null || !jSONObject3.has("feature_stack_rate")) {
                this.la = (float) jSONObjectOptJSONObject4.optDouble("feature_stack_rate", this.la);
            }
            JSONObject jSONObject4 = this.mf;
            if (jSONObject4 == null || !jSONObject4.has("view_traverse_depth")) {
                this.po = jSONObjectOptJSONObject4.optInt("view_traverse_depth", this.po);
            }
            JSONObject jSONObject5 = this.mf;
            if (jSONObject5 == null || !jSONObject5.has("feature_chain_factor")) {
                this.kn = (float) jSONObjectOptJSONObject4.optDouble("feature_chain_factor", this.kn);
            }
            JSONObject jSONObject6 = this.mf;
            if (jSONObject6 == null || !jSONObject6.has("feature_req_switch")) {
                this.ka = jSONObjectOptJSONObject4.optInt("feature_req_switch", this.ka);
            }
            this.vi = jSONObjectOptJSONObject4.optInt("event_switch", this.kz);
            this.ny = jSONObjectOptJSONObject4.optInt("switch_audio_focus", 0);
            this.eo = jSONObjectOptJSONObject4.optString("apm_pv_config", "");
            this.ab = jSONObjectOptJSONObject4.optInt("splash_card_show_max_count", 3);
            this.tt = jSONObjectOptJSONObject4.optInt("pre_fetch_cnt", 10);
            this.ra = jSONObjectOptJSONObject4.optInt("gnd_prefetch_cache_size", 5);
            this.bw = jSONObjectOptJSONObject4.optLong("gnd_prefetch_cache_ttl", 0L);
            this.kk = com.byazt.mw.c.c(jSONObjectOptJSONObject4.optJSONObject("white_check_config"));
            this.an = jSONObjectOptJSONObject4.optInt("scheme_get_type", 0);
            this.ne = jSONObjectOptJSONObject4.optInt("scheme_get_num", 1);
            this.pr = jSONObjectOptJSONObject4.optInt("if_query_all_package", 0);
            this.qp = com.byazt.dz.tt.c(jSONObjectOptJSONObject4.optJSONObject("clog_config"));
            this.pf = com.byazt.tl.uj.c(jSONObjectOptJSONObject4.optJSONObject("oncall_upload"));
            this.nb = jSONObjectOptJSONObject4.optInt("feedback_opt", 1);
            this.bx = jSONObjectOptJSONObject4.optBoolean("check_live_room", false);
            JSONObject jSONObjectOptJSONObject8 = jSONObjectOptJSONObject4.optJSONObject("pglam");
            this.ru = jSONObjectOptJSONObject8;
            if (jSONObjectOptJSONObject8 != null) {
                com.byazt.aas.ve.c(jSONObjectOptJSONObject8);
                this.op = this.ru.optInt("pglam_main_enable", 0);
                this.tj = this.ru.optInt("pglam_dns_check_enable", 0);
                this.nm = this.ru.optString("pglam_clazz_check", "");
                ve = this.ru.optInt("pgl_4TypeEncrypt_close", 0);
                uj = this.ru.optInt("pgl_soIntegrity_check", 0);
                n = this.ru.optInt("pgl_soverfailstrategy_enable", 0);
            }
            this.il = jSONObjectOptJSONObject4.optInt("ud_enable", 1);
            this.o = jSONObjectOptJSONObject4.optJSONObject("thread_config");
            com.byazt.jv.c.tt();
            this.sy = jSONObjectOptJSONObject4.optBoolean("new_app_list", false);
            this.id = tt.c(jSONObjectOptJSONObject4.optJSONObject("app_live_config"));
            this.uv = jSONObjectOptJSONObject4.optJSONObject("plugin_update_state");
            this.mk = jSONObjectOptJSONObject4.optJSONObject("antispam_autoclick_detect");
            com.byazt.dna.n nVarTt = gr.tt();
            if (nVarTt != null) {
                nVarTt.updateHARSettings(this.mk);
            }
            this.ul = jSONObjectOptJSONObject4.optInt("is_open_isw", 1);
            this.ys = jSONObjectOptJSONObject4.optInt("is_kv_cache_type", 0);
            this.xg = jSONObjectOptJSONObject4.optInt("kv_init_type", 0);
            this.yg = jSONObjectOptJSONObject4.optInt("open_dl_type", 0);
            this.xx = jSONObjectOptJSONObject4.optString("app_dl_scheme_list", "");
            int iOptInt = jSONObjectOptJSONObject4.optInt("lp_url_sw", 0);
            this.sf = iOptInt;
            if (iOptInt == 1) {
                this.fq = jSONObjectOptJSONObject4.optString("lp_list", "");
            }
            JSONObject jSONObjectOptJSONObject9 = jSONObjectOptJSONObject4.optJSONObject("uchain");
            if (jSONObjectOptJSONObject9 != null) {
                String strOptString2 = jSONObjectOptJSONObject9.optString("md5", "");
                String strOptString3 = jSONObjectOptJSONObject9.optString("url", "");
                if (!TextUtils.isEmpty(strOptString2) && !TextUtils.isEmpty(strOptString3)) {
                    this.xv = strOptString2;
                    this.rp = strOptString3;
                }
            }
            com.byazt.ppf.ve.c(this.xv, this.rp, this.d);
            JSONObject jSONObjectOptJSONObject10 = jSONObjectOptJSONObject4.optJSONObject("ruleEngine");
            if (jSONObjectOptJSONObject10 != null) {
                Boolean boolValueOf = Boolean.valueOf(jSONObjectOptJSONObject10.optBoolean("enable"));
                this.xw = boolValueOf;
                if (boolValueOf.booleanValue()) {
                    JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject10.optJSONArray("rules");
                    this.tu = jSONArrayOptJSONArray2;
                    com.byazt.jze.tt.c(jSONArrayOptJSONArray2, this.d);
                }
            }
            this.cg = jSONObjectOptJSONObject4.optInt("m_vids_join", 0);
            this.yt = jSONObjectOptJSONObject4.optInt("mini_event_upload_version", 0);
            this.jm = jSONObjectOptJSONObject4.optLong("bg_web_readd_t", C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS);
            this.ym = jSONObjectOptJSONObject4.optInt("title_priority", 0);
            this.jf = jSONObjectOptJSONObject4.optInt("splash_video_opt_enable", 0);
            this.zm = jSONObjectOptJSONObject4.optInt("support_live_code", -1);
            this.vr = jSONObjectOptJSONObject4.optInt("gesture_through_enable", 0);
            this.ls = jSONObjectOptJSONObject4.optInt("disable_effects", 0);
            this.wq = jSONObjectOptJSONObject4.optInt("enable_layout_restrict", 0);
            this.ef = jSONObjectOptJSONObject4.optInt("refresh_req_num", 2);
            this.fb = jSONObjectOptJSONObject4.optInt("refresh_max_times", 1);
            this.x = jSONObjectOptJSONObject4.optInt("npth_enable_type", 0);
            this.jy = jSONObjectOptJSONObject4.optBoolean("is_sp_send_meta", true);
            this.jc = sp.c(jSONObjectOptJSONObject4.optString("opt_config"));
            this.qe = t.c(jSONObjectOptJSONObject4.optString("user_interaction_config"));
            this.up = a.c(jSONObjectOptJSONObject4.optString("kv_config"));
            this.f924if = jSONObjectOptJSONObject4.optBoolean("preload_switch", false);
            this.xl = jSONObjectOptJSONObject4.optBoolean("cache_ana_lru_switch", false);
            this.lx = jSONObjectOptJSONObject4.optBoolean("cache_ana_expire_switch", false);
            this.wn = jSONObjectOptJSONObject4.optInt("preload_time_point", 0);
            this.js = jSONObjectOptJSONObject4.optBoolean("is_adapt_density", true);
            this.wj = jSONObjectOptJSONObject4.optBoolean("is_adapt_landscape", true);
            this.cy = jSONObjectOptJSONObject4.optBoolean("disable_easy_playable", true);
            this.yx = jSONObjectOptJSONObject4.optInt("enable_target_34", 1);
            this.mn = jSONObjectOptJSONObject4.optBoolean("app_info_cache_switch", false);
            this.lw = jSONObjectOptJSONObject4.optBoolean("disable_repeat_render", true);
            this.zo = jSONObjectOptJSONObject4.optInt("status_bar_adapt", 0);
            this.bz = jSONObjectOptJSONObject4.optJSONObject("dex_strategy");
            this.bs = jSONObjectOptJSONObject4.optInt("jump_shield_short_duration", 1000);
            this.nh = jSONObjectOptJSONObject4.optInt("replace_dummy_video", 1);
            this.vt = jSONObjectOptJSONObject4.optInt("template_pull_timeout", -1);
            this.wy = jSONObjectOptJSONObject4.optInt("template_pull_type", 0);
            JSONObject jSONObjectOptJSONObject11 = jSONObjectOptJSONObject4.optJSONObject("view_report_opt");
            if (jSONObjectOptJSONObject11 != null) {
                this.dp = jSONObjectOptJSONObject11.optBoolean("view_check_by_window", false);
                this.cj = jSONObjectOptJSONObject11.optBoolean("shake_twist_bind_show", false);
                this.wo = jSONObjectOptJSONObject11.optBoolean("view_check_by_click", false);
            }
            JSONObject jSONObjectOptJSONObject12 = jSONObjectOptJSONObject4.optJSONObject("tt_csj_lifecycle_opt");
            if (jSONObjectOptJSONObject12 != null) {
                this.vz = Boolean.valueOf(jSONObjectOptJSONObject12.optBoolean("node_line_enable", false));
                this.yw = Boolean.valueOf(jSONObjectOptJSONObject12.optBoolean("node_line_detail_enable", false));
                m.c("Tme_node_line", " net n_l_en:" + this.vz);
                m.c("Tme_node_line", " net n_l_d_en:" + this.yw);
            }
            com.byazt.aas.cu.c();
            JSONObject jSONObjectOptJSONObject13 = jSONObjectOptJSONObject4.optJSONObject("ugen_event_center_config");
            if (jSONObjectOptJSONObject13 == null) {
                jSONObjectOptJSONObject13 = new JSONObject();
            }
            this.db = jSONObjectOptJSONObject13.optInt("dynamic_ugen_v3", 0);
            this.gc = jSONObjectOptJSONObject13.optInt("creative_ugen_v3", 0);
            this.pz = jSONObjectOptJSONObject13.optInt("creative_ugen_v2", 0);
            this.jl = jSONObjectOptJSONObject4.optBoolean("is_first_plugin_resources", false);
            int iOptInt2 = jSONObjectOptJSONObject4.optInt("open_webview_count");
            SSWebView.setMaxWebViewCount(iOptInt2);
            ve().put("open_webview_count", iOptInt2);
            new com.byazt.ws.tt().c(jSONObjectOptJSONObject4);
            int iOptInt3 = jSONObjectOptJSONObject4.optInt("lottie_composition_cache_size", 20);
            sl(iOptInt3);
            ve().put("lottie_composition_cache_size", iOptInt3);
            this.ur = jSONObjectOptJSONObject4.optInt("lottie_image_cache_resource_limit", 30);
            ve().put("lottie_image_cache_resource_limit", this.ur);
            this.mu = jSONObjectOptJSONObject4.optBoolean("lottie_zip_download_disable", false) ? 1 : 0;
            ve().put("lottie_zip_download_disable", this.mu == 1);
            com.byazt.tlc.c.c(this.ur, this.mu == 1);
            JSONObject jSONObjectOptJSONObject14 = jSONObjectOptJSONObject4.optJSONObject("video_opt");
            if (jSONObjectOptJSONObject14 != null) {
                this.rm = jSONObjectOptJSONObject14.optInt("video_size_gap_report", 0);
                ve().put("video_size_gap_report", this.rm);
            }
            JSONObject jSONObjectOptJSONObject15 = jSONObjectOptJSONObject4.optJSONObject("req_exemption_cfg");
            com.byazt.dl.a.c().c(jSONObjectOptJSONObject15);
            if (jSONObjectOptJSONObject15 != null) {
                ve().put("req_exemption_cfg", jSONObjectOptJSONObject15.toString());
            } else {
                ve().remove("req_exemption_cfg");
            }
            this.pi = jSONObjectOptJSONObject4.optInt("endcard_lazy", 0);
            this.hy = jSONObjectOptJSONObject4.optInt("is_adapt_two_finger", 0);
            this.zr = jSONObjectOptJSONObject4.optInt("lottie_disable_os7_and_below", 0);
            this.ki = jSONObjectOptJSONObject4.optInt("stats_report_register_info", 0);
            this.kq = jSONObjectOptJSONObject4.optBoolean("ignore_query_result", false);
            this.vx = jSONObjectOptJSONObject4.optBoolean("enable_dynamic_clear_cache", true);
            String strOptString4 = jSONObjectOptJSONObject4.optString("local_res_zip_url", "");
            com.byazt.fh.n.c().c(strOptString4);
            this.pe = strOptString4;
            this.mc = jSONObjectOptJSONObject4.optInt("enableUChainDownLoad", 0);
        } else {
            ttVar2 = ttVar2;
        }
        JSONObject jSONObjectOptJSONObject16 = jSONObject.optJSONObject("download_config");
        if (jSONObjectOptJSONObject16 != null) {
            ttVar = ttVar2;
            ttVar.x(jSONObjectOptJSONObject16.optInt("if_storage_internal", 1));
        } else {
            ttVar = ttVar2;
        }
        ttVar.c();
        cu.tt(jSONObject);
        kp.c(jSONObject);
        or.c(jSONObject);
        com.byazt.ete.x.c(jSONObject);
        pu.c(jSONObject);
        gu.c(jSONObject);
        new com.byazt.xo.tt(128).c(new Runnable() { // from class: com.byazt.ogz.sl.2
            @Override // java.lang.Runnable
            public void run() {
                d.c(jSONObject, new d.c() { // from class: com.byazt.ogz.sl.2.1
                    @Override // com.byazt.ete.d.c
                    public void c(d.ve veVar) {
                        d.c(sl.this.f2549a, veVar);
                    }

                    @Override // com.byazt.ete.d.c
                    public void tt(d.ve veVar) {
                        d.tt(sl.this.f2549a, veVar);
                    }
                });
            }
        });
        f.c(jSONObject);
        this.os = System.currentTimeMillis();
        this.oz.clear();
        JSONArray jSONArrayOptJSONArray3 = jSONObject.optJSONArray("spam_app_list");
        if (jSONArrayOptJSONArray3 != null) {
            int length = jSONArrayOptJSONArray3.length();
            for (int i2 = 0; i2 < length; i2++) {
                String strOptString5 = jSONArrayOptJSONArray3.optString(i2);
                if (!TextUtils.isEmpty(strOptString5)) {
                    this.oz.add(strOptString5);
                }
            }
        }
        synchronized (this.r) {
            this.r.clear();
            JSONArray jSONArrayOptJSONArray4 = jSONObject.optJSONArray("scheme_check_list");
            if (jSONArrayOptJSONArray4 != null) {
                int length2 = jSONArrayOptJSONArray4.length();
                for (int i3 = 0; i3 < length2; i3++) {
                    String strOptString6 = jSONArrayOptJSONArray4.optString(i3);
                    if (!TextUtils.isEmpty(strOptString6)) {
                        this.r.add(strOptString6);
                    }
                }
            }
        }
        synchronized (this.s) {
            this.s.clear();
            JSONArray jSONArrayOptJSONArray5 = jSONObject.optJSONArray("top_scheme_list");
            if (jSONArrayOptJSONArray5 != null) {
                int length3 = jSONArrayOptJSONArray5.length();
                for (int i4 = 0; i4 < length3; i4++) {
                    String strOptString7 = jSONArrayOptJSONArray5.optString(i4);
                    if (!TextUtils.isEmpty(strOptString7)) {
                        this.s.add(strOptString7);
                    }
                }
            }
        }
        JSONObject jSONObjectOptJSONObject17 = jSONObject.optJSONObject("download_sdk_config");
        if (jSONObjectOptJSONObject17 != null) {
            this.kp = jSONObjectOptJSONObject17.toString();
        } else {
            this.kp = "";
        }
        this.tk = jSONObjectOptJSONObject17;
        try {
            JSONObject jSONObjectOptJSONObject18 = jSONObject.optJSONObject("ad_slot_conf_block");
            if (jSONObjectOptJSONObject18 != null) {
                this.tw = jSONObjectOptJSONObject18.toString();
                this.ek.clear();
                Iterator<String> itKeys = jSONObjectOptJSONObject18.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    this.ek.put(next, jSONObjectOptJSONObject18.opt(next));
                }
            }
        } catch (Exception unused) {
        }
        if (com.byazt.by.ve.c().da() || !com.byazt.omf.x.m().d()) {
            x(jSONObject);
        }
        com.byazt.zlb.ve.ve(15, this.is);
        if (com.byazt.zlb.ve.c()) {
            JSONObject jSONObjectOptJSONObject19 = jSONObjectOptJSONObject4 != null ? jSONObjectOptJSONObject4.optJSONObject("test_tool_urls") : null;
            if (jSONObjectOptJSONObject19 != null) {
                if (jSONObjectOptJSONObject19.has("qa_tool_host")) {
                    try {
                        String host = new URL(jSONObjectOptJSONObject19.optString("qa_tool_host")).getHost();
                        if (!TextUtils.isEmpty(host)) {
                            com.byazt.omf.x.m().da(host);
                        }
                    } catch (MalformedURLException unused2) {
                    }
                }
                if (!TextUtils.isEmpty(com.byazt.omf.x.m().v())) {
                    if (jSONObjectOptJSONObject19.has("ad_preview_url")) {
                        com.byazt.omf.x.m().sl(jSONObjectOptJSONObject19.optString("ad_preview_url"));
                    }
                    if (jSONObjectOptJSONObject19.has("basic_info_url")) {
                        com.byazt.omf.x.m().t(jSONObjectOptJSONObject19.optString("basic_info_url"));
                    }
                }
            }
        }
        this.st = jSONObject.optInt("pre_cache_brand_count", this.st);
        JSONObject jSONObjectOptJSONObject20 = jSONObject.optJSONObject("video_cache_config");
        this.en = jSONObjectOptJSONObject20;
        if (jSONObjectOptJSONObject20 != null) {
            com.byazt.ri.c.c(jSONObjectOptJSONObject20);
        }
        nu();
        bz();
        com.byazt.dz.ve.c(this.qp);
        my(this.d);
        com.byazt.lj.c.c(false);
    }

    private String c(JSONObject jSONObject, String str, String str2) {
        String strOptString = jSONObject.optString(str, str2);
        if (!com.byazt.omf.x.m().lr()) {
            return strOptString;
        }
        String string = ve().getString(str + "_qa_modify_setting", "");
        return TextUtils.isEmpty(string) ? strOptString : string;
    }

    @Override // com.byazt.ogz.n
    public void c(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("app_common_config");
        this.gx = jSONObjectOptJSONObject;
        if (jSONObjectOptJSONObject != null) {
            this.by = jSONObjectOptJSONObject.optJSONObject("plugin_retry_opt");
            this.fr = jSONObjectOptJSONObject.optJSONObject("plugin_downloader_settings");
            com.byazt.by.ve.c().c(jSONObjectOptJSONObject);
            i(jSONObjectOptJSONObject);
            this.xd = jSONObjectOptJSONObject.optInt("enable_dl_ext", this.g);
            this.hq = jSONObjectOptJSONObject.optLong("ext_use_type", this.hj);
            com.byazt.omf.eo.ve();
        }
    }

    @Override // com.byazt.ogz.n
    public void tt(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        if (jSONObject == null) {
            return;
        }
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("app_common_config");
        if (jSONObjectOptJSONObject2 != null) {
            this.pb = jSONObjectOptJSONObject2.optBoolean("can_init_live", true);
        }
        if (!this.pb || (jSONObjectOptJSONObject = jSONObject.optJSONObject("live_sdk_conf")) == null) {
            return;
        }
        this.cf = aw.c(jSONObjectOptJSONObject);
        com.byazt.apd.tt.c().tt();
    }

    public <T> T c(String str, T t) {
        T t2;
        try {
            return (!this.ek.containsKey(str) || (t2 = (T) this.ek.get(str)) == null) ? t : t2;
        } catch (Exception unused) {
        }
    }

    private void my(final String str) {
        com.byazt.bwm.n.tt(new com.byazt.bwm.sp("") { // from class: com.byazt.ogz.sl.3
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.ql.c.c(str);
            }
        });
    }

    private void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.i = jSONObject.optInt("enable", 0);
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("content_type");
            this.da.clear();
            if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() != 0) {
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    String strOptString = jSONArrayOptJSONArray.optString(i);
                    if (!TextUtils.isEmpty(strOptString)) {
                        this.da.add(strOptString);
                    }
                }
            }
            this.sl = jSONObject.optInt("send_response_to_webview", 0);
            this.t = jSONObject.optInt("max_report_size_single", 2);
            this.u = jSONObject.optInt("max_report_size_total", 5);
            this.nu = jSONObject.optInt("max_report_times", 0);
            this.z = jSONObject.optString("report_url", "https://api-access.pangolin-sdk-toutiao.com/v2/inspect/aegis/client/page/");
            this.m = jSONObject.optInt("storage_type", 0);
            this.yp = jSONObject.optInt("report_only_wifi_enable", 0);
            return;
        }
        this.i = 0;
        this.da.clear();
        this.sl = 0;
        this.t = 2;
        this.u = 5;
        this.nu = 0;
        this.z = "https://api-access.pangolin-sdk-toutiao.com/v2/inspect/aegis/client/page/";
        this.m = 0;
        this.yp = 0;
    }

    private int sp(JSONObject jSONObject) {
        int iOptInt = jSONObject.optInt("splash_check_type", 1);
        this.tx = iOptInt;
        if (iOptInt == 0 || iOptInt == 1) {
            return iOptInt;
        }
        return 1;
    }

    private void bz() {
        ve();
        this.f2549a.put("open_mini_game", this.qi);
        if (!"https://sf3-fe-tos.pglstatp-toutiao.com/obj/csj-sdk-static/csj_assets/".equals(this.ca) && !TextUtils.isEmpty(this.ca)) {
            this.f2549a.put("img_bucket", this.ca);
        }
        SharedPreferences.Editor editorEdit = js().edit();
        this.f2549a.put("url_stats", this.nc);
        this.f2549a.put("url_alog", this.jt);
        editorEdit.putString("url_stats", this.nc);
        editorEdit.putString("url_alog", this.jt);
        this.f2549a.put("xpath", this.to);
        if (this.pu != null) {
            this.f2549a.put("digest", this.pu.toString());
        }
        this.f2549a.put("data_time", this.lt);
        this.f2549a.put("fetch_template", this.az);
        this.f2549a.put("pyload_h5", this.b);
        com.byazt.it.n nVar = this.f2549a;
        nb nbVar = this.q;
        nVar.put("insert_js_config", nbVar != null ? nbVar.toString() : "");
        com.byazt.it.n nVar2 = this.f2549a;
        com.byazt.mw.c cVar = this.kk;
        nVar2.put("white_check_config", cVar != null ? cVar.toString() : "");
        this.f2549a.put("splash_check_type", this.tx);
        this.f2549a.put("if_both_open", this.y);
        this.f2549a.put("adlog_exception_batch", this.ma);
        this.f2549a.put("adlog_interval", this.j);
        this.f2549a.put("enable_kite", this.rh);
        this.f2549a.put("adlog_batch", this.dz);
        this.f2549a.put("adlog_debug", this.yf);
        this.f2549a.put("adlog_monitor", this.f);
        this.f2549a.put("enable_ttvideo", this.p);
        this.f2549a.put("enable_zaid", this.md);
        this.f2549a.put("player_stats_check_switch", this.h);
        this.f2549a.put("enable_cdn_opt", this.gr);
        this.f2549a.put("download_button_effect", this.yv);
        this.f2549a.put("ext_use_type", this.hq);
        this.f2549a.put("enable_glgpu", 0);
        this.f2549a.put("enable_dl_ext", this.xd);
        this.f2549a.put("enable_oaid_frequency", this.aw);
        this.f2549a.put("download_receiver_enable", this.cu);
        this.f2549a.put("launch_strategy", this.c);
        this.f2549a.put("dl_popup_duration", this.zb);
        this.f2549a.put("switch_audio_focus", this.ny);
        this.f2549a.put("opt_show_check", this.or);
        if (this.nt != null) {
            this.f2549a.put("pitaya_general_settings", this.nt.toString());
        }
        if (this.lz != null) {
            this.f2549a.put("live_stream_cof", this.lz.toString());
        }
        if (this.ft != null) {
            this.f2549a.put("video_start", this.ft.toString());
        }
        if (this.ts != null) {
            this.f2549a.put("volume", this.ts.toString());
        }
        if (this.pa != null) {
            this.f2549a.put("brightness", this.pa.toString());
        }
        if (this.hs != null) {
            this.f2549a.put("dl_notification", this.hs.toString());
        }
        this.f2549a.put("disable_show_url", this.ix);
        if (this.tp != null) {
            this.f2549a.put("sensor_direction", this.tp.toString());
        }
        if (this.te != null) {
            this.f2549a.put("pitaya_business_conf", this.te.toString());
        }
        if (this.ri != null) {
            this.f2549a.put("pitaya_applog_event_filter", this.ri.toString());
        }
        com.byazt.it.n nVar3 = this.f2549a;
        JSONObject jSONObject = this.pn;
        nVar3.put("http_drop", jSONObject == null ? "" : jSONObject.toString());
        this.f2549a.put("stats_batch", this.yo);
        this.f2549a.put("max_memory_event_count", this.vp);
        this.f2549a.put("event_switch", this.vi);
        this.f2549a.put("pre_fetch_cnt", this.tt);
        this.f2549a.put("web_upload_enable", this.i);
        this.f2549a.put("web_upload_content_type", this.da);
        this.f2549a.put("web_upload_send_restowv", this.sl);
        this.f2549a.put("web_upload_max_retry", this.nu);
        this.f2549a.put("web_upload_max_single_file", this.t);
        this.f2549a.put("web_upload_max_zip_file", this.u);
        this.f2549a.put("web_upload_report_url", this.z);
        this.f2549a.put("web_upload_storage_type", this.m);
        this.f2549a.put("web_upload_report_only_wifi", this.yp);
        this.f2549a.put("app_list_control", this.v);
        this.f2549a.put("max_tpl_cnts", this.w);
        this.f2549a.put("fetch_tpl_timeout_ctrl", this.nl);
        this.f2549a.put("interact_show_after_time", this.ej);
        this.f2549a.put("fetch_tpl_timeout_ctrl_bad_device", this.pl);
        this.f2549a.put("tpl_render_error_rate_h5", this.di);
        this.f2549a.put("tpl_render_error_rate_native", this.jg);
        this.f2549a.put("mid_value", this.sd);
        this.f2549a.put("low_value", this.k);
        this.f2549a.put("tpl_enable_render_timeout_opt", this.hg);
        this.f2549a.put("open_single_abi", this.iy);
        com.byazt.it.n nVar4 = this.f2549a;
        int i = this.lv;
        if (i == Integer.MAX_VALUE) {
            i = 0;
        }
        nVar4.put("show_callback_mult", i);
        this.f2549a.put("webview_cache_count", this.bj);
        this.f2549a.put("webview_cache_count_v3", this.bp);
        this.f2549a.put("webview_render_concurrent_count", this.ph);
        this.f2549a.put("enable_apm_pv", this.cl);
        this.f2549a.put("hit_app_list_time", this.os);
        this.f2549a.put("hit_app_list_data", this.oz);
        this.f2549a.put("scheme_list_data", this.r);
        this.f2549a.put("top_scheme_list_data", this.s);
        this.f2549a.put("policy_url", this.dh);
        com.byazt.it.n nVar5 = this.f2549a;
        Boolean bool = this.hl;
        nVar5.put("use_mediation_map", bool != null ? bool.booleanValue() : false);
        this.f2549a.put("apm_pv_config", this.eo);
        this.f2549a.put("dyn_draw_engine_url", this.gk);
        this.f2549a.put("play_component_ugen_engine_url", this.e);
        this.f2549a.put("local_res_zip_url", this.pe);
        this.f2549a.put("ad_pkg_info_url", this.nx);
        this.f2549a.put("sp_key_if_sp_cache", this.iw);
        this.f2549a.put("download_sdk_config", this.kp);
        com.byazt.it.n nVar6 = this.f2549a;
        JSONObject jSONObject2 = this.o;
        nVar6.put("thread_config", jSONObject2 != null ? jSONObject2.toString() : "");
        this.f2549a.put("npth_enable_type", this.x);
        this.f2549a.put("is_sp_send_meta", this.jy);
        this.f2549a.put("opt_config", this.jc.toString());
        com.byazt.it.n nVar7 = this.f2549a;
        t tVar = this.qe;
        nVar7.put("user_interaction_config", tVar != null ? tVar.toString() : "");
        this.f2549a.put("kv_config", this.up.toString());
        this.f2549a.put("is_first_plugin_resources", this.jl);
        this.f2549a.put("vbtt", this.ij);
        this.f2549a.put("preload_switch", this.f924if);
        this.f2549a.put("cache_ana_lru_switch", this.xl);
        this.f2549a.put("cache_ana_expire_switch", this.lx);
        this.f2549a.put("preload_time_point", this.wn);
        this.f2549a.put("app_info_cache_switch", this.mn);
        this.f2549a.put("is_adapt_density", this.js);
        this.f2549a.put("is_adapt_landscape", this.wj);
        this.f2549a.put("disable_easy_playable", this.cy);
        this.f2549a.put("enable_target_34", this.yx);
        com.byazt.it.n nVar8 = this.f2549a;
        JSONObject jSONObject3 = this.bz;
        nVar8.put("dex_strategy", jSONObject3 == null ? "" : jSONObject3.toString());
        this.f2549a.put("disable_repeat_render", this.lw);
        this.f2549a.put("status_bar_adapt", this.zo);
        this.f2549a.put("jump_shield_short_duration", this.bs);
        this.f2549a.put("replace_dummy_video", this.nh);
        this.f2549a.put("template_pull_timeout", this.vt);
        this.f2549a.put("template_pull_type", this.wy);
        if (!TextUtils.isEmpty(this.lr)) {
            this.f2549a.put("template_ids", this.lr);
        }
        if (!TextUtils.isEmpty(this.bm)) {
            this.f2549a.put("tpl_infos", this.bm);
        }
        com.byazt.it.n nVar9 = this.f2549a;
        rl rlVar = this.vl;
        nVar9.put("tpl_timeout_ctrl", rlVar != null ? rlVar.toString() : "");
        this.f2549a.put("call_stack_rate", this.ly);
        this.f2549a.put("gnd_prefetch_cache_ttl", this.bw);
        this.f2549a.put("gnd_prefetch_cache_size", this.ra);
        this.f2549a.put("global_sample", this.cx);
        this.f2549a.put("read_video_from_cache", this.fv);
        this.f2549a.put("brand_video_cache_count", this.st);
        this.f2549a.put("enable_bw_screen_detection", this.hc);
        this.f2549a.put("splash_card_show_max_count", this.ab);
        com.byazt.it.n nVar10 = this.f2549a;
        com.byazt.dz.tt ttVar = this.qp;
        nVar10.put("clog_config", ttVar != null ? ttVar.toString() : "");
        com.byazt.it.n nVar11 = this.f2549a;
        com.byazt.tl.uj ujVar = this.pf;
        nVar11.put("oncall_upload", ujVar != null ? ujVar.toString() : "");
        this.f2549a.put("feedback_opt", this.nb);
        this.f2549a.put("check_live_room", this.bx);
        this.f2549a.put("can_init_live", this.pb);
        this.f2549a.put("new_app_list", this.sy);
        com.byazt.it.n nVar12 = this.f2549a;
        tt ttVar2 = this.id;
        nVar12.put("app_live_config", ttVar2 != null ? ttVar2.toString() : "");
        com.byazt.it.n nVar13 = this.f2549a;
        JSONObject jSONObject4 = this.uv;
        nVar13.put("plugin_update_state", jSONObject4 != null ? jSONObject4.toString() : "");
        com.byazt.it.n nVar14 = this.f2549a;
        JSONObject jSONObject5 = this.mk;
        nVar14.put("antispam_autoclick_detect", jSONObject5 != null ? jSONObject5.toString() : "");
        com.byazt.it.n nVar15 = this.f2549a;
        JSONObject jSONObject6 = this.by;
        nVar15.put("plugin_retry_opt", jSONObject6 != null ? jSONObject6.toString() : "");
        com.byazt.it.n nVar16 = this.f2549a;
        JSONObject jSONObject7 = this.fr;
        nVar16.put("plugin_downloader_settings", jSONObject7 != null ? jSONObject7.toString() : "");
        com.byazt.it.n nVar17 = this.f2549a;
        JSONObject jSONObject8 = this.ru;
        nVar17.put("pglam", jSONObject8 != null ? jSONObject8.toString() : "");
        this.f2549a.put("pglam_main_enable", this.op);
        this.f2549a.put("pglam_dns_check_enable", this.tj);
        this.f2549a.put("pglam_clazz_check", this.nm);
        this.f2549a.put("ud_enable", this.il);
        this.f2549a.put("is_open_isw", this.ul);
        editorEdit.putInt("pgl_soIntegrity_check", uj);
        editorEdit.putInt("pgl_soverfailstrategy_enable", n);
        editorEdit.putInt("is_kv_cache_type", this.ys);
        editorEdit.putInt("kv_init_type", this.xg);
        editorEdit.putString("md5", this.xv);
        editorEdit.putString("url", this.rp);
        editorEdit.apply();
        if (this.xw != null) {
            this.f2549a.put("rule_engine_enable", this.xw.booleanValue());
            if (this.xw.booleanValue() && this.tu != null) {
                this.f2549a.put("rule_engine_list", this.tu.toString());
            }
        }
        this.f2549a.put("lp_url_sw", this.sf);
        if (this.sf == 1 && (com.byazt.by.ve.c().da() || !com.byazt.omf.x.m().d())) {
            mn().put("lp_list", this.fq);
        }
        if (this.cf != null) {
            this.f2549a.put("live_sdk_conf", this.cf.toString());
        }
        this.f2549a.put("open_dl_type", this.yg);
        this.f2549a.put("app_dl_scheme_list", this.xx);
        this.f2549a.put("scheme_get_type", this.an);
        this.f2549a.put("scheme_get_num", this.ne);
        this.f2549a.put("if_query_all_package", this.pr);
        if (this.en != null) {
            this.f2549a.put("video_cache_config", this.en.toString());
        }
        if (this.mf != null) {
            this.f2549a.put("log_rate_conf", this.mf.toString());
        }
        this.f2549a.put("splash_close_text", this.xr);
        this.f2549a.put("network_module", this.sv);
        this.f2549a.put("m_vids_join", this.cg);
        this.f2549a.put("mini_event_upload_version", this.yt);
        this.f2549a.put("bg_web_readd_t", this.jm);
        this.f2549a.put("title_priority", this.ym);
        this.f2549a.put("splash_video_opt_enable", this.jf);
        this.f2549a.put("support_live_code", this.zm);
        this.f2549a.put("gesture_through_enable", this.vr);
        this.f2549a.put("disable_effects", this.ls);
        this.f2549a.put("enable_layout_restrict", this.wq);
        this.f2549a.put("refresh_req_num", this.ef);
        this.f2549a.put("refresh_max_times", this.fb);
        this.f2549a.put("shake_trigger_control", this.em);
        this.f2549a.put("net_rating", this.fe);
        this.f2549a.put("device_rating", this.ge);
        this.f2549a.put("bytebench_rating", this.br);
        com.byazt.it.n nVar18 = this.f2549a;
        JSONObject jSONObject9 = this.qt;
        nVar18.put("net_rating_config", jSONObject9 != null ? jSONObject9.toString() : "");
        this.f2549a.put("express_gesture_enable", this.my);
        this.f2549a.put("opt_click_chain", this.rl);
        this.f2549a.put("main_start_downloader", this.qy);
        this.f2549a.put("app_express_gesture_priority", this.gt);
        this.f2549a.put("ad_slot_conf_block", this.tw);
        this.f2549a.put("view_check_by_window", this.dp);
        this.f2549a.put("shake_twist_bind_show", this.cj);
        this.f2549a.put("view_check_by_click", this.wo);
        this.f2549a.put("node_line_enable", this.vz.booleanValue());
        this.f2549a.put("node_line_detail_enable", this.yw.booleanValue());
        this.f2549a.put("dynamic_ugen_v3", this.db);
        this.f2549a.put("creative_ugen_v3", this.gc);
        this.f2549a.put("creative_ugen_v2", this.pz);
        this.f2549a.put("enable", this.dn);
        this.f2549a.put("session_enable", this.cs);
        this.f2549a.put("feature_stack_rate", this.la);
        this.f2549a.put("view_traverse_depth", this.po);
        this.f2549a.put("feature_chain_factor", this.kn);
        this.f2549a.put("feature_req_switch", this.ka);
        this.f2549a.put("endcard_lazy", this.pi);
        this.f2549a.put("is_adapt_two_finger", this.hy);
        this.f2549a.put("stats_report_register_info", this.ki);
        this.f2549a.put("lottie_disable_os7_and_below", this.zr);
        this.f2549a.put("ignore_query_result", this.kq);
        this.f2549a.put("splash_enable_rotate", this.gu);
        this.f2549a.put("enable_dynamic_clear_cache", this.vx);
        if (this.gx != null) {
            this.f2549a.put("app_common_config", this.gx.toString());
        }
        cu.c(this.f2549a);
        kp.c(this.f2549a);
        com.byazt.ete.x.tt(this.f2549a);
        d.tt(this.f2549a);
        or.tt(this.f2549a);
        pu.c(this.f2549a);
        gu.tt(this.f2549a);
    }

    private void x(JSONObject jSONObject) {
        int length;
        SharedPreferences.Editor editorEdit;
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("ad_slot_conf_list");
        if (jSONArrayOptJSONArray == null || (length = jSONArrayOptJSONArray.length()) <= 0) {
            return;
        }
        this.ic.clear();
        nm();
        com.byazt.it.ve veVarI = i();
        SharedPreferences.Editor editorEdit2 = null;
        if (veVarI == null) {
            if (this.ku == null) {
                this.ku = com.byazt.nys.tt.tt(gt.getContext(), com.byazt.bnf.c.tt(com.byazt.vxy.c.c().c(this.d), sp()), 0);
            }
            editorEdit = this.ku.edit();
        } else {
            editorEdit = null;
        }
        for (int i = 0; i < length; i++) {
            JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
            c cVarUj = uj(jSONObjectOptJSONObject);
            if (cVarUj != null) {
                this.ic.put(cVarUj.c, cVarUj);
                if (com.byazt.by.uj.c().sp(cVarUj.ve())) {
                    if (editorEdit2 == null && this.ck != null) {
                        editorEdit2 = this.ck.edit();
                    }
                    if (editorEdit2 != null) {
                        editorEdit2.putString(gt(cVarUj.c), jSONObjectOptJSONObject.toString());
                    }
                }
                if (veVarI != null) {
                    veVarI.put(gt(cVarUj.c), jSONObjectOptJSONObject.toString());
                } else if (editorEdit != null) {
                    editorEdit.putString(gt(cVarUj.c), jSONObjectOptJSONObject.toString());
                }
                com.byazt.zlb.ve.c(cVarUj.c, jSONObjectOptJSONObject);
            }
        }
        if (editorEdit2 != null) {
            try {
                editorEdit2.commit();
            } catch (Throwable th) {
                m.tt("TTSdkSetting", "saveSlotConfig failed:" + th.getMessage());
                return;
            }
        }
        if (editorEdit != null) {
            editorEdit.commit();
        }
    }

    private String gt(String str) {
        return "ad_slot_conf_".concat(String.valueOf(str));
    }

    public String my() {
        if (TextUtils.isEmpty(this.is)) {
            this.is = com.byazt.by.ve.c().uj();
        }
        return this.is;
    }

    public boolean gt() {
        if (this.p == -1) {
            this.p = ve().get("enable_ttvideo", -1);
        }
        int i = this.p;
        if (i == 0) {
            return false;
        }
        return (i == 1 && (zm.m() || zm.z())) ? false : true;
    }

    public boolean rl() {
        if (this.md == Integer.MIN_VALUE) {
            this.md = ve().get("enable_zaid", 0);
        }
        return this.md != 0;
    }

    public boolean qy() {
        if (this.h == Integer.MIN_VALUE) {
            this.h = ve().get("player_stats_check_switch", 1);
        }
        return this.h == 1;
    }

    public boolean gu() {
        if (this.my == Integer.MIN_VALUE) {
            this.my = ve().get("express_gesture_enable", 0);
        }
        return this.my == 1;
    }

    public int gr() {
        if (this.gt == Integer.MIN_VALUE) {
            this.gt = ve().get("app_express_gesture_priority", -1);
        }
        return this.gt;
    }

    public boolean zm() {
        if (this.qy == Integer.MIN_VALUE) {
            this.qy = ve().get("main_start_downloader", 0);
        }
        return this.qy == 1;
    }

    public String p() {
        if (TextUtils.isEmpty(this.nc)) {
            String str = ve().get("url_stats", "api-access.pangolin-sdk-toutiao1.com");
            this.nc = str;
            if (TextUtils.isEmpty(str)) {
                this.nc = "api-access.pangolin-sdk-toutiao1.com";
            }
        }
        return this.nc;
    }

    public String md() {
        if (TextUtils.isEmpty(this.ca)) {
            this.ca = ve().get("img_bucket", "https://sf3-fe-tos.pglstatp-toutiao.com/obj/csj-sdk-static/csj_assets/");
        }
        return this.ca;
    }

    public boolean h() {
        boolean z = ve().get("enable_apm_pv", false);
        this.cl = z;
        return z;
    }

    public String eo() {
        if (TextUtils.isEmpty(this.jt)) {
            String str = ve().get("url_alog", "log-api.pangolin-sdk-toutiao-b.com/service/2/app_log/");
            this.jt = str;
            if (TextUtils.isEmpty(str)) {
                this.jt = "log-api.pangolin-sdk-toutiao-b.com/service/2/app_log/";
            }
        }
        return this.jt;
    }

    public boolean zb() {
        if (this.yf == Integer.MAX_VALUE) {
            this.yf = ve().get("adlog_debug", 0);
        }
        return this.yf == 1;
    }

    public boolean or() {
        if (this.f == Integer.MAX_VALUE) {
            this.f = ve().get("adlog_monitor", 1);
        }
        return this.f != 0;
    }

    public long cu() {
        if (this.j == 2147483647L) {
            this.j = ve().get("adlog_interval", 5000L);
        }
        return this.j;
    }

    public boolean qp() {
        if (this.rh == Integer.MAX_VALUE) {
            this.rh = ve().get("enable_kite", 0);
        }
        return this.rh == 1;
    }

    public int nb() {
        if (this.dz == Integer.MAX_VALUE) {
            this.dz = ve().get("adlog_batch", 10);
        }
        return this.dz;
    }

    public boolean pf() {
        if (this.xd == this.g) {
            this.xd = ve().get("enable_dl_ext", this.g);
        }
        return this.xd == 1;
    }

    public boolean bx() {
        if (this.aw == Integer.MIN_VALUE) {
            this.aw = ve().get("enable_oaid_frequency", 0);
        }
        return this.aw == 1;
    }

    public int sv() {
        if (this.yo == 3) {
            this.yo = ve().get("stats_batch", 5);
        }
        int i = this.yo;
        if (i <= 0 || i > 100) {
            return 5;
        }
        return i;
    }

    public int aw() {
        if (this.vp == Integer.MAX_VALUE) {
            this.vp = ve().get("max_memory_event_count", 10000);
        }
        int i = this.vp;
        if (i < 100) {
            return 10000;
        }
        return i;
    }

    public boolean ic() {
        if (this.cu == Integer.MAX_VALUE) {
            this.cu = ve().get("download_receiver_enable", 1);
        }
        return this.cu != 0;
    }

    public boolean hd() {
        if (this.ny == Integer.MAX_VALUE) {
            this.ny = ve().get("switch_audio_focus", 0);
        }
        return this.ny == 1;
    }

    public boolean bm() {
        if (this.vi == this.kz) {
            this.vi = ve().get("event_switch", this.kz);
        }
        return this.vi == 1;
    }

    public int lr() {
        if (this.tt == 10) {
            this.tt = ve().get("pre_fetch_cnt", 10);
        }
        return this.tt;
    }

    public long l() {
        if (this.hq == this.hj) {
            this.hq = ve().get("ext_use_type", this.hj);
        }
        return this.hq;
    }

    public boolean lo() {
        if (this.ir == Integer.MAX_VALUE) {
            this.ir = ve().get("enable_glgpu", 0);
        }
        return this.ir == 1;
    }

    public boolean pu() {
        if (this.c == 0) {
            this.c = ve().get("launch_strategy", 0);
        }
        return this.c == 1;
    }

    public boolean lt() {
        if (this.or == Integer.MAX_VALUE) {
            this.or = ve().get("opt_show_check", 0);
        }
        return this.or == 1;
    }

    public int to() {
        if (this.ma == Integer.MAX_VALUE) {
            this.ma = ve().get("adlog_exception_batch", 100);
        }
        return this.ma;
    }

    public String kp() {
        if (TextUtils.isEmpty(this.to)) {
            this.to = ve().get("xpath", "");
        }
        return this.to;
    }

    public JSONObject b() {
        if (this.pu == null) {
            String str = ve().get("digest", "");
            if (!TextUtils.isEmpty(str)) {
                try {
                    this.pu = new JSONObject(str);
                } catch (Exception unused) {
                }
            }
        }
        return this.pu;
    }

    public long q() {
        if (this.lt == 0) {
            this.lt = ve().get("data_time", 0L);
        }
        return this.lt;
    }

    public float kk() {
        if (this.ly < 0.0f) {
            this.ly = ve().get("call_stack_rate", 0.0f);
        }
        return this.ly;
    }

    public int tx() {
        if (this.i == Integer.MAX_VALUE) {
            this.i = ve().get("web_upload_enable", 0);
        }
        return this.i;
    }

    public Set<String> v() {
        Set<String> set;
        if (this.da.isEmpty() && (set = ve().get("web_upload_content_type", Collections.synchronizedSet(new HashSet()))) != null && set.size() != 0) {
            Iterator<String> it = set.iterator();
            while (it.hasNext()) {
                this.da.add(it.next());
            }
        }
        return this.da;
    }

    public int os() {
        if (this.sl == Integer.MAX_VALUE) {
            this.sl = ve().get("web_upload_send_restowv", 0);
        }
        return this.sl;
    }

    public int oz() {
        if (this.t == Integer.MAX_VALUE) {
            this.t = ve().get("web_upload_max_single_file", 2);
        }
        return this.t;
    }

    public int r() {
        if (this.u == Integer.MAX_VALUE) {
            this.u = ve().get("web_upload_max_zip_file", 5);
        }
        return this.u;
    }

    public int s() {
        if (this.nu == Integer.MAX_VALUE) {
            this.nu = ve().get("web_upload_max_retry", 0);
        }
        return this.nu;
    }

    public int y() {
        if (this.yp == Integer.MAX_VALUE) {
            this.yp = ve().get("web_upload_report_only_wifi", 0);
        }
        return this.yp;
    }

    public String iu() {
        if (TextUtils.equals(this.z, "https://api-access.pangolin-sdk-toutiao.com/v2/inspect/aegis/client/page/")) {
            this.z = ve().get("web_upload_report_url", "https://api-access.pangolin-sdk-toutiao.com/v2/inspect/aegis/client/page/");
        }
        return this.z;
    }

    public int j() {
        if (this.m == Integer.MAX_VALUE) {
            this.m = ve().get("web_upload_storage_type", 0);
        }
        return this.m;
    }

    public nb dz() {
        if (this.q == null) {
            this.q = nb.c(ve().get("insert_js_config", ""));
        }
        return this.q;
    }

    public com.byazt.mw.c ma() {
        if (this.kk == null) {
            this.kk = com.byazt.mw.c.c(ve().get("white_check_config", ""));
        }
        return this.kk;
    }

    public JSONObject yf() {
        if (this.tk == null) {
            String str = ve().get("download_sdk_config", "");
            this.kp = str;
            if (!TextUtils.isEmpty(str)) {
                try {
                    this.tk = new JSONObject(this.kp);
                } catch (JSONException e) {
                    m.c(e);
                }
            }
        }
        return this.tk;
    }

    public int ir() {
        if (this.tx == Integer.MAX_VALUE) {
            this.tx = ve().get("splash_check_type", 1);
        }
        return this.tx;
    }

    public boolean tt(int i) {
        return x(i) != 0;
    }

    public boolean c(String str) {
        return nu(str).rh;
    }

    public boolean tt(String str) {
        return nu(str).my;
    }

    public long ve(String str) {
        return nu(str).gt;
    }

    public boolean g() {
        return ir() == 1;
    }

    public boolean hj() {
        if (this.cx == 2.14748365E9f) {
            this.cx = ve().get("global_sample", 1.0f);
        }
        return com.byazt.ktv.tt.c(this.cx, false);
    }

    public String xd() {
        if (TextUtils.isEmpty(this.eo)) {
            this.eo = ve().get("apm_pv_config", "");
        }
        return this.eo;
    }

    public JSONObject hq() {
        if (this.mf == null) {
            try {
                this.mf = new JSONObject(ve().get("log_rate_conf", ""));
            } catch (Exception unused) {
            }
        }
        return this.mf;
    }

    public boolean ny() {
        return com.byazt.by.n.c().x();
    }

    public JSONObject gx() {
        if (this.pn == null) {
            String str = ve().get("http_drop", "");
            if (!TextUtils.isEmpty(str)) {
                try {
                    this.pn = new JSONObject(str);
                } catch (Exception e) {
                    m.c(e);
                }
            }
        }
        return this.pn;
    }

    public boolean az() {
        if (this.ix == Integer.MAX_VALUE) {
            this.ix = this.f2549a.get("disable_show_url", 0);
        }
        return this.ix == 1;
    }

    public String is() {
        if (TextUtils.isEmpty(this.gk)) {
            this.gk = ve().get("dyn_draw_engine_url", "https://sf3-fe-tos.pglstatp-toutiao.com/obj/ad-pattern/renderer/package.json");
        }
        return this.gk;
    }

    public String jt() {
        if (TextUtils.isEmpty(this.e)) {
            this.e = ve().get("play_component_ugen_engine_url", "");
        }
        return this.e;
    }

    public String w() {
        if (TextUtils.isEmpty(this.pe)) {
            this.pe = ve().get("local_res_zip_url", "");
        }
        return this.pe;
    }

    public String nl() {
        if (TextUtils.isEmpty(this.nx)) {
            this.nx = ve().get("ad_pkg_info_url", "apps.bytesfield.com");
        }
        if (TextUtils.isEmpty(this.nx)) {
            this.nx = "apps.bytesfield.com";
        }
        return this.nx;
    }

    public String ej() {
        if (TextUtils.isEmpty(this.xr)) {
            this.xr = ve().get("splash_close_text", "跳过");
        }
        if (TextUtils.isEmpty(this.xr)) {
            this.xr = "跳过";
        }
        return this.xr;
    }

    public int pl() {
        return com.byazt.by.n.c().i();
    }

    public boolean di() {
        int iPl = pl();
        com.byazt.dna.n nVarTt = gr.tt();
        return (iPl == 40001 || iPl == 40002 || iPl == 4) && nVarTt != null && nVarTt.getArmorLoadStatus();
    }

    public boolean jg() {
        if (this.gr == Integer.MAX_VALUE) {
            this.gr = ve().getInt("enable_cdn_opt", 0);
        }
        return this.gr == 1;
    }

    public int hg() {
        if (this.yv == Integer.MAX_VALUE) {
            this.yv = ve().getInt("download_button_effect", 0);
        }
        return this.yv;
    }

    public boolean sd() {
        if (this.nq == Integer.MAX_VALUE) {
            this.nq = ve().get("settings_open", 1);
        }
        return this.nq == 1;
    }

    public void ve(int i) {
        if (this.nq != i) {
            this.nq = i;
            ve().put("settings_open", this.nq);
        }
    }

    public int ca() {
        if (this.cg == Integer.MAX_VALUE) {
            this.cg = ve().get("m_vids_join", 0);
        }
        int i = this.cg;
        if (i == Integer.MAX_VALUE) {
            return 0;
        }
        return i;
    }

    public long gk() {
        if (this.jm == 2147483647L) {
            this.jm = ve().get("bg_web_readd_t", C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS);
        }
        return this.jm;
    }

    public boolean e() {
        if (this.ym == Integer.MAX_VALUE) {
            this.ym = ve().get("title_priority", 0);
        }
        return this.ym == 1;
    }

    public boolean pe() {
        if (this.jf == Integer.MAX_VALUE) {
            this.jf = ve().get("splash_video_opt_enable", 0);
        }
        return this.jf == 1;
    }

    public boolean nx() {
        if (this.vr == Integer.MAX_VALUE) {
            this.vr = ve().get("gesture_through_enable", 0);
        }
        return this.vr == 1;
    }

    public boolean iw() {
        if (this.ls == Integer.MAX_VALUE) {
            this.ls = ve().get("disable_effects", 0);
        }
        return this.ls == 1;
    }

    public boolean bj() {
        if (this.wq == Integer.MAX_VALUE) {
            this.wq = ve().get("enable_layout_restrict", 0);
        }
        return this.wq == 1;
    }

    public boolean bp() {
        if (this.db == Integer.MAX_VALUE) {
            this.db = ve().get("dynamic_ugen_v3", 0);
        }
        return this.db == 1;
    }

    public boolean ph() {
        if (this.gc == Integer.MAX_VALUE) {
            this.gc = ve().get("creative_ugen_v3", 0);
        }
        return this.gc == 1;
    }

    public boolean dr() {
        if (this.pz == Integer.MAX_VALUE) {
            this.pz = ve().get("creative_ugen_v2", 0);
        }
        return this.pz == 1;
    }

    public int ly() {
        if (this.ef == Integer.MAX_VALUE) {
            this.ef = ve().get("refresh_req_num", 2);
        }
        if (this.ef <= 0) {
            this.ef = 2;
        }
        return this.ef;
    }

    public int px() {
        if (this.fb == Integer.MAX_VALUE) {
            this.fb = ve().get("refresh_max_times", 1);
        }
        if (this.fb < 0) {
            this.fb = 1;
        }
        return this.fb;
    }

    public String fk() {
        if (TextUtils.isEmpty(this.dh)) {
            this.dh = ve().get("policy_url", oq);
        }
        return this.dh;
    }

    public boolean cx() {
        if (!TextUtils.isEmpty(p.n) && p.n.compareTo(p.da) < 0) {
            return false;
        }
        Boolean bool = this.xo;
        if (bool != null) {
            return bool.booleanValue();
        }
        if (this.hl == null) {
            this.hl = Boolean.valueOf(ve().get("use_mediation_map", false));
        }
        Boolean bool2 = this.hl;
        this.xo = bool2;
        return bool2.booleanValue();
    }

    public boolean uj(String str) {
        int i = gt.tt().nu(String.valueOf(str)).uj;
        if (i != 1) {
            return i == 2 && rh.ve(gt.getContext()) != 0;
        }
        return rh.uj(gt.getContext());
    }

    public boolean n(String str) {
        return nu(String.valueOf(str)).n == 1;
    }

    public int a(String str) {
        return m(str).t;
    }

    public boolean sp(String str) {
        return str == null || gt.tt().m(String.valueOf(str)).da == 0;
    }

    public int x(String str) {
        if (str == null) {
            return 1500;
        }
        return gt.tt().nu(String.valueOf(str)).sl;
    }

    public int uj(int i) {
        return Math.max(nu(String.valueOf(i)).x, 0);
    }

    public int n(int i) {
        return Math.max(nu(String.valueOf(i)).i, 0);
    }

    public boolean i(String str) {
        try {
            c cVarNu = gt.tt().nu(String.valueOf(str));
            return (cVarNu == null || cVarNu.yp == null) ? false : true;
        } catch (Exception unused) {
            return false;
        }
    }

    public boolean da(String str) {
        try {
            c cVarM = gt.tt().m(String.valueOf(str));
            return (cVarM == null || cVarM.yp == null) ? false : true;
        } catch (Exception unused) {
            return false;
        }
    }

    public int sl(String str) {
        return nu(str).sp;
    }

    public List<String> mf() {
        if (this.os + bn.e < System.currentTimeMillis()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = this.oz.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList;
    }

    public int fv() {
        if (this.iw == Integer.MAX_VALUE) {
            this.iw = ve().get("sp_key_if_sp_cache", 1);
        }
        return this.iw;
    }

    public JSONObject st() {
        if (this.en == null) {
            try {
                String str = ve().get("video_cache_config", "");
                if (!TextUtils.isEmpty(str)) {
                    this.en = new JSONObject(str);
                }
            } catch (Throwable th) {
                m.tt("TTSdkSettings", th.getMessage());
            }
        }
        return this.en;
    }

    public List<String> en() {
        if (this.os + bn.e < System.currentTimeMillis()) {
            return null;
        }
        Map<String, Boolean> mapTt = yv.tt(86400000L);
        ArrayList arrayList = new ArrayList();
        synchronized (this.r) {
            for (String str : this.r) {
                if (!mapTt.containsKey(str.replaceAll("[&\\?]?tt_csj_scheme_priority=[^&]*", ""))) {
                    arrayList.add(str);
                }
            }
        }
        Collections.sort(arrayList, new Comparator<String>() { // from class: com.byazt.ogz.sl.4
            @Override // java.util.Comparator
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public int compare(String str2, String str3) {
                try {
                    return Integer.parseInt(Uri.parse(str2).getQueryParameter("tt_csj_scheme_priority")) - Integer.parseInt(Uri.parse(str3).getQueryParameter("tt_csj_scheme_priority"));
                } catch (Throwable unused) {
                    return 0;
                }
            }
        });
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            arrayList.set(i, ((String) arrayList.get(i)).replaceAll("[&\\?]?tt_csj_scheme_priority=[^&]*", ""));
        }
        return arrayList;
    }

    public Set<String> o() {
        if (this.s.size() == 0) {
            return null;
        }
        return this.s;
    }

    public boolean hc() {
        if (this.v == Integer.MAX_VALUE) {
            this.v = ve().get("app_list_control", 0);
        }
        return this.v == 1;
    }

    public int ab() {
        if (this.w == Integer.MAX_VALUE) {
            this.w = ve().get("max_tpl_cnts", 100);
        }
        return this.w;
    }

    public boolean oq() {
        if (this.lv == Integer.MAX_VALUE) {
            this.lv = ve().get("show_callback_mult", 0);
        }
        return this.lv == 1;
    }

    public int an() {
        if (this.ej == Integer.MAX_VALUE) {
            this.ej = ve().get("interact_show_after_time", 500);
        }
        return this.ej;
    }

    public int ne() {
        if (this.pl == 0) {
            this.pl = ve().get("fetch_tpl_timeout_ctrl_bad_device", 300);
        }
        return this.pl;
    }

    public boolean ix() {
        if (!this.hg) {
            this.hg = ve().get("tpl_enable_render_timeout_opt", false);
        }
        return this.hg;
    }

    public float lz() {
        if (this.di == 0.0f) {
            this.di = ve().get("tpl_render_error_rate_h5", 4.5f);
        }
        return this.di;
    }

    public float hs() {
        if (this.jg == 0.0f) {
            this.jg = ve().get("tpl_render_error_rate_native", 1.0f);
        }
        return this.jg;
    }

    public float te() {
        if (this.k == 0.0f) {
            this.k = ve().get("low_value", 7.3f);
        }
        return this.k;
    }

    public int c(String str, int i) {
        if (i == 0 || i == 9) {
            return u(str);
        }
        return t(str);
    }

    public boolean ri() {
        if (!this.dn) {
            this.dn = ve().get("enable", true);
        }
        return this.dn;
    }

    public boolean ts() {
        if (!this.cs) {
            this.cs = ve().get("session_enable", false);
        }
        return this.cs;
    }

    public float ft() {
        if (this.la < 0.0f) {
            this.la = ve().get("feature_stack_rate", 0.0f);
        }
        float f = this.la;
        if (f < 0.0f || f > 1.0f) {
            return 0.0f;
        }
        return f;
    }

    public int pa() {
        if (this.po <= 0) {
            this.po = ve().get("view_traverse_depth", 20);
        }
        int i = this.po;
        if (i <= 0) {
            return 20;
        }
        return i;
    }

    public float tp() {
        if (this.kn < 0.0f) {
            this.kn = ve().get("feature_chain_factor", 1.0f);
        }
        float f = this.kn;
        if (f <= 0.0f) {
            return 1.0f;
        }
        if (f > 100.0f) {
            return 100.0f;
        }
        return f;
    }

    public int pr() {
        if (this.ka < 0) {
            this.ka = ve().get("feature_req_switch", 0);
        }
        int i = this.ka;
        if (i == 0 || i == 1) {
            return i;
        }
        return 0;
    }

    public List<Integer> gl() {
        return new ArrayList(this.hz);
    }

    public int t(String str) {
        int iTt;
        if (this.vl == null) {
            return 5000;
        }
        str.hashCode();
        switch (str) {
            case "banner_ad":
                iTt = this.vl.tt("banner");
                break;
            case "rewarded_video":
                iTt = this.vl.tt("rewarded");
                break;
            case "fullscreen_interstitial_ad":
                iTt = this.vl.tt("fullscreen");
                break;
            case "embeded_ad":
                iTt = this.vl.tt("feed");
                break;
            case "draw_ad":
                iTt = this.vl.tt(MediationConstant.RIT_TYPE_DRAW);
                break;
            default:
                iTt = 5000;
                break;
        }
        if (iTt <= 0) {
            return 5000;
        }
        return iTt;
    }

    public int u(String str) {
        int iC;
        if (this.vl == null) {
            return 5000;
        }
        str.hashCode();
        switch (str) {
            case "banner_ad":
                iC = this.vl.c("banner");
                break;
            case "rewarded_video":
                iC = this.vl.c("rewarded");
                break;
            case "fullscreen_interstitial_ad":
                iC = this.vl.c("fullscreen");
                break;
            case "embeded_ad":
                iC = this.vl.c("feed");
                break;
            case "draw_ad":
                iC = this.vl.c(MediationConstant.RIT_TYPE_DRAW);
                break;
            default:
                iC = 5000;
                break;
        }
        if (iC <= 0) {
            return 5000;
        }
        return iC;
    }

    public int ru() {
        if (this.bj == Integer.MAX_VALUE) {
            this.bj = ve().get("webview_cache_count", 0);
        }
        int i = this.bj;
        if (i < 0) {
            return 0;
        }
        return i;
    }

    public int op() {
        if (this.bp == Integer.MAX_VALUE) {
            this.bp = ve().get("webview_cache_count_v3", 0);
        }
        int i = this.bp;
        if (i < 0) {
            return 0;
        }
        return i;
    }

    public int a(int i) {
        c cVarNu = nu(String.valueOf(i));
        if (cVarNu.tt <= 0 || cVarNu.tt > 5) {
            return 1;
        }
        return cVarNu.tt;
    }

    public int sp(int i) {
        return nu(String.valueOf(i)).f2548a;
    }

    public int x(int i) {
        int i2 = m(String.valueOf(i)).z;
        if (i2 == 0 || i2 == 1 || i2 == 2 || i2 == 3 || i2 == 4) {
            return i2;
        }
        return 2;
    }

    public int i(int i) {
        return m(String.valueOf(i)).m;
    }

    public int yp(String str) {
        return m(String.valueOf(str)).nu;
    }

    public boolean da(int i) {
        return nu(String.valueOf(i)).u;
    }

    public boolean z(String str) {
        return nu(str).tt() == 1;
    }

    public int tj() {
        if (this.ij == Integer.MAX_VALUE) {
            this.ij = ve().get("vbtt", 5);
        }
        return this.ij;
    }

    public c m(String str) {
        if (str == null) {
            return uj(new JSONObject());
        }
        c cVarRl = this.ic.get(str);
        if (cVarRl == null) {
            cVarRl = rl(str);
        }
        if (cVarRl != null) {
            return cVarRl;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("code_id", str);
            return uj(jSONObject);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public c nu(String str) {
        if (str == null) {
            return uj(new JSONObject());
        }
        c cVarQy = this.ic.get(str);
        if (cVarQy == null) {
            cVarQy = qy(str);
        }
        if (cVarQy != null) {
            return cVarQy;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("code_id", str);
            return uj(jSONObject);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public void nm() {
        if (this.ck == null) {
            synchronized (this.ey) {
                if (this.ck == null) {
                    this.ck = com.byazt.nys.tt.tt(gt.getContext(), com.byazt.bnf.c.tt(com.byazt.vxy.c.c().c(this.d), x()), 0);
                }
            }
        }
    }

    private c rl(String str) {
        c cVarUj = null;
        try {
            nm();
            String string = this.ck.getString(gt(str), null);
            if (TextUtils.isEmpty(string)) {
                return null;
            }
            cVarUj = uj(new JSONObject(string));
            this.ic.put(str, cVarUj);
            return cVarUj;
        } catch (Throwable th) {
            m.tt("TTSdkSetting", "buildSlot failed:" + th.getMessage());
            return cVarUj;
        }
    }

    private c qy(String str) {
        String string;
        com.byazt.it.ve veVarI = i();
        c cVarUj = null;
        try {
            if (veVarI == null) {
                if (this.ku == null) {
                    this.ku = com.byazt.nys.tt.tt(gt.getContext(), com.byazt.bnf.c.tt(com.byazt.vxy.c.c().c(this.d), sp()), 0);
                }
                string = this.ku.getString(gt(str), "");
            } else {
                string = veVarI.get(gt(str), "");
            }
            if (TextUtils.isEmpty(string)) {
                return null;
            }
            cVarUj = uj(new JSONObject(string));
            this.ic.put(str, cVarUj);
            return cVarUj;
        } catch (Throwable th) {
            m.tt("TTSdkSetting", "buildSlot failed:" + th.getMessage());
            return cVarUj;
        }
    }

    public int pb() {
        if (this.ra == -1) {
            this.ra = ve().get("gnd_prefetch_cache_size", 5);
        }
        return this.ra;
    }

    public long sy() {
        if (this.bw == -1) {
            this.bw = ve().get("gnd_prefetch_cache_ttl", 0L);
        }
        return this.bw;
    }

    public int id() {
        if (this.yx == Integer.MAX_VALUE) {
            this.yx = ve().get("enable_target_34", 1);
        }
        return this.yx;
    }

    public boolean sf() {
        if (this.fv == Integer.MAX_VALUE) {
            this.fv = ve().get("read_video_from_cache", 1);
        }
        return this.fv == 1;
    }

    public int rp() {
        int i = ve().get("npth_enable_type", 0);
        this.x = i;
        return i;
    }

    public boolean tu() {
        return this.jc.ve;
    }

    public boolean ra() {
        return this.jc.c;
    }

    public boolean jm() {
        if (!na) {
            synchronized (this.ew) {
                if (!na) {
                    dw = ve().get("disable_easy_playable", true);
                    na = true;
                }
            }
        }
        return dw;
    }

    public int jf() {
        if (ve == Integer.MAX_VALUE) {
            String str = this.f2549a.get("pglam", "");
            if (!TextUtils.isEmpty(str)) {
                try {
                    ve = new JSONObject(str).optInt("pgl_4TypeEncrypt_close", 0);
                } catch (JSONException e) {
                    m.c(e);
                    return 0;
                }
            }
        }
        return ve;
    }

    public int vr() {
        if (uj == Integer.MAX_VALUE) {
            uj = js().getInt("pgl_soIntegrity_check", 0);
        }
        return uj;
    }

    public int ls() {
        if (n == Integer.MAX_VALUE) {
            n = js().getInt("pgl_soverfailstrategy_enable", 0);
        }
        return n;
    }

    public String[] ef() {
        String str = this.nm;
        if (str == null || str.length() <= 0) {
            return null;
        }
        return this.nm.split(UrlConst.PRD_KEY);
    }

    public boolean mk() {
        return p.x() && this.ul == 1;
    }

    public int by() {
        if (this.ys == 0) {
            this.ys = js().getInt("is_kv_cache_type", 0);
        }
        return this.ys;
    }

    public int ck() {
        if (this.xg == 0) {
            this.xg = js().getInt("kv_init_type", 0);
        }
        return this.xg;
    }

    public String ey() {
        if (this.sf != 1) {
            return "";
        }
        if (!TextUtils.isEmpty(this.fq)) {
            return this.fq;
        }
        String str = mn().get("lp_list", this.fq);
        this.fq = str;
        return str;
    }

    public String qt() {
        if (TextUtils.isEmpty(this.xv)) {
            this.xv = js().getString("md5", "");
        }
        return this.xv;
    }

    public String fe() {
        if (TextUtils.isEmpty(this.rp)) {
            this.rp = js().getString("url", "");
        }
        return this.rp;
    }

    public boolean ge() {
        if (this.xw == null) {
            this.xw = Boolean.valueOf(ve().get("rule_engine_enable", false));
        }
        return this.xw.booleanValue();
    }

    public boolean rh(String str) {
        if (TextUtils.isEmpty(str) || str.equals("http") || str.equals("https")) {
            return false;
        }
        if (this.yg == 0) {
            this.yg = ve().get("open_dl_type", 0);
        }
        int i = this.yg;
        if (i == 0) {
            return false;
        }
        if (i == 2) {
            return true;
        }
        return gu(str);
    }

    private boolean gu(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (!TextUtils.isEmpty(this.xx)) {
            this.xx = ve().get("app_dl_scheme_list", "");
        }
        if (TextUtils.isEmpty(this.xx)) {
            return false;
        }
        String[] strArrSplit = this.xx.split(",");
        if (strArrSplit.length == 0) {
            return false;
        }
        for (String str2 : strArrSplit) {
            if (str.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    public boolean kn() {
        if (this.il == 1) {
            this.il = ve().get("ud_enable", 1);
        }
        return this.il == 1;
    }

    private SharedPreferences js() {
        if (this.fk == null) {
            this.fk = com.byazt.nys.tt.tt(gt.getContext(), n(), 0);
        }
        return this.fk;
    }

    public JSONObject jc() {
        if (this.bz == null) {
            String str = ve().get("dex_strategy", "");
            if (!TextUtils.isEmpty(str)) {
                try {
                    this.bz = new JSONObject(str);
                } catch (JSONException unused) {
                }
            }
        }
        return this.bz;
    }

    public boolean vl() {
        if (this.vz == null) {
            this.vz = Boolean.valueOf(ve().get("node_line_enable", false));
        }
        return this.vz.booleanValue();
    }

    /* JADX INFO: renamed from: if, reason: not valid java name */
    public JSONObject m772if() {
        if (this.gx == null) {
            try {
                this.gx = new JSONObject(ve().get("app_common_config", ""));
            } catch (JSONException unused) {
            }
        }
        return this.gx;
    }

    private void i(JSONObject jSONObject) {
        try {
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("bottom_tab_white_list");
            if (jSONArrayOptJSONArray != null) {
                Set<String> setSynchronizedSet = Collections.synchronizedSet(new HashSet());
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    String strOptString = jSONArrayOptJSONArray.optString(i);
                    if (strOptString != null && !strOptString.isEmpty()) {
                        setSynchronizedSet.add(strOptString);
                    }
                }
                this.gy = setSynchronizedSet;
                ve().put("bottom_tab_white_list", jSONArrayOptJSONArray.toString());
            }
            JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("bottom_tab_black_list");
            if (jSONArrayOptJSONArray2 != null) {
                Set<String> setSynchronizedSet2 = Collections.synchronizedSet(new HashSet());
                for (int i2 = 0; i2 < jSONArrayOptJSONArray2.length(); i2++) {
                    String strOptString2 = jSONArrayOptJSONArray2.optString(i2);
                    if (strOptString2 != null && !strOptString2.isEmpty()) {
                        setSynchronizedSet2.add(strOptString2);
                    }
                }
                this.mm = setSynchronizedSet2;
                ve().put("bottom_tab_black_list", jSONArrayOptJSONArray2.toString());
            }
        } catch (Throwable unused) {
        }
    }

    private Set<String> wj() {
        Set<String> setSynchronizedSet = Collections.synchronizedSet(new HashSet());
        try {
            String str = ve().get("bottom_tab_white_list", "");
            if (str != null && !str.isEmpty()) {
                JSONArray jSONArray = new JSONArray(str);
                for (int i = 0; i < jSONArray.length(); i++) {
                    String strOptString = jSONArray.optString(i);
                    if (strOptString != null && !strOptString.isEmpty()) {
                        setSynchronizedSet.add(strOptString);
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return setSynchronizedSet;
    }

    private Set<String> dp() {
        Set<String> setSynchronizedSet = Collections.synchronizedSet(new HashSet());
        try {
            String str = ve().get("bottom_tab_black_list", "");
            if (str != null && !str.isEmpty()) {
                JSONArray jSONArray = new JSONArray(str);
                for (int i = 0; i < jSONArray.length(); i++) {
                    String strOptString = jSONArray.optString(i);
                    if (strOptString != null && !strOptString.isEmpty()) {
                        setSynchronizedSet.add(strOptString);
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return setSynchronizedSet;
    }

    public Set<String> xl() {
        if (this.gy == null) {
            this.gy = wj();
        }
        return this.gy;
    }

    public Set<String> lx() {
        if (this.mm == null) {
            this.mm = dp();
        }
        return this.mm;
    }

    public boolean wn() {
        if (this.yw == null) {
            this.yw = Boolean.valueOf(ve().get("node_line_detail_enable", false));
        }
        return this.yw.booleanValue();
    }
}
