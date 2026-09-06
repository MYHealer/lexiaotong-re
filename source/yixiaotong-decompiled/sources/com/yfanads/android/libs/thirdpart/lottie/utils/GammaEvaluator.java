package com.yfanads.android.libs.thirdpart.lottie.utils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class GammaEvaluator {
    private static float EOCF_sRGB(float f) {
        return f <= 0.04045f ? f / 12.92f : (float) Math.pow((f + 0.055f) / 1.055f, 2.4000000953674316d);
    }

    private static float OECF_sRGB(float f) {
        return f <= 0.0031308f ? f * 12.92f : (float) ((Math.pow(f, 0.4166666567325592d) * 1.0549999475479126d) - 0.054999999701976776d);
    }

    public static int evaluate(float f, int i, int i2) {
        float f2 = ((i >> 24) & 255) / 255.0f;
        float f3 = ((i2 >> 24) & 255) / 255.0f;
        float fEOCF_sRGB = EOCF_sRGB(((i >> 16) & 255) / 255.0f);
        float fEOCF_sRGB2 = EOCF_sRGB(((i >> 8) & 255) / 255.0f);
        float fEOCF_sRGB3 = EOCF_sRGB((i & 255) / 255.0f);
        float fEOCF_sRGB4 = EOCF_sRGB(((i2 >> 16) & 255) / 255.0f);
        float fEOCF_sRGB5 = ((EOCF_sRGB(((i2 >> 8) & 255) / 255.0f) - fEOCF_sRGB2) * f) + fEOCF_sRGB2;
        float fEOCF_sRGB6 = ((EOCF_sRGB((i2 & 255) / 255.0f) - fEOCF_sRGB3) * f) + fEOCF_sRGB3;
        float f4 = (((f3 - f2) * f) + f2) * 255.0f;
        return (Math.round(OECF_sRGB(((fEOCF_sRGB4 - fEOCF_sRGB) * f) + fEOCF_sRGB) * 255.0f) << 16) | (Math.round(f4) << 24) | (Math.round(OECF_sRGB(fEOCF_sRGB5) * 255.0f) << 8) | Math.round(OECF_sRGB(fEOCF_sRGB6) * 255.0f);
    }
}
