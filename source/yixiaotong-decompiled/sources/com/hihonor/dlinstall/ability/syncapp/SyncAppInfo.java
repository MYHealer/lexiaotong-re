package com.hihonor.dlinstall.ability.syncapp;

import android.text.TextUtils;
import java.io.Serializable;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public class SyncAppInfo implements Serializable {
    private static final long serialVersionUID = 1;
    public String checkSum;
    public long installTime;
    public String packageName;

    public SyncAppInfo(String str, String str2) {
        this.packageName = "";
        this.checkSum = "";
        this.installTime = 0L;
        if (!TextUtils.isEmpty(str)) {
            this.packageName = str;
        }
        this.checkSum = str2;
    }

    public SyncAppInfo(String str, String str2, long j) {
        this(str, str2);
        this.installTime = j;
    }
}
