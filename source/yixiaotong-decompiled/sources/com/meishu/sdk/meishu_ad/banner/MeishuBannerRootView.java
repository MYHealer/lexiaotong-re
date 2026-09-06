package com.meishu.sdk.meishu_ad.banner;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.meishu.sdk.core.utils.LogUtil;
import com.meishu.sdk.platform.ms.banner.c;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class MeishuBannerRootView extends RelativeLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f5003a;
    public c b;
    public boolean c;

    public MeishuBannerRootView(Context context) {
        super(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.view.View
    public void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        LogUtil.d("MeishuBannerRootView", "onVisibilityChanged: " + i + ", isShown: " + isShown() + ", isAdExposured: " + this.c);
        if (!this.c && i == 0 && isShown()) {
            this.c = true;
            LogUtil.d("MeishuBannerRootView", com.meishu.sdk.activity.a.a("adListener is not null: ").append(this.f5003a != null).toString());
            if (this.f5003a != null) {
                LogUtil.d("MeishuBannerRootView", "send onADExposure");
                ((com.meishu.sdk.platform.ms.banner.a) this.f5003a).onADExposure();
            }
            c cVar = this.b;
            if (cVar == null || cVar.getInteractionListener() == null) {
                return;
            }
            this.b.getInteractionListener().onAdExposure();
        }
    }

    public void setAdListener(b bVar) {
        this.f5003a = bVar;
    }

    public void setBannerAd(c cVar) {
        this.b = cVar;
    }

    public MeishuBannerRootView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MeishuBannerRootView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
