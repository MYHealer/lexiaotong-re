package com.yfanads.android.utils.log;

import java.util.Date;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class LogFileBean {
    public int level;
    public String msg;
    public String tag;
    public Date time = new Date();

    public LogFileBean(int i, String str, String str2) {
        this.level = i;
        this.tag = str;
        this.msg = str2;
    }
}
