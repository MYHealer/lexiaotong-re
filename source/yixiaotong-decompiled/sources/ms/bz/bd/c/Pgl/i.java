package ms.bz.bd.c.Pgl;

import android.text.TextUtils;
import com.google.common.base.Ascii;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import okio.Utf8;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
final class i extends pblz.pgla {
    i() {
    }

    @Override // ms.bz.bd.c.Pgl.pblz.pgla
    public final Object c(long j, String str, Object obj) throws Throwable {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface networkInterfaceNextElement = networkInterfaces.nextElement();
                Enumeration<InetAddress> inetAddresses = networkInterfaceNextElement.getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress inetAddressNextElement = inetAddresses.nextElement();
                    String name = networkInterfaceNextElement.getName();
                    if (!TextUtils.isEmpty(name) && !inetAddressNextElement.isLoopbackAddress() && (inetAddressNextElement instanceof Inet4Address) && name.startsWith((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "f77982", new byte[]{101, 56, 74, 72, 19}))) {
                        com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "950409", new byte[]{33, 57, 70, 84, 46, 42, 62, 6, 100, 119, 59, 119, 77, 65, 2, 43, 96});
                        networkInterfaceNextElement.getName();
                        return networkInterfaceNextElement.getName();
                    }
                }
            }
            return "";
        } catch (SocketException unused) {
            com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "a84f10", new byte[]{119, Utf8.REPLACEMENT_BYTE, 83, 82, 39, 55, 67, Ascii.GS, 97, 36, 117, 41, 84, 82, 8, 38, 107, Ascii.NAK, Utf8.REPLACEMENT_BYTE});
            return "";
        }
    }
}
