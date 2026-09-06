package client.android.yixiaotong.v3.ui.appcontrol.electricitymeter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.controller.bean.SuccessBean;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.ui.dialog.BaseMaterialDialog;
import client.android.yixiaotong.ui.dialog.SystemErrorTip;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.v3.bean.elecmeter.BindElecMeterInfoBean;
import client.android.yixiaotong.v3.bean.elecmeter.BindElecMeterRoomInfoBean;
import client.android.yixiaotong.v3.http.V3BusinessControllers;
import client.android.yixiaotong.v3.ui.error.ErrorControlUtil;
import client.android.yixiaotong.v3.userinfo.InvestorInfoUtilControl;
import client.android.yixiaotong.v3.userinfo.UserInfoUtilControl;
import client.android.yixiaotong.v3.util.ClickUtil;
import client.android.yixiaotong.v3.util.LocalDataUtil;
import client.android.yixiaotong.v3.util.LogUtil;
import com.huawei.openalliance.ad.views.PPSLabelView;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class BindRoomActivity extends BaseActivity {
    public static final int FLOW_BINGED = 1;
    public static final int FLOW_UNBIND = 0;
    private static final String TAG = "BindRoomActivity";
    private BindElecMeterRoomInfoBean mBindElecMeterRoomInfoBean;
    private int mFlowState;
    private String mInvestorId;
    private String mSchoolId;
    private String mStudentId;
    private TitleBar mTitleBar;
    private TextView mTvArea;
    private TextView mTvBuilding;
    private TextView mTvFloor;
    private TextView mTvRoom;
    private boolean mIsEnable = true;
    private int mClickIndex = 0;

    static {
        StubApp.interface11(9303);
    }

    private String getMsg() {
        int i = this.mClickIndex;
        if (i == 0) {
            return "请选择区域";
        }
        if (i == 1) {
            return "请选择楼栋";
        }
        if (i != 2) {
            return i != 3 ? "" : "请选择房间";
        }
        return "请选择楼层";
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    public static void launch(Activity activity, int i) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) BindRoomActivity.class).putExtra("flowstate", i));
        }
    }

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.titlebar);
        this.mTvArea = (TextView) findViewById(R.id.tv_area1);
        this.mTvBuilding = (TextView) findViewById(R.id.tv_area2);
        this.mTvFloor = (TextView) findViewById(R.id.tv_area3);
        this.mTvRoom = (TextView) findViewById(R.id.tv_area4);
    }

    private void initTitlebar() {
        this.mTitleBar.setTitleView(getString(R.string.bindroom));
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
        this.mTitleBar.setLeftView(R.mipmap.back);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initView() {
        BindElecMeterRoomInfoBean bindElecMeterRoomInfoBean = this.mBindElecMeterRoomInfoBean;
        if (bindElecMeterRoomInfoBean != null) {
            int i = this.mClickIndex;
            if (i != 0) {
                if (i == 1) {
                    this.mTvArea.setText(bindElecMeterRoomInfoBean.regionalName);
                    this.mTvBuilding.setText("");
                    this.mTvFloor.setText("");
                    this.mTvRoom.setText("");
                    return;
                }
                if (i == 2) {
                    this.mTvArea.setText(bindElecMeterRoomInfoBean.regionalName);
                    this.mTvBuilding.setText(this.mBindElecMeterRoomInfoBean.buildingName);
                    this.mTvFloor.setText("");
                    this.mTvRoom.setText("");
                    return;
                }
                if (i == 3) {
                    this.mTvArea.setText(bindElecMeterRoomInfoBean.regionalName);
                    this.mTvBuilding.setText(this.mBindElecMeterRoomInfoBean.buildingName);
                    this.mTvFloor.setText(this.mBindElecMeterRoomInfoBean.floorName);
                    this.mTvRoom.setText("");
                    return;
                }
                if (i != 4) {
                    return;
                }
            }
            this.mTvArea.setText(bindElecMeterRoomInfoBean.regionalName);
            this.mTvBuilding.setText(this.mBindElecMeterRoomInfoBean.buildingName);
            this.mTvFloor.setText(this.mBindElecMeterRoomInfoBean.floorName);
            this.mTvRoom.setText(this.mBindElecMeterRoomInfoBean.roomName);
        }
    }

    private void initClickListeners() {
        findViewById(R.id.rel_area1).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.electricitymeter.BindRoomActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m264x875781f2(view);
            }
        });
        findViewById(R.id.rel_area2).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.electricitymeter.BindRoomActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m265xa058d391(view);
            }
        });
        findViewById(R.id.rel_area3).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.electricitymeter.BindRoomActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m266xb95a2530(view);
            }
        });
        findViewById(R.id.rel_area4).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.electricitymeter.BindRoomActivity$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m267xd25b76cf(view);
            }
        });
        findViewById(R.id.btn_bindroom).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.electricitymeter.BindRoomActivity$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m268xeb5cc86e(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$0$client-android-yixiaotong-v3-ui-appcontrol-electricitymeter-BindRoomActivity, reason: not valid java name */
    /* synthetic */ void m264x875781f2(View view) {
        if (ClickUtil.isFastDoubleClick()) {
            return;
        }
        this.mClickIndex = 1;
        ElecMeterAddressActivity.launch(getActivity(), this.mClickIndex, null);
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$1$client-android-yixiaotong-v3-ui-appcontrol-electricitymeter-BindRoomActivity, reason: not valid java name */
    /* synthetic */ void m265xa058d391(View view) {
        if (ClickUtil.isFastDoubleClick()) {
            return;
        }
        if (StringUtils.isNotEmpty(this.mTvArea.getText().toString())) {
            this.mClickIndex = 2;
            ElecMeterAddressActivity.launch(getActivity(), this.mClickIndex, this.mBindElecMeterRoomInfoBean);
        } else {
            ToastUtils.show(getActivity(), "请选择区域");
        }
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$2$client-android-yixiaotong-v3-ui-appcontrol-electricitymeter-BindRoomActivity, reason: not valid java name */
    /* synthetic */ void m266xb95a2530(View view) {
        if (ClickUtil.isFastDoubleClick()) {
            return;
        }
        if (StringUtils.isNotEmpty(this.mTvBuilding.getText().toString())) {
            this.mClickIndex = 3;
            ElecMeterAddressActivity.launch(getActivity(), this.mClickIndex, this.mBindElecMeterRoomInfoBean);
        } else {
            ToastUtils.show(getActivity(), "请选择楼栋");
        }
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$3$client-android-yixiaotong-v3-ui-appcontrol-electricitymeter-BindRoomActivity, reason: not valid java name */
    /* synthetic */ void m267xd25b76cf(View view) {
        if (ClickUtil.isFastDoubleClick()) {
            return;
        }
        if (StringUtils.isNotEmpty(this.mTvFloor.getText().toString())) {
            this.mClickIndex = 4;
            ElecMeterAddressActivity.launch(getActivity(), this.mClickIndex, this.mBindElecMeterRoomInfoBean);
        } else {
            ToastUtils.show(getActivity(), "请选择楼层");
        }
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$4$client-android-yixiaotong-v3-ui-appcontrol-electricitymeter-BindRoomActivity, reason: not valid java name */
    /* synthetic */ void m268xeb5cc86e(View view) {
        if (ClickUtil.isFastDoubleClick()) {
            return;
        }
        int i = this.mClickIndex;
        if ((i == 0 && this.mBindElecMeterRoomInfoBean != null) || (i != 4 && StringUtils.isNotEmpty(this.mTvRoom.getText().toString()))) {
            ToastUtils.show(getActivity(), "当前房间已绑定");
            getUserInfoElecMeter();
        } else if (this.mClickIndex == 4) {
            bindRoom();
        } else {
            ToastUtils.show(getActivity(), getMsg());
        }
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.mIsEnable = true;
        ErrorControlUtil.getInstance().onResume();
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        this.mIsEnable = false;
        BaseMaterialDialog.dissmisMaterialDialog();
        ErrorControlUtil.getInstance().onPause();
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        LogUtil.e(TAG, "onActivityResult:" + i2 + PPSLabelView.Code + i);
        if (intent != null) {
            LogUtil.e(TAG, "onActivityResult:" + (intent != null));
            BindElecMeterRoomInfoBean bindElecMeterRoomInfoBean = (BindElecMeterRoomInfoBean) intent.getSerializableExtra("bean");
            if (bindElecMeterRoomInfoBean != null) {
                int i3 = this.mClickIndex;
                if (i3 == 1) {
                    this.mBindElecMeterRoomInfoBean.regionalCode = bindElecMeterRoomInfoBean.regionalCode;
                    this.mBindElecMeterRoomInfoBean.regionalName = bindElecMeterRoomInfoBean.regionalName;
                } else if (i3 == 2) {
                    this.mBindElecMeterRoomInfoBean.buildingCode = bindElecMeterRoomInfoBean.buildingCode;
                    this.mBindElecMeterRoomInfoBean.buildingName = bindElecMeterRoomInfoBean.buildingName;
                } else if (i3 == 3) {
                    this.mBindElecMeterRoomInfoBean.floorCode = bindElecMeterRoomInfoBean.floorCode;
                    this.mBindElecMeterRoomInfoBean.floorName = bindElecMeterRoomInfoBean.floorName;
                } else if (i3 == 4) {
                    this.mBindElecMeterRoomInfoBean.roomCode = bindElecMeterRoomInfoBean.roomCode;
                    this.mBindElecMeterRoomInfoBean.roomName = bindElecMeterRoomInfoBean.roomName;
                }
                initView();
            }
        }
    }

    private void initData() {
        this.mSchoolId = UserInfoUtilControl.getInstance().getSchoolId();
        this.mInvestorId = InvestorInfoUtilControl.getInstance().getInvestorId();
        this.mStudentId = UserInfoUtilControl.getInstance().getStudentId();
        if (this.mFlowState == 1) {
            V3BusinessControllers.getInstance().getRoomInformationElecMeter(getLoginAccount(), this.mSchoolId, this.mInvestorId, this.mStudentId, 1, new Listener<BindElecMeterRoomInfoBean>() { // from class: client.android.yixiaotong.v3.ui.appcontrol.electricitymeter.BindRoomActivity.1
                @Override // client.android.yixiaotong.controller.core.Listener
                public void onStart(Controller controller) {
                    super.onStart(controller);
                    BaseMaterialDialog.showMaterialDialog(BindRoomActivity.this.getActivity(), "获取房间信息.", false);
                }

                @Override // client.android.yixiaotong.controller.core.Listener
                public void onComplete(Controller controller, BindElecMeterRoomInfoBean bindElecMeterRoomInfoBean, Object... objArr) {
                    super.onComplete(controller, bindElecMeterRoomInfoBean, objArr);
                    if (BindRoomActivity.this.mIsEnable) {
                        BaseMaterialDialog.dissmisMaterialDialog();
                        BindRoomActivity.this.mBindElecMeterRoomInfoBean = bindElecMeterRoomInfoBean;
                        BindRoomActivity.this.initView();
                    }
                }

                @Override // client.android.yixiaotong.controller.core.Listener
                public void onFail(Controller controller, ClientException clientException) {
                    super.onFail(controller, clientException);
                    if (BindRoomActivity.this.mIsEnable) {
                        BaseMaterialDialog.dissmisMaterialDialog();
                        ErrorControlUtil.getInstance().onError(BindRoomActivity.this.getLoginAccount(), clientException, BindRoomActivity.this.getActivity(), false, BindRoomActivity.this.mTitleBar.getTitleViewContent());
                    }
                }
            });
        }
    }

    private void bindRoom() {
        V3BusinessControllers.getInstance().userBindRoomElecMeter(getLoginAccount(), this.mSchoolId, this.mInvestorId, this.mStudentId, 1, this.mBindElecMeterRoomInfoBean.regionalCode, this.mBindElecMeterRoomInfoBean.regionalName, this.mBindElecMeterRoomInfoBean.buildingCode, this.mBindElecMeterRoomInfoBean.buildingName, this.mBindElecMeterRoomInfoBean.floorCode, this.mBindElecMeterRoomInfoBean.floorName, this.mBindElecMeterRoomInfoBean.roomCode, this.mBindElecMeterRoomInfoBean.roomName, new Listener<SuccessBean>() { // from class: client.android.yixiaotong.v3.ui.appcontrol.electricitymeter.BindRoomActivity.2
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                super.onStart(controller);
                BaseMaterialDialog.showMaterialDialog(BindRoomActivity.this.getActivity(), "正在绑定房间.", false);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, SuccessBean successBean, Object... objArr) {
                super.onComplete(controller, successBean, objArr);
                if (BindRoomActivity.this.mIsEnable) {
                    ToastUtils.show(BindRoomActivity.this.getActivity(), "绑定房间成功!");
                    BindRoomActivity.this.getUserInfoElecMeter();
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                super.onFail(controller, clientException);
                if (BindRoomActivity.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    ErrorControlUtil.getInstance().onError(BindRoomActivity.this.getLoginAccount(), clientException, BindRoomActivity.this.getActivity(), false, BindRoomActivity.this.mTitleBar.getTitleViewContent());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getUserInfoElecMeter() {
        V3BusinessControllers.getInstance().getUserInfoElecMeter(getLoginAccount(), this.mSchoolId, this.mInvestorId, this.mStudentId, 1, new Listener<BindElecMeterInfoBean>() { // from class: client.android.yixiaotong.v3.ui.appcontrol.electricitymeter.BindRoomActivity.3
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                super.onStart(controller);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, BindElecMeterInfoBean bindElecMeterInfoBean, Object... objArr) {
                super.onComplete(controller, bindElecMeterInfoBean, objArr);
                if (BindRoomActivity.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    if (StringUtils.isEmpty(bindElecMeterInfoBean.roomAddress)) {
                        ToastUtils.show(BindRoomActivity.this.getActivity(), "绑定房间失败！");
                        return;
                    }
                    if (!StringUtils.isNotEmpty(bindElecMeterInfoBean.roomAddress) || !StringUtils.isNotEmpty(bindElecMeterInfoBean.factoryNo) || !StringUtils.isNotEmpty(bindElecMeterInfoBean.thirdPartyUserNumber)) {
                        BindRoomActivity.this.showDialog("电表数据异常\n" + LocalDataUtil.getTraceID(BindRoomActivity.this.getActivity()));
                    } else {
                        ElecMeterControlActivity.launch(BindRoomActivity.this.getActivity(), bindElecMeterInfoBean);
                        BindRoomActivity.this.finish();
                    }
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                super.onFail(controller, clientException);
                if (BindRoomActivity.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    ErrorControlUtil.getInstance().onError(BindRoomActivity.this.getLoginAccount(), clientException, BindRoomActivity.this.getActivity(), false, BindRoomActivity.this.mTitleBar.getTitleViewContent());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialog(String str) {
        SystemErrorTip.getInstance().showTipDialog(getActivity(), str);
    }
}
