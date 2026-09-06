package client.android.yixiaotong.v4.ui.app.electricitymeter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.v4.http.bean.V4ElecMeterInfoBean;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class V4RoomDetailActivity extends BaseActivity {
    private static final String TAG = "V4RoomDetailActivity";
    private V4ElecMeterInfoBean mBindElecMeterInfoBean;
    private boolean mIsEnable = true;
    LinearLayout mLinUserNo;
    private int mProductId;
    TitleBar mTitleBar;
    TextView mTvDeviceNo;
    TextView mTvRoomAdress;
    TextView mTvUserNo;
    TextView mTvUserNoText;

    static {
        StubApp.interface11(10775);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    public static void launch(Activity activity, V4ElecMeterInfoBean v4ElecMeterInfoBean, int i) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) V4RoomDetailActivity.class).putExtra("bean", v4ElecMeterInfoBean).putExtra("productid", i));
        }
    }

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.titlebar);
        this.mTvUserNoText = (TextView) findViewById(R.id.tv_usernotext);
        this.mLinUserNo = (LinearLayout) findViewById(R.id.lin_userno);
        this.mTvUserNo = (TextView) findViewById(R.id.tv_userno);
        this.mTvRoomAdress = (TextView) findViewById(R.id.tv_roomaddress);
        this.mTvDeviceNo = (TextView) findViewById(R.id.deviceno);
    }

    private void initTitleBar() {
        this.mTitleBar.setTitleView(getString(R.string.roominfo1));
        this.mTitleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
    }

    private void initView() {
        if (this.mProductId == 12) {
            this.mLinUserNo.setVisibility(0);
            this.mTvUserNoText.setText(getString(R.string.userno1));
        } else {
            this.mLinUserNo.setVisibility(8);
        }
        this.mTvDeviceNo.setText(this.mBindElecMeterInfoBean.mac);
        this.mTvRoomAdress.setText(this.mBindElecMeterInfoBean.address);
        this.mTvUserNo.setText(this.mBindElecMeterInfoBean.eleSn);
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

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
    }
}
