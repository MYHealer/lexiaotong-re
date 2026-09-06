package com.byazt.il;

import java.util.Arrays;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
@com.byazt.zqa.c(c = {0, 1, 2411, 20})
public class c {
    public String c;
    public Object[] tt;

    public String c() {
        return this.c;
    }

    public void c(String str) {
        this.c = str;
    }

    public void c(Object[] objArr) {
        this.tt = objArr;
    }

    public Object[] tt() {
        return this.tt;
    }

    public String toString() {
        return "MethodResult{methodName='" + this.c + "', args=" + Arrays.toString(this.tt) + '}';
    }
}
