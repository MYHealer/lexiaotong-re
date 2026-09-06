package client.android.yixiaotong.v4.ui.wallet;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.controller.bean.SuccessBean;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.controller.store.ClientDataManager;
import client.android.yixiaotong.controller.store.LocalBusinessStore;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.ui.ammeter.AmmeterWalletDetailActivity;
import client.android.yixiaotong.ui.dialog.BaseMaterialDialog;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.v3.ui.dialog.RefundDialog;
import client.android.yixiaotong.v3.ui.dialog.TwoButtonDialog;
import client.android.yixiaotong.v3.util.ClickUtil;
import client.android.yixiaotong.v4.http.V4BusinessControllers;
import client.android.yixiaotong.v4.http.bean.V4SubmitRefundBean;
import client.android.yixiaotong.v4.ui.error.V4ErrorControlUtil;
import client.android.yixiaotong.v4.ui.order.V4NoPayOrderActivity;
import client.android.yixiaotong.v4.util.EmojiExcludeFilter;
import com.stub.StubApp;
import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class V4SubmitRefundActivity extends BaseActivity {
    private static final int ALI = 2;
    private static final String TAG = "V4SubmitRefundActivity";
    private static final int WALLET = 1;
    private static final int WALLETDEVICE = 2;
    private static final int WEIXIN = 1;
    private EditText mEtAliAccount;
    private EditText mEtName;
    private EditText mEtPhone;
    private EditText mEtRefundDes;
    private EditText mEtStudentNo;
    private LinearLayout mLinRefundDes;
    private String mMoney;
    private int mProductId;
    private RelativeLayout mRelAli;
    private RelativeLayout mRelRefundMethod;
    private RelativeLayout mRelStudentNo;
    private RadioGroup mRgRefundMethod;
    private String mRoomId;
    private TextView mTvCount;
    private TextView mTvRefundAccount;
    private TitleBar mVTitleBar;
    private int mRefundState = -1;
    private boolean mIsEnable = true;
    private int mRefundWay = 0;
    private String mAppId = "";

    static {
        StubApp.interface11(11121);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    public static void launch(Activity activity, int i, String str, int i2, String str2) {
        Intent intent = new Intent(activity, (Class<?>) V4SubmitRefundActivity.class);
        intent.putExtra("refundway", i);
        intent.putExtra(AmmeterWalletDetailActivity.EXTRA_MONEY, str);
        intent.putExtra("productId", i2);
        intent.putExtra("roomId", str2);
        activity.startActivity(intent);
    }

    public static void launch(Activity activity, int i, String str) {
        Intent intent = new Intent(activity, (Class<?>) V4SubmitRefundActivity.class);
        intent.putExtra("refundway", i);
        intent.putExtra(AmmeterWalletDetailActivity.EXTRA_MONEY, str);
        activity.startActivity(intent);
    }

    private void initViewNew() {
        this.mVTitleBar = (TitleBar) findViewById(R.id.v_titleBar);
        this.mEtPhone = (EditText) findViewById(R.id.et_phone);
        this.mEtName = (EditText) findViewById(R.id.et_name);
        this.mTvRefundAccount = (TextView) findViewById(R.id.textali);
        this.mEtAliAccount = (EditText) findViewById(R.id.et_aliaccount);
        this.mRelAli = (RelativeLayout) findViewById(R.id.rel_ali);
        this.mLinRefundDes = (LinearLayout) findViewById(R.id.lin_refunddes);
        this.mRelStudentNo = (RelativeLayout) findViewById(R.id.rel_studentno);
        this.mEtStudentNo = (EditText) findViewById(R.id.et_studentno);
        this.mRelRefundMethod = (RelativeLayout) findViewById(R.id.rel_refund_method);
        this.mRgRefundMethod = (RadioGroup) findViewById(R.id.rg_refund_method);
        this.mEtRefundDes = (EditText) findViewById(R.id.et_refunddes);
        this.mTvCount = (TextView) findViewById(R.id.tv_count);
    }

    private void initTitleBar() {
        this.mVTitleBar.setTitleView(getString(R.string.applyrefund));
        this.mVTitleBar.setLeftView(R.mipmap.back);
        this.mVTitleBar.setLeftViewOnClickBack(getActivity());
    }

    private void initView() {
        this.mEtPhone.setText(ClientDataManager.getInstance().getString(ClientDataManager.LOGIN_ACCOUNT));
        this.mEtName.requestFocus();
        this.mEtName.setFocusable(true);
        this.mEtAliAccount.setFilters(new InputFilter[]{new InputFilter() { // from class: client.android.yixiaotong.v4.ui.wallet.V4SubmitRefundActivity.1
            @Override // android.text.InputFilter
            public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
                return ((charSequence == null || !StringUtils.isChinese(charSequence.toString())) && V4SubmitRefundActivity.this.mEtAliAccount.getText().toString().length() + charSequence.toString().length() <= 32) ? charSequence : "";
            }
        }});
        if (this.mRefundState == 2) {
            this.mRelAli.setVisibility(0);
        } else {
            this.mRelAli.setVisibility(8);
        }
        this.mLinRefundDes.setVisibility(0);
        this.mEtRefundDes.addTextChangedListener(new TextWatcher() { // from class: client.android.yixiaotong.v4.ui.wallet.V4SubmitRefundActivity.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                V4SubmitRefundActivity.this.mTvCount.setText(editable.toString().length() + "/150");
            }
        });
        this.mEtAliAccount.setFilters(new InputFilter[]{new EmojiExcludeFilter()});
        this.mEtName.setFilters(new InputFilter[]{new EmojiExcludeFilter()});
        this.mEtRefundDes.setFilters(new InputFilter[]{new EmojiExcludeFilter()});
        this.mEtPhone.setFilters(new InputFilter[]{new EmojiExcludeFilter()});
    }

    private /* synthetic */ void lambda$initView$0(RadioGroup radioGroup, int i) {
        this.mRelAli.setVisibility(i == 1 ? 0 : 8);
    }

    private void initClickListeners() {
        findViewById(R.id.btn_refund).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.wallet.V4SubmitRefundActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m564xbadde04a(view);
            }
        });
        findViewById(R.id.tv_refundrule).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.wallet.V4SubmitRefundActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m565xae6d648b(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$1$client-android-yixiaotong-v4-ui-wallet-V4SubmitRefundActivity, reason: not valid java name */
    /* synthetic */ void m564xbadde04a(View view) {
        if (ClickUtil.isFastDoubleClick() || !check()) {
            return;
        }
        refund();
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$2$client-android-yixiaotong-v4-ui-wallet-V4SubmitRefundActivity, reason: not valid java name */
    /* synthetic */ void m565xae6d648b(View view) {
        RefundDialog.getInstance().showTipTimeOutDialog(getActivity());
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.mIsEnable = true;
        V4ErrorControlUtil.getInstance().onResume();
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        this.mIsEnable = false;
        V4ErrorControlUtil.getInstance().onPause();
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
        if (this.mRefundWay != 2 || !StringUtils.isEmpty(this.mEtAliAccount.getText().toString())) {
            return true;
        }
        ToastUtils.show(getContext(), "请输入支付宝账号");
        return false;
    }

    public void refund() {
        V4BusinessControllers.getInstance().postSubmitRefund(getLoginAccount(), this.mEtName.getText().toString(), this.mEtRefundDes.getText().toString(), this.mRefundWay == 2 ? 2 : 1, this.mProductId, this.mRoomId, this.mEtAliAccount.getText().toString(), new Listener<V4SubmitRefundBean>() { // from class: client.android.yixiaotong.v4.ui.wallet.V4SubmitRefundActivity.3
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                super.onStart(controller);
                BaseMaterialDialog.showMaterialDialog(V4SubmitRefundActivity.this.getActivity(), "申请退款中", false);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, V4SubmitRefundBean v4SubmitRefundBean, Object... objArr) {
                super.onComplete(controller, v4SubmitRefundBean, objArr);
                if (V4SubmitRefundActivity.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    ToastUtils.show(V4SubmitRefundActivity.this.getActivity(), "申请退款成功");
                    V4SubmitRefundActivity.this.finish();
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                super.onFail(controller, clientException);
                if (V4SubmitRefundActivity.this.mIsEnable) {
                    V4SubmitRefundBean v4SubmitRefundBean = (V4SubmitRefundBean) clientException.getObject();
                    if (v4SubmitRefundBean == null || v4SubmitRefundBean.productId == null || v4SubmitRefundBean.productId.isEmpty() || clientException.getCode() != 1004) {
                        V4SubmitRefundActivity.this.onError(clientException);
                    } else {
                        BaseMaterialDialog.dissmisMaterialDialog();
                        TwoButtonDialog.getInstance().showDialog(V4SubmitRefundActivity.this.getActivity(), new TwoButtonDialog.Listener() { // from class: client.android.yixiaotong.v4.ui.wallet.V4SubmitRefundActivity.3.1
                            @Override // client.android.yixiaotong.v3.ui.dialog.TwoButtonDialog.Listener
                            public void onCancle() {
                            }

                            @Override // client.android.yixiaotong.v3.ui.dialog.TwoButtonDialog.Listener
                            public void onConfirm() {
                                V4NoPayOrderActivity.launch(V4SubmitRefundActivity.this.getActivity());
                            }
                        }, "提示", "有未完成订单，请前往账单页支付", "取消", "查看账单");
                    }
                }
            }
        });
    }

    private void refundAliForDevice() {
        V4BusinessControllers.getInstance().submitRefundForDevice(getLoginAccount(), this.mProductId, this.mRoomId, this.mEtRefundDes.getText().toString(), this.mEtAliAccount.getText().toString(), this.mEtName.getText().toString(), new Listener<SuccessBean>() { // from class: client.android.yixiaotong.v4.ui.wallet.V4SubmitRefundActivity.4
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                super.onStart(controller);
                BaseMaterialDialog.showMaterialDialog(V4SubmitRefundActivity.this.getActivity(), "申请退款中", false);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, SuccessBean successBean, Object... objArr) {
                super.onComplete(controller, successBean, objArr);
                if (V4SubmitRefundActivity.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    ToastUtils.show(V4SubmitRefundActivity.this.getActivity(), "申请退款成功");
                    V4SubmitRefundActivity.this.finish();
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                super.onFail(controller, clientException);
                if (V4SubmitRefundActivity.this.mIsEnable) {
                    V4SubmitRefundActivity.this.onError(clientException);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onError(ClientException clientException) {
        BaseMaterialDialog.dissmisMaterialDialog();
        V4ErrorControlUtil.getInstance().showDialog(clientException, getActivity(), false);
    }

    private void toWeChatAuth(String str, String str2) {
        IWXAPI iwxapiCreateWXAPI = WXAPIFactory.createWXAPI(getActivity(), null);
        LocalBusinessStore.saveRefundAppidSecret(getContext(), str + "," + str2);
        iwxapiCreateWXAPI.registerApp(str);
        SendAuth.Req req = new SendAuth.Req();
        req.scope = "snsapi_userinfo";
        req.state = "wechat_sdk_demo_test";
        iwxapiCreateWXAPI.sendReq(req);
    }
}
