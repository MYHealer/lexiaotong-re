package client.android.yixiaotong.controller.bean;

import java.io.Serializable;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public class BillOrderBean implements Serializable {
    private static final long serialVersionUID = -1435567372191962555L;
    public int applicationType;
    public long billId;
    public int consumeAmount;
    public String consumeTime;
    public short temperature = -1;
}
