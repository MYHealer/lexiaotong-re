package com.jd.ad.sdk.jad_xk;

import android.text.TextUtils;
import com.huawei.openalliance.ad.views.PPSLabelView;
import com.jd.ad.sdk.fdt.utils.ANEProxy;
import com.jd.ad.sdk.logger.Logger;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: EventRequestBuilder.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_jt {
    public static com.jd.ad.sdk.jad_zm.jad_fs jad_an() {
        com.jd.ad.sdk.jad_zm.jad_fs jad_fsVar = new com.jd.ad.sdk.jad_zm.jad_fs();
        jad_fsVar.jad_bo("User-Agent", com.jd.ad.sdk.jad_qd.jad_hu.jad_dq());
        jad_fsVar.jad_bo("Content-Type", "application/stream");
        return jad_fsVar;
    }

    public static byte[] jad_an(ConcurrentLinkedQueue<jad_dq> concurrentLinkedQueue) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        Iterator<jad_dq> it = concurrentLinkedQueue.iterator();
        while (it.hasNext()) {
            JSONObject jSONObjectJad_an = it.next().jad_an();
            jSONObjectJad_an.put("rts", String.valueOf(System.currentTimeMillis()));
            jSONArray.put(jSONObjectJad_an);
        }
        jSONObject.put("param", jSONArray);
        Logger.d("XlogReport  data: " + jSONObject);
        String strJa = ANEProxy.ja(jSONObject.toString().replace("\\n", PPSLabelView.Code).replace("\\t", PPSLabelView.Code).replace("\\r", PPSLabelView.Code));
        if (TextUtils.isEmpty(strJa)) {
            return null;
        }
        return strJa.getBytes(StandardCharsets.UTF_8);
    }
}
