package com.byazt.un;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.byazt.aas.nb;
import com.byazt.aas.pf;
import com.byazt.afw.nu;
import com.byazt.bzd.t;
import com.byazt.ete.ic;
import com.byazt.ete.j;
import com.byazt.ete.xd;
import com.byazt.ff.TTProgressBar;
import com.byazt.ga.LottieAnimationView;
import com.byazt.kft.UpieVideoView;
import com.byazt.lbn.TTViewStub;
import com.byazt.nc.u;
import com.byazt.nr.da;
import com.byazt.nr.m;
import com.byazt.nr.rh;
import com.byazt.nr.z;
import com.byazt.omf.gt;
import com.byazt.omf.p;
import com.byazt.omf.x;
import com.byazt.omf.zb;
import com.byazt.ukr.yp;
import com.byazt.wol.LayoutVideoDetail;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.android.metrics.LiveMetrics;
import java.lang.ref.WeakReference;
import java.util.EnumSet;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 96, 15})
public class uj extends com.byazt.nj.c {
    public int bm;
    public boolean cu;
    public com.byazt.dh.ve.c eo;
    public WeakReference<c> hd;
    public WeakReference<com.byazt.dh.ve.uj> ic;
    public int kp;
    public int lr;
    public long lt;
    public ViewGroup md;
    public WeakReference<com.byazt.dh.ve.tt> nb;
    public String or;
    public long oz;
    public boolean qp;
    public int s;
    public Map<String, Object> tk;
    public int to;
    public final boolean zb;
    public long h = 0;
    public long d = 0;
    public boolean pf = false;
    public boolean bx = false;
    public boolean sv = true;
    public volatile boolean aw = false;
    public int l = 0;
    public boolean lo = false;
    public boolean pu = true;
    public boolean b = false;
    public boolean q = false;
    public boolean kk = false;
    public boolean tx = false;
    public com.byazt.fk.sp.c v = new com.byazt.fk.sp.c() { // from class: com.byazt.un.uj.1
        @Override // com.byazt.fk.sp.c
        public void onBufferingUpdate(com.byazt.fk.sp spVar, int i) {
        }

        @Override // com.byazt.fk.sp.c
        public void onStart(com.byazt.fk.sp spVar) {
        }

        @Override // com.byazt.fk.sp.c
        public void onCompletion(com.byazt.fk.sp spVar) {
            com.byazt.rgb.ve.a(uj.this.tx());
            uj.this.c.post(new Runnable() { // from class: com.byazt.un.uj.1.1
                @Override // java.lang.Runnable
                public void run() {
                    uj.this.hd();
                }
            });
            uj.this.c(4);
            uj.this.tt(4);
        }

        @Override // com.byazt.fk.sp.c
        public void onRenderStart(com.byazt.fk.sp spVar, long j) {
            if (!uj.this.b) {
                uj.this.b = true;
                com.byazt.rgb.ve.tt(uj.this.tx(), 1);
            }
            uj.this.c.post(new Runnable() { // from class: com.byazt.un.uj.1.2
                @Override // java.lang.Runnable
                public void run() {
                    if (uj.this.n != null) {
                        if (!uj.this.lt() || !gt.tt().pe()) {
                            uj.this.n.tt();
                        } else {
                            uj.this.n.p();
                        }
                        uj.this.c.removeCallbacks(uj.this.p);
                        uj.this.lo = false;
                    }
                    if (uj.this.hd != null && uj.this.hd.get() != null) {
                        ((c) uj.this.hd.get()).I_();
                    }
                    uj.this.c.removeCallbacks(uj.this.p);
                }
            });
            uj.this.pu();
            uj.this.lt = System.currentTimeMillis();
            uj.this.kk();
        }

        @Override // com.byazt.fk.sp.c
        public void onPrepared(com.byazt.fk.sp spVar) {
            if (!uj.this.q) {
                uj.this.q = true;
                com.byazt.rgb.ve.ve(uj.this.tx());
            }
            if (com.byazt.ex.c.c(uj.this.f2516a)) {
                uj.this.f2516a.ve(spVar.getCodec());
            }
            if (!uj.this.zb || t.c(uj.this.f2516a)) {
                uj.this.pu();
            }
            uj.this.c.post(new Runnable() { // from class: com.byazt.un.uj.1.3
                @Override // java.lang.Runnable
                public void run() {
                    if (uj.this.ic != null && uj.this.ic.get() != null) {
                        ((com.byazt.dh.ve.uj) uj.this.ic.get()).onVideoLoad();
                    }
                    if (uj.this.n != null && (!uj.this.lt() || !gt.tt().pe())) {
                        uj.this.n.tt();
                    }
                    uj.this.c.removeCallbacks(uj.this.p);
                }
            });
        }

        @Override // com.byazt.fk.sp.c
        public void onError(com.byazt.fk.sp spVar, final com.byazt.fk.ve veVar) {
            com.byazt.rgb.ve.ve(uj.this.tx(), 1);
            uj.this.c.post(new Runnable() { // from class: com.byazt.un.uj.1.4
                /* JADX WARN: Code duplicated, block: B:27:0x00d9  */
                /* JADX WARN: Code duplicated, block: B:30:0x00ee  */
                @Override // java.lang.Runnable
                public void run() {
                    int code = veVar.getCode();
                    int extraCode = veVar.getExtraCode();
                    uj.this.c(code, extraCode, veVar.getMsg(), (JSONArray) null);
                    m.uj("NativeVideoController", "CALLBACK_ON_ERROR、、before isVideoPlaying、、、、、");
                    if (!uj.this.bx() || extraCode == -1004) {
                        m.uj("NativeVideoController", "出错后 errorcode,extra、、、、、、、" + code + "," + extraCode);
                        if (!uj.this.uj(code, extraCode) && !com.byazt.ex.c.c(uj.this.f2516a)) {
                            if (code == 1 && (extraCode == -19 || extraCode == -38)) {
                                if (uj.this.n != null) {
                                    uj.this.n.c2(uj.this.f2516a, uj.this.i, false);
                                }
                            }
                            if (uj.this.n != null) {
                                uj.this.n.tt();
                            }
                            if (uj.this.eo != null) {
                                uj.this.eo.tt(uj.this.d, com.byazt.vv.c.c(uj.this.sp, uj.this.m));
                            }
                            if (uj.this.ic != null || uj.this.ic.get() == null || uj.this.bx()) {
                                return;
                            }
                            ((com.byazt.dh.ve.uj) uj.this.ic.get()).onVideoError(code, extraCode);
                            return;
                        }
                        m.uj("NativeVideoController", "出错后展示结果页、、、、、、、");
                        if (uj.this.n != null) {
                            uj.this.n.c2(uj.this.f2516a, uj.this.i, false);
                        }
                        uj.this.ve(true);
                        uj.this.da();
                        if (uj.this.n != null) {
                            uj.this.n.tt();
                        }
                        if (uj.this.eo != null) {
                            uj.this.eo.tt(uj.this.d, com.byazt.vv.c.c(uj.this.sp, uj.this.m));
                        }
                        if (uj.this.ic != null) {
                        }
                    }
                }
            });
            uj.this.c(veVar.getCode(), veVar.getMsg());
        }

        @Override // com.byazt.fk.sp.c
        public void onSeekCompletion(com.byazt.fk.sp spVar, boolean z) {
            uj.this.c.post(new Runnable() { // from class: com.byazt.un.uj.1.5
                @Override // java.lang.Runnable
                public void run() {
                    if (uj.this.n != null) {
                        uj.this.n.tt();
                    }
                }
            });
        }

        @Override // com.byazt.fk.sp.c
        public void onRelease(com.byazt.fk.sp spVar) {
            com.byazt.rgb.ve.ve(uj.this.tx(), 2);
            uj.this.b();
        }

        @Override // com.byazt.fk.sp.c
        public void onVideoSizeChanged(com.byazt.fk.sp spVar, final int i, final int i2) {
            uj.this.c.post(new Runnable() { // from class: com.byazt.un.uj.1.6
                @Override // java.lang.Runnable
                public void run() {
                    uj.this.tt(i, i2);
                }
            });
        }

        @Override // com.byazt.fk.sp.c
        public void onBufferStart(com.byazt.fk.sp spVar, int i, int i2, int i3) {
            com.byazt.rgb.ve.uj(uj.this.tx());
            uj.this.c.post(new Runnable() { // from class: com.byazt.un.uj.1.7
                @Override // java.lang.Runnable
                public void run() {
                    if (uj.this.n != null) {
                        uj.this.n.gu();
                        uj.this.c.postDelayed(uj.this.p, 8000L);
                        uj.this.lo = true;
                    }
                }
            });
        }

        @Override // com.byazt.fk.sp.c
        public void onBufferEnd(com.byazt.fk.sp spVar, int i) {
            uj.this.c.post(new Runnable() { // from class: com.byazt.un.uj.1.8
                @Override // java.lang.Runnable
                public void run() {
                    if (uj.this.n != null) {
                        uj.this.n.tt();
                    }
                    uj.this.c.removeCallbacks(uj.this.p);
                    uj.this.lo = false;
                }
            });
        }

        @Override // com.byazt.fk.sp.c
        public void onPlayPositionUpdate(com.byazt.fk.sp spVar, final long j, final long j2) {
            if (uj.this.kk && uj.this.tx) {
                uj.this.kk = false;
                uj.this.tx = false;
                com.byazt.rgb.ve.tt(uj.this.tx(), 2);
            }
            if (Math.abs(j - uj.this.sp) < 50) {
                return;
            }
            uj.this.c.post(new Runnable() { // from class: com.byazt.un.uj.1.9
                @Override // java.lang.Runnable
                public void run() {
                    if (uj.this.gu != null) {
                        uj.this.gu.c(j, j2);
                    }
                    uj.this.c(j, j2);
                    uj.this.tt(j, j2);
                }
            });
        }

        @Override // com.byazt.fk.sp.c
        public void onMonitorLog(com.byazt.fk.sp spVar, JSONObject jSONObject, String str) {
            if (x.m().hd()) {
                jSONObject.optString("start");
                jSONObject.optString("sdk_dns_analysis_end");
                jSONObject.optString("player_dns_analysis_end");
                jSONObject.optString("tcp_connect_end");
                jSONObject.optString("tcp_first_package_end");
                jSONObject.optString("first_video_package_end");
                jSONObject.optString("first_frame_video_decode_end");
                jSONObject.optString("first_frame_render_end");
                jSONObject.optLong("first_frame_render_end");
                jSONObject.optLong("start");
            }
            com.byazt.ddx.uj.c((Context) uj.this.i.get(), uj.this.f2516a, uj.this.or, "pangle_live_sdk_monitor", jSONObject);
        }

        @Override // com.byazt.fk.sp.c
        public void onPause(com.byazt.fk.sp spVar) {
            uj.this.kk = true;
            com.byazt.rgb.ve.n(uj.this.tx());
        }

        @Override // com.byazt.fk.sp.c
        public void onResume(com.byazt.fk.sp spVar) {
            uj.this.tx = true;
        }
    };
    public int os = 0;
    public Runnable p = new Runnable() { // from class: com.byazt.un.uj.6
        @Override // java.lang.Runnable
        public void run() {
            if (uj.this.n != null) {
                uj.this.n.c2(uj.this.f2516a, uj.this.i, false);
                uj.this.n.tt();
                uj.this.ve(true);
                m.uj("NativeVideoController", "出错后展示结果页、、、、、、、showAdCard");
            }
        }
    };
    public final com.byazt.fn.ve r = new com.byazt.fn.ve() { // from class: com.byazt.un.uj.8
        @Override // com.byazt.fn.ve
        public void onNetworkChanged(Context context, Intent intent, boolean z, int i) {
            uj.this.ve(context, i);
        }
    };
    public boolean y = false;

