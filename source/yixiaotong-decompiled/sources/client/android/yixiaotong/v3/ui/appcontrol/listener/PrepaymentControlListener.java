package client.android.yixiaotong.v3.ui.appcontrol.listener;

import client.android.yixiaotong.v3.bean.prepayment.PrepaymentDeviceInfoBean;
import client.android.yixiaotong.v3.bean.prepayment.PrepaymentWalletBean;
import client.android.yixiaotong.v3.bean.prepayment.SupervisorBean;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public interface PrepaymentControlListener {
    void onCollectEnd(boolean z);

    void onDeviceInfo(PrepaymentDeviceInfoBean prepaymentDeviceInfoBean);

    void onSupervisorInfo(SupervisorBean supervisorBean);

    void onWalletInfo(PrepaymentWalletBean prepaymentWalletBean);
}
