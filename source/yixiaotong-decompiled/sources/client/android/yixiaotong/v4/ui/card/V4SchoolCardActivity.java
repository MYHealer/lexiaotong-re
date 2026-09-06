package client.android.yixiaotong.v4.ui.card;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.controller.bean.SuccessBean;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.ui.dialog.BaseMaterialDialog;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.util.permission.PermissionUtil;
import client.android.yixiaotong.v3.ui.adv.AdvControlUtil;
import client.android.yixiaotong.v3.ui.adv.Common;
import client.android.yixiaotong.v3.ui.adv.NativeUtil;
import client.android.yixiaotong.v3.ui.dialog.BindCardTipDialog;
import client.android.yixiaotong.v3.ui.scan.ScanQrcodeActivity;
import client.android.yixiaotong.v3.util.LogUtil;
import client.android.yixiaotong.v4.http.V4BusinessControllers;
import client.android.yixiaotong.v4.http.bean.V4CardInfoBean;
import client.android.yixiaotong.v4.ui.error.V4ErrorControlUtil;
import client.android.yixiaotong.v4.util.homeinfo.V4HomeInfoUtil;
import client.android.yixiaotong.v4.util.userinfo.V4UserInfoUtil;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class V4SchoolCardActivity extends BaseActivity {
    private static final String TAG = "V4SchoolCardActivity";
    RelativeLayout flContainer;
    private AdvControlUtil.AdvListener mAdvListener;
    Button mBtnUnBind;
    private String mCardId;
    ImageButton mImgBtnEye;
    private NativeUtil mNativeUtil;
    ScrollView mScrollView;
    TitleBar mTitleBar;
    TextView mTvAdvName;
    TextView mTvBindCardTip;
    TextView mTvBindState;
    TextView mTvCardId;
    private boolean mIsEnable = true;
    private PermissionUtil.PermissionGrant permissionGrant = new PermissionUtil.PermissionGrant() { // from class: client.android.yixiaotong.v4.ui.card.V4SchoolCardActivity.5
        @Override // client.android.yixiaotong.util.permission.PermissionUtil.PermissionGrant
        public void onPermissionGranted(int i) {
            if (i != 0) {
                return;
            }
            ScanQrcodeActivity.launch(V4SchoolCardActivity.this.getActivity(), 3);
        }
    };
    private boolean mIsShowAdv = false;

    static {
        StubApp.interface11(10857);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public native void onRequestPermissionsResult(int i, String[] strArr, int[] iArr);

    public static void launch(Activity activity) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) V4SchoolCardActivity.class));
        }
    }

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.titleBar);
        this.mTvBindCardTip = (TextView) findViewById(R.id.tv_bindcardtip);
        this.mTvBindState = (TextView) findViewById(R.id.tv_bindcardstate);
        this.mTvCardId = (TextView) findViewById(R.id.tv_cardid);
        this.mImgBtnEye = (ImageButton) findViewById(R.id.ib_eye);
        this.mBtnUnBind = (Button) findViewById(R.id.btn_unbind);
        this.flContainer = (RelativeLayout) findViewById(R.id.flContainer);
        this.mScrollView = (ScrollView) findViewById(R.id.scrollview);
        this.mTvAdvName = (TextView) findViewById(R.id.tv_advname);
    }

    private void initTitleBar() {
        this.mTitleBar.setTitleView(getString(R.string.schoolcard));
        this.mTitleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
        ImageButton imageButton = (ImageButton) findViewById(R.id.ib_eye);
        View viewFindViewById = findViewById(R.id.rel_bindcardtip);
        View viewFindViewById2 = findViewById(R.id.rel_scanbindcard);
        Button button = (Button) findViewById(R.id.btn_unbind);
        imageButton.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.card.V4SchoolCardActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m504xfc82698a(view);
            }
        });
        viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.card.V4SchoolCardActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m505xd38364b(view);
            }
        });
        viewFindViewById2.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.card.V4SchoolCardActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m506x1dee030c(view);
            }
        });
        button.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.card.V4SchoolCardActivity$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m507x2ea3cfcd(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$initTitleBar$0$client-android-yixiaotong-v4-ui-card-V4SchoolCardActivity, reason: not valid java name */
    /* synthetic */ void m504xfc82698a(View view) {
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

    /* JADX INFO: renamed from: lambda$initTitleBar$1$client-android-yixiaotong-v4-ui-card-V4SchoolCardActivity, reason: not valid java name */
    /* synthetic */ void m505xd38364b(View view) {
        BindCardTipDialog.getInstance().showDialog(getActivity(), new BindCardTipDialog.Listener() { // from class: client.android.yixiaotong.v4.ui.card.V4SchoolCardActivity.1
            @Override // client.android.yixiaotong.v3.ui.dialog.BindCardTipDialog.Listener
            public void onConfirm(String str) {
            }
        });
    }

    /* JADX INFO: renamed from: lambda$initTitleBar$2$client-android-yixiaotong-v4-ui-card-V4SchoolCardActivity, reason: not valid java name */
    /* synthetic */ void m506x1dee030c(View view) {
        PermissionUtil.requestPerssion(getActivity(), 0, this.permissionGrant);
    }

    /* JADX INFO: renamed from: lambda$initTitleBar$3$client-android-yixiaotong-v4-ui-card-V4SchoolCardActivity, reason: not valid java name */
    /* synthetic */ void m507x2ea3cfcd(View view) {
        unBindCard();
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.mIsEnable = true;
        V4ErrorControlUtil.getInstance().onResume();
        getAdv();
        NativeUtil nativeUtil = this.mNativeUtil;
        if (nativeUtil != null) {
            nativeUtil.onResume();
        }
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        this.mIsEnable = false;
        V4ErrorControlUtil.getInstance().onPause();
        BaseMaterialDialog.dissmisMaterialDialog();
        NativeUtil nativeUtil = this.mNativeUtil;
        if (nativeUtil != null) {
            nativeUtil.onPause();
        }
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        NativeUtil nativeUtil = this.mNativeUtil;
        if (nativeUtil != null) {
            nativeUtil.onDestroy();
        }
        super.onDestroy();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (intent == null || i2 != 3) {
            return;
        }
        bindCard(intent.getStringExtra("qrcode"));
    }

    private void getCardInfo() {
        V4BusinessControllers.getInstance().getCardInfo(getLoginAccount(), new Listener<V4CardInfoBean>() { // from class: client.android.yixiaotong.v4.ui.card.V4SchoolCardActivity.2
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                super.onStart(controller);
                BaseMaterialDialog.showMaterialDialog(V4SchoolCardActivity.this.getActivity(), "加载中.", false);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, V4CardInfoBean v4CardInfoBean, Object... objArr) {
                if (V4SchoolCardActivity.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    if (v4CardInfoBean == null) {
                        V4SchoolCardActivity.this.mTvBindCardTip.setVisibility(0);
                        V4SchoolCardActivity.this.mTvBindState.setVisibility(4);
                        V4SchoolCardActivity.this.mTvCardId.setVisibility(4);
                        V4SchoolCardActivity.this.mImgBtnEye.setVisibility(8);
                        V4SchoolCardActivity.this.mBtnUnBind.setVisibility(4);
                        return;
                    }
                    V4SchoolCardActivity.this.mTvBindCardTip.setVisibility(4);
                    V4SchoolCardActivity.this.mTvBindState.setVisibility(0);
                    V4SchoolCardActivity.this.mTvCardId.setVisibility(0);
                    V4SchoolCardActivity.this.mImgBtnEye.setVisibility(0);
                    if (StringUtils.isNotEmpty(v4CardInfoBean.idcardId) && v4CardInfoBean.idcardId.length() > 2) {
                        V4SchoolCardActivity.this.mTvCardId.setText("****  **" + v4CardInfoBean.idcardId.substring(v4CardInfoBean.idcardId.length() - 2));
                        V4SchoolCardActivity.this.mCardId = v4CardInfoBean.idcardId;
                    }
                    V4SchoolCardActivity.this.mBtnUnBind.setVisibility(0);
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (V4SchoolCardActivity.this.mIsEnable) {
                    V4SchoolCardActivity.this.onError(clientException);
                }
            }
        });
    }

    private void bindCard(String str) {
        V4BusinessControllers.getInstance().postBindCard(getLoginAccount(), str, V4UserInfoUtil.getInstance().getLoginAccountV4().userId, new Listener<V4CardInfoBean>() { // from class: client.android.yixiaotong.v4.ui.card.V4SchoolCardActivity.3
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                super.onStart(controller);
                BaseMaterialDialog.showMaterialDialog(V4SchoolCardActivity.this.getActivity(), "绑定卡片中.", false);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, V4CardInfoBean v4CardInfoBean, Object... objArr) {
                if (V4SchoolCardActivity.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    ToastUtils.show(V4SchoolCardActivity.this.getContext(), "绑卡成功！");
                    V4SchoolCardActivity.this.mTvBindCardTip.setVisibility(4);
                    V4SchoolCardActivity.this.mTvBindState.setVisibility(0);
                    V4SchoolCardActivity.this.mTvCardId.setVisibility(0);
                    V4SchoolCardActivity.this.mImgBtnEye.setVisibility(0);
                    if (StringUtils.isNotEmpty(v4CardInfoBean.idcardId) && v4CardInfoBean.idcardId.length() > 2) {
                        V4SchoolCardActivity.this.mImgBtnEye.setImageResource(R.mipmap.hidepsw_white);
                        V4SchoolCardActivity.this.mTvCardId.setText("****  **" + v4CardInfoBean.idcardId.substring(v4CardInfoBean.idcardId.length() - 2));
                        V4SchoolCardActivity.this.mCardId = v4CardInfoBean.idcardId;
                    }
                    V4SchoolCardActivity.this.mBtnUnBind.setVisibility(0);
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (V4SchoolCardActivity.this.mIsEnable) {
                    V4SchoolCardActivity.this.onError(clientException);
                }
            }
        });
    }

    private void unBindCard() {
        V4BusinessControllers.getInstance().postUnBindCard(getLoginAccount(), new Listener<SuccessBean>() { // from class: client.android.yixiaotong.v4.ui.card.V4SchoolCardActivity.4
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                super.onStart(controller);
                BaseMaterialDialog.showMaterialDialog(V4SchoolCardActivity.this.getActivity(), "解绑卡片中.", false);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, SuccessBean successBean, Object... objArr) {
                if (V4SchoolCardActivity.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    ToastUtils.show(V4SchoolCardActivity.this.getContext(), "解绑成功！");
                    V4SchoolCardActivity.this.mCardId = "";
                    V4SchoolCardActivity.this.mTvBindCardTip.setVisibility(0);
                    V4SchoolCardActivity.this.mTvBindState.setVisibility(4);
                    V4SchoolCardActivity.this.mTvCardId.setVisibility(4);
                    V4SchoolCardActivity.this.mTvCardId.setText("");
                    V4SchoolCardActivity.this.mImgBtnEye.setVisibility(8);
                    V4SchoolCardActivity.this.mBtnUnBind.setVisibility(4);
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (V4SchoolCardActivity.this.mIsEnable) {
                    V4SchoolCardActivity.this.onError(clientException);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onError(ClientException clientException) {
        BaseMaterialDialog.dissmisMaterialDialog();
        V4ErrorControlUtil.getInstance().showDialog(clientException, getActivity(), false);
    }

    private void initAdv() {
        this.mNativeUtil = new NativeUtil();
    }

    private void getAdv() {
        if (this.mIsShowAdv) {
            return;
        }
        this.mAdvListener = new AdvControlUtil.AdvListener() { // from class: client.android.yixiaotong.v4.ui.card.V4SchoolCardActivity.6
            @Override // client.android.yixiaotong.v3.ui.adv.AdvControlUtil.AdvListener
            public void isOpen(int i, int i2, int i3, int i4, int i5) {
            }

            @Override // client.android.yixiaotong.v3.ui.adv.AdvControlUtil.AdvListener
            public void onAdClosed(Common.AdvType advType) {
            }

            @Override // client.android.yixiaotong.v3.ui.adv.AdvControlUtil.AdvListener
            public void onRenderSuccess(View view, int i) {
            }

            @Override // client.android.yixiaotong.v3.ui.adv.AdvControlUtil.AdvListener
            public void onAdShow(String str, Common.AdvType advType) {
                V4SchoolCardActivity.this.mIsShowAdv = true;
            }
        };
        boolean zIsOpenAdv = V4HomeInfoUtil.getInstance().isOpenAdv();
        LogUtil.e(TAG, "广告是否开启：" + zIsOpenAdv);
        if (zIsOpenAdv) {
            this.mNativeUtil.initNative(getActivity(), this.mAdvListener, 1);
            this.mNativeUtil.onNative(this.flContainer);
        }
    }
}
