package client.android.yixiaotong.v3.ui.appcontrol.electricitymeter;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.TextView;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.alipay.AliPayUtils;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.icbcPay.ICBCPayUtils;
import client.android.yixiaotong.ui.dialog.BaseMaterialDialog;
import client.android.yixiaotong.ui.dialog.SystemErrorTip;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.ui.widget.WrapGridView;
import client.android.yixiaotong.ui.widget.WrapListView;
import client.android.yixiaotong.util.AppUtils;
import client.android.yixiaotong.util.DecimalUtil;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.util.permission.PermissionUtil;
import client.android.yixiaotong.v3.bean.card.CreateOrderBean;
import client.android.yixiaotong.v3.bean.elecmeter.BindElecMeterInfoBean;
import client.android.yixiaotong.v3.bean.login.PlanJsonBean;
import client.android.yixiaotong.v3.bean.login.TypeInfoBean;
import client.android.yixiaotong.v3.bean.login.ZlPaymentJson;
import client.android.yixiaotong.v3.bean.pay.PayMoneyInfoBean;
import client.android.yixiaotong.v3.bean.wallet.YiKaTongPayModelParameterBean;
import client.android.yixiaotong.v3.http.V3BusinessControllers;
import client.android.yixiaotong.v3.ui.adapter.PayMoneyAdapter;
import client.android.yixiaotong.v3.ui.adapter.PayWayAdapter;
import client.android.yixiaotong.v3.ui.dialog.ICBCPayWayDialog;
import client.android.yixiaotong.v3.ui.error.ErrorControlUtil;
import client.android.yixiaotong.v3.ui.wallet.controlutil.V3WalletControlUtil;
import client.android.yixiaotong.v3.userinfo.InvestorInfoUtilControl;
import client.android.yixiaotong.v3.userinfo.UserInfo;
import client.android.yixiaotong.v3.userinfo.UserInfoUtil;
import client.android.yixiaotong.v3.userinfo.UserInfoUtilControl;
import client.android.yixiaotong.v3.util.ClickUtil;
import client.android.yixiaotong.v3.util.LocalDataUtil;
import client.android.yixiaotong.v3.util.LogUtil;
import client.android.yixiaotong.wxapi.WxPayUtils;
import com.gnete.upbc.cashier.GnetePayConfig;
import com.icbc.paysdk.model.UnionPayReq;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.stub.StubApp;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class ElecMeterRechargeActivity extends BaseActivity {
    private static final String TAG = "ElecMeterRechargeActivity";
    private BindElecMeterInfoBean mBindElecMeterInfoBean;
    private String mInvestorId;
    private WrapGridView mLvRechargeMoney;
    private WrapListView mLvRechargeWay;
    private PayMoneyAdapter mPayMoneyAdapter;
    private PayWayAdapter mPayWayAdapter;
    private int mPlanFlag;
    private String mSchoolId;
    private String mStudentId;
    private TitleBar mTitleBar;
    private TextView mTvDeviceNo;
    private TextView mTvMoney;
    private TextView mTvRoomAddress;
    private TextView mTvUserNo;
    private TypeInfoBean mTypeInfoBean;
    private boolean mIsEnable = true;
    private List<PayMoneyInfoBean> mPayMoneyInfoBeans = new ArrayList();
    private List<Integer> mPayWayDatas = new ArrayList();
    private int mPayWayIndex = 0;
    private int mPayMoneyIndex = 0;
    private ArrayList<Integer> mMoneys = new ArrayList<>();
    private int mICBCIndex = 1;
    private PermissionUtil.PermissionGrant permissionGrant = new PermissionUtil.PermissionGrant() { // from class: client.android.yixiaotong.v3.ui.appcontrol.electricitymeter.ElecMeterRechargeActivity.4
        @Override // client.android.yixiaotong.util.permission.PermissionUtil.PermissionGrant
        public void onPermissionGranted(int i) {
            LogUtil.e(ElecMeterRechargeActivity.TAG, "onPermissionGranted:" + i + "");
            if (i == 4 && ((Integer) ElecMeterRechargeActivity.this.mPayWayDatas.get(ElecMeterRechargeActivity.this.mPayWayIndex)).intValue() == 12) {
                ICBCPayWayDialog.getInstance().showDialog(ElecMeterRechargeActivity.this.getActivity(), new ICBCPayWayDialog.Listener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.electricitymeter.ElecMeterRechargeActivity.4.1
                    @Override // client.android.yixiaotong.v3.ui.dialog.ICBCPayWayDialog.Listener
                    public void onPay(int i2) {
                        ElecMeterRechargeActivity.this.mICBCIndex = i2;
                        if (ElecMeterRechargeActivity.this.check()) {
                            ElecMeterRechargeActivity.this.createOrder();
                        }
                    }
                }, ElecMeterRechargeActivity.this.mTvMoney.getText().toString());
            }
        }
    };

    static {
        StubApp.interface11(9343);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public native void onRequestPermissionsResult(int i, String[] strArr, int[] iArr);

    public static void launch(Activity activity, BindElecMeterInfoBean bindElecMeterInfoBean) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) ElecMeterRechargeActivity.class).putExtra("bean", bindElecMeterInfoBean));
        }
    }

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.titlebar);
        this.mTvMoney = (TextView) findViewById(R.id.tv_money);
        this.mTvUserNo = (TextView) findViewById(R.id.tv_userno);
        this.mTvRoomAddress = (TextView) findViewById(R.id.tv_roomaddress);
        this.mTvDeviceNo = (TextView) findViewById(R.id.tv_deviceno);
        this.mLvRechargeWay = (WrapListView) findViewById(R.id.listview);
        this.mLvRechargeMoney = (WrapGridView) findViewById(R.id.lv_chongzhi);
    }

    private void initTitleBar() {
        this.mTitleBar.setTitleView(getString(R.string.elecmeterrecharge));
        this.mTitleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
    }

    private void initView() {
        this.mTvDeviceNo.setText(this.mBindElecMeterInfoBean.factoryNo);
        this.mTvUserNo.setText(this.mBindElecMeterInfoBean.thirdPartyUserNumber);
        this.mTvRoomAddress.setText(this.mBindElecMeterInfoBean.roomAddress);
        this.mPayMoneyAdapter = new PayMoneyAdapter(getActivity(), new PayMoneyAdapter.OnItemClickListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.electricitymeter.ElecMeterRechargeActivity.1
            @Override // client.android.yixiaotong.v3.ui.adapter.PayMoneyAdapter.OnItemClickListener
            public void onItemClick(int i) {
                LogUtil.e(ElecMeterRechargeActivity.TAG, "onItemClick:" + i);
                ElecMeterRechargeActivity.this.mPayMoneyIndex = i;
                ElecMeterRechargeActivity.this.mTvMoney.setText(DecimalUtil.divide(ElecMeterRechargeActivity.this.mMoneys.get(ElecMeterRechargeActivity.this.mPayMoneyIndex) + "", "100"));
                ElecMeterRechargeActivity.this.mPayMoneyAdapter.notifyDataSetChanged();
            }
        });
        this.mMoneys.add(1000);
        this.mMoneys.add(3000);
        this.mMoneys.add(5000);
        this.mMoneys.add(10000);
        this.mMoneys.add(20000);
        this.mMoneys.add(Integer.valueOf(KSImageLoader.InnerImageLoadingListener.MAX_DURATION));
        this.mPayMoneyInfoBeans.clear();
        for (int i = 0; i < this.mMoneys.size(); i++) {
            PayMoneyInfoBean payMoneyInfoBean = new PayMoneyInfoBean();
            payMoneyInfoBean.payMoney = DecimalUtil.divide(this.mMoneys.get(i) + "", "100");
            this.mPayMoneyInfoBeans.add(payMoneyInfoBean);
        }
        this.mPayMoneyAdapter.setData(this.mPayMoneyInfoBeans);
        this.mLvRechargeMoney.setOnItemClickListener(this.mPayMoneyAdapter);
        this.mLvRechargeMoney.setAdapter((ListAdapter) this.mPayMoneyAdapter);
        this.mPayMoneyAdapter.notifyDataSetChanged();
        this.mTvMoney.setText(DecimalUtil.divide(this.mMoneys.get(this.mPayMoneyIndex) + "", "100"));
        PayWayAdapter payWayAdapter = new PayWayAdapter(getActivity(), new PayWayAdapter.OnItemClickListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.electricitymeter.ElecMeterRechargeActivity.2
            @Override // client.android.yixiaotong.v3.ui.adapter.PayWayAdapter.OnItemClickListener
            public void onItemClick(int i2) {
                LogUtil.e(ElecMeterRechargeActivity.TAG, "onItemClick:" + i2);
                ElecMeterRechargeActivity.this.mPayWayIndex = i2;
                ElecMeterRechargeActivity.this.mPayWayAdapter.notifyDataSetChanged();
                if (((Integer) ElecMeterRechargeActivity.this.mPayWayDatas.get(ElecMeterRechargeActivity.this.mPayWayIndex)).intValue() == 12) {
                    PermissionUtil.requestPerssion(ElecMeterRechargeActivity.this.getActivity(), 4, ElecMeterRechargeActivity.this.permissionGrant);
                }
            }
        });
        this.mPayWayAdapter = payWayAdapter;
        this.mLvRechargeWay.setOnItemClickListener(payWayAdapter);
        this.mLvRechargeWay.setAdapter((ListAdapter) this.mPayWayAdapter);
        this.mPlanFlag = InvestorInfoUtilControl.getInstance().getPlanFlag(7);
        LogUtil.e(TAG, "方案信息：" + this.mPlanFlag);
        int i2 = this.mPlanFlag;
        if (i2 == 1 || i2 == 2 || i2 == 6) {
            PlanJsonBean planJson = InvestorInfoUtilControl.getInstance().getPlanJson(this.mPlanFlag);
            if (planJson.payFlagTypeList != null && planJson.payFlagTypeList.size() > 0) {
                for (int i3 = 0; i3 < planJson.payFlagTypeList.size(); i3++) {
                    this.mPayWayDatas.add(planJson.payFlagTypeList.get(i3));
                }
            }
        } else {
            this.mPayWayDatas.clear();
            ZlPaymentJson zlPaymentJson = InvestorInfoUtilControl.getInstance().getZlPaymentJson(7);
            if (zlPaymentJson != null) {
                for (int i4 = 0; i4 < zlPaymentJson.payPaymentList.size(); i4++) {
                    LogUtil.e(TAG, "getPayment:" + i4 + "  " + zlPaymentJson.payPaymentList.get(i4).payFlag + "  " + zlPaymentJson.payPaymentList.get(i4).payFlagType);
                    if (zlPaymentJson.payPaymentList.get(i4).payFlag == 1) {
                        this.mPayWayDatas.add(Integer.valueOf(zlPaymentJson.payPaymentList.get(i4).payFlagType));
                    }
                }
            }
        }
        this.mPayWayAdapter.setData(this.mPayWayDatas, 0);
        this.mPayWayAdapter.notifyDataSetChanged();
        this.mSchoolId = UserInfoUtilControl.getInstance().getSchoolId();
        this.mInvestorId = InvestorInfoUtilControl.getInstance().getInvestorId();
        this.mStudentId = UserInfoUtilControl.getInstance().getStudentId();
        this.mTypeInfoBean = InvestorInfoUtilControl.getInstance().getTypeInfoBean(this.mPlanFlag, 7);
    }

    private void initClickListeners() {
        findViewById(R.id.btn_pay).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.electricitymeter.ElecMeterRechargeActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m276x13fec24f(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$0$client-android-yixiaotong-v3-ui-appcontrol-electricitymeter-ElecMeterRechargeActivity, reason: not valid java name */
    /* synthetic */ void m276x13fec24f(View view) {
        if (ClickUtil.isFastDoubleClick() || !check()) {
            return;
        }
        createOrder();
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.mIsEnable = true;
        ErrorControlUtil.getInstance().onResume();
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        this.mIsEnable = false;
        ErrorControlUtil.getInstance().onPause();
        BaseMaterialDialog.dissmisMaterialDialog();
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean check() {
        if (StringUtils.isEmpty(this.mTvMoney.getText().toString())) {
            ToastUtils.show(getContext(), getString(R.string.selectrechargeamounts));
            return false;
        }
        TypeInfoBean typeInfoBean = this.mTypeInfoBean;
        if (typeInfoBean != null && typeInfoBean.base.statusFlag == 2) {
            ToastUtils.show(getContext(), getString(R.string.appstop));
            return false;
        }
        List<Integer> list = this.mPayWayDatas;
        if (list != null && list.size() > 0) {
            return true;
        }
        ToastUtils.show(getContext(), "暂未开通支付方式");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void createOrder() {
        String str;
        String str2;
        YiKaTongPayModelParameterBean yiKaTongPayModelParameterBean;
        int iIntValue = this.mMoneys.get(this.mPayMoneyIndex).intValue();
        UserInfo loginAccountV3 = UserInfoUtil.getInstance().getLoginAccountV3();
        if (loginAccountV3 != null) {
            String str3 = loginAccountV3.studentName;
            str2 = loginAccountV3.studentMobile;
            str = str3;
        } else {
            str = "";
            str2 = str;
        }
        if (this.mPayWayDatas.get(this.mPayWayIndex).intValue() == 12) {
            yiKaTongPayModelParameterBean = new YiKaTongPayModelParameterBean();
            yiKaTongPayModelParameterBean.channelType = this.mICBCIndex;
        } else {
            yiKaTongPayModelParameterBean = null;
        }
        V3BusinessControllers.getInstance().elecMeterRechargeCreateOrder(getLoginAccount(), this.mBindElecMeterInfoBean.factoryNo, this.mBindElecMeterInfoBean.thirdPartyUserNumber, 1, iIntValue, this.mPayWayDatas.get(this.mPayWayIndex).intValue(), this.mInvestorId, this.mSchoolId, this.mStudentId, str, str2, this.mBindElecMeterInfoBean.roomAddress, 7, 12, yiKaTongPayModelParameterBean, new Listener<CreateOrderBean>() { // from class: client.android.yixiaotong.v3.ui.appcontrol.electricitymeter.ElecMeterRechargeActivity.3
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                super.onStart(controller);
                BaseMaterialDialog.showMaterialDialog(ElecMeterRechargeActivity.this.getActivity(), "下单中.", false);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, CreateOrderBean createOrderBean, Object... objArr) {
                String str4;
                String str5;
                super.onComplete(controller, createOrderBean, objArr);
                if (ElecMeterRechargeActivity.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    if (createOrderBean != null) {
                        LocalDataUtil.saveIsNeedGetWalletInfo(ElecMeterRechargeActivity.this.getContext(), true);
                        if (((Integer) ElecMeterRechargeActivity.this.mPayWayDatas.get(ElecMeterRechargeActivity.this.mPayWayIndex)).intValue() != 1 || createOrderBean.payInfo == null) {
                            if (((Integer) ElecMeterRechargeActivity.this.mPayWayDatas.get(ElecMeterRechargeActivity.this.mPayWayIndex)).intValue() != 2 || createOrderBean.payInfo == null) {
                                if (((Integer) ElecMeterRechargeActivity.this.mPayWayDatas.get(ElecMeterRechargeActivity.this.mPayWayIndex)).intValue() == 7) {
                                    ToastUtils.show(ElecMeterRechargeActivity.this.getContext(), "支付成功");
                                    return;
                                }
                                if (((Integer) ElecMeterRechargeActivity.this.mPayWayDatas.get(ElecMeterRechargeActivity.this.mPayWayIndex)).intValue() != 3) {
                                    if (((Integer) ElecMeterRechargeActivity.this.mPayWayDatas.get(ElecMeterRechargeActivity.this.mPayWayIndex)).intValue() != 12 || createOrderBean.payInfo == null) {
                                        if (((Integer) ElecMeterRechargeActivity.this.mPayWayDatas.get(ElecMeterRechargeActivity.this.mPayWayIndex)).intValue() != 31 || createOrderBean.payInfo == null) {
                                            ToastUtils.show(ElecMeterRechargeActivity.this.getContext(), "下单失败");
                                            return;
                                        }
                                        if (StringUtils.isNotEmpty(createOrderBean.payInfo.pay_url)) {
                                            if (!AppUtils.checkAliPayInstalled(ElecMeterRechargeActivity.this.getActivity())) {
                                                ToastUtils.show(ElecMeterRechargeActivity.this.getContext(), "需要下载安装支付宝APP后才能进行支付");
                                                return;
                                            }
                                            try {
                                                str4 = "alipays://platformapi/startapp?appId=20000067&url=" + URLEncoder.encode(createOrderBean.payInfo.pay_url, "UTF-8");
                                            } catch (UnsupportedEncodingException e) {
                                                e.printStackTrace();
                                                str4 = null;
                                            }
                                            ElecMeterRechargeActivity.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str4)));
                                            return;
                                        }
                                        ToastUtils.show(ElecMeterRechargeActivity.this.getContext(), "中国银行聚合支付下单失败");
                                        return;
                                    }
                                    LogUtil.e(ElecMeterRechargeActivity.TAG, "订单id：" + createOrderBean.orderId);
                                    UnionPayReq unionPayReq = ICBCPayUtils.getUnionPayReq(createOrderBean.payInfo.appId, createOrderBean.payInfo.msgId, createOrderBean.payInfo.format, createOrderBean.payInfo.charset, createOrderBean.payInfo.encryptType, createOrderBean.payInfo.signType, createOrderBean.payInfo.merSignMsg, createOrderBean.payInfo.timestamp, createOrderBean.payInfo.ca, createOrderBean.payInfo.tranData, createOrderBean.payInfo.encryptKey);
                                    LogUtil.e(ElecMeterRechargeActivity.TAG, "appId:" + createOrderBean.payInfo.appId + " msgId:" + createOrderBean.payInfo.msgId + "  format:" + createOrderBean.payInfo.format + "  charset:" + createOrderBean.payInfo.charset + "  encryptType:" + createOrderBean.payInfo.encryptType + "  signType:" + createOrderBean.payInfo.signType + "  merSignMsg:" + createOrderBean.payInfo.merSignMsg + "  timestamp:" + createOrderBean.payInfo.timestamp + "  ca:" + createOrderBean.payInfo.ca + "  tranData:" + createOrderBean.payInfo.tranData + "  encryptKey:" + createOrderBean.payInfo.encryptKey);
                                    ICBCPayUtils.payAll(ElecMeterRechargeActivity.this.mICBCIndex, createOrderBean.payInfo.appId, ElecMeterRechargeActivity.this.getActivity(), unionPayReq, new ICBCPayUtils.OnPayListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.electricitymeter.ElecMeterRechargeActivity.3.2
                                        @Override // client.android.yixiaotong.icbcPay.ICBCPayUtils.OnPayListener
                                        public void paySuccess() {
                                            ToastUtils.show(ElecMeterRechargeActivity.this.getContext(), "支付成功");
                                        }

                                        @Override // client.android.yixiaotong.icbcPay.ICBCPayUtils.OnPayListener
                                        public void payWaitting() {
                                            ToastUtils.show(ElecMeterRechargeActivity.this.getContext(), "正在等待支付结果,稍后会收到服务器确认的支付结果");
                                        }

                                        @Override // client.android.yixiaotong.icbcPay.ICBCPayUtils.OnPayListener
                                        public void payFail() {
                                            ToastUtils.show(ElecMeterRechargeActivity.this.getContext(), "支付失败");
                                        }
                                    });
                                    return;
                                }
                                if (createOrderBean == null || createOrderBean.payInfo == null || createOrderBean.payInfo.msgBody == null) {
                                    ToastUtils.show(ElecMeterRechargeActivity.this.getContext(), "银联下单失败");
                                    return;
                                } else if (createOrderBean.payInfo.msgBody.retCode.equals("00000")) {
                                    GnetePayConfig.builder().createWXAPI(ElecMeterRechargeActivity.this.getActivity(), "wxd9320c1760b6d01f");
                                    V3WalletControlUtil.getInstance().sendPayRequest(createOrderBean.payInfo.msgBody.chnlUrl, ElecMeterRechargeActivity.this.mPlanFlag, 0);
                                    return;
                                } else {
                                    SystemErrorTip.getInstance().showTipDialog(ElecMeterRechargeActivity.this.getActivity(), createOrderBean.payInfo.msgBody.retMsg);
                                    return;
                                }
                            }
                            if (createOrderBean.payInfo.mode == 0) {
                                str5 = createOrderBean.payInfo.orderString;
                            } else {
                                str5 = createOrderBean.payInfo.mode == 1 ? createOrderBean.payInfo.tradeNo : "";
                            }
                            LogUtil.e(ElecMeterRechargeActivity.TAG, "paymsg:" + str5);
                            AliPayUtils.pay(ElecMeterRechargeActivity.this.getActivity(), str5, new AliPayUtils.OnPayListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.electricitymeter.ElecMeterRechargeActivity.3.1
                                @Override // client.android.yixiaotong.alipay.AliPayUtils.OnPayListener
                                public void paySuccess() {
                                    ToastUtils.show(ElecMeterRechargeActivity.this.getContext(), "支付成功");
                                }

                                @Override // client.android.yixiaotong.alipay.AliPayUtils.OnPayListener
                                public void payWaitting() {
                                    ToastUtils.show(ElecMeterRechargeActivity.this.getContext(), "正在等待支付结果,稍后会收到服务器确认的支付结果");
                                }

                                @Override // client.android.yixiaotong.alipay.AliPayUtils.OnPayListener
                                public void payFail() {
                                    ToastUtils.show(ElecMeterRechargeActivity.this.getContext(), "支付失败");
                                }
                            });
                            return;
                        }
                        WxPayUtils.pay(ElecMeterRechargeActivity.this.getActivity(), createOrderBean.payInfo.appid, createOrderBean.payInfo.partnerid, createOrderBean.payInfo.prepayid, createOrderBean.payInfo.noncestr, createOrderBean.payInfo.timestamp, createOrderBean.payInfo.sign);
                    }
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                super.onFail(controller, clientException);
                if (ElecMeterRechargeActivity.this.mIsEnable) {
                    ErrorControlUtil.getInstance().onError(ElecMeterRechargeActivity.this.getLoginAccount(), clientException, ElecMeterRechargeActivity.this.getActivity(), false, ElecMeterRechargeActivity.this.mTitleBar.getTitleViewContent());
                }
            }
        });
    }
}
