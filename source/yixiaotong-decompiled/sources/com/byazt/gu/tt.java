package com.byazt.gu;

import androidx.core.app.NotificationCompat;
import com.byazt.dna.z;
import com.byazt.gqp.u;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 17, 13})
public class tt implements c {
    @Override // com.byazt.gu.c
    public void c(com.byazt.gqp.tt ttVar, InetSocketAddress inetSocketAddress, Proxy proxy, u uVar, IOException iOException) {
        try {
            ((z) com.byazt.ut.uj.getService(NotificationCompat.CATEGORY_EVENT)).onExceptionEvent("okhttp_connectFailed", c(ttVar), iOException);
        } catch (Exception unused) {
        }
    }

    @Override // com.byazt.gu.c
    public void c(com.byazt.gqp.tt ttVar, IOException iOException) {
        try {
            ((z) com.byazt.ut.uj.getService(NotificationCompat.CATEGORY_EVENT)).onExceptionEvent("okhttp_callFailed", c(ttVar), iOException);
        } catch (Exception unused) {
        }
    }

    private JSONObject c(com.byazt.gqp.tt ttVar) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("url", tt(ttVar));
        return jSONObject;
    }

    private String tt(com.byazt.gqp.tt ttVar) throws NullPointerException {
        return ttVar.c().tt().toString();
    }
}
