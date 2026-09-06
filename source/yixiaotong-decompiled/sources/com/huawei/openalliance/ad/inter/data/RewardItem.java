package com.huawei.openalliance.ad.inter.data;

import com.huawei.openalliance.ad.utils.bc;
import java.io.Serializable;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class RewardItem implements Serializable {
    private static final long serialVersionUID = 30424300;
    int amount;
    String type;

    public RewardItem(String str, int i) {
        this.type = bc.V(str);
        this.amount = i;
    }

    public String Code() {
        return this.type;
    }

    public void Code(int i) {
        this.amount = i;
    }

    public void Code(String str) {
        this.type = str;
    }

    public int V() {
        return this.amount;
    }
}
