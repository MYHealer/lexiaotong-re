package com.ubixnow.ooooo;

import com.ubixnow.core.api.UMNAdManager;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class o0OOO0OO extends z0 {
    public static final String OooO0OO = "----o0OOO0OO";
    public static long OooO0Oo;
    private int OooO0o0;

    public o0OOO0OO(int i) {
        OooO0Oo = System.currentTimeMillis();
        this.OooO0o0 = i;
    }

    private void OooO00o(oO0O00 oo0o00) {
        Lock lockWriteLock;
        try {
            try {
                ReadWriteLock readWriteLock = o0O.OooO0O0;
                readWriteLock.writeLock().lock();
                int i = oo0o00.OooO0OO;
                if (i == 1) {
                    if (oo0o00.OooO0o0) {
                        oO0O000o[] oo0o000oArr = oo0o00.OooO0Oo;
                        if (oo0o000oArr == null || oo0o000oArr.length <= 0) {
                            o0O.OooO00o = null;
                            oOo00o00.OooO0O0(UMNAdManager.getInstance().getAppId() + oO00000o.o00000O0.Oooo0O0);
                        } else {
                            o0O.OooO00o = oo0o000oArr;
                            oOo00o00.OooO00o(UMNAdManager.getInstance().getAppId() + oO00000o.o00000O0.Oooo0O0, System.currentTimeMillis(), oo0o00.OooO0o.getBytes(), oOo0000O.OooO00o(oo0o00));
                        }
                    }
                } else if (i == 2) {
                    o0O.OooO00o = null;
                    oOo00o00.OooO0O0(UMNAdManager.getInstance().getAppId() + oO00000o.o00000O0.Oooo0O0);
                }
                if (ooooO000.OooO00o && o0O.OooO00o != null) {
                    ooooO000.OooO0O0(OooO0OO, "block content:" + Arrays.toString(o0O.OooO00o));
                }
                lockWriteLock = readWriteLock.writeLock();
            } catch (Exception e) {
                e.printStackTrace();
                lockWriteLock = o0O.OooO0O0.writeLock();
            }
            lockWriteLock.unlock();
        } catch (Throwable th) {
            o0O.OooO0O0.writeLock().unlock();
            throw th;
        }
    }

    private void OooO00o(oO0O00oO oo0o00oo) {
        if (oo0o00oo != null) {
            oOO00O.OooO00o(oo0o00oo.OooO0o0);
            oO0O0O00 oo0o0o00 = oo0o00oo.OooO0OO;
            if (oo0o0o00 != null) {
                OooO00o(oo0o0o00);
            }
            oO0O00O oo0o00o = oo0o00oo.OooO0Oo;
            if (oo0o00o != null) {
                if (oo0o00o.OooO0OO != 0) {
                    oOo00o00.OooO0O0(oO00000o.o00000O0.OooOoO0);
                } else {
                    oO0OOo0o[] oo0ooo0oArr = oo0o00o.OooO0Oo;
                    if (oo0ooo0oArr != null) {
                        for (oO0OOo0o oo0ooo0o : oo0ooo0oArr) {
                            if (oo0ooo0o.OooO0OO == 0) {
                                OooO00o(oo0ooo0o);
                            } else {
                                oOo00o00.OooO0O0(UMNAdManager.getInstance().getAppId() + oO00000o.o00000O0.OooOoO0 + oo0ooo0o.OooO);
                            }
                        }
                    }
                }
            }
            oO0O00 oo0o00 = oo0o00oo.OooO0o;
            if (oo0o00 != null) {
                OooO00o(oo0o00);
            }
        }
    }

    private void OooO00o(oO0O0O00 oo0o0o00) {
        oO00000o.o00O0O.OooO00o = oo0o0o00.Oooo00O;
        if (oo0o0o00.OooOoo != 0) {
            o0OO000.OooO00o(o0OO000o.OooO0oO, o0OO000.OooO00o(o0OO000o.OooOO0O, "初始化网络失败", oo0o0o00.OooOoo + ""), new Object[0]);
            ooooO000.OooO0O0("初始化网络失败");
            return;
        }
        if (ooooO000.OooO00o) {
            ooooO000.OooO0OO("-----InitProcessor", oO0Oo0o0.OooO0O0().OooO0O0(oOo0000O.OooO00o(oo0o0o00)));
        }
        if (oo0o0o00.Oooo0) {
            oOo00o00.OooO00o(String.format(oO00000o.o00000O0.OooO00o, UMNAdManager.getInstance().mConfig.appId), oO0Oo0o0.OooO0O0().OooO0O0(oOo0000O.OooO00o(oo0o0o00)));
            o0OOO0.OooO00o = oo0o0o00;
            o0OOO0.OooO0O0();
        }
    }

    private void OooO00o(oO0OOo0o oo0ooo0o) {
        try {
            String str = UMNAdManager.getInstance().mConfig.appId;
            String str2 = oo0ooo0o.OooO;
            if (oo0ooo0o.OooO0o) {
                oO00OOO oo00ooo = new oO00OOO();
                oo00ooo.OooO0OO = str;
                oo00ooo.OooO0Oo = str2;
                oo00ooo.OooO0o0 = oo0ooo0o.OooO0o0[0].OooO0o0;
                oo00ooo.OooO0o = oo0ooo0o.OooO0oO;
                oOo00o00.OooO00o(str + oO00000o.o00000O0.OooOoO0 + str2, System.currentTimeMillis(), oOo0000O.OooO00o(oo00ooo), oOo0000O.OooO00o(oo0ooo0o));
                oOo00o00.OooO00o(oO00000o.o00000O0.OooOoO + oo0ooo0o.OooO, "1");
                oO0OOo0o.OooO00o[] oooO00oArr = oo0ooo0o.OooO0o0;
                o0o0000.OooO00o(str2, oooO00oArr[0].OooOo, oooO00oArr[0].OooO0oO);
            } else {
                oOo00o00.OooO0O0(str + oO00000o.o00000O0.OooOoO0 + str2, System.currentTimeMillis());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.ubixnow.ooooo.z0
    public a1 OooO00o() {
        return new o0OOOO00(null, this.OooO0o0);
    }

    /* JADX WARN: Code duplicated, block: B:10:0x002e  */
    @Override // com.ubixnow.ooooo.c1
    public void OooO00o(b1 b1Var) {
        if (b1Var != null) {
            try {
                if (b1Var.OooO0O0() == 200) {
                    OooO00o(oO0O00oO.OooO00o(oO0000O.OooO0o0(oO0000O.OooO00o(b1Var.OooO0Oo()))));
                    ooooO000.OooO0O0(OooO0OO, "全量配置更新完毕");
                } else {
                    o0OO000.OooO00o(o0OO000o.OooO0oO, o0OO000.OooO00o(o0OO000o.OooOO0, "http code: " + b1Var.OooO0O0(), b1Var.OooO0O0() + ""), new Object[0]);
                }
            } catch (Exception e) {
                o0OO000.OooO00o(o0OO000o.OooO0oO, o0OO000.OooO00o(o0OO000o.OooO, e.getMessage(), ""), new Object[0]);
                e.printStackTrace();
            }
        } else {
            o0OO000.OooO00o(o0OO000o.OooO0oO, o0OO000.OooO00o(o0OO000o.OooOO0, "http code: " + b1Var.OooO0O0(), b1Var.OooO0O0() + ""), new Object[0]);
        }
    }

    @Override // com.ubixnow.ooooo.c1
    public void OooO00o(oOO00OO ooo00oo) {
        ooooO000.OooO0O0(ooo00oo.toString());
        o0OO000.OooO00o(o0OO000o.OooO0oO, o0OO000.OooO00o(o0OO000o.OooO0oo, oOO00O0.networkErrorMsg, ooo00oo.code), new Object[0]);
    }

    @Override // com.ubixnow.ooooo.z0
    public z0.OooO0O0 OooO0OO() {
        return z0.OooO0O0.INIT;
    }
}
