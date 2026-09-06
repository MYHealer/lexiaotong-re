package com.kwad.components.offline.api.core.downloader;

import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public interface ResourceDownloader {
    int download(List<String> list, String str, String str2, DownloadListener downloadListener, boolean z, boolean z2);

    void startImmediately(int i);
}
