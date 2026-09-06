package client.android.yixiaotong.account;

import android.content.Context;
import client.android.yixiaotong.controller.bean.UserInfoBean;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.util.GsonUtils;
import client.android.yixiaotong.util.android.LocalPreferencesHelper;
import com.google.gson.reflect.TypeToken;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public class AccountDataManager extends LocalPreferencesHelper {
    public static final String KEY_BALANCE = "key_balance";
    private final String KEY_USER_INFO;

    public AccountDataManager(Context context, String str) {
        super(context, str);
        this.KEY_USER_INFO = "_user_info";
    }

    public void saveUserInfo(UserInfoBean userInfoBean) throws ClientException {
        if (userInfoBean == null) {
            return;
        }
        try {
            saveOrUpdate("_user_info", GsonUtils.getInstance().parse(userInfoBean));
        } catch (ClientException e) {
            e.printStackTrace();
            throw new ClientException(-1001, "保存个人资料");
        }
    }

    public void updateUserInfo(UserInfoBean userInfoBean) throws ClientException {
        if (userInfoBean == null) {
            return;
        }
        try {
            UserInfoBean userInfoBean2 = (UserInfoBean) GsonUtils.getInstance().parse(new TypeToken<UserInfoBean>() { // from class: client.android.yixiaotong.account.AccountDataManager.1
            }.getType(), getString("_user_info"));
            if (userInfoBean2 != null) {
                userInfoBean.UserType = userInfoBean2.UserType;
                userInfoBean.Token = userInfoBean2.Token;
            }
            saveOrUpdate("_user_info", GsonUtils.getInstance().parse(userInfoBean));
        } catch (ClientException e) {
            e.printStackTrace();
            throw new ClientException(-1001, "保存个人资料");
        }
    }

    public UserInfoBean getUserInfo() {
        try {
            return (UserInfoBean) GsonUtils.getInstance().parse(new TypeToken<UserInfoBean>() { // from class: client.android.yixiaotong.account.AccountDataManager.2
            }.getType(), getString("_user_info"));
        } catch (ClientException unused) {
            return null;
        }
    }

    public void clearUserInfo() {
        del("_user_info");
    }

    public void saveRelationWallet(String str, long j) throws ClientException {
        saveOrUpdate("bluetooth_" + str, j);
    }

    public long getRelationWalletID(String str) {
        return getLong("bluetooth_" + str);
    }
}
