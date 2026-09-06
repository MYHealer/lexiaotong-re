package client.android.yixiaotong.v3.comman;

import java.io.Serializable;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class DeviceBean implements Serializable {
    public int alise;
    public String type;
    public int valves;
    public String version;
    public int belong = 0;
    public int typeId = 0;
    public boolean isNeedTransfereed = true;
    public boolean isNeedCheckIMEI = true;
    public boolean isAbutment = false;
    public int category = 0;
    public boolean hasScreen = true;
    public int mode = 0;
    public int sdkType = 0;
    public int totalMoney = 0;

    public void setData(int i, String str, String str2, int i2, int i3, boolean z, boolean z2, boolean z3, int i4, int i5) {
        this.belong = i;
        this.type = str;
        this.version = str2;
        this.typeId = i2;
        this.alise = i3;
        this.isNeedTransfereed = z;
        this.isNeedCheckIMEI = z2;
        this.hasScreen = z3;
        this.valves = i4;
        this.mode = i5;
    }

    public void setData(int i, String str, String str2, int i2, int i3, boolean z, boolean z2, boolean z3, int i4, int i5, int i6) {
        this.belong = i;
        this.type = str;
        this.version = str2;
        this.typeId = i2;
        this.alise = i3;
        this.isNeedTransfereed = z;
        this.isNeedCheckIMEI = z2;
        this.hasScreen = z3;
        this.valves = i4;
        this.mode = i5;
        this.sdkType = i6;
    }

    public void setData(int i, String str, String str2, int i2, int i3, boolean z, boolean z2, boolean z3, int i4, int i5, int i6, int i7) {
        this.belong = i;
        this.type = str;
        this.version = str2;
        this.typeId = i2;
        this.alise = i3;
        this.isNeedTransfereed = z;
        this.isNeedCheckIMEI = z2;
        this.hasScreen = z3;
        this.valves = i4;
        this.mode = i5;
        this.sdkType = i6;
        this.totalMoney = i7;
    }
}
