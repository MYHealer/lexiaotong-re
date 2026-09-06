package com.ubixnow.ooooo;

import android.text.TextUtils;
import com.ubixnow.core.utils.error.ErrorInfo;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class oO0Oo extends z0 {
    private final o00O0 OooO0OO;
    private final o0oo0000 OooO0Oo;
    private boolean OooO0o0;

    public oO0Oo(o00O0 o00o0, o0oo0000 o0oo0000Var) {
        this.OooO0OO = o00o0;
        this.OooO0o0 = !o00o0.OooOO0o;
        this.OooO0Oo = o0oo0000Var;
    }

    @Override // com.ubixnow.ooooo.z0
    public a1 OooO00o() {
        return new o0OOOO00(this.OooO0OO, 2);
    }

    /* JADX WARN: Code duplicated, block: B:37:0x01b7 A[Catch: Exception -> 0x0202, TryCatch #1 {Exception -> 0x0202, blocks: (B:6:0x0025, B:8:0x0029, B:10:0x002c, B:12:0x0032, B:14:0x003b, B:16:0x003f, B:17:0x004e, B:24:0x0137, B:27:0x013c, B:29:0x0146, B:31:0x014a, B:34:0x015a, B:18:0x00d9, B:20:0x0104, B:22:0x0107, B:23:0x010b, B:35:0x016c, B:36:0x01b4, B:38:0x01fe, B:37:0x01b7), top: B:47:0x0025 }] */
    @Override // com.ubixnow.ooooo.c1
    public void OooO00o(b1 b1Var) {
        o00O0 o00o0;
        ErrorInfo errorInfo;
        boolean z;
        ooooO000.OooO0O0("----RequestAdProcessor ", "更新线上策略完毕");
        int i = 0;
        try {
            byte[] bArrOooO00o = oO0000O.OooO00o(b1Var.OooO0Oo());
            oO0O00O oo0o00o = oO0O00oO.OooO00o(oO0000O.OooO0o0(bArrOooO00o)).OooO0Oo;
            int i2 = oo0o00o.OooO0OO;
            if (i2 == 0) {
                try {
                    oO0OOo0o[] oo0ooo0oArr = oo0o00o.OooO0Oo;
                    if (oo0ooo0oArr == null || oo0ooo0oArr.length <= 0) {
                        oOo00o00.OooO0O0(this.OooO0OO.OooO0O0.appId + oO00000o.o00000O0.OooOoO0 + this.OooO0OO.OooO0Oo.OooO00o.slotId);
                        o00o0 = this.OooO0OO;
                        errorInfo = new ErrorInfo(o0OO000o.Oooo0o0, "请求响应解析异常或无配置项", i2 + "", "");
                        z = this.OooO0o0;
                    } else {
                        oO0OOo0o oo0ooo0oOooO00o = oo0ooo0oArr[0];
                        if (oo0ooo0oOooO00o.OooO0OO == 0) {
                            oOO00O.OooO00o(oo0ooo0oOooO00o.OooO0oo);
                            if (oo0ooo0oOooO00o.OooO0o) {
                                if (ooooO000.OooO00o) {
                                    ooooO000.OooO0OO("----RequestAdProcessor ", oO0Oo0o0.OooO0O0().OooO0O0(oO0000O.OooO0o0(bArrOooO00o)));
                                }
                                oO00OOO oo00ooo = new oO00OOO();
                                o00O0 o00o1 = this.OooO0OO;
                                oo00ooo.OooO0OO = o00o1.OooO0O0.appId;
                                oo00ooo.OooO0o0 = oo0ooo0oOooO00o.OooO0o0[0].OooO0o0;
                                oo00ooo.OooO0Oo = o00o1.OooO0Oo.OooO00o.slotId;
                                oo00ooo.OooO0o = oo0ooo0oOooO00o.OooO0oO;
                                oOo00o00.OooO00o(this.OooO0OO.OooO0O0.appId + oO00000o.o00000O0.OooOoO0 + this.OooO0OO.OooO0Oo.OooO00o.slotId, System.currentTimeMillis(), oOo0000O.OooO00o(oo00ooo), oOo0000O.OooO00o(oo0ooo0oOooO00o));
                                String str = this.OooO0OO.OooO0Oo.OooO00o.slotId;
                                oO0OOo0o.OooO00o[] oooO00oArr = oo0ooo0oOooO00o.OooO0o0;
                                o0o0000.OooO00o(str, oooO00oArr[0].OooOo, oooO00oArr[0].OooO0oO);
                                oOo00o00.OooO00o(oO00000o.o00000O0.OooOoO + this.OooO0OO.OooO0Oo.OooO00o.slotId, "1");
                            } else {
                                byte[] bArrOooO0oo = oOo00o00.OooO0oo(this.OooO0OO.OooO0O0.appId + oO00000o.o00000O0.OooOoO0 + this.OooO0OO.OooO0Oo.OooO00o.slotId);
                                if (bArrOooO0oo != null && bArrOooO0oo.length > 0) {
                                    oo0ooo0oOooO00o = oO0OOo0o.OooO00o(bArrOooO0oo);
                                }
                                oOo00o00.OooO0O0(this.OooO0OO.OooO0O0.appId + oO00000o.o00000O0.OooOoO0 + this.OooO0OO.OooO0Oo.OooO00o.slotId, System.currentTimeMillis());
                            }
                            if (this.OooO0o0) {
                                o00O0 o00o2 = this.OooO0OO;
                                o00o2.OooOOOO = oo0ooo0oOooO00o;
                                ErrorInfo errorInfoOooO00o = o0o0000.OooO00o(o00o2);
                                if (errorInfoOooO00o != null) {
                                    ooooO000.OooO0O0("-----Request error:", errorInfoOooO00o.toString());
                                    ooo0Oo0.OooO00o(this.OooO0OO, errorInfoOooO00o, this.OooO0o0, this.OooO0Oo);
                                    return;
                                }
                                boolean z2 = this.OooO0o0;
                                if (z2) {
                                    ooo0Oo0.OooO00o(this.OooO0OO, z2);
                                    this.OooO0Oo.OooO00o(this.OooO0OO);
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        oOo00o00.OooO0O0(this.OooO0OO.OooO0O0.appId + oO00000o.o00000O0.OooOoO0 + this.OooO0OO.OooO0Oo.OooO00o.slotId);
                        o00o0 = this.OooO0OO;
                        errorInfo = new ErrorInfo(o0OO000o.Oooo0o0, "请求响应解析异常或无配置项", oo0ooo0oOooO00o.OooO0OO + "", "");
                        z = this.OooO0o0;
                    }
                } catch (Exception e) {
                    e = e;
                    i = i2;
                    ooo0Oo0.OooO0O0(this.OooO0OO, new ErrorInfo(o0OO000o.Oooo0o, oOO00O0.ubix_pbparse_error_msg + e.getMessage(), i + "", ""), this.OooO0o0, this.OooO0Oo);
                    return;
                }
            } else {
                oOo00o00.OooO0O0(this.OooO0OO.OooO0O0.appId + oO00000o.o00000O0.OooOoO0 + this.OooO0OO.OooO0Oo.OooO00o.slotId);
                o00o0 = this.OooO0OO;
                errorInfo = new ErrorInfo(o0OO000o.Oooo0o0, "请求响应解析异常或无配置项", i2 + "", "");
                z = this.OooO0o0;
            }
            ooo0Oo0.OooO0O0(o00o0, errorInfo, z, this.OooO0Oo);
        } catch (Exception e2) {
            e = e2;
        }
    }

    @Override // com.ubixnow.ooooo.c1
    public void OooO00o(oOO00OO ooo00oo) {
        if (!TextUtils.isEmpty(ooo00oo.msg) && !ooo00oo.msg.contains("没有网络连接")) {
            ooo00oo.msg = oOO00O0.networkErrorMsg;
        }
        ooo0Oo0.OooO0O0(this.OooO0OO, new ErrorInfo(o0OO000o.Oooo0oO, ooo00oo.msg, ooo00oo.code + "", ""), this.OooO0o0, this.OooO0Oo);
    }

    @Override // com.ubixnow.ooooo.z0
    public z0.OooO0O0 OooO0OO() {
        return z0.OooO0O0.REQUESTAD;
    }
}
