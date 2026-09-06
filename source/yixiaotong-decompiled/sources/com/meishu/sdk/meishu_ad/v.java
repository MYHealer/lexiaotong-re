package com.meishu.sdk.meishu_ad;

import android.animation.Animator;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.renderscript.RenderScript;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.gson.Gson;
import com.meishu.sdk.R;
import com.meishu.sdk.core.AdSdk;
import com.meishu.sdk.core.ad.AdType;
import com.meishu.sdk.core.ad.BaseAdSlot;
import com.meishu.sdk.core.ad.reward.RewardVideoLoader;
import com.meishu.sdk.core.ad.splash.SplashAdLoader;
import com.meishu.sdk.core.exception.ErrorCodeUtil;
import com.meishu.sdk.core.utils.LogUtil;
import com.meishu.sdk.core.utils.PackageBean;
import com.meishu.sdk.core.utils.SdkHandler;
import com.meishu.sdk.core.utils.d1;
import com.meishu.sdk.core.utils.h1;
import com.meishu.sdk.core.utils.i1;
import com.meishu.sdk.core.utils.j1;
import com.meishu.sdk.core.utils.k1;
import com.meishu.sdk.core.utils.o1;
import com.meishu.sdk.core.utils.q0;
import com.meishu.sdk.core.view.DownloadView;
import com.meishu.sdk.core.view.SwipeView;
import com.meishu.sdk.core.view.TouchAdContainer;
import com.meishu.sdk.core.view.TouchPositionListener;
import com.meishu.sdk.core.view.gif.GifImageView;
import com.meishu.sdk.meishu_ad.nativ.NormalMediaView;
import com.meishu.sdk.meishu_ad.splash.MeishuSplashRootView;
import com.meishu.sdk.meishu_ad.splash.SplashSkipView;
import com.qq.e.comm.pi.IReward;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Timer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import okhttp3.OkHttpClient;

