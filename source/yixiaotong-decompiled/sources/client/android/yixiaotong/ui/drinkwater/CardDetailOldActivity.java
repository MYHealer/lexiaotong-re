package client.android.yixiaotong.ui.drinkwater;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.baseutil.XOrUtils;
import client.android.yixiaotong.controller.BusinessControllers;
import client.android.yixiaotong.controller.bean.SuccessBean;
import client.android.yixiaotong.controller.bean.bindcard.BindCardBean;
import client.android.yixiaotong.controller.bean.bindcard.IsBindCardBean;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.controller.error.ErrorUtil;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.ui.RechargeRecordActivity;
import client.android.yixiaotong.ui.dialog.BaseMaterialDialog;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.AppUtils;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.util.permission.PermissionUtil;
import client.android.yixiaotong.v3.comman.DeviceControlUtil;
import client.android.yixiaotong.v3.comman.NBDeviceCommand;
import client.android.yixiaotong.v3.ui.dialog.BindCardTipDialog;
import client.android.yixiaotong.v3.ui.scan.QrcodeUtil;
import client.android.yixiaotong.v3.ui.scan.ScanQrcodeActivity;
import client.android.yixiaotong.v3.util.LogUtil;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class CardDetailOldActivity extends BaseActivity {
    private static final int MANAGERFLAG = 0;
    private static final String TAG = "CardDetailOldActivity";
    private Button mBtnUnBind;
    private String mCardId;
    private ImageView mImgAuth;
    private ImageButton mImgBtnEye;
    private RelativeLayout mRelAuth;
    private TitleBar mTitleBar;
    private TextView mTvAuthState;
    private TextView mTvBindCardTip;
    private TextView mTvBindState;
    private TextView mTvCardId;
    private boolean mIsEnable = true;
    private int mAuthCount = 0;
    private boolean mIsNeedLoad = true;
    private String mMachineId = "0000000000000000";
    private int mTypeId = 0;
    private PermissionUtil.PermissionGrant permissionGrant = new PermissionUtil.PermissionGrant() { // from class: client.android.yixiaotong.ui.drinkwater.CardDetailOldActivity.7
        @Override // client.android.yixiaotong.util.permission.PermissionUtil.PermissionGrant
        public void onPermissionGranted(int i) {
            if (i != 0) {
                return;
            }
            ScanQrcodeActivity.launch(CardDetailOldActivity.this.getActivity(), 3);
        }
    };

    static {
        StubApp.interface11(7051);
    }

    static /* synthetic */ void lambda$initClickListeners$1(String str) {
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public native void onRequestPermissionsResult(int i, String[] strArr, int[] iArr);

    static /* synthetic */ int access$1008(CardDetailOldActivity cardDetailOldActivity) {
        int i = cardDetailOldActivity.mAuthCount;
        cardDetailOldActivity.mAuthCount = i + 1;
        return i;
    }

    public static void launch(Activity activity, int i) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) CardDetailOldActivity.class).putExtra(RechargeRecordActivity.EXTRA_TYPEID, i));
        }
    }

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.titleBar);
        this.mTvBindCardTip = (TextView) findViewById(R.id.tv_bindcardtip);
        this.mTvBindState = (TextView) findViewById(R.id.tv_bindcardstate);
        this.mTvCardId = (TextView) findViewById(R.id.tv_cardid);
        this.mImgBtnEye = (ImageButton) findViewById(R.id.ib_eye);
        this.mBtnUnBind = (Button) findViewById(R.id.btn_unbind);
        this.mRelAuth = (RelativeLayout) findViewById(R.id.rel_auth);
        this.mImgAuth = (ImageView) findViewById(R.id.iv_next);
        this.mTvAuthState = (TextView) findViewById(R.id.tv_authstate);
    }

    private void initTitleBar() {
        this.mTitleBar.setTitleView(getString(R.string.schoolcard));
        this.mTitleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.mIsEnable = true;
        if (this.mIsNeedLoad) {
            getCardInfo();
        }
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        this.mIsEnable = false;
        BaseMaterialDialog.dissmisMaterialDialog();
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
    }

    private void initClickListeners() {
        findViewById(R.id.ib_eye).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.drinkwater.CardDetailOldActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m118xded54762(view);
            }
        });
        findViewById(R.id.rel_bindcardtip).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.drinkwater.CardDetailOldActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m119xc5f44fe4(view);
            }
        });
        findViewById(R.id.rel_scanbindcard).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.drinkwater.CardDetailOldActivity$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m120xb983d425(view);
            }
        });
        findViewById(R.id.btn_unbind).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.drinkwater.CardDetailOldActivity$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m121xad135866(view);
            }
        });
        findViewById(R.id.iv_next).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.drinkwater.CardDetailOldActivity$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m122xa0a2dca7(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$0$client-android-yixiaotong-ui-drinkwater-CardDetailOldActivity, reason: not valid java name */
    /* synthetic */ void m118xded54762(View view) {
        if (!StringUtils.isNotEmpty(this.mCardId) || this.mCardId.length() <= 2) {
            return;
        }
        if (!this.mCardId.equals(this.mTvCardId.getText().toString())) {
            this.mTvCardId.setText(this.mCardId);
            this.mImgBtnEye.setImageResource(R.mipmap.displaypsw_white);
            return;
        }
        TextView textView = this.mTvCardId;
        StringBuilder sb = new StringBuilder("****  **");
        String str = this.mCardId;
        textView.setText(sb.append(str.substring(str.length() - 2)).toString());
        this.mImgBtnEye.setImageResource(R.mipmap.hidepsw_white);
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$2$client-android-yixiaotong-ui-drinkwater-CardDetailOldActivity, reason: not valid java name */
    /* synthetic */ void m119xc5f44fe4(View view) {
        BindCardTipDialog.getInstance().showDialog(getActivity(), new BindCardTipDialog.Listener() { // from class: client.android.yixiaotong.ui.drinkwater.CardDetailOldActivity$$ExternalSyntheticLambda0
            @Override // client.android.yixiaotong.v3.ui.dialog.BindCardTipDialog.Listener
            public final void onConfirm(String str) {
                CardDetailOldActivity.lambda$initClickListeners$1(str);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$3$client-android-yixiaotong-ui-drinkwater-CardDetailOldActivity, reason: not valid java name */
    /* synthetic */ void m120xb983d425(View view) {
        PermissionUtil.requestPerssion(getActivity(), 0, this.permissionGrant);
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$4$client-android-yixiaotong-ui-drinkwater-CardDetailOldActivity, reason: not valid java name */
    /* synthetic */ void m121xad135866(View view) {
        unBindCard();
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$5$client-android-yixiaotong-ui-drinkwater-CardDetailOldActivity, reason: not valid java name */
    /* synthetic */ void m122xa0a2dca7(View view) {
        if (this.mAuthCount > 0) {
            closeCard();
        } else {
            openCard(this.mCardId);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.mIsNeedLoad = false;
        if (intent != null) {
            LogUtil.e(TAG, "  " + i2);
            if (i2 == 3) {
                String stringExtra = intent.getStringExtra("qrcode");
                LogUtil.e(TAG, "  " + stringExtra);
                bindCard(stringExtra);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getCardInfo() {
        BusinessControllers.getInstance().getIsBindCard(getLoginAccount(), this.mTypeId, 0, new Listener<IsBindCardBean>() { // from class: client.android.yixiaotong.ui.drinkwater.CardDetailOldActivity.1
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                super.onStart(controller);
                CardDetailOldActivity.this.mIsNeedLoad = true;
                BaseMaterialDialog.showMaterialDialog(CardDetailOldActivity.this.getActivity(), "加载中.", false);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, IsBindCardBean isBindCardBean, Object... objArr) {
                if (CardDetailOldActivity.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    if (isBindCardBean.isbind == 0) {
                        CardDetailOldActivity.this.mTvBindCardTip.setVisibility(4);
                        CardDetailOldActivity.this.mTvBindState.setVisibility(0);
                        CardDetailOldActivity.this.mTvCardId.setVisibility(0);
                        CardDetailOldActivity.this.mImgBtnEye.setVisibility(0);
                        if (StringUtils.isNotEmpty(isBindCardBean.cardid) && isBindCardBean.cardid.length() > 2) {
                            CardDetailOldActivity.this.mTvCardId.setText("****  **" + isBindCardBean.cardid.substring(isBindCardBean.cardid.length() - 2));
                            CardDetailOldActivity.this.mCardId = isBindCardBean.cardid;
                        }
                        CardDetailOldActivity.this.mBtnUnBind.setVisibility(0);
                        CardDetailOldActivity.this.mRelAuth.setVisibility(0);
                        CardDetailOldActivity.this.mAuthCount = 0;
                        if (isBindCardBean.cardList != null && isBindCardBean.cardList.size() > 0) {
                            for (int i = 0; i < isBindCardBean.cardList.size(); i++) {
                                if (isBindCardBean.cardList.get(i).status == 0 && isBindCardBean.cardList.get(i).typeid == CardDetailOldActivity.this.mTypeId) {
                                    CardDetailOldActivity.access$1008(CardDetailOldActivity.this);
                                }
                            }
                        }
                        if (CardDetailOldActivity.this.mAuthCount > 0) {
                            CardDetailOldActivity.this.mTvAuthState.setText(CardDetailOldActivity.this.getString(R.string.authed));
                            CardDetailOldActivity.this.mTvAuthState.setTextColor(CardDetailOldActivity.this.getResources().getColor(R.color.ffa1a6b3));
                            CardDetailOldActivity.this.mImgAuth.setImageResource(R.mipmap.open2);
                            return;
                        } else {
                            CardDetailOldActivity.this.mTvAuthState.setText(CardDetailOldActivity.this.getString(R.string.noauth));
                            CardDetailOldActivity.this.mTvAuthState.setTextColor(CardDetailOldActivity.this.getResources().getColor(R.color.fff13628));
                            CardDetailOldActivity.this.mImgAuth.setImageResource(R.mipmap.close2);
                            return;
                        }
                    }
                    CardDetailOldActivity.this.mTvBindCardTip.setVisibility(0);
                    CardDetailOldActivity.this.mTvBindState.setVisibility(4);
                    CardDetailOldActivity.this.mTvCardId.setVisibility(4);
                    CardDetailOldActivity.this.mImgBtnEye.setVisibility(8);
                    CardDetailOldActivity.this.mBtnUnBind.setVisibility(4);
                    CardDetailOldActivity.this.mImgAuth.setImageResource(R.mipmap.close2);
                    CardDetailOldActivity.this.mRelAuth.setVisibility(8);
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (CardDetailOldActivity.this.mIsEnable) {
                    CardDetailOldActivity.this.onError(clientException);
                }
            }
        });
    }

    private void bindCard(String str) {
        if (StringUtils.isNotEmpty(str)) {
            if (str.length() == 8) {
                BusinessControllers.getInstance().bindCard2(getLoginAccount(), this.mTypeId, AppUtils.getVersion(getActivity()), this.mMachineId, str, new Listener<BindCardBean>() { // from class: client.android.yixiaotong.ui.drinkwater.CardDetailOldActivity.2
                    @Override // client.android.yixiaotong.controller.core.Listener
                    public void onStart(Controller controller) {
                        super.onStart(controller);
                        BaseMaterialDialog.showMaterialDialog(CardDetailOldActivity.this.getActivity(), "绑定卡片中.", false);
                    }

                    @Override // client.android.yixiaotong.controller.core.Listener
                    public void onComplete(Controller controller, BindCardBean bindCardBean, Object... objArr) {
                        if (CardDetailOldActivity.this.mIsEnable) {
                            BaseMaterialDialog.dissmisMaterialDialog();
                            ToastUtils.show(CardDetailOldActivity.this.getContext(), "绑卡成功！");
                            CardDetailOldActivity.this.openCard(bindCardBean.cardid);
                        }
                    }

                    @Override // client.android.yixiaotong.controller.core.Listener
                    public void onFail(Controller controller, ClientException clientException) {
                        if (CardDetailOldActivity.this.mIsEnable) {
                            CardDetailOldActivity.this.onError(clientException);
                        }
                    }
                });
                return;
            }
            if (str.contains("?")) {
                String[] strArrSplit = str.split("\\?");
                if (strArrSplit.length >= 1) {
                    str = strArrSplit[1];
                }
            }
            if (str.length() > 50 && QrcodeUtil.isNumberLetterIllegal(str.toUpperCase())) {
                String strSubstring = str.substring(34, 50);
                XOrUtils xOrUtils = new XOrUtils();
                String str2 = str.substring(16, 20) + xOrUtils.xOr(NBDeviceCommand.minusCode(str.substring(20, 22), "AA"), xOrUtils.xOr(str.substring(16, 18), str.substring(18, 20))) + xOrUtils.xOr(NBDeviceCommand.minusCode(str.substring(22, 24), "AA"), xOrUtils.xOr(str.substring(16, 18), str.substring(18, 20)));
                if (DeviceControlUtil.isShiDevice(xOrUtils.xOr(NBDeviceCommand.minusCode(str.substring(26, 28), "AA"), xOrUtils.xOr(str.substring(16, 18), str.substring(18, 20))), xOrUtils.xOr(NBDeviceCommand.minusCode(str.substring(28, 30), "AA"), xOrUtils.xOr(str.substring(16, 18), str.substring(18, 20))))) {
                    bindCard(xOrUtils.xOr(NBDeviceCommand.minusCode(str.substring(40, 42), "AA"), xOrUtils.xOr(str.substring(16, 18), str.substring(18, 20))) + xOrUtils.xOr(NBDeviceCommand.minusCode(str.substring(38, 40), "AA"), xOrUtils.xOr(str.substring(16, 18), str.substring(18, 20))) + xOrUtils.xOr(NBDeviceCommand.minusCode(str.substring(36, 38), "AA"), xOrUtils.xOr(str.substring(16, 18), str.substring(18, 20))) + xOrUtils.xOr(NBDeviceCommand.minusCode(str.substring(34, 36), "AA"), xOrUtils.xOr(str.substring(16, 18), str.substring(18, 20))));
                    return;
                }
                BusinessControllers.getInstance().bindCard(getLoginAccount(), this.mTypeId, 0, this.mMachineId, strSubstring, AppUtils.getVersion(getActivity()), str2, new Listener<BindCardBean>() { // from class: client.android.yixiaotong.ui.drinkwater.CardDetailOldActivity.3
                    @Override // client.android.yixiaotong.controller.core.Listener
                    public void onStart(Controller controller) {
                        super.onStart(controller);
                        BaseMaterialDialog.showMaterialDialog(CardDetailOldActivity.this.getActivity(), "绑定卡片中.", false);
                    }

                    @Override // client.android.yixiaotong.controller.core.Listener
                    public void onComplete(Controller controller, BindCardBean bindCardBean, Object... objArr) {
                        if (CardDetailOldActivity.this.mIsEnable) {
                            BaseMaterialDialog.dissmisMaterialDialog();
                            ToastUtils.show(CardDetailOldActivity.this.getContext(), "绑卡成功！");
                            CardDetailOldActivity.this.openCard(bindCardBean.cardid);
                        }
                    }

                    @Override // client.android.yixiaotong.controller.core.Listener
                    public void onFail(Controller controller, ClientException clientException) {
                        if (CardDetailOldActivity.this.mIsEnable) {
                            CardDetailOldActivity.this.onError(clientException);
                        }
                    }
                });
                return;
            }
            ToastUtils.show(getContext(), "设备二维码异常");
            return;
        }
        ToastUtils.show(getContext(), "设备二维码异常!");
    }

    private void unBindCard() {
        if (StringUtils.isNotEmpty(this.mCardId)) {
            BusinessControllers.getInstance().unBindCard(getLoginAccount(), this.mTypeId, 0, this.mMachineId, this.mCardId, new Listener<SuccessBean>() { // from class: client.android.yixiaotong.ui.drinkwater.CardDetailOldActivity.4
                @Override // client.android.yixiaotong.controller.core.Listener
                public void onStart(Controller controller) {
                    super.onStart(controller);
                    BaseMaterialDialog.showMaterialDialog(CardDetailOldActivity.this.getActivity(), "解绑卡片中.", false);
                }

                @Override // client.android.yixiaotong.controller.core.Listener
                public void onComplete(Controller controller, SuccessBean successBean, Object... objArr) {
                    if (CardDetailOldActivity.this.mIsEnable) {
                        BaseMaterialDialog.dissmisMaterialDialog();
                        ToastUtils.show(CardDetailOldActivity.this.getContext(), "解绑成功！");
                        CardDetailOldActivity.this.getCardInfo();
                    }
                }

                @Override // client.android.yixiaotong.controller.core.Listener
                public void onFail(Controller controller, ClientException clientException) {
                    if (CardDetailOldActivity.this.mIsEnable) {
                        CardDetailOldActivity.this.onError(clientException);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openCard(String str) {
        BusinessControllers.getInstance().openCard(getLoginAccount(), this.mTypeId, 0, this.mMachineId, str, new Listener<SuccessBean>() { // from class: client.android.yixiaotong.ui.drinkwater.CardDetailOldActivity.5
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, SuccessBean successBean, Object... objArr) {
                super.onComplete(controller, successBean, objArr);
                if (CardDetailOldActivity.this.mIsEnable) {
                    ToastUtils.show(CardDetailOldActivity.this.getActivity(), "开通授权成功");
                    CardDetailOldActivity.this.getCardInfo();
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (CardDetailOldActivity.this.mIsEnable) {
                    CardDetailOldActivity.this.onError(clientException);
                }
            }
        });
    }

    private void closeCard() {
        BusinessControllers.getInstance().closeCard(getLoginAccount(), this.mTypeId, 0, this.mMachineId, this.mCardId, new Listener<SuccessBean>() { // from class: client.android.yixiaotong.ui.drinkwater.CardDetailOldActivity.6
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, SuccessBean successBean, Object... objArr) {
                super.onComplete(controller, successBean, objArr);
                if (CardDetailOldActivity.this.mIsEnable) {
                    ToastUtils.show(CardDetailOldActivity.this.getActivity(), "关闭授权成功");
                    CardDetailOldActivity.this.getCardInfo();
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (CardDetailOldActivity.this.mIsEnable) {
                    CardDetailOldActivity.this.onError(clientException);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onError(ClientException clientException) {
        BaseMaterialDialog.dissmisMaterialDialog();
        ErrorUtil.onFailResult(getActivity(), this.mTitleBar.getTitleViewContent(), clientException, false);
    }
}
