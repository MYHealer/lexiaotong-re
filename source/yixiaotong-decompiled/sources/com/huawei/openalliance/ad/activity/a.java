package com.huawei.openalliance.ad.activity;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.graphics.Point;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.google.android.exoplayer2.C;
import com.huawei.hms.ads.cp;
import com.huawei.hms.ads.fh;
import com.huawei.openalliance.ad.constant.bf;
import com.huawei.openalliance.ad.constant.bq;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.msgnotify.NotifyCallback;
import com.huawei.openalliance.ad.utils.bg;
import com.huawei.openalliance.ad.utils.bj;
import com.huawei.openalliance.ad.utils.q;
import com.huawei.openalliance.ad.utils.z;
import com.huawei.openalliance.ad.views.PPSBaseDialogContentView;
import com.huawei.openalliance.ad.views.i;
import com.stub.StubApp;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import org.videolan.libvlc.MediaDiscoverer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class a extends d implements NotifyCallback {
    protected static final int B = 16;
    public static final String Code = "huawei.permission.CLICK_STATUSBAR_BROADCAST";
    public static final String I = "com.huawei.ads.feedback.action.FINISH_FEEDBACK_ACTIVITY";
    public static final String V = "com.huawei.ads.feedback.action.ANCHOR_LOCATION_CHANGE";
    protected static final int Z = 36;
    private static final String m = "BaseDialogActivity";
    private static final int n = 40;
    private static final String o = "android.permission.WRITE_SECURE_SETTINGS";
    private static final String p = "com.huawei.intent.action.CLICK_STATUSBAR";
    private static Context r;
    protected int C;
    protected int D;
    protected int F;
    protected int[] L;
    protected int S;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected int[] f4431a;
    protected AdContentData b;
    protected PPSBaseDialogContentView c;
    protected PPSBaseDialogContentView d;
    protected PPSBaseDialogContentView e;
    protected ImageView f;
    protected ImageView g;
    protected ImageView h;
    protected RelativeLayout i;
    protected View j;
    protected View k;
    protected c l;
    private boolean q = false;

    /* JADX INFO: renamed from: com.huawei.openalliance.ad.activity.a$a, reason: collision with other inner class name */
    public static class ViewTreeObserverOnGlobalLayoutListenerC0530a implements ViewTreeObserver.OnGlobalLayoutListener {
        private final WeakReference<Context> Code;
        private final int[] I;
        private final WeakReference<View> V;

        public ViewTreeObserverOnGlobalLayoutListenerC0530a(View view, Context context, int[] iArr) {
            this.Code = new WeakReference<>(context);
            this.V = new WeakReference<>(view);
            this.I = iArr == null ? null : Arrays.copyOf(iArr, iArr.length);
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            try {
                View view = this.V.get();
                Context context = this.Code.get();
                if (view != null && context != null && this.I != null) {
                    int[] iArr = new int[2];
                    view.getLocationOnScreen(iArr);
                    int i = iArr[0];
                    if (i == 0 && iArr[1] == 0) {
                        fh.V(a.m, "anchorView onGlobalLayout newLoc[x,y] =0,0");
                        view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                        return;
                    }
                    int[] iArr2 = this.I;
                    if ((iArr2[0] == i && iArr2[1] == iArr[1]) || a.V(iArr2, iArr)) {
                        return;
                    }
                    view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    fh.V(a.m, "anchorView location change newLoc[x,y] = " + iArr[0] + "," + iArr[1] + "--oldLoc[x,y] = " + this.I[0] + "," + this.I[1]);
                    com.huawei.openalliance.ad.msgnotify.b.Code(context, bq.B, new Intent(a.V));
                }
            } catch (Throwable th) {
                fh.I(a.m, "onGlobalLayout error:" + th.getClass().getSimpleName());
            }
        }
    }

    private static class b implements i {
        WeakReference<a> Code;

        public b(a aVar) {
            this.Code = new WeakReference<>(aVar);
        }

        @Override // com.huawei.openalliance.ad.views.i
        public void Code(int i) {
            a aVar = this.Code.get();
            if (aVar == null || aVar.q) {
                return;
            }
            fh.V(a.m, "got safePadding: %s", Integer.valueOf(i));
            aVar.Code(i);
        }
    }

    private class c extends BroadcastReceiver {
        private c() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null) {
                fh.V(a.m, "intent is empty");
                return;
            }
            String action = intent.getAction();
            fh.V(a.m, "FeedbackEventReceiver action = %s", action);
            if ("android.intent.action.CLOSE_SYSTEM_DIALOGS".equals(action) || a.p.equals(action)) {
                a.this.finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(int i) {
        PPSBaseDialogContentView pPSBaseDialogContentView = this.e;
        if (pPSBaseDialogContentView != null) {
            pPSBaseDialogContentView.Code(i);
        }
        if (this.h != null) {
            this.C += i;
            d();
        }
        this.q = true;
    }

    private boolean Code(int[] iArr) {
        return iArr == null || iArr.length != 2;
    }

    private void D() {
        int i;
        if (Code(this.L) || Code(this.f4431a)) {
            fh.I(m, "mAnchorViewLoc or mAnchorViewSize is unavailable");
            return;
        }
        if (this.L[1] + (this.f4431a[1] >> 1) > (this.F >> 1)) {
            this.d.setVisibility(8);
            this.f.setVisibility(0);
            this.g.setVisibility(8);
            this.e = this.c;
            this.h = this.f;
            int iG = z.g(this);
            if (cp.Code(this).Code(this)) {
                iG = Math.max(iG, cp.Code(this).Code(this.i));
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.e.getLayoutParams();
            layoutParams.setMargins(0, iG, 0, 0);
            this.e.setLayoutParams(layoutParams);
            return;
        }
        this.c.setVisibility(8);
        this.f.setVisibility(8);
        this.g.setVisibility(0);
        this.e = this.d;
        this.h = this.g;
        boolean zB = q.B(this);
        boolean z = q.C(this) && (1 == (i = this.D) || 9 == i);
        boolean z2 = q.S(this) && q.F(this);
        if (zB || z || z2) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.e.getLayoutParams();
            layoutParams2.setMargins(0, 0, 0, Math.max(z.V(this, 40.0f), bg.S(this)));
            this.e.setLayoutParams(layoutParams2);
        }
    }

    private void L() {
        if (Build.VERSION.SDK_INT >= 29) {
            this.i.setForceDarkAllowed(false);
        }
    }

    private void S() {
        int iHeight;
        if (Build.VERSION.SDK_INT >= 30) {
            this.S = getWindowManager().getCurrentWindowMetrics().getBounds().width();
            iHeight = getWindowManager().getCurrentWindowMetrics().getBounds().height();
        } else {
            Point point = new Point();
            getWindowManager().getDefaultDisplay().getSize(point);
            this.S = point.x;
            iHeight = point.y;
        }
        this.F = iHeight;
        fh.Code(m, "initDevicesInfo screenWidth: %s, screenHeight: %s", Integer.valueOf(this.S), Integer.valueOf(this.F));
        this.D = bg.c(this);
        this.C = z.V(this, 22.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean V(int[] iArr, int[] iArr2) {
        int iMax = Math.max(z.g(r), bg.S(r));
        return Math.abs(iArr[0] - iArr2[0]) <= iMax && Math.abs(iArr[1] - iArr2[1]) <= iMax;
    }

    private void a() {
        try {
            this.l = new c();
            z.Code(this, this.l, new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS"), o, null);
            IntentFilter intentFilter = new IntentFilter(p);
            if (getBaseContext() != null) {
                z.Code(this, this.l, intentFilter, Code, null);
            }
            com.huawei.openalliance.ad.msgnotify.b.V(this, bq.B, this);
        } catch (Throwable th) {
            fh.I(m, "registerReceiver error: %s", th.getClass().getSimpleName());
        }
    }

    private void b() {
        try {
            c cVar = this.l;
            if (cVar != null) {
                unregisterReceiver(cVar);
            }
            com.huawei.openalliance.ad.msgnotify.b.V(this, bq.B);
        } catch (Throwable th) {
            fh.I(m, "unRegisterFeedbackReceiver: %s", th.getClass().getSimpleName());
        }
    }

    private void c() {
        if (Code(this.L) || Code(this.f4431a)) {
            fh.I(m, "mAnchorViewLoc or mAnchorViewSize is unavailable");
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.j.getLayoutParams();
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            layoutParams2.width = this.L[0];
            layoutParams2.height = this.L[1];
            this.j.setLayoutParams(layoutParams2);
        }
        ViewGroup.LayoutParams layoutParams3 = this.k.getLayoutParams();
        if (layoutParams3 instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) layoutParams3;
            layoutParams4.width = this.f4431a[0];
            layoutParams4.height = this.f4431a[1];
            this.k.setLayoutParams(layoutParams4);
        }
    }

    private void d() {
        ImageView imageView;
        float f;
        if (Code(this.L) || Code(this.f4431a)) {
            fh.I(m, "mAnchorViewLoc or mAnchorViewSize is unavailable");
            return;
        }
        int iV = z.V(this, 36.0f);
        int i = this.C;
        int i2 = (this.S - i) - iV;
        int i3 = (this.L[0] + (this.f4431a[0] >> 1)) - (iV >> 1);
        if (i3 >= i) {
            i = i3;
        }
        if (i <= i2) {
            i2 = i;
        }
        if (bg.I()) {
            imageView = this.h;
            f = -i2;
        } else {
            imageView = this.h;
            f = i2;
        }
        imageView.setX(f);
    }

    private void e() {
        Window window = getWindow();
        window.getDecorView().setSystemUiVisibility(MediaDiscoverer.Event.Started);
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(0);
    }

    protected boolean B() {
        try {
            this.L = getIntent().getIntArrayExtra(bf.av);
            this.f4431a = getIntent().getIntArrayExtra(bf.ay);
            if (!Code(this.L) && !Code(this.f4431a)) {
                if (bg.I()) {
                    int[] iArr = this.L;
                    int i = (this.S - iArr[0]) - this.f4431a[0];
                    iArr[0] = i;
                    fh.V(m, "rtl mAnchorViewLoc[x,y]= %d, %d", Integer.valueOf(i), Integer.valueOf(this.L[1]));
                }
                if (bg.Code((Activity) this)) {
                    int iE = bg.e(this);
                    int[] iArr2 = this.L;
                    iArr2[1] = iArr2[1] - iE;
                    fh.Code(m, "windowing mode is freeform");
                    fh.Code(m, "initDevicesInfo dragBarHeight: %s", Integer.valueOf(iE));
                }
                return true;
            }
            fh.I(m, "mAnchorViewLoc or mAnchorViewSize is unavailable");
            return false;
        } catch (Throwable th) {
            fh.I(m, "getIntentExtra error: %s", th.getClass().getSimpleName());
            return false;
        }
    }

    protected void C() {
        int viewWith;
        int viewWith2;
        fh.V(m, "getRealOrientation orientation %s", Integer.valueOf(this.D));
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.e.getLayoutParams();
        int iAbs = Math.abs((int) this.h.getX());
        int iV = z.V(this, 36.0f);
        int i = (iV >> 1) + iAbs;
        double d = ((double) iV) * 0.5d;
        int viewWidthPercent = (int) ((((double) (this.S * (1.0f - this.e.getViewWidthPercent()))) * 0.5d) + ((double) z.V(this, 16.0f)) + d);
        int viewWidthPercent2 = (int) (((((double) this.S) * ((((double) this.e.getViewWidthPercent()) * 0.5d) + 0.5d)) - ((double) z.V(this, 16.0f))) - d);
        fh.Code(m, "locationX: %s, locationX2: %s", Integer.valueOf(viewWidthPercent), Integer.valueOf(viewWidthPercent2));
        fh.Code(m, "curImgX: %s, curImgWidth: %s, curImgCenter: %s", Integer.valueOf(iAbs), Integer.valueOf(iV), Integer.valueOf(i));
        int i2 = this.D;
        if (1 != i2 && 9 != i2) {
            layoutParams.removeRule(14);
            this.e.setLayoutParams(layoutParams);
            int i3 = this.S;
            if (i >= i3 / 3) {
                if (i < (i3 * 2) / 3) {
                    viewWith2 = i - (this.e.getViewWith() >> 1);
                } else {
                    iAbs = iAbs + iV + z.V(this, 16.0f);
                    viewWith = this.e.getViewWith();
                }
                this.e.setPaddingStart(viewWith2);
                bg.Code(this, new b(this));
            }
            viewWith = z.V(this, 16.0f);
        } else {
            if (i >= viewWidthPercent) {
                if (i > viewWidthPercent2) {
                    fh.Code(m, "curImgCenter > locationX2");
                    layoutParams.removeRule(14);
                    this.e.setLayoutParams(layoutParams);
                    iAbs = iAbs + iV + z.V(this, 16.0f);
                    viewWith = this.e.getViewWith();
                } else {
                    fh.Code(m, "locationX =< curImgCenter =< locationX2");
                    layoutParams.addRule(14);
                    this.e.setLayoutParams(layoutParams);
                }
                bg.Code(this, new b(this));
            }
            fh.Code(m, "curImgCenter < locationX");
            layoutParams.removeRule(14);
            this.e.setLayoutParams(layoutParams);
            viewWith = z.V(this, 16.0f);
        }
        viewWith2 = iAbs - viewWith;
        this.e.setPaddingStart(viewWith2);
        bg.Code(this, new b(this));
    }

    protected void Code() {
    }

    protected void I() {
    }

    protected int V() {
        return 0;
    }

    protected void Z() {
    }

    @Override // com.huawei.openalliance.ad.activity.d, android.app.Activity
    public void finish() {
        super.finish();
        overridePendingTransition(0, 0);
        fh.V(m, "finish");
        RelativeLayout relativeLayout = this.i;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(4);
        }
    }

    @Override // com.huawei.openalliance.ad.activity.d, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        finish();
    }

    @Override // com.huawei.openalliance.ad.activity.d, android.app.Activity
    protected void onCreate(Bundle bundle) {
        try {
            super.onCreate(bundle);
            requestWindowFeature(1);
            setContentView(V());
            r = StubApp.getOrigApplicationContext(getApplicationContext());
            S();
            if (!B()) {
                fh.I(m, "getIntentExtra return false");
                Z();
                finish();
                return;
            }
            e();
            getWindow().addFlags(C.BUFFER_FLAG_FIRST_SAMPLE);
            Code();
            L();
            a();
            D();
            c();
            d();
            I();
        } catch (Throwable th) {
            fh.I(m, "onCreate ex: %s", th.getClass().getSimpleName());
        }
    }

    @Override // com.huawei.openalliance.ad.activity.d, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        b();
    }

    @Override // com.huawei.openalliance.ad.msgnotify.NotifyCallback
    public void onMessageNotify(String str, Intent intent) {
        if (TextUtils.isEmpty(str) || intent == null) {
            fh.V(m, "msgName or msgData is empty!");
            return;
        }
        fh.Code(m, "onMessageNotify msgName:%s", str);
        try {
            String action = intent.getAction();
            fh.V(m, "FeedbackEventReceiver action = %s", action);
            if (V.equals(action) || I.equals(action)) {
                bj.Code(new Runnable() { // from class: com.huawei.openalliance.ad.activity.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        fh.V(a.m, "anchor point changed, do finish.");
                        a.this.finish();
                    }
                });
            }
        } catch (Throwable th) {
            fh.I(m, "error: " + th.getClass().getSimpleName());
        }
    }
}
