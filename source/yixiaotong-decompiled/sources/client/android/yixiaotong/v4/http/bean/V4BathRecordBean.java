package client.android.yixiaotong.v4.http.bean;

import java.io.Serializable;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class V4BathRecordBean implements Serializable {
    public String address;
    public String consume;
    public String consumeDeductBankName;
    public String consumeOrderId;
    public String createTime;
    public String deviceName;
    public boolean hasAlipayTap;
    private boolean isClicked = false;
    private boolean isPayed = false;
    public String mac;
    public String pay;
    public String payName;
    public int productId;
    public String serviceId;
    public String useTime;

    public boolean isClicked() {
        return this.isClicked;
    }

    public boolean isPayed() {
        return this.isPayed;
    }

    public void setClicked(boolean z) {
        this.isClicked = z;
    }

    public void setPayed(boolean z) {
        this.isPayed = z;
    }
}
