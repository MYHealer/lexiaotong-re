package com.meishu.sdk.core.ad;

import android.os.SystemClock;
import android.view.View;
import com.meishu.sdk.core.MSAdConfig;
import com.meishu.sdk.core.loader.InteractionListener;
import com.meishu.sdk.core.loader.cache.c;
import com.meishu.sdk.core.loader.d;
import com.meishu.sdk.core.utils.ResultBean;
import java.util.Map;

/* JADX INFO: compiled from: BaseAd.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public abstract class a<T extends InteractionListener> implements IAd<T> {
    private static final String TAG = "BaseAd";
    public View adView;
    private d adWrapper;
    private T interactionListener;
    private String platform;
    public TouchData touchData = new TouchData();

    public a(d dVar, String str) {
        this.adWrapper = dVar;
        this.platform = str;
    }

    @Override // com.meishu.sdk.core.ad.IAd
    public View getAdView() {
        return this.adView;
    }

    @Override // com.meishu.sdk.core.ad.IAd
    public ResultBean getData() {
        ResultBean resultBean = new ResultBean();
        resultBean.setSdkName(this.platform);
        d dVar = this.adWrapper;
        if (dVar != null && dVar.getSdkAdInfo() != null) {
            resultBean.setPid(this.adWrapper.getSdkAdInfo().getPid());
            resultBean.setAppid(this.adWrapper.getSdkAdInfo().getApp_id());
            resultBean.setReqId(this.adWrapper.getSdkAdInfo().getReq_id());
            resultBean.setPrice(this.adWrapper.getSdkAdInfo().getCodPrice());
            resultBean.setDrawing(this.adWrapper.getSdkAdInfo().getDrawing());
            if (this.adWrapper.getSdkAdInfo().isCsjGM() && this.adWrapper.getSdkAdInfo().isCsjGMBidding()) {
                resultBean.setEcpm(String.valueOf(this.adWrapper.getSdkAdInfo().getGmShowEcpm()));
            } else if ("bidding".equals(this.adWrapper.getSdkAdInfo().getOtype())) {
                resultBean.setEcpm(String.valueOf(this.adWrapper.getSdkAdInfo().getEcpm()));
            } else {
                resultBean.setEcpm(String.valueOf(this.adWrapper.getSdkAdInfo().getCodPrice()));
            }
            resultBean.setReward_name(this.adWrapper.getSdkAdInfo().getReward_name());
            resultBean.setReward_num(this.adWrapper.getSdkAdInfo().getReward_num());
            resultBean.setS_ext(this.adWrapper.getSdkAdInfo().getS_ext());
            resultBean.setS_code(this.adWrapper.getSdkAdInfo().getS_code());
        }
        return resultBean;
    }

    @Override // com.meishu.sdk.core.ad.IAd
    public T getInteractionListener() {
        return this.interactionListener;
    }

    public Object getSdkAd() {
        return null;
    }

    @Override // com.meishu.sdk.core.ad.IAd
    public TouchData getTouchData() {
        return this.touchData;
    }

    @Override // com.meishu.sdk.core.s2s.ISBidding
    public void sendLossNotification(Map<String, Object> map) {
    }

    @Override // com.meishu.sdk.core.s2s.ISBidding
    public void sendWinNotification(Map<String, Object> map) {
    }

    @Override // com.meishu.sdk.core.ad.IAd
    public void setAdView(View view) {
        this.adView = view;
    }

    public void setCacheAdListener(c cVar) {
        this.adWrapper.setCacheAdListener(cVar);
    }

    @Override // com.meishu.sdk.core.ad.IAd
    public void setInteractionListener(T t) {
        this.interactionListener = t;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.meishu.sdk.core.ad.IAd
    public boolean isAdValid() {
        d dVar = this.adWrapper;
        if (dVar != null && dVar.getSdkAdInfo() != null) {
            int expire_timestamp = this.adWrapper.getSdkAdInfo().getExpire_timestamp();
            String sdk = this.adWrapper.getSdkAdInfo().getSdk();
            sdk.getClass();
            sdk.hashCode();
            byte b = -1;
            switch (sdk.hashCode()) {
                case 2319:
                    if (sdk.equals("HW")) {
                        b = 0;
                    }
                    break;
                case 2362:
                    if (sdk.equals("JD")) {
                        b = 1;
                    }
                    break;
                case 2408:
                    if (sdk.equals("KS")) {
                        b = 2;
                    }
                    break;
                case 67034:
                    if (sdk.equals(MSAdConfig.PLATFORM_CSJ)) {
                        b = 3;
                    }
                    break;
                case 82041:
                    if (sdk.equals("SGM")) {
                        b = 4;
                    }
                    break;
                case 62961147:
                    if (sdk.equals(MSAdConfig.PLATFORM_BD)) {
                        b = 5;
                    }
                    break;
            }
            long j = 1740000;
            switch (b) {
                case 2:
                case 3:
                    j = 3540000;
                    break;
            }
            if (expire_timestamp > 0) {
                j = expire_timestamp * 1000;
            }
            if (SystemClock.uptimeMillis() - this.adWrapper.getSdkAdInfo().getLoadedTime() >= j) {
                return false;
            }
        }
        return true;
    }
}
