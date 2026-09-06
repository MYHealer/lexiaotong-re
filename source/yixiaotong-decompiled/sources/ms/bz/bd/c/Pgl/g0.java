package ms.bz.bd.c.Pgl;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.Context;
import android.view.accessibility.AccessibilityManager;
import com.google.common.base.Ascii;
import java.lang.reflect.Method;
import java.util.List;
import kotlin.io.encoding.Base64;
import okio.Utf8;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
final class g0 extends pblz.pgla {
    g0() {
    }

    @Override // ms.bz.bd.c.Pgl.pblz.pgla
    public final Object c(long j, String str, Object obj) throws Throwable {
        List<AccessibilityServiceInfo> list;
        Context contextTt = pblw.c().tt();
        JSONArray jSONArray = new JSONArray();
        AccessibilityManager accessibilityManager = (AccessibilityManager) contextTt.getSystemService((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "5b1ee3", new byte[]{37, 99, 65, Ascii.DC4, 73, 55, Utf8.REPLACEMENT_BYTE, 65, 105, 57, 45, 116, 91}));
        if (accessibilityManager != null) {
            try {
                Method declaredMethod = accessibilityManager.getClass().getDeclaredMethod((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "4f4ddf", new byte[]{34, 97, 83, 57, 85, 98, 35, 70, 105, 56, 32, 96, 102, 19, 88, 116, 36, 84, 108, 54, 44, 104, 78, 4, 66, 66, 50, 85, 115, Base64.padSymbol, 38, 97, 107, Ascii.EM, 72, 101}), new Class[0]);
                list = declaredMethod != null ? (List) declaredMethod.invoke(accessibilityManager, new Object[0]) : null;
            } catch (Throwable unused) {
            }
            if (list == null || list.size() == 0) {
                return jSONArray.toString();
            }
            for (AccessibilityServiceInfo accessibilityServiceInfo : list) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "fbb1c2", new byte[]{114, 118}), accessibilityServiceInfo.eventTypes);
                    jSONObject.put((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "126c7a", new byte[]{41, 52}), accessibilityServiceInfo.getId());
                    jSONArray.put(jSONObject);
                } catch (Throwable unused2) {
                }
            }
        }
        return jSONArray.toString();
    }
}
