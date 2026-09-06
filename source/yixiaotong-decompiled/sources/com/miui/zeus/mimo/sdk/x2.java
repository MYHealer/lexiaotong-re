package com.miui.zeus.mimo.sdk;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.miui.zeus.mimo.sdk.ad.reward.view.RewardPHRightView;
import com.miui.zeus.mimo.sdk.bean.MimoAdInfo;
import com.miui.zeus.mimo.sdk.click.ClickAreaType;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class x2 extends j2 {
    public v8 I;
    public RewardPHRightView J;
    public FrameLayout K;
    public ImageView L;
    public View M;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            x2 x2Var = x2.this;
            x2Var.onClick(x2Var.M, ClickAreaType.TYPE_PICTURE);
        }
    }

    public x2(Context context) {
        super(context);
    }

    @Override // com.miui.zeus.mimo.sdk.j2
    public void a(View view) {
        super.a(view);
        RewardPHRightView rewardPHRightView = (RewardPHRightView) view.findViewById(a0.o1);
        this.J = rewardPHRightView;
        rewardPHRightView.setVisibility(0);
        this.c.setVisibility(0);
        this.c.setShowGravity(17);
        this.L = (ImageView) view.findViewById(a0.x0);
        int iD = f9.d(getContext());
        int iC = f9.c(getContext());
        if (iD < iC) {
            iC = iD;
            iD = iC;
        }
        FrameLayout frameLayout = (FrameLayout) view.findViewById(a0.F5);
        this.K = frameLayout;
        frameLayout.getLayoutParams().width = (int) (iD * 0.59f);
        this.K.getLayoutParams().height = iC;
        this.M = view.findViewById(a0.u);
    }

    @Override // com.miui.zeus.mimo.sdk.j2, com.miui.zeus.mimo.sdk.view.IBindDataView
    public void destroy() {
        super.destroy();
        v8 v8Var = this.I;
        if (v8Var != null) {
            v8Var.b();
        }
    }

    @Override // com.miui.zeus.mimo.sdk.j2
    public View[] getDownloadViews() {
        return new View[]{this.J.getDownloadButton()};
    }

    @Override // com.miui.zeus.mimo.sdk.j2
    public View getGuideTargetView() {
        return this.J.getDownloadButton();
    }

    @Override // com.miui.zeus.mimo.sdk.j2
    public int getLayoutId() {
        return a0.r;
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0081  */
    @Override // com.miui.zeus.mimo.sdk.j2, com.miui.zeus.mimo.sdk.view.IBindDataView
    public void setAdInfo(Activity activity, MimoAdInfo mimoAdInfo, w3 w3Var) {
        int iE;
        super.setAdInfo(activity, mimoAdInfo, w3Var);
        getVideoView().setVisibility(8);
        Context context = getContext();
        int i = v8.j;
        v8 v8Var = new v8(context, null, 0);
        v8Var.f5646a = i;
        this.I = v8Var;
        this.J.setVisibility(0);
        this.J.a(mimoAdInfo, w3Var, this);
        this.K.addView(this.I, 0, new FrameLayout.LayoutParams(-1, -1, 17));
        String strC = mimoAdInfo.c(w3Var);
        List<String> listA = this.f.a(w3Var);
        int iA = mimoAdInfo.f0;
        if (iA == -1 && !((ArrayList) listA).isEmpty()) {
            iA = b.a(listA);
        }
        boolean z = (iA == 0 || iA == 1) ? false : true;
        if (b.h(mimoAdInfo.I)) {
            if (ijiami_1011.s.s.s.d(new byte[]{79, 93, 67, 16, 15, 84, 0, 8}, "981df7").equals(mimoAdInfo.I)) {
                iE = 0;
            } else {
                iE = 1;
            }
        } else if (b.h(strC)) {
            iE = b.e(strC);
        } else {
            iE = 0;
        }
        if (z) {
            iA = 0;
        }
        ArrayList arrayList = new ArrayList();
        if (((ArrayList) listA).isEmpty() || z) {
            iA = iE;
            listA = arrayList;
        }
        if (iA == iE && strC != null) {
            listA.add(strC);
        }
        if (!listA.isEmpty()) {
            this.I.a(listA, iA);
            Glide.with(y8.f5752a).asBitmap().transform(new q6(25, 8, true, false)).load(listA.get(0)).into(this.L);
        }
        this.M.setOnClickListener(new a());
    }
}
