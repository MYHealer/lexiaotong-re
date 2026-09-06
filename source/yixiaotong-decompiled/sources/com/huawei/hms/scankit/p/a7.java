package com.huawei.hms.scankit.p;

import com.huawei.hms.ml.scan.HmsScan;
import java.util.List;
import org.apache.commons.io.IOUtils;

/* JADX INFO: compiled from: VEventResultParser.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class a7 extends x5 {
    private static void a(String[] strArr, HmsScan.EventTime eventTime) {
        if (strArr == null || strArr.length == 0) {
            return;
        }
        for (String str : strArr) {
            s2.a(str, eventTime);
        }
    }

    @Override // com.huawei.hms.scankit.p.x5
    public HmsScan b(w5 w5Var) {
        String strA = x5.a(w5Var);
        if (!strA.startsWith("BEGIN:VEVENT")) {
            return null;
        }
        String str = strA + IOUtils.LINE_SEPARATOR_UNIX;
        String strA2 = a("SUMMARY", str, true);
        String strA3 = a("LOCATION", str, true);
        String strA4 = a("ORGANIZER", str, true);
        String strA5 = a("DESCRIPTION", str, true);
        String strA6 = a("STATUS", str, true);
        String[] strArrB = b("DTSTART", str, true);
        String[] strArrB2 = b("DTEND", str, true);
        HmsScan.EventTime eventTime = new HmsScan.EventTime(-1, -1, -1, -1, -1, -1, false, "");
        HmsScan.EventTime eventTime2 = new HmsScan.EventTime(-1, -1, -1, -1, -1, -1, false, "");
        a(strArrB, eventTime);
        a(strArrB2, eventTime2);
        return new HmsScan(w5Var.k(), x5.a(w5Var.c()), strA2, HmsScan.EVENT_INFO_FORM, w5Var.i(), x5.a(w5Var.j()), null, new c6(new HmsScan.EventInfo(strA2, eventTime, eventTime2, strA3, strA5, strA4, strA6)));
    }

    private static String a(CharSequence charSequence, String str, boolean z) {
        List<List<String>> listB = z6.b(charSequence, str, z, false);
        return (listB == null || listB.isEmpty()) ? "" : listB.get(listB.size() - 1).get(0);
    }

    private static String[] b(CharSequence charSequence, String str, boolean z) {
        List<List<String>> listB = z6.b(charSequence, str, z, false);
        if (listB == null || listB.isEmpty()) {
            return new String[0];
        }
        int size = listB.size();
        String[] strArr = new String[size];
        for (int i = 0; i < size; i++) {
            strArr[i] = listB.get(i).get(0);
        }
        return strArr;
    }
}
