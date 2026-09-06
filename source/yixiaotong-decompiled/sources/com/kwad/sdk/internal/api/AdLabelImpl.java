package com.kwad.sdk.internal.api;

import android.text.TextUtils;
import java.io.Serializable;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class AdLabelImpl extends com.kwad.sdk.core.response.a.a implements Serializable {
    private static final long serialVersionUID = -4055679938174214490L;
    public String channel;
    public long cpmBidFloor;
    public String historyTitle;
    public String postTitle;
    public String prevTitle;
    public int thirdAge;
    public int thirdGender;
    public String thirdInterest;

    public boolean isUserInfoVaild() {
        return this.thirdAge == 0 && this.thirdGender == 0 && TextUtils.isEmpty(this.thirdInterest);
    }

    public boolean isAdLabelAppInfoInValid() {
        return TextUtils.isEmpty(this.prevTitle) && TextUtils.isEmpty(this.postTitle) && TextUtils.isEmpty(this.channel) && TextUtils.isEmpty(this.historyTitle);
    }
}
