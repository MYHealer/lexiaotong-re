package com.adprof.sdk;

import android.content.Context;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.TextView;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class yf extends pf {
    public yf(Context context) {
        super(context);
    }

    public static void a(yf yfVar) {
        RelativeLayout.LayoutParams layoutParams;
        if (((pf) yfVar).f577a != null && yfVar.m705a()) {
            ((pf) yfVar).f590c.setText("立即下载");
            ((pf) yfVar).f590c.setTextSize(2, 12.0f);
            ((pf) yfVar).f590c.setTextColor(-1);
            ((pf) yfVar).f590c.setGravity(17);
            ((pf) yfVar).f590c.setBackground(yfVar.getResources().getDrawable(R.drawable.adprof_shape_cta_bg));
            int iA = h8.a(7.0f);
            ((pf) yfVar).f590c.setPadding(iA, iA, iA, iA);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(h8.a(90.0f), -2);
            layoutParams2.addRule(11);
            layoutParams2.setMargins(0, h8.a(10.0f), h8.a(5.0f), 0);
            ((pf) yfVar).f590c.setOnClickListener(new xf(yfVar));
            ((pf) yfVar).f590c.setId(102060005);
            yfVar.addView(((pf) yfVar).f590c, layoutParams2);
            if (((pf) yfVar).f590c == null || ((pf) yfVar).f577a == null) {
                return;
            }
            int iA2 = h8.a(8.0f);
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) ((pf) yfVar).f577a.getLayoutParams();
            if (layoutParams3 != null) {
                layoutParams3.addRule(0, ((pf) yfVar).f590c.getId());
                layoutParams3.setMargins(layoutParams3.leftMargin, layoutParams3.topMargin, iA2, layoutParams3.bottomMargin);
                ((pf) yfVar).f577a.setLayoutParams(layoutParams3);
                ((pf) yfVar).f577a.invalidate();
            }
            TextView textView = ((pf) yfVar).f587b;
            if (textView == null || (layoutParams = (RelativeLayout.LayoutParams) textView.getLayoutParams()) == null) {
                return;
            }
            layoutParams.addRule(0, ((pf) yfVar).f590c.getId());
            layoutParams.setMargins(layoutParams.leftMargin, layoutParams.topMargin, iA2, layoutParams.bottomMargin);
            ((pf) yfVar).f587b.setLayoutParams(layoutParams);
            ((pf) yfVar).f587b.invalidate();
        }
    }

    @Override // com.adprof.sdk.pf
    public void b(Bundle bundle, d dVar) {
        post(new wf(this, bundle, dVar));
    }
}
