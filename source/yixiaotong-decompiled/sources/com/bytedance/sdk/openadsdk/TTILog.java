package com.bytedance.sdk.openadsdk;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public interface TTILog {
    void d(String str, String str2);

    void e(String str, String str2);

    void e(String str, String str2, Throwable th);

    void e(String str, Throwable th);

    void flush();

    void forceLogSharding();

    void i(String str, String str2);

    void v(String str, String str2);

    void w(String str, String str2);

    void w(String str, String str2, Throwable th);

    void w(String str, Throwable th);
}
