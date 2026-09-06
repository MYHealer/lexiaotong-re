package com.miui.zeus.mimo.sdk.ad.banner;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.LeadingMarginSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ViewFlipper;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.miui.zeus.mimo.sdk.a0;
import com.miui.zeus.mimo.sdk.bean.MimoAdInfo;
import com.miui.zeus.mimo.sdk.c6;
import com.miui.zeus.mimo.sdk.click.ClickAreaType;
import com.miui.zeus.mimo.sdk.click.CommonActionHandler;
import com.miui.zeus.mimo.sdk.f9;
import com.miui.zeus.mimo.sdk.i8;
import com.miui.zeus.mimo.sdk.k6;
import com.miui.zeus.mimo.sdk.m;
import com.miui.zeus.mimo.sdk.n6;
import com.miui.zeus.mimo.sdk.t6;
import com.miui.zeus.mimo.sdk.track.info.AdEvent;
import com.miui.zeus.mimo.sdk.video.MimoMediaView;
import com.miui.zeus.mimo.sdk.view.IBindDataView;
import com.miui.zeus.mimo.sdk.view.component.AdMarkICP;
import com.miui.zeus.mimo.sdk.view.component.AdMarkICP.a;
import com.miui.zeus.mimo.sdk.view.component.CloseICP;
import com.miui.zeus.mimo.sdk.view.component.DownloadButtonICP;
import com.miui.zeus.mimo.sdk.view.component.IconICP;
import com.miui.zeus.mimo.sdk.view.component.RootICP;
import com.miui.zeus.mimo.sdk.view.component.SixElementsView;
import com.miui.zeus.mimo.sdk.view.component.SummaryICP;
import com.miui.zeus.mimo.sdk.view.component.SummaryICP.a;
import com.miui.zeus.mimo.sdk.view.wave.IconWaveAnimView;
import com.miui.zeus.mimo.sdk.view.wave.WaveView;
import com.miui.zeus.mimo.sdk.w3;
import ijiami_1011.s.s.s;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class MimoBannerView extends RootICP implements IBindDataView {
    private static final int FLIP_INTERVAL = 3000;
    private MimoAdInfo mAdInfo;
    private CloseICP mCloseICP;
    private CommonActionHandler mCommonActionHandler;
    private DownloadButtonICP mDownloadButtonICP;
    private w3 mIEventHandler;
    private ViewFlipper mViewFlipper;
    public static final String BANNER_TEMPLATE_A2 = s.d(new byte[]{86, 86, 89, 95, 87, 17, 32, 86}, "47712c");
    public static final String BANNER_TEMPLATE_A2_WAVE = s.d(new byte[]{1, 82, 15, 86, 0, Ascii.SYN, 32, 86, 57, Ascii.NAK, 80, 19, 6}, "c3a8ed");
    public static final String BANNER_TEMPLATE_WAVE = s.d(new byte[]{106, Ascii.DC2, 88, 67, 85}, "5e9507");
    private static final String TAG = "MimoBannerView";

    public class a implements SixElementsView.e {
        public a() {
        }

        @Override // com.miui.zeus.mimo.sdk.view.component.SixElementsView.e
        public void a(String str) {
            if (MimoBannerView.this.mIEventHandler != null) {
                MimoBannerView.this.mIEventHandler.onJumpWebView(str);
            }
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MimoAdInfo f5292a;

        public b(MimoAdInfo mimoAdInfo) {
            this.f5292a = mimoAdInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            WaveView waveView = (WaveView) MimoBannerView.this.findViewById(a0.A);
            ViewGroup.LayoutParams layoutParams = waveView.getLayoutParams();
            layoutParams.height = MimoBannerView.this.getHeight();
            layoutParams.width = MimoBannerView.this.getWidth();
            waveView.setLayoutParams(layoutParams);
            MimoAdInfo mimoAdInfo = this.f5292a;
            if (mimoAdInfo != null && mimoAdInfo.p0.trim().startsWith(s.d(new byte[]{86, 82, 90, 95, 92, Ascii.ETB, 32, 86, 57, Ascii.NAK, 80, 19, 81}, "43419e"))) {
                float fA = f9.a(MimoBannerView.this.getContext(), 10.0f);
                float fA2 = f9.a(MimoBannerView.this.getContext(), 17.0f);
                float fA3 = f9.a(MimoBannerView.this.getContext(), 17.0f);
                waveView.f5720a = fA;
                waveView.b = fA2;
                waveView.c = fA3;
                waveView.requestLayout();
            }
            waveView.setWaveRotation(0.0f);
            int color = Color.parseColor(s.d(new byte[]{Ascii.ESC, 8, 8, 3, 37, 117, 89}, "8884d1"));
            int color2 = Color.parseColor(s.d(new byte[]{66, 3, 0, 92, 88, 39, 39}, "a24eaa"));
            int color3 = Color.parseColor(s.d(new byte[]{17, 1, 83, 123, 117, 34, 39}, "24e90d"));
            waveView.d = color;
            waveView.e = color2;
            waveView.f = color3;
            waveView.a();
            waveView.invalidate();
        }
    }

    public class c implements i8 {

        public class a implements CommonActionHandler.c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ View f5294a;
            public final /* synthetic */ ClickAreaType b;

            public a(View view, ClickAreaType clickAreaType) {
                this.f5294a = view;
                this.b = clickAreaType;
            }

            @Override // com.miui.zeus.mimo.sdk.click.CommonActionHandler.c
            public void a(boolean z) {
                MimoBannerView.this.notifyViewClicked(this.f5294a, this.b, z);
            }
        }

        public c() {
        }

        @Override // com.miui.zeus.mimo.sdk.i8
        public void onClick(View view, ClickAreaType clickAreaType) {
            if (AdMarkICP.a(view) || ClickAreaType.TYPE_CLOSE == clickAreaType) {
                MimoBannerView.this.notifyViewClosed(view, clickAreaType);
                return;
            }
            if (MimoBannerView.this.mAdInfo == null) {
                m.b(MimoBannerView.TAG, s.d(new byte[]{10, 15, 32, 84, 92, 87, 10, 94, 70, 15, 112, 1, 44, 15, 5, 87, Ascii.NAK, 93, Ascii.DC2, 68, 8, Ascii.ETB, 93, 9}, "eac854"));
                return;
            }
            if (com.miui.zeus.mimo.sdk.b.b(MimoBannerView.this) < MimoBannerView.this.mAdInfo.U0) {
                m.b(s.d(new byte[]{119, 126, 123, 117, 46}, "4226ed"), s.d(new byte[]{-126, -76, -36, -44, -76, -126, -123, -36, -21, -121, -94, -24, -128, -116, -15, 11, -42, -128, -34, -127, -9, -24, -44, -53, -36, -45, -4, -103, -44, -93, -27, -115, -26, -19, -41, -3, -21, -45, -33, -105, Ascii.US, -36, -18, -53, -114, -31, -116, -128, -54, -118, -115, -74, -121, -36, -40, -37, -125, -13, -69, -125, -14, -106, -125, -126, -90, -36, -48, -15, -127, -58, -117}, "e6e139"));
                com.miui.zeus.mimo.sdk.b.a(MimoBannerView.this.mAdInfo, s.d(new byte[]{38, 117, 121, 32, 121, 106, 47, 43, 57, 48, 116, 54, 53, 118, 126, 48, 119}, "e90c25"), s.d(new byte[]{-47, -31, -37, -44, -79, -39, -123, -36, -21, -121, -94, -24, -45, -39, -10, 11, -45, -37, -34, -127, -9, -24, -44, -53, -113, -122, -5, -103, -47, -8, -27, -115, -26, -19, -41, -3, -72, -122, -40, -105, 26, -121, -18, -53, -114, -31, -116, -128, -103, -33, -118, -74, -126, -121, -40, -37, -125, -13, -69, -125, -95, -61, -124, -126, -93, -121, -48, -15, -127, -58, -117}, "6cb16b"), System.currentTimeMillis(), (String) null, s.d(new byte[]{-36, -38, -118, -36, -96, -18, -124, -54, -33, -121, -88, -51, -34, -7, -79, -48, -79, -21, -121, -4, -24, -121, -117, -61, Ascii.NAK, -122, -70, -106, -39, -25, -36, -127, -55, -34, -39, -30, -115, -122, -116, -122, -44, -11, -21, -126, -15, -62, -41, -42, -84, -122, -124, -84, -42, -64, -37}, "9c591d"));
                return;
            }
            if (MimoBannerView.this.mAdInfo.B1.booleanValue() && MimoBannerView.this.mDownloadButtonICP != null && clickAreaType == MimoBannerView.this.mDownloadButtonICP.getClickAreaType() && !MimoBannerView.this.mDownloadButtonICP.a()) {
                MimoBannerView.this.notifyViewClicked(view, clickAreaType, false);
                MimoBannerView.this.notifyViewClosed(view, ClickAreaType.TYPE_FRAUD_CLOSE);
            } else if (MimoBannerView.this.mCommonActionHandler != null) {
                MimoBannerView.this.mCommonActionHandler.b = new a(view, clickAreaType);
                MimoBannerView.this.mCommonActionHandler.a(MimoBannerView.this.mAdInfo, clickAreaType);
            }
        }
    }

    public MimoBannerView(Context context) {
        this(context, null);
    }

    public MimoBannerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MimoBannerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    private i8 getClickListener() {
        return new c();
    }

    private void handleIcon(MimoAdInfo mimoAdInfo, ViewFlipper viewFlipper, w3 w3Var) {
        ViewOutlineProvider t6Var;
        String strTrim = mimoAdInfo.p0.trim();
        int minimumWidth = viewFlipper.getMinimumWidth();
        int minimumHeight = viewFlipper.getMinimumHeight();
        if (strTrim.endsWith(s.d(new byte[]{102, 1, 72, 2}, "9003ee"))) {
            minimumWidth = minimumHeight;
        } else {
            minimumHeight = strTrim.endsWith(s.d(new byte[]{104, 7, 6, Ascii.RS, 88}, "760fae")) ? (minimumWidth * 9) / 16 : (minimumWidth * 2) / 3;
        }
        viewFlipper.removeAllViews();
        for (int i = 0; i < 2; i++) {
            if (strTrim.endsWith(s.d(new byte[]{109, 85, 73, 6}, "2d1785"))) {
                IconICP iconICP = new IconICP(getContext());
                iconICP.setScaleType(ImageView.ScaleType.CENTER_CROP);
                iconICP.setLayoutParams(new FrameLayout.LayoutParams(minimumWidth, minimumHeight));
                String strF = strTrim.endsWith(s.d(new byte[]{107, 85, 26, 2}, "4db324")) ? mimoAdInfo.A : mimoAdInfo.f();
                if (com.miui.zeus.mimo.sdk.b.g(strF)) {
                    strF = strTrim.endsWith(s.d(new byte[]{105, 1, Ascii.GS, 9}, "60e80c")) ? mimoAdInfo.f() : mimoAdInfo.A;
                }
                String cachedResource = this.mIEventHandler.getCachedResource(strF, false);
                if (com.miui.zeus.mimo.sdk.b.h(cachedResource)) {
                    strF = cachedResource;
                }
                iconICP.a(strF, getClickListener());
                viewFlipper.addView(iconICP);
                t6Var = new t6(f9.a(getContext(), 2.18f));
            } else {
                MimoMediaView mimoMediaView = new MimoMediaView(getContext());
                mimoMediaView.setLayoutParams(new FrameLayout.LayoutParams(minimumWidth, minimumHeight));
                mimoMediaView.setPicStartCountDown(false);
                mimoMediaView.setViewClickAreaType(ClickAreaType.TYPE_PICTURE);
                mimoMediaView.a(mimoAdInfo, w3Var, getClickListener());
                viewFlipper.addView(mimoMediaView);
                t6Var = new t6(f9.a(getContext(), 4.5f));
            }
            viewFlipper.setOutlineProvider(t6Var);
            viewFlipper.setClipToOutline(true);
        }
        viewFlipper.getLayoutParams().height = minimumHeight;
        viewFlipper.getLayoutParams().width = minimumWidth;
        viewFlipper.setFlipInterval(3000);
        viewFlipper.startFlipping();
    }

    private void initView(View view, MimoAdInfo mimoAdInfo, w3 w3Var) {
        this.mViewFlipper = (ViewFlipper) view.findViewById(a0.F1);
        SummaryICP summaryICP = (SummaryICP) view.findViewById(a0.P1);
        this.mDownloadButtonICP = (DownloadButtonICP) view.findViewById(a0.b0);
        AdMarkICP adMarkICP = (AdMarkICP) view.findViewById(a0.f1);
        i8 clickListener = getClickListener();
        adMarkICP.f5687a.setText(mimoAdInfo.a());
        adMarkICP.setOnClickListener(adMarkICP.new a(mimoAdInfo, clickListener));
        this.mCloseICP = (CloseICP) view.findViewById(a0.q3);
        IconWaveAnimView iconWaveAnimView = (IconWaveAnimView) view.findViewById(a0.s3);
        SixElementsView sixElementsView = (SixElementsView) view.findViewById(a0.T1);
        String string = mimoAdInfo.a().toString();
        if ((mimoAdInfo.D() && mimoAdInfo.p0.trim().startsWith(BANNER_TEMPLATE_A2)) || mimoAdInfo.p0.trim().startsWith(BANNER_TEMPLATE_A2_WAVE)) {
            int iA = adMarkICP.a(string);
            SpannableString spannableString = new SpannableString(mimoAdInfo.p());
            spannableString.setSpan(new LeadingMarginSpan.Standard(iA, 0), 0, mimoAdInfo.p().length(), 33);
            i8 clickListener2 = getClickListener();
            summaryICP.setText(spannableString);
            if (clickListener2 != null) {
                summaryICP.setOnClickListener(summaryICP.new a(clickListener2));
            }
        } else {
            summaryICP.a(mimoAdInfo.p(), getClickListener());
        }
        setCLickAreaListener(getClickListener());
        this.mDownloadButtonICP.a(mimoAdInfo, false, false, getClickListener(), false);
        this.mCloseICP.setClickAreaListener(getClickListener());
        int color = Color.parseColor(s.d(new byte[]{Ascii.SYN, 12, 118, 2, 9, 81, 81, 84, 86}, "58229a"));
        ViewFlipper viewFlipper = this.mViewFlipper;
        if (viewFlipper != null) {
            handleIcon(mimoAdInfo, viewFlipper, w3Var);
        } else if (iconWaveAnimView != null) {
            color = Color.parseColor(s.d(new byte[]{SignedBytes.MAX_POWER_OF_TWO, 2, 115, 34, 34, 126, 39, 34, 32}, "c67dd8"));
            resizeWaveView(mimoAdInfo, iconWaveAnimView);
        }
        if (sixElementsView != null) {
            sixElementsView.setTextColor(color);
            sixElementsView.a(mimoAdInfo.i, mimoAdInfo.k, mimoAdInfo.e(), mimoAdInfo.m, mimoAdInfo.l, mimoAdInfo.n, mimoAdInfo.p0.trim().startsWith(BANNER_TEMPLATE_A2));
            sixElementsView.setOnItemClickListener(new a());
            sixElementsView.setVisibility(this.mAdInfo.t() ? 0 : 8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyViewClicked(View view, ClickAreaType clickAreaType, boolean z) {
        c6 c6Var = new c6(view, getRootView(), this.mCloseICP, null, new View[]{this.mDownloadButtonICP}, this.mViewEventInfo, true, true);
        AdEvent adEvent = AdEvent.CLICK;
        MimoAdInfo mimoAdInfo = this.mAdInfo;
        n6 n6Var = this.mViewEventInfo;
        if (z) {
            clickAreaType = ClickAreaType.TYPE_CPM_BUTTON;
        }
        com.miui.zeus.mimo.sdk.b.a(adEvent, mimoAdInfo, n6Var, k6.a(clickAreaType, c6Var.f5387a));
        w3 w3Var = this.mIEventHandler;
        if (w3Var != null) {
            w3Var.onClicked();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyViewClosed(View view, ClickAreaType clickAreaType) {
        m.a(TAG, s.d(new byte[]{95, 15, 39, 95, 12, 0, 10, 39, 10, 13, 66, 0, 102, 8, 1, 68}, "0ad3ec"));
        com.miui.zeus.mimo.sdk.b.a(AdEvent.CLOSE, this.mAdInfo, (n6) null, k6.a(null, new c6(view, getRootView(), this.mCloseICP, null, new View[]{this.mDownloadButtonICP}, this.mViewEventInfo, true, true).f5387a, clickAreaType));
        w3 w3Var = this.mIEventHandler;
        if (w3Var != null) {
            w3Var.onClickCloseView();
        }
    }

    private void resizeWaveView(MimoAdInfo mimoAdInfo, IconWaveAnimView iconWaveAnimView) {
        post(new b(mimoAdInfo));
        String strTrim = this.mAdInfo.p0.trim();
        if (TextUtils.isEmpty(strTrim)) {
            iconWaveAnimView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        } else {
            int minimumWidth = iconWaveAnimView.getMinimumWidth();
            int minimumHeight = iconWaveAnimView.getMinimumHeight();
            if (strTrim.endsWith(s.d(new byte[]{103, 7, 73, 2}, "86139a"))) {
                minimumWidth = minimumHeight;
            } else {
                minimumHeight = strTrim.endsWith(s.d(new byte[]{62, 1, 6, 78, 0}, "a00699")) ? (minimumWidth * 9) / 16 : (minimumWidth * 2) / 3;
            }
            iconWaveAnimView.getLayoutParams().height = minimumHeight;
            iconWaveAnimView.getLayoutParams().width = minimumWidth;
        }
        if (!strTrim.endsWith(s.d(new byte[]{62, 84, 77, 83}, "ae5bd4"))) {
            MimoMediaView mimoMediaView = new MimoMediaView(getContext());
            mimoMediaView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            mimoMediaView.setViewClickAreaType(ClickAreaType.TYPE_PICTURE);
            mimoMediaView.setPicStartCountDown(false);
            mimoMediaView.a(mimoAdInfo, this.mIEventHandler, getClickListener());
            mimoMediaView.setOutlineProvider(new t6(f9.a(getContext(), 4.5f)));
            mimoMediaView.setClipToOutline(true);
            iconWaveAnimView.removeAllViews();
            iconWaveAnimView.addView(mimoMediaView);
            return;
        }
        IconICP iconICP = new IconICP(getContext());
        iconICP.setStyle(4);
        iconICP.setScaleType(ImageView.ScaleType.FIT_XY);
        iconICP.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        String strF = strTrim.endsWith(s.d(new byte[]{60, 2, 76, 7}, "c34626")) ? mimoAdInfo.A : mimoAdInfo.f();
        if (com.miui.zeus.mimo.sdk.b.g(strF)) {
            strF = strTrim.endsWith(s.d(new byte[]{58, 85, Ascii.FS, 82}, "eddcf1")) ? mimoAdInfo.f() : mimoAdInfo.A;
        }
        iconICP.setOutlineProvider(new t6(f9.a(getContext(), 2.18f)));
        iconICP.setClipToOutline(true);
        String cachedResource = this.mIEventHandler.getCachedResource(strF, false);
        if (com.miui.zeus.mimo.sdk.b.h(cachedResource)) {
            strF = cachedResource;
        }
        iconICP.a(strF, getClickListener());
        iconWaveAnimView.removeAllViews();
        iconWaveAnimView.addView(iconICP);
    }

    public int createBannerView(MimoAdInfo mimoAdInfo) {
        if (mimoAdInfo == null) {
            return 0;
        }
        if (mimoAdInfo.p0.trim().startsWith(BANNER_TEMPLATE_A2_WAVE)) {
            return a0.o4;
        }
        if (mimoAdInfo.p0.trim().contains(BANNER_TEMPLATE_WAVE)) {
            return a0.m4;
        }
        boolean zStartsWith = mimoAdInfo.p0.trim().startsWith(BANNER_TEMPLATE_A2);
        boolean zD = mimoAdInfo.D();
        if (zStartsWith) {
            return zD ? a0.X : a0.T;
        }
        return zD ? a0.t2 : a0.E;
    }

    @Override // com.miui.zeus.mimo.sdk.view.IBindDataView
    public void destroy() {
        CommonActionHandler commonActionHandler = this.mCommonActionHandler;
        if (commonActionHandler != null) {
            commonActionHandler.a();
        }
        ViewFlipper viewFlipper = this.mViewFlipper;
        if (viewFlipper != null) {
            viewFlipper.stopFlipping();
        }
        DownloadButtonICP downloadButtonICP = this.mDownloadButtonICP;
        if (downloadButtonICP != null) {
            downloadButtonICP.b();
            this.mDownloadButtonICP.clearAnimation();
        }
    }

    @Override // android.view.View, com.miui.zeus.mimo.sdk.view.IBindDataView
    public View getRootView() {
        return this;
    }

    @Override // com.miui.zeus.mimo.sdk.view.IBindDataView
    public boolean onBackPressed() {
        return true;
    }

    @Override // com.miui.zeus.mimo.sdk.view.IBindDataView
    public void pause() {
    }

    @Override // com.miui.zeus.mimo.sdk.view.IBindDataView
    public void resume() {
    }

    @Override // com.miui.zeus.mimo.sdk.view.IBindDataView
    public void setAdInfo(Activity activity, MimoAdInfo mimoAdInfo, w3 w3Var) {
        this.mIEventHandler = w3Var;
        this.mAdInfo = mimoAdInfo;
        this.mCommonActionHandler = new CommonActionHandler(getContext(), activity, w3Var);
        initView((FrameLayout) LayoutInflater.from(getContext()).inflate(createBannerView(this.mAdInfo), (ViewGroup) this, true), mimoAdInfo, w3Var);
    }
}
