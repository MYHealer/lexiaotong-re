package com.meishu.sdk.platform.gdt.recycler;

import com.meishu.sdk.core.utils.LogUtil;
import com.meishu.sdk.platform.gdt.GDTPlatformError;
import com.qq.e.ads.nativ.NativeADUnifiedListener;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import com.qq.e.comm.util.AdError;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class GDTNativeUnifiedAdListenerAdapter implements NativeADUnifiedListener {
    private static final String TAG = "GDTNativeUnifiedAdListenerAdapter";
    private GDTRecyclerAdWrapper adWrapper;
    private List<NativeUnifiedADData> list;

    public GDTNativeUnifiedAdListenerAdapter(GDTRecyclerAdWrapper gDTRecyclerAdWrapper) {
        this.adWrapper = gDTRecyclerAdWrapper;
    }

    public List<NativeUnifiedADData> getAdList() {
        return this.list;
    }

    @Override // com.qq.e.ads.NativeAbstractAD.BasicADListener
    public void onNoAD(AdError adError) {
        try {
            LogUtil.e(TAG, "onNoAD, code: " + adError.getErrorCode() + ", msg: " + adError.getErrorMsg());
            new GDTPlatformError(adError, this.adWrapper.getSdkAdInfo()).post(this.adWrapper.getLoaderListener());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.qq.e.ads.nativ.NativeADUnifiedListener
    public void onADLoaded(List<NativeUnifiedADData> list) {
        try {
            this.list = list;
            if (list == null || this.adWrapper.getLoaderListener() == null) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (NativeUnifiedADData nativeUnifiedADData : list) {
                this.adWrapper.getSdkAdInfo().setEcpm(String.valueOf(nativeUnifiedADData.getECPM()));
                arrayList.add(new GDTNativeUnifiedAdData(this.adWrapper, nativeUnifiedADData));
            }
            this.adWrapper.getLoaderListener().onAdLoaded(arrayList);
            this.adWrapper.getLoaderListener().onAdReady(arrayList);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
