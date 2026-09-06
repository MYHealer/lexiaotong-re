package client.android.yixiaotong.v3.ui.card;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
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
import client.android.yixiaotong.ui.widget.WrapListView;
import client.android.yixiaotong.util.DecimalUtil;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.v3.bean.card.BuyClubCardBean;
import client.android.yixiaotong.v3.bean.card.CreateOrderBean;
import client.android.yixiaotong.v3.bean.login.InvestorInfoBean;
import client.android.yixiaotong.v3.bean.login.PlanInfoBean;
import client.android.yixiaotong.v3.bean.login.TypeInfoBaseInfoBean;
import client.android.yixiaotong.v3.bean.login.TypeInfoBean;
import client.android.yixiaotong.v3.bean.wallet.YiKaTongPayModelParameterBean;
import client.android.yixiaotong.v3.http.V3BusinessControllers;
import client.android.yixiaotong.v3.ui.dialog.ICBCPayWayDialog;
import client.android.yixiaotong.v3.ui.error.V3ErrorTipActivity;
import client.android.yixiaotong.v3.ui.wallet.controlutil.V3WalletControlUtil;
import client.android.yixiaotong.v3.userinfo.InvestorInfoUtil;
import client.android.yixiaotong.v3.userinfo.InvestorInfoUtilControl;
import client.android.yixiaotong.v3.userinfo.UserInfoUtil;
import client.android.yixiaotong.v3.util.ClickUtil;
import client.android.yixiaotong.v3.util.LanguageUtils;
import client.android.yixiaotong.v3.util.LocalDataUtil;
import client.android.yixiaotong.v3.util.LogUtil;
import client.android.yixiaotong.wxapi.WxPayUtils;
import com.gnete.upbc.cashier.GnetePayConfig;
import com.huawei.openalliance.ad.views.PPSLabelView;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class BuyCardDetailActivity extends BaseActivity implements AdapterView.OnItemClickListener {
    private static final String TAG = "BuyCardDetailActivity";
    private Button mBtnBuyCard;
    private BuyClubCardBean mBuyClubCardBean;
    private InvestorInfoBean mInvestorInfoBean;
    private LinearLayout mLinPayWay;
    private WrapListView mLvRechargeWay;
    private RechargeWayAdapter mRechargeWayAdapter;
    private RelativeLayout mRelCardBg;
    private TitleBar mTitleBar;
    private TextView mTvDiscount;
    private TextView mTvMoney;
    private TextView mTvName;
    private TextView mTvServerName;
    private TextView mTvUseServer;
    private TextView mTvUseTime;
    private TextView mTvUseType;
    private TypeInfoBaseInfoBean mTypeInfoBaseInfoBean;
    private int mSelectWay = 0;
    private List<Integer> mPayFlagTypeList = new ArrayList();
    private int mGiveId = -1;
    private int mOrderCount = 1;
    private boolean mIsEnable = true;
    private int mICBCIndex = 1;

    static {
        StubApp.interface11(9631);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    static /* synthetic */ int access$1608(BuyCardDetailActivity buyCardDetailActivity) {
        int i = buyCardDetailActivity.mOrderCount;
        buyCardDetailActivity.mOrderCount = i + 1;
        return i;
    }

    public static void launch(Activity activity, BuyClubCardBean buyClubCardBean, TypeInfoBaseInfoBean typeInfoBaseInfoBean) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) BuyCardDetailActivity.class).putExtra("bean", buyClubCardBean).putExtra("bean2", typeInfoBaseInfoBean));
        }
    }

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.titleBar);
        this.mRelCardBg = (RelativeLayout) findViewById(R.id.rel_bg);
        this.mTvName = (TextView) findViewById(R.id.tv_name);
        this.mTvServerName = (TextView) findViewById(R.id.tv_servername);
        this.mTvMoney = (TextView) findViewById(R.id.tv_money);
        this.mTvUseTime = (TextView) findViewById(R.id.tv_usetime);
        this.mTvDiscount = (TextView) findViewById(R.id.tv_discount);
        this.mTvUseType = (TextView) findViewById(R.id.tv_usetype);
        this.mTvUseServer = (TextView) findViewById(R.id.tv_useserver);
        this.mBtnBuyCard = (Button) findViewById(R.id.btn_buycard);
        this.mLvRechargeWay = (WrapListView) findViewById(R.id.listview);
        this.mLinPayWay = (LinearLayout) findViewById(R.id.lin_payway);
    }

    private void initTitleBar() {
        this.mTitleBar.setTitleView(getString(R.string.buydiscard));
        this.mTitleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
    }

    private void initAdapter() {
        initData();
        this.mRechargeWayAdapter = new RechargeWayAdapter();
        this.mLvRechargeWay.setOnItemClickListener(this);
        this.mLvRechargeWay.setAdapter((ListAdapter) this.mRechargeWayAdapter);
        this.mRechargeWayAdapter.notifyDataSetChanged();
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.mIsEnable = true;
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        this.mIsEnable = false;
        BaseMaterialDialog.dissmisMaterialDialog();
    }

    private void initClickListeners() {
        findViewById(R.id.tv_rule).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.card.BuyCardDetailActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m319xfb1fb760(view);
            }
        });
        findViewById(R.id.btn_cancel).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.card.BuyCardDetailActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m320x12382bf(view);
            }
        });
        findViewById(R.id.btn_buycard).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.card.BuyCardDetailActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m321x7274e1e(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$0$client-android-yixiaotong-v3-ui-card-BuyCardDetailActivity, reason: not valid java name */
    /* synthetic */ void m319xfb1fb760(View view) {
        CardRuleActivity.launch(getActivity());
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$1$client-android-yixiaotong-v3-ui-card-BuyCardDetailActivity, reason: not valid java name */
    /* synthetic */ void m320x12382bf(View view) {
        finish();
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$2$client-android-yixiaotong-v3-ui-card-BuyCardDetailActivity, reason: not valid java name */
    /* synthetic */ void m321x7274e1e(View view) {
        if (ClickUtil.isFastDoubleClick()) {
            return;
        }
        if (this.mPayFlagTypeList.get(this.mSelectWay).intValue() == 12) {
            ToastUtils.show(getActivity(), "请选择支付方式");
        } else {
            this.mOrderCount = 1;
            buyCard();
        }
    }

    private void initData() {
        InvestorInfoBean investorInfoBean = InvestorInfoUtilControl.getInstance().getInvestorInfoBean();
        this.mInvestorInfoBean = investorInfoBean;
        if (investorInfoBean == null) {
            finish();
        }
        this.mPayFlagTypeList.add(1);
        this.mPayFlagTypeList.add(2);
    }

    private void initView() {
        String string;
        this.mRelCardBg.setBackgroundResource(R.mipmap.bg1);
        if (this.mBuyClubCardBean.cardGroup == 1) {
            string = getString(R.string.weeklycard);
            this.mRelCardBg.setBackgroundResource(R.mipmap.bg2);
        } else if (this.mBuyClubCardBean.cardGroup == 2) {
            string = getString(R.string.monthlycard);
            this.mRelCardBg.setBackgroundResource(R.mipmap.bg3);
        } else if (this.mBuyClubCardBean.cardGroup == 3) {
            string = getString(R.string.seasoncard);
            this.mRelCardBg.setBackgroundResource(R.mipmap.bg4);
        } else if (this.mBuyClubCardBean.cardGroup == 4) {
            string = getString(R.string.yearcard);
            this.mRelCardBg.setBackgroundResource(R.mipmap.bg5);
        } else {
            string = "";
        }
        if (this.mBuyClubCardBean.discountValue != 100) {
            if (this.mBuyClubCardBean.discountValue == 0) {
                string = getString(R.string.free) + PPSLabelView.Code + string;
            } else {
                string = (this.mBuyClubCardBean.discountValue / 10.0f) + getString(R.string.discount2) + PPSLabelView.Code + string;
            }
        }
        this.mTvName.setText(string);
        this.mTvServerName.setText(InvestorInfoUtil.getInstance().getInvestorInfosV3().get(InvestorInfoUtil.getInstance().getInvestorInfosIndex()).investorInfo.providerJson.providerName);
        this.mTvMoney.setText(DecimalUtil.divide(this.mBuyClubCardBean.howmuchMoney + "", "100"));
        if (this.mBuyClubCardBean.discountValue == 100) {
            this.mTvDiscount.setText(getString(R.string.notfree));
        } else if (this.mBuyClubCardBean.discountValue == 0) {
            this.mTvDiscount.setText(getString(R.string.free));
        } else {
            float f = this.mBuyClubCardBean.discountValue / 10.0f;
            String str = f + getString(R.string.discount2) + PPSLabelView.Code;
            this.mTvDiscount.setText(f + getString(R.string.discount2));
        }
        if (this.mBuyClubCardBean.typeidJsonb != null && this.mBuyClubCardBean.typeidJsonb.size() > 0) {
            StringBuilder sb = new StringBuilder();
            ArrayList arrayList = new ArrayList();
            List<PlanInfoBean> list = InvestorInfoUtil.getInstance().getInvestorInfosV3().get(InvestorInfoUtil.getInstance().getInvestorInfosIndex()).investorInfo.planInfo;
            if (list != null && list.size() > 0) {
                for (int i = 0; i < list.size(); i++) {
                    List<TypeInfoBean> list2 = list.get(i).typeInfo;
                    if (list2 != null && list2.size() > 0) {
                        for (int i2 = 0; i2 < list2.size(); i2++) {
                            arrayList.add(list.get(i).typeInfo.get(i2));
                        }
                    }
                }
            }
            for (int i3 = 0; i3 < this.mBuyClubCardBean.typeidJsonb.size(); i3++) {
                for (int i4 = 0; i4 < arrayList.size(); i4++) {
                    LogUtil.e(TAG, i3 + "  " + i4 + "  " + this.mBuyClubCardBean.typeidJsonb.get(i3) + "  " + ((TypeInfoBean) arrayList.get(i4)).base.typeId + "  " + sb.toString().contains(((TypeInfoBean) arrayList.get(i4)).base.appName));
                    if (this.mBuyClubCardBean.typeidJsonb.get(i3).intValue() == ((TypeInfoBean) arrayList.get(i4)).base.typeId && !sb.toString().contains(((TypeInfoBean) arrayList.get(i4)).base.appName)) {
                        sb.append(LanguageUtils.getAppName(getActivity(), ((TypeInfoBean) arrayList.get(i4)).base.typeId, ((TypeInfoBean) arrayList.get(i4)).base.appName) + "/");
                    }
                }
            }
            if (sb.length() > 1) {
                this.mTvUseType.setText(sb.toString().substring(0, sb.length() - 1));
            }
        }
        this.mTvUseServer.setText(this.mTvServerName.getText().toString());
        if (this.mBuyClubCardBean.howmuchMoney == 0) {
            this.mLinPayWay.setVisibility(8);
            this.mBtnBuyCard.setText(getString(R.string.freecardcollection));
        } else {
            this.mBtnBuyCard.setText(getString(R.string.pay2) + DecimalUtil.divide(this.mBuyClubCardBean.howmuchMoney + "", "100") + getString(R.string.yuan));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buyCard() {
        YiKaTongPayModelParameterBean yiKaTongPayModelParameterBean;
        String str = UserInfoUtil.getInstance().getLoginAccountV3().schoolInfoList.get(UserInfoUtil.getInstance().getSchoolInfosIndex()).id + "";
        long j = this.mBuyClubCardBean.id;
        int i = this.mBuyClubCardBean.howmuchMoney;
        final int iIntValue = this.mPayFlagTypeList.get(this.mSelectWay).intValue();
        if (iIntValue == 12) {
            yiKaTongPayModelParameterBean = new YiKaTongPayModelParameterBean();
            yiKaTongPayModelParameterBean.channelType = this.mICBCIndex;
        } else {
            yiKaTongPayModelParameterBean = null;
        }
        V3BusinessControllers.getInstance().postCreateOrders(getLoginAccount(), str, this.mInvestorInfoBean.investorId, 3, j, this.mGiveId, i, iIntValue, yiKaTongPayModelParameterBean, new Listener<CreateOrderBean>() { // from class: client.android.yixiaotong.v3.ui.card.BuyCardDetailActivity.1
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                BaseMaterialDialog.showMaterialDialog(BuyCardDetailActivity.this.getActivity(), "下单中.", false);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, CreateOrderBean createOrderBean, Object... objArr) {
                String str2;
                if (BuyCardDetailActivity.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    if (createOrderBean != null) {
                        LocalDataUtil.saveIsNeedGetWalletInfo(BuyCardDetailActivity.this.getContext(), true);
                        if (iIntValue == 1 && createOrderBean.payInfo != null && StringUtils.isNotEmpty(createOrderBean.payInfo.appid)) {
                            WxPayUtils.pay(BuyCardDetailActivity.this.getActivity(), createOrderBean.payInfo.appid, createOrderBean.payInfo.partnerid, createOrderBean.payInfo.prepayid, createOrderBean.payInfo.noncestr, createOrderBean.payInfo.timestamp, createOrderBean.payInfo.sign);
                            BuyCardDetailActivity.this.finish();
                            return;
                        }
                        if (iIntValue == 2 && createOrderBean.payInfo != null && (StringUtils.isNotEmpty(createOrderBean.payInfo.tradeNo) || StringUtils.isNotEmpty(createOrderBean.payInfo.orderString))) {
                            if (createOrderBean.payInfo.mode == 0) {
                                str2 = createOrderBean.payInfo.orderString;
                            } else {
                                str2 = createOrderBean.payInfo.mode == 1 ? createOrderBean.payInfo.tradeNo : "";
                            }
                            AliPayUtils.pay(BuyCardDetailActivity.this.getActivity(), str2, new AliPayUtils.OnPayListener() { // from class: client.android.yixiaotong.v3.ui.card.BuyCardDetailActivity.1.1
                                @Override // client.android.yixiaotong.alipay.AliPayUtils.OnPayListener
                                public void paySuccess() {
                                    ToastUtils.show(BuyCardDetailActivity.this.getContext(), "支付成功");
                                    BuyCardDetailActivity.this.finish();
                                }

                                @Override // client.android.yixiaotong.alipay.AliPayUtils.OnPayListener
                                public void payWaitting() {
                                    ToastUtils.show(BuyCardDetailActivity.this.getContext(), "正在等待支付结果,稍后会收到服务器确认的支付结果");
                                }

                                @Override // client.android.yixiaotong.alipay.AliPayUtils.OnPayListener
                                public void payFail() {
                                    ToastUtils.show(BuyCardDetailActivity.this.getContext(), "支付失败");
                                }
                            });
                            return;
                        }
                        if (iIntValue == 3 && createOrderBean.payInfo != null && createOrderBean.payInfo.msgBody != null) {
                            if (createOrderBean.payInfo.msgBody.retCode.equals("00000")) {
                                GnetePayConfig.builder().createWXAPI(BuyCardDetailActivity.this.getActivity(), "wxd9320c1760b6d01f");
                                V3WalletControlUtil.getInstance().sendPayRequest(createOrderBean.payInfo.msgBody.chnlUrl, 0, 0);
                                BuyCardDetailActivity.this.finish();
                                return;
                            }
                            SystemErrorTip.getInstance().showTipDialog(BuyCardDetailActivity.this.getActivity(), createOrderBean.payInfo.msgBody.retMsg);
                            return;
                        }
                        if (iIntValue != 12 || createOrderBean.payInfo == null) {
                            ToastUtils.show(BuyCardDetailActivity.this.getContext(), "购卡成功");
                            BuyCardDetailActivity.this.finish();
                        } else {
                            ICBCPayUtils.payAll(BuyCardDetailActivity.this.mICBCIndex, createOrderBean.payInfo.appId, BuyCardDetailActivity.this.getActivity(), ICBCPayUtils.getUnionPayReq(createOrderBean.payInfo.appId, createOrderBean.payInfo.msgId, createOrderBean.payInfo.format, createOrderBean.payInfo.charset, createOrderBean.payInfo.encryptType, createOrderBean.payInfo.signType, createOrderBean.payInfo.merSignMsg, createOrderBean.payInfo.timestamp, createOrderBean.payInfo.ca, createOrderBean.payInfo.tranData, createOrderBean.payInfo.encryptKey), new ICBCPayUtils.OnPayListener() { // from class: client.android.yixiaotong.v3.ui.card.BuyCardDetailActivity.1.2
                                @Override // client.android.yixiaotong.icbcPay.ICBCPayUtils.OnPayListener
                                public void paySuccess() {
                                    ToastUtils.show(BuyCardDetailActivity.this.getContext(), "支付成功");
                                    BuyCardDetailActivity.this.finish();
                                }

                                @Override // client.android.yixiaotong.icbcPay.ICBCPayUtils.OnPayListener
                                public void payWaitting() {
                                    ToastUtils.show(BuyCardDetailActivity.this.getContext(), "正在等待支付结果,稍后会收到服务器确认的支付结果");
                                }

                                @Override // client.android.yixiaotong.icbcPay.ICBCPayUtils.OnPayListener
                                public void payFail() {
                                    ToastUtils.show(BuyCardDetailActivity.this.getContext(), "支付失败");
                                }
                            });
                        }
                    }
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (BuyCardDetailActivity.this.mIsEnable) {
                    if (clientException.getCode() != -46 || BuyCardDetailActivity.this.mOrderCount != 1) {
                        BuyCardDetailActivity.this.onError(clientException);
                    } else {
                        BuyCardDetailActivity.access$1608(BuyCardDetailActivity.this);
                        BuyCardDetailActivity.this.buyCard();
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onError(ClientException clientException) {
        BaseMaterialDialog.dissmisMaterialDialog();
        if (clientException.isNeedTip(clientException.getCode())) {
            SystemErrorTip.getInstance().showTipDialog(getActivity(), clientException.getDetail());
        } else {
            V3ErrorTipActivity.launch(getActivity(), this.mTitleBar.getTitleViewContent(), clientException.getDetail(), clientException.getCode(), 2, clientException.getSerial());
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.mSelectWay = i;
        this.mRechargeWayAdapter.notifyDataSetChanged();
        if (this.mPayFlagTypeList.get(this.mSelectWay).intValue() == 12) {
            ICBCPayWayDialog.getInstance().showDialog(getActivity(), new ICBCPayWayDialog.Listener() { // from class: client.android.yixiaotong.v3.ui.card.BuyCardDetailActivity.2
                @Override // client.android.yixiaotong.v3.ui.dialog.ICBCPayWayDialog.Listener
                public void onPay(int i2) {
                    BuyCardDetailActivity.this.mICBCIndex = i2;
                    BuyCardDetailActivity.this.mOrderCount = 1;
                    BuyCardDetailActivity.this.buyCard();
                }
            }, DecimalUtil.divide(this.mBuyClubCardBean.howmuchMoney + "", "100"));
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
            return BuyCardDetailActivity.this.mPayFlagTypeList.size();
        }

        @Override // android.widget.Adapter
        public Integer getItem(int i) {
            return (Integer) BuyCardDetailActivity.this.mPayFlagTypeList.get(i);
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder viewHolder;
            if (view == null) {
                view = LayoutInflater.from(BuyCardDetailActivity.this.getContext()).inflate(R.layout.layout_rechargeway_item, viewGroup, false);
                viewHolder = new ViewHolder(view);
                view.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) view.getTag();
            }
            int iIntValue = getItem(i).intValue();
            viewHolder.img2.setImageResource(R.mipmap.wxz);
            if (iIntValue == 1) {
                viewHolder.img.setImageResource(R.mipmap.wx);
                viewHolder.tv_name.setText(BuyCardDetailActivity.this.getString(R.string.wechatpay));
            } else if (iIntValue == 2) {
                viewHolder.img.setImageResource(R.mipmap.zfb);
                viewHolder.tv_name.setText(BuyCardDetailActivity.this.getString(R.string.alipaymeny));
            } else if (iIntValue == 3) {
                viewHolder.img.setImageResource(R.mipmap.yl);
                viewHolder.tv_name.setText(BuyCardDetailActivity.this.getString(R.string.unionpayment));
            }
            if (BuyCardDetailActivity.this.mSelectWay == i) {
                viewHolder.img2.setImageResource(R.mipmap.xz1);
            }
            if (iIntValue == 12) {
                viewHolder.img.setImageResource(R.mipmap.icbc);
                viewHolder.tv_name.setText(BuyCardDetailActivity.this.getString(R.string.icbcjhzf));
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
