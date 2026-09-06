package com.fancy;

import android.content.Context;
import androidx.core.content.ContextCompat;
import com.kuaishou.weapon.p0.g;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _hs {
    public static boolean _a(Context context) {
        return ContextCompat.checkSelfPermission(context, g.b) == 0;
    }
}
