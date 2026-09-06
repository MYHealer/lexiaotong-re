package client.android.yixiaotong.v3.ui.appcontrol.electricitymeter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.v3.bean.elecmeter.BindElecMeterInfoBean;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class RoomDetailActivity extends BaseActivity {
    private static final String TAG = "RoomDetailActivity";
    private BindElecMeterInfoBean mBindElecMeterInfoBean;
    private boolean mIsEnable = true;
    private TitleBar mTitleBar;
    private TextView mTvDeviceNo;
    private TextView mTvRoomAdress;
    private TextView mTvUserNo;

    static {
        StubApp.interface11(9350);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    public static void launch(Activity activity, BindElecMeterInfoBean bindElecMeterInfoBean) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) RoomDetailActivity.class).putExtra("bean", bindElecMeterInfoBean));
        }
    }

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.titlebar);
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
        this.mTvDeviceNo.setText(this.mBindElecMeterInfoBean.factoryNo);
        this.mTvRoomAdress.setText(this.mBindElecMeterInfoBean.roomAddress);
        this.mTvUserNo.setText(this.mBindElecMeterInfoBean.thirdPartyUserNumber);
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
