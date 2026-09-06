package com.adprof.sdk;

import android.text.TextUtils;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public abstract class v5 implements Serializable {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f1472a = new HashMap();
    public Map b = new HashMap();

    public static boolean a(String str) {
        return (TextUtils.isEmpty(str) || "unFind".equals(str)) ? false : true;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public String m720a(String str) {
        if (!TextUtils.isEmpty(str)) {
            Matcher matcher = Pattern.compile("_([A-Z_0-9])+_").matcher(str);
            while (matcher.find()) {
                try {
                    String strGroup = matcher.group();
                    String strB = (String) this.b.get(strGroup);
                    if (!a(strB)) {
                        strB = (String) this.f1472a.get(strGroup);
                        if (!a(strB)) {
                            strB = null;
                        }
                    }
                    if (!a(strB)) {
                        strB = b(strGroup);
                        if (a(strB)) {
                        }
                    }
                    str = str.replaceAll(strGroup, strB);
                } catch (Throwable th) {
                    pk.b("macroProcess error: ", th);
                }
            }
        }
        return str;
    }

    public abstract String b(String str);
}
