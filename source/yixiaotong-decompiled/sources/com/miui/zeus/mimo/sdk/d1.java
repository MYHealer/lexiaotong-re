package com.miui.zeus.mimo.sdk;

import android.widget.RelativeLayout;
import com.miui.zeus.mimo.sdk.bean.MimoAdInfo;
import com.miui.zeus.mimo.sdk.click.ClickAreaType;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class d1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MimoAdInfo f5401a;
    public final /* synthetic */ b1 b;

    public class a implements o7.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ o7 f5402a;

        public a(o7 o7Var) {
            this.f5402a = o7Var;
        }

        @Override // com.miui.zeus.mimo.sdk.o7.d
        public void a(ClickAreaType clickAreaType, n6 n6Var) {
            b1 b1Var = d1.this.b;
            int i = b1.z;
            b1Var.mViewEventInfo = n6Var;
            b1Var.onClick(this.f5402a, clickAreaType);
            this.f5402a.b();
            this.f5402a.setVisibility(8);
            d1.this.b.removeView(this.f5402a);
        }
    }

    public d1(b1 b1Var, MimoAdInfo mimoAdInfo) {
        this.b = b1Var;
        this.f5401a = mimoAdInfo;
    }

    @Override // java.lang.Runnable
    public void run() {
        o7 o7Var = new o7(this.b.getContext(), null);
        o7Var.setDuration(this.f5401a.J0 * 1000);
        o7Var.setImages(this.f5401a.L0);
        o7Var.setRedPacketItemClickListener(new a(o7Var));
        o7Var.a();
        this.b.addView(o7Var, new RelativeLayout.LayoutParams(-1, -1));
    }
}
