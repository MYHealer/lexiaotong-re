package client.android.yixiaotong.v4.ui.wallet;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.v3.ui.adv.AdvControlUtil;
import client.android.yixiaotong.v3.ui.adv.Common;
import client.android.yixiaotong.v3.ui.adv.InsertUtil;
import client.android.yixiaotong.v3.ui.adv.NativeUtil;
import client.android.yixiaotong.v3.util.LogUtil;
import client.android.yixiaotong.v4.util.homeinfo.V4HomeInfoUtil;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class V4PaySuccessActivity extends BaseActivity {
    private static final String TAG = "V4PaySuccessActivity";
    private AdvControlUtil.AdvListener mAdvListener;
    private InsertUtil mInsertUtil;
    private boolean mIsEnable;
    private NativeUtil mNativeUtil;
    private TitleBar mTitleBar;
    private RelativeLayout rlContainer;

    static {
        StubApp.interface11(11108);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    public static void launch(Activity activity) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) V4PaySuccessActivity.class));
        }
    }

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.titleBar);
        this.rlContainer = (RelativeLayout) findViewById(R.id.rlContainer);
    }

    private void initTitleBar() {
        this.mTitleBar.setTitleView(getString(R.string.payresult));
        this.mTitleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
    }

    private void initClickListeners() {
        findViewById(R.id.btn_tolauhch).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.wallet.V4PaySuccessActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                V4PaySuccessActivity.this.finish();
            }
        });
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.mIsEnable = true;
        NativeUtil nativeUtil = this.mNativeUtil;
        if (nativeUtil != null) {
            nativeUtil.onResume();
        }
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
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
    }

    private void initAdv() {
        this.mNativeUtil = new NativeUtil();
        InsertUtil insertUtil = new InsertUtil();
        this.mInsertUtil = insertUtil;
        insertUtil.onCreate(getActivity());
    }

    private void getAdv() {
        this.mAdvListener = new AdvControlUtil.AdvListener() { // from class: client.android.yixiaotong.v4.ui.wallet.V4PaySuccessActivity.2
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
            this.mInsertUtil.initInsert(getActivity(), this.mAdvListener, true, "", 2);
            this.mInsertUtil.onInsert();
        }
    }
}
