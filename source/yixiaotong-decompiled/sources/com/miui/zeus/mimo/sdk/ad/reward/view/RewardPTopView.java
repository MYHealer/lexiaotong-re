package com.miui.zeus.mimo.sdk.ad.reward.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.miui.zeus.mimo.sdk.a0;
import com.miui.zeus.mimo.sdk.click.ClickAreaType;
import com.miui.zeus.mimo.sdk.h8;
import com.miui.zeus.mimo.sdk.i8;
import com.miui.zeus.mimo.sdk.view.component.BrandICP;
import com.miui.zeus.mimo.sdk.view.component.DownloadButtonICP;
import com.miui.zeus.mimo.sdk.view.component.IconICP;
import com.miui.zeus.mimo.sdk.view.component.SummaryICP;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class RewardPTopView extends FrameLayout implements h8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public IconICP f5324a;
    public BrandICP b;
    public SummaryICP c;
    public DownloadButtonICP d;
    public i8 e;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            RewardPTopView rewardPTopView = RewardPTopView.this;
            i8 i8Var = rewardPTopView.e;
            if (i8Var != null) {
                i8Var.onClick(view, rewardPTopView.getClickAreaType());
            }
        }
    }

    public RewardPTopView(Context context) {
        this(context, null);
    }

    public RewardPTopView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RewardPTopView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(LayoutInflater.from(context).inflate(a0.S2, (ViewGroup) this, true));
    }

    public final void a(View view) {
        IconICP iconICP = (IconICP) view.findViewById(a0.T3);
        this.f5324a = iconICP;
        iconICP.setClickAreaType(ClickAreaType.TYPE_TOP_ICON);
        this.b = (BrandICP) view.findViewById(a0.K4);
        this.c = (SummaryICP) view.findViewById(a0.L5);
        this.d = (DownloadButtonICP) view.findViewById(a0.K2);
        setOnClickListener(new a());
    }

    public ClickAreaType getClickAreaType() {
        return ClickAreaType.TYPE_TOP_CARD;
    }

    public View getDownloadButton() {
        return this.d;
    }
}
