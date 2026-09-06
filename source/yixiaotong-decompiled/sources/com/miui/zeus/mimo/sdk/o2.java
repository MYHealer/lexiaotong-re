package com.miui.zeus.mimo.sdk;

import android.widget.RelativeLayout;
import com.miui.zeus.mimo.sdk.bean.MimoAdInfo;
import com.miui.zeus.mimo.sdk.click.ClickAreaType;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class o2 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MimoAdInfo f5544a;
    public final /* synthetic */ j2 b;

    public class a implements o7.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ o7 f5545a;

        public a(o7 o7Var) {
            this.f5545a = o7Var;
        }

        @Override // com.miui.zeus.mimo.sdk.o7.d
        public void a(ClickAreaType clickAreaType, n6 n6Var) {
            j2 j2Var = o2.this.b;
            String str = j2.H;
            j2Var.mViewEventInfo = n6Var;
            j2Var.onClick(this.f5545a, clickAreaType);
            this.f5545a.b();
            this.f5545a.setVisibility(8);
            o2.this.b.removeView(this.f5545a);
        }
    }

    public o2(j2 j2Var, MimoAdInfo mimoAdInfo) {
        this.b = j2Var;
        this.f5544a = mimoAdInfo;
    }

    @Override // java.lang.Runnable
    public void run() {
        o7 o7Var = new o7(this.b.getContext(), null);
        o7Var.setDuration(this.f5544a.J0 * 1000);
        o7Var.setImages(this.f5544a.L0);
        o7Var.setRedPacketItemClickListener(new a(o7Var));
        o7Var.a();
        this.b.addView(o7Var, new RelativeLayout.LayoutParams(-1, -1));
    }
}
