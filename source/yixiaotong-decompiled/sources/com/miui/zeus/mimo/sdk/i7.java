package com.miui.zeus.mimo.sdk;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.miui.zeus.mimo.sdk.bean.MimoAdInfo;
import com.miui.zeus.mimo.sdk.click.ClickAreaType;
import com.miui.zeus.mimo.sdk.view.MimoScoreView;
import com.miui.zeus.mimo.sdk.view.component.IconICP;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class i7 extends h7 {
    public final w3 g;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            i8 i8Var = i7.this.c;
            if (i8Var != null) {
                i8Var.onClick(view, ClickAreaType.TYPE_RETENTION_DETAIL);
            }
        }
    }

    public i7(Activity activity, Context context, w3 w3Var, MimoAdInfo mimoAdInfo, int i) {
        super(activity, context, mimoAdInfo, i);
        this.g = w3Var;
    }

    @Override // com.miui.zeus.mimo.sdk.h7
    public int a() {
        return a0.w4;
    }

    @Override // com.miui.zeus.mimo.sdk.h7, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        TextView textView = (TextView) findViewById(a0.M5);
        textView.setVisibility(b.g(this.f.r()) ? 8 : 0);
        textView.setText(this.f.r());
        TextView textView2 = (TextView) findViewById(a0.P4);
        textView2.setVisibility(b.g(this.f.p()) ? 8 : 0);
        textView2.setText(this.f.p());
        findViewById(a0.A4).setOnClickListener(new a());
        MimoScoreView mimoScoreView = (MimoScoreView) findViewById(a0.N1);
        IconICP iconICP = (IconICP) findViewById(a0.y0);
        if (!this.f.t()) {
            mimoScoreView.setVisibility(8);
            iconICP.setVisibility(8);
            return;
        }
        MimoAdInfo mimoAdInfo = this.f;
        mimoScoreView.a(mimoAdInfo.o, mimoAdInfo.b(), null);
        iconICP.a(b.h(this.f.b(this.g)) ? this.f.b(this.g) : this.f.A, (i8) null);
        mimoScoreView.setVisibility(0);
        iconICP.setVisibility(0);
    }
}
