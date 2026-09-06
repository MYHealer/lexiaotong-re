package ms.bz.bd.c.Pgl;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
final class w0 extends pblz.pgla {
    w0() {
    }

    @Override // ms.bz.bd.c.Pgl.pblz.pgla
    public final Object c(long j, String str, Object obj) throws Throwable {
        String string;
        Context contextTt = pblw.c().tt();
        ApplicationInfo applicationInfo = contextTt.getPackageManager().getApplicationInfo(contextTt.getPackageName(), 0);
        String str2 = applicationInfo.sourceDir;
        if (str2 == null) {
            str2 = applicationInfo.publicSourceDir;
        }
        HashMap mapC = pblc.c(str2);
        String string2 = "";
        String str3 = (mapC == null || !mapC.containsKey(1903654775)) ? "" : (String) mapC.get(1903654775);
        if (str3 != null && str3.length() > 0) {
            JSONObject jSONObject = new JSONObject(str3);
            try {
                string = jSONObject.getString((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "b4191a", new byte[]{126, 51, 86, 76, 49, 99, 108, 16, 110, 110, 76, 53, 74, 76, 0, 120, 100, Ascii.EM}));
            } catch (JSONException unused) {
                string = "";
            }
            StringBuilder sbAppend = new StringBuilder().append(string).append((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "18b57b", new byte[]{123}));
            try {
                string2 = jSONObject.getString((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "807df7", new byte[]{59, 55, 72, Ascii.NAK, 88, 51, 62, 46, 100, 33, 32, 62, SignedBytes.MAX_POWER_OF_TWO}));
            } catch (JSONException unused2) {
            }
            string2 = sbAppend.append(string2).toString();
        }
        return string2.length() == 0 ? (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "d874b2", new byte[]{91, 53, 74, 69}) : string2;
    }
}
