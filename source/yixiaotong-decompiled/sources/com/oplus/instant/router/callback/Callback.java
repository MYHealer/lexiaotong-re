package com.oplus.instant.router.callback;

import android.database.Cursor;
import com.oplus.instant.router.g.f;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public abstract class Callback {

    public static class Response {
        public static final int DENIED = -8;
        public static final int FAIL = -4;
        public static final int SUCCESS = 1;
        public static final int UPDATE_CANCEL = -11;
        public static final String UPDATE_CANCEL_MESSAGE = "platform need update but user canceled";
        public static final int UPDATE_ERROR = -10;
        public static final String UPDATE_ERROR_MESSAGE = "platform need update but error occurred";
        public static final int UPDATE_SUCCESS = 10;
        public static final String UPDATE_SUCCESS_MESSAGE = "platform update success, please call request again";

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f5769a;
        String b;

        public int getCode() {
            return this.f5769a;
        }

        public String getMsg() {
            return this.b;
        }

        public void setCode(int i) {
            this.f5769a = i;
        }

        public void setMsg(String str) {
            this.b = str;
        }

        public String toString() {
            return this.f5769a + "#" + this.b;
        }
    }

    public abstract void onResponse(Response response);

    public void onResponse(Map<String, Object> map, Cursor cursor) {
        String str;
        Object obj;
        Map<String, Object> mapA = f.a(cursor);
        Response response = new Response();
        if (mapA == null || (obj = mapA.get("code")) == null) {
            response.f5769a = -1;
            str = "fail to get response";
        } else {
            response.f5769a = Long.valueOf(((Long) obj).longValue()).intValue();
            str = (String) mapA.get("msg");
        }
        response.b = str;
        onResponse(response);
    }
}
