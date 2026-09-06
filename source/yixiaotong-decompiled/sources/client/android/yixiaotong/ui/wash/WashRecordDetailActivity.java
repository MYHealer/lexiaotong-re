package client.android.yixiaotong.ui.wash;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.TextView;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.controller.model.WalletModel;
import client.android.yixiaotong.ui.widget.TitleBar;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class WashRecordDetailActivity extends BaseActivity {
    public static final String EXTRA_MODE = "extra_mode";
    public static final String EXTRA_MONEY = "extra_momey";
    public static final String EXTRA_ORDERID = "extra_orderid";
    public static final String EXTRA_PAYWAY = "extra_payway";
    public static final String EXTRA_STATE = "extra_state";
    public static final String EXTRA_TIME = "extra_time";
    public static final String EXTRA_TYPEID = "extra_typeid";
    public static final String EXTRA_WALLET = "extra_wallet";
    public static final String EXTRA_WITHHOLDMONEY = "extra_withholdmoney";
    private int mMode;
    private String mMoney;
    private String mOrderId;
    private String mPayWay;
    RelativeLayout mRelWithholdMoney;
    RelativeLayout mRelXiYi;
    private int mState;
    private String mTime;
    TitleBar mTitleBar;
    TextView mTvMode;
    TextView mTvModeText;
    TextView mTvMoney;
    TextView mTvOrderId;
    TextView mTvPayTime;
    TextView mTvPayWay;
    TextView mTvState;
    TextView mTvWithholdMoney;
    private int mTypeId;
    private WalletModel mWalletModel;
    private String mWithholdMoney;

    static {
        StubApp.interface11(7721);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    public static void launch(Activity activity, String str, String str2, String str3, String str4, int i, String str5) {
        Intent intent = new Intent(activity, (Class<?>) WashRecordDetailActivity.class);
        intent.putExtra("extra_momey", str);
        intent.putExtra("extra_time", str2);
        intent.putExtra("extra_orderid", str3);
        intent.putExtra("extra_payway", str4);
        intent.putExtra("extra_state", i);
        intent.putExtra(EXTRA_WITHHOLDMONEY, str5);
        activity.startActivity(intent);
    }

    public static void launch(Activity activity, int i, String str, String str2, String str3, String str4, int i2, int i3) {
        Intent intent = new Intent(activity, (Class<?>) WashRecordDetailActivity.class);
        intent.putExtra("extra_typeid", i);
        intent.putExtra("extra_momey", str);
        intent.putExtra("extra_time", str2);
        intent.putExtra("extra_orderid", str3);
        intent.putExtra("extra_payway", str4);
        intent.putExtra("extra_state", i2);
        intent.putExtra(EXTRA_MODE, i3);
        activity.startActivity(intent);
    }

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.v_titleBar);
        this.mTvMoney = (TextView) findViewById(R.id.tv_money);
        this.mTvState = (TextView) findViewById(R.id.tv_state);
        this.mTvPayTime = (TextView) findViewById(R.id.tv_datetime);
        this.mTvPayWay = (TextView) findViewById(R.id.tv_payway);
        this.mTvOrderId = (TextView) findViewById(R.id.tv_orderid);
        this.mRelXiYi = (RelativeLayout) findViewById(R.id.rel_xiyi);
        this.mTvModeText = (TextView) findViewById(R.id.tv_modetext);
        this.mTvMode = (TextView) findViewById(R.id.tv_mode);
        this.mRelWithholdMoney = (RelativeLayout) findViewById(R.id.rel_withholdmoney);
        this.mTvWithholdMoney = (TextView) findViewById(R.id.tv_withholdmoney);
    }

    private void initTitleBar() {
        this.mTitleBar.setTitleView("消费详情");
        this.mTitleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
    }
}
