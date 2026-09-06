package client.android.yixiaotong.v3.ui.appcontrol.drawmoney;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
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
import client.android.yixiaotong.util.DecimalUtil;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.util.permission.PermissionUtil;
import client.android.yixiaotong.v3.bean.deviceinfo.MachineByMacBean;
import client.android.yixiaotong.v3.bean.drawmoney.DMGetOrderBean;
import client.android.yixiaotong.v3.bean.drawmoney.DMHandleDataBean;
import client.android.yixiaotong.v3.bean.login.InvestorInfoBean;
import client.android.yixiaotong.v3.bean.login.PayPaymentBean;
import client.android.yixiaotong.v3.bean.login.SchoolInfosBean;
import client.android.yixiaotong.v3.bean.login.TransferAmountInfoBean;
import client.android.yixiaotong.v3.bean.login.TypeInfoExtendJsonBean;
import client.android.yixiaotong.v3.bean.login.ZlPaymentJson;
import client.android.yixiaotong.v3.http.V3BusinessControllers;
import client.android.yixiaotong.v3.ui.account.UpdateInfoActivity;
import client.android.yixiaotong.v3.ui.dialog.TwoButtonDialog;
import client.android.yixiaotong.v3.ui.error.V3ErrorTipActivity;
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
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class DMRechargeActivity extends BaseActivity implements AdapterView.OnItemClickListener {
    public static final String TAG = "DMRechargeActivity";
    private EditText mEtInputMoney;
    private LinearLayout mLinOtherMoney;
    private LinearLayout mLinPayWay;
    private WrapGridView mListView;
    private WrapListView mLvRechargeWay;
    private String mMachineId;
    private int mMoney;
    private int mPayPaymentFlag;
    private String mQrcode;
    private RechargeRecordAdapter mRechargeRecordAdapter;
    private RechargeWayAdapter mRechargeWayAdapter;
    private int mSiteFlag;
    private String mSiteId;
    private TitleBar mTitleBar;
    private TextView mTvMoney;
    private TypeInfoExtendJsonBean mTypeInfoExtendJsonBean;
    private ZlPaymentJson mZlPaymentJson;
    private List<Integer> mSetMoneyList = new ArrayList();
    private int mSelectMoneyIndex = 0;
    private boolean mIsEnable = true;
    private List<PayPaymentBean> mPayPaymentBeanList = new ArrayList();
    private List<Integer> mPayFlagTypeList = new ArrayList();
    private int mSelectWay = 0;
    private boolean mIsNeedLoadOrder = false;
    private int mICBCIndex = 0;
    private PermissionUtil.PermissionGrant permissionGrant = new PermissionUtil.PermissionGrant() { // from class: client.android.yixiaotong.v3.ui.appcontrol.drawmoney.DMRechargeActivity.12
        @Override // client.android.yixiaotong.util.permission.PermissionUtil.PermissionGrant
        public void onPermissionGranted(int i) {
            LogUtil.e(DMRechargeActivity.TAG, "onPermissionGranted:" + i + "");
            if (i == 4 && ((Integer) DMRechargeActivity.this.mPayFlagTypeList.get(DMRechargeActivity.this.mSelectWay)).intValue() == 12) {
                DMRechargeActivity.this.toPay();
            }
        }
    };

    static {
        StubApp.interface11(9150);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public native void onRequestPermissionsResult(int i, String[] strArr, int[] iArr);

    public static void launch(Activity activity, String str) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) DMRechargeActivity.class).putExtra("qrcode", str));
        }
    }

    public static void launch(Activity activity, String str, int i, String str2) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) DMRechargeActivity.class).putExtra("qrcode", str).putExtra("siteflag", i).putExtra("siteid", str2));
        }
    }

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.titleBar);
        this.mListView = (WrapGridView) findViewById(R.id.lv_chongzhi);
        this.mEtInputMoney = (EditText) findViewById(R.id.et_inputmoney);
        this.mLvRechargeWay = (WrapListView) findViewById(R.id.listview);
        this.mLinPayWay = (LinearLayout) findViewById(R.id.lin_payway);
        this.mTvMoney = (TextView) findViewById(R.id.tv_money);
        this.mLinOtherMoney = (LinearLayout) findViewById(R.id.lin_othermoney);
    }

    private void initTitleBar() {
        this.mTitleBar.setTitleView(getString(R.string.drawmoney));
        this.mTitleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
    }

    public void initView() {
        this.mRechargeRecordAdapter = new RechargeRecordAdapter();
        this.mListView.setOnItemClickListener(this);
        this.mListView.setAdapter((ListAdapter) this.mRechargeRecordAdapter);
        this.mRechargeRecordAdapter.notifyDataSetChanged();
        this.mRechargeWayAdapter = new RechargeWayAdapter();
        this.mLvRechargeWay.setOnItemClickListener(this);
        this.mLvRechargeWay.setAdapter((ListAdapter) this.mRechargeWayAdapter);
        this.mRechargeWayAdapter.notifyDataSetChanged();
        this.mEtInputMoney.addTextChangedListener(new TextWatcher() { // from class: client.android.yixiaotong.v3.ui.appcontrol.drawmoney.DMRechargeActivity.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (StringUtils.isEmpty(editable.toString())) {
                    if (DMRechargeActivity.this.mTvMoney.getText().toString().length() == 1 && DMRechargeActivity.this.mSelectMoneyIndex == -1) {
                        DMRechargeActivity.this.mTvMoney.setText("");
                        return;
                    }
                    return;
                }
                DMRechargeActivity.this.mTvMoney.setText(editable.toString());
                DMRechargeActivity.this.mSelectMoneyIndex = -1;
                DMRechargeActivity.this.mRechargeRecordAdapter.notifyDataSetChanged();
            }
        });
    }

    private void initData() {
        TypeInfoExtendJsonBean typeInfoExtendJson = InvestorInfoUtilControl.getInstance().getTypeInfoExtendJson(20);
        this.mTypeInfoExtendJsonBean = typeInfoExtendJson;
        if (typeInfoExtendJson != null) {
            TransferAmountInfoBean transferAmountInfoBean = typeInfoExtendJson.transferAmountInfo;
            if (this.mTypeInfoExtendJsonBean.transferAmountState == 2 && transferAmountInfoBean != null && transferAmountInfoBean.transferAmount != null && transferAmountInfoBean.transferAmount.size() > 0) {
                this.mSetMoneyList = transferAmountInfoBean.transferAmount;
                this.mLinOtherMoney.setVisibility(8);
            }
        }
        if (this.mSetMoneyList.size() == 0) {
            this.mSetMoneyList.add(100);
            this.mSetMoneyList.add(200);
            this.mSetMoneyList.add(500);
            this.mSetMoneyList.add(1000);
        }
        this.mPayPaymentFlag = InvestorInfoUtilControl.getInstance().getPayPaymentFlag(20);
        ZlPaymentJson zlPaymentJson = InvestorInfoUtilControl.getInstance().getZlPaymentJson(20);
        this.mZlPaymentJson = zlPaymentJson;
        if (zlPaymentJson != null) {
            for (int i = 0; i < this.mZlPaymentJson.payPaymentList.size(); i++) {
                if (this.mZlPaymentJson.payPaymentList.get(i).payFlag == 1) {
                    this.mPayFlagTypeList.add(Integer.valueOf(this.mZlPaymentJson.payPaymentList.get(i).payFlagType));
                    this.mPayPaymentBeanList.add(this.mZlPaymentJson.payPaymentList.get(i));
                }
                if (this.mPayFlagTypeList.size() > 0) {
                    this.mLinPayWay.setVisibility(0);
                }
            }
        }
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.mIsEnable = true;
        if (this.mIsNeedLoadOrder) {
            getOrder(this.mMoney);
        }
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        this.mIsEnable = false;
        BaseMaterialDialog.dissmisMaterialDialog();
    }

    private void initClickListeners() {
        findViewById(R.id.btn_pay).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.drawmoney.DMRechargeActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ClickUtil.isFastDoubleClick()) {
                    return;
                }
                if (StringUtils.isNotEmpty(DMRechargeActivity.this.mTvMoney.getText().toString())) {
                    if (DMRechargeActivity.this.mPayFlagTypeList.size() <= 0 || ((Integer) DMRechargeActivity.this.mPayFlagTypeList.get(DMRechargeActivity.this.mSelectWay)).intValue() != 12) {
                        DMRechargeActivity.this.toPay();
                        return;
                    } else {
                        PermissionUtil.requestPerssion(DMRechargeActivity.this.getActivity(), 4, DMRechargeActivity.this.permissionGrant);
                        return;
                    }
                }
                ToastUtils.show(DMRechargeActivity.this.getContext(), "请输入领款金额");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void toPay() {
        int i;
        String strMultiply = DecimalUtil.multiply(this.mTvMoney.getText().toString(), "100");
        if (strMultiply.contains(".")) {
            i = Integer.parseInt(strMultiply.split("\\.")[0]);
        } else {
            i = Integer.parseInt(strMultiply);
        }
        this.mMoney = i;
        if (this.mTypeInfoExtendJsonBean.transferAmountState == 1 && this.mTypeInfoExtendJsonBean.transferAmountInfo != null) {
            if (i > this.mTypeInfoExtendJsonBean.transferAmountInfo.maxTransferAmount) {
                ToastUtils.show(getContext(), "为安全考虑，最大转款金额：" + DecimalUtil.divide(this.mTypeInfoExtendJsonBean.transferAmountInfo.maxTransferAmount + "", "100") + "元");
                return;
            } else if (i < this.mTypeInfoExtendJsonBean.transferAmountInfo.minTransferAmount) {
                ToastUtils.show(getContext(), "最低转款金额：" + DecimalUtil.divide(this.mTypeInfoExtendJsonBean.transferAmountInfo.minTransferAmount + "", "100") + "元");
                return;
            }
        } else if (this.mTypeInfoExtendJsonBean.transferAmountState == 2 && i > 65000) {
            ToastUtils.show(getContext(), "为安全考虑，最大转款金额：" + DecimalUtil.divide("65000", "100") + "元");
            return;
        }
        this.mIsNeedLoadOrder = false;
        getOrder(i);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (adapterView.getAdapter().toString().contains("RechargeRecordAdapter")) {
            this.mSelectMoneyIndex = i;
            this.mRechargeRecordAdapter.notifyDataSetChanged();
        } else if (adapterView.getAdapter().toString().contains("RechargeWayAdapter")) {
            this.mSelectWay = i;
            this.mRechargeWayAdapter.notifyDataSetChanged();
        }
    }

    private void getDeviceInfo() {
        V3BusinessControllers.getInstance().getMachineByMachineId(getLoginAccount(), this.mMachineId, 20, new Listener<MachineByMacBean>() { // from class: client.android.yixiaotong.v3.ui.appcontrol.drawmoney.DMRechargeActivity.3
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                BaseMaterialDialog.showMaterialDialog(DMRechargeActivity.this.getActivity(), "加载中.", false);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, MachineByMacBean machineByMacBean, Object... objArr) {
                if (DMRechargeActivity.this.mIsEnable) {
                    if (machineByMacBean != null && machineByMacBean.base != null && StringUtils.isNotEmpty(machineByMacBean.base.siteId)) {
                        DMRechargeActivity.this.mSiteFlag = machineByMacBean.base.siteFlag;
                        DMRechargeActivity.this.mSiteId = machineByMacBean.base.siteId;
                        DMRechargeActivity.this.handleData();
                        return;
                    }
                    BaseMaterialDialog.dissmisMaterialDialog();
                    DMRechargeActivity.this.showDialog(true, true, false, "设备未授权，请联系管理员" + DMRechargeActivity.this.mMachineId);
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (DMRechargeActivity.this.mIsEnable) {
                    DMRechargeActivity.this.onError(clientException);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleData() {
        V3BusinessControllers.getInstance().postDMHandleData(getLoginAccount(), 20, this.mMachineId, this.mQrcode, new Listener<DMHandleDataBean>() { // from class: client.android.yixiaotong.v3.ui.appcontrol.drawmoney.DMRechargeActivity.4
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                BaseMaterialDialog.showMaterialDialog(DMRechargeActivity.this.getActivity(), "加载中..", false);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, DMHandleDataBean dMHandleDataBean, Object... objArr) {
                if (DMRechargeActivity.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (DMRechargeActivity.this.mIsEnable) {
                    DMRechargeActivity.this.onError(clientException);
                }
            }
        });
    }

    private void getOrder(final int i) {
        int i2;
        int i3;
        InvestorInfoBean investorInfoBean = InvestorInfoUtilControl.getInstance().getInvestorInfoBean();
        SchoolInfosBean schoolInfo = UserInfoUtilControl.getInstance().getSchoolInfo();
        final UserInfo loginAccountV3 = UserInfoUtil.getInstance().getLoginAccountV3();
        List<PayPaymentBean> list = this.mPayPaymentBeanList;
        if (list == null || list.size() <= 0) {
            i2 = 0;
            i3 = 0;
        } else {
            i2 = this.mPayPaymentBeanList.get(this.mSelectWay).payFlag;
            i3 = this.mPayPaymentBeanList.get(this.mSelectWay).payFlagType;
        }
        if (StringUtils.isEmpty(loginAccountV3.studentName)) {
            TwoButtonDialog.getInstance().showDialog(getActivity(), new TwoButtonDialog.Listener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.drawmoney.DMRechargeActivity.5
                @Override // client.android.yixiaotong.v3.ui.dialog.TwoButtonDialog.Listener
                public void onCancle() {
                }

                @Override // client.android.yixiaotong.v3.ui.dialog.TwoButtonDialog.Listener
                public void onConfirm() {
                    UpdateInfoActivity.launch(DMRechargeActivity.this.getActivity(), loginAccountV3.studentName, loginAccountV3.studentGender, "", 2, true);
                }
            }, "提示", "未设置姓名，无法领款，是否去设置？", "暂不", "去设置");
        } else {
            V3BusinessControllers.getInstance().postDMGetOrder(getLoginAccount(), investorInfoBean.investorId, schoolInfo.id + "", loginAccountV3.studentId, 20, loginAccountV3.studentName, loginAccountV3.studentMobile, this.mMachineId, i, this.mPayPaymentFlag, i2, i3, this.mSiteFlag, this.mSiteId, new Listener<DMGetOrderBean>() { // from class: client.android.yixiaotong.v3.ui.appcontrol.drawmoney.DMRechargeActivity.6
                @Override // client.android.yixiaotong.controller.core.Listener
                public void onStart(Controller controller) {
                    BaseMaterialDialog.showMaterialDialog(DMRechargeActivity.this.getActivity(), "下单中..", false);
                }

                @Override // client.android.yixiaotong.controller.core.Listener
                public void onComplete(Controller controller, DMGetOrderBean dMGetOrderBean, Object... objArr) {
                    if (DMRechargeActivity.this.mIsEnable) {
                        BaseMaterialDialog.dissmisMaterialDialog();
                        LocalDataUtil.saveIsNeedGetWalletInfo(DMRechargeActivity.this.getContext(), true);
                        LogUtil.d(DMRechargeActivity.TAG, "postDMGetOrder:" + DMRechargeActivity.this.mIsNeedLoadOrder);
                        if (dMGetOrderBean.payInfo != null && !DMRechargeActivity.this.mIsNeedLoadOrder) {
                            DMRechargeActivity.this.pay(dMGetOrderBean);
                            return;
                        }
                        if (dMGetOrderBean.payInfo == null) {
                            if (!StringUtils.isNotEmpty(dMGetOrderBean.orderId)) {
                                DMRechargeActivity.this.showDialog(true, true, false, "订单异常");
                                return;
                            }
                            if (dMGetOrderBean.price == 0 && dMGetOrderBean.status == 0) {
                                DWQrcodeActivity.launch(DMRechargeActivity.this.getActivity(), DMRechargeActivity.this.mQrcode, i, dMGetOrderBean.orderId);
                                DMRechargeActivity.this.finish();
                            } else if (dMGetOrderBean.status < 2 || !dMGetOrderBean.hasUnRechargeOrder) {
                                DMRechargeActivity.this.showDialog(true, true, false, "数据异常");
                            } else {
                                DWQrcodeActivity.launch(DMRechargeActivity.this.getActivity(), DMRechargeActivity.this.mQrcode, dMGetOrderBean.price, dMGetOrderBean.orderId);
                                DMRechargeActivity.this.finish();
                            }
                        }
                    }
                }

                @Override // client.android.yixiaotong.controller.core.Listener
                public void onFail(Controller controller, ClientException clientException) {
                    if (DMRechargeActivity.this.mIsEnable) {
                        BaseMaterialDialog.dissmisMaterialDialog();
                        DMRechargeActivity.this.onError(clientException);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pay(DMGetOrderBean dMGetOrderBean) {
        String str = "";
        if (dMGetOrderBean.payInfo != null && (StringUtils.isNotEmpty(dMGetOrderBean.payInfo.tradeNo) || StringUtils.isNotEmpty(dMGetOrderBean.payInfo.orderString))) {
            if (dMGetOrderBean.payInfo.mode == 0) {
                str = dMGetOrderBean.payInfo.orderString;
            } else if (dMGetOrderBean.payInfo.mode == 1) {
                str = dMGetOrderBean.payInfo.tradeNo;
            }
            AliPayUtils.pay(getActivity(), str, new AliPayUtils.OnPayListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.drawmoney.DMRechargeActivity.7
                @Override // client.android.yixiaotong.alipay.AliPayUtils.OnPayListener
                public void paySuccess() {
                    DMRechargeActivity.this.mIsNeedLoadOrder = true;
                    ToastUtils.show(DMRechargeActivity.this.getContext(), "支付成功");
                }

                @Override // client.android.yixiaotong.alipay.AliPayUtils.OnPayListener
                public void payWaitting() {
                    ToastUtils.show(DMRechargeActivity.this.getContext(), "正在等待支付结果,稍后会收到服务器确认的支付结果");
                }

                @Override // client.android.yixiaotong.alipay.AliPayUtils.OnPayListener
                public void payFail() {
                    ToastUtils.show(DMRechargeActivity.this.getContext(), "支付失败");
                }
            });
            return;
        }
        if (dMGetOrderBean.payInfo != null && StringUtils.isNotEmpty(dMGetOrderBean.payInfo.appid)) {
            this.mIsNeedLoadOrder = true;
            WxPayUtils.pay(getActivity(), dMGetOrderBean.payInfo.appid, dMGetOrderBean.payInfo.partnerid, dMGetOrderBean.payInfo.prepayid, dMGetOrderBean.payInfo.noncestr, dMGetOrderBean.payInfo.timestamp, dMGetOrderBean.payInfo.sign);
            return;
        }
        if (dMGetOrderBean.payInfo != null && dMGetOrderBean.payInfo.msgBody != null) {
            if (dMGetOrderBean.payInfo.msgBody.retCode.equals("00000")) {
                GnetePayConfig.builder().createWXAPI(getActivity(), "wxd9320c1760b6d01f");
                this.mIsNeedLoadOrder = true;
                V3WalletControlUtil.getInstance().sendPayRequest(dMGetOrderBean.payInfo.msgBody.chnlUrl, 0, 20);
                return;
            }
            SystemErrorTip.getInstance().showTipDialog(getActivity(), dMGetOrderBean.payInfo.msgBody.retMsg);
            return;
        }
        if (dMGetOrderBean.payInfo != null && StringUtils.isNotEmpty(dMGetOrderBean.payInfo.tranData) && StringUtils.isNotEmpty(dMGetOrderBean.payInfo.merSignMsg)) {
            payICBC(dMGetOrderBean);
            return;
        }
        if (dMGetOrderBean.payInfo != null) {
            if (this.mPayPaymentBeanList.get(this.mSelectWay).payFlagType == 1) {
                this.mIsNeedLoadOrder = true;
                WxPayUtils.pay(getActivity(), dMGetOrderBean.payInfo.appid, dMGetOrderBean.payInfo.partnerid, dMGetOrderBean.payInfo.prepayid, dMGetOrderBean.payInfo.noncestr, dMGetOrderBean.payInfo.timestamp, dMGetOrderBean.payInfo.sign);
                return;
            }
            if (this.mPayPaymentBeanList.get(this.mSelectWay).payFlagType == 2) {
                if (dMGetOrderBean.payInfo.mode == 0) {
                    str = dMGetOrderBean.payInfo.orderString;
                } else if (dMGetOrderBean.payInfo.mode == 1) {
                    str = dMGetOrderBean.payInfo.tradeNo;
                }
                AliPayUtils.pay(getActivity(), str, new AliPayUtils.OnPayListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.drawmoney.DMRechargeActivity.8
                    @Override // client.android.yixiaotong.alipay.AliPayUtils.OnPayListener
                    public void paySuccess() {
                        DMRechargeActivity.this.mIsNeedLoadOrder = true;
                        ToastUtils.show(DMRechargeActivity.this.getContext(), "支付成功");
                    }

                    @Override // client.android.yixiaotong.alipay.AliPayUtils.OnPayListener
                    public void payWaitting() {
                        ToastUtils.show(DMRechargeActivity.this.getContext(), "正在等待支付结果,稍后会收到服务器确认的支付结果");
                    }

                    @Override // client.android.yixiaotong.alipay.AliPayUtils.OnPayListener
                    public void payFail() {
                        ToastUtils.show(DMRechargeActivity.this.getContext(), "支付失败");
                    }
                });
                return;
            }
            if (this.mPayPaymentBeanList.get(this.mSelectWay).payFlagType == 3) {
                if (dMGetOrderBean.payInfo != null && dMGetOrderBean.payInfo.msgBody != null && dMGetOrderBean.payInfo.msgBody.retCode.equals("00000")) {
                    GnetePayConfig.builder().createWXAPI(getActivity(), "wxd9320c1760b6d01f");
                    this.mIsNeedLoadOrder = true;
                    V3WalletControlUtil.getInstance().sendPayRequest(dMGetOrderBean.payInfo.msgBody.chnlUrl, 0, 20);
                    return;
                } else if (dMGetOrderBean.payInfo != null && dMGetOrderBean.payInfo.msgBody != null) {
                    SystemErrorTip.getInstance().showTipDialog(getActivity(), dMGetOrderBean.payInfo.msgBody.retMsg);
                    return;
                } else {
                    SystemErrorTip.getInstance().showTipDialog(getActivity(), "数据异常");
                    return;
                }
            }
            if (this.mPayPaymentBeanList.get(this.mSelectWay).payFlagType == 12) {
                payICBC(dMGetOrderBean);
                return;
            }
            return;
        }
        SystemErrorTip.getInstance().showTipDialog(getActivity(), "数据异常");
    }

    private void payICBC(DMGetOrderBean dMGetOrderBean) {
        UnionPayReq unionPayReq = ICBCPayUtils.getUnionPayReq(dMGetOrderBean.payInfo.appId, dMGetOrderBean.payInfo.msgId, dMGetOrderBean.payInfo.format, dMGetOrderBean.payInfo.charset, dMGetOrderBean.payInfo.encryptType, dMGetOrderBean.payInfo.signType, dMGetOrderBean.payInfo.merSignMsg, dMGetOrderBean.payInfo.timestamp, dMGetOrderBean.payInfo.ca, dMGetOrderBean.payInfo.tranData, dMGetOrderBean.payInfo.encryptKey);
        this.mIsNeedLoadOrder = true;
        ICBCPayUtils.payAll(this.mICBCIndex, dMGetOrderBean.payInfo.appId, getActivity(), unionPayReq, new ICBCPayUtils.OnPayListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.drawmoney.DMRechargeActivity.9
            @Override // client.android.yixiaotong.icbcPay.ICBCPayUtils.OnPayListener
            public void paySuccess() {
                DMRechargeActivity.this.mIsNeedLoadOrder = true;
                ToastUtils.show(DMRechargeActivity.this.getContext(), "支付成功");
            }

            @Override // client.android.yixiaotong.icbcPay.ICBCPayUtils.OnPayListener
            public void payWaitting() {
                ToastUtils.show(DMRechargeActivity.this.getContext(), "正在等待支付结果,稍后会收到服务器确认的支付结果");
            }

            @Override // client.android.yixiaotong.icbcPay.ICBCPayUtils.OnPayListener
            public void payFail() {
                ToastUtils.show(DMRechargeActivity.this.getContext(), "支付失败");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialog(boolean z, boolean z2, boolean z3, String str) {
        if (z2) {
            str = str + "\n(" + LocalDataUtil.getTraceID(getContext()) + ")";
        }
        String str2 = str;
        if (z && !z3) {
            SystemErrorTip.getInstance().showTipDialog(getActivity(), "", str2, "", false, new SystemErrorTip.SystemErrorDialogListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.drawmoney.DMRechargeActivity.10
                @Override // client.android.yixiaotong.ui.dialog.SystemErrorTip.SystemErrorDialogListener
                public void onConfirm() {
                    DMRechargeActivity.this.finish();
                }
            });
        } else if (z && z3) {
            SystemErrorTip.getInstance().showTipDialog(getActivity(), new SystemErrorTip.SystemErrorDialogListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.drawmoney.DMRechargeActivity.11
                @Override // client.android.yixiaotong.ui.dialog.SystemErrorTip.SystemErrorDialogListener
                public void onConfirm() {
                    DMRechargeActivity.this.finish();
                }
            }, str2);
        } else {
            SystemErrorTip.getInstance().showTipDialog(getActivity(), str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onError(ClientException clientException) {
        BaseMaterialDialog.dissmisMaterialDialog();
        if (clientException.isNeedTip(clientException.getCode())) {
            showDialog(true, true, false, clientException.getDetail());
        } else {
            V3ErrorTipActivity.launch(getActivity(), this.mTitleBar.getTitleViewContent(), clientException.getDetail(), clientException.getCode(), 2, clientException.getSerial());
            finish();
        }
    }

    class RechargeRecordAdapter extends BaseAdapter {
        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        RechargeRecordAdapter() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return DMRechargeActivity.this.mSetMoneyList.size();
        }

        @Override // android.widget.Adapter
        public Integer getItem(int i) {
            return (Integer) DMRechargeActivity.this.mSetMoneyList.get(i);
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder viewHolder;
            if (view == null) {
                view = LayoutInflater.from(DMRechargeActivity.this.getContext()).inflate(R.layout.layout_dwmoney_item, viewGroup, false);
                viewHolder = new ViewHolder(view);
                view.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) view.getTag();
            }
            int iIntValue = getItem(i).intValue();
            viewHolder.tv_money.setText(DecimalUtil.divide(iIntValue + "", "100") + "元");
            viewHolder.tv_song.setVisibility(8);
            if (DMRechargeActivity.this.mSelectMoneyIndex == i) {
                viewHolder.mRel.setBackground(DMRechargeActivity.this.getResources().getDrawable(R.drawable.shape_6f32fd_round_background));
                viewHolder.tv_money.setTextColor(DMRechargeActivity.this.getResources().getColor(R.color.white));
                viewHolder.tv_song.setTextColor(DMRechargeActivity.this.getResources().getColor(R.color.white));
                DMRechargeActivity.this.mTvMoney.setText(DecimalUtil.divide(iIntValue + "", "100"));
                DMRechargeActivity.this.mEtInputMoney.setText("");
            } else {
                viewHolder.mRel.setBackground(DMRechargeActivity.this.getResources().getDrawable(R.drawable.shape_a1a6b3_background));
                viewHolder.tv_money.setTextColor(DMRechargeActivity.this.getResources().getColor(R.color.ff242933));
                viewHolder.tv_song.setTextColor(DMRechargeActivity.this.getResources().getColor(R.color.fff13628));
            }
            return view;
        }

        class ViewHolder {
            public RelativeLayout mRel;
            public TextView tv_money;
            public TextView tv_song;

            public ViewHolder(View view) {
                this.mRel = (RelativeLayout) view.findViewById(R.id.rel_bg);
                this.tv_money = (TextView) view.findViewById(R.id.tv_money);
                this.tv_song = (TextView) view.findViewById(R.id.tv_song);
            }
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
            return DMRechargeActivity.this.mPayFlagTypeList.size();
        }

        @Override // android.widget.Adapter
        public Integer getItem(int i) {
            return (Integer) DMRechargeActivity.this.mPayFlagTypeList.get(i);
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder viewHolder;
            if (view == null) {
                view = LayoutInflater.from(DMRechargeActivity.this.getContext()).inflate(R.layout.layout_rechargeway_item, viewGroup, false);
                viewHolder = new ViewHolder(view);
                view.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) view.getTag();
            }
            int iIntValue = getItem(i).intValue();
            viewHolder.img2.setImageResource(R.mipmap.wxz);
            if (iIntValue == 1) {
                viewHolder.img.setImageResource(R.mipmap.wx);
                viewHolder.tv_name.setText(DMRechargeActivity.this.getString(R.string.wechatpay));
            } else if (iIntValue == 2) {
                viewHolder.img.setImageResource(R.mipmap.zfb);
                viewHolder.tv_name.setText(DMRechargeActivity.this.getString(R.string.alipaymeny));
            } else if (iIntValue == 3) {
                viewHolder.img.setImageResource(R.mipmap.yl);
                viewHolder.tv_name.setText(DMRechargeActivity.this.getString(R.string.unionpayment));
            }
            if (DMRechargeActivity.this.mSelectWay == i) {
                viewHolder.img2.setImageResource(R.mipmap.xz1);
            }
            if (iIntValue == 12) {
                viewHolder.img.setImageResource(R.mipmap.icbc);
                viewHolder.tv_name.setText(DMRechargeActivity.this.getString(R.string.icbcjhzf));
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
