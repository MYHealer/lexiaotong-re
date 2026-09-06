package com.hihonor.adsdk.base.callback.filter;

import com.hihonor.adsdk.base.bean.BaseAdInfo;
import com.hihonor.adsdk.base.bean.BaseAdInfoResp;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class ResFilterBean {
    private BaseAdInfoResp baseAdInfoResp;
    private boolean isNeedFilter;
    private List<FilterAd> listResultsData = new ArrayList();

    public ResFilterBean() {
    }

    public void addListResultsData(FilterAd filterAd) {
        this.listResultsData.add(filterAd);
    }

    public List<FilterAd> getListResultsData() {
        return this.listResultsData;
    }

    public List<BaseAdInfo> getListSourceData() {
        return this.baseAdInfoResp.getList();
    }

    public boolean isNeedFilter() {
        return this.isNeedFilter;
    }

    public void setListSourceData(BaseAdInfoResp baseAdInfoResp) {
        this.baseAdInfoResp = baseAdInfoResp;
    }

    public void setNeedFilter(boolean z) {
        this.isNeedFilter = z;
    }

    public boolean isEmptyResult() {
        BaseAdInfoResp baseAdInfoResp = this.baseAdInfoResp;
        return baseAdInfoResp == null || baseAdInfoResp.getList() == null || this.baseAdInfoResp.getList().size() == 0;
    }

    public ResFilterBean(boolean z) {
        this.isNeedFilter = z;
    }
}
