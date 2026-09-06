package client.android.yixiaotong.v4.ui.area;

import android.app.Activity;
import client.android.yixiaotong.account.Account;
import client.android.yixiaotong.controller.bean.SuccessBean;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.ui.dialog.BaseMaterialDialog;
import client.android.yixiaotong.ui.dialog.TwoButtonDialog;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.v4.http.V4BusinessControllers;
import client.android.yixiaotong.v4.http.bean.V4ElecMeterInfoBean;
import client.android.yixiaotong.v4.ui.app.electricitymeter.V4ElecMeterAnalysisActivity;
import client.android.yixiaotong.v4.ui.app.electricitymeter.V4ElecMeterControlActivity;
import client.android.yixiaotong.v4.ui.error.V4ErrorControlUtil;
import client.android.yixiaotong.v4.util.userinfo.V4UserInfoBean;
import client.android.yixiaotong.v4.util.userinfo.V4UserInfoUtil;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class V4SelectAddressControl {
    private boolean mIsEnable;

    private V4SelectAddressControl() {
        this.mIsEnable = true;
    }

    private static final class SingleHolder {
        public static final V4SelectAddressControl Instance = new V4SelectAddressControl();

        private SingleHolder() {
        }
    }

    public static V4SelectAddressControl getInstance() {
        return SingleHolder.Instance;
    }

    public void onResume() {
        this.mIsEnable = true;
        V4ErrorControlUtil.getInstance().onResume();
    }

    public void onPause() {
        this.mIsEnable = false;
        BaseMaterialDialog.dissmisMaterialDialog();
        V4ErrorControlUtil.getInstance().onPause();
    }

    public void bindRoom(final Account account, final Activity activity, String str, final int i, final boolean z) {
        V4UserInfoBean loginAccountV4 = V4UserInfoUtil.getInstance().getLoginAccountV4();
        V4BusinessControllers.getInstance().postBindRoom(account, str, loginAccountV4 != null ? loginAccountV4.cpersonId : "", new Listener<V4ElecMeterInfoBean>() { // from class: client.android.yixiaotong.v4.ui.area.V4SelectAddressControl.1
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                super.onStart(controller);
                BaseMaterialDialog.showMaterialDialog(activity, "正在绑定房间.", false);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, V4ElecMeterInfoBean v4ElecMeterInfoBean, Object... objArr) {
                super.onComplete(controller, v4ElecMeterInfoBean, objArr);
                if (V4SelectAddressControl.this.mIsEnable) {
                    ToastUtils.show(activity, "绑定房间成功!");
                    int i2 = i;
                    if (i2 != 0) {
                        V4SelectAddressControl.this.getElecMeterInfo(account, activity, i2, z);
                    } else {
                        BaseMaterialDialog.dissmisMaterialDialog();
                        activity.finish();
                    }
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                super.onFail(controller, clientException);
                if (V4SelectAddressControl.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    if (clientException.getCode() == 33) {
                        final V4ElecMeterInfoBean v4ElecMeterInfoBean = (V4ElecMeterInfoBean) clientException.getObject();
                        TwoButtonDialog.getInstance().showDialog(activity, new TwoButtonDialog.Listener() { // from class: client.android.yixiaotong.v4.ui.area.V4SelectAddressControl.1.1
                            @Override // client.android.yixiaotong.ui.dialog.TwoButtonDialog.Listener
                            public void onCancle() {
                            }

                            @Override // client.android.yixiaotong.ui.dialog.TwoButtonDialog.Listener
                            public void onConfirm() {
                                V4SelectAddressControl.this.unBindSupervisor(account, activity, v4ElecMeterInfoBean.productId, v4ElecMeterInfoBean.roomId);
                            }
                        }, "提示", clientException.getDetail(), "取消", "解绑舍长");
                    } else {
                        V4ErrorControlUtil.getInstance().showDialog(clientException, activity, false);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getElecMeterInfo(Account account, final Activity activity, final int i, final boolean z) {
        V4BusinessControllers.getInstance().getElecMeterInfo(account, i, new Listener<V4ElecMeterInfoBean>() { // from class: client.android.yixiaotong.v4.ui.area.V4SelectAddressControl.2
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                super.onStart(controller);
                BaseMaterialDialog.setConnectMaterialDialog("正在获取设备信息");
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, V4ElecMeterInfoBean v4ElecMeterInfoBean, Object... objArr) {
                super.onComplete(controller, v4ElecMeterInfoBean, objArr);
                if (V4SelectAddressControl.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    int i2 = i;
                    if (i2 == 17) {
                        V4ElecMeterAnalysisActivity.launch(activity, v4ElecMeterInfoBean.mac, i);
                    } else {
                        V4ElecMeterControlActivity.launch(activity, v4ElecMeterInfoBean, i2);
                    }
                    activity.finish();
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                super.onFail(controller, clientException);
                if (V4SelectAddressControl.this.mIsEnable) {
                    V4ErrorControlUtil.getInstance().showDialog(clientException, activity, z);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void unBindSupervisor(Account account, final Activity activity, int i, String str) {
        V4BusinessControllers.getInstance().updateRoomLeader(account, i, str, 2, new Listener<SuccessBean>() { // from class: client.android.yixiaotong.v4.ui.area.V4SelectAddressControl.3
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                BaseMaterialDialog.showMaterialDialog(activity, "正在处理..", false);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, SuccessBean successBean, Object... objArr) {
                if (V4SelectAddressControl.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    ToastUtils.show(activity, "解绑成功");
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (V4SelectAddressControl.this.mIsEnable) {
                    V4ErrorControlUtil.getInstance().showDialog(clientException, activity, false);
                }
            }
        });
    }
}
