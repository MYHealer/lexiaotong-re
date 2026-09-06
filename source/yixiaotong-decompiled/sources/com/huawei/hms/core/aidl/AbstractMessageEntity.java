package com.huawei.hms.core.aidl;

import com.huawei.hms.core.aidl.annotation.Packed;
import com.huawei.hms.support.api.client.Status;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class AbstractMessageEntity implements IMessageEntity {

    @Packed
    private Status commonStatus;

    public Status getCommonStatus() {
        return this.commonStatus;
    }

    public void setCommonStatus(Status status) {
        this.commonStatus = status;
    }
}
