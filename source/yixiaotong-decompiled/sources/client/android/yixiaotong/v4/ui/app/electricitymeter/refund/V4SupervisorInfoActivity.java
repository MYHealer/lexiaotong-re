package client.android.yixiaotong.v4.ui.app.electricitymeter.refund;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.controller.bean.SuccessBean;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.ui.dialog.BaseMaterialDialog;
import client.android.yixiaotong.ui.dialog.SystemErrorTip;
import client.android.yixiaotong.ui.dialog.TwoButtonDialog;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.util.permission.PermissionUtil;
import client.android.yixiaotong.v3.util.ClickUtil;
import client.android.yixiaotong.v4.http.V4BusinessControllers;
import client.android.yixiaotong.v4.http.bean.V4ElecMeterInfoBean;
import client.android.yixiaotong.v4.http.bean.V4RechargeBean;
import client.android.yixiaotong.v4.ui.error.V4ErrorControlUtil;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class V4SupervisorInfoActivity extends BaseActivity {
    private static final String TAG = "V4SupervisorInfoActivity";
    private Button mBtnActive;
    private Button mBtnCancel;
    private V4ElecMeterInfoBean mElecMeterInfoBean;
    private int mProductId;
    private V4SupervisorInfoControlUtil mSupervisorInfoControlUtil;
    private TitleBar mTitleBar;
    private TextView mTvName;
    private TextView mTvPhone;
    private TextView mTvRefund;
    private boolean mIsEnable = true;
    private String mRefundId = "";
    private boolean mIsEnableRefund = false;
    private PermissionUtil.PermissionGrant permissionGrant = new PermissionUtil.PermissionGrant() { // from class: client.android.yixiaotong.v4.ui.app.electricitymeter.refund.V4SupervisorInfoActivity.7
        @Override // client.android.yixiaotong.util.permission.PermissionUtil.PermissionGrant
        public void onPermissionGranted(int i) {
            if (i != 1) {
                return;
            }
            V4SupervisorInfoActivity.this.toggleDeviceLock(1);
        }
    };

    static {
        StubApp.interface11(10804);
    }

    private boolean checkRefund() {
        return true;
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public native void onRequestPermissionsResult(int i, String[] strArr, int[] iArr);

    public static void launch(Activity activity, V4ElecMeterInfoBean v4ElecMeterInfoBean, int i) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) V4SupervisorInfoActivity.class).putExtra("bean", v4ElecMeterInfoBean).putExtra("productid", i));
        }
    }

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.titleBar);
        this.mTvName = (TextView) findViewById(R.id.tv_name);
        this.mTvPhone = (TextView) findViewById(R.id.tv_phone);
        this.mBtnActive = (Button) findViewById(R.id.btn_active);
        this.mBtnCancel = (Button) findViewById(R.id.btn_cancel);
        this.mTvRefund = (TextView) findViewById(R.id.tv_refund);
    }

    private void initTitleBar() {
        this.mTitleBar.setTitleView("舍长");
        this.mTitleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.mIsEnable = true;
        this.mSupervisorInfoControlUtil.onResume();
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        this.mSupervisorInfoControlUtil.onPause();
    }

    private void initData() {
        this.mSupervisorInfoControlUtil.init(getActivity(), getLoginAccount(), this.mTitleBar.getTitleViewContent(), this.mElecMeterInfoBean.bluetoothMac, this.mElecMeterInfoBean.mac, this.mProductId, this.mElecMeterInfoBean.roomId, this.mElecMeterInfoBean.balance);
    }

    private void initView() {
        this.mTvName.setText(this.mElecMeterInfoBean.leaderInfo.name);
        this.mTvPhone.setText(this.mElecMeterInfoBean.leaderInfo.mobile);
        if (this.mElecMeterInfoBean.currentUserIsLeader.booleanValue()) {
            this.mBtnCancel.setVisibility(0);
            this.mIsEnableRefund = true;
            this.mTvRefund.setVisibility(0);
        }
        if (this.mElecMeterInfoBean.lockStatus != null && this.mElecMeterInfoBean.lockStatus.intValue() == 1) {
            this.mBtnActive.setVisibility(0);
        }
        this.mBtnActive.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.app.electricitymeter.refund.V4SupervisorInfoActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m496xf7b7bb49(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$initView$0$client-android-yixiaotong-v4-ui-app-electricitymeter-refund-V4SupervisorInfoActivity, reason: not valid java name */
    /* synthetic */ void m496xf7b7bb49(View view) {
        TwoButtonDialog.getInstance().showDialog(getActivity(), new TwoButtonDialog.Listener() { // from class: client.android.yixiaotong.v4.ui.app.electricitymeter.refund.V4SupervisorInfoActivity.1
            @Override // client.android.yixiaotong.ui.dialog.TwoButtonDialog.Listener
            public void onCancle() {
            }

            @Override // client.android.yixiaotong.ui.dialog.TwoButtonDialog.Listener
            public void onConfirm() {
                V4SupervisorInfoActivity.this.toggleDeviceLock(2);
            }
        }, "提示", "确认恢复设备使用?", "取消", "确认");
    }

    private void initClickListeners() {
        findViewById(R.id.btn_cancel).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.app.electricitymeter.refund.V4SupervisorInfoActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m494xdef49ef6(view);
            }
        });
        findViewById(R.id.tv_refund).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.app.electricitymeter.refund.V4SupervisorInfoActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m495x2495e195(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$1$client-android-yixiaotong-v4-ui-app-electricitymeter-refund-V4SupervisorInfoActivity, reason: not valid java name */
    /* synthetic */ void m494xdef49ef6(View view) {
        if (ClickUtil.isFastDoubleClick200()) {
            return;
        }
        TwoButtonDialog.getInstance().showDialog(getActivity(), new TwoButtonDialog.Listener() { // from class: client.android.yixiaotong.v4.ui.app.electricitymeter.refund.V4SupervisorInfoActivity.2
            @Override // client.android.yixiaotong.ui.dialog.TwoButtonDialog.Listener
            public void onCancle() {
            }

            @Override // client.android.yixiaotong.ui.dialog.TwoButtonDialog.Listener
            public void onConfirm() {
                V4SupervisorInfoActivity.this.unBindSupervisor();
            }
        }, "提示", "确认卸任舍长身份？", "取消", "确认");
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$2$client-android-yixiaotong-v4-ui-app-electricitymeter-refund-V4SupervisorInfoActivity, reason: not valid java name */
    /* synthetic */ void m495x2495e195(View view) {
        if (ClickUtil.isFastDoubleClick200() || !checkRefund()) {
            return;
        }
        TwoButtonDialog.getInstance().showDialog(getActivity(), new TwoButtonDialog.Listener() { // from class: client.android.yixiaotong.v4.ui.app.electricitymeter.refund.V4SupervisorInfoActivity.3
            @Override // client.android.yixiaotong.ui.dialog.TwoButtonDialog.Listener
            public void onCancle() {
            }

            @Override // client.android.yixiaotong.ui.dialog.TwoButtonDialog.Listener
            public void onConfirm() {
                if (ClickUtil.isFastDoubleClick200()) {
                    return;
                }
                PermissionUtil.requestPerssion(V4SupervisorInfoActivity.this.getActivity(), 1, V4SupervisorInfoActivity.this.permissionGrant);
            }
        }, "提示", "请在设备附近，需清空设备余量才可申请退款,申请退款期间设备将无法使用，是否继续申请退款", "#ff0289fe", "取消", "继续退款");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void toggleDeviceLock(final int i) {
        V4BusinessControllers.getInstance().toggleDeviceLock(getLoginAccount(), this.mElecMeterInfoBean.roomId, this.mElecMeterInfoBean.mac, this.mProductId, i, new Listener<String>() { // from class: client.android.yixiaotong.v4.ui.app.electricitymeter.refund.V4SupervisorInfoActivity.4
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                super.onStart(controller);
                BaseMaterialDialog.showMaterialDialog(V4SupervisorInfoActivity.this.getActivity(), "处理中.", false);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, String str, Object... objArr) {
                super.onComplete(controller, str, objArr);
                if (V4SupervisorInfoActivity.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    int i2 = i;
                    if (i2 == 1) {
                        V4SupervisorInfoActivity.this.mSupervisorInfoControlUtil.startSetEmpty();
                    } else if (i2 == 2) {
                        V4SupervisorInfoActivity.this.netRecharge();
                        SystemErrorTip.getInstance().showTipDialog(V4SupervisorInfoActivity.this.getActivity(), "解锁成功，设备已可正常使用");
                    }
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                super.onFail(controller, clientException);
                if (V4SupervisorInfoActivity.this.mIsEnable) {
                    V4ErrorControlUtil.getInstance().showDialog(clientException, V4SupervisorInfoActivity.this.getActivity(), false);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void unBindSupervisor() {
        V4BusinessControllers.getInstance().updateRoomLeader(getLoginAccount(), this.mProductId, this.mElecMeterInfoBean.roomId, 2, new Listener<SuccessBean>() { // from class: client.android.yixiaotong.v4.ui.app.electricitymeter.refund.V4SupervisorInfoActivity.5
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                BaseMaterialDialog.showMaterialDialog(V4SupervisorInfoActivity.this.getActivity(), "正在处理..", false);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, SuccessBean successBean, Object... objArr) {
                if (V4SupervisorInfoActivity.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    ToastUtils.show(V4SupervisorInfoActivity.this.getActivity(), "卸任成功");
                    V4SupervisorInfoActivity.this.finish();
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (V4SupervisorInfoActivity.this.mIsEnable) {
                    V4SupervisorInfoActivity.this.onError(clientException);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void netRecharge() {
        V4BusinessControllers.getInstance().netRecharge(getLoginAccount(), this.mElecMeterInfoBean.mac, new Listener<V4RechargeBean>() { // from class: client.android.yixiaotong.v4.ui.app.electricitymeter.refund.V4SupervisorInfoActivity.6
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onError(ClientException clientException) {
        BaseMaterialDialog.dissmisMaterialDialog();
        V4ErrorControlUtil.getInstance().showDialog(clientException, getActivity(), false);
    }
}
