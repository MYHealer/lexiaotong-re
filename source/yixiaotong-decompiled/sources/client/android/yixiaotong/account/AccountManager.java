package client.android.yixiaotong.account;

import android.content.SharedPreferences;
import android.text.TextUtils;
import client.android.yixiaotong.BaseApplication;
import client.android.yixiaotong.controller.store.ClientDataManager;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public class AccountManager {
    private Account mAccount;

    private static class SingletonHolder {
        public static final AccountManager INSTANCE = new AccountManager();

        private SingletonHolder() {
        }
    }

    public static AccountManager getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private AccountManager() {
    }

    public String getLastLoginAccountUserName() {
        return BaseApplication.app.getSharedPreferences("LastLoginAccount", 0).getString("LastLoginUserName", "");
    }

    public void saveLastLoginAccountUserName(String str) {
        BaseApplication.app.getSharedPreferences("LastLoginAccount", 0).edit().putString("LastLoginUserName", str).commit();
    }

    public Account getLoginAccount() {
        Account account;
        Account account2 = this.mAccount;
        if (account2 != null) {
            return account2;
        }
        SharedPreferences sharedPreferences = BaseApplication.app.getSharedPreferences("LoginAccount", 0);
        if (TextUtils.isEmpty(sharedPreferences.getString("user-key", ""))) {
            account = null;
        } else {
            try {
                account = (Account) getGson().fromJson(sharedPreferences.getString("user-data", ""), new TypeToken<Account>() { // from class: client.android.yixiaotong.account.AccountManager.1
                }.getType());
            } catch (Exception unused) {
                account = null;
            }
        }
        if (account == null) {
            return Account.newAccount(0L);
        }
        this.mAccount = account;
        return account;
    }

    public void saveLoginAccount(Account account) {
        if (account == null) {
            return;
        }
        SharedPreferences.Editor editorEdit = BaseApplication.app.getSharedPreferences("LoginAccount", 0).edit();
        editorEdit.putString("user-key", account.getUuid());
        editorEdit.putString("user-data", getGson().toJson(account));
        editorEdit.commit();
        this.mAccount = account;
    }

    public void clearLoginAccount() {
        this.mAccount = null;
        SharedPreferences.Editor editorEdit = BaseApplication.app.getSharedPreferences("LoginAccount", 0).edit();
        editorEdit.clear();
        editorEdit.commit();
        ClientDataManager.getInstance().del(ClientDataManager.LOGIN_PASSWORD);
    }

    private Gson getGson() {
        return new GsonBuilder().excludeFieldsWithoutExposeAnnotation().serializeNulls().setPrettyPrinting().create();
    }
}
