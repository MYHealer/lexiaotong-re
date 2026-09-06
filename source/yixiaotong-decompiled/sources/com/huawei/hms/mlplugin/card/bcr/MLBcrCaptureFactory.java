package com.huawei.hms.mlplugin.card.bcr;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class MLBcrCaptureFactory {
    MLBcrCaptureFactory() {
    }

    public static MLBcrCaptureFactory getInstance() {
        return new MLBcrCaptureFactory();
    }

    public MLBcrCapture getBcrCapture(MLBcrCaptureConfig mLBcrCaptureConfig) {
        MLBcrCapture mLBcrCaptureC = MLBcrCapture.c();
        mLBcrCaptureC.a(mLBcrCaptureConfig);
        return mLBcrCaptureC;
    }
}
