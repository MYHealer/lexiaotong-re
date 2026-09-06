package com.heytap.msp.opos.sv.interapi.bean.csc.reorder;

import com.heytap.msp.opos.sv.interapi.bean.csc.ReqExtraInfo;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class ReorderRequest implements Serializable {
    public static final int TRIGGER_ACTION_NEW_MESSAGE_RECEIVED = 1;
    public static final int TRIGGER_ACTION_USER_DROP_DOWN_STATUS_BAR = 2;
    private static final long serialVersionUID = 5934728118941431090L;
    private String expItemId;
    private List<RequestAdEntity> reorderReqEntityList;
    private ReqExtraInfo reqExtraInfo;
    private int triggerAction;

    public String getExpItemId() {
        return this.expItemId;
    }

    public List<RequestAdEntity> getRecorderReqEntityList() {
        return this.reorderReqEntityList;
    }

    public ReqExtraInfo getReqExtraInfo() {
        return this.reqExtraInfo;
    }

    public int getTriggerAction() {
        return this.triggerAction;
    }

    public void setExpItemId(String str) {
        this.expItemId = str;
    }

    public void setRecorderReqEntityList(List<RequestAdEntity> list) {
        this.reorderReqEntityList = list;
    }

    public void setReqExtraInfo(ReqExtraInfo reqExtraInfo) {
        this.reqExtraInfo = reqExtraInfo;
    }

    public void setTriggerAction(int i) {
        this.triggerAction = i;
    }

    public String toString() {
        return "ReorderReq{expItemId=" + this.expItemId + ", triggerAction=" + this.triggerAction + ", reorderReqEntityList=" + this.reorderReqEntityList + ", reqExtraInfo=" + this.reqExtraInfo + '}';
    }
}
