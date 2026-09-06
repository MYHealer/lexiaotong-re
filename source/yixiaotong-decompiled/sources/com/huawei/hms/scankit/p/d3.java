package com.huawei.hms.scankit.p;

import com.huawei.hms.ml.scan.HmsScan;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: HTTPResultParser.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class d3 extends x5 {
    private static final Pattern g = Pattern.compile("(?:http:|http//|https://)([\\s\\S]+)", 2);
    private static final Pattern h = Pattern.compile("(?:http:/?(?!/)|http//)([\\s\\S]+)", 2);

    @Override // com.huawei.hms.scankit.p.x5
    public HmsScan b(w5 w5Var) {
        String strA = x5.a(w5Var);
        if (!g.matcher(strA).matches()) {
            return null;
        }
        Matcher matcher = h.matcher(strA);
        if (matcher.matches()) {
            strA = strA.substring(0, 4) + "://" + matcher.group(1);
        }
        String strA2 = x5.a(strA);
        if (strA2.length() == 7) {
            return null;
        }
        return new HmsScan(w5Var.k(), x5.a(w5Var.c()), strA2, HmsScan.URL_FORM, w5Var.i(), x5.a(w5Var.j()), null, new c6(new HmsScan.LinkUrl("", strA2)));
    }
}
