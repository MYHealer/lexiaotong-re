package client.android.yixiaotong.v3.ui.appcontrol.drinkwater;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.ui.RechargeRecordActivity;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.v3.ui.adv.AdvControlUtil;
import client.android.yixiaotong.v3.ui.adv.Common;
import client.android.yixiaotong.v3.ui.adv.InsertUtil;
import client.android.yixiaotong.v3.ui.order.ConsumeRecordActivity;
import client.android.yixiaotong.v3.util.ClickUtil;
import client.android.yixiaotong.v3.util.LogUtil;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class CloseSuccessActivity extends BaseActivity {
    public static final String TAG = "CloseSuccessActivity";
    private AdvControlUtil.AdvListener mAdvListener;
    private Button mBtnToLaunch;
    private InsertUtil mInsertUtil;
    private TitleBar mTitleBar;
    private TextView mTvAdvNameRight;
    private TextView mTvContent;
    private int mTypeId;
    private boolean mIsEnable = true;
    private boolean mIsClose = false;

    static {
        StubApp.interface11(9170);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    public static void launch(Activity activity, int i) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) CloseSuccessActivity.class).putExtra(RechargeRecordActivity.EXTRA_TYPEID, i));
        }
    }

    public static void launchForClose(Activity activity, int i, boolean z) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) CloseSuccessActivity.class).putExtra(RechargeRecordActivity.EXTRA_TYPEID, i).putExtra("close", z));
        }
    }

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.titleBar);
        this.mTvContent = (TextView) findViewById(R.id.tv_content);
        this.mBtnToLaunch = (Button) findViewById(R.id.btn_tolauhch);
        this.mTvAdvNameRight = (TextView) findViewById(R.id.tv_advnameright);
    }

    private void initTitleBar() {
        this.mTitleBar.setTitleView(getString(R.string.settlementresults));
        this.mTitleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.mIsEnable = true;
        AdvControlUtil.getInstance().onResume();
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        this.mIsEnable = false;
        AdvControlUtil.getInstance().onPause();
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        AdvControlUtil.getInstance().onDestroy(getActivity());
        InsertUtil insertUtil = this.mInsertUtil;
        if (insertUtil != null) {
            insertUtil.onDestroy(getActivity());
        }
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
    }

    private void initClickListeners() {
        findViewById(R.id.btn_tolauhch).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.drinkwater.CloseSuccessActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ClickUtil.isFastDoubleClick()) {
                    return;
                }
                if (!CloseSuccessActivity.this.mIsClose) {
                    ConsumeRecordActivity.launch(CloseSuccessActivity.this.getActivity(), CloseSuccessActivity.this.mTypeId);
                }
                CloseSuccessActivity.this.finish();
            }
        });
    }

    private void getAdv() {
        InsertUtil insertUtil = new InsertUtil();
        this.mInsertUtil = insertUtil;
        insertUtil.onCreate(getActivity());
        this.mAdvListener = new AdvControlUtil.AdvListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.drinkwater.CloseSuccessActivity.2
            @Override // client.android.yixiaotong.v3.ui.adv.AdvControlUtil.AdvListener
            public void onAdClosed(Common.AdvType advType) {
            }

            @Override // client.android.yixiaotong.v3.ui.adv.AdvControlUtil.AdvListener
            public void onAdShow(String str, Common.AdvType advType) {
            }

            @Override // client.android.yixiaotong.v3.ui.adv.AdvControlUtil.AdvListener
            public void onRenderSuccess(View view, int i) {
            }

            @Override // client.android.yixiaotong.v3.ui.adv.AdvControlUtil.AdvListener
            public void isOpen(int i, int i2, int i3, int i4, int i5) {
                LogUtil.e("CloseSuccessActivity", "getAdv:" + i);
                if (i == 1) {
                    CloseSuccessActivity.this.mInsertUtil.initInsert(CloseSuccessActivity.this.getActivity(), CloseSuccessActivity.this.mAdvListener, true, "", false);
                    CloseSuccessActivity.this.mInsertUtil.onInsert();
                }
            }
        };
        AdvControlUtil.getInstance().init(getActivity(), this.mAdvListener, this.mTypeId, true, "");
        AdvControlUtil.getInstance().initAdvInfo();
    }
}
