package com.huawei.hms.ads.jsb.inner.data;

import android.text.TextUtils;
import com.huawei.openalliance.ad.constant.cf;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class ImageInfo {
    private int fileSize;
    private int height;
    private String imageType;
    private String url;
    private int width;

    public ImageInfo(com.huawei.openalliance.ad.beans.metadata.ImageInfo imageInfo) {
        this.width = 0;
        this.height = 0;
        if (imageInfo != null) {
            String strI = imageInfo.I();
            this.url = strI;
            if (!TextUtils.isEmpty(strI) && !this.url.startsWith(cf.HTTP.toString()) && !this.url.startsWith(cf.HTTPS.toString())) {
                this.url = imageInfo.F();
            }
            this.width = imageInfo.Z();
            this.height = imageInfo.B();
            this.imageType = imageInfo.V();
            this.fileSize = imageInfo.C();
        }
    }
}