    public interface c {
        void I_();

        void c(int i);

        void i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean uj(int i, int i2) {
        boolean z = i == -1010 || i == -1007 || i == -1004 || i == -110 || i == 100 || i == 200 || i == 60008;
        if (i2 == 1 || i2 == 700 || i2 == 800) {
            return true;
        }
        return z;
    }

    public void c(int i, int i2) {
        if (i == 0 || i2 == 0) {
            return;
        }
        this.bm = i;
        this.lr = i2;
    }

    @Override // com.byazt.dh.ve
    public void c(com.byazt.dh.ve.c cVar) {
        this.eo = cVar;
    }

    @Override // com.byazt.dh.ve
    public void n(boolean z) {
        this.pu = z;
    }

    @Override // com.byazt.nj.c, com.byazt.dh.ve
    public boolean n() {
        return false;
    }

    @Override // com.byazt.nj.c
    public boolean p() {
        return true;
    }

    @Override // com.byazt.nj.c
    public Map<String, Object> pf() {
        return this.tk;
    }

    @Override // com.byazt.dh.ve
    public boolean qy() {
        return this.lo;
    }

    @Override // com.byazt.dh.ve
    public boolean rl() {
        return this.sv;
    }

    @Override // com.byazt.dh.ve
    public void tt(Map<String, Object> map) {
        this.tk = map;
    }

    public void uj(int i) {
        this.to = i;
    }

    @Override // com.byazt.dh.ve
    public void uj(boolean z) {
        this.sv = z;
    }

    @Override // com.byazt.nj.c, com.byazt.dh.ve
    public boolean uj() {
        return false;
    }

    @Override // com.byazt.dh.ve
    public boolean ve() {
        return false;
    }

    public void tt(ic icVar) {
        this.f2516a = icVar;
    }

    public void c(com.byazt.uz.c cVar) {
        if (this.n != null) {
            this.n.c(cVar);
        }
    }

    public void c(final NativeVideoTsView.c cVar) {
        if (!this.t || this.n == null) {
            return;
        }
        this.n.c(new NativeVideoTsView.c() { // from class: com.byazt.un.uj.3
            @Override // com.byazt.un.NativeVideoTsView.c
            public void c(View view, int i) {
                NativeVideoTsView.c cVar2 = cVar;
                if (cVar2 != null) {
                    cVar2.c(view, i);
                }
            }
        });
    }

    public void c(u uVar) {
        if (!this.t || this.n == null) {
            return;
        }
        this.n.c(uVar);
    }

    private void c(Context context) {
        EnumSet<com.byazt.dh.tt.c> enumSetNoneOf = EnumSet.noneOf(com.byazt.dh.tt.c.class);
        enumSetNoneOf.add(com.byazt.dh.tt.c.hideCloseBtn);
        enumSetNoneOf.add(com.byazt.dh.tt.c.hideBackBtn);
        try {
            this.n = c(context, enumSetNoneOf);
            if (this.n != null) {
                this.n.c((com.byazt.dh.c) this);
                this.n.c((com.byazt.ua.c.InterfaceC0286c) this);
            }
        } catch (Throwable th) {
            m.uj("NativeVideoController", th.getMessage());
        }
    }

    public a c(Context context, EnumSet<com.byazt.dh.tt.c> enumSet) {
        View layoutVideoDetail;
        if (this.t) {
            layoutVideoDetail = tt(context);
        } else {
            layoutVideoDetail = new LayoutVideoDetail(context);
        }
        View view = layoutVideoDetail;
        if (view == null) {
            return null;
        }
        if (this.t) {
            return new a(context, view, true, enumSet, this.f2516a, this, or(), null);
        }
        return new n(context, view, true, enumSet, this.f2516a, this, false);
    }

