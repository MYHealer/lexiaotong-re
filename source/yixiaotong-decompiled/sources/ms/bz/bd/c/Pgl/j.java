package ms.bz.bd.c.Pgl;

import android.net.DhcpInfo;
import android.net.wifi.WifiManager;
import com.google.common.base.Ascii;
import com.stub.StubApp;
import kotlin.io.encoding.Base64;
import org.json.JSONArray;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
final class j extends pblz.pgla {
    j() {
    }

    @Override // ms.bz.bd.c.Pgl.pblz.pgla
    public final Object c(long j, String str, Object obj) throws Throwable {
        JSONArray jSONArray = new JSONArray();
        try {
            DhcpInfo dhcpInfo = ((WifiManager) StubApp.getOrigApplicationContext(pblw.c().tt().getApplicationContext()).getSystemService((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "489329", new byte[]{50, 51, 76, 78}))).getDhcpInfo();
            jSONArray.put((dhcpInfo.dns1 & 255) + ((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "b54338", new byte[]{Base64.padSymbol})) + ((dhcpInfo.dns1 >> 8) & 255) + ((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "dab0f6", new byte[]{59})) + ((dhcpInfo.dns1 >> 16) & 255) + ((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "3a7275", new byte[]{108})) + ((dhcpInfo.dns1 >> 24) & 255));
            jSONArray.put((dhcpInfo.dns2 & 255) + ((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "09f501", new byte[]{111})) + ((dhcpInfo.dns2 >> 8) & 255) + ((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "e9ccdd", new byte[]{58})) + ((dhcpInfo.dns2 >> 16) & 255) + ((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "10dee0", new byte[]{110})) + ((dhcpInfo.dns2 >> 24) & 255));
        } catch (Throwable unused) {
            com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "f2ebb5", new byte[]{122, 57, Ascii.RS, 41, 89, 46});
        }
        return jSONArray.toString();
    }
}
