package com.facebook.imageformat;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public enum ImageFormat {
    WEBP_SIMPLE,
    WEBP_LOSSLESS,
    WEBP_EXTENDED,
    WEBP_EXTENDED_WITH_ALPHA,
    WEBP_ANIMATED,
    JPEG,
    PNG,
    GIF,
    BMP,
    UNKNOWN;

    public static boolean isWebpFormat(ImageFormat imageFormat) {
        return imageFormat == WEBP_SIMPLE || imageFormat == WEBP_LOSSLESS || imageFormat == WEBP_EXTENDED || imageFormat == WEBP_EXTENDED_WITH_ALPHA || imageFormat == WEBP_ANIMATED;
    }
}
