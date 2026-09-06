package client.android.yixiaotong.v4.ui.about;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.controller.bean.SuccessBean;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.ui.dialog.BaseMaterialDialog;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.v3.ui.dialog.TwoButtonDialog;
import client.android.yixiaotong.v3.util.ClickUtil;
import client.android.yixiaotong.v4.http.V4BusinessControllers;
import client.android.yixiaotong.v4.ui.error.V4ErrorControlUtil;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class V4CancelAccountActivity extends BaseActivity {
    private static final String TAG = "V4CancelAccountActivity";
    Button mBtnConfirt;
    private boolean mIsEnable = true;
    TitleBar mTitleBar;

    static {
        StubApp.interface11(10628);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    public static void launch(Activity activity) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) V4CancelAccountActivity.class));
        }
    }

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.titleBar);
        this.mBtnConfirt = (Button) findViewById(R.id.btn_confirm);
    }

    private void initTitleBar() {
        this.mTitleBar.setTitleView(getString(R.string.cancel_account));
        this.mTitleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
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
        this.mIsEnable = true;
        BaseMaterialDialog.dissmisMaterialDialog();
        V4ErrorControlUtil.getInstance().onPause();
    }

    private void initClickListeners() {
        findViewById(R.id.btn_confirm).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.about.V4CancelAccountActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m466x38116b5c(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$0$client-android-yixiaotong-v4-ui-about-V4CancelAccountActivity, reason: not valid java name */
    /* synthetic */ void m466x38116b5c(View view) {
        if (ClickUtil.isFastDoubleClick()) {
            return;
        }
        showTwoButDialog("当前账号将被停用，是否确认操作");
    }

    private void showTwoButDialog(String str) {
        TwoButtonDialog.getInstance().showDialog(getActivity(), new TwoButtonDialog.Listener() { // from class: client.android.yixiaotong.v4.ui.about.V4CancelAccountActivity.1
            @Override // client.android.yixiaotong.v3.ui.dialog.TwoButtonDialog.Listener
            public void onCancle() {
            }

            @Override // client.android.yixiaotong.v3.ui.dialog.TwoButtonDialog.Listener
            public void onConfirm() {
                V4CancelAccountActivity.this.cancelUser();
            }
        }, "提示", str, R.color.ff242933, "取消", "确认");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancelUser() {
        V4BusinessControllers.getInstance().postUserlogoff(getLoginAccount(), new Listener<SuccessBean>() { // from class: client.android.yixiaotong.v4.ui.about.V4CancelAccountActivity.2
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                BaseMaterialDialog.showMaterialDialog(V4CancelAccountActivity.this.getActivity(), "正在处理中", false);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, SuccessBean successBean, Object... objArr) {
                if (V4CancelAccountActivity.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    ToastUtils.show(V4CancelAccountActivity.this.getActivity(), "注销成功");
                    V4CancelAccountActivity.this.exitLogin();
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (V4CancelAccountActivity.this.mIsEnable) {
                    V4ErrorControlUtil.getInstance().showDialog(clientException, V4CancelAccountActivity.this.getActivity(), false);
                }
            }
        });
    }
}
