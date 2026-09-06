package com.adprof.sdk.api;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.adprof.sdk.b;
import com.adprof.sdk.d;
import com.adprof.sdk.e;
import com.adprof.sdk.e6;
import com.adprof.sdk.f;
import com.adprof.sdk.g0;
import com.adprof.sdk.h0;
import com.adprof.sdk.hp;
import com.adprof.sdk.io;
import com.adprof.sdk.j0;
import com.adprof.sdk.k0;
import com.adprof.sdk.md;
import com.adprof.sdk.pk;
import com.adprof.sdk.po;
import com.adprof.sdk.rg;
import com.adprof.sdk.xb;
import com.adprof.sdk.xb.a;
import com.adprof.sdk.zb;
import com.huawei.openalliance.ad.views.PPSLabelView;
import com.stub.StubApp;
import java.io.File;
import java.util.LinkedList;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class AFNativeAdMediaView extends h0 implements e, rg {
    public static LinkedList<ViewGroup> CONTAINER_LIST = new LinkedList<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f1041a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Bitmap f37a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ViewGroup f38a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public j0 f39a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public po f40a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f41a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f42a;
    public Bitmap b;

    /* JADX INFO: renamed from: com.adprof.sdk.api.AFNativeAdMediaView$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f1042a;

        static {
            int[] iArr = new int[b.values().length];
            f1042a = iArr;
            try {
                iArr[0] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1042a[1] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1042a[2] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public AFNativeAdMediaView(Context context) {
        super(StubApp.getOrigApplicationContext(context.getApplicationContext()));
        this.f41a = "NativeAdMediaView";
        this.f37a = null;
        this.b = null;
        this.f42a = false;
        this.f1041a = StubApp.getOrigApplicationContext(context.getApplicationContext());
        getVideoAdView().setVideoAdViewListener(this);
        this.f38a = new RelativeLayout(this.f1041a);
        getVideoAdView().setVideoAdStatusListener(this);
        e6.a(this.f1041a);
    }

    private void setVideoURL(d dVar) {
        po videoAdView;
        String strM;
        File fileM593a = dVar.m593a();
        if (fileM593a == null || !fileM593a.exists()) {
            videoAdView = getVideoAdView();
            strM = dVar.m();
        } else {
            videoAdView = getVideoAdView();
            strM = fileM593a.getAbsolutePath();
        }
        videoAdView.setUp(strM);
        pk.a(new StringBuilder().append(this.f41a).append("-----init ").append(fileM593a).toString() != null ? fileM593a.getAbsolutePath() : "path null " + dVar.m() + PPSLabelView.Code);
    }

    public void animateFinish() {
    }

    public void destroy() {
        ((h0) this).f1200a = null;
        zb.a(this.f37a);
        zb.a(this.b);
        j0 videoAdController = getVideoAdController();
        if (videoAdController != null) {
            k0 k0Var = (k0) videoAdController;
            po poVarA = k0Var.a();
            if (poVarA != null) {
                poVarA.m();
            }
            po poVar = (po) k0Var.f414a.get();
            if (poVar != null) {
                poVar.m();
                poVar.c();
                if (poVar.f606a != null) {
                    poVar.getContext().unregisterReceiver(poVar.f606a);
                    poVar.f606a = null;
                }
            }
            k0Var.f414a.clear();
            k0Var.f1257a = null;
        }
        ViewGroup viewGroup = this.f38a;
        if (viewGroup != null) {
            viewGroup.removeAllViews();
            hp.m656a((View) this.f38a);
        }
        po poVar2 = this.f40a;
        if (poVar2 != null) {
            hp.m656a((View) poVar2);
            this.f40a.setVideoAdViewListener(null);
            this.f40a.setVideoAdStatusListener(null);
            po poVar3 = this.f40a;
            poVar3.m();
            poVar3.c();
            if (poVar3.f606a != null) {
                poVar3.getContext().unregisterReceiver(poVar3.f606a);
                poVar3.f606a = null;
            }
            this.f40a = null;
        }
    }

    public e getAdVideoStatusListener() {
        j0 j0Var = this.f39a;
        if (j0Var != null) {
            return ((k0) j0Var).f1257a;
        }
        return null;
    }

    @Override // com.adprof.sdk.f
    public j0 getVideoAdController() {
        if (this.f39a == null) {
            this.f39a = new k0(getVideoAdView());
        }
        return this.f39a;
    }

    public po getVideoAdView() {
        if (this.f40a == null) {
            this.f40a = new po(this.f1041a);
        }
        return this.f40a;
    }

    @Override // com.adprof.sdk.h0
    public double getVideoDuration() {
        return getVideoAdView() != null ? getVideoAdView().getDuration() / 1000.0f : super.getVideoDuration();
    }

    @Override // com.adprof.sdk.h0
    public double getVideoProgress() {
        return getVideoAdView() != null ? ((getVideoAdView().getCurrentPositionWhenPlaying() * 1.0f) / getVideoAdView().getDuration()) / 100.0f : super.getVideoProgress();
    }

    public void init(g0 g0Var) {
        ((h0) this).f1200a = g0Var;
        d adUnit = getAdUnit();
        if (adUnit != null) {
            setVideoURL(adUnit);
            getVideoAdView().setVideoImageDisplayType(1);
            setUIStyle(b.PREVIEW);
            String strL = adUnit.l();
            if (TextUtils.isEmpty(strL)) {
                getVideoAdView().f622d = true;
            } else {
                xb xbVarA = xb.a(this.f1041a);
                xbVarA.getClass();
                xbVarA.new a(strL).a(getVideoAdView().getThumbView());
            }
            getVideoAdView().setSoundChange(getAdConfig().b());
        }
    }

    public boolean onBackPressed() {
        if (CONTAINER_LIST.size() != 0 && getVideoAdView() != null) {
            po videoAdView = getVideoAdView();
            videoAdView.getClass();
            videoAdView.f613b = System.currentTimeMillis();
            rg rgVar = videoAdView.f609a;
            if (rgVar != null) {
                rgVar.onScreenNormal();
            }
            videoAdView.b = 0;
            return true;
        }
        if (CONTAINER_LIST.size() != 0 || getVideoAdView() == null || getVideoAdView().b == 0) {
            return false;
        }
        po videoAdView2 = getVideoAdView();
        Window windowM681a = md.m681a(videoAdView2.getContext());
        if (windowM681a != null) {
            ((ViewGroup) windowM681a.findViewById(R.id.content)).removeView(videoAdView2);
        }
        return true;
    }

    public void onPaused() {
        if (getVideoAdView() != null) {
            getVideoAdView().d();
        }
    }

    @Override // com.adprof.sdk.e
    public void onProgressUpdate(long j, long j2) {
        if (getAdVideoStatusListener() != null) {
            getAdVideoStatusListener().onProgressUpdate(j, j2);
        }
    }

    public void onResume() {
        pk.a(this.f41a + "---onResume  " + this.f42a);
        if (getVideoAdView() == null || this.f42a) {
            return;
        }
        getVideoAdView().e();
    }

    @Override // com.adprof.sdk.rg
    public void onScreenFullscreen() {
        ViewGroup viewGroup = (ViewGroup) this.f38a.getParent();
        viewGroup.removeView(this.f38a);
        CONTAINER_LIST.add(viewGroup);
        Activity activityA = md.a(viewGroup.getContext());
        if (activityA != null) {
            ((ViewGroup) activityA.findViewById(R.id.content)).addView(this.f38a, new FrameLayout.LayoutParams(-1, -1));
            if (getVideoAdView().getVideoHeight() < getVideoAdView().getVideoWidth()) {
                activityA.setRequestedOrientation(6);
            }
        }
    }

    @Override // com.adprof.sdk.rg
    public void onScreenNormal() {
        ViewGroup viewGroup = (ViewGroup) this.f38a.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(this.f38a);
        }
        Activity activityA = md.a(CONTAINER_LIST.getLast().getContext());
        if (activityA != null) {
            activityA.getWindow().getDecorView().setSystemUiVisibility(0);
        }
        if (getVideoAdView().getVideoHeight() < getVideoAdView().getVideoWidth() && activityA != null) {
            activityA.setRequestedOrientation(1);
        }
        CONTAINER_LIST.getLast().removeAllViews();
        CONTAINER_LIST.getLast().addView(this.f38a, new FrameLayout.LayoutParams(-1, -1));
        CONTAINER_LIST.pop();
    }

    @Override // com.adprof.sdk.api.NativeAdData.NativeAdMediaListener
    public void onVideoCompleted() {
        Bitmap textureBitmap;
        if (getAdVideoStatusListener() != null) {
            getAdVideoStatusListener().onVideoCompleted();
        }
        this.f42a = true;
        if (getVideoAdView() != null && (textureBitmap = getVideoAdView().getTextureBitmap()) != null) {
            if (e6.f233a == null) {
                throw new RuntimeException("BlurKit not initialized!");
            }
            try {
                Allocation allocationCreateFromBitmap = Allocation.createFromBitmap(e6.f1143a, textureBitmap);
                Allocation allocationCreateTyped = Allocation.createTyped(e6.f1143a, allocationCreateFromBitmap.getType());
                RenderScript renderScript = e6.f1143a;
                ScriptIntrinsicBlur scriptIntrinsicBlurCreate = ScriptIntrinsicBlur.create(renderScript, Element.U8_4(renderScript));
                scriptIntrinsicBlurCreate.setRadius(10);
                scriptIntrinsicBlurCreate.setInput(allocationCreateFromBitmap);
                scriptIntrinsicBlurCreate.forEach(allocationCreateTyped);
                allocationCreateTyped.copyTo(textureBitmap);
            } catch (Throwable th) {
                pk.b("blur error: ", th);
            }
            getVideoAdView().getBlurImageView().setImageBitmap(textureBitmap);
            this.f37a = textureBitmap;
            this.b = textureBitmap;
        }
        b bVar = ((f) this).f1159a;
        if (bVar != b.PREVIEW && bVar == b.DETAIL_PAGE) {
            setUIStyle(b.DETAIL_PAGE_END);
        }
    }

    @Override // com.adprof.sdk.api.NativeAdData.NativeAdMediaListener
    public void onVideoError(AdError adError) {
        if (getAdVideoStatusListener() != null) {
            getAdVideoStatusListener().onVideoError(adError);
        }
    }

    @Override // com.adprof.sdk.api.NativeAdData.NativeAdMediaListener
    public void onVideoLoad() {
        if (getAdVideoStatusListener() != null) {
            getAdVideoStatusListener().onVideoLoad();
        }
    }

    @Override // com.adprof.sdk.api.NativeAdData.NativeAdMediaListener
    public void onVideoPause() {
        if (getAdVideoStatusListener() != null) {
            getAdVideoStatusListener().onVideoPause();
        }
    }

    @Override // com.adprof.sdk.e
    public void onVideoRestart() {
        pk.a(this.f41a + "---onVideoRestart");
        if (getVideoAdView() != null && getVideoAdView().getBlurImageView() != null) {
            getVideoAdView().getBlurImageView().setVisibility(8);
        }
        if (getAdVideoStatusListener() != null) {
            getAdVideoStatusListener().onVideoRestart();
        }
    }

    @Override // com.adprof.sdk.api.NativeAdData.NativeAdMediaListener
    public void onVideoResume() {
        pk.a(this.f41a + "---onVideoResume");
        if (getAdVideoStatusListener() == null || this.f42a) {
            return;
        }
        getAdVideoStatusListener().onVideoResume();
    }

    @Override // com.adprof.sdk.api.NativeAdData.NativeAdMediaListener
    public void onVideoStart() {
        if (getAdUnit() == null) {
            return;
        }
        zb.a(this.f37a);
        zb.a(this.b);
        if (getAdUnit() != null) {
            getVideoAdView().getVideoWidth();
            getVideoAdView().getVideoHeight();
        }
        if (((f) this).f1159a == b.DETAIL_PAGE_END) {
            setUIStyle(b.DETAIL_PAGE);
        }
        getVideoAdView().a(io.VOLUME, true);
        if (getAdVideoStatusListener() != null) {
            getAdVideoStatusListener().onVideoStart();
        }
    }

    public void reset() {
        if (getVideoAdView() != null) {
            getVideoAdView().m();
        }
    }

    @Override // com.adprof.sdk.h0
    public void setUIStyle(b bVar) {
        if (getAdUnit() == null) {
            return;
        }
        super.setUIStyle(bVar);
        int iOrdinal = bVar.ordinal();
        if (iOrdinal == 0) {
            this.f38a.removeAllViews();
            hp.m656a((View) this.f38a);
            hp.m656a((View) getVideoAdView());
            addView(getVideoAdView(), new RelativeLayout.LayoutParams(-1, -1));
            if (getVideoAdView().f1370a == 0) {
                getVideoAdView().a(io.START, true);
            } else {
                getVideoAdView().a(io.START, false);
            }
            getVideoAdView().a(io.FULLSCREEN, false);
            getVideoAdView().a(io.VOLUME, false);
            getVideoAdView().a(io.BIGRETRY, false);
            getVideoAdView().a(io.RETRY, false);
            getVideoAdView().a(io.BACK, false);
            getVideoAdView().setSoundChange(getAdConfig().b());
            return;
        }
        if (iOrdinal != 1) {
            if (iOrdinal != 2) {
                return;
            }
            getVideoAdView().a(io.START, false);
            getVideoAdView().a(io.FULLSCREEN, false);
            getVideoAdView().a(io.VOLUME, false);
            getVideoAdView().a(io.RETRY, false);
            getVideoAdView().a(io.BACK, true);
            return;
        }
        if (this.f38a.getChildCount() > 0) {
            this.f38a.removeAllViews();
        }
        removeView(getVideoAdView());
        this.f38a.addView(getVideoAdView(), new RelativeLayout.LayoutParams(-1, -1));
        getVideoAdView().setSoundChange(getAdConfig().f515b == 0);
        getVideoAdView().a(io.START, false);
        getVideoAdView().a(io.FULLSCREEN, true);
        getVideoAdView().a(io.VOLUME, true);
        getVideoAdView().a(io.BIGRETRY, false);
        getVideoAdView().a(io.RETRY, false);
        getVideoAdView().a(io.BACK, true);
    }
}
