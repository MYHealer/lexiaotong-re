package com.baidu.mobads.sdk.api;

import android.content.Context;
import android.view.View;
import com.baidu.mobads.sdk.internal.a;
import com.baidu.mobads.sdk.internal.cs;
import com.baidu.mobads.sdk.internal.dg;
import com.qq.e.comm.pi.IReward;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class XAdEntryResponse implements EntryResponse {
    private static final String TAG = "XAdEntryResponse";
    private boolean isDownloadApp;
    private a mAdInfo;
    private EntryResponse.EntryAdInteractionListener mAdInteractionListener;
    private Context mCxt;
    private dg mFeedsProd;
    private cs mUriUtils;

    public XAdEntryResponse(Context context, dg dgVar, a aVar) {
        this.isDownloadApp = false;
        this.mCxt = context;
        this.mFeedsProd = dgVar;
        this.mAdInfo = aVar;
        if (aVar.q() == 2) {
            this.isDownloadApp = true;
        }
        this.mUriUtils = cs.a();
    }

    public String getUniqueId() {
        a aVar = this.mAdInfo;
        return aVar != null ? aVar.M() : "";
    }

    @Override // com.baidu.mobads.sdk.api.EntryResponse
    public void registerViewForInteraction(View view, List<View> list, List<View> list2, EntryResponse.EntryAdInteractionListener entryAdInteractionListener) {
        this.mAdInteractionListener = entryAdInteractionListener;
        if (this.mFeedsProd != null) {
            try {
                HashMap map = new HashMap();
                map.put(IReward.AD_VIEW, view);
                map.put("clickViews", list);
                map.put("creativeViews", list2);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("msg", "registerViewForInteraction");
                jSONObject.put("uniqueId", getUniqueId());
                jSONObject.put("isDownloadApp", this.isDownloadApp);
                this.mFeedsProd.a(jSONObject, map);
            } catch (Throwable unused) {
            }
        }
    }

    @Override // com.baidu.mobads.sdk.api.EntryResponse
    public String getAdLogoUrl() {
        a aVar = this.mAdInfo;
        return aVar != null ? aVar.h() : "https://cpro.baidustatic.com/cpro/logo/sdk/mob-adIcon_2x.png";
    }

    @Override // com.baidu.mobads.sdk.api.EntryResponse
    public String getBaiduLogoUrl() {
        a aVar = this.mAdInfo;
        return aVar != null ? aVar.i() : "https://cpro.baidustatic.com/cpro/logo/sdk/new-bg-logo.png";
    }

    @Override // com.baidu.mobads.sdk.api.EntryResponse
    public String getTitle() {
        a aVar = this.mAdInfo;
        return aVar != null ? aVar.a() : "";
    }

    @Override // com.baidu.mobads.sdk.api.EntryResponse
    public void unionLogoClick() {
        if (this.mFeedsProd == null || this.mUriUtils == null) {
            return;
        }
        JSONObject jSONObjectY = this.mAdInfo.Y();
        try {
            jSONObjectY.put("unionUrl", "https://union.baidu.com/");
            jSONObjectY.put("msg", "unionLogoClick");
        } catch (Throwable unused) {
        }
        this.mFeedsProd.a(jSONObjectY);
    }

    @Override // com.baidu.mobads.sdk.api.EntryResponse
    public boolean isReady(Context context) {
        return this.mAdInfo != null && System.currentTimeMillis() - this.mAdInfo.z() <= this.mAdInfo.K();
    }

    @Override // com.baidu.mobads.sdk.api.EntryResponse
    public boolean isAdAvailable() {
        return this.mAdInfo != null && System.currentTimeMillis() - this.mAdInfo.z() <= this.mAdInfo.K();
    }

    public void onAdClick() {
        EntryResponse.EntryAdInteractionListener entryAdInteractionListener = this.mAdInteractionListener;
        if (entryAdInteractionListener != null) {
            entryAdInteractionListener.onAdClick();
        }
    }

    public void onADExposed() {
        EntryResponse.EntryAdInteractionListener entryAdInteractionListener = this.mAdInteractionListener;
        if (entryAdInteractionListener != null) {
            entryAdInteractionListener.onADExposed();
        }
    }

    public void onADExposureFailed(int i) {
        EntryResponse.EntryAdInteractionListener entryAdInteractionListener = this.mAdInteractionListener;
        if (entryAdInteractionListener != null) {
            entryAdInteractionListener.onADExposureFailed(i);
        }
    }

    public void onAdUnionClick() {
        EntryResponse.EntryAdInteractionListener entryAdInteractionListener = this.mAdInteractionListener;
        if (entryAdInteractionListener != null) {
            entryAdInteractionListener.onAdUnionClick();
        }
    }
}
