package com.miui.zeus.mimo.sdk;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.google.common.base.Ascii;
import com.miui.zeus.mimo.sdk.bean.MimoAdInfo;
import com.miui.zeus.mimo.sdk.click.ClickAreaType;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class y2 extends b3 {
    public v8 K;
    public ImageView L;
    public View M;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            y2 y2Var = y2.this;
            y2Var.onClick(y2Var.M, ClickAreaType.TYPE_PICTURE);
        }
    }

    public y2(Context context) {
        super(context);
    }

    @Override // com.miui.zeus.mimo.sdk.b3, com.miui.zeus.mimo.sdk.j2
    public void a(View view) {
        super.a(view);
        this.L = (ImageView) view.findViewById(a0.x0);
        this.M = view.findViewById(a0.u);
    }

    @Override // com.miui.zeus.mimo.sdk.b3, com.miui.zeus.mimo.sdk.j2, com.miui.zeus.mimo.sdk.view.IBindDataView
    public void destroy() {
        super.destroy();
        v8 v8Var = this.K;
        if (v8Var != null) {
            v8Var.b();
        }
    }

    @Override // com.miui.zeus.mimo.sdk.b3, com.miui.zeus.mimo.sdk.j2
    public View getGuideTargetView() {
        return this.J.getCardView();
    }

    @Override // com.miui.zeus.mimo.sdk.b3, com.miui.zeus.mimo.sdk.j2
    public int getLayoutId() {
        return a0.V2;
    }

    /* JADX WARN: Code duplicated, block: B:23:0x007b  */
    @Override // com.miui.zeus.mimo.sdk.b3, com.miui.zeus.mimo.sdk.j2, com.miui.zeus.mimo.sdk.view.IBindDataView
    public void setAdInfo(Activity activity, MimoAdInfo mimoAdInfo, w3 w3Var) {
        int iE;
        super.setAdInfo(activity, mimoAdInfo, w3Var);
        getVideoView().setVisibility(8);
        Context context = getContext();
        int i = v8.i;
        v8 v8Var = new v8(context, null, 0);
        v8Var.f5646a = 0;
        this.K = v8Var;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        if (getVideoViewContainer() != null) {
            getVideoViewContainer().addView(this.K, 0, layoutParams);
        }
        String strC = mimoAdInfo.c(w3Var);
        List<String> listA = mimoAdInfo.a(w3Var);
        int iA = mimoAdInfo.f0;
        if (iA == -1 && !((ArrayList) listA).isEmpty()) {
            iA = b.a(listA);
        }
        boolean z = (iA == 0 || iA == 1) ? false : true;
        if (b.h(mimoAdInfo.I)) {
            if (ijiami_1011.s.s.s.d(new byte[]{Ascii.DC4, 92, 67, 71, 91, 85, 0, 8}, "b91326").equals(mimoAdInfo.I)) {
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
            this.K.a(listA, iA);
            Glide.with(y8.f5752a).asBitmap().transform(new q6(25, 8, true, false)).load(listA.get(0)).into(this.L);
        }
        this.M.setOnClickListener(new a());
    }
}
