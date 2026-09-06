package com.byazt.six;

import android.webkit.WebResourceResponse;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 502, 20})
public class c {
    public WebResourceResponse c;
    public int tt = -1;

    public WebResourceResponse c() {
        return this.c;
    }

    public void c(int i) {
        this.tt = i;
    }

    public void c(WebResourceResponse webResourceResponse) {
        this.c = webResourceResponse;
    }

    public int getType() {
        return this.tt;
    }
}
