package com.heytap.msp.opos.sv.interapi.bean.csc.reorder;

import java.io.Serializable;
import java.util.Arrays;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class RequestAdEntity implements Serializable {
    private static final long serialVersionUID = -1588547647816928783L;
    private byte[] bizExt;
    private String contentId;

    public byte[] getBizExt() {
        return this.bizExt;
    }

    public String getContentId() {
        return this.contentId;
    }

    public void setBizExt(byte[] bArr) {
        this.bizExt = bArr;
    }

    public void setContentId(String str) {
        this.contentId = str;
    }

    public String toString() {
        return "RecorderReqEntity{contentId='" + this.contentId + "', bizExt=" + Arrays.toString(this.bizExt) + '}';
    }
}
