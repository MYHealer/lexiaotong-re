package com.hihonor.adsdk.base;

import android.text.TextUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public enum NegativeFeedback {
    NOT_INTERESTED(5, HnAds.get().getContext() == null ? "" : HnAds.get().getContext().getResources().getString(R.string.ads_dislike_not_interested)),
    POOR_QUALITY_CONTENT(6, HnAds.get().getContext() == null ? "" : HnAds.get().getContext().getResources().getString(R.string.ads_dislike_poor_quality_content)),
    POOR_CANCEL(99, HnAds.get().getContext() != null ? HnAds.get().getContext().getResources().getString(R.string.ads_dislike_cancel) : "");

    private final String desc;
    private final int reason;

    NegativeFeedback(int i, String str) {
        this.reason = i;
        this.desc = str;
    }

    public String getDesc() {
        return this.desc;
    }

    public int getReason() {
        return this.reason;
    }

    @Override // java.lang.Enum
    public String toString() {
        return "NegativeFeedback{reason=" + this.reason + ", desc='" + this.desc + "'}";
    }

    public static NegativeFeedback getNegativeFeedbackByCode(int i) {
        NegativeFeedback negativeFeedback = NOT_INTERESTED;
        NegativeFeedback[] negativeFeedbackArrValues = values();
        for (int i2 = 0; i2 < 3; i2++) {
            NegativeFeedback negativeFeedback2 = negativeFeedbackArrValues[i2];
            if (i == negativeFeedback2.reason) {
                return negativeFeedback2;
            }
        }
        return negativeFeedback;
    }

    public static NegativeFeedback getNegativeFeedbackByDesc(String str) {
        NegativeFeedback negativeFeedback = NOT_INTERESTED;
        NegativeFeedback[] negativeFeedbackArrValues = values();
        for (int i = 0; i < 3; i++) {
            NegativeFeedback negativeFeedback2 = negativeFeedbackArrValues[i];
            if (TextUtils.equals(str, negativeFeedback2.desc)) {
                return negativeFeedback2;
            }
        }
        return negativeFeedback;
    }
}
