package client.android.yixiaotong.v3.userinfo;

import android.content.SharedPreferences;
import client.android.yixiaotong.BaseApplication;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.util.GsonUtils;
import client.android.yixiaotong.v3.bean.wallet.WalletInfoBean;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class WalletInfoUtil {

    private static class SingletonHolder {
        public static final WalletInfoUtil INSTANCE = new WalletInfoUtil();

        private SingletonHolder() {
        }
    }

    public static WalletInfoUtil getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private WalletInfoUtil() {
    }

    public WalletInfoBean getWalletInfoV3() {
        try {
            return (WalletInfoBean) getGson().fromJson(BaseApplication.app.getSharedPreferences("walletinfoV3" + UserInfoUtilControl.getInstance().getSchoolId(), 0).getString("user-data", ""), new TypeToken<WalletInfoBean>() { // from class: client.android.yixiaotong.v3.userinfo.WalletInfoUtil.1
            }.getType());
        } catch (Exception unused) {
            return null;
        }
    }

    public void saveWalletInfoV3(WalletInfoBean walletInfoBean) {
        if (walletInfoBean == null) {
            return;
        }
        SharedPreferences.Editor editorEdit = BaseApplication.app.getSharedPreferences("walletinfoV3" + UserInfoUtilControl.getInstance().getSchoolId(), 0).edit();
        editorEdit.putString("user-data", getGson().toJson(walletInfoBean));
        editorEdit.commit();
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
