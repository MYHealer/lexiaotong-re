package com.adprof.sdk;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RelativeLayout;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class qf extends pf {
    public qf(Context context) {
        super(context);
    }

    @Override // com.adprof.sdk.pf
    public void b(Bundle bundle, d dVar) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(10);
        a(dVar, layoutParams, "");
        ((pf) this).f576a.setMargins(0, h8.a(5.0f), 0, 0);
        ((pf) this).f576a.addRule(3, 10200002);
        addView(((pf) this).f577a, ((pf) this).f576a);
        if (TextUtils.isEmpty(((pf) this).f589b)) {
            ((pf) this).f577a.setVisibility(8);
        }
    }
}
