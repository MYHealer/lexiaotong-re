package client.android.yixiaotong.ui.bluetoothtwo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.baseutil.RandomUtils;
import client.android.yixiaotong.controller.BusinessControllers;
import client.android.yixiaotong.controller.bean.BillOrderBean;
import client.android.yixiaotong.controller.bean.OpenDataBean;
import client.android.yixiaotong.controller.bean.bath.BathUploadOrderBean;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.controller.error.ErrorUtil;
import client.android.yixiaotong.controller.model.WalletModel;
import client.android.yixiaotong.controller.store.LocalBusinessStore;
import client.android.yixiaotong.sdk.LeXiaoTongSDK;
import client.android.yixiaotong.sdk.bluetooth.BluetoothDevice;
import client.android.yixiaotong.sdk.runnable.OrderBean;
import client.android.yixiaotong.sdk.runnable.TimeOut;
import client.android.yixiaotong.sdk.runnable.listener.CloseListener;
import client.android.yixiaotong.sdk.runnable.listener.ScanListener;
import client.android.yixiaotong.sdk.utils.BathUtil;
import client.android.yixiaotong.sdk.utils.ClientException;
import client.android.yixiaotong.ui.dialog.BaseMaterialDialog;
import client.android.yixiaotong.ui.dialog.ConnectDeviceFailDialog;
import client.android.yixiaotong.ui.dialog.SystemErrorTip;
import client.android.yixiaotong.ui.pay.PayOrderActivity;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.util.android.NetworkUtils;
import client.android.yixiaotong.util.executor.MainThreadExecutor;
import client.android.yixiaotong.util.permission.PermissionUtil;
import client.android.yixiaotong.v3.ui.adv.AdvControlUtil;
import client.android.yixiaotong.v3.ui.adv.Common;
import client.android.yixiaotong.v3.ui.adv.InsertUtil;
import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.huawei.openalliance.ad.constant.x;
import com.stub.StubApp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class BluetoothDetailTwoActivity extends BaseActivity {
    private static final String TAG = "BluetoothDetailTwoActivity";
    private FrameLayout flContainer;
    private TextView mAddressView;
    private AdvControlUtil.AdvListener mAdvListener;
    private BluetoothDevice mBluetoothDevice2;
    private Button mControllerButton;
    private State mCurrentState;
    private Status mCurrentStatus;
    private String mDeviceHexID;
    private String mDeviceMac;
    private String mDeviceName;
    private String mF5Data;
    private InsertUtil mInsertUtil;
    private TextView mNameView;
    private short mOrderMoney;
    private String mOrderTime;
    private long mOrderuserId;
    private String mStudentId;
    private TitleBar mTitleBar;
    private WalletModel mWalletModel;
    public String mAuthorizedData = "";
    private boolean mIsEnable = true;
    private ScanListener mScanListener = new ScanListener() { // from class: client.android.yixiaotong.ui.bluetoothtwo.BluetoothDetailTwoActivity.5
        @Override // client.android.yixiaotong.sdk.runnable.listener.ScanListener
        public void onStart() {
            BluetoothDetailTwoActivity.this.mCurrentState = State.scaning;
        }

        @Override // client.android.yixiaotong.sdk.runnable.listener.ScanListener
        public void onScan(BluetoothDevice bluetoothDevice) {
            if (bluetoothDevice.equals(BluetoothDetailTwoActivity.this.mDeviceMac)) {
                BluetoothDetailTwoActivity.this.mCurrentState = State.scanend;
                BluetoothDetailTwoActivity.this.mBluetoothDevice2 = bluetoothDevice;
                LeXiaoTongSDK.getInstance().stopScanBluetoothDevices();
                if (BaseMaterialDialog.isShowMaterialDialog()) {
                    BaseMaterialDialog.setConnectMaterialDialog("已经搜索到蓝牙水控设备，正在连接设备...");
                    BluetoothDetailTwoActivity.this.mCloseCount = 0;
                    BluetoothDetailTwoActivity.this.close();
                }
            }
        }

        @Override // client.android.yixiaotong.sdk.runnable.listener.ScanListener
        public void onComplete() {
            if (BluetoothDetailTwoActivity.this.mCurrentState == State.scaning) {
                BaseMaterialDialog.dissmisMaterialDialog();
                LeXiaoTongSDK.getInstance().stopScanBluetoothDevices();
                new MaterialDialog.Builder(BluetoothDetailTwoActivity.this.getContext()).title("搜索蓝牙水控失败").content("1、请检查设备是否有人正在使用。\n2、请把手机靠近设备后再重试。\n3、按一下设备上的按钮，设备重起后再重试！").positiveText("确定").onPositive(new MaterialDialog.SingleButtonCallback() { // from class: client.android.yixiaotong.ui.bluetoothtwo.BluetoothDetailTwoActivity.5.1
                    @Override // com.afollestad.materialdialogs.MaterialDialog.SingleButtonCallback
                    public void onClick(MaterialDialog materialDialog, DialogAction dialogAction) {
                    }
                }).show();
            }
            BluetoothDetailTwoActivity.this.mCurrentState = State.scanend;
        }

        @Override // client.android.yixiaotong.sdk.runnable.listener.ScanListener
        public void onBluetoothException(ClientException clientException) {
            if (BluetoothDetailTwoActivity.this.mIsEnable) {
                SystemErrorTip.getInstance().showTipDialog(BluetoothDetailTwoActivity.this.getActivity(), clientException.getDetail());
            }
        }
    };
    private int mCloseCount = 0;
    private CloseListener closeListener = new CloseListener() { // from class: client.android.yixiaotong.ui.bluetoothtwo.BluetoothDetailTwoActivity.6
        @Override // client.android.yixiaotong.sdk.runnable.listener.CloseListener
        public void onFail(BluetoothDevice bluetoothDevice, TimeOut timeOut, String str) {
            String str2;
            if (BluetoothDetailTwoActivity.this.mIsEnable) {
                BaseMaterialDialog.dissmisMaterialDialog();
                if (BluetoothDetailTwoActivity.this.mCurrentStatus != Status.Closed) {
                    if (StringUtils.isNotEmpty(str)) {
                        SystemErrorTip.getInstance().showTipDialog(BluetoothDetailTwoActivity.this.getActivity(), str);
                        return;
                    }
                    if (timeOut == TimeOut.Connect) {
                        str2 = "关阀失败，请长按设备上的按钮关阀";
                    } else if (timeOut == TimeOut.Discover) {
                        str2 = "关阀失败，请长按设备上的按钮关阀.";
                    } else if (timeOut == TimeOut.SendCloseGetDeviceSetting || timeOut == TimeOut.SendCloseAA) {
                        str2 = "获取设备信息失败";
                    } else if (timeOut == TimeOut.SendCloseAbort) {
                        str2 = "关阀失败";
                    } else if (timeOut == TimeOut.SendCloseConnect) {
                        str2 = "采集订单失败";
                    } else {
                        str2 = timeOut == TimeOut.SendCloseConfirm ? "上传订单失败" : "关阀失败" + str;
                    }
                    if (timeOut == TimeOut.SendCloseConfirm || timeOut == TimeOut.SendCloseConnect) {
                        ToastUtils.show(BluetoothDetailTwoActivity.this.getContext(), "关阀成功");
                        BluetoothDetailTwoActivity.this.finish();
                    } else {
                        SystemErrorTip.getInstance().showTipDialog(BluetoothDetailTwoActivity.this.getActivity(), str2);
                    }
                }
            }
        }

        @Override // client.android.yixiaotong.sdk.runnable.listener.CloseListener
        public void onSuccess(BluetoothDevice bluetoothDevice) {
            if (BluetoothDetailTwoActivity.this.mIsEnable) {
                BluetoothDetailTwoActivity.this.mCurrentStatus = Status.Closed;
                BaseMaterialDialog.dissmisMaterialDialog();
                if (BluetoothDetailTwoActivity.this.mOrderuserId == BluetoothDetailTwoActivity.this.getLoginAccount().getUid()) {
                    ArrayList arrayList = new ArrayList();
                    BillOrderBean billOrderBean = new BillOrderBean();
                    billOrderBean.applicationType = BluetoothDetailTwoActivity.this.mWalletModel.typeId;
                    billOrderBean.consumeAmount = BluetoothDetailTwoActivity.this.mOrderMoney;
                    billOrderBean.consumeTime = BluetoothDetailTwoActivity.this.mOrderTime;
                    arrayList.add(billOrderBean);
                    PayOrderActivity.launch(BluetoothDetailTwoActivity.this.getActivity(), BluetoothDetailTwoActivity.this.mWalletModel.typeId, arrayList);
                }
                BluetoothDetailTwoActivity.this.finish();
            }
        }

        @Override // client.android.yixiaotong.sdk.runnable.listener.CloseListener
        public void onBluetoothException(ClientException clientException) {
            Log.e("test", "  " + BluetoothDetailTwoActivity.this.mCloseCount);
            if (BluetoothDetailTwoActivity.this.mIsEnable) {
                if (BluetoothDetailTwoActivity.this.mCloseCount >= 3) {
                    if (BluetoothDetailTwoActivity.this.mCurrentStatus != Status.Closeing) {
                        ToastUtils.show(BluetoothDetailTwoActivity.this.getContext(), "关阀成功");
                        BluetoothDetailTwoActivity.this.finish();
                    } else {
                        BaseMaterialDialog.dissmisMaterialDialog();
                        new ConnectDeviceFailDialog().showTipDialog(BluetoothDetailTwoActivity.this.getActivity(), new ConnectDeviceFailDialog.TipDialogListener() { // from class: client.android.yixiaotong.ui.bluetoothtwo.BluetoothDetailTwoActivity.6.2
                            @Override // client.android.yixiaotong.ui.dialog.ConnectDeviceFailDialog.TipDialogListener
                            public void onMoreHelp() {
                            }

                            @Override // client.android.yixiaotong.ui.dialog.ConnectDeviceFailDialog.TipDialogListener
                            public void onQiehuan() {
                            }

                            @Override // client.android.yixiaotong.ui.dialog.ConnectDeviceFailDialog.TipDialogListener
                            public void onConnect() {
                                BluetoothDetailTwoActivity.this.mCloseCount = 0;
                                BluetoothDetailTwoActivity.this.close();
                            }
                        }, BluetoothDetailTwoActivity.this.mBluetoothDevice2.rssi, false);
                    }
                } else {
                    MainThreadExecutor.getInstance().executeDelayed(new Runnable() { // from class: client.android.yixiaotong.ui.bluetoothtwo.BluetoothDetailTwoActivity.6.1
                        @Override // java.lang.Runnable
                        public void run() {
                            BluetoothDetailTwoActivity.this.close();
                        }
                    }, 800L);
                }
                BluetoothDetailTwoActivity.access$308(BluetoothDetailTwoActivity.this);
            }
        }

        @Override // client.android.yixiaotong.sdk.runnable.listener.CloseListener
        public boolean needUploadOrder(BluetoothDevice bluetoothDevice, OrderBean orderBean) {
            BluetoothDetailTwoActivity.this.mCloseCount = 3;
            BaseMaterialDialog.setConnectMaterialDialog("关阀成功..");
            BluetoothDetailTwoActivity.this.mCurrentStatus = Status.CloseingUpload;
            BluetoothDetailTwoActivity.this.uploadOrder(orderBean);
            BluetoothDetailTwoActivity.this.mOrderuserId = orderBean.studentNo;
            BluetoothDetailTwoActivity.this.mOrderMoney = orderBean.money;
            BluetoothDetailTwoActivity.this.mOrderTime = orderBean.time;
            return true;
        }

        @Override // client.android.yixiaotong.sdk.runnable.listener.CloseListener
        public void needUploadOrder(BluetoothDevice bluetoothDevice, OrderBean orderBean, String str) {
            BluetoothDetailTwoActivity.this.mCloseCount = 3;
            BaseMaterialDialog.setConnectMaterialDialog("关阀成功...");
            BluetoothDetailTwoActivity.this.mCurrentStatus = Status.CloseingUpload;
            BluetoothDetailTwoActivity.this.mOrderuserId = orderBean.studentNo;
            BluetoothDetailTwoActivity.this.mOrderMoney = orderBean.money;
            BluetoothDetailTwoActivity.this.mOrderTime = orderBean.time;
            BluetoothDetailTwoActivity.this.uploadOrderNew(orderBean, str, "0000", 1);
        }

        @Override // client.android.yixiaotong.sdk.runnable.listener.CloseListener
        public String onCloseDate(BluetoothDevice bluetoothDevice) {
            return new SimpleDateFormat("yyMMddHHmmss").format(Calendar.getInstance().getTime());
        }

        @Override // client.android.yixiaotong.sdk.runnable.listener.CloseListener
        public String onf1(BluetoothDevice bluetoothDevice, String str) {
            return BluetoothDetailTwoActivity.this.mAuthorizedData;
        }

        @Override // client.android.yixiaotong.sdk.runnable.listener.CloseListener
        public void onDataV3(BluetoothDevice bluetoothDevice, String str) {
            if (BluetoothDetailTwoActivity.this.mIsEnable) {
                if ((str.startsWith("55") && str.length() == 40 && !str.startsWith("550001")) || ((str.length() == 18 && str.toUpperCase().startsWith("AA")) || str.toUpperCase().equals("A5") || str.toUpperCase().equals("AC"))) {
                    if (str.toUpperCase().equals("A5")) {
                        LeXiaoTongSDK.getInstance().sendDataV3("AC" + BathUtil.getStudentId(BluetoothDetailTwoActivity.this.mStudentId));
                    } else if (!str.startsWith("55") || str.length() != 40) {
                        SystemErrorTip.getInstance().showTipDialog(BluetoothDetailTwoActivity.this.getActivity(), "设备忙");
                    } else {
                        BluetoothDetailTwoActivity.this.uploadOrder(str.substring(2, 10), str);
                    }
                }
            }
        }
    };
    private PermissionUtil.PermissionGrant permissionGrant = new PermissionUtil.PermissionGrant() { // from class: client.android.yixiaotong.ui.bluetoothtwo.BluetoothDetailTwoActivity.10
        @Override // client.android.yixiaotong.util.permission.PermissionUtil.PermissionGrant
        public void onPermissionGranted(int i) {
        }
    };
    private boolean mIsOpenPopAdv = false;

    private enum State {
        scaning,
        scansuccess,
        scanend,
        connecting,
        connected,
        senddata
    }

    enum Status {
        Opening,
        OpeningUpload,
        Opened,
        Closeing,
        CloseingUpload,
        Closed
    }

    static {
        StubApp.interface11(6508);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public native void onRequestPermissionsResult(int i, String[] strArr, int[] iArr);

    static /* synthetic */ int access$308(BluetoothDetailTwoActivity bluetoothDetailTwoActivity) {
        int i = bluetoothDetailTwoActivity.mCloseCount;
        bluetoothDetailTwoActivity.mCloseCount = i + 1;
        return i;
    }

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.titleBar);
        this.mNameView = (TextView) findViewById(R.id.name);
        this.mAddressView = (TextView) findViewById(R.id.address);
        this.mControllerButton = (Button) findViewById(R.id.controller);
        this.flContainer = (FrameLayout) findViewById(R.id.flContainer);
    }

    public static void launch(Activity activity, String str, String str2, String str3, String str4, String str5) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) BluetoothDetailTwoActivity.class).putExtra("deviceMac", str).putExtra("name", str2).putExtra("devicehexid", str3).putExtra("f5data", str4).putExtra("studentid", str5));
        }
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.mIsEnable = true;
        AdvControlUtil.getInstance().onResume();
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        this.mIsEnable = false;
        AdvControlUtil.getInstance().onPause();
    }

    @Override // client.android.yixiaotong.BaseActivity
    public void onPostCreate() {
        super.onPostCreate();
        initWallet();
        initControllerButtonWithStop();
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        BaseMaterialDialog.dissmisMaterialDialog();
        LeXiaoTongSDK.getInstance().closeBLE();
        AdvControlUtil.getInstance().onDestroy(getActivity());
        InsertUtil insertUtil = this.mInsertUtil;
        if (insertUtil != null) {
            insertUtil.onDestroy(getActivity());
        }
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
    }

    private void initWallet() {
        BusinessControllers.getInstance().getRelationWallet(getLoginAccount(), 1, new Listener<WalletModel>() { // from class: client.android.yixiaotong.ui.bluetoothtwo.BluetoothDetailTwoActivity.1
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, WalletModel walletModel, Object... objArr) {
                if (walletModel == null || walletModel.getBalance() <= 0) {
                    BluetoothDetailTwoActivity.this.mWalletModel = null;
                    ToastUtils.show(BluetoothDetailTwoActivity.this.getContext(), "余额不足,请充值", 1);
                    BluetoothDetailTwoActivity.this.finish();
                    return;
                }
                BluetoothDetailTwoActivity.this.mWalletModel = walletModel;
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, client.android.yixiaotong.exception.ClientException clientException) {
                BluetoothDetailTwoActivity.this.mWalletModel = null;
                ToastUtils.show(BluetoothDetailTwoActivity.this.getContext(), "暂不支持此设备", 1);
                BluetoothDetailTwoActivity.this.finish();
            }
        });
    }

    private void initControllerButtonWithStop() {
        if (getLoginAccount().getAccountManagetStore().getUserInfo().UserType != 1) {
            LocalBusinessStore.saveConnectCountToday(getContext(), this.mDeviceMac.replace(x.bQ, ""), getLoginAccount().getUid());
        }
        this.mControllerButton.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.bluetoothtwo.BluetoothDetailTwoActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BluetoothDetailTwoActivity.this.mCloseCount = 0;
                LeXiaoTongSDK.getInstance().startScanBluetoothDevices(BluetoothDetailTwoActivity.this.mScanListener);
                BluetoothDetailTwoActivity.this.mCurrentState = State.scaning;
                BaseMaterialDialog.showMaterialDialog(BluetoothDetailTwoActivity.this.getActivity(), "正在搜索" + BluetoothDetailTwoActivity.this.mDeviceName, false);
            }
        });
    }

    public String getData() {
        return new SimpleDateFormat("yyMMddHHmmss").format(Calendar.getInstance().getTime());
    }

    private void initTitleBar() {
        this.mTitleBar.setLeftViewIsBack();
        this.mTitleBar.setTitleView("设备详情");
        this.mTitleBar.setLeftViewOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.bluetoothtwo.BluetoothDetailTwoActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                new MaterialDialog.Builder(BluetoothDetailTwoActivity.this.getActivity()).title("提示").content("您确定您在水控设备上结算了吗？").positiveText("结算了").negativeText("未结算").onPositive(new MaterialDialog.SingleButtonCallback() { // from class: client.android.yixiaotong.ui.bluetoothtwo.BluetoothDetailTwoActivity.3.2
                    @Override // com.afollestad.materialdialogs.MaterialDialog.SingleButtonCallback
                    public void onClick(MaterialDialog materialDialog, DialogAction dialogAction) {
                        BluetoothDetailTwoActivity.this.finish();
                    }
                }).onNegative(new MaterialDialog.SingleButtonCallback() { // from class: client.android.yixiaotong.ui.bluetoothtwo.BluetoothDetailTwoActivity.3.1
                    @Override // com.afollestad.materialdialogs.MaterialDialog.SingleButtonCallback
                    public void onClick(MaterialDialog materialDialog, DialogAction dialogAction) {
                    }
                }).show();
            }
        });
        if (getLoginAccount().getAccountManagetStore().getUserInfo().UserType == 1 && StringUtils.isNotEmpty(this.mF5Data)) {
            this.mTitleBar.setRightViewTextColor(-14385452);
            this.mTitleBar.setRightView("参数设置");
            this.mTitleBar.setRightViewOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.bluetoothtwo.BluetoothDetailTwoActivity.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (BluetoothDetailTwoActivity.this.mF5Data.length() == 68) {
                        SettingDeviceTwoActivity.launch(BluetoothDetailTwoActivity.this.getActivity(), BluetoothDetailTwoActivity.this.mDeviceMac, BluetoothDetailTwoActivity.this.mDeviceHexID, 1, BluetoothDetailTwoActivity.this.mF5Data);
                    } else if (BluetoothDetailTwoActivity.this.mF5Data.length() <= 74 || !BluetoothDetailTwoActivity.this.mF5Data.substring(70, 74).equalsIgnoreCase("5631")) {
                        SettingDeviceTwoActivity.launch(BluetoothDetailTwoActivity.this.getActivity(), BluetoothDetailTwoActivity.this.mDeviceMac, BluetoothDetailTwoActivity.this.mDeviceHexID, 2, BluetoothDetailTwoActivity.this.mF5Data);
                    } else {
                        SetBluetoothDeviceActivity.launch(BluetoothDetailTwoActivity.this.getActivity(), BluetoothDetailTwoActivity.this.mDeviceMac, BluetoothDetailTwoActivity.this.mDeviceHexID, 2, BluetoothDetailTwoActivity.this.mF5Data);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void close() {
        this.mCurrentStatus = Status.Closeing;
        BaseMaterialDialog.showMaterialDialog(getActivity(), "正在关阀...", false);
        this.mAuthorizedData = "";
        LeXiaoTongSDK.getInstance().closeDevice(new BluetoothDevice(this.mDeviceName, this.mDeviceMac, 0), this.closeListener, getLoginAccount().getUid(), (short) this.mWalletModel.getBalance(), NetworkUtils.isNetwork);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uploadOrder(OrderBean orderBean) {
        BusinessControllers.getInstance().uploadOrder(getLoginAccount(), this.mDeviceHexID, 1, orderBean.studentNo, orderBean.money, orderBean.time, new Listener<Boolean>() { // from class: client.android.yixiaotong.ui.bluetoothtwo.BluetoothDetailTwoActivity.7
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                BaseMaterialDialog.setConnectMaterialDialog("关阀成功，正在上传订单.");
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, Boolean bool, Object... objArr) {
                if (BluetoothDetailTwoActivity.this.mIsEnable && BaseMaterialDialog.isShowMaterialDialog()) {
                    ToastUtils.showLog(BluetoothDetailTwoActivity.this.getContext(), "订单上传成功");
                    LeXiaoTongSDK.getInstance().closeUploadOrder(true);
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, client.android.yixiaotong.exception.ClientException clientException) {
                if (BluetoothDetailTwoActivity.this.mIsEnable && BaseMaterialDialog.isShowMaterialDialog()) {
                    if (clientException.getCode() == 6001) {
                        LeXiaoTongSDK.getInstance().closeUploadOrder(true);
                    } else {
                        BaseMaterialDialog.dissmisMaterialDialog();
                        ErrorUtil.onFailResult(BluetoothDetailTwoActivity.this.getActivity(), BluetoothDetailTwoActivity.this.mTitleBar.getTitleViewContent(), clientException, true);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uploadOrderNew(OrderBean orderBean, String str, String str2, int i) {
        BusinessControllers.getInstance().uploadOrder("", getLoginAccount(), this.mDeviceHexID, this.mWalletModel.typeId, orderBean.studentNo, orderBean.money, orderBean.time, orderBean.offineTimes, Long.parseLong(getLoginAccount().getAccountManagetStore().getUserInfo().InvestorId), i, (short) this.mWalletModel.getBalance(), Integer.parseInt(getLoginAccount().getAccountManagetStore().getUserInfo().AreaId + ""), str, str2, RandomUtils.getRandomString2(), new Listener<OpenDataBean>() { // from class: client.android.yixiaotong.ui.bluetoothtwo.BluetoothDetailTwoActivity.8
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                BaseMaterialDialog.setConnectMaterialDialog("关阀成功，正在上传订单..");
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, OpenDataBean openDataBean, Object... objArr) {
                if (BluetoothDetailTwoActivity.this.mIsEnable) {
                    ToastUtils.show(BluetoothDetailTwoActivity.this.getContext(), "上传订单成功");
                    if (openDataBean != null) {
                        try {
                            openDataBean.setmOpenData(new JSONObject(openDataBean.Records.toString()));
                            BluetoothDetailTwoActivity.this.mAuthorizedData = openDataBean.getmOpenData().AuthorizedData;
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                    LeXiaoTongSDK.getInstance().closeUploadOrder(true);
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, client.android.yixiaotong.exception.ClientException clientException) {
                if (BluetoothDetailTwoActivity.this.mIsEnable) {
                    ErrorUtil.onFailResult(BluetoothDetailTwoActivity.this.getActivity(), BluetoothDetailTwoActivity.this.mTitleBar.getTitleViewContent(), clientException, true);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uploadOrder(String str, String str2) {
        int i = getLoginAccount().getAccountManagetStore().getUserInfo().UserType != 1 ? 0 : 1;
        BusinessControllers.getInstance().postBathUploadOrder(getLoginAccount(), i, str, str2, 1, client.android.yixiaotong.util.random.RandomUtils.getRandNumMaxStringNonO(6), new Listener<BathUploadOrderBean>() { // from class: client.android.yixiaotong.ui.bluetoothtwo.BluetoothDetailTwoActivity.9
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                BaseMaterialDialog.setConnectMaterialDialog("关阀成功，正在上传订单...");
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, BathUploadOrderBean bathUploadOrderBean, Object... objArr) {
                if (BluetoothDetailTwoActivity.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    if (bathUploadOrderBean.studentId.equals(BluetoothDetailTwoActivity.this.mStudentId) && StringUtils.isNotEmpty(bathUploadOrderBean.pay)) {
                        ArrayList arrayList = new ArrayList();
                        BillOrderBean billOrderBean = new BillOrderBean();
                        billOrderBean.applicationType = BluetoothDetailTwoActivity.this.mWalletModel.typeId;
                        billOrderBean.consumeAmount = Integer.parseInt(bathUploadOrderBean.pay);
                        billOrderBean.consumeTime = bathUploadOrderBean.settleTime;
                        arrayList.add(billOrderBean);
                        PayOrderActivity.launch(BluetoothDetailTwoActivity.this.getActivity(), BluetoothDetailTwoActivity.this.mWalletModel.typeId, arrayList);
                    }
                    BluetoothDetailTwoActivity.this.finish();
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, client.android.yixiaotong.exception.ClientException clientException) {
                if (BluetoothDetailTwoActivity.this.mIsEnable) {
                    ErrorUtil.onFailResult(BluetoothDetailTwoActivity.this.getActivity(), BluetoothDetailTwoActivity.this.mTitleBar.getTitleViewContent(), clientException, true);
                }
            }
        });
    }

    private void getAdv() {
        this.mInsertUtil = new InsertUtil();
        this.mAdvListener = new AdvControlUtil.AdvListener() { // from class: client.android.yixiaotong.ui.bluetoothtwo.BluetoothDetailTwoActivity.11
            @Override // client.android.yixiaotong.v3.ui.adv.AdvControlUtil.AdvListener
            public void onAdClosed(Common.AdvType advType) {
            }

            @Override // client.android.yixiaotong.v3.ui.adv.AdvControlUtil.AdvListener
            public void onAdShow(String str, Common.AdvType advType) {
            }

            @Override // client.android.yixiaotong.v3.ui.adv.AdvControlUtil.AdvListener
            public void onRenderSuccess(View view, int i) {
            }

            @Override // client.android.yixiaotong.v3.ui.adv.AdvControlUtil.AdvListener
            public void isOpen(int i, int i2, int i3, int i4, int i5) {
                if (i == 1) {
                    BluetoothDetailTwoActivity.this.mIsOpenPopAdv = true;
                    BluetoothDetailTwoActivity.this.mInsertUtil.onCreate(BluetoothDetailTwoActivity.this.getActivity());
                    BluetoothDetailTwoActivity.this.requestInteraction();
                }
            }
        };
        AdvControlUtil.getInstance().init(getActivity(), this.mAdvListener, 1, false, getLoginAccount().getAccountManagetStore().getUserInfo().AreaId + "");
        AdvControlUtil.getInstance().initAdvInfo();
    }

    public void requestInteraction() {
        if (this.mIsOpenPopAdv) {
            PermissionUtil.requestPerssion(getActivity(), 4, this.permissionGrant);
            this.mInsertUtil.initInsert(getActivity(), this.mAdvListener, false, getLoginAccount().getAccountManagetStore().getUserInfo().AreaId + "", false);
            this.mInsertUtil.onInsert();
        }
    }
}
