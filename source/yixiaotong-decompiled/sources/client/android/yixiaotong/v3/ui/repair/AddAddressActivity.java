package client.android.yixiaotong.v3.ui.repair;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.v3.ui.area.AddressActivity;
import client.android.yixiaotong.v3.userinfo.UserInfoUtil;
import client.android.yixiaotong.v3.util.LocalDataUtil;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class AddAddressActivity extends BaseActivity {
    private EditText mEtPhone;
    private String mId1 = "";
    private String mId2 = "";
    private String mId3 = "";
    private String mId4 = "";
    private String mName = "";
    private int mSiteFlag = -1;
    private TitleBar mTitleBar;
    private TextView mTvArea1;
    private TextView mTvArea2;
    private TextView mTvArea3;
    private TextView mTvArea4;
    private TextView mTvAreaText1;
    private TextView mTvAreaText2;
    private TextView mTvAreaText3;
    private TextView mTvAreaText4;

    static {
        StubApp.interface11(10164);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    public static void launch(Activity activity) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) AddAddressActivity.class));
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
        this.mEtPhone = (EditText) findViewById(R.id.et_phone);
    }

    private void initTitleBar() {
        this.mTitleBar.setTitleView("添加地址");
        this.mTitleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
    }

    private void initClickListeners() {
        findViewById(R.id.btn_addaddress).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.repair.AddAddressActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m413x560dca1b(view);
            }
        });
        findViewById(R.id.rel_area1).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.repair.AddAddressActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m414x66c396dc(view);
            }
        });
        findViewById(R.id.rel_area2).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.repair.AddAddressActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m415x7779639d(view);
            }
        });
        findViewById(R.id.rel_area3).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.repair.AddAddressActivity$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m416x882f305e(view);
            }
        });
        findViewById(R.id.rel_area4).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.repair.AddAddressActivity$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m417x98e4fd1f(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$0$client-android-yixiaotong-v3-ui-repair-AddAddressActivity, reason: not valid java name */
    /* synthetic */ void m413x560dca1b(View view) {
        checkInfo();
        LocalDataUtil.saveArea4(getContext(), this.mId4 + "," + this.mName + "," + this.mSiteFlag + "," + this.mEtPhone.getText().toString());
        finish();
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$1$client-android-yixiaotong-v3-ui-repair-AddAddressActivity, reason: not valid java name */
    /* synthetic */ void m414x66c396dc(View view) {
        handleArea1Click();
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$2$client-android-yixiaotong-v3-ui-repair-AddAddressActivity, reason: not valid java name */
    /* synthetic */ void m415x7779639d(View view) {
        handleArea2Click();
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$3$client-android-yixiaotong-v3-ui-repair-AddAddressActivity, reason: not valid java name */
    /* synthetic */ void m416x882f305e(View view) {
        handleArea3Click();
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$4$client-android-yixiaotong-v3-ui-repair-AddAddressActivity, reason: not valid java name */
    /* synthetic */ void m417x98e4fd1f(View view) {
        handleArea4Click();
    }

    private void handleArea1Click() {
        initAreaView(1);
        AddressActivity.launch(getActivity(), UserInfoUtil.getInstance().getLoginAccountV3().schoolInfoList.get(UserInfoUtil.getInstance().getSchoolInfosIndex()).id + "", this.mTvAreaText1.getText().toString(), 1);
    }

    private void handleArea2Click() {
        if (StringUtils.isNotEmpty(this.mTvArea1.getText().toString())) {
            initAreaView(2);
            AddressActivity.launch(getActivity(), this.mId1, this.mTvAreaText2.getText().toString(), 2);
        }
    }

    private void handleArea3Click() {
        if (StringUtils.isNotEmpty(this.mTvArea2.getText().toString())) {
            initAreaView(3);
            AddressActivity.launch(getActivity(), this.mId2, this.mTvAreaText3.getText().toString(), 3);
        }
    }

    private void handleArea4Click() {
        if (StringUtils.isNotEmpty(this.mTvArea3.getText().toString())) {
            initAreaView(4);
            AddressActivity.launch(getActivity(), this.mId3, this.mTvAreaText4.getText().toString(), 4);
        }
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
            }
        }
    }

    private void checkInfo() {
        if (StringUtils.isEmpty(this.mTvArea1.getText().toString())) {
            ToastUtils.show(getContext(), "请选择区域");
            return;
        }
        if (StringUtils.isEmpty(this.mTvArea2.getText().toString())) {
            ToastUtils.show(getContext(), "请选择楼栋");
            return;
        }
        if (StringUtils.isEmpty(this.mTvArea3.getText().toString())) {
            ToastUtils.show(getContext(), "请选择楼层");
        } else if (StringUtils.isEmpty(this.mTvArea4.getText().toString())) {
            ToastUtils.show(getContext(), "请选择房间");
        } else if (StringUtils.isEmpty(this.mEtPhone.getText().toString())) {
            ToastUtils.show(getContext(), "请输入手机号码");
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
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
        }
    }
}
