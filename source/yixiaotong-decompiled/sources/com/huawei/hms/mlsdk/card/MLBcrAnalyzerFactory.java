package com.huawei.hms.mlsdk.card;

import com.huawei.hms.mlsdk.card.bcr.MLBcrAnalyzer;
import com.huawei.hms.mlsdk.card.bcr.MLBcrAnalyzerSetting;
import com.huawei.hms.mlsdk.common.MLApplication;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class MLBcrAnalyzerFactory {
    private static MLBcrAnalyzerSetting bcrSetting = new MLBcrAnalyzerSetting.Factory().create();
    private final MLApplication application;

    public static MLBcrAnalyzerFactory getInstance() {
        return getInstance(MLApplication.getInstance());
    }

    public static MLBcrAnalyzerFactory getInstance(MLApplication mLApplication) {
        return new MLBcrAnalyzerFactory(mLApplication);
    }

    public MLBcrAnalyzer getBcrAnalyzer() {
        return MLBcrAnalyzer.create(this.application, bcrSetting);
    }

    public MLBcrAnalyzer getBcrAnalyzer(MLBcrAnalyzerSetting mLBcrAnalyzerSetting) {
        return MLBcrAnalyzer.create(this.application, mLBcrAnalyzerSetting);
    }

    MLBcrAnalyzerFactory(MLApplication mLApplication) {
        this.application = mLApplication;
    }
}
