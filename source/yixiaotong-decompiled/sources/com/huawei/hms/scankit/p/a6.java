package com.huawei.hms.scankit.p;

import android.text.TextUtils;
import com.huawei.hms.ml.scan.HmsScan;
import java.util.regex.Pattern;
import org.apache.commons.io.IOUtils;

/* JADX INFO: compiled from: SMSTOMMSTOResultParser.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class a6 extends x5 {
    private static final Pattern g = Pattern.compile("(?:mmsto|smsto):([\\s\\S]+)", 2);

    @Override // com.huawei.hms.scankit.p.x5
    public HmsScan b(w5 w5Var) {
        String strSubstring;
        String strSubstring2;
        String strA = x5.a(w5Var);
        if (TextUtils.isEmpty(strA) || !g.matcher(strA).matches()) {
            return null;
        }
        String strSubstring3 = strA.substring(6);
        int iIndexOf = strSubstring3.indexOf(58);
        if (iIndexOf >= 0) {
            strSubstring = strSubstring3.substring(0, iIndexOf);
            strSubstring2 = strSubstring3.substring(iIndexOf + 1);
        } else {
            strSubstring = strSubstring3;
            strSubstring2 = "";
        }
        return new HmsScan(w5Var.k(), x5.a(w5Var.c()), strSubstring2.isEmpty() ? strSubstring : strSubstring + IOUtils.LINE_SEPARATOR_UNIX + strSubstring2, HmsScan.SMS_FORM, w5Var.i(), x5.a(w5Var.j()), null, new c6(new HmsScan.SmsContent(strSubstring2, strSubstring)));
    }
}
