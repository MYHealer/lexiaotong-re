package client.android.yixiaotong.v3.ui.appcontrol.prepayment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.ui.dialog.BaseMaterialDialog;
import client.android.yixiaotong.ui.dialog.SystemErrorTip;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.v3.bean.deviceinfo.MachineByLocationBean;
import client.android.yixiaotong.v3.bean.login.TypeInfoBean;
import client.android.yixiaotong.v3.http.V3BusinessControllers;
import client.android.yixiaotong.v3.ui.area.AddressActivity;
import client.android.yixiaotong.v3.ui.error.V3ErrorTipActivity;
import client.android.yixiaotong.v3.userinfo.UserInfoUtil;
import client.android.yixiaotong.v3.util.ClickUtil;
import client.android.yixiaotong.v3.util.LocalDataUtil;
import com.stub.StubApp;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class SelectAddressActivity extends BaseActivity {
    private static final String TAG = "SelectAddressActivity";
    private String mDeviceMac;
    private String mDeviceVer;
    private TitleBar mTitleBar;
    private TextView mTvArea1;
    private TextView mTvArea2;
    private TextView mTvArea3;
    private TextView mTvArea4;
    private TextView mTvAreaText1;
    private TextView mTvAreaText2;
    private TextView mTvAreaText3;
    private TextView mTvAreaText4;
    private TypeInfoBean mTypeInfoBean;
    private boolean mIsEnable = true;
    private String mId1 = "";
    private String mId2 = "";
    private String mId3 = "";
    private String mId4 = "";
    private String mName = "";
    private int mSiteFlag = -1;
    private String mMachineId = "";

    static {
        StubApp.interface11(9475);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    public static void launch(Activity activity, TypeInfoBean typeInfoBean) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) SelectAddressActivity.class).putExtra("bean", typeInfoBean));
        }
    }

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.titleBar);
        this.mTvAreaText1 = (TextView) findViewById(R.id.tv_areatext1);
        this.mTvArea1 = (TextView) findViewById(R.id.tv_area1);
        this.mTvAreaText2 = (TextView) findViewById(R.id.tv_areatext2);
        this.mTvArea2 = (TextView) findViewById(R.id.tv_area2);
        this.mTvAreaText3 = (TextView) findViewById(R.id.tv_areatext3);
        this.mTvArea3 = (TextView) findViewById(R.id.tv_area3);
        this.mTvAreaText4 = (TextView) findViewById(R.id.tv_areatext4);
        this.mTvArea4 = (TextView) findViewById(R.id.tv_area4);
    }

    private void initTitleBar() {
        this.mTitleBar.setTitleView("查询设备");
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

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
    }

    private void initClickListeners() {
        findViewById(R.id.rel_area1).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.prepayment.SelectAddressActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m302x435528e7(view);
            }
        });
        findViewById(R.id.rel_area2).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.prepayment.SelectAddressActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m303x4423a768(view);
            }
        });
        findViewById(R.id.rel_area3).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.prepayment.SelectAddressActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m304x44f225e9(view);
            }
        });
        findViewById(R.id.rel_area4).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.prepayment.SelectAddressActivity$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m305x45c0a46a(view);
            }
        });
        findViewById(R.id.btn_next).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.prepayment.SelectAddressActivity$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m306x468f22eb(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$0$client-android-yixiaotong-v3-ui-appcontrol-prepayment-SelectAddressActivity, reason: not valid java name */
    /* synthetic */ void m302x435528e7(View view) {
        if (ClickUtil.isFastDoubleClick()) {
            return;
        }
        initAreaView(1);
        AddressActivity.launch(getActivity(), UserInfoUtil.getInstance().getLoginAccountV3().schoolInfoList.get(UserInfoUtil.getInstance().getSchoolInfosIndex()).id + "", this.mTvAreaText1.getText().toString(), 1);
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$1$client-android-yixiaotong-v3-ui-appcontrol-prepayment-SelectAddressActivity, reason: not valid java name */
    /* synthetic */ void m303x4423a768(View view) {
        if (ClickUtil.isFastDoubleClick() || !StringUtils.isNotEmpty(this.mTvArea1.getText().toString())) {
            return;
        }
        initAreaView(2);
        AddressActivity.launch(getActivity(), this.mId1, this.mTvAreaText2.getText().toString(), 2);
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$2$client-android-yixiaotong-v3-ui-appcontrol-prepayment-SelectAddressActivity, reason: not valid java name */
    /* synthetic */ void m304x44f225e9(View view) {
        if (ClickUtil.isFastDoubleClick() || !StringUtils.isNotEmpty(this.mTvArea2.getText().toString())) {
            return;
        }
        initAreaView(3);
        AddressActivity.launch(getActivity(), this.mId2, this.mTvAreaText3.getText().toString(), 3);
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$3$client-android-yixiaotong-v3-ui-appcontrol-prepayment-SelectAddressActivity, reason: not valid java name */
    /* synthetic */ void m305x45c0a46a(View view) {
        if (ClickUtil.isFastDoubleClick() || !StringUtils.isNotEmpty(this.mTvArea3.getText().toString())) {
            return;
        }
        initAreaView(4);
        AddressActivity.launch(getActivity(), this.mId3, this.mTvAreaText4.getText().toString(), 4);
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$4$client-android-yixiaotong-v3-ui-appcontrol-prepayment-SelectAddressActivity, reason: not valid java name */
    /* synthetic */ void m306x468f22eb(View view) {
        if (ClickUtil.isFastDoubleClick() || !isCheck()) {
            return;
        }
        handleNextButtonClick();
    }

    private void handleNextButtonClick() {
        if (StringUtils.isNotEmpty(this.mMachineId)) {
            LocalDataUtil.saveTypeIdMachineId(getActivity(), 18, this.mMachineId + ";" + this.mDeviceMac + ";" + this.mDeviceVer);
            PrepaymentWalletActivity.launch(getActivity(), this.mTypeInfoBean);
            finish();
            return;
        }
        getMachineInfoByLocation(true);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i != 1 || intent == null) {
            return;
        }
        this.mName = intent.getStringExtra("name");
        String stringExtra = intent.getStringExtra("id");
        if (i2 == 1) {
            this.mId1 = stringExtra;
            this.mTvArea1.setText(this.mName);
            LocalDataUtil.saveArea1(getContext(), stringExtra + "," + this.mName);
            return;
        }
        if (i2 == 2) {
            this.mId2 = stringExtra;
            this.mTvArea2.setText(this.mName);
            LocalDataUtil.saveArea2(getContext(), stringExtra + "," + this.mName);
        } else if (i2 == 3) {
            this.mId3 = stringExtra;
            this.mTvArea3.setText(this.mName);
            LocalDataUtil.saveArea3(getContext(), stringExtra + "," + this.mName);
        } else if (i2 == 4) {
            this.mId4 = stringExtra;
            this.mSiteFlag = intent.getIntExtra("siteflag", -1);
            this.mTvArea4.setText(this.mName);
            LocalDataUtil.saveArea4(getContext(), stringExtra + "," + this.mName + "," + this.mSiteFlag);
            getMachineInfoByLocation(false);
        }
    }

    private boolean isCheck() {
        if (this.mTvArea1.equals("请选择") || StringUtils.isEmpty(this.mTvArea1.getText().toString())) {
            ToastUtils.show(getActivity(), "请选择区域");
            return false;
        }
        if (this.mTvArea2.equals("请选择") || StringUtils.isEmpty(this.mTvArea2.getText().toString())) {
            ToastUtils.show(getActivity(), "请选择楼栋");
            return false;
        }
        if (this.mTvArea3.equals("请选择") || StringUtils.isEmpty(this.mTvArea3.getText().toString())) {
            ToastUtils.show(getActivity(), "请选择楼层");
            return false;
        }
        if (!this.mTvArea4.equals("请选择") && !StringUtils.isEmpty(this.mTvArea4.getText().toString())) {
            return true;
        }
        ToastUtils.show(getActivity(), "请选择房间");
        return false;
    }

    private void initAreaView(int i) {
        if (i == 1) {
            this.mTvArea1.setText("");
            this.mTvArea2.setText("");
            this.mTvArea3.setText("");
            this.mTvArea4.setText("");
            LocalDataUtil.saveArea1(getContext(), "");
            LocalDataUtil.saveArea2(getContext(), "");
            LocalDataUtil.saveArea3(getContext(), "");
            LocalDataUtil.saveArea4(getContext(), "");
            return;
        }
        if (i == 2) {
            this.mTvArea2.setText("");
            this.mTvArea3.setText("");
            this.mTvArea4.setText("");
            LocalDataUtil.saveArea2(getContext(), "");
            LocalDataUtil.saveArea3(getContext(), "");
            LocalDataUtil.saveArea4(getContext(), "");
            return;
        }
        if (i == 3) {
            this.mTvArea3.setText("");
            this.mTvArea4.setText("");
            LocalDataUtil.saveArea3(getContext(), "");
            LocalDataUtil.saveArea4(getContext(), "");
            return;
        }
        if (i == 4) {
            this.mTvArea4.setText("");
            LocalDataUtil.saveArea4(getContext(), "");
            return;
        }
        if (i == 0) {
            String area3 = LocalDataUtil.getArea3(getContext());
            String area2 = LocalDataUtil.getArea2(getContext());
            String area1 = LocalDataUtil.getArea1(getContext());
            String area4 = LocalDataUtil.getArea4(getContext());
            if (StringUtils.isNotEmpty(area1)) {
                String[] strArrSplit = area1.split(",");
                this.mId1 = strArrSplit[0];
                this.mTvArea1.setText(strArrSplit[1]);
            }
            if (StringUtils.isNotEmpty(area2)) {
                String[] strArrSplit2 = area2.split(",");
                this.mId2 = strArrSplit2[0];
                this.mTvArea2.setText(strArrSplit2[1]);
            }
            if (StringUtils.isNotEmpty(area3)) {
                String[] strArrSplit3 = area3.split(",");
                this.mId3 = strArrSplit3[0];
                this.mTvArea3.setText(strArrSplit3[1]);
            }
            if (StringUtils.isNotEmpty(area4)) {
                String[] strArrSplit4 = area4.split(",");
                this.mId4 = strArrSplit4[0];
                this.mTvArea4.setText(strArrSplit4[1]);
                this.mSiteFlag = Integer.parseInt(strArrSplit4[2]);
                getMachineInfoByLocation(false);
            }
        }
    }

    private void getMachineInfoByLocation(final boolean z) {
        V3BusinessControllers.getInstance().postGetMachineByLocation(getLoginAccount(), this.mId4, this.mSiteFlag, this.mTypeInfoBean.base.typeId, new Listener<List<MachineByLocationBean>>() { // from class: client.android.yixiaotong.v3.ui.appcontrol.prepayment.SelectAddressActivity.1
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                BaseMaterialDialog.showMaterialDialog(SelectAddressActivity.this.getActivity(), "正在搜索设备中..", false);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, List<MachineByLocationBean> list, Object... objArr) {
                if (SelectAddressActivity.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    if (list == null || list.size() <= 0 || !StringUtils.isNotEmpty(list.get(0).machineId) || !StringUtils.isNotEmpty(list.get(0).deviceMac) || !StringUtils.isNotEmpty(list.get(0).deviceVer)) {
                        SelectAddressActivity.this.showDialog("当前房间没有设备，请选择其他房间", false);
                        return;
                    }
                    SelectAddressActivity.this.mMachineId = list.get(0).machineId;
                    SelectAddressActivity.this.mDeviceMac = list.get(0).deviceMac;
                    SelectAddressActivity.this.mDeviceVer = list.get(0).deviceVer;
                    if (z) {
                        PrepaymentWalletActivity.launch(SelectAddressActivity.this.getActivity(), SelectAddressActivity.this.mTypeInfoBean);
                        SelectAddressActivity.this.finish();
                    }
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (SelectAddressActivity.this.mIsEnable) {
                    SelectAddressActivity.this.onError(clientException, false);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialog(String str, final boolean z) {
        BaseMaterialDialog.dissmisMaterialDialog();
        SystemErrorTip.getInstance().showTipDialog(getActivity(), new SystemErrorTip.SystemErrorDialogListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.prepayment.SelectAddressActivity.2
            @Override // client.android.yixiaotong.ui.dialog.SystemErrorTip.SystemErrorDialogListener
            public void onConfirm() {
                if (z) {
                    SelectAddressActivity.this.finish();
                }
            }
        }, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onError(ClientException clientException, boolean z) {
        BaseMaterialDialog.dissmisMaterialDialog();
        if (clientException.isNeedTip(clientException.getCode())) {
            showDialog(clientException.getDetail() + "\n(" + LocalDataUtil.getTraceID(getActivity()) + ")", z);
        } else {
            V3ErrorTipActivity.launch(getActivity(), this.mTitleBar.getTitleViewContent(), clientException.getDetail(), clientException.getCode(), 2, clientException.getSerial());
        }
    }
}
