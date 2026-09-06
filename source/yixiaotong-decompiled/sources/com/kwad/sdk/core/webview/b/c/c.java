package com.kwad.sdk.core.webview.b.c;

import com.google.android.exoplayer2.util.MimeTypes;
import com.huawei.openalliance.ad.constant.bj;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class c {
    private static final List<String> bcW;

    static {
        ArrayList arrayList = new ArrayList();
        bcW = arrayList;
        arrayList.add("application/x-javascript");
        arrayList.add("image/jpeg");
        arrayList.add("image/tiff");
        arrayList.add("text/css");
        arrayList.add("text/html");
        arrayList.add(bj.B);
        arrayList.add(bj.Z);
        arrayList.add("application/javascript");
        arrayList.add("video/mp4");
        arrayList.add(MimeTypes.AUDIO_MPEG);
        arrayList.add("application/json");
        arrayList.add("image/webp");
        arrayList.add("image/apng");
        arrayList.add("image/svg+xml");
        arrayList.add("application/octet-stream");
    }

    public static boolean fU(String str) {
        return bcW.contains(str);
    }
}
