package com.adprof.sdk;

import android.content.Context;
import android.graphics.Point;
import android.os.Handler;
import android.os.Looper;
import android.view.Display;
import java.util.HashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class ae {
    public ae(a3 a3Var, Context context, hg hgVar) {
        new HashMap();
        new HashMap();
        new Handler(Looper.getMainLooper());
        Display displayM636a = g8.m636a(context);
        if (displayM636a == null) {
            return;
        }
        Point point = new Point();
        displayM636a.getSize(point);
        Math.min(point.x, point.y);
    }
}
