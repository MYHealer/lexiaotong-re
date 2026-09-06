package client.android.yixiaotong.v3.ui.appcontrol.wash;

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
import client.android.yixiaotong.v3.util.LanguageUtils;
import client.android.yixiaotong.v3.util.LocalDataUtil;
import client.android.yixiaotong.v3.util.LogUtil;
import com.bumptech.glide.Glide;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.lxt.bluetoothsdk.model.BluetoothDevice;
import com.stub.StubApp;
import com.unionpay.tsmservice.mi.data.Constant;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class WashDetailActivity extends BaseActivity implements AdapterView.OnItemClickListener {
    public static final String TAG = "WashDetail";
    private static final int TYPEID = 3;
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
    private PermissionUtil.PermissionGrant permissionGrant = new PermissionUtil.PermissionGrant() { // from class: client.android.yixiaotong.v3.ui.appcontrol.wash.WashDetailActivity.9
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
        StubApp.interface11(9591);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public native void onRequestPermissionsResult(int i, String[] strArr, int[] iArr);

    public static void launch(Activity activity, String str, String str2, boolean z, ModeBean modeBean) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) WashDetailActivity.class).putExtra("qrcode", str).putExtra(Constant.KEY_MAC, str2).putExtra("isbluetoothdevice", z).putExtra("bean", modeBean));
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

    private void initTitleBar() {
        if (this.mTypeInfoBaseInfoBean != null) {
            this.mTitleBar.setTitleView(LanguageUtils.getAppName(getActivity(), this.mTypeInfoBaseInfoBean.typeId, this.mTypeInfoBaseInfoBean.appName));
        } else {
            this.mTitleBar.setTitleView(getString(R.string.laundry));
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
        bluetoothOpenControlUtil.init(getActivity(), getLoginAccount(), this.mBluetoothDevice, this.mTypeInfoBaseInfoBean, 3, this.mTitleBar.getTitleViewContent(), this.mQrcode);
        this.mBluetoothOpenControlUtil.setHandleType(this.mModeBean.f);
        this.mBluetoothOpenControlUtil.setListener(new OpenControlListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.wash.WashDetailActivity.1
            @Override // client.android.yixiaotong.v3.ui.appcontrol.listener.OpenControlListener
            public void onOpenEnd() {
                WashDetailActivity.this.openEnd();
            }

            @Override // client.android.yixiaotong.v3.ui.appcontrol.listener.OpenControlListener
            public void onOpenFail() {
                WashDetailActivity.this.mIsOpenFail = true;
            }
        });
        NBOr4GOpenControlUtil nBOr4GOpenControlUtil = new NBOr4GOpenControlUtil();
        this.mNBOr4GOpenControlUtil = nBOr4GOpenControlUtil;
        nBOr4GOpenControlUtil.init(getActivity(), getLoginAccount(), this.mBluetoothDevice, this.mTypeInfoBaseInfoBean, 3, this.mStudentHex, this.mTitleBar.getTitleViewContent());
        this.mNBOr4GOpenControlUtil.setHandleType(this.mModeBean.f);
        this.mNBOr4GOpenControlUtil.setListener(new OpenControlListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.wash.WashDetailActivity.2
            @Override // client.android.yixiaotong.v3.ui.appcontrol.listener.OpenControlListener
            public void onOpenEnd() {
                WashDetailActivity.this.openEnd();
            }

            @Override // client.android.yixiaotong.v3.ui.appcontrol.listener.OpenControlListener
            public void onOpenFail() {
                WashDetailActivity.this.mIsOpenFail = true;
            }
        });
        NBOr4GCloseControlUtil nBOr4GCloseControlUtil = new NBOr4GCloseControlUtil();
        this.mNBOr4GCloseControlUtil = nBOr4GCloseControlUtil;
        nBOr4GCloseControlUtil.init(getActivity(), getLoginAccount(), this.mBluetoothDevice, this.mTypeInfoBaseInfoBean, 3, this.mStudentHex, this.mTitleBar.getTitleViewContent());
        this.mNBOr4GCloseControlUtil.setListener(new CloseControlListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.wash.WashDetailActivity.3
            @Override // client.android.yixiaotong.v3.ui.appcontrol.listener.CloseControlListener
            public void onCloseEnd() {
                ToastUtils.show(WashDetailActivity.this.getContext(), "关阀成功");
                CloseSuccessActivity.launch(WashDetailActivity.this.getActivity(), 3);
                WashDetailActivity.this.finish();
            }
        });
    }

    public void onClose(View view) {
        finish();
    }

    public void initBluetooth() {
        BluetoothControlUtil.getInstance().init(getActivity());
        BluetoothControlUtil.getInstance().setListener(new BluetoothControlUtil.Listener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.wash.WashDetailActivity.4
            @Override // client.android.yixiaotong.v3.bluetoothutil.BluetoothControlUtil.Listener
            public void onConnected() {
                super.onConnected();
                LogUtil.i(WashDetailActivity.TAG, "onConnected");
                if (WashDetailActivity.this.mFlowState == FlowState.opening) {
                    if (WashDetailActivity.this.mIsBluetoothDevice) {
                        WashDetailActivity.this.mBluetoothOpenControlUtil.connected();
                        return;
                    } else {
                        WashDetailActivity.this.mNBOr4GOpenControlUtil.connected();
                        return;
                    }
                }
                if (WashDetailActivity.this.mFlowState == FlowState.opened) {
                    WashDetailActivity.this.mNBOr4GOpenControlUtil.connectedForOpened();
                } else if (WashDetailActivity.this.mFlowState == FlowState.closeing) {
                    WashDetailActivity.this.mNBOr4GCloseControlUtil.connected();
                }
            }

            @Override // client.android.yixiaotong.v3.bluetoothutil.BluetoothControlUtil.Listener
            public void onFail(int i, String str) {
                super.onFail(i, str);
                LogUtil.i(WashDetailActivity.TAG, "onFail" + i + "  " + str);
                if (str.equalsIgnoreCase("Discover") || str.equalsIgnoreCase("Connect")) {
                    str = "尝试重启手机或设备蓝牙再试";
                }
                if (WashDetailActivity.this.mFlowState == FlowState.opening) {
                    if (WashDetailActivity.this.mIsBluetoothDevice) {
                        if (WashDetailActivity.this.mIsOpenFail) {
                            return;
                        }
                        WashDetailActivity.this.onError(i, str);
                        return;
                    }
                    WashDetailActivity.this.mNBOr4GOpenControlUtil.onBluetoothError(i, str);
                    return;
                }
                if (WashDetailActivity.this.mFlowState == FlowState.opened) {
                    WashDetailActivity.this.disconnect();
                    BluetoothControlUtil.getInstance().connectBluetooth(WashDetailActivity.this.mBluetoothDevice);
                } else if (WashDetailActivity.this.mFlowState == FlowState.closeing) {
                    WashDetailActivity.this.onError(i, str);
                }
            }

            @Override // client.android.yixiaotong.v3.bluetoothutil.BluetoothControlUtil.Listener
            public void onReceivedData(String str) {
                super.onReceivedData(str);
                LogUtil.i(WashDetailActivity.TAG, "onReceivedData:" + str);
                if (WashDetailActivity.this.mFlowState == FlowState.opening) {
                    if (WashDetailActivity.this.mIsBluetoothDevice) {
                        return;
                    }
                    WashDetailActivity.this.mNBOr4GOpenControlUtil.onReceivedData(str);
                } else if (WashDetailActivity.this.mFlowState == FlowState.opened) {
                    if (WashDetailActivity.this.mIsBluetoothDevice) {
                        return;
                    }
                    WashDetailActivity.this.mNBOr4GOpenControlUtil.onReceivedData(str);
                } else if (WashDetailActivity.this.mFlowState == FlowState.closeing) {
                    WashDetailActivity.this.mNBOr4GCloseControlUtil.onReceivedData(str);
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
        V3BusinessControllers.getInstance().getMachineByMac(getLoginAccount(), this.mBluetoothDevice.address, 3, new Listener<MachineByMacBean>() { // from class: client.android.yixiaotong.v3.ui.appcontrol.wash.WashDetailActivity.5
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, MachineByMacBean machineByMacBean, Object... objArr) {
                if (WashDetailActivity.this.mIsEnable) {
                    if (machineByMacBean == null || !StringUtils.isNotEmpty(machineByMacBean.deviceVer) || !StringUtils.isNotEmpty(machineByMacBean.machineId)) {
                        if (!z || !StringUtils.isNotEmpty(WashDetailActivity.this.mQrcode) || WashDetailActivity.this.mQrcode.length() < 52 || !WashDetailActivity.this.mQrcode.startsWith("55")) {
                            WashDetailActivity.this.showDialogNeedExit("设备未授权，请联系管理员" + WashDetailActivity.this.mBluetoothDevice.address);
                            return;
                        } else {
                            WashDetailActivity washDetailActivity = WashDetailActivity.this;
                            washDetailActivity.updateMac(washDetailActivity.mQrcode.substring(2, 10), WashDetailActivity.this.mBluetoothDevice.address);
                            return;
                        }
                    }
                    WashDetailActivity.this.mDeviceVer = machineByMacBean.deviceVer;
                    WashDetailActivity.this.mMachineId = machineByMacBean.machineId;
                    WashDetailActivity.this.mFlowState = FlowState.opening;
                    final int i = machineByMacBean.cnflag;
                    final int i2 = machineByMacBean.mtype;
                    BluetoothControlUtil.getInstance().setDeviceType(WashDetailActivity.this.mDeviceVer);
                    MainThreadExecutor.getInstance().executeDelayed(new Runnable() { // from class: client.android.yixiaotong.v3.ui.appcontrol.wash.WashDetailActivity.5.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (WashDetailActivity.this.mIsBluetoothDevice) {
                                WashDetailActivity.this.mBluetoothOpenControlUtil.setDeviceInfo(WashDetailActivity.this.mDeviceVer, WashDetailActivity.this.mMachineId);
                                WashDetailActivity.this.mBluetoothOpenControlUtil.openStart();
                            } else {
                                WashDetailActivity.this.mNBOr4GOpenControlUtil.setDeviceInfo(WashDetailActivity.this.mPreferredCommunicationType, i2, i, WashDetailActivity.this.mDeviceVer, WashDetailActivity.this.mMachineId);
                                WashDetailActivity.this.mNBOr4GOpenControlUtil.openStart();
                                WashDetailActivity.this.mNBOr4GCloseControlUtil.setDeviceInfo(i, WashDetailActivity.this.mDeviceVer, WashDetailActivity.this.mMachineId);
                            }
                        }
                    }, 50L);
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (WashDetailActivity.this.mIsEnable) {
                    if (!z || !StringUtils.isNotEmpty(WashDetailActivity.this.mQrcode) || WashDetailActivity.this.mQrcode.length() < 52 || !WashDetailActivity.this.mQrcode.startsWith("55")) {
                        WashDetailActivity.this.showDialogNeedExit("设备未授权，请联系管理员" + WashDetailActivity.this.mBluetoothDevice.address);
                    } else {
                        WashDetailActivity washDetailActivity = WashDetailActivity.this;
                        washDetailActivity.updateMac(washDetailActivity.mQrcode.substring(2, 10), WashDetailActivity.this.mBluetoothDevice.address);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateMac(String str, String str2) {
        V3BusinessControllers.getInstance().getUpdateMachineMac(getLoginAccount(), str, str2, 3, new Listener<MachineByMacBean>() { // from class: client.android.yixiaotong.v3.ui.appcontrol.wash.WashDetailActivity.6
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, MachineByMacBean machineByMacBean, Object... objArr) {
                if (WashDetailActivity.this.mIsEnable) {
                    WashDetailActivity.this.getDeviceInfo(false);
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (WashDetailActivity.this.mIsEnable) {
                    WashDetailActivity.this.onError(clientException);
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
            SystemErrorTip.getInstance().showTipDialog(getActivity(), new SystemErrorTip.SystemErrorDialogListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.wash.WashDetailActivity.7
                @Override // client.android.yixiaotong.ui.dialog.SystemErrorTip.SystemErrorDialogListener
                public void onConfirm() {
                    WashDetailActivity.this.finish();
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
        SystemErrorTip.getInstance().showTipDialog(getActivity(), "", str + "\n(" + LocalDataUtil.getTraceID(getContext()) + ")", "", false, new SystemErrorTip.SystemErrorDialogListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.wash.WashDetailActivity.8
            @Override // client.android.yixiaotong.ui.dialog.SystemErrorTip.SystemErrorDialogListener
            public void onConfirm() {
                WashDetailActivity.this.finish();
            }
        });
    }

    class TimeCount extends CountDownTimer {
        public TimeCount(long j, long j2) {
            super(j, j2);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            if (WashDetailActivity.this.mIsEnable) {
                WashDetailActivity.this.finish();
            }
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            if (WashDetailActivity.this.mIsEnable) {
                WashDetailActivity.this.mTvTime.setTextColor(WashDetailActivity.this.getResources().getColor(R.color.ffa1a6b3));
                WashDetailActivity.this.mTvTime.setClickable(false);
                WashDetailActivity.this.mTvTime.setText(Html.fromHtml("该页面将在" + (j / 1000) + "后自动关闭"));
                WashDetailActivity.this.mTvTime.setTextSize(13.0f);
                WashDetailActivity.this.mTvTime.setPadding(5, 5, 5, 5);
            }
        }
    }

    private void getAdv() {
        this.mNativeUtil = new NativeUtil();
        this.mAdvListener = new AdvControlUtil.AdvListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.wash.WashDetailActivity.10
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
                    WashDetailActivity.this.mNativeUtil.initNative(WashDetailActivity.this.getActivity(), WashDetailActivity.this.mAdvListener, 1);
                    WashDetailActivity.this.mNativeUtil.onNative(WashDetailActivity.this.rlContainer);
                }
                if (i3 == 1) {
                    MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.v3.ui.appcontrol.wash.WashDetailActivity.10.1
                        @Override // java.lang.Runnable
                        public void run() {
                            WashDetailActivity.this.mGvAdv.setVisibility(0);
                            WashDetailActivity.this.mAdvAdapter = new AdvAdapter();
                            WashDetailActivity.this.mGvAdv.setAdapter((ListAdapter) WashDetailActivity.this.mAdvAdapter);
                            WashDetailActivity.this.mGvAdv.setOnItemClickListener(WashDetailActivity.this);
                            WashDetailActivity.this.mBannerJumpInfo = AdvControlUtil.getInstance().getBannerJumpInfos();
                            WashDetailActivity.this.mAdvAdapter.notifyDataSetChanged();
                        }
                    });
                }
            }
        };
        AdvControlUtil.getInstance().init(getActivity(), this.mAdvListener, 3, true, "");
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
            return WashDetailActivity.this.mBannerJumpInfo.size();
        }

        @Override // android.widget.Adapter
        public BannerJumpInfoBean getItem(int i) {
            return (BannerJumpInfoBean) WashDetailActivity.this.mBannerJumpInfo.get(i);
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder viewHolder;
            if (view == null) {
                view = LayoutInflater.from(WashDetailActivity.this.getContext()).inflate(R.layout.adv_item, (ViewGroup) null);
                viewHolder = new ViewHolder(view);
                view.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) view.getTag();
            }
            Glide.with(WashDetailActivity.this.getActivity()).load(((BannerJumpInfoBean) WashDetailActivity.this.mBannerJumpInfo.get(i)).info.pictureUrl).into(viewHolder.img);
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
