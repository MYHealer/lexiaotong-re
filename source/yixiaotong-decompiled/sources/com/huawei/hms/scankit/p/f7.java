package com.huawei.hms.scankit.p;

import android.text.TextUtils;
import com.huawei.hms.ml.scan.HmsScan;
import com.huawei.openalliance.ad.views.PPSLabelView;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: WifiResultParser.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class f7 extends x5 {
    private static final Pattern g = Pattern.compile("WIFI:[^:]", 2);

    private static int c(String str) {
        if (str == null) {
            return 0;
        }
        if (str.equalsIgnoreCase("WEP")) {
            return 2;
        }
        if ((str.equalsIgnoreCase("WPA") | str.equalsIgnoreCase("WPA2") | str.equalsIgnoreCase("WPA/WPA2")) || str.equalsIgnoreCase("WPA2/WPA")) {
            return 1;
        }
        return str.equalsIgnoreCase("SAE") ? 3 : 0;
    }

    @Override // com.huawei.hms.scankit.p.x5
    public HmsScan b(w5 w5Var) {
        String strA = x5.a(w5Var);
        if (TextUtils.isEmpty(strA)) {
            return null;
        }
        Matcher matcher = g.matcher(strA);
        if (matcher.find() && matcher.start() == 0) {
            String strSubstring = strA.substring(5);
            if (!strSubstring.endsWith(";")) {
                strSubstring = strSubstring + ";";
            }
            String strB = x5.b("S:", strSubstring, ';', false);
            if (strB != null && !strB.isEmpty()) {
                String strB2 = x5.b("P:", strSubstring, ';', false);
                return new HmsScan(w5Var.k(), x5.a(w5Var.c()), strB + ((strB2 == null || strB2.isEmpty()) ? "" : PPSLabelView.Code + strB2), HmsScan.WIFI_CONNECT_INFO_FORM, w5Var.i(), x5.a(w5Var.j()), null, new c6(new HmsScan.WiFiConnectionInfo(strB, strB2, c(x5.b("T:", strSubstring, ';', false)))));
            }
        }
        return null;
    }
}
