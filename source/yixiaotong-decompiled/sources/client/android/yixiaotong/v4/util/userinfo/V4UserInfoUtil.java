package client.android.yixiaotong.v4.util.userinfo;

import android.content.SharedPreferences;
import client.android.yixiaotong.BaseApplication;
import client.android.yixiaotong.v3.util.LogUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class V4UserInfoUtil {
    private static final String TAG = "V4UserInfoUtil";

    private static class SingletonHolder {
        public static final V4UserInfoUtil INSTANCE = new V4UserInfoUtil();

        private SingletonHolder() {
        }
    }

    public static V4UserInfoUtil getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private V4UserInfoUtil() {
    }

    public V4UserInfoBean getLoginAccountV4() {
        try {
            return (V4UserInfoBean) getGson().fromJson(BaseApplication.app.getSharedPreferences("LoginAccountV4", 0).getString("user-data", ""), new TypeToken<V4UserInfoBean>() { // from class: client.android.yixiaotong.v4.util.userinfo.V4UserInfoUtil.1
            }.getType());
        } catch (Exception unused) {
            return null;
        }
    }

    public void saveUserInfoV4(V4UserInfoBean v4UserInfoBean) {
        if (v4UserInfoBean == null) {
            return;
        }
        SharedPreferences.Editor editorEdit = BaseApplication.app.getSharedPreferences("LoginAccountV4", 0).edit();
        String json = getGson().toJson(v4UserInfoBean);
        LogUtil.e(TAG, "saveUserInfoV4:" + json);
        editorEdit.putString("user-data", json);
        editorEdit.commit();
    }

    public void clearLoginAccount() {
        SharedPreferences.Editor editorEdit = BaseApplication.app.getSharedPreferences("LoginAccountV4", 0).edit();
        editorEdit.clear();
        editorEdit.commit();
    }

    private Gson getGson() {
        return new GsonBuilder().excludeFieldsWithoutExposeAnnotation().serializeNulls().setPrettyPrinting().create();
    }
}
