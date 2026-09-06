package com.byazt.ydv;

import android.text.TextUtils;
import com.byazt.gqp.m;
import com.byazt.gqp.t;
import com.byazt.gqp.yp;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 842, 15})
public class uj implements tt {
    public t c;

    public uj() {
        this.c = null;
        this.c = com.byazt.oy.tt.ve();
    }

    @Override // com.byazt.ydv.tt
    public c c(n nVar) throws IOException {
        yp.c cVar = new yp.c();
        try {
            if (nVar.n != null) {
                for (Map.Entry<String, String> entry : nVar.n.entrySet()) {
                    String key = entry.getKey();
                    if (!TextUtils.isEmpty(key)) {
                        String value = entry.getValue();
                        if (value == null) {
                            value = "";
                        }
                        cVar.tt(key, value);
                    }
                }
            }
            m mVarTt = this.c.c(cVar.c(nVar.tt).c().tt()).tt();
            com.byazt.lt.tt.c("NetworkSoureVolleyImpl", "response code = ", Integer.valueOf(mVarTt.ve()));
            return new a(mVarTt, nVar);
        } catch (Throwable th) {
            com.byazt.nr.m.c(th);
            return null;
        }
    }
}
