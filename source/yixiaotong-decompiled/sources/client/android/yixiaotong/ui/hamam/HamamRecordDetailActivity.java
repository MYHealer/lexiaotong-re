package client.android.yixiaotong.ui.hamam;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.ui.widget.TitleBar;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class HamamRecordDetailActivity extends BaseActivity {
    public static final String EXTRA_MONEY = "extra_momey";
    public static final String EXTRA_ORDERID = "extra_orderid";
    public static final String EXTRA_STATE = "extra_state";
    public static final String EXTRA_TIME = "extra_time";
    public static final String EXTRA_USE = "extra_use";
    public static final String EXTRA_WALLET = "extra_wallet";
    private String mMoney;
    private String mOrderId;
    private int mState;
    private String mTime;
    TitleBar mTitleBar;
    TextView mTvMoney;
    TextView mTvOrderId;
    TextView mTvPayTime;
    TextView mTvState;
    TextView mTvUse;
    private String mUse;

    static {
        StubApp.interface11(AVMDLDataLoader.KeyIsFirstRangeLeftThreshold);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    public static void launch(Activity activity, String str, String str2, String str3, String str4, int i) {
        Intent intent = new Intent(activity, (Class<?>) HamamRecordDetailActivity.class);
        intent.putExtra("extra_momey", str);
        intent.putExtra("extra_time", str2);
        intent.putExtra("extra_orderid", str3);
        intent.putExtra(EXTRA_USE, str4);
        intent.putExtra("extra_state", i);
        activity.startActivity(intent);
    }

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.v_titleBar);
        this.mTvMoney = (TextView) findViewById(R.id.tv_money);
        this.mTvState = (TextView) findViewById(R.id.tv_state);
        this.mTvPayTime = (TextView) findViewById(R.id.tv_datetime);
        this.mTvUse = (TextView) findViewById(R.id.tv_use);
        this.mTvOrderId = (TextView) findViewById(R.id.tv_orderid);
    }

    private void initTitleBar() {
        this.mTitleBar.setTitleView("消费详情");
        this.mTitleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
    }
}
