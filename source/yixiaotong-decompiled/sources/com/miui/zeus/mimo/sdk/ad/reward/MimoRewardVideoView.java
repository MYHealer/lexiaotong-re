package com.miui.zeus.mimo.sdk.ad.reward;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.miui.zeus.mimo.sdk.a0;
import com.miui.zeus.mimo.sdk.a3;
import com.miui.zeus.mimo.sdk.b3;
import com.miui.zeus.mimo.sdk.bean.MimoAdInfo;
import com.miui.zeus.mimo.sdk.c3;
import com.miui.zeus.mimo.sdk.d3;
import com.miui.zeus.mimo.sdk.h2;
import com.miui.zeus.mimo.sdk.j2;
import com.miui.zeus.mimo.sdk.n7;
import com.miui.zeus.mimo.sdk.v2;
import com.miui.zeus.mimo.sdk.view.IBindDataView;
import com.miui.zeus.mimo.sdk.view.component.RootICP;
import com.miui.zeus.mimo.sdk.w2;
import com.miui.zeus.mimo.sdk.w3;
import com.miui.zeus.mimo.sdk.x2;
import com.miui.zeus.mimo.sdk.y2;
import com.miui.zeus.mimo.sdk.z2;
import ijiami_1011.s.s.s;
import kotlin.io.encoding.Base64;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class MimoRewardVideoView extends RootICP implements IBindDataView, n7 {
    private Activity mActivity;
    private final FrameLayout mEndLayout;
    private final FrameLayout mHeadLayout;
    private h2 mRewardEView;
    private j2 mRewardPView;

    public MimoRewardVideoView(Context context) {
        this(context, null);
    }

    public MimoRewardVideoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MimoRewardVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        LayoutInflater.from(getContext()).inflate(a0.z1, (ViewGroup) this, true);
        this.mHeadLayout = (FrameLayout) findViewById(a0.X1);
        this.mEndLayout = (FrameLayout) findViewById(a0.U0);
    }

    private h2 createEView(MimoAdInfo mimoAdInfo) {
        if (mimoAdInfo.A()) {
            return null;
        }
        if (mimoAdInfo.y()) {
            return new c3(getContext(), null);
        }
        return (mimoAdInfo.t() && mimoAdInfo.p0.trim().endsWith(s.d(new byte[]{Base64.padSymbol, 125, 4}, "b856bf"))) ? new v2(getContext()) : new w2(getContext());
    }

    private j2 createPView(MimoAdInfo mimoAdInfo) {
        if (mimoAdInfo.y()) {
            return new d3(getContext());
        }
        if (mimoAdInfo.A()) {
            return new z2(getContext(), null);
        }
        if (this.mActivity.getResources().getConfiguration().orientation == 1) {
            return mimoAdInfo.p0.trim().startsWith(s.d(new byte[]{90, 89, 0, 85, 93, 17, 8, Ascii.DC2, 3, 43, 92, 2, 101, 82, 17, 111, 99, 84}, "37c03e")) ? new y2(getContext()) : new b3(getContext());
        }
        return mimoAdInfo.p0.trim().startsWith(s.d(new byte[]{11, 86, 85, 84, 86, SignedBytes.MAX_POWER_OF_TWO, 8, Ascii.DC2, 3, 43, 92, 2, 42, 87, 68, 110, 104, 5}, "b86184")) ? new x2(getContext()) : new a3(getContext());
    }

    @Override // com.miui.zeus.mimo.sdk.view.IBindDataView
    public void destroy() {
        j2 j2Var = this.mRewardPView;
        if (j2Var != null) {
            j2Var.destroy();
        }
        h2 h2Var = this.mRewardEView;
        if (h2Var != null) {
            h2Var.destroy();
        }
    }

    @Override // android.view.View, com.miui.zeus.mimo.sdk.view.IBindDataView
    public View getRootView() {
        return this;
    }

    @Override // com.miui.zeus.mimo.sdk.view.IBindDataView
    public boolean onBackPressed() {
        j2 j2Var = this.mRewardPView;
        if (j2Var != null && j2Var.getVisibility() == 0) {
            return this.mRewardPView.onBackPressed();
        }
        h2 h2Var = this.mRewardEView;
        if (h2Var == null || h2Var.getVisibility() != 0) {
            return true;
        }
        return this.mRewardEView.onBackPressed();
    }

    @Override // com.miui.zeus.mimo.sdk.n7
    public void onNeedEndPage() {
        this.mEndLayout.removeAllViews();
        this.mEndLayout.addView(this.mRewardEView);
        this.mEndLayout.setVisibility(0);
        this.mHeadLayout.removeAllViews();
        this.mRewardPView.setVisibility(8);
    }

    @Override // com.miui.zeus.mimo.sdk.view.IBindDataView
    public void pause() {
        j2 j2Var = this.mRewardPView;
        if (j2Var != null) {
            j2Var.pause();
        }
    }

    @Override // com.miui.zeus.mimo.sdk.view.IBindDataView
    public void resume() {
        j2 j2Var = this.mRewardPView;
        if (j2Var != null) {
            j2Var.resume();
        }
    }

    @Override // com.miui.zeus.mimo.sdk.view.IBindDataView
    public void setAdInfo(Activity activity, MimoAdInfo mimoAdInfo, w3 w3Var) {
        if (mimoAdInfo == null) {
            return;
        }
        mimoAdInfo.T = true;
        this.mActivity = activity;
        setBackgroundColor((mimoAdInfo.A() || mimoAdInfo.y()) ? 0 : -16777216);
        j2 j2VarCreatePView = createPView(mimoAdInfo);
        this.mRewardPView = j2VarCreatePView;
        j2VarCreatePView.setAdInfo(activity, mimoAdInfo, w3Var);
        this.mHeadLayout.removeAllViews();
        this.mHeadLayout.addView(this.mRewardPView);
        h2 h2VarCreateEView = createEView(mimoAdInfo);
        this.mRewardEView = h2VarCreateEView;
        if (h2VarCreateEView != null) {
            this.mRewardPView.setOnNeedEndPageListener(this);
            this.mRewardEView.setAdInfo(this.mActivity, mimoAdInfo, w3Var);
        }
    }
}
