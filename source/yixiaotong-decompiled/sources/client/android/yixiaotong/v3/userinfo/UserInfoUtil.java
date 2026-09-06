package client.android.yixiaotong.v3.userinfo;

import android.content.SharedPreferences;
import client.android.yixiaotong.BaseApplication;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.v3.bean.login.LoginSeccessBean;
import client.android.yixiaotong.v3.bean.login.SchoolInfosBean;
import client.android.yixiaotong.v3.bean.login.UserInfoBean;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class UserInfoUtil {
    private static final String TAG = "UserInfoUtil";

    private static class SingletonHolder {
        public static final UserInfoUtil INSTANCE = new UserInfoUtil();

        private SingletonHolder() {
        }
    }

    public static UserInfoUtil getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private UserInfoUtil() {
    }

    public UserInfo getLoginAccountV3() {
        SharedPreferences sharedPreferences = BaseApplication.app.getSharedPreferences("LoginAccountV3", 0);
        if (StringUtils.isNotEmpty(sharedPreferences.getString("user-key", ""))) {
            try {
                return (UserInfo) getGson().fromJson(sharedPreferences.getString("user-data", ""), new TypeToken<UserInfo>() { // from class: client.android.yixiaotong.v3.userinfo.UserInfoUtil.1
                }.getType());
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public void saveStudentIdV3(LoginSeccessBean loginSeccessBean) {
        if (loginSeccessBean == null) {
            return;
        }
        SharedPreferences.Editor editorEdit = BaseApplication.app.getSharedPreferences("LoginAccountV3", 0).edit();
        editorEdit.putString("user-key", loginSeccessBean.studentId);
        UserInfo userInfo = new UserInfo();
        userInfo.studentId = loginSeccessBean.studentId;
        editorEdit.putString("user-data", getGson().toJson(userInfo));
        editorEdit.commit();
    }

    public void saveUserInfoV3(UserInfoBean userInfoBean) {
        if (userInfoBean == null) {
            return;
        }
        SharedPreferences.Editor editorEdit = BaseApplication.app.getSharedPreferences("LoginAccountV3", 0).edit();
        UserInfo loginAccountV3 = getLoginAccountV3();
        loginAccountV3.studentGender = userInfoBean.studentGender;
        loginAccountV3.studentHex = userInfoBean.studentHex;
        loginAccountV3.studentIdentity = userInfoBean.studentIdentity;
        loginAccountV3.studentMobile = userInfoBean.studentMobile;
        loginAccountV3.studentName = userInfoBean.studentName;
        editorEdit.putString("user-data", getGson().toJson(loginAccountV3));
        editorEdit.commit();
    }

    public void saveSchoolIdV3(List<String> list) {
        if (list == null) {
            return;
        }
        SharedPreferences.Editor editorEdit = BaseApplication.app.getSharedPreferences("LoginAccountV3", 0).edit();
        UserInfo loginAccountV3 = getLoginAccountV3();
        if (list != null && list.size() != 0) {
            loginAccountV3.schoolList = list;
        }
        editorEdit.putString("user-data", getGson().toJson(loginAccountV3));
        editorEdit.commit();
    }

    public void saveSchoolInfosV3(List<SchoolInfosBean> list) {
        if (list == null) {
            return;
        }
        SharedPreferences.Editor editorEdit = BaseApplication.app.getSharedPreferences("LoginAccountV3", 0).edit();
        UserInfo loginAccountV3 = getLoginAccountV3();
        loginAccountV3.schoolInfoList = list;
        editorEdit.putString("user-data", getGson().toJson(loginAccountV3));
        editorEdit.commit();
    }

    public int getSchoolInfosIndex() {
        return BaseApplication.app.getSharedPreferences("LoginAccountV3", 0).getInt("schoolinfoindex", 0);
    }

    public void saveSchoolInfosIndex(int i) {
        SharedPreferences.Editor editorEdit = BaseApplication.app.getSharedPreferences("LoginAccountV3", 0).edit();
        editorEdit.putInt("schoolinfoindex", i);
        editorEdit.commit();
        UserInfoUtilControl.getInstance().setSchoolId();
    }

    public String getBindSchoolId() {
        return BaseApplication.app.getSharedPreferences("LoginAccountV3", 0).getString("bindschoolid", "");
    }

    public void saveBindSchoolId(String str) {
        SharedPreferences.Editor editorEdit = BaseApplication.app.getSharedPreferences("LoginAccountV3", 0).edit();
        editorEdit.putString("bindschoolid", str);
        editorEdit.commit();
    }

    public void clearLoginAccount() {
        SharedPreferences.Editor editorEdit = BaseApplication.app.getSharedPreferences("LoginAccountV3", 0).edit();
        editorEdit.clear();
        editorEdit.commit();
    }

    private Gson getGson() {
        return new GsonBuilder().excludeFieldsWithoutExposeAnnotation().serializeNulls().setPrettyPrinting().create();
    }
}
