package com.hihonor.adsdk.common.video;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class f {
    private static final String hnadsa = "VideoUtils";

    public static AdVideoSize hnadsa(AdVideoSize adVideoSize, int i, int i2) {
        if (adVideoSize == null) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "getPlayWindowSize,sourceSize is null", new Object[0]);
            return null;
        }
        int width = adVideoSize.getWidth();
        int height = adVideoSize.getHeight();
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "getPlayWindowSize,sourceWidth: " + width + ",sourceHeight: " + height + ",adaptSizeBaseMode: " + i + ",baseSize: " + i2, new Object[0]);
        AdVideoSize adVideoSize2 = new AdVideoSize();
        if (width <= 0 || height <= 0 || i2 <= 0) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "getPlayWindowSize,source video size is invalid!!!", new Object[0]);
            return null;
        }
        if (i == 1) {
            float f = width / height;
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "getPlayWindowSize,horizontal videoRatio:" + f, new Object[0]);
            adVideoSize2 = new AdVideoSize(i2, (int) (i2 / f));
        } else if (i == 2) {
            float f2 = height / width;
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "getPlayWindowSize,vertical videoRatio:" + f2, new Object[0]);
            adVideoSize2 = new AdVideoSize((int) (i2 / f2), i2);
        }
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "getPlayWindowSize,final size,width: " + adVideoSize2.getWidth() + ",height: " + adVideoSize2.getHeight(), new Object[0]);
        return adVideoSize2;
    }
}
