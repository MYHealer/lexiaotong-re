package com.oplus.instant.router.g;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.oplus.instant.router.callback.Callback;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class c {

    class a extends Callback {
        a() {
        }

        @Override // com.oplus.instant.router.callback.Callback
        public void onResponse(Callback.Response response) {
            d.a("GameUtil", "wrapCallback onResponse=" + response);
        }
    }

    private static class b extends Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Callback f5777a;
        private Context b;
        private String c;

        public b(Context context, String str, Callback callback) {
            this.f5777a = callback;
            this.b = context;
            this.c = str;
        }

        @Override // com.oplus.instant.router.callback.Callback
        public void onResponse(Callback.Response response) {
            if (response != null && response.getCode() == 1) {
                try {
                    d.c("GameUtil", "wrapper onResponse " + response);
                    Intent intent = new Intent();
                    intent.setComponent(new ComponentName(h.d(this.b), com.oplus.instant.router.g.a.a("Y29tLm5lYXJtZS5pbnN0YW50LnF1aWNrZ2FtZS5hY3Rpdml0eS5HYW1lVHJhbnNmZXJBY3Rpdml0eQ==")));
                    intent.putExtra("req_uri", this.c);
                    this.b.startActivity(intent);
                } catch (Exception e) {
                    d.c("GameUtil", "wrapper onResponse ex:" + e.getMessage());
                    response = new Callback.Response();
                    response.setCode(-4);
                    response.setMsg("start transform page failed");
                }
            }
            Callback callback = this.f5777a;
            if (callback != null) {
                callback.onResponse(response);
            }
        }
    }

    public static Callback a(Context context, String str, Callback callback) {
        if (callback == null) {
            callback = new a();
        }
        return new b(context, str, callback);
    }

    public static boolean a(Context context, String str, Map<String, String> map) {
        if (str == null || !str.startsWith("hap://game") || h.c(context) < 3100) {
            return false;
        }
        try {
            if ("1".equals(Uri.parse(str).getQueryParameter("in_one_task"))) {
                return true;
            }
        } catch (Exception e) {
            d.a("GameUtil", e);
        }
        return map != null && "1".equals(map.get("in_one_task"));
    }
}
