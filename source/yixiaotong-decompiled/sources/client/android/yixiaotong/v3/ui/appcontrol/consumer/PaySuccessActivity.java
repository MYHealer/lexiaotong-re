package client.android.yixiaotong.v3.ui.appcontrol.consumer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.ui.RechargeRecordActivity;
import client.android.yixiaotong.ui.ammeter.AmmeterWalletDetailActivity;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.executor.MainThreadExecutor;
import client.android.yixiaotong.v3.bean.deviceinfo.MachineByMacBean;
import client.android.yixiaotong.v3.bean.login.TypeInfoBaseInfoBean;
import client.android.yixiaotong.v3.bean.login.TypeInfoBean;
import client.android.yixiaotong.v3.bean.login.UseToolsJsonBean;
import client.android.yixiaotong.v3.bluetoothutil.BluetoothControlUtil;
import client.android.yixiaotong.v3.ui.adv.AdvControlUtil;
import client.android.yixiaotong.v3.ui.adv.Common;
import client.android.yixiaotong.v3.ui.adv.InsertUtil;
import client.android.yixiaotong.v3.ui.adv.NativeUtil;
import client.android.yixiaotong.v3.ui.appcontrol.listener.OpenControlListener;
import client.android.yixiaotong.v3.ui.order.OrderDetailActivity;
import client.android.yixiaotong.v3.userinfo.InvestorInfoUtilControl;
import client.android.yixiaotong.v3.userinfo.UserInfoUtil;
import client.android.yixiaotong.v3.util.ClickUtil;
import client.android.yixiaotong.v3.util.LogUtil;
import com.google.android.exoplayer2.C;
import com.lxt.bluetoothsdk.BluetoothSDK;
import com.lxt.bluetoothsdk.model.BluetoothDevice;
import com.stub.StubApp;
import com.unionpay.tsmservice.mi.data.Constant;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class PaySuccessActivity extends BaseActivity {
    private static final String TAG = "PaySuccessActivity";
    private static final int TIMEOUT = 3000;
    private AdvControlUtil.AdvListener mAdvListener;
    private BluetoothDevice mBluetoothDevice;
    Button mBtnState;
    private Consumer4GOpenControlUtil mConsumer4GOpenControlUtil;
    ImageView mImgResult;
    private InsertUtil mInsertUtil;
    private String mMac;
    private MachineByMacBean mMachineByMacBean;
    private NativeUtil mNativeUtil;
    private String mOrderId;
    private String mStudentHex;
    TitleBar mTitleBar;
    TextView mTvAdvName;
    TextView mTvAdvNameRihht;
    TextView mTvPayContent;
    TextView mTvPayContent2;
    private int mTypeId;
    private TypeInfoBaseInfoBean mTypeInfoBaseInfoBean;
    private TypeInfoBean mTypeInfoBean;
    private UseToolsJsonBean mUseToolsJsonBean;
    RelativeLayout rlContainer;
    private State mState = State.loading;
    private int mPreferredCommunicationType = 1;
    private boolean mIsEnable = true;
    private boolean mIsShowAdv = false;
    private boolean mIsOpenPop = false;

    private enum State {
        loading,
        success,
        fail
    }

    static {
        StubApp.interface11(9128);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    public static void launch(Activity activity, String str, MachineByMacBean machineByMacBean, String str2, int i) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) PaySuccessActivity.class).putExtra(AmmeterWalletDetailActivity.EXTRA_ORDERID, str).putExtra("deviceinfo", machineByMacBean).putExtra(Constant.KEY_MAC, str2).putExtra(RechargeRecordActivity.EXTRA_TYPEID, i));
        }
    }

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.titlebar);
        this.rlContainer = (RelativeLayout) findViewById(R.id.rlContainer);
        this.mTvAdvNameRihht = (TextView) findViewById(R.id.tv_advnameright);
        this.mTvAdvName = (TextView) findViewById(R.id.tv_advname);
        this.mTvPayContent = (TextView) findViewById(R.id.tv_content);
        this.mTvPayContent2 = (TextView) findViewById(R.id.tv_content2);
        this.mImgResult = (ImageView) findViewById(R.id.iv_connected);
        this.mBtnState = (Button) findViewById(R.id.btn_tolauhch);
    }

    private void initTitleBar() {
        this.mTitleBar.setTitleView(getString(R.string.payresult));
        this.mTitleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initView() {
        if (this.mState == State.loading) {
            this.mImgResult.setImageResource(R.mipmap.cumsumer_loading);
            this.mTvPayContent.setText(R.string.consumer_loading);
            this.mBtnState.setVisibility(4);
            final RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
            rotateAnimation.setDuration(C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS);
            rotateAnimation.setRepeatCount(-1);
            this.mImgResult.startAnimation(rotateAnimation);
            rotateAnimation.start();
            MainThreadExecutor.getInstance().executeDelayed(new Runnable() { // from class: client.android.yixiaotong.v3.ui.appcontrol.consumer.PaySuccessActivity.1
                @Override // java.lang.Runnable
                public void run() {
                    rotateAnimation.cancel();
                    PaySuccessActivity.this.mState = State.success;
                    PaySuccessActivity.this.initView();
                }
            }, C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS);
            return;
        }
        if (this.mState == State.success) {
            this.mImgResult.setImageResource(R.mipmap.l_hamam_select);
            this.mTvPayContent.setText(R.string.paysuccess);
            this.mTvPayContent2.setVisibility(0);
            this.mBtnState.setVisibility(0);
            this.mBtnState.setText(R.string.orderdetail1);
            requestInteraction();
            return;
        }
        if (this.mState == State.fail) {
            this.mImgResult.setImageResource(R.mipmap.pay_fail);
            this.mTvPayContent.setText(R.string.payfail);
            this.mBtnState.setText(R.string.back);
        }
    }

    private void initClickListeners() {
        findViewById(R.id.btn_tolauhch).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.consumer.PaySuccessActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ClickUtil.isFastDoubleClick()) {
                    return;
                }
                if (StringUtils.isNotEmpty(PaySuccessActivity.this.mOrderId)) {
                    OrderDetailActivity.launch(PaySuccessActivity.this.getActivity(), PaySuccessActivity.this.mOrderId, PaySuccessActivity.this.mTypeId);
                } else {
                    PaySuccessActivity.this.finish();
                }
            }
        });
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.mIsEnable = true;
        BluetoothControlUtil.getInstance().onResume();
        Consumer4GOpenControlUtil consumer4GOpenControlUtil = this.mConsumer4GOpenControlUtil;
        if (consumer4GOpenControlUtil != null) {
            consumer4GOpenControlUtil.onResume();
        }
        getAdv();
        AdvControlUtil.getInstance().onResume();
        NativeUtil nativeUtil = this.mNativeUtil;
        if (nativeUtil != null) {
            nativeUtil.onResume();
        }
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        this.mIsEnable = false;
        BluetoothControlUtil.getInstance().onPause();
        AdvControlUtil.getInstance().onPause();
        NativeUtil nativeUtil = this.mNativeUtil;
        if (nativeUtil != null) {
            nativeUtil.onPause();
        }
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        Consumer4GOpenControlUtil consumer4GOpenControlUtil = this.mConsumer4GOpenControlUtil;
        if (consumer4GOpenControlUtil != null) {
            consumer4GOpenControlUtil.onPause();
        }
        AdvControlUtil.getInstance().onDestroy(getActivity());
        NativeUtil nativeUtil = this.mNativeUtil;
        if (nativeUtil != null) {
            nativeUtil.onDestroy();
        }
        InsertUtil insertUtil = this.mInsertUtil;
        if (insertUtil != null) {
            insertUtil.onDestroy(getActivity());
        }
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
    }

    private void initData() {
        this.mStudentHex = UserInfoUtil.getInstance().getLoginAccountV3().studentHex;
        TypeInfoBean typeInfoBean = InvestorInfoUtilControl.getInstance().getTypeInfoBean(InvestorInfoUtilControl.getInstance().getPlanFlag(this.mTypeId), this.mTypeId);
        this.mTypeInfoBean = typeInfoBean;
        if (typeInfoBean == null) {
            finish();
            return;
        }
        this.mTypeInfoBaseInfoBean = typeInfoBean.base;
        UseToolsJsonBean useToolsJsonBean = this.mTypeInfoBean.useToolsJson;
        this.mUseToolsJsonBean = useToolsJsonBean;
        if (useToolsJsonBean != null && useToolsJsonBean.preferredCommunicationType != null) {
            this.mPreferredCommunicationType = this.mUseToolsJsonBean.preferredCommunicationType.intValue();
        }
        String str = this.mMac;
        this.mBluetoothDevice = new BluetoothDevice(str, str, 0);
    }

    private void initControl() {
        Consumer4GOpenControlUtil consumer4GOpenControlUtil = new Consumer4GOpenControlUtil();
        this.mConsumer4GOpenControlUtil = consumer4GOpenControlUtil;
        consumer4GOpenControlUtil.init(getActivity(), getLoginAccount(), this.mBluetoothDevice, this.mTypeInfoBaseInfoBean, this.mTypeId, this.mStudentHex, this.mOrderId);
        this.mConsumer4GOpenControlUtil.setListener(new OpenControlListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.consumer.PaySuccessActivity.3
            @Override // client.android.yixiaotong.v3.ui.appcontrol.listener.OpenControlListener
            public void onOpenEnd() {
            }

            @Override // client.android.yixiaotong.v3.ui.appcontrol.listener.OpenControlListener
            public void onOpenFail() {
            }
        });
        this.mConsumer4GOpenControlUtil.setDeviceInfo(this.mPreferredCommunicationType, this.mMachineByMacBean.mtype, this.mMachineByMacBean.cnflag, this.mMachineByMacBean.deviceVer, this.mMachineByMacBean.machineId);
        this.mConsumer4GOpenControlUtil.openStart();
    }

    public void initBluetooth() {
        BluetoothSDK.getInstance().init(getContext());
        BluetoothControlUtil.getInstance().init(getActivity());
        BluetoothControlUtil.getInstance().initDeviceType();
        BluetoothControlUtil.getInstance().setDeviceType(this.mMachineByMacBean.deviceVer);
        BluetoothControlUtil.getInstance().setListener(new BluetoothControlUtil.Listener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.consumer.PaySuccessActivity.4
            @Override // client.android.yixiaotong.v3.bluetoothutil.BluetoothControlUtil.Listener
            public void onConnected() {
                super.onConnected();
                LogUtil.e(PaySuccessActivity.TAG, "onConnected");
                if (PaySuccessActivity.this.mIsEnable) {
                    PaySuccessActivity.this.mConsumer4GOpenControlUtil.connected();
                }
            }

            @Override // client.android.yixiaotong.v3.bluetoothutil.BluetoothControlUtil.Listener
            public void onFail(int i, String str) {
                super.onFail(i, str);
                LogUtil.e(PaySuccessActivity.TAG, "onFail" + i + "  " + str);
                if (!str.equalsIgnoreCase("Discover")) {
                    str.equalsIgnoreCase("Connect");
                }
                if (PaySuccessActivity.this.mIsEnable) {
                    PaySuccessActivity.this.mConsumer4GOpenControlUtil.disconnect();
                }
            }

            @Override // client.android.yixiaotong.v3.bluetoothutil.BluetoothControlUtil.Listener
            public void onReceivedData(String str) {
                super.onReceivedData(str);
                LogUtil.e(PaySuccessActivity.TAG, "onReceivedData:" + str);
                if (PaySuccessActivity.this.mIsEnable) {
                    PaySuccessActivity.this.mConsumer4GOpenControlUtil.onReceivedData(str);
                }
            }
        });
    }

    private void getAdv() {
        if (this.mIsShowAdv) {
            return;
        }
        this.mNativeUtil = new NativeUtil();
        this.mInsertUtil = new InsertUtil();
        this.mAdvListener = new AdvControlUtil.AdvListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.consumer.PaySuccessActivity.5
            @Override // client.android.yixiaotong.v3.ui.adv.AdvControlUtil.AdvListener
            public void onAdClosed(Common.AdvType advType) {
            }

            @Override // client.android.yixiaotong.v3.ui.adv.AdvControlUtil.AdvListener
            public void onRenderSuccess(View view, int i) {
            }

            @Override // client.android.yixiaotong.v3.ui.adv.AdvControlUtil.AdvListener
            public void isOpen(int i, int i2, int i3, int i4, int i5) {
                if (i5 == 1) {
                    PaySuccessActivity.this.mInsertUtil.onCreate(PaySuccessActivity.this.getActivity());
                    PaySuccessActivity.this.mNativeUtil.initNative(PaySuccessActivity.this.getActivity(), PaySuccessActivity.this.mAdvListener, 1);
                    PaySuccessActivity.this.mNativeUtil.onNative(PaySuccessActivity.this.rlContainer);
                }
                if (i == 1) {
                    PaySuccessActivity.this.mIsOpenPop = true;
                }
            }

            @Override // client.android.yixiaotong.v3.ui.adv.AdvControlUtil.AdvListener
            public void onAdShow(String str, Common.AdvType advType) {
                if (Common.AdvType.advnative == advType) {
                    PaySuccessActivity.this.mIsShowAdv = true;
                }
            }
        };
        AdvControlUtil.getInstance().init(getActivity(), this.mAdvListener, this.mTypeId, true, "");
        AdvControlUtil.getInstance().initAdvInfo();
    }

    private void requestInteraction() {
        if (this.mIsOpenPop) {
            this.mInsertUtil.initInsert(getActivity(), this.mAdvListener, true, "", 2);
            this.mInsertUtil.onInsert();
        }
    }
}
