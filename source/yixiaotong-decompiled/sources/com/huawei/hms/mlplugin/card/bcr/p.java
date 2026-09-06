package com.huawei.hms.mlplugin.card.bcr;

/* JADX INFO: compiled from: MasterCard.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class p extends i {
    @Override // com.huawei.hms.mlplugin.card.bcr.i
    String a() {
        return "MasterCard";
    }

    @Override // com.huawei.hms.mlplugin.card.bcr.i
    boolean b(String str) {
        return str.matches("^\\d{16}$");
    }

    @Override // com.huawei.hms.mlplugin.card.bcr.i
    boolean c(String str) {
        return str.matches("^(5[1-5]|2[2-6][2-9][1-9]|27[0-1]\\d|2720).*");
    }
}
