package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.openalliance.ad.ipc.CallResult;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class kv {
    private static final String Code = "DcServiceCmdManager";
    private static final int V = 10001;

    public static void Code(final Context context, final kw kwVar) {
        if (kwVar == null) {
            return;
        }
        com.huawei.openalliance.ad.utils.i.I(new Runnable() { // from class: com.huawei.hms.ads.kv.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if ("com.huawei.hwid".equals(kwVar.S())) {
                        fh.V(kv.Code, "package is hms package name");
                        return;
                    }
                    String strF = ej.Code(context).F(com.huawei.openalliance.ad.constant.w.ay);
                    String strF2 = ej.Code(context).F(com.huawei.openalliance.ad.constant.w.az);
                    fh.Code(kv.Code, "redirectionAppList from configMap : %s; redirectionMediaList from configMap : %s", strF, strF2);
                    List<String> listV = com.huawei.openalliance.ad.utils.bc.V(strF, ",");
                    List<String> listV2 = com.huawei.openalliance.ad.utils.bc.V(strF2, ",");
                    String packageName = com.huawei.openalliance.ad.utils.bc.Code(kwVar.I()) ? context.getPackageName() : kwVar.I();
                    if ((!com.huawei.openalliance.ad.utils.ag.Code(listV) && listV.contains(kwVar.S())) || (!com.huawei.openalliance.ad.utils.ag.Code(listV2) && listV2.contains(packageName))) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("dc_service_cmd", 10001);
                        final JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("contentId", kwVar.B());
                        jSONObject2.put(com.hihonor.adsdk.base.c.r1.hnadse, kwVar.S());
                        jSONObject2.put("apiVer", String.valueOf(kwVar.D()));
                        final CountDownLatch countDownLatch = new CountDownLatch(1);
                        final long jCurrentTimeMillis = System.currentTimeMillis();
                        com.huawei.openalliance.ad.utils.i.Code(new Runnable() { // from class: com.huawei.hms.ads.kv.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                try {
                                    com.huawei.openalliance.ad.ipc.h.Code(context, false).Code(com.huawei.openalliance.ad.constant.s.R, jSONObject2.toString(), new RemoteCallResultCallback<String>() { // from class: com.huawei.hms.ads.kv.2.1.1
                                        @Override // com.huawei.openalliance.ad.ipc.RemoteCallResultCallback
                                        public void onRemoteCallResult(String str, CallResult<String> callResult) {
                                            long jCurrentTimeMillis2 = System.currentTimeMillis();
                                            if (callResult.getCode() == 200) {
                                                String data = callResult.getData();
                                                try {
                                                    fh.Code(kv.Code, "do get param from fat is success : %s", Integer.valueOf(callResult.getCode()));
                                                    jSONObject2.put("paramFromServer", data);
                                                    countDownLatch.countDown();
                                                } catch (JSONException e) {
                                                    countDownLatch.countDown();
                                                    fh.Code(kv.Code, "do get param from fat is failed : %s", Integer.valueOf(callResult.getCode()));
                                                    fh.Z(kv.Code, "json exception queryParamFromServer : %s", e.getClass().getSimpleName());
                                                }
                                            }
                                            fh.Code(kv.Code, "do get param from fat durationg is : %s", Long.valueOf(jCurrentTimeMillis2 - jCurrentTimeMillis));
                                        }
                                    }, null);
                                } catch (Exception e) {
                                    fh.Z(kv.Code, "json exception sendRedirectionMatchRecord : %s", e.getClass().getSimpleName());
                                }
                            }
                        });
                        jSONObject2.put("taskId", kwVar.C());
                        jSONObject2.put("slotId", kwVar.Code());
                        jSONObject2.put(com.huawei.openalliance.ad.constant.ba.S, kwVar.V());
                        jSONObject2.put("taskId", kwVar.C());
                        jSONObject2.put("activityName", kwVar.F());
                        jSONObject2.put("triggerTime", System.currentTimeMillis());
                        jSONObject2.put("callerPkgName", packageName);
                        countDownLatch.await(500L, TimeUnit.MILLISECONDS);
                        jSONObject.put("param", jSONObject2);
                        fh.Code(kv.Code, "send direction match record : %s", jSONObject2.toString());
                        kv.Code(context, jSONObject);
                        return;
                    }
                    fh.V(kv.Code, "package is not in package list, appPkgName: %s, mediaPkgName: %s", kwVar.S(), packageName);
                } catch (Exception e) {
                    fh.Z(kv.Code, "json exception sendRedirectionMatchRecord : %s", e.getClass().getSimpleName());
                }
            }
        });
    }

    public static void Code(Context context, JSONObject jSONObject) {
        com.huawei.openalliance.ad.ipc.h.Code(context, true).Code(com.huawei.openalliance.ad.constant.s.K, jSONObject.toString(), new RemoteCallResultCallback<String>() { // from class: com.huawei.hms.ads.kv.1
            /* JADX WARN: Code duplicated, block: B:10:0x0018 A[Catch: all -> 0x0021, TryCatch #0 {all -> 0x0021, blocks: (B:4:0x0004, B:6:0x000c, B:9:0x0014, B:10:0x0018), top: B:17:0x0004 }] */
            /* JADX WARN: Code duplicated, block: B:12:0x001e  */
            /* JADX WARN: Code duplicated, block: B:21:? A[RETURN, SYNTHETIC] */
            @Override // com.huawei.openalliance.ad.ipc.RemoteCallResultCallback
            public void onRemoteCallResult(String str, CallResult<String> callResult) {
                String str2;
                if (callResult != null) {
                    try {
                        if (callResult.getCode() == 200) {
                            if (!fh.Code()) {
                                return;
                            } else {
                                str2 = "query DC_BRIDGE from hms success!";
                            }
                        } else if (fh.Code()) {
                            return;
                        } else {
                            str2 = "failed to query DC_BRIDGE from hms";
                        }
                    } catch (Throwable th) {
                        fh.Z(kv.Code, "get DC_BRIDGE from hms err : %s", th.getClass().getSimpleName());
                        return;
                    }
                } else if (fh.Code()) {
                    return;
                } else {
                    str2 = "failed to query DC_BRIDGE from hms";
                }
                fh.Code(kv.Code, str2);
            }
        }, String.class);
    }
}
