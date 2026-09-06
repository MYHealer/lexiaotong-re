package com.jd.ad.sdk.fdt.utils;

import com.huawei.openalliance.ad.constant.x;
import java.util.UUID;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class UUIDUtils {
    public static String uuid() {
        return UUID.randomUUID().toString().replace(x.A, "");
    }
}
