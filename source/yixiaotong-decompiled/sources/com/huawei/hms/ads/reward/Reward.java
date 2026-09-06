package com.huawei.hms.ads.reward;

import com.huawei.hms.ads.ci;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public interface Reward {
    public static final Reward DEFAULT = new ci();

    int getAmount();

    String getName();
}
