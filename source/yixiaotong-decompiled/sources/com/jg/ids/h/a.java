package com.jg.ids.h;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\93504.dex */
public final class a extends com.jg.ids.a {
    private static final Uri b = Uri.parse("content://cn.nubia.identity/identity");

    public a(Context context) {
        super(context, "nubia_thread");
    }

    @Override // com.jg.ids.a
    protected final void a(Message message) {
        String packageName = null;
        if (message != null) {
            try {
                if (message.what == 0) {
                    int i = message.getData().getInt("type", -1);
                    String str = "";
                    switch (i) {
                        case 0:
                            str = "getOAID";
                            break;
                        case 1:
                            str = "getVAID";
                            packageName = this.f4599a.getPackageName();
                            break;
                        case 2:
                            str = "getAAID";
                            packageName = this.f4599a.getPackageName();
                            break;
                    }
                    a(i, a(this.f4599a, str, packageName));
                }
            } catch (Throwable th) {
            }
        }
    }

    @Override // com.jg.ids.a
    protected final void b() {
        a(2);
        a(0);
        a(1);
    }

    private void a(int i) {
        try {
            Message messageA = a();
            messageA.what = 0;
            Bundle bundle = new Bundle();
            bundle.putInt("type", i);
            messageA.setData(bundle);
            b(messageA);
        } catch (Throwable th) {
        }
    }

    private static String a(Context context, String str, String str2) {
        Bundle bundleCall;
        if (context == null) {
            return "";
        }
        try {
            if (Build.VERSION.SDK_INT >= 17) {
                ContentProviderClient contentProviderClientAcquireContentProviderClient = context.getContentResolver().acquireContentProviderClient(b);
                if (contentProviderClientAcquireContentProviderClient == null) {
                    return "";
                }
                bundleCall = contentProviderClientAcquireContentProviderClient.call(str, str2, null);
                if (Build.VERSION.SDK_INT >= 24) {
                    contentProviderClientAcquireContentProviderClient.close();
                } else {
                    contentProviderClientAcquireContentProviderClient.release();
                }
            } else {
                bundleCall = context.getContentResolver().call(b, str, str2, (Bundle) null);
            }
            if (bundleCall != null && bundleCall.getInt("code", -1) == 0) {
                return bundleCall.getString("id");
            }
        } catch (Throwable th) {
        }
        return "";
    }

    @Override // com.jg.ids.a
    protected final void a(int i, String str) {
        switch (i) {
            case 0:
                a(new b(this, str));
                break;
            case 1:
                a(new c(this, str));
                break;
            case 2:
                a(new d(this, str));
                break;
        }
    }
}
