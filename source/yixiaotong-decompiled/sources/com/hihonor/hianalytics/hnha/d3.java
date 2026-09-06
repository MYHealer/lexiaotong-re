package com.hihonor.hianalytics.hnha;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public class d3 extends o1 {
    private final String b;

    public d3(String str) {
        this.b = str;
    }

    @Override // com.hihonor.hianalytics.hnha.o1
    protected boolean a() {
        boolean z;
        boolean zA = super.a();
        if (zA) {
            boolean zI = u.i();
            boolean zB = false;
            if (zI) {
                z = false;
            } else {
                com.hihonor.hianalytics.util.a aVarB = com.hihonor.hianalytics.util.g.b();
                boolean zA2 = aVarB.a("isEnableReportData", true);
                u.b(zA2);
                if (aVarB.a("isEnableOwnDataReport")) {
                    zB = aVarB.b("isEnableOwnDataReport");
                    u.a(zB);
                }
                u.c(true);
                z = zB;
                zB = zA2;
            }
            j2.a("NewInitInfoV2support", "checkInitGlobalParam updateMarkNum=" + k.a().j() + ",isGlobalMigrateEnd=" + zI + ",isAutoEventReport=" + p2.d().i() + ",isEnableReport=" + zB + ",isOwnReport=" + z + ",isStatSuccess=" + k.a().k());
        }
        p2.d().f();
        return zA;
    }

    @Override // com.hihonor.hianalytics.hnha.o1
    protected void f() {
        com.hihonor.hianalytics.module.a.b(this.b);
        p2.e().d();
    }
}
