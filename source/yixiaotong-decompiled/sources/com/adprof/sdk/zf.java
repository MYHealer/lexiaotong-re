package com.adprof.sdk;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RelativeLayout;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class zf extends pf {
    public zf(Context context) {
        super(context);
    }

    @Override // com.adprof.sdk.pf
    public void b(Bundle bundle, d dVar) {
        ((pf) this).f576a.addRule(10);
        addView(((pf) this).f577a, ((pf) this).f576a);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(0, h8.a(5.0f), 0, 0);
        layoutParams.addRule(3, 10200001);
        layoutParams.addRule(14);
        a(dVar, layoutParams, "");
        if (TextUtils.isEmpty(((pf) this).f589b)) {
            ((pf) this).f577a.setVisibility(8);
        }
    }
}
