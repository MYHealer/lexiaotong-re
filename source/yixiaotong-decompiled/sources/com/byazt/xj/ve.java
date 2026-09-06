package com.byazt.xj;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import com.byazt.cd.x;
import com.byazt.dq.a;
import com.byazt.dq.n;
import com.byazt.pm.i;
import com.byazt.pm.yp;
import com.byazt.sa.uj;
import com.byazt.sz.da;
import com.byazt.sz.gt;
import com.byazt.sz.m;
import com.byazt.sz.nu;
import com.byazt.sz.qy;
import com.byazt.sz.rh;
import com.byazt.sz.sp;
import com.byazt.sz.u;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.io.encoding.Base64;
import okio.Utf8;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 1471, 54})
public abstract class ve<T extends View> implements View.OnTouchListener, uj, rh.c, rh.tt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c<ViewGroup> f2863a;
    public boolean aw;
    public boolean az;
    public int b;
    public boolean bj;
    public float bm;
    public JSONObject bp;
    public ImageView.ScaleType bx;
    public boolean c;
    public boolean ca;
    public boolean cf;
    public boolean cl;
    public boolean cu;
    public long cx;
    public float d;
    public boolean da;

    @Deprecated
    public a di;
    public boolean dr;
    public float dz;
    public boolean e;
    public com.byazt.hn.ve ej;
    public boolean eo;
    public float f;
    public boolean fk;
    public yp fv;
    public float g;
    public qy gk;
    public boolean gr;
    public float gt;
    public boolean gu;
    public Map<Integer, m> gx;
    public boolean gy;
    public float h;
    public float hd;

    @Deprecated
    public com.byazt.dq.ve hg;
    public float hj;
    public rh hq;
    public com.byazt.sz.yp i;
    public boolean ic;
    public boolean ij;
    public float ir;
    public boolean is;
    public float iu;
    public boolean iw;
    public u iy;
    public float j;

    @Deprecated
    public com.byazt.dq.tt jg;
    public GradientDrawable jt;

    @Deprecated
    public com.byazt.dq.uj.c k;
    public int kk;
    public float kp;
    public boolean kz;
    public float l;
    public float lo;
    public float lr;
    public boolean lt;
    public com.byazt.vt.c ly;
    public float m;
    public float ma;
    public float md;
    public float mf;
    public com.byazt.cd.c.C0123c mm;
    public boolean mq;
    public float my;
    public T n;
    public int nb;
    public String nc;
    public com.byazt.xd.c nl;
    public sp nt;
    public float nu;
    public boolean nx;
    public gt ny;
    public boolean or;
    public ViewGroup.LayoutParams os;
    public com.byazt.rb.c oz;
    public float p;
    public boolean pe;
    public String pf;
    public boolean ph;
    public com.byazt.sz.c pl;
    public i pn;
    public boolean pu;
    public boolean px;
    public String q;
    public boolean qp;
    public boolean qy;
    public com.byazt.rb.a r;
    public float rh;
    public float rl;
    public float s;

    @Deprecated
    public n sd;
    public String sl;
    public c<ViewGroup> sp;
    public com.byazt.pm.u st;
    public float sv;
    public String t;
    public boolean tk;
    public boolean to;
    public Context tt;
    public float tx;
    public float u;
    public JSONObject uj;
    public boolean v;
    public JSONObject ve;
    public boolean vi;
    public boolean vp;
    public String w;
    public com.byazt.sz.i.c x;
    public da xd;
    public float y;
    public float yf;
    public boolean yo;
    public float yp;
    public float yv;
    public float z;
    public boolean zb;
    public boolean zm;

    private float[] oz() {
        float f = this.pu ? this.bm : this.hd;
        float f2 = this.lt ? this.l : this.hd;
        float f3 = this.to ? this.lr : this.hd;
        float f4 = this.tk ? this.lo : this.hd;
        return new float[]{f, f, f2, f2, f4, f4, f3, f3};
    }

    public void aw() {
    }

    public com.byazt.vt.c bx() {
        return this.ly;
    }

    public T c() {
        return null;
    }

    @Override // com.byazt.sa.uj
    public void c(int i, int i2, int i3, int i4) {
        if (this.gk == null || this.iw) {
            return;
        }
        this.iw = true;
    }

    public void c(da daVar) {
        this.xd = daVar;
    }

    public void c(gt gtVar) {
        this.ny = gtVar;
    }

    public void c(com.byazt.sz.i.c cVar) {
        this.x = cVar;
    }

    public void c(qy qyVar) {
        this.gk = qyVar;
    }

    public void c(rh rhVar) {
        this.hq = rhVar;
    }

    public void c(sp spVar) {
        this.nt = spVar;
    }

    public void c(com.byazt.sz.yp ypVar) {
        this.i = ypVar;
    }

    public void c(com.byazt.vt.c cVar) {
        this.ly = cVar;
    }

    public void c(c cVar) {
        this.f2863a = cVar;
    }

    public void c(String str, Map<String, Object> map) {
    }

    public int cu() {
        return (int) this.yp;
    }

    public c d() {
        return this.f2863a;
    }

    public JSONObject da() {
        return this.uj;
    }

    public String eo() {
        return this.sl;
    }

    public JSONObject gr() {
        return this.ve;
    }

    public float gt() {
        return this.hj;
    }

    public long gu() {
        return this.cx;
    }

    public boolean h() {
        return this.da;
    }

    public boolean hd() {
        return this.tx > 0.0f;
    }

    public T i() {
        return this.n;
    }

    public i kp() {
        return this.pn;
    }

    public boolean lt() {
        return this.px;
    }

    public float m() {
        return this.ma;
    }

    public com.byazt.sz.i.c md() {
        return this.x;
    }

    public float my() {
        return this.g;
    }

    public boolean nb() {
        return this.v;
    }

    public float nu() {
        return this.f;
    }

    public int or() {
        return (int) this.u;
    }

    public ViewGroup.LayoutParams p() {
        return this.os;
    }

    public int pf() {
        return this.nb;
    }

    public boolean pu() {
        return this.is;
    }

    public com.byazt.sz.yp qp() {
        return this.i;
    }

    public rh qy() {
        return this.hq;
    }

    public float rh() {
        return this.ir;
    }

    public float rl() {
        return this.hd;
    }

    public void sp(String str) {
        this.sl = str;
    }

    public void sv() {
    }

    public com.byazt.pm.u tk() {
        return this.st;
    }

    public yp to() {
        return this.fv;
    }

    public void tt(boolean z) {
        this.ca = z;
    }

    public float u() {
        return this.y;
    }

    @Override // com.byazt.sa.uj
    public void uj() {
        if (this.gk == null || this.nx) {
            return;
        }
        this.nx = true;
    }

    @Override // com.byazt.sa.uj
    public void ve() {
        if (this.gk == null || this.e) {
            return;
        }
        this.e = true;
    }

    public void ve(JSONObject jSONObject) {
        this.ve = jSONObject;
    }

    public void ve(boolean z) {
        this.da = z;
    }

    public void x(String str) {
        this.t = str;
    }

    public float yp() {
        return this.iu;
    }

    public float z() {
        return this.dz;
    }

    public String zb() {
        return this.t;
    }

    public ve(Context context) {
        this(context, null);
    }

    public ve(Context context, c<ViewGroup> cVar) {
        this.u = -2.0f;
        this.yp = -2.0f;
        this.q = "solid";
        this.kk = 0;
        this.v = true;
        this.s = 0.0f;
        this.y = 0.0f;
        this.iu = 0.0f;
        this.j = 1.0f;
        this.dz = 1.0f;
        this.ma = 1.0f;
        this.yf = 0.0f;
        this.f = 0.0f;
        this.ir = 0.0f;
        this.g = 0.0f;
        this.hj = 1.0f;
        this.az = true;
        this.bj = true;
        this.ph = false;
        this.dr = false;
        this.px = false;
        this.fk = false;
        this.mf = 12.0f;
        this.tt = context;
        this.f2863a = cVar;
        this.gx = new HashMap();
        this.jt = new GradientDrawable();
        this.n = (T) c();
    }

    public void tt(JSONObject jSONObject) {
        this.uj = jSONObject;
        sl();
    }

    public void c(JSONObject jSONObject) {
        this.uj = jSONObject;
        sl();
        JSONObject jSONObject2 = this.ve;
        if (jSONObject2 == null) {
            return;
        }
        Iterator<String> itKeys = jSONObject2.keys();
        c<ViewGroup> cVar = this.f2863a;
        c.C0323c c0323cX = cVar instanceof c ? cVar.x() : null;
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            String strC = com.byazt.wj.tt.c(this.ve.optString(next), jSONObject);
            c(next, strC);
            if (c0323cX != null) {
                c0323cX.c(this.tt, next, strC);
            }
        }
        if (c0323cX != null) {
            c(c0323cX.c());
        }
        if (this.bp == null || this.uj == null) {
            return;
        }
        try {
            if (h()) {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("i18n", this.bp);
                this.uj.put("xNode", jSONObject3);
                return;
            }
            this.uj.put("i18n", this.bp);
        } catch (JSONException e) {
            com.byazt.nr.m.c(e);
        }
    }

    public void sl() {
        boolean zOptBoolean = this.uj.optBoolean("gesture_through_enable", false);
        com.byazt.sz.i.c cVar = this.x;
        this.px = zOptBoolean && (cVar == null || cVar.ve());
        this.fk = this.uj.optBoolean("is_adapt_two_finger", false);
    }

    public void tt() {
        zm();
        t();
        tt(this.kk);
        sp();
        x();
        i iVar = this.pn;
        if (iVar != null) {
            iVar.tt();
            this.pn.ve();
            this.pn.uj();
        }
        this.n.setOnTouchListener(this);
        q();
        ViewGroup viewGroup = (ViewGroup) this.n.getParent();
        if (viewGroup != null) {
            viewGroup.setClipChildren(!this.az);
        }
        com.byazt.rb.c cVar = this.oz;
        if (cVar != null) {
            cVar.uj();
        }
        com.byazt.rb.a aVar = this.r;
        if (aVar != null) {
            aVar.c();
        }
        i iVar2 = this.pn;
        if (iVar2 != null) {
            iVar2.n();
            this.pn.a();
        }
        if (this.hq != null && c(22)) {
            this.hq.c(this.gx.get(22), this, this);
        }
        com.byazt.hn.ve veVar = this.ej;
        if (veVar == null || !veVar.c()) {
            return;
        }
        this.ej.c(this.n);
    }

    public void t() {
        this.n.setPadding((int) (this.zb ? this.p : this.yv), (int) (this.cu ? this.h : this.yv), (int) (this.or ? this.md : this.yv), (int) (this.qp ? this.d : this.yv));
    }

    private void sp() {
        if (this.c) {
            this.n.setTranslationX(this.y);
        }
        if (this.yo) {
            this.n.setTranslationY(this.iu);
        }
        if (this.vp) {
            this.n.setScaleX(this.dz);
        }
        if (this.kz) {
            this.n.setScaleY(this.ma);
        }
        if (this.vi) {
            this.n.setRotation(this.yf);
        }
        if (this.mq) {
            this.n.setRotationX(this.f);
        }
        if (this.cf) {
            this.n.setRotationY(-this.ir);
        }
        if (this.ij) {
            this.n.setAlpha(this.hj);
        }
        float f = this.g;
        if (f != 0.0f) {
            this.n.setRotation(f);
        }
        if (this.vi || this.mq || this.cf) {
            this.n.setCameraDistance(10000.0f);
        }
    }

    @Deprecated
    private void x() {
        com.byazt.dq.uj ujVarUj;
        this.n.setVisibility(this.kk);
        float f = this.g;
        if (f != 0.0f) {
            this.n.setRotation(f);
        }
        com.byazt.sz.i.c cVar = this.x;
        if (cVar != null && TextUtils.isEmpty(cVar.tt())) {
            this.n.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.xj.ve.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (ve.this.xd == null || !ve.this.bj) {
                        return;
                    }
                    ve.this.xd.c(ve.this);
                }
            });
        } else if (c(1) && !this.ca) {
            this.n.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.xj.ve.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (ve.this.hq == null || !ve.this.bj) {
                        return;
                    }
                    rh rhVar = ve.this.hq;
                    m mVar = ve.this.gx.get(1);
                    ve veVar = ve.this;
                    rhVar.c(mVar, veVar, veVar);
                }
            });
        }
        if (this.hq != null && c(4)) {
            if (c(1)) {
                this.cl = true;
                this.sd = new n(this.tt, this.gx.get(4), this.gx.get(1), this.cl, lt(), this.fk);
            } else {
                this.sd = new n(this.tt, this.gx.get(4), this.cl, lt(), this.fk);
            }
        }
        if (this.hq != null && c(1) && this.ca) {
            this.hg = new com.byazt.dq.ve(this.tt, this.gx.get(1));
        }
        b();
        if (this.hq != null && c(3) && (ujVarUj = com.byazt.sa.n.c().uj()) != null) {
            com.byazt.dq.uj.c cVar2 = this.k;
            if (cVar2 != null) {
                cVar2.tt();
            }
            com.byazt.dq.uj.c cVarC = ujVarUj.c(this.tt, this);
            this.k = cVarC;
            cVarC.c(this.mf);
            this.k.c();
            this.k.c(new com.byazt.dq.uj.tt() { // from class: com.byazt.xj.ve.3
                @Override // com.byazt.dq.uj.tt
                public void c(int i) {
                    ve.this.k.tt();
                    if (ve.this.n.isShown() && ve.this.hq != null && i == 1) {
                        rh rhVar = ve.this.hq;
                        m mVar = ve.this.gx.get(3);
                        ve veVar = ve.this;
                        rhVar.c(mVar, veVar, veVar);
                    }
                }
            });
        }
        if (this.hq != null && c(9)) {
            a aVar = new a(this.tt, this.gx.get(9), this);
            this.di = aVar;
            aVar.c(this.hq);
        }
        if (c(10)) {
            com.byazt.dq.tt ttVar = new com.byazt.dq.tt(this.tt, this.gx.get(10), this);
            this.jg = ttVar;
            ttVar.c(this.hq);
        }
    }

    private void b() {
        m mVar;
        if (this.hq == null || !c(18) || (mVar = this.gx.get(18)) == null) {
            return;
        }
        JSONObject jSONObjectVe = mVar.ve();
        if (jSONObjectVe != null) {
            try {
                jSONObjectVe.put("rotateZ", com.byazt.wj.tt.c(jSONObjectVe.optString("rotateZ"), this.uj));
            } catch (JSONException unused) {
            }
        }
        this.hq.c(mVar, this, this);
    }

    private void q() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.sl);
        this.n.setContentDescription(sb);
    }

    public void n() {
        if (this.pl != null) {
            u uVar = new u(this.n, this.pl);
            this.iy = uVar;
            uVar.c();
        }
        com.byazt.rb.c cVar = this.oz;
        if (cVar != null) {
            cVar.c();
        }
        com.byazt.rb.a aVar = this.r;
        if (aVar != null) {
            aVar.tt();
        }
        qy qyVar = this.gk;
        if (qyVar != null) {
            qyVar.uj();
        }
        i iVar = this.pn;
        if (iVar != null) {
            iVar.sp();
        }
        if (this.jg != null && c(10)) {
            this.jg.c();
        }
        if (this.di != null && c(9)) {
            this.di.c();
        }
        n nVar = this.sd;
        if (nVar != null) {
            nVar.c();
        }
        com.byazt.xd.c cVar2 = this.nl;
        if (cVar2 != null) {
            cVar2.ve();
        }
        com.byazt.hn.ve veVar = this.ej;
        if (veVar != null) {
            veVar.ve();
        }
        this.cx = System.currentTimeMillis();
    }

    public void a() {
        u uVar = this.iy;
        if (uVar != null) {
            uVar.tt();
        }
        com.byazt.rb.c cVar = this.oz;
        if (cVar != null) {
            cVar.ve();
        }
        com.byazt.rb.a aVar = this.r;
        if (aVar != null) {
            aVar.ve();
        }
        qy qyVar = this.gk;
        if (qyVar != null) {
            qyVar.n();
        }
        com.byazt.dq.uj.c cVar2 = this.k;
        if (cVar2 != null) {
            cVar2.tt();
        }
        com.byazt.xd.c cVar3 = this.nl;
        if (cVar3 != null) {
            cVar3.uj();
        }
        com.byazt.hn.ve veVar = this.ej;
        if (veVar != null) {
            veVar.uj();
        }
    }

    public void c(boolean z) {
        qy qyVar = this.gk;
        if (qyVar != null) {
            qyVar.c(z);
        }
        i iVar = this.pn;
        if (iVar != null) {
            iVar.c(z);
        }
    }

    public boolean c(int i) {
        Map<Integer, m> map = this.gx;
        return map != null && map.containsKey(Integer.valueOf(i));
    }

    public void tt(int i) {
        ViewParent viewParent = (ViewGroup) this.n.getParent();
        if (viewParent instanceof tt) {
            ((tt) viewParent).ve(this.n, i);
        } else {
            this.n.setVisibility(i);
        }
        i iVar = this.pn;
        if (iVar != null) {
            iVar.c(i);
        }
    }

    public void zm() {
        BitmapDrawable bitmapDrawable;
        Bitmap bitmapC;
        if (TextUtils.isEmpty(this.pf)) {
            if (this.gy) {
                c(this.mm);
                return;
            } else {
                this.jt.setColor(this.nb);
                ve(this.nb);
                return;
            }
        }
        if (this.pf.startsWith("local://")) {
            String strReplace = this.pf.replace("local://", "");
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inPreferredConfig = this.aw ? Bitmap.Config.ARGB_4444 : Bitmap.Config.RGB_565;
                options.inPurgeable = true;
                options.inInputShareable = true;
                Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(this.tt.getResources().openRawResource(com.byazt.cd.uj.tt(this.tt, strReplace)), null, options);
                if (this.aw && (bitmapC = x.c(this.tt, bitmapDecodeStream, (int) this.sv)) != null) {
                    bitmapDrawable = new BitmapDrawable(this.tt.getResources(), bitmapC);
                } else {
                    BitmapDrawable bitmapDrawable2 = new BitmapDrawable(this.tt.getResources(), bitmapDecodeStream);
                    bitmapDrawable = bitmapDrawable2;
                }
                c(bitmapDrawable);
                return;
            } catch (Throwable unused) {
                return;
            }
        }
        yv();
    }

    public void yv() {
        sp spVar = this.nt;
        if (spVar != null) {
            spVar.c();
        }
        com.byazt.sa.n.c().tt().c(this.i, this.pf, new com.byazt.sa.c.InterfaceC0263c() { // from class: com.byazt.xj.ve.4
            @Override // com.byazt.sa.c.InterfaceC0263c
            public void c(final Bitmap bitmap) {
                if (bitmap == null) {
                    if (ve.this.nt != null) {
                        sp spVar2 = ve.this.nt;
                        ve veVar = ve.this;
                        spVar2.tt(veVar, veVar.pf);
                        return;
                    }
                    return;
                }
                if (ve.this.nt != null) {
                    sp spVar3 = ve.this.nt;
                    ve veVar2 = ve.this;
                    spVar3.c(veVar2, veVar2.pf);
                }
                if (ve.this.aw) {
                    final Bitmap bitmapC = x.c(ve.this.tt, bitmap, (int) ve.this.sv);
                    if (bitmapC != null) {
                        x.c(new Runnable() { // from class: com.byazt.xj.ve.4.1
                            @Override // java.lang.Runnable
                            public void run() {
                                ve.this.c(new BitmapDrawable(bitmapC));
                            }
                        });
                        return;
                    }
                    return;
                }
                x.c(new Runnable() { // from class: com.byazt.xj.ve.4.2
                    @Override // java.lang.Runnable
                    public void run() {
                        ve.this.c(new BitmapDrawable(bitmap));
                    }
                });
            }
        });
    }

    public void c(com.byazt.cd.c.C0123c c0123c) {
        if (c0123c == null) {
            return;
        }
        this.jt.setShape(0);
        if (c0123c != null) {
            this.jt.setOrientation(c0123c.c);
            if (Build.VERSION.SDK_INT >= 29) {
                this.jt.setColors(c0123c.tt, c0123c.ve);
            } else {
                this.jt.setColors(c0123c.tt);
            }
        }
        os();
        v();
        kk();
    }

    public void ve(int i) {
        this.jt.setShape(0);
        this.jt.setColor(i);
        os();
        v();
        kk();
    }

    private void kk() {
        com.byazt.xd.c cVar = this.nl;
        if (cVar != null && cVar.tt()) {
            this.nl.c(this.n, this.jt, this.kp, oz());
        } else {
            this.n.setBackground(this.jt);
        }
    }

    private com.byazt.xd.c tx() {
        if (this.nl == null) {
            this.nl = new com.byazt.xd.c();
        }
        return this.nl;
    }

    private void v() {
        com.byazt.xd.c cVar = this.nl;
        if (cVar == null || !cVar.c()) {
            if (TextUtils.equals("dashed", this.q)) {
                GradientDrawable gradientDrawable = this.jt;
                float f = this.kp;
                gradientDrawable.setStroke((int) f, this.b, 3.0f * f, f);
            } else {
                if (TextUtils.equals("dotted", this.q)) {
                    GradientDrawable gradientDrawable2 = this.jt;
                    float f2 = this.kp;
                    gradientDrawable2.setStroke((int) f2, this.b, f2 / 2.0f, f2);
                    return;
                }
                this.jt.setStroke((int) this.kp, this.b);
            }
        }
    }

    private void os() {
        this.jt.setCornerRadii(oz());
    }

    public void c(Drawable drawable) {
        this.n.setBackground(drawable);
    }

    public void c(ViewGroup.LayoutParams layoutParams) {
        T t = this.n;
        if (t != null) {
            t.setLayoutParams(layoutParams);
        }
        this.os = layoutParams;
    }

    public void c(boolean z, boolean z2) {
        if (this.n != null) {
            c(this.os);
            if (z) {
                uj((int) this.u);
            }
            if (z2) {
                n((int) this.yp);
            }
        }
    }

    public ve<T> uj(String str) {
        return c(str);
    }

    public ve<T> c(String str) {
        if (TextUtils.isEmpty(this.sl) || !TextUtils.equals(this.sl, str)) {
            return null;
        }
        return this;
    }

    public ve<T> n(String str) {
        return tt(str);
    }

    public ve<T> tt(String str) {
        if (TextUtils.isEmpty(this.t) || !TextUtils.equals(this.t, str)) {
            return null;
        }
        return this;
    }

    public ve<T> a(String str) {
        return ve(str);
    }

    public ve<T> ve(String str) {
        if (da(str) != null) {
            return this;
        }
        return null;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public void c(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
        }
        str.hashCode();
        byte b = -1;
        switch (str.hashCode()) {
            case -1964681502:
                if (str.equals("clickable")) {
                    b = 0;
                }
                break;
            case -1901681170:
                if (str.equals("onRenderSuccess")) {
                    b = 1;
                }
                break;
            case -1721943862:
                if (str.equals("translateX")) {
                    b = 2;
                }
                break;
            case -1721943861:
                if (str.equals("translateY")) {
                    b = 3;
                }
                break;
            case -1501175880:
                if (str.equals("paddingLeft")) {
                    b = 4;
                }
                break;
            case -1375815020:
                if (str.equals("minWidth")) {
                    b = 5;
                }
                break;
            case -1351184668:
                if (str.equals("onDelay")) {
                    b = 6;
                }
                break;
            case -1337252761:
                if (str.equals("onShake")) {
                    b = 7;
                }
                break;
            case -1337126126:
                if (str.equals("onSlide")) {
                    b = 8;
                }
                break;
            case -1336288090:
                if (str.equals("onTimer")) {
                    b = 9;
                }
                break;
            case -1335874424:
                if (str.equals("onTwist")) {
                    b = 10;
                }
                break;
            case -1332194002:
                if (str.equals("background")) {
                    b = 11;
                }
                break;
            case -1291329255:
                if (str.equals("events")) {
                    b = 12;
                }
                break;
            case -1267206133:
                if (str.equals("opacity")) {
                    b = 13;
                }
                break;
            case -1228066334:
                if (str.equals("borderTopLeftRadius")) {
                    b = 14;
                }
                break;
            case -1221029593:
                if (str.equals("height")) {
                    b = 15;
                }
                break;
            case -1081309778:
                if (str.equals("margin")) {
                    b = 16;
                }
                break;
            case -1044792121:
                if (str.equals("marginTop")) {
                    b = 17;
                }
                break;
            case -1013407967:
                if (str.equals("onDown")) {
                    b = Ascii.DC2;
                }
                break;
            case -933876756:
                if (str.equals("backgroundDrawable")) {
                    b = 19;
                }
                break;
            case -925180581:
                if (str.equals("rotate")) {
                    b = Ascii.DC4;
                }
                break;
            case -908189618:
                if (str.equals("scaleX")) {
                    b = Ascii.NAK;
                }
                break;
            case -908189617:
                if (str.equals("scaleY")) {
                    b = Ascii.SYN;
                }
                break;
            case -882862153:
                if (str.equals("particleEffect")) {
                    b = Ascii.ETB;
                }
                break;
            case -806339567:
                if (str.equals("padding")) {
                    b = Ascii.CAN;
                }
                break;
            case -681357156:
                if (str.equals("triggerFunc")) {
                    b = Ascii.EM;
                }
                break;
            case -389160068:
                if (str.equals("borderGradient")) {
                    b = 26;
                }
                break;
            case -289173127:
                if (str.equals("marginBottom")) {
                    b = Ascii.ESC;
                }
                break;
            case -133587431:
                if (str.equals("minHeight")) {
                    b = Ascii.FS;
                }
                break;
            case 3355:
                if (str.equals("id")) {
                    b = Ascii.GS;
                }
                break;
            case 3176990:
                if (str.equals("i18n")) {
                    b = Ascii.RS;
                }
                break;
            case 3373707:
                if (str.equals("name")) {
                    b = Ascii.US;
                }
                break;
            case 87811796:
                if (str.equals("backgroundImageBlur")) {
                    b = 32;
                }
                break;
            case 90130308:
                if (str.equals("paddingTop")) {
                    b = 33;
                }
                break;
            case 94750088:
                if (str.equals("click")) {
                    b = 34;
                }
                break;
            case 105871684:
                if (str.equals("onTap")) {
                    b = 35;
                }
                break;
            case 108285963:
                if (str.equals("ratio")) {
                    b = 36;
                }
                break;
            case 109250890:
                if (str.equals("scale")) {
                    b = 37;
                }
                break;
            case 113126854:
                if (str.equals("width")) {
                    b = 38;
                }
                break;
            case 197402866:
                if (str.equals("borderFog")) {
                    b = 39;
                }
                break;
            case 202355100:
                if (str.equals("paddingBottom")) {
                    b = 40;
                }
                break;
            case 314070383:
                if (str.equals("animations")) {
                    b = 41;
                }
                break;
            case 320386138:
                if (str.equals("onLoadMore")) {
                    b = 42;
                }
                break;
            case 333432965:
                if (str.equals("borderTopRightRadius")) {
                    b = 43;
                }
                break;
            case 529642498:
                if (str.equals("overflow")) {
                    b = 44;
                }
                break;
            case 581268560:
                if (str.equals("borderBottomLeftRadius")) {
                    b = 45;
                }
                break;
            case 588239831:
                if (str.equals("borderBottomRightRadius")) {
                    b = 46;
                }
                break;
            case 713848971:
                if (str.equals("paddingRight")) {
                    b = 47;
                }
                break;
            case 722830999:
                if (str.equals("borderColor")) {
                    b = 48;
                }
                break;
            case 737768677:
                if (str.equals("borderStyle")) {
                    b = 49;
                }
                break;
            case 741115130:
                if (str.equals("borderWidth")) {
                    b = 50;
                }
                break;
            case 843948038:
                if (str.equals("onExposure")) {
                    b = 51;
                }
                break;
            case 975087886:
                if (str.equals("marginRight")) {
                    b = 52;
                }
                break;
            case 1052832078:
                if (str.equals("translate")) {
                    b = 53;
                }
                break;
            case 1087723621:
                if (str.equals("onAnimation")) {
                    b = 54;
                }
                break;
            case 1118509956:
                if (str.equals("animation")) {
                    b = 55;
                }
                break;
            case 1151851515:
                if (str.equals("animatorSet")) {
                    b = 56;
                }
                break;
            case 1158381436:
                if (str.equals("onPullToRefresh")) {
                    b = 57;
                }
                break;
            case 1287124693:
                if (str.equals(TtmlNode.ATTR_TTS_BACKGROUND_COLOR)) {
                    b = 58;
                }
                break;
            case 1292595405:
                if (str.equals("backgroundImage")) {
                    b = 59;
                }
                break;
            case 1301532860:
                if (str.equals("backgroundScale")) {
                    b = 60;
                }
                break;
            case 1349188574:
                if (str.equals("borderRadius")) {
                    b = Base64.padSymbol;
                }
                break;
            case 1384173149:
                if (str.equals("rotateX")) {
                    b = 62;
                }
                break;
            case 1384173150:
                if (str.equals("rotateY")) {
                    b = Utf8.REPLACEMENT_BYTE;
                }
                break;
            case 1384173151:
                if (str.equals("rotateZ")) {
                    b = SignedBytes.MAX_POWER_OF_TWO;
                }
                break;
            case 1490730380:
                if (str.equals("onScroll")) {
                    b = 65;
                }
                break;
            case 1671308008:
                if (str.equals("disable")) {
                    b = 66;
                }
                break;
            case 1685004456:
                if (str.equals("onLongTap")) {
                    b = 67;
                }
                break;
            case 1824519034:
                if (str.equals("borderFlow")) {
                    b = 68;
                }
                break;
            case 1941332754:
                if (str.equals("visibility")) {
                    b = 69;
                }
                break;
            case 1970934485:
                if (str.equals("marginLeft")) {
                    b = 70;
                }
                break;
            case 1997542747:
                if (str.equals("availability")) {
                    b = 71;
                }
                break;
        }
        switch (b) {
            case 0:
                this.bj = com.byazt.cd.ve.c(str2, true);
                break;
            case 1:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 18:
            case 35:
            case 42:
            case 51:
            case 54:
            case 57:
            case 65:
            case 67:
                tt(str, str2);
                break;
            case 2:
                this.c = true;
                this.y = x.c(this.tt, com.byazt.cd.ve.c(str2, 0.0f));
                break;
            case 3:
                this.yo = true;
                this.iu = x.c(this.tt, com.byazt.cd.ve.c(str2, 0.0f));
                break;
            case 4:
                this.p = x.c(this.tt, str2);
                this.zb = true;
                break;
            case 5:
                this.gt = com.byazt.cd.ve.c(str2, 0.0f);
                break;
            case 11:
            case 58:
                if (com.byazt.cd.c.ve(str2)) {
                    this.gy = true;
                    this.mm = com.byazt.cd.c.tt(str2);
                } else {
                    this.nb = com.byazt.cd.c.c(str2, 0);
                    this.gy = false;
                }
                break;
            case 12:
                this.pn = i.c(this, str2);
                break;
            case 13:
                this.ij = true;
                this.hj = com.byazt.cd.ve.c(str2, 1.0f);
                break;
            case 14:
                this.bm = x.c(this.tt, str2);
                this.pu = true;
                break;
            case 15:
                if (TextUtils.equals(str2, "match_parent")) {
                    this.yp = -1.0f;
                } else if (TextUtils.equals(str2, "wrap_content")) {
                    this.yp = -2.0f;
                } else {
                    this.yp = x.c(this.tt, str2);
                }
                this.dr = true;
                break;
            case 16:
                this.z = x.c(this.tt, str2);
                break;
            case 17:
                this.rh = x.c(this.tt, str2);
                this.gr = true;
                break;
            case 19:
            case 59:
                this.pf = str2;
                break;
            case 20:
                this.vi = true;
                this.yf = com.byazt.cd.ve.c(str2, 0.0f);
                break;
            case 21:
                this.vp = true;
                this.dz = com.byazt.cd.ve.c(str2, 0.0f);
                break;
            case 22:
                this.kz = true;
                this.ma = com.byazt.cd.ve.c(str2, 0.0f);
                break;
            case 23:
                if (this.ej == null) {
                    this.ej = new com.byazt.hn.ve(this.tt);
                }
                this.ej.c(str2);
                break;
            case 24:
                this.yv = x.c(this.tt, str2);
                this.eo = true;
                break;
            case 25:
                this.nc = str2;
                break;
            case 26:
                tx().c(str2);
                break;
            case 27:
                this.my = x.c(this.tt, str2);
                this.zm = true;
                break;
            case 28:
                this.rl = com.byazt.cd.ve.c(str2, 0.0f);
                break;
            case 29:
                this.sl = str2;
                break;
            case 30:
                this.bp = com.byazt.cd.tt.c(str2, (JSONObject) null);
                break;
            case 31:
                this.t = str2;
                break;
            case 32:
                float fC = com.byazt.cd.ve.c(str2, 0.0f);
                this.sv = fC;
                if (fC > 0.0f) {
                    this.aw = true;
                }
                break;
            case 33:
                this.h = x.c(this.tt, str2);
                this.cu = true;
                break;
            case 34:
                this.w = str2;
                break;
            case 36:
                this.tx = com.byazt.cd.ve.c(str2, 0.0f);
                break;
            case 37:
                this.vp = true;
                this.kz = true;
                float[] fArrTt = com.byazt.rb.uj.tt(str2, this.uj);
                this.dz = fArrTt[0];
                this.ma = fArrTt[1];
                break;
            case 38:
                if (TextUtils.equals(str2, "match_parent")) {
                    this.u = -1.0f;
                } else if (TextUtils.equals(str2, "wrap_content")) {
                    this.u = -2.0f;
                } else {
                    this.u = x.c(this.tt, str2);
                }
                this.ph = true;
                break;
            case 39:
                tx().c(str2, this.tt);
                break;
            case 40:
                this.d = x.c(this.tt, str2);
                this.qp = true;
                break;
            case 41:
                List<com.byazt.rb.ve> listC = com.byazt.rb.uj.c(str2, this.uj);
                if (listC != null && !listC.isEmpty()) {
                    this.r = new com.byazt.rb.a(this.tt, this, listC);
                    break;
                }
                break;
            case 43:
                this.l = x.c(this.tt, str2);
                this.lt = true;
                break;
            case 44:
                this.az = t(str2);
                break;
            case 45:
                this.lr = x.c(this.tt, str2);
                this.to = true;
                break;
            case 46:
                this.lo = x.c(this.tt, str2);
                this.tk = true;
                break;
            case 47:
                this.md = x.c(this.tt, str2);
                this.or = true;
                break;
            case 48:
                this.b = com.byazt.cd.c.c(str2);
                break;
            case 49:
                this.q = str2;
                break;
            case 50:
                this.kp = x.c(this.tt, str2);
                break;
            case 52:
                this.nu = x.c(this.tt, str2);
                this.gu = true;
                break;
            case 53:
                this.c = true;
                this.yo = true;
                float[] fArrTt2 = com.byazt.rb.uj.tt(str2, this.uj);
                this.y = x.c(this.tt, fArrTt2[0]);
                this.iu = x.c(this.tt, fArrTt2[1]);
                break;
            case 55:
                try {
                    this.oz = new com.byazt.rb.c(this.tt, this, com.byazt.rb.uj.c(new JSONObject(str2), this.uj));
                } catch (JSONException e) {
                    com.byazt.nr.m.c(e);
                    return;
                }
                break;
            case 56:
                this.pl = com.byazt.sz.c.c(str2, this);
                break;
            case 60:
                this.ic = true;
                this.bx = sl(str2);
                break;
            case 61:
                this.hd = x.c(this.tt, str2);
                break;
            case 62:
                this.mq = true;
                this.f = com.byazt.cd.ve.c(str2, 0.0f);
                break;
            case 63:
                this.cf = true;
                this.ir = com.byazt.cd.ve.c(str2, 0.0f);
                break;
            case 64:
                this.g = com.byazt.cd.ve.c(str2, 0.0f);
                break;
            case 66:
                this.is = com.byazt.cd.ve.c(str2, false);
                break;
            case 68:
                tx().tt(str2);
                break;
            case 69:
                if (TextUtils.equals("visible", str2)) {
                    this.kk = 0;
                } else if (TextUtils.equals("invisible", str2)) {
                    this.kk = 4;
                } else if (TextUtils.equals("gone", str2) || TextUtils.equals("hidden", str2)) {
                    this.kk = 8;
                }
                this.n.setVisibility(this.kk);
                i iVar = this.pn;
                if (iVar != null) {
                    iVar.c(this.kk);
                }
                break;
            case 70:
                this.m = x.c(this.tt, str2);
                this.qy = true;
                break;
            case 71:
                this.v = !TextUtils.equals(str2, "unavailable");
                break;
        }
    }

    private ImageView.ScaleType sl(String str) {
        str.hashCode();
        switch (str) {
            case "center":
                this.bx = ImageView.ScaleType.CENTER;
                break;
            case "fit":
                this.bx = ImageView.ScaleType.FIT_CENTER;
                break;
            case "crop":
                this.bx = ImageView.ScaleType.CENTER_CROP;
                break;
            default:
                this.bx = ImageView.ScaleType.FIT_XY;
                break;
        }
        return this.bx;
    }

    private boolean t(String str) {
        return TextUtils.isEmpty(str) || !TextUtils.equals(str, "hidden");
    }

    public void tt(String str, String str2) {
        if (TextUtils.isEmpty(str2) || this.gx == null) {
            return;
        }
        try {
            int type = nu.c(str).getType();
            m mVar = new m();
            mVar.c(type);
            mVar.c(this);
            JSONObject jSONObject = new JSONObject(str2);
            if (type == 3) {
                try {
                    this.mf = Float.parseFloat(com.byazt.wj.tt.c(jSONObject.optString("shakeAmplitude"), this.uj));
                } catch (NumberFormatException unused) {
                    this.mf = 12.0f;
                }
            }
            rh rhVar = this.hq;
            if (!(rhVar instanceof com.byazt.lv.tt)) {
                c(type, jSONObject, mVar);
            } else if (!((com.byazt.lv.tt) rhVar).c()) {
                c(type, jSONObject, mVar);
            } else {
                mVar.c(jSONObject);
                this.gx.put(Integer.valueOf(type), mVar);
            }
        } catch (JSONException unused2) {
        }
    }

    @Deprecated
    public void c(int i, JSONObject jSONObject, m mVar) {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("success");
        if (jSONObjectOptJSONObject != null) {
            m mVar2 = new m();
            mVar2.c(jSONObjectOptJSONObject);
            mVar2.c(this);
            mVar.c(mVar2);
        }
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("fail");
        if (jSONObjectOptJSONObject2 != null) {
            m mVar3 = new m();
            mVar3.c(jSONObjectOptJSONObject2);
            mVar3.c(this);
            mVar.tt(mVar3);
        }
        mVar.c(jSONObject);
        this.gx.put(Integer.valueOf(i), mVar);
    }

    @Override // com.byazt.sa.uj
    public int[] c(int i, int i2) {
        if (this.tx > 0.0f) {
            if (this.ph) {
                int size = View.MeasureSpec.getSize(i);
                float f = this.tx;
                if (f != 0.0f) {
                    i2 = View.MeasureSpec.makeMeasureSpec((int) (size / f), 1073741824);
                }
            } else if (this.dr) {
                int size2 = View.MeasureSpec.getSize(i2);
                float f2 = this.tx;
                if (f2 != 0.0f) {
                    i = View.MeasureSpec.makeMeasureSpec((int) (size2 * f2), 1073741824);
                }
            }
        }
        if (this.gk != null && !this.pe) {
            this.pe = true;
        }
        return new int[]{i, i2};
    }

    @Override // com.byazt.sa.uj
    public void c(Canvas canvas, com.byazt.sz.n nVar) {
        u uVar = this.iy;
        if (uVar != null) {
            uVar.c(canvas, nVar);
        }
    }

    @Override // com.byazt.sa.uj
    public void c(Canvas canvas) {
        if (this instanceof c) {
            return;
        }
        com.byazt.rb.c cVar = this.oz;
        if (cVar != null) {
            cVar.c(canvas);
        }
        com.byazt.rb.a aVar = this.r;
        if (aVar != null) {
            aVar.c(canvas);
        }
    }

    @Override // com.byazt.sa.uj
    public void tt(Canvas canvas) {
        if (this instanceof c) {
            com.byazt.rb.c cVar = this.oz;
            if (cVar != null) {
                cVar.tt(canvas);
            }
            com.byazt.rb.a aVar = this.r;
            if (aVar != null) {
                aVar.tt(canvas);
            }
        }
    }

    @Override // com.byazt.sa.uj
    public void tt(int i, int i2, int i3, int i4) {
        u uVar = this.iy;
        if (uVar != null) {
            uVar.c(i, i2);
        }
        com.byazt.rb.c cVar = this.oz;
        if (cVar != null) {
            cVar.c(i, i2);
        }
        com.byazt.rb.a aVar = this.r;
        if (aVar != null) {
            aVar.c(i, i2);
        }
    }

    @Override // com.byazt.sz.rh.tt
    public void c(m mVar) {
        c<ViewGroup> cVar;
        ve<T> veVarUj;
        if (mVar == null || mVar.ve() == null) {
            return;
        }
        com.byazt.dq.uj.c cVar2 = this.k;
        if (cVar2 != null) {
            cVar2.tt();
        }
        if (TextUtils.equals(mVar.ve().optString("type"), "onDismiss")) {
            String strOptString = mVar.ve().optString("nodeId");
            tt(8);
            this.sp = (c) tt(this);
            if (TextUtils.isEmpty(strOptString) || (cVar = this.sp) == null || (veVarUj = cVar.uj(strOptString)) == null) {
                return;
            }
            veVarUj.tt(8);
        }
    }

    public ve tt(ve veVar) {
        return (veVar.d() == null && (veVar instanceof c)) ? veVar : tt(veVar.d());
    }

    public void ic() {
        n nVar = this.sd;
        if (nVar != null) {
            nVar.tt();
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        n nVar;
        rh rhVar;
        com.byazt.dq.ve veVar;
        int action = motionEvent.getAction();
        if (action == 0) {
            sv();
        } else if (action == 1 || action == 3) {
            aw();
        }
        gt gtVar = this.ny;
        if (gtVar != null) {
            gtVar.c(this, motionEvent);
        }
        if (c(17) && motionEvent.getAction() == 0) {
            this.hq.c(this.gx.get(17), this, this);
        }
        if (c(1) && this.ca && (rhVar = this.hq) != null && (veVar = this.hg) != null) {
            return veVar.c(rhVar, this, motionEvent);
        }
        rh rhVar2 = this.hq;
        if (rhVar2 != null && (nVar = this.sd) != null) {
            return nVar.c(rhVar2, this, motionEvent, lt());
        }
        i iVar = this.pn;
        if (iVar != null) {
            return iVar.c(motionEvent);
        }
        return false;
    }

    public float bm() {
        T t = this.n;
        if (t instanceof com.byazt.rb.sp) {
            return ((com.byazt.rb.sp) t).getRipple();
        }
        return 0.0f;
    }

    public float lr() {
        T t = this.n;
        if (t instanceof com.byazt.rb.sp) {
            return ((com.byazt.rb.sp) t).getShine();
        }
        return 0.0f;
    }

    public float l() {
        T t = this.n;
        if (t instanceof com.byazt.rb.sp) {
            return ((com.byazt.rb.sp) t).getStretch();
        }
        return 0.0f;
    }

    public float lo() {
        T t = this.n;
        if (t instanceof com.byazt.rb.sp) {
            return ((com.byazt.rb.sp) t).getRubIn();
        }
        return 0.0f;
    }

    public void uj(int i) {
        if (h()) {
            T t = this.n;
            if (t instanceof tt) {
                ((tt) t).c(i);
                return;
            }
            ViewParent viewParent = (ViewGroup) t.getParent();
            if (viewParent instanceof tt) {
                ((tt) viewParent).c(this.n, i);
                return;
            }
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.n.getLayoutParams();
        layoutParams.width = i;
        this.n.setLayoutParams(layoutParams);
    }

    public void n(int i) {
        if (h()) {
            T t = this.n;
            if (t instanceof tt) {
                ((tt) t).tt(i);
                return;
            }
            ViewParent viewParent = (ViewGroup) t.getParent();
            if (viewParent instanceof tt) {
                ((tt) viewParent).tt(this.n, i);
                return;
            }
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.n.getLayoutParams();
        layoutParams.height = i;
        this.n.setLayoutParams(layoutParams);
    }

    public List<com.byazt.ji.tt> i(String str) {
        i iVar;
        if (TextUtils.isEmpty(str) || (iVar = this.pn) == null) {
            return null;
        }
        return iVar.tt(str);
    }

    public void c(String str, Object... objArr) {
        List<com.byazt.ji.tt> listI = i(str);
        if (listI == null || listI.isEmpty()) {
            return;
        }
        for (com.byazt.ji.tt ttVar : listI) {
            ttVar.c(this.pn);
            ttVar.c(objArr);
        }
    }

    public void c(com.byazt.sz.a aVar) {
        i iVar = this.pn;
        if (iVar != null) {
            iVar.c(aVar);
        }
    }

    public com.byazt.rb.c da(String str) {
        com.byazt.rb.c cVar = this.oz;
        if (cVar != null && TextUtils.equals(str, cVar.n())) {
            return this.oz;
        }
        com.byazt.rb.a aVar = this.r;
        if (aVar != null) {
            return aVar.c(str);
        }
        return null;
    }

    public void c(yp ypVar) {
        i iVar = this.pn;
        if (iVar != null) {
            iVar.c(ypVar);
        }
        this.fv = ypVar;
    }

    public void c(com.byazt.pm.u uVar) {
        i iVar = this.pn;
        if (iVar != null) {
            iVar.c(uVar);
        }
        this.st = uVar;
    }
}
