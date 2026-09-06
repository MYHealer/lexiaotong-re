package com.kwad.sdk.core.imageloader;

import com.kwad.sdk.core.d.c;
import com.kwad.sdk.utils.ai;
import com.kwad.sdk.utils.bi;
import com.kwad.sdk.utils.i;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class ImageLoaderPerfUtil {
    private static final String TAG = "ImageLoaderPerfUtil";

    public static ImageLoaderInfo getInfo() {
        ImageLoaderInfo imageLoaderInfo = new ImageLoaderInfo();
        imageLoaderInfo.totalCount = ai.VB();
        imageLoaderInfo.successCount = ai.VC();
        imageLoaderInfo.failedCount = ai.VD();
        imageLoaderInfo.duration = ai.Vz();
        return imageLoaderInfo;
    }

    public static void report() {
        i.execute(new bi() { // from class: com.kwad.sdk.core.imageloader.ImageLoaderPerfUtil.1
            @Override // com.kwad.sdk.utils.bi
            public void doTask() {
                ImageLoaderInfo info = ImageLoaderPerfUtil.getInfo();
                if (info.totalCount == 0) {
                    c.w(ImageLoaderPerfUtil.TAG, "info.totalCount == 0");
                } else {
                    c.d(ImageLoaderPerfUtil.TAG, "ImageLoaderInfo:" + info.toJson().toString());
                    com.kwad.sdk.commercial.c.r(info);
                }
            }
        });
    }
}
