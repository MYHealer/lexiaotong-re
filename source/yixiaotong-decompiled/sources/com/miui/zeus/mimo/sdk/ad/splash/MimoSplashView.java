package com.miui.zeus.mimo.sdk.ad.splash;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.google.common.primitives.SignedBytes;
import com.miui.zeus.mimo.sdk.a0;
import com.miui.zeus.mimo.sdk.bean.MimoAdInfo;
import com.miui.zeus.mimo.sdk.c6;
import com.miui.zeus.mimo.sdk.click.ClickAreaType;
import com.miui.zeus.mimo.sdk.click.ClickEventType;
import com.miui.zeus.mimo.sdk.click.CommonActionHandler;
import com.miui.zeus.mimo.sdk.f9;
import com.miui.zeus.mimo.sdk.i8;
import com.miui.zeus.mimo.sdk.j6;
import com.miui.zeus.mimo.sdk.j8;
import com.miui.zeus.mimo.sdk.k6;
import com.miui.zeus.mimo.sdk.k8;
import com.miui.zeus.mimo.sdk.l6;
import com.miui.zeus.mimo.sdk.n6;
import com.miui.zeus.mimo.sdk.q6;
import com.miui.zeus.mimo.sdk.t6;
import com.miui.zeus.mimo.sdk.track.info.AdEvent;
import com.miui.zeus.mimo.sdk.video.MimoMediaView;
import com.miui.zeus.mimo.sdk.view.IBindDataView;
import com.miui.zeus.mimo.sdk.view.MimoUniversalSlideView;
import com.miui.zeus.mimo.sdk.view.SkipCountDownView;
import com.miui.zeus.mimo.sdk.view.component.AdMarkICP;
import com.miui.zeus.mimo.sdk.view.component.AdMarkICP.a;
import com.miui.zeus.mimo.sdk.view.component.BrandICP;
import com.miui.zeus.mimo.sdk.view.component.BubbleDownloadButtonICP;
import com.miui.zeus.mimo.sdk.view.component.DownloadButtonICP;
import com.miui.zeus.mimo.sdk.view.component.IconICP;
import com.miui.zeus.mimo.sdk.view.component.ImageICP;
import com.miui.zeus.mimo.sdk.view.component.RootICP;
import com.miui.zeus.mimo.sdk.view.component.SixElementsView;
import com.miui.zeus.mimo.sdk.view.component.SloganICP;
import com.miui.zeus.mimo.sdk.view.component.SummaryICP;
import com.miui.zeus.mimo.sdk.w3;
import com.miui.zeus.mimo.sdk.y6;
import com.miui.zeus.mimo.sdk.y8;
import ijiami_1011.s.s.s;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class MimoSplashView extends RootICP implements IBindDataView, i8, SkipCountDownView.c {
    private MimoAdInfo mAdInfo;
    private View mBubbleDownloadBtnBg;
    private BubbleDownloadButtonICP mBubbleDownloadButtonICP;
    private CommonActionHandler mCommonActionHandler;
    private int mCountDownValue;
    private DownloadButtonICP mDownloadButtonICP;
    private w3 mIEventHandler;
    private MimoMediaView mMediaView;
    private k8 mMimoShakeView;
    private Runnable mRunnable;
    private SkipCountDownView mSkipCountDownView;
    private ImageICP mSlipUpView;
    private final y6 mTimerHelper;
    private SixElementsView sixElementsView;
    private SloganICP sloganICP;

    public class a implements SixElementsView.e {
        public a() {
        }

        @Override // com.miui.zeus.mimo.sdk.view.component.SixElementsView.e
        public void a(String str) {
            if (MimoSplashView.this.mIEventHandler != null) {
                MimoSplashView.this.mIEventHandler.onJumpWebView(str);
            }
        }
    }

    public class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ImageView f5334a;

        public b(ImageView imageView) {
            this.f5334a = imageView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (MimoSplashView.this.mMediaView != null) {
                this.f5334a.setSelected(MimoSplashView.this.mMediaView.e);
                MimoSplashView.this.mMediaView.setMute(!MimoSplashView.this.mMediaView.e);
            }
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MimoSplashView.this.onClick(view, ClickAreaType.TYPE_OTHER);
        }
    }

    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MimoSplashView.this.onClick(view, ClickAreaType.TYPE_OTHER);
        }
    }

    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (MimoSplashView.this.mCountDownValue > 0) {
                MimoSplashView.access$210(MimoSplashView.this);
                if (MimoSplashView.this.mSkipCountDownView != null) {
                    MimoSplashView.this.mSkipCountDownView.setCountDown(String.valueOf(MimoSplashView.this.mCountDownValue));
                    return;
                }
                return;
            }
            MimoSplashView.this.mCountDownValue = 0;
            MimoSplashView.this.notifyAdViewDismiss();
            if (MimoSplashView.this.mAdInfo == null || MimoSplashView.this.mAdInfo.E()) {
                return;
            }
            MimoSplashView.this.trackViewEvent(AdEvent.PIC_FINISH);
        }
    }

    public class f implements CommonActionHandler.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f5338a;
        public final /* synthetic */ ClickAreaType b;

        public f(View view, ClickAreaType clickAreaType) {
            this.f5338a = view;
            this.b = clickAreaType;
        }

        @Override // com.miui.zeus.mimo.sdk.click.CommonActionHandler.c
        public void a(boolean z) {
            l6 l6Var = null;
            if (MimoSplashView.this.mMimoShakeView != null) {
                l6 extShakeInfo = MimoSplashView.this.mMimoShakeView.getExtShakeInfo();
                MimoSplashView.this.removeShakeView();
                MimoSplashView.this.mMimoShakeView = null;
                l6Var = extShakeInfo;
            }
            MimoSplashView.this.notifyViewClicked(this.f5338a, this.b, l6Var, z);
        }
    }

    public MimoSplashView(Context context) {
        super(context);
        this.mTimerHelper = new y6();
        this.mCountDownValue = 5;
        this.mRunnable = new e();
    }

    public static /* synthetic */ int access$210(MimoSplashView mimoSplashView) {
        int i = mimoSplashView.mCountDownValue;
        mimoSplashView.mCountDownValue = i - 1;
        return i;
    }

    private void addShakeView() {
        Context context;
        float f2;
        MimoAdInfo mimoAdInfo = this.mAdInfo;
        if (mimoAdInfo == null || !mimoAdInfo.a1 || mimoAdInfo.a(ClickAreaType.TYPE_NATIVE_SHAKE) == ClickEventType.CLICK_DISABLE) {
            return;
        }
        removeShakeView();
        this.mMimoShakeView = new k8(getContext(), null);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        if (getResources().getConfiguration().orientation == 1) {
            layoutParams.removeRule(13);
            DownloadButtonICP downloadButtonICP = this.mDownloadButtonICP;
            if (downloadButtonICP == null || downloadButtonICP.getVisibility() != 0) {
                SloganICP sloganICP = this.sloganICP;
                if (sloganICP != null) {
                    layoutParams.addRule(2, sloganICP.getId());
                    layoutParams.addRule(14);
                    context = getContext();
                    f2 = 84.0f;
                }
            } else {
                layoutParams.addRule(2, this.mDownloadButtonICP.getId());
                layoutParams.addRule(14);
                context = getContext();
                f2 = 15.0f;
            }
            layoutParams.bottomMargin = f9.a(context, f2);
        }
        View view = this.sloganICP;
        if (view == null) {
            view = this.mMediaView;
        }
        ((RelativeLayout) view.getParent()).addView(this.mMimoShakeView, layoutParams);
        this.mMimoShakeView.a(this.mAdInfo, this);
        this.mMimoShakeView.c();
    }

    private void addSwipeUpView(View view) {
        Context context;
        float f2;
        ImageICP imageICP = new ImageICP(getContext());
        this.mSlipUpView = imageICP;
        imageICP.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(f9.a(getContext(), 165.0f), f9.a(getContext(), 136.0f));
        setTouchMoveSlop(true, this.mAdInfo.c1);
        this.mSlipUpView.setScaleType(ImageView.ScaleType.FIT_XY);
        this.mSlipUpView.a(this.mAdInfo.m1, this, new RequestListener<Drawable>() { // from class: com.miui.zeus.mimo.sdk.ad.splash.MimoSplashView.7

            /* JADX INFO: renamed from: com.miui.zeus.mimo.sdk.ad.splash.MimoSplashView$7$a */
            public class a implements Runnable {
                public a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    ImageICP imageICP = MimoSplashView.this.mSlipUpView;
                    int i = a0.i5;
                    MimoSplashView mimoSplashView = MimoSplashView.this;
                    imageICP.getClass();
                    Glide.with(y8.f5752a).load(Integer.valueOf(i)).into(imageICP);
                    if (mimoSplashView == null) {
                        return;
                    }
                    imageICP.setOnClickListener(new j8(imageICP, mimoSplashView));
                }
            }

            @Override // com.bumptech.glide.request.RequestListener
            public boolean onLoadFailed(GlideException glideException, Object obj, Target<Drawable> target, boolean z) {
                y8.b.post(new a());
                return false;
            }

            @Override // com.bumptech.glide.request.RequestListener
            public boolean onResourceReady(Drawable drawable, Object obj, Target<Drawable> target, DataSource dataSource, boolean z) {
                return false;
            }
        });
        layoutParams.addRule(14);
        layoutParams.addRule(2, view.getId());
        if (view instanceof DownloadButtonICP) {
            context = getContext();
            f2 = 15.0f;
        } else {
            context = getContext();
            f2 = 35.0f;
        }
        layoutParams.bottomMargin = f9.a(context, f2);
        RelativeLayout relativeLayout = (RelativeLayout) view.getParent();
        if (this.sloganICP != null) {
            View view2 = new View(getContext());
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
            view2.setBackgroundResource(a0.s4);
            layoutParams2.addRule(2, this.sloganICP.getId());
            layoutParams2.addRule(6, this.mSlipUpView.getId());
            layoutParams2.topMargin = f9.a(getContext(), -15.0f);
            DownloadButtonICP downloadButtonICP = this.mDownloadButtonICP;
            int iIndexOfChild = downloadButtonICP != null ? relativeLayout.indexOfChild(downloadButtonICP) : -1;
            if (iIndexOfChild >= 0) {
                relativeLayout.addView(view2, iIndexOfChild, layoutParams2);
            }
        }
        relativeLayout.addView(this.mSlipUpView, layoutParams);
    }

    private void addUniversalSlideView(View view) {
        MimoAdInfo mimoAdInfo;
        if (view == null || (mimoAdInfo = this.mAdInfo) == null || mimoAdInfo.a(ClickAreaType.TYPE_UNIVERSAL_SLIDE) == ClickEventType.CLICK_DISABLE) {
            return;
        }
        MimoUniversalSlideView mimoUniversalSlideView = new MimoUniversalSlideView(getContext(), null);
        mimoUniversalSlideView.a(this.mAdInfo, this);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.addRule(2, view.getId());
        layoutParams.bottomMargin = f9.a(getContext(), 10.0f);
        ((RelativeLayout) view.getParent()).addView(mimoUniversalSlideView, layoutParams);
    }

    private j6 getClickViewInfo(View view) {
        return new c6(view, this, this.mSkipCountDownView.getCloseView(), null, new View[]{getDownloadBtnView()}, this.mViewEventInfo, true, true).f5387a;
    }

    private View getDownloadBtnView() {
        DownloadButtonICP downloadButtonICP = this.mDownloadButtonICP;
        if (downloadButtonICP != null && downloadButtonICP.isShown()) {
            return this.mDownloadButtonICP;
        }
        BubbleDownloadButtonICP bubbleDownloadButtonICP = this.mBubbleDownloadButtonICP;
        if (bubbleDownloadButtonICP == null || !bubbleDownloadButtonICP.isShown()) {
            return null;
        }
        return this.mBubbleDownloadButtonICP;
    }

    private int getLayoutId() {
        if (getResources().getConfiguration().orientation == 1) {
            return this.mAdInfo.p0.trim().contains(s.d(new byte[]{105, 88, 7, SignedBytes.MAX_POWER_OF_TWO, 69, 17, 4, 48, 3, 26, 69}, "91d40c")) ? a0.D4 : a0.Y;
        }
        return a0.N2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyAdViewDismiss() {
        removeAllViews();
        setVisibility(8);
        this.mTimerHelper.a();
        w3 w3Var = this.mIEventHandler;
        if (w3Var != null) {
            w3Var.onClickCloseView();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyViewClicked(View view, ClickAreaType clickAreaType, l6 l6Var, boolean z) {
        AdEvent adEvent = AdEvent.CLICK;
        MimoAdInfo mimoAdInfo = this.mAdInfo;
        n6 n6Var = this.mViewEventInfo;
        if (z) {
            clickAreaType = ClickAreaType.TYPE_CPM_BUTTON;
        }
        com.miui.zeus.mimo.sdk.b.a(adEvent, mimoAdInfo, n6Var, k6.a(null, clickAreaType, getClickViewInfo(view), l6Var));
        w3 w3Var = this.mIEventHandler;
        if (w3Var != null) {
            w3Var.onClicked();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeShakeView() {
        k8 k8Var = this.mMimoShakeView;
        if (k8Var != null) {
            k8Var.a();
            RelativeLayout relativeLayout = (RelativeLayout) this.mMediaView.getParent();
            if (relativeLayout != null) {
                relativeLayout.removeView(this.mMimoShakeView);
            }
            this.mMimoShakeView.setVisibility(8);
            this.mMimoShakeView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void trackViewEvent(AdEvent adEvent) {
        com.miui.zeus.mimo.sdk.b.a(adEvent, this.mAdInfo, this.mViewEventInfo, (k6) null);
    }

    @Override // com.miui.zeus.mimo.sdk.view.SkipCountDownView.c
    public void clickCountDownView(ClickAreaType clickAreaType) {
        onClick(this.mSkipCountDownView, clickAreaType);
    }

    @Override // com.miui.zeus.mimo.sdk.view.SkipCountDownView.c
    public void clickSkipView(View view) {
        com.miui.zeus.mimo.sdk.b.a(AdEvent.CLOSE, this.mAdInfo, this.mViewEventInfo, k6.a(null, new c6(view, this, this.mSkipCountDownView, null, new View[]{getDownloadBtnView()}, this.mViewEventInfo, true, false).f5387a, null));
        notifyAdViewDismiss();
    }

    @Override // com.miui.zeus.mimo.sdk.view.IBindDataView
    public void destroy() {
        this.mTimerHelper.a();
        CommonActionHandler commonActionHandler = this.mCommonActionHandler;
        if (commonActionHandler != null) {
            commonActionHandler.a();
        }
        DownloadButtonICP downloadButtonICP = this.mDownloadButtonICP;
        if (downloadButtonICP != null) {
            downloadButtonICP.b();
        }
        BubbleDownloadButtonICP bubbleDownloadButtonICP = this.mBubbleDownloadButtonICP;
        if (bubbleDownloadButtonICP != null) {
            bubbleDownloadButtonICP.b();
        }
    }

    @Override // com.miui.zeus.mimo.sdk.view.IBindDataView
    public boolean onBackPressed() {
        return true;
    }

    @Override // com.miui.zeus.mimo.sdk.i8
    public void onClick(View view, ClickAreaType clickAreaType) {
        CommonActionHandler commonActionHandler = this.mCommonActionHandler;
        if (commonActionHandler != null) {
            commonActionHandler.b = new f(view, clickAreaType);
            commonActionHandler.a(this.mAdInfo, clickAreaType);
        }
    }

    @Override // com.miui.zeus.mimo.sdk.view.IBindDataView
    public void pause() {
        this.mTimerHelper.a();
    }

    @Override // com.miui.zeus.mimo.sdk.view.IBindDataView
    public void resume() {
        this.mTimerHelper.a(1000L, 1000L, this.mRunnable);
        k8 k8Var = this.mMimoShakeView;
        if (k8Var != null) {
            k8Var.c();
        }
    }

    @Override // com.miui.zeus.mimo.sdk.view.IBindDataView
    public void setAdInfo(Activity activity, MimoAdInfo mimoAdInfo, w3 w3Var) {
        View view;
        View viewFindViewById;
        if (mimoAdInfo == null) {
            return;
        }
        this.mAdInfo = mimoAdInfo;
        mimoAdInfo.S0 = false;
        this.mIEventHandler = w3Var;
        this.mCountDownValue = mimoAdInfo.d1;
        this.mCommonActionHandler = new CommonActionHandler(getContext(), activity, w3Var);
        FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(getContext()).inflate(getLayoutId(), (ViewGroup) this, true);
        this.mDownloadButtonICP = (DownloadButtonICP) frameLayout.findViewById(a0.O);
        this.mBubbleDownloadBtnBg = frameLayout.findViewById(a0.I3);
        this.mBubbleDownloadButtonICP = (BubbleDownloadButtonICP) frameLayout.findViewById(a0.I2);
        this.mDownloadButtonICP.a(mimoAdInfo, false, false, this, false);
        SkipCountDownView skipCountDownView = (SkipCountDownView) frameLayout.findViewById(a0.v);
        this.mSkipCountDownView = skipCountDownView;
        skipCountDownView.setCloseText(s.d(new byte[]{-34, -127, -48, -115, -119, -76}, "66ce63"));
        this.mSkipCountDownView.setCountDown(String.valueOf(this.mCountDownValue));
        this.mSkipCountDownView.setOnItemClickListener(this);
        MimoMediaView mimoMediaView = (MimoMediaView) frameLayout.findViewById(a0.a4);
        this.mMediaView = mimoMediaView;
        mimoMediaView.setMute(w3Var.isMuted());
        this.mMediaView.a(getResources().getConfiguration().orientation);
        this.mMediaView.setPicStartCountDown(false);
        this.mMediaView.a(mimoAdInfo, this.mIEventHandler, this);
        AdMarkICP adMarkICP = (AdMarkICP) frameLayout.findViewById(a0.n2);
        adMarkICP.f5687a.setText(mimoAdInfo.a());
        adMarkICP.setOnClickListener(adMarkICP.new a(mimoAdInfo, this));
        BrandICP brandICP = (BrandICP) frameLayout.findViewById(a0.G0);
        if (brandICP != null) {
            brandICP.a(mimoAdInfo.r(), this);
        }
        SummaryICP summaryICP = (SummaryICP) frameLayout.findViewById(a0.O5);
        if (summaryICP != null) {
            summaryICP.a(mimoAdInfo.p(), this);
        }
        IconICP iconICP = (IconICP) frameLayout.findViewById(a0.r1);
        if (iconICP != null) {
            iconICP.a(mimoAdInfo.A, this);
        }
        SixElementsView sixElementsView = (SixElementsView) frameLayout.findViewById(a0.P0);
        this.sixElementsView = sixElementsView;
        sixElementsView.setTextColor(-1);
        if (this.mAdInfo.u() && com.miui.zeus.mimo.sdk.b.h(this.mAdInfo.F1)) {
            this.sixElementsView.a(mimoAdInfo.i, mimoAdInfo.k, mimoAdInfo.e(), mimoAdInfo.m, mimoAdInfo.l, mimoAdInfo.n, true);
        } else {
            this.sixElementsView.a(mimoAdInfo.i, mimoAdInfo.k, mimoAdInfo.e(), mimoAdInfo.m, mimoAdInfo.l, mimoAdInfo.n, false);
        }
        this.sixElementsView.setVisibility(mimoAdInfo.D() ? 0 : 4);
        if (getResources().getConfiguration().orientation == 2 && this.sixElementsView.getVisibility() == 0 && (viewFindViewById = frameLayout.findViewById(a0.E0)) != null) {
            viewFindViewById.setVisibility(0);
        }
        this.sixElementsView.setOnItemClickListener(new a());
        setCLickAreaListener(this);
        SloganICP sloganICP = (SloganICP) findViewById(a0.r2);
        this.sloganICP = sloganICP;
        if (sloganICP != null) {
            if (this.mAdInfo.E1) {
                sloganICP.setVisibility(0);
                this.sloganICP.setIClickAreaListener(this);
                if (com.miui.zeus.mimo.sdk.b.h(this.mAdInfo.s1)) {
                    this.sloganICP.setRpkIcon(this.mAdInfo.s1);
                }
                if (com.miui.zeus.mimo.sdk.b.h(this.mAdInfo.r1)) {
                    this.sloganICP.setRpkText(this.mAdInfo.r1);
                }
            } else {
                sloganICP.setVisibility(8);
            }
        }
        ImageView imageView = (ImageView) frameLayout.findViewById(a0.r3);
        if (imageView != null) {
            if (this.mAdInfo.E()) {
                imageView.setSelected(!this.mMediaView.e);
                imageView.setVisibility(0);
                imageView.setOnClickListener(new b(imageView));
            } else {
                imageView.setVisibility(8);
            }
        }
        ClickEventType clickEventTypeA = this.mAdInfo.a(ClickAreaType.TYPE_NATIVE_SHAKE);
        ClickEventType clickEventType = ClickEventType.CLICK_DISABLE;
        if (clickEventTypeA != clickEventType) {
            addShakeView();
        }
        if (mimoAdInfo.a(ClickAreaType.TYPE_SWIPEUP) != clickEventType) {
            addSwipeUpView(this.mDownloadButtonICP.getVisibility() == 0 ? this.mDownloadButtonICP : this.sixElementsView);
        }
        if (!this.mAdInfo.E()) {
            trackViewEvent(AdEvent.PIC_START);
        }
        this.mTimerHelper.a(1000L, 1000L, this.mRunnable);
        View viewFindViewById2 = findViewById(a0.A1);
        if (viewFindViewById2 != null) {
            viewFindViewById2.setOnClickListener(new c());
        }
        View viewFindViewById3 = frameLayout.findViewById(a0.u3);
        if (viewFindViewById3 != null) {
            viewFindViewById3.setOnClickListener(new d());
        }
        View viewFindViewById4 = frameLayout.findViewById(a0.Q4);
        if (viewFindViewById4 != null) {
            float fC = f9.c(y8.f5752a) / 2400.0f;
            ((RelativeLayout.LayoutParams) viewFindViewById4.getLayoutParams()).topMargin = (int) (f9.c(y8.f5752a) * 0.21f * fC);
            this.mMediaView.getLayoutParams().height = (int) (560.0f * fC);
            SloganICP sloganICP2 = this.sloganICP;
            if (sloganICP2 != null) {
                sloganICP2.getLayoutParams().height = (int) (276.0f * fC);
            }
            DownloadButtonICP downloadButtonICP = this.mDownloadButtonICP;
            if (downloadButtonICP != null) {
                downloadButtonICP.getLayoutParams().height = (int) (fC * 186.0f);
            }
            ((RelativeLayout.LayoutParams) viewFindViewById4.getLayoutParams()).addRule(14);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) viewFindViewById4.getLayoutParams();
            ImageICP imageICP = this.mSlipUpView;
            layoutParams.addRule(2, imageICP != null ? imageICP.getId() : this.mDownloadButtonICP.getId());
            viewFindViewById4.setOutlineProvider(new t6(f9.a(getContext(), 13.0f)));
            viewFindViewById4.setClipToOutline(true);
        }
        if (getResources().getConfiguration().orientation == 2) {
            view = viewFindViewById2;
        } else {
            view = this.mDownloadButtonICP.getVisibility() == 0 ? this.mDownloadButtonICP : this.sixElementsView;
        }
        addUniversalSlideView(view);
        ImageView imageView2 = (ImageView) frameLayout.findViewById(a0.j0);
        String strC = this.mAdInfo.c(w3Var);
        if (TextUtils.isEmpty(strC)) {
            strC = this.mAdInfo.f();
        }
        if (imageView2 != null && com.miui.zeus.mimo.sdk.b.h(strC)) {
            imageView2.setVisibility(0);
            Glide.with(y8.f5752a).load(strC).error((Drawable) new ColorDrawable(-16777216)).transform(new q6(25, 8, true, true)).into(imageView2);
        }
        if (this.mBubbleDownloadButtonICP != null && this.mAdInfo.u() && com.miui.zeus.mimo.sdk.b.h(this.mAdInfo.F1)) {
            if (f9.c(getContext()) > 1080 && getResources().getConfiguration().orientation != 2) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.mBubbleDownloadButtonICP.getLayoutParams();
                layoutParams2.width = 1080;
                layoutParams2.height = -2;
                if (f9.d(getContext()) > 1404.0d) {
                    layoutParams2.width = 1404;
                }
                layoutParams2.height = -2;
                this.mBubbleDownloadButtonICP.setLayoutParams(layoutParams2);
            }
            this.mBubbleDownloadButtonICP.setVisibility(0);
            View view2 = this.mBubbleDownloadBtnBg;
            if (view2 != null) {
                view2.setVisibility(0);
            }
            this.mDownloadButtonICP.setVisibility(8);
            if (viewFindViewById2 != null) {
                viewFindViewById2.setVisibility(8);
            }
            this.mBubbleDownloadButtonICP.setBtnStyle(2);
            this.mBubbleDownloadButtonICP.a(mimoAdInfo, false, false, this, false);
        }
        if (mimoAdInfo.a(ClickAreaType.TYPE_BUTTON) == clickEventType) {
            this.mDownloadButtonICP.setVisibility(8);
            BubbleDownloadButtonICP bubbleDownloadButtonICP = this.mBubbleDownloadButtonICP;
            if (bubbleDownloadButtonICP != null) {
                bubbleDownloadButtonICP.setVisibility(8);
            }
            View view3 = this.mBubbleDownloadBtnBg;
            if (view3 != null) {
                view3.setVisibility(8);
            }
        }
    }
}
