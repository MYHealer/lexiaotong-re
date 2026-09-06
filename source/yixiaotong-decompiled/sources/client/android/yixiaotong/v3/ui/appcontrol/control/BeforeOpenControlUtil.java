package client.android.yixiaotong.v3.ui.appcontrol.control;

import android.app.Activity;
import client.android.yixiaotong.account.Account;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.v3.bean.login.InvestorInfosBean;
import client.android.yixiaotong.v3.bean.login.InvestoridAndSchoolId;
import client.android.yixiaotong.v3.bean.login.SchoolInfosBean;
import client.android.yixiaotong.v3.http.V3BusinessControllers;
import client.android.yixiaotong.v3.ui.appcontrol.listener.OpenBeforeListener;
import client.android.yixiaotong.v3.userinfo.InvestorInfoUtil;
import client.android.yixiaotong.v3.userinfo.InvestorInfoUtilControl;
import client.android.yixiaotong.v3.userinfo.UserInfoUtil;
import client.android.yixiaotong.v3.userinfo.UserInfoUtilControl;
import client.android.yixiaotong.v3.util.LocalDataUtil;
import client.android.yixiaotong.v3.util.LogUtil;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class BeforeOpenControlUtil {
    private static final String TAG = "BeforeOpenControlUtil";
    private Account mAccount;
    private Activity mActivity;
    private boolean mIsEnable;
    private OpenBeforeListener mOpenBeforeListener;

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

    public void setListener(OpenBeforeListener openBeforeListener) {
        this.mOpenBeforeListener = openBeforeListener;
    }

    private BeforeOpenControlUtil() {
        this.mIsEnable = true;
    }

    private static final class SingleHolder {
        private static final BeforeOpenControlUtil INSTANCE = new BeforeOpenControlUtil();

        private SingleHolder() {
        }
    }

    public static BeforeOpenControlUtil getInstance() {
        return SingleHolder.INSTANCE;
    }

    public void getUseInfoByMachineId(String str, int i) {
        V3BusinessControllers.getInstance().getUseInfoByMachineId(this.mAccount, str, i, new Listener<InvestoridAndSchoolId>() { // from class: client.android.yixiaotong.v3.ui.appcontrol.control.BeforeOpenControlUtil.1
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, InvestoridAndSchoolId investoridAndSchoolId, Object... objArr) {
                if (BeforeOpenControlUtil.this.mIsEnable && StringUtils.isNotEmpty(investoridAndSchoolId.investorId) && StringUtils.isNotEmpty(investoridAndSchoolId.schoolId)) {
                    LogUtil.d(BeforeOpenControlUtil.TAG, investoridAndSchoolId.schoolId + "  " + UserInfoUtilControl.getInstance().getSchoolId());
                    LogUtil.d(BeforeOpenControlUtil.TAG, investoridAndSchoolId.investorId + "  " + InvestorInfoUtilControl.getInstance().getInvestorInfoBean().investorId);
                    if (!investoridAndSchoolId.schoolId.equals(UserInfoUtilControl.getInstance().getSchoolId())) {
                        List<SchoolInfosBean> list = UserInfoUtil.getInstance().getLoginAccountV3().schoolInfoList;
                        boolean z = false;
                        for (int i2 = 0; i2 < list.size(); i2++) {
                            if (list.get(i2).id == Long.parseLong(investoridAndSchoolId.schoolId)) {
                                UserInfoUtil.getInstance().saveSchoolInfosIndex(i2);
                                z = true;
                            }
                        }
                        if (z) {
                            InvestorInfoUtil.getInstance().saveInvestorInfosIndex(0);
                            LocalDataUtil.saveIsNeedLoadInvestorInfo(BeforeOpenControlUtil.this.mActivity, true);
                            BeforeOpenControlUtil.this.getInvestorInfo(investoridAndSchoolId.investorId);
                            return;
                        }
                        return;
                    }
                    if (investoridAndSchoolId.investorId.equals(InvestorInfoUtilControl.getInstance().getInvestorInfoBean().investorId)) {
                        return;
                    }
                    List<InvestorInfosBean> investorInfosV3 = InvestorInfoUtil.getInstance().getInvestorInfosV3();
                    for (int i3 = 0; i3 < investorInfosV3.size(); i3++) {
                        if (investorInfosV3.get(i3).investorInfo.investorId.equals(investoridAndSchoolId.investorId)) {
                            InvestorInfoUtil.getInstance().saveInvestorInfosIndex(i3);
                        }
                    }
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                boolean unused = BeforeOpenControlUtil.this.mIsEnable;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getInvestorInfo(final String str) {
        V3BusinessControllers.getInstance().getInvestorInfo(this.mAccount, new Listener<List<InvestorInfosBean>>() { // from class: client.android.yixiaotong.v3.ui.appcontrol.control.BeforeOpenControlUtil.2
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, List<InvestorInfosBean> list, Object... objArr) {
                if (BeforeOpenControlUtil.this.mIsEnable) {
                    List<InvestorInfosBean> investorInfosV3 = InvestorInfoUtil.getInstance().getInvestorInfosV3();
                    for (int i = 0; i < investorInfosV3.size(); i++) {
                        if (investorInfosV3.get(i).investorInfo.investorId.equals(str)) {
                            InvestorInfoUtil.getInstance().saveInvestorInfosIndex(i);
                        }
                    }
                }
            }
        });
    }
}
