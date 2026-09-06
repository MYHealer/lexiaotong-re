package com.byazt.ete;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.cdo.oaps.ad.OapsKey;
import com.huawei.hms.ads.ld;
import com.huawei.openalliance.ad.constant.ba;
import com.kwad.components.offline.api.IOfflineCompo;
import com.ubixnow.ooooo.o0OO000o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 8, MediaPlayer.MEDIA_PLAYER_OPTION_OUTLET_CREATE_TIME})
public class ic implements com.byazt.eia.da, com.byazt.eia.i, com.byazt.eia.sl, com.byazt.eia.sp, com.byazt.eia.x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f2180a;
    public sv ab;
    public long an;
    public String az;
    public Map<String, Object> b;
    public int bj;
    public int bp;
    public int br;
    public String bw;
    public boolean bx;
    public hq c;
    public l ca;
    public String cf;
    public String cg;
    public lr ck;
    public to cl;
    public int cu;
    public int cx;
    public JSONObject d;
    public q dh;
    public int dn;
    public int dr;
    public hd ef;
    public String ej;
    public boolean em;
    public z en;
    public String eo;
    public md ey;
    public JSONObject f;
    public int fe;
    public r fk;
    public String fq;
    public p fr;
    public a ft;
    public int fv;
    public JSONObject g;
    public int ge;
    public pf gk;
    public String gl;
    public n gr;
    public String gt;
    public int gx;
    public int gy;
    public String h;
    public yp hc;
    public String hg;
    public int hj;
    public oz hs;
    public boolean hz;
    public String i;

    /* JADX INFO: renamed from: if, reason: not valid java name */
    public com.byazt.seg.c f923if;
    public String ij;
    public JSONObject il;
    public long is;
    public int iw;
    public lo ix;
    public String j;
    public kk jc;
    public JSONObject jf;
    public int jl;
    public int jm;
    public String jt;
    public boolean jy;
    public JSONObject ka;
    public lt kk;
    public volatile String kn;
    public gt kp;
    public boolean ku;
    public String kz;
    public volatile String la;
    public h ls;
    public my lz;
    public String md;
    public String mf;
    public s mm;
    public boolean mq;
    public long my;
    public int n;
    public xd nb;
    public pu ne;
    public String nl;
    public boolean nq;
    public iu nx;
    public String o;
    public int op;
    public j oq;
    public long or;
    public int ox;
    public int p;
    public String pa;
    public String pb;
    public int pf;
    public int ph;
    public int pl;
    public int pr;
    public kp q;
    public int qp;
    public rh qt;
    public com.byazt.dj.tt r;
    public String ra;
    public String rh;
    public cu ri;
    public String rl;
    public yv rp;
    public int s;
    public volatile JSONObject sf;
    public String sl;
    public tx sp;
    public int st;
    public boolean sv;
    public boolean sy;
    public JSONObject t;
    public qp te;
    public sl tj;
    public boolean tk;
    public int tp;
    public qy ts;
    public String tt;
    public JSONObject u;
    public com.byazt.vo.tt uj;
    public String ul;
    public String up;
    public String uv;
    public bx v;
    public String ve;
    public String vi;
    public int vl;
    public long vp;
    public JSONObject vr;
    public boolean w;
    public or wq;
    public zb x;
    public boolean xg;
    public com.byazt.lo.c xl;
    public int xr;
    public zm xv;
    public JSONObject xw;
    public int xx;
    public int y;
    public JSONObject ym;
    public String ys;
    public int yt;
    public nu yv;
    public String z;
    public long zb;
    public rl zm;
    public int da = -1;
    public List<zb> yp = new ArrayList();
    public List<String> m = new ArrayList();
    public List<String> nu = new ArrayList();
    public String qy = "0";
    public String gu = "0";
    public int aw = 100;
    public long ic = -1;
    public long hd = -1;
    public long bm = -1;
    public int lr = -1;
    public int l = 1;
    public long lo = System.currentTimeMillis();
    public String pu = UUID.randomUUID().toString();
    public int lt = 1;
    public String to = "";
    public boolean tx = false;
    public int os = IOfflineCompo.Priority.HIGHEST;
    public int oz = 0;
    public int iu = 1;
    public int dz = 0;
    public int ma = 0;
    public int yf = 0;
    public int ir = 1;
    public int xd = 0;
    public int hq = 0;
    public int ny = 0;
    public int nt = 0;
    public int pn = 1;
    public boolean yo = false;
    public int di = 1;
    public float jg = 100.0f;
    public int sd = 0;
    public int k = 2;
    public int iy = 0;
    public int nc = 100;
    public int e = 2;
    public int pe = 2;
    public float ly = 0.07f;
    public float px = 0.0f;
    public long ru = 0;
    public boolean nm = true;
    public int id = -1;
    public int tu = 0;
    public int fb = 0;
    public long mk = 0;
    public int by = 0;
    public List<eo> cs = new ArrayList();
    public int po = -1;
    public int mc = 1;
    public int qe = -1001;
    public int yg = 0;

    private int vz() {
        return this.aw;
    }

    @Override // com.byazt.eia.da
    public hq A_() {
        return this.c;
    }

    @Override // com.byazt.eia.sp
    public boolean B_() {
        return this.sy;
    }

    @Override // com.byazt.eia.i
    public q C_() {
        return this.dh;
    }

    @Override // com.byazt.eia.i
    public kk D_() {
        return this.jc;
    }

    public void a(int i) {
        if (this.xx == 0) {
            this.xx = i;
        }
    }

    public void a(long j) {
        this.or = j;
    }

    public void a(String str) {
        this.ys = str;
    }

    public void a(JSONObject jSONObject) {
        this.f = jSONObject;
    }

    public void a(boolean z) {
        this.xg = z;
    }

    public String an() {
        return this.md;
    }

    public String aw() {
        return this.pb;
    }

    public void aw(String str) {
        this.ra = str;
    }

    public int az() {
        return this.s;
    }

    public long b() {
        return this.vp;
    }

    public void b(int i) {
        if (i < 0 || i > 100) {
            return;
        }
        this.nc = i;
    }

    public void bm(int i) {
        this.lt = i;
    }

    public boolean bm() {
        return this.nq;
    }

    public int br() {
        return this.bj;
    }

    public boolean bw() {
        return this.tk;
    }

    public int bx() {
        return this.ox;
    }

    public void bx(int i) {
        this.da = i;
    }

    public void bx(String str) {
        this.o = str;
    }

    public int by() {
        if (this.di != 2) {
            this.di = 1;
        }
        return this.di;
    }

    public boolean bz() {
        return this.tx;
    }

    public String c() {
        return this.kn;
    }

    public void c(double d) {
        if (d == 2.0d || d == 1.0d) {
            this.pe = (int) d;
        } else {
            this.pe = 2;
        }
    }

    public void c(float f) {
        this.jg = f;
    }

    public void c(int i) {
        this.po = i;
    }

    public void c(long j) {
        this.vp = j;
    }

    public void c(a aVar) {
        this.ft = aVar;
    }

    public void c(bx bxVar) {
        this.v = bxVar;
    }

    public void c(cu cuVar) {
        this.ri = cuVar;
    }

    public void c(gt gtVar) {
        this.kp = gtVar;
    }

    public void c(h hVar) {
        this.ls = hVar;
    }

    public void c(hq hqVar) {
        this.c = hqVar;
    }

    public void c(iu iuVar) {
        this.nx = iuVar;
    }

    public void c(j jVar) {
        this.oq = jVar;
    }

    public void c(kk kkVar) {
        this.jc = kkVar;
    }

    public void c(kp kpVar) {
        this.q = kpVar;
    }

    public void c(l lVar) {
        this.ca = lVar;
    }

    public void c(lo loVar) {
        this.ix = loVar;
    }

    public void c(lr lrVar) {
        this.ck = lrVar;
    }

    public void c(lt ltVar) {
        this.kk = ltVar;
    }

    public void c(md mdVar) {
        this.ey = mdVar;
    }

    public void c(my myVar) {
        this.lz = myVar;
    }

    public void c(n nVar) {
        this.gr = nVar;
    }

    public void c(nu nuVar) {
        this.yv = nuVar;
    }

    public void c(or orVar) {
        this.wq = orVar;
    }

    public void c(oz ozVar) {
        this.hs = ozVar;
    }

    public void c(p pVar) {
        this.fr = pVar;
    }

    public void c(pf pfVar) {
        this.gk = pfVar;
    }

    public void c(pu puVar) {
        this.ne = puVar;
    }

    public void c(q qVar) {
        this.dh = qVar;
    }

    public void c(qp qpVar) {
        this.te = qpVar;
    }

    public void c(qy qyVar) {
        this.ts = qyVar;
    }

    public void c(r rVar) {
        this.fk = rVar;
    }

    public void c(rl rlVar) {
        this.zm = rlVar;
    }

    public void c(s sVar) {
        this.mm = sVar;
    }

    public void c(sl slVar) {
        this.tj = slVar;
    }

    public void c(sv svVar) {
        this.ab = svVar;
    }

    public void c(to toVar) {
        this.cl = toVar;
    }

    public void c(tx txVar) {
        this.sp = txVar;
    }

    public void c(xd xdVar) {
        this.nb = xdVar;
    }

    public void c(yp ypVar) {
        this.hc = ypVar;
    }

    public void c(yv yvVar) {
        this.rp = yvVar;
    }

    public void c(z zVar) {
        this.en = zVar;
    }

    public void c(zb zbVar) {
        this.x = zbVar;
    }

    public void c(com.byazt.lo.c cVar) {
        this.xl = cVar;
    }

    public void c(com.byazt.seg.c cVar) {
        this.f923if = cVar;
    }

    public void c(com.byazt.vo.tt ttVar) {
        this.uj = ttVar;
    }

    public void c(String str) {
        this.kn = str;
    }

    public void c(Map<String, Object> map) {
        this.b = map;
    }

    public void c(boolean z) {
        this.hz = z;
    }

    public iu cg() {
        return this.nx;
    }

    public int cj() {
        return this.tu;
    }

    public String ck() {
        return this.gl;
    }

    public int cs() {
        return this.nc;
    }

    public int cu() {
        return this.ge;
    }

    public void cu(int i) {
        this.lr = i;
    }

    public void cu(String str) {
        this.hg = str;
    }

    public JSONObject cx() {
        return this.il;
    }

    public JSONObject cy() {
        return this.jf;
    }

    public void d(int i) {
        this.dr = i;
    }

    public void d(String str) {
        this.tt = str;
    }

    @Override // com.byazt.eia.i
    public String da() {
        return this.mf;
    }

    public void da(int i) {
        this.xr = i;
    }

    public void da(long j) {
        this.bm = j;
    }

    public void da(String str) {
        this.cf = str;
    }

    public void da(JSONObject jSONObject) {
        this.jf = jSONObject;
    }

    public void da(boolean z) {
        this.sv = z;
    }

    public boolean dh() {
        return this.l == 1;
    }

    public cu dp() {
        return this.ri;
    }

    public long dz() {
        return this.is;
    }

    public int e() {
        return this.ph;
    }

    public l ef() {
        return this.ca;
    }

    public int ej() {
        return this.pn;
    }

    public j ek() {
        return this.oq;
    }

    public String em() {
        return this.ej;
    }

    public int en() {
        return this.pr;
    }

    public int eo() {
        return this.xx;
    }

    public void eo(int i) {
        this.tp = i;
    }

    public void eo(String str) {
        this.ej = str;
    }

    public long ey() {
        return this.ru;
    }

    public int f() {
        return this.e;
    }

    public qp fb() {
        return this.te;
    }

    public int fq() {
        return this.lt;
    }

    public float fr() {
        if (this.jg <= 0.0f) {
            this.jg = 100.0f;
        }
        return (this.jg * 1000.0f) / 1000.0f;
    }

    public JSONObject ft() {
        return this.u;
    }

    public String fv() {
        return this.pa;
    }

    public int g() {
        return this.nt;
    }

    public int ge() {
        return this.iw;
    }

    public List<String> gl() {
        return this.nu;
    }

    @Override // com.byazt.eia.sp
    public String gr() {
        return this.j;
    }

    public void gr(int i) {
        this.y = i;
    }

    public void gr(String str) {
        this.h = str;
    }

    @Override // com.byazt.eia.sl
    public pf gt() {
        return this.gk;
    }

    public void gt(int i) {
        this.ma = i;
    }

    public void gt(String str) {
        this.rh = str;
    }

    @Override // com.byazt.eia.sp
    public String gu() {
        return this.gu;
    }

    public void gu(int i) {
        this.s = i;
    }

    public void gu(String str) {
        this.qy = str;
    }

    public lo gx() {
        return this.ix;
    }

    public pu gy() {
        return this.ne;
    }

    public int h() {
        return this.yg;
    }

    public void h(int i) {
        this.ph = i;
    }

    public void h(String str) {
        this.j = str;
    }

    public int hc() {
        return this.pf;
    }

    public void hd(int i) {
        this.cu = i;
    }

    public boolean hd() {
        return this.em;
    }

    public int hj() {
        return this.ny;
    }

    public String hl() {
        return this.cg;
    }

    public or hq() {
        return this.wq;
    }

    public int hz() {
        return this.sd;
    }

    @Override // com.byazt.eia.x
    public int i() {
        return this.n;
    }

    public void i(int i) {
        this.ox = i;
    }

    public void i(long j) {
        this.hd = j;
    }

    public void i(String str) {
        this.vi = str;
    }

    public void i(JSONObject jSONObject) {
        this.ym = jSONObject;
    }

    public void i(boolean z) {
        this.bx = z;
    }

    public rh ic() {
        return this.qt;
    }

    public void ic(int i) {
        this.p = i;
    }

    public int id() {
        return this.p;
    }

    /* JADX INFO: renamed from: if, reason: not valid java name */
    public int m760if() {
        return this.cx;
    }

    public com.byazt.dj.tt ij() {
        return this.r;
    }

    public int il() {
        return this.gx;
    }

    public int ir() {
        return this.qp;
    }

    public int is() {
        return this.y;
    }

    public void iu(int i) {
        this.qe = i;
    }

    public boolean iu() {
        return this.w;
    }

    public tx ix() {
        return this.sp;
    }

    public String j() {
        return this.az;
    }

    public void j(int i) {
        this.mc = i;
    }

    public to jc() {
        return this.cl;
    }

    public int jf() {
        return this.xd;
    }

    public JSONObject jm() {
        return this.f;
    }

    public bx js() {
        return this.v;
    }

    public int jt() {
        return this.os;
    }

    public float jy() {
        float f = this.px;
        if (f < 0.0f || f > 50.0f) {
            this.px = 0.0f;
        }
        return this.px;
    }

    public long kk() {
        return this.an;
    }

    public yv kn() {
        return this.rp;
    }

    public JSONObject kp() {
        return this.sf;
    }

    public void kp(int i) {
        this.sd = i;
    }

    public int ku() {
        return this.pl;
    }

    public int kz() {
        return this.id;
    }

    public String l() {
        return this.fq;
    }

    public void l(int i) {
        this.xd = i;
    }

    public JSONObject la() {
        return this.xw;
    }

    public String lo() {
        return this.ul;
    }

    public void lo(int i) {
        this.hq = i;
    }

    public void lr(int i) {
        int i2 = this.aw;
        if (i2 == 100 || i2 == 102) {
            this.aw = i;
        }
    }

    public boolean lr() {
        return this.ku;
    }

    public String ls() {
        return this.tt;
    }

    public String lt() {
        return this.ys;
    }

    public void lt(int i) {
        this.di = i;
    }

    public JSONObject lv() {
        return this.ym;
    }

    public boolean lx() {
        return this.yo;
    }

    @Override // com.byazt.eia.i
    public String m() {
        return this.uv;
    }

    public void m(int i) {
        this.dz = i;
    }

    public void m(String str) {
        this.md = str;
    }

    public void m(boolean z) {
        this.nm = z;
    }

    public int ma() {
        return this.op;
    }

    public int md() {
        return this.dn;
    }

    public void md(int i) {
        this.pn = i;
    }

    public void md(String str) {
        this.to = str;
    }

    public s mf() {
        return this.mm;
    }

    public String mk() {
        return this.nl;
    }

    public int mm() {
        return this.yt;
    }

    public sl mn() {
        return this.tj;
    }

    public int mq() {
        return this.iu;
    }

    public int mu() {
        return this.qe;
    }

    @Override // com.byazt.eia.i
    public yp my() {
        return this.hc;
    }

    public void my(int i) {
        this.id = i;
    }

    public void my(String str) {
        this.z = str;
    }

    @Override // com.byazt.eia.i
    public int n() {
        return this.st;
    }

    public void n(int i) {
        this.fe = i;
    }

    public void n(long j) {
        this.zb = j;
    }

    public void n(String str) {
        this.ul = str;
    }

    public void n(JSONObject jSONObject) {
        this.u = jSONObject;
    }

    public void n(boolean z) {
        this.ku = z;
    }

    public int nb() {
        return this.br;
    }

    public void nb(int i) {
        this.n = i;
    }

    public void nb(String str) {
        this.uv = str;
    }

    public int ne() {
        return this.f2180a;
    }

    public int nl() {
        return this.hj;
    }

    public rl nm() {
        return this.zm;
    }

    public boolean nt() {
        return this.dz == 1;
    }

    public void nu(int i) {
        this.yt = i;
    }

    public void nu(String str) {
        this.i = str;
    }

    public int ny() {
        return this.dz;
    }

    public xd o() {
        return this.nb;
    }

    public String op() {
        return this.gt;
    }

    public int oq() {
        return this.l;
    }

    public void or(int i) {
        this.pf = i;
    }

    public void or(String str) {
        this.gl = str;
    }

    public com.byazt.lo.c os() {
        return this.xl;
    }

    public void os(int i) {
        if (i <= 0 || i > 9) {
            this.k = 3;
        } else {
            this.k = i;
        }
    }

    public String oz() {
        return this.vi;
    }

    public void oz(int i) {
        this.bp = i;
    }

    public int p() {
        return this.po;
    }

    public void p(int i) {
        this.hj = i;
    }

    public void p(String str) {
        this.pu = str;
    }

    public List<zb> pa() {
        return this.yp;
    }

    public int pb() {
        return this.gy;
    }

    public int pe() {
        return this.dr;
    }

    public void pf(int i) {
        this.f2180a = i;
    }

    public void pf(String str) {
        this.mf = str;
    }

    public my pn() {
        return this.lz;
    }

    public zm po() {
        return this.xv;
    }

    public List<String> pr() {
        return this.m;
    }

    public int pu() {
        return this.xr;
    }

    public void pu(int i) {
        this.pl = i;
    }

    public String q() {
        return this.kz;
    }

    public void q(int i) {
        this.iy = i;
    }

    public float qe() {
        float f = this.ly;
        if (f < 0.07f || f > 0.175f) {
            this.ly = 0.07f;
        }
        return this.ly;
    }

    public z qi() {
        return this.en;
    }

    public void qp(int i) {
        this.l = i;
    }

    public void qp(String str) {
        this.ve = str;
    }

    public boolean qp() {
        return this.ge == 1;
    }

    @Override // com.byazt.eia.i
    public String qy() {
        return this.eo;
    }

    public void qy(int i) {
        this.oz = i;
    }

    public void qy(String str) {
        this.rl = str;
    }

    public void r(int i) {
        this.tu = i;
    }

    public boolean r() {
        return this.mq;
    }

    public long ra() {
        return this.bm;
    }

    @Override // com.byazt.eia.sp
    public a rh() {
        return this.ft;
    }

    public void rh(int i) {
        this.yf = i;
    }

    public void rh(String str) {
        this.sl = str;
    }

    public int ri() {
        return this.da;
    }

    public void rl(int i) {
        this.iu = i;
    }

    public void rl(String str) {
        this.gt = str;
    }

    public int rm() {
        return this.mc;
    }

    public long ru() {
        return this.my;
    }

    public String s() {
        return this.cf;
    }

    public void s(int i) {
        this.fb = i;
    }

    @Override // com.byazt.eia.sl
    public boolean s_() {
        return this.hz;
    }

    public String sf() {
        return this.pu;
    }

    @Override // com.byazt.eia.i
    public sv sl() {
        return this.ab;
    }

    public void sl(int i) {
        this.vl = i;
    }

    public void sl(String str) {
        this.jt = str;
    }

    public void sl(JSONObject jSONObject) {
        this.vr = jSONObject;
    }

    @Override // com.byazt.eia.x
    public int sp() {
        return this.jl;
    }

    public void sp(int i) {
        this.ge = i;
    }

    public void sp(long j) {
        this.lo = j;
    }

    public void sp(String str) {
        this.up = str;
    }

    public void sp(JSONObject jSONObject) {
        this.g = jSONObject;
    }

    public void sp(boolean z) {
        this.mq = z;
    }

    public int st() {
        return this.tp;
    }

    public void sv(int i) {
        this.gx = i;
    }

    public void sv(String str) {
        this.cg = str;
    }

    @Override // com.byazt.eia.i
    public String t() {
        return this.o;
    }

    public void t(int i) {
        this.op = i;
    }

    public void t(String str) {
        this.az = str;
    }

    public void t(boolean z) {
        this.tk = z;
    }

    @Override // com.byazt.eia.i
    public String t_() {
        return this.bw;
    }

    public zb te() {
        return this.x;
    }

    public String tj() {
        return this.rl;
    }

    public void tk(int i) {
        if (i < 0 || i > 180) {
            this.bj = 50;
        } else {
            this.bj = i;
        }
    }

    public boolean tk() {
        return this.xg;
    }

    public String to() {
        return this.up;
    }

    public void to(int i) {
        if (i < 12) {
            i = 12;
        }
        if (i > 20) {
            i = 20;
        }
        this.iw = i;
    }

    public String tp() {
        return this.z;
    }

    public JSONObject ts() {
        return this.t;
    }

    public void tt(double d) {
        if (d == 2.0d || d == 1.0d) {
            this.e = (int) d;
        } else {
            this.e = 2;
        }
    }

    public void tt(float f) {
        this.ly = f;
    }

    public void tt(int i) {
        this.dn = i;
    }

    public void tt(long j) {
        this.an = j;
    }

    public void tt(JSONObject jSONObject) {
        this.sf = jSONObject;
    }

    public void tt(boolean z) {
        this.jy = z;
    }

    public long tu() {
        return this.hd;
    }

    public void tx(int i) {
        this.fv = i;
    }

    @Override // com.byazt.eia.i
    public qy u() {
        return this.ts;
    }

    public void u(int i) {
        this.qp = i;
    }

    public void u(String str) {
        this.ij = str;
    }

    public void u(JSONObject jSONObject) {
        this.ka = jSONObject;
    }

    public void u(boolean z) {
        this.sy = z;
    }

    @Override // com.byazt.eia.sp
    public gt u_() {
        return this.kp;
    }

    @Override // com.byazt.eia.i
    public String uj() {
        return this.qy;
    }

    public void uj(int i) {
        this.jl = i;
    }

    public void uj(long j) {
        this.my = j;
    }

    public void uj(String str) {
        this.fq = str;
    }

    public void uj(JSONObject jSONObject) {
        this.t = jSONObject;
    }

    public void uj(boolean z) {
        this.nq = z;
    }

    public long ul() {
        return this.or;
    }

    public boolean up() {
        return this.sv;
    }

    public JSONObject ur() {
        return this.ka;
    }

    public long uv() {
        return this.zb;
    }

    public com.byazt.seg.c v() {
        return this.f923if;
    }

    public void v(int i) {
        this.st = i;
    }

    @Override // com.byazt.eia.x
    public String v_() {
        return this.rh;
    }

    @Override // com.byazt.eia.x
    public String ve() {
        return this.sl;
    }

    public void ve(float f) {
        this.px = f;
    }

    public void ve(int i) {
        this.yg = i;
    }

    public void ve(long j) {
        this.is = j;
    }

    public void ve(String str) {
        this.pb = str;
    }

    public void ve(JSONObject jSONObject) {
        this.il = jSONObject;
    }

    public void ve(boolean z) {
        this.em = z;
    }

    public int vi() {
        return this.ma;
    }

    public r vl() {
        return this.fk;
    }

    public int vp() {
        return this.yf;
    }

    public int vr() {
        return this.hq;
    }

    public p vt() {
        return this.fr;
    }

    public int w() {
        return this.ir;
    }

    @Override // com.byazt.eia.da
    public String w_() {
        return this.h;
    }

    public boolean wj() {
        return this.nm;
    }

    public int wn() {
        return this.k;
    }

    public String wo() {
        return this.ra;
    }

    public lr wy() {
        return this.ck;
    }

    @Override // com.byazt.eia.da
    public String x() {
        return this.i;
    }

    public void x(int i) {
        this.br = i;
    }

    public void x(long j) {
        this.ic = j;
    }

    public void x(String str) {
        this.kz = str;
    }

    public void x(JSONObject jSONObject) {
        this.xw = jSONObject;
    }

    public void x(boolean z) {
        this.w = z;
    }

    public kp xd() {
        return this.q;
    }

    public long xg() {
        return this.lo;
    }

    public int xl() {
        return this.fv;
    }

    public lt xo() {
        return this.kk;
    }

    public int xr() {
        return this.cu;
    }

    public String xv() {
        return this.to;
    }

    public long xw() {
        return this.ic;
    }

    public int xx() {
        return this.iy;
    }

    public String y() {
        return this.jt;
    }

    public void y(int i) {
        this.jm = i;
    }

    public int yf() {
        return this.pe;
    }

    public JSONObject ym() {
        return this.g;
    }

    public oz yo() {
        return this.hs;
    }

    @Override // com.byazt.eia.i
    public nu yp() {
        return this.yv;
    }

    public void yp(int i) {
        this.nt = i;
    }

    public void yp(String str) {
        this.bw = str;
    }

    public void yp(boolean z) {
        this.yo = z;
    }

    public boolean ys() {
        return this.bx;
    }

    public Map<String, Object> yt() {
        return this.b;
    }

    public void yv(int i) {
        this.ir = i;
    }

    public void yv(String str) {
        this.gu = str;
    }

    public boolean yv() {
        return this.po == 3;
    }

    public JSONObject yx() {
        return this.vr;
    }

    @Override // com.byazt.eia.sl
    public n z() {
        return this.gr;
    }

    public void z(int i) {
        this.ny = i;
    }

    public void z(String str) {
        this.pa = str;
    }

    public void z(boolean z) {
        this.tx = z;
    }

    public int zb() {
        return this.fe;
    }

    public void zb(int i) {
        if (i != 1) {
            i = 0;
        }
        this.pr = i;
    }

    public void zb(String str) {
        this.nl = str;
    }

    public void zm(int i) {
        this.os = i;
    }

    public void zm(String str) {
        this.eo = str;
    }

    public h zo() {
        return this.ls;
    }

    public md zr() {
        return this.ey;
    }

    public void c(eo eoVar) {
        if (eoVar == null) {
            return;
        }
        if (this.cs == null) {
            this.cs = new ArrayList();
        }
        this.cs.add(eoVar);
    }

    public eo tt(String str) {
        List<eo> list = this.cs;
        if (list != null && !list.isEmpty()) {
            for (int i = 0; i < this.cs.size(); i++) {
                eo eoVar = this.cs.get(i);
                if (eoVar != null) {
                    String strC = eoVar.c();
                    if (!TextUtils.isEmpty(strC) && strC.equals(str)) {
                        return eoVar;
                    }
                }
            }
        }
        return null;
    }

    public synchronized String zm() {
        if (TextUtils.isEmpty(this.la)) {
            String strU = com.byazt.aas.nb.u(this);
            String strGu = gu();
            String strUj = uj();
            if (TextUtils.isEmpty(strU)) {
                strU = "0";
            }
            if (TextUtils.isEmpty(strUj)) {
                strUj = "0";
            }
            if (TextUtils.isEmpty(strGu)) {
                strGu = "0";
            }
            this.la = strU + "_" + strGu + "_" + strUj;
        }
        return this.la;
    }

    public boolean d() {
        return this.jy && pf();
    }

    public boolean or() {
        return zb() == 1;
    }

    public boolean pf() {
        return nb() == 1;
    }

    public boolean sv() {
        return bx() == 1;
    }

    public void c(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.qt = new rh();
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("sdk_template_info");
            if (jSONObjectOptJSONObject != null) {
                this.qt.c(jSONObjectOptJSONObject.optString("lottie_tmp_url"));
            }
            JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("aigc");
            if (jSONObjectOptJSONObject2 != null) {
                JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject2.optJSONArray("bg_anim_img_android");
                if (jSONArrayOptJSONArray != null) {
                    ArrayList arrayList = new ArrayList();
                    this.qt.c(arrayList);
                    for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                        JSONObject jSONObjectOptJSONObject3 = jSONArrayOptJSONArray.optJSONObject(i);
                        if (jSONObjectOptJSONObject3 != null) {
                            zb zbVar = new zb();
                            zbVar.c(jSONObjectOptJSONObject3.optInt("width"));
                            zbVar.tt(jSONObjectOptJSONObject3.optInt("height"));
                            zbVar.c(jSONObjectOptJSONObject3.optString("url"));
                            arrayList.add(zbVar);
                        }
                    }
                }
                JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject2.optJSONArray("bg_videos");
                if (jSONArrayOptJSONArray2 != null) {
                    ArrayList arrayList2 = new ArrayList();
                    this.qt.tt(arrayList2);
                    for (int i2 = 0; i2 < jSONArrayOptJSONArray2.length(); i2++) {
                        JSONObject jSONObjectOptJSONObject4 = jSONArrayOptJSONArray2.optJSONObject(i2);
                        if (jSONObjectOptJSONObject4 != null) {
                            com.byazt.jzl.uj ujVar = new com.byazt.jzl.uj();
                            ujVar.setFileHash(jSONObjectOptJSONObject4.optString("file_hash"));
                            ujVar.setResolution(jSONObjectOptJSONObject4.optString("resolution"));
                            ujVar.setVideo_duration(jSONObjectOptJSONObject4.optDouble("video_duration"));
                            ujVar.setVideo_url(jSONObjectOptJSONObject4.optString("video_url"));
                            arrayList2.add(ujVar);
                        }
                    }
                }
            }
        }
    }

    public static boolean c(ic icVar) {
        return icVar != null && icVar.g() == 1;
    }

    public static boolean tt(ic icVar) {
        return icVar != null && icVar.hj() == 1;
    }

    public static boolean ve(ic icVar) {
        if (icVar == null) {
            return false;
        }
        return icVar.id() == 5 || icVar.id() == 15 || icVar.id() == 166;
    }

    public static boolean uj(ic icVar) {
        try {
            return icVar.jm() != null && icVar.jm().optInt("parent_type") == 1;
        } catch (Exception unused) {
        }
    }

    public int tx() {
        if (my.uj(this)) {
            return 0;
        }
        return this.vl;
    }

    public int cf() {
        if (fr() != 100.0f || pu.c(this) == 2) {
            return 0;
        }
        return this.oz;
    }

    public void c(com.byazt.dj.tt ttVar) {
        if (ttVar != null) {
            this.r = ttVar;
        } else if (this.r != null) {
            this.r = new ve(this.r);
        }
    }

    public int pl() {
        s sVar = this.mm;
        if (sVar == null) {
            return 1;
        }
        return sVar.c();
    }

    public String di() {
        s sVar = this.mm;
        return sVar == null ? "" : sVar.tt();
    }

    public boolean jg() {
        s sVar = this.mm;
        return sVar == null || sVar.ve();
    }

    public int hg() {
        s sVar = this.mm;
        if (sVar == null) {
            return 50;
        }
        return sVar.uj();
    }

    public int sd() {
        s sVar = this.mm;
        if (sVar == null) {
            return 236;
        }
        return sVar.n();
    }

    public int k() {
        s sVar = this.mm;
        if (sVar == null) {
            return 82;
        }
        return sVar.a();
    }

    public int iy() {
        s sVar = this.mm;
        if (sVar == null) {
            return 56;
        }
        return sVar.sp();
    }

    public int nc() {
        s sVar = this.mm;
        if (sVar == null) {
            return 0;
        }
        return sVar.i();
    }

    public String ca() {
        s sVar = this.mm;
        return sVar == null ? "#008DEA" : sVar.da();
    }

    public String cl() {
        s sVar = this.mm;
        return sVar == null ? "点击查看" : sVar.sl();
    }

    public int gk() {
        s sVar = this.mm;
        if (sVar == null) {
            return 0;
        }
        return sVar.x();
    }

    public s.tt nx() {
        s sVar = this.mm;
        if (sVar != null) {
            return sVar.t();
        }
        return null;
    }

    public s.tt iw() {
        s sVar = this.mm;
        if (sVar != null) {
            return sVar.u();
        }
        return null;
    }

    public s.c bj() {
        s sVar = this.mm;
        if (sVar != null) {
            return sVar.yp();
        }
        return null;
    }

    private float hm() {
        s sVar = this.mm;
        if (sVar == null) {
            return 5.0f;
        }
        return sVar.z();
    }

    public int bp() {
        iu iuVar = this.nx;
        if (iuVar == null) {
            return 2;
        }
        return iuVar.c();
    }

    public int ph() {
        iu iuVar = this.nx;
        if (iuVar == null) {
            return 16;
        }
        return iuVar.tt();
    }

    public int dr() {
        iu iuVar = this.nx;
        if (iuVar == null) {
            return 30;
        }
        return iuVar.ve();
    }

    public int ly() {
        r rVar = this.fk;
        if (rVar == null) {
            return 0;
        }
        return rVar.c();
    }

    public int px() {
        r rVar = this.fk;
        if (rVar == null) {
            return 90;
        }
        return rVar.tt();
    }

    public int fk() {
        r rVar = this.fk;
        if (rVar == null) {
            return 90;
        }
        return rVar.ve();
    }

    public int ab() {
        int i = this.lr;
        if (i != -1) {
            return i;
        }
        if (com.byazt.aas.nb.sl(this) == 7) {
            return 0;
        }
        return (com.byazt.aas.nb.sl(this) == 8 && fr() == 100.0f) ? 0 : 1;
    }

    public int lz() {
        if (ix() != null) {
            return ix().tt();
        }
        return -1;
    }

    public boolean hs() {
        boolean z = ix() != null && ix().c();
        if (z && ne() == 4) {
            return lz() >= 0;
        }
        return z;
    }

    @Override // com.byazt.eia.x
    public String tt() {
        return te() != null ? te().c() : "";
    }

    public void tt(zb zbVar) {
        this.yp.add(zbVar);
    }

    public void aw(int i) {
        this.gy = Math.max(0, i);
    }

    @Override // com.byazt.eia.i
    public JSONObject q_() {
        if (this.d == null) {
            try {
                if (!TextUtils.isEmpty(this.h)) {
                    this.d = new JSONObject(this.h);
                }
            } catch (JSONException unused) {
            }
        }
        return this.d;
    }

    public String sy() {
        try {
            return q_().optString("convert_id", null);
        } catch (Throwable unused) {
            return null;
        }
    }

    public boolean rp() {
        return (TextUtils.isEmpty(com.byazt.aas.nb.u(this)) || TextUtils.isEmpty(this.to) || com.byazt.aas.nb.u(this).contains(this.to)) ? false : true;
    }

    public int sl(boolean z) {
        if (this.sv || z) {
            return vz();
        }
        return 102;
    }

    @Override // com.byazt.eia.sp
    public boolean x_() {
        return jf() == 1;
    }

    @Override // com.byazt.eia.sl
    public boolean nu() {
        return vr() == 1;
    }

    public com.byazt.vo.tt wq() {
        com.byazt.tl.tt.c();
        return this.uj;
    }

    public boolean nq() {
        return ku() != 1;
    }

    public void sl(long j) {
        if (j != 0) {
            this.ru = j;
        } else {
            this.ru = System.currentTimeMillis() / 1000;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            ic icVar = (ic) obj;
            if (this.qy.equals(icVar.qy) && this.h.equals(icVar.h)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (this.qy.hashCode() * 31) + this.h.hashCode();
    }

    public boolean qt() {
        if (com.byazt.ex.c.c(this)) {
            return true;
        }
        if (this.yp.isEmpty()) {
            return false;
        }
        if (this.p == 4 && this.yp.size() < 3) {
            return false;
        }
        Iterator<zb> it = this.yp.iterator();
        while (it.hasNext()) {
            if (!it.next().n()) {
                return false;
            }
        }
        return true;
    }

    public boolean fe() {
        if (wq() != null) {
            return wq().a();
        }
        return false;
    }

    public boolean ox() {
        int iNu = com.byazt.aas.nb.nu(this);
        return iNu == 3 || iNu == 6;
    }

    public String dn() {
        if (!TextUtils.isEmpty(this.hg)) {
            this.hg = this.hg.trim();
        }
        return this.hg;
    }

    public void c(zm zmVar) {
        this.xv = zmVar;
        if (zmVar != null) {
            String strTt = zmVar.tt();
            String strVe = this.xv.ve();
            if (TextUtils.isEmpty(strTt)) {
                return;
            }
            com.byazt.xs.da.c(strTt, strVe, (com.byazt.xs.ve) null);
        }
    }

    public int ka() {
        return my.da(this);
    }

    public int mc() {
        JSONObject jSONObject = this.t;
        if (jSONObject != null) {
            return jSONObject.optInt("easy_playable_skip_duration", 0);
        }
        return 0;
    }

    @Override // com.byazt.eia.i
    public boolean y_() {
        return jc() != null;
    }

    @Override // com.byazt.eia.sl
    public boolean z_() {
        to toVar = this.cl;
        return toVar != null && toVar.c();
    }

    @Override // com.byazt.eia.sl
    public int a() {
        if (u_() != null) {
            return u_().uj();
        }
        return -1;
    }

    public String jl() {
        return TextUtils.isEmpty(this.ve) ? com.byazt.vxy.c.ve() : this.ve;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public JSONObject yg() {
        String str;
        String str2;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("s_sig_ts", ck());
            jSONObject.put("ad_rec_stamp", ey());
            jSONObject.put("interaction_type", i());
            jSONObject.put("target_url", x());
            jSONObject.put("use_sdk_player", hj());
            jSONObject.put("use_media_video_player", g());
            jSONObject.put("landing_scroll_percentage", ri());
            jSONObject.put("gecko_id", ve());
            jSONObject.put("extension", ts());
            jSONObject.put("overlay", ft());
            jSONObject.put("ad_id", uj());
            jSONObject.put(ba.at, an());
            jSONObject.put("package_name", ls());
            jSONObject.put("screenshot", ys());
            jSONObject.put("play_bar_style", cf());
            jSONObject.put("play_bar_show_time", jt());
            jSONObject.put("if_block_lp", ny());
            jSONObject.put("cache_sort", w());
            jSONObject.put("if_sp_cache", nl());
            jSONObject.put("splash_timeout_stage", ej());
            jSONObject.put("is_cache", up());
            jSONObject.put("cache_type", vz());
            com.byazt.dbo.ve.c(this, jSONObject, true);
            jSONObject.putOpt("applist_info", ur());
            jSONObject.put("meta_hashcode", eo());
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("cta", f());
            jSONObject2.put("other", yf());
            jSONObject.put("set_click_type", jSONObject2);
            zb zbVarTe = te();
            if (zbVarTe != null && !TextUtils.isEmpty(zbVarTe.c())) {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("url", zbVarTe.c());
                jSONObject3.put("height", zbVarTe.ve());
                jSONObject3.put("width", zbVarTe.tt());
                jSONObject.put(com.huawei.openalliance.ad.constant.x.cL, jSONObject3);
            }
            Object objJm = jm();
            if (objJm != null) {
                jSONObject.put("session_params", objJm);
            }
            Object objYm = ym();
            if (objYm != null) {
                jSONObject.put("cache_control", objYm);
            }
            com.byazt.dj.tt ttVarIj = ij();
            if (ttVarIj != null) {
                jSONObject.put("adslot", com.byazt.aas.md.c(ttVarIj));
            }
            List<zb> listPa = pa();
            if (listPa != null) {
                JSONArray jSONArray = new JSONArray();
                for (zb zbVar : listPa) {
                    JSONObject jSONObject4 = new JSONObject();
                    jSONObject4.put("url", zbVar.c());
                    jSONObject4.put("height", zbVar.ve());
                    jSONObject4.put("width", zbVar.tt());
                    jSONObject4.put("image_preview", zbVar.a());
                    jSONObject4.put("image_key", zbVar.sp());
                    jSONArray.put(jSONObject4);
                }
                jSONObject.put("image", jSONArray);
            }
            List<String> listPr = pr();
            if (listPr != null) {
                JSONArray jSONArray2 = new JSONArray();
                Iterator<String> it = listPr.iterator();
                while (it.hasNext()) {
                    jSONArray2.put(it.next());
                }
                jSONObject.put("show_url", jSONArray2);
            }
            List<String> listGl = gl();
            if (listGl != null) {
                JSONArray jSONArray3 = new JSONArray();
                Iterator<String> it2 = listGl.iterator();
                while (it2.hasNext()) {
                    jSONArray3.put(it2.next());
                }
                jSONObject.put("click_url", jSONArray3);
            }
            jSONObject.put("phone_num", tp());
            jSONObject.put("title", v_());
            jSONObject.put("download_num", ru());
            jSONObject.put(ld.L, op());
            jSONObject.put(o0OO000o.o00O0O0O, w_());
            jSONObject.put("req_id", qy());
            jSONObject.put("image_mode", id());
            jSONObject.put("intercept_flag", az());
            jSONObject.put("web_inspector", is());
            jSONObject.put("button_text", tj());
            jSONObject.put("ad_logo", mq());
            jSONObject.put("video_adaptation", vi());
            jSONObject.put("feed_video_opentype", vp());
            jSONObject.put("feed_reward_type", kz());
            jSONObject.put("orientation", by());
            jSONObject.put("aspect_ratio", fr());
            jSONObject.put("aspect_margin", qe());
            jSONObject.put("corner_radius", jy());
            n nVarZ = z();
            if (nVarZ != null) {
                JSONObject jSONObject5 = new JSONObject();
                jSONObject5.put("app_name", nVarZ.ve());
                jSONObject5.put("package_name", nVarZ.uj());
                jSONObject5.put("download_url", nVarZ.tt());
                jSONObject5.put("score", nVarZ.n());
                str = "height";
                try {
                    jSONObject5.put("comment_num", nVarZ.a());
                    jSONObject5.put("quick_app_url", nVarZ.c());
                    jSONObject5.put("app_size", nVarZ.sp());
                    jSONObject.put("app", jSONObject5);
                } catch (Exception unused) {
                }
            } else {
                str = "height";
            }
            rl rlVarNm = nm();
            if (rlVarNm != null) {
                jSONObject.put("download_sdk_conf", rlVarNm.ve());
            }
            if (xd() != null) {
                xd().tt(jSONObject);
            }
            if (xo() != null) {
                xo().c(jSONObject);
            }
            if (yp() != null) {
                yp().c(jSONObject);
            }
            if (wq() != null) {
                wq().c(jSONObject);
            }
            if (gy() != null) {
                gy().tt(jSONObject);
            }
            if (gx() != null) {
                gx().c(jSONObject);
            }
            if (pn() != null) {
                pn().c(jSONObject);
            }
            if (ef() != null) {
                ef().c(jSONObject);
            }
            if (yo() != null) {
                yo().c(jSONObject);
            }
            if (fb() != null) {
                fb().c(jSONObject);
            }
            if (jc() != null) {
                jc().c(jSONObject);
            }
            if (hq() != null) {
                hq().tt(jSONObject);
            }
            jSONObject.put("count_down", xr());
            jSONObject.put("expiration_time", uv());
            jSONObject.put("client_expiration_time", uv());
            jSONObject.put("_child_metas", hl());
            jSONObject.put("_meta_life_record", bn().c());
            jSONObject.put("src_req_id", xv());
            jSONObject.put("player_type", xx());
            jSONObject.put("video_encode_type", hc());
            jSONObject.put("feed_video_finish_type", ir());
            jSONObject.put("video_voice_control", ab());
            jSONObject.put("if_show_win", oq());
            if (o() != null) {
                o().c(jSONObject);
            }
            if (u_() != null) {
                u_().c(jSONObject);
            }
            jSONObject.put("if_both_open", jf());
            jSONObject.put("if_double_deeplink", vr());
            JSONObject jSONObject6 = new JSONObject();
            jSONObject6.put("splash_clickarea", pl());
            jSONObject6.put("splash_clicktext", di());
            jSONObject6.put("area_height", hg());
            jSONObject6.put("area_width", sd());
            jSONObject6.put("area_blank_height", k());
            jSONObject6.put("half_blank_height", iy());
            jSONObject6.put("splash_style_id", nc());
            jSONObject6.put("btn_background_dest_color", ca());
            jSONObject6.put("top_splash_clicktext", cl());
            jSONObject6.put("splash_load_time_optimization", gk());
            jSONObject6.put("text_config", nx() != null ? nx().c() : null);
            jSONObject6.put("top_text_config", iw() != null ? iw().c() : null);
            jSONObject6.put("sliding_distance", hm());
            jSONObject6.put("slide_area", bj() != null ? bj().n() : null);
            jSONObject.put("splash_control", jSONObject6);
            JSONObject jSONObject7 = new JSONObject();
            jSONObject7.put("position", bp());
            jSONObject7.put("left_or_right_margin", ph());
            jSONObject7.put("top_or_bottom_margin", dr());
            iu iuVar = this.nx;
            jSONObject7.put("skip_style", iuVar == null ? 1 : iuVar.uj());
            iu iuVar2 = this.nx;
            jSONObject7.put("hide_native_skip_logo", iuVar2 == null ? 0 : iuVar2.n());
            jSONObject.put("skip_control", jSONObject7);
            JSONObject jSONObject8 = new JSONObject();
            jSONObject8.put("show_type", ly());
            jSONObject8.put("blank", px());
            jSONObject8.put("half_blank", fk());
            jSONObject.put("splash_compliance_bar", jSONObject8);
            jSONObject.put("fix_click_sequence", h());
            if (yt() != null) {
                JSONObject jSONObject9 = new JSONObject();
                Set<Map.Entry<String, Object>> setEntrySet = yt().entrySet();
                if (setEntrySet != null && !setEntrySet.isEmpty()) {
                    for (Map.Entry<String, Object> entry : setEntrySet) {
                        jSONObject9.put(entry.getKey(), entry.getValue());
                    }
                }
                jSONObject.put("media_ext", jSONObject9);
            }
            jSONObject.put("isDirectDownload", hd());
            jSONObject.put("page_render_type", tx());
            jSONObject.put("promotion_type", ma());
            jSONObject.put("if_lpua_package", this.jm);
            jSONObject.put("click_freq", this.fb);
            com.byazt.seg.c cVarV = v();
            if (cVarV != null) {
                JSONObject jSONObject10 = new JSONObject();
                jSONObject10.put("id", cVarV.c());
                jSONObject10.put("md5", cVarV.tt());
                jSONObject10.put("url", cVarV.ve());
                jSONObject10.put(com.hihonor.adsdk.base.g.j.e.a.InterfaceC0437a.hnadsd, cVarV.uj());
                jSONObject.put("ugeno", jSONObject10);
            }
            com.byazt.lo.c cVarOs = os();
            if (cVarOs != null) {
                JSONObject jSONObject11 = new JSONObject();
                jSONObject11.put("product_infos", cVarOs.c());
                jSONObject11.put("coupon", cVarOs.tt());
                jSONObject11.put("render_config", cVarOs.ve());
                jSONObject11.put("live_room_data", cVarOs.uj());
                jSONObject11.putOpt("ec_mall_conf", cVarOs.n());
                jSONObject.put("dylite_info", jSONObject11);
            }
            jSONObject.put("native_lp_data", lo());
            jSONObject.put("native_lp_tpl_id", pu());
            jSONObject.put("native_lp_ugen_url", lt());
            jSONObject.put("native_lp_ugen_md5", to());
            jSONObject.put("download_url", l());
            jSONObject.put("native_lp_is_preload", tk());
            if (tk()) {
                jSONObject.put("native_lp_content", kp());
            }
            jSONObject.put("market_url", gr());
            jSONObject.put("close_on_dislike", lx());
            a aVarRh = rh();
            if (aVarRh != null) {
                JSONObject jSONObject12 = new JSONObject();
                jSONObject12.put("developer_name", aVarRh.sp());
                jSONObject12.put("app_version", aVarRh.n());
                jSONObject12.put("permissions", aVarRh.t());
                jSONObject12.put("privacy_policy_url", aVarRh.x());
                jSONObject12.put("package_name", aVarRh.u());
                jSONObject12.put("app_name", aVarRh.yp());
                jSONObject12.put("score", aVarRh.ve());
                jSONObject12.put("creative_tags", aVarRh.uj());
                jSONObject12.put("permissions_url", aVarRh.tt());
                jSONObject12.put("desc_url", aVarRh.i());
                jSONObject12.put("reg_number", aVarRh.da());
                jSONObject12.put("reg_url", aVarRh.sl());
                jSONObject.put("app_manage", jSONObject12);
            }
            zm zmVarPo = po();
            if (zmVarPo != null) {
                JSONObject jSONObject13 = new JSONObject();
                jSONObject13.put("ugen_dialog_url", zmVarPo.tt());
                jSONObject13.put("ugen_dialog_md5", zmVarPo.ve());
                jSONObject13.put("dialog_style", zmVarPo.c());
                jSONObject.put("easy_dl_dialog", jSONObject13);
            }
            if (la() != null) {
                jSONObject.put("easy_pl_material", la());
            }
            jSONObject.put("micro_app_type", p());
            jSONObject.put("app_manage_type", st());
            int i = 1;
            if (en() != 1) {
                i = 0;
            }
            jSONObject.put("lp_down_rule", i);
            jSONObject.put("auction_price", em());
            jSONObject.put(OapsKey.KEY_PRICE, j());
            jSONObject.put("ad_info", mk());
            jSONObject.put("adx_name", dn());
            jSONObject.put("no_default_ttdsp_price", ku());
            jSONObject.put("endcard_close_time", hz());
            jSONObject.put("proportion_watching", cs());
            jSONObject.put("video_skip_result", wn());
            jSONObject.put("shake_value", ge());
            jSONObject.put("deep_shake_value", tw());
            jSONObject.put("rotation_angle", br());
            jSONObject.put("calculation_method", e());
            jSONObject.put("calculation_method_twist", pe());
            jSONObject.put("show_poll_time", m760if());
            jSONObject.put("dynamic_join_type", il());
            jSONObject.put("dynamic_join_duration", pb());
            jSONObject.put("is_web_meta", s_());
            jSONObject.put("union_session_key", rl());
            jSONObject.put("cache_ext", q());
            jSONObject.put("cache_time", b());
            jSONObject.put("req_id", oz());
            jSONObject.put("is_cache", r());
            jSONObject.put("log_ext", s());
            jSONObject.put("material_key", y());
            jSONObject.put("need_get_materials", iu());
            jSONObject.put("s_send_ts", dz());
            jSONObject.put("parse_material_ts", kk());
            hq hqVar = this.c;
            if (hqVar != null) {
                jSONObject.put("wc_miniapp_info", hqVar.i());
            }
            Object obj = this.ve;
            if (obj != null) {
                jSONObject.put("app_id", obj);
            }
            sl slVarMn = mn();
            if (slVarMn != null) {
                JSONObject jSONObject14 = new JSONObject();
                jSONObject14.put("click_trigger_type", slVarMn.c());
                jSONObject14.put("shake_start_time", slVarMn.tt());
                jSONObject14.put("shake_end_time", slVarMn.ve());
                jSONObject.put("click_trigger_config", jSONObject14);
            }
            jSONObject.put("web_monitor_rate", md());
            if (ix() != null) {
                ix().c(jSONObject);
            }
        } catch (Exception unused2) {
            str = "height";
        }
        if (js() != null) {
            js().c(jSONObject);
        }
        try {
            jSONObject.put("is_ec_mall", bz() ? 1 : 0);
            jSONObject.put("live_room_id", da());
            jSONObject.put("ad_type", xl());
            jSONObject.put("live_interaction_type", n());
            jSONObject.put("ec_schema", t_());
        } catch (JSONException e) {
            com.byazt.nr.m.c(e);
        }
        try {
            jSONObject.put("ecom_live_params", t());
        } catch (JSONException e2) {
            com.byazt.nr.m.c(e2);
        }
        cu cuVarDp = dp();
        if (cuVarDp != null) {
            cuVarDp.c(jSONObject);
        }
        qy qyVarU = u();
        if (qyVarU != null) {
            qyVarU.c(jSONObject);
        }
        pf pfVarGt = gt();
        if (pfVarGt != null) {
            try {
                JSONObject jSONObject15 = new JSONObject();
                jSONObject15.put("reward_live_deep_link_user_id", pfVarGt.c());
                jSONObject15.put("reward_live_deep_link_request_id", pfVarGt.a());
                jSONObject15.put("reward_live_deep_link_room_id", pfVarGt.tt());
                jSONObject15.put("reward_live_last_time", pfVarGt.n());
                jSONObject15.put("reawrd_live_short_touch_params", pfVarGt.ve());
                jSONObject15.put("reawrd_live_extra_pangle_scheme_params", pfVarGt.uj());
                jSONObject.put("reward_live_deep_link_params", jSONObject15);
            } catch (Exception unused3) {
            }
        }
        z zVarQi = qi();
        if (zVarQi != null) {
            try {
                JSONObject jSONObject16 = new JSONObject();
                jSONObject16.put("style_type", zVarQi.c());
                jSONObject16.put("image_url", zVarQi.tt());
                jSONObject16.put("position", zVarQi.ve());
                jSONObject16.put("image_height", zVarQi.uj());
                jSONObject16.put("image_scale_rate", zVarQi.a());
                jSONObject16.put("image_gif_url", zVarQi.n());
                jSONObject16.put("image_gif_aspect_ratio", zVarQi.sp());
                jSONObject.put("dynamic_join_coupon_style", jSONObject16);
            } catch (Exception unused4) {
            }
        }
        yp ypVarMy = my();
        if (ypVarMy != null) {
            try {
                jSONObject.put("coupon", ypVarMy.c());
            } catch (JSONException e3) {
                com.byazt.nr.m.c(e3);
            }
        }
        sv svVarSl = sl();
        if (svVarSl != null) {
            try {
                jSONObject.put("live_info", svVarSl.c());
            } catch (JSONException unused5) {
            }
        }
        q qVarC_ = C_();
        if (qVarC_ != null) {
            try {
                jSONObject.put("saas_info", qVarC_.c());
            } catch (JSONException unused6) {
            }
        }
        kk kkVarD_ = D_();
        if (kkVarD_ != null) {
            try {
                jSONObject.put("saas_on_click_material", kkVarD_.c());
            } catch (JSONException unused7) {
            }
        }
        try {
            jSONObject.put("live_sdk_status_while_first_click", this.qe);
        } catch (JSONException unused8) {
        }
        Object objCx = cx();
        if (objCx != null) {
            try {
                jSONObject.put(com.umeng.analytics.pro.d.K, objCx);
            } catch (Exception unused9) {
            }
        }
        j jVarEk = ek();
        if (jVarEk != null) {
            try {
                JSONObject jSONObject17 = new JSONObject();
                jSONObject17.put("video_adapter_type", jVarEk.c());
                jSONObject17.put("video_mute_type", jVarEk.tt());
                jSONObject.put("video_config", jSONObject17);
            } catch (Exception unused10) {
            }
        }
        try {
            jSONObject.put("not_valid_download_url", B_());
        } catch (JSONException e4) {
            com.byazt.nr.m.c(e4);
        }
        try {
            jSONObject.put("dynamic_configs", m());
            String strWo = wo();
            if (!TextUtils.isEmpty(strWo)) {
                jSONObject.put("gnd_prefetch_cache_key", strWo);
                jSONObject.put("gnd_prefetch_timing", cj());
            }
        } catch (JSONException e5) {
            com.byazt.nr.m.c(e5);
        }
        try {
            jSONObject.put("twist_config", lv());
            jSONObject.put("shake_interact_conf", cy());
            jSONObject.put("twist_interact_conf", yx());
        } catch (JSONException e6) {
            com.byazt.nr.m.c(e6);
        }
        try {
            h hVar = this.ls;
            if (hVar != null) {
                hVar.tt(jSONObject);
            }
        } catch (Throwable unused11) {
        }
        try {
            or orVar = this.wq;
            if (orVar != null) {
                orVar.tt(jSONObject);
            }
        } catch (Throwable unused12) {
        }
        rh rhVarIc = ic();
        if (rhVarIc != null) {
            try {
                JSONObject jSONObject18 = new JSONObject();
                jSONObject18.put("lottie_tmp_url", rhVarIc.ve());
                JSONArray jSONArray4 = new JSONArray();
                List<zb> listC = rhVarIc.c();
                if (listC != null) {
                    for (zb zbVar2 : listC) {
                        if (zbVar2 != null) {
                            JSONObject jSONObject19 = new JSONObject();
                            jSONObject19.put("width", zbVar2.tt());
                            str2 = str;
                            jSONObject19.put(str2, zbVar2.ve());
                            jSONObject19.put("url", zbVar2.c());
                            jSONArray4.put(jSONObject19);
                        } else {
                            str2 = str;
                        }
                        str = str2;
                    }
                }
                JSONArray jSONArray5 = new JSONArray();
                List<com.byazt.jzl.uj> listTt = rhVarIc.tt();
                if (listTt != null) {
                    for (com.byazt.jzl.uj ujVar : listTt) {
                        if (ujVar != null) {
                            JSONObject jSONObject20 = new JSONObject();
                            jSONObject20.put("file_hash", ujVar.getFileHash());
                            jSONObject20.put("resolution", ujVar.getResolution());
                            jSONObject20.put("video_duration", ujVar.getVideo_duration());
                            jSONObject20.put("video_url", ujVar.getVideo_url());
                            jSONArray5.put(jSONObject20);
                        }
                    }
                }
                JSONObject jSONObject21 = new JSONObject();
                jSONObject21.put("bg_anim_img_android", jSONArray4);
                jSONObject21.put("bg_videos", jSONArray5);
                JSONObject jSONObject22 = new JSONObject();
                jSONObject22.put("sdk_template_info", jSONObject18);
                jSONObject22.put("aigc", jSONObject21);
                jSONObject.put("sdk_derive_info", jSONObject22);
            } catch (JSONException unused13) {
            }
        }
        try {
            jSONObject.put("disable_video_join", zb());
            jSONObject.put("disable_top_bar", nb());
            jSONObject.put("disable_rtn_button", bx());
            jSONObject.put("disable_safe_area", d());
            jSONObject.put("disable_slide_return", cu());
        } catch (Throwable unused14) {
        }
        try {
            jSONObject.put("_ad_index", fq());
        } catch (JSONException unused15) {
        }
        try {
            jSONObject.put("is_height_resize", rm());
        } catch (JSONException unused16) {
        }
        return jSONObject;
    }

    public void kk(int i) {
        int i2 = 500;
        if (i == Integer.MIN_VALUE) {
            i = com.byazt.aas.nb.sl(this) == 3 ? 500 : 1000;
        }
        if (i >= 500) {
            i2 = 3000;
            if (i <= 3000) {
                i2 = i;
            }
        }
        this.cx = i2;
    }

    public int tw() {
        if (this.n == 4 && TextUtils.isEmpty(this.j)) {
            return this.bp;
        }
        return 0;
    }

    public void c(com.byazt.jzl.uj ujVar) {
        if (this.nb == null) {
            this.nb = new xd();
        }
        this.nb.c(ujVar);
    }

    public static boolean n(ic icVar) {
        return icVar != null && icVar.jm == 1;
    }

    public static boolean a(ic icVar) {
        if (icVar == null || icVar.mk <= 0 || icVar.fb <= 0) {
            return false;
        }
        boolean z = System.currentTimeMillis() - icVar.mk < ((long) icVar.fb);
        if (z) {
            icVar.by++;
            com.byazt.ukr.yp.c().tt(new com.byazt.ee.c() { // from class: com.byazt.ete.ic.1
                @Override // com.byazt.ee.c
                public com.byazt.qal.c c() throws Exception {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(com.hihonor.adsdk.base.g.j.e.a.Q0, ic.this.by);
                    jSONObject.put("click_freq", ic.this.fb);
                    return com.byazt.qal.tt.tt().c("click_intercept").x(ic.this.w_()).tt(jSONObject.toString());
                }
            }, "click_intercept");
        }
        return z;
    }

    public static void sp(ic icVar) {
        if (icVar == null) {
            return;
        }
        icVar.mk = System.currentTimeMillis();
    }

    public String lw() {
        return hashCode() + qy() + kk();
    }

    @Override // com.byazt.eia.i
    public String rl() {
        JSONObject jSONObject = this.f;
        String strOptString = jSONObject != null ? jSONObject.optString("session_id") : "";
        return TextUtils.isEmpty(strOptString) ? lw() : strOptString;
    }

    public hd bn() {
        if (this.ef == null) {
            this.ef = new hd(this);
        }
        return this.ef;
    }

    public void t(JSONObject jSONObject) {
        this.ef = new hd(this, jSONObject);
    }
}
