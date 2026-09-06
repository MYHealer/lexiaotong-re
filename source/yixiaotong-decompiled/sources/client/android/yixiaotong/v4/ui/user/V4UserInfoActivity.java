package client.android.yixiaotong.v4.ui.user;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.ui.dialog.BaseMaterialDialog;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.v4.http.V4BusinessControllers;
import client.android.yixiaotong.v4.http.bean.V4UserInfoDetailBean;
import client.android.yixiaotong.v4.ui.error.V4ErrorControlUtil;
import client.android.yixiaotong.v4.util.EmojiExcludeFilter;
import client.android.yixiaotong.v4.util.userinfo.V4UserInfoBean;
import client.android.yixiaotong.v4.util.userinfo.V4UserInfoUtil;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestOptions;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class V4UserInfoActivity extends BaseActivity {
    private EditText mEtName;
    private EditText mEtStudentNo;
    private ImageView mIvLogo;
    private TitleBar mTitleBar;
    private TextView mTvSchoolName;
    private TextView mTvSex;
    private V4UserInfoBean mUserInfo;
    private boolean mIsEnable = true;
    private int mType = -1;

    static {
        StubApp.interface11(11092);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    public static void launch(Activity activity) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) V4UserInfoActivity.class));
        }
    }

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.titleBar);
        this.mIvLogo = (ImageView) findViewById(R.id.iv_icon);
        this.mTvSchoolName = (TextView) findViewById(R.id.tv_area);
        this.mEtName = (EditText) findViewById(R.id.tv_name);
        this.mTvSex = (TextView) findViewById(R.id.tv_sex);
        this.mEtStudentNo = (EditText) findViewById(R.id.tv_studentno);
    }

    private void initTitleBar() {
        this.mTitleBar.setTitleView(getString(R.string.personalinfo));
        this.mTitleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
        this.mTitleBar.setRightView(getString(R.string.edit));
        this.mTitleBar.setRightViewTextColor(getResources().getColor(R.color.ff008AFF));
        this.mTitleBar.setRightViewOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.user.V4UserInfoActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m553x5f4ac424(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$initTitleBar$0$client-android-yixiaotong-v4-ui-user-V4UserInfoActivity, reason: not valid java name */
    /* synthetic */ void m553x5f4ac424(View view) {
        if (!this.mTitleBar.getRightView().getText().toString().equalsIgnoreCase(getString(R.string.edit))) {
            postUpdateUserInfo();
            return;
        }
        this.mTitleBar.setRightView(getString(R.string.save));
        this.mEtName.setEnabled(true);
        this.mEtStudentNo.setEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initView() {
        V4UserInfoBean loginAccountV4 = V4UserInfoUtil.getInstance().getLoginAccountV4();
        this.mUserInfo = loginAccountV4;
        if (loginAccountV4 == null) {
            finish();
            return;
        }
        this.mTvSchoolName.setText(loginAccountV4.customerName);
        this.mEtName.setText(this.mUserInfo.name);
        this.mTitleBar.setRightView(getString(R.string.edit));
        this.mEtName.setEnabled(false);
        this.mEtStudentNo.setEnabled(false);
        Glide.with(getContext()).load(getResources().getDrawable(R.mipmap.l_shouye_user)).apply((BaseRequestOptions<?>) RequestOptions.bitmapTransform(new CircleCrop())).into(this.mIvLogo);
        this.mEtStudentNo.setFilters(new InputFilter[]{new EmojiExcludeFilter()});
        this.mEtName.setFilters(new InputFilter[]{new EmojiExcludeFilter()});
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
        BaseMaterialDialog.dissmisMaterialDialog();
        V4ErrorControlUtil.getInstance().onPause();
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
    }

    private void postUpdateUserInfo() {
        V4BusinessControllers.getInstance().postUpdateUserInfo(getLoginAccount(), this.mEtName.getText().toString(), new Listener<V4UserInfoDetailBean>() { // from class: client.android.yixiaotong.v4.ui.user.V4UserInfoActivity.1
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                BaseMaterialDialog.showMaterialDialog(V4UserInfoActivity.this.getActivity(), "保存信息中.", false);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, V4UserInfoDetailBean v4UserInfoDetailBean, Object... objArr) {
                if (V4UserInfoActivity.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    ToastUtils.show(V4UserInfoActivity.this.getActivity(), "保存成功");
                    V4UserInfoActivity.this.initView();
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (V4UserInfoActivity.this.mIsEnable) {
                    V4UserInfoActivity.this.onError(clientException);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onError(ClientException clientException) {
        BaseMaterialDialog.dissmisMaterialDialog();
        V4ErrorControlUtil.getInstance().showDialog(clientException, getActivity(), false);
    }
}
