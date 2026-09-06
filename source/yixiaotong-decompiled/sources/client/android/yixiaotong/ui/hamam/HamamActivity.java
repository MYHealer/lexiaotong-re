package client.android.yixiaotong.ui.hamam;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.controller.bean.UserInfoBean;
import client.android.yixiaotong.controller.model.WalletModel;
import client.android.yixiaotong.controller.store.LocalBusinessStore;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.ToastUtils;
import com.facebook.common.util.UriUtil;
import com.facebook.drawee.view.SimpleDraweeView;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class HamamActivity extends BaseActivity {
    public static final String EXTRA_WALLET = "extra_wallet";
    private ImageView mImgEye;
    private ImageView mImgSex;
    private SimpleDraweeView mIvMeIcon;
    private TitleBar mTitleBar;
    private TextView mTvMeId;
    private TextView mTvMeName;
    private TextView mTvMeXueHao;
    private UserInfoBean mUserInfoBean;
    private WalletModel mWalletModel;
    private PwdEditText psw;
    private boolean mPswVisable = false;
    private boolean mIsEnable = true;

    static {
        StubApp.interface11(7262);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    public static void launch(Activity activity, WalletModel walletModel) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) HamamActivity.class).putExtra("extra_wallet", walletModel));
        }
    }

    private void initViewNew() {
        this.mIvMeIcon = (SimpleDraweeView) findViewById(R.id.iv_me_icon);
        this.mImgSex = (ImageView) findViewById(R.id.img_sex);
        this.mImgEye = (ImageView) findViewById(R.id.img_eye);
        this.mTvMeName = (TextView) findViewById(R.id.tv_me_name);
        this.mTvMeId = (TextView) findViewById(R.id.tv_me_id);
        this.mTvMeXueHao = (TextView) findViewById(R.id.tv_me_xuehao);
        this.mTitleBar = (TitleBar) findViewById(R.id.titleBar);
        this.psw = (PwdEditText) findViewById(R.id.et_psw);
    }

    private void initTitleBar() {
        this.mTitleBar.setTitleView("公共浴室");
        this.mTitleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
    }

    private void initInfoView() {
        UserInfoBean userInfo = getLoginAccount().getAccountManagetStore().getUserInfo();
        this.mUserInfoBean = userInfo;
        if (userInfo == null) {
            return;
        }
        this.mIvMeIcon.setImageURI(UriUtil.parseUriOrNull(userInfo.Icon));
        if (this.mUserInfoBean.GenderId == 1) {
            this.mImgSex.setImageDrawable(getResources().getDrawable(R.mipmap.l_shouye_boy));
        } else {
            this.mImgSex.setImageDrawable(getResources().getDrawable(R.mipmap.l_shouye_girl));
        }
        if (StringUtils.isNotEmpty(this.mUserInfoBean.StudentName)) {
            this.mTvMeName.setText(this.mUserInfoBean.StudentName);
        }
        String str = this.mUserInfoBean.ID + "";
        if (StringUtils.isNotEmpty(str) && str.length() > 4) {
            this.mTvMeId.setText("ID：**************" + str.substring(str.length() - 4, str.length()));
        }
        if (StringUtils.isNotEmpty(this.mUserInfoBean.StudentNo)) {
            this.mTvMeXueHao.setText("学号：" + this.mUserInfoBean.StudentNo);
        }
    }

    private void initView() {
        String str = getLoginAccount().getAccountManagetStore().getUserInfo().LoginAccount;
        if (StringUtils.isNotEmpty(str) && str.length() > 4) {
            str.substring(str.length() - 4);
            final String authorizedPassword = LocalBusinessStore.getAuthorizedPassword(getContext(), getLoginAccount().getUid());
            if (StringUtils.isNotEmpty(authorizedPassword)) {
                this.psw.setText(authorizedPassword);
            } else {
                this.psw.setText("??????????");
            }
            this.mImgEye.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.hamam.HamamActivity.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (HamamActivity.this.mPswVisable) {
                        HamamActivity.this.mPswVisable = false;
                        HamamActivity.this.mImgEye.setImageResource(R.mipmap.l_hamam_eye_close);
                        if (StringUtils.isNotEmpty(authorizedPassword)) {
                            HamamActivity.this.psw.setmPswInsviable(false, authorizedPassword);
                            HamamActivity.this.psw.setText(authorizedPassword);
                            return;
                        } else {
                            HamamActivity.this.psw.setmPswInsviable(false, "??????????");
                            HamamActivity.this.psw.setText("??????????");
                            return;
                        }
                    }
                    HamamActivity.this.mPswVisable = true;
                    HamamActivity.this.mImgEye.setImageResource(R.mipmap.l_hamam_eye_on);
                    if (StringUtils.isNotEmpty(authorizedPassword)) {
                        HamamActivity.this.psw.setmPswInsviable(true, authorizedPassword);
                        HamamActivity.this.psw.setText(authorizedPassword);
                    } else {
                        HamamActivity.this.psw.setmPswInsviable(true, "??????????");
                        HamamActivity.this.psw.setText("??????????");
                    }
                }
            });
            return;
        }
        ToastUtils.show(getContext(), "账号异常！");
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
    }
}
