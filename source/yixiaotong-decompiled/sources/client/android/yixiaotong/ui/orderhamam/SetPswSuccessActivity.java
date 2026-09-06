package client.android.yixiaotong.ui.orderhamam;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.ui.widget.TitleBar;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class SetPswSuccessActivity extends BaseActivity {
    public static final String EXTRA_PSW = "psw";
    private String mPsw;
    TitleBar mTitlebar;
    TextView mTvPsw;

    static {
        StubApp.interface11(7528);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    public static void launch(Activity activity, String str) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) SetPswSuccessActivity.class).putExtra(EXTRA_PSW, str));
        }
    }

    private void initViewNew() {
        this.mTitlebar = (TitleBar) findViewById(R.id.titlebar);
        this.mTvPsw = (TextView) findViewById(R.id.tv_psw);
    }

    private void initTitlebar() {
        this.mTitlebar.setRightView("创建成功");
        this.mTitlebar.setLeftView(R.mipmap.back);
        this.mTitlebar.setLeftViewOnClickBack(getActivity());
    }

    private void initClickListeners() {
        findViewById(R.id.btn_back).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.orderhamam.SetPswSuccessActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m169x2c3db980(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$0$client-android-yixiaotong-ui-orderhamam-SetPswSuccessActivity, reason: not valid java name */
    /* synthetic */ void m169x2c3db980(View view) {
        finish();
    }
}
