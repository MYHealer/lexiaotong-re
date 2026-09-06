package com.gnete.upbc.cashier.b;

/* JADX INFO: compiled from: MonitorType.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public enum g implements d {
    LOG("LOG", "用户操作日志"),
    NORMAL("NORMAL", "普通异常"),
    CRASH("CRASH", "严重异常");


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f3276a;
    private final String b;

    g(String str, String str2) {
        this.f3276a = str;
        this.b = str2;
    }

    public static g a(String str) {
        for (g gVar : values()) {
            if (gVar.c().equals(str)) {
                return gVar;
            }
        }
        return CRASH;
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
        return this.f3276a;
    }
}
