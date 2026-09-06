package client.android.yixiaotong.v3.ui.account;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.controller.bean.SuccessBean;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.ui.dialog.BaseMaterialDialog;
import client.android.yixiaotong.ui.dialog.SystemErrorTip;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.v3.bean.login.UserInfoBean;
import client.android.yixiaotong.v3.http.V3BusinessControllers;
import client.android.yixiaotong.v3.ui.error.V3ErrorTipActivity;
import client.android.yixiaotong.v3.userinfo.UserInfoUtil;
import com.baidu.mobads.sdk.api.ArticleInfo;
import com.huawei.openalliance.ad.views.PPSLabelView;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class UpdateInfoActivity extends BaseActivity {
    private EditText mEtData;
    private boolean mIsEnable = true;
    private boolean mIsNeedLoadUserInfo = false;
    private String mName;
    private int mSex;
    private String mStudentNo;
    private TitleBar mTitleBar;
    private int mType;

    static {
        StubApp.interface11(8925);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    public static void launch(Activity activity, String str, int i, String str2, int i2) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) UpdateInfoActivity.class).putExtra("name", str).putExtra(ArticleInfo.USER_SEX, i).putExtra("no", str2).putExtra("type", i2));
        }
    }

    public static void launch(Activity activity, String str, int i, String str2, int i2, boolean z) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) UpdateInfoActivity.class).putExtra("name", str).putExtra(ArticleInfo.USER_SEX, i).putExtra("no", str2).putExtra("type", i2).putExtra("isneedloaduserinfo", z));
        }
    }

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.titleBar);
        this.mEtData = (EditText) findViewById(R.id.et_data);
    }

    private void initTitleBar() {
        int i = this.mType;
        if (i == 1) {
            this.mTitleBar.setTitleView(getString(R.string.studentno));
            this.mEtData.setHint(getString(R.string.fillsno));
        } else if (i == 0) {
            this.mTitleBar.setTitleView(getString(R.string.sex));
            this.mEtData.setHint(getString(R.string.fillsex));
        } else if (i == 2) {
            this.mTitleBar.setTitleView(getString(R.string.name));
            this.mEtData.setHint(getString(R.string.fillinthename));
        }
        this.mTitleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
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
        findViewById(R.id.img_delect).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.account.UpdateInfoActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m228x1c7e50ad(view);
            }
        });
        findViewById(R.id.btn_comfirt).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.account.UpdateInfoActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m229x22821c0c(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$0$client-android-yixiaotong-v3-ui-account-UpdateInfoActivity, reason: not valid java name */
    /* synthetic */ void m228x1c7e50ad(View view) {
        ((EditText) findViewById(R.id.et_data)).setText("");
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$1$client-android-yixiaotong-v3-ui-account-UpdateInfoActivity, reason: not valid java name */
    /* synthetic */ void m229x22821c0c(View view) {
        if (this.mType == 1) {
            updateStudentNo();
        } else {
            updateInfo();
        }
    }

    private boolean check() {
        if (!StringUtils.isEmpty(this.mEtData.getText().toString().replace(PPSLabelView.Code, ""))) {
            return true;
        }
        SystemErrorTip.getInstance().showTipDialog(getActivity(), this.mTitleBar.getTitleViewContent() + "不能为空");
        return false;
    }

    private void updateInfo() {
        if (check()) {
            V3BusinessControllers.getInstance().postUserInfo(getLoginAccount(), this.mSex, this.mEtData.getText().toString(), new Listener<SuccessBean>() { // from class: client.android.yixiaotong.v3.ui.account.UpdateInfoActivity.1
                @Override // client.android.yixiaotong.controller.core.Listener
                public void onStart(Controller controller) {
                    BaseMaterialDialog.showMaterialDialog(UpdateInfoActivity.this.getActivity(), "修改信息中.", false);
                }

                @Override // client.android.yixiaotong.controller.core.Listener
                public void onComplete(Controller controller, SuccessBean successBean, Object... objArr) {
                    if (UpdateInfoActivity.this.mIsEnable) {
                        ToastUtils.show(UpdateInfoActivity.this.getContext(), "修改信息成功");
                        if (UpdateInfoActivity.this.mIsNeedLoadUserInfo) {
                            UpdateInfoActivity.this.getUserInfo();
                        } else {
                            BaseMaterialDialog.dissmisMaterialDialog();
                            UpdateInfoActivity.this.finish();
                        }
                    }
                }

                @Override // client.android.yixiaotong.controller.core.Listener
                public void onFail(Controller controller, ClientException clientException) {
                    if (UpdateInfoActivity.this.mIsEnable) {
                        UpdateInfoActivity.this.onError(clientException);
                    }
                }
            });
        }
    }

    private void updateStudentNo() {
        if (check()) {
            V3BusinessControllers.getInstance().postUpdateStudentNumberBySchoolId(getLoginAccount(), UserInfoUtil.getInstance().getLoginAccountV3().schoolInfoList.get(UserInfoUtil.getInstance().getSchoolInfosIndex()).id + "", this.mEtData.getText().toString(), new Listener<SuccessBean>() { // from class: client.android.yixiaotong.v3.ui.account.UpdateInfoActivity.2
                @Override // client.android.yixiaotong.controller.core.Listener
                public void onStart(Controller controller) {
                    BaseMaterialDialog.showMaterialDialog(UpdateInfoActivity.this.getActivity(), "修改信息中.", false);
                }

                @Override // client.android.yixiaotong.controller.core.Listener
                public void onComplete(Controller controller, SuccessBean successBean, Object... objArr) {
                    if (UpdateInfoActivity.this.mIsEnable) {
                        BaseMaterialDialog.dissmisMaterialDialog();
                        ToastUtils.show(UpdateInfoActivity.this.getContext(), "修改信息成功");
                        UpdateInfoActivity.this.finish();
                    }
                }

                @Override // client.android.yixiaotong.controller.core.Listener
                public void onFail(Controller controller, ClientException clientException) {
                    if (UpdateInfoActivity.this.mIsEnable) {
                        UpdateInfoActivity.this.onError(clientException);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getUserInfo() {
        V3BusinessControllers.getInstance().getUserInfo(getLoginAccount(), new Listener<UserInfoBean>() { // from class: client.android.yixiaotong.v3.ui.account.UpdateInfoActivity.3
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                BaseMaterialDialog.showMaterialDialog(UpdateInfoActivity.this.getActivity(), "获取账户信息.", false);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, UserInfoBean userInfoBean, Object... objArr) {
                if (UpdateInfoActivity.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    UpdateInfoActivity.this.finish();
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (UpdateInfoActivity.this.mIsEnable) {
                    UpdateInfoActivity.this.onError(clientException);
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
            V3ErrorTipActivity.launch(getActivity(), "我的", clientException.getDetail(), clientException.getCode(), 2, clientException.getSerial());
        }
    }
}
