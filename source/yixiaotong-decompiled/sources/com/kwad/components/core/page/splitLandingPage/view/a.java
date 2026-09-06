package com.kwad.components.core.page.splitLandingPage.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.content.Context;
import android.graphics.Rect;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.kwad.components.core.t.x;
import com.kwad.components.core.video.e;
import com.kwad.components.core.video.g;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.contentalliance.a.a.b;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.helper.h;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.video.videoview.AdVideoPlayerViewCache;
import com.kwad.sdk.wrapper.m;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class a {
    private ViewGroup Dy;
    private ImageView Pa;
    private WindowManager afC;
    private com.kwad.components.core.page.splitLandingPage.a.a afD;
    private FrameLayout afE;
    private FrameLayout afF;
    private e afG;
    private final WindowManager.LayoutParams afH = new WindowManager.LayoutParams();
    private InterfaceC0683a afI;
    private com.kwad.sdk.core.video.videoview.a cB;
    private com.kwad.sdk.core.video.videoview.a.InterfaceC0750a cK;
    private ImageView ik;
    private Context mContext;

    /* JADX INFO: renamed from: com.kwad.components.core.page.splitLandingPage.view.a$a, reason: collision with other inner class name */
    public interface InterfaceC0683a {
        boolean uQ();
    }

    public final void a(InterfaceC0683a interfaceC0683a) {
        this.afI = interfaceC0683a;
    }

    public a(Context context, com.kwad.components.core.page.splitLandingPage.a.a aVar) {
        if (context == null) {
            return;
        }
        Context contextWrapContextIfNeed = m.wrapContextIfNeed(context);
        this.mContext = contextWrapContextIfNeed;
        this.afD = aVar;
        WindowManager windowManager = (WindowManager) contextWrapContextIfNeed.getSystemService("window");
        this.afC = windowManager;
        if (windowManager == null) {
            return;
        }
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(this.mContext).inflate(R.layout.ksad_split_mini_video, (ViewGroup) null);
        this.Dy = viewGroup;
        this.afE = (FrameLayout) viewGroup.findViewById(R.id.ksad_split_texture);
        this.afF = (FrameLayout) this.Dy.findViewById(R.id.ksad_video_container);
        this.ik = (ImageView) this.Dy.findViewById(R.id.ksad_video_first_frame_container);
        this.Pa = (ImageView) this.Dy.findViewById(R.id.ksad_split_mini_close_btn);
        this.afE.setOnTouchListener(new View.OnTouchListener() { // from class: com.kwad.components.core.page.splitLandingPage.view.a.1
            float afJ = 0.0f;
            float afK = 0.0f;
            float top = 0.0f;
            float left = 0.0f;
            long afL = 0;

            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (a.this.afH == null) {
                    return false;
                }
                if (motionEvent.getActionMasked() == 0) {
                    this.afJ = motionEvent.getRawX();
                    this.afK = motionEvent.getRawY();
                    this.left = a.this.afH.x;
                    this.top = a.this.afH.y;
                    this.afL = SystemClock.elapsedRealtime();
                    System.out.println(" actionDownX " + this.afJ + " actionDownX " + this.afJ);
                } else {
                    if (motionEvent.getActionMasked() == 2) {
                        float rawX = motionEvent.getRawX() - this.afJ;
                        float rawY = motionEvent.getRawY() - this.afK;
                        if (Math.sqrt((rawX * rawX) + (rawY * rawY)) > 15.0d) {
                            a.this.afH.x = (int) (this.left + rawX);
                            a.this.afH.y = (int) (this.top + rawY);
                            if (a.this.afC != null) {
                                try {
                                    a.this.afC.updateViewLayout(a.this.Dy, a.this.afH);
                                } catch (Exception e) {
                                    com.kwad.components.core.d.a.reportSdkCaughtException(e);
                                    c.printStackTraceOnly(e);
                                }
                            }
                        }
                        return true;
                    }
                    if (motionEvent.getActionMasked() == 1) {
                        float rawX2 = motionEvent.getRawX() - this.afJ;
                        float rawY2 = motionEvent.getRawY() - this.afK;
                        float fElapsedRealtime = SystemClock.elapsedRealtime() - this.afL;
                        if (Math.sqrt((rawX2 * rawX2) + (rawY2 * rawY2)) < 15.0d && fElapsedRealtime > 30.0f && fElapsedRealtime < 300.0f && a.this.afI != null && a.this.afD != null && com.kwad.sdk.core.response.helper.a.aL(com.kwad.sdk.core.response.helper.e.eO(a.this.afD.getAdTemplate()))) {
                            a.this.afI.uQ();
                        }
                    }
                }
                return true;
            }
        });
    }

    public final void uP() {
        this.afG.af();
    }

    public final boolean isVisible() {
        return this.Dy.getAlpha() > 0.0f;
    }

    public final boolean uS() {
        if (this.afD == null || this.afC == null) {
            return false;
        }
        c(new KsAdVideoPlayConfig.Builder().videoSoundEnable(this.afD.getAdTemplate().mIsAudioEnable).build());
        AdInfo adInfoEO = com.kwad.sdk.core.response.helper.e.eO(this.afD.getAdTemplate());
        int iT = com.kwad.sdk.core.response.helper.a.T(adInfoEO);
        int iS = com.kwad.sdk.core.response.helper.a.S(adInfoEO);
        Rect rect = new Rect();
        DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
        if (iT > iS) {
            rect.right = displayMetrics.widthPixels;
            rect.left = rect.right - com.kwad.sdk.c.a.a.a(this.mContext, 86.0f);
            rect.bottom = displayMetrics.heightPixels - com.kwad.sdk.c.a.a.a(this.mContext, 252.0f);
            rect.top = rect.bottom - com.kwad.sdk.c.a.a.a(this.mContext, 154.0f);
        } else {
            rect.right = displayMetrics.widthPixels;
            rect.left = rect.right - com.kwad.sdk.c.a.a.a(this.mContext, 154.0f);
            rect.bottom = displayMetrics.heightPixels - com.kwad.sdk.c.a.a.a(this.mContext, 252.0f);
            rect.top = rect.bottom - com.kwad.sdk.c.a.a.a(this.mContext, 86.0f);
        }
        rect.left -= com.kwad.sdk.c.a.a.a(this.mContext, 12.0f);
        rect.right -= com.kwad.sdk.c.a.a.a(this.mContext, 12.0f);
        this.afH.type = 1003;
        this.afH.flags = 8;
        this.afH.gravity = 51;
        this.afH.format = 1;
        this.afH.width = displayMetrics.widthPixels;
        this.afH.height = displayMetrics.heightPixels;
        this.afH.x = rect.left;
        this.afH.y = rect.top;
        this.afH.width = (rect.right - rect.left) + com.kwad.sdk.c.a.a.a(this.mContext, 12.0f);
        this.afH.height = (rect.bottom - rect.top) + com.kwad.sdk.c.a.a.a(this.mContext, 12.0f);
        float f = (rect.left * displayMetrics.widthPixels) / ((rect.left + displayMetrics.widthPixels) - rect.right);
        float f2 = (rect.top * displayMetrics.heightPixels) / ((rect.top + displayMetrics.heightPixels) - rect.bottom);
        this.Dy.setPivotX(f);
        this.Dy.setPivotY(f2);
        this.Dy.setAlpha(0.0f);
        if (this.afC != null) {
            try {
                if (this.Dy.getWindowToken() == null) {
                    this.afC.addView(this.Dy, this.afH);
                }
            } catch (Exception e) {
                com.kwad.components.core.d.a.reportSdkCaughtException(e);
                c.printStackTraceOnly(e);
            }
        }
        this.Pa.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.page.splitLandingPage.view.a.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                a.this.uP();
                a.this.aV(false).start();
            }
        });
        return true;
    }

    private void c(KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        final AdTemplate adTemplate = this.afD.getAdTemplate();
        AdInfo adInfoEO = com.kwad.sdk.core.response.helper.e.eO(adTemplate);
        String url = com.kwad.sdk.core.response.helper.a.bA(adInfoEO).getUrl();
        if (!TextUtils.isEmpty(url)) {
            this.ik.setImageDrawable(null);
            KSImageLoader.loadImage(this.ik, url, adTemplate);
            this.ik.setVisibility(0);
        } else {
            this.ik.setVisibility(8);
        }
        String strM = com.kwad.sdk.core.response.helper.a.M(adInfoEO);
        if (TextUtils.isEmpty(strM)) {
            return;
        }
        com.kwad.sdk.core.video.videoview.a aVarFt = AdVideoPlayerViewCache.getInstance().ft(strM);
        this.cB = aVarFt;
        if (aVarFt == null) {
            this.cB = new com.kwad.sdk.core.video.videoview.a(this.mContext);
            com.kwad.sdk.core.response.helper.a.ae(adInfoEO);
            this.cB.a(new b.a(adTemplate).a(adTemplate.mVideoPlayerStatus).dQ(com.kwad.sdk.core.response.helper.e.eQ(adTemplate)).dR(h.b(com.kwad.sdk.core.response.helper.e.eP(adTemplate))).b(new com.kwad.sdk.contentalliance.a.a.a(adTemplate, System.currentTimeMillis())).IG(), null);
            com.kwad.sdk.core.video.videoview.a.InterfaceC0750a interfaceC0750a = new com.kwad.sdk.core.video.videoview.a.InterfaceC0750a() { // from class: com.kwad.components.core.page.splitLandingPage.view.a.3
                @Override // com.kwad.sdk.core.video.videoview.a.InterfaceC0750a
                public final com.kwad.sdk.core.video.a.c a(b bVar) {
                    if (!((Boolean) com.kwad.sdk.core.config.e.b(com.kwad.sdk.core.config.c.aQq)).booleanValue() || !((Boolean) com.kwad.sdk.core.config.e.b(com.kwad.sdk.core.config.c.aQr)).booleanValue()) {
                        return null;
                    }
                    g gVar = new g(bVar, adTemplate);
                    if (g.isWaynePlayerReady()) {
                        return gVar;
                    }
                    return null;
                }
            };
            this.cK = interfaceC0750a;
            this.cB.setExternalPlayerListener(interfaceC0750a);
            this.cB.setVideoSoundEnable(ksAdVideoPlayConfig.isVideoSoundEnable());
            e eVar = new e(this.mContext, adTemplate, this.cB, ksAdVideoPlayConfig);
            this.afG = eVar;
            eVar.setDataFlowAutoStart(ksAdVideoPlayConfig.isDataFlowAutoStart());
            this.cB.setController(this.afG);
            this.afG.setAutoRelease(false);
        } else {
            e eVar2 = (e) aVarFt.getController();
            this.afG = eVar2;
            eVar2.setAutoRelease(false);
            this.afG.getAdTemplate().mAdWebVideoPageShowing = true;
        }
        this.cB.setVideoSoundEnable(ksAdVideoPlayConfig.isVideoSoundEnable());
        if (this.cB.getParent() != null) {
            ((ViewGroup) this.cB.getParent()).removeView(this.cB);
        }
        if (this.afF.getTag() != null) {
            FrameLayout frameLayout = this.afF;
            frameLayout.removeView((View) frameLayout.getTag());
            this.afF.setTag(null);
        }
        this.afF.addView(this.cB);
        this.afF.setTag(this.cB);
        this.afG.setAlpha(0.01f);
        this.afG.setVideoPlayCallback(new com.kwad.components.core.video.a.c() { // from class: com.kwad.components.core.page.splitLandingPage.view.a.4
            @Override // com.kwad.components.core.video.a.c
            public final void as() {
            }

            @Override // com.kwad.components.core.video.a.c
            public final void d(long j) {
            }

            @Override // com.kwad.components.core.video.a.c
            public final void onVideoPlayStart() {
            }

            @Override // com.kwad.components.core.video.a.c
            public final void at() {
                a.this.uP();
                a.this.aV(false).start();
            }
        });
    }

    public final void uT() {
        com.kwad.sdk.core.video.videoview.a aVar = this.cB;
        if (aVar == null || aVar.isPlaying()) {
            return;
        }
        this.afG.xG();
    }

    public final Animator aV(boolean z) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(x.h(this.Dy, z), x.h(this.ik, z));
        return animatorSet;
    }
}
