package ms.bz.bd.c.Pgl;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import okhttp3.HttpUrl;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public final class n1 {

    static class pgla implements Comparator<Object> {
        pgla() {
        }

        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            int iAbs = Math.abs(((ScanResult) obj).level);
            int iAbs2 = Math.abs(((ScanResult) obj2).level);
            if (iAbs > iAbs2) {
                return 1;
            }
            return iAbs == iAbs2 ? 0 : -1;
        }
    }

    public static String c(Context context) {
        JSONArray jSONArray = new JSONArray();
        if (context == null) {
            return jSONArray.toString();
        }
        String string = null;
        try {
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            Method declaredMethod = wifiManager.getClass().getDeclaredMethod(new String(pblr.c("6765745363616e526573756c7473")), new Class[0]);
            List list = declaredMethod != null ? (List) declaredMethod.invoke(wifiManager, new Object[0]) : null;
            if (list == null || list.size() <= 0) {
                return jSONArray.toString();
            }
            Collections.sort(list, new pgla());
            for (int i = 0; i < list.size() && i < 10; i++) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("ss", v1.c(((ScanResult) list.get(i)).SSID));
                    jSONObject.put("bs", v1.c(((ScanResult) list.get(i)).BSSID));
                    jSONArray.put(jSONObject);
                } catch (JSONException unused) {
                }
            }
            string = jSONArray.toString();
            return string == null ? HttpUrl.PATH_SEGMENT_ENCODE_SET_URI : string.trim();
        } catch (Throwable unused2) {
        }
    }
}
