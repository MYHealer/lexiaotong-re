package com.kwad.sdk.core.config.item;

import android.content.Context;
import android.content.SharedPreferences;
import com.kwad.sdk.service.ServiceProvider;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class c extends b<Integer> {
    public c() {
        super("batchReportCacheType", 2);
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void l(JSONObject jSONObject) {
        if (jSONObject != null) {
            setValue(Integer.valueOf(jSONObject.optInt(getKey(), Lc().intValue())));
        } else {
            setValue(Lc());
        }
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void b(SharedPreferences.Editor editor) {
        i(ServiceProvider.Ud(), getValue().intValue());
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void a(SharedPreferences sharedPreferences) {
        setValue(Integer.valueOf(bO(ServiceProvider.Ud())));
    }

    public static int bO(Context context) {
        SharedPreferences sharedPreferences;
        try {
            com.kwad.sdk.core.d.c.d("batchReportCacheType", "loadBatchReportCacheType");
            if (context != null && (sharedPreferences = context.getSharedPreferences("ksadsdk_rep", 0)) != null) {
                return sharedPreferences.getInt("batchReportCacheType", 2);
            }
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
        }
        return 2;
    }

    private static void i(Context context, int i) {
        SharedPreferences sharedPreferences;
        com.kwad.sdk.core.d.c.d("batchReportCacheType", "saveBatchReportCacheType");
        if (context == null || (sharedPreferences = context.getSharedPreferences("ksadsdk_rep", 0)) == null) {
            return;
        }
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putInt("batchReportCacheType", i);
        editorEdit.apply();
    }
}
