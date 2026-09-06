package com.adprof.sdk;

import android.graphics.Color;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;
import java.util.HashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class nm implements k8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ qm f1328a;

    public nm(qm qmVar) {
        this.f1328a = qmVar;
    }

    @Override // com.adprof.sdk.k8
    public void a() {
        pk.a("SplashBaseView", "----------onFinish----------");
        HashMap map = new HashMap();
        map.put("isSkip", Boolean.FALSE);
        s5.a(((x0) this.f1328a).f821a.k(), map, "action.splash.close", 0);
    }

    @Override // com.adprof.sdk.k8
    public void a(long j) {
        String str = "跳过｜" + ((int) ((j / 1000) + 1));
        try {
            int iIndexOf = str.indexOf("｜");
            SpannableString spannableString = new SpannableString(str);
            spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#80FFFFFF")), iIndexOf, iIndexOf + 1, 33);
            this.f1328a.f690d.setText(spannableString);
        } catch (Exception unused) {
            TextView textView = this.f1328a.f690d;
            if (textView != null) {
                textView.setText(str);
            }
        }
    }
}
