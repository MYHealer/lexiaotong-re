package com.miui.zeus.mimo.sdk.ad.template;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.miui.zeus.mimo.sdk.a0;
import com.miui.zeus.mimo.sdk.bean.MimoAdInfo;
import com.miui.zeus.mimo.sdk.c6;
import com.miui.zeus.mimo.sdk.click.ClickAreaType;
import com.miui.zeus.mimo.sdk.click.ClickEventType;
import com.miui.zeus.mimo.sdk.click.CommonActionHandler;
import com.miui.zeus.mimo.sdk.d7;
import com.miui.zeus.mimo.sdk.f9;
import com.miui.zeus.mimo.sdk.i;
import com.miui.zeus.mimo.sdk.i8;
import com.miui.zeus.mimo.sdk.j6;
import com.miui.zeus.mimo.sdk.j7;
import com.miui.zeus.mimo.sdk.k6;
import com.miui.zeus.mimo.sdk.k7;
import com.miui.zeus.mimo.sdk.k8;
import com.miui.zeus.mimo.sdk.l6;
import com.miui.zeus.mimo.sdk.l7;
import com.miui.zeus.mimo.sdk.m;
import com.miui.zeus.mimo.sdk.n6;
import com.miui.zeus.mimo.sdk.o7;
import com.miui.zeus.mimo.sdk.t6;
import com.miui.zeus.mimo.sdk.t7;
import com.miui.zeus.mimo.sdk.track.info.AdEvent;
import com.miui.zeus.mimo.sdk.u7;
import com.miui.zeus.mimo.sdk.video.MimoMediaView;
import com.miui.zeus.mimo.sdk.view.IBindDataView;
import com.miui.zeus.mimo.sdk.view.MimoGiftBoxView;
import com.miui.zeus.mimo.sdk.view.MimoUniversalSlideView;
import com.miui.zeus.mimo.sdk.view.component.AdMarkICP;
import com.miui.zeus.mimo.sdk.view.component.BrandICP;
import com.miui.zeus.mimo.sdk.view.component.CloseICP;
import com.miui.zeus.mimo.sdk.view.component.DownloadButtonICP;
import com.miui.zeus.mimo.sdk.view.component.IconICP;
import com.miui.zeus.mimo.sdk.view.component.ImageICP;
import com.miui.zeus.mimo.sdk.view.component.RootICP;
import com.miui.zeus.mimo.sdk.view.component.SixElementsView;
import com.miui.zeus.mimo.sdk.view.component.SummaryICP;
import com.miui.zeus.mimo.sdk.view.wave.WaveView;
import com.miui.zeus.mimo.sdk.w3;
import com.miui.zeus.mimo.sdk.y8;
import ijiami_1011.s.s.s;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class MimoTemplateView extends RootICP implements IBindDataView, d7 {
    private final int INPENDANT_POSITION_MIDDLE;
    private MimoAdInfo mAdInfo;
    private CloseICP mCloseICP;
    private CommonActionHandler mCommonActionHandler;
    private DownloadButtonICP mDownloadButtonICP;
    private w3 mIEventHandler;
    private k8 mShakeView;
    private ImageView mVolumeBtnView;
    private MimoMediaView mimoMediaView;
    private Runnable showRedPacketRainViewRunnable;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MimoGiftBoxView f5345a;

        public a(MimoGiftBoxView mimoGiftBoxView) {
            this.f5345a = mimoGiftBoxView;
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // java.lang.Runnable
        public void run() {
            MimoGiftBoxView mimoGiftBoxView = this.f5345a;
            MimoAdInfo mimoAdInfo = MimoTemplateView.this.mAdInfo;
            w3 w3Var = MimoTemplateView.this.mIEventHandler;
            i8 clickListener = MimoTemplateView.this.getClickListener();
            int width = mimoGiftBoxView.getChildAt(0).getWidth() + f9.a(mimoGiftBoxView.getContext(), 10.0f);
            ImageView imageView = new ImageView(mimoGiftBoxView.getContext());
            imageView.setBackgroundResource(a0.A0);
            mimoGiftBoxView.addView(imageView, 0, new RelativeLayout.LayoutParams(-1, -1));
            imageView.setOnClickListener(new j7(mimoGiftBoxView, clickListener, imageView));
            mimoGiftBoxView.b = LayoutInflater.from(mimoGiftBoxView.getContext()).inflate(a0.M2, (ViewGroup) mimoGiftBoxView, false);
            mimoGiftBoxView.addView(mimoGiftBoxView.b, mimoGiftBoxView.getChildCount(), new RelativeLayout.LayoutParams(-1, -1));
            mimoGiftBoxView.e = (LinearLayout) mimoGiftBoxView.b.findViewById(a0.h1);
            TextView textView = (TextView) mimoGiftBoxView.b.findViewById(a0.i1);
            IconICP iconICP = (IconICP) mimoGiftBoxView.b.findViewById(a0.O1);
            mimoGiftBoxView.f = iconICP;
            iconICP.setOutlineProvider(new t6(f9.a(mimoGiftBoxView.getContext(), 12.0f)));
            mimoGiftBoxView.f.setClipToOutline(true);
            if (com.miui.zeus.mimo.sdk.b.h(mimoAdInfo.i) && com.miui.zeus.mimo.sdk.b.h(mimoAdInfo.A)) {
                textView.setText(mimoAdInfo.i);
                mimoGiftBoxView.f.a(com.miui.zeus.mimo.sdk.b.h(mimoAdInfo.b(w3Var)) ? mimoAdInfo.b(w3Var) : mimoAdInfo.A, clickListener);
            } else {
                textView.setVisibility(8);
                mimoGiftBoxView.f.setVisibility(8);
                mimoGiftBoxView.b.setBackgroundResource(a0.M4);
            }
            mimoGiftBoxView.b.setOnClickListener(new k7(mimoGiftBoxView, clickListener));
            ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(0, width);
            mimoGiftBoxView.f5666a = valueAnimatorOfInt;
            valueAnimatorOfInt.setDuration(1500L);
            mimoGiftBoxView.f5666a.setRepeatCount(0);
            mimoGiftBoxView.f5666a.addUpdateListener(new l7(mimoGiftBoxView));
            mimoGiftBoxView.f5666a.start();
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (MimoTemplateView.this.mimoMediaView != null) {
                MimoTemplateView mimoTemplateView = MimoTemplateView.this;
                mimoTemplateView.setMute(!mimoTemplateView.mimoMediaView.e);
            }
        }
    }

    public class c implements SixElementsView.e {
        public c() {
        }

        @Override // com.miui.zeus.mimo.sdk.view.component.SixElementsView.e
        public void a(String str) {
            if (MimoTemplateView.this.mIEventHandler != null) {
                MimoTemplateView.this.mIEventHandler.onJumpWebView(str);
            }
        }
    }

    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ViewGroup f5348a;

        public d(ViewGroup viewGroup) {
            this.f5348a = viewGroup;
        }

        @Override // java.lang.Runnable
        public void run() {
            MimoTemplateView mimoTemplateView = MimoTemplateView.this;
            mimoTemplateView.showRedPacketRainView(mimoTemplateView.mAdInfo, this.f5348a, MimoTemplateView.this.mAdInfo.L0);
        }
    }

    public class e implements o7.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ o7 f5349a;
        public final /* synthetic */ ViewGroup b;

        public e(o7 o7Var, ViewGroup viewGroup) {
            this.f5349a = o7Var;
            this.b = viewGroup;
        }

        @Override // com.miui.zeus.mimo.sdk.o7.d
        public void a(ClickAreaType clickAreaType, n6 n6Var) {
            MimoTemplateView.this.mViewEventInfo = n6Var;
            MimoTemplateView.this.getClickListener().onClick(this.f5349a, clickAreaType);
            this.f5349a.b();
            this.f5349a.setVisibility(8);
            this.b.removeView(this.f5349a);
        }
    }

    public class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f5350a;
        public final /* synthetic */ DownloadButtonICP b;

        public f(View view, DownloadButtonICP downloadButtonICP) {
            this.f5350a = view;
            this.b = downloadButtonICP;
        }

        @Override // java.lang.Runnable
        public void run() {
            View viewFindViewById = this.f5350a.findViewById(a0.B5);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.b.getLayoutParams();
            layoutParams.leftMargin = f9.a(MimoTemplateView.this.getContext(), 7.0f);
            layoutParams.rightMargin = f9.a(MimoTemplateView.this.getContext(), 7.0f);
            layoutParams.width = viewFindViewById.getWidth() - f9.a(MimoTemplateView.this.getContext(), 14.0f);
        }
    }

    public class g implements i8 {

        public class a implements CommonActionHandler.c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ View f5352a;
            public final /* synthetic */ ClickAreaType b;
            public final /* synthetic */ l6 c;

            public a(View view, ClickAreaType clickAreaType, l6 l6Var) {
                this.f5352a = view;
                this.b = clickAreaType;
                this.c = l6Var;
            }

            @Override // com.miui.zeus.mimo.sdk.click.CommonActionHandler.c
            public void a(boolean z) {
                MimoTemplateView.this.notifyViewClicked(this.f5352a, this.b, z, this.c);
            }
        }

        public g() {
        }

        @Override // com.miui.zeus.mimo.sdk.i8
        public void onClick(View view, ClickAreaType clickAreaType) {
            l6 extShakeInfo;
            if (MimoTemplateView.this.mAdInfo == null) {
                m.b(s.d(new byte[]{40, 90, 11, 87, 99, 84, 12, Ascii.DC4, 10, 3, 69, 0, 51, 90, 3, 79}, "e3f871"), s.d(new byte[]{-41, -80, -37, -36, -66, -33, -123, -36, -21, -121, -94, -24, -43, -120, -10, 3, -36, -35, -34, -127, -9, -24, -43, -38, -111, -44, -29, -106, -35, -36, -37, -125, -49, -40}, "02b99d"));
                return;
            }
            if (com.miui.zeus.mimo.sdk.b.b(MimoTemplateView.this) < MimoTemplateView.this.mAdInfo.U0) {
                m.b(s.d(new byte[]{118, 123, 44, 123, 125}, "57e868"), s.d(new byte[]{-33, -73, -128, -127, -30, -39, -123, -36, -21, -121, -94, -24, -35, -113, -83, 94, -128, -37, -34, -127, -9, -24, -44, -53, -127, -48, -96, -52, -126, -8, -27, -115, -26, -19, -41, -3, -74, -48, -125, -62, 73, -121, -18, -53, -114, -31, -116, -128, -105, -119, -47, -29, -47, -121, -40, -37, -125, -13, -69, -125, -81, -107, -33, -41, -16, -121, -48, -15, -127, -58, -117}, "859deb"));
                com.miui.zeus.mimo.sdk.b.a(MimoTemplateView.this.mAdInfo, s.d(new byte[]{33, 41, 121, 33, 40, 111, 47, 43, 57, 48, 116, 54, 50, 42, 126, 49, 38}, "be0bc0"), s.d(new byte[]{-34, -79, -116, -43, -26, -38, -123, -36, -21, -121, -94, -24, -36, -119, -95, 10, -124, -40, -34, -127, -9, -24, -44, -53, -128, -42, -84, -104, -122, -5, -27, -115, -26, -19, -41, -3, -73, -42, -113, -106, 77, -124, -18, -53, -114, -31, -116, -128, -106, -113, -35, -73, -43, -124, -40, -37, -125, -13, -69, -125, -82, -109, -45, -125, -12, -124, -48, -15, -127, -58, -117}, "9350aa"), System.currentTimeMillis(), (String) null, s.d(new byte[]{-127, -128, -121, -42, -94, -20, -124, -54, -33, -121, -88, -51, -125, -93, -68, -38, -77, -23, -121, -4, -24, -121, -117, -61, 72, -36, -73, -100, -37, -27, -36, -127, -55, -34, -39, -30, -48, -36, -127, -116, -42, -9, -21, -126, -15, -62, -41, -42, -15, -36, -119, -90, -44, -62, -37}, "d9833f"));
                return;
            }
            if (AdMarkICP.a(view) || ClickAreaType.TYPE_CLOSE == clickAreaType) {
                MimoTemplateView.this.notifyViewClosed(view, clickAreaType);
                return;
            }
            if (MimoTemplateView.this.mShakeView != null) {
                extShakeInfo = MimoTemplateView.this.mShakeView.getExtShakeInfo();
                MimoTemplateView.this.mShakeView.a();
                MimoTemplateView.this.mAdInfo.a1 = false;
                if (MimoTemplateView.this.mShakeView.getParent() != null) {
                    ((ViewGroup) MimoTemplateView.this.mShakeView.getParent()).removeView(MimoTemplateView.this.mShakeView);
                }
                MimoTemplateView.this.mShakeView = null;
            } else {
                extShakeInfo = null;
            }
            if (MimoTemplateView.this.mAdInfo.B1.booleanValue() && MimoTemplateView.this.mDownloadButtonICP != null && clickAreaType == MimoTemplateView.this.mDownloadButtonICP.getClickAreaType() && !MimoTemplateView.this.mDownloadButtonICP.a()) {
                MimoTemplateView.this.notifyViewClicked(view, clickAreaType, false, null);
                MimoTemplateView.this.notifyViewClosed(view, ClickAreaType.TYPE_FRAUD_CLOSE);
            } else if (MimoTemplateView.this.mCommonActionHandler != null) {
                MimoTemplateView.this.mCommonActionHandler.b = new a(view, clickAreaType, extShakeInfo);
                MimoTemplateView.this.mCommonActionHandler.a(MimoTemplateView.this.mAdInfo, clickAreaType);
            }
        }
    }

    public MimoTemplateView(Context context) {
        this(context, null);
    }

    public MimoTemplateView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MimoTemplateView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.INPENDANT_POSITION_MIDDLE = 0;
        this.showRedPacketRainViewRunnable = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public i8 getClickListener() {
        return new g();
    }

    private j6 getClickViewInfo(View view) {
        return new c6(view, this, this.mCloseICP, null, new View[]{this.mDownloadButtonICP}, this.mViewEventInfo, true, true).f5387a;
    }

    private String getIconPath(MimoAdInfo mimoAdInfo) {
        String strB = mimoAdInfo.b(this.mIEventHandler);
        String str = mimoAdInfo.A;
        if (TextUtils.isEmpty(strB)) {
            return !TextUtils.isEmpty(str) ? str : "";
        }
        return strB;
    }

    private void getOriginWave(MimoAdInfo mimoAdInfo) {
        ViewGroup viewGroup = (FrameLayout) LayoutInflater.from(getContext()).inflate(a0.L2, (ViewGroup) this, true);
        initMarkView(viewGroup);
        initCloseView(viewGroup);
        initIconView(viewGroup);
        initSummaryView(viewGroup);
        initSixElementsView(viewGroup);
        initWaveView(viewGroup);
        resizeAdViewSize(mimoAdInfo, viewGroup, f9.a(getContext(), 257.0f));
    }

    private void getTemplateAd1() {
        FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(getContext()).inflate(a0.w0, (ViewGroup) this, true);
        initMarkView(frameLayout);
        initCloseView(frameLayout);
        initIconView(frameLayout);
        initSixElementsView(frameLayout);
        initBrandView(frameLayout);
        resizeAdViewSize(this.mAdInfo, frameLayout, f9.a(getContext(), 257.0f));
    }

    private void getTemplateAd2() {
        FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(getContext()).inflate(a0.b1, (ViewGroup) this, true);
        initMarkView(frameLayout);
        initCloseView(frameLayout);
        initSummaryView(frameLayout);
        initImageView(frameLayout);
        initSixElementsView(frameLayout);
        resizeAdViewSize(this.mAdInfo, frameLayout, f9.a(getContext(), 128.0f));
    }

    private void getTemplateAd3() {
        FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(getContext()).inflate(a0.B1, (ViewGroup) this, true);
        initMarkView(frameLayout);
        initImageView(frameLayout);
        initCloseView(frameLayout);
        initSummaryView(frameLayout);
        initDownloadView(frameLayout);
        initSixElementsView(frameLayout);
        resizeAdViewSize(this.mAdInfo, frameLayout, f9.a(getContext(), 115.0f));
    }

    private void getTemplateAd4() {
        FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(getContext()).inflate(a0.Z1, (ViewGroup) this, true);
        initMarkView(frameLayout);
        initImageView(frameLayout);
        initCloseView(frameLayout);
        initSummaryView(frameLayout);
        initDownloadView(frameLayout);
        initSixElementsView(frameLayout);
        resizeAdViewSize(this.mAdInfo, frameLayout, f9.a(getContext(), 227.0f));
    }

    private void getTemplateAd5(boolean z) {
        FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(getContext()).inflate(z ? a0.u4 : a0.p2, (ViewGroup) this, true);
        initMarkView(frameLayout);
        initImageView(frameLayout);
        initCloseView(frameLayout);
        initSummaryView(frameLayout);
        initDownloadView(frameLayout);
        initSixElementsView(frameLayout, Color.parseColor(s.d(new byte[]{71, 7, 81, 80, 7, 95, 7}, "da76a9")), true);
        ViewGroup viewGroup = (RelativeLayout) frameLayout.findViewById(a0.S3);
        if (z) {
            MimoGiftBoxView mimoGiftBoxView = (MimoGiftBoxView) frameLayout.findViewById(a0.g);
            mimoGiftBoxView.post(new a(mimoGiftBoxView));
            initInPendantView(this.mAdInfo, mimoGiftBoxView, 0, true);
        } else {
            initInPendantView(this.mAdInfo, viewGroup, 0, true);
        }
        initBubble4View(this.mAdInfo, viewGroup, z);
        initTiltAngle(this.mAdInfo, viewGroup);
        initRedPacketRainView(this.mAdInfo, viewGroup);
        resizeAdViewSize(this.mAdInfo, frameLayout, f9.a(getContext(), 287.0f));
        initUniversalSlideView(viewGroup);
        initShakeView(this.mAdInfo, viewGroup);
    }

    private void getTemplateAd6() {
        FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(getContext()).inflate(a0.P2, (ViewGroup) this, true);
        initMarkView(frameLayout);
        initCloseView(frameLayout);
        initBrandView(frameLayout);
        initSummaryView(frameLayout);
        initImagesView(this.mAdInfo.j(), frameLayout);
        initDownloadView(frameLayout);
        initSixElementsView(frameLayout);
        resizeAdViewSize(this.mAdInfo, frameLayout, f9.a(getContext(), 227.0f));
        resizeBrandViewWidth(frameLayout);
    }

    private void getTemplateAd7() {
        FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(getContext()).inflate(a0.o3, (ViewGroup) this, true);
        initMarkView(frameLayout);
        initCloseView(frameLayout);
        initIconView(frameLayout);
        initSixElementsView(frameLayout);
        initBrandView(frameLayout);
        initDownloadView(frameLayout);
        resizeBrandViewWidth(frameLayout);
        resizeAdViewSize(this.mAdInfo, frameLayout, f9.a(getContext(), 265.0f));
    }

    private void getTemplateIcon() {
        FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(getContext()).inflate(a0.c0, (ViewGroup) this, true);
        initMarkView(frameLayout);
        initCloseView(frameLayout);
        initIconView(frameLayout);
    }

    private void getTextFloatingAd1(MimoAdInfo mimoAdInfo) {
        FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(getContext()).inflate(a0.k1, (ViewGroup) this, true);
        RelativeLayout relativeLayout = (RelativeLayout) frameLayout.findViewById(a0.S3);
        initMarkView(frameLayout);
        initCloseView(frameLayout);
        initIconView(frameLayout);
        initVideoView(frameLayout, relativeLayout);
        initBrandView(frameLayout);
        initSixElementsView(frameLayout, Color.parseColor(s.d(new byte[]{16, 122, 6, 7, 7, 7, 7, 2, 0}, "384aaa")), false);
        initSummaryView(frameLayout);
        initDownloadView(frameLayout);
        initInPendantView(mimoAdInfo, (RelativeLayout) frameLayout.findViewById(a0.t5), 0, false);
        initBubble4View(mimoAdInfo, relativeLayout, false);
        resizeAdViewSize(mimoAdInfo, frameLayout, f9.a(getContext(), 221.0f));
        resizeFloatingDownloadBtnView(frameLayout, false);
        initRedPacketRainView(mimoAdInfo, relativeLayout);
        initUniversalSlideView(relativeLayout);
        initShakeView(mimoAdInfo, relativeLayout);
    }

    private void getTextFloatingAd2(MimoAdInfo mimoAdInfo) {
        FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(getContext()).inflate(a0.J1, (ViewGroup) this, true);
        RelativeLayout relativeLayout = (RelativeLayout) frameLayout.findViewById(a0.S3);
        initVideoView(frameLayout, relativeLayout);
        initMarkView(frameLayout);
        initCloseView(frameLayout);
        initIconView(frameLayout);
        initBrandView(frameLayout);
        initSixElementsView(frameLayout, Color.parseColor(s.d(new byte[]{Ascii.DC2, 117, 3, 0, 87, 86, 7, 2, 0}, "171f10")), false);
        initSummaryView(frameLayout);
        initDownloadView(frameLayout);
        initInPendantView(mimoAdInfo, (RelativeLayout) frameLayout.findViewById(a0.t5), 0, false);
        initBubble4View(mimoAdInfo, relativeLayout, false);
        resizeAdViewSize(mimoAdInfo, frameLayout, f9.a(getContext(), 272.3f));
        resizeFloatingDownloadBtnView(frameLayout, true);
        initRedPacketRainView(mimoAdInfo, relativeLayout);
        initUniversalSlideView(relativeLayout);
        initShakeView(mimoAdInfo, relativeLayout);
    }

    private void getVerticalTemplate1(MimoAdInfo mimoAdInfo) {
        FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(getContext()).inflate(a0.n1, (ViewGroup) this, true);
        RelativeLayout relativeLayout = (RelativeLayout) frameLayout.findViewById(a0.S3);
        ViewGroup viewGroup = (RelativeLayout) frameLayout.findViewById(a0.i0);
        initVideoView(frameLayout, relativeLayout);
        initMarkView(frameLayout);
        initCloseView(frameLayout);
        initIconView(frameLayout);
        initBrandView(frameLayout);
        initSummaryView(frameLayout);
        initDownloadView(frameLayout);
        initSixElementsView(frameLayout, Color.parseColor(s.d(new byte[]{SignedBytes.MAX_POWER_OF_TWO, 4, 4, 86, 2, 4, 7}, "cbb0db")), false);
        initInPendantView(mimoAdInfo, (RelativeLayout) frameLayout.findViewById(a0.t5), 0, false);
        initBubble6View(mimoAdInfo, relativeLayout);
        resizeVertical(mimoAdInfo, frameLayout);
        initRedPacketRainView(mimoAdInfo, relativeLayout);
        initUniversalSlideView(viewGroup);
        initShakeView(mimoAdInfo, viewGroup);
    }

    private void getVerticalTemplate2(MimoAdInfo mimoAdInfo) {
        FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(getContext()).inflate(a0.N0, (ViewGroup) this, true);
        RelativeLayout relativeLayout = (RelativeLayout) frameLayout.findViewById(a0.S3);
        initVideoView(frameLayout, relativeLayout);
        initMarkView(frameLayout);
        initCloseView(frameLayout);
        initIconView(frameLayout);
        initBrandView(frameLayout);
        initSummaryView(frameLayout);
        initDownloadView(frameLayout);
        initSixElementsView(frameLayout);
        initInPendantView(mimoAdInfo, (RelativeLayout) frameLayout.findViewById(a0.t5), 0, false);
        initBubble6View(mimoAdInfo, relativeLayout);
        resizeVertical(mimoAdInfo, frameLayout);
        initRedPacketRainView(mimoAdInfo, relativeLayout);
        initUniversalSlideView(relativeLayout);
        initShakeView(mimoAdInfo, relativeLayout);
    }

    private void initBrandView(View view) {
        BrandICP brandICP = (BrandICP) view.findViewById(a0.K0);
        if (com.miui.zeus.mimo.sdk.b.g(this.mAdInfo.i)) {
            brandICP.setVisibility(8);
        } else {
            brandICP.setVisibility(0);
            brandICP.a(this.mAdInfo.i, getClickListener());
        }
    }

    private void initBubble4View(MimoAdInfo mimoAdInfo, View view, boolean z) {
        int id;
        int i;
        if (com.miui.zeus.mimo.sdk.b.a(mimoAdInfo.K0, s.d(new byte[]{84, 16, 86, 82, 92, 1}, "6e400d"))) {
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            int iIndexOfChild = viewGroup.indexOfChild(view);
            t7 t7Var = new t7(viewGroup.getContext());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            if (z) {
                id = view.getId();
                i = 7;
            } else {
                layoutParams.addRule(6, view.getId());
                id = view.getId();
                i = 8;
            }
            layoutParams.addRule(i, id);
            if (iIndexOfChild >= 0) {
                viewGroup.addView(t7Var, iIndexOfChild + 1, layoutParams);
            } else {
                viewGroup.addView(t7Var, layoutParams);
            }
            t7Var.a(mimoAdInfo.L0, getClickListener());
        }
    }

    private void initBubble6View(MimoAdInfo mimoAdInfo, View view) {
        if (com.miui.zeus.mimo.sdk.b.a(mimoAdInfo.K0, s.d(new byte[]{85, 66, 0, 7, 13, 84}, "77bea1"))) {
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            int iIndexOfChild = viewGroup.indexOfChild(view);
            getResources().getConfiguration();
            u7 u7Var = new u7(viewGroup.getContext(), 1);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(7, view.getId());
            if (iIndexOfChild >= 0) {
                viewGroup.addView(u7Var, iIndexOfChild + 1, layoutParams);
            } else {
                viewGroup.addView(u7Var, layoutParams);
            }
            u7Var.a(mimoAdInfo.L0, getClickListener());
        }
    }

    private void initCloseView(View view) {
        CloseICP closeICP = (CloseICP) view.findViewById(a0.K1);
        this.mCloseICP = closeICP;
        closeICP.setClickAreaListener(getClickListener());
    }

    private void initDownloadView(View view) {
        DownloadButtonICP downloadButtonICP = (DownloadButtonICP) view.findViewById(a0.C3);
        this.mDownloadButtonICP = downloadButtonICP;
        downloadButtonICP.a(this.mAdInfo, getClickListener());
    }

    private void initIconView(View view) {
        if (this.mAdInfo == null) {
            return;
        }
        IconICP iconICP = (IconICP) view.findViewById(a0.Z);
        String iconPath = getIconPath(this.mAdInfo);
        if (!com.miui.zeus.mimo.sdk.b.h(iconPath)) {
            iconICP.setVisibility(8);
        } else {
            iconICP.setVisibility(0);
            iconICP.a(iconPath, getClickListener());
        }
    }

    private void initImageView(View view) {
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(a0.S3);
        relativeLayout.removeAllViews();
        initVideoView(view, relativeLayout);
    }

    private void initImagesView(List<String> list, View view) {
        ImageICP imageICP = (ImageICP) view.findViewById(a0.K);
        ImageICP imageICP2 = (ImageICP) view.findViewById(a0.n);
        ImageICP imageICP3 = (ImageICP) view.findViewById(a0.z0);
        for (int i = 0; i < list.size(); i++) {
            if (i == 0) {
                imageICP.a(list.get(i), getClickListener());
            }
            if (i == 1) {
                imageICP2.a(list.get(i), getClickListener());
            }
            if (i == 2) {
                imageICP3.a(list.get(i), getClickListener());
            }
        }
    }

    private void initInPendantView(MimoAdInfo mimoAdInfo, ViewGroup viewGroup, int i, boolean z) {
        if (!com.miui.zeus.mimo.sdk.b.a(mimoAdInfo.K0, s.d(new byte[]{93, 86, 51, 92, 8, 5, 0, 10, Ascii.DC2}, "48c9fa")) || mimoAdInfo.L0.isEmpty() || getContext() == null) {
            return;
        }
        ImageICP imageICP = new ImageICP(getContext());
        imageICP.setClickAreaType(ClickAreaType.TYPE_MOD);
        imageICP.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        imageICP.a(mimoAdInfo.L0.get(0), getClickListener());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(f9.a(getContext(), 61.0f), f9.a(getContext(), 61.0f));
        layoutParams.rightMargin = f9.a(getContext(), 4.0f);
        layoutParams.addRule(z ? 20 : 21);
        if (i == 0) {
            layoutParams.addRule(15);
        } else {
            layoutParams.addRule(12);
            layoutParams.bottomMargin = f9.a(getContext(), 4.0f);
        }
        viewGroup.addView(imageICP, layoutParams);
    }

    private void initMarkView(View view) {
        if (this.mAdInfo == null) {
            return;
        }
        AdMarkICP adMarkICP = (AdMarkICP) view.findViewById(a0.E1);
        adMarkICP.setGravity(17);
        adMarkICP.a(this.mAdInfo, getClickListener());
    }

    private void initRedPacketRainView(MimoAdInfo mimoAdInfo, ViewGroup viewGroup) {
        String str = mimoAdInfo.K0;
        if (TextUtils.isEmpty(str) || !s.d(new byte[]{87, 19, 91, 19, SignedBytes.MAX_POWER_OF_TWO, 91, 15, 3}, "3a4c02").equals(str) || mimoAdInfo.L0.isEmpty()) {
            return;
        }
        Runnable runnable = this.showRedPacketRainViewRunnable;
        if (runnable != null) {
            y8.b.removeCallbacks(runnable);
        }
        d dVar = new d(viewGroup);
        this.showRedPacketRainViewRunnable = dVar;
        y8.b.postDelayed(dVar, mimoAdInfo.n());
    }

    private void initShakeView(MimoAdInfo mimoAdInfo, ViewGroup viewGroup) {
        if (!mimoAdInfo.a1 || mimoAdInfo.a(ClickAreaType.TYPE_NATIVE_SHAKE) == ClickEventType.CLICK_DISABLE) {
            return;
        }
        k8 k8Var = this.mShakeView;
        if (k8Var != null) {
            k8Var.a();
            viewGroup.removeView(this.mShakeView);
        }
        this.mShakeView = new k8(getContext(), null);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        viewGroup.addView(this.mShakeView, layoutParams);
        this.mShakeView.a(mimoAdInfo, getClickListener());
        this.mShakeView.c();
    }

    private void initSixElementsView(View view) {
        initSixElementsView(view, Color.parseColor(s.d(new byte[]{26, 1, 0, 1, 80, 86, 82, 87, 85}, "9902ce")), false);
    }

    private void initSixElementsView(View view, int i, boolean z) {
        SixElementsView sixElementsView = (SixElementsView) view.findViewById(a0.T1);
        sixElementsView.setVisibility(this.mAdInfo.D() ? 0 : 4);
        sixElementsView.setTextColor(i);
        MimoAdInfo mimoAdInfo = this.mAdInfo;
        String str = mimoAdInfo.i;
        String str2 = mimoAdInfo.k;
        String strE = mimoAdInfo.e();
        MimoAdInfo mimoAdInfo2 = this.mAdInfo;
        sixElementsView.a(str, str2, strE, mimoAdInfo2.m, mimoAdInfo2.l, mimoAdInfo2.n, z);
        sixElementsView.setOnItemClickListener(new c());
        View viewFindViewById = view.findViewById(a0.N);
        if (viewFindViewById != null) {
            viewFindViewById.setVisibility(this.mAdInfo.D() ? 0 : 4);
        }
    }

    private void initSummaryView(View view) {
        String strP = this.mAdInfo.p();
        SummaryICP summaryICP = (SummaryICP) view.findViewById(a0.T2);
        if (com.miui.zeus.mimo.sdk.b.g(strP)) {
            summaryICP.setVisibility(8);
        } else {
            summaryICP.setVisibility(0);
            summaryICP.a(strP, getClickListener());
        }
    }

    private void initTiltAngle(MimoAdInfo mimoAdInfo, View view) {
        if (!com.miui.zeus.mimo.sdk.b.a(mimoAdInfo.K0, s.d(new byte[]{17, 13, 93, 68, 113, 11, 6, 8, 3}, "ed100e")) || mimoAdInfo.L0.isEmpty()) {
            return;
        }
        ImageICP imageICP = new ImageICP(view.getContext());
        imageICP.setScaleType(ImageView.ScaleType.FIT_XY);
        imageICP.setClickAreaType(ClickAreaType.TYPE_MOD);
        imageICP.a(mimoAdInfo.L0.get(0), getClickListener());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(f9.a(view.getContext(), 82.0f), f9.a(view.getContext(), 82.0f));
        layoutParams.addRule(8, view.getId());
        layoutParams.addRule(7, view.getId());
        ((ViewGroup) view.getParent()).addView(imageICP, layoutParams);
        SixElementsView sixElementsView = (SixElementsView) ((ViewGroup) view.getParent()).findViewById(a0.T1);
        if (sixElementsView != null) {
            sixElementsView.bringToFront();
        }
    }

    private void initUniversalSlideView(ViewGroup viewGroup) {
        MimoAdInfo mimoAdInfo = this.mAdInfo;
        if (mimoAdInfo == null || mimoAdInfo.a(ClickAreaType.TYPE_UNIVERSAL_SLIDE) == ClickEventType.CLICK_DISABLE) {
            return;
        }
        MimoUniversalSlideView mimoUniversalSlideView = new MimoUniversalSlideView(getContext(), null);
        mimoUniversalSlideView.a(this.mAdInfo, this);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        viewGroup.addView(mimoUniversalSlideView, layoutParams);
    }

    private void initVideoView(View view, RelativeLayout relativeLayout) {
        this.mVolumeBtnView = (ImageView) view.findViewById(a0.Z2);
        MimoMediaView mimoMediaView = new MimoMediaView(getContext());
        this.mimoMediaView = mimoMediaView;
        relativeLayout.addView(mimoMediaView, new FrameLayout.LayoutParams(-1, -1, 17));
        this.mimoMediaView.a(s.d(new byte[]{79, 92, 69, 71, 91, 85, 0, 8}, "997326").equalsIgnoreCase(this.mAdInfo.I) ? 1 : 2);
        this.mimoMediaView.setProgressViewVisibility(this.mAdInfo.E() ? 0 : 8);
        this.mimoMediaView.setPicStartCountDown(false);
        this.mimoMediaView.setLooping(true);
        this.mimoMediaView.setOnVideoAdListener(this);
        this.mimoMediaView.setMute(this.mIEventHandler.isMuted());
        this.mimoMediaView.a(this.mAdInfo, this.mIEventHandler, getClickListener());
        this.mVolumeBtnView.setOnClickListener(new b());
    }

    private void initWaveView(ViewGroup viewGroup) {
        WaveView waveView = (WaveView) viewGroup.findViewById(a0.q);
        waveView.setWavePositionLevel(1);
        waveView.w = (-1600) + (2000 / 5.0f);
        waveView.invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyViewClicked(View view, ClickAreaType clickAreaType, boolean z, l6 l6Var) {
        AdEvent adEvent = AdEvent.CLICK;
        MimoAdInfo mimoAdInfo = this.mAdInfo;
        n6 n6Var = this.mViewEventInfo;
        String strD = s.d(new byte[]{103}, "79c4a4");
        if (z) {
            clickAreaType = ClickAreaType.TYPE_CPM_BUTTON;
        }
        com.miui.zeus.mimo.sdk.b.a(adEvent, mimoAdInfo, n6Var, k6.a(strD, clickAreaType, getClickViewInfo(view), l6Var));
        w3 w3Var = this.mIEventHandler;
        if (w3Var != null) {
            w3Var.onClicked();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyViewClosed(View view, ClickAreaType clickAreaType) {
        com.miui.zeus.mimo.sdk.b.a(AdEvent.CLOSE, this.mAdInfo, this.mViewEventInfo, k6.a(null, getClickViewInfo(view), clickAreaType));
        w3 w3Var = this.mIEventHandler;
        if (w3Var != null) {
            w3Var.onClickCloseView();
        }
    }

    private void resizeAdViewSize(MimoAdInfo mimoAdInfo, View view, int i) {
        RelativeLayout relativeLayout;
        int iA;
        if (mimoAdInfo == null || view == null || com.miui.zeus.mimo.sdk.b.g(mimoAdInfo.h0) || com.miui.zeus.mimo.sdk.b.g(mimoAdInfo.i0) || (relativeLayout = (RelativeLayout) view.findViewById(a0.t5)) == null) {
            return;
        }
        int iA2 = com.miui.zeus.mimo.sdk.b.a(mimoAdInfo.h0, 0);
        int iA3 = com.miui.zeus.mimo.sdk.b.a(mimoAdInfo.i0, 0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) relativeLayout.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new FrameLayout.LayoutParams(-1, i);
        }
        if (iA2 != 0) {
            layoutParams.width = Math.min(f9.a(getContext(), iA2), f9.d(getContext()));
        }
        if (iA3 == 0) {
            int i2 = layoutParams.width;
            if (i2 <= 0) {
                layoutParams.height = i;
            } else {
                iA = Math.min(Math.max((int) (i2 / ((f9.a(getContext(), 392.0f) * 1.0f) / i)), i), f9.d(getContext()));
            }
            relativeLayout.setLayoutParams(layoutParams);
        }
        iA = f9.a(getContext(), iA3);
        layoutParams.height = iA;
        relativeLayout.setLayoutParams(layoutParams);
    }

    private static void resizeBrandViewWidth(FrameLayout frameLayout) {
        com.miui.zeus.mimo.sdk.b.a((LinearLayout) frameLayout.findViewById(a0.L1), (AdMarkICP) frameLayout.findViewById(a0.E1), (BrandICP) frameLayout.findViewById(a0.K0));
    }

    private void resizeFloatingDownloadBtnView(View view, boolean z) {
        if (!z || (TextUtils.isEmpty(this.mAdInfo.i) && TextUtils.isEmpty(this.mAdInfo.A))) {
            if (z || (TextUtils.isEmpty(this.mAdInfo.p()) && TextUtils.isEmpty(this.mAdInfo.i) && TextUtils.isEmpty(this.mAdInfo.A))) {
                DownloadButtonICP downloadButtonICP = (DownloadButtonICP) view.findViewById(a0.C3);
                downloadButtonICP.post(new f(view, downloadButtonICP));
                requestLayout();
            }
        }
    }

    private void resizeVertical(MimoAdInfo mimoAdInfo, View view) {
        if (mimoAdInfo == null || view == null || com.miui.zeus.mimo.sdk.b.g(mimoAdInfo.h0) || com.miui.zeus.mimo.sdk.b.g(mimoAdInfo.i0)) {
            return;
        }
        int iA = f9.a(getContext(), 393.0f);
        int iA2 = f9.a(getContext(), 220.7f);
        int iA3 = TextUtils.isEmpty(mimoAdInfo.h0) ? 0 : com.miui.zeus.mimo.sdk.b.a(mimoAdInfo.h0, 0);
        int iA4 = TextUtils.isEmpty(mimoAdInfo.i0) ? 0 : com.miui.zeus.mimo.sdk.b.a(mimoAdInfo.i0, 0);
        View viewFindViewById = view.findViewById(a0.t5);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13);
        viewFindViewById.setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
        ViewGroup.LayoutParams layoutParams3 = layoutParams2;
        if (layoutParams2 == null) {
            RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(iA2, iA);
            layoutParams4.addRule(13);
            layoutParams3 = layoutParams4;
        }
        Context context = getContext();
        int iA5 = iA3 == 0 ? f9.a(context, 220.7f) : Math.min(f9.a(context, iA3), f9.d(getContext()));
        layoutParams3.width = iA5;
        layoutParams3.height = iA4 == 0 ? (int) (iA5 / 0.56f) : Math.min(f9.a(getContext(), iA4), (int) (f9.d(getContext()) / 0.56f));
        view.setLayoutParams(layoutParams3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMute(boolean z) {
        MimoMediaView mimoMediaView = this.mimoMediaView;
        if (mimoMediaView != null) {
            mimoMediaView.setMute(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showRedPacketRainView(MimoAdInfo mimoAdInfo, ViewGroup viewGroup, List<String> list) {
        o7 o7Var = new o7(getContext(), null);
        o7Var.setDuration(mimoAdInfo.J0 * 1000);
        o7Var.setImages(list);
        o7Var.setRedPacketItemClickListener(new e(o7Var, viewGroup));
        o7Var.a();
        viewGroup.addView(o7Var, new RelativeLayout.LayoutParams(-1, -1));
    }

    @Override // com.miui.zeus.mimo.sdk.view.IBindDataView
    public void destroy() {
        MimoMediaView mimoMediaView = this.mimoMediaView;
        if (mimoMediaView != null) {
            mimoMediaView.b();
        }
        CommonActionHandler commonActionHandler = this.mCommonActionHandler;
        if (commonActionHandler != null) {
            commonActionHandler.a();
        }
        DownloadButtonICP downloadButtonICP = this.mDownloadButtonICP;
        if (downloadButtonICP != null) {
            downloadButtonICP.b();
        }
        Runnable runnable = this.showRedPacketRainViewRunnable;
        if (runnable != null) {
            y8.b.removeCallbacks(runnable);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        k8 k8Var;
        super.onAttachedToWindow();
        MimoAdInfo mimoAdInfo = this.mAdInfo;
        if (mimoAdInfo == null || !mimoAdInfo.a1 || (k8Var = this.mShakeView) == null || k8Var.i) {
            return;
        }
        k8Var.c();
    }

    @Override // com.miui.zeus.mimo.sdk.view.IBindDataView
    public boolean onBackPressed() {
        return false;
    }

    @Override // com.miui.zeus.mimo.sdk.d7
    public void onCreateViewSuccess(i iVar) {
    }

    @Override // com.miui.zeus.mimo.sdk.d7
    public void onPicEnd() {
    }

    @Override // com.miui.zeus.mimo.sdk.d7
    public void onPicMode() {
    }

    @Override // com.miui.zeus.mimo.sdk.d7
    public void onVideoEnd() {
        MimoMediaView mimoMediaView = this.mimoMediaView;
        if (mimoMediaView == null) {
            return;
        }
        mimoMediaView.setProgress(100);
    }

    @Override // com.miui.zeus.mimo.sdk.d7
    public void onVideoError() {
    }

    @Override // com.miui.zeus.mimo.sdk.d7
    public void onVideoPause() {
    }

    @Override // com.miui.zeus.mimo.sdk.d7
    public void onVideoProgressUpdate(int i, int i2) {
        MimoMediaView mimoMediaView = this.mimoMediaView;
        if (mimoMediaView == null) {
            return;
        }
        mimoMediaView.setProgress((i * 100) / i2);
    }

    @Override // com.miui.zeus.mimo.sdk.d7
    public void onVideoResume() {
    }

    @Override // com.miui.zeus.mimo.sdk.d7
    public void onVideoStart() {
        if (this.mimoMediaView == null) {
            return;
        }
        ImageView imageView = this.mVolumeBtnView;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
        this.mimoMediaView.setProgress(0);
    }

    @Override // com.miui.zeus.mimo.sdk.d7
    public void onVolumeChanged(boolean z) {
        ImageView imageView = this.mVolumeBtnView;
        if (imageView != null) {
            imageView.setSelected(!z);
        }
    }

    @Override // com.miui.zeus.mimo.sdk.view.IBindDataView
    public void pause() {
        if (this.mAdInfo == null) {
            return;
        }
        MimoMediaView mimoMediaView = this.mimoMediaView;
        if (mimoMediaView != null) {
            mimoMediaView.a();
        }
        k8 k8Var = this.mShakeView;
        if (k8Var != null) {
            k8Var.a();
        }
        Runnable runnable = this.showRedPacketRainViewRunnable;
        if (runnable != null) {
            y8.b.removeCallbacks(runnable);
        }
    }

    @Override // com.miui.zeus.mimo.sdk.view.IBindDataView
    public void resume() {
        if (this.mAdInfo == null) {
            return;
        }
        MimoMediaView mimoMediaView = this.mimoMediaView;
        if (mimoMediaView != null) {
            mimoMediaView.c();
        }
        k8 k8Var = this.mShakeView;
        if (k8Var != null) {
            k8Var.c();
        }
    }

    @Override // com.miui.zeus.mimo.sdk.view.IBindDataView
    public void setAdInfo(Activity activity, MimoAdInfo mimoAdInfo, w3 w3Var) {
        if (mimoAdInfo == null || getContext() == null) {
            return;
        }
        this.mAdInfo = mimoAdInfo;
        setCLickAreaListener(getClickListener());
        this.mIEventHandler = w3Var;
        this.mCommonActionHandler = new CommonActionHandler(getContext(), activity, w3Var);
        removeAllViews();
        if (s.d(new byte[]{12, 16, 8, 3, 88, 90, 53, 1, 11, Ascii.DC2, 93, 4, Ascii.ETB, 7, 80}, "cbad14").equals(mimoAdInfo.p0.trim())) {
            getTemplateAd1();
            return;
        }
        if (s.d(new byte[]{91, Ascii.SYN, 13, 4, 90, 87, 53, 1, 11, Ascii.DC2, 93, 4, SignedBytes.MAX_POWER_OF_TWO, 1, 86}, "4ddc39").equals(mimoAdInfo.p0.trim())) {
            getTemplateAd2();
            return;
        }
        if (s.d(new byte[]{13, 71, 81, 85, 13, 90, 53, 1, 11, Ascii.DC2, 93, 4, Ascii.SYN, 80, 11}, "b582d4").equals(mimoAdInfo.p0.trim())) {
            getTemplateAd3();
            return;
        }
        if (s.d(new byte[]{88, Ascii.ETB, 10, 82, 81, 10, 53, 1, 11, Ascii.DC2, 93, 4, 67, 0, 87}, "7ec58d").equals(mimoAdInfo.p0.trim())) {
            getTemplateAd4();
            return;
        }
        if (!s.d(new byte[]{86, 66, 89, 2, 93, 12, 53, 1, 11, Ascii.DC2, 93, 4, 77, 85, 5}, "900e4b").equals(mimoAdInfo.p0.trim())) {
            if (s.d(new byte[]{88, 67, 94, 1, 13, 15, 53, 1, 11, Ascii.DC2, 93, 4, 67, 84, 1}, "717fda").equals(mimoAdInfo.p0.trim())) {
                getTemplateAd6();
                return;
            }
            if (s.d(new byte[]{11, 17, 93, 1, 12, 15, 53, 1, 11, Ascii.DC2, 93, 4, 16, 6, 12}, "dc4fea").equals(mimoAdInfo.p0.trim())) {
                getTemplateAd7();
                return;
            }
            if (s.d(new byte[]{80, 95, Ascii.DC4, 95, 77, 94, 15, 16, 7, 14, 118, 12, 94, 68}, "80f671").equals(mimoAdInfo.p0.trim())) {
                getTemplateAd5(true);
                return;
            }
            if (s.d(new byte[]{94, 89, Ascii.ETB, 80, 70, 83, 40, 7, 9, 12}, "08c906").equals(mimoAdInfo.p0.trim())) {
                getTemplateIcon();
                return;
            }
            if (s.d(new byte[]{Ascii.SYN, 92, 26, 77, 36, 85, 14, 5, Ascii.DC2, 11, 95, 2, 83}, "b9b9b9").equals(mimoAdInfo.p0.trim())) {
                getTextFloatingAd1(mimoAdInfo);
                return;
            }
            if (s.d(new byte[]{Ascii.DC2, 80, 74, 77, 113, 89, 14, 5, Ascii.DC2, 11, 95, 2, 84}, "f52975").equals(mimoAdInfo.p0.trim())) {
                getTextFloatingAd2(mimoAdInfo);
                return;
            }
            if (s.d(new byte[]{78, 80, 67, 69, 80, 86, 0, 8, 50, 7, 92, Ascii.NAK, 84, 84, 69, 84, 8}, "851195").equals(mimoAdInfo.p0.trim())) {
                getVerticalTemplate1(mimoAdInfo);
                return;
            } else if (s.d(new byte[]{67, 84, 70, 69, 95, 91, 0, 8, 50, 7, 92, Ascii.NAK, 89, 80, SignedBytes.MAX_POWER_OF_TWO, 84, 4}, "514168").equals(mimoAdInfo.p0.trim())) {
                getVerticalTemplate2(mimoAdInfo);
                return;
            } else if (s.d(new byte[]{91, Ascii.ETB, 93, 87, 95, 11, 53, 1, 11, Ascii.DC2, 93, 4, SignedBytes.MAX_POWER_OF_TWO, 0, 5, 111, 65, 4, Ascii.ETB, 1}, "4e406e").equals(mimoAdInfo.p0.trim())) {
                getOriginWave(mimoAdInfo);
                return;
            }
        }
        getTemplateAd5(false);
    }
}
