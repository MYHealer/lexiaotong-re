package client.android.yixiaotong.ui.bluetoothtwo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.TextView;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.ui.widget.TitleBar;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class BathRecordDetailActivity extends BaseActivity {
    public static final String EXTRA_MONEY = "extra_momey";
    public static final String EXTRA_TIME = "extra_time";
    public static final String EXTRA_TYPEID = "extra_typeid";
    public static final String EXTRA_USECOUNT = "extra_pusecount";
    public static final String EXTRA_USEWAY = "extra_payway";
    public static final String EXTRA_WALLET = "extra_wallet";
    private String mMoney;
    private int mOfflineCount;
    private RelativeLayout mRelOfflineCount;
    private RelativeLayout mRelType;
    private String mTime;
    private TitleBar mTitleBar;
    private TextView mTvMoney;
    private TextView mTvOfflineCount;
    private TextView mTvPayTime;
    private TextView mTvState;
    private TextView mTvUseWay;
    private int mTypeid;
    private String mUseWay;

    static {
        StubApp.interface11(6489);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    public static void launch(Activity activity, String str, String str2, String str3, int i) {
        Intent intent = new Intent(activity, (Class<?>) BathRecordDetailActivity.class);
        intent.putExtra("extra_momey", str);
        intent.putExtra("extra_time", str2);
        intent.putExtra("extra_payway", str3);
        intent.putExtra(EXTRA_USECOUNT, i);
        activity.startActivity(intent);
    }

    public static void launch(Activity activity, String str, String str2, int i) {
        Intent intent = new Intent(activity, (Class<?>) BathRecordDetailActivity.class);
        intent.putExtra("extra_momey", str);
        intent.putExtra("extra_time", str2);
        intent.putExtra("extra_typeid", i);
        activity.startActivity(intent);
    }

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.v_titleBar);
        this.mTvMoney = (TextView) findViewById(R.id.tv_money);
        this.mTvState = (TextView) findViewById(R.id.tv_state);
        this.mTvPayTime = (TextView) findViewById(R.id.tv_datetime);
        this.mTvUseWay = (TextView) findViewById(R.id.tv_payway);
        this.mTvOfflineCount = (TextView) findViewById(R.id.tv_offlinecount);
        this.mRelType = (RelativeLayout) findViewById(R.id.rel_type);
        this.mRelOfflineCount = (RelativeLayout) findViewById(R.id.rel_offlinecount);
    }

    private void initTitleBar() {
        this.mTitleBar.setTitleView("消费详情");
        this.mTitleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
    }
}
