package com.hihonor.adsdk.base.mediation.interfaces;

import android.content.Context;
import com.hihonor.adsdk.base.api.BaseExpressAd;
import com.hihonor.adsdk.base.g.j.d.c;
import com.hihonor.adsdk.base.mediation.comm.adevent.a;
import com.hihonor.adsdk.base.mediation.core.imp.AdapterConstructorBean;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public abstract class BaseAdapter<T extends BaseExpressAd> implements IBaseAd {
    protected String mAdContext;
    protected int mAdCount;
    protected a mAdEventListener;
    protected int mAdHeight;
    protected String mAdId;
    protected int mAdWidth;
    protected String mAppId;
    protected Context mContext;
    protected String mExt;
    protected int mLoadType = -1;
    protected String mMediaRequestId;
    protected String mPosId;
    protected String mRequestId;
    protected long mTimeOutMillis;

    public BaseAdapter(AdapterConstructorBean adapterConstructorBean) {
        this.mContext = adapterConstructorBean.getContext();
        this.mAppId = adapterConstructorBean.getAppId();
        this.mPosId = adapterConstructorBean.getPosId();
        this.mExt = adapterConstructorBean.getExt();
    }

    public abstract void fetchAdOnly();

    public String getAdId() {
        return this.mAdId;
    }

    public abstract int getAdType();

    public int getAdapterPriority() {
        return -1;
    }

    protected abstract String getAdnType();

    public String getAppId() {
        return this.mAppId;
    }

    public abstract String getBrandType();

    public String getMediaRequestId() {
        return this.mMediaRequestId;
    }

    public String getPosId() {
        return this.mPosId;
    }

    protected c.a getReportBuilder() {
        return new c.a().hnadsc(this.mPosId).hnadsm(this.mMediaRequestId).hnadsr(this.mRequestId).hnadsa(this.mAdId).hnadsw(this.mAppId).hnadsd(getAdnType()).hnadsf(getBrandType()).hnadsd(this.mLoadType).hnadsb(getAdType());
    }

    public String getRequestId() {
        return this.mRequestId;
    }

    public abstract boolean isValid();

    public void release() {
        this.mAdEventListener = null;
    }

    public void setAdContext(String str) {
        this.mAdContext = str;
    }

    public void setAdCount(int i) {
        this.mAdCount = i;
    }

    public void setAdEventListener(a aVar) {
        this.mAdEventListener = aVar;
    }

    public void setAdHeight(int i) {
        this.mAdHeight = i;
    }

    public void setAdId(String str) {
        this.mAdId = str;
    }

    public void setAdWidth(int i) {
        this.mAdWidth = i;
    }

    public void setAppId(String str) {
        this.mAppId = str;
    }

    @Override // com.hihonor.adsdk.base.mediation.interfaces.IBaseAd
    public void setBidECPM(int i) {
    }

    public abstract void setFetchDelay(int i);

    public void setLoadType(int i) {
        this.mLoadType = i;
    }

    public void setMediaRequestId(String str) {
        this.mMediaRequestId = str;
    }

    @Override // com.hihonor.adsdk.base.mediation.interfaces.IBaseAd
    public void setPayload(String str) {
    }

    public void setPosId(String str) {
        this.mPosId = str;
    }

    public void setRequestId(String str) {
        this.mRequestId = str;
    }

    public void setTimeOutMillis(long j) {
        this.mTimeOutMillis = j;
    }
}
