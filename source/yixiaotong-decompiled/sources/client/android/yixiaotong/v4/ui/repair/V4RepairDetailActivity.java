package client.android.yixiaotong.v4.ui.repair;

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
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.v3.util.ClickUtil;
import client.android.yixiaotong.v4.http.V4BusinessControllers;
import client.android.yixiaotong.v4.http.bean.V4RepairRecordDetailBean;
import client.android.yixiaotong.v4.ui.error.V4ErrorControlUtil;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class V4RepairDetailActivity extends BaseActivity {
    private Button mBtnCancel;
    private boolean mIsEnable;
    private TitleBar mTitleBar;
    private TextView mTvAddress;
    private TextView mTvDetail;
    private TextView mTvPhone;
    private TextView mTvTime;
    private V4RepairRecordDetailBean mV4RepairRecordBean;

    static {
        StubApp.interface11(11002);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    public static void launch(Activity activity, V4RepairRecordDetailBean v4RepairRecordDetailBean) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) V4RepairDetailActivity.class).putExtra("bean", v4RepairRecordDetailBean));
        }
    }

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.titleBar);
        this.mTvTime = (TextView) findViewById(R.id.tv_time);
        this.mTvPhone = (TextView) findViewById(R.id.tv_phone);
        this.mTvAddress = (TextView) findViewById(R.id.tv_address);
        this.mTvDetail = (TextView) findViewById(R.id.tv_detail);
        this.mBtnCancel = (Button) findViewById(R.id.btn_cancel);
    }

    private void initTitleBar() {
        this.mTitleBar.setTitleView(getString(R.string.repairdetails));
        this.mTitleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
    }

    private void initView() {
        this.mTvTime.setText(this.mV4RepairRecordBean.createTime);
        this.mTvDetail.setText(this.mV4RepairRecordBean.repairContent);
        this.mTvPhone.setText(this.mV4RepairRecordBean.contactPhone);
        this.mTvAddress.setText(this.mV4RepairRecordBean.areaName + this.mV4RepairRecordBean.buildingName + this.mV4RepairRecordBean.floorName + this.mV4RepairRecordBean.roomName);
        if (this.mV4RepairRecordBean.status == 0) {
            this.mBtnCancel.setVisibility(0);
        } else {
            this.mBtnCancel.setVisibility(8);
        }
    }

    private void initClickListeners() {
        ((Button) findViewById(R.id.btn_cancel)).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.repair.V4RepairDetailActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ClickUtil.isFastDoubleClick()) {
                    return;
                }
                V4RepairDetailActivity.this.cacelRepair();
            }
        });
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

    /* JADX INFO: Access modifiers changed from: private */
    public void cacelRepair() {
        V4BusinessControllers.getInstance().postDeleteRepair(getLoginAccount(), this.mV4RepairRecordBean.repairId, new Listener<SuccessBean>() { // from class: client.android.yixiaotong.v4.ui.repair.V4RepairDetailActivity.2
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                BaseMaterialDialog.showMaterialDialog(V4RepairDetailActivity.this.getActivity(), "正在处理中.", false);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, SuccessBean successBean, Object... objArr) {
                super.onComplete(controller, successBean, objArr);
                if (V4RepairDetailActivity.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    ToastUtils.show(V4RepairDetailActivity.this.getContext(), "取消成功");
                    V4RepairDetailActivity.this.finish();
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                super.onFail(controller, clientException);
                if (V4RepairDetailActivity.this.mIsEnable) {
                    V4ErrorControlUtil.getInstance().showDialog(clientException, V4RepairDetailActivity.this.getActivity(), false);
                }
            }
        });
    }
}
