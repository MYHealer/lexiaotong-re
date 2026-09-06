package com.baidu.mobads.sdk.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import com.baidu.mobads.sdk.api.CustomNotification;
import com.baidu.mobads.sdk.api.ICommonModuleObj;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
public class t implements ICommonModuleObj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile t f1824a;
    private CustomNotification b = new CustomNotification();
    private com.baidu.mobads.sdk.internal.b.a c = new com.baidu.mobads.sdk.internal.b.a();

    private t() {
    }

    public static t a() {
        if (f1824a == null) {
            synchronized (t.class) {
                if (f1824a == null) {
                    f1824a = new t();
                }
            }
        }
        return f1824a;
    }

    @Override // com.baidu.mobads.sdk.api.ICommonModuleObj
    public Object createModuleObj(String str, JSONObject jSONObject) {
        if (!ICommonModuleObj.KEY_NOTIFICATION.equals(str)) {
            if (ICommonModuleObj.KEY_RESOURCES.equals(str)) {
                return this.c;
            }
            return null;
        }
        if (jSONObject == null) {
            return null;
        }
        Context context = (Context) jSONObject.opt("context");
        int iOptInt = jSONObject.optInt("version", 0);
        String strOptString = jSONObject.optString("channelId");
        String strOptString2 = jSONObject.optString("ticker");
        Bitmap bitmap = (Bitmap) jSONObject.opt(com.huawei.openalliance.ad.constant.x.cL);
        String strOptString3 = jSONObject.optString("title");
        String strOptString4 = jSONObject.optString("content");
        String strOptString5 = jSONObject.optString("status");
        boolean zOptBoolean = jSONObject.optBoolean("autoCancel");
        int iOptInt2 = jSONObject.optInt("progress");
        boolean zOptBoolean2 = jSONObject.optBoolean("indeterminate", false);
        int iOptInt3 = jSONObject.optInt("smallIcon");
        String strOptString6 = jSONObject.optString("action");
        PendingIntent pendingIntent = (PendingIntent) jSONObject.opt(com.huawei.openalliance.ad.download.app.d.e);
        String strOptString7 = jSONObject.optString("action2");
        PendingIntent pendingIntent2 = (PendingIntent) jSONObject.opt("pendingIntent2");
        if (iOptInt == 1) {
            return this.b.getNewNotification(context, strOptString2, zOptBoolean, bitmap, strOptString3, strOptString4, iOptInt2, zOptBoolean2, strOptString6, pendingIntent, strOptString7, pendingIntent2);
        }
        return this.b.getCustomNotification(context, strOptString, strOptString2, bitmap, strOptString3, strOptString4, strOptString5, zOptBoolean, iOptInt2, iOptInt3, strOptString6, pendingIntent);
    }
}
