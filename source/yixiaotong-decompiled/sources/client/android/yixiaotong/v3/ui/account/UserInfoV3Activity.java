package client.android.yixiaotong.v3.ui.account;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
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
import client.android.yixiaotong.v3.ui.dialog.SelectSexDialog;
import client.android.yixiaotong.v3.ui.error.V3ErrorTipActivity;
import client.android.yixiaotong.v3.userinfo.UserInfo;
import client.android.yixiaotong.v3.userinfo.UserInfoUtil;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestOptions;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class UserInfoV3Activity extends BaseActivity {
    private ImageView mIvLogo;
    private int mSex;
    private TitleBar mTitleBar;
    private TextView mTvName;
    private TextView mTvSchoolName;
    private TextView mTvSex;
    private TextView mTvStudentNo;
    private UserInfo mUserInfo;
    private boolean mIsEnable = true;
    private int mType = -1;

    static {
        StubApp.interface11(8933);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    public static void launch(Activity activity) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) UserInfoV3Activity.class));
        }
    }

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.titleBar);
        this.mIvLogo = (ImageView) findViewById(R.id.iv_icon);
        this.mTvSchoolName = (TextView) findViewById(R.id.tv_area);
        this.mTvName = (TextView) findViewById(R.id.tv_name);
        this.mTvSex = (TextView) findViewById(R.id.tv_sex);
        this.mTvStudentNo = (TextView) findViewById(R.id.tv_studentno);
    }

    private void initTitleBar() {
        this.mTitleBar.setTitleView(getString(R.string.personalinfo));
        this.mTitleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initView() {
        UserInfo loginAccountV3 = UserInfoUtil.getInstance().getLoginAccountV3();
        this.mUserInfo = loginAccountV3;
        if (loginAccountV3 == null) {
            finish();
        }
        this.mTvSchoolName.setText(UserInfoUtil.getInstance().getLoginAccountV3().schoolInfoList.get(UserInfoUtil.getInstance().getSchoolInfosIndex()).schoolName);
        this.mTvName.setText(this.mUserInfo.studentName);
        this.mSex = this.mUserInfo.studentGender;
        if (this.mUserInfo.studentGender == 1) {
            this.mTvSex.setText(getString(R.string.boy));
            Glide.with(getContext()).load(getResources().getDrawable(R.mipmap.tx)).apply((BaseRequestOptions<?>) RequestOptions.bitmapTransform(new CircleCrop())).into(this.mIvLogo);
        } else {
            this.mTvSex.setText(getString(R.string.girl));
            Glide.with(getContext()).load(getResources().getDrawable(R.mipmap.tx)).apply((BaseRequestOptions<?>) RequestOptions.bitmapTransform(new CircleCrop())).into(this.mIvLogo);
        }
    }

    private void initClickListeners() {
        findViewById(R.id.rel_no).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.account.UserInfoV3Activity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m230xc95d8c0c(view);
            }
        });
        findViewById(R.id.rel_sex).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.account.UserInfoV3Activity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m231xcf61576b(view);
            }
        });
        findViewById(R.id.rel_name).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.account.UserInfoV3Activity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m232xd56522ca(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$0$client-android-yixiaotong-v3-ui-account-UserInfoV3Activity, reason: not valid java name */
    /* synthetic */ void m230xc95d8c0c(View view) {
        this.mType = 1;
        UpdateInfoActivity.launch(getActivity(), this.mUserInfo.studentName, this.mUserInfo.studentGender, this.mTvStudentNo.getText().toString(), 1);
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$1$client-android-yixiaotong-v3-ui-account-UserInfoV3Activity, reason: not valid java name */
    /* synthetic */ void m231xcf61576b(View view) {
        this.mType = 0;
        SelectSexDialog.getInstance().showDialog(getActivity(), new SelectSexDialog.Listener() { // from class: client.android.yixiaotong.v3.ui.account.UserInfoV3Activity.1
            @Override // client.android.yixiaotong.v3.ui.dialog.SelectSexDialog.Listener
            public void onConfirm(int i) {
                if (i != UserInfoV3Activity.this.mSex) {
                    UserInfoV3Activity.this.updateInfo(i);
                }
            }
        }, this.mSex);
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$2$client-android-yixiaotong-v3-ui-account-UserInfoV3Activity, reason: not valid java name */
    /* synthetic */ void m232xd56522ca(View view) {
        this.mType = 2;
        UpdateInfoActivity.launch(getActivity(), this.mUserInfo.studentName, this.mUserInfo.studentGender, this.mTvStudentNo.getText().toString(), 2);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.mIsEnable = true;
        int i = this.mType;
        if (i == -1 || i == 1) {
            getStudentNo();
        } else if (i == 2) {
            getUserInfo();
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

    /* JADX INFO: Access modifiers changed from: private */
    public void getUserInfo() {
        V3BusinessControllers.getInstance().getUserInfo(getLoginAccount(), new Listener<UserInfoBean>() { // from class: client.android.yixiaotong.v3.ui.account.UserInfoV3Activity.2
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                BaseMaterialDialog.showMaterialDialog(UserInfoV3Activity.this.getActivity(), "获取账户信息.", false);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, UserInfoBean userInfoBean, Object... objArr) {
                if (UserInfoV3Activity.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    UserInfoV3Activity.this.initView();
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (UserInfoV3Activity.this.mIsEnable) {
                    UserInfoV3Activity.this.onError(clientException);
                }
            }
        });
    }

    private void getStudentNo() {
        V3BusinessControllers.getInstance().getSelectStudentNumberBySchoolId(getLoginAccount(), this.mUserInfo.schoolInfoList.get(UserInfoUtil.getInstance().getSchoolInfosIndex()).id + "", new Listener<String>() { // from class: client.android.yixiaotong.v3.ui.account.UserInfoV3Activity.3
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                BaseMaterialDialog.showMaterialDialog(UserInfoV3Activity.this.getActivity(), "加载数据中.", false);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, String str, Object... objArr) {
                if (UserInfoV3Activity.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    if (StringUtils.isNotEmpty(str)) {
                        UserInfoV3Activity.this.mTvStudentNo.setText(str);
                    }
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (UserInfoV3Activity.this.mIsEnable) {
                    UserInfoV3Activity.this.onError(clientException);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateInfo(int i) {
        V3BusinessControllers.getInstance().postUserInfo(getLoginAccount(), i, this.mUserInfo.studentName, new Listener<SuccessBean>() { // from class: client.android.yixiaotong.v3.ui.account.UserInfoV3Activity.4
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                BaseMaterialDialog.showMaterialDialog(UserInfoV3Activity.this.getActivity(), "修改信息中.", false);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, SuccessBean successBean, Object... objArr) {
                if (UserInfoV3Activity.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    ToastUtils.show(UserInfoV3Activity.this.getContext(), "修改信息成功");
                    UserInfoV3Activity.this.getUserInfo();
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (UserInfoV3Activity.this.mIsEnable) {
                    UserInfoV3Activity.this.onError(clientException);
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
            V3ErrorTipActivity.launch(getActivity(), this.mTitleBar.getTitleViewContent().toString(), clientException.getDetail(), clientException.getCode(), 2, clientException.getSerial());
            finish();
        }
    }
}
