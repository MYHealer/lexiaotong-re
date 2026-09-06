package com.heytap.mspsdk.log;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public interface ILog {
    void d(String str, String str2);

    void d(String str, String str2, Throwable th);

    void e(String str, String str2);

    void e(String str, String str2, Throwable th);

    void i(String str, String str2);

    void i(String str, String str2, Throwable th);

    void log(int i, String str, String str2);

    void log(int i, String str, String str2, boolean z);

    void v(String str, String str2);

    void v(String str, String str2, Throwable th);

    void w(String str, String str2);

    void w(String str, String str2, Throwable th);
}
