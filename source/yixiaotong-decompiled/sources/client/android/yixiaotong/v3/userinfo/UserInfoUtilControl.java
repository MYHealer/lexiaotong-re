package client.android.yixiaotong.v3.userinfo;

import client.android.yixiaotong.v3.bean.login.SchoolInfosBean;
import client.android.yixiaotong.v3.util.LogUtil;
import com.huawei.openalliance.ad.views.PPSLabelView;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class UserInfoUtilControl {
    private static final String TAG = "UserInfoUtilControl";
    private String mSchoolId;
    private String mSchoolName;
    private String mStudentId;

    /* JADX INFO: renamed from: client.android.yixiaotong.v3.userinfo.UserInfoUtilControl$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public void setSchoolId() {
        this.mSchoolId = "";
        this.mSchoolName = "";
        this.mStudentId = "";
    }

    /* synthetic */ UserInfoUtilControl(AnonymousClass1 anonymousClass1) {
        this();
    }

    private static class SingletonHolder {
        public static final UserInfoUtilControl INSTANCE = new UserInfoUtilControl(null);

        private SingletonHolder() {
        }
    }

    public static UserInfoUtilControl getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private UserInfoUtilControl() {
    }

    public SchoolInfosBean getSchoolInfo() {
        List<SchoolInfosBean> list;
        int schoolInfosIndex = UserInfoUtil.getInstance().getSchoolInfosIndex();
        UserInfo loginAccountV3 = UserInfoUtil.getInstance().getLoginAccountV3();
        if (loginAccountV3 != null && (list = loginAccountV3.schoolInfoList) != null && list.size() > 0 && list.size() > schoolInfosIndex) {
            return list.get(schoolInfosIndex);
        }
        return null;
    }

    public String getSchoolId() {
        int schoolInfosIndex = UserInfoUtil.getInstance().getSchoolInfosIndex();
        UserInfo loginAccountV3 = UserInfoUtil.getInstance().getLoginAccountV3();
        if (loginAccountV3 == null) {
            return "";
        }
        List<SchoolInfosBean> list = loginAccountV3.schoolInfoList;
        LogUtil.e(TAG, "getSchoolId:" + (list != null) + PPSLabelView.Code + schoolInfosIndex);
        if (list != null) {
            LogUtil.e(TAG, "getSchoolId:" + (list != null) + PPSLabelView.Code + list.size() + PPSLabelView.Code + schoolInfosIndex);
        }
        if (list == null || list.size() <= 0 || list.size() <= schoolInfosIndex || list.get(schoolInfosIndex) == null) {
            return "";
        }
        LogUtil.e(TAG, "getSchoolId");
        String str = list.get(schoolInfosIndex).id + "";
        this.mSchoolId = str;
        return str;
    }

    public String getSchoolIds() {
        List<String> list;
        UserInfo loginAccountV3 = UserInfoUtil.getInstance().getLoginAccountV3();
        if (loginAccountV3 == null || (list = loginAccountV3.schoolList) == null || list.size() <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i) + ",");
        }
        return sb.substring(0, sb.length() - 1);
    }

    public String getSchoolName() {
        List<SchoolInfosBean> list;
        int schoolInfosIndex = UserInfoUtil.getInstance().getSchoolInfosIndex();
        UserInfo loginAccountV3 = UserInfoUtil.getInstance().getLoginAccountV3();
        if (loginAccountV3 == null || (list = loginAccountV3.schoolInfoList) == null || list.size() <= 0 || list.size() <= schoolInfosIndex || list.get(schoolInfosIndex) == null) {
            return "";
        }
        String str = list.get(schoolInfosIndex).schoolName;
        this.mSchoolName = str;
        return str;
    }

    public String getStudentId() {
        UserInfo loginAccountV3 = UserInfoUtil.getInstance().getLoginAccountV3();
        String str = loginAccountV3 != null ? loginAccountV3.studentId : null;
        this.mStudentId = str;
        return str;
    }
}
