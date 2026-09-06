package com.baidu.passbqt.http;

import com.baidu.passbqt.NoProguard;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
public class HttpErrorException extends Exception implements NoProguard {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1925a;

    public HttpErrorException() {
    }

    public HttpErrorException(int i, String str) {
        super(str);
        this.f1925a = i;
    }
}