    private View tt(final Context context) {
        Resources resources = context.getResources();
        RelativeLayout relativeLayout = new RelativeLayout(context);
        relativeLayout.setId(2114387714);
        relativeLayout.setBackgroundColor(-16777216);
        RelativeLayout relativeLayout2 = new RelativeLayout(context);
        ViewGroup.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        relativeLayout2.setId(2114387900);
        relativeLayout2.setBackgroundColor(0);
        relativeLayout2.setGravity(17);
        relativeLayout2.setLayoutParams(layoutParams);
        relativeLayout.addView(relativeLayout2);
        ImageView imageView = new ImageView(context);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
        imageView.setId(2114387651);
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView.setLayoutParams(layoutParams2);
        relativeLayout2.addView(imageView);
        final TTProgressBar tTProgressBar = new TTProgressBar(context);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams((int) TypedValue.applyDimension(1, 60.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 60.0f, resources.getDisplayMetrics()));
        tTProgressBar.setId(2114387631);
        layoutParams3.addRule(13, -1);
        tTProgressBar.setLayoutParams(layoutParams3);
        z.c(context, "tt_normalscreen_loading", new com.byazt.qr.c<Bitmap>() { // from class: com.byazt.un.uj.4
            @Override // com.byazt.qr.c
            public void c(Bitmap bitmap) {
                tTProgressBar.setIndeterminateDrawable(com.byazt.vfu.n.c(context, new BitmapDrawable(context.getResources(), bitmap), 0, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DEMUXER_STALL, 0.5f, 0.5f));
            }
        }, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
        relativeLayout2.addView(tTProgressBar);
        View viewInflate = new com.byazt.wol.uj().inflate(context);
        viewInflate.setId(2114387688);
        viewInflate.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        relativeLayout.addView(viewInflate);
        ImageView imageView2 = new ImageView(context);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
        imageView2.setId(2114387626);
        layoutParams4.addRule(13, -1);
        imageView2.setScaleType(ImageView.ScaleType.CENTER);
        z.c(context, "tt_new_play_video", imageView2, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
        imageView2.setVisibility(8);
        imageView2.setLayoutParams(layoutParams4);
        relativeLayout.addView(imageView2);
        TTProgressBar tTProgressBar2 = new TTProgressBar(context, null, R.style.Widget.ProgressBar.Horizontal);
        tTProgressBar2.setIndeterminate(false);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-1, (int) TypedValue.applyDimension(1, 1.5f, resources.getDisplayMetrics()));
        tTProgressBar2.setMax(100);
        tTProgressBar2.setId(2114387653);
        tTProgressBar2.setBackgroundColor(0);
        tTProgressBar2.setIndeterminateDrawable(null);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#A5FFFFFF"));
        float fVe = pf.ve(context, 1.0f);
        gradientDrawable.setCornerRadius(fVe);
        int iVe = pf.ve(context, 2.0f);
        gradientDrawable.setSize(-1, iVe);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setColor(Color.parseColor("#FFFFFFFF"));
        gradientDrawable2.setCornerRadius(fVe);
        gradientDrawable2.setSize(-1, iVe);
        ClipDrawable clipDrawable = new ClipDrawable(gradientDrawable2, 3, 1);
        GradientDrawable gradientDrawable3 = new GradientDrawable();
        gradientDrawable3.setColor(Color.parseColor("#FFF85959"));
        gradientDrawable3.setCornerRadius(fVe);
        gradientDrawable3.setSize(-1, iVe);
        tTProgressBar2.setProgressDrawable(new LayerDrawable(new Drawable[]{gradientDrawable, clipDrawable, new ClipDrawable(gradientDrawable3, 3, 1)}));
        tTProgressBar2.setVisibility(8);
        layoutParams5.addRule(12, -1);
        tTProgressBar2.setLayoutParams(layoutParams5);
        relativeLayout.addView(tTProgressBar2);
        TTViewStub tTViewStub = new TTViewStub(context, new com.byazt.wol.a());
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(-1, -1);
        tTViewStub.setId(2114387744);
        tTViewStub.setLayoutParams(layoutParams6);
        relativeLayout.addView(tTViewStub);
        TTViewStub tTViewStub2 = new TTViewStub(context, new com.byazt.wol.tt());
        RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-1, -1);
        tTViewStub2.setId(2114387666);
        tTViewStub2.setLayoutParams(layoutParams7);
        relativeLayout.addView(tTViewStub2);
        TTViewStub tTViewStub3 = new TTViewStub(context, new com.byazt.wol.sp());
        RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams8.addRule(13, -1);
        tTViewStub3.setId(2114387828);
        tTViewStub3.setLayoutParams(layoutParams8);
        relativeLayout.addView(tTViewStub3);
        return relativeLayout;
    }

    public uj(Context context, ViewGroup viewGroup, ic icVar, String str, boolean z, boolean z2, boolean z3) {
        this.or = com.byazt.dyf.tt.AD_TAG_FEED;
        this.cu = false;
        this.qp = true;
        this.bm = 0;
        this.lr = 0;
        this.s = 1;
        this.s = rh.ve(context);
        c(z);
        this.or = str;
        try {
            this.bm = viewGroup.getWidth();
            this.lr = viewGroup.getHeight();
        } catch (Throwable unused) {
        }
        this.md = viewGroup;
        this.i = new WeakReference<>(context);
        this.f2516a = icVar;
        c(context);
        this.zb = true;
        this.cu = z2;
        this.qp = z3;
    }

    public uj(Context context, ViewGroup viewGroup, ic icVar, String str, boolean z, boolean z2) {
        this.or = com.byazt.dyf.tt.AD_TAG_FEED;
        this.cu = false;
        this.qp = true;
        this.bm = 0;
        this.lr = 0;
        this.s = 1;
        this.s = rh.ve(context);
        try {
            this.bm = viewGroup.getWidth();
            this.lr = viewGroup.getHeight();
        } catch (Throwable unused) {
        }
        this.md = viewGroup;
        this.or = str;
        this.i = new WeakReference<>(context);
        this.f2516a = icVar;
        c(context);
        this.zb = true;
        this.cu = z;
        this.qp = z2;
    }

    @Override // com.byazt.dh.ve
    public void c(com.byazt.dh.ve.uj ujVar) {
        this.ic = new WeakReference<>(ujVar);
    }

    @Override // com.byazt.dh.ve
    public boolean c(com.byazt.jzl.a aVar) {
        aVar.getUrl();
        if (TextUtils.isEmpty(aVar.getUrl())) {
            tt("url is null");
            m.uj("tag_video_play", "[video] play video stop , because no video info");
            return false;
        }
        this.qy = aVar;
        this.nu = aVar.isQuiet();
        this.sp = aVar.getCurrent();
        if (aVar.getCurrent() > 0) {
            this.sp = aVar.getCurrent();
            this.x = this.x > this.sp ? this.x : this.sp;
        }
        if (this.n != null) {
            this.n.c();
            if (this.os == 0) {
                this.n.sp();
            }
            this.n.ve(aVar.getWidth(), aVar.getHeight());
            this.n.ve(this.md);
            this.n.c(aVar.getWidth(), aVar.getHeight());
        }
        try {
            if (this.uj == null) {
                if (!ic()) {
                    tt("create video error");
                    return false;
                }
                this.uj.addIVideoPlayerCallback(this.v);
            }
            yv();
            this.d = 0L;
            ve(aVar);
            return true;
        } catch (Throwable th) {
            tt(th.getMessage());
            m.uj("tag_video_play", "[video] invoke NativeVideoController#playVideo cause exception :" + th.toString());
            return false;
        }
    }

