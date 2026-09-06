package com.huawei.hms.scankit.p;

import android.text.TextUtils;
import com.huawei.hms.ml.scan.HmsScan;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: EmailContentAddressResultParser.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class j2 extends x5 {
    private static final Pattern g = Pattern.compile("(?:MATMSG:TO:|mailto:|SMTP:)([\\s\\S]+)", 2);
    private static final Pattern h = Pattern.compile("mailto:([\\s\\S]+)\\?subject=([\\s\\S]+)&body=([\\s\\S]+)", 2);
    private static final Pattern i = Pattern.compile("MATMSG:TO:([\\s\\S]+);SUB:([\\s\\S]+);BODY:([\\s\\S]+)", 2);
    private static final Pattern j = Pattern.compile("SMTP:([\\s\\S]+):([\\s\\S]+):([\\s\\S]+)", 2);

    static String c(String str) {
        try {
            return URLDecoder.decode(str, "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            return str;
        }
    }

    @Override // com.huawei.hms.scankit.p.x5
    public HmsScan b(w5 w5Var) {
        String strGroup;
        String str;
        String strGroup2;
        String strA = x5.a(w5Var);
        if (TextUtils.isEmpty(strA) || !g.matcher(strA).matches()) {
            return null;
        }
        try {
            Matcher matcher = h.matcher(strA);
            Matcher matcher2 = i.matcher(strA);
            Matcher matcher3 = j.matcher(strA);
            if (matcher.matches()) {
                String strGroup3 = matcher.group(1);
                strGroup = matcher.group(2);
                strGroup2 = matcher.group(3);
                str = strGroup3;
            } else {
                if (!matcher2.matches()) {
                    if (matcher3.matches()) {
                        String strGroup4 = matcher3.group(1);
                        strGroup = matcher3.group(2);
                        str = strGroup4;
                        strGroup2 = matcher3.group(3);
                    }
                    return null;
                }
                String strGroup5 = matcher2.group(1);
                String strGroup6 = matcher2.group(2);
                String strGroup7 = matcher2.group(3);
                str = strGroup5;
                strGroup = strGroup6;
                strGroup2 = strGroup7;
            }
            return new HmsScan(w5Var.k(), x5.a(w5Var.c()), str, HmsScan.EMAIL_CONTENT_FORM, w5Var.i(), x5.a(w5Var.j()), null, new c6(new HmsScan.EmailContent(str, c(strGroup), c(strGroup2), HmsScan.EmailContent.OTHER_USE_TYPE)));
        } catch (RuntimeException | Exception unused) {
        }
    }
}
