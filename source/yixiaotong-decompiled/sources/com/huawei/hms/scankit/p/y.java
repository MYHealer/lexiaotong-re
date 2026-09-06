package com.huawei.hms.scankit.p;

import android.text.TextUtils;
import com.huawei.hms.ml.scan.HmsScan;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: BookmarkDoCoMoResultParser.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class y extends x5 {
    private static final Pattern g = Pattern.compile("(?:MEBKM:)([\\s\\S]+)", 2);
    private static final Pattern h = Pattern.compile("(?:http:/?(?!/)|http//)([\\s\\S]+)", 2);

    private static String a(String[] strArr, String str) {
        for (String str2 : strArr) {
            if (str2.startsWith(str)) {
                return x5.b(str2.substring(str.length()));
            }
        }
        return "";
    }

    @Override // com.huawei.hms.scankit.p.x5
    public HmsScan b(w5 w5Var) {
        String strA = x5.a(w5Var);
        if (TextUtils.isEmpty(strA)) {
            return null;
        }
        Matcher matcher = g.matcher(strA);
        if (!matcher.matches()) {
            return null;
        }
        String[] strArrSplit = matcher.group(1).split("(?<=(?<!\\\\)(?:\\\\\\\\){0,100});");
        String strA2 = a(strArrSplit, "TITLE:");
        String strA3 = x5.a(a(strArrSplit, "URL:"));
        if (strA3.length() == 0) {
            return null;
        }
        Matcher matcher2 = h.matcher(strA3);
        if (matcher2.matches()) {
            strA3 = strA3.substring(0, 4) + "://" + matcher2.group(1);
        }
        String str = strA3;
        return new HmsScan(w5Var.k(), x5.a(w5Var.c()), str, HmsScan.URL_FORM, w5Var.i(), x5.a(w5Var.j()), null, new c6(new HmsScan.LinkUrl(strA2, str)));
    }
}
