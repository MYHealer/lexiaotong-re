package com.bytedance.android.livehostapi.platform;

import android.app.Activity;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public interface IHostTokenInjectionAuth {
    TokenInfo getTokenInfo();

    boolean isLogin();

    void onTokenInvalid(TokenInfo tokenInfo, TokenRefreshCallback tokenRefreshCallback, Activity activity, Map<String, String> map);
}
