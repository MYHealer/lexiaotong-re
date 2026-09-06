package com.huawei.hms.scankit.p;

import com.huawei.hms.ml.scan.HmsScan;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: LocationCoordinateResultParser.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class w3 extends x5 {
    private static final Pattern g = Pattern.compile("geo:([\\s\\-0-9.]+),([\\s\\-0-9.]+)(?:[,?].*)?", 2);

    @Override // com.huawei.hms.scankit.p.x5
    public HmsScan b(w5 w5Var) {
        String strA = x5.a(w5Var);
        Matcher matcher = g.matcher(strA);
        if (!matcher.matches()) {
            return null;
        }
        try {
            return new HmsScan(w5Var.k(), x5.a(w5Var.c()), strA, HmsScan.LOCATION_COORDINATE_FORM, w5Var.i(), x5.a(w5Var.j()), null, new c6(new HmsScan.LocationCoordinate(Double.parseDouble(matcher.group(1)), Double.parseDouble(matcher.group(2)))));
        } catch (NumberFormatException unused) {
            return null;
        }
    }
}
