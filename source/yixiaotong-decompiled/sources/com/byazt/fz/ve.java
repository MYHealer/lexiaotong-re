package com.byazt.fz;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 1022, 54})
public class ve implements com.byazt.wj.c {
    @Override // com.byazt.wj.c
    public com.byazt.wj.c.InterfaceC0314c c(String str) {
        return c.c(str);
    }

    @com.byazt.zqa.c(c = {0, 1, 1022, 24})
    static class c implements com.byazt.wj.c.InterfaceC0314c {
        public com.byazt.kx.c c;
        public String tt;

        private c(String str) {
            this.tt = str;
            this.c = com.byazt.kx.c.c(str);
        }

        public static c c(String str) {
            return new c(str);
        }

        @Override // com.byazt.wj.c.InterfaceC0314c
        public Object c(JSONObject jSONObject) {
            com.byazt.kx.c cVar = this.c;
            if (cVar == null) {
                return this.tt;
            }
            Object objC = cVar.c(jSONObject);
            if (objC instanceof String) {
                return objC;
            }
            if (objC instanceof com.byazt.il.c) {
                return String.valueOf(rh.c((com.byazt.il.c) objC));
            }
            if (objC != null && objC.getClass().isArray()) {
                try {
                    return new JSONArray(objC).toString();
                } catch (JSONException unused) {
                    return String.valueOf(objC);
                }
            }
            return String.valueOf(objC);
        }
    }
}
