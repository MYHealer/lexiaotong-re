package com.gnete.upbc.cashier.b;

/* JADX INFO: compiled from: NetworkType.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public enum h implements d {
    MOBILE("MOBILE", "移动网络"),
    WIFI("WIFI", "WIFI"),
    UNKNOWN("UNKNOWN", "未知");


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f3277a;
    private final String b;

    h(String str, String str2) {
        this.f3277a = str;
        this.b = str2;
    }

    @Override // com.gnete.upbc.cashier.b.d
    public int a() {
        return 0;
    }

    @Override // com.gnete.upbc.cashier.b.d
    public String b() {
        return this.b;
    }

    public String c() {
        return this.f3277a;
    }
}
