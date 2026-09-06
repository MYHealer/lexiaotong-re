package ms.bz.bd.c.Pgl;

import android.content.Context;
import com.bytedance.framwork.core.sdkmonitor.SDKMonitor;
import com.bytedance.framwork.core.sdkmonitor.SDKMonitorUtils;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public final class t1 extends pblx {
    private SDKMonitor c;

    final class pgla implements SDKMonitor.IGetExtendParams {
        final /* synthetic */ JSONObject c;
        final /* synthetic */ String tt;

        pgla(JSONObject jSONObject, String str) {
            this.c = jSONObject;
            this.tt = str;
        }
    }

    @Override // ms.bz.bd.c.Pgl.pblx
    public final void c(long j, long j2, String str, String str2, int i) {
        SDKMonitor sDKMonitor = this.c;
        if (sDKMonitor == null) {
            return;
        }
        sDKMonitor.monitorSLA(j, j2, str, (String) null, str2, i, (JSONObject) null);
    }

    @Override // ms.bz.bd.c.Pgl.pblx
    public final void c(String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "666dd2", new byte[]{Ascii.DC4, 56, 68, 2, 95, 36, 39, 50, 113, 49, 41, 32, 105, Ascii.US, 92, 8, 52, Ascii.EM, 102, 51, 34, 38, 5, 3, 94, 55, 35, Ascii.RS, 100, 49, 41, 53, 72, Ascii.NAK, Ascii.ESC, 104, 120, 90, 39});
        if (this.c == null) {
            return;
        }
        try {
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "6fc593", new byte[]{52, 97, 2, 87, 15, 39, 48, 73, 51, 104, 34}), str);
            jSONObject4.put((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "f76843", new byte[]{116, 52, 81, 73, 12, 43, 119, 15}), jSONObject);
            jSONObject4.put((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "5b8f2e", new byte[]{41, 101, 95, 0, 4, 113}), jSONObject2);
            jSONObject4.put((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "e12643", new byte[]{120, 60, 70, 103, 19, 48, 116}), jSONObject3);
            com.byazt.nr.m.uj((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "177c0d", new byte[]{13, 16, 112, 54, 60, 86, 17}), jSONObject4.toString());
        } catch (JSONException e) {
            com.byazt.nr.m.c(e);
        }
        if (jSONObject.length() > 0 || jSONObject2.length() > 0) {
            this.c.monitorEvent(str, jSONObject, jSONObject2, jSONObject3);
        }
    }

    @Override // ms.bz.bd.c.Pgl.pblx
    public final boolean c(String str) {
        JSONObject jSONObject;
        String str2;
        String string;
        Context contextTt = pblw.c().tt();
        String string2 = null;
        if (str != null) {
            try {
                jSONObject = new JSONObject(str);
            } catch (JSONException unused) {
                com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "34a302", new byte[]{49, 51, Ascii.US});
                jSONObject = null;
            }
        } else {
            jSONObject = null;
        }
        if (jSONObject == null) {
            return false;
        }
        try {
            string = jSONObject.getString((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "73ee60", new byte[]{53, 53, Ascii.GS, 46, 8, 46, 48}));
            try {
                string2 = jSONObject.getString((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "bed5fc", new byte[]{123, 104, 4, 85, 102, 117, 104, SignedBytes.MAX_POWER_OF_TWO}));
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                JSONArray jSONArray = jSONObject.getJSONArray((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "e4603c", new byte[]{119, 57, 75, 66, 5, 115, 83, 39, 75, 115}));
                JSONArray jSONArray2 = jSONObject.getJSONArray((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "743353", new byte[]{52, 51, 80, 72, Ascii.CAN, 48, 1, 39, 78, 112}));
                for (int i = 0; i < jSONArray.length(); i++) {
                    arrayList.add(jSONArray.getString(i));
                }
                for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                    arrayList2.add(jSONArray2.getString(i2));
                }
                if (arrayList.size() <= 0 || arrayList2.size() <= 0) {
                    return false;
                }
                SDKMonitorUtils.setConfigUrl(string, arrayList);
                SDKMonitorUtils.setDefaultReportUrl(string, arrayList2);
            } catch (JSONException unused2) {
                str2 = string2;
                string2 = string;
                com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "15fa4c", new byte[]{51, 50, Ascii.CAN, 42, 2});
                string = string2;
                string2 = str2;
            }
        } catch (JSONException unused3) {
            str2 = null;
        }
        jSONObject.remove((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "15488b", new byte[]{35, 56, 73, 74, 14, 114, 7, 38, 73, 123}));
        jSONObject.remove((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "0159f0", new byte[]{51, 54, 86, 66, 75, 51, 6, 34, 72, 122}));
        SDKMonitorUtils.initMonitor(contextTt, string, jSONObject, new pgla(jSONObject, string2));
        this.c = SDKMonitorUtils.getInstance(string);
        return true;
    }

    @Override // ms.bz.bd.c.Pgl.pblx
    public final void tt(long j, long j2, String str, String str2, int i) {
        SDKMonitor sDKMonitor = this.c;
        if (sDKMonitor == null) {
            return;
        }
        sDKMonitor.monitorApiError(j, j2, str, (String) null, str2, i, (JSONObject) null);
    }
}
