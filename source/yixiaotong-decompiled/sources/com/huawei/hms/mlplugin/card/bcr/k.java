package com.huawei.hms.mlplugin.card.bcr;

/* JADX INFO: compiled from: ChinaTUnion.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class k extends i {
    @Override // com.huawei.hms.mlplugin.card.bcr.i
    String a() {
        return "China T-Union";
    }

    @Override // com.huawei.hms.mlplugin.card.bcr.i
    boolean b(String str) {
        return str.matches("^\\d{19}$");
    }

    @Override // com.huawei.hms.mlplugin.card.bcr.i
    boolean c(String str) {
        return str.matches("^(31).*");
    }
}
