package com.ubix.ssp.ad.e.b0;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import com.ubix.ssp.ad.e.a0.u;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class f {
    public static long a(Context context, Object obj) {
        if (e.f8775a) {
            return context.getSharedPreferences("UBIXVD_PROGRESS", 0).getLong("newVersion:" + obj.toString(), 0L);
        }
        return 0L;
    }

    public static Activity a(Context context) {
        if (context == null) {
            return null;
        }
        try {
            if (context instanceof Activity) {
                return (Activity) context;
            }
            if (context instanceof ContextWrapper) {
                return a(((ContextWrapper) context).getBaseContext());
            }
            return null;
        } catch (Exception e) {
            u.d("catch error", e.toString());
        }
    }

    public static void a(Context context, Object obj, long j) {
        if (e.f8775a) {
            if (j < 5000) {
                j = 0;
            }
            context.getSharedPreferences("UBIXVD_PROGRESS", 0).edit().putLong("newVersion:" + obj.toString(), j).apply();
        }
    }
}
