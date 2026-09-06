package com.bykv.vk.component.ttvideo.utils;

import java.net.URL;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public class URLBuilder {
    private static final String TAG = "URLBuilder";

    public static final URL build(String str) {
        try {
            return new URL(str);
        } catch (Exception unused) {
            return null;
        }
    }
}
