package com.hihonor.dlinstall;

import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class AppShelfStatus {
    public boolean isOnline;
    public boolean isOnlineMaxVersion;
    public String packageName;
    public List<String> supportedCountryList;

    public AppShelfStatus(String str, boolean z, boolean z2, List<String> list) {
        this.packageName = str;
        this.isOnline = z;
        this.isOnlineMaxVersion = z2;
        this.supportedCountryList = list;
    }
}
