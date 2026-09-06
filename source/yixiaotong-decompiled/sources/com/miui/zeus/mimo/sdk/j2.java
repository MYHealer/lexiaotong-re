package com.miui.zeus.mimo.sdk;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.common.base.Ascii;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.miui.zeus.mimo.sdk.ad.reward.view.RewardPSkipCountDownView;
import com.miui.zeus.mimo.sdk.bean.MimoAdInfo;
import com.miui.zeus.mimo.sdk.click.ClickAreaType;
import com.miui.zeus.mimo.sdk.click.ClickEventType;
import com.miui.zeus.mimo.sdk.click.CommonActionHandler;
import com.miui.zeus.mimo.sdk.click.MarketDownloadHandler;
import com.miui.zeus.mimo.sdk.download.AutoDownloadController;
import com.miui.zeus.mimo.sdk.track.info.AdEvent;
import com.miui.zeus.mimo.sdk.video.MimoMediaView;
import com.miui.zeus.mimo.sdk.view.IBindDataView;
import com.miui.zeus.mimo.sdk.view.MimoUniversalSlideView;
import com.miui.zeus.mimo.sdk.view.MimoVideoTipsView;
import com.miui.zeus.mimo.sdk.view.component.AdMarkICP;
import com.miui.zeus.mimo.sdk.view.component.DownloadButtonICP;
import com.miui.zeus.mimo.sdk.view.component.RootICP;
import com.miui.zeus.mimo.sdk.view.component.SixElementsView;
import kotlin.io.encoding.Base64;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public abstract class j2 extends RootICP implements IBindDataView, d7, i8, SixElementsView.e, n, CommonActionHandler.b {
    public static final String H = "j2";
    public boolean A;
    public DownloadButtonICP B;
    public boolean C;
    public final Runnable D;
    public Runnable E;
    public final Runnable F;
    public final Runnable G;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ImageView f5482a;
    public MimoMediaView b;
    public SixElementsView c;
    public MimoVideoTipsView d;
    public e2 e;
    public MimoAdInfo f;
    public w3 g;
    public Activity h;
    public RewardPSkipCountDownView i;
    public long j;
    public int k;
    public boolean l;
    public boolean m;
    public h7 n;
    public n7 o;
    public AutoDownloadController p;
    public FrameLayout q;
    public boolean r;
    public long s;
    public g7 t;
    public k8 u;
    public Runnable v;
    public boolean w;
    public long x;
    public boolean y;
    public CommonActionHandler z;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            j2.this.a();
        }
    }

    public class b implements DialogInterface.OnShowListener {
        public b() {
        }

        @Override // android.content.DialogInterface.OnShowListener
        public void onShow(DialogInterface dialogInterface) {
            j2.this.j();
        }
    }

    public class c implements DialogInterface.OnDismissListener {
        public c() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            j2.this.i();
        }
    }

    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            j2.this.a();
        }
    }

    public class e implements CommonActionHandler.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ClickAreaType f5487a;
        public final /* synthetic */ j6 b;
        public final /* synthetic */ l6 c;

        public e(ClickAreaType clickAreaType, j6 j6Var, l6 l6Var) {
            this.f5487a = clickAreaType;
            this.b = j6Var;
            this.c = l6Var;
        }

        @Override // com.miui.zeus.mimo.sdk.click.CommonActionHandler.c
        public void a(boolean z) {
            j2.this.c(5);
            j2 j2Var = j2.this;
            ClickAreaType clickAreaType = this.f5487a;
            j6 j6Var = this.b;
            l6 l6Var = this.c;
            j2Var.getClass();
            AdEvent adEvent = AdEvent.CLICK;
            String strD = ijiami_1011.s.s.s.d(new byte[]{97}, "12a57d");
            if (z) {
                clickAreaType = ClickAreaType.TYPE_CPM_BUTTON;
            }
            j2Var.a(adEvent, k6.a(strD, clickAreaType, j6Var, l6Var));
            w3 w3Var = j2Var.g;
            if (w3Var != null) {
                w3Var.onClicked();
            }
        }
    }

    public class f implements Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            e2 e2Var = j2.this.e;
            if (e2Var != null) {
                e2Var.dismiss();
            }
        }
    }

    public class g implements Runnable {
        public g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            j2.this.w = false;
            j2 j2Var = j2.this;
            if (j2Var.y || j2Var.getInstallGuideToast() == null) {
                return;
            }
            j2.this.c(2);
            j2 j2Var2 = j2.this;
            RewardPSkipCountDownView rewardPSkipCountDownView = j2Var2.i;
            if (rewardPSkipCountDownView == null || j2Var2.f.z0 == 4) {
                return;
            }
            rewardPSkipCountDownView.a();
            j2.this.i.h = true;
        }
    }

    public class h implements Runnable {
        public h() {
        }

        @Override // java.lang.Runnable
        public void run() {
            g7 g7Var = j2.this.t;
            if (g7Var != null) {
                g7Var.dismiss();
            }
            j2 j2Var = j2.this;
            if (j2Var.y) {
                j2Var.b();
            }
        }
    }

    public class i implements View.OnClickListener {
        public i() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            j2 j2Var = j2.this;
            j2Var.setMute(!j2Var.c());
        }
    }

    public class j implements RewardPSkipCountDownView.c {
        public j() {
        }
    }

    public class k implements Runnable {
        public k() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (j2.this.getContext() != null) {
                Toast.makeText(j2.this.getContext(), ijiami_1011.s.s.s.d(new byte[]{-118, -108, -78, -40, -110, -9, -124, -18, -58, -118, -116, -40, -122, -117, -103, Ascii.GS, -40, -55, -42, -125, -50, -17, -44, -11, -20}, "b3410f"), 0).show();
            }
        }
    }

    public class l implements Runnable {

        public class a implements e2.a {
            public a() {
            }

            public void a() {
                MimoMediaView mimoMediaView = j2.this.b;
                if (mimoMediaView != null) {
                    mimoMediaView.c();
                }
            }

            public void b() {
                MimoMediaView mimoMediaView = j2.this.b;
                if (mimoMediaView != null) {
                    mimoMediaView.a();
                }
            }
        }

        public l() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Activity activity;
            j2 j2Var = j2.this;
            e2 e2Var = j2Var.e;
            if (!(e2Var instanceof e3)) {
                if (e2Var == null || (activity = j2Var.h) == null) {
                    return;
                }
                e2Var.a(activity, j2Var.f.s(), j2.this.getGuideTargetView(), null);
                return;
            }
            long j = j2Var.x;
            if ((j <= 5000 && j != 0) || j2Var.y || j2Var.C) {
                return;
            }
            String str = j2.H;
            com.miui.zeus.mimo.sdk.m.e(j2.H, ijiami_1011.s.s.s.d(new byte[]{75, 12, 92, Ascii.DC2, 47, 87, Ascii.DC2, 16, 7, 14, 93, 34, 77, 13, 87, 0, 50, 86, 0, Ascii.ETB, Ascii.DC2, 66, 66, 13, 87, 19, 19, 55, 3, 78, 0, Ascii.SYN, 2, 50, 94, Ascii.NAK, 124, 13, 82, 9, 9, 94}, "8d3ef9"));
            j2 j2Var2 = j2.this;
            j2Var2.e.a(j2Var2.h, j2Var2.f.s(), j2.this, new a());
        }
    }

    public class m implements Runnable {
        public m() {
        }

        @Override // java.lang.Runnable
        public void run() {
            j2.this.h();
        }
    }

    public j2(Context context) {
        this(context, null);
    }

    public j2(Context context, AttributeSet attributeSet) {
        this(context, null, 0);
    }

    public j2(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.r = false;
        this.s = 0L;
        this.w = false;
        this.A = true;
        this.B = null;
        this.C = false;
        this.D = new h();
        this.E = new k();
        this.F = new l();
        this.G = new m();
    }

    public static boolean b(j2 j2Var) {
        MimoAdInfo mimoAdInfo = j2Var.f;
        if (mimoAdInfo != null) {
            return mimoAdInfo.a(j2Var.j, j2Var.x);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public e2 getInstallGuideToast() {
        int i2 = this.f.z0;
        if (i2 == 0) {
            return null;
        }
        if (i2 == 3) {
            return new g2();
        }
        if (i2 != 4) {
            return new f2();
        }
        w3 w3Var = this.g;
        return new e3(getContext(), this.h, this.f, this.g, w3Var != null ? w3Var.getDialogThemeId() : 0);
    }

    public void a() {
        com.miui.zeus.mimo.sdk.m.a(H, ijiami_1011.s.s.s.d(new byte[]{85, 80, 91, 8, 69, 80, 32, 0}, "395a68"));
        h7 h7Var = this.n;
        if (h7Var != null) {
            h7Var.dismiss();
            this.n = null;
        }
        MimoMediaView mimoMediaView = this.b;
        if (mimoMediaView != null) {
            mimoMediaView.b();
            this.b = null;
        }
        w3 w3Var = this.g;
        if (w3Var != null) {
            w3Var.onClickCloseView();
        }
        Activity activity = this.h;
        if (activity != null) {
            activity.finish();
        }
    }

    public void a(int i2) {
    }

    public void a(View view) {
        this.f5482a = (ImageView) view.findViewById(a0.l4);
        this.q = (FrameLayout) view.findViewById(a0.F5);
        MimoMediaView mimoMediaView = (MimoMediaView) view.findViewById(a0.L3);
        this.b = mimoMediaView;
        if (mimoMediaView != null) {
            mimoMediaView.setBackgroundScaleType(ImageView.ScaleType.FIT_CENTER);
            this.b.setViewClickAreaType(ClickAreaType.TYPE_FULL_VIDEO);
        }
        this.i = (RewardPSkipCountDownView) view.findViewById(a0.I0);
        this.c = (SixElementsView) view.findViewById(a0.j);
        this.d = (MimoVideoTipsView) view.findViewById(a0.U1);
        this.f5482a.setOnClickListener(new i());
        RewardPSkipCountDownView rewardPSkipCountDownView = this.i;
        if (rewardPSkipCountDownView != null) {
            rewardPSkipCountDownView.setVisibility(8);
            this.i.setOnItemClickListener(new j());
        }
    }

    public void a(AdEvent adEvent, k6 k6Var) {
        com.miui.zeus.mimo.sdk.b.a(adEvent, this.f, this.mViewEventInfo, k6Var);
    }

    @Override // com.miui.zeus.mimo.sdk.view.component.SixElementsView.e
    public void a(String str) {
        w3 w3Var = this.g;
        if (w3Var != null) {
            w3Var.onJumpWebView(str);
        }
    }

    public boolean a(int i2, long j2) {
        if (this.y) {
            return true;
        }
        MimoAdInfo mimoAdInfo = this.f;
        if (mimoAdInfo.z0 == 4) {
            return i2 != 1;
        }
        if (i2 == 5 || i2 == 3) {
            return true;
        }
        return i2 == 4 && j2 < ((long) mimoAdInfo.C0) * 1000;
    }

    public void b() {
        e2 e2Var = this.e;
        if (e2Var != null) {
            e2Var.dismiss();
            this.e = null;
        }
        n7 n7Var = this.o;
        if (n7Var != null) {
            n7Var.onNeedEndPage();
        }
    }

    public void b(int i2) {
    }

    public void b(String str) {
    }

    public void c(int i2) {
        x8.e(new l2(this, i2, 0L));
    }

    public boolean c() {
        return this.b.e;
    }

    public boolean d() {
        return true;
    }

    public void destroy() {
        CommonActionHandler commonActionHandler = this.z;
        if (commonActionHandler != null) {
            commonActionHandler.a();
        }
        MimoMediaView mimoMediaView = this.b;
        if (mimoMediaView != null) {
            mimoMediaView.b();
            this.b = null;
        }
        AutoDownloadController autoDownloadController = this.p;
        if (autoDownloadController != null) {
            autoDownloadController.c();
            this.p = null;
        }
        e2 e2Var = this.e;
        if (e2Var != null) {
            e2Var.dismiss();
        }
        Runnable runnable = this.F;
        if (runnable != null) {
            y8.b.removeCallbacks(runnable);
        }
        Runnable runnable2 = this.G;
        if (runnable2 != null) {
            y8.b.removeCallbacks(runnable2);
        }
        Runnable runnable3 = this.D;
        if (runnable3 != null) {
            y8.b.removeCallbacks(runnable3);
        }
        removeShakeView();
        Runnable runnable4 = this.E;
        if (runnable4 != null) {
            y8.b.removeCallbacks(runnable4);
            this.E = null;
        }
    }

    public final boolean e() {
        if (this.f.z0 == 4) {
            e2 e2Var = this.e;
            if ((e2Var instanceof e3) && ((e3) e2Var).isShowing()) {
                return true;
            }
        }
        return false;
    }

    public void f() {
    }

    public void g() {
    }

    public j6 getClickViewInfo(View view) {
        return new c6(view, this, getCloseView(), null, getDownloadViews(), this.mViewEventInfo, false, false).f5387a;
    }

    public View getCloseView() {
        RewardPSkipCountDownView rewardPSkipCountDownView = this.i;
        if (rewardPSkipCountDownView == null) {
            return null;
        }
        return rewardPSkipCountDownView.getSkipView();
    }

    public abstract View[] getDownloadViews();

    public abstract View getGuideTargetView();

    public abstract int getLayoutId();

    public MimoMediaView getVideoView() {
        return this.b;
    }

    public FrameLayout getVideoViewContainer() {
        return this.q;
    }

    public void h() {
        e2 e2Var = this.e;
        if (e2Var != null) {
            e2Var.dismiss();
            this.e = null;
        }
    }

    public void i() {
        MimoMediaView mimoMediaView = this.b;
        if (mimoMediaView != null) {
            mimoMediaView.c();
        }
    }

    public void j() {
        MimoMediaView mimoMediaView = this.b;
        if (mimoMediaView != null) {
            mimoMediaView.a();
        }
    }

    public void k() {
        if (com.miui.zeus.mimo.sdk.b.a(this.h)) {
            return;
        }
        com.miui.zeus.mimo.sdk.m.a(H, ijiami_1011.s.s.s.d(new byte[]{70, 88, 9, Ascii.DC4, 99, 10, 17, Ascii.ETB, 34, 11, 80, 9, 90, 87}, "50fc7c"));
        h7 h7Var = this.n;
        if (h7Var == null || !h7Var.isShowing()) {
            w3 w3Var = this.g;
            int dialogThemeId = (w3Var == null || w3Var.getDialogThemeId() == 0) ? a0.c5 : this.g.getDialogThemeId();
            this.n = this.f.E0 == 1 ? new i7(this.h, getContext(), this.g, this.f, dialogThemeId) : new h7(this.h, getContext(), this.f, dialogThemeId);
            h7 h7Var2 = this.n;
            h7Var2.c = this;
            h7Var2.b = new a();
            h7Var2.setOnShowListener(new b());
            this.n.setOnDismissListener(new c());
            this.n.show();
        }
    }

    public final void l() {
        e2 installGuideToast = getInstallGuideToast();
        this.e = installGuideToast;
        if (installGuideToast != null) {
            MimoAdInfo mimoAdInfo = this.f;
            if (mimoAdInfo.C0 > 0 || (mimoAdInfo.t() && !w6.a(y8.f5752a, this.f))) {
                y8.b.postDelayed(this.F, C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS);
                if (this.f.z0 != 4) {
                    y8.b.postDelayed(this.G, 7000L);
                }
            }
        }
    }

    @Override // com.miui.zeus.mimo.sdk.view.IBindDataView
    public boolean onBackPressed() {
        Toast.makeText(getContext(), getResources().getString(a0.Q1), 0).show();
        return false;
    }

    @Override // com.miui.zeus.mimo.sdk.n
    public void onCancelDownload(String str) {
    }

    public void onClick(View view, ClickAreaType clickAreaType) {
        l6 extShakeInfo;
        DownloadButtonICP downloadButtonICP;
        this.C = true;
        ClickEventType clickEventTypeA = this.f.a(clickAreaType);
        if (AdMarkICP.a(view) || ClickAreaType.TYPE_CLOSE == clickAreaType) {
            a(AdEvent.CLOSE, k6.a(ijiami_1011.s.s.s.d(new byte[]{49}, "a99e70"), getClickViewInfo(view), clickAreaType));
            a();
            return;
        }
        e2 e2Var = this.e;
        if (e2Var != null) {
            e2Var.dismiss();
        }
        j6 clickViewInfo = getClickViewInfo(view);
        h7 h7Var = this.n;
        if (h7Var != null && h7Var.isShowing()) {
            this.n.dismiss();
        }
        com.miui.zeus.mimo.sdk.m.a(H, ijiami_1011.s.s.s.d(new byte[]{95, 86, 112, 95, 93, 91, 10, 76, 79, 66, 82, 9, 89, 91, 88, 118, 66, 93, 15, 16, 50, Ascii.ESC, 65, 0, 13}, "083348") + clickEventTypeA + ijiami_1011.s.s.s.d(new byte[]{72, 81, 89, 80, 7, 95, 32, Ascii.SYN, 3, 3, 101, Ascii.FS, Ascii.DC4, 87, 8}, "d259d4") + clickAreaType);
        if (clickEventTypeA == ClickEventType.CLICK_DISABLE) {
            return;
        }
        boolean z = clickAreaType == ClickAreaType.TYPE_FULL_VIDEO || (this.f.x() && clickAreaType == ClickAreaType.TYPE_PICTURE);
        if (this.f.H0 > 0 && z) {
            if (clickEventTypeA == ClickEventType.CLICK_AUTO_DOWNLOAD || this.z.b()) {
                return;
            }
            if (clickEventTypeA == ClickEventType.CLICK_NO_AUTO_DOWNLOAD) {
                MimoMediaView mimoMediaView = this.b;
                if (mimoMediaView != null) {
                    mimoMediaView.a();
                }
                e2 e2Var2 = this.e;
                if (e2Var2 != null) {
                    e2Var2.dismiss();
                }
                g();
                this.d.a(this.f, this, this, this.g, new k2(this));
                this.d.c();
                y8.b.removeCallbacks(this.F);
                y8.b.post(this.G);
                return;
            }
        }
        k8 k8Var = this.u;
        if (k8Var != null) {
            extShakeInfo = k8Var.getExtShakeInfo();
            removeShakeView();
        } else {
            extShakeInfo = null;
        }
        if (!this.f.B1.booleanValue() || (downloadButtonICP = this.B) == null || clickAreaType != downloadButtonICP.getClickAreaType() || this.B.a()) {
            CommonActionHandler commonActionHandler = this.z;
            if (commonActionHandler != null) {
                commonActionHandler.b = new e(clickAreaType, clickViewInfo, extShakeInfo);
                commonActionHandler.c = this;
                commonActionHandler.a(this.f, clickAreaType);
                return;
            }
            return;
        }
        a(AdEvent.CLICK, k6.a(ijiami_1011.s.s.s.d(new byte[]{104}, "884084"), clickAreaType, clickViewInfo, null));
        w3 w3Var = this.g;
        if (w3Var != null) {
            w3Var.onClicked();
        }
        a(AdEvent.CLOSE, k6.a(ijiami_1011.s.s.s.d(new byte[]{51}, "cdf567"), getClickViewInfo(view), ClickAreaType.TYPE_FRAUD_CLOSE));
        a();
    }

    @Override // com.miui.zeus.mimo.sdk.d7
    public void onCreateViewSuccess(com.miui.zeus.mimo.sdk.i iVar) {
    }

    @Override // com.miui.zeus.mimo.sdk.n
    public void onDownloadFailed(String str, int i2) {
    }

    @Override // com.miui.zeus.mimo.sdk.n
    public void onDownloadFinished(String str) {
        c(3);
    }

    @Override // com.miui.zeus.mimo.sdk.n
    public void onDownloadPaused(String str) {
    }

    @Override // com.miui.zeus.mimo.sdk.n
    public void onDownloadProgressUpdated(String str, int i2) {
    }

    @Override // com.miui.zeus.mimo.sdk.n
    public void onDownloadStarted(String str) {
        x8.e(new f());
    }

    @Override // com.miui.zeus.mimo.sdk.n
    public void onExistDownload(String str) {
    }

    @Override // com.miui.zeus.mimo.sdk.n
    public void onInstallFailed(String str, int i2) {
    }

    @Override // com.miui.zeus.mimo.sdk.n
    public void onInstallStart(String str) {
    }

    @Override // com.miui.zeus.mimo.sdk.n
    public void onInstallSuccess(String str) {
        x8.e(new g());
    }

    @Override // com.miui.zeus.mimo.sdk.d7
    public void onPicEnd() {
        com.miui.zeus.mimo.sdk.m.a(H, ijiami_1011.s.s.s.d(new byte[]{89, 93, 49, 95, 84, 36, 15, 0, 78, 75}, "63a67a"));
        this.l = false;
        this.m = true;
        w3 w3Var = this.g;
        if (w3Var != null) {
            w3Var.onPicAdEnd();
        }
        c(1);
        MimoMediaView mimoMediaView = this.b;
        if (mimoMediaView != null) {
            mimoMediaView.b();
            this.b = null;
        }
        b();
    }

    @Override // com.miui.zeus.mimo.sdk.d7
    public void onPicMode() {
        com.miui.zeus.mimo.sdk.m.a(H, ijiami_1011.s.s.s.d(new byte[]{86, 8, 102, 11, 87, 121, 14, 0, 3, 74, Ascii.CAN}, "9f6b44"));
        this.k = 2;
        this.l = false;
        this.m = false;
        ImageView imageView = this.f5482a;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
    }

    @Override // com.miui.zeus.mimo.sdk.d7
    public void onVideoEnd() {
        com.miui.zeus.mimo.sdk.m.a(H, ijiami_1011.s.s.s.d(new byte[]{86, 94, 102, 11, 6, 3, 14, 33, 8, 6, Ascii.EM, 76}, "900bbf"));
        this.l = true;
        this.m = false;
        MimoMediaView mimoMediaView = this.b;
        if (mimoMediaView != null) {
            mimoMediaView.setProgress(100);
        }
        w3 w3Var = this.g;
        if (w3Var != null) {
            w3Var.onVideoComplete();
        }
        c(1);
        MimoMediaView mimoMediaView2 = this.b;
        if (mimoMediaView2 != null) {
            mimoMediaView2.b();
            this.b = null;
        }
        b();
    }

    @Override // com.miui.zeus.mimo.sdk.d7
    public void onVideoError() {
        com.miui.zeus.mimo.sdk.m.b(H, ijiami_1011.s.s.s.d(new byte[]{14, 8, 98, 88, 7, 81, 14, 33, Ascii.DC4, 16, 94, Ascii.ETB, 73, 79}, "af41c4"));
        x8.e(new d());
    }

    @Override // com.miui.zeus.mimo.sdk.d7
    public void onVideoPause() {
        w3 w3Var = this.g;
        if (w3Var != null) {
            w3Var.onVideoPause();
        }
    }

    @Override // com.miui.zeus.mimo.sdk.d7
    public void onVideoResume() {
        w3 w3Var = this.g;
        if (w3Var != null) {
            w3Var.onVideoResume();
        }
    }

    @Override // com.miui.zeus.mimo.sdk.d7
    public void onVideoStart() {
        MimoMediaView mimoMediaView;
        com.miui.zeus.mimo.sdk.m.a(H, ijiami_1011.s.s.s.d(new byte[]{93, 10, 51, 81, 5, 83, 14, 55, Ascii.DC2, 3, 67, 17, 26, 77}, "2de8a6"));
        this.k = 1;
        this.l = false;
        this.m = false;
        w3 w3Var = this.g;
        if (w3Var != null) {
            w3Var.onVideoStart();
        }
        if (!e() || (mimoMediaView = this.b) == null) {
            return;
        }
        mimoMediaView.a();
        a(0, this.b.getDuration());
    }

    @Override // com.miui.zeus.mimo.sdk.d7
    public void onVolumeChanged(boolean z) {
        ImageView imageView = this.f5482a;
        if (imageView != null) {
            imageView.setSelected(!z);
        }
    }

    public void pause() {
        MimoMediaView mimoMediaView = this.b;
        if (mimoMediaView != null) {
            mimoMediaView.a();
        }
        removeShakeView();
        Runnable runnable = this.v;
        if (runnable != null) {
            y8.b.removeCallbacks(runnable);
        }
    }

    public final void removeShakeView() {
        k8 k8Var = this.u;
        if (k8Var != null) {
            k8Var.a();
            removeView(this.u);
            this.u = null;
        }
    }

    public void resume() {
        RewardPSkipCountDownView rewardPSkipCountDownView;
        g7 g7Var;
        if (getVisibility() == 0) {
            if (this.b != null) {
                h7 h7Var = this.n;
                boolean z = h7Var != null && h7Var.isShowing();
                MimoVideoTipsView mimoVideoTipsView = this.d;
                boolean z2 = mimoVideoTipsView != null && mimoVideoTipsView.getVisibility() == 0;
                if (!z && !z2 && !e()) {
                    this.b.c();
                }
            }
            k8 k8Var = this.u;
            if (k8Var != null) {
                k8Var.c();
            }
            if (this.s <= 0) {
                if (this.y) {
                    return;
                }
                b(this.f.k());
                return;
            }
            if (this.w || this.y || !this.r || this.f == null) {
                return;
            }
            long jElapsedRealtime = SystemClock.elapsedRealtime() - this.s;
            this.s = 0L;
            this.r = false;
            g7 g7Var2 = this.t;
            if (g7Var2 != null) {
                g7Var2.dismiss();
            }
            w3 w3Var = this.g;
            int dialogThemeId = (w3Var == null || w3Var.getDialogThemeId() == 0) ? a0.c5 : this.g.getDialogThemeId();
            if (!this.f.A()) {
                g7 g7Var3 = new g7(this.h, getContext(), dialogThemeId);
                this.t = g7Var3;
                g7Var3.setOnShowListener(new m2(this));
                this.t.setOnDismissListener(new n2(this));
            }
            x8.e(new l2(this, 4, jElapsedRealtime));
            if (!this.y) {
                b(4);
            }
            if (!this.f.A() && (g7Var = this.t) != null) {
                g7Var.f5441a = this.y;
                g7Var.show();
            }
            if (this.y && (rewardPSkipCountDownView = this.i) != null) {
                rewardPSkipCountDownView.a();
                this.i.h = true;
            }
            y8.b.postDelayed(this.D, ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
            String strD = this.y ? ijiami_1011.s.s.s.d(new byte[]{15, Ascii.SYN, 93, 19, 104, 9, Ascii.DC4, 16, 57, 17, 68, 6, 6, 6, 67, 16}, "ec0c7f") : ijiami_1011.s.s.s.d(new byte[]{89, 68, 93, 70, Base64.padSymbol, 92, Ascii.DC4, 16, 57, 4, 80, 12, 95}, "3106b3");
            MimoAdInfo mimoAdInfo = this.f;
            String str = mimoAdInfo != null ? mimoAdInfo.u : null;
            String strValueOf = mimoAdInfo != null ? String.valueOf(mimoAdInfo.d) : null;
            MimoAdInfo mimoAdInfo2 = this.f;
            com.miui.zeus.mimo.sdk.b.a(str, strValueOf, mimoAdInfo2 != null ? mimoAdInfo2.e0 : null, ijiami_1011.s.s.s.d(new byte[]{40, 102, 46, 96, 62, 123, 52, 48}, "b3c0a4"), strD, null, System.currentTimeMillis() - jElapsedRealtime, null, null);
        }
    }

    public void setAdInfo(Activity activity, MimoAdInfo mimoAdInfo, w3 w3Var) {
        RewardPSkipCountDownView rewardPSkipCountDownView;
        Context context;
        float f2;
        MimoAdInfo mimoAdInfo2;
        this.f = mimoAdInfo;
        this.g = w3Var;
        a(LayoutInflater.from(getContext()).inflate(getLayoutId(), (ViewGroup) this, true));
        if (d()) {
            setCLickAreaListener(this);
        }
        this.h = activity;
        CommonActionHandler commonActionHandler = new CommonActionHandler(getContext(), activity, w3Var);
        this.z = commonActionHandler;
        u3 u3Var = commonActionHandler.d;
        if (u3Var instanceof MarketDownloadHandler) {
            ((MarketDownloadHandler) u3Var).e = this;
        }
        MimoMediaView mimoMediaView = this.b;
        if (mimoMediaView != null) {
            mimoMediaView.setOnVideoAdListener(this);
            this.b.setProgress(0);
            this.b.setMute(w3Var.isMuted());
            this.b.a(this.h.getResources().getConfiguration().orientation);
            this.b.a(this.f, this.g, this);
        }
        this.c.setTextColor(Color.parseColor(ijiami_1011.s.s.s.d(new byte[]{Ascii.ETB, 8, 92, 36, 34, 115, 39, 34, 32}, "41ebd5")));
        SixElementsView sixElementsView = this.c;
        MimoAdInfo mimoAdInfo3 = this.f;
        String str = mimoAdInfo3.i;
        String str2 = mimoAdInfo3.k;
        String strE = mimoAdInfo3.e();
        MimoAdInfo mimoAdInfo4 = this.f;
        sixElementsView.a(str, str2, strE, mimoAdInfo4.m, mimoAdInfo4.l, mimoAdInfo4.n, false);
        this.c.setVisibility(this.f.D() ? 0 : 4);
        this.c.setOnItemClickListener(this);
        AutoDownloadController autoDownloadController = new AutoDownloadController(getContext());
        this.p = autoDownloadController;
        autoDownloadController.b();
        l();
        MimoAdInfo mimoAdInfo5 = this.f;
        if (mimoAdInfo5.a1) {
            ClickAreaType clickAreaType = ClickAreaType.TYPE_NATIVE_SHAKE;
            ClickEventType clickEventTypeA = mimoAdInfo5.a(clickAreaType);
            ClickEventType clickEventType = ClickEventType.CLICK_DISABLE;
            if (clickEventTypeA != clickEventType && (mimoAdInfo2 = this.f) != null && mimoAdInfo2.a1 && mimoAdInfo2.a(clickAreaType) != clickEventType) {
                removeShakeView();
                this.u = new k8(getContext(), null, 0);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 17;
                addView(this.u, layoutParams);
                this.u.a(this.f, this);
                this.u.c();
            }
        }
        if ((a(this.f) || this.f.v()) && (rewardPSkipCountDownView = this.i) != null) {
            rewardPSkipCountDownView.setVisibility(0);
        }
        if (a(this.f)) {
            this.f5482a.setVisibility(8);
        }
        if (this.b != null && this.f.E()) {
            if (!this.A) {
                return;
            } else {
                y8.b.postDelayed(this.E, C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS);
            }
        }
        String str3 = mimoAdInfo.K0;
        if (com.miui.zeus.mimo.sdk.b.a(str3, ijiami_1011.s.s.s.d(new byte[]{6, Ascii.ETB, 13, Ascii.DC2, Ascii.DC2, 12, 15, 3}, "bebbbe"))) {
            Runnable runnable = this.v;
            if (runnable != null) {
                y8.b.removeCallbacks(runnable);
            }
            o2 o2Var = new o2(this, mimoAdInfo);
            this.v = o2Var;
            y8.b.postDelayed(o2Var, mimoAdInfo.n());
        } else if (com.miui.zeus.mimo.sdk.b.a(str3, ijiami_1011.s.s.s.d(new byte[]{6, 65, 91, 86, 85, 82}, "d49497"))) {
            u7 u7Var = new u7(getContext(), getContext().getResources().getConfiguration().orientation);
            int iIndexOfChild = ((ViewGroup) this.d.getParent()).indexOfChild(this.d);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
            if (activity.getResources().getConfiguration().orientation == 1) {
                layoutParams2.topMargin = f9.a(getContext(), mimoAdInfo.B() ? 90.0f : 32.0f);
                layoutParams2.bottomMargin = f9.a(getContext(), 52.0f);
            }
            ((ViewGroup) this.d.getParent()).addView(u7Var, iIndexOfChild, layoutParams2);
            u7Var.a(mimoAdInfo.L0, this);
        }
        MimoAdInfo mimoAdInfo6 = this.f;
        if (mimoAdInfo6 != null && mimoAdInfo6.a(ClickAreaType.TYPE_UNIVERSAL_SLIDE) != ClickEventType.CLICK_DISABLE) {
            MimoUniversalSlideView mimoUniversalSlideView = new MimoUniversalSlideView(getContext(), null, 0);
            mimoUniversalSlideView.a(mimoAdInfo, this);
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
            if (this.f.A()) {
                layoutParams3.gravity = 17;
            } else {
                layoutParams3.gravity = 81;
                if (activity.getResources().getConfiguration().orientation == 1) {
                    context = getContext();
                    f2 = 260.0f;
                } else {
                    context = getContext();
                    f2 = 121.0f;
                }
                layoutParams3.bottomMargin = f9.a(context, f2);
            }
            addView(mimoUniversalSlideView, layoutParams3);
        }
        for (View view : getDownloadViews()) {
            if (view instanceof DownloadButtonICP) {
                this.B = (DownloadButtonICP) view;
            }
        }
    }

    public void setMute(boolean z) {
        MimoMediaView mimoMediaView = this.b;
        if (mimoMediaView != null) {
            mimoMediaView.setMute(z);
        }
    }

    public void setOnNeedEndPageListener(n7 n7Var) {
        this.o = n7Var;
    }

    public void onVideoProgressUpdate(int i2, int i3) {
        this.j = i2;
        this.x = i3;
        if (i3 > 30000 && i2 >= 30000) {
            c(1);
        }
        a(i2, i3);
        MimoMediaView mimoMediaView = this.b;
        if (mimoMediaView != null) {
            mimoMediaView.setProgressViewVisibility(0);
            this.b.setProgress((i2 * 100) / i3);
        }
        Runnable runnable = this.E;
        if (runnable != null) {
            y8.b.removeCallbacks(runnable);
            this.E = null;
        }
    }

    public final boolean a(MimoAdInfo mimoAdInfo) {
        return mimoAdInfo.p0.trim().startsWith(ijiami_1011.s.s.s.d(new byte[]{94, 11, 5, 84, 93, Ascii.SYN, 8, Ascii.DC2, 3, 43, 92, 2, 97, 0, Ascii.DC4, 110, 99, 83}, "7ef13b")) || mimoAdInfo.p0.trim().startsWith(ijiami_1011.s.s.s.d(new byte[]{81, 86, 87, 0, 90, Ascii.SYN, 8, Ascii.DC2, 3, 43, 92, 2, 112, 87, 70, 58, 100, 83}, "884e4b"));
    }

    public final void a(int i2, int i3) {
        String strValueOf = String.valueOf(Math.round(Math.round(((double) Math.max(i3 - i2, 0)) / 1000.0d)));
        if (this.i != null) {
            MimoAdInfo mimoAdInfo = this.f;
            if (mimoAdInfo != null && mimoAdInfo.a(this.j, this.x)) {
                RewardPSkipCountDownView rewardPSkipCountDownView = this.i;
                rewardPSkipCountDownView.d.setVisibility(0);
                rewardPSkipCountDownView.g.setVisibility(0);
            } else {
                RewardPSkipCountDownView rewardPSkipCountDownView2 = this.i;
                rewardPSkipCountDownView2.d.setVisibility(8);
                rewardPSkipCountDownView2.g.setVisibility(8);
            }
            if (i3 <= 30000) {
                this.i.a(strValueOf);
            } else if (this.y) {
                this.i.a();
                this.i.h = true;
            } else {
                this.i.a(String.valueOf((KSImageLoader.InnerImageLoadingListener.MAX_DURATION - i2) / 1000));
            }
            this.i.setVisibility(0);
        }
    }
}
