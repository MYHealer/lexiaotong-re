package client.android.yixiaotong.v3.ui.appcontrol.drinkwater;

import android.app.Activity;
import android.util.Log;
import client.android.yixiaotong.account.Account;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.ui.dialog.BaseMaterialDialog;
import client.android.yixiaotong.ui.dialog.SystemErrorTip;
import client.android.yixiaotong.util.GsonUtils;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.v3.bean.deviceinfo.MachineInfoJson;
import client.android.yixiaotong.v3.bean.deviceinfo.NBOr4GDevice;
import client.android.yixiaotong.v3.bean.deviceinfo.PostOpenAuthBean;
import client.android.yixiaotong.v3.bean.login.TypeInfoBaseInfoBean;
import client.android.yixiaotong.v3.bean.order.NoPayOrderBean;
import client.android.yixiaotong.v3.bluetoothutil.BluetoothControlUtil;
import client.android.yixiaotong.v3.http.V3BusinessControllers;
import client.android.yixiaotong.v3.ui.appcontrol.listener.OpenControlListener;
import client.android.yixiaotong.v3.ui.error.V3ErrorTipActivity;
import client.android.yixiaotong.v3.ui.order.NoPayOrderActivity;
import client.android.yixiaotong.v3.util.LocalDataUtil;
import com.google.gson.reflect.TypeToken;
import com.lxt.bluetoothsdk.model.BluetoothDevice;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class BluetoothOpenControlUtil {
    private static final String TAG = "BleOpenControlUtil";
    private Account mAccount;
    private Activity mActivity;
    private BluetoothDevice mBluetoothDevice;
    private OpenControlListener mControlListener;
    private String mDeviceVer;
    private int mHandleType;
    private boolean mIsEnable;
    private boolean mIsUploadData = false;
    private String mMachineId;
    private String mQrcode;
    private State mState;
    private String mTitleContent;
    private int mTypeId;
    private TypeInfoBaseInfoBean mTypeInfoBaseInfoBean;

    private enum State {
        connecting,
        connected,
        connectfail
    }

    public void init(Activity activity, Account account, BluetoothDevice bluetoothDevice, TypeInfoBaseInfoBean typeInfoBaseInfoBean, int i, String str, String str2) {
        this.mIsEnable = true;
        this.mActivity = activity;
        this.mAccount = account;
        this.mBluetoothDevice = bluetoothDevice;
        this.mTypeInfoBaseInfoBean = typeInfoBaseInfoBean;
        this.mTypeId = i;
        this.mTitleContent = str;
        this.mQrcode = str2;
    }

    public void onPause() {
        this.mIsEnable = false;
    }

    public void onResume() {
        this.mIsEnable = true;
    }

    public void setDeviceInfo(String str, String str2) {
        this.mDeviceVer = str;
        this.mMachineId = str2;
    }

    public void setHandleType(int i) {
        this.mHandleType = i;
    }

    public void setListener(OpenControlListener openControlListener) {
        this.mControlListener = openControlListener;
    }

    private void connectDecice() {
        BluetoothControlUtil.getInstance().connectBluetooth(this.mBluetoothDevice);
    }

    private void disconnect() {
        BluetoothControlUtil.getInstance().disconnect();
    }

    public void openStart() {
        connectDecice();
        if (this.mQrcode.substring(10, 20).equals("0000000000")) {
            this.mIsUploadData = true;
        } else {
            uploadOrder(this.mQrcode);
        }
    }

    public void connected() {
        this.mState = State.connected;
        sendData("aa");
        if (this.mIsUploadData) {
            auth(this.mQrcode);
        }
    }

    private void openEnd() {
        this.mControlListener.onOpenEnd();
    }

    private void openFail() {
        this.mControlListener.onOpenFail();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendAuthData(String str) {
        sendData(str);
        openEnd();
    }

    private void sendData(String str) {
        BluetoothControlUtil.getInstance().setSendTimeOut(10000);
        BluetoothControlUtil.getInstance().sendData(str);
    }

    private void uploadOrder(String str) {
        NBOr4GDevice nBOr4GDevice = new NBOr4GDevice();
        nBOr4GDevice.machineData = str;
        V3BusinessControllers.getInstance().postHandleData(this.mAccount, this.mTypeInfoBaseInfoBean.typeId, this.mMachineId, this.mDeviceVer, nBOr4GDevice, 0, new Listener<Object>() { // from class: client.android.yixiaotong.v3.ui.appcontrol.drinkwater.BluetoothOpenControlUtil.1
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, Object obj, Object... objArr) {
                if (BluetoothOpenControlUtil.this.mIsEnable) {
                    BluetoothOpenControlUtil.this.mIsUploadData = true;
                    if (BluetoothOpenControlUtil.this.mState == State.connected) {
                        BluetoothOpenControlUtil bluetoothOpenControlUtil = BluetoothOpenControlUtil.this;
                        bluetoothOpenControlUtil.auth(bluetoothOpenControlUtil.mQrcode);
                    }
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (BluetoothOpenControlUtil.this.mIsEnable) {
                    if (clientException.getCode() == -52) {
                        ToastUtils.show(BluetoothOpenControlUtil.this.mActivity, clientException.getDetail());
                        String ifNull = GsonUtils.getInstance().parseIfNull(clientException.getObject());
                        Log.e("test", ifNull);
                        NoPayOrderActivity.launch(BluetoothOpenControlUtil.this.mActivity, GsonUtils.getInstance().parseString2List(ifNull, NoPayOrderBean.class), BluetoothOpenControlUtil.this.mTypeInfoBaseInfoBean);
                        BluetoothOpenControlUtil.this.mActivity.finish();
                        return;
                    }
                    BluetoothOpenControlUtil.this.onError(clientException);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void auth(String str) {
        MachineInfoJson machineInfoJson = new MachineInfoJson();
        machineInfoJson.machineData = str;
        int i = this.mTypeId;
        if (i == 3 || i == 16) {
            machineInfoJson.handleType = this.mHandleType;
        }
        V3BusinessControllers.getInstance().postOpenAuth(this.mAccount, 1, this.mTypeInfoBaseInfoBean.typeId, this.mDeviceVer, this.mMachineId, "", machineInfoJson, new Listener<Object>() { // from class: client.android.yixiaotong.v3.ui.appcontrol.drinkwater.BluetoothOpenControlUtil.2
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, Object obj, Object... objArr) {
                if (BluetoothOpenControlUtil.this.mIsEnable) {
                    String ifNull = GsonUtils.getInstance().parseIfNull(obj);
                    Log.e(BluetoothOpenControlUtil.TAG, ifNull);
                    try {
                        BluetoothOpenControlUtil.this.sendAuthData(((PostOpenAuthBean) GsonUtils.getInstance().parse(new TypeToken<PostOpenAuthBean>() { // from class: client.android.yixiaotong.v3.ui.appcontrol.drinkwater.BluetoothOpenControlUtil.2.1
                        }.getType(), ifNull)).sendMachineData);
                    } catch (ClientException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (BluetoothOpenControlUtil.this.mIsEnable) {
                    if (clientException.getCode() == -52) {
                        ToastUtils.show(BluetoothOpenControlUtil.this.mActivity, clientException.getDetail());
                        String ifNull = GsonUtils.getInstance().parseIfNull(clientException.getObject());
                        Log.e("test", ifNull);
                        NoPayOrderActivity.launch(BluetoothOpenControlUtil.this.mActivity, GsonUtils.getInstance().parseString2List(ifNull, NoPayOrderBean.class), BluetoothOpenControlUtil.this.mTypeInfoBaseInfoBean);
                        BluetoothOpenControlUtil.this.mActivity.finish();
                        return;
                    }
                    BluetoothOpenControlUtil.this.onError(clientException);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onError(ClientException clientException) {
        BaseMaterialDialog.dissmisMaterialDialog();
        if (clientException.isNeedTip(clientException.getCode())) {
            openFail();
            SystemErrorTip.getInstance().showTipDialog(this.mActivity, new SystemErrorTip.SystemErrorDialogListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.drinkwater.BluetoothOpenControlUtil.3
                @Override // client.android.yixiaotong.ui.dialog.SystemErrorTip.SystemErrorDialogListener
                public void onConfirm() {
                    BluetoothOpenControlUtil.this.mActivity.finish();
                }
            }, clientException.getDetail() + "\n(" + LocalDataUtil.getTraceID(this.mActivity) + ")");
        } else {
            V3ErrorTipActivity.launch(this.mActivity, this.mTitleContent, clientException.getDetail(), clientException.getCode(), 2, clientException.getSerial());
            this.mActivity.finish();
        }
    }
}
