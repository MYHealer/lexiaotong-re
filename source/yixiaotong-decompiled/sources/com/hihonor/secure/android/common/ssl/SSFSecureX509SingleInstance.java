package com.hihonor.secure.android.common.ssl;

import android.content.Context;
import android.os.AsyncTask;
import com.hihonor.secure.android.common.ssl.util.BksUtil;
import com.hihonor.secure.android.common.ssl.util.e;
import com.hihonor.secure.android.common.ssl.util.g;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class SSFSecureX509SingleInstance {
    private static final String TAG = "SSFSecureX509SingleInstance";
    private static volatile SecureX509TrustManager r;

    public static SecureX509TrustManager getInstance(Context context) throws NoSuchAlgorithmException, IOException, CertificateException, KeyStoreException {
        if (context == null) {
            throw new NullPointerException("context is null");
        }
        com.hihonor.secure.android.common.ssl.util.c.setContext(context);
        if (r == null) {
            synchronized (SSFSecureX509SingleInstance.class) {
                if (r == null) {
                    InputStream filesBksIS = BksUtil.getFilesBksIS(context);
                    if (filesBksIS == null) {
                        g.c(TAG, "get assets bks");
                        filesBksIS = context.getAssets().open(SecureX509TrustManager.A);
                    } else {
                        g.c(TAG, "get files bks");
                    }
                    r = new SecureX509TrustManager(filesBksIS, "", true);
                    new e().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, context);
                }
            }
        }
        return r;
    }

    public static void updateBks(InputStream inputStream) {
        String str = TAG;
        g.c(str, "update bks");
        if (inputStream == null || r == null) {
            return;
        }
        r = new SecureX509TrustManager(inputStream, "", true);
        SSFCompatiableSystemCA.a(r);
        SASFCompatiableSystemCA.a(r);
        if (r == null || r.getAcceptedIssuers() == null) {
            return;
        }
        g.b(str, "after updata bks , ca size is : " + r.getAcceptedIssuers().length);
    }
}
