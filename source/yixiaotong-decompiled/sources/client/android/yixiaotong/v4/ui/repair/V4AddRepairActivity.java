package client.android.yixiaotong.v4.ui.repair;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.controller.bean.SuccessBean;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.ui.dialog.BaseMaterialDialog;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.v3.util.ClickUtil;
import client.android.yixiaotong.v3.util.LogUtil;
import client.android.yixiaotong.v4.http.V4BusinessControllers;
import client.android.yixiaotong.v4.ui.area.V4SelectAddressActivity;
import client.android.yixiaotong.v4.ui.error.V4ErrorControlUtil;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class V4AddRepairActivity extends BaseActivity {
    private static final String TAG = "V4AddRepairActivity";
    private String mAddress;
    private String mAreaAddress;
    private String mBuildingAddress;
    private EditText mEtMobile;
    private EditText mEtName;
    private EditText mEtReport;
    private String mFloorAddress;
    private boolean mIsEnable;
    private String mRoomAddress;
    private TitleBar mTitleBar;
    private TextView mTvAddress;

    static {
        StubApp.interface11(10999);
    }

    private void initView() {
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    public static void launch(Activity activity) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) V4AddRepairActivity.class));
        }
    }

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.titlebar);
        this.mEtReport = (EditText) findViewById(R.id.et_report);
        this.mEtName = (EditText) findViewById(R.id.et_name);
        this.mEtMobile = (EditText) findViewById(R.id.et_mobile);
        this.mTvAddress = (TextView) findViewById(R.id.tv_address);
    }

    private void initTitleBar() {
        this.mTitleBar.setTitleView(getString(R.string.doorlock_repair));
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
    }

    private void initClickListeners() {
        findViewById(R.id.rel_selectaddress).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.repair.V4AddRepairActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m536xcb56af67(view);
            }
        });
        findViewById(R.id.btn_complete).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.repair.V4AddRepairActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m537xd15a7ac6(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$0$client-android-yixiaotong-v4-ui-repair-V4AddRepairActivity, reason: not valid java name */
    /* synthetic */ void m536xcb56af67(View view) {
        if (ClickUtil.isFastDoubleClick()) {
            return;
        }
        V4SelectAddressActivity.launchForResult(getActivity(), 1);
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$1$client-android-yixiaotong-v4-ui-repair-V4AddRepairActivity, reason: not valid java name */
    /* synthetic */ void m537xd15a7ac6(View view) {
        if (ClickUtil.isFastDoubleClick() || !isCheckInfo()) {
            return;
        }
        repair();
    }

    private boolean isCheckInfo() {
        if (StringUtils.isEmpty(this.mEtReport.getText().toString())) {
            ToastUtils.show(getContext(), "请输入报修内容");
            return false;
        }
        if (StringUtils.isEmpty(this.mEtName.getText().toString())) {
            ToastUtils.show(getContext(), "请输入联系人");
            return false;
        }
        if (StringUtils.isEmpty(this.mEtMobile.getText().toString())) {
            ToastUtils.show(getContext(), "请输入联系电话");
            return false;
        }
        if (!this.mTvAddress.getText().toString().equals("设备故障位置")) {
            return true;
        }
        ToastUtils.show(getContext(), "请选择故障位置");
        return false;
    }

    private void repair() {
        V4BusinessControllers.getInstance().postAddRepair(getLoginAccount(), this.mEtReport.getText().toString(), this.mAreaAddress, this.mBuildingAddress, this.mFloorAddress, this.mRoomAddress, this.mEtName.getText().toString(), this.mEtMobile.getText().toString(), new Listener<SuccessBean>() { // from class: client.android.yixiaotong.v4.ui.repair.V4AddRepairActivity.1
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                BaseMaterialDialog.showMaterialDialog(V4AddRepairActivity.this.getActivity(), "正在提交报修.", false);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, SuccessBean successBean, Object... objArr) {
                super.onComplete(controller, successBean, objArr);
                if (V4AddRepairActivity.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    ToastUtils.show(V4AddRepairActivity.this.getContext(), "提交成功");
                    V4AddRepairActivity.this.finish();
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                super.onFail(controller, clientException);
                if (V4AddRepairActivity.this.mIsEnable) {
                    V4ErrorControlUtil.getInstance().showDialog(clientException, V4AddRepairActivity.this.getActivity(), false);
                }
            }
        });
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i != 1 || intent == null) {
            return;
        }
        this.mAddress = intent.getStringExtra("name");
        intent.getStringExtra("id");
        LogUtil.e(TAG, "onActivityResult:" + this.mAddress);
        if (StringUtils.isNotEmpty(this.mAddress) && this.mAddress.contains(",")) {
            String[] strArrSplit = this.mAddress.split(",");
            this.mTvAddress.setText(this.mAddress.replace(",", ""));
            if (strArrSplit.length > 3) {
                this.mAreaAddress = strArrSplit[0];
                this.mBuildingAddress = strArrSplit[1];
                this.mFloorAddress = strArrSplit[2];
                this.mRoomAddress = strArrSplit[3];
            }
        }
    }
}
