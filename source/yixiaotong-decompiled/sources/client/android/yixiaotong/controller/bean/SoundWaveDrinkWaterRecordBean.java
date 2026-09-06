package client.android.yixiaotong.controller.bean;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public class SoundWaveDrinkWaterRecordBean {
    public long ConsumeTime;
    public int i41;
    public int i42;
    public int i43;
    public int i81;
    public String machineid;
    public String orderid;
    public String payDate;
    public int payMoney;
    public String payTime;
    public int realPay;
    public int state;
    public int sysflag;
    public int typeId;

    public int getI41() {
        return this.i41;
    }

    public String getMachineid() {
        return this.machineid;
    }

    public String getOrderid() {
        return this.orderid;
    }

    public String getPayDate() {
        return this.payDate;
    }

    public int getPayMoney() {
        return this.payMoney;
    }

    public String getPayTime() {
        return this.payTime;
    }

    public int getRealPay() {
        return this.realPay;
    }

    public int getSysflag() {
        return this.sysflag;
    }

    public int getTypeId() {
        return this.typeId;
    }

    public void setTypeId(int i) {
        this.typeId = i;
    }

    public String toString() {
        return "SoundWaveDrinkWaterRecordBean{orderid='" + this.orderid + "', payMoney=" + this.payMoney + ", payDate='" + this.payDate + "', payTime='" + this.payTime + "', machineid='" + this.machineid + "', sysflag=" + this.sysflag + ", typeId=" + this.typeId + ", realPay=" + this.realPay + ", i41=" + this.i41 + ", ConsumeTime=" + this.ConsumeTime + ", state=" + this.state + '}';
    }
}
