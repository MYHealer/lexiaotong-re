package client.android.yixiaotong.v4.ui.app.electricitymeter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.v3.ui.adv.AdvControlUtil;
import client.android.yixiaotong.v3.ui.adv.Common;
import client.android.yixiaotong.v3.ui.adv.InsertUtil;
import client.android.yixiaotong.v3.ui.adv.NativeUtil;
import client.android.yixiaotong.v3.util.LogUtil;
import client.android.yixiaotong.v4.util.homeinfo.V4HomeInfoUtil;
import com.stub.StubApp;
import com.unionpay.tsmservice.mi.data.Constant;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class V4DeviceRechargeActivity extends BaseActivity {
    private static final String TAG = "PaySuccessActivity";
    private static final int TIMEOUT = 11000;
    private AdvControlUtil.AdvListener mAdvListener;
    private String mBtMac;
    ImageView mImgResult;
    private InsertUtil mInsertUtil;
    private boolean mIsEnable;
    private String mMac;
    private NativeUtil mNativeUtil;
    private int mProductId;
    private String mSysRandom;
    TitleBar mTitleBar;
    TextView mTvAdvName;
    TextView mTvPayContent;
    TextView mTvPayContent2;
    TextView mTvRechargeTip;
    private V4DeviceRechargeControlUtil mV4DeviceRechargeControlUtil;
    RelativeLayout rlContainer;
    private int mRechargeResult = 0;
    private boolean mCountTimeEnd = false;

    static {
        StubApp.interface11(10714);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    public static void launch(Activity activity, String str, String str2, int i, String str3) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) V4DeviceRechargeActivity.class).putExtra("btmac", str).putExtra(Constant.KEY_MAC, str2).putExtra("productid", i).putExtra("sysrandom", str3));
        }
    }

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.titlebar);
        this.rlContainer = (RelativeLayout) findViewById(R.id.rlContainer);
        this.mTvAdvName = (TextView) findViewById(R.id.tv_advname);
        this.mTvPayContent = (TextView) findViewById(R.id.tv_content);
        this.mTvPayContent2 = (TextView) findViewById(R.id.tv_content2);
        this.mImgResult = (ImageView) findViewById(R.id.iv_connected);
        this.mTvRechargeTip = (TextView) findViewById(R.id.tv_tiptext);
    }

    /* JADX INFO: renamed from: client.android.yixiaotong.v4.ui.app.electricitymeter.V4DeviceRechargeActivity$1, reason: invalid class name */
    class AnonymousClass1 implements V4DeviceRechargeControlUtil.OnListener {
        AnonymousClass1() {
        }

        @Override // client.android.yixiaotong.v4.ui.app.electricitymeter.V4DeviceRechargeControlUtil.OnListener
        public void onChargeSuccess() {
            V4DeviceRechargeActivity.this.mRechargeResult = 1;
        }
    }

    /* JADX INFO: renamed from: client.android.yixiaotong.v4.ui.app.electricitymeter.V4DeviceRechargeActivity$2, reason: invalid class name */
    class AnonymousClass2 implements Runnable {
        AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public void run() {
            V4DeviceRechargeActivity.this.initAdv();
            V4DeviceRechargeActivity.this.getAdv();
        }
    }

    private void initTitleBar() {
        this.mTitleBar.setTitleView(getResources().getString(R.string.rechargedetails));
        this.mTitleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setLeftViewOnClick(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.app.electricitymeter.V4DeviceRechargeActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (V4DeviceRechargeActivity.this.isCheckExit()) {
                    V4DeviceRechargeActivity.this.finish();
                }
            }
        });
        findViewById(R.id.btn_tolauhch).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.app.electricitymeter.V4DeviceRechargeActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (V4DeviceRechargeActivity.this.isCheckExit()) {
                    V4DeviceRechargeActivity.this.finish();
                }
            }
        });
    }

    private void initView() {
        int i = this.mProductId;
        if (i == 12) {
            this.mTvRechargeTip.setText(getString(R.string.electmetertip1));
        } else if (i == 6) {
            this.mTvRechargeTip.setText(getString(R.string.remotewatertip));
        } else if (i == 13) {
            this.mTvRechargeTip.setText(getString(R.string.airtip));
        }
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.mIsEnable = true;
        V4DeviceRechargeControlUtil v4DeviceRechargeControlUtil = this.mV4DeviceRechargeControlUtil;
        if (v4DeviceRechargeControlUtil != null) {
            v4DeviceRechargeControlUtil.onResume();
        }
        NativeUtil nativeUtil = this.mNativeUtil;
        if (nativeUtil != null) {
            nativeUtil.onResume();
        }
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        V4DeviceRechargeControlUtil v4DeviceRechargeControlUtil = this.mV4DeviceRechargeControlUtil;
        if (v4DeviceRechargeControlUtil != null) {
            v4DeviceRechargeControlUtil.onPause();
        }
        NativeUtil nativeUtil = this.mNativeUtil;
        if (nativeUtil != null) {
            nativeUtil.onPause();
        }
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        this.mIsEnable = false;
        InsertUtil insertUtil = this.mInsertUtil;
        if (insertUtil != null) {
            insertUtil.onDestroy(getActivity());
        }
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        NativeUtil nativeUtil = this.mNativeUtil;
        if (nativeUtil != null) {
            nativeUtil.onDestroy();
        }
        super.onDestroy();
        V4DeviceRechargeControlUtil v4DeviceRechargeControlUtil = this.mV4DeviceRechargeControlUtil;
        if (v4DeviceRechargeControlUtil != null) {
            v4DeviceRechargeControlUtil.disconnect();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isCheckExit() {
        if (this.mCountTimeEnd) {
            return true;
        }
        ToastUtils.show(getActivity(), getResources().getString(R.string.rechargeexittip));
        return false;
    }

    class TimeCount extends CountDownTimer {
        public TimeCount(long j, long j2) {
            super(j, j2);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            if (V4DeviceRechargeActivity.this.mIsEnable) {
                if (V4DeviceRechargeActivity.this.mRechargeResult == 1) {
                    V4DeviceRechargeActivity.this.mTvPayContent2.setText(V4DeviceRechargeActivity.this.getResources().getString(R.string.rechargesuccess));
                } else {
                    V4DeviceRechargeActivity.this.mTvPayContent2.setText(V4DeviceRechargeActivity.this.getResources().getString(R.string.rechargecompleted));
                }
                V4DeviceRechargeActivity.this.mCountTimeEnd = true;
            }
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            if (V4DeviceRechargeActivity.this.mIsEnable) {
                V4DeviceRechargeActivity.this.mTvPayContent2.setTextColor(V4DeviceRechargeActivity.this.getResources().getColor(R.color.ff7a7a7a));
                V4DeviceRechargeActivity.this.mTvPayContent2.setText(Html.fromHtml("正在同步充值中 " + (j / 1000) + " S"));
                V4DeviceRechargeActivity.this.mTvPayContent2.setTextSize(15.0f);
                V4DeviceRechargeActivity.this.mTvPayContent2.setPadding(5, 5, 5, 5);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initAdv() {
        this.mNativeUtil = new NativeUtil();
        InsertUtil insertUtil = new InsertUtil();
        this.mInsertUtil = insertUtil;
        insertUtil.onCreate(getActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getAdv() {
        this.mAdvListener = new AdvControlUtil.AdvListener() { // from class: client.android.yixiaotong.v4.ui.app.electricitymeter.V4DeviceRechargeActivity.5
            @Override // client.android.yixiaotong.v3.ui.adv.AdvControlUtil.AdvListener
            public void isOpen(int i, int i2, int i3, int i4, int i5) {
            }

            @Override // client.android.yixiaotong.v3.ui.adv.AdvControlUtil.AdvListener
            public void onAdClosed(Common.AdvType advType) {
            }

            @Override // client.android.yixiaotong.v3.ui.adv.AdvControlUtil.AdvListener
            public void onAdShow(String str, Common.AdvType advType) {
            }

            @Override // client.android.yixiaotong.v3.ui.adv.AdvControlUtil.AdvListener
            public void onRenderSuccess(View view, int i) {
            }
        };
        boolean zIsOpenAdv = V4HomeInfoUtil.getInstance().isOpenAdv();
        LogUtil.e(TAG, "广告是否开启：" + zIsOpenAdv);
        if (zIsOpenAdv) {
            this.mNativeUtil.initNative(getActivity(), this.mAdvListener, 1);
            this.mNativeUtil.onNative(this.rlContainer);
            this.mInsertUtil.initInsert(getActivity(), this.mAdvListener, true, "", false);
            this.mInsertUtil.onInsert();
        }
    }
}
