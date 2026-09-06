package com.huawei.openalliance.ad.ipc;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.huawei.hms.ads.ej;
import com.huawei.hms.ads.fh;
import com.huawei.openalliance.ad.utils.bb;
import com.huawei.openalliance.ad.utils.bl;
import com.huawei.openalliance.ad.utils.z;
import com.stub.StubApp;
import java.io.Closeable;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class b {
    private static final String B = ".pps.apiprovider";
    private static final String C = ".pps.innerapiprovider";
    private static final String Code = "ApiCallManager";
    private static b V = null;
    private static final String Z = "content";
    private volatile Uri L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f4469a;
    private static final byte[] I = new byte[0];
    private static final String S = "com.huawei.hwid.pps.apiprovider";
    private static final String F = "/pps/api/call";
    private static final Uri D = new Uri.Builder().scheme("content").authority(S).path(F).build();

    private b(Context context) {
        this.f4469a = StubApp.getOrigApplicationContext(context.getApplicationContext());
    }

    private Uri Code(boolean z) {
        if (z) {
            return D;
        }
        int iV = ej.Code(this.f4469a).v();
        fh.V(Code, "ads selection:" + iV);
        if (z.V(this.f4469a) && (iV == 0 || iV == 2)) {
            return D;
        }
        if (!z.I()) {
            return D;
        }
        if (this.L == null) {
            this.L = new Uri.Builder().scheme("content").authority(this.f4469a.getPackageName() + C).path(F).build();
        }
        return this.L;
    }

    public static b Code(Context context) {
        b bVar;
        synchronized (I) {
            if (V == null) {
                V = new b(context);
            }
            bVar = V;
        }
        return bVar;
    }

    public <T> CallResult<T> Code(String str, String str2, Class<T> cls) {
        return Code(str, str2, cls, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> CallResult<T> Code(String str, String str2, Class<T> cls, boolean z) {
        String message;
        CallResult<T> callResult = (CallResult<T>) new CallResult();
        Cursor cursor = null;
        try {
            try {
                Uri uriCode = Code(z);
                try {
                    if (!z.Code(this.f4469a, uriCode)) {
                        fh.I(Code, "uri invalid");
                        callResult.setCode(-1);
                        bb.Code((Closeable) null);
                        return callResult;
                    }
                    fh.V(Code, "call remote method: %s", str);
                    if (fh.Code()) {
                        fh.Code(Code, "paramContent: %s", bl.Code(str2));
                    }
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("sdk_version", "13.4.81.300");
                    jSONObject.put("content", str2);
                    Cursor cursorQuery = this.f4469a.getContentResolver().query(uriCode, null, null, new String[]{str, jSONObject.toString()}, null);
                    if (cursorQuery != null) {
                        try {
                            if (cursorQuery.moveToFirst()) {
                                int i = cursorQuery.getInt(cursorQuery.getColumnIndexOrThrow("code"));
                                callResult.setCode(i);
                                String string = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("content"));
                                fh.Code(Code, "call: %s code: %s result: %s", str, Integer.valueOf(i), string);
                                if (i == 200) {
                                    callResult.setData(i.Code(string, cls));
                                } else {
                                    callResult.setMsg(string);
                                }
                            }
                        } catch (IllegalArgumentException e) {
                            e = e;
                            cursor = cursorQuery;
                            fh.I(Code, "callRemote IllegalArgumentException");
                            callResult.setCode(-1);
                            message = e.getMessage();
                            callResult.setMsg(message);
                            bb.Code(cursor);
                        } catch (Throwable th) {
                            th = th;
                            cursor = cursorQuery;
                            fh.I(Code, "callRemote " + th.getClass().getSimpleName());
                            callResult.setCode(-1);
                            message = th.getMessage();
                            callResult.setMsg(message);
                            bb.Code(cursor);
                        }
                    }
                    bb.Code(cursorQuery);
                    fh.V(Code, "call %s code: %s msg: %s", str, Integer.valueOf(callResult.getCode()), callResult.getMsg());
                    return callResult;
                } catch (IllegalArgumentException e2) {
                    e = e2;
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                bb.Code(cursor);
                throw th3;
            }
        } catch (IllegalArgumentException e3) {
            e = e3;
            cursor = null;
        } catch (Throwable th4) {
            th = th4;
            cursor = null;
        }
        fh.I(Code, "callRemote IllegalArgumentException");
        callResult.setCode(-1);
        message = e.getMessage();
        callResult.setMsg(message);
        bb.Code(cursor);
        fh.V(Code, "call %s code: %s msg: %s", str, Integer.valueOf(callResult.getCode()), callResult.getMsg());
        return callResult;
    }
}
