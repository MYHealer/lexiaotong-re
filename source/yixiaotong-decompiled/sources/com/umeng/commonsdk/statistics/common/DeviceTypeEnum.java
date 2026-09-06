package com.umeng.commonsdk.statistics.common;

import com.unionpay.tsmservice.mi.data.Constant;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public enum DeviceTypeEnum {
    IMEI("imei", "imei"),
    OAID("oaid", "oaid"),
    ANDROIDID("android_id", "android_id"),
    MAC(Constant.KEY_MAC, Constant.KEY_MAC),
    SERIALNO("serial_no", "serial_no"),
    IDFA("idfa", "idfa"),
    DEFAULT("null", "null");

    private String description;
    private String deviceIdType;

    public String getDescription() {
        return this.description;
    }

    public String getDeviceIdType() {
        return this.deviceIdType;
    }

    DeviceTypeEnum(String str, String str2) {
        this.deviceIdType = str;
        this.description = str2;
    }
}
