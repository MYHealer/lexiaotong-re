package com.opos.exoplayer.core.f.h;

import com.huawei.openalliance.ad.constant.x;
import com.opos.exoplayer.core.i.p;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Pattern f6459a = Pattern.compile("^NOTE(( |\t).*)?$");
    private static final Pattern b = Pattern.compile("^\ufeff?WEBVTT(( |\t).*)?$");

    public static long a(String str) {
        String[] strArrSplit = str.split("\\.", 2);
        long j = 0;
        for (String str2 : strArrSplit[0].split(x.bQ)) {
            j = (j * 60) + Long.parseLong(str2);
        }
        long j2 = j * 1000;
        if (strArrSplit.length == 2) {
            j2 += Long.parseLong(strArrSplit[1]);
        }
        return j2 * 1000;
    }

    public static void a(p pVar) throws com.opos.exoplayer.core.f.f {
        String strZ = pVar.z();
        if (strZ == null || !b.matcher(strZ).matches()) {
            throw new com.opos.exoplayer.core.f.f("Expected WEBVTT. Got " + strZ);
        }
    }

    public static float b(String str) {
        if (str.endsWith("%")) {
            return Float.parseFloat(str.substring(0, str.length() - 1)) / 100.0f;
        }
        throw new NumberFormatException("Percentages must end with %");
    }
}
