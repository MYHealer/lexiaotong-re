package com.ubixnow.ooooo;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class oOO00 {
    private static int OooO00o = 30;
    private static int OooO0O0 = 15;

    public static void OooO00o(ViewGroup viewGroup, int i) {
        ViewGroup.LayoutParams layoutParams;
        if (viewGroup == null || i == 0) {
            return;
        }
        try {
            TextView textView = new TextView(viewGroup.getContext());
            ooooO000.OooO0O0("-----addTagView", i + " name:" + viewGroup.getClass().getName());
            if (textView.getParent() == null) {
                textView.setText("UBIX");
                textView.setBackgroundColor(1431721558);
                textView.setTextColor(-3158065);
                textView.setPadding(10, 5, 10, 5);
                textView.setTextSize(1, 10.0f);
                if (viewGroup instanceof RelativeLayout) {
                    viewGroup.addView(textView);
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) textView.getLayoutParams();
                    layoutParams2.topMargin = oOO00000.OooO00o(OooO00o);
                    layoutParams2.leftMargin = oOO00000.OooO00o(OooO0O0);
                    layoutParams2.rightMargin = oOO00000.OooO00o(OooO0O0);
                    layoutParams2.bottomMargin = oOO00000.OooO00o(OooO00o);
                    if (i == 2) {
                        layoutParams2.addRule(12);
                        layoutParams = layoutParams2;
                    } else if (i == 3) {
                        layoutParams = layoutParams2;
                        layoutParams2.addRule(11);
                        layoutParams = layoutParams2;
                    } else if (i == 4) {
                        layoutParams2.addRule(12);
                        layoutParams = layoutParams2;
                        layoutParams2.addRule(11);
                        layoutParams = layoutParams2;
                    }
                } else {
                    if (!(viewGroup instanceof FrameLayout)) {
                        return;
                    }
                    viewGroup.addView(textView);
                    FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
                    layoutParams3.topMargin = oOO00000.OooO00o(OooO00o);
                    layoutParams3.leftMargin = oOO00000.OooO00o(OooO0O0);
                    layoutParams3.rightMargin = oOO00000.OooO00o(OooO0O0);
                    layoutParams3.bottomMargin = oOO00000.OooO00o(OooO00o);
                    if (i == 2) {
                        layoutParams = layoutParams3;
                        layoutParams3.gravity = 80;
                        layoutParams = layoutParams3;
                    } else if (i == 3) {
                        layoutParams3.gravity = 5;
                        layoutParams = layoutParams3;
                    } else if (i == 4) {
                        layoutParams3.gravity = 85;
                        layoutParams = layoutParams3;
                    }
                }
                textView.setLayoutParams(layoutParams);
            }
        } catch (Exception unused) {
        }
    }
}
