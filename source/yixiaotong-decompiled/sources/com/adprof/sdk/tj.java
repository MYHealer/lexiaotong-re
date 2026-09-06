package com.adprof.sdk;

import android.graphics.Color;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class tj implements k8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ yj f1442a;

    public tj(yj yjVar) {
        this.f1442a = yjVar;
    }

    @Override // com.adprof.sdk.k8
    public void a() {
        pk.a("rewardBaseView----------onFinish----------");
        yj yjVar = this.f1442a;
        if (yjVar.f867a) {
            return;
        }
        TextView textView = yjVar.f875d;
        if (textView != null) {
            textView.setText("关闭");
            this.f1442a.f872c.setVisibility(8);
            this.f1442a.f867a = true;
        }
        xj xjVar = this.f1442a.f865a;
        if (xjVar != null) {
            kk kkVar = (kk) xjVar;
            d dVar = kkVar.f1269a.f1290a;
            if (dVar == null || !dVar.m606g()) {
                return;
            }
            kkVar.f1269a.f451a.m();
            kkVar.a();
        }
    }

    @Override // com.adprof.sdk.k8
    public void a(long j) {
        String str;
        yj yjVar = this.f1442a;
        if (yjVar.f867a) {
            return;
        }
        int i = (int) ((j / 1000) + 1);
        yjVar.b = i;
        if (yjVar.f875d != null) {
            if (i > yjVar.f863a.c) {
                if (((x0) yjVar).f821a.m606g()) {
                    yj yjVar2 = this.f1442a;
                    yjVar2.f875d.setText("获得奖励剩余 " + yjVar2.b + " 秒");
                    return;
                }
                return;
            }
            if (((x0) yjVar).f821a.m606g()) {
                str = "获得奖励剩余 " + this.f1442a.b + " 秒";
            } else {
                str = "跳过｜" + this.f1442a.b;
            }
            try {
                int iIndexOf = str.indexOf("｜");
                SpannableString spannableString = new SpannableString(str);
                spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#80FFFFFF")), iIndexOf, iIndexOf + 1, 33);
                this.f1442a.f875d.setText(spannableString);
            } catch (Exception unused) {
                this.f1442a.f875d.setText(str);
            }
        }
    }
}
