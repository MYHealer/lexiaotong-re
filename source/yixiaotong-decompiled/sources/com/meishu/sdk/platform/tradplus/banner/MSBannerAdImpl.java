package com.meishu.sdk.platform.tradplus.banner;

import android.view.View;
import android.view.ViewGroup;
import com.meishu.sdk.core.utils.o1;
import com.tradplus.ads.base.adapter.banner.TPBannerAdImpl;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class MSBannerAdImpl extends TPBannerAdImpl {
    private String[] eventUrl;
    private long loadedTime;
    private String posId;
    private boolean reportEventUrl;

    public MSBannerAdImpl(Object obj, View view) {
        super(obj, view);
        this.reportEventUrl = false;
    }

    public void setAdShown() {
        super/*com.tradplus.ads.base.bean.TPBaseAd*/.setAdShown();
        reportEventUrl();
    }

    public void setMsData(String str, long j, String[] strArr) {
        this.posId = str;
        this.loadedTime = j;
        this.eventUrl = strArr;
    }

    public MSBannerAdImpl(Object obj, View view, ViewGroup viewGroup) {
        super(obj, view, viewGroup);
        this.reportEventUrl = false;
    }

    private void reportEventUrl() {
        ViewGroup viewGroup;
        try {
            if (this.reportEventUrl) {
                return;
            }
            View renderView = getRenderView();
            if (renderView != null) {
                try {
                    viewGroup = (ViewGroup) renderView.getParent();
                } catch (Exception unused) {
                    viewGroup = null;
                }
            } else {
                viewGroup = null;
            }
            o1.a(viewGroup, this.posId, this.loadedTime);
            o1.b(this.eventUrl);
            this.reportEventUrl = true;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
