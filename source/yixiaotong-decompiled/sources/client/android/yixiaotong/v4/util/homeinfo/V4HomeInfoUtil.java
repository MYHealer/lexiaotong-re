package client.android.yixiaotong.v4.util.homeinfo;

import android.app.Activity;
import android.content.SharedPreferences;
import client.android.yixiaotong.BaseApplication;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.v3.util.LogUtil;
import client.android.yixiaotong.v4.http.bean.V4HomeFunBean;
import client.android.yixiaotong.v4.http.bean.V4HomeInfoBean;
import client.android.yixiaotong.v4.http.bean.V4HomePageInfoBean;
import client.android.yixiaotong.v4.util.projectconfig.V4ProjectConfigInfoUtil;
import client.android.yixiaotong.v4.util.projectconfig.V4ProjectInfoBean;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class V4HomeInfoUtil {
    private static final String TAG = "V4HomeInfoUtil";
    private V4HomeInfoBean mV4HomeInfoBean;

    private static class SingletonHolder {
        public static final V4HomeInfoUtil INSTANCE = new V4HomeInfoUtil();

        private SingletonHolder() {
        }
    }

    public static V4HomeInfoUtil getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private V4HomeInfoUtil() {
    }

    public V4HomeInfoBean getHomeInfoV4() {
        SharedPreferences sharedPreferences = BaseApplication.app.getSharedPreferences("homeinfov4", 0);
        try {
            return (V4HomeInfoBean) getGson().fromJson(sharedPreferences.getString("user-data", ""), new TypeToken<V4HomeInfoBean>() { // from class: client.android.yixiaotong.v4.util.homeinfo.V4HomeInfoUtil.1
            }.getType());
        } catch (Exception unused) {
            return new V4HomeInfoBean();
        }
    }

    public void saveHomeInfoV4(V4HomeInfoBean v4HomeInfoBean) {
        this.mV4HomeInfoBean = null;
        SharedPreferences.Editor editorEdit = BaseApplication.app.getSharedPreferences("homeinfov4", 0).edit();
        if (v4HomeInfoBean != null) {
            editorEdit.putString("user-data", getGson().toJson(v4HomeInfoBean));
        } else {
            editorEdit.putString("user-data", "");
        }
        editorEdit.commit();
    }

    public boolean isOpenAdv() {
        if (this.mV4HomeInfoBean == null) {
            this.mV4HomeInfoBean = getHomeInfoV4();
        }
        V4HomeInfoBean v4HomeInfoBean = this.mV4HomeInfoBean;
        if (v4HomeInfoBean != null) {
            return v4HomeInfoBean.openAd;
        }
        return false;
    }

    public boolean is4GPriority() {
        String str;
        LogUtil.e(TAG, "is4GPriority start");
        if (this.mV4HomeInfoBean == null) {
            this.mV4HomeInfoBean = getHomeInfoV4();
        }
        V4HomeInfoBean v4HomeInfoBean = this.mV4HomeInfoBean;
        if (v4HomeInfoBean == null || v4HomeInfoBean.customerPageDefList == null) {
            return true;
        }
        List<V4HomePageInfoBean> list = this.mV4HomeInfoBean.customerPageDefList;
        List<V4HomeFunBean> arrayList = new ArrayList();
        if (list != null && list.size() > 0) {
            for (V4HomePageInfoBean v4HomePageInfoBean : list) {
                if (v4HomePageInfoBean.pageKey.equalsIgnoreCase("Priority")) {
                    arrayList = v4HomePageInfoBean.funList;
                    break;
                }
            }
        }
        if (arrayList == null || arrayList.size() <= 0) {
            str = "1";
        } else {
            for (V4HomeFunBean v4HomeFunBean : arrayList) {
                if (v4HomeFunBean.funKey.equalsIgnoreCase("Priority_4G") && StringUtils.isNotEmpty(v4HomeFunBean.funEnable)) {
                    str = v4HomeFunBean.funEnable;
                }
            }
            str = "1";
        }
        LogUtil.e(TAG, "is4GPriority end:" + str);
        return !str.equals("0");
    }

    private Gson getGson() {
        return new GsonBuilder().serializeNulls().setPrettyPrinting().create();
    }

    public List<V4HomeInfoBean> getAppList(Activity activity) {
        ArrayList arrayList = new ArrayList();
        V4ProjectInfoBean projectInfoV4 = V4ProjectConfigInfoUtil.getInstance().getProjectInfoV4();
        if (projectInfoV4 != null && projectInfoV4.productTypeToArray != null) {
            for (int i = 0; i < projectInfoV4.productTypeToArray.size(); i++) {
                V4HomeInfoBean v4HomeInfoBean = new V4HomeInfoBean();
                v4HomeInfoBean.appName = V4TypeIDSetUtil.getAppName(activity, projectInfoV4.productTypeToArray.get(i).intValue());
                v4HomeInfoBean.productId = projectInfoV4.productTypeToArray.get(i).intValue();
                arrayList.add(v4HomeInfoBean);
            }
        }
        return arrayList;
    }
}
