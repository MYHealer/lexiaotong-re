package client.android.yixiaotong.v4.util;

import android.app.Activity;
import client.android.yixiaotong.account.Account;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.ui.dialog.UpdateAppDialog;
import client.android.yixiaotong.util.AppUtils;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.v3.util.LogUtil;
import client.android.yixiaotong.v4.http.V4BusinessControllers;
import client.android.yixiaotong.v4.http.bean.V4VersionInfoBean;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class V4AppUpdateControlUtil {
    private static final String TAG = "V4AppUpdateControlUtil";
    private Account mAccount;
    private Activity mActivity;
    private V4VersionInfoBean mAppVersionBean;
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

    private V4AppUpdateControlUtil() {
        this.mIsEnable = true;
    }

    private static final class SigleHolder {
        public static final V4AppUpdateControlUtil INSTANCE = new V4AppUpdateControlUtil();

        private SigleHolder() {
        }
    }

    public static V4AppUpdateControlUtil getInstance() {
        return SigleHolder.INSTANCE;
    }

    public void onPause() {
        this.mIsEnable = false;
        UpdateAppDialog.getInstance().dismiss(this.mActivity);
    }

    public void getVerSion() {
        LogUtil.e(TAG, "getAppVerInfo:" + V4LocalDataUtil.getIsNeedLoadVersion(this.mActivity));
        if (V4LocalDataUtil.getIsNeedLoadVersion(this.mActivity) == 0) {
            String version = AppUtils.getVersion(this.mActivity);
            V4LocalDataUtil.saveAppUpdateUrl(this.mActivity, "");
            V4BusinessControllers.getInstance().getAppVersionInfo(this.mAccount, version, new Listener<V4VersionInfoBean>() { // from class: client.android.yixiaotong.v4.util.V4AppUpdateControlUtil.1
                @Override // client.android.yixiaotong.controller.core.Listener
                public void onComplete(Controller controller, V4VersionInfoBean v4VersionInfoBean, Object... objArr) {
                    if (V4AppUpdateControlUtil.this.mIsEnable) {
                        if (StringUtils.isNotEmpty(v4VersionInfoBean.url)) {
                            V4LocalDataUtil.saveAppUpdateUrl(V4AppUpdateControlUtil.this.mActivity, v4VersionInfoBean.url);
                        }
                        V4LocalDataUtil.saveIsNeedLoadVersion(V4AppUpdateControlUtil.this.mActivity, 2);
                        LogUtil.e(V4AppUpdateControlUtil.TAG, "getAppVerInfo:" + v4VersionInfoBean.ver + "  " + v4VersionInfoBean.status);
                        if (StringUtils.isNotEmpty(v4VersionInfoBean.ver)) {
                            V4AppUpdateControlUtil.this.mAppVersionBean = v4VersionInfoBean;
                            V4LocalDataUtil.saveAppVer(V4AppUpdateControlUtil.this.mActivity, v4VersionInfoBean.ver);
                            V4AppUpdateControlUtil.this.mustUpdateTip();
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
        V4VersionInfoBean v4VersionInfoBean = this.mAppVersionBean;
        if (v4VersionInfoBean == null || v4VersionInfoBean.status != 2) {
            return;
        }
        LogUtil.e(TAG, "mustUpdateTip:" + this.mAppVersionBean.status);
        new V4UpdateAppUtil().showMustUpdateApkDialog(this.mActivity, this.mAppVersionBean.msg);
    }

    public void updateTip() {
        LogUtil.e(TAG, "updateTip:");
        V4VersionInfoBean v4VersionInfoBean = this.mAppVersionBean;
        if (v4VersionInfoBean != null) {
            if (v4VersionInfoBean.status == 1) {
                new V4UpdateAppUtil().showMustUpdateApkDialog(this.mActivity, this.mAppVersionBean.msg, false, false);
            } else if (this.mAppVersionBean.status == 2) {
                new V4UpdateAppUtil().showMustUpdateApkDialog(this.mActivity, this.mAppVersionBean.msg);
            }
        }
    }
}
