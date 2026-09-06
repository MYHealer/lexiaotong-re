package com.meishu.sdk.platform.custom.recycler;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.meishu.sdk.core.ad.a;
import com.meishu.sdk.core.ad.recycler.DownloadStatusListener;
import com.meishu.sdk.core.ad.recycler.ExpressMediaListener;
import com.meishu.sdk.core.ad.recycler.RecyclerAdData;
import com.meishu.sdk.core.ad.recycler.RecyclerAdMediaListener;
import com.meishu.sdk.core.ad.recycler.RecylcerAdInteractionListener;
import com.meishu.sdk.core.ad.recycler.d;
import com.meishu.sdk.core.domain.MeishuAdInfo;
import com.meishu.sdk.core.utils.o1;
import com.meishu.sdk.core.view.TouchAdContainer;
import com.meishu.sdk.core.view.TouchPositionListener;
import com.meishu.sdk.platform.ms.recycler.MsCustomVideo;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public abstract class MsCustomRecyclerFeedAd extends a implements RecyclerAdData {
    private MsCustomRecyclerAdapter adWrapper;
    private boolean hasExposed;
    private final Class<? extends ViewGroup> initAdContainer;
    private RecylcerAdInteractionListener recylcerAdInteractionListener;

    public MsCustomRecyclerFeedAd(MsCustomRecyclerAdapter msCustomRecyclerAdapter) {
        this(msCustomRecyclerAdapter, null);
    }

    private ViewGroup getInitAdContainer(Class<?> cls, Context context) {
        if (cls == null) {
            return null;
        }
        try {
            Constructor<?> constructor = cls.getConstructor(Context.class);
            constructor.setAccessible(true);
            return (ViewGroup) constructor.newInstance(context);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public abstract void bindAdToView(Context context, ViewGroup viewGroup, List<View> list);

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v3, types: [android.view.ViewGroup] */
    /* JADX WARN: Type inference failed for: r10v4, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r10v5, types: [android.view.ViewGroup] */
    /* JADX WARN: Type inference failed for: r10v6 */
    /* JADX WARN: Type inference failed for: r10v7, types: [android.view.View, android.view.ViewGroup] */
    /* JADX WARN: Type inference failed for: r10v9 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r2v3, types: [android.view.View, android.widget.FrameLayout, com.meishu.sdk.core.view.TouchAdContainer] */
    /* JADX WARN: Type inference failed for: r3v3, types: [android.view.View, android.view.ViewGroup] */
    /* JADX WARN: Type inference failed for: r6v0, types: [com.meishu.sdk.core.ad.IAd, com.meishu.sdk.platform.custom.recycler.MsCustomRecyclerFeedAd, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v1, types: [android.view.ViewGroup[]] */
    /* JADX WARN: Type inference failed for: r8v11, types: [android.view.ViewGroup] */
    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public void bindAdToView(Context context, ViewGroup viewGroup, List<View> list, RecylcerAdInteractionListener recylcerAdInteractionListener) {
        MsCustomRecyclerAdapter msCustomRecyclerAdapter = this.adWrapper;
        if (msCustomRecyclerAdapter != null && msCustomRecyclerAdapter.getSdkAdInfo() != null) {
            o1.b(this.adWrapper.getSdkAdInfo().getEventUrl());
        }
        this.recylcerAdInteractionListener = recylcerAdInteractionListener;
        ?? A = d.a(viewGroup, getClass(), TouchAdContainer.class);
        ?? r10 = A[1];
        ?? r1 = 0;
        r1 = 0;
        r1 = 0;
        r1 = 0;
        r1 = 0;
        if (r10 == 0) {
            r10 = A[0];
            ?? r8 = (ViewGroup) r10.getParent();
            if (r8 != 0) {
                int iIndexOfChild = r8.indexOfChild(r10);
                ViewGroup.LayoutParams layoutParams = r10.getLayoutParams();
                r8.removeView(r10);
                ?? touchAdContainer = new TouchAdContainer(r10.getContext());
                touchAdContainer.setTouchPositionListener(new TouchPositionListener(this));
                ?? initAdContainer = getInitAdContainer(this.initAdContainer, r10.getContext());
                if (initAdContainer == 0) {
                    touchAdContainer.addView(r10, new ViewGroup.LayoutParams(-1, -1));
                } else {
                    touchAdContainer.addView(initAdContainer, new ViewGroup.LayoutParams(-1, -1));
                    initAdContainer.addView(r10, new ViewGroup.LayoutParams(-1, -1));
                }
                touchAdContainer.setId(r10.getId());
                r8.addView(touchAdContainer, iIndexOfChild, layoutParams);
                r10 = touchAdContainer;
                r1 = initAdContainer;
            }
        } else {
            if (r10 instanceof TouchAdContainer) {
                ((TouchAdContainer) r10).setTouchPositionListener(new TouchPositionListener(this));
            }
            if (r10 != 0) {
                try {
                    Class<? extends ViewGroup> cls = this.initAdContainer;
                    if (cls != null && cls.isAssignableFrom(r10.getChildAt(0).getClass())) {
                        r1 = (ViewGroup) r10.getChildAt(0);
                    }
                } catch (Exception unused) {
                }
            }
        }
        ArrayList arrayList = new ArrayList(list);
        arrayList.add(r10);
        if (r1 != 0) {
            arrayList.add(r1);
        }
        if (r1 != 0) {
            r10 = r1;
        }
        bindAdToView(context, r10, arrayList);
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public void bindMediaView(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, int i, int i2, RecyclerAdMediaListener recyclerAdMediaListener) {
    }

    public MsCustomRecyclerAdapter getAdWraper() {
        return this.adWrapper;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getAppIntro() {
        return null;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getAppIntroUrl() {
        return null;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public List<MeishuAdInfo.PermissionBean> getAppPermissionList() {
        return null;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getAppPremissionUrl() {
        return null;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getAppSize() {
        return null;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getAppVersion() {
        return null;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public MsCustomVideo getCustomVideo() {
        return null;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getDeveloper() {
        return null;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public View getMediaView() {
        return null;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getPlatFormEcpm() {
        return null;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getPlatform() {
        return null;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getPrivacyAgreement() {
        return null;
    }

    public RecylcerAdInteractionListener getRecylcerAdInteractionListener() {
        return this.recylcerAdInteractionListener;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getVideoCover() {
        return "";
    }

    public boolean isHasExposed() {
        return this.hasExposed;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public void setDownloadStatusListener(DownloadStatusListener downloadStatusListener) {
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public void setExpressMediaListener(ExpressMediaListener expressMediaListener) {
    }

    public void setHasExposed(boolean z) {
        this.hasExposed = z;
    }

    public MsCustomRecyclerFeedAd(MsCustomRecyclerAdapter msCustomRecyclerAdapter, Class<? extends ViewGroup> cls) {
        this(msCustomRecyclerAdapter, cls, "CUSTOM");
    }

    public MsCustomRecyclerFeedAd(MsCustomRecyclerAdapter msCustomRecyclerAdapter, Class<? extends ViewGroup> cls, String str) {
        super(msCustomRecyclerAdapter, str);
        this.adWrapper = msCustomRecyclerAdapter;
        this.initAdContainer = cls;
    }
}
