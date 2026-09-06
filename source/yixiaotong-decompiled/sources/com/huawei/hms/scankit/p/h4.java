package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/* JADX INFO: compiled from: MultiFormatOneDReader.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class h4 extends o4 {
    private static final o4[] b = new o4[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final o4[] f4269a;

    public h4(Map<f1, ?> map) {
        Collection collection = map == null ? null : (Collection) map.get(f1.POSSIBLE_FORMATS);
        ArrayList arrayList = new ArrayList();
        if (collection != null) {
            if (collection.contains(BarcodeFormat.EAN_13) || collection.contains(BarcodeFormat.UPC_A) || collection.contains(BarcodeFormat.EAN_8) || collection.contains(BarcodeFormat.UPC_E)) {
                arrayList.add(new j4(map));
            }
            if (collection.contains(BarcodeFormat.CODE_39)) {
                arrayList.add(new q0(false));
            }
            if (collection.contains(BarcodeFormat.CODE_93)) {
                arrayList.add(new s0());
            }
            if (collection.contains(BarcodeFormat.CODE_128)) {
                arrayList.add(new o0());
            }
            if (collection.contains(BarcodeFormat.ITF)) {
                arrayList.add(new s3());
            }
            if (collection.contains(BarcodeFormat.CODABAR)) {
                arrayList.add(new m0());
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.add(new j4(map));
            arrayList.add(new q0());
            arrayList.add(new m0());
            arrayList.add(new s0());
            arrayList.add(new o0());
            arrayList.add(new s3());
        }
        this.f4269a = (o4[]) arrayList.toArray(b);
    }

    @Override // com.huawei.hms.scankit.p.o4
    public w5 a(int i, r rVar, Map<f1, ?> map) throws a {
        for (o4 o4Var : this.f4269a) {
            try {
                return o4Var.a(i, rVar, map);
            } catch (a unused) {
            }
        }
        throw a.a();
    }
}
