package com.bykv.vk.component.ttvideo.mediakit.fetcher;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public interface AVMDLURLFetcherInterface {
    void close();

    String[] getURLs();

    int start(String str, String str2, String str3, AVMDLURLFetcherListener aVMDLURLFetcherListener);
}
