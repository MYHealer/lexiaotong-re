package com.miui.zeus.mimo.sdk;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import com.miui.zeus.mimo.sdk.ad.reward.view.RewardPBottomView;
import com.miui.zeus.mimo.sdk.ad.reward.view.RewardPTopView;
import com.miui.zeus.mimo.sdk.bean.MimoAdInfo;
import com.miui.zeus.mimo.sdk.click.ClickAreaType;
import com.miui.zeus.mimo.sdk.view.component.DownloadButtonICP;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class b3 extends j2 {
    public RewardPTopView I;
    public RewardPBottomView J;

    public b3(Context context) {
        super(context);
    }

    @Override // com.miui.zeus.mimo.sdk.j2
    public void a(View view) {
        super.a(view);
        this.I = (RewardPTopView) view.findViewById(a0.Y3);
        this.J = (RewardPBottomView) view.findViewById(a0.A3);
    }

    @Override // com.miui.zeus.mimo.sdk.j2, com.miui.zeus.mimo.sdk.view.IBindDataView
    public void destroy() {
        DownloadButtonICP downloadButtonICP;
        DownloadButtonICP downloadButtonICP2;
        super.destroy();
        RewardPTopView rewardPTopView = this.I;
        if (rewardPTopView != null && (downloadButtonICP2 = rewardPTopView.d) != null) {
            downloadButtonICP2.b();
        }
        RewardPBottomView rewardPBottomView = this.J;
        if (rewardPBottomView == null || (downloadButtonICP = rewardPBottomView.f) == null) {
            return;
        }
        downloadButtonICP.b();
    }

    @Override // com.miui.zeus.mimo.sdk.j2
    public void f() {
        this.J.setVisibility(0);
    }

    @Override // com.miui.zeus.mimo.sdk.j2
    public void g() {
        this.J.setVisibility(8);
    }

    @Override // com.miui.zeus.mimo.sdk.j2
    public View[] getDownloadViews() {
        return new View[]{this.I.getDownloadButton(), this.J.getDownloadButton()};
    }

    @Override // com.miui.zeus.mimo.sdk.j2
    public View getGuideTargetView() {
        return this.J.getDownloadButton();
    }

    @Override // com.miui.zeus.mimo.sdk.j2
    public int getLayoutId() {
        return a0.G1;
    }

    @Override // com.miui.zeus.mimo.sdk.j2, com.miui.zeus.mimo.sdk.d7
    public void onVideoProgressUpdate(int i, int i2) {
        RewardPTopView rewardPTopView;
        super.onVideoProgressUpdate(i, i2);
        if (i < 1000 || !this.f.B() || (rewardPTopView = this.I) == null || rewardPTopView.getVisibility() == 0) {
            return;
        }
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, -1.0f, 1, 0.0f);
        translateAnimation.setDuration(330L);
        translateAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
        rewardPTopView.setVisibility(0);
        rewardPTopView.startAnimation(translateAnimation);
    }

    @Override // com.miui.zeus.mimo.sdk.j2, com.miui.zeus.mimo.sdk.view.IBindDataView
    public void setAdInfo(Activity activity, MimoAdInfo mimoAdInfo, w3 w3Var) {
        super.setAdInfo(activity, mimoAdInfo, w3Var);
        RewardPTopView rewardPTopView = this.I;
        rewardPTopView.getClass();
        if (mimoAdInfo != null) {
            rewardPTopView.e = this;
            rewardPTopView.f5324a.setVisibility(mimoAdInfo.t() ? 0 : 8);
            rewardPTopView.f5324a.a(b.h(mimoAdInfo.b(w3Var)) ? mimoAdInfo.b(w3Var) : mimoAdInfo.A, this);
            rewardPTopView.b.setVisibility(TextUtils.isEmpty(mimoAdInfo.r()) ? 8 : 0);
            rewardPTopView.b.a(mimoAdInfo.r(), this);
            rewardPTopView.c.a(mimoAdInfo.p(), this);
            rewardPTopView.d.a(mimoAdInfo, true, true, this, false);
            rewardPTopView.d.setClickAreaType(ClickAreaType.TYPE_TOP_BUTTON);
        }
        this.J.a(this.f, w3Var, this);
    }
}
