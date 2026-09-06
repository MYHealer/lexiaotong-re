package com.miui.zeus.mimo.sdk;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.miui.zeus.mimo.sdk.ad.reward.recycler.RewardRecyclerItemView;
import com.miui.zeus.mimo.sdk.bean.MimoAdInfo;
import com.miui.zeus.mimo.sdk.view.MimoPagerIndicatorView;
import com.miui.zeus.mimo.sdk.view.card.CardLayoutManager;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class v2 extends h2 {
    public RecyclerView s;
    public MimoPagerIndicatorView t;
    public View u;
    public y6 v;
    public ValueAnimator w;
    public RewardRecyclerItemView x;
    public int y;

    public v2(Context context) {
        super(context);
        this.y = 8;
    }

    public v2(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.y = 8;
    }

    @Override // com.miui.zeus.mimo.sdk.h2
    public void a(View view) {
        super.a(view);
        this.o = true;
        this.s = (RecyclerView) view.findViewById(a0.R0);
        this.t = (MimoPagerIndicatorView) view.findViewById(a0.H5);
        this.u = view.findViewById(a0.l);
        this.f.setTextColor(Color.parseColor(ijiami_1011.s.s.s.d(new byte[]{66, 91, 9, 118, 126, 35, 39, 34, 32}, "ac908e")));
        this.i.setTextColor(Color.parseColor(ijiami_1011.s.s.s.d(new byte[]{26, 9, 88, 116, 39, 116, 39, 34, 32}, "90a2a2")));
    }

    public final void a(ViewGroup viewGroup, boolean z) {
        if (z) {
            this.x = null;
        }
        if (viewGroup == null) {
            return;
        }
        for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = viewGroup.getChildAt(childCount);
            if (childAt != null) {
                if (childAt instanceof RewardRecyclerItemView) {
                    this.x = (RewardRecyclerItemView) childAt;
                    return;
                } else if (childAt instanceof ViewGroup) {
                    a((ViewGroup) childAt, false);
                }
            }
        }
    }

    @Override // com.miui.zeus.mimo.sdk.h2, com.miui.zeus.mimo.sdk.view.IBindDataView
    public void destroy() {
        super.destroy();
        ValueAnimator valueAnimator = this.w;
        if (valueAnimator != null) {
            valueAnimator.removeAllListeners();
            this.w.removeAllUpdateListeners();
            this.w.cancel();
        }
        y6 y6Var = this.v;
        if (y6Var != null) {
            y6Var.a();
            this.v = null;
        }
    }

    @Override // com.miui.zeus.mimo.sdk.h2
    public int getLayoutId() {
        Activity activity = this.j;
        return (activity == null || activity.getResources().getConfiguration().orientation != 2) ? a0.D5 : a0.W1;
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        w3 w3Var;
        d2 d2Var;
        double d;
        double d2;
        super.onWindowVisibilityChanged(i);
        if (i != 0 || this.y == i) {
            return;
        }
        this.y = i;
        MimoAdInfo mimoAdInfo = this.l;
        if (mimoAdInfo == null || (w3Var = this.n) == null) {
            return;
        }
        List<String> listA = mimoAdInfo.a(w3Var);
        ArrayList arrayList = (ArrayList) listA;
        if (arrayList.isEmpty()) {
            ((ViewGroup) this.s.getParent()).setVisibility(8);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.b.getLayoutParams();
            layoutParams.addRule(12, 0);
            layoutParams.addRule(13);
            layoutParams.removeRule(2);
            layoutParams.width = this.j.getResources().getConfiguration().orientation == 1 ? (f9.d(getContext()) * 884) / 1080 : f9.a(getContext(), 320.0f);
            this.b.setLayoutParams(layoutParams);
            return;
        }
        int i2 = this.j.getResources().getConfiguration().orientation;
        this.t.setVisibility(0);
        this.t.a(arrayList.size(), 0);
        this.u.setOnClickListener(new p2(this));
        v7 v7Var = new v7();
        v7Var.f5645a = 3;
        if (i2 == 2) {
            v7Var.b = f9.d(getContext()) / 13;
        } else {
            v7Var.b = ((int) (f9.d(getContext()) * 0.25f)) + f9.a(getContext(), 3.0f);
        }
        int iA = mimoAdInfo.f0;
        if (iA == -1) {
            iA = b.a(listA);
        }
        if (iA != 1 || this.t == null) {
            d2Var = new d2(getContext(), listA, i2 != 2 ? 0 : 1);
        } else {
            d2Var = new d2(getContext(), listA, 2);
            this.t.setOrientation(false);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.t.getLayoutParams();
            layoutParams2.width = -2;
            layoutParams2.removeRule(12);
            layoutParams2.addRule(11);
            layoutParams2.addRule(15);
            layoutParams2.setMargins(0, 0, f9.a(y8.f5752a, 15.0f), 0);
            this.t.setLayoutParams(layoutParams2);
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.s.getLayoutParams();
            if (i2 == 1) {
                int iC = f9.c(getContext());
                if (iC < 1900) {
                    d = iC;
                    d2 = 0.2d;
                } else {
                    d = iC;
                    d2 = 0.28d;
                }
                layoutParams3.setMargins(layoutParams3.leftMargin, (int) (d * d2), layoutParams3.rightMargin, layoutParams3.bottomMargin);
            } else {
                v7Var.d = f9.a(y8.f5752a, 79.0f);
            }
            v7Var.c = 0;
        }
        w7 w7Var = new w7(d2Var, listA, v7Var);
        w7Var.c = new r2(this);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(w7Var);
        itemTouchHelper.attachToRecyclerView(this.s);
        this.s.setVisibility(0);
        this.s.setItemAnimator(new DefaultItemAnimator());
        this.s.setAdapter(d2Var);
        RecyclerView recyclerView = this.s;
        recyclerView.setLayoutManager(new CardLayoutManager(recyclerView, itemTouchHelper, v7Var));
        this.s.post(new q2(this));
    }

    @Override // com.miui.zeus.mimo.sdk.h2, com.miui.zeus.mimo.sdk.view.IBindDataView
    public void setAdInfo(Activity activity, MimoAdInfo mimoAdInfo, w3 w3Var) {
        super.setAdInfo(activity, mimoAdInfo, w3Var);
    }
}
