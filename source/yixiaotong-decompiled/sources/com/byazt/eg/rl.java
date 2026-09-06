package com.byazt.eg;

import client.android.yixiaotong.v3.comman.AppTypeIdUtil;
import java.nio.charset.Charset;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 16, AppTypeIdUtil.Drink4GCostControl_1})
public final class rl {
    public static final Pattern c = Pattern.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");
    public static final Pattern tt = Pattern.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f2140a;
    public final String n;
    public final String uj;
    public final String ve;

    public String c() {
        return this.uj;
    }

    public String toString() {
        return this.ve;
    }

    public String tt() {
        return this.n;
    }

    private rl(String str, String str2, String str3, String str4) {
        this.ve = str;
        this.uj = str2;
        this.n = str3;
        this.f2140a = str4;
    }

    public static rl c(String str) {
        Matcher matcher = c.matcher(str);
        if (!matcher.lookingAt()) {
            return null;
        }
        String lowerCase = matcher.group(1).toLowerCase(Locale.US);
        String lowerCase2 = matcher.group(2).toLowerCase(Locale.US);
        Matcher matcher2 = tt.matcher(str);
        String str2 = null;
        for (int iEnd = matcher.end(); iEnd < str.length(); iEnd = matcher2.end()) {
            matcher2.region(iEnd, str.length());
            if (!matcher2.lookingAt()) {
                return null;
            }
            if ("charset".equalsIgnoreCase(matcher2.group(1))) {
                String strGroup = matcher2.group(2);
                if (strGroup != null) {
                    if (strGroup.startsWith("'") && strGroup.endsWith("'") && strGroup.length() > 2) {
                        strGroup = strGroup.substring(1, strGroup.length() - 1);
                    }
                } else {
                    strGroup = matcher2.group(3);
                }
                if (str2 != null && !str2.equalsIgnoreCase(strGroup)) {
                    return null;
                }
                str2 = strGroup;
            }
        }
        return new rl(str, lowerCase, lowerCase2, str2);
    }

    public Charset ve() {
        return c((Charset) null);
    }

    public Charset c(Charset charset) {
        try {
            String str = this.f2140a;
            return str != null ? Charset.forName(str) : charset;
        } catch (IllegalArgumentException unused) {
            return charset;
        }
    }

    public boolean equals(Object obj) {
        return (obj instanceof rl) && ((rl) obj).ve.equals(this.ve);
    }

    public int hashCode() {
        return this.ve.hashCode();
    }
}
