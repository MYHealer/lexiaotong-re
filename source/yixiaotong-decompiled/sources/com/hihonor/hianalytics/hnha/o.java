package com.hihonor.hianalytics.hnha;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
class o extends p {
    o() {
    }

    @Override // com.hihonor.hianalytics.hnha.p
    protected void c(String str) {
        u.a("sp_name_direct_boot_safe", true, "NewPrivacyDataDirect", str);
        u.a("sp_name_direct_boot_safe", true, "NewPrivacyTimeDirect", String.valueOf(System.currentTimeMillis()));
    }

    @Override // com.hihonor.hianalytics.hnha.p
    protected String e() {
        return u.a("sp_name_direct_boot_safe", true, "NewPrivacyDataDirect", "");
    }
}
