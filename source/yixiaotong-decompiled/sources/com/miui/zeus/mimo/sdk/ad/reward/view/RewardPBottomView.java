package com.miui.zeus.mimo.sdk.ad.reward.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.google.common.base.Ascii;
import com.miui.zeus.mimo.sdk.a0;
import com.miui.zeus.mimo.sdk.b;
import com.miui.zeus.mimo.sdk.bean.MimoAdInfo;
import com.miui.zeus.mimo.sdk.click.ClickAreaType;
import com.miui.zeus.mimo.sdk.h8;
import com.miui.zeus.mimo.sdk.i8;
import com.miui.zeus.mimo.sdk.view.MimoScoreView;
import com.miui.zeus.mimo.sdk.view.component.AdMarkICP;
import com.miui.zeus.mimo.sdk.view.component.AdMarkICP.a;
import com.miui.zeus.mimo.sdk.view.component.BrandICP;
import com.miui.zeus.mimo.sdk.view.component.DownloadButtonICP;
import com.miui.zeus.mimo.sdk.view.component.IconICP;
import com.miui.zeus.mimo.sdk.view.component.SummaryICP;
import com.miui.zeus.mimo.sdk.w3;
import ijiami_1011.s.s.s;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class RewardPBottomView extends FrameLayout implements h8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public i8 f5315a;
    public IconICP b;
    public BrandICP c;
    public SummaryICP d;
    public AdMarkICP e;
    public DownloadButtonICP f;
    public View g;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            RewardPBottomView rewardPBottomView = RewardPBottomView.this;
            i8 i8Var = rewardPBottomView.f5315a;
            if (i8Var != null) {
                i8Var.onClick(view, rewardPBottomView.getClickAreaType());
            }
        }
    }

    public RewardPBottomView(Context context) {
        this(context, null);
    }

    public RewardPBottomView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RewardPBottomView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public View a(Context context, MimoAdInfo mimoAdInfo) {
        if (mimoAdInfo.p0.trim().startsWith(s.d(new byte[]{94, 90, 6, 93, 15, Ascii.ETB, 8, Ascii.DC2, 3, 43, 92, 2, 97, 81, Ascii.ETB, 103, 49, 82}, "74e8ac"))) {
            return LayoutInflater.from(context).inflate(a0.m2, (ViewGroup) this, true);
        }
        if (!mimoAdInfo.t()) {
            return LayoutInflater.from(context).inflate(a0.p3, (ViewGroup) this, true);
        }
        boolean zStartsWith = mimoAdInfo.p0.trim().startsWith(s.d(new byte[]{15, 94, 6, 85, 11, 76, 8, Ascii.DC2, 3, 52, 88, 1, 3, 95, 51, 85, Ascii.ETB, 76, 8, 7, 7, 14, 110, 53, 87}, "f0e0e8"));
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(context);
        return zStartsWith ? layoutInflaterFrom.inflate(a0.V0, (ViewGroup) this, true) : layoutInflaterFrom.inflate(a0.p5, (ViewGroup) this, true);
    }

    public View getCardView() {
        return this.g;
    }

    public ClickAreaType getClickAreaType() {
        return ClickAreaType.TYPE_BOTTOM_CARD;
    }

    public View getDownloadButton() {
        return this.f;
    }

    public void a(MimoAdInfo mimoAdInfo, w3 w3Var, i8 i8Var) {
        if (mimoAdInfo == null) {
            return;
        }
        this.f5315a = i8Var;
        removeAllViews();
        View viewA = a(getContext(), mimoAdInfo);
        this.g = viewA.findViewById(a0.A3);
        this.b = (IconICP) viewA.findViewById(a0.R3);
        this.c = (BrandICP) viewA.findViewById(a0.v0);
        this.e = (AdMarkICP) viewA.findViewById(a0.k0);
        MimoScoreView mimoScoreView = (MimoScoreView) viewA.findViewById(a0.h2);
        this.d = (SummaryICP) viewA.findViewById(a0.O2);
        DownloadButtonICP downloadButtonICP = (DownloadButtonICP) viewA.findViewById(a0.n4);
        this.f = downloadButtonICP;
        if (downloadButtonICP != null) {
            downloadButtonICP.a(mimoAdInfo, false, true, i8Var, false);
            this.f.setClickAreaType(ClickAreaType.TYPE_BOTTOM_BUTTON);
        }
        IconICP iconICP = this.b;
        if (iconICP != null) {
            iconICP.setClickAreaType(ClickAreaType.TYPE_BOTTOM_ICON);
            this.b.a(b.h(mimoAdInfo.b(w3Var)) ? mimoAdInfo.b(w3Var) : mimoAdInfo.A, i8Var);
            if (!mimoAdInfo.t()) {
                this.b.setVisibility(8);
            }
        }
        this.c.a(mimoAdInfo.r(), i8Var);
        AdMarkICP adMarkICP = this.e;
        if (adMarkICP != null) {
            adMarkICP.f5687a.setText(mimoAdInfo.a());
            adMarkICP.setOnClickListener(adMarkICP.new a(mimoAdInfo, i8Var));
        }
        SummaryICP summaryICP = this.d;
        if (summaryICP != null) {
            summaryICP.a(mimoAdInfo.p(), i8Var);
        }
        if (mimoScoreView != null) {
            if (!mimoAdInfo.t()) {
                mimoScoreView.setVisibility(8);
            }
            mimoScoreView.a(mimoAdInfo.o, mimoAdInfo.b(), i8Var);
        }
        setOnClickListener(new a());
        LinearLayout linearLayout = (LinearLayout) viewA.findViewById(a0.I1);
        if (mimoAdInfo.x() || linearLayout != null) {
            b.a(linearLayout, this.e, this.c);
        }
        if (mimoAdInfo.x()) {
            this.g.setBackgroundResource(a0.w5);
        }
    }
}
