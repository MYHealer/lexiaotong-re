package com.meishu.sdk.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.meishu.sdk.core.AdSdk;
import com.meishu.sdk.core.MSAdConfig;
import com.meishu.sdk.core.safe.SafeActivity;
import com.meishu.sdk.core.safe.l;
import com.meishu.sdk.core.service.d;
import com.meishu.sdk.core.service.e;
import com.meishu.sdk.core.utils.LogUtil;
import com.meishu.sdk.core.utils.SdkHandler;
import com.meishu.sdk.core.utils.f;
import com.meishu.sdk.core.utils.f1;
import com.meishu.sdk.core.utils.h0;
import com.meishu.sdk.core.utils.o0;
import com.meishu.sdk.core.utils.q0;
import com.meishu.sdk.core.utils.u1;
import com.meishu.sdk.core.utils.v1;
import com.stub.StubApp;
import java.net.URISyntaxException;
import java.security.MessageDigest;
import java.util.Arrays;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class MeishuOpenDeepLinkActivity extends SafeActivity {
    public static final String KEY_DEEP_LINK = "deep_link";
    public static final String KEY_DEEP_SIGN = "dp_sign";
    public static final String KEY_DEEP_START = "dp_start";
    public static final String KEY_DP_SIGN = "dp_d_sign";
    public static final int REQUEST_CODE_DEEP_LINK = 10010;
    private static final String TAG = "MeishuOpenDeepLinkActivity";
    private String DPSIGN;
    private String dpSign;
    private String[] dpStartUrls;
    private boolean hasAppBackground;
    private boolean isBackground = false;
    private boolean isInner = true;
    private final e onAppStateListener = new com.meishu.sdk.core.service.a() { // from class: com.meishu.sdk.activity.MeishuOpenDeepLinkActivity.2
        @Override // com.meishu.sdk.core.service.a, com.meishu.sdk.core.service.e
        public void onActivityPause(Activity activity) {
        }

        @Override // com.meishu.sdk.core.service.a, com.meishu.sdk.core.service.e
        public void onActivityResume(Activity activity) {
        }

        @Override // com.meishu.sdk.core.service.e
        public boolean onAppStateUpdate(boolean z) {
            if (z) {
                return false;
            }
            MeishuOpenDeepLinkActivity.this.hasAppBackground = true;
            return false;
        }
    };
    private Boolean openDeepLinkRes;

    static {
        StubApp.interface11(44735);
    }

    private void dpReport(int i) {
        String[] strArr = this.dpStartUrls;
        if (strArr == null || strArr.length <= 0) {
            return;
        }
        f.a(h0.b(strArr, i));
    }

    private void goOrigin(String str) {
        byte[] bArrDigest;
        try {
            if (TextUtils.isEmpty(this.dpSign)) {
                dpReport(4);
                jdl(str);
                return;
            }
            try {
                byte[] bArrA = f1.a(this.dpSign);
                if (bArrA != null && bArrA.length > 0) {
                    StringBuilder sbAppend = new StringBuilder().append(str);
                    AdSdk.adConfig();
                    try {
                        bArrDigest = MessageDigest.getInstance("SHA-256").digest(sbAppend.append(MSAdConfig.initUUID()).toString().getBytes("UTF-8"));
                    } catch (Exception unused) {
                        bArrDigest = null;
                    }
                    if (Arrays.equals(bArrA, bArrDigest)) {
                        dpReport(1);
                        startActivityForResult(u1.a(str, this), 10010);
                        return;
                    }
                }
                dpReport(2);
                startActivityForResult(u1.a(str, this), 10010);
            } catch (Throwable th) {
                th.printStackTrace();
                dpReport(3);
                jdl(str);
            }
        } catch (Throwable unused2) {
            o0.a(false);
            finish();
        }
    }

    private void handleSIGN(String str, String str2) {
        try {
            if (!TextUtils.isEmpty(str)) {
                String strA = v1.a(str, str2);
                if (TextUtils.isEmpty(strA)) {
                    goOrigin(str2);
                } else {
                    Intent uri = Intent.parseUri(strA, 0);
                    if (uri.resolveActivity(AdSdk.getContext().getPackageManager()) != null) {
                        dpReport(1);
                        startActivityForResult(uri, 10010);
                    } else {
                        goOrigin(str2);
                    }
                }
            }
        } catch (Throwable th) {
            goOrigin(str2);
            th.printStackTrace();
        }
    }

    private void jdl(String str) throws URISyntaxException {
        Intent uri = Intent.parseUri(str, 0);
        uri.addCategory("android.intent.category.BROWSABLE");
        uri.setComponent(null);
        uri.setSelector(null);
        uri.setFlags(268435456);
        if (q0.f != null) {
            f.a(str, uri);
        }
        startActivityForResult(uri, 10010);
    }

    private void jumpDeepLink(String str) {
        try {
            if (TextUtils.isEmpty(this.DPSIGN)) {
                goOrigin(str);
            } else {
                handleSIGN(this.DPSIGN, str);
            }
        } catch (Throwable th) {
            LogUtil.d(TAG, "jumpDeepLink error");
            th.printStackTrace();
            o0.a(false);
            finish();
        }
    }

    public static void startOpenDeepLinkActivity(Context context, String str, String str2, String[] strArr, String str3) {
        try {
            Intent intent = new Intent(context, (Class<?>) MeishuOpenDeepLinkActivity.class);
            if (!(context instanceof Activity)) {
                intent.setFlags(268435456);
            }
            intent.putExtra(KEY_DEEP_LINK, str);
            intent.putExtra(KEY_DEEP_SIGN, str2);
            intent.putExtra(KEY_DEEP_START, strArr);
            intent.putExtra(KEY_DP_SIGN, str3);
            context.startActivity(intent);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.meishu.sdk.core.safe.SafeActivity
    public void safeOnActivityResult(int i, int i2, Intent intent) {
        super.safeOnActivityResult(i, i2, intent);
        if (i == 10010) {
            if (i2 == 0) {
                SdkHandler.getInstance().postDelay(new l() { // from class: com.meishu.sdk.activity.MeishuOpenDeepLinkActivity.1
                    @Override // com.meishu.sdk.core.safe.l
                    public void notifyRunnableCatch(Throwable th) {
                        super.notifyRunnableCatch(th);
                        MeishuOpenDeepLinkActivity.this.safeFinish();
                    }

                    @Override // com.meishu.sdk.core.safe.l
                    public void safeRun() {
                        if (MeishuOpenDeepLinkActivity.this.hasAppBackground) {
                            MeishuOpenDeepLinkActivity.this.openDeepLinkRes = Boolean.TRUE;
                        } else {
                            MeishuOpenDeepLinkActivity meishuOpenDeepLinkActivity = MeishuOpenDeepLinkActivity.this;
                            meishuOpenDeepLinkActivity.openDeepLinkRes = Boolean.valueOf(meishuOpenDeepLinkActivity.isBackground);
                        }
                        MeishuOpenDeepLinkActivity.this.notifyJumpDeepLinkRes();
                    }
                }, 100L);
            } else {
                this.openDeepLinkRes = Boolean.TRUE;
                notifyJumpDeepLinkRes();
            }
        }
    }

    @Override // com.meishu.sdk.core.safe.SafeActivity
    public void safeOnCreate(Bundle bundle) {
        super.safeOnCreate(bundle);
        getWindow().setStatusBarColor(0);
        String stringExtra = getIntent().getStringExtra(KEY_DEEP_LINK);
        this.dpSign = getIntent().getStringExtra(KEY_DEEP_SIGN);
        try {
            this.DPSIGN = getIntent().getStringExtra(KEY_DP_SIGN);
        } catch (Throwable unused) {
        }
        this.dpStartUrls = getIntent().getStringArrayExtra(KEY_DEEP_START);
        d.a(this.onAppStateListener);
        jumpDeepLink(stringExtra);
    }

    @Override // com.meishu.sdk.core.safe.SafeActivity
    public void safeOnDestroy() {
        super.safeOnDestroy();
        d.b(this.onAppStateListener);
    }

    @Override // com.meishu.sdk.core.safe.SafeActivity
    public void safeOnPause() {
        super.safeOnPause();
        this.isBackground = true;
    }

    @Override // com.meishu.sdk.core.safe.SafeActivity
    public void safeOnResume() {
        super.safeOnResume();
        this.isBackground = false;
        notifyJumpDeepLinkRes();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyJumpDeepLinkRes() {
        Boolean bool;
        if (this.isBackground || (bool = this.openDeepLinkRes) == null) {
            return;
        }
        o0.a(bool.booleanValue());
        d.b(this.onAppStateListener);
        finish();
    }
}
