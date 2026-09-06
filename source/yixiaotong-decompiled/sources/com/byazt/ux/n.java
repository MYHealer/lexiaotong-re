package com.byazt.ux;

import cz.msebera.android.httpclient.HttpStatus;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, HttpStatus.SC_INSUFFICIENT_SPACE_ON_RESOURCE, 46})
public class n {

    public interface c {
        void c(JSONObject jSONObject);
    }

    public static void c(com.byazt.seg.c cVar, c cVar2) {
        if (cVar == null) {
            if (cVar2 != null) {
                cVar2.c(null);
            }
        } else {
            c(cVar.ve(), cVar.c(), cVar.tt(), cVar2);
        }
    }

    public static void c(String str, String str2, String str3, final c cVar) {
        JSONObject jSONObjectC = com.byazt.xs.sp.c().c(str2, str3);
        if (jSONObjectC == null) {
            com.byazt.hy.tt.c(str, str2, str3, new com.byazt.hy.tt.InterfaceC0179tt() { // from class: com.byazt.ux.n.1
                @Override // com.byazt.hy.tt.InterfaceC0179tt
                public void c(JSONObject jSONObject) {
                    c cVar2 = cVar;
                    if (cVar2 != null) {
                        cVar2.c(jSONObject);
                    }
                }

                @Override // com.byazt.hy.tt.InterfaceC0179tt
                public void c() {
                    c cVar2 = cVar;
                    if (cVar2 != null) {
                        cVar2.c(null);
                    }
                }
            });
        } else if (cVar != null) {
            cVar.c(jSONObjectC);
        }
    }
}
