package com.miui.zeus.mimo.sdk;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.View;
import com.miui.zeus.mimo.sdk.bean.MimoAdInfo;
import com.miui.zeus.mimo.sdk.view.component.SixElementsView;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class o0 extends m0 {
    public SixElementsView k;

    public class a implements SixElementsView.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ w3 f5541a;

        public a(o0 o0Var, w3 w3Var) {
            this.f5541a = w3Var;
        }

        @Override // com.miui.zeus.mimo.sdk.view.component.SixElementsView.e
        public void a(String str) {
            this.f5541a.onJumpWebView(str);
        }
    }

    public o0(Context context) {
        super(context);
    }

    @Override // com.miui.zeus.mimo.sdk.m0, com.miui.zeus.mimo.sdk.i0
    public void a(View view) {
        super.a(view);
        this.g = false;
        this.k = (SixElementsView) view.findViewById(a0.U);
    }

    @Override // com.miui.zeus.mimo.sdk.m0, com.miui.zeus.mimo.sdk.i0, com.miui.zeus.mimo.sdk.view.IBindDataView
    public void destroy() {
        super.destroy();
    }

    @Override // com.miui.zeus.mimo.sdk.m0, com.miui.zeus.mimo.sdk.i0
    public int getLayoutId() {
        return a0.q4;
    }

    @Override // com.miui.zeus.mimo.sdk.m0, com.miui.zeus.mimo.sdk.i0, com.miui.zeus.mimo.sdk.view.IBindDataView
    public void setAdInfo(Activity activity, MimoAdInfo mimoAdInfo, w3 w3Var) {
        super.setAdInfo(activity, mimoAdInfo, w3Var);
        if (activity.getResources().getConfiguration().orientation == 1) {
            this.k.setVisibility(8);
            setPadding(0, 0, 0, mimoAdInfo.t() ? f9.a(getContext(), 40.0f) : f9.a(getContext(), 11.0f));
            return;
        }
        setPadding(0, 0, 0, f9.a(getContext(), 11.0f));
        this.k.setTextColor(Color.parseColor(ijiami_1011.s.s.s.d(new byte[]{17, 95, 93, 115, 117, 116, 39, 34, 32}, "2fd532")));
        this.k.a(mimoAdInfo.i, mimoAdInfo.k, mimoAdInfo.e(), mimoAdInfo.m, mimoAdInfo.l, mimoAdInfo.n, false);
        this.k.setVisibility(mimoAdInfo.D() ? 0 : 4);
        this.k.setOnItemClickListener(new a(this, w3Var));
    }
}