/* JADX INFO: compiled from: AdNative.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class v {
    public static Handler C = new Handler();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f5096a;
    public int b;
    public String[] d;
    public int f;
    public boolean g;
    public boolean h;
    public boolean j;
    public volatile boolean k;
    public long l;
    public int m;
    public long n;
    public long o;
    public long p;
    public MeishuSplashRootView q;
    public GifImageView r;
    public boolean s;
    public byte[] t;
    public byte[] x;
    public int c = 1;
    public List<Animator> e = new ArrayList();
    public boolean i = false;
    public volatile int u = 0;
    public volatile int v = 0;
    public volatile int w = 0;
    public volatile boolean y = false;
    public volatile boolean z = false;
    public int A = 1;
    public final com.meishu.sdk.meishu_ad.splash.l B = new com.meishu.sdk.meishu_ad.splash.l();

    /* JADX INFO: compiled from: AdNative.java */
    public class a extends com.meishu.sdk.core.safe.l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SplashSkipView f5097a;
        public final /* synthetic */ com.meishu.sdk.meishu_ad.splash.c b;
        public final /* synthetic */ com.meishu.sdk.meishu_ad.splash.a c;
        public final /* synthetic */ View d;
        public final /* synthetic */ boolean e;
        public final /* synthetic */ MeishuSplashRootView f;

        /* JADX INFO: renamed from: com.meishu.sdk.meishu_ad.v$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: AdNative.java */
        public class C0827a implements SplashSkipView.b {
            public C0827a() {
            }

            @Override // com.meishu.sdk.meishu_ad.splash.SplashSkipView.b
            public void onSkip() {
                LogUtil.d("AdNative", "onSkip: ");
                Handler handler = v.C;
                if (handler != null) {
                    handler.removeCallbacksAndMessages(null);
                }
                try {
                    a.this.b.b.getAppendInfo().setHasClickedSkip(true);
                } catch (Exception unused) {
                }
                v.a(v.this);
                com.meishu.sdk.meishu_ad.splash.a aVar = a.this.c;
                if (aVar != null) {
                    com.meishu.sdk.platform.ms.splash.g gVar = (com.meishu.sdk.platform.ms.splash.g) aVar;
                    gVar.getClass();
                    SdkHandler.getInstance().runOnUiThread(new com.meishu.sdk.platform.ms.splash.h(gVar));
                    ((com.meishu.sdk.platform.ms.splash.g) a.this.c).b();
                }
            }

            @Override // com.meishu.sdk.meishu_ad.splash.SplashSkipView.b
            public void onTick(long j) {
                View view;
                com.meishu.sdk.meishu_ad.splash.a aVar = a.this.c;
                if (aVar != null) {
                    com.meishu.sdk.platform.ms.splash.g gVar = (com.meishu.sdk.platform.ms.splash.g) aVar;
                    gVar.getClass();
                    SdkHandler.getInstance().runOnUiThread(new com.meishu.sdk.platform.ms.splash.j(gVar, j));
                }
                if (((long) a.this.f5097a.getTotalTime()) - j <= a.this.f5097a.getShowTime() || (view = a.this.d) == null) {
                    return;
                }
                view.setVisibility(0);
            }

            @Override // com.meishu.sdk.meishu_ad.splash.SplashSkipView.b
            public void onTimeOver() {
                LogUtil.d("AdNative", "onTimeOver: ");
                Handler handler = v.C;
                if (handler != null) {
                    handler.removeCallbacksAndMessages(null);
                }
                try {
                    a.this.b.b.getAppendInfo().setHasTimeOver(true);
                } catch (Exception unused) {
                }
                v.a(v.this);
                com.meishu.sdk.meishu_ad.splash.a aVar = a.this.c;
                if (aVar != null) {
                    com.meishu.sdk.platform.ms.splash.g gVar = (com.meishu.sdk.platform.ms.splash.g) aVar;
                    gVar.getClass();
                    SdkHandler.getInstance().runOnUiThread(new com.meishu.sdk.platform.ms.splash.i(gVar));
                    ((com.meishu.sdk.platform.ms.splash.g) a.this.c).b();
                }
            }
        }

        /* JADX INFO: compiled from: AdNative.java */
        public class b extends com.meishu.sdk.core.safe.o {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ SplashSkipView.b f5099a;

            public b(a aVar, SplashSkipView.b bVar) {
                this.f5099a = bVar;
            }

            @Override // com.meishu.sdk.core.safe.o
            public void safeOnClick(View view) {
                this.f5099a.onSkip();
            }
        }

        public a(SplashSkipView splashSkipView, com.meishu.sdk.meishu_ad.splash.c cVar, com.meishu.sdk.meishu_ad.splash.a aVar, View view, boolean z, MeishuSplashRootView meishuSplashRootView) {
            this.f5097a = splashSkipView;
            this.b = cVar;
            this.c = aVar;
            this.d = view;
            this.e = z;
            this.f = meishuSplashRootView;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.meishu.sdk.core.safe.l
        public void safeRun() {
            try {
                this.f5097a.setTotalTime((int) AdSdk.adConfig().getSplashShowTime());
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.f5097a.setShow(!((SplashAdLoader) this.b.f5082a.getAdLoader()).getIsHideSkipBtn());
            C0827a c0827a = new C0827a();
            this.f5097a.setOnSkipListener(c0827a);
            View view = this.d;
            if (view != null) {
                view.setOnClickListener(new b(this, c0827a));
                this.f5097a.setShow(false);
            }
            if (this.e) {
                v.a(v.this, this.b, this.f, this.c, this.f5097a);
            }
        }
    }

    /* JADX INFO: compiled from: AdNative.java */
    public class b implements com.meishu.sdk.meishu_ad.splash.c.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.meishu.sdk.meishu_ad.splash.c f5100a;
        public final /* synthetic */ com.meishu.sdk.meishu_ad.splash.d b;
        public final /* synthetic */ com.meishu.sdk.meishu_ad.splash.a c;
        public final /* synthetic */ com.meishu.sdk.platform.ms.splash.a d;
        public final /* synthetic */ View e;
        public final /* synthetic */ boolean f;

        public b(com.meishu.sdk.meishu_ad.splash.c cVar, com.meishu.sdk.meishu_ad.splash.d dVar, com.meishu.sdk.meishu_ad.splash.a aVar, com.meishu.sdk.platform.ms.splash.a aVar2, View view, boolean z) {
            this.f5100a = cVar;
            this.b = dVar;
            this.c = aVar;
            this.d = aVar2;
            this.e = view;
            this.f = z;
        }

        @Override // com.meishu.sdk.meishu_ad.splash.c.b
        public void a(ViewGroup viewGroup) {
            NormalMediaView normalMediaView;
            try {
                v.this.j = true;
                v.a(v.this, this.f5100a, this.b, this.c);
                v vVar = v.this;
                com.meishu.sdk.meishu_ad.splash.c cVar = this.f5100a;
                com.meishu.sdk.meishu_ad.splash.a aVar = this.c;
                com.meishu.sdk.meishu_ad.splash.d dVar = this.b;
                vVar.getClass();
                if (cVar.b.getAdPatternType() != 2) {
                    new Timer().schedule(new h0(vVar, aVar, dVar), 5000L);
                }
                v vVar2 = v.this;
                if (vVar2.f != 1) {
                    vVar2.a(this.f5100a, this.b, this.c, this.d, this.e, this.f, viewGroup);
                } else {
                    vVar2.g = true;
                    v vVar3 = v.this;
                    if (vVar3.h) {
                        vVar3.a(this.f5100a, this.c);
                        if (this.b.getAdPatternType() == 2 && (normalMediaView = this.f5100a.d) != null) {
                            normalMediaView.start();
                        }
                    }
                }
                try {
                    PackageBean.AdBean adBean = q0.m;
                    if (adBean == null || adBean.getSplash() == null || q0.m.getSplash().getIc() != 1) {
                        return;
                    }
                    v.this.a(this.f5100a, this.c);
                } catch (Exception unused) {
                }
            } catch (Throwable th) {
                th.printStackTrace();
                v.this.a(this.c, "show渲染错误", Integer.valueOf(ErrorCodeUtil.RENDER_AD_EXCEPTION));
            }
        }
    }

    /* JADX INFO: compiled from: AdNative.java */
    public class c implements com.meishu.sdk.meishu_ad.reward.i.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.meishu.sdk.meishu_ad.nativ.d f5101a;
        public final /* synthetic */ com.meishu.sdk.core.webview.s[] b;
        public final /* synthetic */ com.meishu.sdk.meishu_ad.nativ.a c;
        public final /* synthetic */ int d;
        public final /* synthetic */ ArrayList e;

        public c(com.meishu.sdk.meishu_ad.nativ.d dVar, com.meishu.sdk.core.webview.s[] sVarArr, com.meishu.sdk.meishu_ad.nativ.a aVar, int i, ArrayList arrayList) {
            this.f5101a = dVar;
            this.b = sVarArr;
            this.c = aVar;
            this.d = i;
            this.e = arrayList;
        }
    }

    /* JADX INFO: compiled from: AdNative.java */
    public class d extends com.meishu.sdk.core.webview.i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.meishu.sdk.meishu_ad.reward.i f5102a;

        public d(v vVar, com.meishu.sdk.meishu_ad.reward.i iVar) {
            this.f5102a = iVar;
        }

        @Override // com.meishu.sdk.core.webview.listener.c
        public void a(boolean z) {
        }

        @Override // com.meishu.sdk.core.webview.listener.g
        public boolean onPageFinished(String str, boolean z, boolean z2, int i) {
            LogUtil.dev("AdNative", "final h5 res:" + z2);
            this.f5102a.d(z2);
            return false;
        }
    }

    /* JADX INFO: compiled from: AdNative.java */
    public class e extends com.meishu.sdk.core.safe.l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.meishu.sdk.meishu_ad.reward.i f5103a;

        public e(v vVar, com.meishu.sdk.meishu_ad.reward.i iVar) {
            this.f5103a = iVar;
        }

        @Override // com.meishu.sdk.core.safe.l
        public void safeRun() {
            this.f5103a.b(false);
        }
    }

    /* JADX INFO: compiled from: AdNative.java */
    public class f implements com.meishu.sdk.core.utils.z.i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ NormalMediaView f5104a;
        public final /* synthetic */ com.meishu.sdk.meishu_ad.nativ.f b;
        public final /* synthetic */ com.meishu.sdk.core.ad.b c;
        public final /* synthetic */ com.meishu.sdk.meishu_ad.reward.i d;

        /* JADX INFO: compiled from: AdNative.java */
        public class a implements NormalMediaView.d {
            public a() {
            }
        }

        public f(NormalMediaView normalMediaView, com.meishu.sdk.meishu_ad.nativ.f fVar, com.meishu.sdk.core.ad.b bVar, com.meishu.sdk.meishu_ad.reward.i iVar) {
            this.f5104a = normalMediaView;
            this.b = fVar;
            this.c = bVar;
            this.d = iVar;
        }

        @Override // com.meishu.sdk.core.utils.z.i
        public void a() {
            this.d.b(false);
        }

        @Override // com.meishu.sdk.core.utils.z.i
        public void success() {
            this.f5104a.setVideoPath(this.b.g);
            this.f5104a.setPlayOnce(true);
            this.f5104a.setFromLogoVisibility(8);
            this.f5104a.setUseTransform(false);
            if (this.c.getVideoIsMute()) {
                this.f5104a.g();
            }
            this.f5104a.setOnPreparedListener(new a());
        }
    }

    /* JADX INFO: compiled from: AdNative.java */
    public class g implements com.meishu.sdk.core.utils.z.i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ NormalMediaView f5106a;
        public final /* synthetic */ com.meishu.sdk.meishu_ad.nativ.a b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ com.meishu.sdk.meishu_ad.nativ.f d;
        public final /* synthetic */ boolean e;
        public final /* synthetic */ float f;
        public final /* synthetic */ float g;
        public final /* synthetic */ boolean h;
        public final /* synthetic */ List i;

        /* JADX INFO: compiled from: AdNative.java */
        public class a implements com.meishu.sdk.core.utils.z.i {
            public a() {
            }

            @Override // com.meishu.sdk.core.utils.z.i
            public void a() {
                g gVar = g.this;
                v vVar = v.this;
                com.meishu.sdk.meishu_ad.nativ.a aVar = gVar.b;
                Integer num = ErrorCodeUtil.RES_LOAD_ERROR;
                Handler handler = v.C;
                vVar.a(aVar, "视频资源错误", num);
            }

            @Override // com.meishu.sdk.core.utils.z.i
            public void success() {
                v.this.p = System.currentTimeMillis();
                g gVar = g.this;
                if (gVar.c) {
                    com.meishu.sdk.meishu_ad.nativ.f fVar = gVar.d;
                    fVar.setMonitorUrl(com.meishu.sdk.core.utils.h0.b(fVar.getMonitorUrl(), v.this.a()));
                }
                com.meishu.sdk.meishu_ad.nativ.f fVar2 = g.this.d;
                fVar2.adPatternType = 1;
                fVar2.getImageUrls()[0] = g.this.d.getVideo_cover();
                com.meishu.sdk.core.utils.h0.b(g.this.d.getMonitorUrl());
                g gVar2 = g.this;
                v.a(gVar2.d, gVar2.b, gVar2.h, gVar2.f5106a, gVar2.i);
            }
        }

        public g(NormalMediaView normalMediaView, com.meishu.sdk.meishu_ad.nativ.a aVar, boolean z, com.meishu.sdk.meishu_ad.nativ.f fVar, boolean z2, float f, float f2, boolean z3, List list) {
            this.f5106a = normalMediaView;
            this.b = aVar;
            this.c = z;
            this.d = fVar;
            this.e = z2;
            this.f = f;
            this.g = f2;
            this.h = z3;
            this.i = list;
        }

        @Override // com.meishu.sdk.core.utils.z.i
        public void a() {
            v.this.o = System.currentTimeMillis();
            if (TextUtils.isEmpty(this.d.getVideo_cover()) || !this.c) {
                v.this.a(this.b, "视频资源错误", ErrorCodeUtil.RES_LOAD_ERROR);
            } else {
                com.meishu.sdk.core.utils.z.a(this.d.getVideo_cover(), new a());
            }
        }

        @Override // com.meishu.sdk.core.utils.z.i
        public void success() {
            NormalMediaView normalMediaView = this.f5106a;
            com.meishu.sdk.meishu_ad.nativ.a aVar = this.b;
            boolean z = this.c;
            normalMediaView.E = aVar;
            normalMediaView.F = z;
            normalMediaView.setRecycler(z);
            if (this.c) {
                this.f5106a.setConfigWidth(this.d.f5047a);
                this.f5106a.setConfigHeight(this.d.b);
                this.f5106a.setVideoEndCover(this.d.h);
                this.f5106a.setInitMute(true);
                this.f5106a.setVideoCover(this.d.getVideo_cover());
                this.f5106a.setVideoEndCover(this.d.h);
                this.f5106a.setFromLogoVisibility(8);
                this.f5106a.setUseTransform(false);
                this.f5106a.setAutoStart(this.e);
                this.f5106a.setContainerWidth(this.f);
                this.f5106a.setContainerHeight(this.g);
            } else {
                this.f5106a.setVideoPath(this.d.g);
                this.f5106a.setVideoCover(this.d.getVideo_cover());
                this.f5106a.setVideoEndCover(this.d.h);
                this.f5106a.setPlayOnce(true);
                this.f5106a.setUseTransform(false);
                this.f5106a.setContainerWidth(this.f);
                this.f5106a.setContainerHeight(this.g);
                if (AdSdk.adConfig().showLogo()) {
                    this.f5106a.setFromLogo(this.d.getFromLogo());
                } else {
                    this.f5106a.setFromLogo(null);
                    this.f5106a.setFromLogoVisibility(8);
                }
            }
            v.a(this.d, this.b, this.h, this.f5106a, this.i);
        }
    }

    /* JADX INFO: compiled from: AdNative.java */
    public class h implements com.meishu.sdk.core.utils.z.i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.meishu.sdk.meishu_ad.nativ.f f5108a;
        public final /* synthetic */ com.meishu.sdk.meishu_ad.nativ.a b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ NormalMediaView d;
        public final /* synthetic */ List e;

        public h(com.meishu.sdk.meishu_ad.nativ.f fVar, com.meishu.sdk.meishu_ad.nativ.a aVar, boolean z, NormalMediaView normalMediaView, List list) {
            this.f5108a = fVar;
            this.b = aVar;
            this.c = z;
            this.d = normalMediaView;
            this.e = list;
        }

        @Override // com.meishu.sdk.core.utils.z.i
        public void a() {
            v.this.a(this.b, "视频资源错误", ErrorCodeUtil.RES_LOAD_ERROR);
        }

        @Override // com.meishu.sdk.core.utils.z.i
        public void success() {
            v.a(this.f5108a, this.b, this.c, this.d, this.e);
        }
    }

    /* JADX INFO: compiled from: AdNative.java */
    public class i extends com.meishu.sdk.core.safe.l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.meishu.sdk.core.bquery.i f5109a;
        public final /* synthetic */ com.meishu.sdk.meishu_ad.splash.d b;
        public final /* synthetic */ com.meishu.sdk.meishu_ad.splash.c c;
        public final /* synthetic */ com.meishu.sdk.meishu_ad.splash.a d;
        public final /* synthetic */ View e;

        public i(com.meishu.sdk.core.bquery.i iVar, com.meishu.sdk.meishu_ad.splash.d dVar, com.meishu.sdk.meishu_ad.splash.c cVar, com.meishu.sdk.meishu_ad.splash.a aVar, View view) {
            this.f5109a = iVar;
            this.b = dVar;
            this.c = cVar;
            this.d = aVar;
            this.e = view;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(com.meishu.sdk.meishu_ad.splash.d dVar, com.meishu.sdk.core.bquery.i iVar, boolean z) {
            if (z) {
                return;
            }
            new DownloadView().handleDownloadView(v.this.q, dVar);
            iVar.b(R.id.ms_shakeRoot).d(0);
            if (AdSdk.adConfig().showLogo()) {
                iVar.b(R.id.ms_img_meishu_ad_tag).d(0);
            }
        }

        /* JADX WARN: Code duplicated, block: B:37:0x0248  */
        @Override // com.meishu.sdk.core.safe.l
        public void safeRun() {
            com.meishu.sdk.core.bquery.i iVar;
            ImageView imageView;
            com.meishu.sdk.meishu_ad.splash.c cVar;
            com.meishu.sdk.meishu_ad.splash.d dVar;
            TextView textView;
            TextView textView2;
            SplashSkipView splashSkipView;
            int i;
            long j;
            RelativeLayout relativeLayout;
            NormalMediaView normalMediaView;
            com.meishu.sdk.meishu_ad.splash.a aVar;
            com.meishu.sdk.meishu_ad.splash.c cVar2;
            SplashSkipView splashSkipView2;
            this.f5109a.b(R.id.ms_shakeRoot).d(8);
            this.f5109a.b(R.id.ms_img_meishu_ad_tag).d(8);
            com.meishu.sdk.meishu_ad.splash.l lVar = v.this.B;
            final com.meishu.sdk.meishu_ad.splash.d dVar2 = this.b;
            final com.meishu.sdk.core.bquery.i iVar2 = this.f5109a;
            lVar.a(new com.meishu.sdk.meishu_ad.splash.l.a() { // from class: com.meishu.sdk.meishu_ad.v$i$$ExternalSyntheticLambda0
                @Override // com.meishu.sdk.meishu_ad.splash.l.a
                public final void a(boolean z) {
                    this.f$0.a(dVar2, iVar2, z);
                }
            });
            AdType adType = AdType.SPLASH;
            adType.value();
            com.meishu.sdk.core.utils.h.a();
            this.c.b.setAct_type(com.meishu.sdk.core.utils.h.a(this.c.b.getAct_type(), adType.value()));
            v vVar = v.this;
            com.meishu.sdk.core.bquery.i iVar3 = this.f5109a;
            MeishuSplashRootView meishuSplashRootView = vVar.q;
            com.meishu.sdk.meishu_ad.splash.d dVar3 = this.b;
            com.meishu.sdk.meishu_ad.splash.c cVar3 = this.c;
            com.meishu.sdk.meishu_ad.splash.a aVar2 = this.d;
            vVar.getClass();
            dVar3.getAct_type();
            SplashSkipView splashSkipView3 = (SplashSkipView) meishuSplashRootView.findViewById(R.id.ms_skipView);
            RelativeLayout relativeLayout2 = (RelativeLayout) meishuSplashRootView.findViewById(R.id.ms_shake_img_container);
            ImageView imageView2 = (ImageView) meishuSplashRootView.findViewById(R.id.ms_shake_img);
            TextView textView3 = (TextView) meishuSplashRootView.findViewById(R.id.ms_shake_text);
            TextView textView4 = (TextView) meishuSplashRootView.findViewById(R.id.ms_shake_text_bottom);
            LinearLayout linearLayout = (LinearLayout) meishuSplashRootView.findViewById(R.id.ms_shakeRoot);
            TextView textView5 = (TextView) meishuSplashRootView.findViewById(R.id.ms_jump_btn);
            SwipeView swipeView = (SwipeView) meishuSplashRootView.findViewById(R.id.ms_SwipeViewParent);
            RelativeLayout relativeLayout3 = (RelativeLayout) meishuSplashRootView.findViewById(R.id.ms_up_move_container);
            ImageView imageView3 = (ImageView) meishuSplashRootView.findViewById(R.id.ms_up_move_iv);
            ImageView imageView4 = (ImageView) meishuSplashRootView.findViewById(R.id.ms_any_move_iv);
            meishuSplashRootView.post(new n(vVar, cVar3, relativeLayout2, imageView4, imageView2, relativeLayout3, imageView3, textView3, textView4, textView5, (ImageView) meishuSplashRootView.findViewById(R.id.ms_img_meishu_ad_tag)));
            String[] strArrA = v.a(dVar3.getAct_type());
            textView3.setText(strArrA[0]);
            textView4.setText(strArrA[1]);
            int iA = com.meishu.sdk.core.utils.m.a(vVar.f5096a);
            DisplayMetrics displayMetrics = vVar.f5096a.getResources().getDisplayMetrics();
            double d = iA;
            textView3.setTextSize(((float) (0.02d * d)) / displayMetrics.scaledDensity);
            textView4.setTextSize(((float) (0.018d * d)) / displayMetrics.scaledDensity);
            textView5.setTextSize(((float) (d * 0.019d)) / displayMetrics.scaledDensity);
            iVar3.b(R.id.ms_jump_btn).d(8);
            if (swipeView.getVisibility() != 8) {
                swipeView.setVisibility(8);
            }
            imageView2.addOnAttachStateChangeListener(new com.meishu.sdk.meishu_ad.f(vVar));
            if (com.meishu.sdk.core.utils.h.d(dVar3.getAct_type()) || com.meishu.sdk.core.utils.h.e(dVar3.getAct_type())) {
                textView3.setVisibility(0);
                textView4.setVisibility(0);
                linearLayout.post(new com.meishu.sdk.meishu_ad.g(vVar, meishuSplashRootView, linearLayout));
                if ((dVar3.getAct_type() & 32) != 32 || (dVar3.getAct_type() & 128) == 128) {
                    iVar = iVar3;
                    imageView = imageView4;
                    cVar = cVar3;
                    dVar = dVar3;
                    textView = textView3;
                    textView2 = textView4;
                    splashSkipView = splashSkipView3;
                    i = 2;
                    j = 100;
                } else {
                    iVar = iVar3;
                    cVar = cVar3;
                    imageView = imageView4;
                    textView = textView3;
                    textView2 = textView4;
                    j = 100;
                    v.C.postDelayed(new q(vVar, imageView3, relativeLayout3, relativeLayout2, imageView2), 100L);
                    swipeView.setVisibility(0);
                    dVar = dVar3;
                    swipeView.setMoveDistance(dVar3.getAct_type(), dVar.F);
                    splashSkipView = splashSkipView3;
                    swipeView.setOnSwipeListener(new com.meishu.sdk.meishu_ad.h(vVar, aVar2, cVar, splashSkipView));
                    i = 2;
                    if ((dVar.getAct_type() & 2) == 2) {
                        relativeLayout3.setOnClickListener(new com.meishu.sdk.meishu_ad.i(vVar, aVar2, cVar, splashSkipView));
                    }
                }
                if ((dVar.getAct_type() & 128) == 128) {
                    ImageView imageView5 = imageView;
                    relativeLayout = relativeLayout2;
                    v.C.postDelayed(new p(vVar, imageView5, imageView2, relativeLayout), j);
                    swipeView.setVisibility(0);
                    swipeView.setMoveDistance(dVar.getAct_type(), dVar.F);
                    swipeView.setOnSwipeListener(new com.meishu.sdk.meishu_ad.j(vVar, aVar2, cVar, splashSkipView));
                    if ((dVar.getAct_type() & i) == i) {
                        imageView5.setOnClickListener(new k(vVar, aVar2, cVar, splashSkipView));
                    }
                } else {
                    relativeLayout = relativeLayout2;
                    relativeLayout.setVisibility(0);
                    imageView2.setVisibility(0);
                    imageView2.post(new r(vVar, imageView2, -1));
                }
                if ((dVar.getAct_type() & i) == i) {
                    relativeLayout.setOnClickListener(new l(vVar, aVar2, cVar, splashSkipView));
                }
            } else {
                if ((dVar3.getAct_type() & 32) == 32 || (dVar3.getAct_type() & 128) == 128) {
                    textView3.setVisibility(0);
                    textView4.setVisibility(0);
                    if ((dVar3.getAct_type() & 32) != 32) {
                        aVar = aVar2;
                        cVar2 = cVar3;
                        splashSkipView2 = splashSkipView3;
                    } else {
                        if ((dVar3.getAct_type() & 128) != 128) {
                            relativeLayout3.setVisibility(0);
                            imageView3.setVisibility(0);
                            imageView3.post(new t(vVar, relativeLayout3, imageView3, -1));
                        }
                        if ((dVar3.getAct_type() & 2) == 2) {
                            aVar = aVar2;
                            cVar2 = cVar3;
                            splashSkipView2 = splashSkipView3;
                            relativeLayout3.setOnClickListener(new o(vVar, aVar, cVar2, splashSkipView2));
                        } else {
                            aVar = aVar2;
                            cVar2 = cVar3;
                            splashSkipView2 = splashSkipView3;
                        }
                    }
                    if ((dVar3.getAct_type() & 128) == 128) {
                        imageView4.setVisibility(0);
                        imageView4.post(new s(vVar, imageView4, -1));
                        if ((dVar3.getAct_type() & 2) == 2) {
                            imageView4.setOnClickListener(new o(vVar, aVar, cVar2, splashSkipView2));
                        }
                    }
                    dVar3.getAct_type();
                    if ((dVar3.getAct_type() & 32) == 32 || (dVar3.getAct_type() & 128) == 128) {
                        swipeView.setVisibility(0);
                        swipeView.setMoveDistance(dVar3.getAct_type(), dVar3.F);
                        swipeView.setOnSwipeListener(new m(vVar, aVar, cVar2, dVar3, splashSkipView2));
                        i = 2;
                        dVar = dVar3;
                        iVar = iVar3;
                        textView = textView3;
                        textView2 = textView4;
                    }
                } else if ((dVar3.getAct_type() & 2) == 2) {
                    iVar3.b(R.id.ms_jump_btn).d(0);
                    if (!TextUtils.isEmpty(dVar3.getClk_area())) {
                        iVar3.b(R.id.ms_jump_btn).a(dVar3.getClk_area());
                    } else if (dVar3.getInteractionType() == 1) {
                        View view = iVar3.b(R.id.ms_jump_btn).d;
                        if (view instanceof TextView) {
                            ((TextView) view).setText("点击查看详情");
                        }
                    } else {
                        View view2 = iVar3.b(R.id.ms_jump_btn).d;
                        if (view2 instanceof TextView) {
                            ((TextView) view2).setText("点击查看详情");
                        }
                    }
                }
                iVar = iVar3;
                i = 2;
                textView = textView3;
                textView2 = textView4;
                dVar = dVar3;
            }
            if (!TextUtils.isEmpty(dVar.getClk_area())) {
                textView.setText(dVar.getClk_area());
            }
            if (!TextUtils.isEmpty(dVar.getAction_desc())) {
                textView2.setText(dVar.getAction_desc());
            }
            if (!AdSdk.adConfig().showLogo()) {
                iVar.b(R.id.ms_img_meishu_ad_tag).d(8);
            } else if (!TextUtils.isEmpty(dVar.getFromLogo())) {
                iVar.b(R.id.ms_img_meishu_ad_tag).a(dVar.getFromLogo(), false);
            }
            try {
                v vVar2 = v.this;
                com.meishu.sdk.meishu_ad.splash.c cVar4 = this.c;
                vVar2.a(cVar4, cVar4.e, this.d, this.e, true);
                if (this.b.getAdPatternType() != i || (normalMediaView = this.c.d) == null) {
                    return;
                }
                normalMediaView.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: compiled from: AdNative.java */
    public class j implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.meishu.sdk.meishu_ad.splash.d f5110a;
        public final /* synthetic */ com.meishu.sdk.meishu_ad.splash.c b;
        public final /* synthetic */ com.meishu.sdk.meishu_ad.splash.a c;
        public final /* synthetic */ View d;

        public j(com.meishu.sdk.meishu_ad.splash.d dVar, com.meishu.sdk.meishu_ad.splash.c cVar, com.meishu.sdk.meishu_ad.splash.a aVar, View view) {
            this.f5110a = dVar;
            this.b = cVar;
            this.c = aVar;
            this.d = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            NormalMediaView normalMediaView;
            try {
                new DownloadView().handleDownloadView(v.this.q, this.f5110a);
                v vVar = v.this;
                com.meishu.sdk.meishu_ad.splash.c cVar = this.b;
                vVar.a(cVar, cVar.e, this.c, this.d, false);
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                if (this.f5110a.getAdPatternType() == 2 && (normalMediaView = this.b.d) != null) {
                    normalMediaView.start();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            v vVar2 = v.this;
            com.meishu.sdk.meishu_ad.splash.d dVar = this.f5110a;
            MeishuSplashRootView meishuSplashRootView = vVar2.q;
            vVar2.getClass();
            try {
                com.meishu.sdk.core.bquery.i iVar = new com.meishu.sdk.core.bquery.i(meishuSplashRootView);
                LinearLayout linearLayout = (LinearLayout) meishuSplashRootView.findViewById(R.id.ms_layout_native_splash_logo_ll);
                ImageView imageView = (ImageView) meishuSplashRootView.findViewById(R.id.ms_layout_native_splash_logo);
                TextView textView = (TextView) meishuSplashRootView.findViewById(R.id.ms_layout_native_splash_cid);
                linearLayout.setBackground(vVar2.f5096a.getResources().getDrawable(R.drawable.ms_black_oval_gray));
                if (!TextUtils.isEmpty(dVar.getCid())) {
                    textView.setText(dVar.getCid());
                }
                if (TextUtils.isEmpty(dVar.getFromLogo())) {
                    return;
                }
                iVar.d = imageView;
                iVar.a(dVar.getFromLogo(), false);
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
    }

    public v(Context context) {
        this.f5096a = context;
    }

    public final void a(com.meishu.sdk.meishu_ad.splash.c cVar) {
        try {
            com.meishu.sdk.meishu_ad.splash.d dVar = cVar.b;
            if (dVar != null && this.q != null) {
                int skipBtnLocation = dVar.getSkipBtnLocation();
                View viewFindViewById = this.q.findViewById(R.id.ms_skipView_container);
                if (viewFindViewById == null) {
                    return;
                }
                int iB = com.meishu.sdk.meishu_ad.splash.e.b(this.f5096a);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                if (skipBtnLocation == 0) {
                    layoutParams.addRule(10);
                    layoutParams.addRule(11);
                    layoutParams.topMargin = com.meishu.sdk.meishu_ad.splash.e.c(this.f5096a);
                    layoutParams.rightMargin = iB;
                } else if (skipBtnLocation == 1) {
                    layoutParams.addRule(12);
                    layoutParams.addRule(11);
                    layoutParams.rightMargin = iB;
                    layoutParams.bottomMargin = com.meishu.sdk.meishu_ad.splash.e.a(this.f5096a);
                    if (Boolean.TRUE.equals(com.meishu.sdk.platform.ms.splash.k.a(this.f5096a))) {
                        layoutParams.bottomMargin += (int) com.meishu.sdk.core.utils.m.a(this.f5096a, 30.0f);
                    } else {
                        layoutParams.bottomMargin += (int) com.meishu.sdk.core.utils.m.a(this.f5096a, 18.0f);
                    }
                    viewFindViewById.setPadding(viewFindViewById.getPaddingLeft(), viewFindViewById.getPaddingTop(), viewFindViewById.getPaddingRight(), layoutParams.bottomMargin);
                } else if (skipBtnLocation == 2) {
                    layoutParams.addRule(12);
                    layoutParams.addRule(9);
                    layoutParams.bottomMargin = com.meishu.sdk.meishu_ad.splash.e.a(this.f5096a);
                    layoutParams.leftMargin = iB;
                    viewFindViewById.setPadding(viewFindViewById.getPaddingLeft(), viewFindViewById.getPaddingTop(), viewFindViewById.getPaddingRight(), layoutParams.bottomMargin);
                    View viewFindViewById2 = this.q.findViewById(R.id.ms_download_layer_textview);
                    if (viewFindViewById2 != null) {
                        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
                        layoutParams2.bottomMargin = layoutParams.bottomMargin;
                        MeishuSplashRootView meishuSplashRootView = this.q;
                        int iA = com.meishu.sdk.meishu_ad.splash.e.a(meishuSplashRootView);
                        if (meishuSplashRootView != null) {
                            try {
                                iA = (int) com.meishu.sdk.core.utils.m.a(meishuSplashRootView.getContext(), iA);
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                        }
                        layoutParams2.leftMargin = (int) (((((double) iB) / 4.0d) * 3.0d) + ((double) iA));
                        viewFindViewById2.setLayoutParams(layoutParams2);
                    }
                } else if (skipBtnLocation == 3) {
                    layoutParams.addRule(10);
                    layoutParams.addRule(9);
                    layoutParams.topMargin = com.meishu.sdk.meishu_ad.splash.e.c(this.f5096a);
                    layoutParams.leftMargin = iB;
                }
                viewFindViewById.setLayoutParams(layoutParams);
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public static Bitmap[] b(Bitmap bitmap, int i2, int i3, int i4) {
        int i5;
        Bitmap[] bitmapArr = new Bitmap[2];
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float f2 = (i2 * 1.0f) / width;
        Matrix matrix = new Matrix();
        matrix.postScale(f2, f2);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, false);
        int height2 = bitmapCreateBitmap.getHeight();
        bitmapCreateBitmap.getWidth();
        if (height2 < i3) {
            try {
                AdSdk.getContext();
                bitmapArr[1] = com.meishu.sdk.core.utils.e0.a(bitmapCreateBitmap, 10);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        } else {
            if (i4 == 3 || i4 == 2 || i4 == 1) {
                i5 = (height2 - i3) / 2;
            } else {
                i5 = (i4 != 4 && i4 == 5) ? height2 - i3 : 0;
            }
            bitmapCreateBitmap = Bitmap.createBitmap(bitmapCreateBitmap, 0, i5, i2, i3, (Matrix) null, false);
        }
        bitmapArr[0] = bitmapCreateBitmap;
        return bitmapArr;
    }

    public final int b(int i2) {
        try {
            if (this.m > 0 && this.l > 0) {
                return Math.max(Math.min(this.m - ((int) (System.currentTimeMillis() - this.l)), Math.max(i2, 0)), 0);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return Math.max(i2, 0);
    }

    public static void a(v vVar, SplashSkipView splashSkipView) {
        vVar.getClass();
        if (!AdSdk.adConfig().isSplashClickToClosed() || splashSkipView == null) {
            return;
        }
        splashSkipView.a(true);
    }

    public static void a(v vVar, com.meishu.sdk.meishu_ad.splash.c cVar, MeishuSplashRootView meishuSplashRootView, com.meishu.sdk.meishu_ad.splash.a aVar, SplashSkipView splashSkipView) {
        TextView textView;
        vVar.getClass();
        try {
            if ((cVar.b.getAct_type() & 1) == 1) {
                meishuSplashRootView.setOnClickListener(new w(vVar, cVar, aVar, splashSkipView));
            }
            if ((cVar.b.getAct_type() & 2) == 2 && (textView = (TextView) meishuSplashRootView.findViewById(R.id.ms_jump_btn)) != null) {
                textView.setOnClickListener(new x(vVar, aVar, cVar, splashSkipView));
            }
            if (aVar instanceof com.meishu.sdk.platform.ms.splash.g) {
                ((com.meishu.sdk.platform.ms.splash.g) aVar).k = new y(vVar, new boolean[]{false}, cVar, aVar, splashSkipView);
                if (!((com.meishu.sdk.platform.ms.splash.g) aVar).e || ((com.meishu.sdk.platform.ms.splash.g) aVar).k == null) {
                    return;
                }
                ((y) ((com.meishu.sdk.platform.ms.splash.g) aVar).k).a();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void a(v vVar) {
        vVar.getClass();
        try {
            List<Animator> list = vVar.e;
            if (list == null || list.isEmpty()) {
                return;
            }
            for (int i2 = 0; i2 < vVar.e.size(); i2++) {
                Animator animator = vVar.e.get(i2);
                if (animator != null) {
                    animator.cancel();
                }
            }
            vVar.e.clear();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void a(v vVar, com.meishu.sdk.meishu_ad.splash.c cVar, com.meishu.sdk.meishu_ad.splash.d dVar, com.meishu.sdk.meishu_ad.splash.a aVar) {
        vVar.getClass();
        if (((dVar == null || dVar.getAd_type() == 0) ? AdType.SPLASH.value() : dVar.getAd_type()) != AdType.SPLASH.value()) {
            return;
        }
        com.meishu.sdk.meishu_ad.splash.l lVar = vVar.B;
        Context context = vVar.f5096a;
        MeishuSplashRootView meishuSplashRootView = vVar.q;
        g0 g0Var = new g0(vVar, aVar, cVar);
        lVar.getClass();
        try {
            if (dVar.getWebTempId() <= 0 || TextUtils.isEmpty(dVar.getWebTempUrl())) {
                return;
            }
            lVar.c = meishuSplashRootView;
            com.meishu.sdk.core.webview.n nVar = new com.meishu.sdk.core.webview.n();
            nVar.f4988a = 0;
            String webTempUrl = dVar.getWebTempUrl();
            lVar.b = com.meishu.sdk.core.webview.o.a(webTempUrl) ? com.meishu.sdk.core.webview.o.a(context, webTempUrl, cVar, nVar, null, new com.meishu.sdk.meishu_ad.splash.h(lVar, context, dVar, meishuSplashRootView, cVar, g0Var)) : null;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final SplashSkipView a(com.meishu.sdk.meishu_ad.splash.c cVar, MeishuSplashRootView meishuSplashRootView, com.meishu.sdk.meishu_ad.splash.a aVar, View view, boolean z) {
        SplashSkipView splashSkipView = cVar.c;
        if (splashSkipView != null) {
            return splashSkipView;
        }
        SplashSkipView splashSkipView2 = (SplashSkipView) meishuSplashRootView.findViewById(R.id.ms_skipView);
        meishuSplashRootView.post(new a(splashSkipView2, cVar, aVar, view, z, meishuSplashRootView));
        cVar.c = splashSkipView2;
        return splashSkipView2;
    }

    public final void a(m0 m0Var, String str, Integer num) {
        if (this.z) {
            return;
        }
        this.z = true;
        if (this.o == 0) {
            this.o = System.currentTimeMillis();
        }
        if (m0Var != null) {
            m0Var.onAdRenderFail(str, num.intValue());
        }
        if (q0.i > 0) {
            o1.b(this.d, num.intValue(), str);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void a(com.meishu.sdk.meishu_ad.splash.d dVar, com.meishu.sdk.meishu_ad.splash.a aVar, com.meishu.sdk.platform.ms.splash.a aVar2, View view, boolean z) {
        long t1;
        int fetchDelay;
        try {
            this.d = dVar.getEventUrl();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        com.meishu.sdk.meishu_ad.splash.c cVar = new com.meishu.sdk.meishu_ad.splash.c(dVar, aVar2, z);
        if (dVar.getImageUrls() != null && dVar.getImageUrls().length != 0) {
            this.f = 0;
            PackageBean.AdBean adBean = q0.m;
            PackageBean.SplashConfigBean splash = (adBean == null || adBean.getSplash() == null) ? null : q0.m.getSplash();
            if (dVar.getRs() != null) {
                this.A = dVar.getRs().intValue();
            } else if (splash != null) {
                this.A = splash.getRs();
            }
            if (this.A != 1) {
                this.f = 1;
            } else if (splash != null) {
                this.f = splash.getAr();
            }
            try {
                t1 = ((SplashAdLoader) aVar2.getAdLoader()).getT1();
            } catch (Exception unused) {
                t1 = 0;
            }
            this.l = t1;
            try {
                fetchDelay = ((SplashAdLoader) aVar2.getAdLoader()).getFetchDelay();
            } catch (Exception unused2) {
                fetchDelay = 0;
            }
            this.m = fetchDelay;
            cVar.i.add(new b(cVar, dVar, aVar, aVar2, view, z));
            if (this.f == 1) {
                a(cVar, dVar, aVar, aVar2, view, z, (ViewGroup) null);
            }
            a(this.A == 1, aVar, cVar);
            return;
        }
        LogUtil.i("AdNative", "empty srcUrls");
        a(aVar, "图片url为空", ErrorCodeUtil.EMPTY_SRC_URL);
    }

    public final void a(com.meishu.sdk.meishu_ad.splash.c cVar, com.meishu.sdk.meishu_ad.splash.a aVar) {
        LogUtil.d("AdNative", "adListener=" + aVar + ",nativeAd.getAdView()=" + cVar.getAdView() + ",isSplashStartRender=" + this.i);
        if (aVar == null || cVar.getAdView() == null || this.i) {
            return;
        }
        this.i = true;
        com.meishu.sdk.platform.ms.splash.g gVar = (com.meishu.sdk.platform.ms.splash.g) aVar;
        try {
            if (gVar.j) {
                return;
            }
            gVar.j = true;
            gVar.i = cVar.getAdView();
            try {
                Gson gson = new Gson();
                HashMap map = new HashMap();
                map.put("stepNum", 4);
                map.put("msg", "onAdReady add View");
                Integer numA = gVar.a();
                if (numA != null) {
                    map.put("creativeType", numA);
                }
                if (gVar.i != null) {
                    map.put(IReward.AD_VIEW, 1);
                } else {
                    map.put(IReward.AD_VIEW, 0);
                }
                o1.a(gVar.f5245a, gson.toJson(map));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            gVar.onADExposure();
            View view = gVar.i;
            if (view != null) {
                ViewGroup viewGroup = (ViewGroup) view.getParent();
                if (viewGroup != null) {
                    viewGroup.removeView(gVar.i);
                }
                TouchAdContainer touchAdContainer = new TouchAdContainer(gVar.i.getContext());
                try {
                    PackageBean.AdBean adBean = q0.m;
                    if (adBean == null || adBean.getSplash() == null || q0.m.getSplash().getNie() != 1) {
                        touchAdContainer.setInterceptDownEvent();
                    }
                } catch (Exception unused) {
                }
                touchAdContainer.setTouchPositionListener(new TouchPositionListener(cVar));
                touchAdContainer.addView(gVar.i);
                if (viewGroup != null) {
                    viewGroup.addView(touchAdContainer);
                }
                gVar.i = touchAdContainer;
                cVar.adView = touchAdContainer;
                com.meishu.sdk.platform.ms.splash.b bVar = gVar.d;
                if (bVar != null) {
                    bVar.setAdView(touchAdContainer);
                }
            } else {
                try {
                    o1.b(cVar.b.getEventUrl(), ErrorCodeUtil.RENDER_AD_INTERRUPTED, "adView 为null");
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
            cVar.b();
        } catch (Throwable th) {
            try {
                o1.b(cVar.b.getEventUrl(), ErrorCodeUtil.RENDER_AD_INTERRUPTED, "广告加载成功，加载到容器时发生异常");
            } catch (Exception e4) {
                e4.printStackTrace();
            }
            th.printStackTrace();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a(com.meishu.sdk.meishu_ad.splash.c cVar, com.meishu.sdk.meishu_ad.splash.d dVar, com.meishu.sdk.meishu_ad.splash.a aVar, com.meishu.sdk.platform.ms.splash.a aVar2, View view, boolean z, ViewGroup viewGroup) {
        try {
            Gson gson = new Gson();
            HashMap map = new HashMap();
            map.put("stepNum", 2);
            map.put("msg", "start create layout");
            map.put("creativeType", Integer.valueOf(dVar.getAdPatternType()));
            o1.a(cVar.b.getErrorUrl(), gson.toJson(map));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (viewGroup != null) {
            try {
                this.f5096a = viewGroup.getContext();
            } catch (Throwable th) {
                try {
                    o1.b(cVar.b.getEventUrl(), ErrorCodeUtil.RENDER_AD_EXCEPTION, th.getMessage());
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
                th.printStackTrace();
                return;
            }
        }
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.f5096a);
        int iValue = (dVar == null || dVar.getAd_type() == 0) ? AdType.SPLASH.value() : dVar.getAd_type();
        if (iValue == AdType.SPLASH.value()) {
            MeishuSplashRootView meishuSplashRootView = (MeishuSplashRootView) layoutInflaterFrom.inflate(R.layout.ms_splash_ad_layout, (ViewGroup) null);
            this.q = meishuSplashRootView;
            cVar.e = meishuSplashRootView;
            cVar.adView = meishuSplashRootView;
            this.B.c = meishuSplashRootView;
            com.meishu.sdk.core.bquery.i iVar = new com.meishu.sdk.core.bquery.i(this.q);
            a(cVar);
            this.q.post(new i(iVar, dVar, cVar, aVar, view));
            int iIntValue = ((SplashAdLoader) aVar2.getAdLoader()).getAccept_ad_width().intValue();
            int iIntValue2 = ((SplashAdLoader) aVar2.getAdLoader()).getAccept_ad_height().intValue();
            if (viewGroup != null) {
                if (iIntValue <= 0) {
                    iIntValue = viewGroup.getWidth();
                }
                if (iIntValue2 <= 0) {
                    iIntValue2 = viewGroup.getHeight();
                }
            }
            DisplayMetrics displayMetrics = this.f5096a.getResources().getDisplayMetrics();
            if (iIntValue <= 0 || iIntValue > displayMetrics.widthPixels) {
                iIntValue = displayMetrics.widthPixels;
            }
            int i2 = iIntValue;
            int i3 = (iIntValue2 <= 0 || iIntValue2 > displayMetrics.heightPixels) ? displayMetrics.heightPixels : iIntValue2;
            if (dVar.getAdPatternType() == 2) {
                a(aVar, dVar, cVar, this.q, iVar, view, ((SplashAdLoader) aVar2.getAdLoader()).getVideoIsMute(), i2, i3);
                return;
            } else {
                a(aVar, dVar, cVar, this.q, view, i2, i3);
                return;
            }
        }
        if (iValue == AdType.FEED.value()) {
            MeishuSplashRootView meishuSplashRootView2 = (MeishuSplashRootView) layoutInflaterFrom.inflate(R.layout.ms_layout_native_splash, (ViewGroup) null);
            this.q = meishuSplashRootView2;
            cVar.e = meishuSplashRootView2;
            cVar.adView = meishuSplashRootView2;
            meishuSplashRootView2.post(new j(dVar, cVar, aVar, view));
            a(aVar, dVar, cVar, this.q, view);
            return;
        }
        a(aVar, "unsupported type", ErrorCodeUtil.UNSUPPORTED_TYPE);
    }

    public final void a(com.meishu.sdk.meishu_ad.splash.a aVar, com.meishu.sdk.meishu_ad.splash.d dVar, com.meishu.sdk.meishu_ad.splash.c cVar, MeishuSplashRootView meishuSplashRootView, View view) {
        new DownloadView().handleDownloadView(meishuSplashRootView, dVar);
        if (dVar.getAdPatternType() == 2) {
            new com.meishu.sdk.core.bquery.i(meishuSplashRootView).a(dVar.g, 86400000, true, new com.meishu.sdk.meishu_ad.e(this, aVar, dVar, cVar, meishuSplashRootView, view));
        } else {
            com.meishu.sdk.core.cache.a.a(dVar.getImageUrls()[0], new j0(this, aVar, dVar, cVar, meishuSplashRootView, view), true);
        }
    }

    /* JADX WARN: Code duplicated, block: B:27:0x00be  */
    /* JADX WARN: Code duplicated, block: B:31:0x0122  */
    /* JADX WARN: Code duplicated, block: B:33:0x0136 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:34:0x0138  */
    /* JADX WARN: Code duplicated, block: B:36:0x013e  */
    /* JADX WARN: Code duplicated, block: B:37:0x015b  */
    /* JADX WARN: Code duplicated, block: B:38:0x015d  */
    /* JADX WARN: Code duplicated, block: B:51:0x019a  */
    /* JADX WARN: Code duplicated, block: B:53:0x01d1  */
    /* JADX WARN: Code duplicated, block: B:55:0x01dd  */
    /* JADX WARN: Code duplicated, block: B:57:0x020d  */
    /* JADX WARN: Code duplicated, block: B:59:0x023d  */
    /* JADX WARN: Code duplicated, block: B:63:0x024c  */
    /* JADX WARN: Code duplicated, block: B:66:0x0273  */
    /* JADX WARN: Code duplicated, block: B:67:0x027e  */
    /* JADX WARN: Code duplicated, block: B:70:0x0290  */
    /* JADX WARN: Code duplicated, block: B:71:0x029b  */
    /* JADX WARN: Code duplicated, block: B:74:0x02a9  */
    /* JADX WARN: Code duplicated, block: B:75:0x02b4  */
    /* JADX WARN: Code duplicated, block: B:78:0x00a9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v17 */
    /* JADX WARN: Type inference failed for: r4v24 */
    /* JADX WARN: Type inference failed for: r4v31 */
    /* JADX WARN: Type inference failed for: r4v32 */
    public static void a(v vVar, byte[] bArr, MeishuSplashRootView meishuSplashRootView, boolean z, BaseAdSlot baseAdSlot, com.meishu.sdk.meishu_ad.splash.c cVar, com.meishu.sdk.meishu_ad.splash.a aVar, NormalMediaView normalMediaView) {
        int height;
        int videoWidth;
        Bitmap bitmapDecodeByteArray;
        View viewInflate;
        boolean z2;
        int i2;
        int i3;
        RelativeLayout relativeLayout;
        LinearLayout linearLayout;
        GifImageView gifImageView;
        TextView textView;
        ImageView imageView;
        ImageView imageView2;
        TextView textView2;
        TextView textView3;
        int i4;
        com.meishu.sdk.core.bquery.i iVar;
        boolean z3;
        com.meishu.sdk.meishu_ad.nativ.f fVar;
        int i5;
        ?? r4;
        DisplayMetrics displayMetrics = vVar.f5096a.getResources().getDisplayMetrics();
        ImageView imageView3 = (ImageView) meishuSplashRootView.findViewById(R.id.ms_layout_native_splash_bg);
        SplashSkipView splashSkipView = (SplashSkipView) meishuSplashRootView.findViewById(R.id.ms_skipView);
        RelativeLayout relativeLayout2 = (RelativeLayout) meishuSplashRootView.findViewById(R.id.ms_native_splash_ad_container);
        View viewInflate2 = View.inflate(vVar.f5096a, R.layout.ms_layout_native_splash_1, null);
        if (normalMediaView != null) {
            videoWidth = normalMediaView.getMeishuVideoView().getMediaPlayer().getVideoWidth();
            height = normalMediaView.getMeishuVideoView().getMediaPlayer().getVideoHeight();
        } else if (z) {
            GifImageView gifImageView2 = new GifImageView(vVar.f5096a);
            gifImageView2.setBytes(bArr);
            int gifWidth = gifImageView2.getGifWidth();
            height = gifImageView2.getGifHeight();
            videoWidth = gifWidth;
        } else {
            if (bArr == null || bArr.length <= 0) {
                height = 0;
                videoWidth = 0;
            } else {
                Bitmap bitmapDecodeByteArray2 = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
                if (bitmapDecodeByteArray2 != null) {
                    int width = bitmapDecodeByteArray2.getWidth();
                    height = bitmapDecodeByteArray2.getHeight();
                    bitmapDecodeByteArray = bitmapDecodeByteArray2;
                    videoWidth = width;
                } else {
                    bitmapDecodeByteArray = bitmapDecodeByteArray2;
                    height = 0;
                    videoWidth = 0;
                }
            }
            if ((videoWidth * 1.0f) / height < 0.67d) {
                try {
                    try {
                        viewInflate = View.inflate(vVar.f5096a, R.layout.ms_layout_native_splash_2, null);
                        z2 = true;
                    } catch (Exception e2) {
                        e = e2;
                        e.printStackTrace();
                        viewInflate = viewInflate2;
                        z2 = false;
                    }
                } catch (Exception e3) {
                    e = e3;
                }
                i2 = height;
                i3 = videoWidth;
                viewInflate.post(new k0(vVar, cVar, meishuSplashRootView, aVar, splashSkipView));
                relativeLayout2.addView(viewInflate, -1, -1);
                relativeLayout = (RelativeLayout) viewInflate.findViewById(R.id.activity_sdk_splash_mediaContainer);
                linearLayout = (LinearLayout) viewInflate.findViewById(R.id.ms_layout_native_splash_ll);
                gifImageView = (GifImageView) viewInflate.findViewById(R.id.layout_native_splash_imageview);
                textView = (TextView) viewInflate.findViewById(R.id.layout_native_splash_title);
                imageView = (ImageView) viewInflate.findViewById(R.id.layout_native_splash_icon);
                imageView2 = (ImageView) viewInflate.findViewById(R.id.layout_native_splash_score);
                textView2 = (TextView) viewInflate.findViewById(R.id.layout_native_splash_desc);
                textView3 = (TextView) viewInflate.findViewById(R.id.ms_jump_btn);
                if (normalMediaView != null) {
                    relativeLayout.removeAllViews();
                    relativeLayout.addView(normalMediaView, -1, -1);
                    ExecutorService executorService = com.meishu.sdk.core.utils.g0.f4905a;
                    com.meishu.sdk.core.utils.g0.b.f4906a.a(new l0(vVar, normalMediaView, imageView3));
                } else if (z) {
                    if (!gifImageView.isAnimating()) {
                        gifImageView.setBytes(bArr);
                        cVar.setWidth(Integer.valueOf(gifImageView.getGifWidth()));
                        cVar.setHeight(Integer.valueOf(gifImageView.getGifHeight()));
                        gifImageView.startAnimation();
                    }
                } else {
                    if (bArr == null && bArr.length > 0) {
                        if (bitmapDecodeByteArray == null) {
                            i4 = 0;
                            bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
                        } else {
                            i4 = 0;
                        }
                        Bitmap bitmap = bitmapDecodeByteArray;
                        if (bitmap != null) {
                            gifImageView.setImageBitmap(bitmap);
                        }
                        Bitmap bitmapDecodeByteArray3 = BitmapFactory.decodeByteArray(bArr, i4, bArr.length);
                        if (bitmapDecodeByteArray3 != null) {
                            vVar.f5096a.getApplicationContext();
                            imageView3.setImageBitmap(com.meishu.sdk.core.utils.e0.a(bitmapDecodeByteArray3, 25));
                        }
                    }
                    iVar = new com.meishu.sdk.core.bquery.i(meishuSplashRootView);
                    if (z2) {
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) linearLayout.getLayoutParams();
                        double d2 = ((double) displayMetrics.widthPixels) * 0.86d;
                        layoutParams.width = (int) d2;
                        layoutParams.height = (int) ((d2 * ((double) i2)) / ((double) i3));
                        int i6 = (int) (((double) displayMetrics.heightPixels) * 0.07d);
                        layoutParams.topMargin = i6;
                        layoutParams.bottomMargin = i6;
                        linearLayout.setLayoutParams(layoutParams);
                        if (!com.meishu.sdk.core.utils.h.d(cVar.b.getAct_type()) || com.meishu.sdk.core.utils.h.e(cVar.b.getAct_type())) {
                            Drawable drawable = vVar.f5096a.getResources().getDrawable(R.drawable.ms_shake_angle);
                            drawable.setBounds(0, 0, 100, 100);
                            textView3.setPadding(60, 0, 60, 0);
                            textView3.setCompoundDrawables(drawable, null, null, null);
                        }
                        textView.setVisibility(8);
                        textView2.setVisibility(8);
                        imageView2.setVisibility(8);
                        imageView.setVisibility(8);
                        r4 = 0;
                    } else {
                        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) linearLayout.getLayoutParams();
                        layoutParams2.width = (int) (((double) displayMetrics.widthPixels) * 0.86d);
                        layoutParams2.height = -2;
                        int i7 = (int) (((double) displayMetrics.heightPixels) * 0.07d);
                        layoutParams2.topMargin = i7;
                        layoutParams2.bottomMargin = i7;
                        linearLayout.setLayoutParams(layoutParams2);
                        if (!com.meishu.sdk.core.utils.h.d(cVar.b.getAct_type()) || com.meishu.sdk.core.utils.h.e(cVar.b.getAct_type())) {
                            Drawable drawable2 = vVar.f5096a.getResources().getDrawable(R.drawable.ms_shake_angle);
                            z3 = false;
                            drawable2.setBounds(0, 0, 100, 100);
                            textView3.setPadding(60, 0, 60, 0);
                            textView3.setCompoundDrawables(drawable2, null, null, null);
                        } else {
                            z3 = false;
                        }
                        fVar = (com.meishu.sdk.meishu_ad.nativ.f) baseAdSlot;
                        if (!TextUtils.isEmpty(fVar.desc)) {
                            textView2.setVisibility(z3 ? 1 : 0);
                            textView2.setText(fVar.title);
                            i5 = 8;
                        } else {
                            i5 = 8;
                            textView2.setVisibility(8);
                            imageView2.setVisibility(z3 ? 1 : 0);
                        }
                        if (!TextUtils.isEmpty(baseAdSlot.getAppName())) {
                            textView.setVisibility(z3 ? 1 : 0);
                            textView.setText(baseAdSlot.getAppName());
                        } else {
                            textView.setVisibility(i5);
                            imageView2.setVisibility(i5);
                        }
                        if (!TextUtils.isEmpty(fVar.iconUrl)) {
                            imageView.setVisibility(z3 ? 1 : 0);
                            iVar.d = imageView;
                            iVar.a(fVar.iconUrl, z3);
                            r4 = z3;
                        } else {
                            imageView.setVisibility(i5);
                            r4 = z3;
                        }
                    }
                    String[] strArrA = a(cVar.b.getAct_type());
                    textView3.setText(strArrA[r4] + strArrA[1]);
                    textView3.setOnClickListener(new com.meishu.sdk.meishu_ad.b(vVar, cVar, aVar, splashSkipView));
                }
                i4 = 0;
                iVar = new com.meishu.sdk.core.bquery.i(meishuSplashRootView);
                if (z2) {
                    RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) linearLayout.getLayoutParams();
                    double d3 = ((double) displayMetrics.widthPixels) * 0.86d;
                    layoutParams3.width = (int) d3;
                    layoutParams3.height = (int) ((d3 * ((double) i2)) / ((double) i3));
                    int i8 = (int) (((double) displayMetrics.heightPixels) * 0.07d);
                    layoutParams3.topMargin = i8;
                    layoutParams3.bottomMargin = i8;
                    linearLayout.setLayoutParams(layoutParams3);
                    if (!com.meishu.sdk.core.utils.h.d(cVar.b.getAct_type())) {
                        Drawable drawable3 = vVar.f5096a.getResources().getDrawable(R.drawable.ms_shake_angle);
                        drawable3.setBounds(0, 0, 100, 100);
                        textView3.setPadding(60, 0, 60, 0);
                        textView3.setCompoundDrawables(drawable3, null, null, null);
                    } else {
                        Drawable drawable4 = vVar.f5096a.getResources().getDrawable(R.drawable.ms_shake_angle);
                        drawable4.setBounds(0, 0, 100, 100);
                        textView3.setPadding(60, 0, 60, 0);
                        textView3.setCompoundDrawables(drawable4, null, null, null);
                    }
                    textView.setVisibility(8);
                    textView2.setVisibility(8);
                    imageView2.setVisibility(8);
                    imageView.setVisibility(8);
                    r4 = 0;
                } else {
                    RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) linearLayout.getLayoutParams();
                    layoutParams4.width = (int) (((double) displayMetrics.widthPixels) * 0.86d);
                    layoutParams4.height = -2;
                    int i9 = (int) (((double) displayMetrics.heightPixels) * 0.07d);
                    layoutParams4.topMargin = i9;
                    layoutParams4.bottomMargin = i9;
                    linearLayout.setLayoutParams(layoutParams4);
                    if (com.meishu.sdk.core.utils.h.d(cVar.b.getAct_type())) {
                        Drawable drawable5 = vVar.f5096a.getResources().getDrawable(R.drawable.ms_shake_angle);
                        z3 = false;
                        drawable5.setBounds(0, 0, 100, 100);
                        textView3.setPadding(60, 0, 60, 0);
                        textView3.setCompoundDrawables(drawable5, null, null, null);
                    } else {
                        Drawable drawable6 = vVar.f5096a.getResources().getDrawable(R.drawable.ms_shake_angle);
                        z3 = false;
                        drawable6.setBounds(0, 0, 100, 100);
                        textView3.setPadding(60, 0, 60, 0);
                        textView3.setCompoundDrawables(drawable6, null, null, null);
                    }
                    fVar = (com.meishu.sdk.meishu_ad.nativ.f) baseAdSlot;
                    if (!TextUtils.isEmpty(fVar.desc)) {
                        textView2.setVisibility(z3 ? 1 : 0);
                        textView2.setText(fVar.title);
                        i5 = 8;
                    } else {
                        i5 = 8;
                        textView2.setVisibility(8);
                        imageView2.setVisibility(z3 ? 1 : 0);
                    }
                    if (!TextUtils.isEmpty(baseAdSlot.getAppName())) {
                        textView.setVisibility(z3 ? 1 : 0);
                        textView.setText(baseAdSlot.getAppName());
                    } else {
                        textView.setVisibility(i5);
                        imageView2.setVisibility(i5);
                    }
                    if (!TextUtils.isEmpty(fVar.iconUrl)) {
                        imageView.setVisibility(z3 ? 1 : 0);
                        iVar.d = imageView;
                        iVar.a(fVar.iconUrl, z3);
                        r4 = z3;
                    } else {
                        imageView.setVisibility(i5);
                        r4 = z3;
                    }
                }
                String[] strArrA2 = a(cVar.b.getAct_type());
                textView3.setText(strArrA2[r4] + strArrA2[1]);
                textView3.setOnClickListener(new com.meishu.sdk.meishu_ad.b(vVar, cVar, aVar, splashSkipView));
            }
            viewInflate = viewInflate2;
            z2 = false;
            i2 = height;
            i3 = videoWidth;
            viewInflate.post(new k0(vVar, cVar, meishuSplashRootView, aVar, splashSkipView));
            relativeLayout2.addView(viewInflate, -1, -1);
            relativeLayout = (RelativeLayout) viewInflate.findViewById(R.id.activity_sdk_splash_mediaContainer);
            linearLayout = (LinearLayout) viewInflate.findViewById(R.id.ms_layout_native_splash_ll);
            gifImageView = (GifImageView) viewInflate.findViewById(R.id.layout_native_splash_imageview);
            textView = (TextView) viewInflate.findViewById(R.id.layout_native_splash_title);
            imageView = (ImageView) viewInflate.findViewById(R.id.layout_native_splash_icon);
            imageView2 = (ImageView) viewInflate.findViewById(R.id.layout_native_splash_score);
            textView2 = (TextView) viewInflate.findViewById(R.id.layout_native_splash_desc);
            textView3 = (TextView) viewInflate.findViewById(R.id.ms_jump_btn);
            if (normalMediaView != null) {
                relativeLayout.removeAllViews();
                relativeLayout.addView(normalMediaView, -1, -1);
                ExecutorService executorService2 = com.meishu.sdk.core.utils.g0.f4905a;
                com.meishu.sdk.core.utils.g0.b.f4906a.a(new l0(vVar, normalMediaView, imageView3));
            } else if (z) {
                if (!gifImageView.isAnimating()) {
                    gifImageView.setBytes(bArr);
                    cVar.setWidth(Integer.valueOf(gifImageView.getGifWidth()));
                    cVar.setHeight(Integer.valueOf(gifImageView.getGifHeight()));
                    gifImageView.startAnimation();
                }
            } else {
                if (bArr == null) {
                }
                iVar = new com.meishu.sdk.core.bquery.i(meishuSplashRootView);
                if (z2) {
                    RelativeLayout.LayoutParams layoutParams5 = (RelativeLayout.LayoutParams) linearLayout.getLayoutParams();
                    double d4 = ((double) displayMetrics.widthPixels) * 0.86d;
                    layoutParams5.width = (int) d4;
                    layoutParams5.height = (int) ((d4 * ((double) i2)) / ((double) i3));
                    int i10 = (int) (((double) displayMetrics.heightPixels) * 0.07d);
                    layoutParams5.topMargin = i10;
                    layoutParams5.bottomMargin = i10;
                    linearLayout.setLayoutParams(layoutParams5);
                    if (!com.meishu.sdk.core.utils.h.d(cVar.b.getAct_type())) {
                        Drawable drawable7 = vVar.f5096a.getResources().getDrawable(R.drawable.ms_shake_angle);
                        drawable7.setBounds(0, 0, 100, 100);
                        textView3.setPadding(60, 0, 60, 0);
                        textView3.setCompoundDrawables(drawable7, null, null, null);
                    } else {
                        Drawable drawable8 = vVar.f5096a.getResources().getDrawable(R.drawable.ms_shake_angle);
                        drawable8.setBounds(0, 0, 100, 100);
                        textView3.setPadding(60, 0, 60, 0);
                        textView3.setCompoundDrawables(drawable8, null, null, null);
                    }
                    textView.setVisibility(8);
                    textView2.setVisibility(8);
                    imageView2.setVisibility(8);
                    imageView.setVisibility(8);
                    r4 = 0;
                } else {
                    RelativeLayout.LayoutParams layoutParams6 = (RelativeLayout.LayoutParams) linearLayout.getLayoutParams();
                    layoutParams6.width = (int) (((double) displayMetrics.widthPixels) * 0.86d);
                    layoutParams6.height = -2;
                    int i11 = (int) (((double) displayMetrics.heightPixels) * 0.07d);
                    layoutParams6.topMargin = i11;
                    layoutParams6.bottomMargin = i11;
                    linearLayout.setLayoutParams(layoutParams6);
                    if (com.meishu.sdk.core.utils.h.d(cVar.b.getAct_type())) {
                        Drawable drawable9 = vVar.f5096a.getResources().getDrawable(R.drawable.ms_shake_angle);
                        z3 = false;
                        drawable9.setBounds(0, 0, 100, 100);
                        textView3.setPadding(60, 0, 60, 0);
                        textView3.setCompoundDrawables(drawable9, null, null, null);
                    } else {
                        Drawable drawable10 = vVar.f5096a.getResources().getDrawable(R.drawable.ms_shake_angle);
                        z3 = false;
                        drawable10.setBounds(0, 0, 100, 100);
                        textView3.setPadding(60, 0, 60, 0);
                        textView3.setCompoundDrawables(drawable10, null, null, null);
                    }
                    fVar = (com.meishu.sdk.meishu_ad.nativ.f) baseAdSlot;
                    if (!TextUtils.isEmpty(fVar.desc)) {
                        textView2.setVisibility(z3 ? 1 : 0);
                        textView2.setText(fVar.title);
                        i5 = 8;
                    } else {
                        i5 = 8;
                        textView2.setVisibility(8);
                        imageView2.setVisibility(z3 ? 1 : 0);
                    }
                    if (!TextUtils.isEmpty(baseAdSlot.getAppName())) {
                        textView.setVisibility(z3 ? 1 : 0);
                        textView.setText(baseAdSlot.getAppName());
                    } else {
                        textView.setVisibility(i5);
                        imageView2.setVisibility(i5);
                    }
                    if (!TextUtils.isEmpty(fVar.iconUrl)) {
                        imageView.setVisibility(z3 ? 1 : 0);
                        iVar.d = imageView;
                        iVar.a(fVar.iconUrl, z3);
                        r4 = z3;
                    } else {
                        imageView.setVisibility(i5);
                        r4 = z3;
                    }
                }
                String[] strArrA3 = a(cVar.b.getAct_type());
                textView3.setText(strArrA3[r4] + strArrA3[1]);
                textView3.setOnClickListener(new com.meishu.sdk.meishu_ad.b(vVar, cVar, aVar, splashSkipView));
            }
            i4 = 0;
            iVar = new com.meishu.sdk.core.bquery.i(meishuSplashRootView);
            if (z2) {
                RelativeLayout.LayoutParams layoutParams7 = (RelativeLayout.LayoutParams) linearLayout.getLayoutParams();
                double d5 = ((double) displayMetrics.widthPixels) * 0.86d;
                layoutParams7.width = (int) d5;
                layoutParams7.height = (int) ((d5 * ((double) i2)) / ((double) i3));
                int i12 = (int) (((double) displayMetrics.heightPixels) * 0.07d);
                layoutParams7.topMargin = i12;
                layoutParams7.bottomMargin = i12;
                linearLayout.setLayoutParams(layoutParams7);
                if (!com.meishu.sdk.core.utils.h.d(cVar.b.getAct_type())) {
                    Drawable drawable11 = vVar.f5096a.getResources().getDrawable(R.drawable.ms_shake_angle);
                    drawable11.setBounds(0, 0, 100, 100);
                    textView3.setPadding(60, 0, 60, 0);
                    textView3.setCompoundDrawables(drawable11, null, null, null);
                } else {
                    Drawable drawable12 = vVar.f5096a.getResources().getDrawable(R.drawable.ms_shake_angle);
                    drawable12.setBounds(0, 0, 100, 100);
                    textView3.setPadding(60, 0, 60, 0);
                    textView3.setCompoundDrawables(drawable12, null, null, null);
                }
                textView.setVisibility(8);
                textView2.setVisibility(8);
                imageView2.setVisibility(8);
                imageView.setVisibility(8);
                r4 = 0;
            } else {
                RelativeLayout.LayoutParams layoutParams8 = (RelativeLayout.LayoutParams) linearLayout.getLayoutParams();
                layoutParams8.width = (int) (((double) displayMetrics.widthPixels) * 0.86d);
                layoutParams8.height = -2;
                int i13 = (int) (((double) displayMetrics.heightPixels) * 0.07d);
                layoutParams8.topMargin = i13;
                layoutParams8.bottomMargin = i13;
                linearLayout.setLayoutParams(layoutParams8);
                if (com.meishu.sdk.core.utils.h.d(cVar.b.getAct_type())) {
                    Drawable drawable13 = vVar.f5096a.getResources().getDrawable(R.drawable.ms_shake_angle);
                    z3 = false;
                    drawable13.setBounds(0, 0, 100, 100);
                    textView3.setPadding(60, 0, 60, 0);
                    textView3.setCompoundDrawables(drawable13, null, null, null);
                } else {
                    Drawable drawable14 = vVar.f5096a.getResources().getDrawable(R.drawable.ms_shake_angle);
                    z3 = false;
                    drawable14.setBounds(0, 0, 100, 100);
                    textView3.setPadding(60, 0, 60, 0);
                    textView3.setCompoundDrawables(drawable14, null, null, null);
                }
                fVar = (com.meishu.sdk.meishu_ad.nativ.f) baseAdSlot;
                if (!TextUtils.isEmpty(fVar.desc)) {
                    textView2.setVisibility(z3 ? 1 : 0);
                    textView2.setText(fVar.title);
                    i5 = 8;
                } else {
                    i5 = 8;
                    textView2.setVisibility(8);
                    imageView2.setVisibility(z3 ? 1 : 0);
                }
                if (!TextUtils.isEmpty(baseAdSlot.getAppName())) {
                    textView.setVisibility(z3 ? 1 : 0);
                    textView.setText(baseAdSlot.getAppName());
                } else {
                    textView.setVisibility(i5);
                    imageView2.setVisibility(i5);
                }
                if (!TextUtils.isEmpty(fVar.iconUrl)) {
                    imageView.setVisibility(z3 ? 1 : 0);
                    iVar.d = imageView;
                    iVar.a(fVar.iconUrl, z3);
                    r4 = z3;
                } else {
                    imageView.setVisibility(i5);
                    r4 = z3;
                }
            }
            String[] strArrA4 = a(cVar.b.getAct_type());
            textView3.setText(strArrA4[r4] + strArrA4[1]);
            textView3.setOnClickListener(new com.meishu.sdk.meishu_ad.b(vVar, cVar, aVar, splashSkipView));
        }
        bitmapDecodeByteArray = null;
        if ((videoWidth * 1.0f) / height < 0.67d) {
            viewInflate = View.inflate(vVar.f5096a, R.layout.ms_layout_native_splash_2, null);
            z2 = true;
            i2 = height;
            i3 = videoWidth;
            viewInflate.post(new k0(vVar, cVar, meishuSplashRootView, aVar, splashSkipView));
            relativeLayout2.addView(viewInflate, -1, -1);
            relativeLayout = (RelativeLayout) viewInflate.findViewById(R.id.activity_sdk_splash_mediaContainer);
            linearLayout = (LinearLayout) viewInflate.findViewById(R.id.ms_layout_native_splash_ll);
            gifImageView = (GifImageView) viewInflate.findViewById(R.id.layout_native_splash_imageview);
            textView = (TextView) viewInflate.findViewById(R.id.layout_native_splash_title);
            imageView = (ImageView) viewInflate.findViewById(R.id.layout_native_splash_icon);
            imageView2 = (ImageView) viewInflate.findViewById(R.id.layout_native_splash_score);
            textView2 = (TextView) viewInflate.findViewById(R.id.layout_native_splash_desc);
            textView3 = (TextView) viewInflate.findViewById(R.id.ms_jump_btn);
            if (normalMediaView != null) {
                relativeLayout.removeAllViews();
                relativeLayout.addView(normalMediaView, -1, -1);
                ExecutorService executorService3 = com.meishu.sdk.core.utils.g0.f4905a;
                com.meishu.sdk.core.utils.g0.b.f4906a.a(new l0(vVar, normalMediaView, imageView3));
            } else if (z) {
                if (!gifImageView.isAnimating()) {
                    gifImageView.setBytes(bArr);
                    cVar.setWidth(Integer.valueOf(gifImageView.getGifWidth()));
                    cVar.setHeight(Integer.valueOf(gifImageView.getGifHeight()));
                    gifImageView.startAnimation();
                }
            } else {
                if (bArr == null) {
                }
                iVar = new com.meishu.sdk.core.bquery.i(meishuSplashRootView);
                if (z2) {
                    RelativeLayout.LayoutParams layoutParams9 = (RelativeLayout.LayoutParams) linearLayout.getLayoutParams();
                    double d6 = ((double) displayMetrics.widthPixels) * 0.86d;
                    layoutParams9.width = (int) d6;
                    layoutParams9.height = (int) ((d6 * ((double) i2)) / ((double) i3));
                    int i14 = (int) (((double) displayMetrics.heightPixels) * 0.07d);
                    layoutParams9.topMargin = i14;
                    layoutParams9.bottomMargin = i14;
                    linearLayout.setLayoutParams(layoutParams9);
                    if (!com.meishu.sdk.core.utils.h.d(cVar.b.getAct_type())) {
                        Drawable drawable15 = vVar.f5096a.getResources().getDrawable(R.drawable.ms_shake_angle);
                        drawable15.setBounds(0, 0, 100, 100);
                        textView3.setPadding(60, 0, 60, 0);
                        textView3.setCompoundDrawables(drawable15, null, null, null);
                    } else {
                        Drawable drawable16 = vVar.f5096a.getResources().getDrawable(R.drawable.ms_shake_angle);
                        drawable16.setBounds(0, 0, 100, 100);
                        textView3.setPadding(60, 0, 60, 0);
                        textView3.setCompoundDrawables(drawable16, null, null, null);
                    }
                    textView.setVisibility(8);
                    textView2.setVisibility(8);
                    imageView2.setVisibility(8);
                    imageView.setVisibility(8);
                    r4 = 0;
                } else {
                    RelativeLayout.LayoutParams layoutParams10 = (RelativeLayout.LayoutParams) linearLayout.getLayoutParams();
                    layoutParams10.width = (int) (((double) displayMetrics.widthPixels) * 0.86d);
                    layoutParams10.height = -2;
                    int i15 = (int) (((double) displayMetrics.heightPixels) * 0.07d);
                    layoutParams10.topMargin = i15;
                    layoutParams10.bottomMargin = i15;
                    linearLayout.setLayoutParams(layoutParams10);
                    if (com.meishu.sdk.core.utils.h.d(cVar.b.getAct_type())) {
                        Drawable drawable17 = vVar.f5096a.getResources().getDrawable(R.drawable.ms_shake_angle);
                        z3 = false;
                        drawable17.setBounds(0, 0, 100, 100);
                        textView3.setPadding(60, 0, 60, 0);
                        textView3.setCompoundDrawables(drawable17, null, null, null);
                    } else {
                        Drawable drawable18 = vVar.f5096a.getResources().getDrawable(R.drawable.ms_shake_angle);
                        z3 = false;
                        drawable18.setBounds(0, 0, 100, 100);
                        textView3.setPadding(60, 0, 60, 0);
                        textView3.setCompoundDrawables(drawable18, null, null, null);
                    }
                    fVar = (com.meishu.sdk.meishu_ad.nativ.f) baseAdSlot;
                    if (!TextUtils.isEmpty(fVar.desc)) {
                        textView2.setVisibility(z3 ? 1 : 0);
                        textView2.setText(fVar.title);
                        i5 = 8;
                    } else {
                        i5 = 8;
                        textView2.setVisibility(8);
                        imageView2.setVisibility(z3 ? 1 : 0);
                    }
                    if (!TextUtils.isEmpty(baseAdSlot.getAppName())) {
                        textView.setVisibility(z3 ? 1 : 0);
                        textView.setText(baseAdSlot.getAppName());
                    } else {
                        textView.setVisibility(i5);
                        imageView2.setVisibility(i5);
                    }
                    if (!TextUtils.isEmpty(fVar.iconUrl)) {
                        imageView.setVisibility(z3 ? 1 : 0);
                        iVar.d = imageView;
                        iVar.a(fVar.iconUrl, z3);
                        r4 = z3;
                    } else {
                        imageView.setVisibility(i5);
                        r4 = z3;
                    }
                }
                String[] strArrA5 = a(cVar.b.getAct_type());
                textView3.setText(strArrA5[r4] + strArrA5[1]);
                textView3.setOnClickListener(new com.meishu.sdk.meishu_ad.b(vVar, cVar, aVar, splashSkipView));
            }
            i4 = 0;
            iVar = new com.meishu.sdk.core.bquery.i(meishuSplashRootView);
            if (z2) {
                RelativeLayout.LayoutParams layoutParams11 = (RelativeLayout.LayoutParams) linearLayout.getLayoutParams();
                double d7 = ((double) displayMetrics.widthPixels) * 0.86d;
                layoutParams11.width = (int) d7;
                layoutParams11.height = (int) ((d7 * ((double) i2)) / ((double) i3));
                int i16 = (int) (((double) displayMetrics.heightPixels) * 0.07d);
                layoutParams11.topMargin = i16;
                layoutParams11.bottomMargin = i16;
                linearLayout.setLayoutParams(layoutParams11);
                if (!com.meishu.sdk.core.utils.h.d(cVar.b.getAct_type())) {
                    Drawable drawable19 = vVar.f5096a.getResources().getDrawable(R.drawable.ms_shake_angle);
                    drawable19.setBounds(0, 0, 100, 100);
                    textView3.setPadding(60, 0, 60, 0);
                    textView3.setCompoundDrawables(drawable19, null, null, null);
                } else {
                    Drawable drawable110 = vVar.f5096a.getResources().getDrawable(R.drawable.ms_shake_angle);
                    drawable110.setBounds(0, 0, 100, 100);
                    textView3.setPadding(60, 0, 60, 0);
                    textView3.setCompoundDrawables(drawable110, null, null, null);
                }
                textView.setVisibility(8);
                textView2.setVisibility(8);
                imageView2.setVisibility(8);
                imageView.setVisibility(8);
                r4 = 0;
            } else {
                RelativeLayout.LayoutParams layoutParams12 = (RelativeLayout.LayoutParams) linearLayout.getLayoutParams();
                layoutParams12.width = (int) (((double) displayMetrics.widthPixels) * 0.86d);
                layoutParams12.height = -2;
                int i17 = (int) (((double) displayMetrics.heightPixels) * 0.07d);
                layoutParams12.topMargin = i17;
                layoutParams12.bottomMargin = i17;
                linearLayout.setLayoutParams(layoutParams12);
                if (com.meishu.sdk.core.utils.h.d(cVar.b.getAct_type())) {
                    Drawable drawable111 = vVar.f5096a.getResources().getDrawable(R.drawable.ms_shake_angle);
                    z3 = false;
                    drawable111.setBounds(0, 0, 100, 100);
                    textView3.setPadding(60, 0, 60, 0);
                    textView3.setCompoundDrawables(drawable111, null, null, null);
                } else {
                    Drawable drawable112 = vVar.f5096a.getResources().getDrawable(R.drawable.ms_shake_angle);
                    z3 = false;
                    drawable112.setBounds(0, 0, 100, 100);
                    textView3.setPadding(60, 0, 60, 0);
                    textView3.setCompoundDrawables(drawable112, null, null, null);
                }
                fVar = (com.meishu.sdk.meishu_ad.nativ.f) baseAdSlot;
                if (!TextUtils.isEmpty(fVar.desc)) {
                    textView2.setVisibility(z3 ? 1 : 0);
                    textView2.setText(fVar.title);
                    i5 = 8;
                } else {
                    i5 = 8;
                    textView2.setVisibility(8);
                    imageView2.setVisibility(z3 ? 1 : 0);
                }
                if (!TextUtils.isEmpty(baseAdSlot.getAppName())) {
                    textView.setVisibility(z3 ? 1 : 0);
                    textView.setText(baseAdSlot.getAppName());
                } else {
                    textView.setVisibility(i5);
                    imageView2.setVisibility(i5);
                }
                if (!TextUtils.isEmpty(fVar.iconUrl)) {
                    imageView.setVisibility(z3 ? 1 : 0);
                    iVar.d = imageView;
                    iVar.a(fVar.iconUrl, z3);
                    r4 = z3;
                } else {
                    imageView.setVisibility(i5);
                    r4 = z3;
                }
            }
            String[] strArrA6 = a(cVar.b.getAct_type());
            textView3.setText(strArrA6[r4] + strArrA6[1]);
            textView3.setOnClickListener(new com.meishu.sdk.meishu_ad.b(vVar, cVar, aVar, splashSkipView));
        }
        viewInflate = viewInflate2;
        z2 = false;
        i2 = height;
        i3 = videoWidth;
        viewInflate.post(new k0(vVar, cVar, meishuSplashRootView, aVar, splashSkipView));
        relativeLayout2.addView(viewInflate, -1, -1);
        relativeLayout = (RelativeLayout) viewInflate.findViewById(R.id.activity_sdk_splash_mediaContainer);
        linearLayout = (LinearLayout) viewInflate.findViewById(R.id.ms_layout_native_splash_ll);
        gifImageView = (GifImageView) viewInflate.findViewById(R.id.layout_native_splash_imageview);
        textView = (TextView) viewInflate.findViewById(R.id.layout_native_splash_title);
        imageView = (ImageView) viewInflate.findViewById(R.id.layout_native_splash_icon);
        imageView2 = (ImageView) viewInflate.findViewById(R.id.layout_native_splash_score);
        textView2 = (TextView) viewInflate.findViewById(R.id.layout_native_splash_desc);
        textView3 = (TextView) viewInflate.findViewById(R.id.ms_jump_btn);
        if (normalMediaView != null) {
            relativeLayout.removeAllViews();
            relativeLayout.addView(normalMediaView, -1, -1);
            ExecutorService executorService4 = com.meishu.sdk.core.utils.g0.f4905a;
            com.meishu.sdk.core.utils.g0.b.f4906a.a(new l0(vVar, normalMediaView, imageView3));
        } else if (z) {
            if (!gifImageView.isAnimating()) {
                gifImageView.setBytes(bArr);
                cVar.setWidth(Integer.valueOf(gifImageView.getGifWidth()));
                cVar.setHeight(Integer.valueOf(gifImageView.getGifHeight()));
                gifImageView.startAnimation();
            }
        } else {
            if (bArr == null) {
            }
            iVar = new com.meishu.sdk.core.bquery.i(meishuSplashRootView);
            if (z2) {
                RelativeLayout.LayoutParams layoutParams13 = (RelativeLayout.LayoutParams) linearLayout.getLayoutParams();
                double d8 = ((double) displayMetrics.widthPixels) * 0.86d;
                layoutParams13.width = (int) d8;
                layoutParams13.height = (int) ((d8 * ((double) i2)) / ((double) i3));
                int i18 = (int) (((double) displayMetrics.heightPixels) * 0.07d);
                layoutParams13.topMargin = i18;
                layoutParams13.bottomMargin = i18;
                linearLayout.setLayoutParams(layoutParams13);
                if (!com.meishu.sdk.core.utils.h.d(cVar.b.getAct_type())) {
                    Drawable drawable113 = vVar.f5096a.getResources().getDrawable(R.drawable.ms_shake_angle);
                    drawable113.setBounds(0, 0, 100, 100);
                    textView3.setPadding(60, 0, 60, 0);
                    textView3.setCompoundDrawables(drawable113, null, null, null);
                } else {
                    Drawable drawable114 = vVar.f5096a.getResources().getDrawable(R.drawable.ms_shake_angle);
                    drawable114.setBounds(0, 0, 100, 100);
                    textView3.setPadding(60, 0, 60, 0);
                    textView3.setCompoundDrawables(drawable114, null, null, null);
                }
                textView.setVisibility(8);
                textView2.setVisibility(8);
                imageView2.setVisibility(8);
                imageView.setVisibility(8);
                r4 = 0;
            } else {
                RelativeLayout.LayoutParams layoutParams14 = (RelativeLayout.LayoutParams) linearLayout.getLayoutParams();
                layoutParams14.width = (int) (((double) displayMetrics.widthPixels) * 0.86d);
                layoutParams14.height = -2;
                int i19 = (int) (((double) displayMetrics.heightPixels) * 0.07d);
                layoutParams14.topMargin = i19;
                layoutParams14.bottomMargin = i19;
                linearLayout.setLayoutParams(layoutParams14);
                if (com.meishu.sdk.core.utils.h.d(cVar.b.getAct_type())) {
                    Drawable drawable115 = vVar.f5096a.getResources().getDrawable(R.drawable.ms_shake_angle);
                    z3 = false;
                    drawable115.setBounds(0, 0, 100, 100);
                    textView3.setPadding(60, 0, 60, 0);
                    textView3.setCompoundDrawables(drawable115, null, null, null);
                } else {
                    Drawable drawable116 = vVar.f5096a.getResources().getDrawable(R.drawable.ms_shake_angle);
                    z3 = false;
                    drawable116.setBounds(0, 0, 100, 100);
                    textView3.setPadding(60, 0, 60, 0);
                    textView3.setCompoundDrawables(drawable116, null, null, null);
                }
                fVar = (com.meishu.sdk.meishu_ad.nativ.f) baseAdSlot;
                if (!TextUtils.isEmpty(fVar.desc)) {
                    textView2.setVisibility(z3 ? 1 : 0);
                    textView2.setText(fVar.title);
                    i5 = 8;
                } else {
                    i5 = 8;
                    textView2.setVisibility(8);
                    imageView2.setVisibility(z3 ? 1 : 0);
                }
                if (!TextUtils.isEmpty(baseAdSlot.getAppName())) {
                    textView.setVisibility(z3 ? 1 : 0);
                    textView.setText(baseAdSlot.getAppName());
                } else {
                    textView.setVisibility(i5);
                    imageView2.setVisibility(i5);
                }
                if (!TextUtils.isEmpty(fVar.iconUrl)) {
                    imageView.setVisibility(z3 ? 1 : 0);
                    iVar.d = imageView;
                    iVar.a(fVar.iconUrl, z3);
                    r4 = z3;
                } else {
                    imageView.setVisibility(i5);
                    r4 = z3;
                }
            }
            String[] strArrA7 = a(cVar.b.getAct_type());
            textView3.setText(strArrA7[r4] + strArrA7[1]);
            textView3.setOnClickListener(new com.meishu.sdk.meishu_ad.b(vVar, cVar, aVar, splashSkipView));
        }
        i4 = 0;
        iVar = new com.meishu.sdk.core.bquery.i(meishuSplashRootView);
        if (z2) {
            RelativeLayout.LayoutParams layoutParams15 = (RelativeLayout.LayoutParams) linearLayout.getLayoutParams();
            double d9 = ((double) displayMetrics.widthPixels) * 0.86d;
            layoutParams15.width = (int) d9;
            layoutParams15.height = (int) ((d9 * ((double) i2)) / ((double) i3));
            int i110 = (int) (((double) displayMetrics.heightPixels) * 0.07d);
            layoutParams15.topMargin = i110;
            layoutParams15.bottomMargin = i110;
            linearLayout.setLayoutParams(layoutParams15);
            if (!com.meishu.sdk.core.utils.h.d(cVar.b.getAct_type())) {
                Drawable drawable117 = vVar.f5096a.getResources().getDrawable(R.drawable.ms_shake_angle);
                drawable117.setBounds(0, 0, 100, 100);
                textView3.setPadding(60, 0, 60, 0);
                textView3.setCompoundDrawables(drawable117, null, null, null);
            } else {
                Drawable drawable118 = vVar.f5096a.getResources().getDrawable(R.drawable.ms_shake_angle);
                drawable118.setBounds(0, 0, 100, 100);
                textView3.setPadding(60, 0, 60, 0);
                textView3.setCompoundDrawables(drawable118, null, null, null);
            }
            textView.setVisibility(8);
            textView2.setVisibility(8);
            imageView2.setVisibility(8);
            imageView.setVisibility(8);
            r4 = 0;
        } else {
            RelativeLayout.LayoutParams layoutParams16 = (RelativeLayout.LayoutParams) linearLayout.getLayoutParams();
            layoutParams16.width = (int) (((double) displayMetrics.widthPixels) * 0.86d);
            layoutParams16.height = -2;
            int i111 = (int) (((double) displayMetrics.heightPixels) * 0.07d);
            layoutParams16.topMargin = i111;
            layoutParams16.bottomMargin = i111;
            linearLayout.setLayoutParams(layoutParams16);
            if (com.meishu.sdk.core.utils.h.d(cVar.b.getAct_type())) {
                Drawable drawable119 = vVar.f5096a.getResources().getDrawable(R.drawable.ms_shake_angle);
                z3 = false;
                drawable119.setBounds(0, 0, 100, 100);
                textView3.setPadding(60, 0, 60, 0);
                textView3.setCompoundDrawables(drawable119, null, null, null);
            } else {
                Drawable drawable1110 = vVar.f5096a.getResources().getDrawable(R.drawable.ms_shake_angle);
                z3 = false;
                drawable1110.setBounds(0, 0, 100, 100);
                textView3.setPadding(60, 0, 60, 0);
                textView3.setCompoundDrawables(drawable1110, null, null, null);
            }
            fVar = (com.meishu.sdk.meishu_ad.nativ.f) baseAdSlot;
            if (!TextUtils.isEmpty(fVar.desc)) {
                textView2.setVisibility(z3 ? 1 : 0);
                textView2.setText(fVar.title);
                i5 = 8;
            } else {
                i5 = 8;
                textView2.setVisibility(8);
                imageView2.setVisibility(z3 ? 1 : 0);
            }
            if (!TextUtils.isEmpty(baseAdSlot.getAppName())) {
                textView.setVisibility(z3 ? 1 : 0);
                textView.setText(baseAdSlot.getAppName());
            } else {
                textView.setVisibility(i5);
                imageView2.setVisibility(i5);
            }
            if (!TextUtils.isEmpty(fVar.iconUrl)) {
                imageView.setVisibility(z3 ? 1 : 0);
                iVar.d = imageView;
                iVar.a(fVar.iconUrl, z3);
                r4 = z3;
            } else {
                imageView.setVisibility(i5);
                r4 = z3;
            }
        }
        String[] strArrA8 = a(cVar.b.getAct_type());
        textView3.setText(strArrA8[r4] + strArrA8[1]);
        textView3.setOnClickListener(new com.meishu.sdk.meishu_ad.b(vVar, cVar, aVar, splashSkipView));
    }

    public static String[] a(int i2) {
        String str;
        boolean z = true;
        boolean z2 = (i2 & 2) == 2;
        boolean z3 = (i2 & 4) == 4 || (i2 & 64) == 64;
        boolean zE = com.meishu.sdk.core.utils.h.e(i2);
        if ((i2 & 32) != 32 && (i2 & 128) != 128) {
            z = false;
        }
        String str2 = z2 ? "查看详情" : "跳转详情页或第三方应用";
        if (z2) {
            if (z3) {
                str = "摇动或点击";
            } else if (zE) {
                str = "扭动或点击";
            } else {
                str = z ? "上滑或点击" : "点击";
            }
        } else if (z3) {
            str = "摇一摇";
        } else if (zE) {
            str = "扭一扭";
        } else {
            str = z ? "向上滑动" : "";
        }
        return new String[]{str, str2};
    }

    public final void a(com.meishu.sdk.meishu_ad.splash.a aVar, com.meishu.sdk.meishu_ad.splash.d dVar, com.meishu.sdk.meishu_ad.splash.c cVar, MeishuSplashRootView meishuSplashRootView, View view, int i2, int i3) {
        ImageView imageView;
        v vVar;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        ImageView imageView2 = (ImageView) meishuSplashRootView.findViewById(R.id.ms_splash_image_bg);
        this.r = (GifImageView) meishuSplashRootView.findViewById(R.id.ms_splash_image);
        int scale_type = dVar.getScale_type();
        if (scale_type == -1) {
            scale_type = 2;
        }
        int i9 = scale_type;
        try {
            DisplayMetrics displayMetrics = this.f5096a.getResources().getDisplayMetrics();
            if (i2 <= 0) {
                try {
                    i6 = displayMetrics.widthPixels;
                } catch (Exception e2) {
                    e = e2;
                    i4 = i2;
                    i5 = i3;
                    vVar = this;
                    imageView = imageView2;
                    GifImageView gifImageView = vVar.r;
                    ErrorCodeUtil.RES_LOAD_ERROR.intValue();
                    a(cVar, gifImageView, imageView, i9, dVar, aVar, i4, i5);
                    e.printStackTrace();
                }
            } else {
                i6 = i2;
            }
            if (i3 <= 0) {
                try {
                    i7 = displayMetrics.heightPixels;
                } catch (Exception e3) {
                    e = e3;
                    i5 = i3;
                    vVar = this;
                    imageView = imageView2;
                    i4 = i6;
                    GifImageView gifImageView2 = vVar.r;
                    ErrorCodeUtil.RES_LOAD_ERROR.intValue();
                    a(cVar, gifImageView2, imageView, i9, dVar, aVar, i4, i5);
                    e.printStackTrace();
                }
            } else {
                i7 = i3;
            }
            try {
                this.r.setVisibility(0);
                meishuSplashRootView.findViewById(R.id.ms_splash_video).setVisibility(8);
                if (this.n == 0) {
                    try {
                        this.n = System.currentTimeMillis();
                    } catch (Exception e4) {
                        e = e4;
                        i5 = i7;
                        vVar = this;
                        imageView = imageView2;
                        i4 = i6;
                        GifImageView gifImageView3 = vVar.r;
                        ErrorCodeUtil.RES_LOAD_ERROR.intValue();
                        a(cVar, gifImageView3, imageView, i9, dVar, aVar, i4, i5);
                        e.printStackTrace();
                    }
                }
                j1 j1Var = new j1();
                String str = dVar.getImageUrls()[0];
                int iB = b(dVar.getMaterialTimeout(2000));
                imageView = imageView2;
                int i10 = i7;
                try {
                    j1Var.f4915a = new u(this, cVar, meishuSplashRootView, aVar, view, imageView2, i9, dVar, i6, i10);
                    try {
                        new Timer().schedule(new h1(j1Var), iB > 0 ? iB : ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                    i1 i1Var = new i1(j1Var);
                    OkHttpClient okHttpClient = com.meishu.sdk.core.utils.z.f4956a;
                    i8 = i10;
                    try {
                        com.meishu.sdk.core.cache.c.a(str, new com.meishu.sdk.core.utils.b0(i1Var, i9, i6, i8));
                    } catch (Exception e5) {
                        e = e5;
                        vVar = this;
                        i5 = i8;
                        i4 = i6;
                        GifImageView gifImageView4 = vVar.r;
                        ErrorCodeUtil.RES_LOAD_ERROR.intValue();
                        a(cVar, gifImageView4, imageView, i9, dVar, aVar, i4, i5);
                        e.printStackTrace();
                    }
                } catch (Exception e6) {
                    e = e6;
                    i8 = i10;
                }
            } catch (Exception e7) {
                e = e7;
                i8 = i7;
                imageView = imageView2;
            }
        } catch (Exception e8) {
            e = e8;
            imageView = imageView2;
            vVar = this;
            i4 = i2;
            i5 = i3;
        }
    }

    public static void a(boolean z, com.meishu.sdk.meishu_ad.splash.a aVar, com.meishu.sdk.meishu_ad.splash.c cVar) {
        if (!z || aVar == null) {
            return;
        }
        ((com.meishu.sdk.platform.ms.splash.g) aVar).onADLoaded(cVar);
    }

    public final void a(com.meishu.sdk.meishu_ad.splash.c cVar, ImageView imageView, ImageView imageView2, int i2, com.meishu.sdk.meishu_ad.splash.d dVar, com.meishu.sdk.meishu_ad.splash.a aVar, int i3, int i4) {
        this.s = true;
        if (cVar.b.getAdPatternType() != 2) {
            try {
                o1.c(cVar.b.getEventUrl(), ErrorCodeUtil.RENDER_AD_RESULT, "加载失败 cid:" + dVar.getCid());
            } catch (Throwable th) {
                th.printStackTrace();
            }
            o1.b(dVar.getEventUrl(), ErrorCodeUtil.RES_LOAD_ERROR.intValue(), "加载失败,cid=" + dVar.getCid());
        }
        try {
            byte[] bArrA = com.meishu.sdk.core.utils.e0.a(dVar.getDefImage());
            if (bArrA != null) {
                a(cVar, imageView, imageView2, i2, dVar, aVar, i3, i4, bArrA, true);
                return;
            }
            String[] eventUrl = dVar.getEventUrl();
            Integer num = ErrorCodeUtil.RES_LOAD_ERROR;
            o1.b(eventUrl, num.intValue(), "load res error defImage is null,cid=" + dVar.getCid());
            a(aVar, "load res error defImage is null,cid=" + dVar.getCid(), num);
        } catch (Throwable th2) {
            String[] eventUrl2 = dVar.getEventUrl();
            Integer num2 = ErrorCodeUtil.RES_LOAD_ERROR;
            o1.b(eventUrl2, num2.intValue(), com.meishu.sdk.activity.a.a("load res error ,cid=").append(dVar.getCid()).append(",throwable=").append(th2.getMessage()).toString());
            a(aVar, com.meishu.sdk.activity.a.a("load res error ,cid=").append(dVar.getCid()).append(",throwable=").append(th2.getMessage()).toString(), num2);
            th2.printStackTrace();
        }
    }

    public final void a(com.meishu.sdk.meishu_ad.splash.c cVar, ImageView imageView, ImageView imageView2, int i2, com.meishu.sdk.meishu_ad.splash.d dVar, com.meishu.sdk.meishu_ad.splash.a aVar, int i3, int i4, byte[] bArr, boolean z) {
        try {
            imageView.setVisibility(0);
            Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
            if (bitmapDecodeByteArray != null) {
                Bitmap[] bitmapArrA = a(i2, bitmapDecodeByteArray, i3, i4);
                if (bitmapArrA.length == 2) {
                    bitmapDecodeByteArray = bitmapArrA[0];
                    a(i2, bitmapDecodeByteArray, imageView, imageView2, bitmapArrA[1]);
                }
                k1.a(dVar, z ? 3 : 2, z);
                cVar.setWidth(Integer.valueOf(bitmapDecodeByteArray.getWidth()));
                cVar.setHeight(Integer.valueOf(bitmapDecodeByteArray.getHeight()));
                this.p = System.currentTimeMillis();
                a(this.A != 1, aVar, cVar);
                this.h = true;
                try {
                    dVar.getAppendInfo().getResLoadSuccess().a(true);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                if (this.f != 1 || this.g) {
                    dVar.setMonitorUrl(com.meishu.sdk.core.utils.h0.b(dVar.getMonitorUrl(), a()));
                    if (dVar.getAdPatternType() == 2) {
                        com.meishu.sdk.core.utils.h0.b(dVar.getMonitorUrl());
                    }
                    a(cVar, aVar);
                    return;
                }
                return;
            }
            String[] eventUrl = dVar.getEventUrl();
            Integer num = ErrorCodeUtil.RES_LOAD_ERROR;
            o1.b(eventUrl, num.intValue(), "load res error defImage bitmap is null,cid=" + dVar.getCid());
            a(aVar, "load res error defImage bitmap is null,cid=" + dVar.getCid(), num);
            if (z) {
                String defImage = dVar.getDefImage();
                RenderScript renderScript = com.meishu.sdk.core.utils.e0.f4899a;
                try {
                    if (TextUtils.isEmpty(defImage)) {
                        return;
                    }
                    String strA = com.meishu.sdk.core.utils.e0.a(defImage, ".jpg");
                    File file = new File(com.meishu.sdk.core.utils.e0.b(), strA);
                    if (file.exists()) {
                        file.delete();
                    }
                    AdSdk.getSharedPreferences().edit().remove(strA).apply();
                    return;
                } catch (Exception e3) {
                    e3.printStackTrace();
                    return;
                }
            }
            return;
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        e4.printStackTrace();
    }

    public static Bitmap[] a(int i2, Bitmap bitmap, int i3, int i4) {
        try {
            switch (i2) {
                case 1:
                    if ((bitmap.getHeight() * 1.0f) / i4 > (bitmap.getWidth() * 1.0f) / i3) {
                        return b(bitmap, i3, i4, i2);
                    }
                    return a(bitmap, i3, i4, i2);
                case 2:
                default:
                    if ((bitmap.getWidth() * 1.0f) / i3 > (bitmap.getHeight() * 1.0f) / i4) {
                        return b(bitmap, i3, i4, i2);
                    }
                    return a(bitmap, i3, i4, i2);
                case 3:
                case 4:
                case 5:
                    return b(bitmap, i3, i4, i2);
                case 6:
                case 7:
                case 8:
                    return a(bitmap, i3, i4, i2);
                case 9:
                    return new Bitmap[]{bitmap, null};
            }
        } catch (Throwable th) {
            th.printStackTrace();
            return new Bitmap[]{bitmap, null};
        }
    }

    public final void a(int i2, Bitmap bitmap, ImageView imageView, ImageView imageView2, Bitmap bitmap2) {
        try {
            if (bitmap2 != null) {
                imageView.setScaleType(ImageView.ScaleType.CENTER);
            } else {
                imageView.setScaleType(ImageView.ScaleType.MATRIX);
            }
            if (i2 == 9) {
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            }
            imageView.setImageBitmap(bitmap);
        } catch (Throwable th) {
            th.printStackTrace();
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        }
        if (bitmap2 != null) {
            try {
                imageView2.setVisibility(0);
                imageView2.setImageBitmap(bitmap2);
                imageView2.setImageAlpha(MediaPlayer.MEDIA_PLAYER_OPTION_SLOW_PLAY_SPEED);
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    }

    public static Bitmap[] a(Bitmap bitmap, int i2, int i3, int i4) {
        int i5;
        int i6;
        Bitmap[] bitmapArr = new Bitmap[2];
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float f2 = (i3 * 1.0f) / height;
        Matrix matrix = new Matrix();
        matrix.postScale(f2, f2);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, false);
        bitmapCreateBitmap.getHeight();
        int width2 = bitmapCreateBitmap.getWidth();
        if (width2 < i2) {
            try {
                AdSdk.getContext();
                bitmapArr[1] = com.meishu.sdk.core.utils.e0.a(bitmapCreateBitmap, 25);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        } else {
            if (i4 == 6 || i4 == 2 || i4 == 1) {
                i5 = (width2 - i2) / 2;
            } else {
                if (i4 != 7 && i4 == 8) {
                    i5 = width2 - i2;
                } else {
                    i6 = 0;
                }
                bitmapCreateBitmap = Bitmap.createBitmap(bitmapCreateBitmap, i6, 0, i2, i3, (Matrix) null, false);
            }
            i6 = i5;
            bitmapCreateBitmap = Bitmap.createBitmap(bitmapCreateBitmap, i6, 0, i2, i3, (Matrix) null, false);
        }
        bitmapArr[0] = bitmapCreateBitmap;
        return bitmapArr;
    }

    /* JADX WARN: Code duplicated, block: B:36:0x00e8 A[Catch: Exception -> 0x010b, TryCatch #0 {Exception -> 0x010b, blocks: (B:34:0x00dc, B:36:0x00e8, B:38:0x00ee, B:39:0x00f7, B:41:0x00fe, B:43:0x0102, B:44:0x0108), top: B:91:0x00dc }] */
    /* JADX WARN: Code duplicated, block: B:38:0x00ee A[Catch: Exception -> 0x010b, TryCatch #0 {Exception -> 0x010b, blocks: (B:34:0x00dc, B:36:0x00e8, B:38:0x00ee, B:39:0x00f7, B:41:0x00fe, B:43:0x0102, B:44:0x0108), top: B:91:0x00dc }] */
    /* JADX WARN: Code duplicated, block: B:39:0x00f7 A[Catch: Exception -> 0x010b, TryCatch #0 {Exception -> 0x010b, blocks: (B:34:0x00dc, B:36:0x00e8, B:38:0x00ee, B:39:0x00f7, B:41:0x00fe, B:43:0x0102, B:44:0x0108), top: B:91:0x00dc }] */
    /* JADX WARN: Code duplicated, block: B:44:0x0108 A[Catch: Exception -> 0x010b, TRY_LEAVE, TryCatch #0 {Exception -> 0x010b, blocks: (B:34:0x00dc, B:36:0x00e8, B:38:0x00ee, B:39:0x00f7, B:41:0x00fe, B:43:0x0102, B:44:0x0108), top: B:91:0x00dc }] */
    /* JADX WARN: Code duplicated, block: B:65:0x0186  */
    /* JADX WARN: Type inference failed for: r15v2 */
    /* JADX WARN: Type inference failed for: r15v3, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r15v5 */
    public final void a(com.meishu.sdk.meishu_ad.splash.a aVar, com.meishu.sdk.meishu_ad.splash.d dVar, com.meishu.sdk.meishu_ad.splash.c cVar, MeishuSplashRootView meishuSplashRootView, com.meishu.sdk.core.bquery.i iVar, View view, boolean z, int i2, int i3) {
        ImageView imageView;
        ?? r15;
        String str;
        a0 a0Var;
        int i4;
        File file;
        File fileA;
        byte[] bArrA;
        String defImage;
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        meishuSplashRootView.setVisibility(4);
        meishuSplashRootView.findViewById(R.id.ms_splash_image).setVisibility(8);
        ImageView imageView2 = (ImageView) meishuSplashRootView.findViewById(R.id.ms_splash_image_bg);
        imageView2.setVisibility(0);
        try {
            imageView = imageView2;
            try {
                new Timer().schedule(new z(this, dVar, aVar, cVar, i2, i3, view), b(dVar.getMaterialTimeout(2500)));
            } catch (Throwable th) {
                th = th;
                th.printStackTrace();
            }
        } catch (Throwable th2) {
            th = th2;
            imageView = imageView2;
        }
        this.n = System.currentTimeMillis();
        String video_cover = dVar.getVideo_cover();
        try {
            try {
                try {
                    if (!TextUtils.isEmpty(video_cover)) {
                        dVar.getScale_type();
                        DisplayMetrics displayMetrics = this.f5096a.getResources().getDisplayMetrics();
                        int i5 = i2 <= 0 ? displayMetrics.widthPixels : i2;
                        int i6 = i3 <= 0 ? displayMetrics.heightPixels : i3;
                        if (this.n == 0) {
                            this.n = System.currentTimeMillis();
                        }
                        if (!TextUtils.isEmpty(dVar.getVideo_cover())) {
                            r15 = 1;
                            com.meishu.sdk.core.cache.a.a(video_cover, new d0(this, cVar, dVar, aVar, i5, i6, view), true);
                        }
                        bArrA = com.meishu.sdk.core.utils.e0.a(dVar.getDefImage());
                        this.x = bArrA;
                        if (bArrA == null) {
                            defImage = dVar.getDefImage();
                            if (defImage != null) {
                                com.meishu.sdk.core.utils.z.a(defImage, new c0(this, aVar), (boolean) r15);
                            } else {
                                this.w = 2;
                                if (this.u == 2 && this.v == 2) {
                                    a(aVar, "video load error,def isnull", ErrorCodeUtil.RES_LOAD_ERROR);
                                }
                            }
                        } else {
                            this.w = r15;
                        }
                        int i7 = this.f;
                        str = dVar.g;
                        a0Var = new a0(this, cVar, dVar, meishuSplashRootView, aVar, view, i2, i3, z, atomicBoolean, imageView, iVar);
                        com.meishu.sdk.core.bquery.g.a(AdSdk.getContext());
                        file = null;
                        fileA = com.meishu.sdk.core.bquery.g.a(com.meishu.sdk.core.bquery.g.b(AdSdk.getContext()), str, null);
                        if (fileA != null && fileA.exists()) {
                            file = fileA;
                        }
                        if (file == null && file.exists()) {
                            long jCurrentTimeMillis = System.currentTimeMillis() - file.lastModified();
                            if (file.length() > 0 && jCurrentTimeMillis < 86400000) {
                                SdkHandler.getInstance().runOnUiThread(new com.meishu.sdk.core.bquery.a(iVar, a0Var, str, file));
                                return;
                            }
                            file.delete();
                        }
                        if (q0.a() <= 0 && i7 == 0 && q0.a() > 0 && !TextUtils.isEmpty(str) && !str.trim().toLowerCase().contains("m3u8") && str.trim().toLowerCase().startsWith("http")) {
                            int iA = q0.a();
                            com.meishu.sdk.core.bquery.b bVar = new com.meishu.sdk.core.bquery.b(iVar, a0Var);
                            if (TextUtils.isEmpty(str)) {
                                bVar.a();
                                return;
                            }
                            long jCurrentTimeMillis2 = System.currentTimeMillis();
                            ExecutorService executorService = com.meishu.sdk.core.utils.g0.f4905a;
                            com.meishu.sdk.core.utils.g0.b.f4906a.a(new com.meishu.sdk.meishu_ad.view.player.a(0, iA, jCurrentTimeMillis2, bVar, str));
                            return;
                        }
                        i4 = 0;
                        iVar.a(str, 86400000, false, new com.meishu.sdk.core.bquery.c(iVar, a0Var));
                        return;
                    }
                    this.v = 2;
                    if (this.u == 2 && this.w == 2) {
                        a(aVar, "video load error,def isnull", ErrorCodeUtil.RES_LOAD_ERROR);
                    }
                    iVar.a(str, 86400000, false, new com.meishu.sdk.core.bquery.c(iVar, a0Var));
                    return;
                } catch (Throwable th3) {
                    th = th3;
                    th.printStackTrace();
                    a0Var.onFail(i4, "mediaPlayer loadVideo error");
                    return;
                }
                com.meishu.sdk.core.bquery.g.a(AdSdk.getContext());
                file = null;
                fileA = com.meishu.sdk.core.bquery.g.a(com.meishu.sdk.core.bquery.g.b(AdSdk.getContext()), str, null);
                if (fileA != null) {
                    file = fileA;
                }
                if (file == null) {
                }
                if (q0.a() <= 0) {
                }
                i4 = 0;
            } catch (Throwable th4) {
                th = th4;
                i4 = 0;
            }
            bArrA = com.meishu.sdk.core.utils.e0.a(dVar.getDefImage());
            this.x = bArrA;
            if (bArrA == null) {
                defImage = dVar.getDefImage();
                if (defImage != null) {
                    com.meishu.sdk.core.utils.z.a(defImage, new c0(this, aVar), (boolean) r15);
                } else {
                    this.w = 2;
                    if (this.u == 2) {
                        a(aVar, "video load error,def isnull", ErrorCodeUtil.RES_LOAD_ERROR);
                    }
                }
            } else {
                this.w = r15;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        r15 = 1;
        int i8 = this.f;
        str = dVar.g;
        a0Var = new a0(this, cVar, dVar, meishuSplashRootView, aVar, view, i2, i3, z, atomicBoolean, imageView, iVar);
    }

    public static void a(com.meishu.sdk.meishu_ad.splash.d dVar) {
        try {
            dVar.getAppendInfo().getResLoadSuccess().a(true);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void a(v vVar, com.meishu.sdk.meishu_ad.splash.c cVar, com.meishu.sdk.meishu_ad.splash.d dVar, int i2, int i3, com.meishu.sdk.meishu_ad.splash.a aVar, View view) {
        byte[] bArr;
        byte[] bArr2;
        byte[] bArr3;
        if (vVar.y) {
            return;
        }
        vVar.y = true;
        if (vVar.u == 2 && vVar.v == 2 && vVar.w == 2) {
            vVar.a(aVar, com.meishu.sdk.activity.a.a("load res all error,cid=").append(dVar.getCid()).toString(), ErrorCodeUtil.RES_LOAD_ERROR);
            return;
        }
        vVar.o = System.currentTimeMillis();
        int scale_type = dVar.getScale_type();
        int i4 = scale_type == -1 ? 2 : scale_type;
        DisplayMetrics displayMetrics = vVar.f5096a.getResources().getDisplayMetrics();
        int i5 = i2 <= 0 ? displayMetrics.widthPixels : i2;
        int i6 = i3 <= 0 ? displayMetrics.heightPixels : i3;
        GifImageView gifImageView = (GifImageView) vVar.q.findViewById(R.id.ms_splash_image);
        vVar.r = gifImageView;
        gifImageView.setVisibility(0);
        vVar.q.findViewById(R.id.ms_splash_video).setVisibility(8);
        vVar.p = System.currentTimeMillis();
        vVar.a(cVar, vVar.q, aVar, view, true);
        ImageView imageView = (ImageView) vVar.q.findViewById(R.id.ms_splash_image_bg);
        if (vVar.v == 1 && (bArr3 = vVar.t) != null) {
            vVar.a(cVar, vVar.r, imageView, i4, dVar, aVar, i5, i6, bArr3, false);
            return;
        }
        if (vVar.k) {
            if (vVar.w != 1 || (bArr2 = vVar.x) == null) {
                return;
            }
            vVar.a(cVar, vVar.r, imageView, i4, dVar, aVar, i5, i6, bArr2, true);
            return;
        }
        if (vVar.v == 2 && vVar.w == 1 && (bArr = vVar.x) != null) {
            vVar.a(cVar, vVar.r, imageView, i4, dVar, aVar, i5, i6, bArr, true);
        }
    }

    public void a(com.meishu.sdk.meishu_ad.nativ.f fVar, com.meishu.sdk.meishu_ad.nativ.a aVar, com.meishu.sdk.core.ad.b bVar) {
        int ar;
        int i2;
        try {
            this.d = fVar.getEventUrl();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        boolean z = bVar instanceof RewardVideoLoader;
        NormalMediaView normalMediaView = new NormalMediaView(new ContextWrapper(this.f5096a));
        normalMediaView.setAdListener(aVar);
        ArrayList arrayList = new ArrayList();
        com.meishu.sdk.meishu_ad.nativ.d dVar = new com.meishu.sdk.meishu_ad.nativ.d(fVar);
        dVar.e = fVar.title;
        dVar.f = fVar.desc;
        dVar.b = fVar.getAdPatternType();
        dVar.c = fVar.iconUrl;
        dVar.d = fVar.getImageUrls();
        dVar.h = normalMediaView;
        dVar.k = bVar.getVideoIsMute();
        fVar.getCid();
        dVar.f5045a = z ? AdType.REWARD.value() : 0;
        arrayList.add(dVar);
        if (z) {
            try {
                PackageBean.AdBean adBean = q0.m;
                ar = (adBean == null || adBean.getReward() == null) ? 0 : q0.m.getReward().getAr();
            } catch (Exception unused) {
            }
            if (ar != 1 && d1.a(this.f5096a, fVar) && fVar.getRewardTmpId() == 1) {
                LogUtil.dev("AdNative", "rewardAr change 1. because rewardTmp 1");
                i2 = 1;
            } else {
                i2 = ar;
            }
        } else {
            i2 = 0;
        }
        LogUtil.dev("AdNative", "rewardAr: " + i2 + " mainThread:" + (Looper.myLooper() == Looper.getMainLooper()));
        if (i2 == 1 && aVar != null) {
            aVar.onADLoaded(arrayList);
        }
        this.n = System.currentTimeMillis();
        com.meishu.sdk.core.webview.s[] sVarArr = new com.meishu.sdk.core.webview.s[1];
        com.meishu.sdk.meishu_ad.reward.i iVar = new com.meishu.sdk.meishu_ad.reward.i(new c(dVar, sVarArr, aVar, i2, arrayList));
        String h5Url = fVar.getH5Url();
        if (!TextUtils.isEmpty(h5Url) && z) {
            sVarArr[0] = com.meishu.sdk.core.webview.o.a(this.f5096a, h5Url, dVar, null, new d(this, iVar), null);
        } else {
            iVar.d(false);
        }
        if (fVar.getAdPatternType() == 2) {
            SdkHandler.getInstance().postDelay(new e(this, iVar), C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS);
            com.meishu.sdk.core.utils.z.a(fVar.g, new f(normalMediaView, fVar, bVar, iVar));
        } else {
            iVar.b(true);
        }
    }

    public final void a(com.meishu.sdk.meishu_ad.nativ.f fVar, com.meishu.sdk.meishu_ad.nativ.a aVar, boolean z, boolean z2, boolean z3, float f2, float f3) {
        ArrayList arrayList = new ArrayList();
        NormalMediaView normalMediaView = new NormalMediaView(this.f5096a);
        if (fVar.getAdPatternType() == 2) {
            this.n = System.currentTimeMillis();
            com.meishu.sdk.core.utils.z.a(fVar.g, new g(normalMediaView, aVar, z, fVar, z3, f2, f3, z2, arrayList));
        } else if (fVar.getAdPatternType() != 11 && fVar.getAdPatternType() != 12 && fVar.getAdPatternType() != 13 && fVar.getAdPatternType() != 1) {
            LogUtil.i("AdNative", com.meishu.sdk.activity.a.a("unsupported type: ").append(fVar.getAdPatternType()).toString());
            a(aVar, "不支持的广告类型", ErrorCodeUtil.UNSUPPORTED_TYPE);
        } else {
            com.meishu.sdk.core.utils.z.a(fVar.getImageUrls()[0], new h(fVar, aVar, z2, normalMediaView, arrayList));
        }
    }

    public static void a(com.meishu.sdk.meishu_ad.nativ.f fVar, com.meishu.sdk.meishu_ad.nativ.a aVar, boolean z, NormalMediaView normalMediaView, List list) {
        normalMediaView.setOnVideoLoadedListener(new i0(fVar, z, list, aVar));
        n0.c cVar = normalMediaView.A;
        if (cVar != null) {
            cVar.onLoaded(normalMediaView);
        }
    }

    public String a() {
        return this.n + "." + this.o + "." + this.p;
    }
}
