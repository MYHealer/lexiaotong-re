package com.huawei.hms.scankit.p;

import android.text.TextUtils;
import com.huawei.hms.ml.scan.HmsScan;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: URIResultParser.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class w6 extends x5 {
    private static final Pattern g = Pattern.compile("(?:uri|url):([\\s\\S]*)", 2);
    private static final Pattern h = Pattern.compile("(?:http:/?(?!/)|http//)([\\s\\S]+)", 2);

    @Override // com.huawei.hms.scankit.p.x5
    public HmsScan b(w5 w5Var) {
        String strA = x5.a(w5Var);
        if (TextUtils.isEmpty(strA) || !g.matcher(strA).matches()) {
            return null;
        }
        String strSubstring = strA.substring(4);
        Matcher matcher = h.matcher(strSubstring);
        if (matcher.matches()) {
            strSubstring = strSubstring.substring(0, 4) + "://" + matcher.group(1);
        }
        return new HmsScan(w5Var.k(), x5.a(w5Var.c()), x5.a(strSubstring), HmsScan.URL_FORM, w5Var.i(), x5.a(w5Var.j()), null, new c6(new HmsScan.LinkUrl("", "")));
    }
}