    private boolean ic() {
        int i;
        com.byazt.fk.sp ujVar;
        ic icVar = this.f2516a;
        if (com.byazt.ic.c.tt(icVar)) {
            com.byazt.jr.tt ttVarGu = gu();
            if (ttVarGu != null) {
                int iSl = nb.sl(this.f2516a);
                this.zm = c("ad");
                this.uj = new com.byazt.kft.c(ttVarGu, com.byazt.ic.c.i(icVar), new com.byazt.ts.uj(String.valueOf(iSl), this.zm), xd.rh(icVar), c("assist"));
                i = 1;
            } else {
                if (this.v != null) {
                    this.v.onError(null, new com.byazt.jzl.ve(60008, 10005, "创建lottie播放器时，iRenderView为null, mediaLayout is null: " + (this.n == null)));
                }
                m.uj("tag_video_play", "[video] invoke NativeVideoController#playVideo error: iRenderView为null");
                return false;
            }
        } else if (com.byazt.ic.c.ve(icVar)) {
            com.byazt.jr.tt ttVarGu2 = gu();
            if (ttVarGu2 != null) {
                int iSl2 = nb.sl(this.f2516a);
                if (p.n() && this.qy.getPlayerType() == 1) {
                    ujVar = com.byazt.btt.tt.c().createTTVideoPlayer(gt.getContext(), String.valueOf(iSl2));
                } else {
                    this.zm = c("ad");
                    ujVar = new com.byazt.ts.uj(String.valueOf(iSl2), this.zm);
                }
                this.uj = new com.byazt.kft.tt(ujVar, com.byazt.ic.c.i(icVar), c("assist"), ttVarGu2);
                i = 2;
            } else {
                if (this.v != null) {
                    this.v.onError(null, new com.byazt.jzl.ve(60008, 10005, "创建Upie播放器时，iRenderView为null, mediaLayout is null: " + (this.n == null)));
                }
                m.uj("tag_video_play", "[video] invoke NativeVideoController#playVideo error: iRenderView为null");
                return false;
            }
        } else {
            int iSl3 = nb.sl(this.f2516a);
            if (com.byazt.ex.c.c(this.f2516a)) {
                this.uj = com.byazt.btt.tt.c().createTTLiveVideoPlayer(gt.getContext(), p(), (long) xd.sp(this.f2516a), gt.tt().gy(), null);
                i = 3;
            } else if (p.n() && this.qy.getPlayerType() == 1) {
                this.uj = com.byazt.btt.tt.c().createTTVideoPlayer(gt.getContext(), String.valueOf(iSl3));
                i = 4;
            } else {
                this.zm = c("ad");
                this.uj = new com.byazt.ts.uj(String.valueOf(iSl3), this.zm);
                i = 5;
            }
        }
        if (icVar != null) {
            com.byazt.rgb.ve.c(icVar, String.valueOf(nb.t(this.f2516a)), nb.sl(this.f2516a), i, this.f2516a.zm());
        }
        return true;
    }

    @Override // com.byazt.dh.ve
    public int z() {
        return com.byazt.vv.c.c(this.x, this.m);
    }

    private void ve(com.byazt.jzl.a aVar) {
        if (aVar == null) {
            tt("model is null");
            return;
        }
        if (this.uj != null) {
            if (this.f2516a != null) {
                aVar.setCodeId(String.valueOf(nb.t(this.f2516a)));
            }
            aVar.setScene(0);
            com.byazt.rgb.ve.tt(tx());
            this.uj.setDataSource(aVar);
        }
        this.h = System.currentTimeMillis();
        if (!TextUtils.isEmpty(aVar.getUrl())) {
            if (this.n != null) {
                this.n.n(8);
                this.n.n(0);
            }
            boolean zVe = nb.ve(this.f2516a);
            boolean zTt = this.n != null ? zb.tt(this.n.c, 50, 9) : true;
            Runnable runnable = new Runnable() { // from class: com.byazt.un.uj.5
                @Override // java.lang.Runnable
                public void run() {
                    uj.this.rl.c();
                    uj.this.nb();
                    uj.this.h = System.currentTimeMillis();
                    if (uj.this.n != null) {
                        uj.this.n.uj(0);
                    }
                    uj.this.kp = 1;
                    uj.this.b = false;
                    uj.this.q = false;
                    com.byazt.rgb.ve.c(uj.this.tx(), uj.this.kp);
                    uj.this.uj.start(true, uj.this.sp, uj.this.nu);
                }
            };
            if (zVe && !zTt) {
                tt(runnable);
                x(true);
                WeakReference<c> weakReference = this.hd;
                if (weakReference != null && weakReference.get() != null) {
                    this.hd.get().i();
                }
            } else {
                c(runnable);
            }
        } else {
            tt("url is null");
        }
        if (this.t) {
            sv();
        }
    }

    @Override // com.byazt.dh.ve
    public void c(com.byazt.dh.ve.tt ttVar) {
        this.nb = new WeakReference<>(ttVar);
    }

    @Override // com.byazt.nj.c, com.byazt.dh.ve
    public long t() {
        if (nu() == null) {
            return 0L;
        }
        return nu().getTotalBufferTime();
    }

