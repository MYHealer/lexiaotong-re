package client.android.yixiaotong.v3.ui.order;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.alipay.AliPayUtils;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.ui.dialog.BaseMaterialDialog;
import client.android.yixiaotong.ui.dialog.SystemErrorTip;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.DecimalUtil;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.v3.bean.login.InvestorInfoBean;
import client.android.yixiaotong.v3.bean.login.PayPaymentBean;
import client.android.yixiaotong.v3.bean.login.PlanJsonBean;
import client.android.yixiaotong.v3.bean.login.TypeInfoBaseInfoBean;
import client.android.yixiaotong.v3.bean.login.ZlPaymentJson;
import client.android.yixiaotong.v3.bean.order.NoPayOrderBean;
import client.android.yixiaotong.v3.bean.order.NoPayOrderResultBean;
import client.android.yixiaotong.v3.http.V3BusinessControllers;
import client.android.yixiaotong.v3.ui.dialog.OrderDetailDialog;
import client.android.yixiaotong.v3.ui.error.V3ErrorTipActivity;
import client.android.yixiaotong.v3.ui.wallet.controlutil.V3WalletControlUtil;
import client.android.yixiaotong.v3.userinfo.InvestorInfoUtil;
import client.android.yixiaotong.v3.userinfo.InvestorInfoUtilControl;
import client.android.yixiaotong.v3.userinfo.UserInfoUtil;
import client.android.yixiaotong.v3.util.ClickUtil;
import client.android.yixiaotong.v3.util.LocalDataUtil;
import client.android.yixiaotong.v3.util.LogUtil;
import client.android.yixiaotong.wxapi.WxPayUtils;
import com.gnete.upbc.cashier.GnetePayConfig;
import com.stub.StubApp;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class NoPayOrderActivity extends BaseActivity implements AdapterView.OnItemClickListener {
    private static final String TAG = "NoPayOrderActivity";
    private RecordsAdapter mApdater;
    private String mAppName;
    private InvestorInfoBean mInvestorInfoBean;
    private ListView mLvRecord;
    private int mOrderPayFlag;
    private int mOrderPayFlagType;
    private int mOrderPayPaymentFlag;
    private int mPayPaymentFlag;
    private PlanJsonBean mPlanJsonBean;
    private TitleBar mTitleBar;
    private int mTotalMoney;
    private TextView mTvTotalMoney;
    private TypeInfoBaseInfoBean mTypeInfoBaseInfoBean;
    private int mTypeid;
    private ZlPaymentJson mZlPaymentJson;
    private List<NoPayOrderBean> mAllRecordListBeans = new ArrayList();
    private List<NoPayOrderBean> mRecordListBeans = new ArrayList();
    private List<PayPaymentBean> mPayPaymentBeanList = new ArrayList();
    private List<Integer> mPayFlagTypeList = new ArrayList();
    private int mSelectWay = 0;
    private boolean mIsEnable = true;
    private boolean mHasUnPayMergeOrder = false;

    static {
        StubApp.interface11(10048);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    public static void launch(Activity activity, List<NoPayOrderBean> list, TypeInfoBaseInfoBean typeInfoBaseInfoBean) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) NoPayOrderActivity.class).putExtra("list", (Serializable) list).putExtra("bean", typeInfoBaseInfoBean));
        }
    }

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.titleBar);
        this.mLvRecord = (ListView) findViewById(R.id.lv_record);
        this.mTvTotalMoney = (TextView) findViewById(R.id.tv_totalmoney);
    }

    private void initTitleBar() {
        this.mTitleBar.setTitleView(getString(R.string.unpaidorder));
        this.mTitleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
    }

    private void getNewNoPayOrders() {
        for (int i = 0; i < this.mAllRecordListBeans.size(); i++) {
            if (this.mAllRecordListBeans.get(i).typeId == this.mTypeid) {
                this.mRecordListBeans.add(this.mAllRecordListBeans.get(i));
            }
        }
    }

    public void initData() {
        if (InvestorInfoUtil.getInstance().getInvestorInfosV3() != null && InvestorInfoUtil.getInstance().getInvestorInfosV3().size() > 0) {
            InvestorInfoBean investorInfoBean = InvestorInfoUtilControl.getInstance().getInvestorInfoBean();
            this.mInvestorInfoBean = investorInfoBean;
            if (investorInfoBean != null) {
                this.mZlPaymentJson = InvestorInfoUtilControl.getInstance().getZlPaymentJson(this.mTypeid);
                this.mPayPaymentFlag = InvestorInfoUtilControl.getInstance().getPayPaymentFlag(this.mTypeid);
                if (this.mZlPaymentJson != null) {
                    for (int i = 0; i < this.mZlPaymentJson.payPaymentList.size(); i++) {
                        if (this.mZlPaymentJson.payPaymentList.get(i).payFlag == 1) {
                            this.mPayFlagTypeList.add(Integer.valueOf(this.mZlPaymentJson.payPaymentList.get(i).payFlagType));
                            this.mPayPaymentBeanList.add(this.mZlPaymentJson.payPaymentList.get(i));
                        }
                    }
                    return;
                }
                ToastUtils.show(getContext(), "未设置单笔支付方式");
                finish();
                return;
            }
            return;
        }
        finish();
    }

    public void initView() {
        this.mApdater = new RecordsAdapter();
        this.mLvRecord.setOnItemClickListener(this);
        this.mLvRecord.setAdapter((ListAdapter) this.mApdater);
        this.mApdater.notifyDataSetChanged();
        for (int i = 0; i < this.mRecordListBeans.size(); i++) {
            this.mTotalMoney = this.mRecordListBeans.get(i).price + this.mTotalMoney;
        }
        this.mTvTotalMoney.setText("¥" + DecimalUtil.divide(this.mTotalMoney + "", "100"));
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.mIsEnable = true;
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        this.mIsEnable = false;
    }

    private void initClickListeners() {
        findViewById(R.id.btn_pay).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.order.NoPayOrderActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m386x649ceefc(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$0$client-android-yixiaotong-v3-ui-order-NoPayOrderActivity, reason: not valid java name */
    /* synthetic */ void m386x649ceefc(View view) {
        if (ClickUtil.isFastDoubleClick()) {
            return;
        }
        handlePayment();
    }

    private void handlePayment() {
        if (InvestorInfoUtilControl.getInstance().getPlanFlag(this.mTypeid) == 1) {
            this.mHasUnPayMergeOrder = false;
            payOrders();
        } else {
            OrderPayWayActivity.launch(getActivity(), this.mTypeid, this.mTotalMoney, this.mRecordListBeans);
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        Log.e("test", adapterView.getAdapter().toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:25:0x00f0  */
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
        if (this.mTypeInfoBaseInfoBean.typeId == 18) {
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
        V3BusinessControllers.getInstance().postPayOrders(getLoginAccount(), str4, this.mInvestorInfoBean.investorId, i5, i6, i7, this.mRecordListBeans, str, str2, i3, new Listener<NoPayOrderResultBean>() { // from class: client.android.yixiaotong.v3.ui.order.NoPayOrderActivity.1
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                BaseMaterialDialog.showMaterialDialog(NoPayOrderActivity.this.getActivity(), "请求支付中..", false);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, final NoPayOrderResultBean noPayOrderResultBean, Object... objArr) {
                if (NoPayOrderActivity.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    LogUtil.e("tag", "statusFlag:" + noPayOrderResultBean.statusFlag);
                    if (noPayOrderResultBean == null) {
                        ToastUtils.show(NoPayOrderActivity.this.getContext(), "数据异常");
                        return;
                    }
                    if (noPayOrderResultBean.statusFlag == 2) {
                        ToastUtils.show(NoPayOrderActivity.this.getContext(), "钱包支付成功！");
                        NoPayOrderActivity.this.finish();
                        return;
                    }
                    if (noPayOrderResultBean.statusFlag == 0) {
                        ToastUtils.show(NoPayOrderActivity.this.getContext(), "支付成功！");
                        NoPayOrderActivity.this.finish();
                    } else {
                        if (noPayOrderResultBean.hasUnPayMergeOrder) {
                            if (NoPayOrderActivity.this.mHasUnPayMergeOrder) {
                                SystemErrorTip.getInstance().showTipDialog(NoPayOrderActivity.this.getActivity(), noPayOrderResultBean.msg);
                                return;
                            } else if (noPayOrderResultBean.hasUnPayMergeOrder) {
                                OrderDetailDialog.getInstance().showDialog(NoPayOrderActivity.this.getActivity(), new OrderDetailDialog.Listener() { // from class: client.android.yixiaotong.v3.ui.order.NoPayOrderActivity.1.1
                                    @Override // client.android.yixiaotong.v3.ui.dialog.OrderDetailDialog.Listener
                                    public void onConfirm() {
                                        NoPayOrderActivity.this.mHasUnPayMergeOrder = true;
                                        NoPayOrderActivity.this.mRecordListBeans.clear();
                                        NoPayOrderActivity.this.mRecordListBeans.addAll(noPayOrderResultBean.orderInfo);
                                        NoPayOrderActivity.this.mOrderPayPaymentFlag = noPayOrderResultBean.paymentFlag;
                                        NoPayOrderActivity.this.mOrderPayFlag = noPayOrderResultBean.payFlag;
                                        NoPayOrderActivity.this.mOrderPayFlagType = noPayOrderResultBean.payFlagType;
                                        NoPayOrderActivity.this.payOrders();
                                    }

                                    @Override // client.android.yixiaotong.v3.ui.dialog.OrderDetailDialog.Listener
                                    public void onCancle() {
                                        NoPayOrderActivity.this.cancelOrder();
                                    }
                                }, noPayOrderResultBean.totalPrice, noPayOrderResultBean.mergeOrderId, noPayOrderResultBean.createTime);
                                return;
                            } else {
                                NoPayOrderActivity.this.pay(noPayOrderResultBean);
                                return;
                            }
                        }
                        NoPayOrderActivity.this.pay(noPayOrderResultBean);
                    }
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (NoPayOrderActivity.this.mIsEnable) {
                    NoPayOrderActivity.this.onError(clientException);
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
            AliPayUtils.pay(getActivity(), str, new AliPayUtils.OnPayListener() { // from class: client.android.yixiaotong.v3.ui.order.NoPayOrderActivity.2
                @Override // client.android.yixiaotong.alipay.AliPayUtils.OnPayListener
                public void paySuccess() {
                    ToastUtils.show(NoPayOrderActivity.this.getContext(), "支付成功");
                    NoPayOrderActivity.this.finish();
                }

                @Override // client.android.yixiaotong.alipay.AliPayUtils.OnPayListener
                public void payWaitting() {
                    ToastUtils.show(NoPayOrderActivity.this.getContext(), "正在等待支付结果,稍后会收到服务器确认的支付结果");
                }

                @Override // client.android.yixiaotong.alipay.AliPayUtils.OnPayListener
                public void payFail() {
                    ToastUtils.show(NoPayOrderActivity.this.getContext(), "支付失败");
                }
            });
            return;
        }
        if (noPayOrderResultBean.payInfo != null && StringUtils.isNotEmpty(noPayOrderResultBean.payInfo.appid)) {
            WxPayUtils.pay(getActivity(), noPayOrderResultBean.payInfo.appid, noPayOrderResultBean.payInfo.partnerid, noPayOrderResultBean.payInfo.prepayid, noPayOrderResultBean.payInfo.noncestr, noPayOrderResultBean.payInfo.timestamp, noPayOrderResultBean.payInfo.sign);
            finish();
            return;
        }
        if (noPayOrderResultBean.payInfo != null && noPayOrderResultBean.payInfo.msgBody != null) {
            if (noPayOrderResultBean.payInfo.msgBody.retCode.equals("00000")) {
                GnetePayConfig.builder().createWXAPI(getActivity(), "wxd9320c1760b6d01f");
                V3WalletControlUtil.getInstance().sendPayRequest(noPayOrderResultBean.payInfo.msgBody.chnlUrl, 0, this.mTypeid);
                finish();
                return;
            }
            SystemErrorTip.getInstance().showTipDialog(getActivity(), noPayOrderResultBean.payInfo.msgBody.retMsg);
            return;
        }
        List<PayPaymentBean> list = this.mPayPaymentBeanList;
        if (list != null && list.size() > 0 && this.mPayPaymentBeanList.get(this.mSelectWay) != null) {
            if (noPayOrderResultBean.payInfo != null) {
                if (this.mPayPaymentBeanList.get(this.mSelectWay).payFlagType == 1) {
                    WxPayUtils.pay(getActivity(), noPayOrderResultBean.payInfo.appid, noPayOrderResultBean.payInfo.partnerid, noPayOrderResultBean.payInfo.prepayid, noPayOrderResultBean.payInfo.noncestr, noPayOrderResultBean.payInfo.timestamp, noPayOrderResultBean.payInfo.sign);
                    finish();
                    return;
                }
                if (this.mPayPaymentBeanList.get(this.mSelectWay).payFlagType == 2) {
                    if (noPayOrderResultBean.payInfo.mode == 0) {
                        str = noPayOrderResultBean.payInfo.orderString;
                    } else if (noPayOrderResultBean.payInfo.mode == 1) {
                        str = noPayOrderResultBean.payInfo.tradeNo;
                    }
                    AliPayUtils.pay(getActivity(), str, new AliPayUtils.OnPayListener() { // from class: client.android.yixiaotong.v3.ui.order.NoPayOrderActivity.3
                        @Override // client.android.yixiaotong.alipay.AliPayUtils.OnPayListener
                        public void paySuccess() {
                            ToastUtils.show(NoPayOrderActivity.this.getContext(), "支付成功");
                            NoPayOrderActivity.this.finish();
                        }

                        @Override // client.android.yixiaotong.alipay.AliPayUtils.OnPayListener
                        public void payWaitting() {
                            ToastUtils.show(NoPayOrderActivity.this.getContext(), "正在等待支付结果,稍后会收到服务器确认的支付结果");
                        }

                        @Override // client.android.yixiaotong.alipay.AliPayUtils.OnPayListener
                        public void payFail() {
                            ToastUtils.show(NoPayOrderActivity.this.getContext(), "支付失败");
                        }
                    });
                    return;
                }
                if (this.mPayPaymentBeanList.get(this.mSelectWay).payFlagType == 3) {
                    if (noPayOrderResultBean.payInfo != null && noPayOrderResultBean.payInfo.msgBody != null && noPayOrderResultBean.payInfo.msgBody.retCode.equals("00000")) {
                        GnetePayConfig.builder().createWXAPI(getActivity(), "wxd9320c1760b6d01f");
                        V3WalletControlUtil.getInstance().sendPayRequest(noPayOrderResultBean.payInfo.msgBody.chnlUrl, 0, this.mTypeid);
                        finish();
                        return;
                    } else if (noPayOrderResultBean.payInfo != null && noPayOrderResultBean.payInfo.msgBody != null) {
                        SystemErrorTip.getInstance().showTipDialog(getActivity(), noPayOrderResultBean.payInfo.msgBody.retMsg);
                        return;
                    } else {
                        SystemErrorTip.getInstance().showTipDialog(getActivity(), "数据异常");
                        return;
                    }
                }
                return;
            }
            SystemErrorTip.getInstance().showTipDialog(getActivity(), "数据异常");
            return;
        }
        ToastUtils.show(getContext(), "支付成功！");
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancelOrder() {
        V3BusinessControllers.getInstance().postCancelPayOrders(getLoginAccount(), UserInfoUtil.getInstance().getLoginAccountV3().schoolInfoList.get(UserInfoUtil.getInstance().getSchoolInfosIndex()).id + "", this.mInvestorInfoBean.investorId, new Listener<NoPayOrderResultBean>() { // from class: client.android.yixiaotong.v3.ui.order.NoPayOrderActivity.4
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                BaseMaterialDialog.showMaterialDialog(NoPayOrderActivity.this.getActivity(), "正在取消订单", false);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, NoPayOrderResultBean noPayOrderResultBean, Object... objArr) {
                if (NoPayOrderActivity.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    ToastUtils.show(NoPayOrderActivity.this.getContext(), "取消成功，请尝试再次支付");
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (NoPayOrderActivity.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    NoPayOrderActivity.this.onError(clientException);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onError(ClientException clientException) {
        BaseMaterialDialog.dissmisMaterialDialog();
        if (clientException.isNeedTip(clientException.getCode())) {
            SystemErrorTip.getInstance().showTipDialog(getActivity(), new SystemErrorTip.SystemErrorDialogListener() { // from class: client.android.yixiaotong.v3.ui.order.NoPayOrderActivity.5
                @Override // client.android.yixiaotong.ui.dialog.SystemErrorTip.SystemErrorDialogListener
                public void onConfirm() {
                    NoPayOrderActivity.this.finish();
                }
            }, clientException.getDetail());
        } else {
            V3ErrorTipActivity.launch(getActivity(), this.mTitleBar.getTitleViewContent(), clientException.getDetail(), clientException.getCode(), 2, clientException.getSerial());
            finish();
        }
    }

    private class RecordsAdapter extends BaseAdapter {
        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        private RecordsAdapter() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return NoPayOrderActivity.this.mRecordListBeans.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return NoPayOrderActivity.this.mRecordListBeans.get(i);
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder viewHolder;
            if (view == null) {
                view = LayoutInflater.from(NoPayOrderActivity.this.getContext()).inflate(R.layout.layout_orderrecord_item_v3, (ViewGroup) null);
                viewHolder = new ViewHolder(view);
                view.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) view.getTag();
            }
            viewHolder.tv_type.setText(NoPayOrderActivity.this.mAppName);
            NoPayOrderBean noPayOrderBean = (NoPayOrderBean) getItem(i);
            viewHolder.tv_orderid.setText(NoPayOrderActivity.this.getString(R.string.orderno) + noPayOrderBean.orderId);
            viewHolder.tv_money.setText("¥" + DecimalUtil.divide(noPayOrderBean.price + "", "100"));
            viewHolder.tv_time.setText(noPayOrderBean.posDatetime);
            viewHolder.tv_state.setText(NoPayOrderActivity.this.getString(R.string.nopay));
            viewHolder.tv_state.setTextColor(NoPayOrderActivity.this.getResources().getColor(R.color.fff3382a));
            return view;
        }

        class ViewHolder {
            public TextView tv_money;
            public TextView tv_orderid;
            public TextView tv_state;
            public TextView tv_time;
            public TextView tv_type;

            public ViewHolder(View view) {
                this.tv_orderid = (TextView) view.findViewById(R.id.tv_orderid);
                this.tv_type = (TextView) view.findViewById(R.id.tv_type);
                this.tv_money = (TextView) view.findViewById(R.id.tv_money);
                this.tv_time = (TextView) view.findViewById(R.id.tv_time);
                this.tv_state = (TextView) view.findViewById(R.id.tv_state);
            }
        }
    }
}
