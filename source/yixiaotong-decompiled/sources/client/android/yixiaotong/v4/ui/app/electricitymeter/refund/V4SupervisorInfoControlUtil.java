package client.android.yixiaotong.v4.ui.app.electricitymeter.refund;

import android.app.Activity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.account.Account;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.ui.dialog.BaseMaterialDialog;
import client.android.yixiaotong.ui.dialog.SystemErrorTip;
import client.android.yixiaotong.ui.dialog.TwoButtonDialog;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.v3.bluetoothutil.BluetoothControlUtil;
import client.android.yixiaotong.v3.ui.appcontrol.listener.CollectAndSetEmptyControlListener;
import client.android.yixiaotong.v3.ui.scan.QrcodeUtil;
import client.android.yixiaotong.v3.util.LogUtil;
import client.android.yixiaotong.v4.http.V4BusinessControllers;
import client.android.yixiaotong.v4.http.bean.V4RefundableAmountBean;
import client.android.yixiaotong.v4.ui.error.V4ErrorControlUtil;
import client.android.yixiaotong.v4.ui.wallet.V4SubmitRefundActivity;
import com.huawei.openalliance.ad.views.PPSLabelView;
import com.lxt.bluetoothsdk.BluetoothSDK;
import com.lxt.bluetoothsdk.model.BluetoothDevice;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class V4SupervisorInfoControlUtil {
    private static final String TAG = "V4SupervisorInfoControlUtil";
    private Account mAccount;
    private Activity mActivity;
    private String mBalance;
    private BluetoothDevice mBluetoothDevice;
    private V4CollectAndSetEmptyControlUtil mCollectAndSetEmptyControlUtil;
    private FlowState mFlowState;
    private boolean mIsEnable;
    private String mMachineId;
    private String mRoomId;
    private String mTitleContent;
    private int mTypeId;
    private String mStudentHex = client.android.yixiaotong.util.bluetooth.BluetoothDevice.DEFAULT_DEVICEHEXNO;
    private int mProductId = 0;

    private enum FlowState {
        none,
        collect,
        collectend,
        setempty,
        setemptyend,
        rechargewater
    }

    public void init(Activity activity, Account account, String str, String str2, String str3, int i, String str4, String str5) {
        this.mIsEnable = true;
        this.mActivity = activity;
        this.mAccount = account;
        this.mTitleContent = str;
        this.mMachineId = str3;
        this.mProductId = i;
        this.mRoomId = str4;
        this.mBalance = str5;
        if (str2.length() == 12) {
            str2 = QrcodeUtil.getMac(str2.substring(0, 12));
        }
        this.mBluetoothDevice = new BluetoothDevice(str2, str2, 0);
        V4CollectAndSetEmptyControlUtil v4CollectAndSetEmptyControlUtil = new V4CollectAndSetEmptyControlUtil();
        this.mCollectAndSetEmptyControlUtil = v4CollectAndSetEmptyControlUtil;
        v4CollectAndSetEmptyControlUtil.init(this.mActivity, this.mAccount, this.mBluetoothDevice, this.mStudentHex, this.mTitleContent, this.mMachineId);
        this.mCollectAndSetEmptyControlUtil.setListener(new CollectAndSetEmptyControlListener() { // from class: client.android.yixiaotong.v4.ui.app.electricitymeter.refund.V4SupervisorInfoControlUtil.1
            @Override // client.android.yixiaotong.v3.ui.appcontrol.listener.CollectAndSetEmptyControlListener
            public void onCollectEnd() {
                V4SupervisorInfoControlUtil.this.mFlowState = FlowState.collectend;
                if (V4SupervisorInfoControlUtil.this.mIsEnable) {
                    V4SupervisorInfoControlUtil.this.getWalletInfo();
                }
            }

            @Override // client.android.yixiaotong.v3.ui.appcontrol.listener.CollectAndSetEmptyControlListener
            public void onSetEmpty() {
                V4SupervisorInfoControlUtil.this.mFlowState = FlowState.setemptyend;
                if (V4SupervisorInfoControlUtil.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    V4SupervisorInfoControlUtil.this.startCollect();
                }
            }

            @Override // client.android.yixiaotong.v3.ui.appcontrol.listener.CollectAndSetEmptyControlListener
            public void onFail(int i2) {
                if (V4SupervisorInfoControlUtil.this.mIsEnable) {
                    V4SupervisorInfoControlUtil.this.onShowFail();
                }
            }
        });
        this.mFlowState = FlowState.none;
    }

    public void startCollect() {
        this.mFlowState = FlowState.collect;
        BaseMaterialDialog.showMaterialDialog(this.mActivity, "开始采集数据中.", false);
        this.mCollectAndSetEmptyControlUtil.startCollect();
    }

    public void startSetEmpty() {
        this.mFlowState = FlowState.setempty;
        BaseMaterialDialog.showMaterialDialog(this.mActivity, "开始清空数据中.", false);
        this.mCollectAndSetEmptyControlUtil.startSetEmpty();
    }

    public void onResume() {
        this.mIsEnable = true;
        V4CollectAndSetEmptyControlUtil v4CollectAndSetEmptyControlUtil = this.mCollectAndSetEmptyControlUtil;
        if (v4CollectAndSetEmptyControlUtil != null) {
            v4CollectAndSetEmptyControlUtil.onResume();
        }
        initBluetooth();
        BluetoothControlUtil.getInstance().onResume();
        V4ErrorControlUtil.getInstance().onResume();
    }

    public void onPause() {
        this.mIsEnable = false;
        BaseMaterialDialog.dissmisMaterialDialog();
        disconnect();
        BluetoothControlUtil.getInstance().onPause();
        V4CollectAndSetEmptyControlUtil v4CollectAndSetEmptyControlUtil = this.mCollectAndSetEmptyControlUtil;
        if (v4CollectAndSetEmptyControlUtil != null) {
            v4CollectAndSetEmptyControlUtil.onPause();
        }
        V4ErrorControlUtil.getInstance().onPause();
    }

    public void startRefund(final V4RefundableAmountBean v4RefundableAmountBean) {
        TwoButtonDialog.getInstance().showDialog(this.mActivity, new TwoButtonDialog.Listener() { // from class: client.android.yixiaotong.v4.ui.app.electricitymeter.refund.V4SupervisorInfoControlUtil.2
            @Override // client.android.yixiaotong.ui.dialog.TwoButtonDialog.Listener
            public void onCancle() {
            }

            @Override // client.android.yixiaotong.ui.dialog.TwoButtonDialog.Listener
            public void onConfirm() {
                if (v4RefundableAmountBean.refundableAmount.equals("0")) {
                    ToastUtils.show(V4SupervisorInfoControlUtil.this.mActivity, "余额为0，不能继续退款");
                } else {
                    V4SubmitRefundActivity.launch(V4SupervisorInfoControlUtil.this.mActivity, 2, v4RefundableAmountBean.refundableAmount, V4SupervisorInfoControlUtil.this.mProductId, V4SupervisorInfoControlUtil.this.mRoomId);
                }
            }
        }, "提示", String.format(this.mActivity.getResources().getString(R.string.refundprepaymentwallet_tip), v4RefundableAmountBean.refundableAmount, "0", v4RefundableAmountBean.refundableAmount), "#ff0289fe", "取消", "继续退款");
    }

    public void initBluetooth() {
        BluetoothSDK.getInstance().init(this.mActivity);
        BluetoothControlUtil.getInstance().init(this.mActivity);
        BluetoothControlUtil.getInstance().setListener(new BluetoothControlUtil.Listener() { // from class: client.android.yixiaotong.v4.ui.app.electricitymeter.refund.V4SupervisorInfoControlUtil.3
            @Override // client.android.yixiaotong.v3.bluetoothutil.BluetoothControlUtil.Listener
            public void onConnected() {
                super.onConnected();
                LogUtil.i(V4SupervisorInfoControlUtil.TAG, "onConnected:" + V4SupervisorInfoControlUtil.this.mFlowState);
                V4SupervisorInfoControlUtil.this.mCollectAndSetEmptyControlUtil.connected();
            }

            @Override // client.android.yixiaotong.v3.bluetoothutil.BluetoothControlUtil.Listener
            public void onFail(int i, String str) {
                super.onFail(i, str);
                LogUtil.i(V4SupervisorInfoControlUtil.TAG, "onFail" + i + "  " + str + PPSLabelView.Code + V4SupervisorInfoControlUtil.this.mFlowState);
                if (str.equalsIgnoreCase("Discover") || str.equalsIgnoreCase("Connect")) {
                    str = "尝试重启手机蓝牙或靠近设备蓝牙再试";
                }
                ToastUtils.show(V4SupervisorInfoControlUtil.this.mActivity, str);
                V4SupervisorInfoControlUtil.this.onShowFail();
            }

            @Override // client.android.yixiaotong.v3.bluetoothutil.BluetoothControlUtil.Listener
            public void onReceivedData(String str) {
                super.onReceivedData(str);
                LogUtil.i(V4SupervisorInfoControlUtil.TAG, "onReceivedData:" + str + PPSLabelView.Code + V4SupervisorInfoControlUtil.this.mFlowState);
                V4SupervisorInfoControlUtil.this.mCollectAndSetEmptyControlUtil.onReceivedData(str);
            }
        });
    }

    private void disconnect() {
        BluetoothControlUtil.getInstance().disconnect();
    }

    public void getWalletInfo() {
        V4BusinessControllers.getInstance().getRefundableAmount(this.mAccount, this.mProductId, this.mRoomId, new Listener<V4RefundableAmountBean>() { // from class: client.android.yixiaotong.v4.ui.app.electricitymeter.refund.V4SupervisorInfoControlUtil.4
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                BaseMaterialDialog.showMaterialDialog(V4SupervisorInfoControlUtil.this.mActivity, "正在获取可退余额..", false);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, V4RefundableAmountBean v4RefundableAmountBean, Object... objArr) {
                if (V4SupervisorInfoControlUtil.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    V4SupervisorInfoControlUtil.this.startRefund(v4RefundableAmountBean);
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (V4SupervisorInfoControlUtil.this.mIsEnable) {
                    V4SupervisorInfoControlUtil.this.onError(clientException, false);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onError(ClientException clientException, boolean z) {
        BaseMaterialDialog.dissmisMaterialDialog();
        V4ErrorControlUtil.getInstance().onError(this.mAccount, clientException, this.mActivity, z, this.mTitleContent);
    }

    private void showDialog(String str) {
        BaseMaterialDialog.dissmisMaterialDialog();
        SystemErrorTip.getInstance().showTipDialog(this.mActivity, str);
    }

    private void showDialogNeedExit(String str) {
        BaseMaterialDialog.dissmisMaterialDialog();
        SystemErrorTip.getInstance().showTipDialog(this.mActivity, "提示", str, "我知道了", false, new SystemErrorTip.SystemErrorDialogListener() { // from class: client.android.yixiaotong.v4.ui.app.electricitymeter.refund.V4SupervisorInfoControlUtil.5
            @Override // client.android.yixiaotong.ui.dialog.SystemErrorTip.SystemErrorDialogListener
            public void onConfirm() {
                V4SupervisorInfoControlUtil.this.mActivity.finish();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onShowFail() {
        BaseMaterialDialog.dissmisMaterialDialog();
        if (this.mFlowState == FlowState.collect) {
            TwoButtonDialog.getInstance().showDialog(this.mActivity, new TwoButtonDialog.Listener() { // from class: client.android.yixiaotong.v4.ui.app.electricitymeter.refund.V4SupervisorInfoControlUtil.6
                @Override // client.android.yixiaotong.ui.dialog.TwoButtonDialog.Listener
                public void onCancle() {
                }

                @Override // client.android.yixiaotong.ui.dialog.TwoButtonDialog.Listener
                public void onConfirm() {
                    V4SupervisorInfoControlUtil.this.startSetEmpty();
                }
            }, "提示", "数据采集失败，请在设备前重试", "#ff0289fe", "取消", "重新采集");
        } else if (this.mFlowState == FlowState.setempty) {
            TwoButtonDialog.getInstance().showDialog(this.mActivity, new TwoButtonDialog.Listener() { // from class: client.android.yixiaotong.v4.ui.app.electricitymeter.refund.V4SupervisorInfoControlUtil.7
                @Override // client.android.yixiaotong.ui.dialog.TwoButtonDialog.Listener
                public void onCancle() {
                }

                @Override // client.android.yixiaotong.ui.dialog.TwoButtonDialog.Listener
                public void onConfirm() {
                    V4SupervisorInfoControlUtil.this.startSetEmpty();
                }
            }, "提示", "清空设备余量失败，请在设备前重试", "#ff0289fe", "取消", "重试");
        }
    }
}
