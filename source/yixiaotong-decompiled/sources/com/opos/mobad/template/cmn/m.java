package com.opos.mobad.template.cmn;

import android.content.Context;
import android.widget.RelativeLayout;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class m {
    public static void a(Context context, RelativeLayout relativeLayout, boolean z) {
        RelativeLayout relativeLayout2 = new RelativeLayout(context);
        relativeLayout2.setClickable(true);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, com.opos.cmn.an.h.f.a.a(context, 16.0f));
        layoutParams.addRule(12);
        relativeLayout.addView(relativeLayout2, layoutParams);
        if (z) {
            return;
        }
        RelativeLayout relativeLayout3 = new RelativeLayout(context);
        relativeLayout3.setClickable(true);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(context, 16.0f), -1);
        layoutParams2.addRule(11);
        relativeLayout.addView(relativeLayout3, layoutParams2);
    }
}
