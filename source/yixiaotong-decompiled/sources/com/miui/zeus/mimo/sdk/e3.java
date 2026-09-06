package com.miui.zeus.mimo.sdk;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.miui.zeus.mimo.sdk.ad.reward.view.RewardPopPView;
import com.miui.zeus.mimo.sdk.bean.MimoAdInfo;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class e3 extends Dialog implements e2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f5412a;
    public MimoAdInfo b;
    public Activity c;
    public w3 d;
    public RewardPopPView e;
    public e2.a f;

    public class a implements RewardPopPView.c {
        public a() {
        }
    }

    public e3(Context context, Activity activity, MimoAdInfo mimoAdInfo, w3 w3Var, int i) {
        super(activity, i);
        this.f5412a = context;
        this.b = mimoAdInfo;
        this.c = activity;
        this.d = w3Var;
        a();
    }

    public final void a() {
        if (this.e == null) {
            RewardPopPView rewardPopPView = new RewardPopPView(this.f5412a, null);
            this.e = rewardPopPView;
            rewardPopPView.setAdInfo(this.c, this.b, this.d);
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface, com.miui.zeus.mimo.sdk.e2
    public void dismiss() {
        m.a(ijiami_1011.s.s.s.d(new byte[]{96, 4, Ascii.DC2, 86, Ascii.SYN, 86, 49, 11, Ascii.SYN, 38, 88, 4, 94, 14, 2}, "2ae7d2"), ijiami_1011.s.s.s.d(new byte[]{82, 80, 65, 88, 89, Ascii.ETB, Ascii.DC2}, "69250d"));
        RewardPopPView rewardPopPView = this.e;
        if (rewardPopPView != null) {
            rewardPopPView.destroy();
        }
        super.dismiss();
        e2.a aVar = this.f;
        if (aVar != null) {
            ((j2.l.a) aVar).a();
        }
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(this.e);
        Window window = getWindow();
        if (window != null) {
            window.setGravity(17);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.height = -1;
            attributes.dimAmount = 0.7f;
            window.setAttributes(attributes);
            window.addFlags(2);
            window.setLayout(-1, -1);
            window.setBackgroundDrawable(new ColorDrawable(0));
            if (this.c != null) {
                window.getDecorView().setSystemUiVisibility(this.c.getWindow().getDecorView().getSystemUiVisibility());
            }
        }
        setCanceledOnTouchOutside(false);
        setCancelable(false);
        this.e.setOnStatusListener(new a());
    }

    @Override // com.miui.zeus.mimo.sdk.e2
    public void a(Activity activity, String[] strArr, View view, e2.a aVar) {
        m.a(ijiami_1011.s.s.s.d(new byte[]{103, 1, Ascii.DC2, 83, 69, 82, 49, 11, Ascii.SYN, 38, 88, 4, 89, 11, 2}, "5de276"), ijiami_1011.s.s.s.d(new byte[]{71, 12, 13, 67}, "4db404"));
        if (b.a(activity)) {
            m.b(ijiami_1011.s.s.s.d(new byte[]{55, 4, 17, 87, 75, 81, 49, 11, Ascii.SYN, 38, 88, 4, 9, 14, 1}, "eaf695"), ijiami_1011.s.s.s.d(new byte[]{71, 92, 12, 17, 70, 3, 0, 13, 10, 7, 85, 95, Ascii.DC4, 85, 0, Ascii.DC2, 15, 19, 8, 16, Ascii.US, 66, 88, Ascii.SYN, Ascii.DC4, 90, Ascii.SYN, 10, 10, 69, 14, Ascii.SYN, 70, 6, 84, Ascii.SYN, SignedBytes.MAX_POWER_OF_TWO, 70, 12, Ascii.US, 3, 1}, "44cffe"));
            return;
        }
        RewardPopPView rewardPopPView = this.e;
        if (rewardPopPView == null || !rewardPopPView.S || !rewardPopPView.T) {
            m.b(ijiami_1011.s.s.s.d(new byte[]{54, 85, 79, 2, 75, 82, 49, 11, Ascii.SYN, 38, 88, 4, 8, 95, 95}, "d08c96"), ijiami_1011.s.s.s.d(new byte[]{65, 9, 91, 68, 67, 7, 0, 13, 10, 7, 85, 95, Ascii.DC2, 19, 81, SignedBytes.MAX_POWER_OF_TWO, 12, Ascii.DC4, 19, 7, 3, 66, 95, 10, 70, 65, 70, 86, 2, 5, Ascii.CAN}, "2a43ca"));
            return;
        }
        show();
        this.f = aVar;
        if (aVar != null) {
            ((j2.l.a) aVar).b();
        }
        b.a(this.b, ijiami_1011.s.s.s.d(new byte[]{99, 114, 110, 39, 98, 112, 62, 52, 41, 50, 110, 54, 121, 120, 110}, "179f04"), "", System.currentTimeMillis());
    }
}
