package client.android.yixiaotong.v3.ui.appcontrol.drinkwater;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Html;
import android.util.Log;
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
import client.android.yixiaotong.v3.ui.appcontrol.listener.CloseControlListener;
import client.android.yixiaotong.v3.ui.appcontrol.listener.ErrorControlListener;
import client.android.yixiaotong.v3.ui.appcontrol.listener.OpenControlListener;
import client.android.yixiaotong.v3.ui.error.V3ErrorTipActivity;
import client.android.yixiaotong.v3.ui.scan.QrcodeUtil;
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
public class DrinkWaterDetailActivity extends BaseActivity implements AdapterView.OnItemClickListener {
    public static final String TAG = "DrinkWaterDetail";
    private static final int TYPEID = 6;
    private FrameLayout flContainer;
    private AdvAdapter mAdvAdapter;
    private AdvControlUtil.AdvListener mAdvListener;
    private BluetoothDevice mBluetoothDevice;
    private BluetoothOpenControlUtil mBluetoothOpenControlUtil;
    private Button mBtnClose;
    private ClientException mClientException;
    private int mCnFlag;
    private DSKCloseControlUtil mDskCloseControlUtil;
    private DSKOpenControlUtil mDskOpenControlUtil;
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
    private PermissionUtil.PermissionGrant permissionGrant = new PermissionUtil.PermissionGrant() { // from class: client.android.yixiaotong.v3.ui.appcontrol.drinkwater.DrinkWaterDetailActivity.14
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
        StubApp.interface11(9225);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public native void onRequestPermissionsResult(int i, String[] strArr, int[] iArr);

    public static void launch(Activity activity, String str) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) DrinkWaterDetailActivity.class).putExtra("qrcode", str));
        }
    }

    public static void launch(Activity activity, String str, String str2, String str3, int i, int i2, String str4) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) DrinkWaterDetailActivity.class).putExtra("qrcode", str).putExtra("devicever", str2).putExtra("machineid", str3).putExtra("cnflag", i).putExtra("mtype", i2).putExtra(Constant.KEY_MAC, str4));
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
        String mac = QrcodeUtil.getMac(this.mQrcode.substring(40, 52));
        this.mIsBluetoothDevice = true;
        if (QrcodeUtil.isNBor4GDevice(this.mQrcode, 6)) {
            this.mIsBluetoothDevice = false;
            mac = QrcodeUtil.getMac(this.mQrcode.substring(0, 12));
            if (Error50XUtil.isInterrupt(getActivity())) {
                this.mMachineId = this.mQrcode.substring(34, 50);
            }
        }
        if (StringUtils.isNotEmpty(mac) && mac.length() == 17 && QrcodeUtil.isMacIllegal(mac)) {
            this.mBluetoothDevice = new BluetoothDevice(mac, mac, 0);
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
        ToastUtils.show(getContext(), "不合法的蓝牙地址" + mac);
        finish();
    }

    private void initTitleBar() {
        if (this.mTypeInfoBaseInfoBean != null) {
            this.mTitleBar.setTitleView(LanguageUtils.getAppName(getActivity(), this.mTypeInfoBaseInfoBean.typeId, this.mTypeInfoBaseInfoBean.appName));
        } else {
            this.mTitleBar.setTitleView(getString(R.string.drink));
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
        bluetoothOpenControlUtil.init(getActivity(), getLoginAccount(), this.mBluetoothDevice, this.mTypeInfoBaseInfoBean, 6, this.mTitleBar.getTitleViewContent(), this.mQrcode);
        this.mBluetoothOpenControlUtil.setListener(new OpenControlListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.drinkwater.DrinkWaterDetailActivity.1
            @Override // client.android.yixiaotong.v3.ui.appcontrol.listener.OpenControlListener
            public void onOpenEnd() {
                DrinkWaterDetailActivity.this.openEnd();
            }

            @Override // client.android.yixiaotong.v3.ui.appcontrol.listener.OpenControlListener
            public void onOpenFail() {
                DrinkWaterDetailActivity.this.mIsOpenFail = true;
            }
        });
        NBOr4GOpenControlUtil nBOr4GOpenControlUtil = new NBOr4GOpenControlUtil();
        this.mNBOr4GOpenControlUtil = nBOr4GOpenControlUtil;
        nBOr4GOpenControlUtil.init(getActivity(), getLoginAccount(), this.mBluetoothDevice, this.mTypeInfoBaseInfoBean, 6, this.mStudentHex, this.mTitleBar.getTitleViewContent());
        this.mNBOr4GOpenControlUtil.setListener(new OpenControlListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.drinkwater.DrinkWaterDetailActivity.2
            @Override // client.android.yixiaotong.v3.ui.appcontrol.listener.OpenControlListener
            public void onOpenEnd() {
                DrinkWaterDetailActivity.this.openEnd();
            }

            @Override // client.android.yixiaotong.v3.ui.appcontrol.listener.OpenControlListener
            public void onOpenFail() {
                DrinkWaterDetailActivity.this.mIsOpenFail = true;
            }
        });
        this.mNBOr4GOpenControlUtil.setErrorListener(new ErrorControlListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.drinkwater.DrinkWaterDetailActivity.3
            @Override // client.android.yixiaotong.v3.ui.appcontrol.listener.ErrorControlListener
            public void onFail(ClientException clientException) {
                if (clientException != null) {
                    DrinkWaterDetailActivity.this.mIsOffineOpen = true;
                    DrinkWaterDetailActivity.this.mClientException = clientException;
                }
            }
        });
        NBOr4GCloseControlUtil nBOr4GCloseControlUtil = new NBOr4GCloseControlUtil();
        this.mNBOr4GCloseControlUtil = nBOr4GCloseControlUtil;
        nBOr4GCloseControlUtil.init(getActivity(), getLoginAccount(), this.mBluetoothDevice, this.mTypeInfoBaseInfoBean, 6, this.mStudentHex, this.mTitleBar.getTitleViewContent());
        this.mNBOr4GCloseControlUtil.setListener(new CloseControlListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.drinkwater.DrinkWaterDetailActivity.4
            @Override // client.android.yixiaotong.v3.ui.appcontrol.listener.CloseControlListener
            public void onCloseEnd() {
                ToastUtils.show(DrinkWaterDetailActivity.this.getContext(), "关阀成功");
                CloseSuccessActivity.launch(DrinkWaterDetailActivity.this.getActivity(), 6);
                DrinkWaterDetailActivity.this.finish();
            }
        });
        DSKOpenControlUtil dSKOpenControlUtil = new DSKOpenControlUtil();
        this.mDskOpenControlUtil = dSKOpenControlUtil;
        dSKOpenControlUtil.init(getActivity(), getLoginAccount(), this.mBluetoothDevice, this.mTypeInfoBaseInfoBean, 6, this.mStudentHex, this.mTitleBar.getTitleViewContent());
        this.mDskOpenControlUtil.setListener(new OpenControlListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.drinkwater.DrinkWaterDetailActivity.5
            @Override // client.android.yixiaotong.v3.ui.appcontrol.listener.OpenControlListener
            public void onOpenEnd() {
                DrinkWaterDetailActivity.this.openEnd();
            }

            @Override // client.android.yixiaotong.v3.ui.appcontrol.listener.OpenControlListener
            public void onOpenFail() {
                DrinkWaterDetailActivity.this.mIsOpenFail = true;
            }
        });
        DSKCloseControlUtil dSKCloseControlUtil = new DSKCloseControlUtil();
        this.mDskCloseControlUtil = dSKCloseControlUtil;
        dSKCloseControlUtil.init(getActivity(), getLoginAccount(), this.mBluetoothDevice, this.mTypeInfoBaseInfoBean, 6, this.mStudentHex, this.mTitleBar.getTitleViewContent());
        this.mDskCloseControlUtil.setListener(new CloseControlListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.drinkwater.DrinkWaterDetailActivity.6
            @Override // client.android.yixiaotong.v3.ui.appcontrol.listener.CloseControlListener
            public void onCloseEnd() {
                ToastUtils.show(DrinkWaterDetailActivity.this.getContext(), "关阀成功");
                CloseSuccessActivity.launch(DrinkWaterDetailActivity.this.getActivity(), 6);
                DrinkWaterDetailActivity.this.finish();
            }
        });
    }

    public void onClose(View view) {
        BaseMaterialDialog.showMaterialDialog(getActivity(), "正在关阀中.", false);
        this.mFlowState = FlowState.closeing;
        disconnect();
        if (this.mType == 1) {
            this.mDskCloseControlUtil.closeStart();
        } else {
            this.mNBOr4GCloseControlUtil.closeStart();
        }
        MainThreadExecutor.getInstance().executeDelayed(new Runnable() { // from class: client.android.yixiaotong.v3.ui.appcontrol.drinkwater.DrinkWaterDetailActivity.7
            @Override // java.lang.Runnable
            public void run() {
                if (DrinkWaterDetailActivity.this.mIsEnable && DrinkWaterDetailActivity.this.mFlowState == FlowState.closeing && !DrinkWaterDetailActivity.this.mIsCloseConnected) {
                    ToastUtils.show(DrinkWaterDetailActivity.this.getActivity(), "关阀失败");
                    BaseMaterialDialog.dissmisMaterialDialog();
                    LogUtil.e(DrinkWaterDetailActivity.TAG, "关阀失败");
                }
            }
        }, 7000L);
    }

    public void initBluetooth() {
        BluetoothControlUtil.getInstance().init(getActivity());
        BluetoothControlUtil.getInstance().setListener(new BluetoothControlUtil.Listener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.drinkwater.DrinkWaterDetailActivity.8
            @Override // client.android.yixiaotong.v3.bluetoothutil.BluetoothControlUtil.Listener
            public void onConnected() {
                super.onConnected();
                Log.e(DrinkWaterDetailActivity.TAG, "onConnected  " + DrinkWaterDetailActivity.this.mFlowState + "  " + DrinkWaterDetailActivity.this.mIsBluetoothDevice + "  " + DrinkWaterDetailActivity.this.mIsOffineOpen);
                if (DrinkWaterDetailActivity.this.mIsOffineOpen) {
                    if (DrinkWaterDetailActivity.this.mFlowState == FlowState.opening) {
                        DrinkWaterDetailActivity.this.mNBOr4GOpenControlUtil.connected();
                        return;
                    } else {
                        if (DrinkWaterDetailActivity.this.mFlowState == FlowState.closeing) {
                            DrinkWaterDetailActivity.this.mNBOr4GCloseControlUtil.connected();
                            return;
                        }
                        return;
                    }
                }
                if (DrinkWaterDetailActivity.this.mType == 1) {
                    if (DrinkWaterDetailActivity.this.mFlowState == FlowState.opening) {
                        DrinkWaterDetailActivity.this.mDskOpenControlUtil.connected();
                        return;
                    } else {
                        if (DrinkWaterDetailActivity.this.mFlowState == FlowState.closeing) {
                            DrinkWaterDetailActivity.this.mDskCloseControlUtil.connected();
                            return;
                        }
                        return;
                    }
                }
                if (DrinkWaterDetailActivity.this.mFlowState == FlowState.opening || DrinkWaterDetailActivity.this.mFlowState == FlowState.opened) {
                    if (DrinkWaterDetailActivity.this.mIsBluetoothDevice) {
                        DrinkWaterDetailActivity.this.mBluetoothOpenControlUtil.connected();
                        return;
                    } else {
                        DrinkWaterDetailActivity.this.mNBOr4GOpenControlUtil.connected();
                        return;
                    }
                }
                if (DrinkWaterDetailActivity.this.mFlowState == FlowState.closeing) {
                    DrinkWaterDetailActivity.this.mIsCloseConnected = true;
                    DrinkWaterDetailActivity.this.mNBOr4GCloseControlUtil.connected();
                }
            }

            @Override // client.android.yixiaotong.v3.bluetoothutil.BluetoothControlUtil.Listener
            public void onFail(int i, String str) {
                super.onFail(i, str);
                Log.e(DrinkWaterDetailActivity.TAG, "onFail" + i + "  " + str + "  " + DrinkWaterDetailActivity.this.mFlowState + "  " + DrinkWaterDetailActivity.this.mIsBluetoothDevice + "  " + DrinkWaterDetailActivity.this.mIsOffineOpen);
                if (DrinkWaterDetailActivity.this.mIsOffineOpen) {
                    if (DrinkWaterDetailActivity.this.mClientException != null) {
                        DrinkWaterDetailActivity drinkWaterDetailActivity = DrinkWaterDetailActivity.this;
                        drinkWaterDetailActivity.onError(drinkWaterDetailActivity.mClientException);
                        return;
                    } else {
                        DrinkWaterDetailActivity.this.getDeviceInfo(true);
                        return;
                    }
                }
                if (str.equalsIgnoreCase("Discover") || str.equalsIgnoreCase("Connect")) {
                    str = "尝试重启手机或设备蓝牙再试";
                }
                if (DrinkWaterDetailActivity.this.mType == 1) {
                    if (DrinkWaterDetailActivity.this.mFlowState == FlowState.opening) {
                        if (DrinkWaterDetailActivity.this.mIsBluetoothDevice) {
                            if (DrinkWaterDetailActivity.this.mIsOpenFail) {
                                return;
                            }
                            DrinkWaterDetailActivity.this.onError(i, str);
                            return;
                        }
                        DrinkWaterDetailActivity.this.mDskOpenControlUtil.onBluetoothError(i, str);
                        return;
                    }
                    if (DrinkWaterDetailActivity.this.mFlowState == FlowState.closeing) {
                        DrinkWaterDetailActivity.this.onError(i, str);
                        return;
                    }
                    return;
                }
                if (DrinkWaterDetailActivity.this.mFlowState == FlowState.opening) {
                    if (DrinkWaterDetailActivity.this.mIsBluetoothDevice) {
                        if (DrinkWaterDetailActivity.this.mIsOpenFail) {
                            return;
                        }
                        DrinkWaterDetailActivity.this.onError(i, str);
                        return;
                    }
                    DrinkWaterDetailActivity.this.mNBOr4GOpenControlUtil.onBluetoothError(i, str);
                    return;
                }
                if (DrinkWaterDetailActivity.this.mFlowState == FlowState.closeing) {
                    DrinkWaterDetailActivity.this.onError(i, str);
                }
            }

            @Override // client.android.yixiaotong.v3.bluetoothutil.BluetoothControlUtil.Listener
            public void onReceivedData(String str) {
                super.onReceivedData(str);
                Log.e(DrinkWaterDetailActivity.TAG, "onReceivedData:" + str);
                if (DrinkWaterDetailActivity.this.mIsOffineOpen) {
                    if (DrinkWaterDetailActivity.this.mFlowState == FlowState.opening) {
                        DrinkWaterDetailActivity.this.mNBOr4GOpenControlUtil.onReceivedData(str);
                        return;
                    } else {
                        if (DrinkWaterDetailActivity.this.mFlowState == FlowState.closeing) {
                            DrinkWaterDetailActivity.this.mNBOr4GCloseControlUtil.onReceivedData(str);
                            return;
                        }
                        return;
                    }
                }
                if (DrinkWaterDetailActivity.this.mType == 1) {
                    if (DrinkWaterDetailActivity.this.mFlowState == FlowState.opening || DrinkWaterDetailActivity.this.mFlowState == FlowState.opened) {
                        DrinkWaterDetailActivity.this.mDskOpenControlUtil.onReceivedData(str);
                        return;
                    } else {
                        if (DrinkWaterDetailActivity.this.mFlowState == FlowState.closeing) {
                            DrinkWaterDetailActivity.this.mDskCloseControlUtil.onReceivedData(str);
                            return;
                        }
                        return;
                    }
                }
                if (DrinkWaterDetailActivity.this.mFlowState == FlowState.opening || DrinkWaterDetailActivity.this.mFlowState == FlowState.opened) {
                    if (DrinkWaterDetailActivity.this.mIsBluetoothDevice) {
                        return;
                    }
                    DrinkWaterDetailActivity.this.mNBOr4GOpenControlUtil.onReceivedData(str);
                } else if (DrinkWaterDetailActivity.this.mFlowState == FlowState.closeing) {
                    DrinkWaterDetailActivity.this.mNBOr4GCloseControlUtil.onReceivedData(str);
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
        MainThreadExecutor.getInstance().executeDelayed(new Runnable() { // from class: client.android.yixiaotong.v3.ui.appcontrol.drinkwater.DrinkWaterDetailActivity.9
            @Override // java.lang.Runnable
            public void run() {
                if (DrinkWaterDetailActivity.this.mType == 1) {
                    DrinkWaterDetailActivity.this.showDialogNeedExit("暂不支持该设备");
                    return;
                }
                if (DrinkWaterDetailActivity.this.mIsBluetoothDevice) {
                    DrinkWaterDetailActivity.this.mBluetoothOpenControlUtil.setDeviceInfo(DrinkWaterDetailActivity.this.mDeviceVer, DrinkWaterDetailActivity.this.mMachineId);
                    DrinkWaterDetailActivity.this.mBluetoothOpenControlUtil.openStart();
                } else {
                    DrinkWaterDetailActivity.this.mNBOr4GOpenControlUtil.setDeviceInfo(DrinkWaterDetailActivity.this.mPreferredCommunicationType, DrinkWaterDetailActivity.this.mType, DrinkWaterDetailActivity.this.mCnFlag, DrinkWaterDetailActivity.this.mDeviceVer, DrinkWaterDetailActivity.this.mMachineId);
                    DrinkWaterDetailActivity.this.mNBOr4GOpenControlUtil.openStart();
                    DrinkWaterDetailActivity.this.mNBOr4GCloseControlUtil.setDeviceInfo(DrinkWaterDetailActivity.this.mCnFlag, DrinkWaterDetailActivity.this.mDeviceVer, DrinkWaterDetailActivity.this.mMachineId);
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

    /* JADX INFO: Access modifiers changed from: private */
    public void getDeviceInfo(final boolean z) {
        V3BusinessControllers.getInstance().getMachineByMac(getLoginAccount(), this.mBluetoothDevice.address, 6, new Listener<MachineByMacBean>() { // from class: client.android.yixiaotong.v3.ui.appcontrol.drinkwater.DrinkWaterDetailActivity.10
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, MachineByMacBean machineByMacBean, Object... objArr) {
                if (DrinkWaterDetailActivity.this.mIsEnable) {
                    if (machineByMacBean == null || !StringUtils.isNotEmpty(machineByMacBean.deviceVer) || !StringUtils.isNotEmpty(machineByMacBean.machineId)) {
                        if (!z || !StringUtils.isNotEmpty(DrinkWaterDetailActivity.this.mQrcode) || DrinkWaterDetailActivity.this.mQrcode.length() < 52 || !DrinkWaterDetailActivity.this.mQrcode.startsWith("55")) {
                            DrinkWaterDetailActivity.this.showDialogNeedExit("设备未授权，请联系管理员" + DrinkWaterDetailActivity.this.mBluetoothDevice.address);
                            return;
                        } else {
                            DrinkWaterDetailActivity drinkWaterDetailActivity = DrinkWaterDetailActivity.this;
                            drinkWaterDetailActivity.updateMac(drinkWaterDetailActivity.mQrcode.substring(2, 10), DrinkWaterDetailActivity.this.mBluetoothDevice.address);
                            return;
                        }
                    }
                    DrinkWaterDetailActivity.this.mDeviceVer = machineByMacBean.deviceVer;
                    DrinkWaterDetailActivity.this.mMachineId = machineByMacBean.machineId;
                    DrinkWaterDetailActivity.this.mCnFlag = machineByMacBean.cnflag;
                    DrinkWaterDetailActivity.this.mType = machineByMacBean.mtype;
                    BeforeOpenControlUtil.getInstance().getUseInfoByMachineId(DrinkWaterDetailActivity.this.mMachineId, 6);
                    DrinkWaterDetailActivity.this.startOpen();
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (DrinkWaterDetailActivity.this.mIsEnable) {
                    if (clientException.isNeedExitApp(clientException.getCode()) || clientException.getCode() == -45) {
                        DrinkWaterDetailActivity.this.onError(clientException);
                        return;
                    }
                    if (!z || !StringUtils.isNotEmpty(DrinkWaterDetailActivity.this.mQrcode) || DrinkWaterDetailActivity.this.mQrcode.length() < 52 || !DrinkWaterDetailActivity.this.mQrcode.startsWith("55")) {
                        if (LocalDataUtil.getIsFirstOffline(DrinkWaterDetailActivity.this.getActivity())) {
                            DrinkWaterDetailActivity.this.onError(clientException);
                            return;
                        } else {
                            DrinkWaterDetailActivity.this.startOpenOffline(clientException);
                            return;
                        }
                    }
                    DrinkWaterDetailActivity drinkWaterDetailActivity = DrinkWaterDetailActivity.this;
                    drinkWaterDetailActivity.updateMac(drinkWaterDetailActivity.mQrcode.substring(2, 10), DrinkWaterDetailActivity.this.mBluetoothDevice.address);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateMac(String str, String str2) {
        V3BusinessControllers.getInstance().getUpdateMachineMac(getLoginAccount(), str, str2, 6, new Listener<MachineByMacBean>() { // from class: client.android.yixiaotong.v3.ui.appcontrol.drinkwater.DrinkWaterDetailActivity.11
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, MachineByMacBean machineByMacBean, Object... objArr) {
                if (DrinkWaterDetailActivity.this.mIsEnable) {
                    DrinkWaterDetailActivity.this.getDeviceInfo(false);
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (DrinkWaterDetailActivity.this.mIsEnable) {
                    DrinkWaterDetailActivity.this.onError(clientException);
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
            SystemErrorTip.getInstance().showTipDialog(getActivity(), new SystemErrorTip.SystemErrorDialogListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.drinkwater.DrinkWaterDetailActivity.12
                @Override // client.android.yixiaotong.ui.dialog.SystemErrorTip.SystemErrorDialogListener
                public void onConfirm() {
                    DrinkWaterDetailActivity.this.finish();
                }
            }, clientException.getDetail() + "\n(" + LocalDataUtil.getTraceID(getContext()) + ")");
        } else {
            V3ErrorTipActivity.launch(getActivity(), this.mTitleBar.getTitleViewContent(), clientException.getDetail(), clientException.getCode(), 2, clientException.getSerial());
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialogNeedExit(String str) {
        BaseMaterialDialog.dissmisMaterialDialog();
        SystemErrorTip.getInstance().showTipDialog(getActivity(), "", str + "\n(" + LocalDataUtil.getTraceID(getContext()) + ")", "", false, new SystemErrorTip.SystemErrorDialogListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.drinkwater.DrinkWaterDetailActivity.13
            @Override // client.android.yixiaotong.ui.dialog.SystemErrorTip.SystemErrorDialogListener
            public void onConfirm() {
                DrinkWaterDetailActivity.this.finish();
            }
        });
    }

    class TimeCount extends CountDownTimer {
        public TimeCount(long j, long j2) {
            super(j, j2);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            if (DrinkWaterDetailActivity.this.mIsEnable) {
                DrinkWaterDetailActivity.this.finish();
            }
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            if (DrinkWaterDetailActivity.this.mIsEnable) {
                DrinkWaterDetailActivity.this.mTvTime.setTextColor(DrinkWaterDetailActivity.this.getResources().getColor(R.color.ffa1a6b3));
                DrinkWaterDetailActivity.this.mTvTime.setClickable(false);
                DrinkWaterDetailActivity.this.mTvTime.setText(Html.fromHtml("该页面将在" + (j / 1000) + "后自动关闭"));
                DrinkWaterDetailActivity.this.mTvTime.setTextSize(13.0f);
                DrinkWaterDetailActivity.this.mTvTime.setPadding(5, 5, 5, 5);
            }
        }
    }

    private void getAdv() {
        this.mNativeUtil = new NativeUtil();
        this.mAdvListener = new AdvControlUtil.AdvListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.drinkwater.DrinkWaterDetailActivity.15
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
                    DrinkWaterDetailActivity.this.mNativeUtil.initNative(DrinkWaterDetailActivity.this.getActivity(), DrinkWaterDetailActivity.this.mAdvListener, 1);
                    DrinkWaterDetailActivity.this.mNativeUtil.onNative(DrinkWaterDetailActivity.this.rlContainer);
                }
                if (i3 == 1) {
                    MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.v3.ui.appcontrol.drinkwater.DrinkWaterDetailActivity.15.1
                        @Override // java.lang.Runnable
                        public void run() {
                            DrinkWaterDetailActivity.this.mGvAdv.setVisibility(0);
                            DrinkWaterDetailActivity.this.mAdvAdapter = new AdvAdapter();
                            DrinkWaterDetailActivity.this.mGvAdv.setAdapter((ListAdapter) DrinkWaterDetailActivity.this.mAdvAdapter);
                            DrinkWaterDetailActivity.this.mGvAdv.setOnItemClickListener(DrinkWaterDetailActivity.this);
                            DrinkWaterDetailActivity.this.mBannerJumpInfo = AdvControlUtil.getInstance().getBannerJumpInfos();
                            DrinkWaterDetailActivity.this.mAdvAdapter.notifyDataSetChanged();
                        }
                    });
                }
            }
        };
        AdvControlUtil.getInstance().init(getActivity(), this.mAdvListener, 6, true, "");
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
            return DrinkWaterDetailActivity.this.mBannerJumpInfo.size();
        }

        @Override // android.widget.Adapter
        public BannerJumpInfoBean getItem(int i) {
            return (BannerJumpInfoBean) DrinkWaterDetailActivity.this.mBannerJumpInfo.get(i);
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder viewHolder;
            if (view == null) {
                view = LayoutInflater.from(DrinkWaterDetailActivity.this.getContext()).inflate(R.layout.adv_item, (ViewGroup) null);
                viewHolder = new ViewHolder(view);
                view.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) view.getTag();
            }
            Glide.with(DrinkWaterDetailActivity.this.getActivity()).load(((BannerJumpInfoBean) DrinkWaterDetailActivity.this.mBannerJumpInfo.get(i)).info.pictureUrl).into(viewHolder.img);
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
