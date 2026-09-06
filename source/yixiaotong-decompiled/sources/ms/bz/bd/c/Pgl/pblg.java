package ms.bz.bd.c.Pgl;

import android.os.Build;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public final class pblg {
    public static String c() {
        JSONObject jSONObject = new JSONObject();
        try {
            HashMap mapTt = tt();
            for (String str : mapTt.keySet()) {
                jSONObject.put(str, mapTt.get(str));
            }
            return jSONObject.toString();
        } catch (Throwable unused) {
            return (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "e72018", new byte[]{111, 40});
        }
    }

    private static HashMap tt() {
        HashMap map = new HashMap();
        map.put((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "daf427", new byte[]{36}), Build.MODEL);
        map.put((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "63475c", new byte[]{117}), Build.BRAND);
        map.put((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "9b7ae4", new byte[]{123}), Build.BOARD);
        map.put((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "9881d3", new byte[]{124}), Build.VERSION.RELEASE);
        map.put((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "84d6f0", new byte[]{124}), Build.DISPLAY);
        map.put((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "da352e", new byte[]{35}), Build.HARDWARE);
        map.put((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "925f0d", new byte[]{127}), Build.FINGERPRINT);
        return map;
    }
}
