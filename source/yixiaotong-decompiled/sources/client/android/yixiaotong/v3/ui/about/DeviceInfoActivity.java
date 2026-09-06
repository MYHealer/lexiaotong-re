package client.android.yixiaotong.v3.ui.about;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.ui.dialog.BaseMaterialDialog;
import client.android.yixiaotong.ui.dialog.SystemErrorTip;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.v3.bean.user.HistoryLoginInfoBean;
import client.android.yixiaotong.v3.http.V3BusinessControllers;
import client.android.yixiaotong.v3.ui.error.V3ErrorTipActivity;
import client.android.yixiaotong.v3.userinfo.UserInfoUtilControl;
import com.stub.StubApp;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class DeviceInfoActivity extends BaseActivity {
    private boolean mIsEnable = true;
    private TitleBar mTitleBar;
    private TextView mTvInfo;

    static {
        StubApp.interface11(8910);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    public static void launch(Activity activity) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) DeviceInfoActivity.class));
        }
    }

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.titleBar);
        this.mTvInfo = (TextView) findViewById(R.id.tv_info);
    }

    private void initTitleBar() {
        this.mTitleBar.setTitleView("登录设备信息");
        this.mTitleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
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
        BaseMaterialDialog.dissmisMaterialDialog();
    }

    private void getLoginInfo() {
        V3BusinessControllers.getInstance().getMobileInfo(getLoginAccount(), UserInfoUtilControl.getInstance().getStudentId(), new Listener<List<HistoryLoginInfoBean>>() { // from class: client.android.yixiaotong.v3.ui.about.DeviceInfoActivity.1
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                super.onStart(controller);
                BaseMaterialDialog.showMaterialDialog(DeviceInfoActivity.this.getActivity(), "正在获取数据中", false);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, List<HistoryLoginInfoBean> list, Object... objArr) {
                super.onComplete(controller, list, objArr);
                if (DeviceInfoActivity.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    if (list == null || list.size() <= 0) {
                        return;
                    }
                    DeviceInfoActivity.this.setView(list);
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                super.onFail(controller, clientException);
                if (DeviceInfoActivity.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    if (clientException.isNeedTip(clientException.getCode())) {
                        SystemErrorTip.getInstance().showTipDialog(DeviceInfoActivity.this.getActivity(), clientException.getDetail());
                    } else {
                        V3ErrorTipActivity.launch(DeviceInfoActivity.this.getActivity(), "首页", clientException.getDetail(), clientException.getCode(), 2, clientException.getSerial());
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setView(List<HistoryLoginInfoBean> list) {
        StringBuilder sb = new StringBuilder();
        for (HistoryLoginInfoBean historyLoginInfoBean : list) {
            sb.append(historyLoginInfoBean.createDateTime + " 在设备" + historyLoginInfoBean.mobileModel + "上登录;\n");
        }
        this.mTvInfo.setText(sb);
    }
}
