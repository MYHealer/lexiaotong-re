package com.miui.zeus.mimo.sdk.ad.reward.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;
import android.widget.TextView;
import com.miui.zeus.mimo.sdk.a0;
import com.miui.zeus.mimo.sdk.bean.MimoAdInfo;
import com.miui.zeus.mimo.sdk.f9;
import com.miui.zeus.mimo.sdk.i8;
import com.miui.zeus.mimo.sdk.w3;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class RewardPlayablePBottomView extends RewardPBottomView {
    public boolean h;
    public boolean i;
    public ImageView j;
    public TextView k;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            RewardPlayablePBottomView rewardPlayablePBottomView = RewardPlayablePBottomView.this;
            rewardPlayablePBottomView.setDrawerViewExpanded(!rewardPlayablePBottomView.h);
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            RewardPlayablePBottomView.this.h = false;
            RewardPlayablePBottomView.this.j.setRotation(180.0f);
            RewardPlayablePBottomView.this.i = false;
            RewardPlayablePBottomView.this.d.setVisibility(4);
            RewardPlayablePBottomView.this.c.setVisibility(4);
        }
    }

    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            RewardPlayablePBottomView.this.k.setVisibility(0);
        }
    }

    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            RewardPlayablePBottomView.this.k.setVisibility(8);
        }
    }

    public RewardPlayablePBottomView(Context context) {
        this(context, null);
    }

    public RewardPlayablePBottomView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RewardPlayablePBottomView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.h = true;
        this.i = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a() {
        this.h = true;
        this.j.setRotation(0.0f);
        this.i = false;
        this.d.setVisibility(0);
        this.c.setVisibility(0);
    }

    @Override // com.miui.zeus.mimo.sdk.ad.reward.view.RewardPBottomView
    public View a(Context context, MimoAdInfo mimoAdInfo) {
        return LayoutInflater.from(context).inflate(a0.N5, (ViewGroup) this, true);
    }

    @Override // com.miui.zeus.mimo.sdk.ad.reward.view.RewardPBottomView
    public void a(MimoAdInfo mimoAdInfo, w3 w3Var, i8 i8Var) {
        super.a(mimoAdInfo, w3Var, i8Var);
        this.j = (ImageView) findViewById(a0.D0);
        this.k = (TextView) findViewById(a0.K5);
        this.j.setOnClickListener(new a());
    }

    public void setDrawerViewExpanded(boolean z) {
        ViewPropertyAnimator viewPropertyAnimatorWithStartAction;
        Runnable runnableLambdaFactory$;
        if (this.i) {
            return;
        }
        this.i = true;
        float width = getWidth() - f9.a(getContext(), 79.0f);
        if (z) {
            viewPropertyAnimatorWithStartAction = animate().translationX(0.0f).setDuration(300L).withStartAction(new d());
            runnableLambdaFactory$ = RewardPlayablePBottomView$$Lambda$1.lambdaFactory$(this);
        } else {
            viewPropertyAnimatorWithStartAction = animate().translationX(width).setDuration(300L).withStartAction(new c());
            runnableLambdaFactory$ = new b();
        }
        viewPropertyAnimatorWithStartAction.withEndAction(runnableLambdaFactory$).start();
    }
}
