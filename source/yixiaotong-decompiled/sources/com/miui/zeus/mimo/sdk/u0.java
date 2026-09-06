package com.miui.zeus.mimo.sdk;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.miui.zeus.mimo.sdk.bean.MimoAdInfo;
import com.miui.zeus.mimo.sdk.click.ClickAreaType;
import com.miui.zeus.mimo.sdk.click.ClickEventType;
import com.miui.zeus.mimo.sdk.click.CommonActionHandler;
import com.miui.zeus.mimo.sdk.track.info.AdEvent;
import com.miui.zeus.mimo.sdk.view.IBindDataView;
import com.miui.zeus.mimo.sdk.view.component.AdMarkICP;
import com.miui.zeus.mimo.sdk.view.component.DownloadButtonICP;
import com.miui.zeus.mimo.sdk.view.component.ImageICP;
import com.miui.zeus.mimo.sdk.view.component.RootICP;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class u0 extends RootICP implements IBindDataView, i8 {
    public static final /* synthetic */ int i = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public j0 f5620a;
    public i0 b;
    public MimoAdInfo c;
    public CommonActionHandler d;
    public w3 e;
    public RelativeLayout f;
    public final Runnable g;
    public DownloadButtonICP h;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            u0 u0Var = u0.this;
            MimoAdInfo mimoAdInfo = u0Var.c;
            if (mimoAdInfo != null) {
                o7 o7Var = new o7(u0Var.getContext(), null);
                o7Var.setDuration(mimoAdInfo.J0 * 1000);
                o7Var.setImages(mimoAdInfo.L0);
                o7Var.setRedPacketItemClickListener(new v0(u0Var, o7Var));
                o7Var.a();
                u0Var.addView(o7Var);
            }
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ j0 f5622a;

        public b(j0 j0Var) {
            this.f5622a = j0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f5622a.setOutlineProvider(new t6(f9.a(u0.this.getContext(), 6.54f), 1));
            this.f5622a.setClipToOutline(true);
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i0 f5623a;

        public c(i0 i0Var) {
            this.f5623a = i0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f5623a.setOutlineProvider(new t6(f9.a(u0.this.getContext(), 6.54f), 2));
            this.f5623a.setClipToOutline(true);
        }
    }

    public class d implements CommonActionHandler.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f5624a;
        public final /* synthetic */ ClickAreaType b;

        public d(View view, ClickAreaType clickAreaType) {
            this.f5624a = view;
            this.b = clickAreaType;
        }

        @Override // com.miui.zeus.mimo.sdk.click.CommonActionHandler.c
        public void a(boolean z) {
            w3 w3Var;
            u0 u0Var = u0.this;
            View view = this.f5624a;
            ClickAreaType clickAreaType = this.b;
            int i = u0.i;
            u0Var.notifyViewClicked(view, clickAreaType, z);
            if ((this.b == ClickAreaType.TYPE_BUTTON && u0.this.c.S) || u0.this.c.E() || (w3Var = u0.this.e) == null) {
                return;
            }
            w3Var.onClickCloseView();
        }
    }

    public u0(Context context) {
        this(context, null);
    }

    public u0(Context context, AttributeSet attributeSet) {
        this(context, null, 0);
    }

    public u0(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.g = new a();
        this.h = null;
    }

    public final RelativeLayout a(Activity activity, MimoAdInfo mimoAdInfo) {
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        addView(relativeLayout, b(activity, mimoAdInfo));
        setBackgroundColor(-1728053248);
        setClipToPadding(false);
        setClipChildren(false);
        return relativeLayout;
    }

    public final c6 a(View view) {
        return new c6(view, getRootView(), this.f5620a.getCloseICP(), null, new View[]{this.b.getDownloadBtn()}, this.mViewEventInfo, false, false);
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0038  */
    public FrameLayout.LayoutParams b(Activity activity, MimoAdInfo mimoAdInfo) {
        boolean z;
        if (mimoAdInfo.t()) {
            z = mimoAdInfo.p0.trim().endsWith(ijiami_1011.s.s.s.d(new byte[]{15}, "9e74ea")) || mimoAdInfo.p0.trim().endsWith(ijiami_1011.s.s.s.d(new byte[]{2, 106, 7, Ascii.FS, 5}, "454d70"));
        }
        int iA = f9.a(getContext(), z ? 29.1f : 21.8f);
        int iA2 = f9.a(getContext(), z ? 334.5f : 349.0f);
        if (activity.getResources().getConfiguration().orientation == 1) {
            iA2 = f9.d(getContext()) - (iA * 2);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(iA2, -2);
        layoutParams.gravity = 17;
        return layoutParams;
    }

    public j0 b() {
        j0 x0Var = this.c.t() ? new x0(getContext()) : new a1(getContext());
        x0Var.post(new b(x0Var));
        x0Var.g = false;
        x0Var.setBackgroundColor(-1);
        return x0Var;
    }

    @Override // com.miui.zeus.mimo.sdk.view.IBindDataView
    public void destroy() {
        j0 j0Var = this.f5620a;
        if (j0Var != null) {
            j0Var.destroy();
        }
        i0 i0Var = this.b;
        if (i0Var != null) {
            i0Var.destroy();
        }
        CommonActionHandler commonActionHandler = this.d;
        if (commonActionHandler != null) {
            commonActionHandler.a();
        }
    }

    public RelativeLayout.LayoutParams getBottomLayoutParams() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(3, this.f5620a.getId());
        return layoutParams;
    }

    @Override // android.view.View, com.miui.zeus.mimo.sdk.view.IBindDataView
    public View getRootView() {
        return this;
    }

    public final void notifyViewClicked(View view, ClickAreaType clickAreaType, boolean z) {
        com.miui.zeus.mimo.sdk.b.a(AdEvent.CLICK, this.c, this.mViewEventInfo, k6.a(null, z ? ClickAreaType.TYPE_CPM_BUTTON : clickAreaType, a(view).f5387a, clickAreaType == ClickAreaType.TYPE_NATIVE_SHAKE ? this.f5620a.getExtShakeInfo() : null));
        w3 w3Var = this.e;
        if (w3Var != null) {
            w3Var.onClicked();
        }
    }

    @Override // com.miui.zeus.mimo.sdk.view.IBindDataView
    public boolean onBackPressed() {
        return false;
    }

    @Override // com.miui.zeus.mimo.sdk.i8
    public void onClick(View view, ClickAreaType clickAreaType) {
        DownloadButtonICP downloadButtonICP;
        ClickEventType clickEventTypeA = this.c.a(clickAreaType);
        if (AdMarkICP.a(view) || ClickAreaType.TYPE_CLOSE == clickAreaType) {
            a(view, clickAreaType);
            return;
        }
        if (clickEventTypeA == ClickEventType.CLICK_DISABLE) {
            return;
        }
        j0 j0Var = this.f5620a;
        if (j0Var != null) {
            j0Var.removeShakeView();
        }
        if (this.c.B1.booleanValue() && (downloadButtonICP = this.h) != null && clickAreaType == downloadButtonICP.getClickAreaType() && !this.h.a()) {
            notifyViewClicked(view, clickAreaType, false);
            a(view, ClickAreaType.TYPE_FRAUD_CLOSE);
            return;
        }
        CommonActionHandler commonActionHandler = this.d;
        if (commonActionHandler != null) {
            commonActionHandler.b = new d(view, clickAreaType);
            commonActionHandler.a(this.c, clickAreaType);
        }
    }

    @Override // com.miui.zeus.mimo.sdk.view.IBindDataView
    public void pause() {
        j0 j0Var = this.f5620a;
        if (j0Var != null) {
            j0Var.pause();
        }
        i0 i0Var = this.b;
        if (i0Var != null) {
            i0Var.pause();
        }
        y8.b.removeCallbacks(this.g);
    }

    @Override // com.miui.zeus.mimo.sdk.view.IBindDataView
    public void resume() {
        j0 j0Var = this.f5620a;
        if (j0Var != null) {
            j0Var.resume();
        }
        i0 i0Var = this.b;
        if (i0Var != null) {
            i0Var.resume();
        }
    }

    @Override // com.miui.zeus.mimo.sdk.view.IBindDataView
    public void setAdInfo(Activity activity, MimoAdInfo mimoAdInfo, w3 w3Var) {
        this.c = mimoAdInfo;
        this.e = w3Var;
        removeAllViews();
        this.f = a(activity, mimoAdInfo);
        j0 j0VarB = b();
        this.f5620a = j0VarB;
        j0VarB.setId(View.generateViewId());
        this.f.addView(this.f5620a);
        i0 i0VarA = a();
        this.b = i0VarA;
        i0VarA.setId(View.generateViewId());
        this.f.addView(this.b, getBottomLayoutParams());
        this.f5620a.setIClickAreaListener(this);
        this.f5620a.setAdInfo(activity, mimoAdInfo, w3Var);
        this.b.setIClickAreaListener(this);
        this.b.setAdInfo(activity, mimoAdInfo, w3Var);
        this.d = new CommonActionHandler(getContext(), activity, w3Var);
        String str = mimoAdInfo.K0;
        if (com.miui.zeus.mimo.sdk.b.a(str, ijiami_1011.s.s.s.d(new byte[]{6, 74, 14, 71, SignedBytes.MAX_POWER_OF_TWO, 92, 15, 3}, "b8a705"))) {
            y8.b.postDelayed(this.g, this.c.n());
        } else if (com.miui.zeus.mimo.sdk.b.a(str, ijiami_1011.s.s.s.d(new byte[]{7, 85, 89, Ascii.NAK, 39, 87, 6, 8, 3}, "a90ef9"))) {
            List<String> list = mimoAdInfo.L0;
            if (list != null && !list.isEmpty()) {
                ImageICP imageICP = new ImageICP(getContext());
                imageICP.setClickAreaType(ClickAreaType.TYPE_MOD);
                String str2 = list.get(0);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(f9.a(getContext(), 45.0f), f9.a(getContext(), 45.0f));
                layoutParams.addRule(6, this.b.getId());
                layoutParams.addRule(7, this.b.getId());
                layoutParams.setMargins(0, -5, -10, 0);
                this.f.addView(imageICP, layoutParams);
                imageICP.a(str2, this);
            }
        } else if (com.miui.zeus.mimo.sdk.b.a(str, ijiami_1011.s.s.s.d(new byte[]{0, 70, 90, 1, 10, 80}, "b38cf5")) && (mimoAdInfo.p0.trim().contains(ijiami_1011.s.s.s.d(new byte[]{16, 7, 69, 93, 3, 12, 41, 11, Ascii.DC4, 11, 75, 10, 13, 16, 86, 84, 39, 85}, "cd78fb")) || mimoAdInfo.p0.trim().contains(ijiami_1011.s.s.s.d(new byte[]{Ascii.SYN, 2, 66, 0, 6, 95, 55, 1, Ascii.DC4, Ascii.SYN, 88, 6, 4, 13, 113, 82}, "ea0ec1")))) {
            u7 u7Var = new u7(getContext(), getContext().getResources().getConfiguration().orientation);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
            if (activity.getResources().getConfiguration().orientation == 1) {
                layoutParams2.topMargin = f9.a(getContext(), mimoAdInfo.B() ? 4.0f : 32.0f);
                layoutParams2.bottomMargin = f9.a(getContext(), 82.0f);
            } else {
                layoutParams2.leftMargin = f9.a(getContext(), 20.0f);
                layoutParams2.rightMargin = f9.a(getContext(), 0.0f);
            }
            addView(u7Var, layoutParams2);
            u7Var.a(mimoAdInfo.L0, this);
        }
        i0 i0Var = this.b;
        if (i0Var == null || i0Var.getDownloadBtn() == null) {
            return;
        }
        this.h = this.b.getDownloadBtn();
    }

    public i0 a() {
        i0 l0Var;
        if (!this.c.t()) {
            l0Var = new p0(getContext());
        } else if (this.c.p0.trim().endsWith(ijiami_1011.s.s.s.d(new byte[]{80}, "a3e59a")) || this.c.p0.trim().endsWith(ijiami_1011.s.s.s.d(new byte[]{84, 109, 7, 76, 1}, "e24430"))) {
            l0Var = new l0(getContext());
        } else {
            l0Var = (this.c.p0.trim().endsWith(ijiami_1011.s.s.s.d(new byte[]{3}, "5e39c9")) || this.c.p0.trim().endsWith(ijiami_1011.s.s.s.d(new byte[]{82, 111, 7, 75, 2}, "d04304"))) ? new n0(getContext()) : new m0(getContext());
        }
        l0Var.post(new c(l0Var));
        l0Var.setBackgroundColor(-1);
        return l0Var;
    }

    public final void a(View view, ClickAreaType clickAreaType) {
        com.miui.zeus.mimo.sdk.b.a(AdEvent.CLOSE, this.c, this.mViewEventInfo, k6.a(null, a(view).f5387a, clickAreaType));
        w3 w3Var = this.e;
        if (w3Var != null) {
            w3Var.onClickCloseView();
        }
    }
}
