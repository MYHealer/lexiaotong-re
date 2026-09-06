package com.airbnb.lottie;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public interface LottieLogger {
    void debug(String str);

    void debug(String str, Throwable th);

    void error(String str, Throwable th);

    void warning(String str);

    void warning(String str, Throwable th);
}
