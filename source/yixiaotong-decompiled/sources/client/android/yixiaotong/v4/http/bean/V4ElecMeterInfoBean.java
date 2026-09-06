package client.android.yixiaotong.v4.http.bean;

import java.io.Serializable;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class V4ElecMeterInfoBean implements Serializable {
    public String address;
    public String balance;
    public String bluetoothMac;
    public Boolean canBind;
    public String cpersonBalance;
    public String cpersonGiftBalance;
    public String cpersonTotalBalance;
    public String deviceCurrKwh;
    public Integer deviceStatus;
    public String eleSn;
    public String hexTotalKwh;
    public V4RoomLeaderInfoBean leaderInfo;
    public Integer lockStatus;
    public String mac;
    public int productId;
    public String roomId;
    public String roomTotalKwh;
    public String updateTime;
    public Boolean hasLeader = false;
    public Boolean currentUserIsLeader = false;
}
