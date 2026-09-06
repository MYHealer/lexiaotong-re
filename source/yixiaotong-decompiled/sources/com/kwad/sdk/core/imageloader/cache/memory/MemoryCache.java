package com.kwad.sdk.core.imageloader.cache.memory;

import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import java.util.Collection;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public interface MemoryCache {
    void clear();

    DecodedResult get(String str);

    Collection<String> keys();

    boolean put(String str, DecodedResult decodedResult);

    DecodedResult remove(String str);
}
