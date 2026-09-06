package com.yfanads.android.adx.newplayer.videocache.headers;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class EmptyHeadersInjector implements HeaderInjector {
    @Override // com.yfanads.android.adx.newplayer.videocache.headers.HeaderInjector
    public Map<String, String> addHeaders(String str) {
        return new HashMap();
    }
}
