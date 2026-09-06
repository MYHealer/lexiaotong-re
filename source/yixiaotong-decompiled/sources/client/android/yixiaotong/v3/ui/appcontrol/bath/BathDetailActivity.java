package client.android.yixiaotong.v3.ui.appcontrol.bath;

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
import client.android.yixiaotong.ui.widget.SetFontColorUtil;
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
import client.android.yixiaotong.v3.bean.login.TypeInfoBean;
import client.android.yixiaotong.v3.bean.login.UseToolsJsonBean;
import client.android.yixiaotong.v3.bluetoothutil.BluetoothControlUtil;
import client.android.yixiaotong.v3.http.V3BusinessControllers;
import client.android.yixiaotong.v3.ui.adv.AdvControlUtil;
import client.android.yixiaotong.v3.ui.adv.Common;
import client.android.yixiaotong.v3.ui.adv.NativeUtil;
import client.android.yixiaotong.v3.ui.appcontrol.control.BeforeOpenControlUtil;
import client.android.yixiaotong.v3.ui.appcontrol.drinkwater.BluetoothOpenControlUtil;
import client.android.yixiaotong.v3.ui.appcontrol.drinkwater.CloseSuccessActivity;
import client.android.yixiaotong.v3.ui.appcontrol.drinkwater.DSKCloseControlUtil;
import client.android.yixiaotong.v3.ui.appcontrol.drinkwater.DSKOpenControlUtil;
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
import com.lxt.bluetoothsdk.BluetoothSDK;
import com.lxt.bluetoothsdk.model.BluetoothDevice;
import com.stub.StubApp;
import com.unionpay.tsmservice.mi.data.Constant;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class BathDetailActivity extends BaseActivity implements AdapterView.OnItemClickListener {
    public static final String TAG = "BathDetailActivity";
    private static final int TYPEID = 1;
    FrameLayout flContainer;
    private AdvAdapter mAdvAdapter;
    private AdvControlUtil.AdvListener mAdvListener;
    private BathBluetoothOpenControlUtil mBathBluetoothOpenControlUtil;
    private BluetoothDevice mBluetoothDevice;
    private BluetoothOpenControlUtil mBluetoothOpenControlUtil;
    Button mBtnClose;
    private ClientException mClientException;
    private int mCnFlag;
    private DSKCloseControlUtil mDskCloseControlUtil;
    private DSKOpenControlUtil mDskOpenControlUtil;
    WrapGridView mGvAdv;
    ImageView mIvCircle;
    private String mMac;
    private NBOr4GCloseControlUtil mNBOr4GCloseControlUtil;
    private NBOr4GOpenControlUtil mNBOr4GOpenControlUtil;
    private NativeUtil mNativeUtil;
    private String mQrcode;
    RelativeLayout mRelClose;
    RelativeLayout mRelConnect;
    private String mStudentHex;
    private TimeCount mTimeCount;
    TitleBar mTitleBar;
    TextView mTvAdvName;
    TextView mTvConnectTip;
    TextView mTvMac;
    TextView mTvTime;
    TextView mTvTip;
    private int mType;
    private TypeInfoBaseInfoBean mTypeInfoBaseInfoBean;
    private TypeInfoBean mTypeInfoBean;
    private UseToolsJsonBean mUseToolsJsonBean;
    RelativeLayout rlContainer;
    private boolean mIsEnable = true;
    private FlowState mFlowState = FlowState.none;
    private String mDeviceVer = "";
    private String mMachineId = "";
    private boolean mIsBluetoothDevice = true;
    private int mPreferredCommunicationType = 0;
    private boolean mIsOpenFail = false;
    private boolean mIsSaveAddress = false;
    private boolean mIsOffineOpen = false;
    private boolean mIsCloseConnected = false;
    private PermissionUtil.PermissionGrant permissionGrant = new PermissionUtil.PermissionGrant() { // from class: client.android.yixiaotong.v3.ui.appcontrol.bath.BathDetailActivity.17
        @Override // client.android.yixiaotong.util.permission.PermissionUtil.PermissionGrant
        public void onPermissionGranted(int i) {
        }
    };
    private List<BannerJumpInfoBean> mBannerJumpInfo = new ArrayList();

    private enum FlowState {
        none,
        opening,
        opened,
        closeing
    }

    static {
        StubApp.interface11(9086);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public native void onRequestPermissionsResult(int i, String[] strArr, int[] iArr);

    public static void launch(Activity activity, String str, boolean z) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) BathDetailActivity.class).putExtra(Constant.KEY_MAC, str).putExtra("issave", z));
        }
    }

    public static void launch(Activity activity, String str, boolean z, String str2, String str3, int i, int i2) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) BathDetailActivity.class).putExtra(Constant.KEY_MAC, str).putExtra("issave", z).putExtra("devicever", str2).putExtra("machineid", str3).putExtra("cnflag", i).putExtra("mtype", i2));
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
        this.mTvTip = (TextView) findViewById(R.id.tv_tip);
        this.flContainer = (FrameLayout) findViewById(R.id.flContainer);
        this.mGvAdv = (WrapGridView) findViewById(R.id.gv_adv);
        this.rlContainer = (RelativeLayout) findViewById(R.id.rlContainer);
        this.mTvAdvName = (TextView) findViewById(R.id.tv_advname);
    }

    private void initTitleBar() {
        if (this.mTypeInfoBaseInfoBean != null) {
            this.mTitleBar.setTitleView(LanguageUtils.getAppName(getActivity(), this.mTypeInfoBaseInfoBean.typeId, this.mTypeInfoBaseInfoBean.appName));
        } else {
            this.mTitleBar.setTitleView(getString(R.string.bath));
        }
        this.mTitleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
    }

    private void initViewRoate() {
        Animation animationLoadAnimation = AnimationUtils.loadAnimation(getActivity(), R.anim.rotating);
        animationLoadAnimation.setInterpolator(new LinearInterpolator());
        if (animationLoadAnimation != null) {
            this.mIvCircle.startAnimation(animationLoadAnimation);
        }
    }

    private void initView() {
        this.mTvMac.setText("设备mac:" + this.mBluetoothDevice.address);
        LogUtil.d(TAG, this.mIsBluetoothDevice + "  " + this.mQrcode);
        if (this.mIsBluetoothDevice && StringUtils.isNotEmpty(this.mQrcode) && this.mType != 1) {
            this.mBtnClose.setVisibility(4);
            this.mTvConnectTip.setVisibility(4);
            this.mTvMac.setVisibility(4);
            this.mTvTime.setVisibility(0);
        } else {
            this.mBtnClose.setVisibility(0);
            this.mTvConnectTip.setVisibility(0);
            this.mTvMac.setVisibility(0);
            this.mTvTime.setVisibility(4);
        }
        TextView textView = this.mTvTip;
        textView.setText(SetFontColorUtil.getFontForContents(textView.getText().toString(), "#ff6f32fd", "机械按钮", "触摸按钮", "极速开阀"));
    }

    private void start() {
        this.mIsOffineOpen = false;
        UseToolsJsonBean useToolsJsonBean = this.mUseToolsJsonBean;
        if (useToolsJsonBean != null && useToolsJsonBean.preferredCommunicationType != null) {
            this.mPreferredCommunicationType = this.mUseToolsJsonBean.preferredCommunicationType.intValue();
        }
        this.mStudentHex = UserInfoUtil.getInstance().getLoginAccountV3().studentHex;
        if (this.mMac.length() >= 52) {
            String str = this.mMac;
            this.mQrcode = str;
            if (QrcodeUtil.isNBor4GDevice(str, 1)) {
                this.mMac = QrcodeUtil.getMac(this.mMac.substring(0, 12));
                this.mMachineId = this.mQrcode.substring(34, 50);
            } else {
                this.mMac = QrcodeUtil.getMac(this.mMac.substring(40, 52));
            }
        }
        LogUtil.e(TAG, "mac:" + this.mMac + "  " + this.mMachineId);
        if (StringUtils.isNotEmpty(this.mMac) && this.mMac.length() == 17 && QrcodeUtil.isMacIllegal(this.mMac)) {
            initData(this.mMac);
        } else {
            this.mIsBluetoothDevice = false;
            getInfoByQRCode(this.mMac);
        }
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
        if (this.mCnFlag == 1) {
            this.mIsBluetoothDevice = true;
        } else {
            this.mIsBluetoothDevice = false;
        }
        this.mIsOffineOpen = false;
        this.mFlowState = FlowState.opening;
        initView();
        BeforeOpenControlUtil.getInstance().getUseInfoByMachineId(this.mMachineId, 1);
        BluetoothControlUtil.getInstance().setDeviceType(this.mDeviceVer);
        MainThreadExecutor.getInstance().executeDelayed(new Runnable() { // from class: client.android.yixiaotong.v3.ui.appcontrol.bath.BathDetailActivity.1
            @Override // java.lang.Runnable
            public void run() {
                if (BathDetailActivity.this.mType == 1) {
                    BathDetailActivity.this.mDskOpenControlUtil.setDeviceInfo(BathDetailActivity.this.mPreferredCommunicationType, BathDetailActivity.this.mType, BathDetailActivity.this.mCnFlag, BathDetailActivity.this.mDeviceVer, BathDetailActivity.this.mMachineId);
                    BathDetailActivity.this.mDskOpenControlUtil.openStart();
                    BathDetailActivity.this.mDskCloseControlUtil.setDeviceInfo(BathDetailActivity.this.mCnFlag, BathDetailActivity.this.mDeviceVer, BathDetailActivity.this.mMachineId);
                } else {
                    if (BathDetailActivity.this.mIsBluetoothDevice) {
                        if (StringUtils.isNotEmpty(BathDetailActivity.this.mQrcode)) {
                            BathDetailActivity.this.mBluetoothOpenControlUtil.setDeviceInfo(BathDetailActivity.this.mDeviceVer, BathDetailActivity.this.mMachineId);
                            BathDetailActivity.this.mBluetoothOpenControlUtil.openStart();
                            return;
                        } else {
                            BathDetailActivity.this.mBathBluetoothOpenControlUtil.setDeviceInfo(BathDetailActivity.this.mDeviceVer, BathDetailActivity.this.mMachineId);
                            BathDetailActivity.this.mBathBluetoothOpenControlUtil.openStart();
                            return;
                        }
                    }
                    BathDetailActivity.this.mNBOr4GOpenControlUtil.setDeviceInfo(BathDetailActivity.this.mPreferredCommunicationType, BathDetailActivity.this.mType, BathDetailActivity.this.mCnFlag, BathDetailActivity.this.mDeviceVer, BathDetailActivity.this.mMachineId);
                    BathDetailActivity.this.mNBOr4GOpenControlUtil.openStart();
                    BathDetailActivity.this.mNBOr4GCloseControlUtil.setDeviceInfo(BathDetailActivity.this.mCnFlag, BathDetailActivity.this.mDeviceVer, BathDetailActivity.this.mMachineId);
                }
            }
        }, 50L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openEnd() {
        LogUtil.e(TAG, "openEnd");
        this.mFlowState = FlowState.opened;
        this.mIvCircle.clearAnimation();
        this.mRelConnect.setVisibility(8);
        this.mRelClose.setVisibility(0);
        if (this.mIsBluetoothDevice || this.mType == 1) {
            LocalDataUtil.saveOpenSuccessInfo(getActivity(), this.mStudentHex, "");
        } else if (this.mBluetoothDevice != null) {
            LocalDataUtil.saveOpenSuccessInfo(getActivity(), this.mStudentHex, this.mType + "," + this.mBluetoothDevice.address + "," + this.mCnFlag + "," + this.mDeviceVer + "," + this.mMachineId);
        }
        if (this.mIsBluetoothDevice && StringUtils.isNotEmpty(this.mQrcode) && this.mType != 1) {
            TimeCount timeCount = new TimeCount(ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT, 1000L);
            this.mTimeCount = timeCount;
            timeCount.start();
        }
        requestInteraction();
    }

    public void onClose(View view) {
        onClose();
    }

    private void onClose() {
        BaseMaterialDialog.showMaterialDialog(getActivity(), "正在关阀中.", false);
        this.mFlowState = FlowState.closeing;
        NBOr4GOpenControlUtil nBOr4GOpenControlUtil = this.mNBOr4GOpenControlUtil;
        if (nBOr4GOpenControlUtil != null) {
            nBOr4GOpenControlUtil.onPause();
        }
        disconnect();
        LogUtil.e(TAG, "开始关阀  " + this.mType + "  " + this.mIsBluetoothDevice + "  " + this.mIsOffineOpen);
        if (this.mType == 1) {
            this.mDskCloseControlUtil.closeStart();
        } else if (this.mIsBluetoothDevice && !this.mIsOffineOpen) {
            this.mBathBluetoothOpenControlUtil.setListener(new CloseControlListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.bath.BathDetailActivity.2
                @Override // client.android.yixiaotong.v3.ui.appcontrol.listener.CloseControlListener
                public void onCloseEnd() {
                    ToastUtils.show(BathDetailActivity.this.getContext(), "关阀成功!");
                    CloseSuccessActivity.launch(BathDetailActivity.this.getActivity(), 1);
                    BathDetailActivity.this.finish();
                }
            });
            this.mBathBluetoothOpenControlUtil.closeStart();
        } else {
            this.mNBOr4GCloseControlUtil.closeStart();
        }
        MainThreadExecutor.getInstance().executeDelayed(new Runnable() { // from class: client.android.yixiaotong.v3.ui.appcontrol.bath.BathDetailActivity.3
            @Override // java.lang.Runnable
            public void run() {
                if (BathDetailActivity.this.mIsEnable && BathDetailActivity.this.mFlowState == FlowState.closeing && !BathDetailActivity.this.mIsCloseConnected) {
                    ToastUtils.show(BathDetailActivity.this.getActivity(), "关阀失败.");
                    BaseMaterialDialog.dissmisMaterialDialog();
                    LogUtil.e(BathDetailActivity.TAG, "关阀失败");
                }
            }
        }, 7000L);
    }

    private void initControl() {
        BathBluetoothOpenControlUtil bathBluetoothOpenControlUtil = new BathBluetoothOpenControlUtil();
        this.mBathBluetoothOpenControlUtil = bathBluetoothOpenControlUtil;
        bathBluetoothOpenControlUtil.init(getActivity(), getLoginAccount(), this.mBluetoothDevice, this.mTypeInfoBaseInfoBean, 1, this.mTitleBar.getTitleViewContent(), "mQrcode");
        this.mBathBluetoothOpenControlUtil.setListener(new OpenControlListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.bath.BathDetailActivity.4
            @Override // client.android.yixiaotong.v3.ui.appcontrol.listener.OpenControlListener
            public void onOpenEnd() {
                BathDetailActivity.this.openEnd();
            }

            @Override // client.android.yixiaotong.v3.ui.appcontrol.listener.OpenControlListener
            public void onOpenFail() {
                BathDetailActivity.this.mIsOpenFail = true;
            }
        });
        NBOr4GOpenControlUtil nBOr4GOpenControlUtil = new NBOr4GOpenControlUtil();
        this.mNBOr4GOpenControlUtil = nBOr4GOpenControlUtil;
        nBOr4GOpenControlUtil.init(getActivity(), getLoginAccount(), this.mBluetoothDevice, this.mTypeInfoBaseInfoBean, 1, this.mStudentHex, this.mTitleBar.getTitleViewContent());
        this.mNBOr4GOpenControlUtil.setListener(new OpenControlListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.bath.BathDetailActivity.5
            @Override // client.android.yixiaotong.v3.ui.appcontrol.listener.OpenControlListener
            public void onOpenEnd() {
                BathDetailActivity.this.openEnd();
            }

            @Override // client.android.yixiaotong.v3.ui.appcontrol.listener.OpenControlListener
            public void onOpenFail() {
                BathDetailActivity.this.mIsOpenFail = true;
            }
        });
        this.mNBOr4GOpenControlUtil.setErrorListener(new ErrorControlListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.bath.BathDetailActivity.6
            @Override // client.android.yixiaotong.v3.ui.appcontrol.listener.ErrorControlListener
            public void onFail(ClientException clientException) {
                if (clientException != null) {
                    BathDetailActivity.this.mIsOffineOpen = true;
                    BathDetailActivity.this.mClientException = clientException;
                }
            }
        });
        NBOr4GCloseControlUtil nBOr4GCloseControlUtil = new NBOr4GCloseControlUtil();
        this.mNBOr4GCloseControlUtil = nBOr4GCloseControlUtil;
        nBOr4GCloseControlUtil.init(getActivity(), getLoginAccount(), this.mBluetoothDevice, this.mTypeInfoBaseInfoBean, 1, this.mStudentHex, this.mTitleBar.getTitleViewContent());
        this.mNBOr4GCloseControlUtil.setListener(new CloseControlListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.bath.BathDetailActivity.7
            @Override // client.android.yixiaotong.v3.ui.appcontrol.listener.CloseControlListener
            public void onCloseEnd() {
                LocalDataUtil.saveOpenSuccessInfo(BathDetailActivity.this.getActivity(), BathDetailActivity.this.mStudentHex, "");
                ToastUtils.show(BathDetailActivity.this.getContext(), "关阀成功");
                CloseSuccessActivity.launch(BathDetailActivity.this.getActivity(), 1);
                BathDetailActivity.this.finish();
            }
        });
        BluetoothOpenControlUtil bluetoothOpenControlUtil = new BluetoothOpenControlUtil();
        this.mBluetoothOpenControlUtil = bluetoothOpenControlUtil;
        bluetoothOpenControlUtil.init(getActivity(), getLoginAccount(), this.mBluetoothDevice, this.mTypeInfoBaseInfoBean, 1, this.mTitleBar.getTitleViewContent(), this.mQrcode);
        this.mBluetoothOpenControlUtil.setListener(new OpenControlListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.bath.BathDetailActivity.8
            @Override // client.android.yixiaotong.v3.ui.appcontrol.listener.OpenControlListener
            public void onOpenEnd() {
                BathDetailActivity.this.openEnd();
            }

            @Override // client.android.yixiaotong.v3.ui.appcontrol.listener.OpenControlListener
            public void onOpenFail() {
                BathDetailActivity.this.mIsOpenFail = true;
            }
        });
        DSKOpenControlUtil dSKOpenControlUtil = new DSKOpenControlUtil();
        this.mDskOpenControlUtil = dSKOpenControlUtil;
        dSKOpenControlUtil.init(getActivity(), getLoginAccount(), this.mBluetoothDevice, this.mTypeInfoBaseInfoBean, 1, this.mStudentHex, this.mTitleBar.getTitleViewContent());
        this.mDskOpenControlUtil.setListener(new OpenControlListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.bath.BathDetailActivity.9
            @Override // client.android.yixiaotong.v3.ui.appcontrol.listener.OpenControlListener
            public void onOpenEnd() {
                BathDetailActivity.this.openEnd();
            }

            @Override // client.android.yixiaotong.v3.ui.appcontrol.listener.OpenControlListener
            public void onOpenFail() {
                BathDetailActivity.this.mIsOpenFail = true;
            }
        });
        DSKCloseControlUtil dSKCloseControlUtil = new DSKCloseControlUtil();
        this.mDskCloseControlUtil = dSKCloseControlUtil;
        dSKCloseControlUtil.init(getActivity(), getLoginAccount(), this.mBluetoothDevice, this.mTypeInfoBaseInfoBean, 1, this.mStudentHex, this.mTitleBar.getTitleViewContent());
        this.mDskCloseControlUtil.setListener(new CloseControlListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.bath.BathDetailActivity.10
            @Override // client.android.yixiaotong.v3.ui.appcontrol.listener.CloseControlListener
            public void onCloseEnd() {
                ToastUtils.show(BathDetailActivity.this.getContext(), "关阀成功");
                CloseSuccessActivity.launch(BathDetailActivity.this.getActivity(), 1);
                BathDetailActivity.this.finish();
            }
        });
    }

    public void initBluetooth() {
        BluetoothSDK.getInstance().init(getContext());
        BluetoothControlUtil.getInstance().init(getActivity());
        BluetoothControlUtil.getInstance().setListener(new BluetoothControlUtil.Listener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.bath.BathDetailActivity.11
            @Override // client.android.yixiaotong.v3.bluetoothutil.BluetoothControlUtil.Listener
            public void onConnected() {
                super.onConnected();
                LogUtil.d(BathDetailActivity.TAG, "onConnected:" + BathDetailActivity.this.mIsOffineOpen);
                if (BathDetailActivity.this.mIsOffineOpen) {
                    if (BathDetailActivity.this.mFlowState == FlowState.opening) {
                        BathDetailActivity.this.mNBOr4GOpenControlUtil.connected();
                        return;
                    } else {
                        if (BathDetailActivity.this.mFlowState == FlowState.closeing) {
                            BathDetailActivity.this.mNBOr4GCloseControlUtil.connected();
                            return;
                        }
                        return;
                    }
                }
                if (BathDetailActivity.this.mType == 1) {
                    if (BathDetailActivity.this.mFlowState == FlowState.opening) {
                        BathDetailActivity.this.mDskOpenControlUtil.connected();
                        return;
                    } else {
                        if (BathDetailActivity.this.mFlowState == FlowState.closeing) {
                            BathDetailActivity.this.mDskCloseControlUtil.connected();
                            return;
                        }
                        return;
                    }
                }
                if (BathDetailActivity.this.mIsBluetoothDevice) {
                    if (StringUtils.isNotEmpty(BathDetailActivity.this.mQrcode)) {
                        BathDetailActivity.this.mBluetoothOpenControlUtil.connected();
                        return;
                    } else {
                        BathDetailActivity.this.mBathBluetoothOpenControlUtil.connected();
                        return;
                    }
                }
                if (BathDetailActivity.this.mFlowState == FlowState.opening || BathDetailActivity.this.mFlowState == FlowState.opened) {
                    BathDetailActivity.this.mNBOr4GOpenControlUtil.connected();
                } else if (BathDetailActivity.this.mFlowState == FlowState.closeing) {
                    BathDetailActivity.this.mIsCloseConnected = true;
                    BathDetailActivity.this.mNBOr4GCloseControlUtil.connected();
                }
            }

            @Override // client.android.yixiaotong.v3.bluetoothutil.BluetoothControlUtil.Listener
            public void onFail(int i, String str) {
                super.onFail(i, str);
                LogUtil.d(BathDetailActivity.TAG, "onFail" + i + "  " + str + "  " + BathDetailActivity.this.mIsOffineOpen);
                if (BathDetailActivity.this.mIsOffineOpen) {
                    if (BathDetailActivity.this.mClientException != null) {
                        BathDetailActivity bathDetailActivity = BathDetailActivity.this;
                        bathDetailActivity.onError(bathDetailActivity.mClientException);
                        return;
                    } else {
                        BathDetailActivity.this.disconnect();
                        BathDetailActivity.this.getDeviceInfo(true);
                        return;
                    }
                }
                if (str.equalsIgnoreCase("Discover") || str.equalsIgnoreCase("Connect")) {
                    str = "尝试重启手机或设备蓝牙再试";
                }
                if (BathDetailActivity.this.mType == 1) {
                    if (BathDetailActivity.this.mFlowState == FlowState.opening) {
                        if (BathDetailActivity.this.mIsBluetoothDevice) {
                            if (BathDetailActivity.this.mIsOpenFail) {
                                return;
                            }
                            BathDetailActivity.this.onError(i, str);
                            return;
                        }
                        BathDetailActivity.this.mDskOpenControlUtil.onBluetoothError(i, str);
                        return;
                    }
                    if (BathDetailActivity.this.mFlowState == FlowState.closeing) {
                        BathDetailActivity.this.onError(i, str);
                        return;
                    }
                    return;
                }
                if (BathDetailActivity.this.mFlowState == FlowState.opening) {
                    if (BathDetailActivity.this.mIsBluetoothDevice) {
                        if (BathDetailActivity.this.mIsOpenFail) {
                            return;
                        }
                        BathDetailActivity.this.onError(i, str);
                        return;
                    }
                    BathDetailActivity.this.mNBOr4GOpenControlUtil.onBluetoothError(i, str);
                    return;
                }
                if (BathDetailActivity.this.mFlowState == FlowState.closeing) {
                    BathDetailActivity.this.onError(i, str);
                }
            }

            @Override // client.android.yixiaotong.v3.bluetoothutil.BluetoothControlUtil.Listener
            public void onReceivedData(String str) {
                super.onReceivedData(str);
                LogUtil.d(BathDetailActivity.TAG, "onReceivedData:" + str);
                LogUtil.d(BathDetailActivity.TAG, "onReceivedData:" + BathDetailActivity.this.mIsOffineOpen + "  " + BathDetailActivity.this.mFlowState);
                if (BathDetailActivity.this.mIsOffineOpen) {
                    if (BathDetailActivity.this.mFlowState == FlowState.opening) {
                        BathDetailActivity.this.mNBOr4GOpenControlUtil.onReceivedData(str);
                        return;
                    } else {
                        if (BathDetailActivity.this.mFlowState == FlowState.closeing) {
                            BathDetailActivity.this.mNBOr4GCloseControlUtil.onReceivedData(str);
                            return;
                        }
                        return;
                    }
                }
                if (BathDetailActivity.this.mType == 1) {
                    if (BathDetailActivity.this.mFlowState == FlowState.opening || BathDetailActivity.this.mFlowState == FlowState.opened) {
                        BathDetailActivity.this.mDskOpenControlUtil.onReceivedData(str);
                        return;
                    } else {
                        if (BathDetailActivity.this.mFlowState == FlowState.closeing) {
                            BathDetailActivity.this.mDskCloseControlUtil.onReceivedData(str);
                            return;
                        }
                        return;
                    }
                }
                if (BathDetailActivity.this.mIsBluetoothDevice) {
                    if (StringUtils.isNotEmpty(BathDetailActivity.this.mQrcode)) {
                        return;
                    }
                    BathDetailActivity.this.mBathBluetoothOpenControlUtil.receivedData(str);
                } else if (BathDetailActivity.this.mFlowState == FlowState.opening || BathDetailActivity.this.mFlowState == FlowState.opened) {
                    BathDetailActivity.this.mNBOr4GOpenControlUtil.onReceivedData(str);
                } else if (BathDetailActivity.this.mFlowState == FlowState.closeing) {
                    BathDetailActivity.this.mNBOr4GCloseControlUtil.onReceivedData(str);
                }
            }
        });
    }

    private void connectDecice() {
        BluetoothControlUtil.getInstance().connectBluetooth(this.mBluetoothDevice);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void disconnect() {
        BluetoothControlUtil.getInstance().disconnect();
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.mIsEnable = true;
        BeforeOpenControlUtil.getInstance().onResume();
        BluetoothControlUtil.getInstance().onResume();
        BathBluetoothOpenControlUtil bathBluetoothOpenControlUtil = this.mBathBluetoothOpenControlUtil;
        if (bathBluetoothOpenControlUtil != null) {
            bathBluetoothOpenControlUtil.onResume();
        }
        NBOr4GOpenControlUtil nBOr4GOpenControlUtil = this.mNBOr4GOpenControlUtil;
        if (nBOr4GOpenControlUtil != null) {
            nBOr4GOpenControlUtil.onResume();
        }
        NBOr4GCloseControlUtil nBOr4GCloseControlUtil = this.mNBOr4GCloseControlUtil;
        if (nBOr4GCloseControlUtil != null) {
            nBOr4GCloseControlUtil.onResume();
        }
        BluetoothOpenControlUtil bluetoothOpenControlUtil = this.mBluetoothOpenControlUtil;
        if (bluetoothOpenControlUtil != null) {
            bluetoothOpenControlUtil.onResume();
        }
        DSKOpenControlUtil dSKOpenControlUtil = this.mDskOpenControlUtil;
        if (dSKOpenControlUtil != null) {
            dSKOpenControlUtil.onResume();
        }
        DSKCloseControlUtil dSKCloseControlUtil = this.mDskCloseControlUtil;
        if (dSKCloseControlUtil != null) {
            dSKCloseControlUtil.onResume();
        }
        AdvControlUtil.getInstance().onResume();
        NativeUtil nativeUtil = this.mNativeUtil;
        if (nativeUtil != null) {
            nativeUtil.onResume();
        }
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
        BathBluetoothOpenControlUtil bathBluetoothOpenControlUtil = this.mBathBluetoothOpenControlUtil;
        if (bathBluetoothOpenControlUtil != null) {
            bathBluetoothOpenControlUtil.onPause();
        }
        NBOr4GOpenControlUtil nBOr4GOpenControlUtil = this.mNBOr4GOpenControlUtil;
        if (nBOr4GOpenControlUtil != null) {
            nBOr4GOpenControlUtil.onPause();
        }
        NBOr4GCloseControlUtil nBOr4GCloseControlUtil = this.mNBOr4GCloseControlUtil;
        if (nBOr4GCloseControlUtil != null) {
            nBOr4GCloseControlUtil.onPause();
        }
        BluetoothOpenControlUtil bluetoothOpenControlUtil = this.mBluetoothOpenControlUtil;
        if (bluetoothOpenControlUtil != null) {
            bluetoothOpenControlUtil.onPause();
        }
        DSKOpenControlUtil dSKOpenControlUtil = this.mDskOpenControlUtil;
        if (dSKOpenControlUtil != null) {
            dSKOpenControlUtil.onPause();
        }
        DSKCloseControlUtil dSKCloseControlUtil = this.mDskCloseControlUtil;
        if (dSKCloseControlUtil != null) {
            dSKCloseControlUtil.onPause();
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
    public void initData(String str) {
        this.mBluetoothDevice = new BluetoothDevice(str, str, 0);
        if (!this.mIsSaveAddress) {
            LocalDataUtil.saveBathMacInfo(getContext(), this.mBluetoothDevice.address);
        }
        initViewRoate();
        initBluetooth();
        initControl();
        getAdv();
        if (StringUtils.isNotEmpty(this.mMachineId) && StringUtils.isNotEmpty(this.mDeviceVer)) {
            startOpen();
        } else if (Error50XUtil.isInterrupt(getActivity()) || (LocalDataUtil.getIsFirstOffline(getActivity()) && LocalDataUtil.getIsEnableOffline(getActivity()))) {
            startOpenOffline(null);
        } else {
            getDeviceInfo(true);
        }
    }

    private void getInfoByQRCode(String str) {
        V3BusinessControllers.getInstance().getInfoByQRCode(getLoginAccount(), str, false, new Listener<MachineByMacBean>() { // from class: client.android.yixiaotong.v3.ui.appcontrol.bath.BathDetailActivity.12
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                BaseMaterialDialog.setConnectMaterialDialog("正在获取数据中");
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, MachineByMacBean machineByMacBean, Object... objArr) {
                if (BathDetailActivity.this.mIsEnable) {
                    if (machineByMacBean == null || !StringUtils.isNotEmpty(machineByMacBean.deviceMac)) {
                        BathDetailActivity.this.showDialog(true, true, false, "设备未授权，请联系管理员");
                    } else {
                        BathDetailActivity.this.initData(machineByMacBean.deviceMac);
                    }
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (BathDetailActivity.this.mIsEnable) {
                    BathDetailActivity.this.onError(clientException);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getDeviceInfo(final boolean z) {
        V3BusinessControllers.getInstance().getMachineByMac(getLoginAccount(), this.mBluetoothDevice.address, 1, new Listener<MachineByMacBean>() { // from class: client.android.yixiaotong.v3.ui.appcontrol.bath.BathDetailActivity.13
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, MachineByMacBean machineByMacBean, Object... objArr) {
                if (BathDetailActivity.this.mIsEnable) {
                    if (machineByMacBean == null || !StringUtils.isNotEmpty(machineByMacBean.deviceVer) || !StringUtils.isNotEmpty(machineByMacBean.machineId)) {
                        if (!z || !StringUtils.isNotEmpty(BathDetailActivity.this.mQrcode) || BathDetailActivity.this.mQrcode.length() < 52 || !BathDetailActivity.this.mQrcode.startsWith("55")) {
                            BathDetailActivity.this.showDialog(true, true, false, "设备未授权，请联系管理员" + BathDetailActivity.this.mBluetoothDevice.address);
                            return;
                        } else {
                            BathDetailActivity bathDetailActivity = BathDetailActivity.this;
                            bathDetailActivity.updateMac(bathDetailActivity.mQrcode.substring(2, 10), BathDetailActivity.this.mBluetoothDevice.address);
                            return;
                        }
                    }
                    BathDetailActivity.this.mDeviceVer = machineByMacBean.deviceVer;
                    BathDetailActivity.this.mMachineId = machineByMacBean.machineId;
                    BathDetailActivity.this.mCnFlag = machineByMacBean.cnflag;
                    BathDetailActivity.this.mType = machineByMacBean.mtype;
                    if (StringUtils.isNotEmpty(machineByMacBean.roominfo)) {
                        LocalDataUtil.saveBathMacInfo(BathDetailActivity.this.getContext(), BathDetailActivity.this.mBluetoothDevice.address + "," + machineByMacBean.roominfo);
                    }
                    BathDetailActivity.this.startOpen();
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (BathDetailActivity.this.mIsEnable) {
                    if (clientException.isNeedExitApp(clientException.getCode()) || clientException.getCode() == -45) {
                        BathDetailActivity.this.onError(clientException);
                        return;
                    }
                    if (!z || !StringUtils.isNotEmpty(BathDetailActivity.this.mQrcode) || BathDetailActivity.this.mQrcode.length() < 52 || !BathDetailActivity.this.mQrcode.startsWith("55") || Error50XUtil.isInterrupt(BathDetailActivity.this.getActivity())) {
                        if (LocalDataUtil.getIsFirstOffline(BathDetailActivity.this.getActivity())) {
                            BathDetailActivity.this.onError(clientException);
                            return;
                        } else {
                            BathDetailActivity.this.startOpenOffline(clientException);
                            return;
                        }
                    }
                    BathDetailActivity bathDetailActivity = BathDetailActivity.this;
                    bathDetailActivity.updateMac(bathDetailActivity.mQrcode.substring(2, 10), BathDetailActivity.this.mBluetoothDevice.address);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateMac(String str, String str2) {
        V3BusinessControllers.getInstance().getUpdateMachineMac(getLoginAccount(), str, str2, 1, new Listener<MachineByMacBean>() { // from class: client.android.yixiaotong.v3.ui.appcontrol.bath.BathDetailActivity.14
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, MachineByMacBean machineByMacBean, Object... objArr) {
                if (BathDetailActivity.this.mIsEnable) {
                    BathDetailActivity.this.getDeviceInfo(false);
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (BathDetailActivity.this.mIsEnable) {
                    BathDetailActivity.this.onError(clientException);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onError(int i, String str) {
        BaseMaterialDialog.dissmisMaterialDialog();
        if (this.mFlowState == FlowState.closeing || this.mIsBluetoothDevice) {
            V3ErrorTipActivity.launchBluetoothFail(getActivity(), this.mTitleBar.getTitleViewContent(), str, i);
        } else {
            V3ErrorTipActivity.launchBluetoothFailForOpen(getActivity(), this.mTitleBar.getTitleViewContent(), str, i);
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onError(ClientException clientException) {
        BaseMaterialDialog.dissmisMaterialDialog();
        if (Error50XUtil.isInterrupt(getActivity()) && LocalDataUtil.getIsEnableOffline(getActivity())) {
            onError(0, "蓝牙连接失败，尝试重启手机蓝牙再试！");
        } else if (clientException.isNeedTip(clientException.getCode())) {
            showDialog(true, true, false, clientException.getDetail());
        } else {
            V3ErrorTipActivity.launch(getActivity(), this.mTitleBar.getTitleViewContent(), clientException.getDetail(), clientException.getCode(), 4, clientException.getSerial());
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialog(boolean z, boolean z2, boolean z3, String str) {
        if (z2) {
            str = str + "\n(" + LocalDataUtil.getTraceID(getContext()) + ")";
        }
        String str2 = str;
        if (z && !z3) {
            SystemErrorTip.getInstance().showTipDialog(getActivity(), "", str2, "", false, new SystemErrorTip.SystemErrorDialogListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.bath.BathDetailActivity.15
                @Override // client.android.yixiaotong.ui.dialog.SystemErrorTip.SystemErrorDialogListener
                public void onConfirm() {
                    BathDetailActivity.this.finish();
                }
            });
        } else if (z && z3) {
            SystemErrorTip.getInstance().showTipDialog(getActivity(), new SystemErrorTip.SystemErrorDialogListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.bath.BathDetailActivity.16
                @Override // client.android.yixiaotong.ui.dialog.SystemErrorTip.SystemErrorDialogListener
                public void onConfirm() {
                    BathDetailActivity.this.finish();
                }
            }, str2);
        } else {
            SystemErrorTip.getInstance().showTipDialog(getActivity(), str2);
        }
    }

    class TimeCount extends CountDownTimer {
        public TimeCount(long j, long j2) {
            super(j, j2);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            if (BathDetailActivity.this.mIsEnable) {
                BathDetailActivity.this.finish();
            }
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            if (BathDetailActivity.this.mIsEnable) {
                BathDetailActivity.this.mTvTime.setTextColor(BathDetailActivity.this.getResources().getColor(R.color.ffa1a6b3));
                BathDetailActivity.this.mTvTime.setClickable(false);
                BathDetailActivity.this.mTvTime.setText(Html.fromHtml("该页面将在" + (j / 1000) + "后自动关闭"));
                BathDetailActivity.this.mTvTime.setTextSize(13.0f);
                BathDetailActivity.this.mTvTime.setPadding(5, 5, 5, 5);
            }
        }
    }

    private void getAdv() {
        this.mNativeUtil = new NativeUtil();
        this.mAdvListener = new AdvControlUtil.AdvListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.bath.BathDetailActivity.18
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
                    BathDetailActivity.this.mNativeUtil.initNative(BathDetailActivity.this.getActivity(), BathDetailActivity.this.mAdvListener, 1);
                    BathDetailActivity.this.mNativeUtil.onNative(BathDetailActivity.this.rlContainer);
                }
                if (i3 == 1) {
                    MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.v3.ui.appcontrol.bath.BathDetailActivity.18.1
                        @Override // java.lang.Runnable
                        public void run() {
                            BathDetailActivity.this.mGvAdv.setVisibility(0);
                            BathDetailActivity.this.mAdvAdapter = new AdvAdapter();
                            BathDetailActivity.this.mGvAdv.setAdapter((ListAdapter) BathDetailActivity.this.mAdvAdapter);
                            BathDetailActivity.this.mGvAdv.setOnItemClickListener(BathDetailActivity.this);
                            BathDetailActivity.this.mBannerJumpInfo = AdvControlUtil.getInstance().getBannerJumpInfos();
                            BathDetailActivity.this.mAdvAdapter.notifyDataSetChanged();
                        }
                    });
                }
            }
        };
        AdvControlUtil.getInstance().init(getActivity(), this.mAdvListener, 1, true, "");
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
            return BathDetailActivity.this.mBannerJumpInfo.size();
        }

        @Override // android.widget.Adapter
        public BannerJumpInfoBean getItem(int i) {
            return (BannerJumpInfoBean) BathDetailActivity.this.mBannerJumpInfo.get(i);
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder viewHolder;
            if (view == null) {
                view = LayoutInflater.from(BathDetailActivity.this.getContext()).inflate(R.layout.adv_item, (ViewGroup) null);
                viewHolder = new ViewHolder(view);
                view.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) view.getTag();
            }
            Glide.with(BathDetailActivity.this.getActivity()).load(((BannerJumpInfoBean) BathDetailActivity.this.mBannerJumpInfo.get(i)).info.pictureUrl).into(viewHolder.img);
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
