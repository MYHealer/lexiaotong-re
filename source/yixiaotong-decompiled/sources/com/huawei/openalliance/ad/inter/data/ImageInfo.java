package com.huawei.openalliance.ad.inter.data;

import android.text.TextUtils;
import com.huawei.openalliance.ad.constant.cf;
import java.io.Serializable;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class ImageInfo implements Serializable {
    private static final long serialVersionUID = 30414300;
    private boolean checkSha256;
    private int fileSize;
    private int height;
    private String imageType;
    private String originalUrl;
    private String sha256;
    private String url;
    private int width;

    public ImageInfo() {
        this.width = 0;
        this.height = 0;
    }

    public ImageInfo(com.huawei.openalliance.ad.beans.metadata.ImageInfo imageInfo) {
        this.width = 0;
        this.height = 0;
        if (imageInfo != null) {
            this.url = imageInfo.I();
            String strI = imageInfo.I();
            this.originalUrl = strI;
            if (!TextUtils.isEmpty(strI) && !this.originalUrl.startsWith(cf.HTTP.toString()) && !this.originalUrl.startsWith(cf.HTTPS.toString())) {
                this.originalUrl = imageInfo.F();
            }
            this.width = imageInfo.Z();
            this.height = imageInfo.B();
            this.sha256 = imageInfo.Code();
            this.imageType = imageInfo.V();
            this.fileSize = imageInfo.C();
            this.checkSha256 = imageInfo.S() == 0;
        }
    }

    public int B() {
        return this.height;
    }

    public int C() {
        return this.width;
    }

    public void Code(String str) {
        this.originalUrl = str;
    }

    public boolean Code() {
        String str = this.url;
        return str != null && str.startsWith(cf.CONTENT.toString());
    }

    public String D() {
        return this.originalUrl;
    }

    public int F() {
        return this.fileSize;
    }

    public String I() {
        return this.sha256;
    }

    public boolean S() {
        return this.checkSha256;
    }

    public String V() {
        return this.imageType;
    }

    public String Z() {
        return this.url;
    }
}
