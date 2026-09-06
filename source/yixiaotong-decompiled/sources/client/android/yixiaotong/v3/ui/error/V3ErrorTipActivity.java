package client.android.yixiaotong.v3.ui.error;

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
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.ui.dialog.BaseMaterialDialog;
import client.android.yixiaotong.ui.dialog.UpdateAppDialog;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.util.update.UpdateAppUtil;
import client.android.yixiaotong.v3.bean.login.SchoolInfoBean;
import client.android.yixiaotong.v3.bean.login.UseToolsJsonBean;
import client.android.yixiaotong.v3.bean.register.PswBean;
import client.android.yixiaotong.v3.bean.user.AppVersionBean;
import client.android.yixiaotong.v3.http.V3BusinessControllers;
import client.android.yixiaotong.v3.ui.card.SchoolCardActivity;
import client.android.yixiaotong.v3.ui.register.MachinePSWActivity;
import client.android.yixiaotong.v3.ui.register.ResetDevicePswActivity;
import client.android.yixiaotong.v3.userinfo.InvestorInfoUtilControl;
import client.android.yixiaotong.v3.userinfo.UserInfoUtilControl;
import client.android.yixiaotong.v3.util.Error50XUtil;
import client.android.yixiaotong.v3.util.LocalDataUtil;
import client.android.yixiaotong.v3.util.LogUtil;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class V3ErrorTipActivity extends BaseActivity {
    public static final int BLUETOOTHTYPE = 1;
    public static final int BLUETOOTHTYPE_OPEN = 3;
    public static final int EXITAPP = 1001;
    public static final int EXITAPP1 = -44;
    private static final String EXTRA_CODE = "extra_code";
    private static final String EXTRA_SERIAL = "extra_serial";
    private static final String EXTRA_TIP = "extra_tip";
    private static final String EXTRA_TITLE = "extra_title";
    private static final String EXTRA_TYPE = "extra_type";
    public static final int NETWORKTYPE_OPEN = 4;
    public static final int SYSTEMTYPE = 2;
    private static final String TAG = "V3ErrorTipActivity";
    private Button mBtnKnow;
    private Button mBtnUpdate;
    private int mCode;
    private ImageView mImgErrorPic;
    private boolean mIsEnable;
    private RelativeLayout mRelBluetoothFailTip;
    private RelativeLayout mRelCard;
    private RelativeLayout mRelPsw;
    private String mSerial;
    private String mTip;
    private String mTitle;
    private TitleBar mTitleBar;
    private TextView mTvContent1;
    private EditText mTvContent2;
    private TextView mTvTraceId;
    private int mType;

    static {
        StubApp.interface11(9954);
    }

    public boolean isNeedExitApp(int i) {
        return i == 1001 || i == -44;
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
            activity.startActivity(new Intent(activity, (Class<?>) V3ErrorTipActivity.class).putExtra(EXTRA_TITLE, str).putExtra(EXTRA_TIP, str2).putExtra(EXTRA_CODE, i).putExtra(EXTRA_TYPE, i2).putExtra(EXTRA_SERIAL, str3));
        }
    }

    public static void launchBluetoothFail(Activity activity, String str, String str2, int i) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) V3ErrorTipActivity.class).putExtra(EXTRA_TITLE, str).putExtra(EXTRA_TIP, str2).putExtra(EXTRA_CODE, i).putExtra(EXTRA_TYPE, 1));
        }
    }

    public static void launchBluetoothFailForOpen(Activity activity, String str, String str2, int i) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) V3ErrorTipActivity.class).putExtra(EXTRA_TITLE, str).putExtra(EXTRA_TIP, str2).putExtra(EXTRA_CODE, i).putExtra(EXTRA_TYPE, 3));
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
            bluetoothFailUI();
            return;
        }
        if (i == 2 || i == 4) {
            LogUtil.e(TAG, "getCode:" + LocalDataUtil.getCode(getContext()));
            if (LocalDataUtil.getCode(getContext()) == 404) {
                errorcode(LocalDataUtil.getCode(getContext()));
            } else {
                int i2 = this.mCode;
                if (i2 == -1000) {
                    this.mImgErrorPic.setImageResource(R.mipmap.wljzsb);
                    this.mTvContent1.setText("网络加载失败");
                    if (LocalDataUtil.getCode(getContext()) == 200 || LocalDataUtil.getCode(getContext()) == 0) {
                        this.mTvContent2.setText("请重新检查网络是否连接\nTraceId:" + LocalDataUtil.getTraceID(getContext()));
                    } else {
                        this.mTvContent2.setText("请重新检查网络是否连接" + LocalDataUtil.getCode(getContext()) + "\nTraceId:" + LocalDataUtil.getTraceID(getContext()));
                    }
                } else if (i2 == -53) {
                    this.mImgErrorPic.setImageResource(R.mipmap.fwqyc);
                    this.mTvContent1.setText("乐校通APP有新版本，需要更新才能使用");
                    EditText editText = this.mTvContent2;
                    editText.setText(editText.getText().toString());
                    this.mBtnKnow.setVisibility(8);
                    this.mBtnUpdate.setVisibility(0);
                    getVerSion();
                    new UpdateAppUtil().showMustUpdateApkDialog(getActivity(), this.mTip);
                } else {
                    this.mImgErrorPic.setImageResource(R.mipmap.fwqyc);
                    this.mTvContent1.setText("");
                    int i3 = this.mCode;
                    if ((i3 >= -73 && i3 <= -60) || i3 == -51) {
                        this.mTvContent1.setText("系统异常");
                        this.mTvContent2.setText("TraceId:" + LocalDataUtil.getTraceID(getContext()));
                    } else {
                        this.mTvContent2.setText(this.mTvContent2.getText().toString() + "\nTraceId:" + LocalDataUtil.getTraceID(getContext()));
                    }
                }
            }
            if (this.mType == 4) {
                bluetoothFailUI();
            }
        }
    }

    private void bluetoothFailUI() {
        UseToolsJsonBean useToolsJsonBean = InvestorInfoUtilControl.getInstance().getUseToolsJsonBean(1);
        if (useToolsJsonBean != null) {
            if (useToolsJsonBean.useCardFlag == 1) {
                this.mRelBluetoothFailTip.setVisibility(0);
                this.mRelCard.setVisibility(0);
            }
            if (useToolsJsonBean.useMachinePwdFlag == 1) {
                this.mRelBluetoothFailTip.setVisibility(0);
                this.mRelPsw.setVisibility(0);
            }
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
        findViewById(R.id.btn_update).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.error.V3ErrorTipActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m374xe685bbab(view);
            }
        });
        findViewById(R.id.btn_know).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.error.V3ErrorTipActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m375x7372d2ca(view);
            }
        });
        findViewById(R.id.tv_bindcard).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.error.V3ErrorTipActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m376x5fe9e9(view);
            }
        });
        findViewById(R.id.tv_setpsw).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.error.V3ErrorTipActivity$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m377x8d4d0108(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$0$client-android-yixiaotong-v3-ui-error-V3ErrorTipActivity, reason: not valid java name */
    /* synthetic */ void m374xe685bbab(View view) {
        new UpdateAppUtil().showMustUpdateApkDialog(getActivity(), this.mTip);
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$1$client-android-yixiaotong-v3-ui-error-V3ErrorTipActivity, reason: not valid java name */
    /* synthetic */ void m375x7372d2ca(View view) {
        finish();
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$2$client-android-yixiaotong-v3-ui-error-V3ErrorTipActivity, reason: not valid java name */
    /* synthetic */ void m376x5fe9e9(View view) {
        SchoolCardActivity.launch(getActivity());
        finish();
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$3$client-android-yixiaotong-v3-ui-error-V3ErrorTipActivity, reason: not valid java name */
    /* synthetic */ void m377x8d4d0108(View view) {
        findPsw();
    }

    private void errorcode(int i) {
        if (i == 404) {
            this.mImgErrorPic.setImageResource(R.mipmap.error404);
            this.mTvContent1.setText("空空如也");
            this.mTvContent2.setText("你访问的页面不在地球，请重试~");
        } else if (i == 502) {
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
        this.mTvTraceId.setVisibility(0);
        this.mTvTraceId.setText(LocalDataUtil.getTraceID(getContext()));
    }

    private void getSchoolInfo() {
        V3BusinessControllers.getInstance().getSchoolInfo(getLoginAccount(), new Listener<SchoolInfoBean>() { // from class: client.android.yixiaotong.v3.ui.error.V3ErrorTipActivity.1
        });
    }

    private void getVerSion() {
        String schoolId = UserInfoUtilControl.getInstance().getSchoolId();
        String investorId = InvestorInfoUtilControl.getInstance().getInvestorId();
        LocalDataUtil.saveAppUpdateUrl(getActivity(), "");
        V3BusinessControllers.getInstance().getAppVerInfo(getLoginAccount(), schoolId, investorId, new Listener<AppVersionBean>() { // from class: client.android.yixiaotong.v3.ui.error.V3ErrorTipActivity.2
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, AppVersionBean appVersionBean, Object... objArr) {
                if (StringUtils.isNotEmpty(appVersionBean.ver)) {
                    if ((appVersionBean.status == 1 || appVersionBean.status == 2) && StringUtils.isNotEmpty(appVersionBean.url)) {
                        LocalDataUtil.saveAppUpdateUrl(V3ErrorTipActivity.this.getActivity(), appVersionBean.url);
                    }
                }
            }
        });
    }

    private void findPsw() {
        V3BusinessControllers.getInstance().getFindMachiniePWD(getLoginAccount(), UserInfoUtilControl.getInstance().getSchoolId(), new Listener<PswBean>() { // from class: client.android.yixiaotong.v3.ui.error.V3ErrorTipActivity.3
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                super.onStart(controller);
                BaseMaterialDialog.showMaterialDialog(V3ErrorTipActivity.this.getActivity(), "加载中.", false);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, PswBean pswBean, Object... objArr) {
                if (V3ErrorTipActivity.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    if (pswBean != null) {
                        if (pswBean.statusFlag == 0) {
                            ResetDevicePswActivity.launch(V3ErrorTipActivity.this.getActivity(), 0, "");
                            V3ErrorTipActivity.this.finish();
                        } else if (pswBean.statusFlag == 1) {
                            MachinePSWActivity.launch(V3ErrorTipActivity.this.getActivity(), pswBean.password);
                            V3ErrorTipActivity.this.finish();
                        } else if (pswBean.statusFlag == 2) {
                            ToastUtils.show(V3ErrorTipActivity.this.getContext(), "密码已停用");
                        }
                    }
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (V3ErrorTipActivity.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    ToastUtils.show(V3ErrorTipActivity.this.getActivity(), clientException.getDetail());
                }
            }
        });
    }
}
