package com.opos.mobad.ui.c;

import android.content.Context;
import android.view.View;
import java.util.Arrays;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int[] f8313a = {-999, -999, -999, -999};

    public static int[] a(Context context, View view, View view2, int[] iArr) {
        com.opos.cmn.an.f.a.b("CoordinationTools", "translate coordinate, " + Arrays.toString(iArr));
        if (context == null || view == null || view2 == null || iArr == null || iArr.length != 4 || Arrays.equals(iArr, f8313a)) {
            return iArr;
        }
        int[] iArr2 = new int[2];
        view.getLocationOnScreen(iArr2);
        int[] iArr3 = new int[2];
        view2.getLocationOnScreen(iArr3);
        int i = iArr3[0] - iArr2[0];
        int i2 = iArr3[1] - iArr2[1];
        int[] iArr4 = {com.opos.cmn.an.h.f.a.b(context, iArr[0] + i), com.opos.cmn.an.h.f.a.b(context, iArr[1] + i2), com.opos.cmn.an.h.f.a.b(context, iArr[2] + i), com.opos.cmn.an.h.f.a.b(context, iArr[3] + i2)};
        com.opos.cmn.an.f.a.b("CoordinationTools", "translate coordinate, ", Arrays.toString(iArr2), Arrays.toString(iArr3));
        com.opos.cmn.an.f.a.b("CoordinationTools", "translate coordinate, " + Arrays.toString(iArr4) + "[0][2]need minus -: " + i + "[1][3] need minus -" + i2);
        return iArr4;
    }
}
