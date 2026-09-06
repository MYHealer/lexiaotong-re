package client.android.yixiaotong.v3.ui.appcontrol.bath;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.controller.LocalControllers;
import client.android.yixiaotong.controller.bean.local.LocalCountDownBean;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.ui.RechargeRecordActivity;
import client.android.yixiaotong.ui.dialog.BaseMaterialDialog;
import client.android.yixiaotong.ui.dialog.SystemErrorTip;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.TimeUtils;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.v3.bean.appointment.AppointmentBean;
import client.android.yixiaotong.v3.bean.appointment.AppointmentResultBean;
import client.android.yixiaotong.v3.bean.appointment.UsingBean;
import client.android.yixiaotong.v3.http.V3BusinessControllers;
import client.android.yixiaotong.v3.ui.error.V3ErrorTipActivity;
import client.android.yixiaotong.v3.userinfo.InvestorInfoUtilControl;
import client.android.yixiaotong.v3.userinfo.UserInfoUtilControl;
import client.android.yixiaotong.v3.util.LocalDataUtil;
import client.android.yixiaotong.v3.util.LogUtil;
import client.android.yixiaotong.view.load.PullRefreshLayout;
import com.hihonor.adsdk.base.ErrorCode;
import com.stub.StubApp;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class AppointBathSuccessActivity extends BaseActivity {
    public static final String TAG = "AppointBathSuccessActivity";
    private Button mBtnCancel;
    private Controller mController;
    private boolean mIsEnable;
    private PullRefreshLayout mSwipeRefreshLayout;
    private long mTime;
    private TitleBar mTitleBar;
    private TextView mTvAddress;
    private TextView mTvDes;
    private TextView mTvMac;
    private TextView mTvMachineId;
    private TextView mTvName;
    private TextView mTvTime;
    private int mTypeId;
    private UsingBean mUsingBean;

    static {
        StubApp.interface11(9003);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    public static void launch(Activity activity, UsingBean usingBean, int i) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) AppointBathSuccessActivity.class).putExtra("bean", usingBean).putExtra(RechargeRecordActivity.EXTRA_TYPEID, i));
        }
    }

    public static void launch(Activity activity, int i) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) AppointBathSuccessActivity.class).putExtra(RechargeRecordActivity.EXTRA_TYPEID, i));
        }
    }

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.titleBar);
        this.mSwipeRefreshLayout = (PullRefreshLayout) findViewById(R.id.swipeRefreshLayout);
        this.mTvTime = (TextView) findViewById(R.id.tv_time);
        this.mTvName = (TextView) findViewById(R.id.tv_no);
        this.mTvAddress = (TextView) findViewById(R.id.tv_address);
        this.mTvMachineId = (TextView) findViewById(R.id.tv_devicesn);
        this.mTvMac = (TextView) findViewById(R.id.tv_mac);
        this.mTvDes = (TextView) findViewById(R.id.tv_des);
        this.mBtnCancel = (Button) findViewById(R.id.btn_cancel);
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

    private void initTitleBar() {
        this.mTitleBar.setTitleView("预约成功");
        this.mTitleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initView() {
        this.mTvTime.setText(this.mUsingBean.statusDuration + "分钟");
        this.mTvName.setText(this.mUsingBean.machineName);
        this.mTvAddress.setText("地址：" + this.mUsingBean.addressMsg);
        this.mTvMachineId.setText("设备编号：" + this.mUsingBean.machineId);
        this.mTvMac.setText("蓝牙地址：" + this.mUsingBean.mac);
        if (this.mUsingBean.curStatus == 122) {
            this.mBtnCancel.setVisibility(4);
        }
        long jStrTimeToSec1 = TimeUtils.strTimeToSec1(this.mUsingBean.statusTime.substring(0, this.mUsingBean.statusTime.length() - 3)) / 1000;
        String str = TAG;
        LogUtil.e(str, jStrTimeToSec1 + "  " + (System.currentTimeMillis() / 1000));
        if ((System.currentTimeMillis() / 1000) - jStrTimeToSec1 > this.mUsingBean.statusDuration * 60) {
            this.mTime = 0L;
            finish();
        } else {
            this.mTime = (jStrTimeToSec1 + ((long) (this.mUsingBean.statusDuration * 60))) - (System.currentTimeMillis() / 1000);
            countDown();
        }
        LogUtil.e(str, this.mTime + "");
        this.mSwipeRefreshLayout.setOnRefreshListener(new PullRefreshLayout.OnRefreshListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.bath.AppointBathSuccessActivity.1
            @Override // client.android.yixiaotong.view.load.PullRefreshLayout.OnRefreshListener
            public void onRefresh() {
                AppointBathSuccessActivity.this.getAppiontmentState();
            }
        });
    }

    private void countDown() {
        if (this.mController != null) {
            LocalControllers.getInstance().cancelTime(this.mController);
        }
        LocalControllers.getInstance().timeCountDown(getLoginAccount(), this.mTime, new Listener<LocalCountDownBean>() { // from class: client.android.yixiaotong.v3.ui.appcontrol.bath.AppointBathSuccessActivity.2
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, LocalCountDownBean localCountDownBean, Object... objArr) {
                super.onComplete(controller, localCountDownBean, objArr);
                AppointBathSuccessActivity.this.mController = controller;
                AppointBathSuccessActivity.this.mTime--;
                long j = AppointBathSuccessActivity.this.mTime / 60;
                long j2 = AppointBathSuccessActivity.this.mTime % 60;
                AppointBathSuccessActivity.this.mTvTime.setText(StringUtils.getLenString(j + "", 2) + "分" + StringUtils.getLenString(j2 + "", 2) + "秒");
                if (localCountDownBean.complete) {
                    AppointBathSuccessActivity.this.finish();
                }
            }
        });
    }

    private void initClickListeners() {
        findViewById(R.id.btn_cancel).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.bath.AppointBathSuccessActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m234xad410b6e(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$0$client-android-yixiaotong-v3-ui-appcontrol-bath-AppointBathSuccessActivity, reason: not valid java name */
    /* synthetic */ void m234xad410b6e(View view) {
        ToastUtils.show(getContext(), "暂不支持取消预约功能");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getAppiontmentState() {
        V3BusinessControllers.getInstance().getUsingList(getLoginAccount(), UserInfoUtilControl.getInstance().getSchoolId(), InvestorInfoUtilControl.getInstance().getInvestorInfoBean().investorId, this.mTypeId, new Listener<List<UsingBean>>() { // from class: client.android.yixiaotong.v3.ui.appcontrol.bath.AppointBathSuccessActivity.3
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                BaseMaterialDialog.showMaterialDialog(AppointBathSuccessActivity.this.getActivity(), "加载中.", false);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, List<UsingBean> list, Object... objArr) {
                if (AppointBathSuccessActivity.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    if (AppointBathSuccessActivity.this.mSwipeRefreshLayout != null) {
                        AppointBathSuccessActivity.this.mSwipeRefreshLayout.setRefreshing(false);
                    }
                    if (list == null || list.size() <= 0) {
                        ToastUtils.show(AppointBathSuccessActivity.this.getContext(), ErrorCode.AD_APP_RESERVE_FAIL_MSG);
                        AppointBathSuccessActivity.this.finish();
                    } else if (list.get(0).curStatus == 120 || list.get(0).curStatus == 121 || list.get(0).curStatus == 122) {
                        AppointBathSuccessActivity.this.mUsingBean = list.get(0);
                        AppointBathSuccessActivity.this.initView();
                    } else {
                        ToastUtils.show(AppointBathSuccessActivity.this.getContext(), ErrorCode.AD_APP_RESERVE_FAIL_MSG);
                        AppointBathSuccessActivity.this.finish();
                    }
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (AppointBathSuccessActivity.this.mIsEnable) {
                    AppointBathSuccessActivity.this.onError(clientException);
                }
            }
        });
    }

    private void cancel() {
        V3BusinessControllers.getInstance().cancelReserve(getLoginAccount(), this.mUsingBean.orderId, this.mUsingBean.machineId, 4, this.mTypeId, 5, new Listener<AppointmentBean>() { // from class: client.android.yixiaotong.v3.ui.appcontrol.bath.AppointBathSuccessActivity.4
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                BaseMaterialDialog.showMaterialDialog(AppointBathSuccessActivity.this.getActivity(), "开始取消预约", false);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, AppointmentBean appointmentBean, Object... objArr) {
                if (AppointBathSuccessActivity.this.mIsEnable) {
                    ToastUtils.show(AppointBathSuccessActivity.this.getContext(), "取消预约成功");
                    AppointBathSuccessActivity.this.finish();
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (AppointBathSuccessActivity.this.mIsEnable) {
                    AppointBathSuccessActivity.this.onError(clientException);
                }
            }
        });
    }

    private void getResult(String str) {
        V3BusinessControllers.getInstance().getResult(getLoginAccount(), this.mUsingBean.machineId, this.mTypeId, 4, str, new Listener<AppointmentResultBean>() { // from class: client.android.yixiaotong.v3.ui.appcontrol.bath.AppointBathSuccessActivity.5
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                BaseMaterialDialog.setConnectMaterialDialog("取消预约中");
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, AppointmentResultBean appointmentResultBean, Object... objArr) {
                if (AppointBathSuccessActivity.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    if (appointmentResultBean.status == 0) {
                        ToastUtils.show(AppointBathSuccessActivity.this.getContext(), "取消预约成功");
                        AppointBathSuccessActivity.this.finish();
                    } else {
                        SystemErrorTip.getInstance().showTipDialog(AppointBathSuccessActivity.this.getActivity(), appointmentResultBean.statusMsg);
                        AppointBathSuccessActivity.this.showDialog(false, true, appointmentResultBean.statusMsg);
                    }
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (AppointBathSuccessActivity.this.mIsEnable) {
                    AppointBathSuccessActivity.this.onError(clientException);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onError(ClientException clientException) {
        BaseMaterialDialog.dissmisMaterialDialog();
        PullRefreshLayout pullRefreshLayout = this.mSwipeRefreshLayout;
        if (pullRefreshLayout != null) {
            pullRefreshLayout.setRefreshing(false);
        }
        if (clientException.isNeedTip(clientException.getCode())) {
            showDialog(false, true, clientException.getDetail());
        } else {
            V3ErrorTipActivity.launch(getActivity(), this.mTitleBar.getTitleViewContent(), clientException.getDetail(), clientException.getCode(), 2, clientException.getSerial());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialog(boolean z, boolean z2, String str) {
        if (z2) {
            str = str + "\n(" + LocalDataUtil.getTraceID(getContext()) + ")";
        }
        SystemErrorTip.getInstance().showTipDialog(getActivity(), str);
    }
}
