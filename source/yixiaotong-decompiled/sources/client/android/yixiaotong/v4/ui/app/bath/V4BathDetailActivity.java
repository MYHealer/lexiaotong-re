package client.android.yixiaotong.v4.ui.app.bath;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Html;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.ui.RechargeRecordActivity;
import client.android.yixiaotong.ui.dialog.BaseMaterialDialog;
import client.android.yixiaotong.ui.dialog.SystemErrorTip;
import client.android.yixiaotong.ui.widget.SetFontColorUtil;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.util.executor.MainThreadExecutor;
import client.android.yixiaotong.v3.bluetoothutil.BluetoothControlUtil;
import client.android.yixiaotong.v3.ui.adv.AdvControlUtil;
import client.android.yixiaotong.v3.ui.adv.Common;
import client.android.yixiaotong.v3.ui.adv.NativeUtil;
import client.android.yixiaotong.v3.ui.appcontrol.listener.CloseControlListener;
import client.android.yixiaotong.v3.ui.appcontrol.listener.ErrorControlListener;
import client.android.yixiaotong.v3.ui.scan.QrcodeUtil;
import client.android.yixiaotong.v3.util.ClickUtil;
import client.android.yixiaotong.v3.util.LogUtil;
import client.android.yixiaotong.v4.ui.app.listener.V4OpenControlListener;
import client.android.yixiaotong.v4.util.V4LocalDataUtil;
import client.android.yixiaotong.v4.util.homeinfo.V4HomeInfoUtil;
import client.android.yixiaotong.v4.util.homeinfo.V4TypeIDSetUtil;
import client.android.yixiaotong.v4.util.userinfo.V4UserInfoUtil;
import com.lxt.bluetoothsdk.BluetoothSDK;
import com.lxt.bluetoothsdk.model.BluetoothDevice;
import com.stub.StubApp;
import com.unionpay.tsmservice.mi.data.Constant;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class V4BathDetailActivity extends BaseActivity {
    public static final String TAG = "V4BathDetailActivity";
    private AdvControlUtil.AdvListener mAdvListener;
    private BluetoothDevice mBluetoothDevice;
    Button mBtnClose;
    private ClientException mClientException;
    ImageView mIvCircle;
    LinearLayout mLinTip;
    private String mMac;
    private String mMode;
    private V4NBOr4GCloseControlUtil mNBOr4GCloseControlUtil;
    private V4NBOr4GOpenControlUtil mNBOr4GOpenControlUtil;
    private NativeUtil mNativeUtil;
    RelativeLayout mRelClose;
    RelativeLayout mRelConnect;
    TitleBar mTitleBar;
    TextView mTvAdvName;
    TextView mTvConnectTip;
    TextView mTvMac;
    TextView mTvTime;
    TextView mTvTip;
    private int mTypeId;
    RelativeLayout rlContainer;
    private boolean mIsEnable = true;
    private FlowState mFlowState = FlowState.none;
    private String mMachineId = "";
    private boolean mWashModeUseAddLiquid = false;
    private boolean mIsOffineOpen = false;
    private boolean mIsCloseConnected = false;

    private enum FlowState {
        none,
        opening,
        opened,
        closeing
    }

    static {
        StubApp.interface11(10669);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    public static void launch(Activity activity, String str, String str2, int i, String str3, boolean z) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) V4BathDetailActivity.class).putExtra(Constant.KEY_MAC, str).putExtra("machineid", str2).putExtra(RechargeRecordActivity.EXTRA_TYPEID, i).putExtra("mode", str3).putExtra("washmodeuseaddliquid", z));
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
        this.mLinTip = (LinearLayout) findViewById(R.id.lin_tip);
        this.mTvTip = (TextView) findViewById(R.id.tv_tip);
        this.rlContainer = (RelativeLayout) findViewById(R.id.rlContainer);
        this.mTvAdvName = (TextView) findViewById(R.id.tv_advname);
    }

    private void initTitleBar() {
        this.mTitleBar.setTitleView(V4TypeIDSetUtil.getAppName(getActivity(), this.mTypeId));
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
        this.mTvMac.setText("设备蓝牙mac:" + this.mBluetoothDevice.address);
        this.mBtnClose.setVisibility(0);
        this.mTvMac.setVisibility(0);
        TextView textView = this.mTvTip;
        textView.setText(SetFontColorUtil.getFontForContents(textView.getText().toString(), "#ff6f32fd", "机械按钮", "触摸按钮", "极速开阀"));
    }

    private void start() {
        this.mIsOffineOpen = false;
        LogUtil.e(TAG, "mac:" + this.mMac);
        if (StringUtils.isNotEmpty(this.mMac) && this.mMac.length() == 17 && QrcodeUtil.isMacIllegal(this.mMac)) {
            initData(this.mMac);
        } else {
            ToastUtils.show(getActivity(), "设备蓝牙Mac异常：" + this.mMac);
            finish();
        }
    }

    private void startOpen() {
        this.mIsOffineOpen = false;
        this.mFlowState = FlowState.opening;
        initView();
        BluetoothControlUtil.getInstance().setDeviceType(BluetoothControlUtil.DeviceType.nbdevice);
        MainThreadExecutor.getInstance().executeDelayed(new Runnable() { // from class: client.android.yixiaotong.v4.ui.app.bath.V4BathDetailActivity.1
            @Override // java.lang.Runnable
            public void run() {
                V4BathDetailActivity.this.mNBOr4GOpenControlUtil.setDeviceInfo(V4BathDetailActivity.this.mMachineId);
                V4BathDetailActivity.this.mNBOr4GOpenControlUtil.openStart();
                V4BathDetailActivity.this.mNBOr4GCloseControlUtil.setDeviceInfo(V4BathDetailActivity.this.mMachineId);
            }
        }, 50L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openEnd(int i) {
        LogUtil.e(TAG, "openEnd:" + i);
        this.mFlowState = FlowState.opened;
        this.mIvCircle.clearAnimation();
        this.mRelConnect.setVisibility(8);
        this.mRelClose.setVisibility(0);
        V4LocalDataUtil.saveOpenSuccessInfo(getActivity(), V4UserInfoUtil.getInstance().getLoginAccountV4().hexUserId, this.mBluetoothDevice.address + "," + this.mMachineId);
        V4NBOr4GCloseControlUtil v4NBOr4GCloseControlUtil = this.mNBOr4GCloseControlUtil;
        if (v4NBOr4GCloseControlUtil != null) {
            v4NBOr4GCloseControlUtil.setOpenWay(i);
        }
        if (this.mTypeId != 1) {
            this.mLinTip.setVisibility(8);
        }
        this.mTvConnectTip.setVisibility(0);
        int i2 = this.mTypeId;
        if (i2 == 11 || i2 == 4 || i2 == 12 || i2 == 13) {
            this.mBtnClose.setText(getResources().getString(R.string.backfirstpage));
            this.mTvConnectTip.setVisibility(8);
        }
        this.mBtnClose.setVisibility(8);
        new TimeCount(4000L, 1000L).start();
    }

    public void onClose(View view) {
        if (ClickUtil.isFastDoubleClick()) {
            return;
        }
        int i = this.mTypeId;
        if (i == 11 || i == 4) {
            finish();
        } else {
            onClose();
        }
    }

    private void onClose() {
        BaseMaterialDialog.showMaterialDialog(getActivity(), "正在关阀中.", false);
        this.mFlowState = FlowState.closeing;
        disconnect();
        LogUtil.e(TAG, "开始关阀  " + this.mIsOffineOpen);
        this.mNBOr4GCloseControlUtil.closeStart();
        MainThreadExecutor.getInstance().executeDelayed(new Runnable() { // from class: client.android.yixiaotong.v4.ui.app.bath.V4BathDetailActivity.2
            @Override // java.lang.Runnable
            public void run() {
                if (V4BathDetailActivity.this.mIsEnable && V4BathDetailActivity.this.mFlowState == FlowState.closeing && !V4BathDetailActivity.this.mIsCloseConnected) {
                    ToastUtils.show(V4BathDetailActivity.this.getActivity(), "关阀失败.");
                    BaseMaterialDialog.dissmisMaterialDialog();
                    LogUtil.e(V4BathDetailActivity.TAG, "关阀失败");
                }
            }
        }, 7000L);
    }

    private void initControl() {
        V4NBOr4GOpenControlUtil v4NBOr4GOpenControlUtil = new V4NBOr4GOpenControlUtil();
        this.mNBOr4GOpenControlUtil = v4NBOr4GOpenControlUtil;
        v4NBOr4GOpenControlUtil.init(getActivity(), getLoginAccount(), this.mBluetoothDevice, this.mTypeId, this.mTitleBar.getTitleViewContent(), this.mMode, this.mWashModeUseAddLiquid);
        this.mNBOr4GOpenControlUtil.setListener(new V4OpenControlListener() { // from class: client.android.yixiaotong.v4.ui.app.bath.V4BathDetailActivity.3
            @Override // client.android.yixiaotong.v4.ui.app.listener.V4OpenControlListener
            public void onOpenFail() {
            }

            @Override // client.android.yixiaotong.v4.ui.app.listener.V4OpenControlListener
            public void onOpenEnd(int i) {
                V4BathDetailActivity.this.openEnd(i);
            }
        });
        this.mNBOr4GOpenControlUtil.setErrorListener(new ErrorControlListener() { // from class: client.android.yixiaotong.v4.ui.app.bath.V4BathDetailActivity.4
            @Override // client.android.yixiaotong.v3.ui.appcontrol.listener.ErrorControlListener
            public void onFail(ClientException clientException) {
                if (clientException != null) {
                    V4BathDetailActivity.this.mIsOffineOpen = true;
                    V4BathDetailActivity.this.mClientException = clientException;
                }
            }
        });
        V4NBOr4GCloseControlUtil v4NBOr4GCloseControlUtil = new V4NBOr4GCloseControlUtil();
        this.mNBOr4GCloseControlUtil = v4NBOr4GCloseControlUtil;
        v4NBOr4GCloseControlUtil.init(getActivity(), getLoginAccount(), this.mBluetoothDevice, this.mTypeId, this.mTitleBar.getTitleViewContent());
        this.mNBOr4GCloseControlUtil.setListener(new CloseControlListener() { // from class: client.android.yixiaotong.v4.ui.app.bath.V4BathDetailActivity.5
            @Override // client.android.yixiaotong.v3.ui.appcontrol.listener.CloseControlListener
            public void onCloseEnd() {
                V4LocalDataUtil.saveOpenSuccessInfo(V4BathDetailActivity.this.getActivity(), V4UserInfoUtil.getInstance().getLoginAccountV4().hexUserId, "");
                ToastUtils.show(V4BathDetailActivity.this.getContext(), "关阀成功");
                V4CloseSuccessActivity.launch(V4BathDetailActivity.this.getActivity(), V4BathDetailActivity.this.mTypeId);
                V4BathDetailActivity.this.finish();
            }
        });
    }

    public void initBluetooth() {
        BluetoothSDK.getInstance().init(getContext());
        BluetoothControlUtil.getInstance().init(getActivity());
        BluetoothControlUtil.getInstance().setListener(new BluetoothControlUtil.Listener() { // from class: client.android.yixiaotong.v4.ui.app.bath.V4BathDetailActivity.6
            @Override // client.android.yixiaotong.v3.bluetoothutil.BluetoothControlUtil.Listener
            public void onConnected() {
                super.onConnected();
                LogUtil.d(V4BathDetailActivity.TAG, "onConnected:" + V4BathDetailActivity.this.mIsOffineOpen);
                if (V4BathDetailActivity.this.mIsOffineOpen) {
                    if (V4BathDetailActivity.this.mFlowState == FlowState.opening) {
                        V4BathDetailActivity.this.mNBOr4GOpenControlUtil.connected();
                        return;
                    } else {
                        if (V4BathDetailActivity.this.mFlowState == FlowState.closeing) {
                            V4BathDetailActivity.this.mNBOr4GCloseControlUtil.connected();
                            return;
                        }
                        return;
                    }
                }
                if (V4BathDetailActivity.this.mFlowState == FlowState.opening || V4BathDetailActivity.this.mFlowState == FlowState.opened) {
                    V4BathDetailActivity.this.mNBOr4GOpenControlUtil.connected();
                } else if (V4BathDetailActivity.this.mFlowState == FlowState.closeing) {
                    V4BathDetailActivity.this.mIsCloseConnected = true;
                    V4BathDetailActivity.this.mNBOr4GCloseControlUtil.connected();
                }
            }

            @Override // client.android.yixiaotong.v3.bluetoothutil.BluetoothControlUtil.Listener
            public void onFail(int i, String str) {
                super.onFail(i, str);
                LogUtil.e(V4BathDetailActivity.TAG, "onFail" + i + "  " + str + "  " + V4BathDetailActivity.this.mIsOffineOpen);
                if (str.equalsIgnoreCase("Discover") || str.equalsIgnoreCase("Connect")) {
                    str = "尝试重启手机或设备蓝牙再试";
                }
                if (V4BathDetailActivity.this.mIsOffineOpen) {
                    V4BathDetailActivity.this.disconnect();
                    V4BathDetailActivity.this.onError(i, str);
                } else if (V4BathDetailActivity.this.mFlowState == FlowState.opening) {
                    V4BathDetailActivity.this.mNBOr4GOpenControlUtil.onBluetoothError(i, str);
                } else if (V4BathDetailActivity.this.mFlowState == FlowState.closeing) {
                    V4BathDetailActivity.this.onError(i, str);
                }
            }

            @Override // client.android.yixiaotong.v3.bluetoothutil.BluetoothControlUtil.Listener
            public void onReceivedData(final String str) {
                super.onReceivedData(str);
                LogUtil.d(V4BathDetailActivity.TAG, "onReceivedData:" + str);
                MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.v4.ui.app.bath.V4BathDetailActivity.6.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (V4BathDetailActivity.this.mIsOffineOpen) {
                            if (V4BathDetailActivity.this.mFlowState == FlowState.opening) {
                                V4BathDetailActivity.this.mNBOr4GOpenControlUtil.onReceivedData(str);
                                return;
                            } else {
                                if (V4BathDetailActivity.this.mFlowState == FlowState.closeing) {
                                    V4BathDetailActivity.this.mNBOr4GCloseControlUtil.onReceivedData(str);
                                    return;
                                }
                                return;
                            }
                        }
                        if (V4BathDetailActivity.this.mFlowState == FlowState.opening || V4BathDetailActivity.this.mFlowState == FlowState.opened) {
                            V4BathDetailActivity.this.mNBOr4GOpenControlUtil.onReceivedData(str);
                        } else if (V4BathDetailActivity.this.mFlowState == FlowState.closeing) {
                            V4BathDetailActivity.this.mNBOr4GCloseControlUtil.onReceivedData(str);
                        }
                    }
                });
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
        V4NBOr4GOpenControlUtil v4NBOr4GOpenControlUtil = this.mNBOr4GOpenControlUtil;
        if (v4NBOr4GOpenControlUtil != null) {
            v4NBOr4GOpenControlUtil.onResume();
        }
        V4NBOr4GCloseControlUtil v4NBOr4GCloseControlUtil = this.mNBOr4GCloseControlUtil;
        if (v4NBOr4GCloseControlUtil != null) {
            v4NBOr4GCloseControlUtil.onResume();
        }
        NativeUtil nativeUtil = this.mNativeUtil;
        if (nativeUtil != null) {
            nativeUtil.onResume();
        }
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
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
        V4NBOr4GOpenControlUtil v4NBOr4GOpenControlUtil = this.mNBOr4GOpenControlUtil;
        if (v4NBOr4GOpenControlUtil != null) {
            v4NBOr4GOpenControlUtil.onPause();
        }
        V4NBOr4GCloseControlUtil v4NBOr4GCloseControlUtil = this.mNBOr4GCloseControlUtil;
        if (v4NBOr4GCloseControlUtil != null) {
            v4NBOr4GCloseControlUtil.onPause();
        }
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        NativeUtil nativeUtil = this.mNativeUtil;
        if (nativeUtil != null) {
            nativeUtil.onDestroy();
        }
        super.onDestroy();
        disconnect();
    }

    private void initData(String str) {
        this.mBluetoothDevice = new BluetoothDevice(str, str, 0);
        initViewRoate();
        initBluetooth();
        initControl();
        getAdv();
        startOpen();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onError(int i, String str) {
        BaseMaterialDialog.dissmisMaterialDialog();
        SystemErrorTip.getInstance().showTipDialog(getActivity(), new SystemErrorTip.SystemErrorDialogListener() { // from class: client.android.yixiaotong.v4.ui.app.bath.V4BathDetailActivity.7
            @Override // client.android.yixiaotong.ui.dialog.SystemErrorTip.SystemErrorDialogListener
            public void onConfirm() {
                V4BathDetailActivity.this.finish();
            }
        }, str);
    }

    class TimeCount extends CountDownTimer {
        public TimeCount(long j, long j2) {
            super(j, j2);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            if (V4BathDetailActivity.this.mIsEnable) {
                V4BathDetailActivity.this.mBtnClose.setVisibility(0);
                V4BathDetailActivity.this.mTvTime.setVisibility(8);
            }
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            if (V4BathDetailActivity.this.mIsEnable) {
                String str = (j / 1000) + ExifInterface.LATITUDE_SOUTH;
                V4BathDetailActivity.this.mTvTime.setTextColor(V4BathDetailActivity.this.getResources().getColor(R.color.ff6f32fd));
                V4BathDetailActivity.this.mTvTime.setClickable(false);
                V4BathDetailActivity.this.mTvTime.setText(Html.fromHtml(str));
                V4BathDetailActivity.this.mTvTime.setTextSize(18.0f);
                V4BathDetailActivity.this.mTvTime.setPadding(5, 5, 5, 5);
            }
        }
    }

    private void initAdv() {
        this.mNativeUtil = new NativeUtil();
    }

    private void getAdv() {
        this.mAdvListener = new AdvControlUtil.AdvListener() { // from class: client.android.yixiaotong.v4.ui.app.bath.V4BathDetailActivity.8
            @Override // client.android.yixiaotong.v3.ui.adv.AdvControlUtil.AdvListener
            public void isOpen(int i, int i2, int i3, int i4, int i5) {
            }

            @Override // client.android.yixiaotong.v3.ui.adv.AdvControlUtil.AdvListener
            public void onAdClosed(Common.AdvType advType) {
            }

            @Override // client.android.yixiaotong.v3.ui.adv.AdvControlUtil.AdvListener
            public void onAdShow(String str, Common.AdvType advType) {
            }

            @Override // client.android.yixiaotong.v3.ui.adv.AdvControlUtil.AdvListener
            public void onRenderSuccess(View view, int i) {
            }
        };
        boolean zIsOpenAdv = V4HomeInfoUtil.getInstance().isOpenAdv();
        LogUtil.e(TAG, "广告是否开启：" + zIsOpenAdv);
        if (zIsOpenAdv) {
            this.mNativeUtil.initNative(getActivity(), this.mAdvListener, 1);
            this.mNativeUtil.onNative(this.rlContainer);
        }
    }
}
