package client.android.yixiaotong.v3.ui.appcontrol.dry;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.ui.dialog.BaseMaterialDialog;
import client.android.yixiaotong.ui.dialog.SystemErrorTip;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.ui.widget.WrapGridView;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.util.executor.MainThreadExecutor;
import client.android.yixiaotong.util.permission.PermissionUtil;
import client.android.yixiaotong.v3.bean.adv.BannerJumpInfoBean;
import client.android.yixiaotong.v3.bean.deviceinfo.MachineByMacBean;
import client.android.yixiaotong.v3.bean.deviceinfo.ModeBean;
import client.android.yixiaotong.v3.bean.login.TypeInfoBaseInfoBean;
import client.android.yixiaotong.v3.bean.login.UseToolsJsonBean;
import client.android.yixiaotong.v3.bluetoothutil.BluetoothControlUtil;
import client.android.yixiaotong.v3.http.V3BusinessControllers;
import client.android.yixiaotong.v3.ui.adv.AdvControlUtil;
import client.android.yixiaotong.v3.ui.adv.Common;
import client.android.yixiaotong.v3.ui.adv.NativeUtil;
import client.android.yixiaotong.v3.ui.appcontrol.drinkwater.BluetoothOpenControlUtil;
import client.android.yixiaotong.v3.ui.appcontrol.drinkwater.CloseSuccessActivity;
import client.android.yixiaotong.v3.ui.appcontrol.drinkwater.NBOr4GCloseControlUtil;
import client.android.yixiaotong.v3.ui.appcontrol.drinkwater.NBOr4GOpenControlUtil;
import client.android.yixiaotong.v3.ui.appcontrol.listener.CloseControlListener;
import client.android.yixiaotong.v3.ui.appcontrol.listener.OpenControlListener;
import client.android.yixiaotong.v3.ui.error.V3ErrorTipActivity;
import client.android.yixiaotong.v3.ui.scan.QrcodeUtil;
import client.android.yixiaotong.v3.util.LanguageUtils;
import client.android.yixiaotong.v3.util.LocalDataUtil;
import client.android.yixiaotong.v3.util.LogUtil;
import com.bumptech.glide.Glide;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.lxt.bluetoothsdk.BluetoothSDK;
import com.lxt.bluetoothsdk.model.BluetoothDevice;
import com.stub.StubApp;
import com.unionpay.tsmservice.mi.data.Constant;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class DryDetailActivity extends BaseActivity implements AdapterView.OnItemClickListener {
    public static final String TAG = "DryDetail";
    private static final int TYPEID = 16;
    private FrameLayout flContainer;
    private AdvAdapter mAdvAdapter;
    private AdvControlUtil.AdvListener mAdvListener;
    private BluetoothDevice mBluetoothDevice;
    private BluetoothOpenControlUtil mBluetoothOpenControlUtil;
    private Button mBtnClose;
    private WrapGridView mGvAdv;
    private ImageView mIvCircle;
    private String mMac;
    private ModeBean mModeBean;
    private NBOr4GCloseControlUtil mNBOr4GCloseControlUtil;
    private NBOr4GOpenControlUtil mNBOr4GOpenControlUtil;
    private NativeUtil mNativeUtil;
    private int mPlanFlag;
    private String mQrcode;
    private RelativeLayout mRelAdvTip;
    private RelativeLayout mRelClose;
    private RelativeLayout mRelConnect;
    private String mStudentHex;
    private TimeCount mTimeCount;
    private TitleBar mTitleBar;
    private TextView mTvAdvName;
    private TextView mTvConnectTip;
    private TextView mTvMac;
    private TextView mTvTime;
    private TypeInfoBaseInfoBean mTypeInfoBaseInfoBean;
    private UseToolsJsonBean mUseToolsJsonBean;
    private RelativeLayout rlContainer;
    private boolean mIsEnable = true;
    private FlowState mFlowState = FlowState.opening;
    private String mDeviceVer = "";
    private String mMachineId = "";
    private boolean mIsBluetoothDevice = true;
    private int mPreferredCommunicationType = 0;
    private boolean mIsOpenFail = false;
    private PermissionUtil.PermissionGrant permissionGrant = new PermissionUtil.PermissionGrant() { // from class: client.android.yixiaotong.v3.ui.appcontrol.dry.DryDetailActivity.9
        @Override // client.android.yixiaotong.util.permission.PermissionUtil.PermissionGrant
        public void onPermissionGranted(int i) {
        }
    };
    private List<BannerJumpInfoBean> mBannerJumpInfo = new ArrayList();

    private enum FlowState {
        none,
        opening,
        opened,
        closeing,
        closeed
    }

    static {
        StubApp.interface11(9285);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public native void onRequestPermissionsResult(int i, String[] strArr, int[] iArr);

    public static void launch(Activity activity, String str, String str2, boolean z, ModeBean modeBean) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) DryDetailActivity.class).putExtra("qrcode", str).putExtra(Constant.KEY_MAC, str2).putExtra("isbluetoothdevice", z).putExtra("bean", modeBean));
        }
    }

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.titleBar);
        this.mRelConnect = (RelativeLayout) findViewById(R.id.rel_connect);
        this.mIvCircle = (ImageView) findViewById(R.id.iv_circle);
        this.mRelClose = (RelativeLayout) findViewById(R.id.rel_close);
        this.mBtnClose = (Button) findViewById(R.id.btn_close);
        this.mTvConnectTip = (TextView) findViewById(R.id.connecttiptext);
        this.mTvMac = (TextView) findViewById(R.id.tv_mac);
        this.mTvTime = (TextView) findViewById(R.id.tv_time);
        this.mRelAdvTip = (RelativeLayout) findViewById(R.id.rel_advtip);
        this.flContainer = (FrameLayout) findViewById(R.id.flContainer);
        this.mGvAdv = (WrapGridView) findViewById(R.id.gv_adv);
        this.rlContainer = (RelativeLayout) findViewById(R.id.rlContainer);
        this.mTvAdvName = (TextView) findViewById(R.id.tv_advname);
    }

    private void start() {
        if (StringUtils.isNotEmpty(this.mMac) && this.mMac.length() == 17 && QrcodeUtil.isMacIllegal(this.mMac)) {
            BluetoothSDK.getInstance().init(getContext());
            String str = this.mMac;
            this.mBluetoothDevice = new BluetoothDevice(str, str, 0);
            initView();
            initBluetooth();
            initControl();
            getDeviceInfo(true);
            getAdv();
            return;
        }
        ToastUtils.show(getContext(), "不合法的蓝牙地址" + this.mMac);
        finish();
    }

    private void initTitleBar() {
        if (this.mTypeInfoBaseInfoBean != null) {
            this.mTitleBar.setTitleView(LanguageUtils.getAppName(getActivity(), this.mTypeInfoBaseInfoBean.typeId, this.mTypeInfoBaseInfoBean.appName));
        } else {
            this.mTitleBar.setTitleView(getString(R.string.clothesdryer));
        }
        this.mTitleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
    }

    private void initView() {
        Animation animationLoadAnimation = AnimationUtils.loadAnimation(getActivity(), R.anim.rotating);
        animationLoadAnimation.setInterpolator(new LinearInterpolator());
        if (animationLoadAnimation != null) {
            this.mIvCircle.startAnimation(animationLoadAnimation);
        }
        this.mTvMac.setText("设备mac：" + this.mBluetoothDevice.address);
        if (this.mIsBluetoothDevice) {
            this.mBtnClose.setVisibility(4);
            this.mTvConnectTip.setVisibility(4);
            this.mTvMac.setVisibility(4);
            this.mTvTime.setVisibility(0);
            return;
        }
        this.mBtnClose.setVisibility(0);
        this.mTvConnectTip.setVisibility(4);
        this.mTvMac.setVisibility(0);
        this.mTvTime.setVisibility(4);
    }

    private void initControl() {
        BluetoothOpenControlUtil bluetoothOpenControlUtil = new BluetoothOpenControlUtil();
        this.mBluetoothOpenControlUtil = bluetoothOpenControlUtil;
        bluetoothOpenControlUtil.init(getActivity(), getLoginAccount(), this.mBluetoothDevice, this.mTypeInfoBaseInfoBean, 16, this.mTitleBar.getTitleViewContent(), this.mQrcode);
        this.mBluetoothOpenControlUtil.setHandleType(this.mModeBean.f);
        this.mBluetoothOpenControlUtil.setListener(new OpenControlListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.dry.DryDetailActivity.1
            @Override // client.android.yixiaotong.v3.ui.appcontrol.listener.OpenControlListener
            public void onOpenEnd() {
                DryDetailActivity.this.openEnd();
            }

            @Override // client.android.yixiaotong.v3.ui.appcontrol.listener.OpenControlListener
            public void onOpenFail() {
                DryDetailActivity.this.mIsOpenFail = true;
            }
        });
        NBOr4GOpenControlUtil nBOr4GOpenControlUtil = new NBOr4GOpenControlUtil();
        this.mNBOr4GOpenControlUtil = nBOr4GOpenControlUtil;
        nBOr4GOpenControlUtil.init(getActivity(), getLoginAccount(), this.mBluetoothDevice, this.mTypeInfoBaseInfoBean, 16, this.mStudentHex, this.mTitleBar.getTitleViewContent());
        this.mNBOr4GOpenControlUtil.setHandleType(this.mModeBean.f);
        this.mNBOr4GOpenControlUtil.setListener(new OpenControlListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.dry.DryDetailActivity.2
            @Override // client.android.yixiaotong.v3.ui.appcontrol.listener.OpenControlListener
            public void onOpenEnd() {
                DryDetailActivity.this.openEnd();
            }

            @Override // client.android.yixiaotong.v3.ui.appcontrol.listener.OpenControlListener
            public void onOpenFail() {
                DryDetailActivity.this.mIsOpenFail = true;
            }
        });
        NBOr4GCloseControlUtil nBOr4GCloseControlUtil = new NBOr4GCloseControlUtil();
        this.mNBOr4GCloseControlUtil = nBOr4GCloseControlUtil;
        nBOr4GCloseControlUtil.init(getActivity(), getLoginAccount(), this.mBluetoothDevice, this.mTypeInfoBaseInfoBean, 16, this.mStudentHex, this.mTitleBar.getTitleViewContent());
        this.mNBOr4GCloseControlUtil.setListener(new CloseControlListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.dry.DryDetailActivity.3
            @Override // client.android.yixiaotong.v3.ui.appcontrol.listener.CloseControlListener
            public void onCloseEnd() {
                ToastUtils.show(DryDetailActivity.this.getContext(), "关阀成功");
                CloseSuccessActivity.launch(DryDetailActivity.this.getActivity(), 16);
                DryDetailActivity.this.finish();
            }
        });
    }

    public void onClose(View view) {
        finish();
    }

    public void initBluetooth() {
        BluetoothControlUtil.getInstance().init(getActivity());
        BluetoothControlUtil.getInstance().setListener(new BluetoothControlUtil.Listener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.dry.DryDetailActivity.4
            @Override // client.android.yixiaotong.v3.bluetoothutil.BluetoothControlUtil.Listener
            public void onConnected() {
                super.onConnected();
                LogUtil.i(DryDetailActivity.TAG, "onConnected");
                if (DryDetailActivity.this.mFlowState == FlowState.opening) {
                    if (DryDetailActivity.this.mIsBluetoothDevice) {
                        DryDetailActivity.this.mBluetoothOpenControlUtil.connected();
                        return;
                    } else {
                        DryDetailActivity.this.mNBOr4GOpenControlUtil.connected();
                        return;
                    }
                }
                if (DryDetailActivity.this.mFlowState == FlowState.opened) {
                    DryDetailActivity.this.mNBOr4GOpenControlUtil.connectedForOpened();
                } else if (DryDetailActivity.this.mFlowState == FlowState.closeing) {
                    DryDetailActivity.this.mNBOr4GCloseControlUtil.connected();
                }
            }

            @Override // client.android.yixiaotong.v3.bluetoothutil.BluetoothControlUtil.Listener
            public void onFail(int i, String str) {
                super.onFail(i, str);
                LogUtil.i(DryDetailActivity.TAG, "onFail" + i + "  " + str);
                if (str.equalsIgnoreCase("Discover") || str.equalsIgnoreCase("Connect")) {
                    str = "尝试重启手机或设备蓝牙再试";
                }
                if (DryDetailActivity.this.mFlowState == FlowState.opening) {
                    if (DryDetailActivity.this.mIsBluetoothDevice) {
                        if (DryDetailActivity.this.mIsOpenFail) {
                            return;
                        }
                        DryDetailActivity.this.onError(i, str);
                        return;
                    }
                    DryDetailActivity.this.mNBOr4GOpenControlUtil.onBluetoothError(i, str);
                    return;
                }
                if (DryDetailActivity.this.mFlowState == FlowState.opened) {
                    DryDetailActivity.this.disconnect();
                    BluetoothControlUtil.getInstance().connectBluetooth(DryDetailActivity.this.mBluetoothDevice);
                } else if (DryDetailActivity.this.mFlowState == FlowState.closeing) {
                    DryDetailActivity.this.onError(i, str);
                }
            }

            @Override // client.android.yixiaotong.v3.bluetoothutil.BluetoothControlUtil.Listener
            public void onReceivedData(String str) {
                super.onReceivedData(str);
                LogUtil.i(DryDetailActivity.TAG, "onReceivedData:" + str);
                if (DryDetailActivity.this.mFlowState == FlowState.opening) {
                    if (DryDetailActivity.this.mIsBluetoothDevice) {
                        return;
                    }
                    DryDetailActivity.this.mNBOr4GOpenControlUtil.onReceivedData(str);
                } else if (DryDetailActivity.this.mFlowState == FlowState.opened) {
                    if (DryDetailActivity.this.mIsBluetoothDevice) {
                        return;
                    }
                    DryDetailActivity.this.mNBOr4GOpenControlUtil.onReceivedData(str);
                } else if (DryDetailActivity.this.mFlowState == FlowState.closeing) {
                    DryDetailActivity.this.mNBOr4GCloseControlUtil.onReceivedData(str);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void disconnect() {
        BluetoothControlUtil.getInstance().disconnect();
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        LogUtil.w(TAG, "onResume");
        this.mIsEnable = true;
        BluetoothControlUtil.getInstance().onResume();
        this.mBluetoothOpenControlUtil.onResume();
        this.mNBOr4GOpenControlUtil.onResume();
        this.mNBOr4GCloseControlUtil.onResume();
        AdvControlUtil.getInstance().onResume();
        NativeUtil nativeUtil = this.mNativeUtil;
        if (nativeUtil != null) {
            nativeUtil.onResume();
        }
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        LogUtil.w(TAG, "onPause");
        AdvControlUtil.getInstance().onPause();
        NativeUtil nativeUtil = this.mNativeUtil;
        if (nativeUtil != null) {
            nativeUtil.onPause();
        }
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        this.mIsEnable = false;
        BaseMaterialDialog.dissmisMaterialDialog();
        disconnect();
        BluetoothControlUtil.getInstance().onPause();
        this.mBluetoothOpenControlUtil.onPause();
        this.mNBOr4GOpenControlUtil.onPause();
        this.mNBOr4GCloseControlUtil.onPause();
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        AdvControlUtil.getInstance().onDestroy(getActivity());
        NativeUtil nativeUtil = this.mNativeUtil;
        if (nativeUtil != null) {
            nativeUtil.onDestroy();
        }
        super.onDestroy();
        LogUtil.w(TAG, "onDestroy");
        disconnect();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openEnd() {
        this.mFlowState = FlowState.opened;
        this.mIvCircle.clearAnimation();
        this.mRelConnect.setVisibility(8);
        this.mRelClose.setVisibility(0);
        if (this.mIsBluetoothDevice) {
            TimeCount timeCount = new TimeCount(ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT, 1000L);
            this.mTimeCount = timeCount;
            timeCount.start();
        }
        requestInteraction();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getDeviceInfo(final boolean z) {
        V3BusinessControllers.getInstance().getMachineByMac(getLoginAccount(), this.mBluetoothDevice.address, 16, new Listener<MachineByMacBean>() { // from class: client.android.yixiaotong.v3.ui.appcontrol.dry.DryDetailActivity.5
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, MachineByMacBean machineByMacBean, Object... objArr) {
                if (DryDetailActivity.this.mIsEnable) {
                    if (machineByMacBean == null || !StringUtils.isNotEmpty(machineByMacBean.deviceVer) || !StringUtils.isNotEmpty(machineByMacBean.machineId)) {
                        if (!z || !StringUtils.isNotEmpty(DryDetailActivity.this.mQrcode) || DryDetailActivity.this.mQrcode.length() < 52 || !DryDetailActivity.this.mQrcode.startsWith("55")) {
                            DryDetailActivity.this.showDialogNeedExit("设备未授权，请联系管理员" + DryDetailActivity.this.mBluetoothDevice.address);
                            return;
                        } else {
                            DryDetailActivity dryDetailActivity = DryDetailActivity.this;
                            dryDetailActivity.updateMac(dryDetailActivity.mQrcode.substring(2, 10), DryDetailActivity.this.mBluetoothDevice.address);
                            return;
                        }
                    }
                    DryDetailActivity.this.mDeviceVer = machineByMacBean.deviceVer;
                    DryDetailActivity.this.mMachineId = machineByMacBean.machineId;
                    DryDetailActivity.this.mFlowState = FlowState.opening;
                    final int i = machineByMacBean.cnflag;
                    final int i2 = machineByMacBean.mtype;
                    BluetoothControlUtil.getInstance().setDeviceType(DryDetailActivity.this.mDeviceVer);
                    MainThreadExecutor.getInstance().executeDelayed(new Runnable() { // from class: client.android.yixiaotong.v3.ui.appcontrol.dry.DryDetailActivity.5.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (DryDetailActivity.this.mIsBluetoothDevice) {
                                DryDetailActivity.this.mBluetoothOpenControlUtil.setDeviceInfo(DryDetailActivity.this.mDeviceVer, DryDetailActivity.this.mMachineId);
                                DryDetailActivity.this.mBluetoothOpenControlUtil.openStart();
                            } else {
                                DryDetailActivity.this.mNBOr4GOpenControlUtil.setDeviceInfo(DryDetailActivity.this.mPreferredCommunicationType, i2, i, DryDetailActivity.this.mDeviceVer, DryDetailActivity.this.mMachineId);
                                DryDetailActivity.this.mNBOr4GOpenControlUtil.openStart();
                                DryDetailActivity.this.mNBOr4GCloseControlUtil.setDeviceInfo(i, DryDetailActivity.this.mDeviceVer, DryDetailActivity.this.mMachineId);
                            }
                        }
                    }, 50L);
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (DryDetailActivity.this.mIsEnable) {
                    if (!z || !StringUtils.isNotEmpty(DryDetailActivity.this.mQrcode) || DryDetailActivity.this.mQrcode.length() < 52 || !DryDetailActivity.this.mQrcode.startsWith("55")) {
                        DryDetailActivity.this.showDialogNeedExit("设备未授权，请联系管理员" + DryDetailActivity.this.mBluetoothDevice.address);
                    } else {
                        DryDetailActivity dryDetailActivity = DryDetailActivity.this;
                        dryDetailActivity.updateMac(dryDetailActivity.mQrcode.substring(2, 10), DryDetailActivity.this.mBluetoothDevice.address);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateMac(String str, String str2) {
        V3BusinessControllers.getInstance().getUpdateMachineMac(getLoginAccount(), str, str2, 16, new Listener<MachineByMacBean>() { // from class: client.android.yixiaotong.v3.ui.appcontrol.dry.DryDetailActivity.6
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, MachineByMacBean machineByMacBean, Object... objArr) {
                if (DryDetailActivity.this.mIsEnable) {
                    DryDetailActivity.this.getDeviceInfo(false);
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (DryDetailActivity.this.mIsEnable) {
                    DryDetailActivity.this.onError(clientException);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onError(int i, String str) {
        BaseMaterialDialog.dissmisMaterialDialog();
        V3ErrorTipActivity.launchBluetoothFail(getActivity(), this.mTitleBar.getTitleViewContent(), str, i);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onError(ClientException clientException) {
        BaseMaterialDialog.dissmisMaterialDialog();
        if (clientException.isNeedTip(clientException.getCode())) {
            SystemErrorTip.getInstance().showTipDialog(getActivity(), new SystemErrorTip.SystemErrorDialogListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.dry.DryDetailActivity.7
                @Override // client.android.yixiaotong.ui.dialog.SystemErrorTip.SystemErrorDialogListener
                public void onConfirm() {
                    DryDetailActivity.this.finish();
                }
            }, clientException.getDetail() + "\n(" + LocalDataUtil.getTraceID(getContext()) + ")");
        } else {
            V3ErrorTipActivity.launch(getActivity(), this.mTitleBar.getTitleViewContent(), clientException.getDetail(), clientException.getCode(), 2, clientException.getSerial());
            finish();
        }
    }

    private void showDialog(String str) {
        BaseMaterialDialog.dissmisMaterialDialog();
        SystemErrorTip.getInstance().showTipDialog(getActivity(), str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialogNeedExit(String str) {
        BaseMaterialDialog.dissmisMaterialDialog();
        SystemErrorTip.getInstance().showTipDialog(getActivity(), "", str + "\n(" + LocalDataUtil.getTraceID(getContext()) + ")", "", false, new SystemErrorTip.SystemErrorDialogListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.dry.DryDetailActivity.8
            @Override // client.android.yixiaotong.ui.dialog.SystemErrorTip.SystemErrorDialogListener
            public void onConfirm() {
                DryDetailActivity.this.finish();
            }
        });
    }

    class TimeCount extends CountDownTimer {
        public TimeCount(long j, long j2) {
            super(j, j2);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            if (DryDetailActivity.this.mIsEnable) {
                DryDetailActivity.this.finish();
            }
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            if (DryDetailActivity.this.mIsEnable) {
                DryDetailActivity.this.mTvTime.setTextColor(DryDetailActivity.this.getResources().getColor(R.color.ffa1a6b3));
                DryDetailActivity.this.mTvTime.setClickable(false);
                DryDetailActivity.this.mTvTime.setText(Html.fromHtml("该页面将在" + (j / 1000) + "后自动关闭"));
                DryDetailActivity.this.mTvTime.setTextSize(13.0f);
                DryDetailActivity.this.mTvTime.setPadding(5, 5, 5, 5);
            }
        }
    }

    private void getAdv() {
        this.mNativeUtil = new NativeUtil();
        this.mAdvListener = new AdvControlUtil.AdvListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.dry.DryDetailActivity.10
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
                if (i5 == 1) {
                    DryDetailActivity.this.mNativeUtil.initNative(DryDetailActivity.this.getActivity(), DryDetailActivity.this.mAdvListener, 1);
                    DryDetailActivity.this.mNativeUtil.onNative(DryDetailActivity.this.rlContainer);
                }
                if (i3 == 1) {
                    MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.v3.ui.appcontrol.dry.DryDetailActivity.10.1
                        @Override // java.lang.Runnable
                        public void run() {
                            DryDetailActivity.this.mGvAdv.setVisibility(0);
                            DryDetailActivity.this.mAdvAdapter = new AdvAdapter();
                            DryDetailActivity.this.mGvAdv.setAdapter((ListAdapter) DryDetailActivity.this.mAdvAdapter);
                            DryDetailActivity.this.mGvAdv.setOnItemClickListener(DryDetailActivity.this);
                            DryDetailActivity.this.mBannerJumpInfo = AdvControlUtil.getInstance().getBannerJumpInfos();
                            DryDetailActivity.this.mAdvAdapter.notifyDataSetChanged();
                        }
                    });
                }
            }
        };
        AdvControlUtil.getInstance().init(getActivity(), this.mAdvListener, 16, true, "");
        AdvControlUtil.getInstance().initAdvInfo();
    }

    public void requestInteraction() {
        this.mGvAdv.setVisibility(8);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        AdvControlUtil.getInstance().requestJumpAdv(i);
    }

    private class AdvAdapter extends BaseAdapter {
        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        private AdvAdapter() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return DryDetailActivity.this.mBannerJumpInfo.size();
        }

        @Override // android.widget.Adapter
        public BannerJumpInfoBean getItem(int i) {
            return (BannerJumpInfoBean) DryDetailActivity.this.mBannerJumpInfo.get(i);
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder viewHolder;
            if (view == null) {
                view = LayoutInflater.from(DryDetailActivity.this.getContext()).inflate(R.layout.adv_item, (ViewGroup) null);
                viewHolder = new ViewHolder(view);
                view.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) view.getTag();
            }
            Glide.with(DryDetailActivity.this.getActivity()).load(((BannerJumpInfoBean) DryDetailActivity.this.mBannerJumpInfo.get(i)).info.pictureUrl).into(viewHolder.img);
            return view;
        }

        class ViewHolder {
            public ImageView img;

            public ViewHolder(View view) {
                this.img = (ImageView) view.findViewById(R.id.img_item);
            }
        }
    }
}
