package com.meishu.sdk.platform.gdt.recycler;

import android.text.TextUtils;
import android.view.ViewGroup;
import com.meishu.sdk.core.ad.recycler.RecyclerAdData;
import com.meishu.sdk.core.ad.recycler.RecylcerAdInteractionListener;
import com.meishu.sdk.core.utils.LogUtil;
import com.meishu.sdk.core.utils.f;
import com.meishu.sdk.core.utils.h0;
import com.meishu.sdk.core.utils.i;
import com.meishu.sdk.core.utils.z;
import com.meishu.sdk.platform.gdt.GDTPlatformError;
import com.qq.e.ads.nativ.NativeExpressAD;
import com.qq.e.ads.nativ.NativeExpressADView;
import com.qq.e.comm.util.AdError;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class GDTExpressAdListenerAdapter implements NativeExpressAD.NativeExpressADListener {
    private static final String TAG = "GDTExpressAdListenerAdapter";
    private List<RecyclerAdData> adDataList;
    private GDTRecyclerAdWrapper adWrapper;
    private List<NativeExpressADView> list;

    public GDTExpressAdListenerAdapter(GDTRecyclerAdWrapper gDTRecyclerAdWrapper) {
        this.adWrapper = gDTRecyclerAdWrapper;
    }

    public List<NativeExpressADView> getAdList() {
        return this.list;
    }

    @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
    public void onADClicked(NativeExpressADView nativeExpressADView) {
        try {
            for (RecyclerAdData recyclerAdData : this.adDataList) {
                if (recyclerAdData.getAdView() == nativeExpressADView) {
                    GDTExpressRecyclerAdData gDTExpressRecyclerAdData = (GDTExpressRecyclerAdData) recyclerAdData;
                    RecylcerAdInteractionListener recylcerAdInteractionListener = ((GDTExpressRecyclerAdData) recyclerAdData).getRecylcerAdInteractionListener();
                    if (this.adWrapper.getSdkAdInfo() != null && !TextUtils.isEmpty(this.adWrapper.getSdkAdInfo().getClk())) {
                        LogUtil.d(TAG, "send onAdClick");
                        z.a(StubApp.getOrigApplicationContext(this.adWrapper.getContext().getApplicationContext()), f.a(this.adWrapper.getSdkAdInfo().getClk(), gDTExpressRecyclerAdData), new i());
                        this.adWrapper.getSdkAdInfo().getMsLoadedTime();
                        this.adWrapper.getAdLoader().getPosId();
                    }
                    if (recylcerAdInteractionListener != null) {
                        recylcerAdInteractionListener.onAdClicked();
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
    public void onADClosed(NativeExpressADView nativeExpressADView) {
        RecylcerAdInteractionListener recylcerAdInteractionListener;
        if (nativeExpressADView != null) {
            try {
                if (nativeExpressADView.getParent() != null) {
                    ((ViewGroup) nativeExpressADView.getParent()).removeView(nativeExpressADView);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (this.adWrapper.getLoaderListener() != null) {
            this.adWrapper.getLoaderListener().onAdClosed();
        }
        try {
            for (RecyclerAdData recyclerAdData : this.adDataList) {
                if (recyclerAdData.getAdView() == nativeExpressADView && (recylcerAdInteractionListener = ((GDTExpressRecyclerAdData) recyclerAdData).getRecylcerAdInteractionListener()) != null) {
                    recylcerAdInteractionListener.onAdClosed();
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
    public void onADExposure(NativeExpressADView nativeExpressADView) {
        RecylcerAdInteractionListener recylcerAdInteractionListener;
        try {
            h0.a(this.adWrapper.getSdkAdInfo(), nativeExpressADView);
            if (this.adWrapper.getLoaderListener() != null) {
                this.adWrapper.getLoaderListener().onAdExposure();
            }
            for (RecyclerAdData recyclerAdData : this.adDataList) {
                if (recyclerAdData.getAdView() == nativeExpressADView && (recylcerAdInteractionListener = ((GDTExpressRecyclerAdData) recyclerAdData).getRecylcerAdInteractionListener()) != null) {
                    recylcerAdInteractionListener.onAdExposure();
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
    public void onADLeftApplication(NativeExpressADView nativeExpressADView) {
    }

    @Override // com.qq.e.ads.NativeAbstractAD.BasicADListener
    public void onNoAD(AdError adError) {
        try {
            new GDTPlatformError(adError, this.adWrapper.getSdkAdInfo()).post(this.adWrapper.getLoaderListener());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
    public void onRenderFail(NativeExpressADView nativeExpressADView) {
        RecylcerAdInteractionListener recylcerAdInteractionListener;
        try {
            LogUtil.e(TAG, "onRenderFail");
            z.a(this.adWrapper.getSdkAdInfo().getErr(), (Integer) (-1), "onRenderFail");
            if (this.adWrapper.getLoaderListener() != null) {
                this.adWrapper.getLoaderListener().onAdError();
                this.adWrapper.getLoaderListener().onAdRenderFail("GDTRenderFail", -1);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        try {
            for (RecyclerAdData recyclerAdData : this.adDataList) {
                if (recyclerAdData.getAdView() == nativeExpressADView && (recylcerAdInteractionListener = ((GDTExpressRecyclerAdData) recyclerAdData).getRecylcerAdInteractionListener()) != null) {
                    recylcerAdInteractionListener.onAdRenderFailed();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
    public void onRenderSuccess(NativeExpressADView nativeExpressADView) {
        try {
            if (this.adWrapper.getLoaderListener() != null) {
                for (int i = 0; i < this.adDataList.size(); i++) {
                    RecyclerAdData recyclerAdData = this.adDataList.get(i);
                    if (nativeExpressADView != null && nativeExpressADView.equals(this.adDataList.get(i).getAdView())) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(recyclerAdData);
                        this.adWrapper.getLoaderListener().onAdReady(arrayList);
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void destroy() {
        try {
            List<RecyclerAdData> list = this.adDataList;
            if (list != null) {
                Iterator<RecyclerAdData> it = list.iterator();
                while (it.hasNext()) {
                    try {
                        it.next().destroy();
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
                this.adDataList = null;
            }
            this.list = null;
            this.adWrapper = null;
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
    public void onADLoaded(List<NativeExpressADView> list) {
        try {
            this.list = list;
            if (this.adWrapper.getLoaderListener() == null) {
                return;
            }
            this.adDataList = new ArrayList();
            for (NativeExpressADView nativeExpressADView : list) {
                this.adWrapper.getSdkAdInfo().setEcpm(String.valueOf(nativeExpressADView.getECPM()));
                this.adDataList.add(new GDTExpressRecyclerAdData(this.adWrapper, nativeExpressADView));
            }
            this.adWrapper.getLoaderListener().onAdLoaded(this.adDataList);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
