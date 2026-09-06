package com.byazt.ux;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.alipay.sdk.tid.b;
import com.byazt.aas.cu;
import com.byazt.aas.nb;
import com.byazt.aas.pf;
import com.byazt.dna.u;
import com.byazt.eia.i;
import com.byazt.ete.ic;
import com.byazt.ete.my;
import com.byazt.ete.yp;
import com.byazt.kt.RecyclerView;
import com.byazt.nr.h;
import com.byazt.nr.z;
import com.byazt.omf.gt;
import com.byazt.omf.rh;
import com.byazt.oq.GifView;
import com.byazt.ouz.sl;
import com.byazt.xs.da;
import com.byazt.yj.gr;
import com.byazt.yj.m;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.google.android.exoplayer2.C;
import com.huawei.openalliance.ad.constant.dd;
import cz.msebera.android.httpclient.HttpStatus;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, HttpStatus.SC_INSUFFICIENT_SPACE_ON_RESOURCE, 20})
public abstract class c implements sl, uj, ve, x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.byazt.qj.c f2803a;
    public com.byazt.seg.c c;
    public a gr;
    public InterfaceC0301c gt;
    public List<com.byazt.pj.ve> i;
    public int m;
    public tt my;
    public ic n;
    public int nu;
    public int rh;
    public com.byazt.xj.ve<View> sp;
    public String t;
    public Context tt;
    public Map<String, Object> u;
    public com.byazt.ddx.sp uj;
    public ViewGroup ve;
    public com.byazt.xj.ve<View> x;
    public JSONObject yp;
    public boolean yv;
    public int z;
    public FrameLayout zm;
    public boolean qy = true;
    public boolean gu = true;
    public AtomicInteger rl = new AtomicInteger(2);
    public AtomicInteger da = new AtomicInteger();
    public Map<Integer, Boolean> sl = new HashMap();

    /* JADX INFO: renamed from: com.byazt.ux.c$c, reason: collision with other inner class name */
    public interface InterfaceC0301c {
        void c();
    }

    public void c(com.byazt.qj.c cVar) {
        this.f2803a = cVar;
    }

    public void c(InterfaceC0301c interfaceC0301c) {
        this.gt = interfaceC0301c;
    }

    public void c(Map<String, Object> map) {
        this.u = map;
    }

    public abstract List<com.byazt.pj.ve> sl();

    public void tt(boolean z) {
        this.yv = z;
    }

    public c(Context context, ViewGroup viewGroup, com.byazt.ddx.sp spVar, ic icVar, String str, int i) {
        this.tt = context;
        this.ve = viewGroup;
        this.uj = spVar;
        this.n = icVar;
        this.t = str;
        this.c = icVar.v();
        a aVar = new a(this.tt, this.uj, icVar, str, i);
        this.gr = aVar;
        aVar.c((uj) this);
        this.gr.c((ve) this);
        if (this.n.ts() != null) {
            this.gr.c((x) this);
        }
    }

    public void t() {
        try {
            this.i = sl();
            n.c(this.c, new n.c() { // from class: com.byazt.ux.c.1
                @Override // com.byazt.ux.n.c
                public void c(JSONObject jSONObject) {
                    if (jSONObject == null) {
                        c.this.uj.c(-1, "template info load fail");
                        if (c.this.f2803a != null) {
                            c.this.f2803a.c(-1);
                            return;
                        }
                        return;
                    }
                    c cVar = c.this;
                    cVar.c(jSONObject, cVar.i);
                }
            });
        } catch (Exception e) {
            this.uj.c(-3, e.getMessage());
            com.byazt.qj.c cVar = this.f2803a;
            if (cVar != null) {
                cVar.c(-3);
            }
        }
    }

    public boolean u() {
        com.byazt.xj.ve<T> veVarUj;
        com.byazt.xj.ve<View> veVar = this.sp;
        return (veVar == null || (veVarUj = veVar.uj("interactionWebView")) == 0 || veVarUj.i() == null || veVarUj.i().getVisibility() != 0) ? false : true;
    }

    public void c(JSONObject jSONObject, List<com.byazt.pj.ve> list) {
        this.uj.tt();
        this.gr.c((sl) this);
        this.gr.c(jSONObject, list, new sp() { // from class: com.byazt.ux.c.4
            @Override // com.byazt.ux.sp
            public void c(int i, String str) {
                if (c.this.f2803a != null) {
                    c.this.f2803a.c(i);
                }
            }

            @Override // com.byazt.ux.sp
            public void c(com.byazt.xj.ve<View> veVar) {
                c.this.sp = veVar;
                c cVar = c.this;
                cVar.x = cVar.gr.c();
                c.this.ve.addView(veVar.i(), new FrameLayout.LayoutParams(veVar.or(), veVar.cu()));
                if (c.this.yv) {
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(pf.ve(c.this.tt, 200.0f), pf.ve(c.this.tt, 200.0f));
                    layoutParams.gravity = 17;
                    c.this.ve.addView(c.this.m(), layoutParams);
                }
                if (c.this.f2803a != null) {
                    c.this.f2803a.c(veVar.i());
                }
                com.byazt.ddx.uj.c(c.this.n, c.this.t, "ugeno_coin_eCommerce_page_show_success", (com.byazt.ya.c) null);
            }
        });
    }

    public void c(tt ttVar) {
        this.my = ttVar;
        a aVar = this.gr;
        if (aVar != null) {
            aVar.c(ttVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View m() {
        this.zm = new FrameLayout(this.tt);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(18.0f);
        gradientDrawable.setColor(Color.parseColor("#99000000"));
        gradientDrawable.setShape(0);
        this.zm.setBackground(gradientDrawable);
        final GifView gifView = new GifView(this.tt);
        com.byazt.xky.tt.c(com.byazt.fh.ve.c("shop_page_guide_gif.gif")).type(3).config(Bitmap.Config.RGB_565).to(new gr() { // from class: com.byazt.ux.c.5
            @Override // com.byazt.yj.gr
            public void onFailed(int i, String str, Throwable th) {
            }

            @Override // com.byazt.yj.gr
            public void onSuccess(m mVar) {
                Object result = mVar.getResult();
                try {
                    if (result instanceof byte[]) {
                        if (mVar.isGif()) {
                            gifView.c((byte[]) result, false);
                        } else {
                            gifView.setImageDrawable(com.byazt.aas.m.c((byte[]) result, 0));
                        }
                    }
                } catch (Throwable unused) {
                }
            }
        });
        int iVe = pf.ve(this.tt, 120.0f);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(iVe, iVe);
        layoutParams.gravity = 17;
        layoutParams.bottomMargin = pf.ve(this.tt, 10.0f);
        gifView.setLayoutParams(layoutParams);
        this.zm.addView(gifView);
        TextView textView = new TextView(this.tt);
        textView.setText("需要浏览页面才能领取奖励");
        textView.setTextSize(14.0f);
        textView.setTypeface(Typeface.SERIF, 1);
        textView.setTextColor(Color.parseColor("#ffffff"));
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 17;
        layoutParams2.topMargin = pf.ve(this.tt, 70.0f);
        textView.setLayoutParams(layoutParams2);
        this.zm.addView(textView);
        this.zm.setOnTouchListener(new com.byazt.lo.ve(this.tt, new com.byazt.lo.ve.c() { // from class: com.byazt.ux.c.6
            @Override // com.byazt.lo.ve.c
            public void c() {
                if ((c.this.x instanceof com.byazt.pj.a) && c.this.x.i() != null) {
                    ((RecyclerView) c.this.x.i()).tt(1);
                }
                c cVar = c.this;
                cVar.c(cVar.x);
                c.this.zm.setVisibility(8);
                com.byazt.ddx.uj.c(c.this.n, com.huawei.openalliance.ad.constant.x.dh, "in_web_click", (com.byazt.ya.c) null);
            }

            @Override // com.byazt.lo.ve.c
            public void tt() {
                c.this.zm.setVisibility(8);
            }
        }, 200));
        this.zm.postDelayed(new Runnable() { // from class: com.byazt.ux.c.7
            @Override // java.lang.Runnable
            public void run() {
                c.this.zm.setVisibility(8);
            }
        }, C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS);
        return this.zm;
    }

    /* JADX INFO: renamed from: com.byazt.ux.c$8, reason: invalid class name */
    @com.byazt.zqa.c(c = {0, 1, HttpStatus.SC_INSUFFICIENT_SPACE_ON_RESOURCE, 112})
    public class AnonymousClass8 extends com.byazt.bwm.sp {
        public final /* synthetic */ com.byazt.xj.ve c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass8(String str, com.byazt.xj.ve veVar) {
            super(str);
            this.c = veVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.byazt.hy.tt.c(c.this.n, c.this.yp, new com.byazt.at.uj() { // from class: com.byazt.ux.c.8.1
                @Override // com.byazt.at.uj
                public void c(boolean z, List<ic> list, boolean z2) {
                    if (list == null || list.size() <= 0) {
                        if (c.this.rl.get() <= 0) {
                            if (c.this.gt != null) {
                                c.this.gt.c();
                                return;
                            }
                            return;
                        } else {
                            c.this.c(AnonymousClass8.this.c);
                            c.this.rl.decrementAndGet();
                            return;
                        }
                    }
                    c.this.m = list.size();
                    c.this.nu += list.size();
                    c.this.rh = c.this.yp();
                    ic icVar = list.get(0);
                    if (icVar != null) {
                        c.this.yp = icVar.jm();
                    }
                    final List<com.byazt.pj.ve> listC = c.this.c(list);
                    rh.a().post(new Runnable() { // from class: com.byazt.ux.c.8.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (AnonymousClass8.this.c == null || !(AnonymousClass8.this.c instanceof com.byazt.pj.a)) {
                                return;
                            }
                            ((com.byazt.pj.a) AnonymousClass8.this.c).tt(listC);
                        }
                    });
                }
            }, c.this.n.ij());
        }
    }

    public void c(com.byazt.xj.ve veVar) {
        com.byazt.bwm.n.tt(new AnonymousClass8("shop_page", veVar));
    }

    public int yp() {
        int i = this.m;
        int i2 = this.z;
        return Math.max(i < i2 ? this.nu - i : this.nu - i2, 0);
    }

    public List<com.byazt.pj.ve> c(List<ic> list) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (ic icVar : list) {
            com.byazt.pj.ve veVar = new com.byazt.pj.ve();
            JSONObject jSONObjectYg = icVar.yg();
            try {
                jSONObjectYg.put("voice_btn_position", my.nu(this.n));
            } catch (JSONException unused) {
            }
            veVar.c(-2134548432);
            veVar.c(jSONObjectYg);
            arrayList.add(veVar);
        }
        return arrayList;
    }

    public void c(final ic icVar, final com.byazt.xj.ve veVar) {
        if (TextUtils.equals(veVar.eo(), dd.C)) {
            com.byazt.xj.c cVarD = veVar.d();
            if (cVarD != null) {
                com.byazt.xj.ve veVarUj = cVarD.uj("video_" + icVar.id());
                if (veVarUj instanceof com.byazt.qzm.tt) {
                    com.byazt.qzm.tt ttVar = (com.byazt.qzm.tt) veVarUj;
                    if (ttVar.x()) {
                        ttVar.uj(false);
                        if (veVar instanceof com.byazt.vn.tt) {
                            z.c(this.tt, "tt_unmute", new com.byazt.qr.c<Bitmap>() { // from class: com.byazt.ux.c.9
                                @Override // com.byazt.qr.c
                                public void c(Bitmap bitmap) {
                                    ((com.byazt.vn.tt) veVar).tt(new BitmapDrawable(c.this.tt.getResources(), bitmap));
                                }
                            }, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
                            return;
                        }
                        return;
                    }
                    ttVar.uj(true);
                    if (veVar instanceof com.byazt.vn.tt) {
                        z.c(this.tt, "tt_mute", new com.byazt.qr.c<Bitmap>() { // from class: com.byazt.ux.c.10
                            @Override // com.byazt.qr.c
                            public void c(Bitmap bitmap) {
                                ((com.byazt.vn.tt) veVar).tt(new BitmapDrawable(c.this.tt.getResources(), bitmap));
                            }
                        }, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        if (this.qy) {
            if (!da.a(this.n)) {
                c(this.n, this.u);
            }
            com.byazt.ddx.uj.c(icVar, this.t, "ugeno_coin_eCommerce_click_content", (com.byazt.ya.c) null);
            com.byazt.ddx.uj.c(icVar, this.t, "page_click", (com.byazt.ya.c) null);
            this.qy = false;
        }
        tt(icVar);
        if (this instanceof com.byazt.lo.uj) {
            icVar.sl(1);
            ic icVar2 = this.n;
            if (icVar2 != null) {
                icVar.c(icVar2.v());
            }
        }
        if (com.byazt.wdw.ve.c((i) icVar, true)) {
            com.byazt.wdw.ve veVar2 = new com.byazt.wdw.ve(icVar, icVar.my(), this.tt, new HashMap());
            veVar2.c(new com.byazt.wdw.ve.tt() { // from class: com.byazt.ux.c.11
                @Override // com.byazt.wdw.ve.tt
                public void c() {
                    rh.a().post(new Runnable() { // from class: com.byazt.ux.c.11.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (icVar == null || icVar.my() == null) {
                                return;
                            }
                            h.c(c.this.tt, icVar.my().uj(), 0);
                        }
                    });
                    c.this.tt(icVar, veVar);
                }

                @Override // com.byazt.wdw.ve.tt
                public void c(final String str, final boolean z) {
                    rh.a().post(new Runnable() { // from class: com.byazt.ux.c.11.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (z && "has_applied".equals(str)) {
                                h.c(c.this.tt, "你已领券，快去直播间下单吧", 0);
                            } else {
                                h.c(c.this.tt, "领券失败", 0);
                            }
                        }
                    });
                    c.this.tt(icVar, veVar);
                }
            });
            veVar2.c(new com.byazt.wdw.ve.c() { // from class: com.byazt.ux.c.2
                @Override // com.byazt.wdw.ve.c
                public void c() {
                }
            });
            return;
        }
        tt(icVar, veVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tt(ic icVar, com.byazt.xj.ve veVar) {
        String strTt = nb.tt(this.n);
        com.byazt.hkv.c cVar = new com.byazt.hkv.c(this.tt, icVar, strTt, nb.uj(strTt));
        Map<String, Object> mapN = ((com.byazt.vis.c) cVar.c(com.byazt.vis.c.class)).n();
        mapN.put("click_element_type", veVar.eo());
        Map<String, Object> map = this.u;
        if (map != null) {
            mapN.putAll(map);
        }
        final String strUj = icVar.uj();
        com.byazt.pop.ve veVarTt = com.byazt.yih.x.tt(this.tt, icVar, strTt);
        ((com.byazt.nat.c) cVar.c(com.byazt.nat.c.class)).c(veVarTt);
        cVar.c(null, new com.byazt.ete.da());
        if (veVarTt != null) {
            veVarTt.c(new com.byazt.pop.c() { // from class: com.byazt.ux.c.3
                @Override // com.byazt.pop.c
                public void c() {
                    com.byazt.nt.c.c(strUj);
                }

                @Override // com.byazt.pop.c
                public void c(long j, long j2, String str, String str2) {
                    com.byazt.nt.c.c(strUj, j, j2);
                }

                @Override // com.byazt.pop.c
                public void tt(long j, long j2, String str, String str2) {
                    com.byazt.nt.c.tt(strUj, j, j2);
                }

                @Override // com.byazt.pop.c
                public void ve(long j, long j2, String str, String str2) {
                    com.byazt.nt.c.ve(strUj, j, j2);
                }

                @Override // com.byazt.pop.c
                public void c(long j, String str, String str2) {
                    com.byazt.nt.c.tt(strUj);
                }

                @Override // com.byazt.pop.c
                public void c(String str, String str2) {
                    com.byazt.nt.c.ve(strUj);
                }
            });
        }
        Object obj = this.tt;
        if (obj instanceof com.byazt.fh.tt) {
            ((com.byazt.fh.tt) obj).c(2);
        }
    }

    private void tt(ic icVar) {
        com.byazt.lo.c cVarOs;
        JSONObject jSONObjectTt;
        yp ypVarC;
        if (icVar == null || (cVarOs = icVar.os()) == null || (jSONObjectTt = cVarOs.tt()) == null || (ypVarC = yp.c(jSONObjectTt)) == null) {
            return;
        }
        if (ypVarC.ve() == 0 || ypVarC.ve() == 5) {
            icVar.c(ypVarC);
        }
    }

    public void c(JSONObject jSONObject) {
        ic icVarC;
        if (jSONObject == null || (icVarC = com.byazt.omf.c.c(jSONObject)) == null) {
            return;
        }
        String strTt = nb.tt(this.n);
        HashMap map = new HashMap();
        map.put("is_slide", this.da);
        com.byazt.ddx.uj.c(icVarC, strTt, map, (Double) null);
        com.byazt.pf.c.c().uj();
        ic icVar = this.n;
        cu.c(icVar != null ? icVar.eo() : 0);
        JSONObject jSONObject2 = new JSONObject();
        try {
            if (this.gu && this.da.get() == 0) {
                return;
            }
            jSONObject2.put("is_slide", this.da);
            jSONObject2.put(b.f, System.currentTimeMillis());
            com.byazt.ddx.uj.c(icVarC, strTt, "is_slide", jSONObject2, (com.byazt.ya.c) null);
        } catch (JSONException e) {
            com.byazt.nr.m.c(e);
        }
    }

    @Override // com.byazt.ux.x
    public void tt(com.byazt.xj.ve veVar) {
        ic icVar = this.n;
        if (icVar == null || icVar.ts() == null) {
            return;
        }
        veVar.tt(0);
    }

    public void z() {
        ic icVar = this.n;
        cu.tt(icVar != null ? icVar.eo() : 0);
    }

    private void c(ic icVar, Map<String, Object> map) {
        if (icVar == null) {
            return;
        }
        String strTt = nb.tt(icVar);
        int displayDpi = ((u) com.byazt.ut.uj.getService("device_info_new")).getDisplayDpi();
        com.byazt.ddx.uj.c("click", icVar, new com.byazt.ete.i.c().a(-1.0f).n(-1.0f).uj(-1.0f).ve(-1.0f).tt(-1L).c(-1L).uj(-1).n(-1).a(-1024).ve(com.byazt.omf.x.m().tt() ? 1 : 2).tt(displayDpi).c(pf.a(gt.getContext())).tt(pf.sp(gt.getContext())).c(com.byazt.wz.x.tt(icVar)).c(), strTt, true, map, -1, false, false);
    }
}
