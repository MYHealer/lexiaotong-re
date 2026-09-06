package client.android.yixiaotong.ui.ammeter;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.alipay.AliPayUtils;
import client.android.yixiaotong.controller.BusinessControllers;
import client.android.yixiaotong.controller.bean.AeemterAuthorizeBean;
import client.android.yixiaotong.controller.bean.AmmeterAliPayBean;
import client.android.yixiaotong.controller.bean.AmmeterEndBean;
import client.android.yixiaotong.controller.bean.AmmeterOrderStateBean;
import client.android.yixiaotong.controller.bean.AmmeterRoomDetail;
import client.android.yixiaotong.controller.bean.AmmeterWeiXinPayBean;
import client.android.yixiaotong.controller.bean.UnionPayBean;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.controller.model.WalletModel;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.sdk.utils.HexString;
import client.android.yixiaotong.ui.dialog.SystemErrorTip;
import client.android.yixiaotong.ui.refund.Refund2Activity;
import client.android.yixiaotong.ui.unionpay.AlipayActivity;
import client.android.yixiaotong.ui.unionpay.UnionWebActivity;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.AESHelper;
import client.android.yixiaotong.util.AppUtils;
import client.android.yixiaotong.util.ClickUtils;
import client.android.yixiaotong.util.DecimalUtil;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.util.ammeterbluetooth.AmmeterBluetoothDevice;
import client.android.yixiaotong.util.ammeterbluetooth.AmmeterBluetoothManager;
import client.android.yixiaotong.util.ammeterbluetooth.AmmeterCommandUtils;
import client.android.yixiaotong.util.ammeterutil.AmmeterRandomUtils;
import client.android.yixiaotong.util.android.LocalPreferencesHelper;
import client.android.yixiaotong.util.bluetooth.TimeOut;
import client.android.yixiaotong.util.random.RandomUtils;
import client.android.yixiaotong.wxapi.WxPayUtils;
import com.afollestad.materialdialogs.MaterialDialog;
import com.android.volley.VolleyError;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.huawei.openalliance.ad.constant.x;
import com.huawei.openalliance.ad.views.PPSLabelView;
import com.masget.base.ApiConfig;
import com.masget.base.volley.JSONResponseHandler;
import com.masget.base.volley.VolleyRequestNew;
import com.stub.StubApp;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class AmmeterWalletDetailActivity extends BaseActivity implements AmmeterBluetoothManager.Listener {
    public static final String EXTRAS_DEVICE_ADDRESS = "deviceAddress";
    public static final String EXTRAS_DEVICE_NAME = "deviceName";
    public static final String EXTRA_DEVICENO = "deviceno";
    public static final String EXTRA_MONEY = "money";
    public static final String EXTRA_ORDER = "order";
    public static final String EXTRA_ORDERID = "orderid";
    public static final String EXTRA_USERNO = "extra_userno";
    public static final String EXTRA_WALLET = "extra_wallet";
    public static final int MESSAGE_CONNECT = 2;
    public static final int MESSAGE_CONNECTCOUNT = 6;
    public static final int MESSAGE_CONNECTED = 3;
    public static final int MESSAGE_GETDATA = 7;
    public static final int MESSAGE_SCAN = 1;
    public static final int MESSAGE_SCANCOUNT = 5;
    public static final int MESSAGE_SENDDATA = 4;
    private boolean isHasOredr;
    private String mAddress;
    private AmmeterBluetoothManager mAmmeterBluetoothManager;
    private AmmeterBluetoothDevice mBluetoothDevice;
    private TimeOut mCurrentCheckTimeOut;
    private String mDeviceNo;
    private Handler mHandler;
    private ImageView mImgUnionAlipay;
    private ImageView mImgUnionOnline;
    private ImageView mImgUnionWechat;
    String mInputMoney;
    private LinearLayout mLinInputMoney;
    private LinearLayout mLinInputMoney1;
    private MaterialDialog mMaterialDialog;
    private String mOrderId;
    private String mOrderMoney;
    private Button mRechargerAmmeter;
    private RelativeLayout mRelOrder;
    private String mRoomId;
    private String mTime;
    private TextView mTvAmmeterBalance;
    private TextView mTvDeviceName;
    private TextView mTvInputMoney;
    private TextView mTvKWH;
    private TextView mTvSubBalabce;
    private String mUserNo;
    private String mUserNo1;
    private Button mVBtnRecord;
    private TitleBar mVTitleBar;
    private WalletModel mWalletModel;
    private String mReceivedCode = "FF";
    private String mSendCode = "FF";
    private String mbalance = "0.00";
    private boolean mConnected = false;
    private boolean mSupport = false;
    private boolean mReceicedData = false;
    private boolean isRealPay = false;
    private State mState = State.none;
    private boolean isFirstSelectOrder = false;
    private int getDataMessage = 8;
    private int scanMessage = 10;
    private int connectMessage = 12;
    private int mShengyuMoney = 0;
    private Handler handlersend = new Handler();
    final Runnable runnableSend = new Runnable() { // from class: client.android.yixiaotong.ui.ammeter.AmmeterWalletDetailActivity.13
        private void sendData() {
            if (!AmmeterWalletDetailActivity.this.isConnected()) {
                ToastUtils.show(AmmeterWalletDetailActivity.this.getContext(), "电表已断开，请重新连接电表");
                AmmeterWalletDetailActivity.this.finish();
            } else {
                AmmeterWalletDetailActivity.this.sendGetDeviceInfoData();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            sendData();
        }
    };
    private boolean isFoundDevice = false;

    enum State {
        none,
        close,
        opened
    }

    static {
        StubApp.interface11(6261);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isConnected() {
        return this.mSupport && this.mConnected;
    }

    @Override // client.android.yixiaotong.util.ammeterbluetooth.AmmeterBluetoothManager.Listener
    public void onConnected(String str, boolean z) {
        this.mConnected = z;
    }

    @Override // client.android.yixiaotong.util.ammeterbluetooth.AmmeterBluetoothManager.Listener
    public void onConnecting(String str) {
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    @Override // client.android.yixiaotong.util.ammeterbluetooth.AmmeterBluetoothManager.Listener
    public void onDiscoveryFinished() {
    }

    @Override // client.android.yixiaotong.util.ammeterbluetooth.AmmeterBluetoothManager.Listener
    public void onDiscoveryStarted() {
    }

    static /* synthetic */ int access$2310(AmmeterWalletDetailActivity ammeterWalletDetailActivity) {
        int i = ammeterWalletDetailActivity.scanMessage;
        ammeterWalletDetailActivity.scanMessage = i - 1;
        return i;
    }

    static /* synthetic */ int access$2510(AmmeterWalletDetailActivity ammeterWalletDetailActivity) {
        int i = ammeterWalletDetailActivity.connectMessage;
        ammeterWalletDetailActivity.connectMessage = i - 1;
        return i;
    }

    static /* synthetic */ int access$2610(AmmeterWalletDetailActivity ammeterWalletDetailActivity) {
        int i = ammeterWalletDetailActivity.getDataMessage;
        ammeterWalletDetailActivity.getDataMessage = i - 1;
        return i;
    }

    private void initViewNew() {
        this.mVTitleBar = (TitleBar) findViewById(R.id.v_titleBar);
        this.mVBtnRecord = (Button) findViewById(R.id.v_btn_record);
        this.mTvDeviceName = (TextView) findViewById(R.id.tv_devicename);
        this.mTvSubBalabce = (TextView) findViewById(R.id.tv_balance);
        this.mRechargerAmmeter = (Button) findViewById(R.id.v_btn_recharge);
        this.mTvKWH = (TextView) findViewById(R.id.tv_kwh);
        this.mTvAmmeterBalance = (TextView) findViewById(R.id.tv_ammeter_balance);
        this.mImgUnionAlipay = (ImageView) findViewById(R.id.v_btn_union_alipay);
        this.mImgUnionWechat = (ImageView) findViewById(R.id.v_btn_union_wechat);
        this.mImgUnionOnline = (ImageView) findViewById(R.id.v_btn_union_online);
        this.mTvInputMoney = (TextView) findViewById(R.id.tv_money);
        this.mRelOrder = (RelativeLayout) findViewById(R.id.rel_order);
        this.mLinInputMoney = (LinearLayout) findViewById(R.id.lin_inputmoney);
        this.mLinInputMoney1 = (LinearLayout) findViewById(R.id.lin_inputmoney1);
    }

    public static void launch(Activity activity, WalletModel walletModel) {
        Intent intent = new Intent(activity, (Class<?>) AmmeterWalletDetailActivity.class);
        intent.putExtra("extra_wallet", walletModel);
        activity.startActivity(intent);
    }

    public static void launch(Activity activity, WalletModel walletModel, String str, boolean z, String str2, String str3, String str4) {
        Intent intent = new Intent(activity, (Class<?>) AmmeterWalletDetailActivity.class);
        intent.putExtra("extra_wallet", walletModel);
        intent.putExtra("deviceAddress", str);
        intent.putExtra(EXTRA_ORDER, z);
        intent.putExtra(EXTRA_MONEY, str3);
        intent.putExtra(EXTRA_ORDERID, str2);
        intent.putExtra("extra_userno", str4);
        activity.startActivity(intent);
    }

    /* JADX INFO: renamed from: client.android.yixiaotong.ui.ammeter.AmmeterWalletDetailActivity$1, reason: invalid class name */
    class AnonymousClass1 implements View.OnClickListener {
        AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AmmeterWalletDetailActivity.this.ammeterRecharger();
        }
    }

    /* JADX INFO: renamed from: client.android.yixiaotong.ui.ammeter.AmmeterWalletDetailActivity$2, reason: invalid class name */
    class AnonymousClass2 implements View.OnClickListener {
        AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!AmmeterWalletDetailActivity.this.isConnected()) {
                ToastUtils.show(AmmeterWalletDetailActivity.this.getContext(), "电表已断开，请重新连接");
                AmmeterWalletDetailActivity.this.finish();
            } else {
                AmmeterWalletDetailActivity ammeterWalletDetailActivity = AmmeterWalletDetailActivity.this;
                ammeterWalletDetailActivity.sendGetElectricityConsumptionData(ammeterWalletDetailActivity.mReceivedCode);
            }
        }
    }

    /* JADX INFO: renamed from: client.android.yixiaotong.ui.ammeter.AmmeterWalletDetailActivity$3, reason: invalid class name */
    class AnonymousClass3 implements View.OnClickListener {
        AnonymousClass3() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ClickUtils.isFastDoubleClick()) {
                return;
            }
            AmmeterWalletDetailActivity.this.showDialog();
            AmmeterWalletDetailActivity.this.isRealPay = true;
            AmmeterWalletDetailActivity.this.isFirstSelectOrder = false;
            AmmeterWalletDetailActivity.this.aliCharge();
        }
    }

    /* JADX INFO: renamed from: client.android.yixiaotong.ui.ammeter.AmmeterWalletDetailActivity$4, reason: invalid class name */
    class AnonymousClass4 implements View.OnClickListener {
        AnonymousClass4() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ClickUtils.isFastDoubleClick()) {
                return;
            }
            AmmeterWalletDetailActivity.this.showDialog();
            AmmeterWalletDetailActivity.this.isRealPay = true;
            AmmeterWalletDetailActivity.this.isFirstSelectOrder = false;
            if (AppUtils.isWeixinAvilible(AmmeterWalletDetailActivity.this.getActivity())) {
                AmmeterWalletDetailActivity.this.weixinCharge();
            } else {
                ToastUtils.show(AmmeterWalletDetailActivity.this.getContext(), "需要安装微信APP后，才可以使用微信支付通道！");
            }
        }
    }

    /* JADX INFO: renamed from: client.android.yixiaotong.ui.ammeter.AmmeterWalletDetailActivity$5, reason: invalid class name */
    class AnonymousClass5 implements View.OnClickListener {
        AnonymousClass5() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ClickUtils.isFastDoubleClick()) {
                return;
            }
            AmmeterWalletDetailActivity.this.showDialog();
            AmmeterWalletDetailActivity.this.isRealPay = true;
            AmmeterWalletDetailActivity.this.isFirstSelectOrder = false;
            AmmeterWalletDetailActivity.this.unionCharge();
        }
    }

    private void initTitleBar() {
        this.mVTitleBar.setTitleView("交电费");
        this.mVTitleBar.setLeftView(R.mipmap.back);
        this.mVTitleBar.setLeftViewOnClickBack(getActivity());
        if (this.mWalletModel.IsRefund == 1) {
            if (this.mWalletModel.refund != 1) {
                this.mVTitleBar.setRightView("申请退款");
            } else {
                this.mVTitleBar.setRightView("已申请退款");
            }
            this.mVTitleBar.setRightViewOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.ammeter.AmmeterWalletDetailActivity.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (AmmeterWalletDetailActivity.this.mWalletModel.refund != 1) {
                        Refund2Activity.launch(AmmeterWalletDetailActivity.this.getActivity(), AmmeterWalletDetailActivity.this.mWalletModel);
                    } else {
                        ToastUtils.show(AmmeterWalletDetailActivity.this.getContext(), "退款申请已提交，点击主页面的应用图标可查看退款进度");
                    }
                }
            });
        }
    }

    private void initView() {
        if (this.isHasOredr) {
            this.mRelOrder.setVisibility(0);
            this.mLinInputMoney.setVisibility(8);
            this.mLinInputMoney1.setVisibility(8);
            this.mRechargerAmmeter.setVisibility(0);
            this.mTvSubBalabce.setText(this.mOrderMoney);
            return;
        }
        this.mRelOrder.setVisibility(8);
        this.mLinInputMoney.setVisibility(0);
        this.mLinInputMoney1.setVisibility(0);
        this.mRechargerAmmeter.setVisibility(8);
    }

    private void initHandler() {
        this.mHandler = new Handler() { // from class: client.android.yixiaotong.ui.ammeter.AmmeterWalletDetailActivity.7
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 1) {
                    if (TimeOut.Scan == AmmeterWalletDetailActivity.this.mCurrentCheckTimeOut) {
                        AmmeterWalletDetailActivity.this.dismissDialog();
                        AmmeterWalletDetailActivity.this.mAmmeterBluetoothManager.disConnectAll();
                        AmmeterWalletDetailActivity.this.mAmmeterBluetoothManager.stopScan();
                        ToastUtils.show(AmmeterWalletDetailActivity.this.getActivity(), "无法搜索到您宿舍的电表，请靠近电表后重试！");
                        AmmeterWalletDetailActivity.this.finish();
                        return;
                    }
                    return;
                }
                if (message.what == 2) {
                    if (TimeOut.Connect == AmmeterWalletDetailActivity.this.mCurrentCheckTimeOut) {
                        AmmeterWalletDetailActivity.this.dismissDialog();
                        AmmeterBluetoothManager.getInstance().disConnectAll();
                        ToastUtils.show(AmmeterWalletDetailActivity.this.getActivity(), "连接超时，请靠近电表设备后重试");
                        AmmeterWalletDetailActivity.this.finish();
                        return;
                    }
                    return;
                }
                if (message.what == 4) {
                    if (TimeOut.WriteSetting == AmmeterWalletDetailActivity.this.mCurrentCheckTimeOut) {
                        AmmeterWalletDetailActivity.this.dismissDialog();
                        AmmeterBluetoothManager.getInstance().disConnectAll();
                        SystemErrorTip.getInstance().showTipDialog(AmmeterWalletDetailActivity.this.getActivity(), new SystemErrorTip.SystemErrorDialogListener() { // from class: client.android.yixiaotong.ui.ammeter.AmmeterWalletDetailActivity.7.1
                            @Override // client.android.yixiaotong.ui.dialog.SystemErrorTip.SystemErrorDialogListener
                            public void onConfirm() {
                                AmmeterWalletDetailActivity.this.finish();
                            }
                        }, "充值超时，可以在充值账单里面重新充值！");
                        return;
                    }
                    return;
                }
                if (message.what == 3) {
                    TimeOut timeOut = TimeOut.Connected;
                    TimeOut unused = AmmeterWalletDetailActivity.this.mCurrentCheckTimeOut;
                    return;
                }
                if (message.what == 5) {
                    if (AmmeterWalletDetailActivity.this.mMaterialDialog != null) {
                        AmmeterWalletDetailActivity.access$2310(AmmeterWalletDetailActivity.this);
                        if (AmmeterWalletDetailActivity.this.scanMessage > 0) {
                            AmmeterWalletDetailActivity.this.mMaterialDialog.setContent("正在搜索您宿舍的电表 " + AmmeterWalletDetailActivity.this.scanMessage + " 秒");
                            AmmeterWalletDetailActivity.this.mHandler.sendEmptyMessageDelayed(5, 1000L);
                            return;
                        }
                        return;
                    }
                    return;
                }
                if (message.what == 6) {
                    if (AmmeterWalletDetailActivity.this.mMaterialDialog != null) {
                        AmmeterWalletDetailActivity.access$2510(AmmeterWalletDetailActivity.this);
                        if (AmmeterWalletDetailActivity.this.connectMessage > 0) {
                            AmmeterWalletDetailActivity.this.mMaterialDialog.setContent("正在连接电表 " + AmmeterWalletDetailActivity.this.connectMessage + " 秒");
                            AmmeterWalletDetailActivity.this.mHandler.sendEmptyMessageDelayed(6, 1000L);
                            return;
                        }
                        return;
                    }
                    return;
                }
                if (message.what != 7 || AmmeterWalletDetailActivity.this.mMaterialDialog == null) {
                    return;
                }
                AmmeterWalletDetailActivity.access$2610(AmmeterWalletDetailActivity.this);
                if (AmmeterWalletDetailActivity.this.getDataMessage > 0) {
                    AmmeterWalletDetailActivity.this.mMaterialDialog.setContent("正在获取电表信息 " + AmmeterWalletDetailActivity.this.getDataMessage + " 秒");
                    AmmeterWalletDetailActivity.this.mHandler.sendEmptyMessageDelayed(7, 1000L);
                } else {
                    ToastUtils.show(AmmeterWalletDetailActivity.this.getActivity(), "获取电表数据超时！");
                    AmmeterWalletDetailActivity.this.finish();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ammeterRecharger() {
        if (!isConnected()) {
            ToastUtils.show(getContext(), "电表已断开，请重新连接");
            finish();
            return;
        }
        if (this.mState != State.opened) {
            ToastUtils.show(getContext(), "电表暂时无法充值，请找管理员初始化电表！");
            return;
        }
        if (StringUtils.isNotEmpty(this.mTvSubBalabce.getText().toString())) {
            int i = (int) Float.parseFloat(this.mTvSubBalabce.getText().toString());
            if (!isConnected()) {
                ToastUtils.show(getContext(), "电表已断开，请重新连接");
                finish();
                return;
            } else if (i <= 500) {
                shouquan();
                return;
            } else {
                ToastUtils.show(getContext(), "充值金额最低为1元，最高为500元");
                return;
            }
        }
        ToastUtils.show(getContext(), "请输入充值金额");
    }

    private void readAmmeterInfo() {
        final String randNumMaxStringNonO = RandomUtils.getRandNumMaxStringNonO(6);
        BusinessControllers.getInstance().ammeterDetails(getLoginAccount(), this.mUserNo, randNumMaxStringNonO, new BigDecimal(this.mTvAmmeterBalance.getText().toString()).multiply(new BigDecimal(100.0d)).intValue() + "", new BigDecimal(this.mTvKWH.getText().toString()).multiply(new BigDecimal(100.0d)).intValue() + "", new Listener<AmmeterEndBean>() { // from class: client.android.yixiaotong.ui.ammeter.AmmeterWalletDetailActivity.8
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, AmmeterEndBean ammeterEndBean, Object... objArr) {
                ammeterEndBean.rand.equals(randNumMaxStringNonO);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                SystemErrorTip.getInstance().showTipDialog(AmmeterWalletDetailActivity.this.getActivity(), clientException.getDetail());
            }
        });
    }

    private void ammeterAddress() {
        BusinessControllers.getInstance().ammeterGetRoomDetail(getLoginAccount(), new Listener<AmmeterRoomDetail>() { // from class: client.android.yixiaotong.ui.ammeter.AmmeterWalletDetailActivity.9
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, AmmeterRoomDetail ammeterRoomDetail, Object... objArr) {
                if (ammeterRoomDetail != null) {
                    AmmeterWalletDetailActivity.this.mTvDeviceName.setText(ammeterRoomDetail.School + ammeterRoomDetail.Region + ammeterRoomDetail.Building + ammeterRoomDetail.Floor + ammeterRoomDetail.Room);
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                SystemErrorTip.getInstance().showTipDialog(AmmeterWalletDetailActivity.this.getActivity(), clientException.getDetail());
            }
        });
    }

    private void selectOrder() {
        if (this.isHasOredr || !this.isRealPay || this.isFirstSelectOrder) {
            return;
        }
        if (this.mWalletModel.aliCharge == 0 || this.mWalletModel.unionCharge != 0) {
            this.isFirstSelectOrder = true;
            BusinessControllers.getInstance().ammeterSelectOrder(getLoginAccount(), this.mOrderId, new Listener<AmmeterOrderStateBean>() { // from class: client.android.yixiaotong.ui.ammeter.AmmeterWalletDetailActivity.10
                @Override // client.android.yixiaotong.controller.core.Listener
                public void onStart(Controller controller) {
                    AmmeterWalletDetailActivity.this.showDialog();
                    AmmeterWalletDetailActivity.this.mMaterialDialog.setContent("正在查询订单的支付状态...");
                }

                @Override // client.android.yixiaotong.controller.core.Listener
                public void onComplete(Controller controller, AmmeterOrderStateBean ammeterOrderStateBean, Object... objArr) {
                    if (AmmeterWalletDetailActivity.this.mState != State.none) {
                        if (!AmmeterWalletDetailActivity.this.isConnected()) {
                            ToastUtils.show(AmmeterWalletDetailActivity.this.getContext(), "电表已断开，请重新连接");
                            AmmeterWalletDetailActivity.this.dismissDialog();
                            AmmeterWalletDetailActivity.this.finish();
                        } else if (ammeterOrderStateBean.success == 1) {
                            AmmeterWalletDetailActivity.this.shouquan();
                        } else {
                            AmmeterWalletDetailActivity.this.dismissDialog();
                            ToastUtils.show(AmmeterWalletDetailActivity.this.getActivity(), ammeterOrderStateBean.Message);
                        }
                    }
                }

                @Override // client.android.yixiaotong.controller.core.Listener
                public void onFail(Controller controller, ClientException clientException) {
                    AmmeterWalletDetailActivity.this.dismissDialog();
                    SystemErrorTip.getInstance().showTipDialog(AmmeterWalletDetailActivity.this.getActivity(), clientException.getDetail());
                }
            });
        }
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        selectOrder();
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        AmmeterBluetoothManager.getInstance().stopScan();
        AmmeterBluetoothManager.getInstance().disConnectAll();
        clearHandler(this.handlersend, this.runnableSend);
        this.mCurrentCheckTimeOut = null;
        this.mHandler = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getDate(String str) {
        int i = 0;
        if (str.length() > 13) {
            String str2 = new SimpleDateFormat("yyyyMMddEEEEHHmmss").format(new Date());
            String[] strArr = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
            String str3 = "01";
            while (i < 7) {
                if (str2.substring(8, 11).equals(strArr[i])) {
                    str3 = "0" + i;
                }
                i++;
            }
            return str.substring(2, 8) + str3 + str.substring(8, 14);
        }
        String strReplace = new SimpleDateFormat("yyyyMMddEEEEHHmmss").format(new Date());
        String[] strArr2 = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        while (i < 7) {
            if (strReplace.substring(8, 11).equals(strArr2[i])) {
                strReplace = strReplace.replace(strReplace.substring(8, 11), "0" + i);
            }
            i++;
        }
        return strReplace.substring(2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void shouquan() {
        final String randNumMaxStringNonO = RandomUtils.getRandNumMaxStringNonO(6);
        BusinessControllers.getInstance().ammeterAuthorize(getLoginAccount(), getLoginAccount().getAccountManagetStore().getUserInfo().AreaId + "", 0, this.mUserNo, this.mWalletModel.typeId, 0, randNumMaxStringNonO, 1, this.mOrderId, new BigDecimal(this.mTvAmmeterBalance.getText().toString()).multiply(new BigDecimal(100.0d)).intValue() + "", new BigDecimal(this.mTvKWH.getText().toString()).multiply(new BigDecimal(100.0d)).intValue() + "", new Listener<AeemterAuthorizeBean>() { // from class: client.android.yixiaotong.ui.ammeter.AmmeterWalletDetailActivity.11
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                if (AmmeterWalletDetailActivity.this.isShowingDialog()) {
                    AmmeterWalletDetailActivity.this.mMaterialDialog.setContent("正在给电表充值中，请保持靠近电表不要离开，充值成功后再离开");
                } else {
                    AmmeterWalletDetailActivity.this.showDialog();
                    AmmeterWalletDetailActivity.this.mMaterialDialog.setContent("正在给电表充值中，请保持靠近电表不要离开，充值成功后再离开");
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, AeemterAuthorizeBean aeemterAuthorizeBean, Object... objArr) {
                String strDecrypt;
                if (aeemterAuthorizeBean.rand.equals(randNumMaxStringNonO) && StringUtils.isNotEmpty(aeemterAuthorizeBean.systemTime)) {
                    try {
                        strDecrypt = AESHelper.decrypt(aeemterAuthorizeBean.pay, StringUtils.asciiToString("121,107,116,95,50,48,49,55,95,64,37,48,50,48,95,87,90,81,73,84,83,84,89,85,73,74,104,100,48,56,48,50"));
                    } catch (Exception e) {
                        e.printStackTrace();
                        strDecrypt = null;
                    }
                    if (Integer.parseInt(strDecrypt) < 100 || Integer.parseInt(strDecrypt) > 50000) {
                        AmmeterWalletDetailActivity.this.dismissDialog();
                        ToastUtils.show(AmmeterWalletDetailActivity.this.getContext(), "充值金额最低为1元，最高为500元");
                        return;
                    }
                    AmmeterWalletDetailActivity ammeterWalletDetailActivity = AmmeterWalletDetailActivity.this;
                    ammeterWalletDetailActivity.sendWriteDateRechargeData(ammeterWalletDetailActivity.getDate(aeemterAuthorizeBean.systemTime), strDecrypt.substring(0, strDecrypt.length() - 2), AmmeterWalletDetailActivity.this.mReceivedCode);
                    AmmeterWalletDetailActivity.this.mCurrentCheckTimeOut = TimeOut.WriteSetting;
                    if (AmmeterWalletDetailActivity.this.mHandler != null) {
                        AmmeterWalletDetailActivity.this.mHandler.sendEmptyMessageDelayed(4, 8000L);
                    }
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                AmmeterWalletDetailActivity.this.dismissDialog();
                if (clientException.getCode() == 4080) {
                    AmmeterWalletDetailActivity.this.shouquanHistory(((AeemterAuthorizeBean) clientException.getObject()).orderid);
                } else {
                    SystemErrorTip.getInstance().showTipDialog(AmmeterWalletDetailActivity.this.getActivity(), new SystemErrorTip.SystemErrorDialogListener() { // from class: client.android.yixiaotong.ui.ammeter.AmmeterWalletDetailActivity.11.1
                        @Override // client.android.yixiaotong.ui.dialog.SystemErrorTip.SystemErrorDialogListener
                        public void onConfirm() {
                            AmmeterWalletDetailActivity.this.finish();
                        }
                    }, clientException.getDetail());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void shouquanHistory(String str) {
        final String randNumMaxStringNonO = RandomUtils.getRandNumMaxStringNonO(6);
        long j = getLoginAccount().getAccountManagetStore().getUserInfo().AreaId;
        int iIntValue = new BigDecimal(this.mTvAmmeterBalance.getText().toString()).multiply(new BigDecimal(100.0d)).intValue();
        int iIntValue2 = new BigDecimal(this.mTvKWH.getText().toString()).multiply(new BigDecimal(100.0d)).intValue();
        this.mOrderId = str;
        BusinessControllers.getInstance().ammeterAuthorize(getLoginAccount(), j + "", 0, this.mUserNo, this.mWalletModel.typeId, 0, randNumMaxStringNonO, 1, this.mOrderId, iIntValue + "", iIntValue2 + "", new Listener<AeemterAuthorizeBean>() { // from class: client.android.yixiaotong.ui.ammeter.AmmeterWalletDetailActivity.12
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                if (AmmeterWalletDetailActivity.this.isShowingDialog()) {
                    AmmeterWalletDetailActivity.this.mMaterialDialog.setContent("正在给电表充值中，请保持靠近电表不要离开，充值成功后再离开");
                } else {
                    AmmeterWalletDetailActivity.this.showDialog();
                    AmmeterWalletDetailActivity.this.mMaterialDialog.setContent("正在给电表充值中，请保持靠近电表不要离开，充值成功后再离开");
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, AeemterAuthorizeBean aeemterAuthorizeBean, Object... objArr) {
                String strDecrypt;
                if (aeemterAuthorizeBean.rand.equals(randNumMaxStringNonO) && StringUtils.isNotEmpty(aeemterAuthorizeBean.systemTime)) {
                    try {
                        strDecrypt = AESHelper.decrypt(aeemterAuthorizeBean.pay, StringUtils.asciiToString("121,107,116,95,50,48,49,55,95,64,37,48,50,48,95,87,90,81,73,84,83,84,89,85,73,74,104,100,48,56,48,50"));
                    } catch (Exception e) {
                        e.printStackTrace();
                        strDecrypt = null;
                    }
                    if (Integer.parseInt(strDecrypt) < 100 || Integer.parseInt(strDecrypt) > 50000) {
                        AmmeterWalletDetailActivity.this.dismissDialog();
                        ToastUtils.show(AmmeterWalletDetailActivity.this.getContext(), "充值金额最低为1元，最高为500元");
                        return;
                    }
                    AmmeterWalletDetailActivity ammeterWalletDetailActivity = AmmeterWalletDetailActivity.this;
                    ammeterWalletDetailActivity.sendWriteDateRechargeData(ammeterWalletDetailActivity.getDate(aeemterAuthorizeBean.systemTime), strDecrypt.substring(0, strDecrypt.length() - 2), AmmeterWalletDetailActivity.this.mReceivedCode);
                    AmmeterWalletDetailActivity.this.mCurrentCheckTimeOut = TimeOut.WriteSetting;
                    if (AmmeterWalletDetailActivity.this.mHandler != null) {
                        AmmeterWalletDetailActivity.this.mHandler.sendEmptyMessageDelayed(4, 8000L);
                    }
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                AmmeterWalletDetailActivity.this.dismissDialog();
                SystemErrorTip.getInstance().showTipDialog(AmmeterWalletDetailActivity.this.getActivity(), new SystemErrorTip.SystemErrorDialogListener() { // from class: client.android.yixiaotong.ui.ammeter.AmmeterWalletDetailActivity.12.1
                    @Override // client.android.yixiaotong.ui.dialog.SystemErrorTip.SystemErrorDialogListener
                    public void onConfirm() {
                        AmmeterWalletDetailActivity.this.finish();
                    }
                }, clientException.getDetail());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendGetDeviceInfoData() {
        this.mReceivedCode = "FF";
        String randNumMaxString = AmmeterRandomUtils.getRandNumMaxString(2);
        this.mSendCode = randNumMaxString;
        this.mAmmeterBluetoothManager.sendData(this.mAddress, HexString.hexToBuffer(AmmeterCommandUtils.getDeviceInfo(randNumMaxString)));
    }

    private void sendGetDeviceTypeStateUserNoBalanceEle(String str) {
        String randNumMaxString = AmmeterRandomUtils.getRandNumMaxString(2);
        this.mSendCode = randNumMaxString;
        this.mAmmeterBluetoothManager.sendData(this.mAddress, HexString.hexToBuffer(AmmeterCommandUtils.getDeviceTypeStateUserNoBalanceEle(str, randNumMaxString)));
    }

    private void sendGetBalanceData(String str) {
        String randNumMaxString = AmmeterRandomUtils.getRandNumMaxString(2);
        this.mSendCode = randNumMaxString;
        this.mAmmeterBluetoothManager.sendData(this.mAddress, HexString.hexToBuffer(AmmeterCommandUtils.getBalance(str, randNumMaxString)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendGetElectricityConsumptionData(String str) {
        String randNumMaxString = AmmeterRandomUtils.getRandNumMaxString(2);
        this.mSendCode = randNumMaxString;
        this.mAmmeterBluetoothManager.sendData(this.mAddress, HexString.hexToBuffer(AmmeterCommandUtils.getElectricityConsumption(str, randNumMaxString)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendWriteDateRechargeData(String str, String str2, String str3) {
        this.mSendCode = AmmeterRandomUtils.getRandNumMaxString(2);
        this.mAmmeterBluetoothManager.sendData(this.mAddress, HexString.hexToBuffer(AmmeterCommandUtils.writeDateAndRecharge(str, Short.parseShort(str2), str3, this.mSendCode)));
    }

    private void clearHandler(Handler handler, Runnable runnable) {
        if (handler != null) {
            handler.removeCallbacks(runnable);
        }
    }

    private void connetAmmeter() {
        this.mAmmeterBluetoothManager.disConnectAll();
        runOnUiThread(new Runnable() { // from class: client.android.yixiaotong.ui.ammeter.AmmeterWalletDetailActivity.14
            @Override // java.lang.Runnable
            public void run() {
                AmmeterWalletDetailActivity.this.mAmmeterBluetoothManager.connect(AmmeterWalletDetailActivity.this.mAddress);
                AmmeterWalletDetailActivity.this.mCurrentCheckTimeOut = TimeOut.Connect;
                if (AmmeterWalletDetailActivity.this.mHandler != null) {
                    AmmeterWalletDetailActivity.this.mHandler.sendEmptyMessageDelayed(2, ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT);
                }
            }
        }, 800L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialog() {
        try {
            dismissDialog();
            MaterialDialog materialDialogShow = new MaterialDialog.Builder(this).content("正在连接中...").progress(true, 0).dismissListener(new DialogInterface.OnDismissListener() { // from class: client.android.yixiaotong.ui.ammeter.AmmeterWalletDetailActivity.15
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                }
            }).show();
            this.mMaterialDialog = materialDialogShow;
            materialDialogShow.setCanceledOnTouchOutside(false);
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dismissDialog() {
        try {
            if (isShowingDialog()) {
                this.mMaterialDialog.dismiss();
                this.mMaterialDialog = null;
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isShowingDialog() {
        MaterialDialog materialDialog = this.mMaterialDialog;
        return materialDialog != null && materialDialog.isShowing();
    }

    @Override // client.android.yixiaotong.util.ammeterbluetooth.AmmeterBluetoothManager.Listener
    public void onDisconnected(String str) {
        dismissDialog();
        AmmeterBluetoothManager.getInstance().disConnectAll();
        ToastUtils.show(getContext(), "电表蓝牙信号不好，请重试");
    }

    @Override // client.android.yixiaotong.util.ammeterbluetooth.AmmeterBluetoothManager.Listener
    public void onConnectionFailed(String str) {
        dismissDialog();
        AmmeterBluetoothManager.getInstance().disConnectAll();
        ToastUtils.show(getContext(), "连接电表失败");
    }

    @Override // client.android.yixiaotong.util.ammeterbluetooth.AmmeterBluetoothManager.Listener
    public void onDeviceFound(String str) {
        if (StringUtils.isNotEmpty(str) && this.mAddress.equals(str) && !this.isFoundDevice) {
            this.isFoundDevice = true;
            MaterialDialog materialDialog = this.mMaterialDialog;
            if (materialDialog != null) {
                materialDialog.setContent("已经查找到您宿舍的电表...");
            }
            connetAmmeter();
            this.mAmmeterBluetoothManager.stopScan();
        }
    }

    @Override // client.android.yixiaotong.util.ammeterbluetooth.AmmeterBluetoothManager.Listener
    public void onConnectState(String str, boolean z) {
        this.mSupport = z;
        if (z) {
            if (isShowingDialog()) {
                this.mMaterialDialog.setContent("电表蓝牙匹配成功，正在连接电表...");
            }
            this.mCurrentCheckTimeOut = TimeOut.Connected;
            this.handlersend.postDelayed(this.runnableSend, 1000L);
        }
    }

    @Override // client.android.yixiaotong.util.ammeterbluetooth.AmmeterBluetoothManager.Listener
    public void onSendDataFailed() {
        dismissDialog();
        ToastUtils.show(getContext(), "数据发送失败！");
        finish();
    }

    @Override // client.android.yixiaotong.util.ammeterbluetooth.AmmeterBluetoothManager.Listener
    public void onBLEState(boolean z) {
        this.mConnected = z;
        this.mSupport = z;
        if (isConnected()) {
            showDialog();
            this.mMaterialDialog.setContent("正在获取电表信息 8 秒");
            this.mHandler.sendEmptyMessageDelayed(7, 1000L);
            sendGetDeviceInfoData();
            return;
        }
        this.isFoundDevice = false;
        this.mAmmeterBluetoothManager.disConnectAll();
        this.mAmmeterBluetoothManager.startScan();
        showDialog();
        this.mMaterialDialog.setContent("正在搜索电表...");
        this.mCurrentCheckTimeOut = TimeOut.Scan;
        this.mHandler.sendEmptyMessageDelayed(1, ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT);
    }

    @Override // client.android.yixiaotong.util.ammeterbluetooth.AmmeterBluetoothManager.Listener
    public void onDataReceived(String str, byte[] bArr) {
        String strDivide;
        String strDivide2;
        String strBufferToHex = HexString.bufferToHex(bArr);
        AmmeterCommandUtils.isConnectResult(strBufferToHex);
        if ("81".equals(strBufferToHex.substring(4, 6).toUpperCase())) {
            String upperCase = strBufferToHex.substring(0, 2).toUpperCase();
            this.mReceivedCode = upperCase;
            if (this.mSendCode.equals(upperCase)) {
                String upperCase2 = strBufferToHex.substring(2, 4).toUpperCase();
                this.mReceivedCode = upperCase2;
                sendGetDeviceTypeStateUserNoBalanceEle(upperCase2);
                return;
            }
            ToastUtils.show(getContext(), "校验码出错啦！");
            return;
        }
        if ("B3".equals(strBufferToHex.substring(4, 6))) {
            dismissDialog();
            String upperCase3 = strBufferToHex.substring(0, 2).toUpperCase();
            this.mReceivedCode = upperCase3;
            if (this.mSendCode.equals(upperCase3)) {
                this.mReceivedCode = strBufferToHex.substring(2, 4).toUpperCase();
                strBufferToHex.substring(6, 14);
                strBufferToHex.substring(14, 22);
                return;
            }
            ToastUtils.show(getContext(), "校验码出错啦！");
            return;
        }
        if ("B7".equals(strBufferToHex.substring(4, 6))) {
            this.getDataMessage = 0;
            dismissDialog();
            String upperCase4 = strBufferToHex.substring(0, 2).toUpperCase();
            this.mReceivedCode = upperCase4;
            if (this.mSendCode.equals(upperCase4)) {
                this.mReceivedCode = strBufferToHex.substring(2, 4).toUpperCase();
                if (Integer.toBinaryString(Integer.parseInt(strBufferToHex.substring(8, 10), 16)).length() < 8) {
                    this.mState = State.close;
                } else {
                    this.mState = State.opened;
                }
                String strSubstring = strBufferToHex.substring(10, 34);
                this.mUserNo = strSubstring;
                if (strSubstring.toUpperCase().contains("FFFFFFFF") || !this.mUserNo1.equals(this.mUserNo)) {
                    ToastUtils.show(getActivity(), "用户编号有异常，请联系管理员重新初始化电表");
                    finish();
                }
                String strSubstring2 = strBufferToHex.substring(35, 42);
                String upperCase5 = strBufferToHex.substring(34, 35).toUpperCase();
                short s = Short.parseShort(upperCase5, 16);
                if (s < 8) {
                    strDivide2 = DecimalUtil.divide(upperCase5 + strSubstring2, "100");
                } else {
                    strDivide2 = x.A + DecimalUtil.divide(((s - 8) + "") + strSubstring2, "100");
                }
                String strTwoDecimal = DecimalUtil.twoDecimal(strDivide2);
                this.mbalance = strTwoDecimal;
                this.mTvAmmeterBalance.setText(strTwoDecimal);
                StringBuilder sb = new StringBuilder();
                sb.append(Float.parseFloat(strBufferToHex.substring(42, 50)) / 100.0f);
                this.mTvKWH.setText(sb.toString());
                readAmmeterInfo();
                return;
            }
            ToastUtils.show(getContext(), "校验码出错啦！");
            return;
        }
        if ("8A".equals(strBufferToHex.substring(4, 6).toUpperCase())) {
            dismissDialog();
            String upperCase6 = strBufferToHex.substring(0, 2).toUpperCase();
            this.mReceivedCode = upperCase6;
            if (this.mSendCode.equals(upperCase6)) {
                this.mReceivedCode = strBufferToHex.substring(2, 4).toUpperCase();
                if (strBufferToHex.length() > 13) {
                    String strSubstring3 = strBufferToHex.substring(7, 14);
                    String upperCase7 = strBufferToHex.substring(6, 7).toUpperCase();
                    short s2 = Short.parseShort(upperCase7, 16);
                    if (s2 < 8) {
                        strDivide = DecimalUtil.divide(upperCase7 + strSubstring3, "100");
                    } else {
                        strDivide = x.A + DecimalUtil.divide(((s2 - 8) + "") + strSubstring3, "100");
                    }
                    String strTwoDecimal2 = DecimalUtil.twoDecimal(strDivide);
                    this.mbalance = strTwoDecimal2;
                    this.mTvAmmeterBalance.setText(strTwoDecimal2);
                    BusinessControllers.getInstance().ammeterEnd(getLoginAccount(), this.mOrderId, this.mUserNo, new BigDecimal(this.mTvAmmeterBalance.getText().toString()).multiply(new BigDecimal(100.0d)).intValue() + "", new BigDecimal(this.mTvKWH.getText().toString()).multiply(new BigDecimal(100.0d)).intValue() + "", new Listener<AmmeterEndBean>() { // from class: client.android.yixiaotong.ui.ammeter.AmmeterWalletDetailActivity.16
                        @Override // client.android.yixiaotong.controller.core.Listener
                        public void onComplete(Controller controller, AmmeterEndBean ammeterEndBean, Object... objArr) {
                        }

                        @Override // client.android.yixiaotong.controller.core.Listener
                        public void onStart(Controller controller) {
                        }

                        @Override // client.android.yixiaotong.controller.core.Listener
                        public void onFail(Controller controller, ClientException clientException) {
                            ToastUtils.show(AmmeterWalletDetailActivity.this.getActivity(), clientException.getDetail());
                        }
                    });
                    return;
                }
                return;
            }
            dismissDialog();
            ToastUtils.show(getContext(), "校验码出错啦！");
            return;
        }
        if ("B4".equals(strBufferToHex.substring(4, 6).toUpperCase())) {
            this.mCurrentCheckTimeOut = null;
            String upperCase8 = strBufferToHex.substring(0, 2).toUpperCase();
            this.mReceivedCode = upperCase8;
            if (this.mSendCode.equals(upperCase8)) {
                this.mReceivedCode = strBufferToHex.substring(2, 4).toUpperCase();
                this.mTvInputMoney.setText("");
                sendGetBalanceData(this.mReceivedCode);
            } else {
                dismissDialog();
                ToastUtils.show(getContext(), "校验码出错啦！");
            }
            if (isShowingDialog()) {
                this.mMaterialDialog.setContent("充值成功");
                return;
            }
            return;
        }
        if ("8B".equals(strBufferToHex.substring(4, 6).toUpperCase())) {
            this.mCurrentCheckTimeOut = null;
            String upperCase9 = strBufferToHex.substring(0, 2).toUpperCase();
            this.mReceivedCode = upperCase9;
            if (this.mSendCode.equals(upperCase9)) {
                this.mReceivedCode = strBufferToHex.substring(2, 4).toUpperCase();
                this.mTvInputMoney.setText("");
                sendGetBalanceData(this.mReceivedCode);
            } else {
                dismissDialog();
                ToastUtils.show(getContext(), "校验码出错啦！");
            }
            if (isShowingDialog()) {
                this.mMaterialDialog.setContent("充值成功");
                return;
            }
            return;
        }
        dismissDialog();
        String strSubstring4 = strBufferToHex.substring(4, 6);
        if (strSubstring4.toUpperCase().equals("C2")) {
            ToastUtils.show(getContext(), "获取设备类型和状态存在异常！");
        } else if (strSubstring4.toUpperCase().equals("F7")) {
            ToastUtils.show(getContext(), "备类型和状态用户编号余额用电量存在异常！");
        } else if (strSubstring4.toUpperCase().equals("C1")) {
            ToastUtils.show(getContext(), "获取设备信息存在异常！");
        } else if (strSubstring4.toUpperCase().equals("C3")) {
            ToastUtils.show(getContext(), "获取设备编号存在异常！");
        } else if (strSubstring4.toUpperCase().equals("CB") || strSubstring4.toUpperCase().equals("F4")) {
            this.mCurrentCheckTimeOut = null;
            ToastUtils.show(getContext(), "充值失败！");
        } else if (strSubstring4.toUpperCase().equals("F3")) {
            ToastUtils.show(getContext(), "获取购电记录失败！");
        } else if (strSubstring4.toUpperCase().equals("C5")) {
            ToastUtils.show(getContext(), "写入用户编号存在异常！");
        } else if (strSubstring4.toUpperCase().equals("CD")) {
            ToastUtils.show(getContext(), "获取设备信息存在异常！");
        } else if (strSubstring4.toUpperCase().equals("CC")) {
            ToastUtils.show(getContext(), "获取用电量存在异常！");
        } else if (strSubstring4.toUpperCase().equals("CA")) {
            ToastUtils.show(getContext(), "获取余额存在异常！");
        } else {
            ToastUtils.show(getContext(), "未知错误");
        }
        finish();
    }

    public void onClick0(View view) {
        setMoney("0");
    }

    public void onClick1(View view) {
        setMoney("1");
    }

    public void onClick2(View view) {
        setMoney("2");
    }

    public void onClick3(View view) {
        setMoney("3");
    }

    public void onClick4(View view) {
        setMoney("4");
    }

    public void onClick5(View view) {
        setMoney("5");
    }

    public void onClick6(View view) {
        setMoney("6");
    }

    public void onClick7(View view) {
        setMoney("7");
    }

    public void onClick8(View view) {
        setMoney("8");
    }

    public void onClick9(View view) {
        setMoney("9");
    }

    private void setMoney(String str) {
        this.mInputMoney = this.mTvInputMoney.getText().toString();
        this.mTvInputMoney.setText(this.mInputMoney + str);
    }

    public void onClick(View view) {
        if (this.mTvInputMoney.getText().toString().isEmpty()) {
            return;
        }
        this.mTvInputMoney.setText("");
    }

    public void onClickDel(View view) {
        String string = this.mTvInputMoney.getText().toString();
        this.mInputMoney = string;
        if (StringUtils.isNotEmpty(string)) {
            if (this.mInputMoney.length() > 1) {
                TextView textView = this.mTvInputMoney;
                String str = this.mInputMoney;
                textView.setText(str.substring(0, str.length() - 1));
            } else if (this.mInputMoney.length() == 1) {
                this.mTvInputMoney.setText("");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aliCharge() {
        if (!this.mTvInputMoney.getText().toString().isEmpty() && Integer.parseInt(this.mTvInputMoney.getText().toString()) > 0 && Integer.parseInt(this.mTvInputMoney.getText().toString()) <= 500) {
            if (this.mWalletModel.aliCharge != 0 && this.mWalletModel.unionCharge == 0) {
                BusinessControllers.getInstance().ammeterAliOrder(getLoginAccount(), getLoginAccount().getAccountManagetStore().getUserInfo().AreaId, getLoginAccount().getAccountManagetStore().getUserInfo().Mobile, this.mWalletModel.typeId, Build.MODEL.replace(PPSLabelView.Code, ""), Build.VERSION.SDK_INT + "", new BigDecimal(this.mTvInputMoney.getText().toString()).multiply(new BigDecimal(100.0d)).intValue(), new AnonymousClass17());
                return;
            }
            if (this.mWalletModel.aliCharge == 0 && this.mWalletModel.unionCharge != 0) {
                long j = getLoginAccount().getAccountManagetStore().getUserInfo().AreaId;
                String str = getLoginAccount().getAccountManagetStore().getUserInfo().Mobile;
                String strReplace = Build.MODEL.replace(PPSLabelView.Code, "");
                int i = Build.VERSION.SDK_INT;
                int iIntValue = new BigDecimal(this.mTvInputMoney.getText().toString()).multiply(new BigDecimal(100.0d)).intValue();
                final String str2 = iIntValue + "";
                BusinessControllers.getInstance().ammeterUnionAliOrder(getLoginAccount(), j, str, this.mWalletModel.typeId, strReplace, i + "", iIntValue, new Listener<UnionPayBean>() { // from class: client.android.yixiaotong.ui.ammeter.AmmeterWalletDetailActivity.18
                    @Override // client.android.yixiaotong.controller.core.Listener
                    public void onStart(Controller controller) {
                        AmmeterWalletDetailActivity.this.showDialog();
                    }

                    @Override // client.android.yixiaotong.controller.core.Listener
                    public void onComplete(Controller controller, final UnionPayBean unionPayBean, Object... objArr) {
                        String strOptString;
                        String strOptString2;
                        String strOptString3;
                        AmmeterWalletDetailActivity.this.dismissDialog();
                        if (unionPayBean != null) {
                            AmmeterWalletDetailActivity.this.mOrderId = unionPayBean.orderID;
                            try {
                                JSONObject jSONObject = new JSONObject(unionPayBean.settmentInfo);
                                strOptString = jSONObject.optString("settlementtype");
                                try {
                                    strOptString2 = jSONObject.optString("settlementparams");
                                    try {
                                        strOptString3 = jSONObject.optString("extraparams");
                                    } catch (JSONException e) {
                                        e = e;
                                        e.printStackTrace();
                                        strOptString3 = "";
                                    }
                                } catch (JSONException e2) {
                                    e = e2;
                                    strOptString2 = "";
                                }
                            } catch (JSONException e3) {
                                e = e3;
                                strOptString = "";
                                strOptString2 = strOptString;
                            }
                            HashMap map = new HashMap();
                            map.put("ordernumber", unionPayBean.orderID);
                            map.put(TtmlNode.TAG_BODY, "APP支付宝充值支付");
                            map.put("amount", str2);
                            map.put("businesstype", "2001");
                            map.put("paymenttypeid", "12");
                            if (StringUtils.isNotEmpty(strOptString3)) {
                                map.put("extraparams", strOptString3);
                            }
                            if (StringUtils.isNotEmpty(strOptString2) && unionPayBean.mainUnionCompanyId != unionPayBean.unionCompanyId) {
                                map.put("subcompanyid", unionPayBean.unionCompanyId + "");
                                map.put("settlementtype", strOptString);
                                map.put("settlementparams", strOptString2);
                            }
                            map.put("unionSession", unionPayBean.unionSession);
                            map.put("unionAppKey", unionPayBean.unionAppKey);
                            map.put("companyid", unionPayBean.mainUnionCompanyId + "");
                            VolleyRequestNew.postJson(true, ApiConfig.URL_PAY, map, new JSONResponseHandler() { // from class: client.android.yixiaotong.ui.ammeter.AmmeterWalletDetailActivity.18.1
                                @Override // com.masget.base.volley.JSONResponseHandler
                                public void onSuccess(JSONObject jSONObject2) {
                                    if (jSONObject2.optInt("ret") != 0) {
                                        AmmeterWalletDetailActivity.this.dismissDialog();
                                        ToastUtils.show(AmmeterWalletDetailActivity.this.getContext(), jSONObject2.optString(CrashHianalyticsData.MESSAGE));
                                        return;
                                    }
                                    try {
                                        String strOptString4 = new JSONObject(jSONObject2.optString("data")).optString("qrcode");
                                        if (StringUtils.isNotEmpty(strOptString4)) {
                                            LocalPreferencesHelper localPreferencesHelper = new LocalPreferencesHelper(AmmeterWalletDetailActivity.this.getContext(), "default_alipay_preferences");
                                            localPreferencesHelper.saveOrUpdate("paystate", "0");
                                            localPreferencesHelper.saveOrUpdate("payRespcode", "0");
                                            Intent intent = new Intent(AmmeterWalletDetailActivity.this.getActivity(), (Class<?>) AlipayActivity.class);
                                            intent.putExtra("qrcode", strOptString4);
                                            intent.putExtra("ordernumber", unionPayBean.orderID);
                                            intent.putExtra("mainUnionCompanyId", unionPayBean.mainUnionCompanyId + "");
                                            intent.putExtra("unionSession", unionPayBean.unionSession);
                                            intent.putExtra("unionAppKey", unionPayBean.unionAppKey);
                                            AmmeterWalletDetailActivity.this.startActivity(intent);
                                            AmmeterWalletDetailActivity.this.dismissDialog();
                                        }
                                    } catch (JSONException e4) {
                                        e4.printStackTrace();
                                    }
                                }

                                @Override // com.masget.base.volley.JSONResponseHandler
                                public void onFail(VolleyError volleyError) {
                                    AmmeterWalletDetailActivity.this.dismissDialog();
                                    ToastUtils.show(AmmeterWalletDetailActivity.this.getContext(), "下单失败");
                                }
                            });
                        }
                    }

                    @Override // client.android.yixiaotong.controller.core.Listener
                    public void onFail(Controller controller, ClientException clientException) {
                        AmmeterWalletDetailActivity.this.dismissDialog();
                        SystemErrorTip.getInstance().showTipDialog(AmmeterWalletDetailActivity.this.getActivity(), new SystemErrorTip.SystemErrorDialogListener() { // from class: client.android.yixiaotong.ui.ammeter.AmmeterWalletDetailActivity.18.2
                            @Override // client.android.yixiaotong.ui.dialog.SystemErrorTip.SystemErrorDialogListener
                            public void onConfirm() {
                                AmmeterWalletDetailActivity.this.finish();
                            }
                        }, clientException.getDetail());
                    }
                });
                return;
            }
            ToastUtils.show(getContext(), "支付宝和银联支付存在冲突");
            return;
        }
        dismissDialog();
        ToastUtils.show(getContext(), "最低充值金额为1元,最高充值金额为500元！");
    }

    /* JADX INFO: renamed from: client.android.yixiaotong.ui.ammeter.AmmeterWalletDetailActivity$17, reason: invalid class name */
    class AnonymousClass17 extends Listener<AmmeterAliPayBean> {
        @Override // client.android.yixiaotong.controller.core.Listener
        public void onStart(Controller controller) {
        }

        AnonymousClass17() {
        }

        @Override // client.android.yixiaotong.controller.core.Listener
        public void onComplete(Controller controller, AmmeterAliPayBean ammeterAliPayBean, Object... objArr) {
            AmmeterWalletDetailActivity.this.dismissDialog();
            if (ammeterAliPayBean != null) {
                AmmeterWalletDetailActivity.this.mOrderId = ammeterAliPayBean.orderid;
                AliPayUtils.pay(AmmeterWalletDetailActivity.this.getActivity(), ammeterAliPayBean.payInfo, new AliPayUtils.OnPayListener() { // from class: client.android.yixiaotong.ui.ammeter.AmmeterWalletDetailActivity.17.1
                    @Override // client.android.yixiaotong.alipay.AliPayUtils.OnPayListener
                    public void paySuccess() {
                        if (!AmmeterWalletDetailActivity.this.isConnected()) {
                            SystemErrorTip.getInstance().showTipDialog(AmmeterWalletDetailActivity.this.getActivity(), new SystemErrorTip.SystemErrorDialogListener() { // from class: client.android.yixiaotong.ui.ammeter.AmmeterWalletDetailActivity.17.1.1
                                @Override // client.android.yixiaotong.ui.dialog.SystemErrorTip.SystemErrorDialogListener
                                public void onConfirm() {
                                    AmmeterWalletDetailActivity.this.finish();
                                }
                            }, "电表已断开，请重新连接");
                        } else {
                            AmmeterWalletDetailActivity.this.shouquan();
                        }
                    }

                    @Override // client.android.yixiaotong.alipay.AliPayUtils.OnPayListener
                    public void payWaitting() {
                        ToastUtils.show(AmmeterWalletDetailActivity.this.getContext(), "正在等待支付结果,稍后会收到服务器确认的支付结果");
                    }

                    @Override // client.android.yixiaotong.alipay.AliPayUtils.OnPayListener
                    public void payFail() {
                        SystemErrorTip.getInstance().showTipDialog(AmmeterWalletDetailActivity.this.getActivity(), new SystemErrorTip.SystemErrorDialogListener() { // from class: client.android.yixiaotong.ui.ammeter.AmmeterWalletDetailActivity.17.1.2
                            @Override // client.android.yixiaotong.ui.dialog.SystemErrorTip.SystemErrorDialogListener
                            public void onConfirm() {
                                AmmeterWalletDetailActivity.this.finish();
                            }
                        }, "支付失败");
                    }
                });
                return;
            }
            SystemErrorTip.getInstance().showTipDialog(AmmeterWalletDetailActivity.this.getActivity(), new SystemErrorTip.SystemErrorDialogListener() { // from class: client.android.yixiaotong.ui.ammeter.AmmeterWalletDetailActivity.17.2
                @Override // client.android.yixiaotong.ui.dialog.SystemErrorTip.SystemErrorDialogListener
                public void onConfirm() {
                    AmmeterWalletDetailActivity.this.finish();
                }
            }, "下单失败");
        }

        @Override // client.android.yixiaotong.controller.core.Listener
        public void onFail(Controller controller, ClientException clientException) {
            AmmeterWalletDetailActivity.this.dismissDialog();
            SystemErrorTip.getInstance().showTipDialog(AmmeterWalletDetailActivity.this.getActivity(), new SystemErrorTip.SystemErrorDialogListener() { // from class: client.android.yixiaotong.ui.ammeter.AmmeterWalletDetailActivity.17.3
                @Override // client.android.yixiaotong.ui.dialog.SystemErrorTip.SystemErrorDialogListener
                public void onConfirm() {
                    AmmeterWalletDetailActivity.this.finish();
                }
            }, clientException.getDetail());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void weixinCharge() {
        if (!this.mTvInputMoney.getText().toString().isEmpty() && Integer.parseInt(this.mTvInputMoney.getText().toString()) > 0 && Integer.parseInt(this.mTvInputMoney.getText().toString()) <= 500) {
            BusinessControllers.getInstance().ammeterWeiXinOrder(getLoginAccount(), getLoginAccount().getAccountManagetStore().getUserInfo().AreaId, getLoginAccount().getAccountManagetStore().getUserInfo().Mobile, this.mWalletModel.typeId, Build.MODEL.replace(PPSLabelView.Code, ""), Build.VERSION.SDK_INT + "", new BigDecimal(this.mTvInputMoney.getText().toString()).multiply(new BigDecimal(100.0d)).intValue(), new Listener<AmmeterWeiXinPayBean>() { // from class: client.android.yixiaotong.ui.ammeter.AmmeterWalletDetailActivity.19
                @Override // client.android.yixiaotong.controller.core.Listener
                public void onStart(Controller controller) {
                }

                @Override // client.android.yixiaotong.controller.core.Listener
                public void onComplete(Controller controller, AmmeterWeiXinPayBean ammeterWeiXinPayBean, Object... objArr) {
                    AmmeterWalletDetailActivity.this.dismissDialog();
                    if (ammeterWeiXinPayBean != null) {
                        AmmeterWalletDetailActivity.this.mOrderId = ammeterWeiXinPayBean.orderid;
                        WxPayUtils.pay(AmmeterWalletDetailActivity.this.getActivity(), ammeterWeiXinPayBean.appid, ammeterWeiXinPayBean.partnerid, ammeterWeiXinPayBean.prepayid, ammeterWeiXinPayBean.noncestr, ammeterWeiXinPayBean.timestamp, ammeterWeiXinPayBean.sign);
                        return;
                    }
                    ToastUtils.show(AmmeterWalletDetailActivity.this.getContext(), "下单失败");
                }

                @Override // client.android.yixiaotong.controller.core.Listener
                public void onFail(Controller controller, ClientException clientException) {
                    AmmeterWalletDetailActivity.this.dismissDialog();
                    SystemErrorTip.getInstance().showTipDialog(AmmeterWalletDetailActivity.this.getActivity(), new SystemErrorTip.SystemErrorDialogListener() { // from class: client.android.yixiaotong.ui.ammeter.AmmeterWalletDetailActivity.19.1
                        @Override // client.android.yixiaotong.ui.dialog.SystemErrorTip.SystemErrorDialogListener
                        public void onConfirm() {
                            AmmeterWalletDetailActivity.this.finish();
                        }
                    }, clientException.getDetail());
                }
            });
            return;
        }
        dismissDialog();
        ToastUtils.show(getContext(), "最低充值金额为1元,最高充值金额为500元！");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void unionCharge() {
        if (!this.mTvInputMoney.getText().toString().isEmpty() && Integer.parseInt(this.mTvInputMoney.getText().toString()) > 0 && Integer.parseInt(this.mTvInputMoney.getText().toString()) <= 500) {
            showDialog();
            int iIntValue = new BigDecimal(this.mTvInputMoney.getText().toString()).multiply(new BigDecimal(100.0d)).intValue();
            final String str = iIntValue + "";
            BusinessControllers.getInstance().ammeterUnionAliOrder(getLoginAccount(), getLoginAccount().getAccountManagetStore().getUserInfo().AreaId, getLoginAccount().getAccountManagetStore().getUserInfo().Mobile, this.mWalletModel.typeId, Build.MODEL.replace(PPSLabelView.Code, ""), Build.VERSION.SDK_INT + "", iIntValue, new Listener<UnionPayBean>() { // from class: client.android.yixiaotong.ui.ammeter.AmmeterWalletDetailActivity.20
                @Override // client.android.yixiaotong.controller.core.Listener
                public void onStart(Controller controller) {
                }

                @Override // client.android.yixiaotong.controller.core.Listener
                public void onComplete(Controller controller, UnionPayBean unionPayBean, Object... objArr) {
                    String strOptString;
                    String strOptString2;
                    String strOptString3;
                    AmmeterWalletDetailActivity.this.mOrderId = unionPayBean.orderID;
                    try {
                        JSONObject jSONObject = new JSONObject(unionPayBean.settmentInfo);
                        strOptString = jSONObject.optString("settlementtype");
                        try {
                            strOptString2 = jSONObject.optString("settlementparams");
                            try {
                                strOptString3 = jSONObject.optString("extraparams");
                            } catch (JSONException e) {
                                e = e;
                                e.printStackTrace();
                                strOptString3 = "";
                            }
                        } catch (JSONException e2) {
                            e = e2;
                            strOptString2 = "";
                        }
                    } catch (JSONException e3) {
                        e = e3;
                        strOptString = "";
                        strOptString2 = strOptString;
                    }
                    HashMap map = new HashMap();
                    map.put("ordernumber", unionPayBean.orderID);
                    map.put(TtmlNode.TAG_BODY, "APP银联在线充值支付");
                    map.put("amount", str);
                    map.put("businesstype", "1001");
                    map.put("paymenttypeid", "4");
                    if (StringUtils.isNotEmpty(strOptString3)) {
                        map.put("extraparams", strOptString3);
                    }
                    if (StringUtils.isNotEmpty(strOptString2) && unionPayBean.mainUnionCompanyId != unionPayBean.unionCompanyId) {
                        map.put("subcompanyid", unionPayBean.unionCompanyId + "");
                        map.put("settlementtype", strOptString);
                        map.put("settlementparams", strOptString2);
                    }
                    map.put("unionSession", unionPayBean.unionSession);
                    map.put("unionAppKey", unionPayBean.unionAppKey);
                    map.put("companyid", unionPayBean.mainUnionCompanyId + "");
                    String strPostUrlEncrypt = VolleyRequestNew.postUrlEncrypt(ApiConfig.URL_PAY, map, true);
                    if (strPostUrlEncrypt == null) {
                        AmmeterWalletDetailActivity.this.dismissDialog();
                        ToastUtils.show(AmmeterWalletDetailActivity.this.getContext(), "获取订单失败");
                        return;
                    }
                    Intent intent = new Intent(AmmeterWalletDetailActivity.this.getActivity(), (Class<?>) UnionWebActivity.class);
                    intent.putExtra("url", strPostUrlEncrypt);
                    intent.putExtra("ordernumber", unionPayBean.orderID);
                    intent.putExtra("mainUnionCompanyId", unionPayBean.mainUnionCompanyId + "");
                    intent.putExtra("unionSession", unionPayBean.unionSession);
                    intent.putExtra("unionAppKey", unionPayBean.unionAppKey);
                    AmmeterWalletDetailActivity.this.startActivity(intent);
                    AmmeterWalletDetailActivity.this.dismissDialog();
                }

                @Override // client.android.yixiaotong.controller.core.Listener
                public void onFail(Controller controller, ClientException clientException) {
                    AmmeterWalletDetailActivity.this.dismissDialog();
                    SystemErrorTip.getInstance().showTipDialog(AmmeterWalletDetailActivity.this.getActivity(), new SystemErrorTip.SystemErrorDialogListener() { // from class: client.android.yixiaotong.ui.ammeter.AmmeterWalletDetailActivity.20.1
                        @Override // client.android.yixiaotong.ui.dialog.SystemErrorTip.SystemErrorDialogListener
                        public void onConfirm() {
                            AmmeterWalletDetailActivity.this.finish();
                        }
                    }, clientException.getDetail());
                }
            });
            return;
        }
        dismissDialog();
        ToastUtils.show(getContext(), "最低充值金额为1元,最高充值金额为500元！");
    }
}
