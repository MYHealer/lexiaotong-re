package com.byazt.bzd;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 724, 42})
public class i {

    @com.byazt.zqa.c(c = {0, 1, 724, 64})
    public static class c {
        public String c;
        public Map<String, String> tt;
    }

    public static c c(String str) {
        c cVar = new c();
        if (str == null) {
            return cVar;
        }
        String strTrim = str.trim();
        if (strTrim.equals("")) {
            return cVar;
        }
        String[] strArrSplit = strTrim.split("\\?");
        cVar.c = strArrSplit[0];
        if (strArrSplit.length == 1) {
            return cVar;
        }
        String[] strArrSplit2 = strArrSplit[1].split("&");
        cVar.tt = new HashMap();
        for (String str2 : strArrSplit2) {
            String[] strArrSplit3 = str2.split("=");
            if (strArrSplit3.length >= 2) {
                cVar.tt.put(strArrSplit3[0], strArrSplit3[1]);
            }
        }
        return cVar;
    }

    private static String c(String str, LinkedHashMap<String, String> linkedHashMap) {
        StringBuilder sb = new StringBuilder();
        if (str == null) {
            return sb.toString();
        }
        sb.append(str);
        boolean z = str.contains("?") || str.contains("&");
        if (linkedHashMap != null && linkedHashMap.size() > 0) {
            for (String str2 : linkedHashMap.keySet()) {
                if (!z) {
                    sb.append("?");
                    z = true;
                } else {
                    sb.append("&");
                }
                sb.append(str2).append("=").append(linkedHashMap.get(str2));
            }
        }
        return sb.toString();
    }

    public static String tt(String str) {
        c cVarC = c(str);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (cVarC.tt != null) {
            if (cVarC.tt.containsKey("v")) {
                linkedHashMap.put("v", cVarC.tt.get("v"));
                cVarC.tt.remove("v");
            }
            for (Map.Entry<String, String> entry : cVarC.tt.entrySet()) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return c(cVarC.c, linkedHashMap);
    }
}
