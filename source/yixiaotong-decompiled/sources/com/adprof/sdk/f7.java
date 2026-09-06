package com.adprof.sdk;

import android.widget.TextView;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public abstract class f7 {
    public static void a(TextView textView, TextView textView2, d dVar) {
        String str;
        String string;
        o1 o1Var;
        if (textView == null || dVar == null) {
            pk.e("adCtaText or adUnit is null");
        } else {
            q0 q0Var = dVar.f188a;
            if (q0Var == null || (o1Var = q0Var.f639a) == null || !o1Var.f525b) {
                dVar.m607h();
                string = dVar.m607h() ? "摇动或点击" : "点击";
            } else {
                string = textView.getContext().getString(R.string.adprof_interstitial_bubble_hint);
            }
            textView.setText(string);
        }
        if (textView2 == null || dVar == null) {
            pk.e("adCtaTextBottom or adUnit is null");
            return;
        }
        if (dVar.m597a()) {
            str = "立即下载";
        } else {
            str = dVar.c == 2 ? "跳转详情页或第三方应用" : "跳转详情页";
        }
        textView2.setText(str);
    }
}
