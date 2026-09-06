package client.android.yixiaotong.account;

import android.content.SharedPreferences;
import client.android.yixiaotong.BaseApplication;
import client.android.yixiaotong.controller.bean.ManagerAppBean;
import client.android.yixiaotong.controller.bean.ManagerBean;
import client.android.yixiaotong.util.StringUtils;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public class AppAccountManager {
    private static final String manager1 = "123001";
    private static final String manager10 = "666888001";
    private static final String manager2 = "123002";
    private static final String manager3 = "123003";
    private static final String manager4 = "123004";
    private static final String manager5 = "123005";
    private static final String manager6 = "123006";
    private static final String manager7 = "123007";
    private static final String manager8 = "123008";
    private static final String manager9 = "123009";
    private boolean isSaveAppAccount;

    /* JADX INFO: renamed from: client.android.yixiaotong.account.AppAccountManager$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public boolean isSaveAppAccount() {
        return this.isSaveAppAccount;
    }

    /* synthetic */ AppAccountManager(AnonymousClass1 anonymousClass1) {
        this();
    }

    private AppAccountManager() {
        this.isSaveAppAccount = false;
    }

    private static class SingletonHolder {
        public static final AppAccountManager INSTANCE = new AppAccountManager(null);

        private SingletonHolder() {
        }
    }

    public static AppAccountManager getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public int getAppManagerAccount(int i) {
        return BaseApplication.app.getSharedPreferences("AppManagerAccount", 0).getInt("appuser-key" + i, 0);
    }

    public void initAppAccount() {
        SharedPreferences.Editor editorEdit = BaseApplication.app.getSharedPreferences("AppManagerAccount", 0).edit();
        for (int i = 0; i <= 19; i++) {
            editorEdit.putInt("appuser-key" + i, 0);
        }
        editorEdit.commit();
    }

    public void saveAppAccount(ManagerBean managerBean) {
        if (managerBean == null) {
            return;
        }
        List<ManagerAppBean> sortList = managerBean.getSortList();
        SharedPreferences.Editor editorEdit = BaseApplication.app.getSharedPreferences("AppManagerAccount", 0).edit();
        for (int i = 0; i <= 11; i++) {
            editorEdit.putInt("appuser-key" + i, 0);
        }
        for (int i2 = 0; i2 < sortList.size(); i2++) {
            editorEdit.putInt("appuser-key" + sortList.get(i2).id, sortList.get(i2).id);
        }
        this.isSaveAppAccount = true;
        editorEdit.commit();
    }

    public boolean isYinShuiManager(String str) {
        if (StringUtils.isNotEmpty(str)) {
            return manager1.equals(str) || manager2.equals(str) || manager3.equals(str) || manager4.equals(str) || manager5.equals(str) || manager6.equals(str) || manager7.equals(str) || manager8.equals(str) || manager9.equals(str) || manager10.equals(str);
        }
        return false;
    }
}
