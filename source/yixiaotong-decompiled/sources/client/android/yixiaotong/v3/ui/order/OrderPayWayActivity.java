package client.android.yixiaotong.v3.ui.order;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.alipay.AliPayUtils;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.icbcPay.ICBCPayUtils;
import client.android.yixiaotong.ui.RechargeRecordActivity;
import client.android.yixiaotong.ui.dialog.BaseMaterialDialog;
import client.android.yixiaotong.ui.dialog.SystemErrorTip;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.ui.widget.WrapListView;
import client.android.yixiaotong.util.AppUtils;
import client.android.yixiaotong.util.DecimalUtil;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.util.permission.PermissionUtil;
import client.android.yixiaotong.v3.bean.login.InvestorInfoBean;
import client.android.yixiaotong.v3.bean.login.PayPaymentBean;
import client.android.yixiaotong.v3.bean.login.TypeInfoBean;
import client.android.yixiaotong.v3.bean.login.ZlPaymentJson;
import client.android.yixiaotong.v3.bean.order.NoPayOrderBean;
import client.android.yixiaotong.v3.bean.order.NoPayOrderListBean;
import client.android.yixiaotong.v3.bean.order.NoPayOrderResultBean;
import client.android.yixiaotong.v3.http.V3BusinessControllers;
import client.android.yixiaotong.v3.ui.dialog.ICBCPayWayDialog;
import client.android.yixiaotong.v3.ui.dialog.OrderDetailDialog;
import client.android.yixiaotong.v3.ui.error.V3ErrorTipActivity;
import client.android.yixiaotong.v3.ui.wallet.controlutil.V3WalletControlUtil;
import client.android.yixiaotong.v3.userinfo.InvestorInfoUtilControl;
import client.android.yixiaotong.v3.userinfo.UserInfoUtil;
import client.android.yixiaotong.v3.util.ClickUtil;
import client.android.yixiaotong.v3.util.LocalDataUtil;
import client.android.yixiaotong.v3.util.LogUtil;
import client.android.yixiaotong.wxapi.WxPayUtils;
import com.gnete.upbc.cashier.GnetePayConfig;
import com.icbc.paysdk.model.UnionPayReq;
import com.stub.StubApp;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class OrderPayWayActivity extends BaseActivity implements AdapterView.OnItemClickListener {
    private static final String TAG = "OrderPayWayActivity";
    private InvestorInfoBean mInvestorInfoBean;
    private boolean mIsEnable;
    private LinearLayout mLinPayWay;
    private WrapListView mLvRechargeWay;
    private int mOrderPayFlag;
    private int mOrderPayFlagType;
    private int mOrderPayPaymentFlag;
    private int mPayMoney;
    private int mPayPaymentFlag;
    private String mPayUrl;
    private RechargeWayAdapter mRechargeWayAdapter;
    private TitleBar mTitleBar;
    private TextView mTvPayMoney;
    private int mTypeId;
    private ZlPaymentJson mZlPaymentJson;
    private List<TypeInfoBean> mAppDatas = new ArrayList();
    private int mSelectWay = 0;
    private List<Integer> mPayFlagTypeList = new ArrayList();
    private List<PayPaymentBean> mPayPaymentBeanList = new ArrayList();
    private boolean mHasUnPayMergeOrder = false;
    private List<NoPayOrderBean> mNoPayRecordListBeans = new ArrayList();
    private boolean mIsNeedLoadOrder = false;
    private int mICBCIndex = 1;
    private PermissionUtil.PermissionGrant permissionGrant = new PermissionUtil.PermissionGrant() { // from class: client.android.yixiaotong.v3.ui.order.OrderPayWayActivity.7
        @Override // client.android.yixiaotong.util.permission.PermissionUtil.PermissionGrant
        public void onPermissionGranted(int i) {
            LogUtil.e(OrderPayWayActivity.TAG, "onPermissionGranted:" + i + "");
            if (i == 4 && ((Integer) OrderPayWayActivity.this.mPayFlagTypeList.get(OrderPayWayActivity.this.mSelectWay)).intValue() == 12) {
                ICBCPayWayDialog.getInstance().showDialog(OrderPayWayActivity.this.getActivity(), new ICBCPayWayDialog.Listener() { // from class: client.android.yixiaotong.v3.ui.order.OrderPayWayActivity.7.1
                    @Override // client.android.yixiaotong.v3.ui.dialog.ICBCPayWayDialog.Listener
                    public void onPay(int i2) {
                        OrderPayWayActivity.this.mICBCIndex = i2;
                        OrderPayWayActivity.this.mHasUnPayMergeOrder = false;
                        OrderPayWayActivity.this.payOrders();
                    }
                }, DecimalUtil.divide(OrderPayWayActivity.this.mPayMoney + "", "100"));
            }
        }
    };

    static {
        StubApp.interface11(10081);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public native void onRequestPermissionsResult(int i, String[] strArr, int[] iArr);

    public static void launch(Activity activity, int i, int i2, List<NoPayOrderBean> list) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) OrderPayWayActivity.class).putExtra(RechargeRecordActivity.EXTRA_TYPEID, i).putExtra("paymoney", i2).putExtra("orders", (Serializable) list));
        }
    }

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.titleBar);
        this.mTvPayMoney = (TextView) findViewById(R.id.tv_paymoney);
        this.mLinPayWay = (LinearLayout) findViewById(R.id.lin_payway);
        this.mLvRechargeWay = (WrapListView) findViewById(R.id.listview);
    }

    private void initTitleBar() {
        this.mTitleBar.setTitleView("确认支付");
        this.mTitleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
    }

    private void initView() {
        this.mTvPayMoney.setText("¥" + DecimalUtil.divide(this.mPayMoney + "", "100"));
        this.mRechargeWayAdapter = new RechargeWayAdapter();
        this.mLvRechargeWay.setOnItemClickListener(this);
        this.mLvRechargeWay.setAdapter((ListAdapter) this.mRechargeWayAdapter);
        this.mRechargeWayAdapter.notifyDataSetChanged();
    }

    private void initData() {
        InvestorInfoBean investorInfoBean = InvestorInfoUtilControl.getInstance().getInvestorInfoBean();
        this.mInvestorInfoBean = investorInfoBean;
        if (investorInfoBean != null) {
            List<TypeInfoBean> typeInfoBeans = InvestorInfoUtilControl.getInstance().getTypeInfoBeans();
            this.mAppDatas = typeInfoBeans;
            if (typeInfoBeans.size() > 0) {
                getPayment();
            }
        }
        this.mRechargeWayAdapter.notifyDataSetChanged();
    }

    private void getPayment() {
        this.mZlPaymentJson = InvestorInfoUtilControl.getInstance().getZlPaymentJson(this.mTypeId);
        this.mPayPaymentFlag = InvestorInfoUtilControl.getInstance().getPayPaymentFlag(this.mTypeId);
        this.mPayFlagTypeList.clear();
        this.mPayPaymentBeanList.clear();
        if (this.mZlPaymentJson != null) {
            for (int i = 0; i < this.mZlPaymentJson.payPaymentList.size(); i++) {
                LogUtil.e(TAG, "getPayment:" + i + "  " + this.mZlPaymentJson.payPaymentList.get(i).payFlag + "  " + this.mZlPaymentJson.payPaymentList.get(i).payFlagType);
                if (this.mZlPaymentJson.payPaymentList.get(i).payFlag == 1) {
                    this.mPayFlagTypeList.add(Integer.valueOf(this.mZlPaymentJson.payPaymentList.get(i).payFlagType));
                    this.mPayPaymentBeanList.add(this.mZlPaymentJson.payPaymentList.get(i));
                }
            }
        }
        if (this.mPayFlagTypeList.size() == 0) {
            this.mLinPayWay.setVisibility(4);
        } else {
            this.mLinPayWay.setVisibility(0);
        }
    }

    private void initClickListeners() {
        findViewById(R.id.btn_pay).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.order.OrderPayWayActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m392x2a22c29e(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$0$client-android-yixiaotong-v3-ui-order-OrderPayWayActivity, reason: not valid java name */
    /* synthetic */ void m392x2a22c29e(View view) {
        LogUtil.e(TAG, "Pay button clicked");
        handlePayment();
    }

    private void handlePayment() {
        if (ClickUtil.isFastDoubleClick()) {
            return;
        }
        if (this.mPayFlagTypeList.size() > 0 && this.mPayFlagTypeList.get(this.mSelectWay).intValue() == 12) {
            ToastUtils.show(getActivity(), "请选择支付方式");
        } else {
            this.mHasUnPayMergeOrder = false;
            payOrders();
        }
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.mIsEnable = true;
        if (this.mIsNeedLoadOrder) {
            getNoPayRecord();
        }
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        this.mIsEnable = false;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (ClickUtil.isFastDoubleClick()) {
            return;
        }
        this.mSelectWay = i;
        this.mRechargeWayAdapter.notifyDataSetChanged();
        if (this.mPayFlagTypeList.get(this.mSelectWay).intValue() == 12) {
            PermissionUtil.requestPerssion(getActivity(), 4, this.permissionGrant);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:25:0x00ee  */
    public void payOrders() {
        int i;
        int i2;
        String str;
        String str2;
        int i3;
        String str3;
        String str4 = UserInfoUtil.getInstance().getLoginAccountV3().schoolInfoList.get(UserInfoUtil.getInstance().getSchoolInfosIndex()).id + "";
        if (this.mZlPaymentJson == null) {
            ToastUtils.show(getContext(), "未配置单笔支付方案");
            return;
        }
        int i4 = this.mPayPaymentFlag;
        if (this.mPayPaymentBeanList.size() > 0) {
            i = this.mPayPaymentBeanList.get(this.mSelectWay).payFlag;
            i2 = this.mPayPaymentBeanList.get(this.mSelectWay).payFlagType;
        } else {
            i = 0;
            i2 = 0;
        }
        if (this.mHasUnPayMergeOrder) {
            i4 = this.mOrderPayPaymentFlag;
            i = this.mOrderPayFlag;
            i2 = this.mOrderPayFlagType;
        }
        int i5 = i4;
        int i6 = i;
        int i7 = i2;
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
                    String str5 = typeIdMachineId.split(";")[3];
                    i3 = Integer.parseInt(typeIdMachineId.split(";")[4]);
                    str = str3;
                    str2 = str5;
                } else {
                    str = str3;
                    str2 = null;
                }
            } else {
                str = null;
                str2 = null;
            }
            i3 = -1;
        } else {
            str = null;
            str2 = null;
            i3 = -1;
        }
        V3BusinessControllers.getInstance().postPayOrders(getLoginAccount(), str4, this.mInvestorInfoBean.investorId, i5, i6, i7, this.mNoPayRecordListBeans, str, str2, i3, new Listener<NoPayOrderResultBean>() { // from class: client.android.yixiaotong.v3.ui.order.OrderPayWayActivity.1
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                BaseMaterialDialog.showMaterialDialog(OrderPayWayActivity.this.getActivity(), "请求支付中..", false);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, final NoPayOrderResultBean noPayOrderResultBean, Object... objArr) {
                if (OrderPayWayActivity.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    if (noPayOrderResultBean == null) {
                        ToastUtils.show(OrderPayWayActivity.this.getContext(), "数据异常");
                        return;
                    }
                    if (noPayOrderResultBean.statusFlag == 2) {
                        ToastUtils.show(OrderPayWayActivity.this.getContext(), "钱包支付成功！");
                        OrderPayWayActivity.this.finish();
                        return;
                    }
                    if (noPayOrderResultBean.statusFlag == 0) {
                        ToastUtils.show(OrderPayWayActivity.this.getContext(), "支付成功！");
                        OrderPayWayActivity.this.finish();
                    } else {
                        if (noPayOrderResultBean.hasUnPayMergeOrder) {
                            if (OrderPayWayActivity.this.mHasUnPayMergeOrder) {
                                SystemErrorTip.getInstance().showTipDialog(OrderPayWayActivity.this.getActivity(), noPayOrderResultBean.msg);
                                return;
                            } else {
                                OrderDetailDialog.getInstance().showDialog(OrderPayWayActivity.this.getActivity(), new OrderDetailDialog.Listener() { // from class: client.android.yixiaotong.v3.ui.order.OrderPayWayActivity.1.1
                                    @Override // client.android.yixiaotong.v3.ui.dialog.OrderDetailDialog.Listener
                                    public void onConfirm() {
                                        OrderPayWayActivity.this.mHasUnPayMergeOrder = true;
                                        OrderPayWayActivity.this.mNoPayRecordListBeans.clear();
                                        OrderPayWayActivity.this.mNoPayRecordListBeans.addAll(noPayOrderResultBean.orderInfo);
                                        OrderPayWayActivity.this.mOrderPayPaymentFlag = noPayOrderResultBean.paymentFlag;
                                        OrderPayWayActivity.this.mOrderPayFlag = noPayOrderResultBean.payFlag;
                                        OrderPayWayActivity.this.mOrderPayFlagType = noPayOrderResultBean.payFlagType;
                                        OrderPayWayActivity.this.payOrders();
                                    }

                                    @Override // client.android.yixiaotong.v3.ui.dialog.OrderDetailDialog.Listener
                                    public void onCancle() {
                                        OrderPayWayActivity.this.cancelOrder();
                                    }
                                }, noPayOrderResultBean.totalPrice, noPayOrderResultBean.mergeOrderId, noPayOrderResultBean.createTime);
                                return;
                            }
                        }
                        OrderPayWayActivity.this.pay(noPayOrderResultBean);
                    }
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (OrderPayWayActivity.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    OrderPayWayActivity.this.onError(clientException);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pay(NoPayOrderResultBean noPayOrderResultBean) {
        String str = "";
        if (noPayOrderResultBean.payInfo != null && (StringUtils.isNotEmpty(noPayOrderResultBean.payInfo.tradeNo) || StringUtils.isNotEmpty(noPayOrderResultBean.payInfo.orderString))) {
            if (noPayOrderResultBean.payInfo.mode == 0) {
                str = noPayOrderResultBean.payInfo.orderString;
            } else if (noPayOrderResultBean.payInfo.mode == 1) {
                str = noPayOrderResultBean.payInfo.tradeNo;
            }
            AliPayUtils.pay(getActivity(), str, new AliPayUtils.OnPayListener() { // from class: client.android.yixiaotong.v3.ui.order.OrderPayWayActivity.2
                @Override // client.android.yixiaotong.alipay.AliPayUtils.OnPayListener
                public void paySuccess() {
                    ToastUtils.show(OrderPayWayActivity.this.getContext(), "支付成功");
                    OrderPayWayActivity.this.finish();
                }

                @Override // client.android.yixiaotong.alipay.AliPayUtils.OnPayListener
                public void payWaitting() {
                    ToastUtils.show(OrderPayWayActivity.this.getContext(), "正在等待支付结果,稍后会收到服务器确认的支付结果");
                }

                @Override // client.android.yixiaotong.alipay.AliPayUtils.OnPayListener
                public void payFail() {
                    ToastUtils.show(OrderPayWayActivity.this.getContext(), "支付失败");
                }
            });
            return;
        }
        if (noPayOrderResultBean.payInfo != null && StringUtils.isNotEmpty(noPayOrderResultBean.payInfo.appid)) {
            this.mIsNeedLoadOrder = true;
            WxPayUtils.pay(getActivity(), noPayOrderResultBean.payInfo.appid, noPayOrderResultBean.payInfo.partnerid, noPayOrderResultBean.payInfo.prepayid, noPayOrderResultBean.payInfo.noncestr, noPayOrderResultBean.payInfo.timestamp, noPayOrderResultBean.payInfo.sign);
            return;
        }
        if (noPayOrderResultBean.payInfo != null && noPayOrderResultBean.payInfo.msgBody != null) {
            if (noPayOrderResultBean.payInfo.msgBody.retCode.equals("00000")) {
                GnetePayConfig.builder().createWXAPI(getActivity(), "wxd9320c1760b6d01f");
                V3WalletControlUtil.getInstance().sendPayRequest(noPayOrderResultBean.payInfo.msgBody.chnlUrl, 0, this.mTypeId);
                return;
            } else {
                SystemErrorTip.getInstance().showTipDialog(getActivity(), noPayOrderResultBean.payInfo.msgBody.retMsg);
                return;
            }
        }
        if (noPayOrderResultBean.payInfo != null && StringUtils.isNotEmpty(noPayOrderResultBean.payInfo.tranData) && StringUtils.isNotEmpty(noPayOrderResultBean.payInfo.merSignMsg)) {
            payICBC(noPayOrderResultBean);
            return;
        }
        String str2 = null;
        if (noPayOrderResultBean.payInfo != null && StringUtils.isNotEmpty(noPayOrderResultBean.payInfo.pay_url)) {
            this.mIsNeedLoadOrder = true;
            if (AppUtils.checkAliPayInstalled(getActivity())) {
                try {
                    str2 = "alipays://platformapi/startapp?appId=20000067&url=" + URLEncoder.encode(noPayOrderResultBean.payInfo.pay_url, "UTF-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str2)));
                return;
            }
            ToastUtils.show(getContext(), "需要下载安装支付宝APP后才能进行支付");
            return;
        }
        List<PayPaymentBean> list = this.mPayPaymentBeanList;
        if (list != null && list.size() > 0 && this.mPayPaymentBeanList.get(this.mSelectWay) != null) {
            if (noPayOrderResultBean.payInfo != null) {
                if (this.mPayPaymentBeanList.get(this.mSelectWay).payFlagType == 1) {
                    this.mIsNeedLoadOrder = true;
                    WxPayUtils.pay(getActivity(), noPayOrderResultBean.payInfo.appid, noPayOrderResultBean.payInfo.partnerid, noPayOrderResultBean.payInfo.prepayid, noPayOrderResultBean.payInfo.noncestr, noPayOrderResultBean.payInfo.timestamp, noPayOrderResultBean.payInfo.sign);
                    return;
                }
                if (this.mPayPaymentBeanList.get(this.mSelectWay).payFlagType == 2) {
                    if (noPayOrderResultBean.payInfo.mode == 0) {
                        str = noPayOrderResultBean.payInfo.orderString;
                    } else if (noPayOrderResultBean.payInfo.mode == 1) {
                        str = noPayOrderResultBean.payInfo.tradeNo;
                    }
                    AliPayUtils.pay(getActivity(), str, new AliPayUtils.OnPayListener() { // from class: client.android.yixiaotong.v3.ui.order.OrderPayWayActivity.3
                        @Override // client.android.yixiaotong.alipay.AliPayUtils.OnPayListener
                        public void paySuccess() {
                            ToastUtils.show(OrderPayWayActivity.this.getContext(), "支付成功");
                            OrderPayWayActivity.this.finish();
                        }

                        @Override // client.android.yixiaotong.alipay.AliPayUtils.OnPayListener
                        public void payWaitting() {
                            ToastUtils.show(OrderPayWayActivity.this.getContext(), "正在等待支付结果,稍后会收到服务器确认的支付结果");
                        }

                        @Override // client.android.yixiaotong.alipay.AliPayUtils.OnPayListener
                        public void payFail() {
                            ToastUtils.show(OrderPayWayActivity.this.getContext(), "支付失败");
                        }
                    });
                    return;
                }
                if (this.mPayPaymentBeanList.get(this.mSelectWay).payFlagType == 3) {
                    if (noPayOrderResultBean.payInfo != null && noPayOrderResultBean.payInfo.msgBody != null && noPayOrderResultBean.payInfo.msgBody.retCode.equals("00000")) {
                        GnetePayConfig.builder().createWXAPI(getActivity(), "wxd9320c1760b6d01f");
                        V3WalletControlUtil.getInstance().sendPayRequest(noPayOrderResultBean.payInfo.msgBody.chnlUrl, 0, this.mTypeId);
                        this.mIsNeedLoadOrder = true;
                        return;
                    } else if (noPayOrderResultBean.payInfo != null && noPayOrderResultBean.payInfo.msgBody != null) {
                        SystemErrorTip.getInstance().showTipDialog(getActivity(), noPayOrderResultBean.payInfo.msgBody.retMsg);
                        return;
                    } else {
                        SystemErrorTip.getInstance().showTipDialog(getActivity(), "数据异常");
                        return;
                    }
                }
                if (this.mPayPaymentBeanList.get(this.mSelectWay).payFlagType == 12) {
                    payICBC(noPayOrderResultBean);
                    return;
                }
                if (this.mPayPaymentBeanList.get(this.mSelectWay).payFlagType == 31) {
                    if (noPayOrderResultBean.payInfo != null && StringUtils.isNotEmpty(noPayOrderResultBean.payInfo.pay_url)) {
                        this.mIsNeedLoadOrder = true;
                        if (AppUtils.checkAliPayInstalled(getActivity())) {
                            try {
                                str2 = "alipays://platformapi/startapp?appId=20000067&url=" + URLEncoder.encode(noPayOrderResultBean.payInfo.pay_url, "UTF-8");
                            } catch (UnsupportedEncodingException e2) {
                                e2.printStackTrace();
                            }
                            startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str2)));
                            return;
                        }
                        ToastUtils.show(getContext(), "需要下载安装支付宝APP后才能进行支付");
                        return;
                    }
                    ToastUtils.show(getContext(), "中国银行聚合支付下单失败");
                    return;
                }
                return;
            }
            ToastUtils.show(getActivity(), "支付完成");
            finish();
            return;
        }
        ToastUtils.show(getContext(), "支付成功！");
    }

    private void payICBC(NoPayOrderResultBean noPayOrderResultBean) {
        UnionPayReq unionPayReq = ICBCPayUtils.getUnionPayReq(noPayOrderResultBean.payInfo.appId, noPayOrderResultBean.payInfo.msgId, noPayOrderResultBean.payInfo.format, noPayOrderResultBean.payInfo.charset, noPayOrderResultBean.payInfo.encryptType, noPayOrderResultBean.payInfo.signType, noPayOrderResultBean.payInfo.merSignMsg, noPayOrderResultBean.payInfo.timestamp, noPayOrderResultBean.payInfo.ca, noPayOrderResultBean.payInfo.tranData, noPayOrderResultBean.payInfo.encryptKey);
        this.mIsNeedLoadOrder = true;
        ICBCPayUtils.payAll(this.mICBCIndex, noPayOrderResultBean.payInfo.appId, getActivity(), unionPayReq, new ICBCPayUtils.OnPayListener() { // from class: client.android.yixiaotong.v3.ui.order.OrderPayWayActivity.4
            @Override // client.android.yixiaotong.icbcPay.ICBCPayUtils.OnPayListener
            public void paySuccess() {
                OrderPayWayActivity.this.mIsNeedLoadOrder = true;
                ToastUtils.show(OrderPayWayActivity.this.getContext(), "支付成功");
            }

            @Override // client.android.yixiaotong.icbcPay.ICBCPayUtils.OnPayListener
            public void payWaitting() {
                ToastUtils.show(OrderPayWayActivity.this.getContext(), "正在等待支付结果,稍后会收到服务器确认的支付结果");
            }

            @Override // client.android.yixiaotong.icbcPay.ICBCPayUtils.OnPayListener
            public void payFail() {
                ToastUtils.show(OrderPayWayActivity.this.getContext(), "支付失败");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancelOrder() {
        V3BusinessControllers.getInstance().postCancelPayOrders(getLoginAccount(), UserInfoUtil.getInstance().getLoginAccountV3().schoolInfoList.get(UserInfoUtil.getInstance().getSchoolInfosIndex()).id + "", this.mInvestorInfoBean.investorId, new Listener<NoPayOrderResultBean>() { // from class: client.android.yixiaotong.v3.ui.order.OrderPayWayActivity.5
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                BaseMaterialDialog.showMaterialDialog(OrderPayWayActivity.this.getActivity(), "正在取消订单", false);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, NoPayOrderResultBean noPayOrderResultBean, Object... objArr) {
                if (OrderPayWayActivity.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    ToastUtils.show(OrderPayWayActivity.this.getContext(), "取消成功，请尝试再次支付");
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (OrderPayWayActivity.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    OrderPayWayActivity.this.onError(clientException);
                }
            }
        });
    }

    /* JADX WARN: Code duplicated, block: B:15:0x00b8  */
    private void getNoPayRecord() {
        String str;
        String str2;
        int i;
        String str3;
        String str4 = UserInfoUtil.getInstance().getLoginAccountV3().schoolInfoList.get(UserInfoUtil.getInstance().getSchoolInfosIndex()).id + "";
        String str5 = UserInfoUtil.getInstance().getLoginAccountV3().studentId;
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
                    String str6 = typeIdMachineId.split(";")[3];
                    i = Integer.parseInt(typeIdMachineId.split(";")[4]);
                    str2 = str6;
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
        V3BusinessControllers.getInstance().getNoPayOrders(getLoginAccount(), str4, this.mTypeId, this.mInvestorInfoBean.investorId, str5, str, str2, i, new Listener<NoPayOrderListBean>() { // from class: client.android.yixiaotong.v3.ui.order.OrderPayWayActivity.6
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, NoPayOrderListBean noPayOrderListBean, Object... objArr) {
                if (OrderPayWayActivity.this.mIsEnable) {
                    if (noPayOrderListBean != null) {
                        if (noPayOrderListBean.orderList.size() == 0) {
                            OrderPayWayActivity.this.finish();
                            return;
                        }
                        return;
                    }
                    OrderPayWayActivity.this.finish();
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                boolean unused = OrderPayWayActivity.this.mIsEnable;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onError(ClientException clientException) {
        if (clientException.isNeedTip(clientException.getCode())) {
            SystemErrorTip.getInstance().showTipDialog(getActivity(), clientException.getDetail());
        } else {
            V3ErrorTipActivity.launch(getActivity(), this.mTitleBar.getTitleViewContent(), clientException.getDetail(), clientException.getCode(), 2, clientException.getSerial());
        }
    }

    class RechargeWayAdapter extends BaseAdapter {
        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        RechargeWayAdapter() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return OrderPayWayActivity.this.mPayFlagTypeList.size();
        }

        @Override // android.widget.Adapter
        public Integer getItem(int i) {
            return (Integer) OrderPayWayActivity.this.mPayFlagTypeList.get(i);
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder viewHolder;
            if (view == null) {
                view = LayoutInflater.from(OrderPayWayActivity.this.getContext()).inflate(R.layout.layout_rechargeway_item, viewGroup, false);
                viewHolder = new ViewHolder(view);
                view.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) view.getTag();
            }
            int iIntValue = getItem(i).intValue();
            viewHolder.img2.setImageResource(R.mipmap.wxz);
            if (iIntValue == 1) {
                viewHolder.img.setImageResource(R.mipmap.wx);
                viewHolder.tv_name.setText("微信支付");
            } else if (iIntValue == 2) {
                viewHolder.img.setImageResource(R.mipmap.zfb);
                viewHolder.tv_name.setText("支付宝支付");
            } else if (iIntValue == 3) {
                viewHolder.img.setImageResource(R.mipmap.yl);
                viewHolder.tv_name.setText("银联支付");
            } else if (iIntValue == 31) {
                viewHolder.img.setImageResource(R.mipmap.refund_zgyh);
                viewHolder.tv_name.setText(OrderPayWayActivity.this.getString(R.string.zgyhjhzf));
            } else {
                viewHolder.img.setVisibility(8);
                viewHolder.tv_name.setText("第三方支付");
            }
            if (OrderPayWayActivity.this.mSelectWay == i) {
                viewHolder.img2.setImageResource(R.mipmap.xz1);
            }
            if (iIntValue == 12) {
                viewHolder.img.setImageResource(R.mipmap.icbc);
                viewHolder.tv_name.setText(OrderPayWayActivity.this.getString(R.string.icbcjhzf));
                viewHolder.img2.setImageResource(R.mipmap.next);
            }
            return view;
        }

        class ViewHolder {
            public ImageView img;
            public ImageView img2;
            public TextView tv_name;

            public ViewHolder(View view) {
                this.img = (ImageView) view.findViewById(R.id.img1);
                this.tv_name = (TextView) view.findViewById(R.id.textali);
                this.img2 = (ImageView) view.findViewById(R.id.img_select_ali);
            }
        }
    }
}
