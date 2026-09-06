package client.android.yixiaotong.v3.ui.control;

import android.app.Activity;
import client.android.yixiaotong.account.Account;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.ui.dialog.UpdateAppDialog;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.update.UpdateAppUtil;
import client.android.yixiaotong.v3.bean.user.AppVersionBean;
import client.android.yixiaotong.v3.http.V3BusinessControllers;
import client.android.yixiaotong.v3.userinfo.InvestorInfoUtilControl;
import client.android.yixiaotong.v3.userinfo.UserInfoUtilControl;
import client.android.yixiaotong.v3.util.LocalDataUtil;
import client.android.yixiaotong.v3.util.LogUtil;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class AppUpdateControlUtil {
    private static final String TAG = "AppUpdateControlUtil";
    private Account mAccount;
    private Activity mActivity;
    private AppVersionBean mAppVersionBean;
    private boolean mIsEnable;
    private String mTitleContent;

    public void init(Account account, Activity activity, String str) {
        this.mAccount = account;
        this.mActivity = activity;
        this.mTitleContent = str;
    }

    public void onResume() {
        this.mIsEnable = true;
    }

    private AppUpdateControlUtil() {
        this.mIsEnable = true;
    }

    private static final class SigleHolder {
        public static final AppUpdateControlUtil INSTANCE = new AppUpdateControlUtil();

        private SigleHolder() {
        }
    }

    public static AppUpdateControlUtil getInstance() {
        return SigleHolder.INSTANCE;
    }

    public void onPause() {
        this.mIsEnable = false;
        UpdateAppDialog.getInstance().dismiss(this.mActivity);
    }

    public void getVerSion() {
        LogUtil.e(TAG, "getAppVerInfo:" + LocalDataUtil.getIsNeedLoadVersion(this.mActivity));
        if (LocalDataUtil.getIsNeedLoadVersion(this.mActivity) == 0) {
            String schoolId = UserInfoUtilControl.getInstance().getSchoolId();
            String investorId = InvestorInfoUtilControl.getInstance().getInvestorId();
            LocalDataUtil.saveAppUpdateUrl(this.mActivity, "");
            V3BusinessControllers.getInstance().getAppVerInfo(this.mAccount, schoolId, investorId, new Listener<AppVersionBean>() { // from class: client.android.yixiaotong.v3.ui.control.AppUpdateControlUtil.1
                @Override // client.android.yixiaotong.controller.core.Listener
                public void onComplete(Controller controller, AppVersionBean appVersionBean, Object... objArr) {
                    if (AppUpdateControlUtil.this.mIsEnable) {
                        if (StringUtils.isNotEmpty(appVersionBean.url)) {
                            LocalDataUtil.saveAppUpdateUrl(AppUpdateControlUtil.this.mActivity, appVersionBean.url);
                        }
                        LocalDataUtil.saveIsNeedLoadVersion(AppUpdateControlUtil.this.mActivity, 2);
                        LogUtil.e(AppUpdateControlUtil.TAG, "getAppVerInfo:" + appVersionBean.ver + "  " + appVersionBean.status);
                        if (StringUtils.isNotEmpty(appVersionBean.ver)) {
                            AppUpdateControlUtil.this.mAppVersionBean = appVersionBean;
                            LocalDataUtil.saveAppVer(AppUpdateControlUtil.this.mActivity, appVersionBean.ver);
                            AppUpdateControlUtil.this.mustUpdateTip();
                        }
                    }
                }
            });
            return;
        }
        mustUpdateTip();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mustUpdateTip() {
        LogUtil.e(TAG, "mustUpdateTip:");
        AppVersionBean appVersionBean = this.mAppVersionBean;
        if (appVersionBean == null || appVersionBean.status != 2) {
            return;
        }
        LogUtil.e(TAG, "mustUpdateTip:" + this.mAppVersionBean.status);
        new UpdateAppUtil().showMustUpdateApkDialog(this.mActivity, this.mAppVersionBean.msg);
    }

    public void updateTip() {
        LogUtil.e(TAG, "updateTip:");
        AppVersionBean appVersionBean = this.mAppVersionBean;
        if (appVersionBean != null) {
            if (appVersionBean.status == 1) {
                new UpdateAppUtil().showMustUpdateApkDialog(this.mActivity, this.mAppVersionBean.msg, false, false);
            } else if (this.mAppVersionBean.status == 2) {
                new UpdateAppUtil().showMustUpdateApkDialog(this.mActivity, this.mAppVersionBean.msg);
            }
        }
    }
}
