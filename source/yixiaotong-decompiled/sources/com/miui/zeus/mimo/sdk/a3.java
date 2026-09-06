package com.miui.zeus.mimo.sdk;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.miui.zeus.mimo.sdk.ad.reward.view.RewardPHBottomView;
import com.miui.zeus.mimo.sdk.ad.reward.view.RewardPHRightView;
import com.miui.zeus.mimo.sdk.bean.MimoAdInfo;
import com.miui.zeus.mimo.sdk.click.ClickAreaType;
import com.miui.zeus.mimo.sdk.view.component.AdMarkICP;
import com.miui.zeus.mimo.sdk.view.component.AdMarkICP.a;
import com.miui.zeus.mimo.sdk.view.component.DownloadButtonICP;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class a3 extends j2 {
    public RewardPHBottomView I;
    public RewardPHRightView J;

    public a3(Context context) {
        super(context);
    }

    @Override // com.miui.zeus.mimo.sdk.j2
    public void a(View view) {
        super.a(view);
        this.I = (RewardPHBottomView) view.findViewById(a0.F2);
        this.J = (RewardPHRightView) view.findViewById(a0.o1);
    }

    @Override // com.miui.zeus.mimo.sdk.j2, com.miui.zeus.mimo.sdk.view.IBindDataView
    public void destroy() {
        DownloadButtonICP downloadButtonICP;
        DownloadButtonICP downloadButtonICP2;
        super.destroy();
        RewardPHBottomView rewardPHBottomView = this.I;
        if (rewardPHBottomView != null && (downloadButtonICP2 = rewardPHBottomView.c) != null) {
            downloadButtonICP2.b();
        }
        RewardPHRightView rewardPHRightView = this.J;
        if (rewardPHRightView == null || (downloadButtonICP = rewardPHRightView.f5319a) == null) {
            return;
        }
        downloadButtonICP.b();
    }

    @Override // com.miui.zeus.mimo.sdk.j2
    public void f() {
        this.I.setVisibility(0);
    }

    @Override // com.miui.zeus.mimo.sdk.j2
    public void g() {
        this.I.setVisibility(8);
    }

    @Override // com.miui.zeus.mimo.sdk.j2
    public View[] getDownloadViews() {
        return this.I.getVisibility() == 0 ? new View[]{this.I.getDownloadButton()} : new View[]{this.J.getDownloadButton()};
    }

    @Override // com.miui.zeus.mimo.sdk.j2
    public View getGuideTargetView() {
        return this.I.getVisibility() == 0 ? this.I.getDownloadButton() : this.J.getDownloadButton();
    }

    @Override // com.miui.zeus.mimo.sdk.j2
    public int getLayoutId() {
        return a0.p4;
    }

    @Override // com.miui.zeus.mimo.sdk.j2, com.miui.zeus.mimo.sdk.view.IBindDataView
    public void setAdInfo(Activity activity, MimoAdInfo mimoAdInfo, w3 w3Var) {
        super.setAdInfo(activity, mimoAdInfo, w3Var);
        if (mimoAdInfo.p0.trim().startsWith(ijiami_1011.s.s.s.d(new byte[]{88, 91, 1, 3, 15, SignedBytes.MAX_POWER_OF_TWO, 8, Ascii.DC2, 3, 52, 88, 1, 84, 90, 42, 9, 19, 93, Ascii.ESC, 11, 8, Ascii.SYN, 80, 9, 110, 101, 83}, "15bfa4")) || mimoAdInfo.p0.trim().startsWith(ijiami_1011.s.s.s.d(new byte[]{81, 92, 2, 92, 15, 16, 8, Ascii.DC2, 3, 52, 88, 1, 93, 93, 41, 86, 19, 13, Ascii.ESC, 11, 8, Ascii.SYN, 80, 9, 103, 98, 83}, "82a9ad")) || !mimoAdInfo.t()) {
            this.c.setVisibility(0);
            this.I.setVisibility(8);
            this.J.setVisibility(0);
            this.J.a(mimoAdInfo, w3Var, this);
            return;
        }
        this.I.setVisibility(0);
        this.c.setVisibility(8);
        this.J.setVisibility(8);
        RewardPHBottomView rewardPHBottomView = this.I;
        rewardPHBottomView.getClass();
        rewardPHBottomView.d = this;
        rewardPHBottomView.e = w3Var;
        rewardPHBottomView.f5317a.setVisibility(TextUtils.isEmpty(mimoAdInfo.r()) ? 8 : 0);
        rewardPHBottomView.f5317a.a(mimoAdInfo.r(), this);
        AdMarkICP adMarkICP = rewardPHBottomView.f;
        adMarkICP.f5687a.setText(mimoAdInfo.a());
        adMarkICP.setOnClickListener(adMarkICP.new a(mimoAdInfo, this));
        rewardPHBottomView.c.a(mimoAdInfo, false, true, this, false);
        rewardPHBottomView.c.setClickAreaType(ClickAreaType.TYPE_BOTTOM_BUTTON);
        rewardPHBottomView.b.setTextColor(Color.parseColor(ijiami_1011.s.s.s.d(new byte[]{Ascii.ESC, 119, 39, 6, 84, 2, 81, 84, 86}, "81a6d2")));
        rewardPHBottomView.b.a(mimoAdInfo.i, mimoAdInfo.k, mimoAdInfo.e(), mimoAdInfo.m, mimoAdInfo.l, mimoAdInfo.n, false);
        rewardPHBottomView.b.setOnItemClickListener(rewardPHBottomView);
    }
}
