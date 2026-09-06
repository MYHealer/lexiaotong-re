package com.kwad.framework.filedownloader.a;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public interface b {
    Map<String, List<String>> BO();

    Map<String, List<String>> BP();

    void BQ();

    void addHeader(String str, String str2);

    String bW(String str);

    void execute();

    InputStream getInputStream();

    int getResponseCode();
}
