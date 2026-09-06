package com.huawei.hms.scankit.p;

import android.text.TextUtils;
import com.huawei.hms.ml.scan.HmsScan;
import com.huawei.openalliance.ad.views.PPSLabelView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: DriverInfoResultParser.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class d2 extends x5 {
    private static final List<String> h = new a();
    private String g = "";

    /* JADX INFO: compiled from: DriverInfoResultParser.java */
    class a extends ArrayList<String> {
        a() {
            add("");
            add("DCT");
            add("DAD");
            add("DCS");
            add("DBC");
            add("DBB");
            add("DAG");
            add("DAI");
            add("DAJ");
            add("DAK");
            add("DAQ");
            add("DCG");
            add("DBD");
            add("DBA");
        }
    }

    public HmsScan.DriverInfo a(String[] strArr, String str) {
        String[] strArr2 = {"", "", "", "", "", "", "", "", "", "", "", "", "", ""};
        strArr2[0] = str;
        boolean z = false;
        for (String str2 : strArr) {
            if (str2.length() <= 3) {
                return null;
            }
            int iIndexOf = h.indexOf(str2.substring(0, 3));
            if (iIndexOf != -1) {
                strArr2[iIndexOf] = str2.substring(3).trim();
                z = true;
            }
        }
        if (!z) {
            return null;
        }
        this.g = strArr2[0] + PPSLabelView.Code + strArr2[3] + PPSLabelView.Code + strArr2[1];
        return new HmsScan.DriverInfo(strArr2[0], strArr2[1], strArr2[2], strArr2[3], strArr2[4], strArr2[5], strArr2[6], strArr2[7], strArr2[8], strArr2[9], strArr2[10], strArr2[11], strArr2[12], strArr2[13], null, null, null, null);
    }

    @Override // com.huawei.hms.scankit.p.x5
    public HmsScan b(w5 w5Var) {
        String strA = x5.a(w5Var);
        if (!TextUtils.isEmpty(strA) && strA.startsWith("@") && strA.length() > 34 && strA.substring(4, 8).equals("ANSI")) {
            String strValueOf = String.valueOf(strA.charAt(1));
            String strValueOf2 = String.valueOf(strA.charAt(3));
            String strSubstring = strA.substring(21, 23);
            HmsScan.DriverInfo driverInfoA = a(strA.substring(strA.indexOf(strSubstring, 23) + 2).split(strValueOf2)[0].split(strValueOf), strSubstring);
            if (driverInfoA != null) {
                return new HmsScan(w5Var.k(), x5.a(w5Var.c()), this.g, HmsScan.DRIVER_INFO_FORM, w5Var.i(), x5.a(w5Var.j()), null, new c6(driverInfoA));
            }
        }
        return null;
    }
}
