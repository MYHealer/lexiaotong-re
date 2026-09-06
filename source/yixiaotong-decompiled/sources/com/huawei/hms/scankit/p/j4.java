package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/* JADX INFO: compiled from: MultiFormatUPCEANReader.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class j4 extends o4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final s6[] f4287a;

    public j4(Map<f1, ?> map) {
        Collection collection = map == null ? null : (Collection) map.get(f1.POSSIBLE_FORMATS);
        ArrayList arrayList = new ArrayList();
        if (collection != null) {
            if (collection.contains(BarcodeFormat.EAN_13)) {
                arrayList.add(new e2());
            } else if (collection.contains(BarcodeFormat.UPC_A)) {
                arrayList.add(new n6());
            }
            if (collection.contains(BarcodeFormat.EAN_8)) {
                arrayList.add(new g2());
            }
            if (collection.contains(BarcodeFormat.UPC_E)) {
                arrayList.add(new u6());
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.add(new e2());
            arrayList.add(new g2());
            arrayList.add(new u6());
        }
        this.f4287a = (s6[]) arrayList.toArray(new s6[arrayList.size()]);
    }

    @Override // com.huawei.hms.scankit.p.o4
    public w5 a(int i, r rVar, Map<f1, ?> map) throws a {
        for (int[] iArr : s6.b(rVar)) {
            for (s6 s6Var : this.f4287a) {
                try {
                    w5 w5VarA = s6Var.a(i, rVar, iArr, map);
                    boolean z = w5VarA.c() == BarcodeFormat.EAN_13 && w5VarA.k().charAt(0) == '0';
                    Collection collection = map == null ? null : (Collection) map.get(f1.POSSIBLE_FORMATS);
                    return (z && (collection == null || collection.contains(BarcodeFormat.UPC_A))) ? new w5(w5VarA.k().substring(1), w5VarA.i(), w5VarA.j(), BarcodeFormat.UPC_A) : w5VarA;
                } catch (a unused) {
                }
            }
        }
        throw a.a();
    }
}
