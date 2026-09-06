package client.android.yixiaotong.v3.ui.about;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.v3.util.LocalDataUtil;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class InformationPermissionsActivity extends BaseActivity {
    private TitleBar mTitleBar;

    static {
        StubApp.interface11(8914);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.titleBar);
    }

    public static void launch(Activity activity) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) InformationPermissionsActivity.class));
        }
    }

    private void initTitleBar() {
        this.mTitleBar.setTitleView(getString(R.string.informationpermissions));
        this.mTitleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
    }

    private void initClickListeners() {
        findViewById(R.id.rel_accountinfo).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.about.InformationPermissionsActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m225xf536842e(view);
            }
        });
        findViewById(R.id.rel_personinfo).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.about.InformationPermissionsActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m226x2e16e4cd(view);
            }
        });
        findViewById(R.id.rel_deviceinfo).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.about.InformationPermissionsActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m227x66f7456c(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$0$client-android-yixiaotong-v3-ui-about-InformationPermissionsActivity, reason: not valid java name */
    /* synthetic */ void m225xf536842e(View view) {
        AccountInfoActivity.launch(getActivity());
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$1$client-android-yixiaotong-v3-ui-about-InformationPermissionsActivity, reason: not valid java name */
    /* synthetic */ void m226x2e16e4cd(View view) {
        PersonInfoActivity.launch(getActivity());
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$2$client-android-yixiaotong-v3-ui-about-InformationPermissionsActivity, reason: not valid java name */
    /* synthetic */ void m227x66f7456c(View view) {
        if (StringUtils.isNotEmpty(LocalDataUtil.getLastTokenInfo(getActivity()))) {
            DeviceInfoActivity.launch(getActivity());
        } else {
            ToastUtils.show(getActivity(), "登录后可查看");
        }
    }
}
