package client.android.yixiaotong.v3.ui.appcontrol.hairdryer;

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
import client.android.yixiaotong.util.android.NetworkUtils;
import client.android.yixiaotong.util.executor.MainThreadExecutor;
import client.android.yixiaotong.util.permission.PermissionUtil;
import client.android.yixiaotong.v3.bean.adv.BannerJumpInfoBean;
import client.android.yixiaotong.v3.bean.deviceinfo.MachineByMacBean;
import client.android.yixiaotong.v3.bean.login.TypeInfoBaseInfoBean;
import client.android.yixiaotong.v3.bean.login.UseToolsJsonBean;
import client.android.yixiaotong.v3.bluetoothutil.BluetoothControlUtil;
import client.android.yixiaotong.v3.http.V3BusinessControllers;
import client.android.yixiaotong.v3.ui.adv.AdvControlUtil;
import client.android.yixiaotong.v3.ui.adv.Common;
import client.android.yixiaotong.v3.ui.adv.NativeUtil;
import client.android.yixiaotong.v3.ui.appcontrol.control.BeforeOpenControlUtil;
import client.android.yixiaotong.v3.ui.appcontrol.drinkwater.BluetoothOpenControlUtil;
import client.android.yixiaotong.v3.ui.appcontrol.drinkwater.CloseSuccessActivity;
import client.android.yixiaotong.v3.ui.appcontrol.drinkwater.NBOr4GCloseControlUtil;
import client.android.yixiaotong.v3.ui.appcontrol.drinkwater.NBOr4GOpenControlUtil;
import client.android.yixiaotong.v3.ui.appcontrol.listener.CloseControlListener;
import client.android.yixiaotong.v3.ui.appcontrol.listener.ErrorControlListener;
import client.android.yixiaotong.v3.ui.appcontrol.listener.OpenControlListener;
import client.android.yixiaotong.v3.ui.error.V3ErrorTipActivity;
import client.android.yixiaotong.v3.ui.scan.QrcodeUtil;
import client.android.yixiaotong.v3.userinfo.UserInfoUtil;
import client.android.yixiaotong.v3.util.Error50XUtil;
import client.android.yixiaotong.v3.util.LanguageUtils;
import client.android.yixiaotong.v3.util.LocalDataUtil;
import client.android.yixiaotong.v3.util.LogUtil;
import com.bumptech.glide.Glide;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.huawei.openalliance.ad.views.PPSLabelView;
import com.lxt.bluetoothsdk.BluetoothSDK;
import com.lxt.bluetoothsdk.model.BluetoothDevice;
import com.stub.StubApp;
import com.unionpay.tsmservice.mi.data.Constant;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class HairdryerDetailActivity extends BaseActivity implements AdapterView.OnItemClickListener {
    public static final String TAG = "HairdryerDetail";
    private static final int TYPEID = 8;
    private FrameLayout flContainer;
    private AdvAdapter mAdvAdapter;
    private AdvControlUtil.AdvListener mAdvListener;
    private BluetoothDevice mBluetoothDevice;
    private BluetoothOpenControlUtil mBluetoothOpenControlUtil;
    private Button mBtnClose;
    private ClientException mClientException;
    private int mCnFlag;
    private WrapGridView mGvAdv;
    private ImageView mIvCircle;
    private String mMac;
    private NBOr4GCloseControlUtil mNBOr4GCloseControlUtil;
    private NBOr4GOpenControlUtil mNBOr4GOpenControlUtil;
    private NativeUtil mNativeUtil;
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
    private int mType;
    private TypeInfoBaseInfoBean mTypeInfoBaseInfoBean;
    private UseToolsJsonBean mUseToolsJsonBean;
    private RelativeLayout rlContainer;
    private boolean mIsEnable = true;
    private FlowState mFlowState = FlowState.none;
    private String mDeviceVer = "";
    private String mMachineId = "";
    private boolean mIsBluetoothDevice = true;
    private int mPreferredCommunicationType = 0;
    private boolean mIsOpenFail = false;
    private boolean mIsOffineOpen = false;
    private boolean mIsCloseConnected = false;
    private PermissionUtil.PermissionGrant permissionGrant = new PermissionUtil.PermissionGrant() { // from class: client.android.yixiaotong.v3.ui.appcontrol.hairdryer.HairdryerDetailActivity.13
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
        StubApp.interface11(9380);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public native void onRequestPermissionsResult(int i, String[] strArr, int[] iArr);

    public static void launch(Activity activity, String str) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) HairdryerDetailActivity.class).putExtra("qrcode", str));
        }
    }

    public static void launch(Activity activity, String str, String str2, String str3, int i, int i2, String str4) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) HairdryerDetailActivity.class).putExtra("qrcode", str).putExtra("devicever", str2).putExtra("machineid", str3).putExtra("cnflag", i).putExtra("mtype", i2).putExtra(Constant.KEY_MAC, str4));
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
        BluetoothSDK.getInstance().init(getContext());
        this.mIsOffineOpen = false;
        UseToolsJsonBean useToolsJsonBean = this.mUseToolsJsonBean;
        if (useToolsJsonBean != null && useToolsJsonBean.preferredCommunicationType != null) {
            this.mPreferredCommunicationType = this.mUseToolsJsonBean.preferredCommunicationType.intValue();
        }
        this.mStudentHex = UserInfoUtil.getInstance().getLoginAccountV3().studentHex;
        LogUtil.e(TAG, "preferredCommunicationType:" + this.mPreferredCommunicationType + PPSLabelView.Code + this.mQrcode);
        if (StringUtils.isNotEmpty(this.mQrcode) && this.mQrcode.length() >= 52) {
            String mac = QrcodeUtil.getMac(this.mQrcode.substring(40, 52));
            this.mIsBluetoothDevice = true;
            if (QrcodeUtil.isNBor4GDevice(this.mQrcode, 8)) {
                this.mIsBluetoothDevice = false;
                mac = QrcodeUtil.getMac(this.mQrcode.substring(0, 12));
                if (Error50XUtil.isInterrupt(getActivity())) {
                    this.mMachineId = this.mQrcode.substring(34, 50);
                }
            }
            initData(mac);
            return;
        }
        this.mIsBluetoothDevice = false;
        if (StringUtils.isNotEmpty(this.mMac)) {
            initData(this.mMac);
        } else {
            getInfoByQRCode();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initData(String str) {
        if (StringUtils.isNotEmpty(str) && str.length() == 17 && QrcodeUtil.isMacIllegal(str)) {
            this.mBluetoothDevice = new BluetoothDevice(str, str, 0);
            initView();
            initBluetooth();
            initControl();
            getAdv();
            if (StringUtils.isNotEmpty(this.mMachineId) && StringUtils.isNotEmpty(this.mDeviceVer)) {
                startOpen();
                return;
            } else if (Error50XUtil.isInterrupt(getActivity()) || (LocalDataUtil.getIsFirstOffline(getActivity()) && LocalDataUtil.getIsEnableOffline(getActivity()))) {
                startOpenOffline(null);
                return;
            } else {
                getDeviceInfo(true);
                return;
            }
        }
        ToastUtils.show(getContext(), "不合法的蓝牙地址" + str);
        finish();
    }

    private void initTitleBar() {
        if (this.mTypeInfoBaseInfoBean != null) {
            this.mTitleBar.setTitleView(LanguageUtils.getAppName(getActivity(), this.mTypeInfoBaseInfoBean.typeId, this.mTypeInfoBaseInfoBean.appName));
        } else {
            this.mTitleBar.setTitleView(getString(R.string.hairdryer));
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
        this.mTvConnectTip.setVisibility(0);
        this.mTvMac.setVisibility(0);
        this.mTvTime.setVisibility(4);
    }

    private void initControl() {
        BluetoothOpenControlUtil bluetoothOpenControlUtil = new BluetoothOpenControlUtil();
        this.mBluetoothOpenControlUtil = bluetoothOpenControlUtil;
        bluetoothOpenControlUtil.init(getActivity(), getLoginAccount(), this.mBluetoothDevice, this.mTypeInfoBaseInfoBean, 8, this.mTitleBar.getTitleViewContent(), this.mQrcode);
        this.mBluetoothOpenControlUtil.setListener(new OpenControlListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.hairdryer.HairdryerDetailActivity.1
            @Override // client.android.yixiaotong.v3.ui.appcontrol.listener.OpenControlListener
            public void onOpenEnd() {
                HairdryerDetailActivity.this.openEnd();
            }

            @Override // client.android.yixiaotong.v3.ui.appcontrol.listener.OpenControlListener
            public void onOpenFail() {
                HairdryerDetailActivity.this.mIsOpenFail = true;
            }
        });
        NBOr4GOpenControlUtil nBOr4GOpenControlUtil = new NBOr4GOpenControlUtil();
        this.mNBOr4GOpenControlUtil = nBOr4GOpenControlUtil;
        nBOr4GOpenControlUtil.init(getActivity(), getLoginAccount(), this.mBluetoothDevice, this.mTypeInfoBaseInfoBean, 8, this.mStudentHex, this.mTitleBar.getTitleViewContent());
        this.mNBOr4GOpenControlUtil.setListener(new OpenControlListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.hairdryer.HairdryerDetailActivity.2
            @Override // client.android.yixiaotong.v3.ui.appcontrol.listener.OpenControlListener
            public void onOpenEnd() {
                HairdryerDetailActivity.this.openEnd();
            }

            @Override // client.android.yixiaotong.v3.ui.appcontrol.listener.OpenControlListener
            public void onOpenFail() {
                HairdryerDetailActivity.this.mIsOpenFail = true;
            }
        });
        this.mNBOr4GOpenControlUtil.setErrorListener(new ErrorControlListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.hairdryer.HairdryerDetailActivity.3
            @Override // client.android.yixiaotong.v3.ui.appcontrol.listener.ErrorControlListener
            public void onFail(ClientException clientException) {
                if (clientException != null) {
                    HairdryerDetailActivity.this.mIsOffineOpen = true;
                    HairdryerDetailActivity.this.mClientException = clientException;
                }
            }
        });
        NBOr4GCloseControlUtil nBOr4GCloseControlUtil = new NBOr4GCloseControlUtil();
        this.mNBOr4GCloseControlUtil = nBOr4GCloseControlUtil;
        nBOr4GCloseControlUtil.init(getActivity(), getLoginAccount(), this.mBluetoothDevice, this.mTypeInfoBaseInfoBean, 8, this.mStudentHex, this.mTitleBar.getTitleViewContent());
        this.mNBOr4GCloseControlUtil.setListener(new CloseControlListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.hairdryer.HairdryerDetailActivity.4
            @Override // client.android.yixiaotong.v3.ui.appcontrol.listener.CloseControlListener
            public void onCloseEnd() {
                ToastUtils.show(HairdryerDetailActivity.this.getContext(), "关阀成功");
                CloseSuccessActivity.launch(HairdryerDetailActivity.this.getActivity(), 8);
                HairdryerDetailActivity.this.finish();
            }
        });
        this.mBluetoothOpenControlUtil.onResume();
        this.mNBOr4GOpenControlUtil.onResume();
        this.mNBOr4GCloseControlUtil.onResume();
    }

    public void onClose(View view) {
        BaseMaterialDialog.showMaterialDialog(getActivity(), "正在关阀中.", false);
        this.mFlowState = FlowState.closeing;
        disconnect();
        this.mNBOr4GCloseControlUtil.closeStart();
        MainThreadExecutor.getInstance().executeDelayed(new Runnable() { // from class: client.android.yixiaotong.v3.ui.appcontrol.hairdryer.HairdryerDetailActivity.5
            @Override // java.lang.Runnable
            public void run() {
                if (HairdryerDetailActivity.this.mIsEnable && HairdryerDetailActivity.this.mFlowState == FlowState.closeing && !HairdryerDetailActivity.this.mIsCloseConnected) {
                    ToastUtils.show(HairdryerDetailActivity.this.getActivity(), "关阀失败");
                    BaseMaterialDialog.dissmisMaterialDialog();
                    LogUtil.e(HairdryerDetailActivity.TAG, "关阀失败");
                }
            }
        }, 7000L);
    }

    public void initBluetooth() {
        BluetoothControlUtil.getInstance().init(getActivity());
        BluetoothControlUtil.getInstance().setListener(new BluetoothControlUtil.Listener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.hairdryer.HairdryerDetailActivity.6
            @Override // client.android.yixiaotong.v3.bluetoothutil.BluetoothControlUtil.Listener
            public void onConnected() {
                super.onConnected();
                LogUtil.i(HairdryerDetailActivity.TAG, "onConnected  " + HairdryerDetailActivity.this.mFlowState + "  " + HairdryerDetailActivity.this.mIsBluetoothDevice + "  " + HairdryerDetailActivity.this.mIsOffineOpen);
                if (HairdryerDetailActivity.this.mIsOffineOpen) {
                    if (HairdryerDetailActivity.this.mFlowState == FlowState.opening) {
                        HairdryerDetailActivity.this.mNBOr4GOpenControlUtil.connected();
                        return;
                    } else {
                        if (HairdryerDetailActivity.this.mFlowState == FlowState.closeing) {
                            HairdryerDetailActivity.this.mNBOr4GCloseControlUtil.connected();
                            return;
                        }
                        return;
                    }
                }
                if (HairdryerDetailActivity.this.mFlowState == FlowState.opening) {
                    if (HairdryerDetailActivity.this.mIsBluetoothDevice) {
                        HairdryerDetailActivity.this.mBluetoothOpenControlUtil.connected();
                        return;
                    } else {
                        HairdryerDetailActivity.this.mNBOr4GOpenControlUtil.connected();
                        return;
                    }
                }
                if (HairdryerDetailActivity.this.mFlowState == FlowState.closeing) {
                    HairdryerDetailActivity.this.mIsCloseConnected = true;
                    HairdryerDetailActivity.this.mNBOr4GCloseControlUtil.connected();
                }
            }

            @Override // client.android.yixiaotong.v3.bluetoothutil.BluetoothControlUtil.Listener
            public void onFail(int i, String str) {
                super.onFail(i, str);
                LogUtil.i(HairdryerDetailActivity.TAG, "onFail" + i + "  " + str + "  " + HairdryerDetailActivity.this.mFlowState + "  " + HairdryerDetailActivity.this.mIsBluetoothDevice + "  " + HairdryerDetailActivity.this.mIsOffineOpen);
                if (HairdryerDetailActivity.this.mIsOffineOpen) {
                    if (HairdryerDetailActivity.this.mClientException != null) {
                        HairdryerDetailActivity hairdryerDetailActivity = HairdryerDetailActivity.this;
                        hairdryerDetailActivity.onError(hairdryerDetailActivity.mClientException);
                        return;
                    } else {
                        HairdryerDetailActivity.this.getDeviceInfo(true);
                        return;
                    }
                }
                if (str.equalsIgnoreCase("Discover") || str.equalsIgnoreCase("Connect")) {
                    str = "尝试重启手机或设备蓝牙再试";
                }
                if (HairdryerDetailActivity.this.mFlowState == FlowState.opening) {
                    if (HairdryerDetailActivity.this.mIsBluetoothDevice) {
                        if (HairdryerDetailActivity.this.mIsOpenFail) {
                            return;
                        }
                        HairdryerDetailActivity.this.onError(i, str);
                        return;
                    }
                    HairdryerDetailActivity.this.mNBOr4GOpenControlUtil.onBluetoothError(i, str);
                    return;
                }
                if (HairdryerDetailActivity.this.mFlowState == FlowState.closeing) {
                    HairdryerDetailActivity.this.onError(i, str);
                }
            }

            @Override // client.android.yixiaotong.v3.bluetoothutil.BluetoothControlUtil.Listener
            public void onReceivedData(String str) {
                super.onReceivedData(str);
                LogUtil.i(HairdryerDetailActivity.TAG, "onReceivedData:" + str);
                if (HairdryerDetailActivity.this.mIsOffineOpen) {
                    if (HairdryerDetailActivity.this.mFlowState == FlowState.opening) {
                        HairdryerDetailActivity.this.mNBOr4GOpenControlUtil.onReceivedData(str);
                        return;
                    } else {
                        if (HairdryerDetailActivity.this.mFlowState == FlowState.closeing) {
                            HairdryerDetailActivity.this.mNBOr4GCloseControlUtil.onReceivedData(str);
                            return;
                        }
                        return;
                    }
                }
                if (HairdryerDetailActivity.this.mFlowState == FlowState.opening) {
                    if (HairdryerDetailActivity.this.mIsBluetoothDevice) {
                        return;
                    }
                    HairdryerDetailActivity.this.mNBOr4GOpenControlUtil.onReceivedData(str);
                } else if (HairdryerDetailActivity.this.mFlowState == FlowState.opened) {
                    if (HairdryerDetailActivity.this.mIsBluetoothDevice) {
                        return;
                    }
                    HairdryerDetailActivity.this.mNBOr4GOpenControlUtil.onReceivedData(str);
                } else if (HairdryerDetailActivity.this.mFlowState == FlowState.closeing) {
                    HairdryerDetailActivity.this.mNBOr4GCloseControlUtil.onReceivedData(str);
                }
            }
        });
    }

    private void disconnect() {
        BluetoothControlUtil.getInstance().disconnect();
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.mIsEnable = true;
        BeforeOpenControlUtil.getInstance().onResume();
        BluetoothControlUtil.getInstance().onResume();
        BluetoothOpenControlUtil bluetoothOpenControlUtil = this.mBluetoothOpenControlUtil;
        if (bluetoothOpenControlUtil != null) {
            bluetoothOpenControlUtil.onResume();
        }
        NBOr4GOpenControlUtil nBOr4GOpenControlUtil = this.mNBOr4GOpenControlUtil;
        if (nBOr4GOpenControlUtil != null) {
            nBOr4GOpenControlUtil.onResume();
        }
        NBOr4GCloseControlUtil nBOr4GCloseControlUtil = this.mNBOr4GCloseControlUtil;
        if (nBOr4GCloseControlUtil != null) {
            nBOr4GCloseControlUtil.onResume();
        }
        AdvControlUtil.getInstance().onResume();
        NativeUtil nativeUtil = this.mNativeUtil;
        if (nativeUtil != null) {
            nativeUtil.onResume();
        }
        LogUtil.e(TAG, "onResume");
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        BeforeOpenControlUtil.getInstance().onPause();
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
        BluetoothOpenControlUtil bluetoothOpenControlUtil = this.mBluetoothOpenControlUtil;
        if (bluetoothOpenControlUtil != null) {
            bluetoothOpenControlUtil.onPause();
        }
        NBOr4GOpenControlUtil nBOr4GOpenControlUtil = this.mNBOr4GOpenControlUtil;
        if (nBOr4GOpenControlUtil != null) {
            nBOr4GOpenControlUtil.onPause();
        }
        NBOr4GCloseControlUtil nBOr4GCloseControlUtil = this.mNBOr4GCloseControlUtil;
        if (nBOr4GCloseControlUtil != null) {
            nBOr4GCloseControlUtil.onPause();
        }
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
    public void startOpenOffline(ClientException clientException) {
        if (NetworkUtils.isFlightModeEnabled(getActivity())) {
            ToastUtils.show(getActivity(), "请关闭飞行模式后重试");
            finish();
        } else {
            if (!NetworkUtils.isNetworkAvailable(getActivity())) {
                ToastUtils.show(getActivity(), "请打开网络后重试");
                finish();
                return;
            }
            BluetoothControlUtil.getInstance().initDeviceType();
            this.mIsBluetoothDevice = false;
            initView();
            this.mIsOffineOpen = true;
            this.mFlowState = FlowState.opening;
            this.mNBOr4GOpenControlUtil.openOffineStart(clientException);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startOpen() {
        this.mIsOffineOpen = false;
        this.mFlowState = FlowState.opening;
        BluetoothControlUtil.getInstance().setDeviceType(this.mDeviceVer);
        MainThreadExecutor.getInstance().executeDelayed(new Runnable() { // from class: client.android.yixiaotong.v3.ui.appcontrol.hairdryer.HairdryerDetailActivity.7
            @Override // java.lang.Runnable
            public void run() {
                if (HairdryerDetailActivity.this.mIsBluetoothDevice) {
                    HairdryerDetailActivity.this.mBluetoothOpenControlUtil.setDeviceInfo(HairdryerDetailActivity.this.mDeviceVer, HairdryerDetailActivity.this.mMachineId);
                    HairdryerDetailActivity.this.mBluetoothOpenControlUtil.openStart();
                } else {
                    HairdryerDetailActivity.this.mNBOr4GOpenControlUtil.setDeviceInfo(HairdryerDetailActivity.this.mPreferredCommunicationType, HairdryerDetailActivity.this.mType, HairdryerDetailActivity.this.mCnFlag, HairdryerDetailActivity.this.mDeviceVer, HairdryerDetailActivity.this.mMachineId);
                    HairdryerDetailActivity.this.mNBOr4GOpenControlUtil.openStart();
                    HairdryerDetailActivity.this.mNBOr4GCloseControlUtil.setDeviceInfo(HairdryerDetailActivity.this.mCnFlag, HairdryerDetailActivity.this.mDeviceVer, HairdryerDetailActivity.this.mMachineId);
                }
            }
        }, 50L);
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

    private void getInfoByQRCode() {
        V3BusinessControllers.getInstance().getInfoByQRCode(getLoginAccount(), this.mQrcode, false, new Listener<MachineByMacBean>() { // from class: client.android.yixiaotong.v3.ui.appcontrol.hairdryer.HairdryerDetailActivity.8
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                BaseMaterialDialog.setConnectMaterialDialog("正在获取数据中");
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, MachineByMacBean machineByMacBean, Object... objArr) {
                if (HairdryerDetailActivity.this.mIsEnable) {
                    if (machineByMacBean == null || !StringUtils.isNotEmpty(machineByMacBean.deviceMac)) {
                        HairdryerDetailActivity.this.showDialogNeedExit("设备未授权，请联系管理员");
                    } else {
                        HairdryerDetailActivity.this.initData(machineByMacBean.deviceMac);
                    }
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (HairdryerDetailActivity.this.mIsEnable) {
                    HairdryerDetailActivity.this.onError(clientException);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getDeviceInfo(final boolean z) {
        V3BusinessControllers.getInstance().getMachineByMac(getLoginAccount(), this.mBluetoothDevice.address, 8, new Listener<MachineByMacBean>() { // from class: client.android.yixiaotong.v3.ui.appcontrol.hairdryer.HairdryerDetailActivity.9
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, MachineByMacBean machineByMacBean, Object... objArr) {
                if (HairdryerDetailActivity.this.mIsEnable) {
                    if (machineByMacBean == null || !StringUtils.isNotEmpty(machineByMacBean.deviceVer) || !StringUtils.isNotEmpty(machineByMacBean.machineId)) {
                        if (!z || !StringUtils.isNotEmpty(HairdryerDetailActivity.this.mQrcode) || HairdryerDetailActivity.this.mQrcode.length() < 52 || !HairdryerDetailActivity.this.mQrcode.startsWith("55")) {
                            HairdryerDetailActivity.this.showDialogNeedExit("设备未授权，请联系管理员" + HairdryerDetailActivity.this.mBluetoothDevice.address + "\n(" + LocalDataUtil.getTraceID(HairdryerDetailActivity.this.getContext()) + ")");
                            return;
                        } else {
                            HairdryerDetailActivity hairdryerDetailActivity = HairdryerDetailActivity.this;
                            hairdryerDetailActivity.updateMac(hairdryerDetailActivity.mQrcode.substring(2, 10), HairdryerDetailActivity.this.mBluetoothDevice.address);
                            return;
                        }
                    }
                    HairdryerDetailActivity.this.mDeviceVer = machineByMacBean.deviceVer;
                    HairdryerDetailActivity.this.mMachineId = machineByMacBean.machineId;
                    HairdryerDetailActivity.this.mCnFlag = machineByMacBean.cnflag;
                    HairdryerDetailActivity.this.mType = machineByMacBean.mtype;
                    BeforeOpenControlUtil.getInstance().getUseInfoByMachineId(HairdryerDetailActivity.this.mMachineId, 8);
                    HairdryerDetailActivity.this.startOpen();
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (HairdryerDetailActivity.this.mIsEnable) {
                    if (clientException.isNeedExitApp(clientException.getCode()) || clientException.getCode() == -45) {
                        HairdryerDetailActivity.this.onError(clientException);
                        return;
                    }
                    if (!z || !StringUtils.isNotEmpty(HairdryerDetailActivity.this.mQrcode) || HairdryerDetailActivity.this.mQrcode.length() < 52 || !HairdryerDetailActivity.this.mQrcode.startsWith("55")) {
                        if (LocalDataUtil.getIsFirstOffline(HairdryerDetailActivity.this.getActivity())) {
                            HairdryerDetailActivity.this.onError(clientException);
                            return;
                        } else {
                            HairdryerDetailActivity.this.startOpenOffline(clientException);
                            return;
                        }
                    }
                    HairdryerDetailActivity hairdryerDetailActivity = HairdryerDetailActivity.this;
                    hairdryerDetailActivity.updateMac(hairdryerDetailActivity.mQrcode.substring(2, 10), HairdryerDetailActivity.this.mBluetoothDevice.address);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateMac(String str, String str2) {
        V3BusinessControllers.getInstance().getUpdateMachineMac(getLoginAccount(), str, str2, 8, new Listener<MachineByMacBean>() { // from class: client.android.yixiaotong.v3.ui.appcontrol.hairdryer.HairdryerDetailActivity.10
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, MachineByMacBean machineByMacBean, Object... objArr) {
                if (HairdryerDetailActivity.this.mIsEnable) {
                    HairdryerDetailActivity.this.getDeviceInfo(false);
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (HairdryerDetailActivity.this.mIsEnable) {
                    HairdryerDetailActivity.this.onError(clientException);
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
            SystemErrorTip.getInstance().showTipDialog(getActivity(), new SystemErrorTip.SystemErrorDialogListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.hairdryer.HairdryerDetailActivity.11
                @Override // client.android.yixiaotong.ui.dialog.SystemErrorTip.SystemErrorDialogListener
                public void onConfirm() {
                    HairdryerDetailActivity.this.finish();
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
        SystemErrorTip.getInstance().showTipDialog(getActivity(), "", str, "", false, new SystemErrorTip.SystemErrorDialogListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.hairdryer.HairdryerDetailActivity.12
            @Override // client.android.yixiaotong.ui.dialog.SystemErrorTip.SystemErrorDialogListener
            public void onConfirm() {
                HairdryerDetailActivity.this.finish();
            }
        });
    }

    class TimeCount extends CountDownTimer {
        public TimeCount(long j, long j2) {
            super(j, j2);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            if (HairdryerDetailActivity.this.mIsEnable) {
                HairdryerDetailActivity.this.finish();
            }
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            if (HairdryerDetailActivity.this.mIsEnable) {
                HairdryerDetailActivity.this.mTvTime.setTextColor(HairdryerDetailActivity.this.getResources().getColor(R.color.ffa1a6b3));
                HairdryerDetailActivity.this.mTvTime.setClickable(false);
                HairdryerDetailActivity.this.mTvTime.setText(Html.fromHtml("该页面将在" + (j / 1000) + "后自动关闭"));
                HairdryerDetailActivity.this.mTvTime.setTextSize(13.0f);
                HairdryerDetailActivity.this.mTvTime.setPadding(5, 5, 5, 5);
            }
        }
    }

    private void getAdv() {
        this.mNativeUtil = new NativeUtil();
        this.mAdvListener = new AdvControlUtil.AdvListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.hairdryer.HairdryerDetailActivity.14
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
                    HairdryerDetailActivity.this.mNativeUtil.initNative(HairdryerDetailActivity.this.getActivity(), HairdryerDetailActivity.this.mAdvListener, 1);
                    HairdryerDetailActivity.this.mNativeUtil.onNative(HairdryerDetailActivity.this.rlContainer);
                }
                if (i3 == 1) {
                    MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.v3.ui.appcontrol.hairdryer.HairdryerDetailActivity.14.1
                        @Override // java.lang.Runnable
                        public void run() {
                            HairdryerDetailActivity.this.mGvAdv.setVisibility(0);
                            HairdryerDetailActivity.this.mAdvAdapter = new AdvAdapter();
                            HairdryerDetailActivity.this.mGvAdv.setAdapter((ListAdapter) HairdryerDetailActivity.this.mAdvAdapter);
                            HairdryerDetailActivity.this.mGvAdv.setOnItemClickListener(HairdryerDetailActivity.this);
                            HairdryerDetailActivity.this.mBannerJumpInfo = AdvControlUtil.getInstance().getBannerJumpInfos();
                            HairdryerDetailActivity.this.mAdvAdapter.notifyDataSetChanged();
                        }
                    });
                }
            }
        };
        AdvControlUtil.getInstance().init(getActivity(), this.mAdvListener, 8, true, "");
        AdvControlUtil.getInstance().initAdvInfo();
        AdvControlUtil.getInstance().onResume();
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
            return HairdryerDetailActivity.this.mBannerJumpInfo.size();
        }

        @Override // android.widget.Adapter
        public BannerJumpInfoBean getItem(int i) {
            return (BannerJumpInfoBean) HairdryerDetailActivity.this.mBannerJumpInfo.get(i);
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder viewHolder;
            if (view == null) {
                view = LayoutInflater.from(HairdryerDetailActivity.this.getContext()).inflate(R.layout.adv_item, (ViewGroup) null);
                viewHolder = new ViewHolder(view);
                view.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) view.getTag();
            }
            Glide.with(HairdryerDetailActivity.this.getActivity()).load(((BannerJumpInfoBean) HairdryerDetailActivity.this.mBannerJumpInfo.get(i)).info.pictureUrl).into(viewHolder.img);
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
