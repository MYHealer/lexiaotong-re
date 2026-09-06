package com.meishu.sdk.core.utils;

import java.util.Comparator;

/* JADX INFO: compiled from: CheckAppInstallHelper.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class e implements Comparator<PackageBean.AppBean.PackBean> {
    public e(d dVar) {
    }

    @Override // java.util.Comparator
    public int compare(PackageBean.AppBean.PackBean packBean, PackageBean.AppBean.PackBean packBean2) {
        PackageBean.AppBean.PackBean packBean3 = packBean;
        PackageBean.AppBean.PackBean packBean4 = packBean2;
        if (packBean3.getExpirationTime() == packBean4.getExpirationTime()) {
            return 0;
        }
        return packBean3.getExpirationTime() > packBean4.getExpirationTime() ? 1 : -1;
    }
}
