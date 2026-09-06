package com.yfanads.android.core.textlink;

import android.content.Context;
import com.yfanads.android.core.i;
import com.yfanads.android.model.YFAdType;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class YFTextLinkAds extends i implements YFTextLinkSetting {
    private TLParams tlParams;

    public YFTextLinkAds(Context context, YFTextLinkListener yFTextLinkListener) {
        this(context, yFTextLinkListener, null);
    }

    @Override // com.yfanads.android.core.i
    public int getAType() {
        return 12;
    }

    @Override // com.yfanads.android.core.textlink.YFTextLinkSetting
    public TLParams getConfig() {
        return this.tlParams;
    }

    public void setTLParams(TLParams tLParams) {
        this.tlParams = tLParams;
    }

    public YFTextLinkAds(Context context, YFTextLinkListener yFTextLinkListener, TLParams tLParams) {
        super(context, yFTextLinkListener);
        this.tlParams = tLParams;
        setAdType(YFAdType.TEXTLINK);
    }
}
