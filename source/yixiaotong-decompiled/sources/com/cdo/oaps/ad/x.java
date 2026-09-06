package com.cdo.oaps.ad;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public class x {
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x0043 -> B:19:0x0045). Please report as a decompilation issue!!! */
    public static float a(Context context) {
        float fFloatValue;
        Object obj;
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo("com.nearme.gamecenter", 128);
            if (applicationInfo.metaData == null || !applicationInfo.metaData.containsKey("oaps_version") || (obj = applicationInfo.metaData.get("oaps_version")) == null) {
                fFloatValue = -1.0f;
            } else {
                fFloatValue = obj instanceof Number ? ((Number) obj).floatValue() : Float.valueOf(obj.toString()).floatValue();
            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return fFloatValue > 0.0f ? fFloatValue : w.b(context);
    }
}
