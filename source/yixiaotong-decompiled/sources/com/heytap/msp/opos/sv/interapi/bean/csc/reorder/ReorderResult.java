package com.heytap.msp.opos.sv.interapi.bean.csc.reorder;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class ReorderResult implements Serializable {
    public static final String EXT_INFO_KEY_RE_RANK_ID = "reRankId";
    private static final long serialVersionUID = -7578038454117208382L;
    private int code;
    private Map<String, String> extInfo;
    private String msg;
    private long requestLimitTime;
    private List<ResultAdEntity> resultAdEntityList;

    public ReorderResult() {
    }

    public ReorderResult(int i, String str) {
        this.code = i;
        this.msg = str;
    }

    public int getCode() {
        return this.code;
    }

    public Map<String, String> getExtInfo() {
        return this.extInfo;
    }

    public String getMsg() {
        return this.msg;
    }

    public List<ResultAdEntity> getReorderEntityList() {
        return this.resultAdEntityList;
    }

    public long getRequestLimitTime() {
        return this.requestLimitTime;
    }

    public void setCode(int i) {
        this.code = i;
    }

    public void setExtInfo(Map<String, String> map) {
        this.extInfo = map;
    }

    public void setMsg(String str) {
        this.msg = str;
    }

    public void setReorderEntityList(List<ResultAdEntity> list) {
        this.resultAdEntityList = list;
    }

    public void setRequestLimitTime(long j) {
        this.requestLimitTime = j;
    }

    public String toString() {
        return "ReorderResult{code=" + this.code + ", msg='" + this.msg + "', resultAdEntityList=" + this.resultAdEntityList + ", requestLimitTime=" + this.requestLimitTime + ", extInfo=" + this.extInfo + '}';
    }
}
