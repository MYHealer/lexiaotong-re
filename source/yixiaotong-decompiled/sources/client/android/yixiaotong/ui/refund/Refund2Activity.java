package client.android.yixiaotong.ui.refund;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.controller.BusinessControllers;
import client.android.yixiaotong.controller.bean.SuccessBean;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.controller.error.ErrorUtil;
import client.android.yixiaotong.controller.model.WalletModel;
import client.android.yixiaotong.controller.store.LocalBusinessStore;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.ui.dialog.RefundDialog;
import client.android.yixiaotong.ui.dialog.SystemErrorTip;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.DecimalUtil;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.ToastUtils;
import com.stub.StubApp;
import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class Refund2Activity extends BaseActivity {
    public static final String EXTRA_WALLET = "extra_wallet";
    ImageView mImgAli;
    ImageView mImgWechat;
    RelativeLayout mRelAli;
    RelativeLayout mRelWeChat;
    TextView mTvMoney;
    TitleBar mVTitleBar;
    private WalletModel mWalletModel;
    private boolean mIsRefundToAli = false;
    private int mBanlance = 0;
    private boolean mIsEnable = true;

    static {
        StubApp.interface11(7558);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    private void initViewNew() {
        this.mVTitleBar = (TitleBar) findViewById(R.id.v_titleBar);
        this.mTvMoney = (TextView) findViewById(R.id.tv_money);
        this.mImgWechat = (ImageView) findViewById(R.id.img_select_weixin);
        this.mImgAli = (ImageView) findViewById(R.id.img_select_ali);
        this.mRelAli = (RelativeLayout) findViewById(R.id.rel_alipay);
        this.mRelWeChat = (RelativeLayout) findViewById(R.id.rel_wechat);
    }

    public static void launch(Activity activity, WalletModel walletModel) {
        Intent intent = new Intent(activity, (Class<?>) Refund2Activity.class);
        intent.putExtra("extra_wallet", walletModel);
        activity.startActivity(intent);
    }

    private void initTitleBar() {
        this.mVTitleBar.setTitleView("申请退款");
        this.mVTitleBar.setLeftView(R.mipmap.back);
        this.mVTitleBar.setLeftViewOnClickBack(getActivity());
        this.mVTitleBar.setRightView("退款规则");
        this.mVTitleBar.setRightViewTextColor(getResources().getColor(R.color.ff222222));
        this.mVTitleBar.setRightViewOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.refund.Refund2Activity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                RefundDialog.getInstance().showTipTimeOutDialog(Refund2Activity.this.getActivity());
            }
        });
    }

    private void initView() {
        this.mBanlance = (int) (Float.parseFloat(this.mWalletModel.getBaseWallet()) * 100.0f);
        Log.e("test", this.mBanlance + "  " + Float.parseFloat(this.mWalletModel.getBaseWallet()));
        this.mTvMoney.setText(String.format(getResources().getString(R.string.refund_tip), DecimalUtil.twoDecimal(DecimalUtil.divide(this.mWalletModel.getBalance() + "", "100")), DecimalUtil.twoDecimal(this.mWalletModel.getBaseWallet())));
        if (this.mWalletModel.WeiXinRefund != 1) {
            this.mRelWeChat.setVisibility(8);
            this.mImgWechat.setImageResource(R.mipmap.l_chongzhi_unselect);
            this.mImgAli.setImageResource(R.mipmap.l_chongzhi_select);
            this.mIsRefundToAli = true;
        }
        if (this.mWalletModel.AliRefund != 1) {
            this.mRelAli.setVisibility(8);
        }
    }

    private void initClickListeners() {
        findViewById(R.id.rel_alipay).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.refund.Refund2Activity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m170x8e6bf16f(view);
            }
        });
        findViewById(R.id.rel_wechat).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.refund.Refund2Activity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m171x1ba6a2f0(view);
            }
        });
        findViewById(R.id.btn_refund).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.refund.Refund2Activity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m172xa8e15471(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$0$client-android-yixiaotong-ui-refund-Refund2Activity, reason: not valid java name */
    /* synthetic */ void m170x8e6bf16f(View view) {
        this.mIsRefundToAli = true;
        this.mImgWechat.setImageResource(R.mipmap.l_chongzhi_unselect);
        this.mImgAli.setImageResource(R.mipmap.l_chongzhi_select);
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$1$client-android-yixiaotong-ui-refund-Refund2Activity, reason: not valid java name */
    /* synthetic */ void m171x1ba6a2f0(View view) {
        this.mIsRefundToAli = false;
        this.mImgAli.setImageResource(R.mipmap.l_chongzhi_unselect);
        this.mImgWechat.setImageResource(R.mipmap.l_chongzhi_select);
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$2$client-android-yixiaotong-ui-refund-Refund2Activity, reason: not valid java name */
    /* synthetic */ void m172xa8e15471(View view) {
        if (!this.mIsRefundToAli) {
            if (this.mBanlance >= 30) {
                toWeChatAuth();
                return;
            } else {
                ToastUtils.show(getContext(), "当前余额低于微信退款额度，暂不支持退款");
                return;
            }
        }
        if (this.mBanlance < 10) {
            ToastUtils.show(getContext(), "当前余额低于支付宝退款额度，暂不支持退款");
        } else {
            RefundToAliActivity.launch(getActivity(), this.mWalletModel);
            finish();
        }
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        String openId = LocalBusinessStore.getOpenId(getContext());
        this.mIsEnable = true;
        if (StringUtils.isNotEmpty(openId)) {
            refund();
        }
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        this.mIsEnable = false;
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
    }

    public void refund() {
        BusinessControllers.getInstance().refund2(getLoginAccount(), getLoginAccount().getAccountManagetStore().getUserInfo().LoginAccount, this.mWalletModel.typeId, 1, "", LocalBusinessStore.getOpenId(getContext()), LocalBusinessStore.getName(getContext()), new Listener<SuccessBean>() { // from class: client.android.yixiaotong.ui.refund.Refund2Activity.2
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, SuccessBean successBean, Object... objArr) {
                if (Refund2Activity.this.mIsEnable) {
                    if (successBean.success != 1) {
                        SystemErrorTip.getInstance().showTipDialog(Refund2Activity.this.getActivity(), "提交失败,请稍候再试");
                    } else {
                        SystemErrorTip.getInstance().showTipDialog(Refund2Activity.this.getActivity(), new SystemErrorTip.SystemErrorDialogListener() { // from class: client.android.yixiaotong.ui.refund.Refund2Activity.2.1
                            @Override // client.android.yixiaotong.ui.dialog.SystemErrorTip.SystemErrorDialogListener
                            public void onConfirm() {
                                Refund2Activity.this.finish();
                            }
                        }, "提交成功");
                    }
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (Refund2Activity.this.mIsEnable) {
                    ErrorUtil.onFailResult(Refund2Activity.this.getActivity(), Refund2Activity.this.mVTitleBar.getTitleViewContent(), clientException, false);
                }
            }
        });
    }

    private void toWeChatAuth() {
        IWXAPI iwxapiCreateWXAPI = WXAPIFactory.createWXAPI(getActivity(), null);
        String str = this.mWalletModel.WeiXinRefundAppId;
        if (StringUtils.isNotEmpty(str)) {
            LocalBusinessStore.saveRefundAppidSecret(getContext(), str + "," + this.mWalletModel.WeiXinRefundSecret);
            iwxapiCreateWXAPI.registerApp(str);
            SendAuth.Req req = new SendAuth.Req();
            req.scope = "snsapi_userinfo";
            req.state = "wechat_sdk_demo_test";
            iwxapiCreateWXAPI.sendReq(req);
        }
    }
}
