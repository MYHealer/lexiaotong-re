package com.kwad.components.offline.api.tk;

import com.kwad.components.offline.api.tk.model.StyleTemplate;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public interface TKDownloadListener {
    void onFailed(String str);

    void onSuccess(StyleTemplate styleTemplate);
}
