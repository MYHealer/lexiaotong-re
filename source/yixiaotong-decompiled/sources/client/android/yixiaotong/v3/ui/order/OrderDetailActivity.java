package client.android.yixiaotong.v3.ui.order;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.ui.RechargeRecordActivity;
import client.android.yixiaotong.ui.ammeter.AmmeterWalletDetailActivity;
import client.android.yixiaotong.ui.dialog.BaseMaterialDialog;
import client.android.yixiaotong.ui.dialog.SystemErrorTip;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.AppUtils;
import client.android.yixiaotong.util.DecimalUtil;
import client.android.yixiaotong.util.GsonUtils;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.util.executor.MainThreadExecutor;
import client.android.yixiaotong.util.permission.PermissionUtil;
import client.android.yixiaotong.v3.bean.login.OperationTime;
import client.android.yixiaotong.v3.bean.login.UseToolsJsonBean;
import client.android.yixiaotong.v3.bean.order.DeviceBehaviorJsonBean;
import client.android.yixiaotong.v3.bean.order.ExtendJsonBean;
import client.android.yixiaotong.v3.bean.order.NoPayOrderBean;
import client.android.yixiaotong.v3.bean.order.OrderDetailBean;
import client.android.yixiaotong.v3.bean.order.OrderMoreDetailBean;
import client.android.yixiaotong.v3.bean.order.SellCardStatusBaen;
import client.android.yixiaotong.v3.bean.wallet.WalletInfoBean;
import client.android.yixiaotong.v3.bluetoothutil.BluetoothControlUtil;
import client.android.yixiaotong.v3.http.V3BusinessControllers;
import client.android.yixiaotong.v3.ui.appcontrol.sellcard.SellCardControlUtil;
import client.android.yixiaotong.v3.ui.error.V3ErrorTipActivity;
import client.android.yixiaotong.v3.ui.scan.ScanQrcodeActivity;
import client.android.yixiaotong.v3.ui.scan.ZxingScanV3Activity;
import client.android.yixiaotong.v3.userinfo.InvestorInfoUtilControl;
import client.android.yixiaotong.v3.userinfo.UserInfoUtilControl;
import client.android.yixiaotong.v3.util.ClickUtil;
import client.android.yixiaotong.v3.util.LocalDataUtil;
import client.android.yixiaotong.v3.util.LogUtil;
import com.google.gson.reflect.TypeToken;
import com.stub.StubApp;
import java.math.BigDecimal;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class OrderDetailActivity extends BaseActivity {
    private static final String TAG = "OrderDetailActivity";
    private String mInvestorId;
    private NoPayOrderBean mNoPayOrderBean;
    private OrderDetailBean mOrderDetailBean;
    private String mOrderId;
    private RelativeLayout mRelBottom;
    private RelativeLayout mRelConsumeTime;
    private RelativeLayout mRelConsumerMoney;
    private RelativeLayout mRelDeviceName;
    private RelativeLayout mRelDiscount;
    private RelativeLayout mRelFinishTime;
    private RelativeLayout mRelMaichong1;
    private RelativeLayout mRelMaichong2;
    private RelativeLayout mRelMode;
    private RelativeLayout mRelPayPlan;
    private RelativeLayout mRelPayState;
    private RelativeLayout mRelPayWay;
    private RelativeLayout mRelPayable;
    private RelativeLayout mRelUse1;
    private RelativeLayout mRelUse2;
    private RelativeLayout mRelUsetime;
    private TitleBar mTitleBar;
    private TextView mTvConsumeMoney;
    private TextView mTvConsumeTime;
    private TextView mTvDeviceName;
    private TextView mTvDeviceNameText;
    private TextView mTvDiscountAmount;
    private TextView mTvFinishTime;
    private TextView mTvMaiChong1;
    private TextView mTvMaiChong2;
    private TextView mTvMaiChongText1;
    private TextView mTvMode;
    private TextView mTvModeText;
    private TextView mTvOrderDes;
    private TextView mTvOrderId;
    private TextView mTvPayMoney;
    private TextView mTvPayMoneyText;
    private TextView mTvPayTime;
    private TextView mTvPayWay;
    private TextView mTvPayflag;
    private TextView mTvState;
    private TextView mTvUse1;
    private TextView mTvUse2;
    private TextView mTvUseText1;
    private TextView mTvUseTime;
    private int mTypeId;
    private UseToolsJsonBean mUseToolsJsonBean;
    private View mVLinePayTime;
    private View mVLineUse1;
    private boolean mIsEnable = true;
    private int mPosUseSecond = 0;
    private PermissionUtil.PermissionGrant permissionGrant = new PermissionUtil.PermissionGrant() { // from class: client.android.yixiaotong.v3.ui.order.OrderDetailActivity.9
        @Override // client.android.yixiaotong.util.permission.PermissionUtil.PermissionGrant
        public void onPermissionGranted(int i) {
            if (i == 0) {
                PermissionUtil.requestPerssion(OrderDetailActivity.this.getActivity(), 1, OrderDetailActivity.this.permissionGrant);
            } else {
                if (i != 1) {
                    return;
                }
                if (AppUtils.isUserHuaWeiScan()) {
                    ScanQrcodeActivity.launch(OrderDetailActivity.this.getActivity(), 15);
                } else {
                    ZxingScanV3Activity.launch(OrderDetailActivity.this.getActivity(), 15);
                }
            }
        }
    };

    static {
        StubApp.interface11(10068);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public native void onRequestPermissionsResult(int i, String[] strArr, int[] iArr);

    public static void launch(Activity activity, NoPayOrderBean noPayOrderBean, int i) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) OrderDetailActivity.class).putExtra("bean1", noPayOrderBean).putExtra(RechargeRecordActivity.EXTRA_TYPEID, i));
        }
    }

    public static void launch(Activity activity, OrderDetailBean orderDetailBean, int i) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) OrderDetailActivity.class).putExtra("bean2", orderDetailBean).putExtra(RechargeRecordActivity.EXTRA_TYPEID, i));
        }
    }

    public static void launch(Activity activity, String str, int i) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) OrderDetailActivity.class).putExtra(AmmeterWalletDetailActivity.EXTRA_ORDERID, str).putExtra(RechargeRecordActivity.EXTRA_TYPEID, i));
        }
    }

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.titleBar);
        this.mTvOrderId = (TextView) findViewById(R.id.tv_orderid);
        this.mTvState = (TextView) findViewById(R.id.tv_state);
        this.mRelConsumeTime = (RelativeLayout) findViewById(R.id.rel_consumetime);
        this.mTvConsumeTime = (TextView) findViewById(R.id.tv_consumetime);
        this.mRelDeviceName = (RelativeLayout) findViewById(R.id.rel_devicename);
        this.mTvDeviceNameText = (TextView) findViewById(R.id.tv_devicenametext);
        this.mTvDeviceName = (TextView) findViewById(R.id.tv_devicename);
        this.mRelMode = (RelativeLayout) findViewById(R.id.rel_mode);
        this.mTvModeText = (TextView) findViewById(R.id.tv_modetext);
        this.mTvMode = (TextView) findViewById(R.id.tv_mode);
        this.mRelConsumerMoney = (RelativeLayout) findViewById(R.id.rel_consumemoney);
        this.mTvConsumeMoney = (TextView) findViewById(R.id.tv_consumemoney);
        this.mRelDiscount = (RelativeLayout) findViewById(R.id.rel_discount);
        this.mTvDiscountAmount = (TextView) findViewById(R.id.tv_discountamount);
        this.mRelPayable = (RelativeLayout) findViewById(R.id.rel_payable);
        this.mTvPayMoneyText = (TextView) findViewById(R.id.tv_paytext);
        this.mTvPayMoney = (TextView) findViewById(R.id.paymoney);
        this.mRelPayState = (RelativeLayout) findViewById(R.id.rel_paystate);
        this.mTvPayTime = (TextView) findViewById(R.id.tv_paytime);
        this.mVLinePayTime = findViewById(R.id.v_line5);
        this.mRelPayWay = (RelativeLayout) findViewById(R.id.rel_payway);
        this.mTvPayWay = (TextView) findViewById(R.id.tv_payway);
        this.mRelPayPlan = (RelativeLayout) findViewById(R.id.rel_payplan);
        this.mTvPayflag = (TextView) findViewById(R.id.tv_payflag);
        this.mRelFinishTime = (RelativeLayout) findViewById(R.id.rel_finishtime);
        this.mTvFinishTime = (TextView) findViewById(R.id.tv_finishtime);
        this.mRelBottom = (RelativeLayout) findViewById(R.id.rel_bottom);
        this.mRelUsetime = (RelativeLayout) findViewById(R.id.rel_usetime);
        this.mTvUseTime = (TextView) findViewById(R.id.tv_usetime);
        this.mRelMaichong1 = (RelativeLayout) findViewById(R.id.rel_maichong1);
        this.mTvMaiChongText1 = (TextView) findViewById(R.id.tv_maichongtext1);
        this.mTvMaiChong1 = (TextView) findViewById(R.id.tv_maichong1);
        this.mRelUse1 = (RelativeLayout) findViewById(R.id.rel_use1);
        this.mTvUseText1 = (TextView) findViewById(R.id.tv_usetext1);
        this.mTvUse1 = (TextView) findViewById(R.id.tv_use1);
        this.mVLineUse1 = findViewById(R.id.v_lineuse1);
        this.mRelMaichong2 = (RelativeLayout) findViewById(R.id.rel_maichong2);
        this.mTvMaiChong2 = (TextView) findViewById(R.id.tv_maichong2);
        this.mRelUse2 = (RelativeLayout) findViewById(R.id.rel_use2);
        this.mTvUse2 = (TextView) findViewById(R.id.tv_use2);
        this.mTvOrderDes = (TextView) findViewById(R.id.tv_orderdes);
    }

    private void initTitleBar() {
        this.mTitleBar.setTitleView(getString(R.string.orderdetails));
        this.mTitleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
    }

    private void initClickListeners() {
        findViewById(R.id.btn_takecard).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.order.OrderDetailActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m391x13120fc8(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$0$client-android-yixiaotong-v3-ui-order-OrderDetailActivity, reason: not valid java name */
    /* synthetic */ void m391x13120fc8(View view) {
        if (ClickUtil.isFastDoubleClick()) {
            return;
        }
        checkTakeCard();
    }

    private void initView() {
        if (this.mTypeId == 18) {
            this.mRelConsumerMoney.setVisibility(8);
            this.mRelDiscount.setVisibility(8);
            this.mRelPayable.setVisibility(8);
            this.mRelPayPlan.setVisibility(8);
            this.mVLineUse1.setVisibility(4);
            this.mVLinePayTime.setVisibility(4);
        }
        NoPayOrderBean noPayOrderBean = this.mNoPayOrderBean;
        if (noPayOrderBean != null) {
            this.mInvestorId = noPayOrderBean.investorId;
            this.mOrderId = this.mNoPayOrderBean.orderId;
            this.mTvOrderId.setText(getString(R.string.orderno) + this.mNoPayOrderBean.orderId);
            this.mTvState.setText(getString(R.string.nopay));
            this.mTvConsumeTime.setText(this.mNoPayOrderBean.posDateTime);
            this.mTvConsumeMoney.setText(getString(R.string.renminbi) + DecimalUtil.divide(this.mNoPayOrderBean.price + "", "100"));
            this.mRelDiscount.setVisibility(8);
            this.mRelPayState.setVisibility(8);
        } else {
            OrderDetailBean orderDetailBean = this.mOrderDetailBean;
            if (orderDetailBean != null) {
                this.mInvestorId = orderDetailBean.investorId;
                this.mOrderId = this.mOrderDetailBean.orderId;
                this.mTvOrderId.setText(getString(R.string.orderno) + this.mOrderDetailBean.orderId);
                if (this.mOrderDetailBean.payCode == 1) {
                    this.mTvState.setText(getString(R.string.payed));
                } else {
                    this.mTvState.setText(getString(R.string.nopay));
                }
                this.mTvConsumeTime.setText(this.mOrderDetailBean.posDateTime);
                this.mTvConsumeMoney.setText(getString(R.string.renminbi) + DecimalUtil.divide(this.mOrderDetailBean.posPrice + "", "100"));
                this.mTvDiscountAmount.setText(getString(R.string.renminbi) + DecimalUtil.divide(this.mOrderDetailBean.discountsPrice + "", "100"));
                this.mTvPayMoney.setText(getString(R.string.renminbi) + DecimalUtil.divide(this.mOrderDetailBean.payPrice + "", "100"));
                this.mTvPayTime.setText(this.mOrderDetailBean.posDateTime);
            } else {
                this.mInvestorId = InvestorInfoUtilControl.getInstance().getInvestorId();
            }
        }
        int i = this.mTypeId;
        if (i == 26 || i == 2) {
            this.mRelConsumeTime.setVisibility(8);
            this.mRelDeviceName.setVisibility(0);
        }
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.mIsEnable = true;
        SellCardControlUtil.getInstance().onResume();
        BluetoothControlUtil.getInstance().onResume();
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        this.mIsEnable = false;
        BaseMaterialDialog.dissmisMaterialDialog();
        SellCardControlUtil.getInstance().onPause();
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        BluetoothControlUtil.getInstance().onPause();
        SellCardControlUtil.getInstance().disconnect();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:15:0x0089  */
    public void getOrderIdInfo() {
        String str;
        String str2;
        int i;
        String str3;
        String schoolId = UserInfoUtilControl.getInstance().getSchoolId();
        if (this.mTypeId == 18) {
            String typeIdMachineId = LocalDataUtil.getTypeIdMachineId(getActivity(), 18);
            if (StringUtils.isNotEmpty(typeIdMachineId)) {
                if (typeIdMachineId.split(";").length >= 1) {
                    LogUtil.e(TAG, typeIdMachineId.split(";")[0] + "  " + typeIdMachineId.split(";")[1] + "  " + typeIdMachineId.split(";")[2]);
                    str3 = typeIdMachineId.split(";")[0];
                } else {
                    str3 = null;
                }
                if (typeIdMachineId.split(";").length >= 5) {
                    String str4 = typeIdMachineId.split(";")[3];
                    i = Integer.parseInt(typeIdMachineId.split(";")[4]);
                    str2 = str4;
                } else {
                    str2 = null;
                    i = -1;
                }
                str = str3;
            } else {
                str = null;
                str2 = null;
                i = -1;
            }
        } else {
            str = null;
            str2 = null;
            i = -1;
        }
        V3BusinessControllers.getInstance().getOrderIdInfo(getLoginAccount(), schoolId, this.mTypeId, this.mInvestorId, this.mOrderId, str, str2, i, new Listener<OrderMoreDetailBean>() { // from class: client.android.yixiaotong.v3.ui.order.OrderDetailActivity.1
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                super.onStart(controller);
                BaseMaterialDialog.showMaterialDialog(OrderDetailActivity.this.getActivity(), "获取订单信息.", false);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, OrderMoreDetailBean orderMoreDetailBean, Object... objArr) {
                super.onComplete(controller, orderMoreDetailBean, objArr);
                if (OrderDetailActivity.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    OrderDetailActivity.this.initResult(orderMoreDetailBean);
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (OrderDetailActivity.this.mIsEnable) {
                    OrderDetailActivity.this.onError(clientException);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initResult(OrderMoreDetailBean orderMoreDetailBean) {
        ExtendJsonBean extendJsonBean;
        if (StringUtils.isNotEmpty(orderMoreDetailBean.description)) {
            this.mTvOrderDes.setText(orderMoreDetailBean.description);
        }
        int i = this.mTypeId;
        if (i == 3) {
            this.mRelMode.setVisibility(0);
            this.mTvModeText.setText(getString(R.string.laundrymode));
            if (orderMoreDetailBean.deviceBehaviorJson != null) {
                try {
                    DeviceBehaviorJsonBean deviceBehaviorJsonBean = (DeviceBehaviorJsonBean) GsonUtils.getInstance().parse(new TypeToken<DeviceBehaviorJsonBean>() { // from class: client.android.yixiaotong.v3.ui.order.OrderDetailActivity.2
                    }.getType(), GsonUtils.getInstance().parseIfNull(orderMoreDetailBean.deviceBehaviorJson));
                    if (StringUtils.isNotEmpty(deviceBehaviorJsonBean.modeName)) {
                        this.mTvMode.setText(deviceBehaviorJsonBean.modeName);
                    } else if (deviceBehaviorJsonBean.functionMode == 1) {
                        this.mTvMode.setText(getString(R.string.dehydration));
                    } else if (deviceBehaviorJsonBean.functionMode == 2) {
                        this.mTvMode.setText(getString(R.string.expressservice));
                    } else if (deviceBehaviorJsonBean.functionMode == 3) {
                        this.mTvMode.setText(getString(R.string.standardwashing));
                    } else if (deviceBehaviorJsonBean.functionMode == 4) {
                        this.mTvMode.setText(getString(R.string.largeitemwashing));
                    }
                } catch (ClientException e) {
                    e.printStackTrace();
                }
            }
        } else if (i == 16) {
            this.mRelMode.setVisibility(0);
            this.mTvModeText.setText(getString(R.string.dryingmode));
            if (orderMoreDetailBean.deviceBehaviorJson != null) {
                try {
                    DeviceBehaviorJsonBean deviceBehaviorJsonBean2 = (DeviceBehaviorJsonBean) GsonUtils.getInstance().parse(new TypeToken<DeviceBehaviorJsonBean>() { // from class: client.android.yixiaotong.v3.ui.order.OrderDetailActivity.3
                    }.getType(), GsonUtils.getInstance().parseIfNull(orderMoreDetailBean.deviceBehaviorJson));
                    if (StringUtils.isNotEmpty(deviceBehaviorJsonBean2.modeName)) {
                        this.mTvMode.setText(deviceBehaviorJsonBean2.modeName);
                    } else if (deviceBehaviorJsonBean2.functionMode == 1) {
                        this.mTvMode.setText(getString(R.string.extradry));
                    } else if (deviceBehaviorJsonBean2.functionMode == 2) {
                        this.mTvMode.setText(getString(R.string.standard));
                    } else if (deviceBehaviorJsonBean2.functionMode == 3) {
                        this.mTvMode.setText(getString(R.string.quickdrying));
                    } else if (deviceBehaviorJsonBean2.functionMode == 4) {
                        this.mTvMode.setText(getString(R.string.overtime2));
                    }
                } catch (ClientException e2) {
                    e2.printStackTrace();
                }
            }
        } else if (i == 9) {
            if (orderMoreDetailBean.deviceBehaviorJson != null) {
                try {
                    SellCardStatusBaen sellCardStatusBaen = (SellCardStatusBaen) GsonUtils.getInstance().parse(new TypeToken<SellCardStatusBaen>() { // from class: client.android.yixiaotong.v3.ui.order.OrderDetailActivity.4
                    }.getType(), GsonUtils.getInstance().parseIfNull(orderMoreDetailBean.deviceBehaviorJson));
                    if (StringUtils.isNotEmpty(orderMoreDetailBean.orderType) && orderMoreDetailBean.orderType.equals("100")) {
                        this.mTvOrderDes.setTextColor(getResources().getColor(R.color.ffa1a6b3));
                        this.mRelFinishTime.setVisibility(8);
                        if (sellCardStatusBaen.sellCardStatus == 1) {
                            this.mTvOrderDes.setText(getString(R.string.cardsuccessfullyissued));
                            this.mRelFinishTime.setVisibility(0);
                            this.mTvFinishTime.setText(orderMoreDetailBean.upDateTime);
                        } else if (sellCardStatusBaen.sellCardStatus == 4) {
                            this.mTvOrderDes.setText(getString(R.string.pendingcard));
                            this.mTvOrderDes.setTextColor(getResources().getColor(R.color.fff9a437));
                            this.mRelBottom.setVisibility(0);
                        } else {
                            this.mTvOrderDes.setText("");
                            this.mRelBottom.setVisibility(8);
                        }
                    } else if (sellCardStatusBaen.sellCardStatus == 0) {
                        this.mTvOrderDes.setText(getString(R.string.unknowncardstatus));
                    } else if (sellCardStatusBaen.sellCardStatus == 1) {
                        this.mTvOrderDes.setText(getString(R.string.cardsuccessfullyissued));
                    } else if (sellCardStatusBaen.sellCardStatus == 2) {
                        this.mTvOrderDes.setText(getString(R.string.takecardfail));
                    } else if (sellCardStatusBaen.sellCardStatus == 3) {
                        this.mTvOrderDes.setText(getString(R.string.takecardfail2));
                    }
                } catch (ClientException e3) {
                    e3.printStackTrace();
                }
            }
            this.mRelConsumeTime.setVisibility(8);
        } else if (i == 26 || i == 2) {
            this.mTvOrderId.setText(getString(R.string.orderno) + orderMoreDetailBean.orderId);
            if (this.mTypeId == 2) {
                this.mTvDeviceNameText.setText(getString(R.string.productinformation));
            }
            this.mTvDeviceName.setText(orderMoreDetailBean.machineName);
            if (orderMoreDetailBean.payCode == 1) {
                this.mTvState.setText(getString(R.string.payed));
            } else {
                this.mTvState.setText(getString(R.string.nopay));
            }
            this.mTvConsumeMoney.setText(getString(R.string.renminbi) + DecimalUtil.divide(orderMoreDetailBean.posPrice + "", "100"));
            this.mTvDiscountAmount.setText(getString(R.string.renminbi) + DecimalUtil.divide(orderMoreDetailBean.discountsPrice + "", "100"));
            this.mTvPayMoney.setText(getString(R.string.renminbi) + DecimalUtil.divide(orderMoreDetailBean.payPrice + "", "100"));
            this.mTvPayTime.setText(orderMoreDetailBean.payDateTime);
        } else if (orderMoreDetailBean.deviceBehaviorJson != null) {
            if (this.mTypeId == 6) {
                List string2List = GsonUtils.getInstance().parseString2List(GsonUtils.getInstance().parseIfNull(orderMoreDetailBean.deviceBehaviorJson), DeviceBehaviorJsonBean.class);
                if (string2List != null && string2List.size() > 0) {
                    for (int i2 = 0; i2 < string2List.size() && string2List.get(i2) != null; i2++) {
                        if (StringUtils.isNotEmpty(((DeviceBehaviorJsonBean) string2List.get(i2)).drinkingValve) && string2List.size() == 2) {
                            if (DecimalUtil.decimalToInt(((DeviceBehaviorJsonBean) string2List.get(i2)).drinkingValve) == 1) {
                                if (StringUtils.isNotEmpty(((DeviceBehaviorJsonBean) string2List.get(i2)).posLitre)) {
                                    displayUseUI(1);
                                    if (((DeviceBehaviorJsonBean) string2List.get(i2)).posLitre.contains(".")) {
                                        this.mTvUse1.setText(((DeviceBehaviorJsonBean) string2List.get(i2)).posLitre.split("\\.")[0] + getString(R.string.ml));
                                    } else {
                                        this.mTvUse1.setText(((DeviceBehaviorJsonBean) string2List.get(i2)).posLitre + getString(R.string.ml));
                                    }
                                }
                                if (StringUtils.isNotEmpty(((DeviceBehaviorJsonBean) string2List.get(i2)).extendJson)) {
                                    try {
                                        this.mTvMaiChong1.setText(((ExtendJsonBean) GsonUtils.getInstance().parse(new TypeToken<ExtendJsonBean>() { // from class: client.android.yixiaotong.v3.ui.order.OrderDetailActivity.5
                                        }.getType(), ((DeviceBehaviorJsonBean) string2List.get(i2)).extendJson)).originalCount);
                                    } catch (ClientException e4) {
                                        e4.printStackTrace();
                                    }
                                }
                            } else {
                                if (StringUtils.isNotEmpty(((DeviceBehaviorJsonBean) string2List.get(i2)).posLitre)) {
                                    displayUseUI(2);
                                    if (((DeviceBehaviorJsonBean) string2List.get(i2)).posLitre.contains(".")) {
                                        this.mTvUse2.setText(((DeviceBehaviorJsonBean) string2List.get(i2)).posLitre.split("\\.")[0] + getString(R.string.ml));
                                    } else {
                                        this.mTvUse2.setText(((DeviceBehaviorJsonBean) string2List.get(i2)).posLitre + getString(R.string.ml));
                                    }
                                }
                                if (StringUtils.isNotEmpty(((DeviceBehaviorJsonBean) string2List.get(i2)).extendJson)) {
                                    try {
                                        this.mTvMaiChong2.setText(((ExtendJsonBean) GsonUtils.getInstance().parse(new TypeToken<ExtendJsonBean>() { // from class: client.android.yixiaotong.v3.ui.order.OrderDetailActivity.6
                                        }.getType(), ((DeviceBehaviorJsonBean) string2List.get(i2)).extendJson)).originalCount);
                                    } catch (ClientException e5) {
                                        e5.printStackTrace();
                                    }
                                }
                            }
                        } else {
                            if (StringUtils.isNotEmpty(((DeviceBehaviorJsonBean) string2List.get(i2)).posLitre)) {
                                displayUseUI(1);
                                if (((DeviceBehaviorJsonBean) string2List.get(i2)).posLitre.contains(".")) {
                                    this.mTvUse1.setText(((DeviceBehaviorJsonBean) string2List.get(i2)).posLitre.split("\\.")[0] + getString(R.string.ml));
                                } else {
                                    this.mTvUse1.setText(((DeviceBehaviorJsonBean) string2List.get(i2)).posLitre + getString(R.string.ml));
                                }
                            }
                            if (StringUtils.isNotEmpty(((DeviceBehaviorJsonBean) string2List.get(i2)).extendJson)) {
                                try {
                                    this.mTvMaiChong1.setText(((ExtendJsonBean) GsonUtils.getInstance().parse(new TypeToken<ExtendJsonBean>() { // from class: client.android.yixiaotong.v3.ui.order.OrderDetailActivity.7
                                    }.getType(), ((DeviceBehaviorJsonBean) string2List.get(i2)).extendJson)).originalCount);
                                } catch (ClientException e6) {
                                    e6.printStackTrace();
                                }
                            }
                        }
                        if (StringUtils.isNotEmpty(((DeviceBehaviorJsonBean) string2List.get(i2)).posUseSecond)) {
                            if (((DeviceBehaviorJsonBean) string2List.get(i2)).posGroup != null && ((DeviceBehaviorJsonBean) string2List.get(i2)).posGroup.intValue() == 2) {
                                this.mRelUsetime.setVisibility(0);
                            }
                            if (((DeviceBehaviorJsonBean) string2List.get(i2)).posUseSecond.contains(".")) {
                                Log.e(TAG, ((DeviceBehaviorJsonBean) string2List.get(i2)).posUseSecond);
                                this.mPosUseSecond += Integer.parseInt(((DeviceBehaviorJsonBean) string2List.get(i2)).posUseSecond.split("\\.")[0]);
                            } else {
                                this.mPosUseSecond += Integer.parseInt(((DeviceBehaviorJsonBean) string2List.get(i2)).posUseSecond);
                            }
                            this.mTvUseTime.setText(this.mPosUseSecond + getString(R.string.second));
                        }
                    }
                }
            } else if (orderMoreDetailBean.deviceBehaviorJson != null) {
                try {
                    DeviceBehaviorJsonBean deviceBehaviorJsonBean3 = (DeviceBehaviorJsonBean) GsonUtils.getInstance().parse(DeviceBehaviorJsonBean.class, GsonUtils.getInstance().parseIfNull(orderMoreDetailBean.deviceBehaviorJson));
                    if (deviceBehaviorJsonBean3 != null) {
                        if (StringUtils.isNotEmpty(deviceBehaviorJsonBean3.posUseSecond)) {
                            if (deviceBehaviorJsonBean3.posGroup != null && deviceBehaviorJsonBean3.posGroup.intValue() == 2) {
                                this.mRelUsetime.setVisibility(0);
                            }
                            LogUtil.e(TAG, getString(R.string.usetime2) + "：" + deviceBehaviorJsonBean3.posUseSecond);
                            if (deviceBehaviorJsonBean3.posUseSecond.contains(".")) {
                                this.mTvUseTime.setText(deviceBehaviorJsonBean3.posUseSecond.split("\\.")[0] + getString(R.string.second));
                            } else {
                                this.mTvUseTime.setText(deviceBehaviorJsonBean3.posUseSecond + getString(R.string.second));
                            }
                        }
                        if (StringUtils.isNotEmpty(deviceBehaviorJsonBean3.posLitre)) {
                            this.mTvUseText1.setText(getString(R.string.used3));
                            displayUseUI(1);
                            this.mTvUse1.setText((new BigDecimal(deviceBehaviorJsonBean3.posLitre).longValue() / 1000) + getString(R.string.l));
                            LogUtil.e(TAG, getString(R.string.used3) + "：" + deviceBehaviorJsonBean3.posLitre);
                        }
                        if (orderMoreDetailBean.discountsPrice != 0 && this.mTypeId != 18) {
                            this.mTvConsumeMoney.setText(getString(R.string.renminbi) + DecimalUtil.divide(orderMoreDetailBean.posPrice + "", "100"));
                            this.mRelDiscount.setVisibility(0);
                            this.mTvDiscountAmount.setText(getString(R.string.renminbi) + DecimalUtil.divide(orderMoreDetailBean.discountsPrice + "", "100"));
                            this.mTvPayMoney.setText(getString(R.string.renminbi) + DecimalUtil.divide(orderMoreDetailBean.payPrice + "", "100"));
                            this.mTvPayMoneyText.setText(getString(R.string.paid));
                        }
                        if (StringUtils.isNotEmpty(deviceBehaviorJsonBean3.extendJson) && (extendJsonBean = (ExtendJsonBean) GsonUtils.getInstance().parse(ExtendJsonBean.class, deviceBehaviorJsonBean3.extendJson)) != null && StringUtils.isNotEmpty(extendJsonBean.originalCount)) {
                            this.mTvMaiChong1.setText(extendJsonBean.originalCount);
                            this.mTvMaiChongText1.setText(getString(R.string.pulsecount));
                        }
                    }
                } catch (ClientException e7) {
                    e7.printStackTrace();
                }
            }
        }
        this.mTvPayTime.setText(orderMoreDetailBean.payDateTime);
        if (orderMoreDetailBean.payFlagType == 0) {
            this.mTvPayWay.setText(getString(R.string.walletpay));
        } else if (orderMoreDetailBean.payFlagType == 1) {
            this.mTvPayWay.setText(getString(R.string.weixin));
        } else if (orderMoreDetailBean.payFlagType == 2) {
            this.mTvPayWay.setText(getString(R.string.alipay));
        } else if (orderMoreDetailBean.payFlagType == 3) {
            this.mTvPayWay.setText(getString(R.string.unionpay));
        } else if (orderMoreDetailBean.payFlagType == 4) {
            this.mTvPayWay.setText(getString(R.string.longpay));
        } else if (orderMoreDetailBean.payFlagType == 21) {
            this.mTvPayWay.setText(getString(R.string.yulinonecard));
        } else {
            this.mTvPayWay.setText(getString(R.string.unknown));
        }
        if (orderMoreDetailBean != null) {
            switch (orderMoreDetailBean.paymentFlag) {
                case -2:
                    this.mTvPayflag.setText(getString(R.string.freeuse));
                    break;
                case -1:
                    this.mTvPayflag.setText("优惠全额付");
                    break;
                case 0:
                    this.mTvPayflag.setText(getString(R.string.walletpay));
                    break;
                case 1:
                    this.mTvPayflag.setText("单笔第三方支付");
                    this.mRelPayWay.setVisibility(0);
                    break;
                case 2:
                    this.mTvPayflag.setText("聚合支付");
                    break;
                case 3:
                    this.mTvPayflag.setText("一付一享");
                    this.mRelPayWay.setVisibility(0);
                    break;
                case 4:
                    this.mTvPayflag.setText("一享一付");
                    this.mRelPayWay.setVisibility(0);
                    break;
                case 5:
                    this.mTvPayflag.setText("支付宝水票");
                    break;
                case 6:
                    this.mTvPayflag.setText("预付费钱包");
                    break;
                case 7:
                    this.mTvPayflag.setText("正元一卡通");
                    break;
            }
        }
    }

    private void displayUseUI(int i) {
        if (i == 1) {
            UseToolsJsonBean useToolsJsonBean = this.mUseToolsJsonBean;
            if (useToolsJsonBean != null && useToolsJsonBean.useDeviceDisplay == 1) {
                this.mRelUse1.setVisibility(0);
                return;
            } else {
                this.mRelUse1.setVisibility(8);
                return;
            }
        }
        UseToolsJsonBean useToolsJsonBean2 = this.mUseToolsJsonBean;
        if (useToolsJsonBean2 != null && useToolsJsonBean2.useDeviceDisplay == 1) {
            this.mRelUse2.setVisibility(0);
        } else {
            this.mRelUse2.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onError(ClientException clientException) {
        if (clientException.isNeedTip(clientException.getCode())) {
            SystemErrorTip.getInstance().showTipDialog(getActivity(), new SystemErrorTip.SystemErrorDialogListener() { // from class: client.android.yixiaotong.v3.ui.order.OrderDetailActivity.8
                @Override // client.android.yixiaotong.ui.dialog.SystemErrorTip.SystemErrorDialogListener
                public void onConfirm() {
                    OrderDetailActivity.this.finish();
                }
            }, clientException.getDetail());
        } else {
            V3ErrorTipActivity.launch(getActivity(), this.mTitleBar.getTitleViewContent(), clientException.getDetail(), clientException.getCode(), 2, clientException.getSerial());
            finish();
        }
    }

    private void checkTakeCard() {
        int planFlag = InvestorInfoUtilControl.getInstance().getPlanFlag(9);
        if (checkIsOpenBluetooth()) {
            OperationTime operationTimeIsOpenTime = InvestorInfoUtilControl.getInstance().isOpenTime(9, planFlag);
            if (!operationTimeIsOpenTime.isOpen) {
                SellCardControlUtil.getInstance().showDialog(false, false, false, "暂停服务，开放时间为\n每日" + operationTimeIsOpenTime.openTime);
            } else {
                PermissionUtil.requestPerssion(getActivity(), 0, this.permissionGrant);
            }
        }
    }

    public boolean checkIsOpenBluetooth() {
        if (BluetoothAdapter.getDefaultAdapter().isEnabled()) {
            return true;
        }
        startActivityForResult(new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE"), 200);
        return false;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 200) {
            if (i2 != -1) {
                return;
            }
            checkTakeCard();
        } else {
            if (i2 != 15 || intent == null) {
                return;
            }
            final String stringExtra = intent.getStringExtra("qrcode");
            if (StringUtils.isNotEmpty(stringExtra) && stringExtra.length() >= 52) {
                MainThreadExecutor.getInstance().executeDelayed(new Runnable() { // from class: client.android.yixiaotong.v3.ui.order.OrderDetailActivity.10
                    @Override // java.lang.Runnable
                    public void run() {
                        SellCardControlUtil.getInstance().getAuthData(stringExtra);
                        SellCardControlUtil.getInstance().connectDecice(stringExtra);
                    }
                }, 200L);
            } else {
                ToastUtils.show(getActivity(), "不合法的二维码！" + stringExtra);
            }
        }
    }

    private void setListener() {
        SellCardControlUtil.getInstance().setListener(new SellCardControlUtil.OnListener() { // from class: client.android.yixiaotong.v3.ui.order.OrderDetailActivity.11
            @Override // client.android.yixiaotong.v3.ui.appcontrol.sellcard.SellCardControlUtil.OnListener
            public void onError(int i) {
            }

            @Override // client.android.yixiaotong.v3.ui.appcontrol.sellcard.SellCardControlUtil.OnListener
            public void onGetCardPrice(int i) {
            }

            @Override // client.android.yixiaotong.v3.ui.appcontrol.sellcard.SellCardControlUtil.OnListener
            public void onGetWalletInfo(WalletInfoBean walletInfoBean) {
            }

            @Override // client.android.yixiaotong.v3.ui.appcontrol.sellcard.SellCardControlUtil.OnListener
            public void onIsHasDevice(boolean z) {
            }

            @Override // client.android.yixiaotong.v3.ui.appcontrol.sellcard.SellCardControlUtil.OnListener
            public void onAuth() {
                if (OrderDetailActivity.this.mIsEnable) {
                    OrderDetailActivity.this.getOrderIdInfo();
                }
            }
        });
    }
}
