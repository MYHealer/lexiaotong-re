package client.android.yixiaotong.ui.bluetoothtwo;

import android.app.Activity;
import android.client.bluetoothsdk.util.HexString;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.baseutil.RandomUtils;
import client.android.yixiaotong.controller.BusinessControllers;
import client.android.yixiaotong.controller.bean.OpenDataBean;
import client.android.yixiaotong.controller.bean.SuccessBean;
import client.android.yixiaotong.controller.bean.bath.BathAuthNewBean;
import client.android.yixiaotong.controller.bean.bath.BathUploadOrderNewBean;
import client.android.yixiaotong.controller.bean.set.SetBean;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.controller.error.ErrorUtil;
import client.android.yixiaotong.controller.model.WalletModel;
import client.android.yixiaotong.controller.store.LocalBusinessStore;
import client.android.yixiaotong.sdk.LeXiaoTongSDK;
import client.android.yixiaotong.sdk.bluetooth.BluetoothDevice;
import client.android.yixiaotong.sdk.runnable.OrderBean;
import client.android.yixiaotong.sdk.runnable.TimeOut;
import client.android.yixiaotong.sdk.runnable.listener.OpenListener;
import client.android.yixiaotong.sdk.runnable.listener.SettingListener;
import client.android.yixiaotong.sdk.utils.ClientException;
import client.android.yixiaotong.sdk.utils.RandomUtil;
import client.android.yixiaotong.ui.dialog.BaseMaterialDialog;
import client.android.yixiaotong.ui.dialog.SystemErrorTip;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.BathUtil;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.TimeUtils;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.util.android.NetworkUtils;
import client.android.yixiaotong.util.bluetooth.CommandUtils;
import client.android.yixiaotong.util.drinkwater.PreferenceUtil;
import client.android.yixiaotong.util.executor.MainThreadExecutor;
import client.android.yixiaotong.util.permission.PermissionUtil;
import client.android.yixiaotong.v3.ui.adv.AdvControlUtil;
import client.android.yixiaotong.v3.ui.adv.Common;
import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.stub.StubApp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class BathOpenActivity extends BaseActivity {
    private static final String TYPE_DEVICEMAC = "type_devicemac";
    private FrameLayout flContainer;
    private String mAuthData;
    private int mConsumptionTimes;
    private String mDeviceHexID;
    private String mDeviceMac;
    private String mDeviceName;
    private String mF0Data;
    private String mF5Data;
    private String mF8Data;
    private boolean mIsEnadle;
    private String mKey;
    private TextView mOpenSuccess;
    private String mStudentId;
    private String mSystemData;
    private TextView mTime;
    private TitleBar mTitleBar;
    private WalletModel mWalletModel;
    private TimeCount time;
    private boolean mmIsAddConsumptionTimes = false;
    public String mAuthorizedData = "";
    private boolean mIsConnected = true;
    private SystemErrorTip.SystemErrorDialogListener mSystemErrorDialogListener = new SystemErrorTip.SystemErrorDialogListener() { // from class: client.android.yixiaotong.ui.bluetoothtwo.BathOpenActivity.1
        @Override // client.android.yixiaotong.ui.dialog.SystemErrorTip.SystemErrorDialogListener
        public void onConfirm() {
            BathOpenActivity.this.finish();
        }
    };
    private boolean mIsOpened = false;
    private boolean mIsErrorEnd = false;
    private OpenListener openListener = new OpenListener() { // from class: client.android.yixiaotong.ui.bluetoothtwo.BathOpenActivity.9
        @Override // client.android.yixiaotong.sdk.runnable.listener.OpenListener
        public void onConnectSuccessV3(BluetoothDevice bluetoothDevice, String str) {
        }

        @Override // client.android.yixiaotong.sdk.runnable.listener.OpenListener
        public String onGetStudentId(BluetoothDevice bluetoothDevice) {
            return "5551C4B8";
        }

        @Override // client.android.yixiaotong.sdk.runnable.listener.OpenListener
        public boolean needUploadOrder(BluetoothDevice bluetoothDevice, OrderBean orderBean) {
            if (BaseMaterialDialog.isShowMaterialDialog()) {
                BaseMaterialDialog.setConnectMaterialDialog("设备正在启动中..");
            } else {
                BathOpenActivity.this.finish();
            }
            BathOpenActivity.this.uploadOrder(orderBean);
            return true;
        }

        @Override // client.android.yixiaotong.sdk.runnable.listener.OpenListener
        public void needUploadOrder(BluetoothDevice bluetoothDevice, OrderBean orderBean, String str) {
            BaseMaterialDialog.setConnectMaterialDialog("设备正在启动中...");
            BathOpenActivity.this.uploadOrderNew(orderBean, str, BathOpenActivity.this.mIsOpened ? "0004" : "0000", 1);
        }

        @Override // client.android.yixiaotong.sdk.runnable.listener.OpenListener
        public short callBalance(BluetoothDevice bluetoothDevice) {
            if (BathOpenActivity.this.mWalletModel.getBalance() > 30000) {
                return (short) 30000;
            }
            return (short) BathOpenActivity.this.mWalletModel.getBalance();
        }

        @Override // client.android.yixiaotong.sdk.runnable.listener.OpenListener
        public String onOpenDate(BluetoothDevice bluetoothDevice) {
            return new SimpleDateFormat("yyMMddHHmmss").format(Calendar.getInstance().getTime());
        }

        @Override // client.android.yixiaotong.sdk.runnable.listener.OpenListener
        public String onf1(BluetoothDevice bluetoothDevice, String str, String str2) {
            if (!StringUtils.isNotEmpty(BathOpenActivity.this.mAuthorizedData)) {
                OrderBean orderBean = new OrderBean();
                orderBean.studentNo = 0L;
                orderBean.time = "";
                orderBean.money = (short) 0;
                BathOpenActivity.this.uploadOrderNew(orderBean, str2, "0000", 0);
            } else {
                LeXiaoTongSDK.getInstance().openForF1(BathOpenActivity.this.mAuthorizedData);
                BathOpenActivity.this.mAuthorizedData = "";
            }
            return BathOpenActivity.this.mAuthorizedData;
        }

        @Override // client.android.yixiaotong.sdk.runnable.listener.OpenListener
        public void onBluetoothException(ClientException clientException) {
            if (BathOpenActivity.this.mIsOpened || !BathOpenActivity.this.mIsEnadle) {
                return;
            }
            SystemErrorTip.getInstance().showTipDialog(BathOpenActivity.this.getActivity(), BathOpenActivity.this.mSystemErrorDialogListener, clientException.getDetail());
            BaseMaterialDialog.dissmisMaterialDialog();
        }

        @Override // client.android.yixiaotong.sdk.runnable.listener.OpenListener
        public void onFail(BluetoothDevice bluetoothDevice, TimeOut timeOut, String str) {
            String str2;
            Log.e("test", timeOut + "  " + str);
            if (!BathOpenActivity.this.mIsEnadle || BathOpenActivity.this.mIsSet) {
                return;
            }
            BathOpenActivity.this.mIsConnected = false;
            BaseMaterialDialog.dissmisMaterialDialog();
            if (BathOpenActivity.this.mIsOpened || BathOpenActivity.this.mIsErrorEnd) {
                return;
            }
            if (StringUtils.isNotEmpty(str)) {
                SystemErrorTip.getInstance().showTipDialog(BathOpenActivity.this.getActivity(), BathOpenActivity.this.mSystemErrorDialogListener, str);
                return;
            }
            if (timeOut == TimeOut.SendConnect) {
                str2 = "发送连接数据超时";
            } else if (timeOut == TimeOut.SendConfirm) {
                str2 = "发送开阀数据超时";
            } else if (timeOut == TimeOut.SendAbort) {
                str2 = "关阀超时";
            } else {
                str2 = timeOut == TimeOut.SendV3 ? "设备开阀无响应" : "开阀超时" + timeOut;
            }
            SystemErrorTip.getInstance().showTipDialog(BathOpenActivity.this.getActivity(), BathOpenActivity.this.mSystemErrorDialogListener, str2);
        }

        @Override // client.android.yixiaotong.sdk.runnable.listener.OpenListener
        public void onSuccess(BluetoothDevice bluetoothDevice, boolean z) {
            if (BathOpenActivity.this.mIsEnadle) {
                if (StringUtils.isNotEmpty(BathOpenActivity.this.mStudentId)) {
                    LocalBusinessStore.saveLastBathStudentId(BathOpenActivity.this.getContext(), 1, BathOpenActivity.this.mStudentId);
                }
                BathOpenActivity.this.mIsOpened = true;
                BaseMaterialDialog.dissmisMaterialDialog();
                PreferenceUtil.putDeviceMac(BathOpenActivity.this.getContext(), BathOpenActivity.TYPE_DEVICEMAC, BathOpenActivity.this.mDeviceMac);
                BathOpenActivity.this.mTime.setVisibility(0);
                BathOpenActivity.this.mOpenSuccess.setVisibility(0);
                BathOpenActivity.this.time.start();
                BathOpenActivity.this.updateConsumptionTimes();
                BathOpenActivity.this.uploadState();
            }
        }

        @Override // client.android.yixiaotong.sdk.runnable.listener.OpenListener
        public void onConnectSuccess(BluetoothDevice bluetoothDevice, String str) {
            if (BathOpenActivity.this.mIsEnadle) {
                BaseMaterialDialog.setConnectMaterialDialog("蓝牙配对成功...");
                LeXiaoTongSDK.getInstance().openDevice(BathOpenActivity.this.openListener, NetworkUtils.isNetwork);
            }
        }

        @Override // client.android.yixiaotong.sdk.runnable.listener.OpenListener
        public void onConnectSuccessNew(BluetoothDevice bluetoothDevice, String str) {
            LeXiaoTongSDK.getInstance().openDevice(BathOpenActivity.this.openListener, true);
        }

        @Override // client.android.yixiaotong.sdk.runnable.listener.OpenListener
        public void onDataV4(BluetoothDevice bluetoothDevice, String str, String str2) {
            if (str2.equals("02")) {
                BathOpenActivity.this.newDeviceUploadOrder(str);
            } else if (str2.equals("08")) {
                BathOpenActivity.this.mF8Data = str;
            }
        }

        @Override // client.android.yixiaotong.sdk.runnable.listener.OpenListener
        public String onGetAuthDataV4(BluetoothDevice bluetoothDevice) {
            return StringUtils.isNotEmpty(BathOpenActivity.this.mAuthData) ? BathOpenActivity.this.mAuthData : LocalBusinessStore.getBathKey(BathOpenActivity.this.getContext());
        }

        @Override // client.android.yixiaotong.sdk.runnable.listener.OpenListener
        public int callConsumptionTime(BluetoothDevice bluetoothDevice) {
            if (BathOpenActivity.this.mConsumptionTimes == 0 && !BathOpenActivity.this.mmIsAddConsumptionTimes) {
                MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.ui.bluetoothtwo.BathOpenActivity.9.1
                    @Override // java.lang.Runnable
                    public void run() {
                        BaseMaterialDialog.dissmisMaterialDialog();
                        BathOpenActivity.this.mIsErrorEnd = true;
                        new MaterialDialog.Builder(BathOpenActivity.this.getContext()).title("开阀失败").content("1.上次消费订单尚未上传\n2.消费次数已用完\n请在上次使用的设备上重试或充值后重试").positiveText("确定").onPositive(new MaterialDialog.SingleButtonCallback() { // from class: client.android.yixiaotong.ui.bluetoothtwo.BathOpenActivity.9.1.1
                            @Override // com.afollestad.materialdialogs.MaterialDialog.SingleButtonCallback
                            public void onClick(MaterialDialog materialDialog, DialogAction dialogAction) {
                            }
                        }).show();
                    }
                });
            }
            if (BathOpenActivity.this.mmIsAddConsumptionTimes) {
                return 1;
            }
            return BathOpenActivity.this.mConsumptionTimes;
        }

        @Override // client.android.yixiaotong.sdk.runnable.listener.OpenListener
        public void onDataV3(BluetoothDevice bluetoothDevice, String str) {
            if (BaseMaterialDialog.isShowMaterialDialog()) {
                if ((str.startsWith("55") && str.length() == 40 && !str.startsWith("550001")) || ((str.length() == 18 && str.toUpperCase().startsWith("AA")) || str.toUpperCase().equals("A5") || str.toUpperCase().equals("AC"))) {
                    if (BathOpenActivity.this.mConsumptionTimes > 0) {
                        BathOpenActivity.this.smallAppBath();
                        return;
                    }
                    BaseMaterialDialog.dissmisMaterialDialog();
                    BathOpenActivity.this.mIsErrorEnd = true;
                    new MaterialDialog.Builder(BathOpenActivity.this.getContext()).title("开阀失败").content("1.上次消费订单尚未上传\n2.消费次数已用完\n请在上次使用的设备上重试或充值后重试").positiveText("确定").onPositive(new MaterialDialog.SingleButtonCallback() { // from class: client.android.yixiaotong.ui.bluetoothtwo.BathOpenActivity.9.2
                        @Override // com.afollestad.materialdialogs.MaterialDialog.SingleButtonCallback
                        public void onClick(MaterialDialog materialDialog, DialogAction dialogAction) {
                        }
                    }).show();
                }
            }
        }
    };
    private boolean mIsOffine = true;
    private boolean mIsSet = false;
    private SettingListener mSettingListener = new SettingListener() { // from class: client.android.yixiaotong.ui.bluetoothtwo.BathOpenActivity.14
        @Override // client.android.yixiaotong.sdk.runnable.listener.SettingListener
        public void onBluetoothException(ClientException clientException) {
        }

        @Override // client.android.yixiaotong.sdk.runnable.listener.SettingListener
        public void onStart(BluetoothDevice bluetoothDevice) {
        }

        @Override // client.android.yixiaotong.sdk.runnable.listener.SettingListener
        public void onSuccess(BluetoothDevice bluetoothDevice) {
            BaseMaterialDialog.dissmisMaterialDialog();
            BathOpenActivity.this.mIsSet = false;
            BathOpenActivity.this.openDevice();
        }

        @Override // client.android.yixiaotong.sdk.runnable.listener.SettingListener
        public void onFail(BluetoothDevice bluetoothDevice, TimeOut timeOut) {
            BaseMaterialDialog.dissmisMaterialDialog();
            SystemErrorTip.getInstance().showTipDialog(BathOpenActivity.this.getActivity(), new SystemErrorTip.SystemErrorDialogListener() { // from class: client.android.yixiaotong.ui.bluetoothtwo.BathOpenActivity.14.1
                @Override // client.android.yixiaotong.ui.dialog.SystemErrorTip.SystemErrorDialogListener
                public void onConfirm() {
                    BathOpenActivity.this.finish();
                }
            }, "设备参数异常，请重新连接再试");
        }
    };
    private PermissionUtil.PermissionGrant permissionGrant = new PermissionUtil.PermissionGrant() { // from class: client.android.yixiaotong.ui.bluetoothtwo.BathOpenActivity.15
        @Override // client.android.yixiaotong.util.permission.PermissionUtil.PermissionGrant
        public void onPermissionGranted(int i) {
        }
    };

    enum Status {
        Opening,
        OpeningUpload,
        Opened,
        Closeing,
        CloseingUpload,
        Closed
    }

    static {
        StubApp.interface11(6479);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public native void onRequestPermissionsResult(int i, String[] strArr, int[] iArr);

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.titleBar);
        this.mTime = (TextView) findViewById(R.id.time);
        this.mOpenSuccess = (TextView) findViewById(R.id.tv_opensuccess);
        this.flContainer = (FrameLayout) findViewById(R.id.flContainer);
    }

    public static void launch(Activity activity, String str, String str2, int i, String str3, String str4) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) BathOpenActivity.class).putExtra("deviceMac", str).putExtra("name", str2).putExtra("consumptionTimes", i).putExtra("devicehexid", str3).putExtra("f5data", str4));
        }
    }

    public static void launch(Activity activity, String str, String str2, int i, String str3, String str4, String str5, int i2) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) BathOpenActivity.class).putExtra("deviceMac", str).putExtra("name", str2).putExtra("deviceType", i).putExtra("data", str3).putExtra(CrashHianalyticsData.TIME, str4).putExtra("studentid", str5).putExtra("consumptionTimes", i2));
        }
    }

    private void initTitleBar() {
        TitleBar titleBar = (TitleBar) findViewById(R.id.titleBar);
        this.mTitleBar = titleBar;
        titleBar.setLeftViewIsBack();
        this.mTitleBar.setTitleView("设备详情");
        this.mTitleBar.setLeftViewOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.bluetoothtwo.BathOpenActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BathOpenActivity.this.finish();
            }
        });
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.mIsEnadle = true;
        initWallet();
        openDevice();
        AdvControlUtil.getInstance().onResume();
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        this.mIsEnadle = false;
        AdvControlUtil.getInstance().onPause();
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        BaseMaterialDialog.dissmisMaterialDialog();
        LeXiaoTongSDK.getInstance().closeBLE();
        AdvControlUtil.getInstance().onDestroy(getActivity());
    }

    private void initWallet() {
        BusinessControllers.getInstance().getRelationWallet(getLoginAccount(), 1, new Listener<WalletModel>() { // from class: client.android.yixiaotong.ui.bluetoothtwo.BathOpenActivity.3
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, WalletModel walletModel, Object... objArr) {
                if (walletModel == null || walletModel.getBalance() <= 0) {
                    BathOpenActivity.this.mIsErrorEnd = true;
                    BathOpenActivity.this.mWalletModel = null;
                    BaseMaterialDialog.dissmisMaterialDialog();
                    SystemErrorTip.getInstance().showTipDialog(BathOpenActivity.this.getActivity(), BathOpenActivity.this.mSystemErrorDialogListener, "余额不足,请充值");
                    return;
                }
                BathOpenActivity.this.mWalletModel = walletModel;
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, client.android.yixiaotong.exception.ClientException clientException) {
                BathOpenActivity.this.mWalletModel = null;
                BathOpenActivity.this.mIsErrorEnd = true;
                BaseMaterialDialog.dissmisMaterialDialog();
                SystemErrorTip.getInstance().showTipDialog(BathOpenActivity.this.getActivity(), BathOpenActivity.this.mSystemErrorDialogListener, "暂不支持此设备");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openDevice() {
        BaseMaterialDialog.showMaterialDialog(getActivity(), "正在开阀...", false);
        MainThreadExecutor.getInstance().executeDelayed(new Runnable() { // from class: client.android.yixiaotong.ui.bluetoothtwo.BathOpenActivity.4
            @Override // java.lang.Runnable
            public void run() {
                BathOpenActivity.this.mAuthorizedData = "";
                if (BathOpenActivity.this.mIsConnected) {
                    LeXiaoTongSDK.getInstance().openDevice(BathOpenActivity.this.openListener, NetworkUtils.isNetwork);
                } else {
                    LeXiaoTongSDK.getInstance().openDevice(new BluetoothDevice(BathOpenActivity.this.mDeviceName, BathOpenActivity.this.mDeviceMac, 0), BathOpenActivity.this.openListener, BathOpenActivity.this.getLoginAccount().getUid(), (short) BathOpenActivity.this.mWalletModel.getBalance(), NetworkUtils.isNetwork);
                }
            }
        }, 100L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uploadOrder(final OrderBean orderBean) {
        BusinessControllers.getInstance().uploadOrder(getLoginAccount(), this.mDeviceHexID, 1, orderBean.studentNo, orderBean.money, orderBean.time, new Listener<Boolean>() { // from class: client.android.yixiaotong.ui.bluetoothtwo.BathOpenActivity.5
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                BaseMaterialDialog.setConnectMaterialDialog("正在上传订单..");
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, Boolean bool, Object... objArr) {
                if (BathOpenActivity.this.mIsEnadle) {
                    if (!BaseMaterialDialog.isShowMaterialDialog()) {
                        BathOpenActivity.this.finish();
                    }
                    ToastUtils.show(BathOpenActivity.this.getContext(), "订单上传成功");
                    if (orderBean.studentNo != BathOpenActivity.this.getLoginAccount().getUid()) {
                        if (BathOpenActivity.this.mConsumptionTimes > 0) {
                            LeXiaoTongSDK.getInstance().openUploadOrder(true);
                            return;
                        }
                        BaseMaterialDialog.dissmisMaterialDialog();
                        BathOpenActivity.this.mIsErrorEnd = true;
                        new MaterialDialog.Builder(BathOpenActivity.this.getContext()).title("开阀失败").content("1.上次消费订单尚未上传\n2.消费次数已用完\n请在上次使用的设备上重试或充值后重试").positiveText("确定").onPositive(new MaterialDialog.SingleButtonCallback() { // from class: client.android.yixiaotong.ui.bluetoothtwo.BathOpenActivity.5.1
                            @Override // com.afollestad.materialdialogs.MaterialDialog.SingleButtonCallback
                            public void onClick(MaterialDialog materialDialog, DialogAction dialogAction) {
                            }
                        }).show();
                        return;
                    }
                    if (BathOpenActivity.this.mWalletModel.getBalance() - ((long) orderBean.money) > BathOpenActivity.this.mWalletModel.max) {
                        BathOpenActivity.this.mmIsAddConsumptionTimes = true;
                        LeXiaoTongSDK.getInstance().openUploadOrder(true);
                    } else {
                        BaseMaterialDialog.dissmisMaterialDialog();
                        BathOpenActivity.this.mIsErrorEnd = true;
                        SystemErrorTip.getInstance().showTipDialog(BathOpenActivity.this.getActivity(), BathOpenActivity.this.mSystemErrorDialogListener, "账户余额不足，请充值后再来使用");
                    }
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, client.android.yixiaotong.exception.ClientException clientException) {
                if (BathOpenActivity.this.mIsEnadle) {
                    if (!BaseMaterialDialog.isShowMaterialDialog()) {
                        BathOpenActivity.this.finish();
                    }
                    if (clientException.getCode() != 6001) {
                        BathOpenActivity.this.mIsErrorEnd = true;
                        BaseMaterialDialog.dissmisMaterialDialog();
                        ErrorUtil.onFailResult(BathOpenActivity.this.getActivity(), BathOpenActivity.this.mTitleBar.getTitleViewContent(), clientException, true);
                        return;
                    }
                    if (orderBean.studentNo != BathOpenActivity.this.getLoginAccount().getUid()) {
                        if (BathOpenActivity.this.mConsumptionTimes > 0) {
                            LeXiaoTongSDK.getInstance().openUploadOrder(true);
                            return;
                        }
                        BaseMaterialDialog.dissmisMaterialDialog();
                        BathOpenActivity.this.mIsErrorEnd = true;
                        new MaterialDialog.Builder(BathOpenActivity.this.getContext()).title("开阀失败").content("1.上次消费订单尚未上传\n2.消费次数已用完\n请在上次使用的设备上重试或充值后重试").positiveText("确定").onPositive(new MaterialDialog.SingleButtonCallback() { // from class: client.android.yixiaotong.ui.bluetoothtwo.BathOpenActivity.5.2
                            @Override // com.afollestad.materialdialogs.MaterialDialog.SingleButtonCallback
                            public void onClick(MaterialDialog materialDialog, DialogAction dialogAction) {
                            }
                        }).show();
                        return;
                    }
                    if (BathOpenActivity.this.mWalletModel.getBalance() - ((long) orderBean.money) > BathOpenActivity.this.mWalletModel.max) {
                        BathOpenActivity.this.mmIsAddConsumptionTimes = true;
                        LeXiaoTongSDK.getInstance().openUploadOrder(true);
                    } else {
                        BaseMaterialDialog.dissmisMaterialDialog();
                        BathOpenActivity.this.mIsErrorEnd = true;
                        SystemErrorTip.getInstance().showTipDialog(BathOpenActivity.this.getActivity(), BathOpenActivity.this.mSystemErrorDialogListener, "账户余额不足，请充值后再来使用");
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uploadOrderNew(final OrderBean orderBean, String str, String str2, int i) {
        BusinessControllers.getInstance().uploadOrder("", getLoginAccount(), this.mDeviceHexID, this.mWalletModel.typeId, orderBean.studentNo, orderBean.money, orderBean.time, orderBean.offineTimes, Long.parseLong(getLoginAccount().getAccountManagetStore().getUserInfo().InvestorId), i, (short) this.mWalletModel.getBalance(), Integer.parseInt(getLoginAccount().getAccountManagetStore().getUserInfo().AreaId + ""), str, str2, RandomUtils.getRandomString2(), new Listener<OpenDataBean>() { // from class: client.android.yixiaotong.ui.bluetoothtwo.BathOpenActivity.6
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                BaseMaterialDialog.setConnectMaterialDialog("正在授权...");
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, OpenDataBean openDataBean, Object... objArr) {
                if (BathOpenActivity.this.mIsEnadle) {
                    ToastUtils.show(BathOpenActivity.this.getContext(), "授权成功");
                    if (openDataBean != null && openDataBean.Records != null) {
                        try {
                            openDataBean.setmOpenData(new JSONObject(openDataBean.Records.toString()));
                            BathOpenActivity.this.mAuthorizedData = openDataBean.getmOpenData().AuthorizedData;
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                    Log.e("test", orderBean.time + "  " + orderBean.studentNo);
                    if (StringUtils.isEmpty(orderBean.time) || orderBean.studentNo == 0) {
                        if (BathOpenActivity.this.mConsumptionTimes > 0 || BathOpenActivity.this.mmIsAddConsumptionTimes) {
                            LeXiaoTongSDK.getInstance().openForF1(BathOpenActivity.this.mAuthorizedData);
                            BathOpenActivity.this.mAuthorizedData = "";
                            return;
                        } else {
                            BaseMaterialDialog.dissmisMaterialDialog();
                            BathOpenActivity.this.mIsErrorEnd = true;
                            new MaterialDialog.Builder(BathOpenActivity.this.getContext()).title("开阀失败").content("1.上次消费订单尚未上传\n2.消费次数已用完\n请在上次使用的设备上重试或充值后重试").positiveText("确定").onPositive(new MaterialDialog.SingleButtonCallback() { // from class: client.android.yixiaotong.ui.bluetoothtwo.BathOpenActivity.6.1
                                @Override // com.afollestad.materialdialogs.MaterialDialog.SingleButtonCallback
                                public void onClick(MaterialDialog materialDialog, DialogAction dialogAction) {
                                }
                            }).show();
                            return;
                        }
                    }
                    if (orderBean.studentNo != BathOpenActivity.this.getLoginAccount().getUid() || BathOpenActivity.this.mIsOpened) {
                        LeXiaoTongSDK.getInstance().openUploadOrder(true);
                        return;
                    }
                    if (BathOpenActivity.this.mWalletModel.getBalance() - ((long) orderBean.money) > BathOpenActivity.this.mWalletModel.max) {
                        BathOpenActivity.this.mmIsAddConsumptionTimes = true;
                        LeXiaoTongSDK.getInstance().openUploadOrder(true);
                    } else {
                        BaseMaterialDialog.dissmisMaterialDialog();
                        BathOpenActivity.this.mIsErrorEnd = true;
                        SystemErrorTip.getInstance().showTipDialog(BathOpenActivity.this.getActivity(), BathOpenActivity.this.mSystemErrorDialogListener, "账户余额不足，请充值后再来使用");
                    }
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, client.android.yixiaotong.exception.ClientException clientException) {
                if (BathOpenActivity.this.mIsEnadle) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    BathOpenActivity.this.mIsErrorEnd = true;
                    ErrorUtil.onFailResult(BathOpenActivity.this.getActivity(), BathOpenActivity.this.mTitleBar.getTitleViewContent(), clientException, true);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uploadState() {
        if (StringUtils.isNotEmpty(this.mF5Data) && NetworkUtils.isNetwork) {
            BusinessControllers.getInstance().uploadEqStatus(getLoginAccount(), this.mDeviceHexID, CommandUtils.getReturnSettingResult(HexString.hexToBuffer(this.mF5Data)), TimeUtils.getCurrentTime(), new Listener<Boolean>() { // from class: client.android.yixiaotong.ui.bluetoothtwo.BathOpenActivity.7
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateConsumptionTimes() {
        if (this.mConsumptionTimes > 0) {
            BusinessControllers.getInstance().updateConsumptionTimes(getLoginAccount(), this.mWalletModel.ID, this.mConsumptionTimes - 1, new Listener<SuccessBean>() { // from class: client.android.yixiaotong.ui.bluetoothtwo.BathOpenActivity.8
            });
        }
    }

    private void open() {
        BaseMaterialDialog.showMaterialDialog(getActivity(), "正在连接水控设备...", false);
        LeXiaoTongSDK.getInstance().sendDataV3(this.mSystemData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void smallAppBath() {
        open();
    }

    public String getData() {
        return new SimpleDateFormat("yyMMddHHmmss").format(Calendar.getInstance().getTime());
    }

    class TimeCount extends CountDownTimer {
        public TimeCount(long j, long j2) {
            super(j, j2);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            BluetoothDetailTwoActivity.launch(BathOpenActivity.this.getActivity(), BathOpenActivity.this.mDeviceMac, BathOpenActivity.this.mDeviceName, BathOpenActivity.this.mDeviceHexID, "", BathOpenActivity.this.mStudentId);
            BathOpenActivity.this.finish();
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            BathOpenActivity.this.mTime.setTextColor(-10066330);
            BathOpenActivity.this.mTime.setClickable(false);
            BathOpenActivity.this.mTime.setText(Html.fromHtml("该页面将在" + (j / 1000) + "后自动关闭"));
            BathOpenActivity.this.mTime.setTextSize(12.0f);
            BathOpenActivity.this.mTime.setPadding(5, 5, 5, 5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void newDeviceUploadOrder(final String str) {
        boolean z;
        MainThreadExecutor.getInstance().executeDelayed(new Runnable() { // from class: client.android.yixiaotong.ui.bluetoothtwo.BathOpenActivity.10
            @Override // java.lang.Runnable
            public void run() {
                if (BathOpenActivity.this.mIsOffine) {
                    LeXiaoTongSDK.getInstance().openDevice(BathOpenActivity.this.openListener, false);
                }
            }
        }, ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT);
        int i = getLoginAccount().getAccountManagetStore().getUserInfo().UserType != 1 ? 0 : 1;
        if (!StringUtils.isNotEmpty(this.mF0Data) || this.mF0Data.length() <= 40 || !StringUtils.isNotEmpty(str) || str.length() <= 70 || !StringUtils.isNotEmpty(this.mF8Data) || this.mF8Data.length() <= 30) {
            return;
        }
        String strSubstring = this.mF0Data.substring(22, 38);
        if (strSubstring.equals("0000000000000000")) {
            SystemErrorTip.getInstance().showTipDialog(getActivity(), "生产未给设备授权");
            return;
        }
        String strReceivedResult = BathUtil.receivedResult(this.mF0Data.substring(14, 16), this.mF0Data.substring(4, 6), this.mF0Data.substring(6, 8));
        String strReceivedResult2 = BathUtil.receivedResult(this.mF0Data.substring(16, 18), this.mF0Data.substring(4, 6), this.mF0Data.substring(6, 8));
        BathUtil.receivedResult(this.mF0Data.substring(18, 20), this.mF0Data.substring(4, 6), this.mF0Data.substring(6, 8));
        BathUtil.receivedResult(this.mF0Data.substring(20, 22), this.mF0Data.substring(4, 6), this.mF0Data.substring(6, 8));
        boolean zEqualsIgnoreCase = strReceivedResult.equalsIgnoreCase("01");
        if (strReceivedResult.equalsIgnoreCase("02")) {
            z = zEqualsIgnoreCase;
            z = 6;
        }
        z = zEqualsIgnoreCase;
        BusinessControllers.getInstance().postBatheAuthAnalysis(getLoginAccount(), z ? 1 : 0, i, strSubstring, BathUtil.HexStringToInt(strReceivedResult), BathUtil.HexStringToInt(strReceivedResult2), str.substring(42, 58), this.mF8Data.substring(22, 30), str.substring(58, 70), 0, RandomUtil.getRandNumMaxString(6), "1.0", new Listener<BathUploadOrderNewBean>() { // from class: client.android.yixiaotong.ui.bluetoothtwo.BathOpenActivity.11
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                BathOpenActivity.this.mIsOffine = true;
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, BathUploadOrderNewBean bathUploadOrderNewBean, Object... objArr) {
                BathOpenActivity.this.mIsOffine = false;
                if (bathUploadOrderNewBean == null) {
                    ToastUtils.show(BathOpenActivity.this.getContext(), "上传订单失败");
                    return;
                }
                if (StringUtils.isNotEmpty(bathUploadOrderNewBean.app_key)) {
                    LocalBusinessStore.saveBathKey(BathOpenActivity.this.getContext(), bathUploadOrderNewBean.app_key);
                }
                BathOpenActivity.this.newDeviceAuth(str);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, client.android.yixiaotong.exception.ClientException clientException) {
                BathOpenActivity.this.mIsOffine = false;
                if (clientException.getCode() == -1000) {
                    LeXiaoTongSDK.getInstance().openDevice(BathOpenActivity.this.openListener, false);
                } else {
                    ErrorUtil.onFailResult(BathOpenActivity.this.getActivity(), BathOpenActivity.this.mTitleBar.getTitleViewContent(), clientException, true);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v10, types: [client.android.yixiaotong.controller.BusinessControllers] */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v5, types: [int] */
    /* JADX WARN: Type inference failed for: r7v6 */
    public void newDeviceAuth(String str) {
        int i = getLoginAccount().getAccountManagetStore().getUserInfo().UserType != 1 ? 0 : 1;
        if (!StringUtils.isNotEmpty(this.mF0Data) || this.mF0Data.length() <= 40 || !StringUtils.isNotEmpty(str) || str.length() <= 70 || !StringUtils.isNotEmpty(this.mF8Data) || this.mF8Data.length() <= 30) {
            return;
        }
        String strSubstring = this.mF0Data.substring(22, 38);
        if (strSubstring.equals("0000000000000000")) {
            SystemErrorTip.getInstance().showTipDialog(getActivity(), "生产未给设备授权");
            return;
        }
        String strReceivedResult = BathUtil.receivedResult(this.mF0Data.substring(14, 16), this.mF0Data.substring(4, 6), this.mF0Data.substring(6, 8));
        String strReceivedResult2 = BathUtil.receivedResult(this.mF0Data.substring(16, 18), this.mF0Data.substring(4, 6), this.mF0Data.substring(6, 8));
        BathUtil.receivedResult(this.mF0Data.substring(18, 20), this.mF0Data.substring(4, 6), this.mF0Data.substring(6, 8));
        ?? EqualsIgnoreCase = strReceivedResult.equalsIgnoreCase("02") ? 6 : strReceivedResult.equalsIgnoreCase("01");
        int iHexStringToInt = BathUtil.HexStringToInt(strReceivedResult);
        int iHexStringToInt2 = BathUtil.HexStringToInt(strReceivedResult2);
        str.substring(42, 58);
        String strSubstring2 = this.mF8Data.substring(22, 30);
        String strSubstring3 = str.substring(54, 58);
        String strSubstring4 = str.substring(50, 54);
        final String randNumMaxString = RandomUtil.getRandNumMaxString(6);
        BusinessControllers.getInstance().postBatheAuth(getLoginAccount(), this.mStudentId, EqualsIgnoreCase, i, strSubstring, iHexStringToInt, iHexStringToInt2, strSubstring2, strSubstring4, strSubstring3, 0, randNumMaxString, "1.0", new Listener<BathAuthNewBean>() { // from class: client.android.yixiaotong.ui.bluetoothtwo.BathOpenActivity.12
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, BathAuthNewBean bathAuthNewBean, Object... objArr) {
                if (bathAuthNewBean == null || !bathAuthNewBean.rand.equals(randNumMaxString)) {
                    ToastUtils.show(BathOpenActivity.this.getContext(), "上传订单失败");
                    return;
                }
                LocalBusinessStore.saveBathKey(BathOpenActivity.this.getContext(), bathAuthNewBean.app_key);
                BathOpenActivity.this.mAuthData = bathAuthNewBean.systemdata;
                LeXiaoTongSDK.getInstance().openDevice(BathOpenActivity.this.openListener, true);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, client.android.yixiaotong.exception.ClientException clientException) {
                if (clientException.getCode() == 4115) {
                    ToastUtils.show(BathOpenActivity.this.getContext(), "需要先支付");
                } else {
                    ErrorUtil.onFailResult(BathOpenActivity.this.getActivity(), BathOpenActivity.this.mTitleBar.getTitleViewContent(), clientException, true);
                }
            }
        });
    }

    private void judeSetValue(String str, String str2, String str3, String str4) {
        BusinessControllers.getInstance().JudgeEquipmentRateInfo(getLoginAccount(), 1, str, str2, str3, str4, new Listener<SetBean>() { // from class: client.android.yixiaotong.ui.bluetoothtwo.BathOpenActivity.13
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                if (BathOpenActivity.this.mIsEnadle) {
                    BaseMaterialDialog.showMaterialDialog(BathOpenActivity.this.getActivity(), "正在校验费率..", false);
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, SetBean setBean, Object... objArr) {
                if (BathOpenActivity.this.mIsEnadle) {
                    if (setBean != null && (setBean.success == 1 || setBean.success == 2)) {
                        BaseMaterialDialog.dissmisMaterialDialog();
                        BathOpenActivity.this.openDevice();
                        return;
                    }
                    BaseMaterialDialog.setConnectMaterialDialog("正在设置费率..");
                    BathOpenActivity.this.mIsSet = true;
                    BathOpenActivity.this.mIsConnected = false;
                    LeXiaoTongSDK.getInstance().closeBLE();
                    BluetoothDevice bluetoothDevice = new BluetoothDevice(BathOpenActivity.this.mDeviceName, BathOpenActivity.this.mDeviceMac, 0);
                    String str5 = ((BathOpenActivity.this.mF5Data.substring(12, 14) + BathOpenActivity.this.mF5Data.substring(14, 16) + setBean.amountDeducted + setBean.ChargeBackPulseNumber + setBean.PulseQValue + setBean.AlarmTime + "00") + new SimpleDateFormat("yyMMddHHmm").format(Calendar.getInstance().getTime())) + BathOpenActivity.this.mF5Data.substring(36, 40) + "0E0F";
                    Log.e("test", str5);
                    LeXiaoTongSDK.getInstance().settingDevice(bluetoothDevice, BathOpenActivity.this.mSettingListener, str5, BathOpenActivity.this.getLoginAccount().getUid());
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, client.android.yixiaotong.exception.ClientException clientException) {
                if (BathOpenActivity.this.mIsEnadle) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    ErrorUtil.onFailResult(BathOpenActivity.this.getActivity(), BathOpenActivity.this.mTitleBar.getTitleViewContent(), clientException, true);
                }
            }
        });
    }

    private void getAdv() {
        AdvControlUtil.getInstance().init(getActivity(), new AdvControlUtil.AdvListener() { // from class: client.android.yixiaotong.ui.bluetoothtwo.BathOpenActivity.16
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
                if (i2 == 1) {
                    MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.ui.bluetoothtwo.BathOpenActivity.16.1
                        @Override // java.lang.Runnable
                        public void run() {
                            AdvControlUtil.getInstance().requestBanner(BathOpenActivity.this.flContainer);
                        }
                    });
                }
            }
        }, 1, false, getLoginAccount().getAccountManagetStore().getUserInfo().AreaId + "");
        AdvControlUtil.getInstance().initAdvInfo();
    }
}
