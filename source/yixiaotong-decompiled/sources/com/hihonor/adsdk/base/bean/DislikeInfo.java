package com.hihonor.adsdk.base.bean;

import android.text.TextUtils;
import com.hihonor.adsdk.base.NegativeFeedback;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class DislikeInfo {
    private int code;
    private int id;
    private String text;

    public DislikeInfo() {
    }

    public int getCode() {
        return this.code;
    }

    public int getId() {
        return this.id;
    }

    public String getText() {
        return this.text;
    }

    public void setId(int i) {
        this.id = i;
    }

    public DislikeInfo(String str) {
        setText(str);
    }

    public void setCode(int i) {
        this.code = i;
        NegativeFeedback[] negativeFeedbackArrValues = NegativeFeedback.values();
        for (int i2 = 0; i2 < 3; i2++) {
            NegativeFeedback negativeFeedback = negativeFeedbackArrValues[i2];
            if (negativeFeedback.getReason() == i) {
                this.text = negativeFeedback.getDesc();
            }
        }
    }

    public void setText(String str) {
        this.text = str;
        NegativeFeedback[] negativeFeedbackArrValues = NegativeFeedback.values();
        for (int i = 0; i < 3; i++) {
            NegativeFeedback negativeFeedback = negativeFeedbackArrValues[i];
            if (TextUtils.equals(negativeFeedback.getDesc(), str)) {
                this.code = negativeFeedback.getReason();
            }
        }
    }
}
