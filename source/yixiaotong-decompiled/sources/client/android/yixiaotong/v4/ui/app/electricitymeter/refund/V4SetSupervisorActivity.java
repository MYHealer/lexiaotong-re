package client.android.yixiaotong.v4.ui.app.electricitymeter.refund;

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
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.v3.ui.dialog.TwoButtonDialog;
import client.android.yixiaotong.v3.util.ClickUtil;
import client.android.yixiaotong.v3.util.LogUtil;
import client.android.yixiaotong.v4.http.V4BusinessControllers;
import client.android.yixiaotong.v4.ui.error.V4ErrorControlUtil;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class V4SetSupervisorActivity extends BaseActivity {
    private static final String TAG = "V4SetSupervisorActivity";
    private EditText mEtPhone;
    private boolean mIsEnable = true;
    private int mProductId;
    private String mRoomId;
    private TitleBar mTitleBar;

    static {
        StubApp.interface11(10793);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    public static void launch(Activity activity, String str, int i) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) V4SetSupervisorActivity.class).putExtra("roomid", str).putExtra("productid", i));
        }
    }

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.titleBar);
        this.mEtPhone = (EditText) findViewById(R.id.et_phone);
    }

    private void initTitleBar() {
        this.mTitleBar.setTitleView(getString(R.string.setdormitoryleader2));
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
        this.mIsEnable = false;
        V4ErrorControlUtil.getInstance().onPause();
        BaseMaterialDialog.dissmisMaterialDialog();
    }

    private void initClickListeners() {
        findViewById(R.id.btn_save).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.app.electricitymeter.refund.V4SetSupervisorActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m493x9e791d67(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$0$client-android-yixiaotong-v4-ui-app-electricitymeter-refund-V4SetSupervisorActivity, reason: not valid java name */
    /* synthetic */ void m493x9e791d67(View view) {
        if (ClickUtil.isFastDoubleClick()) {
            return;
        }
        validateAndSavePhoneNumber();
    }

    private void validateAndSavePhoneNumber() {
        TwoButtonDialog.getInstance().showDialog(getActivity(), new TwoButtonDialog.Listener() { // from class: client.android.yixiaotong.v4.ui.app.electricitymeter.refund.V4SetSupervisorActivity.1
            @Override // client.android.yixiaotong.v3.ui.dialog.TwoButtonDialog.Listener
            public void onCancle() {
            }

            @Override // client.android.yixiaotong.v3.ui.dialog.TwoButtonDialog.Listener
            public void onConfirm() {
                V4SetSupervisorActivity.this.changeSupervisor();
            }
        }, "提示", "是否确认将当前账户设置为舍长", "取消", "确认");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void changeSupervisor() {
        V4BusinessControllers.getInstance().updateRoomLeader(getLoginAccount(), this.mProductId, this.mRoomId, 1, new Listener<SuccessBean>() { // from class: client.android.yixiaotong.v4.ui.app.electricitymeter.refund.V4SetSupervisorActivity.2
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                BaseMaterialDialog.showMaterialDialog(V4SetSupervisorActivity.this.getActivity(), "正在处理中..", false);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, SuccessBean successBean, Object... objArr) {
                LogUtil.e("changeSupervisor", "onComplete result=" + successBean);
                if (V4SetSupervisorActivity.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    ToastUtils.show(V4SetSupervisorActivity.this.getActivity(), "设置舍长成功");
                    V4SetSupervisorActivity.this.finish();
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                LogUtil.e("changeSupervisor", "onFail code=" + clientException.getCode() + " detail=" + clientException.getDetail());
                if (V4SetSupervisorActivity.this.mIsEnable) {
                    V4ErrorControlUtil.getInstance().showDialog(clientException, V4SetSupervisorActivity.this.getActivity(), false);
                }
            }
        });
    }
}
