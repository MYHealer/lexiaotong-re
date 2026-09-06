package com.miui.zeus.mimo.sdk;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.miui.zeus.mimo.sdk.bean.MimoAdInfo;
import com.miui.zeus.mimo.sdk.view.IBindDataView;
import com.miui.zeus.mimo.sdk.view.component.RootICP;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class t0 extends RootICP implements IBindDataView, n7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public FrameLayout f5609a;
    public FrameLayout b;
    public b1 c;
    public r0 d;
    public boolean e;
    public Activity f;

    public t0(Context context, AttributeSet attributeSet) {
        this(context, null, 0);
    }

    public t0(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.e = false;
    }

    public final r0 a() {
        return new r0(getContext(), null);
    }

    @Override // com.miui.zeus.mimo.sdk.view.IBindDataView
    public void destroy() {
        Activity activity;
        b1 b1Var = this.c;
        if (b1Var != null) {
            b1Var.destroy();
        }
        r0 r0Var = this.d;
        if (r0Var != null) {
            r0Var.destroy();
        }
        if (!this.e || (activity = this.f) == null) {
            return;
        }
        activity.getWindow().clearFlags(1024);
    }

    @Override // android.view.View, com.miui.zeus.mimo.sdk.view.IBindDataView
    public View getRootView() {
        return this;
    }

    @Override // com.miui.zeus.mimo.sdk.view.IBindDataView
    public boolean onBackPressed() {
        return false;
    }

    @Override // com.miui.zeus.mimo.sdk.n7
    public void onNeedEndPage() {
        this.f5609a.removeAllViews();
        this.c.setVisibility(8);
        this.b.removeAllViews();
        this.b.addView(this.d);
        this.b.setVisibility(0);
    }

    @Override // com.miui.zeus.mimo.sdk.view.IBindDataView
    public void pause() {
        b1 b1Var = this.c;
        if (b1Var != null) {
            b1Var.pause();
        }
        r0 r0Var = this.d;
        if (r0Var != null) {
            r0Var.pause();
        }
    }

    @Override // com.miui.zeus.mimo.sdk.view.IBindDataView
    public void resume() {
        b1 b1Var = this.c;
        if (b1Var != null) {
            b1Var.resume();
        }
        r0 r0Var = this.d;
        if (r0Var != null) {
            r0Var.resume();
        }
        if (!this.e || this.f == null) {
            return;
        }
        post(new s0(this));
    }

    @Override // com.miui.zeus.mimo.sdk.view.IBindDataView
    public void setAdInfo(Activity activity, MimoAdInfo mimoAdInfo, w3 w3Var) {
        this.f = activity;
        if (activity == null || (activity.getWindow().getAttributes().flags & 1024) != 1024) {
            this.e = true;
            activity.getWindow().setFlags(1024, 1024);
        }
        removeAllViews();
        View viewInflate = LayoutInflater.from(getContext()).inflate(a0.y1, (ViewGroup) this, false);
        addView(viewInflate, new FrameLayout.LayoutParams(activity.getResources().getDisplayMetrics().widthPixels, -2));
        setBackgroundColor(-16777216);
        this.f5609a = (FrameLayout) viewInflate.findViewById(a0.q1);
        this.b = (FrameLayout) viewInflate.findViewById(a0.v2);
        b1 z0Var = mimoAdInfo.p0.trim().toLowerCase().contains(ijiami_1011.s.s.s.d(new byte[]{7, 87, 93, 83, 90, 80, 19, 15}, "e82871")) ? new z0(getContext()) : new b1(getContext());
        this.c = z0Var;
        z0Var.setAdInfo(activity, mimoAdInfo, w3Var);
        this.f5609a.removeAllViews();
        this.f5609a.addView(this.c);
        r0 r0VarA = a();
        this.d = r0VarA;
        r0VarA.setAdInfo(activity, mimoAdInfo, w3Var);
        this.c.setOnNeedEndPageListener(this);
    }
}
