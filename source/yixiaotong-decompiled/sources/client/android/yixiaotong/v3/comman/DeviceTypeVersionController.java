package client.android.yixiaotong.v3.comman;

import com.cdo.oaps.ad.wrapper.BaseWrapper;
import com.unionpay.tsmservice.data.Constant;
import java.util.ArrayList;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class DeviceTypeVersionController {
    public static final int ALISE_4GBLE = 4;
    public static final int ALISE_BLE = 1;
    public static final int ALISE_NB = 2;
    public static final int ALISE_NBBLE = 0;
    public static final int AUTHTOTALMONEY_FORALI = 1;
    public static final String Bluetooth_Device_Type = "00";
    public static final String Bluetooth_Device_Ver_Bath1 = "00";
    public static final String Bluetooth_Device_Ver_Bath2 = "01";
    public static final String Bluetooth_Device_Ver_Bath3 = "02";
    public static final String Bluetooth_Device_Ver_Bath4 = "06";
    public static final String Bluetooth_Device_Ver_Bath5 = "03";
    public static final String Bluetooth_Device_Ver_DM1 = "09";
    public static final String Bluetooth_Device_Ver_DM2 = "10";
    public static final String Bluetooth_Device_Ver_DrinkWater = "03";
    public static final String Bluetooth_Device_Ver_Dry = "07";
    public static final String Bluetooth_Device_Ver_Hair = "05";
    public static final String Bluetooth_Device_Ver_SellCard = "08";
    public static final String Bluetooth_Device_Ver_SellCard2 = "11";
    public static final String Bluetooth_Device_Ver_Washer = "04";
    public static final int LI_DEVICE = 0;
    public static final int MODE_L = 2;
    public static final int MODE_MAICHONG = 1;
    public static final int MODE_MONEY = 0;
    public static final int SDKTYPE_FORALI = 1;
    public static final int SDKTYPE_FORME = 0;
    public static final int SHI_DEVICE = 1;
    private ArrayList<DeviceBean> mDeviceInfos;

    /* JADX INFO: renamed from: client.android.yixiaotong.v3.comman.DeviceTypeVersionController$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* synthetic */ DeviceTypeVersionController(AnonymousClass1 anonymousClass1) {
        this();
    }

    private DeviceTypeVersionController() {
        this.mDeviceInfos = new ArrayList<>();
        addDevice();
    }

    private static class Single {
        private static final DeviceTypeVersionController install = new DeviceTypeVersionController(null);

        private Single() {
        }
    }

    public static DeviceTypeVersionController getInstance() {
        return Single.install;
    }

    private void addDevice() {
        setDeviceInfo(0, "01", "02", 1, 0, true, true, true, 1, 0);
        setDeviceInfo(0, "01", "03", 1, 0, true, true, true, 1, 0);
        setDeviceInfo(0, "01", "05", 1, 0, true, true, true, 1, 0);
        setDeviceInfo(0, "01", "08", 1, 4, true, true, true, 1, 0);
        setDeviceInfo(0, "01", Bluetooth_Device_Ver_DM1, 1, 4, true, true, true, 1, 0);
        setDeviceInfo(0, "01", BaseWrapper.ENTER_ID_OAPS_DEMO, 1, 4, false, true, true, 1, 1);
        setDeviceInfo(0, "01", "32", 1, 4, false, true, true, 1, 1);
        setDeviceInfo(0, "01", BaseWrapper.ENTER_ID_OAPS_ROAMING, 1, 4, false, true, true, 1, 1);
        setDeviceInfo(0, "01", "51", 1, 4, false, false, true, 1, 1);
        setDeviceInfo(0, "01", "52", 1, 4, false, false, true, 1, 1);
        setDeviceInfo(0, "01", "53", 1, 4, false, false, true, 1, 1);
        setDeviceInfo(0, "01", "61", 1, 4, false, true, true, 1, 1);
        setDeviceInfo(0, "01", "62", 1, 4, false, true, true, 1, 1);
        setDeviceInfo(0, "01", Constant.TRANS_TYPE_CASH_LOAD, 1, 4, false, true, true, 1, 1);
        setDeviceInfo(0, "01", "71", 1, 4, false, true, true, 1, 1);
        setDeviceInfo(0, "01", "72", 1, 4, false, true, true, 1, 1);
        setDeviceInfo(0, "01", "73", 1, 4, false, true, true, 1, 1);
        setDeviceInfo(0, "01", "81", 1, 4, false, true, false, 1, 0);
        setDeviceInfo(0, "01", "82", 1, 4, false, true, false, 1, 0);
        setDeviceInfo(0, "01", "91", 1, 4, false, true, true, 1, 0, 1);
        setDeviceInfo(0, "01", "92", 1, 4, false, true, true, 1, 0, 1);
        setDeviceInfo(0, "01", "93", 1, 4, false, true, true, 1, 0, 1, 1);
        setDeviceInfo(0, "01", "94", 1, 4, false, true, true, 1, 0, 1);
        setDeviceInfo(0, "01", "A1", 1, 4, false, true, true, 1, 0, 1);
        setDeviceInfo(0, "01", "A2", 1, 4, false, true, true, 1, 0, 0);
        setDeviceInfo(0, "01", "85", 1, 4, false, true, true, 1, 1);
        setDeviceInfo(0, "01", "A4", 1, 4, false, true, true, 1, 0, 1);
        setDeviceInfo(0, "01", "A5", 1, 4, false, true, true, 1, 0, 0);
        setDeviceInfo(0, "01", "04", 17, 0, true, true, true, 1, 0);
        setDeviceInfo(0, "01", "06", 17, 4, true, true, true, 1, 0);
        setDeviceInfo(0, "01", "07", 17, 4, true, true, true, 1, 0);
        setDeviceInfo(0, "02", "02", 6, 0, true, true, true, 2, 0);
        setDeviceInfo(0, "02", "08", 6, 4, true, true, true, 1, 0);
        setDeviceInfo(0, "02", Bluetooth_Device_Ver_DM1, 6, 4, true, true, true, 2, 0);
        setDeviceInfo(0, "02", "0A", 6, 4, true, true, true, 1, 0);
        setDeviceInfo(0, "02", "0B", 6, 4, true, true, true, 2, 0);
        setDeviceInfo(0, "02", "32", 6, 4, false, true, true, 1, 1);
        setDeviceInfo(0, "02", BaseWrapper.ENTER_ID_OAPS_ROAMING, 6, 4, false, true, true, 2, 1);
        setDeviceInfo(0, "02", "62", 6, 4, false, true, true, 1, 1);
        setDeviceInfo(0, "02", Constant.TRANS_TYPE_CASH_LOAD, 6, 4, false, true, true, 2, 1);
        setDeviceInfo(0, "02", "72", 6, 4, false, true, true, 1, 0, 1);
        setDeviceInfo(0, "02", "73", 6, 4, false, true, true, 2, 0, 1);
        setDeviceInfo(0, "02", "74", 6, 4, false, true, true, 2, 0, 1);
        setDeviceInfo(0, "02", "76", 6, 4, false, true, true, 1, 0, 1);
        setDeviceInfo(0, "02", "84", 6, 4, false, true, true, 1, 0, 0);
        setDeviceInfo(0, "02", "85", 6, 4, false, true, true, 2, 0, 0);
        setDeviceInfo(0, "03", "02", 8, 0, true, true, true, 1, 0);
        setDeviceInfo(0, "03", "03", 8, 4, true, true, true, 1, 0);
        setDeviceInfo(0, "03", "04", 8, 4, true, true, true, 1, 0);
        setDeviceInfo(0, "03", BaseWrapper.ENTER_ID_OAPS_DEMO, 8, 4, false, true, false, 1, 1);
        setDeviceInfo(0, "03", "61", 8, 4, false, true, true, 1, 0, 1);
        setDeviceInfo(0, "04", "02", 3, 0, true, true, true, 1, 0);
        setDeviceInfo(0, "04", "03", 3, 4, true, true, false, 1, 0);
        setDeviceInfo(0, "04", "04", 3, 4, true, true, false, 1, 0);
        setDeviceInfo(0, "04", BaseWrapper.ENTER_ID_OAPS_DEMO, 3, 4, false, true, false, 1, 1);
        setDeviceInfo(0, "04", "61", 3, 4, false, true, false, 1, 0, 1);
        setDeviceInfo(0, "04", "62", 3, 4, false, true, false, 1, 0, 1);
        setDeviceInfo(0, "05", "02", 16, 0, true, true, true, 1, 0);
        setDeviceInfo(0, "05", "03", 16, 4, true, true, false, 1, 0);
        setDeviceInfo(0, "05", "04", 16, 4, true, true, false, 1, 0);
        setDeviceInfo(0, "05", BaseWrapper.ENTER_ID_OAPS_DEMO, 16, 4, false, true, false, 1, 1);
        setDeviceInfo(0, "05", "62", 3, 4, false, true, false, 1, 0, 1);
        setDeviceInfo(0, "06", "61", 18, 4, false, true, false, 1, 1);
        setDeviceInfo(0, "06", Constant.TRANS_TYPE_CASH_LOAD, 18, 4, false, true, false, 1, 1);
        setDeviceInfo(0, "0A", "01", 2, 4, true, true, false, 1, 0);
        setDeviceInfo(1, "01", BaseWrapper.ENTER_ID_AD_SDK, 1, 0, true, true, true, 1, 2);
        setDeviceInfo(1, "01", "15", 1, 1, true, false, true, 1, 2);
        setDeviceInfo(1, "01", "16", 1, 0, true, true, true, 1, 2);
        setDeviceInfo(1, "01", BaseWrapper.ENTER_ID_17, 1, 1, true, false, true, 1, 2);
        setDeviceInfo(1, "02", BaseWrapper.ENTER_ID_AD_SDK, 6, 0, true, true, true, 1, 2);
        setDeviceInfo(1, "02", "15", 6, 1, true, false, true, 1, 2);
        setDeviceInfo(1, "02", "16", 6, 0, true, true, true, 2, 2);
        setDeviceInfo(1, "02", BaseWrapper.ENTER_ID_17, 6, 1, true, false, true, 2, 2);
        setDeviceInfo(1, "02", BaseWrapper.ENTER_ID_18, 6, 0, true, true, true, 1, 2);
        setDeviceInfo(1, "02", BaseWrapper.ENTER_ID_19, 6, 1, true, false, true, 1, 2);
        setDeviceInfo(1, "02", "1A", 6, 0, true, true, true, 2, 2);
        setDeviceInfo(1, "02", "1B", 6, 1, true, false, true, 2, 2);
        setDeviceInfo(1, "02", "1C", 6, 0, true, true, true, 1, 2);
        setDeviceInfo(1, "03", BaseWrapper.ENTER_ID_18, 8, 0, true, true, true, 1, 0);
        setDeviceInfo(1, "04", BaseWrapper.ENTER_ID_17, 3, 0, true, true, true, 1, 0);
    }

    private void setDeviceInfo(int i, String str, String str2, int i2, int i3, boolean z, boolean z2, boolean z3, int i4, int i5) {
        DeviceBean deviceBean = new DeviceBean();
        deviceBean.setData(i, str, str2, i2, i3, z, z2, z3, i4, i5, 0);
        this.mDeviceInfos.add(deviceBean);
    }

    private void setDeviceInfo(int i, String str, String str2, int i2, int i3, boolean z, boolean z2, boolean z3, int i4, int i5, int i6) {
        DeviceBean deviceBean = new DeviceBean();
        deviceBean.setData(i, str, str2, i2, i3, z, z2, z3, i4, i5, i6);
        this.mDeviceInfos.add(deviceBean);
    }

    private void setDeviceInfo(int i, String str, String str2, int i2, int i3, boolean z, boolean z2, boolean z3, int i4, int i5, int i6, int i7) {
        DeviceBean deviceBean = new DeviceBean();
        deviceBean.setData(i, str, str2, i2, i3, z, z2, z3, i4, i5, i6, i7);
        this.mDeviceInfos.add(deviceBean);
    }

    public DeviceBean getDeviceInfo(String str, String str2) {
        for (int i = 0; i < this.mDeviceInfos.size(); i++) {
            if (str.equalsIgnoreCase(this.mDeviceInfos.get(i).type) && str2.equalsIgnoreCase(this.mDeviceInfos.get(i).version)) {
                return this.mDeviceInfos.get(i);
            }
        }
        return null;
    }
}
