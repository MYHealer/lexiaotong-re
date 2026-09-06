package client.android.yixiaotong.v3.ui.card;

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
import client.android.yixiaotong.baseutil.XOrUtils;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.ui.dialog.BaseMaterialDialog;
import client.android.yixiaotong.ui.dialog.SystemErrorTip;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.util.executor.MainThreadExecutor;
import client.android.yixiaotong.util.permission.PermissionUtil;
import client.android.yixiaotong.v3.bean.card.BindCardExtendJson;
import client.android.yixiaotong.v3.bean.card.SchoolCardInfoBean;
import client.android.yixiaotong.v3.bean.login.InvestorInfoBean;
import client.android.yixiaotong.v3.bean.login.TypeInfoBean;
import client.android.yixiaotong.v3.comman.DeviceControlUtil;
import client.android.yixiaotong.v3.comman.NBDeviceCommand;
import client.android.yixiaotong.v3.http.V3BusinessControllers;
import client.android.yixiaotong.v3.ui.adv.AdvControlUtil;
import client.android.yixiaotong.v3.ui.adv.Common;
import client.android.yixiaotong.v3.ui.adv.NativeUtil;
import client.android.yixiaotong.v3.ui.dialog.BindCardTipDialog;
import client.android.yixiaotong.v3.ui.error.V3ErrorTipActivity;
import client.android.yixiaotong.v3.ui.scan.QrcodeUtil;
import client.android.yixiaotong.v3.ui.scan.ScanQrcodeActivity;
import client.android.yixiaotong.v3.userinfo.InvestorInfoUtil;
import client.android.yixiaotong.v3.userinfo.InvestorInfoUtilControl;
import client.android.yixiaotong.v3.userinfo.UserInfoUtil;
import client.android.yixiaotong.v3.util.LogUtil;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class SchoolCardActivity extends BaseActivity {
    private static final String TAG = "SchoolCardActivity";
    private RelativeLayout flContainer;
    private AdvControlUtil.AdvListener mAdvListener;
    private Button mBtnUnBind;
    private String mCardId;
    private ImageButton mImgBtnEye;
    private InvestorInfoBean mInvestorInfoBean;
    private NativeUtil mNativeUtil;
    private RelativeLayout mRelAuth;
    private ScrollView mScrollView;
    private TitleBar mTitleBar;
    private TextView mTvAdvName;
    private TextView mTvAuthState;
    private TextView mTvBindCardTip;
    private TextView mTvBindState;
    private TextView mTvCardId;
    private TextView mTvClickSet;
    private boolean mIsEnable = true;
    private int mAuthCount = 0;
    private List<TypeInfoBean> mAppDatas = new ArrayList();
    private List<Integer> mTypeids = new ArrayList();
    private boolean mIsNeedLoad = true;
    private List<BindCardExtendJson> mExtendJsons = new ArrayList();
    private PermissionUtil.PermissionGrant permissionGrant = new PermissionUtil.PermissionGrant() { // from class: client.android.yixiaotong.v3.ui.card.SchoolCardActivity.5
        @Override // client.android.yixiaotong.util.permission.PermissionUtil.PermissionGrant
        public void onPermissionGranted(int i) {
            if (i != 0) {
                return;
            }
            ScanQrcodeActivity.launch(SchoolCardActivity.this.getActivity(), 3);
        }
    };
    private boolean mIsShowAdv = false;

    static {
        StubApp.interface11(9670);
    }

    static /* synthetic */ void lambda$initClickListeners$1(String str) {
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public native void onRequestPermissionsResult(int i, String[] strArr, int[] iArr);

    static /* synthetic */ int access$1008(SchoolCardActivity schoolCardActivity) {
        int i = schoolCardActivity.mAuthCount;
        schoolCardActivity.mAuthCount = i + 1;
        return i;
    }

    public static void launch(Activity activity) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) SchoolCardActivity.class));
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
        this.mTvAuthState = (TextView) findViewById(R.id.tv_authstate);
        this.mTvClickSet = (TextView) findViewById(R.id.tv_clickset);
        this.flContainer = (RelativeLayout) findViewById(R.id.flContainer);
        this.mScrollView = (ScrollView) findViewById(R.id.scrollview);
        this.mTvAdvName = (TextView) findViewById(R.id.tv_advname);
    }

    private void initTitleBar() {
        this.mTitleBar.setTitleView(getString(R.string.schoolcard));
        this.mTitleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
    }

    private void initData() {
        int investorInfosIndex = InvestorInfoUtil.getInstance().getInvestorInfosIndex();
        if (InvestorInfoUtil.getInstance().getInvestorInfosV3() != null && InvestorInfoUtil.getInstance().getInvestorInfosV3().size() > 0 && InvestorInfoUtil.getInstance().getInvestorInfosV3().get(investorInfosIndex) != null) {
            this.mInvestorInfoBean = InvestorInfoUtil.getInstance().getInvestorInfosV3().get(investorInfosIndex).investorInfo;
            this.mAppDatas.clear();
            if (this.mInvestorInfoBean != null) {
                for (int i = 0; i < this.mInvestorInfoBean.planInfo.size(); i++) {
                    for (int i2 = 0; i2 < this.mInvestorInfoBean.planInfo.get(i).typeInfo.size(); i2++) {
                        this.mAppDatas.add(this.mInvestorInfoBean.planInfo.get(i).typeInfo.get(i2));
                    }
                }
            }
        }
        if (this.mAppDatas.size() > 0) {
            for (int i3 = 0; i3 < this.mAppDatas.size(); i3++) {
                this.mTypeids.add(Integer.valueOf(this.mAppDatas.get(i3).base.typeId));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getAuthSize() {
        List<TypeInfoBean> typeInfoBeans = InvestorInfoUtilControl.getInstance().getTypeInfoBeans();
        this.mAuthCount = 0;
        if (typeInfoBeans != null && typeInfoBeans.size() > 0) {
            for (int i = 0; i < typeInfoBeans.size(); i++) {
                LogUtil.e(TAG, i + "  " + typeInfoBeans.get(i).base.typeId + "  " + typeInfoBeans.get(i).base.appName + "  " + typeInfoBeans.get(i).useToolsJson.useCardFlag);
                if (typeInfoBeans.get(i).useToolsJson.useCardFlag == 1) {
                    for (int i2 = 0; i2 < this.mExtendJsons.size(); i2++) {
                        LogUtil.e(TAG, this.mExtendJsons.get(i2).typeid + "  " + typeInfoBeans.get(i).base.typeId);
                        if (this.mExtendJsons.get(i2).typeid == typeInfoBeans.get(i).base.typeId) {
                            this.mAuthCount++;
                        }
                    }
                }
            }
        }
        this.mTvClickSet.setText(this.mAuthCount + getString(R.string.devices));
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.mIsEnable = true;
        if (this.mIsNeedLoad) {
            getCardInfo();
        }
        getAdv();
        AdvControlUtil.getInstance().onResume();
        NativeUtil nativeUtil = this.mNativeUtil;
        if (nativeUtil != null) {
            nativeUtil.onResume();
        }
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        this.mIsEnable = false;
        BaseMaterialDialog.dissmisMaterialDialog();
        AdvControlUtil.getInstance().onPause();
        NativeUtil nativeUtil = this.mNativeUtil;
        if (nativeUtil != null) {
            nativeUtil.onPause();
        }
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        AdvControlUtil.getInstance().onDestroy(getActivity());
        NativeUtil nativeUtil = this.mNativeUtil;
        if (nativeUtil != null) {
            nativeUtil.onDestroy();
        }
        super.onDestroy();
    }

    private void initClickListeners() {
        findViewById(R.id.ib_eye).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.card.SchoolCardActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m326xe7fd2789(view);
            }
        });
        findViewById(R.id.rel_bindcardtip).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.card.SchoolCardActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m327x3325398b(view);
            }
        });
        findViewById(R.id.rel_auth).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.card.SchoolCardActivity$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m328x58b9428c(view);
            }
        });
        findViewById(R.id.rel_scanbindcard).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.card.SchoolCardActivity$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m329x7e4d4b8d(view);
            }
        });
        findViewById(R.id.btn_unbind).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.card.SchoolCardActivity$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m330xa3e1548e(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$0$client-android-yixiaotong-v3-ui-card-SchoolCardActivity, reason: not valid java name */
    /* synthetic */ void m326xe7fd2789(View view) {
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

    /* JADX INFO: renamed from: lambda$initClickListeners$2$client-android-yixiaotong-v3-ui-card-SchoolCardActivity, reason: not valid java name */
    /* synthetic */ void m327x3325398b(View view) {
        BindCardTipDialog.getInstance().showDialog(getActivity(), new BindCardTipDialog.Listener() { // from class: client.android.yixiaotong.v3.ui.card.SchoolCardActivity$$ExternalSyntheticLambda0
            @Override // client.android.yixiaotong.v3.ui.dialog.BindCardTipDialog.Listener
            public final void onConfirm(String str) {
                SchoolCardActivity.lambda$initClickListeners$1(str);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$3$client-android-yixiaotong-v3-ui-card-SchoolCardActivity, reason: not valid java name */
    /* synthetic */ void m328x58b9428c(View view) {
        if (this.mAuthCount > 0) {
            AuthCardActivity.launch(getActivity(), this.mExtendJsons, this.mCardId);
        }
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$4$client-android-yixiaotong-v3-ui-card-SchoolCardActivity, reason: not valid java name */
    /* synthetic */ void m329x7e4d4b8d(View view) {
        PermissionUtil.requestPerssion(getActivity(), 0, this.permissionGrant);
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$5$client-android-yixiaotong-v3-ui-card-SchoolCardActivity, reason: not valid java name */
    /* synthetic */ void m330xa3e1548e(View view) {
        unBindCard();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.mIsNeedLoad = false;
        if (intent == null || i2 != 3) {
            return;
        }
        bindCard(intent.getStringExtra("qrcode"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getCardInfo() {
        V3BusinessControllers.getInstance().getFindCard(getLoginAccount(), UserInfoUtil.getInstance().getLoginAccountV3().schoolInfoList.get(UserInfoUtil.getInstance().getSchoolInfosIndex()).id + "", new Listener<SchoolCardInfoBean>() { // from class: client.android.yixiaotong.v3.ui.card.SchoolCardActivity.1
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                super.onStart(controller);
                SchoolCardActivity.this.mIsNeedLoad = true;
                BaseMaterialDialog.showMaterialDialog(SchoolCardActivity.this.getActivity(), "加载中.", false);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, SchoolCardInfoBean schoolCardInfoBean, Object... objArr) {
                if (SchoolCardActivity.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    if (schoolCardInfoBean == null) {
                        ToastUtils.show(SchoolCardActivity.this.getContext(), "卡片信息为空！");
                        SchoolCardActivity.this.finish();
                        return;
                    }
                    if (schoolCardInfoBean.cardFlag == 0) {
                        SchoolCardActivity.this.mTvBindCardTip.setVisibility(4);
                        SchoolCardActivity.this.mTvBindState.setVisibility(0);
                        SchoolCardActivity.this.mTvCardId.setVisibility(0);
                        SchoolCardActivity.this.mImgBtnEye.setVisibility(0);
                        if (StringUtils.isNotEmpty(schoolCardInfoBean.cardId) && schoolCardInfoBean.cardId.length() > 2) {
                            SchoolCardActivity.this.mTvCardId.setText("****  **" + schoolCardInfoBean.cardId.substring(schoolCardInfoBean.cardId.length() - 2));
                            SchoolCardActivity.this.mCardId = schoolCardInfoBean.cardId;
                        }
                        SchoolCardActivity.this.mBtnUnBind.setVisibility(0);
                        SchoolCardActivity.this.mRelAuth.setVisibility(0);
                        SchoolCardActivity.this.mAuthCount = 0;
                        if (schoolCardInfoBean.extendJson != null && schoolCardInfoBean.extendJson.size() > 0) {
                            for (int i = 0; i < schoolCardInfoBean.extendJson.size(); i++) {
                                if (schoolCardInfoBean.extendJson.get(i).status == 0) {
                                    SchoolCardActivity.access$1008(SchoolCardActivity.this);
                                }
                            }
                        }
                        if (schoolCardInfoBean.extendJson != null) {
                            SchoolCardActivity.this.mExtendJsons = schoolCardInfoBean.extendJson;
                        }
                        if (SchoolCardActivity.this.mAuthCount > 0) {
                            SchoolCardActivity.this.mTvAuthState.setText(SchoolCardActivity.this.getString(R.string.authed));
                            SchoolCardActivity.this.mTvAuthState.setTextColor(SchoolCardActivity.this.getResources().getColor(R.color.ffa1a6b3));
                            SchoolCardActivity.this.mTvClickSet.setText(SchoolCardActivity.this.mAuthCount + SchoolCardActivity.this.getString(R.string.devices));
                            SchoolCardActivity.this.mTvClickSet.setTextColor(SchoolCardActivity.this.getResources().getColor(R.color.ff242933));
                            SchoolCardActivity.this.getAuthSize();
                            return;
                        }
                        SchoolCardActivity.this.mTvAuthState.setText(SchoolCardActivity.this.getString(R.string.noauth));
                        SchoolCardActivity.this.mTvAuthState.setTextColor(SchoolCardActivity.this.getResources().getColor(R.color.fff13628));
                        SchoolCardActivity.this.mTvClickSet.setText(SchoolCardActivity.this.getString(R.string.clickset));
                        SchoolCardActivity.this.mTvClickSet.setTextColor(SchoolCardActivity.this.getResources().getColor(R.color.ffa1a6b3));
                        return;
                    }
                    SchoolCardActivity.this.mTvBindCardTip.setVisibility(0);
                    SchoolCardActivity.this.mTvBindState.setVisibility(4);
                    SchoolCardActivity.this.mTvCardId.setVisibility(4);
                    SchoolCardActivity.this.mImgBtnEye.setVisibility(8);
                    SchoolCardActivity.this.mBtnUnBind.setVisibility(4);
                    SchoolCardActivity.this.mRelAuth.setVisibility(8);
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (SchoolCardActivity.this.mIsEnable) {
                    SchoolCardActivity.this.mIsNeedLoad = false;
                    SchoolCardActivity.this.onError(clientException);
                }
            }
        });
    }

    private void bindCard(String str) {
        String str2 = UserInfoUtil.getInstance().getLoginAccountV3().schoolInfoList.get(UserInfoUtil.getInstance().getSchoolInfosIndex()).id + "";
        if (StringUtils.isNotEmpty(str)) {
            if (str.length() == 8) {
                V3BusinessControllers.getInstance().postBindCardByMachine2(getLoginAccount(), str2, str, this.mTypeids, new Listener<SchoolCardInfoBean>() { // from class: client.android.yixiaotong.v3.ui.card.SchoolCardActivity.2
                    @Override // client.android.yixiaotong.controller.core.Listener
                    public void onStart(Controller controller) {
                        super.onStart(controller);
                        BaseMaterialDialog.showMaterialDialog(SchoolCardActivity.this.getActivity(), "绑定卡片中.", false);
                    }

                    @Override // client.android.yixiaotong.controller.core.Listener
                    public void onComplete(Controller controller, SchoolCardInfoBean schoolCardInfoBean, Object... objArr) {
                        if (SchoolCardActivity.this.mIsEnable) {
                            BaseMaterialDialog.dissmisMaterialDialog();
                            if (schoolCardInfoBean == null || schoolCardInfoBean.cardFlag != 0) {
                                ToastUtils.show(SchoolCardActivity.this.getContext(), "绑卡失败！");
                            } else {
                                ToastUtils.show(SchoolCardActivity.this.getContext(), "绑卡成功！");
                                SchoolCardActivity.this.getCardInfo();
                            }
                        }
                    }

                    @Override // client.android.yixiaotong.controller.core.Listener
                    public void onFail(Controller controller, ClientException clientException) {
                        if (SchoolCardActivity.this.mIsEnable) {
                            SchoolCardActivity.this.onError(clientException);
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
                String str3 = str.substring(16, 20) + xOrUtils.xOr(NBDeviceCommand.minusCode(str.substring(20, 22), "AA"), xOrUtils.xOr(str.substring(16, 18), str.substring(18, 20))) + xOrUtils.xOr(NBDeviceCommand.minusCode(str.substring(22, 24), "AA"), xOrUtils.xOr(str.substring(16, 18), str.substring(18, 20)));
                if (DeviceControlUtil.isShiDevice(xOrUtils.xOr(NBDeviceCommand.minusCode(str.substring(26, 28), "AA"), xOrUtils.xOr(str.substring(16, 18), str.substring(18, 20))), xOrUtils.xOr(NBDeviceCommand.minusCode(str.substring(28, 30), "AA"), xOrUtils.xOr(str.substring(16, 18), str.substring(18, 20))))) {
                    bindCard(xOrUtils.xOr(NBDeviceCommand.minusCode(str.substring(40, 42), "AA"), xOrUtils.xOr(str.substring(16, 18), str.substring(18, 20))) + xOrUtils.xOr(NBDeviceCommand.minusCode(str.substring(38, 40), "AA"), xOrUtils.xOr(str.substring(16, 18), str.substring(18, 20))) + xOrUtils.xOr(NBDeviceCommand.minusCode(str.substring(36, 38), "AA"), xOrUtils.xOr(str.substring(16, 18), str.substring(18, 20))) + xOrUtils.xOr(NBDeviceCommand.minusCode(str.substring(34, 36), "AA"), xOrUtils.xOr(str.substring(16, 18), str.substring(18, 20))));
                    return;
                }
                V3BusinessControllers.getInstance().postBindCardByMachine(getLoginAccount(), str2, "0000000000000000", strSubstring, str3, this.mTypeids, new Listener<SchoolCardInfoBean>() { // from class: client.android.yixiaotong.v3.ui.card.SchoolCardActivity.3
                    @Override // client.android.yixiaotong.controller.core.Listener
                    public void onStart(Controller controller) {
                        super.onStart(controller);
                        BaseMaterialDialog.showMaterialDialog(SchoolCardActivity.this.getActivity(), "绑定卡片中.", false);
                    }

                    @Override // client.android.yixiaotong.controller.core.Listener
                    public void onComplete(Controller controller, SchoolCardInfoBean schoolCardInfoBean, Object... objArr) {
                        if (SchoolCardActivity.this.mIsEnable) {
                            BaseMaterialDialog.dissmisMaterialDialog();
                            if (schoolCardInfoBean == null || schoolCardInfoBean.cardFlag != 0) {
                                ToastUtils.show(SchoolCardActivity.this.getContext(), "绑卡失败！");
                            } else {
                                ToastUtils.show(SchoolCardActivity.this.getContext(), "绑卡成功！");
                                SchoolCardActivity.this.getCardInfo();
                            }
                        }
                    }

                    @Override // client.android.yixiaotong.controller.core.Listener
                    public void onFail(Controller controller, ClientException clientException) {
                        if (SchoolCardActivity.this.mIsEnable) {
                            SchoolCardActivity.this.onError(clientException);
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
            V3BusinessControllers.getInstance().postUnbindCard(getLoginAccount(), UserInfoUtil.getInstance().getLoginAccountV3().schoolInfoList.get(UserInfoUtil.getInstance().getSchoolInfosIndex()).id + "", this.mCardId, new Listener<SchoolCardInfoBean>() { // from class: client.android.yixiaotong.v3.ui.card.SchoolCardActivity.4
                @Override // client.android.yixiaotong.controller.core.Listener
                public void onStart(Controller controller) {
                    super.onStart(controller);
                    BaseMaterialDialog.showMaterialDialog(SchoolCardActivity.this.getActivity(), "解绑卡片中.", false);
                }

                @Override // client.android.yixiaotong.controller.core.Listener
                public void onComplete(Controller controller, SchoolCardInfoBean schoolCardInfoBean, Object... objArr) {
                    if (SchoolCardActivity.this.mIsEnable) {
                        BaseMaterialDialog.dissmisMaterialDialog();
                        ToastUtils.show(SchoolCardActivity.this.getContext(), "解绑成功！");
                        SchoolCardActivity.this.getCardInfo();
                    }
                }

                @Override // client.android.yixiaotong.controller.core.Listener
                public void onFail(Controller controller, ClientException clientException) {
                    if (SchoolCardActivity.this.mIsEnable) {
                        SchoolCardActivity.this.onError(clientException);
                    }
                }
            });
        }
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

    private void getAdv() {
        if (this.mIsShowAdv) {
            return;
        }
        this.mNativeUtil = new NativeUtil();
        this.mAdvListener = new AdvControlUtil.AdvListener() { // from class: client.android.yixiaotong.v3.ui.card.SchoolCardActivity.6
            @Override // client.android.yixiaotong.v3.ui.adv.AdvControlUtil.AdvListener
            public void onAdClosed(Common.AdvType advType) {
            }

            @Override // client.android.yixiaotong.v3.ui.adv.AdvControlUtil.AdvListener
            public void onRenderSuccess(View view, int i) {
            }

            @Override // client.android.yixiaotong.v3.ui.adv.AdvControlUtil.AdvListener
            public void isOpen(int i, int i2, int i3, int i4, int i5) {
                if (i5 == 1) {
                    SchoolCardActivity.this.mNativeUtil.initNative(SchoolCardActivity.this.getActivity(), SchoolCardActivity.this.mAdvListener, 1);
                    SchoolCardActivity.this.mNativeUtil.onNative(SchoolCardActivity.this.flContainer);
                }
            }

            @Override // client.android.yixiaotong.v3.ui.adv.AdvControlUtil.AdvListener
            public void onAdShow(String str, Common.AdvType advType) {
                SchoolCardActivity.this.mIsShowAdv = true;
            }
        };
        AdvControlUtil.getInstance().init(getActivity(), this.mAdvListener, 1, true, "");
        MainThreadExecutor.getInstance().executeDelayed(new Runnable() { // from class: client.android.yixiaotong.v3.ui.card.SchoolCardActivity.7
            @Override // java.lang.Runnable
            public void run() {
                AdvControlUtil.getInstance().initAdvInfo();
            }
        }, 100L);
    }
}
