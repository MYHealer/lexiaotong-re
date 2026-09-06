package com.opos.cmn.biz.ststrategy.impl;

import android.content.Context;
import android.text.TextUtils;
import com.byazt.bv.BaseConstants;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.opos.acs.st.utils.ErrorContants;
import com.opos.cmn.an.c.c;
import com.opos.cmn.biz.requeststatistic.RequestStatisticManager;
import com.opos.cmn.biz.requeststatistic.StatisticEvent;
import com.opos.cmn.biz.ststrategy.StStrategyManager;
import com.opos.cmn.biz.ststrategy.UpdateParams;
import com.opos.cmn.biz.ststrategy.entity.STConfigEntity;
import com.opos.cmn.biz.ststrategy.listener.UpdateSTConfigListener;
import com.opos.cmn.biz.ststrategy.utils.f;
import com.opos.cmn.func.a.a.b;
import com.opos.cmn.func.a.a.d;
import com.opos.cmn.func.a.a.e;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class a implements com.opos.cmn.biz.ststrategy.interfaces.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f6022a = "a";
    private static ConcurrentHashMap<String, AtomicBoolean> c = new ConcurrentHashMap<>();
    private static volatile com.opos.cmn.an.j.a d = null;
    private static final byte[] e = new byte[1];
    private Context b;

    public a(Context context) {
        this.b = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(JSONObject jSONObject) {
        int i = -1;
        if (jSONObject != null && jSONObject.has("code") && !jSONObject.isNull("code")) {
            try {
                int i2 = jSONObject.getInt("code");
                if (i2 == 0) {
                    i = 0;
                } else if (-3 == i2) {
                    i = -3;
                }
            } catch (JSONException e2) {
                com.opos.cmn.an.f.a.c(f6022a, "", e2);
            }
        }
        com.opos.cmn.an.f.a.b(f6022a, "isResponseOKByCode result " + (i == 0));
        return i;
    }

    private d a(String str, String str2, boolean z) {
        try {
            return new d.a().b(str2).a(c()).a("POST").a(a(str, z)).a();
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.c(f6022a, "getSTConfigNetRequest fail", e2);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(UpdateSTConfigListener updateSTConfigListener) {
        if (updateSTConfigListener != null) {
            updateSTConfigListener.onFail();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:26:0x0063 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:27:0x0065  */
    /* JADX WARN: Code duplicated, block: B:34:0x00c5 A[Catch: Exception -> 0x012c, PHI: r5 r8
  0x00c5: PHI (r5v4 com.opos.cmn.func.a.a.e) = (r5v3 com.opos.cmn.func.a.a.e), (r5v7 com.opos.cmn.func.a.a.e) binds: [B:45:0x0121, B:33:0x00c3] A[DONT_GENERATE, DONT_INLINE]
  0x00c5: PHI (r8v3 boolean) = (r8v2 boolean), (r8v9 boolean) binds: [B:45:0x0121, B:33:0x00c3] A[DONT_GENERATE, DONT_INLINE], TRY_ENTER, TRY_LEAVE, TryCatch #2 {Exception -> 0x012c, blocks: (B:6:0x001a, B:34:0x00c5, B:50:0x0128, B:51:0x012b), top: B:61:0x001a }] */
    /* JADX WARN: Code duplicated, block: B:50:0x0128 A[Catch: Exception -> 0x012c, TRY_ENTER, TryCatch #2 {Exception -> 0x012c, blocks: (B:6:0x001a, B:34:0x00c5, B:50:0x0128, B:51:0x012b), top: B:61:0x001a }] */
    /* JADX WARN: Code duplicated, block: B:55:0x0134 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:65:0x0069 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:71:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(String str, boolean z, com.opos.cmn.biz.ststrategy.listener.a aVar) throws Throwable {
        e eVar;
        long j;
        Object obj = "update stConfig success======ParamsName=";
        String str2 = f6022a;
        com.opos.cmn.an.f.a.b(str2, "request http st config start======");
        Context context = this.b;
        if (context == null || str == null) {
            return;
        }
        boolean z2 = false;
        try {
            String strA = f.a(context);
            d dVarA = a(str, strA, z);
            long jCurrentTimeMillis = System.currentTimeMillis();
            e eVar2 = 0;
            try {
                try {
                    e eVarA = b.a().a(this.b, dVarA);
                    if (eVarA != null) {
                        try {
                            try {
                                if (200 == eVarA.f6077a) {
                                    try {
                                        com.opos.cmn.an.f.a.a(str2, "update stConfig success======ParamsName=" + str);
                                        if (aVar != null) {
                                            aVar.a(eVarA);
                                        }
                                        z2 = true;
                                        eVar = eVarA;
                                    } catch (Exception e2) {
                                        e = e2;
                                        z2 = true;
                                        eVar = eVarA;
                                        com.opos.cmn.an.f.a.c(f6022a, "", e);
                                        long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
                                        RequestStatisticManager.getInstance().report(new StatisticEvent.Builder(ErrorContants.LOAD_STRATEGY_ERROR, strA, -1L, jCurrentTimeMillis2, jCurrentTimeMillis2, "6").setExt(e.getMessage()).setCurrentTime(System.currentTimeMillis()).setSdkVersion(StStrategyManager.getStVerCode() + "").build());
                                        if (eVar != null) {
                                        }
                                        if (z2) {
                                            return;
                                        } else {
                                            return;
                                        }
                                    } catch (Throwable th) {
                                        th = th;
                                        eVar2 = eVarA;
                                        if (eVar2 != 0) {
                                            eVar2.a();
                                        }
                                        throw th;
                                    }
                                } else {
                                    if (eVarA == null) {
                                        j = -2;
                                    } else {
                                        try {
                                            j = eVarA.f6077a;
                                        } catch (Throwable th2) {
                                            th = th2;
                                            obj = eVarA;
                                            eVar2 = obj;
                                            if (eVar2 != 0) {
                                                eVar2.a();
                                            }
                                            throw th;
                                        }
                                    }
                                    long j2 = j;
                                    long jCurrentTimeMillis3 = System.currentTimeMillis() - jCurrentTimeMillis;
                                    eVar = eVarA;
                                    try {
                                        RequestStatisticManager.getInstance().report(new StatisticEvent.Builder(ErrorContants.LOAD_STRATEGY_ERROR, strA, j2, jCurrentTimeMillis3, jCurrentTimeMillis3, "6").setCurrentTime(System.currentTimeMillis()).setSdkVersion(StStrategyManager.getStVerCode() + "").build());
                                        com.opos.cmn.an.f.a.a(str2, "update stConfig failed======code=" + j2);
                                    } catch (Exception e3) {
                                        e = e3;
                                        com.opos.cmn.an.f.a.c(f6022a, "", e);
                                        long jCurrentTimeMillis4 = System.currentTimeMillis() - jCurrentTimeMillis;
                                        RequestStatisticManager.getInstance().report(new StatisticEvent.Builder(ErrorContants.LOAD_STRATEGY_ERROR, strA, -1L, jCurrentTimeMillis4, jCurrentTimeMillis4, "6").setExt(e.getMessage()).setCurrentTime(System.currentTimeMillis()).setSdkVersion(StStrategyManager.getStVerCode() + "").build());
                                        if (eVar != null) {
                                        }
                                        if (z2) {
                                            return;
                                        } else {
                                            return;
                                        }
                                    }
                                }
                                if (eVar != null) {
                                    eVar.a();
                                }
                            } catch (Exception e4) {
                                e = e4;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                        }
                    } else {
                        if (eVarA == null) {
                            j = -2;
                        } else {
                            j = eVarA.f6077a;
                        }
                        long j3 = j;
                        long jCurrentTimeMillis5 = System.currentTimeMillis() - jCurrentTimeMillis;
                        eVar = eVarA;
                        RequestStatisticManager.getInstance().report(new StatisticEvent.Builder(ErrorContants.LOAD_STRATEGY_ERROR, strA, j3, jCurrentTimeMillis5, jCurrentTimeMillis5, "6").setCurrentTime(System.currentTimeMillis()).setSdkVersion(StStrategyManager.getStVerCode() + "").build());
                        com.opos.cmn.an.f.a.a(str2, "update stConfig failed======code=" + j3);
                        if (eVar != null) {
                            eVar.a();
                        }
                    }
                } catch (Throwable th4) {
                    th = th4;
                }
            } catch (Exception e5) {
                e = e5;
                eVar = null;
            } catch (Throwable th5) {
                th = th5;
            }
        } catch (Exception e6) {
            com.opos.cmn.an.f.a.c(f6022a, "", e6);
        }
        if (z2 || aVar == null) {
            return;
        }
        aVar.a();
    }

    private boolean a(Context context, String str) {
        boolean z = false;
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                if (!b(context, str) && !c(context, str) && !d(context, str)) {
                    z = true;
                }
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.c(f6022a, "", e2);
            }
        }
        com.opos.cmn.an.f.a.a(f6022a, "isLegalReq :" + z + ",dataType :" + str);
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(String str) {
        boolean zF = com.opos.cmn.biz.ststrategy.utils.d.f(this.b);
        long jB = com.opos.cmn.biz.ststrategy.utils.d.b(this.b, str);
        long jA = com.opos.cmn.biz.ststrategy.utils.d.a(this.b);
        boolean zC = com.opos.cmn.biz.ststrategy.utils.e.c(this.b);
        boolean z = (zC && 0 != jB && System.currentTimeMillis() < (60000 * jA) + jB && f.b(this.b) && zF) ? false : true;
        com.opos.cmn.an.f.a.a(f6022a, "needUpdateStConfigs," + z + ",pkgName =" + str + zC + ",ntLimit=" + jA + ",lastTime=" + jB + ",nowTime=" + System.currentTimeMillis());
        return z;
    }

    private byte[] a(String str, boolean z) {
        String str2;
        String str3 = f6022a;
        com.opos.cmn.an.f.a.b(str3, "getReqConfigContent");
        byte[] bytes = null;
        if (this.b == null || TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("model", c.a());
            jSONObject2.put("osVersion", com.opos.cmn.an.c.d.a());
            jSONObject2.put("ptoVer", StStrategyManager.getStVerCode());
            jSONObject2.put("region", com.opos.cmn.biz.a.d.a(this.b));
            jSONObject2.put("brand", com.opos.cmn.biz.a.b.a(this.b));
            jSONObject2.put("duId", com.opos.cmn.g.a.b.b(this.b));
            jSONObject2.put("ouId", com.opos.cmn.g.a.b.a(this.b));
            jSONObject2.put("anId", com.opos.cmn.an.c.e.a(this.b));
            jSONObject2.put("ouIdStatus", com.opos.cmn.g.a.b.g(this.b));
            jSONObject2.put("from", "client");
            JSONObject jSONObject3 = new JSONObject();
            if (z) {
                if (com.opos.cmn.biz.ststrategy.utils.a.c.equals(str)) {
                    str2 = com.opos.cmn.biz.ststrategy.utils.a.b;
                } else if (com.opos.cmn.biz.ststrategy.utils.a.d.equals(str)) {
                    str2 = BaseConstants.KLLK_PROMOTION_NORMAL_PKG_INFO;
                } else if ("com.opos.st.demo".equals(str)) {
                    str2 = com.opos.cmn.biz.ststrategy.utils.a.b;
                } else {
                    jSONObject3.put(com.hihonor.adsdk.base.c.r1.hnadse, str);
                }
                jSONObject3.put(com.hihonor.adsdk.base.c.r1.hnadse, str2);
            } else {
                jSONObject3.put("dataType", str);
            }
            if (!f.b(this.b) || !z) {
                jSONObject3.put("currTime", 0);
            } else if (z) {
                jSONObject3.put("currTime", com.opos.cmn.biz.ststrategy.utils.d.c(this.b, str));
            }
            jSONObject.put(TtmlNode.TAG_HEAD, jSONObject2);
            jSONObject.put(TtmlNode.TAG_BODY, jSONObject3);
            bytes = jSONObject.toString().getBytes("UTF-8");
            com.opos.cmn.an.f.a.b(str3, "req st config content=" + jSONObject.toString());
            return bytes;
        } catch (UnsupportedEncodingException | JSONException e2) {
            com.opos.cmn.an.f.a.c(f6022a, "", e2);
            return bytes;
        }
    }

    private synchronized AtomicBoolean b(String str) {
        AtomicBoolean atomicBoolean;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (c.containsKey(str)) {
            atomicBoolean = c.get(str);
        } else {
            AtomicBoolean atomicBoolean2 = new AtomicBoolean(false);
            c.put(str, atomicBoolean2);
            atomicBoolean = atomicBoolean2;
        }
        return atomicBoolean;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(UpdateSTConfigListener updateSTConfigListener) {
        if (updateSTConfigListener != null) {
            updateSTConfigListener.onSuccess();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final String str, final UpdateSTConfigListener updateSTConfigListener) {
        String str2 = f6022a;
        com.opos.cmn.an.f.a.a(str2, "update STConfigs by dataType begin======" + str);
        if (TextUtils.isEmpty(str)) {
            com.opos.cmn.an.f.a.b(str2, "updateSTConfigsByDataType Params dataType is null");
            a(updateSTConfigListener);
            return;
        }
        AtomicBoolean atomicBooleanB = b(str);
        if (atomicBooleanB == null || !atomicBooleanB.compareAndSet(false, true)) {
            com.opos.cmn.an.f.a.a(str2, "already update stConfig by dataType, do nothing!!!");
            c(updateSTConfigListener);
        } else {
            com.opos.cmn.an.f.a.b(str2, "has no initted.init!!!");
            try {
                if (a(this.b, str)) {
                    a(str, false, new com.opos.cmn.biz.ststrategy.listener.a() { // from class: com.opos.cmn.biz.ststrategy.impl.a.3
                        @Override // com.opos.cmn.biz.ststrategy.listener.a
                        public void a() {
                            a.this.a(updateSTConfigListener);
                        }

                        @Override // com.opos.cmn.biz.ststrategy.listener.a
                        public void a(e eVar) {
                            JSONObject jSONObjectA = com.opos.cmn.biz.ststrategy.utils.e.a(a.this.b, eVar);
                            int iA = a.this.a(jSONObjectA);
                            if (iA == 0) {
                                if (com.opos.cmn.biz.ststrategy.utils.e.b(a.this.b, jSONObjectA)) {
                                    a.this.b(updateSTConfigListener);
                                    return;
                                }
                            } else if (iA == -3) {
                                long jCurrentTimeMillis = System.currentTimeMillis();
                                a aVar = a.this;
                                if (aVar.e(aVar.b, str)) {
                                    com.opos.cmn.an.f.a.b(a.f6022a, "set first Req dataType:" + str + ",currTime=" + jCurrentTimeMillis);
                                    com.opos.cmn.biz.ststrategy.utils.d.c(a.this.b, str, jCurrentTimeMillis);
                                }
                                com.opos.cmn.biz.ststrategy.utils.d.d(a.this.b, str, jCurrentTimeMillis);
                            }
                            a.this.a(updateSTConfigListener);
                        }
                    });
                } else {
                    a(updateSTConfigListener);
                }
                atomicBooleanB.set(false);
            } catch (Throwable th) {
                atomicBooleanB.set(false);
                throw th;
            }
        }
        com.opos.cmn.an.f.a.b(str2, "update STConfigs by dataType end:" + str);
    }

    private boolean b(Context context, String str) {
        STConfigEntity sTConfigEntityA;
        boolean z = (context == null || TextUtils.isEmpty(str) || (sTConfigEntityA = com.opos.cmn.biz.ststrategy.utils.e.a()) == null || sTConfigEntityA.dataEntity == null || sTConfigEntityA.dataEntity.metaEntityMap == null || !sTConfigEntityA.dataEntity.metaEntityMap.containsKey(str)) ? false : true;
        com.opos.cmn.an.f.a.b(f6022a, " dataType:" + str + " is included in strategy result:" + z);
        return z;
    }

    private Map<String, String> c() {
        HashMap map = new HashMap();
        map.put("Content-type", "application/json");
        map.put("Accept-Charset", "UTF-8");
        map.put("Connection", "Keep-Alive");
        map.put("Route-Data", com.opos.cmn.biz.a.e.a(this.b));
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(UpdateSTConfigListener updateSTConfigListener) {
        if (updateSTConfigListener != null) {
            updateSTConfigListener.onNotNeedUpdate();
        }
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0026  */
    private boolean c(Context context, String str) {
        boolean z;
        if (context == null || TextUtils.isEmpty(str)) {
            z = false;
        } else {
            long jD = com.opos.cmn.biz.ststrategy.utils.d.d(context, str);
            if (0 != jD) {
                if (System.currentTimeMillis() - jD > ((long) com.opos.cmn.biz.ststrategy.utils.d.d(context)) * 60000) {
                    z = true;
                } else {
                    z = false;
                }
            } else {
                z = false;
            }
        }
        com.opos.cmn.an.f.a.b(f6022a, "isInBlackList :" + z + ",dataType :" + str);
        return z;
    }

    private void d() {
        if (d == null) {
            synchronized (e) {
                if (d == null) {
                    d = new com.opos.cmn.an.j.a.C0869a().a(1).b(1).a("cmn_strategy_single").a();
                }
            }
        }
    }

    private boolean d(Context context, String str) {
        boolean z = false;
        if (context != null && !TextUtils.isEmpty(str)) {
            long jE = com.opos.cmn.biz.ststrategy.utils.d.e(context, str);
            if (0 != jE) {
                if (System.currentTimeMillis() - jE < ((long) com.opos.cmn.biz.ststrategy.utils.d.c(context)) * 60000) {
                    z = true;
                }
            }
            com.opos.cmn.an.f.a.b(f6022a, "isWithinDTLimitTime firstInDTLimit:" + jE + ", result :" + z);
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean e(Context context, String str) {
        boolean z = (context == null || TextUtils.isEmpty(str) || com.opos.cmn.biz.ststrategy.utils.d.d(context, str) != 0) ? false : true;
        com.opos.cmn.an.f.a.b(f6022a, "isFirstSupplyReq result:" + z);
        return z;
    }

    @Override // com.opos.cmn.biz.ststrategy.interfaces.a
    public STConfigEntity a() {
        return com.opos.cmn.biz.ststrategy.utils.e.a(this.b);
    }

    @Override // com.opos.cmn.biz.ststrategy.interfaces.a
    public void a(final UpdateParams updateParams, final UpdateSTConfigListener updateSTConfigListener) {
        String str;
        String str2 = f6022a;
        com.opos.cmn.an.f.a.a(str2, "begin update STConfigs by PkgName======" + updateParams);
        if (updateParams == null) {
            str = "update Params is null";
        } else {
            if (!TextUtils.isEmpty(updateParams.pkgName)) {
                final AtomicBoolean atomicBooleanB = b(updateParams.pkgName);
                if (atomicBooleanB == null || !atomicBooleanB.compareAndSet(false, true)) {
                    com.opos.cmn.an.f.a.a(str2, "already update stConfig by pkgName, do nothing!!!");
                    c(updateSTConfigListener);
                    return;
                } else {
                    com.opos.cmn.an.f.a.b(str2, "has no initted.init!!!");
                    com.opos.cmn.an.j.b.a().execute(new Runnable() { // from class: com.opos.cmn.biz.ststrategy.impl.a.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                if (a.this.a(updateParams.pkgName)) {
                                    a.this.a(updateParams.pkgName, true, new com.opos.cmn.biz.ststrategy.listener.a() { // from class: com.opos.cmn.biz.ststrategy.impl.a.1.1
                                        @Override // com.opos.cmn.biz.ststrategy.listener.a
                                        public void a() {
                                            a.this.a(updateSTConfigListener);
                                        }

                                        @Override // com.opos.cmn.biz.ststrategy.listener.a
                                        public void a(e eVar) {
                                            long jCurrentTimeMillis = System.currentTimeMillis();
                                            com.opos.cmn.biz.ststrategy.utils.d.a(a.this.b, updateParams.pkgName, jCurrentTimeMillis);
                                            com.opos.cmn.an.f.a.b(a.f6022a, "set pkgName:" + updateParams.pkgName + ",lastTime=" + jCurrentTimeMillis);
                                            JSONObject jSONObjectA = com.opos.cmn.biz.ststrategy.utils.e.a(a.this.b, eVar);
                                            if (a.this.a(jSONObjectA) != 0 || !com.opos.cmn.biz.ststrategy.utils.e.b(a.this.b, jSONObjectA)) {
                                                a.this.a(updateSTConfigListener);
                                                return;
                                            }
                                            com.opos.cmn.biz.ststrategy.utils.d.e(a.this.b);
                                            com.opos.cmn.biz.ststrategy.utils.d.b(a.this.b, updateParams.pkgName, com.opos.cmn.biz.ststrategy.utils.e.a(a.this.b, jSONObjectA));
                                            a.this.b(updateSTConfigListener);
                                        }
                                    });
                                } else {
                                    com.opos.cmn.an.f.a.a(a.f6022a, "don't need update stConfigs,no overdue");
                                    a.this.c(updateSTConfigListener);
                                }
                            } finally {
                                atomicBooleanB.set(false);
                            }
                        }
                    });
                    return;
                }
            }
            str = "update Params pkgName is null";
        }
        com.opos.cmn.an.f.a.c(str2, str);
        a(updateSTConfigListener);
    }

    @Override // com.opos.cmn.biz.ststrategy.interfaces.a
    public void a(final String str, final UpdateSTConfigListener updateSTConfigListener) {
        d();
        com.opos.cmn.an.j.a aVar = d;
        if (aVar != null) {
            try {
                aVar.execute(new Runnable() { // from class: com.opos.cmn.biz.ststrategy.impl.a.2
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.b(str, updateSTConfigListener);
                    }
                });
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.c("ThreadPoolTool", "executeSingleTask", e2);
            }
        }
    }
}