    @Override // com.byazt.dh.ve
    public int u() {
        if (nu() == null) {
            return 0;
        }
        return nu().getBufferCount();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hd() {
        this.os++;
        if (md() && this.n != null) {
            this.n.tt();
            com.byazt.dh.ve.c cVar = this.eo;
            if (cVar != null) {
                cVar.c(this.d, com.byazt.vv.c.c(this.sp, this.m));
            }
            this.d = System.currentTimeMillis() - this.h;
            this.n.n(true);
            boolean zC = com.byazt.ex.c.c(this.f2516a);
            int iMm = this.f2516a.mm();
            boolean z = iMm <= 0;
            boolean z2 = !z && this.os >= iMm;
            boolean zVe = nb.ve(this.f2516a);
            if (!zVe || z2 || zC) {
                this.n.c2(this.f2516a, this.i, true);
            }
            if (!this.rl.c(64) || bm() || lr()) {
                this.rl.ve(64);
                tt(this.m, this.m);
                long j = this.m;
                this.sp = j;
                this.x = j;
                nu.c cVar2 = new nu.c();
                cVar2.c(sl());
                cVar2.ve(yp());
                cVar2.tt(t());
                cVar2.a(u());
                com.byazt.sw.uj.uj(this.n, cVar2);
            }
            if (!this.t && this.gt) {
                n(this.n, (View) null);
            }
            this.my = true;
            if (zC) {
                return;
            }
            if (zVe && (z || this.os < iMm)) {
                zm();
                return;
            }
            boolean z3 = yp() / 1000 < 10;
            if (t.c(this.f2516a) && z3 && this.os < 2) {
                zm();
            }
        }
    }

    @Override // com.byazt.dh.ve
    public void a() {
        if (this.uj != null) {
            this.uj.pause();
        }
        if ((!this.rl.c(64) || bm()) && this.rl.c(2)) {
            nu.c cVar = new nu.c();
            cVar.c(sl());
            cVar.ve(yp());
            cVar.tt(t());
            c(this.n, cVar);
        }
    }

    @Override // com.byazt.dh.ve
    public void c(Map<String, Object> map) {
        if (this.uj != null) {
            this.uj.pause();
        }
        if ((!this.rl.c(64) || bm()) && this.rl.c(2)) {
            nu.c cVar = new nu.c();
            cVar.c(sl());
            cVar.ve(yp());
            cVar.tt(t());
            if (map != null) {
                cVar.c(map);
            }
            c(this.n, cVar);
        }
    }

    private boolean bm() {
        return this.os > 0 && nb.ve(this.f2516a);
    }

    private boolean lr() {
        return this.os > 0 && t.c(this.f2516a);
    }

    @Override // com.byazt.dh.ve
    public void sp() {
        if (this.uj != null) {
            this.uj.pause();
        }
    }

    @Override // com.byazt.dh.ve
    public void x() {
        if (this.n != null) {
            this.n.c();
        }
        if (this.n != null) {
            this.n.gr();
        }
        lo();
    }

    public void a(boolean z) {
        if (this.n != null) {
            this.n.c();
        }
        if (this.n != null && z) {
            this.n.gr();
        }
        lo();
    }

    private boolean l() {
        return this.t && x.m().b() > 0;
    }

    private void lo() {
        m.c("NativeVideoController", "resumeVideo:  mIsSurfaceValid = ", Boolean.valueOf(this.da));
        if (this.uj != null) {
            if (this.uj.isPaused() && !l()) {
                if (this.da || ((this.qy != null && this.qy.isAudio()) || com.byazt.ic.c.tt(this.f2516a))) {
                    eo();
                } else {
                    tt(this.yv);
                }
                m.c("NativeVideoController", "resumeVideo: isPaused = true , mIsSurfaceValid = ", Boolean.valueOf(this.da));
            } else if (l()) {
                this.sp = x.m().b();
                x.m().c(-1L);
                this.uj.seekTo(this.sp);
                this.uj.play();
            } else {
                this.kp = 1;
                this.b = false;
                this.uj.start(false, this.sp, this.nu);
            }
        }
        if (this.rl.c(2)) {
            nu.c cVar = new nu.c();
            cVar.c(sl());
            cVar.ve(yp());
            cVar.tt(t());
            tt(rh(), cVar);
        }
    }

    @Override // com.byazt.dh.ve
    public void c(long j) {
        this.sp = j;
        this.x = this.x > this.sp ? this.x : this.sp;
        if (this.n != null) {
            this.n.c();
        }
        if (this.uj != null) {
            this.kp = 1;
            this.b = false;
            this.uj.start(true, this.sp, this.nu);
        }
    }

    @Override // com.byazt.dh.ve
    public void i() {
        c(true, 3);
    }

    @Override // com.byazt.dh.ve
    public void c(boolean z, int i) {
        if (this.t) {
            c(1);
        }
        long jYp = yp();
        if ((!this.rl.c(64) || bm()) && this.rl.c(1) && jYp > 0) {
            if (z) {
                nu.c cVar = new nu.c();
                cVar.c(sl());
                cVar.ve(jYp);
                cVar.tt(t());
                cVar.n(i);
                cVar.a(u());
                this.rl.ve(32);
                com.byazt.sw.uj.c(this.n, cVar, this.tk, !this.rl.c(2) ? 1 : 0);
            } else {
                nu.c cVar2 = new nu.c();
                cVar2.c(sl());
                cVar2.ve(jYp);
                cVar2.tt(t());
                c(this.n, cVar2);
            }
        }
        da();
    }

    @Override // com.byazt.dh.ve
    public void da() {
        tt(yp() == 0 ? -2 : -1);
        if (this.uj != null) {
            this.uj.release();
            this.uj = null;
        }
        int iMm = this.f2516a == null ? 2 : this.f2516a.mm();
        boolean z = iMm > 0 && this.os == iMm;
        if (!nb.ve(this.f2516a) || z) {
            try {
                this.n.c2(this.f2516a, this.i, true);
            } catch (Exception e) {
                m.uj("NativeVideoController", e.getMessage());
            }
        }
        if (this.c != null) {
            this.c.removeCallbacksAndMessages(null);
        }
        if (this.sl != null) {
            this.sl.clear();
        }
        aw();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pu() {
        if (!this.rl.c(2) || bm()) {
            nu.c cVar = new nu.c();
            if (lt()) {
                this.sv = true;
            }
            cVar.tt(this.sv);
            cVar.ve(yp());
            this.rl.ve(2);
            com.byazt.sw.uj.c(this.n, cVar);
        }
    }

    /* JADX WARN: Code duplicated, block: B:37:0x007f  */
    /* JADX WARN: Code duplicated, block: B:40:0x0086  */
    /* JADX WARN: Code duplicated, block: B:43:0x008d A[Catch: all -> 0x00f4, TryCatch #0 {all -> 0x00f4, blocks: (B:2:0x0000, B:4:0x0004, B:6:0x000c, B:8:0x0012, B:10:0x0016, B:16:0x0022, B:17:0x002e, B:38:0x0080, B:41:0x0087, B:43:0x008d, B:45:0x0091, B:47:0x00a3, B:54:0x00bc, B:56:0x00c2, B:58:0x00ca, B:60:0x00d7, B:61:0x00e0, B:48:0x00a9, B:50:0x00ad, B:51:0x00b3, B:53:0x00b7, B:30:0x0051, B:31:0x0062, B:33:0x0068, B:63:0x00e8, B:65:0x00ec, B:66:0x00f1), top: B:69:0x0000 }] */
    /* JADX WARN: Code duplicated, block: B:45:0x0091 A[Catch: all -> 0x00f4, TryCatch #0 {all -> 0x00f4, blocks: (B:2:0x0000, B:4:0x0004, B:6:0x000c, B:8:0x0012, B:10:0x0016, B:16:0x0022, B:17:0x002e, B:38:0x0080, B:41:0x0087, B:43:0x008d, B:45:0x0091, B:47:0x00a3, B:54:0x00bc, B:56:0x00c2, B:58:0x00ca, B:60:0x00d7, B:61:0x00e0, B:48:0x00a9, B:50:0x00ad, B:51:0x00b3, B:53:0x00b7, B:30:0x0051, B:31:0x0062, B:33:0x0068, B:63:0x00e8, B:65:0x00ec, B:66:0x00f1), top: B:69:0x0000 }] */
    /* JADX WARN: Code duplicated, block: B:47:0x00a3 A[Catch: all -> 0x00f4, TryCatch #0 {all -> 0x00f4, blocks: (B:2:0x0000, B:4:0x0004, B:6:0x000c, B:8:0x0012, B:10:0x0016, B:16:0x0022, B:17:0x002e, B:38:0x0080, B:41:0x0087, B:43:0x008d, B:45:0x0091, B:47:0x00a3, B:54:0x00bc, B:56:0x00c2, B:58:0x00ca, B:60:0x00d7, B:61:0x00e0, B:48:0x00a9, B:50:0x00ad, B:51:0x00b3, B:53:0x00b7, B:30:0x0051, B:31:0x0062, B:33:0x0068, B:63:0x00e8, B:65:0x00ec, B:66:0x00f1), top: B:69:0x0000 }] */
    /* JADX WARN: Code duplicated, block: B:48:0x00a9 A[Catch: all -> 0x00f4, TryCatch #0 {all -> 0x00f4, blocks: (B:2:0x0000, B:4:0x0004, B:6:0x000c, B:8:0x0012, B:10:0x0016, B:16:0x0022, B:17:0x002e, B:38:0x0080, B:41:0x0087, B:43:0x008d, B:45:0x0091, B:47:0x00a3, B:54:0x00bc, B:56:0x00c2, B:58:0x00ca, B:60:0x00d7, B:61:0x00e0, B:48:0x00a9, B:50:0x00ad, B:51:0x00b3, B:53:0x00b7, B:30:0x0051, B:31:0x0062, B:33:0x0068, B:63:0x00e8, B:65:0x00ec, B:66:0x00f1), top: B:69:0x0000 }] */
    /* JADX WARN: Code duplicated, block: B:50:0x00ad A[Catch: all -> 0x00f4, TryCatch #0 {all -> 0x00f4, blocks: (B:2:0x0000, B:4:0x0004, B:6:0x000c, B:8:0x0012, B:10:0x0016, B:16:0x0022, B:17:0x002e, B:38:0x0080, B:41:0x0087, B:43:0x008d, B:45:0x0091, B:47:0x00a3, B:54:0x00bc, B:56:0x00c2, B:58:0x00ca, B:60:0x00d7, B:61:0x00e0, B:48:0x00a9, B:50:0x00ad, B:51:0x00b3, B:53:0x00b7, B:30:0x0051, B:31:0x0062, B:33:0x0068, B:63:0x00e8, B:65:0x00ec, B:66:0x00f1), top: B:69:0x0000 }] */
    /* JADX WARN: Code duplicated, block: B:51:0x00b3 A[Catch: all -> 0x00f4, TryCatch #0 {all -> 0x00f4, blocks: (B:2:0x0000, B:4:0x0004, B:6:0x000c, B:8:0x0012, B:10:0x0016, B:16:0x0022, B:17:0x002e, B:38:0x0080, B:41:0x0087, B:43:0x008d, B:45:0x0091, B:47:0x00a3, B:54:0x00bc, B:56:0x00c2, B:58:0x00ca, B:60:0x00d7, B:61:0x00e0, B:48:0x00a9, B:50:0x00ad, B:51:0x00b3, B:53:0x00b7, B:30:0x0051, B:31:0x0062, B:33:0x0068, B:63:0x00e8, B:65:0x00ec, B:66:0x00f1), top: B:69:0x0000 }] */
    /* JADX WARN: Code duplicated, block: B:53:0x00b7 A[Catch: all -> 0x00f4, TryCatch #0 {all -> 0x00f4, blocks: (B:2:0x0000, B:4:0x0004, B:6:0x000c, B:8:0x0012, B:10:0x0016, B:16:0x0022, B:17:0x002e, B:38:0x0080, B:41:0x0087, B:43:0x008d, B:45:0x0091, B:47:0x00a3, B:54:0x00bc, B:56:0x00c2, B:58:0x00ca, B:60:0x00d7, B:61:0x00e0, B:48:0x00a9, B:50:0x00ad, B:51:0x00b3, B:53:0x00b7, B:30:0x0051, B:31:0x0062, B:33:0x0068, B:63:0x00e8, B:65:0x00ec, B:66:0x00f1), top: B:69:0x0000 }] */
    /* JADX WARN: Code duplicated, block: B:60:0x00d7 A[Catch: all -> 0x00f4, TryCatch #0 {all -> 0x00f4, blocks: (B:2:0x0000, B:4:0x0004, B:6:0x000c, B:8:0x0012, B:10:0x0016, B:16:0x0022, B:17:0x002e, B:38:0x0080, B:41:0x0087, B:43:0x008d, B:45:0x0091, B:47:0x00a3, B:54:0x00bc, B:56:0x00c2, B:58:0x00ca, B:60:0x00d7, B:61:0x00e0, B:48:0x00a9, B:50:0x00ad, B:51:0x00b3, B:53:0x00b7, B:30:0x0051, B:31:0x0062, B:33:0x0068, B:63:0x00e8, B:65:0x00ec, B:66:0x00f1), top: B:69:0x0000 }] */
    public void tt(int i, int i2) {
        ViewGroup viewGroup;
        int iRound;
        int iRound2;
        RelativeLayout.LayoutParams layoutParams;
        Object objGu;
        ViewGroup.LayoutParams layoutParams2;
        try {
            if (this.i != null && this.i.get() != null && gu() != null && this.uj != null && (viewGroup = this.md) != null && viewGroup != null) {
                if (i < 0 && i2 < 0) {
                    i = this.uj.getVideoWidth();
                    i2 = this.uj.getVideoHeight();
                }
                int width = this.md.getWidth();
                int height = this.md.getHeight();
                if (width > 0 && height > 0 && i2 > 0 && i > 0) {
                    if (i != i2) {
                        if (i > i2) {
                            iRound = (int) Math.round((((double) width) * 1.0d) / ((double) ((i * 1.0f) / i2)));
                            iRound2 = width;
                        } else if (to()) {
                            iRound = 0;
                        } else {
                            iRound2 = (int) Math.round(((double) (height * 1.0f)) / ((double) ((i2 * 1.0f) / i)));
                            iRound = height;
                        }
                        if (iRound <= height || iRound <= 0) {
                            iRound = height;
                        }
                        if (tt(i, i2, iRound2, width)) {
                            iRound2 = width;
                        }
                        if (to()) {
                            c(i, i2, width, height);
                            return;
                        }
                        layoutParams = new RelativeLayout.LayoutParams(iRound2, iRound);
                        layoutParams.addRule(13);
                        objGu = gu();
                        if (objGu instanceof TextureView) {
                            ((TextureView) objGu).setLayoutParams(layoutParams);
                        } else if (objGu instanceof UpieVideoView) {
                            ((UpieVideoView) objGu).setLayoutParams(layoutParams);
                        } else if (objGu instanceof SurfaceView) {
                            ((SurfaceView) objGu).setLayoutParams(layoutParams);
                        }
                        if (ve(i, i2) && (layoutParams2 = this.md.getLayoutParams()) != null) {
                            layoutParams2.height = iRound;
                            layoutParams2.width = iRound2;
                            this.md.setLayoutParams(layoutParams2);
                            if (this.n != null) {
                                this.n.c(layoutParams2.width, layoutParams2.height);
                            }
                        }
                        c(width, height, iRound2, iRound);
                        return;
                    }
                    iRound = width > height ? height : width;
                    iRound2 = iRound;
                    if (iRound <= height) {
                        iRound = height;
                    } else {
                        iRound = height;
                    }
                    if (tt(i, i2, iRound2, width)) {
                        iRound2 = width;
                    }
                    if (to()) {
                        c(i, i2, width, height);
                        return;
                    }
                    layoutParams = new RelativeLayout.LayoutParams(iRound2, iRound);
                    layoutParams.addRule(13);
                    objGu = gu();
                    if (objGu instanceof TextureView) {
                        ((TextureView) objGu).setLayoutParams(layoutParams);
                    } else if (objGu instanceof UpieVideoView) {
                        ((UpieVideoView) objGu).setLayoutParams(layoutParams);
                    } else if (objGu instanceof SurfaceView) {
                        ((SurfaceView) objGu).setLayoutParams(layoutParams);
                    }
                    if (ve(i, i2)) {
                        layoutParams2.height = iRound;
                        layoutParams2.width = iRound2;
                        this.md.setLayoutParams(layoutParams2);
                        if (this.n != null) {
                            this.n.c(layoutParams2.width, layoutParams2.height);
                        }
                    }
                    c(width, height, iRound2, iRound);
                    return;
                }
                return;
            }
            if (this.i != null) {
                this.i.get();
            }
            gu();
        } catch (Throwable unused) {
        }
    }

    private void c(float f, float f2, float f3, float f4) {
        boolean zDa;
        if (gt.tt().yp()) {
            WeakReference<c> weakReference = this.hd;
            View view = null;
            c cVar = weakReference != null ? weakReference.get() : null;
            if (cVar instanceof NativeVideoTsView) {
                NativeVideoTsView nativeVideoTsView = (NativeVideoTsView) cVar;
                zDa = nativeVideoTsView.da();
                Object parent = nativeVideoTsView.getParent();
                if (parent instanceof View) {
                    view = (View) parent;
                }
            } else {
                zDa = true;
            }
            View view2 = view;
            if (zDa) {
                yp.c().c(this.f2516a, f, f2, f3, f4, view2);
            }
        }
    }

    private void c(int i, int i2, int i3, int i4) {
        Matrix matrix;
        if (i3 == 0 || i4 == 0) {
            return;
        }
        float f = i3;
        float f2 = i;
        float f3 = f / f2;
        float f4 = i4;
        float f5 = i2;
        float f6 = f4 / f5;
        try {
            Object objGu = gu();
            if (objGu instanceof TextureView) {
                matrix = ((TextureView) objGu).getMatrix();
            } else if (objGu instanceof UpieVideoView) {
                matrix = ((UpieVideoView) objGu).getMatrix();
            } else {
                matrix = objGu instanceof SurfaceView ? ((SurfaceView) objGu).getMatrix() : null;
            }
            float fMax = Math.max(f3, f6);
            if (matrix == null) {
                matrix = new Matrix();
            } else {
                matrix.reset();
            }
            matrix.preTranslate((i3 - i) / 2, (i4 - i2) / 2);
            matrix.preScale(f2 / f, f5 / f4);
            matrix.postScale(fMax, fMax, i3 / 2, i4 / 2);
            if (objGu instanceof TextureView) {
                ((TextureView) objGu).setTransform(matrix);
                ((TextureView) objGu).postInvalidate();
                return;
            }
            if (objGu instanceof UpieVideoView) {
                LottieAnimationView lottieAnimationViewC = c((View) objGu);
                if (lottieAnimationViewC != null) {
                    lottieAnimationViewC.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    return;
                }
                return;
            }
            if (objGu instanceof SurfaceView) {
                if (Build.VERSION.SDK_INT >= 29) {
                    ((SurfaceView) objGu).setAnimationMatrix(matrix);
                }
                ((SurfaceView) objGu).postInvalidate();
            }
        } catch (Exception unused) {
        }
    }

    private LottieAnimationView c(View view) {
        LottieAnimationView lottieAnimationViewC;
        if (view instanceof LottieAnimationView) {
            return (LottieAnimationView) view;
        }
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof LottieAnimationView) {
                return (LottieAnimationView) childAt;
            }
            if ((childAt instanceof ViewGroup) && (lottieAnimationViewC = c(childAt)) != null) {
                return lottieAnimationViewC;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean lt() {
        return TextUtils.equals(this.or, "splash_ad") || TextUtils.equals(this.or, "cache_splash_ad");
    }

    private boolean to() {
        j jVarEk;
        if (lt()) {
            return this.f2516a == null || (jVarEk = this.f2516a.ek()) == null || jVarEk.c() != 0;
        }
        return false;
    }

    private boolean tt(int i, int i2, int i3, int i4) {
        return (i3 > i4 && !ve(i, i2)) || i3 <= 0;
    }

    private boolean ve(int i, int i2) {
        return i < i2 && tk();
    }

    private boolean tk() {
        return this.f2516a != null && this.f2516a.vi() == 1 && "draw_ad".equals(this.or) && this.md != null;
    }

    public com.byazt.jr.tt gu() {
        if (this.i == null || this.i.get() == null) {
            return null;
        }
        if ((this.i.get().getResources().getConfiguration().orientation == 1 || com.byazt.ic.c.c(this.f2516a)) && this.n != null) {
            return this.n.nu();
        }
        return null;
    }

    @Override // com.byazt.dh.c
    public void c(com.byazt.dh.tt ttVar, View view) {
        if (this.uj == null || !md()) {
            return;
        }
        if (this.uj.isPlaying()) {
            a();
            if (this.n != null) {
                this.n.tt(true, false);
                this.n.a();
                return;
            }
            return;
        }
        if (!this.uj.isPaused()) {
            if (this.n != null) {
                this.n.ve(this.md);
            }
            c(this.sp);
            if (this.n != null) {
                this.n.tt(false, false);
                return;
            }
            return;
        }
        a(false);
        if (this.n != null) {
            this.n.tt(false, false);
        }
    }

    @Override // com.byazt.dh.c
    public void c(com.byazt.dh.tt ttVar, int i) {
        if (this.uj == null) {
            return;
        }
        c(this.oz, a(i));
    }

    @Override // com.byazt.dh.c
    public void tt(com.byazt.dh.tt ttVar, int i) {
        if (this.n != null) {
            this.n.a();
        }
    }

    @Override // com.byazt.dh.c
    public void c(com.byazt.dh.tt ttVar, int i, boolean z) {
        if (md()) {
            long j = (long) (((((long) i) * this.m) * 1.0f) / 100.0f);
            if (this.m > 0) {
                this.oz = (int) j;
            } else {
                this.oz = 0L;
            }
            if (this.n != null) {
                this.n.c(this.oz);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tt(long j, long j2) {
        this.sp = j;
        this.m = j2;
        if (this.n != null) {
            this.n.c(j, j2);
            this.n.tt(com.byazt.vv.c.c(j, j2));
        }
        try {
            com.byazt.dh.ve.c cVar = this.eo;
            if (cVar != null) {
                cVar.c(j, j2);
            }
        } catch (Throwable th) {
            m.ve("NativeVideoController", "onProgressUpdate error: ", th);
        }
    }

    @Override // com.byazt.dh.c
    public void tt(com.byazt.dh.tt ttVar, View view) {
        tt(ttVar, view, false, false);
    }

    public void tt(com.byazt.dh.tt ttVar, View view, boolean z, boolean z2) {
        if (md()) {
            i(!this.gt);
            if (this.i.get() instanceof Activity) {
                if (this.gt) {
                    n(z ? 8 : 0);
                    if (this.n != null) {
                        this.n.c(this.md);
                        this.n.ve(false);
                    }
                } else {
                    n(1);
                    if (this.n != null) {
                        this.n.tt(this.md);
                        this.n.ve(false);
                    }
                }
                WeakReference<com.byazt.dh.ve.tt> weakReference = this.nb;
                com.byazt.dh.ve.tt ttVar2 = weakReference != null ? weakReference.get() : null;
                if (ttVar2 != null) {
                    ttVar2.c(this.gt);
                }
            }
        }
    }

    public void n(int i) {
        if (md()) {
            boolean z = i == 0 || i == 8;
            Context context = this.i.get();
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                try {
                    activity.setRequestedOrientation(i);
                } catch (Throwable unused) {
                }
                if (!z) {
                    activity.getWindow().setFlags(1024, 1024);
                } else {
                    activity.getWindow().clearFlags(1024);
                }
            }
        }
    }

    @Override // com.byazt.dh.c
    public void ve(com.byazt.dh.tt ttVar, View view) {
        if (this.n != null) {
            this.n.i();
        }
        c(1);
        c(true, 3);
    }

    @Override // com.byazt.dh.c
    public void c(com.byazt.dh.tt ttVar, View view, boolean z, boolean z2) {
        if (this.t) {
            a();
        }
        if (this.n == null) {
            return;
        }
        if (z && !this.t && !gr()) {
            this.n.tt(!bx(), false);
            this.n.c(z2, true, false);
        }
        if (this.uj != null && this.uj.isPlaying()) {
            this.n.a();
            this.n.n();
        } else {
            this.n.a();
        }
    }

    @Override // com.byazt.dh.c
    public void uj(com.byazt.dh.tt ttVar, View view) {
        if (this.gt) {
            i(false);
            if (this.n != null) {
                this.n.tt(this.md);
            }
            n(1);
            return;
        }
        c(1);
        c(true, 3);
    }

    @Override // com.byazt.dh.c
    public void n(com.byazt.dh.tt ttVar, View view) {
        c(ttVar, view, false);
    }

    public void c(com.byazt.dh.tt ttVar, View view, boolean z) {
        kp();
    }

    private void kp() {
        if (md()) {
            i(!this.gt);
            if (this.i.get() instanceof Activity) {
                if (this.n != null) {
                    this.n.tt(this.md);
                    this.n.ve(false);
                }
                n(1);
                WeakReference<com.byazt.dh.ve.tt> weakReference = this.nb;
                com.byazt.dh.ve.tt ttVar = weakReference != null ? weakReference.get() : null;
                if (ttVar != null) {
                    ttVar.c(this.gt);
                }
            }
        }
    }

    public boolean gr() {
        return this.uj == null || this.uj.isCompleted();
    }

    public void zm() {
        if (rh.ve(gt.getContext()) == 0) {
            return;
        }
        if (this.n != null) {
            this.n.c();
        }
        ve(false);
        if (this.uj != null) {
            this.rl.c();
            nb();
            this.kp = 2;
            this.b = false;
            this.uj.restart();
            pu();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (!this.aw || this.n == null || this.n.ve() == null) {
            return;
        }
        this.aw = false;
        this.n.ve().post(new Runnable() { // from class: com.byazt.un.uj.7
            @Override // java.lang.Runnable
            public void run() {
                if (uj.this.qy == null) {
                    return;
                }
                uj.this.qy.setCid(uj.this.f2516a.uj());
                uj.this.qy.setWidth(uj.this.bm);
                uj.this.qy.setHeight(uj.this.lr);
                uj.this.qy.setPlayTrackUrls(null);
                uj.this.qy.setLogExtra(uj.this.f2516a.w_());
                uj.this.qy.setCurrent(0L);
                uj.this.qy.setQuiet(uj.this.my());
                uj.this.qy.setCacheParentDir(uj.this.qy.getCacheParentDir());
                uj ujVar = uj.this;
                ujVar.c(ujVar.qy);
                uj.this.ve(false);
            }
        });
    }

    @Override // com.byazt.dh.c
    public void c() {
        if (rh.ve(gt.getContext()) == 0) {
            return;
        }
        this.aw = true;
        if (this.uj == null) {
            da();
            b();
        } else {
            da();
        }
    }

    public boolean bx() {
        return this.uj != null && this.uj.isPlaying();
    }

    private void c(long j, boolean z) {
        if (this.uj == null) {
            return;
        }
        if (z) {
            q();
        }
        this.uj.seekTo(j);
    }

    private boolean a(int i) {
        return this.n != null && this.n.ve(i);
    }

    private void q() {
        if (this.n != null) {
            this.n.uj(0);
            this.n.c(false, false);
            this.n.ve(false);
            this.n.n();
            this.n.sp();
        }
    }

    /* JADX INFO: renamed from: com.byazt.un.uj$2, reason: invalid class name */
    @com.byazt.zqa.c(c = {0, 1, 96, 97})
    static /* synthetic */ class AnonymousClass2 {
        public static final /* synthetic */ int[] c;

        static {
            int[] iArr = new int[com.byazt.sgn.z.c.values().length];
            c = iArr;
            try {
                iArr[com.byazt.sgn.z.c.PAUSE_VIDEO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                c[com.byazt.sgn.z.c.RELEASE_VIDEO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                c[com.byazt.sgn.z.c.START_VIDEO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    @Override // com.byazt.un.tt
    public void c(com.byazt.sgn.z.c cVar, String str) {
        int i = AnonymousClass2.c[cVar.ordinal()];
        if (i == 1) {
            a();
            return;
        }
        if (i == 2) {
            c(true, 3);
        } else {
            if (i != 3) {
                return;
            }
            x();
            this.z = false;
            this.pf = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean sp(int i) {
        int iVe = rh.ve(gt.getContext());
        if (iVe == 0) {
            a();
            this.z = true;
            if (this.n != null) {
                this.n.c2(this.f2516a, this.i, false);
            }
        }
        if (iVe != 4 && iVe != 0) {
            if (this.n != null) {
                this.n.c();
            }
            a();
            this.z = true;
            this.pf = false;
            if (this.n != null && this.f2516a != null) {
                return this.n.c(i, xd.z(this.f2516a), this.qp);
            }
        } else if (iVe == 4) {
            this.z = false;
            if (this.n != null) {
                this.n.gt();
            }
        }
        return true;
    }

    private void tt(Context context, int i) {
        if (!md() || context == null || this.s == i) {
            return;
        }
        this.s = i;
        if (i != 4 && i != 0) {
            this.pf = false;
        }
        if (!this.pf && !gt() && this.cu) {
            da.tt().post(new Runnable() { // from class: com.byazt.un.uj.9
                @Override // java.lang.Runnable
                public void run() {
                    uj.this.sp(2);
                }
            });
        }
        WeakReference<c> weakReference = this.hd;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.hd.get().c(this.s);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ve(Context context, int i) {
        tt(context, i);
        if (i == 4) {
            this.z = false;
        }
    }

    public void c(Context context, int i) {
        tt(context, i);
        if (i == 4) {
            this.z = false;
            da.tt().post(new Runnable() { // from class: com.byazt.un.uj.10
                @Override // java.lang.Runnable
                public void run() {
                    uj.this.x();
                }
            });
        }
    }

    public void sv() {
        if (this.y || !this.pu) {
            return;
        }
        this.y = true;
        ((com.byazt.dna.u) com.byazt.ut.uj.getService("device_info_new")).registerNetworkMonitor(this.r);
    }

    public void aw() {
        if (this.y) {
            this.y = false;
            try {
                ((com.byazt.dna.u) com.byazt.ut.uj.getService("device_info_new")).removeNetworkMonitor(this.r);
            } catch (Throwable unused) {
            }
        }
    }

    public void c(c cVar) {
        this.hd = new WeakReference<>(cVar);
    }

    @Override // com.byazt.dh.ve
    public void tt(com.byazt.jzl.a aVar) {
        this.qy = aVar;
    }

    @Override // com.byazt.nj.c
    public void nb() {
        if (this.i == null) {
            return;
        }
        this.gr = com.byazt.sw.uj.c();
        if (this.zm != null) {
            this.zm.tt(this.gr);
        }
        this.rl.ve(1);
        com.byazt.sw.uj.c(this.f2516a, this.n, this.qy, this.sv, this.gr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kk() {
        if (com.byazt.ex.c.c(this.f2516a) && !TextUtils.isEmpty(this.or)) {
            boolean zC = this.rl.c(1024);
            long jLongValue = this.rl.tt(1).longValue();
            if (zC) {
                return;
            }
            this.rl.ve(1024);
            if (this.or.equals(com.byazt.dyf.tt.AD_TAG_FEED)) {
                com.byazt.ddx.uj.c(this.f2516a, com.byazt.dyf.tt.AD_TAG_FEED, System.currentTimeMillis() - jLongValue, com.byazt.sw.uj.c(this.n));
            } else if (this.or.equals("draw_ad")) {
                com.byazt.ddx.uj.c(this.f2516a, "draw_ad", System.currentTimeMillis() - jLongValue, com.byazt.sw.uj.c(this.n));
            }
        }
    }

    @Override // com.byazt.dh.ve
    public void c(int i) {
        if (com.byazt.ex.c.c(this.f2516a)) {
            if (this.lt <= 0) {
                this.lt = System.currentTimeMillis();
            }
            long jCurrentTimeMillis = System.currentTimeMillis() - this.lt;
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("close_reason", Integer.valueOf(i));
                jSONObject.putOpt("buffer_count", Integer.valueOf(u()));
                jSONObject.putOpt("buffer_time", Long.valueOf(t()));
            } catch (Exception e) {
                m.c(e);
            }
            if (!this.rl.c(512)) {
                this.rl.ve(512);
                if (this.or.equals(com.byazt.dyf.tt.AD_TAG_FEED)) {
                    com.byazt.ddx.uj.c(this.f2516a, com.byazt.dyf.tt.AD_TAG_FEED, jCurrentTimeMillis, jSONObject, com.byazt.sw.uj.c(this.n));
                } else if (this.or.equals("draw_ad")) {
                    com.byazt.ddx.uj.c(this.f2516a, "draw_ad", jCurrentTimeMillis, jSONObject, com.byazt.sw.uj.c(this.n));
                }
            }
            if (com.byazt.ex.c.c(this.f2516a)) {
                if (com.byazt.apd.tt.c().c(this.f2516a)) {
                    com.byazt.apd.tt.c().c(LiveMetrics.EVENT_LIVESDK_LIVE_WINDOW_DURATION_V2, this.f2516a, jCurrentTimeMillis);
                } else {
                    com.byazt.ex.c.c(LiveMetrics.EVENT_LIVESDK_LIVE_WINDOW_DURATION_V2, this.f2516a, jCurrentTimeMillis);
                }
            }
        }
    }

    @Override // com.byazt.dh.ve
    public void tt() {
        if (this.uj != null) {
            ve(false);
            this.kp = 2;
            this.b = false;
            this.uj.restart();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i, String str) {
        if (com.byazt.ex.c.c(this.f2516a)) {
            if (this.or.equals(com.byazt.dyf.tt.AD_TAG_FEED)) {
                com.byazt.ddx.uj.c(this.f2516a, com.byazt.dyf.tt.AD_TAG_FEED, i, str, com.byazt.sw.uj.c(this.n));
            } else if (this.or.equals("draw_ad")) {
                com.byazt.ddx.uj.c(this.f2516a, "draw_ad", i, str, com.byazt.sw.uj.c(this.n));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String tx() {
        if (this.f2516a == null) {
            return null;
        }
        return this.f2516a.zm();
    }

    public void finalize() throws Throwable {
        super.finalize();
        com.byazt.rgb.ve.ve(tx(), 3);
    }
}
