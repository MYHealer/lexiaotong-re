package com.hihonor.adsdk.base.e.e;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.hihonor.adsdk.base.c;
import com.hihonor.adsdk.common.b.b;
import com.hihonor.adsdk.common.f.t;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class a {
    private static final String hnadsa = "SecInfoCache";
    private static String hnadsb;

    private a() {
    }

    public static synchronized void hnadsa(String str) {
        hnadsb = str;
        SharedPreferences.Editor editorHnadsb = t.hnadse().hnadsb();
        if (editorHnadsb != null && str != null) {
            editorHnadsb.putString(c.x1.hnadsd, str);
            editorHnadsb.putLong(c.x1.hnadse, System.currentTimeMillis());
            b.hnadsc(hnadsa, "save sec info.", new Object[0]);
            editorHnadsb.apply();
        }
    }

    public static synchronized String hnadsa() {
        b.hnadsc(hnadsa, "get sec info.", new Object[0]);
        if (TextUtils.isEmpty(hnadsb)) {
            hnadsb = t.hnadse().hnadsg(c.x1.hnadsd);
        }
        return hnadsb;
    }
}
