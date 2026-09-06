package com.adprof.sdk;

import java.util.Locale;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public abstract class gi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String[] f1192a = {"hap://", "quickapp://", "hapjs://", "hnquickapp://", "hwfastapp://", "huaweiquickapp://", "hmquickapp://", "miquickapp://", "xiaomiquickapp://", "oppohap://", "vivohap://", "vvquickapp://", "meizuquickapp://", "mzquickapp://", "ztequickapp://", "higame://", "hiapp://", "oppo://fastapp", "vivofastapp://", "https://dplink.dlhaoyuekj.cn", "https://dplink.cchlgame.com", "micloud://", "oaps://", "https://hapjs.org", "http://hapjs.org"};

    @JvmStatic
    public static final boolean a(String str) {
        if (str == null || StringsKt.isBlank(str)) {
            return false;
        }
        String lowerCase = StringsKt.trim((CharSequence) str).toString().toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        for (String str2 : f1192a) {
            if (StringsKt.startsWith$default(lowerCase, str2, false, 2, (Object) null)) {
                return true;
            }
        }
        return false;
    }
}
