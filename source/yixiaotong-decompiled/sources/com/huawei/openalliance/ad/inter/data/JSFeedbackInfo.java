package com.huawei.openalliance.ad.inter.data;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class JSFeedbackInfo extends FeedbackInfo {
    private String idStr;

    public JSFeedbackInfo(FeedbackInfo feedbackInfo) {
        if (feedbackInfo != null) {
            Code(feedbackInfo.I());
            Code(feedbackInfo.V());
            Code(feedbackInfo.Code());
            V(String.valueOf(feedbackInfo.I()));
        }
    }

    public String B() {
        return this.idStr;
    }

    public void V(String str) {
        this.idStr = str;
    }
}
