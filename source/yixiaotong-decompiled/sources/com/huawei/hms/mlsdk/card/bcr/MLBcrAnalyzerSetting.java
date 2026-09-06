package com.huawei.hms.mlsdk.card.bcr;

import android.text.TextUtils;
import java.util.Arrays;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class MLBcrAnalyzerSetting {
    private final String langType;
    private final int recMode;
    private final int recType;
    private final int resultType;

    /* JADX INFO: renamed from: com.huawei.hms.mlsdk.card.bcr.MLBcrAnalyzerSetting$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public final String getLangType() {
        return this.langType;
    }

    public final int getRecMode() {
        return this.recMode;
    }

    public final int getRecType() {
        return this.recType;
    }

    public final int getResultType() {
        return this.resultType;
    }

    /* synthetic */ MLBcrAnalyzerSetting(String str, int i, int i2, int i3, AnonymousClass1 anonymousClass1) {
        this(str, i, i2, i3);
    }

    private MLBcrAnalyzerSetting(String str, int i, int i2, int i3) {
        this.langType = str;
        this.recType = i;
        this.recMode = i2;
        this.resultType = i3;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof MLBcrAnalyzerSetting)) {
            return false;
        }
        MLBcrAnalyzerSetting mLBcrAnalyzerSetting = (MLBcrAnalyzerSetting) obj;
        return TextUtils.equals(mLBcrAnalyzerSetting.langType, this.langType) && mLBcrAnalyzerSetting.recType == this.recType && mLBcrAnalyzerSetting.recMode == this.recMode && mLBcrAnalyzerSetting.resultType == this.resultType;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.langType, Integer.valueOf(this.recType), Integer.valueOf(this.recMode), Integer.valueOf(this.resultType)});
    }

    public static class Factory {
        private String langType = "zh";
        private int recType = 0;
        private int recMode = 1;
        private int resultType = 1;

        public Factory setLangType(String str) {
            this.langType = str;
            return this;
        }

        public Factory setRecMode(int i) {
            this.recMode = i;
            return this;
        }

        public Factory setRecType(int i) {
            this.recType = i;
            return this;
        }

        public Factory setResultType(int i) {
            this.resultType = i;
            return this;
        }

        public MLBcrAnalyzerSetting create() {
            return new MLBcrAnalyzerSetting(this.langType, this.recType, this.recMode, this.resultType, null);
        }
    }
}
