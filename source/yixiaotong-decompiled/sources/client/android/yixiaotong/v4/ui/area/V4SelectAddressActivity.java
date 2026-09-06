package client.android.yixiaotong.v4.ui.area;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.v3.util.ClickUtil;
import client.android.yixiaotong.v4.util.V4LocalDataUtil;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class V4SelectAddressActivity extends BaseActivity {
    public static final int REQUESTCODE = 1;
    private String mName;
    private int mResultCode;
    TitleBar mTitleBar;
    TextView mTvArea1;
    TextView mTvArea2;
    TextView mTvArea3;
    TextView mTvArea4;
    TextView mTvAreaText1;
    TextView mTvAreaText2;
    TextView mTvAreaText3;
    TextView mTvAreaText4;
    private String mId1 = "";
    private String mId2 = "";
    private String mId3 = "";
    private String mId4 = "";
    private int mProductId = 0;

    static {
        StubApp.interface11(10840);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    public static void launch(Activity activity, int i) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) V4SelectAddressActivity.class).putExtra("productId", i));
        }
    }

    public static void launchForResult(Activity activity, int i) {
        if (activity != null) {
            activity.startActivityForResult(new Intent(activity, (Class<?>) V4SelectAddressActivity.class).putExtra("code", i), 1);
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
        this.mTitleBar.setTitleView(this.mProductId >= 0 ? "绑定房间" : "选择地址");
        this.mTitleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        V4SelectAddressControl.getInstance().onResume();
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        V4SelectAddressControl.getInstance().onPause();
    }

    private void initViewNewListener() {
        findViewById(R.id.rel_area1).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.area.V4SelectAddressActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m499x19fe9333(view);
            }
        });
        findViewById(R.id.rel_area2).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.area.V4SelectAddressActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m500xae3d02d2(view);
            }
        });
        findViewById(R.id.rel_area3).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.area.V4SelectAddressActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m501x427b7271(view);
            }
        });
        findViewById(R.id.rel_area4).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.area.V4SelectAddressActivity$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m502xd6b9e210(view);
            }
        });
        findViewById(R.id.btn_comfirt).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.area.V4SelectAddressActivity$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m503x6af851af(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$initViewNewListener$0$client-android-yixiaotong-v4-ui-area-V4SelectAddressActivity, reason: not valid java name */
    /* synthetic */ void m499x19fe9333(View view) {
        initAreaView(1);
        V4AddressActivity.launch(getActivity(), "", this.mTvAreaText1.getText().toString(), 1);
    }

    /* JADX INFO: renamed from: lambda$initViewNewListener$1$client-android-yixiaotong-v4-ui-area-V4SelectAddressActivity, reason: not valid java name */
    /* synthetic */ void m500xae3d02d2(View view) {
        if (StringUtils.isNotEmpty(this.mTvArea1.getText().toString())) {
            initAreaView(2);
            V4AddressActivity.launch(getActivity(), this.mId1, this.mTvAreaText2.getText().toString(), 2);
        }
    }

    /* JADX INFO: renamed from: lambda$initViewNewListener$2$client-android-yixiaotong-v4-ui-area-V4SelectAddressActivity, reason: not valid java name */
    /* synthetic */ void m501x427b7271(View view) {
        if (StringUtils.isNotEmpty(this.mTvArea2.getText().toString())) {
            initAreaView(3);
            V4AddressActivity.launch(getActivity(), this.mId2, this.mTvAreaText3.getText().toString(), 3);
        }
    }

    /* JADX INFO: renamed from: lambda$initViewNewListener$3$client-android-yixiaotong-v4-ui-area-V4SelectAddressActivity, reason: not valid java name */
    /* synthetic */ void m502xd6b9e210(View view) {
        if (StringUtils.isNotEmpty(this.mTvArea3.getText().toString())) {
            initAreaView(4);
            V4AddressActivity.launch(getActivity(), this.mId3, this.mTvAreaText4.getText().toString(), 4);
        }
    }

    /* JADX INFO: renamed from: lambda$initViewNewListener$4$client-android-yixiaotong-v4-ui-area-V4SelectAddressActivity, reason: not valid java name */
    /* synthetic */ void m503x6af851af(View view) {
        if (ClickUtil.isFastDoubleClick()) {
            return;
        }
        if (this.mProductId >= 0) {
            V4SelectAddressControl.getInstance().bindRoom(getLoginAccount(), getActivity(), this.mId4, this.mProductId, false);
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("name", this.mTvArea1.getText().toString() + "," + this.mTvArea2.getText().toString() + "," + this.mTvArea3.getText().toString() + "," + this.mTvArea4.getText().toString());
        intent.putExtra("id", this.mId4);
        setResult(1, intent);
        finish();
    }

    private void initAreaView(int i) {
        if (i == 1) {
            this.mTvArea1.setText("");
            this.mTvArea2.setText("");
            this.mTvArea3.setText("");
            this.mTvArea4.setText("");
            V4LocalDataUtil.saveArea1(getContext(), "");
            V4LocalDataUtil.saveArea2(getContext(), "");
            V4LocalDataUtil.saveArea3(getContext(), "");
            V4LocalDataUtil.saveArea4(getContext(), "");
            return;
        }
        if (i == 2) {
            this.mTvArea2.setText("");
            this.mTvArea3.setText("");
            this.mTvArea4.setText("");
            V4LocalDataUtil.saveArea2(getContext(), "");
            V4LocalDataUtil.saveArea3(getContext(), "");
            V4LocalDataUtil.saveArea4(getContext(), "");
            return;
        }
        if (i == 3) {
            this.mTvArea3.setText("");
            this.mTvArea4.setText("");
            V4LocalDataUtil.saveArea3(getContext(), "");
            V4LocalDataUtil.saveArea4(getContext(), "");
            return;
        }
        if (i == 4) {
            this.mTvArea4.setText("");
            V4LocalDataUtil.saveArea4(getContext(), "");
            return;
        }
        if (i == 0) {
            String area2 = V4LocalDataUtil.getArea2(getContext());
            String area1 = V4LocalDataUtil.getArea1(getContext());
            String area3 = V4LocalDataUtil.getArea3(getContext());
            String area4 = V4LocalDataUtil.getArea4(getContext());
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
            }
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
        this.mResultCode = i2;
        if (i2 == 1) {
            this.mId1 = stringExtra;
            this.mTvArea1.setText(this.mName);
            V4LocalDataUtil.saveArea1(getContext(), stringExtra + "," + this.mName);
            return;
        }
        if (i2 == 2) {
            this.mId2 = stringExtra;
            this.mTvArea2.setText(this.mName);
            V4LocalDataUtil.saveArea2(getContext(), stringExtra + "," + this.mName);
        } else if (i2 == 3) {
            this.mId3 = stringExtra;
            this.mTvArea3.setText(this.mName);
            V4LocalDataUtil.saveArea3(getContext(), stringExtra + "," + this.mName);
        } else if (i2 == 4) {
            this.mId4 = stringExtra;
            this.mTvArea4.setText(this.mName);
            V4LocalDataUtil.saveArea4(getContext(), stringExtra + "," + this.mName);
        }
    }
}
