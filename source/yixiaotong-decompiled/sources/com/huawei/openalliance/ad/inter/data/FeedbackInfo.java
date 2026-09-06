package com.huawei.openalliance.ad.inter.data;

import android.text.TextUtils;
import java.io.Serializable;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class FeedbackInfo implements Serializable {
    private static final long serialVersionUID = 30456300;
    private long id;
    private String label;
    private int type;

    public String Code() {
        return this.label;
    }

    public void Code(int i) {
        this.type = i;
    }

    public void Code(long j) {
        this.id = j;
    }

    public void Code(String str) {
        this.label = str;
    }

    public long I() {
        return this.id;
    }

    public int V() {
        return this.type;
    }

    public boolean Z() {
        int i;
        return !TextUtils.isEmpty(this.label) && ((i = this.type) == 1 || i == 2 || i == 3);
    }
}
