package client.android.yixiaotong.v3.userinfo;

import android.content.SharedPreferences;
import client.android.yixiaotong.BaseApplication;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.util.GsonUtils;
import client.android.yixiaotong.v3.bean.login.InvestorInfosBean;
import client.android.yixiaotong.v3.util.LogUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class InvestorInfoUtil {
    private static final String TAG = "InvestorInfoUtil";

    private static class SingletonHolder {
        public static final InvestorInfoUtil INSTANCE = new InvestorInfoUtil();

        private SingletonHolder() {
        }
    }

    public static InvestorInfoUtil getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private InvestorInfoUtil() {
    }

    public List<InvestorInfosBean> getInvestorInfosV3() {
        SharedPreferences sharedPreferences = BaseApplication.app.getSharedPreferences("investorinfoV3", 0);
        try {
            return (List) getGson().fromJson(sharedPreferences.getString("user-data", ""), new TypeToken<List<InvestorInfosBean>>() { // from class: client.android.yixiaotong.v3.userinfo.InvestorInfoUtil.1
            }.getType());
        } catch (Exception unused) {
            return new ArrayList();
        }
    }

    public void saveInvestorInfosV3(List<InvestorInfosBean> list) {
        SharedPreferences.Editor editorEdit = BaseApplication.app.getSharedPreferences("investorinfoV3", 0).edit();
        if (list != null && list.size() > 0) {
            editorEdit.putString("user-data", getGson().toJson(list));
        } else {
            editorEdit.putString("user-data", "");
        }
        editorEdit.commit();
    }

    public int getInvestorInfosIndex() {
        int i = BaseApplication.app.getSharedPreferences("investorinfoV3", 0).getInt("investorindex", 0);
        LogUtil.e(TAG, "getInvestorInfosIndex:" + i);
        return i;
    }

    public void saveInvestorInfosIndex(int i) {
        LogUtil.e(TAG, "saveInvestorInfosIndex:" + i);
        SharedPreferences.Editor editorEdit = BaseApplication.app.getSharedPreferences("investorinfoV3", 0).edit();
        editorEdit.putInt("investorindex", i);
        editorEdit.commit();
        InvestorInfoUtilControl.getInstance().setInvestorId();
    }

    private Gson getGson() {
        return new GsonBuilder().serializeNulls().setPrettyPrinting().create();
    }

    private String obJectToString(Object obj) {
        try {
            return GsonUtils.getInstance().parse(obj);
        } catch (ClientException e) {
            e.printStackTrace();
            return null;
        }
    }
}
