package com.adprof.sdk;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public abstract class z0 {
    public static void a(Context context, View view, int i, d dVar) {
        z2 z2Var;
        try {
            ul ulVarA = vl.a(dVar);
            if (ulVarA != null && "1".equals(ulVarA.s)) {
                View viewFindViewById = view.findViewById(i);
                ViewGroup viewGroup = viewFindViewById != null ? (ViewGroup) viewFindViewById.getParent() : null;
                if (viewGroup instanceof RelativeLayout) {
                    TextView textView = new TextView(context);
                    q0 q0Var = dVar.f188a;
                    textView.setText(String.valueOf((q0Var == null || (z2Var = q0Var.f643a) == null) ? 0 : z2Var.f1548a));
                    textView.setTextColor(-7829368);
                    textView.setTextSize(2, 12.0f);
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.addRule(8, i);
                    layoutParams.addRule(16, i);
                    layoutParams.setMarginEnd(h8.a(6.0f));
                    int iIndexOfChild = viewGroup.indexOfChild(viewFindViewById);
                    viewGroup.addView(textView, iIndexOfChild >= 0 ? iIndexOfChild + 1 : viewGroup.getChildCount(), layoutParams);
                }
            }
        } catch (Throwable th) {
            pk.a(th);
        }
    }
}
