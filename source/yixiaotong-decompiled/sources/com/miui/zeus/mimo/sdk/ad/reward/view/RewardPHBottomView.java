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
import com.miui.zeus.mimo.sdk.view.component.AdMarkICP;
import com.miui.zeus.mimo.sdk.view.component.BrandICP;
import com.miui.zeus.mimo.sdk.view.component.DownloadButtonICP;
import com.miui.zeus.mimo.sdk.view.component.SixElementsView;
import com.miui.zeus.mimo.sdk.w3;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class RewardPHBottomView extends FrameLayout implements h8, SixElementsView.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public BrandICP f5317a;
    public SixElementsView b;
    public DownloadButtonICP c;
    public i8 d;
    public w3 e;
    public AdMarkICP f;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            RewardPHBottomView rewardPHBottomView = RewardPHBottomView.this;
            i8 i8Var = rewardPHBottomView.d;
            if (i8Var != null) {
                i8Var.onClick(view, rewardPHBottomView.getClickAreaType());
            }
        }
    }

    public RewardPHBottomView(Context context) {
        this(context, null);
    }

    public RewardPHBottomView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RewardPHBottomView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(LayoutInflater.from(context).inflate(a0.v5, (ViewGroup) this, true));
    }

    public final void a(View view) {
        this.f5317a = (BrandICP) view.findViewById(a0.v0);
        this.c = (DownloadButtonICP) view.findViewById(a0.n4);
        this.f = (AdMarkICP) view.findViewById(a0.k0);
        this.b = (SixElementsView) view.findViewById(a0.j);
        setOnClickListener(new a());
    }

    @Override // com.miui.zeus.mimo.sdk.view.component.SixElementsView.e
    public void a(String str) {
        w3 w3Var = this.e;
        if (w3Var != null) {
            w3Var.onJumpWebView(str);
        }
    }

    public ClickAreaType getClickAreaType() {
        return ClickAreaType.TYPE_BOTTOM_CARD;
    }

    public View getDownloadButton() {
        return this.c;
    }
}
