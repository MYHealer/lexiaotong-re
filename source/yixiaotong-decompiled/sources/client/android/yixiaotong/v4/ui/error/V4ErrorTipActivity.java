package client.android.yixiaotong.v4.ui.error;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.ui.dialog.UpdateAppDialog;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.update.UpdateAppUtil;
import client.android.yixiaotong.v3.util.Error50XUtil;
import client.android.yixiaotong.v3.util.LocalDataUtil;
import client.android.yixiaotong.v3.util.LogUtil;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class V4ErrorTipActivity extends BaseActivity {
    public static final int BLUETOOTHTYPE = 1;
    public static final int BLUETOOTHTYPE_OPEN = 3;
    public static final int EXITAPP1 = 403;
    private static final String EXTRA_CODE = "extra_code";
    private static final String EXTRA_SERIAL = "extra_serial";
    private static final String EXTRA_TIP = "extra_tip";
    private static final String EXTRA_TITLE = "extra_title";
    private static final String EXTRA_TYPE = "extra_type";
    public static final int NETWORKTYPE_OPEN = 4;
    public static final int SYSTEMTYPE = 2;
    private static final String TAG = "V4ErrorTipActivity";
    Button mBtnKnow;
    Button mBtnUpdate;
    private int mCode;
    ImageView mImgErrorPic;
    private boolean mIsEnable;
    RelativeLayout mRelBluetoothFailTip;
    RelativeLayout mRelCard;
    RelativeLayout mRelPsw;
    private String mSerial;
    private String mTip;
    private String mTitle;
    TitleBar mTitleBar;
    TextView mTvContent1;
    EditText mTvContent2;
    TextView mTvTraceId;
    private int mType;

    static {
        StubApp.interface11(10942);
    }

    static /* synthetic */ void lambda$initClickListeners$2(View view) {
    }

    static /* synthetic */ void lambda$initClickListeners$3(View view) {
    }

    public boolean isNeedExitApp(int i) {
        return i == 403;
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    public static void launch(Activity activity, String str, String str2, int i, int i2, String str3) {
        if (activity != null) {
            LogUtil.e(TAG, activity.getLocalClassName());
            if (Error50XUtil.isInterrupt(activity)) {
                if (Error50XUtil.isFinishActivity(activity)) {
                    activity.finish();
                    return;
                }
                return;
            }
            activity.startActivity(new Intent(activity, (Class<?>) V4ErrorTipActivity.class).putExtra(EXTRA_TITLE, str).putExtra(EXTRA_TIP, str2).putExtra(EXTRA_CODE, i).putExtra(EXTRA_TYPE, i2).putExtra(EXTRA_SERIAL, str3));
        }
    }

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.tb_name);
        this.mImgErrorPic = (ImageView) findViewById(R.id.img_errorpic);
        this.mTvContent1 = (TextView) findViewById(R.id.tv_content1);
        this.mTvContent2 = (EditText) findViewById(R.id.tv_content2);
        this.mBtnUpdate = (Button) findViewById(R.id.btn_update);
        this.mBtnKnow = (Button) findViewById(R.id.btn_know);
        this.mTvTraceId = (TextView) findViewById(R.id.tv_traceid);
        this.mRelBluetoothFailTip = (RelativeLayout) findViewById(R.id.rel_bluetoothfailtip);
        this.mRelCard = (RelativeLayout) findViewById(R.id.rel_card);
        this.mRelPsw = (RelativeLayout) findViewById(R.id.rel_psw);
    }

    private void initTitleBar() {
        this.mTitleBar.setTitleView(this.mTitle);
        this.mTitleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
    }

    private void initView() {
        this.mTvContent2.setText(this.mTip);
        int i = this.mType;
        if (i == 1) {
            this.mTvContent1.setText("蓝牙连接失败");
            this.mImgErrorPic.setImageResource(R.mipmap.lyljsb);
            return;
        }
        if (i == 3) {
            this.mTvContent1.setText("蓝牙连接失败");
            this.mImgErrorPic.setImageResource(R.mipmap.lyljsb);
            return;
        }
        if (i == 2 || i == 4) {
            LogUtil.e(TAG, "getCode:" + LocalDataUtil.getCode(getContext()));
            if (LocalDataUtil.getCode(getContext()) == 404) {
                errorcode(LocalDataUtil.getCode(getContext()));
                return;
            }
            if (this.mCode == -1000) {
                this.mImgErrorPic.setImageResource(R.mipmap.wljzsb);
                this.mTvContent1.setText("网络加载失败");
                if (LocalDataUtil.getCode(getContext()) == 200 || LocalDataUtil.getCode(getContext()) == 0) {
                    this.mTvContent2.setText("请重新检查网络是否连接");
                    return;
                } else {
                    this.mTvContent2.setText("请重新检查网络是否连接" + LocalDataUtil.getCode(getContext()));
                    return;
                }
            }
            this.mImgErrorPic.setImageResource(R.mipmap.fwqyc);
            this.mTvContent1.setText("");
            EditText editText = this.mTvContent2;
            editText.setText(editText.getText().toString());
        }
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
        UpdateAppDialog.getInstance().dismiss(getActivity());
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
    }

    private void initClickListeners() {
        findViewById(R.id.btn_update).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.error.V4ErrorTipActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m525x607f7e2d(view);
            }
        });
        findViewById(R.id.btn_know).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.error.V4ErrorTipActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m526xed6c954c(view);
            }
        });
        findViewById(R.id.tv_bindcard).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.error.V4ErrorTipActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                V4ErrorTipActivity.lambda$initClickListeners$2(view);
            }
        });
        findViewById(R.id.tv_setpsw).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.error.V4ErrorTipActivity$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                V4ErrorTipActivity.lambda$initClickListeners$3(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$0$client-android-yixiaotong-v4-ui-error-V4ErrorTipActivity, reason: not valid java name */
    /* synthetic */ void m525x607f7e2d(View view) {
        new UpdateAppUtil().showMustUpdateApkDialog(getActivity(), this.mTip);
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$1$client-android-yixiaotong-v4-ui-error-V4ErrorTipActivity, reason: not valid java name */
    /* synthetic */ void m526xed6c954c(View view) {
        finish();
    }

    private void errorcode(int i) {
        if (i == 404) {
            this.mImgErrorPic.setImageResource(R.mipmap.error404);
            this.mTvContent1.setText("空空如也");
            this.mTvContent2.setText("你访问的页面不在地球，请重试~");
            return;
        }
        if (i == 502) {
            this.mImgErrorPic.setImageResource(R.mipmap.error502);
            this.mTvContent1.setText("出错啦");
            this.mTvContent2.setText("系统正在紧急修复中，请在15-30分钟后重新尝试使用。");
        } else if (i == 503) {
            this.mImgErrorPic.setImageResource(R.mipmap.error503);
            this.mTvContent1.setText("超载啦");
            this.mTvContent2.setText("服务临时压力有点大，请换个时间或者过三分钟后尝试使用。");
        } else if (i == 504) {
            this.mImgErrorPic.setImageResource(R.mipmap.error504);
            this.mTvContent1.setText("超时啦");
            this.mTvContent2.setText("同学先休息一下吧，稍后再试");
        }
    }
}
