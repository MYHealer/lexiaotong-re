package com.huawei.hms.mlplugin.card.bcr;

/* JADX INFO: compiled from: AmericanExpress.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class j extends i {
    @Override // com.huawei.hms.mlplugin.card.bcr.i
    String a() {
        return "American Express";
    }

    @Override // com.huawei.hms.mlplugin.card.bcr.i
    boolean b(String str) {
        return str.matches("^\\d{15}$");
    }

    @Override // com.huawei.hms.mlplugin.card.bcr.i
    boolean c(String str) {
        return str.matches("^(34|37).*");
    }
}
