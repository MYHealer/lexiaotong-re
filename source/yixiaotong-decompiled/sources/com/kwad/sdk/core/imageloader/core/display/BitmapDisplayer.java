package com.kwad.sdk.core.imageloader.core.display;

import com.kwad.sdk.core.imageloader.core.assist.LoadedFrom;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.imageaware.ImageAware;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public interface BitmapDisplayer {
    void display(DecodedResult decodedResult, ImageAware imageAware, LoadedFrom loadedFrom);
}
