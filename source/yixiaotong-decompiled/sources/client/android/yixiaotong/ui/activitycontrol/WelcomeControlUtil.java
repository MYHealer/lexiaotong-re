package client.android.yixiaotong.ui.activitycontrol;

import android.app.Activity;
import client.android.yixiaotong.account.Account;
import client.android.yixiaotong.controller.bean.SuccessBean;
import client.android.yixiaotong.controller.bean.UserInfoBean;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.controller.store.LocalBusinessStore;
import client.android.yixiaotong.util.AppUtils;
import client.android.yixiaotong.util.TimeUtils;
import client.android.yixiaotong.v3.bean.user.UserCommon;
import client.android.yixiaotong.v3.bean.user.UserPage;
import client.android.yixiaotong.v3.http.V3BusinessControllers;
import client.android.yixiaotong.v3.userinfo.UserInfo;
import client.android.yixiaotong.v3.userinfo.UserInfoUtil;
import client.android.yixiaotong.v3.userinfo.UserInfoUtilControl;
import client.android.yixiaotong.v3.util.LocalDataUtil;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public class WelcomeControlUtil {
    private Account mAccount;
    private Activity mActivity;
    private boolean mIsEnable;

    public void init(Account account, Activity activity) {
        this.mAccount = account;
        this.mActivity = activity;
    }

    public void onPause() {
        this.mIsEnable = false;
    }

    public void onResume() {
        this.mIsEnable = true;
    }

    private WelcomeControlUtil() {
        this.mIsEnable = true;
    }

    private static final class SingleHolder {
        public static final WelcomeControlUtil Instance = new WelcomeControlUtil();

        private SingleHolder() {
        }
    }

    public static WelcomeControlUtil getInstance() {
        return SingleHolder.Instance;
    }

    public void userActiveInfo(Account account, Activity activity) {
        if (LocalDataUtil.getPlatformInfo(activity) != 4 && LocalBusinessStore.getLoginLicenseTip(activity)) {
            this.mAccount = account;
            this.mActivity = activity;
            String uUid = AppUtils.getUUid(activity);
            UserCommon userCommon = new UserCommon();
            userCommon.identification = uUid;
            userCommon.ipAddress = AppUtils.getPhoneIPAddress();
            userCommon.deviceId = uUid;
            userCommon.mobileModel = AppUtils.getSystemModel();
            userCommon.clientVersion = AppUtils.getVersion(activity);
            userCommon.mobileSystem = AppUtils.getDeviceBrand();
            userCommon.mobileSystemVersion = AppUtils.getSystemVersion();
            userCommon.clientType = "1";
            if (LocalDataUtil.getPlatformInfo(activity) == 1) {
                userCommon.premiseId = UserInfoUtilControl.getInstance().getSchoolId();
                UserInfo loginAccountV3 = UserInfoUtil.getInstance().getLoginAccountV3();
                if (loginAccountV3 != null) {
                    userCommon.userId = loginAccountV3.studentId;
                }
            } else {
                UserInfoBean userInfo = account.getAccountManagetStore().getUserInfo();
                if (userInfo != null) {
                    userCommon.premiseId = userInfo.AreaId + "";
                    userCommon.userId = userInfo.ID + "";
                }
            }
            UserPage userPage = new UserPage();
            userPage.accessTime = TimeUtils.formatDateTime(System.currentTimeMillis());
            userPage.id = "0";
            if (activity.getLocalClassName().contains("MainActivity")) {
                userPage.id = "1";
            }
            V3BusinessControllers.getInstance().postUserActiveInfo(this.mAccount, userCommon, userPage, new Listener<SuccessBean>() { // from class: client.android.yixiaotong.ui.activitycontrol.WelcomeControlUtil.1
            });
        }
    }
}
