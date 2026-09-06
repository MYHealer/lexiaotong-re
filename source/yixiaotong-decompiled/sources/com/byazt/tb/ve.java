package com.byazt.tb;

import android.text.TextUtils;
import com.byazt.va.uj;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 1771, 54})
public final class ve extends c {
    public static tt c;

    @Override // com.byazt.tb.c
    public String c() {
        return "net";
    }

    public static String c(uj ujVar, String str) {
        Map map;
        tt ttVarC = com.byazt.sq.ve.c("net");
        if (ttVarC == null || (map = (Map) ttVarC.call(1, str)) == null) {
            return str;
        }
        String str2 = (String) map.get("url");
        if (!TextUtils.isEmpty(str2)) {
            str = str2;
        }
        Map map2 = (Map) map.get("header");
        if (map2 != null) {
            for (String str3 : map2.keySet()) {
                ujVar.tt(str3, (String) map2.get(str3));
            }
        }
        return str;
    }

    public static void c(JSONObject jSONObject, int i) {
        try {
            tt ttVarC = com.byazt.sq.ve.c("net");
            if (ttVarC == null) {
                return;
            }
            String string = com.byazt.nr.c.c(jSONObject.toString()).toString();
            HashMap map = new HashMap();
            map.put(TtmlNode.TAG_BODY, string);
            map.put("type", Integer.valueOf(i));
            ttVarC.call(2, map);
        } catch (Throwable unused) {
        }
    }

    public static void tt(JSONObject jSONObject, int i) {
        try {
            tt ttVarC = com.byazt.sq.ve.c("net");
            if (ttVarC != null && jSONObject != null) {
                String string = com.byazt.nr.c.c(jSONObject.toString()).toString();
                HashMap map = new HashMap();
                map.put(TtmlNode.TAG_BODY, string);
                map.put("type", Integer.valueOf(i));
                ttVarC.call(3, map);
            }
        } catch (Throwable unused) {
        }
    }
}
