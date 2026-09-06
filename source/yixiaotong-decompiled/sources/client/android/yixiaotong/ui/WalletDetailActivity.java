package client.android.yixiaotong.ui;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.alipay.AliPayUtils;
import client.android.yixiaotong.controller.BusinessControllers;
import client.android.yixiaotong.controller.bean.AliPayBean;
import client.android.yixiaotong.controller.bean.SuccessBean;
import client.android.yixiaotong.controller.bean.UnionPayBean;
import client.android.yixiaotong.controller.bean.WeiXinPayBean;
import client.android.yixiaotong.controller.bean.pay.ABCPayBean;
import client.android.yixiaotong.controller.bean.recharge.RechargeDetailBean;
import client.android.yixiaotong.controller.bean.recharge.RechargeDetailListBean;
import client.android.yixiaotong.controller.bean.recharge.RechargeInfoBean;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.controller.error.ErrorUtil;
import client.android.yixiaotong.controller.model.WalletModel;
import client.android.yixiaotong.event.BalanceSyncEvent;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.ui.adapter.RechargeRecordAdapter;
import client.android.yixiaotong.ui.card.CardRecordActivity;
import client.android.yixiaotong.ui.dialog.AppTipDialog;
import client.android.yixiaotong.ui.dialog.BaseMaterialDialog;
import client.android.yixiaotong.ui.dialog.SystemErrorTip;
import client.android.yixiaotong.ui.dialog.TwoButtonDialog;
import client.android.yixiaotong.ui.refund.Refund2Activity;
import client.android.yixiaotong.ui.scancode.ScanQrcodeOrBarcodeActivity;
import client.android.yixiaotong.ui.scancode.ZxingScanActivity;
import client.android.yixiaotong.ui.unionpay.AlipayActivity;
import client.android.yixiaotong.ui.unionpay.UnionWebActivity;
import client.android.yixiaotong.ui.wallet.BalanceDetailActivity;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.ui.widget.WrapGridView;
import client.android.yixiaotong.util.AppUtils;
import client.android.yixiaotong.util.DecimalUtil;
import client.android.yixiaotong.util.EventBusUtil;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.util.android.LocalPreferencesHelper;
import client.android.yixiaotong.util.android.NetworkUtils;
import client.android.yixiaotong.util.permission.PermissionUtil;
import client.android.yixiaotong.wxapi.WxPayUtils;
import com.android.volley.VolleyError;
import com.cdo.oaps.ad.wrapper.BaseWrapper;
import com.example.caller.BankABCCaller;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.masget.base.ApiConfig;
import com.masget.base.volley.JSONResponseHandler;
import com.masget.base.volley.VolleyRequestNew;
import com.stub.StubApp;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public class WalletDetailActivity extends BaseActivity implements AdapterView.OnItemClickListener {
    public static final String EXTRA_WALLET = "extra_wallet";
    ImageView imgabc;
    ImageView imgali;
    ImageView imgunion;
    ImageView imgweixin;
    TextView mBtnButie;
    TextView mBtnChongzhi;
    Button mBtnRefund;
    RelativeLayout mImgABC;
    ImageView mImgSelectABC;
    ImageView mImgSelectAli;
    ImageView mImgSelectUnion;
    ImageView mImgSelectWeiXin;
    RelativeLayout mImgUnionAlipay;
    RelativeLayout mImgUnionOnline;
    RelativeLayout mImgUnionWechat;
    LinearLayout mLinCard;
    LinearLayout mLinLineCard;
    WrapGridView mListView;
    private RechargeRecordAdapter mRechargeRecordAdapter;
    RelativeLayout mRelChongzhi;
    RelativeLayout mRelPayWay;
    RelativeLayout mRelTip;
    RelativeLayout mRelToWalletDetaill;
    TextView mTextJiner;
    TextView mTvBalance;
    TextView mTvBalanceText1;
    EditText mTvMoney;
    TextView mTvMoney1;
    TextView mTvRefundRecord;
    TextView mTvServerMobile;
    TextView mTvTip;
    TextView mTvWalletText;
    TitleBar mVTitleBar;
    View mView1;
    View mView2;
    private WalletModel mWalletModel;
    ScrollView scrollview;
    TextView textabc;
    TextView textali;
    TextView textunion;
    TextView textweixin;
    private int mPayWay = 1;
    private boolean mIsCardChongzhi = false;
    private boolean mIsEnable = true;
    private int mRechargeState = -2;
    private int mRechargeType = 1;
    private String mRechargeContent = "";
    private String mRechargeTime = "";
    private boolean mOpenPayType = true;
    private List<RechargeDetailBean> mListData = new ArrayList();
    private boolean mIsServerData = false;
    private PermissionUtil.PermissionGrant permissionGrant = new PermissionUtil.PermissionGrant() { // from class: client.android.yixiaotong.ui.WalletDetailActivity.21
        @Override // client.android.yixiaotong.util.permission.PermissionUtil.PermissionGrant
        public void onPermissionGranted(int i) {
            if (i == 0) {
                PermissionUtil.requestPerssion(WalletDetailActivity.this.getActivity(), 2, WalletDetailActivity.this.permissionGrant);
                return;
            }
            if (i == 2) {
                PermissionUtil.requestPerssion(WalletDetailActivity.this.getActivity(), 3, WalletDetailActivity.this.permissionGrant);
            } else {
                if (i != 3) {
                    return;
                }
                if (AppUtils.isUserHuaWeiScan()) {
                    ScanQrcodeOrBarcodeActivity.launch(WalletDetailActivity.this.getActivity(), WalletDetailActivity.this.mWalletModel, WalletDetailActivity.this.mTvMoney.getText().toString(), 2);
                } else {
                    ZxingScanActivity.launch(WalletDetailActivity.this.getActivity(), WalletDetailActivity.this.mWalletModel, WalletDetailActivity.this.mTvMoney.getText().toString(), 2);
                }
            }
        }
    };

    static {
        StubApp.interface11(6110);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public native void onRequestPermissionsResult(int i, String[] strArr, int[] iArr);

    private void initViewNew() {
        this.mVTitleBar = (TitleBar) findViewById(R.id.v_titleBar);
        this.mTvMoney = (EditText) findViewById(R.id.edt_money);
        this.mImgUnionAlipay = (RelativeLayout) findViewById(R.id.v_btn_union_alipay);
        this.mImgUnionWechat = (RelativeLayout) findViewById(R.id.v_btn_union_wechat);
        this.mImgUnionOnline = (RelativeLayout) findViewById(R.id.v_btn_union_online);
        this.mImgABC = (RelativeLayout) findViewById(R.id.v_btn_abc);
        this.mLinCard = (LinearLayout) findViewById(R.id.lin_card);
        this.mLinLineCard = (LinearLayout) findViewById(R.id.lin_lin_card);
        this.mBtnChongzhi = (TextView) findViewById(R.id.btn_chongzhi);
        this.mBtnButie = (TextView) findViewById(R.id.btn_butie);
        this.mView1 = findViewById(R.id.view1);
        this.mView2 = findViewById(R.id.view2);
        this.mTvBalance = (TextView) findViewById(R.id.tv_balance);
        this.imgweixin = (ImageView) findViewById(R.id.img);
        this.imgali = (ImageView) findViewById(R.id.img1);
        this.imgunion = (ImageView) findViewById(R.id.img2);
        this.imgabc = (ImageView) findViewById(R.id.img3);
        this.textweixin = (TextView) findViewById(R.id.textweixin);
        this.textali = (TextView) findViewById(R.id.textali);
        this.textunion = (TextView) findViewById(R.id.textunion);
        this.textabc = (TextView) findViewById(R.id.textabc);
        this.mRelPayWay = (RelativeLayout) findViewById(R.id.rel_payway);
        this.mTextJiner = (TextView) findViewById(R.id.textjiner);
        this.mRelChongzhi = (RelativeLayout) findViewById(R.id.rel_chongzhi);
        this.mImgSelectAli = (ImageView) findViewById(R.id.img_select_ali);
        this.mImgSelectWeiXin = (ImageView) findViewById(R.id.img_select_weixin);
        this.mImgSelectUnion = (ImageView) findViewById(R.id.img_select_union);
        this.mImgSelectABC = (ImageView) findViewById(R.id.img_select_abc);
        this.mTvMoney1 = (TextView) findViewById(R.id.tv_money1);
        this.scrollview = (ScrollView) findViewById(R.id.scrollview);
        this.mTvTip = (TextView) findViewById(R.id.tv_tip);
        this.mRelTip = (RelativeLayout) findViewById(R.id.rel_tip);
        this.mTvRefundRecord = (TextView) findViewById(R.id.tv_refundrecord);
        this.mListView = (WrapGridView) findViewById(R.id.lv_chongzhi);
        this.mBtnRefund = (Button) findViewById(R.id.btn_refund);
        this.mTvServerMobile = (TextView) findViewById(R.id.tv_servertelephone);
        this.mTvBalanceText1 = (TextView) findViewById(R.id.tv_balancetext1);
        this.mRelToWalletDetaill = (RelativeLayout) findViewById(R.id.rel_towalletdetail);
        this.mTvWalletText = (TextView) findViewById(R.id.tv_appname);
    }

    public static void launch(Activity activity, WalletModel walletModel) {
        Intent intent = new Intent(activity, (Class<?>) WalletDetailActivity.class);
        intent.putExtra("extra_wallet", walletModel);
        activity.startActivity(intent);
    }

    private void showDialog() {
        BaseMaterialDialog.showMaterialDialog(getActivity(), "连接中...", false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dismissDialog() {
        BaseMaterialDialog.dissmisMaterialDialog();
    }

    /* JADX INFO: renamed from: client.android.yixiaotong.ui.WalletDetailActivity$1, reason: invalid class name */
    class AnonymousClass1 implements ViewTreeObserver.OnGlobalLayoutListener {
        final /* synthetic */ int[] val$lastLocation;

        AnonymousClass1(int[] iArr) {
            this.val$lastLocation = iArr;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            WalletDetailActivity walletDetailActivity = WalletDetailActivity.this;
            walletDetailActivity.doScrollEvent(walletDetailActivity.scrollview, this.val$lastLocation, WalletDetailActivity.this.mTvMoney);
        }
    }

    private void initClickListeners() {
        findViewById(R.id.tv_refundrecord).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.WalletDetailActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                RefundRecordActivity.launch(WalletDetailActivity.this.getActivity(), WalletDetailActivity.this.mWalletModel);
            }
        });
        findViewById(R.id.rel_towalletdetail).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.WalletDetailActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BalanceDetailActivity.launch(WalletDetailActivity.this.getActivity(), WalletDetailActivity.this.mWalletModel);
            }
        });
        findViewById(R.id.btn_refund).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.WalletDetailActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WalletDetailActivity.this.refund();
            }
        });
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (!NetworkUtils.isNetworkAvailable(getContext())) {
            ToastUtils.show(getContext(), "请检查网络后重试");
            return;
        }
        RechargeDetailBean item = this.mRechargeRecordAdapter.getItem(i);
        this.mTvMoney.setText("");
        this.mTvMoney1.setText(item.recharge);
        this.mRechargeRecordAdapter.setIndex(i);
        this.mRechargeRecordAdapter.notifyDataSetChanged();
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
    }

    private void initRecharge() {
        this.mIsServerData = false;
        this.mRechargeRecordAdapter.setServerData(false);
        ArrayList arrayList = new ArrayList();
        RechargeDetailBean rechargeDetailBean = new RechargeDetailBean();
        rechargeDetailBean.gift = "0";
        rechargeDetailBean.recharge = "5";
        arrayList.add(rechargeDetailBean);
        RechargeDetailBean rechargeDetailBean2 = new RechargeDetailBean();
        rechargeDetailBean2.gift = "0";
        rechargeDetailBean2.recharge = "10";
        arrayList.add(rechargeDetailBean2);
        RechargeDetailBean rechargeDetailBean3 = new RechargeDetailBean();
        rechargeDetailBean3.gift = "0";
        rechargeDetailBean3.recharge = BaseWrapper.ENTER_ID_SYSTEM_HELPER;
        arrayList.add(rechargeDetailBean3);
        RechargeDetailBean rechargeDetailBean4 = new RechargeDetailBean();
        rechargeDetailBean4.gift = "0";
        rechargeDetailBean4.recharge = "50";
        arrayList.add(rechargeDetailBean4);
        this.mTvMoney1.setText("5");
        this.mListData.clear();
        this.mListData.addAll(arrayList);
        this.mRechargeRecordAdapter.notifyDataSetChanged();
    }

    private void initRechargerInfo() {
        initRecharge();
        BusinessControllers.getInstance().getRechargeGiftInfo(getLoginAccount(), this.mWalletModel.typeId, new Listener<RechargeDetailListBean>() { // from class: client.android.yixiaotong.ui.WalletDetailActivity.5
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, RechargeDetailListBean rechargeDetailListBean, Object... objArr) {
                if (rechargeDetailListBean == null || rechargeDetailListBean.giftRules.size() <= 0) {
                    return;
                }
                Iterator<RechargeDetailBean> it = rechargeDetailListBean.giftRules.iterator();
                while (it.hasNext()) {
                    if (Float.parseFloat(it.next().gift) != 0.0f) {
                        WalletDetailActivity.this.mIsServerData = true;
                    }
                }
                WalletDetailActivity.this.mRechargeRecordAdapter.setServerData(WalletDetailActivity.this.mIsServerData);
                WalletDetailActivity.this.mTvMoney1.setText(rechargeDetailListBean.giftRules.get(0).recharge);
                WalletDetailActivity.this.mListData.clear();
                WalletDetailActivity.this.mListData.addAll(rechargeDetailListBean.giftRules);
                WalletDetailActivity.this.mRechargeRecordAdapter.notifyDataSetChanged();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doScrollEvent(ScrollView scrollView, int[] iArr, EditText... editTextArr) {
        Rect rect = new Rect();
        scrollView.getWindowVisibleDisplayFrame(rect);
        int height = scrollView.getHeight() - rect.bottom;
        int scrollY = scrollView.getScrollY();
        for (EditText editText : editTextArr) {
            if (editText.isFocused()) {
                if (height > 100) {
                    int[] iArr2 = new int[2];
                    iArr[0] = scrollY;
                    editText.getLocationInWindow(iArr2);
                    int height2 = editText.getHeight();
                    if (iArr2[1] + height2 > rect.bottom) {
                        scrollView.scrollBy(0, (iArr2[1] + height2) - rect.bottom);
                        return;
                    }
                    return;
                }
                int i = iArr[0];
                if (i != scrollY) {
                    scrollView.scrollTo(0, i);
                }
                iArr[0] = scrollView.getScrollY();
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onlyWeixin() {
        this.mPayWay = 1;
        this.mImgUnionAlipay.setBackgroundResource(R.mipmap.l_chongzhi_unselectbackground);
        this.mImgUnionWechat.setBackgroundResource(R.mipmap.l_chongzhi_selectbackground);
        this.mImgUnionOnline.setBackgroundResource(R.mipmap.l_chongzhi_unselectbackground);
        this.mImgABC.setBackgroundResource(R.mipmap.l_chongzhi_unselectbackground);
        this.imgali.setImageResource(R.mipmap.l_chongzhi_unlai);
        this.imgweixin.setImageResource(R.mipmap.l_chongzhi_weixin);
        this.imgunion.setImageResource(R.mipmap.l_chongzhi_ununion);
        this.imgabc.setImageResource(R.mipmap.l_chongzhi_unabc);
        this.mImgSelectAli.setImageResource(R.mipmap.l_chongzhi_unselect);
        this.mImgSelectWeiXin.setImageResource(R.mipmap.l_chongzhi_select);
        this.mImgSelectUnion.setImageResource(R.mipmap.l_chongzhi_unselect);
        this.mImgSelectABC.setImageResource(R.mipmap.l_chongzhi_unselect);
        this.textali.setTextColor(-13421773);
        this.textweixin.setTextColor(-11890462);
        this.textunion.setTextColor(-13421773);
        this.textabc.setTextColor(-13421773);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onlyAli() {
        this.mPayWay = 0;
        this.mImgUnionAlipay.setBackgroundResource(R.mipmap.l_chongzhi_selectbackground);
        this.mImgUnionWechat.setBackgroundResource(R.mipmap.l_chongzhi_unselectbackground);
        this.mImgUnionOnline.setBackgroundResource(R.mipmap.l_chongzhi_unselectbackground);
        this.mImgABC.setBackgroundResource(R.mipmap.l_chongzhi_unselectbackground);
        this.imgali.setImageResource(R.mipmap.l_chongzhi_ali);
        this.imgweixin.setImageResource(R.mipmap.l_chongzhi_unwexin);
        this.imgunion.setImageResource(R.mipmap.l_chongzhi_ununion);
        this.imgabc.setImageResource(R.mipmap.l_chongzhi_unabc);
        this.mImgSelectAli.setImageResource(R.mipmap.l_chongzhi_select);
        this.mImgSelectWeiXin.setImageResource(R.mipmap.l_chongzhi_unselect);
        this.mImgSelectUnion.setImageResource(R.mipmap.l_chongzhi_unselect);
        this.mImgSelectABC.setImageResource(R.mipmap.l_chongzhi_unselect);
        this.textali.setTextColor(-11890462);
        this.textweixin.setTextColor(-13421773);
        this.textunion.setTextColor(-13421773);
        this.textabc.setTextColor(-13421773);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onlyUnion() {
        this.mPayWay = 2;
        this.mImgUnionAlipay.setBackgroundResource(R.mipmap.l_chongzhi_unselectbackground);
        this.mImgUnionWechat.setBackgroundResource(R.mipmap.l_chongzhi_unselectbackground);
        this.mImgUnionOnline.setBackgroundResource(R.mipmap.l_chongzhi_selectbackground);
        this.mImgABC.setBackgroundResource(R.mipmap.l_chongzhi_unselectbackground);
        this.imgali.setImageResource(R.mipmap.l_chongzhi_unlai);
        this.imgweixin.setImageResource(R.mipmap.l_chongzhi_unwexin);
        this.imgunion.setImageResource(R.mipmap.l_chongzhi_union);
        this.imgabc.setImageResource(R.mipmap.l_chongzhi_unabc);
        this.mImgSelectAli.setImageResource(R.mipmap.l_chongzhi_unselect);
        this.mImgSelectWeiXin.setImageResource(R.mipmap.l_chongzhi_unselect);
        this.mImgSelectUnion.setImageResource(R.mipmap.l_chongzhi_select);
        this.mImgSelectABC.setImageResource(R.mipmap.l_chongzhi_unselect);
        this.textali.setTextColor(-13421773);
        this.textweixin.setTextColor(-13421773);
        this.textunion.setTextColor(-11890462);
        this.textabc.setTextColor(-13421773);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onlyABC() {
        this.mPayWay = 3;
        this.mImgUnionAlipay.setBackgroundResource(R.mipmap.l_chongzhi_unselectbackground);
        this.mImgUnionWechat.setBackgroundResource(R.mipmap.l_chongzhi_unselectbackground);
        this.mImgUnionOnline.setBackgroundResource(R.mipmap.l_chongzhi_unselectbackground);
        this.mImgABC.setBackgroundResource(R.mipmap.l_chongzhi_selectbackground);
        this.imgali.setImageResource(R.mipmap.l_chongzhi_unlai);
        this.imgweixin.setImageResource(R.mipmap.l_chongzhi_unwexin);
        this.imgunion.setImageResource(R.mipmap.l_chongzhi_ununion);
        this.imgabc.setImageResource(R.mipmap.l_chongzhi_abc);
        this.mImgSelectAli.setImageResource(R.mipmap.l_chongzhi_unselect);
        this.mImgSelectWeiXin.setImageResource(R.mipmap.l_chongzhi_unselect);
        this.mImgSelectUnion.setImageResource(R.mipmap.l_chongzhi_unselect);
        this.mImgSelectABC.setImageResource(R.mipmap.l_chongzhi_select);
        this.textali.setTextColor(-13421773);
        this.textweixin.setTextColor(-13421773);
        this.textunion.setTextColor(-13421773);
        this.textabc.setTextColor(-11890462);
    }

    private void initQieHuanChongZhiView() {
        this.mBtnChongzhi.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.WalletDetailActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WalletDetailActivity.this.mTvBalance.setText(DecimalUtil.twoDecimal(DecimalUtil.divide(WalletDetailActivity.this.mWalletModel.getBalance() + "", "100")));
                WalletDetailActivity.this.mIsCardChongzhi = false;
                WalletDetailActivity.this.mRelPayWay.setVisibility(0);
                WalletDetailActivity.this.mBtnChongzhi.setTextColor(-14540254);
                WalletDetailActivity.this.mBtnButie.setTextColor(-6710887);
                WalletDetailActivity.this.mView1.setBackgroundColor(-16741633);
                WalletDetailActivity.this.mView2.setBackgroundColor(-1);
                if (StringUtils.isNotEmpty(WalletDetailActivity.this.mWalletModel.serviceMobile)) {
                    WalletDetailActivity.this.mTvServerMobile.setVisibility(0);
                }
                WalletDetailActivity.this.mBtnRefund.setVisibility(0);
                if (WalletDetailActivity.this.mWalletModel.refund != 1) {
                    WalletDetailActivity.this.mBtnRefund.setText("申请退款");
                } else {
                    WalletDetailActivity.this.mBtnRefund.setText("取消申请退款");
                }
                WalletDetailActivity.this.mTvBalanceText1.setVisibility(8);
                WalletDetailActivity.this.mRelToWalletDetaill.setVisibility(0);
                WalletDetailActivity.this.mTvWalletText.setVisibility(0);
                WalletDetailActivity.this.mRelTip.setVisibility(0);
                WalletDetailActivity.this.mTextJiner.setVisibility(0);
                WalletDetailActivity.this.mListView.setVisibility(0);
                WalletDetailActivity.this.mTvMoney.setText("");
                if (WalletDetailActivity.this.mListData != null && WalletDetailActivity.this.mListData.size() > 0) {
                    WalletDetailActivity.this.mTvMoney1.setText(((RechargeDetailBean) WalletDetailActivity.this.mListData.get(0)).recharge);
                } else {
                    WalletDetailActivity.this.mTvMoney1.setText("");
                }
                WalletDetailActivity.this.mRechargeRecordAdapter.setIndex(0);
                WalletDetailActivity.this.mRechargeRecordAdapter.notifyDataSetChanged();
            }
        });
        this.mBtnButie.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.WalletDetailActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WalletDetailActivity.this.mTvBalance.setText(DecimalUtil.twoDecimal(WalletDetailActivity.this.mWalletModel.getBaseWallet()));
                WalletDetailActivity.this.mIsCardChongzhi = true;
                WalletDetailActivity.this.mRelPayWay.setVisibility(8);
                WalletDetailActivity.this.mBtnChongzhi.setTextColor(-6710887);
                WalletDetailActivity.this.mBtnButie.setTextColor(-14540254);
                WalletDetailActivity.this.mView2.setBackgroundColor(-16741633);
                WalletDetailActivity.this.mView1.setBackgroundColor(-1);
                WalletDetailActivity.this.mBtnRefund.setVisibility(4);
                WalletDetailActivity.this.mTvServerMobile.setVisibility(4);
                WalletDetailActivity.this.mTvWalletText.setVisibility(4);
                WalletDetailActivity.this.mRelTip.setVisibility(8);
                WalletDetailActivity.this.mTextJiner.setVisibility(8);
                WalletDetailActivity.this.mListView.setVisibility(8);
                WalletDetailActivity.this.mTvMoney.setText("");
                WalletDetailActivity.this.mTvMoney1.setText("");
                WalletDetailActivity.this.mTvBalanceText1.setVisibility(0);
                WalletDetailActivity.this.mRelToWalletDetaill.setVisibility(4);
            }
        });
    }

    private void initTitleBar() {
        this.mVTitleBar.setTitleView(this.mWalletModel.name + "充值");
        if (this.mWalletModel.IsUseCard == 1) {
            this.mLinCard.setVisibility(0);
            this.mLinLineCard.setVisibility(0);
            initQieHuanChongZhiView();
        }
        this.mVTitleBar.setLeftView(R.mipmap.back);
        this.mVTitleBar.setLeftViewOnClickBack(getActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refund() {
        if (this.mWalletModel.refund == 1) {
            TwoButtonDialog.getInstance().showDialog(getActivity(), new TwoButtonDialog.Listener() { // from class: client.android.yixiaotong.ui.WalletDetailActivity.8
                @Override // client.android.yixiaotong.ui.dialog.TwoButtonDialog.Listener
                public void onCancle() {
                }

                @Override // client.android.yixiaotong.ui.dialog.TwoButtonDialog.Listener
                public void onConfirm() {
                    BusinessControllers.getInstance().getCancellationOfRefund(WalletDetailActivity.this.getLoginAccount(), WalletDetailActivity.this.mWalletModel.typeId, new Listener<SuccessBean>() { // from class: client.android.yixiaotong.ui.WalletDetailActivity.8.1
                        @Override // client.android.yixiaotong.controller.core.Listener
                        public void onStart(Controller controller) {
                            if (WalletDetailActivity.this.mIsEnable) {
                                BaseMaterialDialog.showMaterialDialog(WalletDetailActivity.this.getActivity(), "取消申请退款中..", false);
                            }
                        }

                        @Override // client.android.yixiaotong.controller.core.Listener
                        public void onComplete(Controller controller, SuccessBean successBean, Object... objArr) {
                            if (WalletDetailActivity.this.mIsEnable) {
                                BaseMaterialDialog.dissmisMaterialDialog();
                                SystemErrorTip.getInstance().showTipDialog(WalletDetailActivity.this.getActivity(), "取消申请退款成功");
                                BusinessControllers.getInstance().syncWallets(WalletDetailActivity.this.getLoginAccount(), null);
                            }
                        }

                        @Override // client.android.yixiaotong.controller.core.Listener
                        public void onFail(Controller controller, ClientException clientException) {
                            if (WalletDetailActivity.this.mIsEnable) {
                                BaseMaterialDialog.dissmisMaterialDialog();
                                ErrorUtil.onFailResult(WalletDetailActivity.this.getActivity(), WalletDetailActivity.this.mVTitleBar.getTitleViewContent(), clientException, false);
                            }
                        }
                    });
                }
            }, "温馨提示", "确定取消退款？", "再想想", "确定");
            return;
        }
        if (this.mTvBalance.getText().toString().equals("0.00")) {
            SystemErrorTip.getInstance().showTipDialog(getActivity(), "当前基本账户余额为0.00元，无法申请退款");
            return;
        }
        int i = this.mRechargeState;
        if (i == -2) {
            SystemErrorTip.getInstance().showTipDialog(getActivity(), "正在请求中...");
            return;
        }
        if (i == -1) {
            SystemErrorTip.getInstance().showTipDialog(getActivity(), this.mRechargeContent);
            return;
        }
        if (i == 0) {
            if (this.mRechargeType == 2) {
                SystemErrorTip.getInstance().showTipDialog(getActivity(), "申请退款为" + this.mRechargeTime + "，退款时间内进入APP点击“申请退款”即可");
                return;
            } else {
                SystemErrorTip.getInstance().showTipDialog(getActivity(), "暂不能申请退款");
                return;
            }
        }
        if (i == 1) {
            if (this.mWalletModel.AliRefund != 1 && this.mWalletModel.WeiXinRefund != 1) {
                SystemErrorTip.getInstance().showTipDialog(getActivity(), "无退款渠道，暂不支持退款，如有疑问，请联系管理员处理");
            } else {
                new AppTipDialog().showTipDialog(getActivity(), new AppTipDialog.TipDialogListener() { // from class: client.android.yixiaotong.ui.WalletDetailActivity.9
                    @Override // client.android.yixiaotong.ui.dialog.AppTipDialog.TipDialogListener
                    public void onCanle() {
                    }

                    @Override // client.android.yixiaotong.ui.dialog.AppTipDialog.TipDialogListener
                    public void onConfirt() {
                        Refund2Activity.launch(WalletDetailActivity.this.getActivity(), WalletDetailActivity.this.mWalletModel);
                    }
                }, "申请退款后，" + this.mWalletModel.name + "功能将被冻结，不能使用！是否要继续申请退款？", "取消", "继续");
            }
        }
    }

    private void initView() {
        this.mRechargeRecordAdapter = new RechargeRecordAdapter(getActivity(), this.mListData);
        this.mListView.setOnItemClickListener(this);
        this.mListView.setAdapter((ListAdapter) this.mRechargeRecordAdapter);
        this.mRechargeRecordAdapter.notifyDataSetChanged();
        this.mTvRefundRecord.getPaint().setFlags(8);
        if (this.mWalletModel.weiXinCharge == 0) {
            this.mImgUnionWechat.setVisibility(8);
        }
        if (this.mWalletModel.aliCharge == 0 && this.mWalletModel.unionCharge == 0) {
            this.mImgUnionAlipay.setVisibility(8);
        }
        if (this.mWalletModel.unionCharge == 0) {
            this.mImgUnionOnline.setVisibility(8);
        }
        if (this.mWalletModel.ABCCharge == 0) {
            this.mImgABC.setVisibility(8);
        }
        if (this.mWalletModel.weiXinCharge == 0) {
            if (this.mWalletModel.aliCharge != 0 || this.mWalletModel.unionCharge != 0) {
                onlyAli();
            } else if (this.mWalletModel.unionCharge != 0) {
                onlyUnion();
            } else if (this.mWalletModel.ABCCharge != 0) {
                onlyABC();
            } else {
                this.mOpenPayType = false;
            }
        }
        this.mImgUnionAlipay.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.WalletDetailActivity.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WalletDetailActivity.this.onlyAli();
            }
        });
        this.mImgUnionWechat.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.WalletDetailActivity.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WalletDetailActivity.this.onlyWeixin();
            }
        });
        this.mImgUnionOnline.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.WalletDetailActivity.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WalletDetailActivity.this.onlyUnion();
            }
        });
        this.mImgABC.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.WalletDetailActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WalletDetailActivity.this.onlyABC();
            }
        });
        initview1();
        this.mTvMoney.addTextChangedListener(new TextWatcher() { // from class: client.android.yixiaotong.ui.WalletDetailActivity.14
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (StringUtils.isEmpty(editable.toString())) {
                    return;
                }
                WalletDetailActivity.this.mTvMoney1.setText(editable.toString());
                WalletDetailActivity.this.mRechargeRecordAdapter.setIndex(-1);
                WalletDetailActivity.this.mRechargeRecordAdapter.notifyDataSetChanged();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initview1() {
        if (this.mIsCardChongzhi) {
            this.mTvBalance.setText(DecimalUtil.twoDecimal(this.mWalletModel.getBaseWallet()));
        } else {
            this.mTvBalance.setText(DecimalUtil.twoDecimal(DecimalUtil.divide(this.mWalletModel.getBalance() + "", "100")));
        }
        if (this.mWalletModel.IsRefund == 1) {
            if (this.mWalletModel.refund != 1) {
                this.mBtnRefund.setText("申请退款");
            } else {
                this.mBtnRefund.setText("取消申请退款");
            }
        }
        if (StringUtils.isNotEmpty(this.mWalletModel.serviceMobile)) {
            this.mTvServerMobile.setText("客服电话：" + this.mWalletModel.serviceMobile);
        } else {
            this.mTvServerMobile.setVisibility(8);
        }
    }

    public void onClickConfirmCard() {
        if (this.mTvMoney.getText().toString().isEmpty()) {
            ToastUtils.show(getActivity(), "请输入金额！");
            return;
        }
        double d = Double.parseDouble(this.mTvBalance.getText().toString());
        int i = Integer.parseInt(this.mTvMoney.getText().toString());
        if (i > d) {
            ToastUtils.show(getActivity(), "账户可用余额不足！");
        } else if (i < 1 || i > 500) {
            ToastUtils.show(getActivity(), "最低充值金额为1元,最高充值金额为500元！");
        } else {
            PermissionUtil.requestPerssion(getActivity(), 0, this.permissionGrant);
        }
    }

    public void onRecord(View view) {
        if (this.mIsCardChongzhi) {
            CardRecordActivity.launch(getActivity(), this.mWalletModel, "", "");
        } else {
            RechargeRecordActivity.launch(getActivity(), this.mWalletModel.typeId);
        }
    }

    public void closeInputMethod() {
        InputMethodManager inputMethodManager = (InputMethodManager) getActivity().getSystemService("input_method");
        if (!inputMethodManager.isActive() || getActivity().getCurrentFocus() == null || getActivity().getCurrentFocus().getWindowToken() == null) {
            return;
        }
        inputMethodManager.hideSoftInputFromWindow(getActivity().getCurrentFocus().getWindowToken(), 2);
    }

    public void chongzhi(View view) {
        ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(this.mTvMoney.getWindowToken(), 2);
        if (this.mIsCardChongzhi) {
            onClickConfirmCard();
            return;
        }
        if (!this.mOpenPayType) {
            SystemErrorTip.getInstance().showTipDialog(getActivity(), "暂未开通支付方式");
            return;
        }
        int i = this.mPayWay;
        if (i == 0) {
            aliCharge();
            return;
        }
        if (i == 1) {
            weixinCharge();
            return;
        }
        if (i == 2) {
            unionCharge();
        } else {
            if (i != 3) {
                return;
            }
            if (BankABCCaller.isBankABCAvaiable(getActivity())) {
                abcCharge();
            } else {
                ToastUtils.show(getContext(), "没安装农行掌银，或已安装农行掌银版本不支持");
            }
        }
    }

    private void aliCharge() {
        if (StringUtils.isNotEmpty(this.mTvMoney1.getText().toString()) && Float.parseFloat(this.mTvMoney1.getText().toString()) > 0.0f && Float.parseFloat(this.mTvMoney1.getText().toString()) <= 500.0f) {
            if (this.mWalletModel.aliCharge != 0 && this.mWalletModel.unionCharge == 0) {
                BusinessControllers.getInstance().aliPay(getLoginAccount(), new BigDecimal(this.mTvMoney1.getText().toString()).multiply(new BigDecimal(100.0d)).intValue(), this.mWalletModel.ID, new Listener<AliPayBean>() { // from class: client.android.yixiaotong.ui.WalletDetailActivity.15
                    @Override // client.android.yixiaotong.controller.core.Listener
                    public void onComplete(Controller controller, AliPayBean aliPayBean, Object... objArr) {
                        if (WalletDetailActivity.this.mIsEnable) {
                            if (!TextUtils.isEmpty(aliPayBean.payInfo)) {
                                AliPayUtils.pay(WalletDetailActivity.this.getActivity(), aliPayBean.payInfo, new AliPayUtils.OnPayListener() { // from class: client.android.yixiaotong.ui.WalletDetailActivity.15.1
                                    @Override // client.android.yixiaotong.alipay.AliPayUtils.OnPayListener
                                    public void paySuccess() {
                                        WalletDetailActivity.this.mTvMoney.setText("");
                                        ToastUtils.show(WalletDetailActivity.this.getContext(), "支付成功");
                                        BusinessControllers.getInstance().syncWallets(WalletDetailActivity.this.getLoginAccount(), null);
                                    }

                                    @Override // client.android.yixiaotong.alipay.AliPayUtils.OnPayListener
                                    public void payWaitting() {
                                        ToastUtils.show(WalletDetailActivity.this.getContext(), "正在等待支付结果,稍后会收到服务器确认的支付结果");
                                    }

                                    @Override // client.android.yixiaotong.alipay.AliPayUtils.OnPayListener
                                    public void payFail() {
                                        ToastUtils.show(WalletDetailActivity.this.getContext(), "支付失败");
                                    }
                                });
                            } else {
                                ToastUtils.show(WalletDetailActivity.this.getContext(), "数据出错，下单失败");
                            }
                        }
                    }

                    @Override // client.android.yixiaotong.controller.core.Listener
                    public void onFail(Controller controller, ClientException clientException) {
                        if (WalletDetailActivity.this.mIsEnable) {
                            ErrorUtil.onFailResult(WalletDetailActivity.this.getActivity(), WalletDetailActivity.this.mVTitleBar.getTitleViewContent(), clientException, false);
                        }
                    }
                });
                return;
            } else {
                if (this.mWalletModel.aliCharge == 0 && this.mWalletModel.unionCharge != 0) {
                    showDialog();
                    int iIntValue = new BigDecimal(this.mTvMoney1.getText().toString()).multiply(new BigDecimal(100.0d)).intValue();
                    final String str = iIntValue + "";
                    BusinessControllers.getInstance().unionPay(getLoginAccount(), iIntValue, this.mWalletModel.ID, new Listener<UnionPayBean>() { // from class: client.android.yixiaotong.ui.WalletDetailActivity.16
                        @Override // client.android.yixiaotong.controller.core.Listener
                        public void onComplete(Controller controller, final UnionPayBean unionPayBean, Object... objArr) {
                            String strOptString;
                            String strOptString2;
                            String strOptString3;
                            if (WalletDetailActivity.this.mIsEnable) {
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
                                map.put("amount", str);
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
                                VolleyRequestNew.postJson(true, ApiConfig.URL_PAY, map, new JSONResponseHandler() { // from class: client.android.yixiaotong.ui.WalletDetailActivity.16.1
                                    @Override // com.masget.base.volley.JSONResponseHandler
                                    public void onSuccess(JSONObject jSONObject2) {
                                        if (jSONObject2.optInt("ret") != 0) {
                                            WalletDetailActivity.this.dismissDialog();
                                            ToastUtils.show(WalletDetailActivity.this.getContext(), jSONObject2.optString(CrashHianalyticsData.MESSAGE));
                                            return;
                                        }
                                        try {
                                            String strOptString4 = new JSONObject(jSONObject2.optString("data")).optString("qrcode");
                                            if (StringUtils.isNotEmpty(strOptString4)) {
                                                LocalPreferencesHelper localPreferencesHelper = new LocalPreferencesHelper(WalletDetailActivity.this.getContext(), "default_alipay_preferences");
                                                localPreferencesHelper.saveOrUpdate("paystate", "0");
                                                localPreferencesHelper.saveOrUpdate("payRespcode", "0");
                                                Intent intent = new Intent(WalletDetailActivity.this.getActivity(), (Class<?>) AlipayActivity.class);
                                                intent.putExtra("qrcode", strOptString4);
                                                intent.putExtra("ordernumber", unionPayBean.orderID);
                                                intent.putExtra("mainUnionCompanyId", unionPayBean.mainUnionCompanyId + "");
                                                intent.putExtra("unionSession", unionPayBean.unionSession);
                                                intent.putExtra("unionAppKey", unionPayBean.unionAppKey);
                                                WalletDetailActivity.this.startActivity(intent);
                                                WalletDetailActivity.this.mTvMoney.setText("");
                                                WalletDetailActivity.this.dismissDialog();
                                            }
                                        } catch (JSONException e4) {
                                            e4.printStackTrace();
                                        }
                                    }

                                    @Override // com.masget.base.volley.JSONResponseHandler
                                    public void onFail(VolleyError volleyError) {
                                        WalletDetailActivity.this.dismissDialog();
                                        ToastUtils.show(WalletDetailActivity.this.getContext(), "下单失败");
                                    }
                                });
                            }
                        }

                        @Override // client.android.yixiaotong.controller.core.Listener
                        public void onFail(Controller controller, ClientException clientException) {
                            if (WalletDetailActivity.this.mIsEnable) {
                                WalletDetailActivity.this.dismissDialog();
                                ErrorUtil.onFailResult(WalletDetailActivity.this.getActivity(), WalletDetailActivity.this.mVTitleBar.getTitleViewContent(), clientException, false);
                            }
                        }
                    });
                    return;
                }
                ToastUtils.show(getContext(), "支付宝和银联支付存在冲突");
                return;
            }
        }
        ToastUtils.show(getActivity(), "最低充值金额为1元,最高充值金额为500元！");
    }

    private void weixinCharge() {
        if (StringUtils.isNotEmpty(this.mTvMoney1.getText().toString()) && Float.parseFloat(this.mTvMoney1.getText().toString()) > 0.0f && Float.parseFloat(this.mTvMoney1.getText().toString()) <= 500.0f) {
            showDialog();
            BusinessControllers.getInstance().weiXinPay(getLoginAccount(), new BigDecimal(this.mTvMoney1.getText().toString()).multiply(new BigDecimal(100.0d)).intValue(), this.mWalletModel.ID, new Listener<WeiXinPayBean>() { // from class: client.android.yixiaotong.ui.WalletDetailActivity.17
                @Override // client.android.yixiaotong.controller.core.Listener
                public void onComplete(Controller controller, WeiXinPayBean weiXinPayBean, Object... objArr) {
                    if (WalletDetailActivity.this.mIsEnable) {
                        if (weiXinPayBean != null) {
                            WalletDetailActivity.this.dismissDialog();
                            WxPayUtils.pay(WalletDetailActivity.this.getActivity(), weiXinPayBean.appid, weiXinPayBean.partnerid, weiXinPayBean.prepayid, weiXinPayBean.noncestr, weiXinPayBean.timestamp, weiXinPayBean.sign);
                            WalletDetailActivity.this.mTvMoney.setText("");
                        } else {
                            WalletDetailActivity.this.dismissDialog();
                            ToastUtils.show(WalletDetailActivity.this.getContext(), "数据出错，下单失败");
                        }
                    }
                }

                @Override // client.android.yixiaotong.controller.core.Listener
                public void onFail(Controller controller, ClientException clientException) {
                    if (WalletDetailActivity.this.mIsEnable) {
                        WalletDetailActivity.this.dismissDialog();
                        ErrorUtil.onFailResult(WalletDetailActivity.this.getActivity(), WalletDetailActivity.this.mVTitleBar.getTitleViewContent(), clientException, false);
                    }
                }
            });
            return;
        }
        ToastUtils.show(getContext(), "最低充值金额为1元,最高充值金额为500元！");
    }

    private void unionCharge() {
        if (StringUtils.isNotEmpty(this.mTvMoney1.getText().toString()) && Float.parseFloat(this.mTvMoney1.getText().toString()) > 0.0f && Float.parseFloat(this.mTvMoney1.getText().toString()) <= 500.0f) {
            showDialog();
            int iIntValue = new BigDecimal(this.mTvMoney1.getText().toString()).multiply(new BigDecimal(100.0d)).intValue();
            final String str = iIntValue + "";
            BusinessControllers.getInstance().unionPay(getLoginAccount(), iIntValue, this.mWalletModel.ID, new Listener<UnionPayBean>() { // from class: client.android.yixiaotong.ui.WalletDetailActivity.18
                @Override // client.android.yixiaotong.controller.core.Listener
                public void onComplete(Controller controller, UnionPayBean unionPayBean, Object... objArr) {
                    String strOptString;
                    String strOptString2;
                    String strOptString3;
                    if (WalletDetailActivity.this.mIsEnable) {
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
                            WalletDetailActivity.this.dismissDialog();
                            ToastUtils.show(WalletDetailActivity.this.getContext(), "获取订单失败");
                            return;
                        }
                        Intent intent = new Intent(WalletDetailActivity.this.getActivity(), (Class<?>) UnionWebActivity.class);
                        intent.putExtra("url", strPostUrlEncrypt);
                        intent.putExtra("ordernumber", unionPayBean.orderID);
                        intent.putExtra("mainUnionCompanyId", unionPayBean.mainUnionCompanyId + "");
                        intent.putExtra("unionSession", unionPayBean.unionSession);
                        intent.putExtra("unionAppKey", unionPayBean.unionAppKey);
                        WalletDetailActivity.this.startActivity(intent);
                        WalletDetailActivity.this.mTvMoney.setText("");
                        WalletDetailActivity.this.dismissDialog();
                    }
                }

                @Override // client.android.yixiaotong.controller.core.Listener
                public void onFail(Controller controller, ClientException clientException) {
                    if (WalletDetailActivity.this.mIsEnable) {
                        WalletDetailActivity.this.dismissDialog();
                        ErrorUtil.onFailResult(WalletDetailActivity.this.getActivity(), WalletDetailActivity.this.mVTitleBar.getTitleViewContent(), clientException, false);
                    }
                }
            });
            return;
        }
        ToastUtils.show(getContext(), "最低充值金额为1元,最高充值金额为500元！");
    }

    private void abcCharge() {
        if (StringUtils.isNotEmpty(this.mTvMoney1.getText().toString()) && Float.parseFloat(this.mTvMoney1.getText().toString()) > 0.0f && Float.parseFloat(this.mTvMoney1.getText().toString()) <= 500.0f) {
            showDialog();
            BusinessControllers.getInstance().ABCPay(getLoginAccount(), new BigDecimal(this.mTvMoney1.getText().toString()).multiply(new BigDecimal(100.0d)).intValue(), this.mWalletModel.typeId, new Listener<ABCPayBean>() { // from class: client.android.yixiaotong.ui.WalletDetailActivity.19
                @Override // client.android.yixiaotong.controller.core.Listener
                public void onComplete(Controller controller, ABCPayBean aBCPayBean, Object... objArr) {
                    if (WalletDetailActivity.this.mIsEnable) {
                        WalletDetailActivity.this.dismissDialog();
                        String packageName = WalletDetailActivity.this.getPackageName();
                        Log.e("test", "开始调起农行支付：" + packageName + "  " + aBCPayBean.token);
                        BankABCCaller.startBankABC(WalletDetailActivity.this.getActivity(), packageName, "client.android.yixiaotong.ui.WalletDetailActivity", "pay", aBCPayBean.token);
                    }
                }

                @Override // client.android.yixiaotong.controller.core.Listener
                public void onFail(Controller controller, ClientException clientException) {
                    if (WalletDetailActivity.this.mIsEnable) {
                        WalletDetailActivity.this.dismissDialog();
                        ErrorUtil.onFailResult(WalletDetailActivity.this.getActivity(), WalletDetailActivity.this.mVTitleBar.getTitleViewContent(), clientException, false);
                    }
                }
            });
            return;
        }
        ToastUtils.show(getContext(), "最低充值金额为1元,最高充值金额为500元！");
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.mIsEnable = true;
        if (this.mPayWay == 3) {
            Log.e("test", "onresume param:" + getIntent().getStringExtra("from_bankabc_param"));
        }
        BusinessControllers.getInstance().syncWallets(getLoginAccount(), null);
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        EventBusUtil.getInstance().getCommonEventBus().unregister(this);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        this.mIsEnable = false;
        dismissDialog();
    }

    public void onEventMainThread(BalanceSyncEvent balanceSyncEvent) {
        BusinessControllers.getInstance().getWalletModels(getLoginAccount(), new Listener<List<WalletModel>>() { // from class: client.android.yixiaotong.ui.WalletDetailActivity.20
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, List<WalletModel> list, Object... objArr) {
                if (WalletDetailActivity.this.mIsEnable) {
                    for (WalletModel walletModel : list) {
                        if (WalletDetailActivity.this.mWalletModel.ID == walletModel.ID) {
                            WalletDetailActivity.this.mWalletModel = walletModel;
                            WalletDetailActivity.this.initview1();
                            return;
                        }
                    }
                }
            }
        });
    }

    private void getRechargePromptInformation() {
        BusinessControllers.getInstance().GetRechargePromptInformation(getLoginAccount(), this.mWalletModel.typeId, new Listener<RechargeInfoBean>() { // from class: client.android.yixiaotong.ui.WalletDetailActivity.22
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, RechargeInfoBean rechargeInfoBean, Object... objArr) {
                if (WalletDetailActivity.this.mIsEnable && StringUtils.isNotEmpty(rechargeInfoBean.firstCharge) && StringUtils.isNotEmpty(rechargeInfoBean.leastCharge)) {
                    String str = "用户最低充值为" + rechargeInfoBean.leastCharge + "元，首次需充值" + rechargeInfoBean.firstCharge + "元";
                    String str2 = "，申请退款时间为" + rechargeInfoBean.refundTime;
                    WalletDetailActivity.this.mRechargeState = rechargeInfoBean.refundStatus;
                    WalletDetailActivity.this.mRechargeTime = rechargeInfoBean.refundTime;
                    if (rechargeInfoBean.refundStatus != 1) {
                        WalletDetailActivity.this.mRechargeType = rechargeInfoBean.refundType;
                        if (rechargeInfoBean.refundType == 2) {
                            SpannableString spannableString = new SpannableString(str + str2);
                            spannableString.setSpan(new ForegroundColorSpan(WalletDetailActivity.this.getResources().getColor(R.color.ffFA5854)), 7, rechargeInfoBean.leastCharge.length() + 8, 33);
                            spannableString.setSpan(new ForegroundColorSpan(WalletDetailActivity.this.getResources().getColor(R.color.ffFA5854)), rechargeInfoBean.leastCharge.length() + 14, rechargeInfoBean.leastCharge.length() + 14 + rechargeInfoBean.firstCharge.length() + 1, 33);
                            spannableString.setSpan(new ForegroundColorSpan(WalletDetailActivity.this.getResources().getColor(R.color.ffFA5854)), rechargeInfoBean.leastCharge.length() + 23 + rechargeInfoBean.firstCharge.length(), rechargeInfoBean.leastCharge.length() + 23 + rechargeInfoBean.firstCharge.length() + rechargeInfoBean.refundTime.length(), 33);
                            WalletDetailActivity.this.mTvTip.setText(spannableString);
                            return;
                        }
                        SpannableString spannableString2 = new SpannableString(str);
                        spannableString2.setSpan(new ForegroundColorSpan(WalletDetailActivity.this.getResources().getColor(R.color.ffFA5854)), 7, rechargeInfoBean.leastCharge.length() + 8, 33);
                        spannableString2.setSpan(new ForegroundColorSpan(WalletDetailActivity.this.getResources().getColor(R.color.ffFA5854)), rechargeInfoBean.leastCharge.length() + 14, rechargeInfoBean.leastCharge.length() + 14 + rechargeInfoBean.firstCharge.length() + 1, 33);
                        WalletDetailActivity.this.mTvTip.setText(spannableString2);
                        return;
                    }
                    SpannableString spannableString3 = new SpannableString(str + str2 + "，点击右上角“申请退款”");
                    spannableString3.setSpan(new ForegroundColorSpan(WalletDetailActivity.this.getResources().getColor(R.color.ffFA5854)), 7, rechargeInfoBean.leastCharge.length() + 8, 33);
                    spannableString3.setSpan(new ForegroundColorSpan(WalletDetailActivity.this.getResources().getColor(R.color.ffFA5854)), rechargeInfoBean.leastCharge.length() + 14, rechargeInfoBean.leastCharge.length() + 14 + rechargeInfoBean.firstCharge.length() + 1, 33);
                    spannableString3.setSpan(new ForegroundColorSpan(WalletDetailActivity.this.getResources().getColor(R.color.ffFA5854)), rechargeInfoBean.leastCharge.length() + 23 + rechargeInfoBean.firstCharge.length(), rechargeInfoBean.leastCharge.length() + 23 + rechargeInfoBean.firstCharge.length() + rechargeInfoBean.refundTime.length(), 33);
                    WalletDetailActivity.this.mTvTip.setText(spannableString3);
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (WalletDetailActivity.this.mIsEnable) {
                    WalletDetailActivity.this.mRechargeContent = clientException.getDetail();
                    WalletDetailActivity.this.mRechargeState = -1;
                }
            }
        });
    }
}
