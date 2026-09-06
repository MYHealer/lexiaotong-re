package com.adprof.sdk;

import android.text.TextUtils;
import java.util.Calendar;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public final class n1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final n1 f1315a = new n1();

    public final Integer a(String str) {
        String string;
        if (str == null || (string = StringsKt.trim((CharSequence) str).toString()) == null) {
            return null;
        }
        return StringsKt.toIntOrNull(string);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public final void m689a(String str) {
        y0 y0Var;
        long j;
        int i;
        try {
            Integer numA = a(str);
            if (numA == null) {
                pk.b("recordSlotShow invalid slotId: " + str);
                return;
            }
            e2 e2VarA = d1.f1121a.a().a(numA.intValue());
            if (e2VarA != null && (y0Var = e2VarA.f230a) != null && y0Var.b > 0) {
                String str2 = "show_count_" + str;
                long jCurrentTimeMillis = System.currentTimeMillis();
                String string = sl.a().getString(str2, "");
                int i2 = 1;
                if (!TextUtils.isEmpty(string)) {
                    Intrinsics.checkNotNull(string);
                    if (StringsKt.contains$default((CharSequence) string, (CharSequence) "_", false, 2, (Object) null)) {
                        List listSplit$default = StringsKt.split$default((CharSequence) string, new String[]{"_"}, false, 0, 6, (Object) null);
                        if (listSplit$default.size() == 2) {
                            j = Long.parseLong((String) listSplit$default.get(0));
                            i = Integer.parseInt((String) listSplit$default.get(1));
                        } else {
                            j = 0;
                            i = 1;
                        }
                        Calendar calendar = Calendar.getInstance();
                        calendar.setTimeInMillis(jCurrentTimeMillis);
                        Calendar calendar2 = Calendar.getInstance();
                        calendar2.setTimeInMillis(j);
                        if (calendar.get(1) == calendar2.get(1) && calendar.get(2) == calendar2.get(2) && calendar.get(5) == calendar2.get(5)) {
                            i2 = 1 + i;
                        }
                    }
                }
                sl.a(str2, new StringBuilder().append(jCurrentTimeMillis).append('_').append(i2).toString());
                return;
            }
            pk.d("show no need record to sp");
        } catch (Throwable th) {
            pk.a(th);
            oh.b(th);
        }
    }
}
