package com.hihonor.hianalytics.util;

import android.content.Context;
import com.hihonor.hianalytics.hnha.j2;
import java.io.Closeable;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class d {
    public static List<String> a(Context context) {
        return b(context);
    }

    private static List<String> b(Context context) {
        if (context != null) {
            try {
                InputStream inputStreamOpen = context.getResources().getAssets().open("hianalytics_config");
                JSONArray jSONArray = new JSONObject(j.a(inputStreamOpen, 2048)).getJSONArray("base_uri");
                int length = jSONArray.length();
                if (length != 0 && length <= 13) {
                    ArrayList arrayList = new ArrayList();
                    for (int i = 0; i < length; i++) {
                        String strOptString = jSONArray.optString(i, "");
                        if (s.b(strOptString)) {
                            arrayList.add(strOptString);
                        }
                    }
                    k.a(inputStreamOpen);
                    return arrayList;
                }
                j2.g("ConfigUtils", "getFormalBaseUrl preBaseUri config is error,Number error of URI");
                ArrayList arrayList2 = new ArrayList();
                k.a(inputStreamOpen);
                return arrayList2;
            } catch (Throwable th) {
                try {
                    j2.g("ConfigUtils", "getFormalBaseUrl occurException=" + SystemUtils.getDesensitizedException(th));
                } finally {
                    k.a((Closeable) null);
                }
            }
        }
        return new ArrayList();
    }
}
