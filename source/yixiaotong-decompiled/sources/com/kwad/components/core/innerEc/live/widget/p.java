package com.kwad.components.core.innerEc.live.widget;

import android.view.View;
import android.view.ViewGroup;
import com.kwad.sdk.utils.ab;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class p {
    public static void b(ViewGroup viewGroup, View view) {
        try {
            Object objI = ab.i(ab.a("com.kwad.yoga.YogaNodeJNIFinalizer", viewGroup.getClass().getClassLoader()));
            ab.callMethodOrThrow(objI, "setFlexGrow", Float.valueOf(1.0f));
            ab.callMethodOrThrow(objI, "setFlexShrink", Float.valueOf(1.0f));
            ab.callMethodOrThrow(viewGroup, "addView", view, objI);
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
        }
    }
}
