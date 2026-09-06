package com.huawei.openalliance.ad.beans.metadata;

import com.huawei.openalliance.ad.utils.bc;
import java.io.Serializable;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class PromoteInfo implements Serializable {
    private static final long serialVersionUID = 5783856735147861149L;
    private String name;
    private int type;

    public void Code(int i) {
        this.type = i;
    }

    public void Code(String str) {
        this.name = str;
    }

    public String getName() {
        return bc.V(this.name);
    }

    public int getType() {
        return this.type;
    }
}
