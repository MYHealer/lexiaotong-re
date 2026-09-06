package com.huawei.openalliance.ad.ipc;

import android.content.ComponentName;
import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.exoplayer2.C;
import com.huawei.hms.ads.fh;
import com.huawei.openalliance.ad.utils.bl;
import com.huawei.openalliance.ad.utils.z;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class g extends c<f> {
    private static final String B = "com.huawei.android.hms.ppskit.PpsCoreService";
    private static final String C = "Decouple.PPSApiServiceManager";
    private static final byte[] D = new byte[0];
    private static g F = null;
    private static final String S = "AidlConnectMonitorMethod";
    private static final String Z = "com.huawei.android.hms.ppskit.PPS_API_SERVICE";
    private long L;

    private static class a<T> extends c.a<f> {
        private String Code;
        private RemoteCallResultCallback<T> I;
        private String V;
        private Class<T> Z;

        a(String str, String str2, RemoteCallResultCallback<T> remoteCallResultCallback, Class<T> cls) {
            this.Code = str;
            this.V = str2;
            this.I = remoteCallResultCallback;
            this.Z = cls;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void Code(final RemoteCallResultCallback remoteCallResultCallback, final String str, final CallResult callResult) {
            if (callResult != null) {
                fh.V(g.C, "call %s code: %s msg: %s", str, Integer.valueOf(callResult.getCode()), callResult.getMsg());
            }
            if (remoteCallResultCallback != null) {
                com.huawei.openalliance.ad.utils.i.I(new Runnable() { // from class: com.huawei.openalliance.ad.ipc.g.a.2
                    @Override // java.lang.Runnable
                    public void run() {
                        remoteCallResultCallback.onRemoteCallResult(str, callResult);
                    }
                });
            }
        }

        private void V(String str) {
            fh.I(g.C, str);
            CallResult callResult = new CallResult();
            callResult.setCode(-1);
            callResult.setMsg(str);
            Code(this.I, this.Code, callResult);
        }

        @Override // com.huawei.openalliance.ad.ipc.c.a
        public void Code(f fVar) {
            String str;
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("sdk_version", "13.4.81.300");
                jSONObject.put("content", this.V);
                fVar.Code(this.Code, jSONObject.toString(), new e.a() { // from class: com.huawei.openalliance.ad.ipc.g.a.1
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // com.huawei.openalliance.ad.ipc.e
                    public void Code(String str2, int i, String str3) {
                        String message;
                        if (fh.Code()) {
                            fh.Code(g.C, "call: %s code: %s result: %s", str2, Integer.valueOf(i), bl.Code(str3));
                        }
                        CallResult callResult = new CallResult();
                        callResult.setCode(i);
                        try {
                            if (i == 200) {
                                callResult.setData(i.Code(str3, a.this.Z));
                            } else {
                                callResult.setMsg(str3);
                            }
                        } catch (IllegalArgumentException e) {
                            fh.I(g.C, "onCallResult IllegalArgumentException");
                            callResult.setCode(-1);
                            message = e.getMessage();
                            callResult.setMsg(message);
                        } catch (Throwable th) {
                            fh.I(g.C, "onCallResult " + th.getClass().getSimpleName());
                            callResult.setCode(-1);
                            message = th.getMessage();
                            callResult.setMsg(message);
                        }
                        a aVar = a.this;
                        aVar.Code(aVar.I, str2, callResult);
                    }
                });
            } catch (RemoteException unused) {
                str = "remote call RemoteException";
                V(str);
            } catch (Throwable th) {
                str = "remote call " + th.getClass().getSimpleName();
                V(str);
            }
        }

        @Override // com.huawei.openalliance.ad.ipc.c.a
        public void Code(String str) {
            V("onServiceCallFailed");
        }
    }

    protected g(Context context) {
        super(context);
    }

    public static g V(Context context) {
        g gVar;
        synchronized (D) {
            if (F == null) {
                F = new g(context);
            }
            gVar = F;
        }
        return gVar;
    }

    @Override // com.huawei.openalliance.ad.ipc.c
    protected void B() {
        this.L = System.currentTimeMillis();
    }

    @Override // com.huawei.openalliance.ad.ipc.c
    protected void Code(ComponentName componentName) {
        long jCurrentTimeMillis = System.currentTimeMillis() - this.L;
        z.V(componentName.getPackageName());
        Code(S, String.valueOf(jCurrentTimeMillis), null, null);
    }

    public <T> void Code(String str, String str2, RemoteCallResultCallback<T> remoteCallResultCallback, Class<T> cls) {
        fh.V(V(), "call remote method: " + str);
        if (fh.Code()) {
            fh.Code(V(), "paramContent: %s", bl.Code(str2));
        }
        Code(new a(str, str2, remoteCallResultCallback, cls), C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS);
    }

    @Override // com.huawei.openalliance.ad.ipc.c
    protected String F() {
        return "com.huawei.android.hms.ppskit.PpsCoreService";
    }

    @Override // com.huawei.openalliance.ad.ipc.c
    protected String I() {
        return Z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.huawei.openalliance.ad.ipc.c
    /* JADX INFO: renamed from: V, reason: merged with bridge method [inline-methods] */
    public f Code(IBinder iBinder) {
        return f.a.Code(iBinder);
    }

    @Override // com.huawei.openalliance.ad.ipc.c
    public String V() {
        return C;
    }

    @Override // com.huawei.openalliance.ad.ipc.c
    public String Z() {
        return z.Z(this.V);
    }
}
