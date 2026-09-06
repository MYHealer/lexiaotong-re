package client.android.yixiaotong.controller.store;

import android.content.Context;
import client.android.yixiaotong.BaseApplication;
import client.android.yixiaotong.util.android.LocalPreferencesHelper;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public class ClientDataManager extends LocalPreferencesHelper {
    public static final String CHECK_PASSWORD = "check_password";
    public static final String LOGIN_ACCOUNT = "login_account";
    public static final String LOGIN_PASSWORD = "login_password";
    public static final String MESSAGE_REMIND = "_message_remind";
    public static final String MESSAGE_SOUND = "_message_sound";
    public static final String MESSAGE_VIBRATE = "_message_vibrate";
    private static ClientDataManager mClientDataManager;

    private ClientDataManager(Context context, String str) {
        super(context, str);
    }

    public static ClientDataManager getInstance() {
        if (mClientDataManager == null) {
            mClientDataManager = new ClientDataManager(BaseApplication.app, "client_data");
        }
        return mClientDataManager;
    }
}
