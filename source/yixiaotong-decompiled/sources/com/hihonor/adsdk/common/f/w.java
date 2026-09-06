package com.hihonor.adsdk.common.f;

import android.view.View;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class w {
    private static final String hnadsa = "SeparatorUtil";
    private static final int hnadsb = 2;

    public static void hnadsa(View... viewArr) {
        int length = viewArr.length;
        int i = 0;
        if (length <= 2 || length % 2 == 0) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "The length of views is greater than 2 and is an odd number", new Object[0]);
            return;
        }
        int i2 = length - 2;
        do {
            View view = viewArr[i];
            View view2 = viewArr[i + 1];
            if (view != null && view2 != null) {
                view2.setVisibility(view.getVisibility());
            }
            i += 2;
        } while (i < i2);
        int i3 = length - 1;
        do {
            View view3 = viewArr[i3];
            if (view3 != null && view3.getVisibility() == 0) {
                return;
            }
            View view4 = viewArr[i3 - 1];
            if (view4 != null && view4.getVisibility() == 0) {
                view4.setVisibility(8);
                return;
            }
            i3 -= 2;
        } while (i3 > 0);
    }
}
