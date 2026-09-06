package client.android.yixiaotong.ui.about;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.ToastUtils;
import com.huawei.openalliance.ad.views.PPSLabelView;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public class CancelAccountActivity extends BaseActivity {
    Button mBtnCommit;
    EditText mEtContent;
    TitleBar mTitleBar;

    static {
        StubApp.interface11(6120);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    public static void launch(Activity activity) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) CancelAccountActivity.class));
        }
    }

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.titleBar);
        this.mEtContent = (EditText) findViewById(R.id.et_content);
        this.mBtnCommit = (Button) findViewById(R.id.btn_commit);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
    }

    private void initTitleBar() {
        this.mTitleBar.setTitleView("申请销户");
        this.mTitleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
    }

    private void initView() {
        this.mBtnCommit.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.about.CancelAccountActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ((InputMethodManager) CancelAccountActivity.this.getSystemService("input_method")).hideSoftInputFromWindow(CancelAccountActivity.this.mBtnCommit.getWindowToken(), 0);
                if (StringUtils.isNotEmpty(CancelAccountActivity.this.mEtContent.getText().toString().replace(PPSLabelView.Code, ""))) {
                    ToastUtils.show(CancelAccountActivity.this.getContext(), "提交申请成功");
                } else {
                    ToastUtils.show(CancelAccountActivity.this.getContext(), "请输入内容");
                }
            }
        });
    }
}
