package client.android.yixiaotong.ui.error;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.account.AccountManager;
import client.android.yixiaotong.controller.BusinessControllers;
import client.android.yixiaotong.controller.bean.SystemErrorBean;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.sdk.utils.NetworkUtils;
import client.android.yixiaotong.ui.dialog.ServerMaintainDialog;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.TimeUtils;
import client.android.yixiaotong.util.executor.AsyncExecutor;
import client.android.yixiaotong.util.executor.MainThreadExecutor;
import com.google.android.exoplayer2.C;
import com.stub.StubApp;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class ErrorTipActivity extends BaseActivity {
    public static final int BLUETOOTHTYPE = 1;
    private static final String EXTRA_CODE = "extra_code";
    private static final String EXTRA_SERIAL = "extra_serial";
    private static final String EXTRA_TIP1 = "extra_tip1";
    private static final String EXTRA_TIP2 = "extra_tip2";
    private static final String EXTRA_TITLE = "extra_title";
    private static final String EXTRA_TYPE = "extra_type";
    public static final int SYSTEMTYPE = 2;
    private Button mBtnCloseTip;
    private int mCode;
    private ImageView mImgErrorPic;
    private boolean mIsEnable;
    private String mSerial;
    private String mTip1;
    private String mTip2;
    private String mTitle;
    private TitleBar mTitleBar;
    private TextView mTvContent1;
    private TextView mTvContent2;
    private TextView mTvHelper1;
    private TextView mTvHelper2;
    private TextView mTvTime;
    private int mType;
    private boolean mFirstVisit = true;
    private boolean mNetOnline = false;
    private int mUrlIndex = 0;
    private String[] urlArray = {"http://3g.163.com", "http://xw.qq.com", "http://app.jd.com", "http://m.baidu.com", "http://m.taobao.com"};

    static {
        StubApp.interface11(7201);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    public static void launch(Activity activity, String str, String str2, String str3, int i, int i2) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) ErrorTipActivity.class).putExtra(EXTRA_TITLE, str).putExtra(EXTRA_TIP1, str2).putExtra(EXTRA_TIP2, str3).putExtra(EXTRA_CODE, i).putExtra(EXTRA_TYPE, i2));
        }
    }

    public static void launch(Activity activity, String str, String str2, String str3, int i, int i2, String str4) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) ErrorTipActivity.class).putExtra(EXTRA_TITLE, str).putExtra(EXTRA_TIP1, str2).putExtra(EXTRA_TIP2, str3).putExtra(EXTRA_CODE, i).putExtra(EXTRA_TYPE, i2).putExtra(EXTRA_SERIAL, str4));
        }
    }

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.tb_name);
        this.mImgErrorPic = (ImageView) findViewById(R.id.img_errorpic);
        this.mTvContent1 = (TextView) findViewById(R.id.tv_content1);
        this.mTvContent2 = (TextView) findViewById(R.id.tv_content2);
        this.mTvHelper1 = (TextView) findViewById(R.id.tv_helper1);
        this.mTvHelper2 = (TextView) findViewById(R.id.tv_helper2);
        this.mTvTime = (TextView) findViewById(R.id.tv_time);
        this.mBtnCloseTip = (Button) findViewById(R.id.btn_closetip);
    }

    private void initTitleBar() {
        this.mTitleBar.setTitleView(this.mTitle);
        this.mTitleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
    }

    private void initClickListeners() {
        findViewById(R.id.btn_closetip).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.error.ErrorTipActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m130xd87213e2(view);
            }
        });
        findViewById(R.id.tv_helper1).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.error.ErrorTipActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m131x65acc563(view);
            }
        });
        findViewById(R.id.tv_helper2).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.error.ErrorTipActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m132xf2e776e4(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$0$client-android-yixiaotong-ui-error-ErrorTipActivity, reason: not valid java name */
    /* synthetic */ void m130xd87213e2(View view) {
        finish();
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$1$client-android-yixiaotong-ui-error-ErrorTipActivity, reason: not valid java name */
    /* synthetic */ void m131x65acc563(View view) {
        finish();
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$2$client-android-yixiaotong-ui-error-ErrorTipActivity, reason: not valid java name */
    /* synthetic */ void m132xf2e776e4(View view) {
        finish();
    }

    private void initView() {
        this.mTvContent1.setText(this.mTip1);
        this.mTvContent2.setText(this.mTip2 + "(" + this.mCode + ")");
        int i = this.mType;
        if (i == 1) {
            this.mImgErrorPic.setImageResource(R.mipmap.l_bluetooth_close);
            return;
        }
        if (i == 2) {
            if (this.mCode == -1000) {
                this.mImgErrorPic.setImageResource(R.mipmap.l_net_timeout);
                this.mTvContent1.setText("当前网络超时");
                this.mTvContent2.setText("当前网络超时、网络连接失败");
                this.mBtnCloseTip.setText("我知道了");
                this.mTvHelper1.setText("网络相关？");
                this.mTvHelper1.setVisibility(4);
                this.mTvHelper2.setVisibility(4);
                netWorkError(getActivity());
                return;
            }
            this.mTvTime.setVisibility(0);
            this.mImgErrorPic.setImageResource(R.mipmap.l_sever_error);
            this.mTvContent1.setText("出错啦，请稍等再试");
            this.mTvContent1.setVisibility(8);
            this.mTvContent2.setTextColor(getResources().getColor(R.color.ffff892C));
            if (StringUtils.isEmpty(this.mTip2)) {
                this.mTvContent2.setText("出错啦，请稍等再试(" + this.mCode + ")");
            }
            try {
                if (StringUtils.isNotEmpty(this.mSerial)) {
                    if (this.mSerial.length() == 13) {
                        this.mTvTime.setText("触发时间:" + TimeUtils.formatDateTime(Long.parseLong(this.mSerial)));
                    } else {
                        this.mTvTime.setText("触发时间:" + TimeUtils.formatDateTime(Long.parseLong(this.mSerial) * 1000));
                    }
                }
            } catch (Exception unused) {
            }
            this.mBtnCloseTip.setText("返回页面");
            this.mBtnCloseTip.setBackgroundResource(R.drawable.round_radius_button_fb8f45_background);
            this.mTvHelper1.setVisibility(4);
            this.mTvHelper2.setVisibility(4);
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
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
    }

    private void netWorkError(Activity activity) {
        if (NetworkUtils.isNetworkAvailable(activity)) {
            delayed(activity);
        } else {
            this.mTvContent1.setText("请打开网络");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getServerState(final Activity activity) {
        BusinessControllers.getInstance().getSystemErrorMsg(AccountManager.getInstance().getLoginAccount(), new Listener<SystemErrorBean>() { // from class: client.android.yixiaotong.ui.error.ErrorTipActivity.1
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                if (ErrorTipActivity.this.mIsEnable) {
                    ErrorTipActivity.this.mTvContent1.setText("当前网络良好");
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, SystemErrorBean systemErrorBean, Object... objArr) {
                if (ErrorTipActivity.this.mIsEnable) {
                    if (systemErrorBean == null || !StringUtils.isNotEmpty(systemErrorBean.time)) {
                        ErrorTipActivity.this.mTvContent2.setText("当前网络超时、网络连接失败");
                    } else {
                        ServerMaintainDialog.getInstance().showServerErrorDialog(activity, systemErrorBean.time);
                    }
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (ErrorTipActivity.this.mIsEnable) {
                    ErrorTipActivity.this.mTvContent2.setText("当前网络超时、网络连接失败");
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void delayed(final Activity activity) {
        networkIsOnline(activity);
        MainThreadExecutor.getInstance().executeDelayed(new Runnable() { // from class: client.android.yixiaotong.ui.error.ErrorTipActivity.2
            @Override // java.lang.Runnable
            public void run() {
                if (!ErrorTipActivity.this.mNetOnline && ErrorTipActivity.this.mIsEnable && ErrorTipActivity.this.mFirstVisit) {
                    ErrorTipActivity.this.mFirstVisit = false;
                    ErrorTipActivity.this.delayed(activity);
                }
            }
        }, C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS);
    }

    private void networkIsOnline(final Activity activity) {
        AsyncExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.ui.error.ErrorTipActivity.3
            @Override // java.lang.Runnable
            public void run() {
                int i;
                ErrorTipActivity.this.mNetOnline = false;
                try {
                    double dRandom = Math.random();
                    while (true) {
                        i = (int) (dRandom * 5.0d);
                        if (i != ErrorTipActivity.this.mUrlIndex) {
                            break;
                        } else {
                            dRandom = Math.random();
                        }
                    }
                    if (i >= 0 && i < ErrorTipActivity.this.urlArray.length) {
                        ErrorTipActivity.this.mUrlIndex = i;
                    }
                    new URL(ErrorTipActivity.this.urlArray[ErrorTipActivity.this.mUrlIndex]).openStream();
                    ErrorTipActivity.this.mNetOnline = true;
                    ErrorTipActivity.this.getServerState(activity);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
        });
    }
}
