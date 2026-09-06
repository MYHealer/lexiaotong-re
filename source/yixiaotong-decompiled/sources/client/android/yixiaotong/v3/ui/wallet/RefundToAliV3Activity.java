package client.android.yixiaotong.v3.ui.wallet;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.Spanned;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.controller.store.LocalBusinessStore;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.ui.ammeter.AmmeterWalletDetailActivity;
import client.android.yixiaotong.ui.dialog.BaseMaterialDialog;
import client.android.yixiaotong.ui.dialog.SystemErrorTip;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.util.executor.MainThreadExecutor;
import client.android.yixiaotong.util.permission.PermissionUtil;
import client.android.yixiaotong.v3.bean.wallet.AppIdAndSecretBean;
import client.android.yixiaotong.v3.http.V3BusinessControllers;
import client.android.yixiaotong.v3.ui.dialog.RefundDialog;
import client.android.yixiaotong.v3.ui.error.V3ErrorTipActivity;
import client.android.yixiaotong.v3.ui.wallet.controlutil.RefundControlUtil;
import client.android.yixiaotong.v3.userinfo.InvestorInfoUtilControl;
import client.android.yixiaotong.v3.userinfo.UserInfo;
import client.android.yixiaotong.v3.userinfo.UserInfoUtilControl;
import client.android.yixiaotong.v3.util.BankInfo;
import client.android.yixiaotong.v3.util.ClickUtil;
import client.android.yixiaotong.v3.util.LogUtil;
import com.huawei.hms.mlplugin.card.bcr.MLBcrCapture;
import com.huawei.hms.mlplugin.card.bcr.MLBcrCaptureConfig;
import com.huawei.hms.mlplugin.card.bcr.MLBcrCaptureFactory;
import com.huawei.hms.mlplugin.card.bcr.MLBcrCaptureResult;
import com.stub.StubApp;
import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class RefundToAliV3Activity extends BaseActivity {
    private static final int ALI = 2;
    private static final String TAG = "RefundToAliV3Activity";
    private static final int WEIXIN = 1;
    private EditText mEtAliAccount;
    private EditText mEtName;
    private EditText mEtPhone;
    private String mId;
    private ImageView mImgCamera;
    private ImageView mImgUnion;
    private int mMoney;
    private String mRefundReason;
    public String mRefundUrl;
    private RelativeLayout mRelAli;
    private RelativeLayout mRelUnionInfo;
    private String mStudentNo;
    private TextView mTvRefundAccount;
    private TextView mTvUnionName;
    private int mType;
    private UserInfo mUserInfoBean;
    private TitleBar mVTitleBar;
    private boolean mIsEnable = true;
    private int mRefundWay = 0;
    private String mAppId = "";
    private MLBcrCapture.Callback callback = new MLBcrCapture.Callback() { // from class: client.android.yixiaotong.v3.ui.wallet.RefundToAliV3Activity.3
        @Override // com.huawei.hms.mlplugin.card.bcr.MLBcrCapture.Callback
        public void onSuccess(final MLBcrCaptureResult mLBcrCaptureResult) {
            MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.v3.ui.wallet.RefundToAliV3Activity.3.1
                @Override // java.lang.Runnable
                public void run() {
                    if (mLBcrCaptureResult != null) {
                        LogUtil.e(RefundToAliV3Activity.TAG, "扫描到的信息:" + mLBcrCaptureResult.getNumber());
                        RefundToAliV3Activity.this.mEtAliAccount.setText(mLBcrCaptureResult.getNumber());
                        RefundToAliV3Activity.this.mEtAliAccount.setSelection(RefundToAliV3Activity.this.mEtAliAccount.getText().length());
                    }
                }
            });
        }

        @Override // com.huawei.hms.mlplugin.card.bcr.MLBcrCapture.Callback
        public void onCanceled() {
            ToastUtils.show(RefundToAliV3Activity.this.getActivity(), "取消识别");
            LogUtil.e(RefundToAliV3Activity.TAG, "扫描到的信息:onCanceled");
        }

        @Override // com.huawei.hms.mlplugin.card.bcr.MLBcrCapture.Callback
        public void onFailure(int i, Bitmap bitmap) {
            ToastUtils.show(RefundToAliV3Activity.this.getActivity(), "识别失败，请手动输入银行卡号");
            LogUtil.e(RefundToAliV3Activity.TAG, "扫描到的信息:onFailure");
        }

        @Override // com.huawei.hms.mlplugin.card.bcr.MLBcrCapture.Callback
        public void onDenied() {
            ToastUtils.show(RefundToAliV3Activity.this.getActivity(), "识别失败，请手动输入银行卡号!");
            LogUtil.e(RefundToAliV3Activity.TAG, "扫描到的信息:onDenied");
        }
    };
    private PermissionUtil.PermissionGrant permissionGrant = new PermissionUtil.PermissionGrant() { // from class: client.android.yixiaotong.v3.ui.wallet.RefundToAliV3Activity.4
        @Override // client.android.yixiaotong.util.permission.PermissionUtil.PermissionGrant
        public void onPermissionGranted(int i) {
            if (i != 0) {
                return;
            }
            RefundToAliV3Activity.this.mEtAliAccount.setText("");
            RefundToAliV3Activity.this.mEtAliAccount.requestFocus();
            RefundToAliV3Activity refundToAliV3Activity = RefundToAliV3Activity.this;
            refundToAliV3Activity.startCaptureActivity(refundToAliV3Activity.callback);
        }
    };

    static {
        StubApp.interface11(10271);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public native void onRequestPermissionsResult(int i, String[] strArr, int[] iArr);

    public static void launch(Activity activity, int i, String str, int i2, int i3, String str2, String str3, String str4) {
        Intent intent = new Intent(activity, (Class<?>) RefundToAliV3Activity.class);
        intent.putExtra("refundway", i);
        intent.putExtra("id", str);
        intent.putExtra(AmmeterWalletDetailActivity.EXTRA_MONEY, i2);
        intent.putExtra("type", i3);
        intent.putExtra("refundreason", str2);
        intent.putExtra("refundurl", str3);
        intent.putExtra("studentno", str4);
        activity.startActivity(intent);
    }

    private void initViewNew() {
        this.mVTitleBar = (TitleBar) findViewById(R.id.v_titleBar);
        this.mRelUnionInfo = (RelativeLayout) findViewById(R.id.rel_unioninfo);
        this.mImgUnion = (ImageView) findViewById(R.id.img_union);
        this.mTvUnionName = (TextView) findViewById(R.id.tv_unionname);
        this.mEtPhone = (EditText) findViewById(R.id.et_phone);
        this.mEtName = (EditText) findViewById(R.id.et_name);
        this.mTvRefundAccount = (TextView) findViewById(R.id.textali);
        this.mEtAliAccount = (EditText) findViewById(R.id.et_aliaccount);
        this.mRelAli = (RelativeLayout) findViewById(R.id.rel_ali);
        this.mImgCamera = (ImageView) findViewById(R.id.img_camera);
    }

    private void initTitleBar() {
        this.mVTitleBar.setTitleView(getString(R.string.applyrefund));
        this.mVTitleBar.setLeftView(R.mipmap.back);
        this.mVTitleBar.setLeftViewOnClickBack(getActivity());
    }

    private void initView() {
        this.mEtPhone.setText(this.mUserInfoBean.studentMobile);
        this.mEtName.requestFocus();
        this.mEtName.setFocusable(true);
        this.mEtAliAccount.setFilters(new InputFilter[]{new InputFilter() { // from class: client.android.yixiaotong.v3.ui.wallet.RefundToAliV3Activity.1
            @Override // android.text.InputFilter
            public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
                return ((charSequence == null || !StringUtils.isChinese(charSequence.toString())) && RefundToAliV3Activity.this.mEtAliAccount.getText().toString().length() + charSequence.toString().length() <= 32) ? charSequence : "";
            }
        }});
        int i = this.mRefundWay;
        if (i == 1) {
            this.mRelAli.setVisibility(8);
            return;
        }
        if (i == 22) {
            this.mTvRefundAccount.setText(getString(R.string.bankcardno));
            this.mImgUnion.setImageResource(R.mipmap.refund_zgyh);
            this.mTvUnionName.setText(getString(R.string.zgyh));
            this.mRelUnionInfo.setVisibility(0);
            this.mImgCamera.setVisibility(0);
            return;
        }
        if (i == 23) {
            this.mTvRefundAccount.setText(getString(R.string.bankcardno));
            this.mImgUnion.setImageResource(R.mipmap.refund_jsyh);
            this.mTvUnionName.setText(getString(R.string.jsyh));
            this.mRelUnionInfo.setVisibility(0);
            this.mImgCamera.setVisibility(0);
            return;
        }
        if (i == 24) {
            this.mTvRefundAccount.setText(getString(R.string.bankcardno));
            this.mImgUnion.setImageResource(R.mipmap.refund_nyyh);
            this.mTvUnionName.setText(getString(R.string.nyyh));
            this.mRelUnionInfo.setVisibility(0);
            this.mImgCamera.setVisibility(0);
            return;
        }
        if (i == 25) {
            this.mTvRefundAccount.setText(getString(R.string.bankcardno));
            this.mImgUnion.setImageResource(R.mipmap.refund_icbc);
            this.mTvUnionName.setText(getString(R.string.icbc));
            this.mRelUnionInfo.setVisibility(0);
            this.mImgCamera.setVisibility(0);
        }
    }

    private void initClickListeners() {
        findViewById(R.id.btn_refund).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.wallet.RefundToAliV3Activity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m426x55f85a8a(view);
            }
        });
        findViewById(R.id.tv_refundrule).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.wallet.RefundToAliV3Activity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m427xea36ca29(view);
            }
        });
        findViewById(R.id.img_camera).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.wallet.RefundToAliV3Activity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m428x7e7539c8(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$0$client-android-yixiaotong-v3-ui-wallet-RefundToAliV3Activity, reason: not valid java name */
    /* synthetic */ void m426x55f85a8a(View view) {
        if (ClickUtil.isFastDoubleClick()) {
            return;
        }
        handleRefundAction();
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$1$client-android-yixiaotong-v3-ui-wallet-RefundToAliV3Activity, reason: not valid java name */
    /* synthetic */ void m427xea36ca29(View view) {
        RefundDialog.getInstance().showTipTimeOutDialog(getActivity());
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$2$client-android-yixiaotong-v3-ui-wallet-RefundToAliV3Activity, reason: not valid java name */
    /* synthetic */ void m428x7e7539c8(View view) {
        if (ClickUtil.isFastDoubleClick()) {
            return;
        }
        requestCameraPermission();
    }

    private void handleRefundAction() {
        if (check()) {
            if (this.mRefundWay == 1) {
                getAppId();
            } else {
                startRefund();
            }
        }
    }

    private void requestCameraPermission() {
        PermissionUtil.requestPerssion(getActivity(), 0, this.permissionGrant);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.mIsEnable = true;
        if (StringUtils.isNotEmpty(LocalBusinessStore.getOpenId(getContext()))) {
            startRefund();
        }
        RefundControlUtil.getInstance().onResume();
    }

    private void startRefund() {
        if (this.mType == 3) {
            refundCard();
        } else {
            refund();
        }
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        this.mIsEnable = false;
        RefundControlUtil.getInstance().onPause();
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
    }

    private boolean check() {
        if (StringUtils.isEmpty(this.mEtPhone.getText().toString())) {
            ToastUtils.show(getContext(), "请输入手机号");
            return false;
        }
        if (StringUtils.isEmpty(this.mEtName.getText().toString())) {
            ToastUtils.show(getContext(), "请输入姓名");
            return false;
        }
        if (this.mRefundWay == 2 && StringUtils.isEmpty(this.mEtAliAccount.getText().toString())) {
            ToastUtils.show(getContext(), "请输入支付宝账号");
            return false;
        }
        int i = this.mRefundWay;
        if (i != 22 && i != 23 && i != 24 && i != 25) {
            return true;
        }
        if (StringUtils.isEmpty(this.mEtAliAccount.getText().toString())) {
            ToastUtils.show(getContext(), "请输入银行卡号");
            return false;
        }
        if (BankInfo.checkBankCard(this.mEtAliAccount.getText().toString())) {
            return true;
        }
        ToastUtils.show(getContext(), "银行卡号错误");
        return false;
    }

    private void getAppId() {
        V3BusinessControllers.getInstance().getAppInfo(getLoginAccount(), InvestorInfoUtilControl.getInstance().getInvestorId(), UserInfoUtilControl.getInstance().getSchoolId(), new Listener<AppIdAndSecretBean>() { // from class: client.android.yixiaotong.v3.ui.wallet.RefundToAliV3Activity.2
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                BaseMaterialDialog.showMaterialDialog(RefundToAliV3Activity.this.getActivity(), "正在申请退款.", false);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, AppIdAndSecretBean appIdAndSecretBean, Object... objArr) {
                if (RefundToAliV3Activity.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    if (!StringUtils.isNotEmpty(appIdAndSecretBean.appId) || !StringUtils.isNotEmpty(appIdAndSecretBean.appSecret)) {
                        SystemErrorTip.getInstance().showTipDialog(RefundToAliV3Activity.this.getActivity(), "数据异常");
                        return;
                    }
                    RefundToAliV3Activity.this.mAppId = appIdAndSecretBean.appId;
                    RefundToAliV3Activity.this.toWeChatAuth(appIdAndSecretBean.appId, appIdAndSecretBean.appSecret);
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (RefundToAliV3Activity.this.mIsEnable) {
                    RefundToAliV3Activity.this.onError(clientException);
                }
            }
        });
    }

    public void refund() {
        String str;
        String str2;
        String openId = LocalBusinessStore.getOpenId(getContext());
        String string = this.mEtPhone.getText().toString();
        String string2 = this.mEtName.getText().toString();
        int i = this.mRefundWay;
        if (i == 1) {
            str = openId;
            str2 = this.mAppId;
        } else {
            if (i == 2 || i == 22 || i == 23 || i == 24 || i == 25) {
                openId = this.mEtAliAccount.getText().toString();
            }
            str = openId;
            str2 = "";
        }
        if (this.mType == 6) {
            RefundControlUtil.getInstance().refundPrepayment(this.mId, this.mMoney, this.mRefundWay, string, string2, str, str2, this.mRefundReason, this.mRefundUrl);
            return;
        }
        RefundControlUtil.getInstance().refund(this.mType, this.mId, this.mMoney, this.mRefundWay, string, string2, str, str2, this.mRefundReason, this.mRefundUrl, this.mStudentNo);
    }

    private void refundCard() {
        RefundControlUtil.getInstance().refundCard(this.mRefundWay, this.mId, this.mMoney, this.mAppId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onError(ClientException clientException) {
        BaseMaterialDialog.dissmisMaterialDialog();
        if (clientException.isNeedTip(clientException.getCode())) {
            SystemErrorTip.getInstance().showTipDialog(getActivity(), clientException.getDetail());
        } else {
            V3ErrorTipActivity.launch(getActivity(), this.mVTitleBar.getTitleViewContent(), clientException.getDetail(), clientException.getCode(), 2, clientException.getSerial());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void toWeChatAuth(String str, String str2) {
        IWXAPI iwxapiCreateWXAPI = WXAPIFactory.createWXAPI(getActivity(), null);
        LocalBusinessStore.saveRefundAppidSecret(getContext(), str + "," + str2);
        iwxapiCreateWXAPI.registerApp(str);
        SendAuth.Req req = new SendAuth.Req();
        req.scope = "snsapi_userinfo";
        req.state = "wechat_sdk_demo_test";
        iwxapiCreateWXAPI.sendReq(req);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startCaptureActivity(MLBcrCapture.Callback callback) {
        MLBcrCaptureFactory.getInstance().getBcrCapture(new MLBcrCaptureConfig.Factory().setResultType(0).setOrientation(0).create()).captureFrame(this, callback);
    }
}
