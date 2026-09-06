package client.android.yixiaotong.zksoundwave.b;

import com.huawei.openalliance.ad.views.PPSLabelView;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f971a = "53,53,48,51,65,53,48,52,53,65,65,65";
    private static final String b = "TAG";
    private static String c = "";
    private static String d = "";

    public static final String a(String str, int i) {
        c = str.substring(12, 20);
        StringBuilder sb = new StringBuilder();
        int i2 = i % 16;
        if (i2 != 0) {
            str = g.c(str, i2);
        }
        d = f.a(4);
        String str2 = d + g.k(f971a);
        sb.append(d.substring(0, 2));
        e eVar = new e();
        for (int i3 = 0; i3 < str.length() / 16; i3++) {
            int i4 = i3 * 16;
            sb.append(eVar.c(str.substring(i4, i4 + 16), str2, 0));
        }
        sb.append(d.substring(2, 4));
        return sb.toString();
    }

    public static boolean a(String str, String str2) {
        if (str != null && str2 != null && str2.length() > 26) {
            String strA = new h().a((str + str2.substring(6, str2.length() - 6)).replace(PPSLabelView.Code, ""));
            d.e(b, strA);
            byte[] bArrA = a.a(c.a(strA));
            StringBuilder sb = new StringBuilder();
            for (byte b2 : bArrA) {
                sb.append(c.a(b2));
            }
            d.e(b, sb.toString() + "  " + str2.substring(4, 6));
            if (sb.toString().equals(str2.substring(4, 6))) {
                return true;
            }
        }
        return false;
    }

    public static final String b(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        boolean zA = a(str2, str);
        d.e("test", zA + "  " + c + "  " + c.substring(6, 8) + "  " + str.substring(2, 4));
        if (zA && g.c(c) && c.substring(6, 8).equalsIgnoreCase(str.substring(2, 4))) {
            String strD = new e().d(str.substring(6, 22), d + str2.substring(4) + c, 0);
            sb.append("55");
            sb.append(str2);
            sb.append(strD);
            sb.append(str.substring(22, str.length() - 6));
        }
        return sb.toString();
    }
}
