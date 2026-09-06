package com.meishu.sdk.core.uri;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import com.meishu.sdk.activity.MeishuWebviewActivity;
import com.meishu.sdk.core.AdSdk;
import com.meishu.sdk.core.ad.AdSlot;

/* JADX INFO: compiled from: HttpProcessor.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class a implements b {
    @Override // com.meishu.sdk.core.uri.b
    public boolean a(Context context, Uri uri, AdSlot adSlot) {
        if (!uri.getScheme().startsWith("http")) {
            return false;
        }
        Class<? extends Activity> clsWebViewActivity = AdSdk.adConfig() != null ? AdSdk.adConfig().webViewActivity() : null;
        if (clsWebViewActivity == null) {
            clsWebViewActivity = MeishuWebviewActivity.class;
        }
        Intent intent = new Intent(context, clsWebViewActivity);
        intent.putExtra(MeishuWebviewActivity.EXTRA_AD_DURL_KEY, new String[]{uri.toString()});
        if (adSlot.getClickUrl() != null) {
            for (String str : adSlot.getClickUrl()) {
                try {
                    Uri uri2 = Uri.parse(str);
                    if (uri2.getHost() != null && "dsp.1rtb.com".equals(uri2.getHost())) {
                        String strSubstring = null;
                        String strSubstring2 = null;
                        for (String str2 : new String(Base64.decode(uri2.getQueryParameter("ext_data"), 3)).split(",")) {
                            if (str2.startsWith("amid=")) {
                                strSubstring = str2.substring(5);
                            } else if (str2.startsWith("uuid=")) {
                                strSubstring2 = str2.substring(5);
                            }
                        }
                        if (!TextUtils.isEmpty(strSubstring)) {
                            intent.putExtra(MeishuWebviewActivity.EXTRA_AD_AMID_KEY, strSubstring);
                            if (!TextUtils.isEmpty(strSubstring2)) {
                                intent.putExtra(MeishuWebviewActivity.EXTRA_AD_UUID_KEY, strSubstring2);
                                break;
                            }
                            break;
                        }
                        continue;
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
        return true;
    }
}
