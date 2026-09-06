package com.ubixnow.ooooo;

import android.text.TextUtils;
import java.net.URI;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class o0O000o0 implements o0O000<oo00o> {
    public static final String OooO00o = "----o0O000o0";
    public static final int OooO0O0 = 30;
    public static final int OooO0OO = 31;
    public static final int OooO0Oo = 32;
    public static final int OooO0o = 34;
    public static final int OooO0o0 = 33;
    public static final int OooO0oO = 20;
    private oO00OOOo OooO0oo;

    public class OooO00o implements Runnable {
        public final /* synthetic */ oo00o OooO00o;
        public final /* synthetic */ o0O000O OooO0O0;
        public final /* synthetic */ o00O0 OooO0OO;

        public OooO00o(oo00o oo00oVar, o0O000O o0o000o, o00O0 o00o0) {
            this.OooO00o = oo00oVar;
            this.OooO0O0 = o0o000o;
            this.OooO0OO = o00o0;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                o0O000Oo o0o000ooOooO0O0 = o0O000o0.this.OooO0O0(this.OooO00o);
                if (o0o000ooOooO0O0 != null) {
                    this.OooO0O0.OooO00o(o0o000ooOooO0O0);
                    return;
                }
                o0O0oo00 o0o0oo00OooO0OO = o0O000o0.this.OooO0OO(this.OooO00o);
                this.OooO00o.materialStatus = o0O000o0.this.OooO0oo;
                oO00OOOo oo00oooo = this.OooO00o.materialStatus;
                if (oo00oooo != null) {
                    this.OooO0OO.OooOo00.add(oo00oooo);
                }
                if (o0o0oo00OooO0OO == null) {
                    this.OooO0O0.OooO00o(this.OooO00o);
                } else {
                    this.OooO0O0.OooO00o(new o0O000Oo(4, o0o0oo00OooO0OO));
                }
            } catch (Exception e) {
                ooooO000.OooO00o(e);
            }
        }
    }

    private o0O0oo00 OooO00o(o0oOo0O0 o0ooo0o0, oO0O000o oo0o000o) {
        if (o0ooo0o0.OooO0o == null || oo0o000o.OooO0Oo == null) {
            return null;
        }
        if (TextUtils.isEmpty(o0ooo0o0.OooO0O0) && TextUtils.isEmpty(o0ooo0o0.OooO0OO)) {
            return null;
        }
        String str = o0ooo0o0.OooO0O0;
        String upperCase = str == null ? "" : str.toUpperCase();
        String str2 = o0ooo0o0.OooO0OO;
        String upperCase2 = str2 != null ? str2.toUpperCase() : "";
        String[] strArr = oo0o000o.OooO0Oo;
        int length = strArr.length;
        for (int i = 0; i < length; i++) {
            String str3 = strArr[i];
            if (!TextUtils.isEmpty(str3)) {
                String upperCase3 = str3.toUpperCase();
                if (!upperCase.contains(upperCase3) && !upperCase2.contains(upperCase3)) {
                }
                return new o0O0oo00(str3, oo0o000o.OooO0o);
            }
        }
        return null;
    }

    private String OooO00o(oo00o oo00oVar, o0O0oo00 o0o0oo00) {
        if (o0o0oo00 == null) {
            o0o0oo00 = new o0O0oo00("", "");
        }
        return " Ads Name:" + oO00000o.o0O0O00.OooO00o(oo00oVar.getBaseAdConfig().OooO00o.OooO0OO) + "   Slot Id:" + oo00oVar.getBaseAdConfig().OooO00o.OooO0o0 + "   MaterialFilterInfo info:" + o0o0oo00.toString();
    }

    private void OooO00o(o0O0oo00 o0o0oo00) {
        this.OooO0oo.OooO0oO = new oO00OOo0();
        oO00OOo0 oo00ooo0 = this.OooO0oo.OooO0oO;
        oo00ooo0.OooO0OO = o0o0oo00.OooO0O0;
        oo00ooo0.OooO0Oo = o0o0oo00.OooO00o;
    }

    private void OooO00o(oo00o oo00oVar) {
        oO00OOOo oo00oooo;
        int i;
        if (this.OooO0oo == null) {
            oO00OOOo oo00oooo2 = new oO00OOOo();
            this.OooO0oo = oo00oooo2;
            oo00oooo2.OooO0OO = oo00oVar.getBaseAdConfig().OooO00o.OooO0o0;
            this.OooO0oo.OooO0Oo = oo00oVar.getBaseAdConfig().OooO00o.OooO0OO + "";
            if (oo00oVar.getBaseAdConfig().OooO00o.OooOO0O == 1) {
                oo00oooo = this.OooO0oo;
                i = oo00oVar.getBaseAdConfig().OooO0o;
            } else {
                oo00oooo = this.OooO0oo;
                i = (int) oo00oVar.getBaseAdConfig().OooO00o.OooO;
            }
            oo00oooo.OooO0o0 = i;
        }
    }

    private boolean OooO00o(String str, oO0O000o oo0o000o) {
        try {
            if (o0O.OooO00o != null) {
                if (o0O0ooO.OooO00o.equals(oo0o000o.OooOO0)) {
                    return true;
                }
                for (String str2 : oo0o000o.OooO0OO) {
                    if (str.equals(str2)) {
                        return true;
                    }
                }
            }
        } catch (Exception e) {
            ooooO000.OooO00o(e);
        }
        ooooO000.OooO0O0(OooO00o, "【CMP】: 配置中没有该广告位！");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public o0O000Oo OooO0O0(oo00o oo00oVar) {
        int i = oo00oVar.checkMaterialStatus;
        if (i <= 0) {
            return null;
        }
        if (i == 7) {
            return new o0O000Oo(2, o0OO000o.o00000O, "素材物料异常", oOO00O0.material_problem, "素材物料异常");
        }
        if (i != 10) {
            return i != 11 ? new o0O000Oo(1, o0OO000o.o00000o0, o0OO000o.o0000O0O, o0OO000o.o00000o0, o0OO000o.o0000O0O) : new o0O000Oo(2, o0OO000o.o00000OO, o0OO000o.o0000O0, oOO00O0.material_problem, "素材物料异常");
        }
        oOO00O0.OooO00o oooO00o = oOO00O0.OooO00o.RENDER_TYPE_ERROR;
        return new o0O000Oo(2, o0OO000o.o000000O, o0OO000o.o00000oo, oooO00o.OooO00o(), oooO00o.OooO0O0());
    }

    private o0O0oo00 OooO0O0(o0oOo0O0 o0ooo0o0, oO0O000o oo0o000o) {
        String[] strArr;
        if (TextUtils.isEmpty(o0ooo0o0.OooO0Oo) || (strArr = oo0o000o.OooO) == null) {
            return null;
        }
        for (String str : strArr) {
            if (str.equalsIgnoreCase(o0ooo0o0.OooO0Oo)) {
                return new o0O0oo00(str, oo0o000o.OooO0o);
            }
        }
        return null;
    }

    private o0O0oo00 OooO0O0(String str, oO0O000o oo0o000o) {
        try {
            String host = new URI(str).getHost();
            for (String str2 : oo0o000o.OooO0o0) {
                if (!TextUtils.isEmpty(host) && str2.contains(".") && (host.equalsIgnoreCase(str2) || host.toUpperCase().endsWith("." + str2.toUpperCase()))) {
                    return new o0O0oo00(str2, oo0o000o.OooO0o);
                }
            }
            return null;
        } catch (Exception e) {
            ooooO000.OooO00o(e);
            return null;
        }
    }

    private o0O0oo00 OooO0OO(o0oOo0O0 o0ooo0o0, oO0O000o oo0o000o) {
        String[] strArr;
        List<String> list = o0ooo0o0.OooO00o;
        if (list == null || (strArr = oo0o000o.OooO0oo) == null || strArr.length <= 0) {
            return null;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            try {
                String host = new URI(it.next()).getHost();
                for (String str : oo0o000o.OooO0oo) {
                    if (str.contains(".") && !TextUtils.isEmpty(host) && (host.equalsIgnoreCase(str) || host.toUpperCase().endsWith("." + str.toUpperCase()))) {
                        return new o0O0oo00(str, oo0o000o.OooO0o);
                    }
                }
            } catch (Exception e) {
                ooooO000.OooO00o(e);
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public o0O0oo00 OooO0OO(oo00o oo00oVar) {
        o0O0oo00 o0o0oo00OooO0o0;
        try {
            try {
                o0O.OooO0O0.readLock().lock();
                o0O0o0 o0o0o0 = oo00oVar.material;
                if (o0o0o0 != null && o0o0o0.OooO0o0 != null && o0O.OooO00o != null) {
                    ooooO000.OooO0O0(OooO00o, "【CMP】: 开始进行cmp流程:" + oo00oVar.material.OooO0o0.toString());
                    oO0O000o[] oo0o000oArr = o0O.OooO00o;
                    int length = oo0o000oArr.length;
                    int i = 0;
                    while (true) {
                        if (i < length) {
                            oO0O000o oo0o000o = oo0o000oArr[i];
                            if (OooO00o(oo00oVar.getBaseAdConfig().OooO0O0, oo0o000o)) {
                                OooO00o(oo00oVar);
                                o0o0oo00OooO0o0 = OooO0o0(oo00oVar.material.OooO0o0, oo0o000o);
                                if (o0o0oo00OooO0o0 != null) {
                                    ooooO000.OooO0O0(OooO00o, "【CMP】:协议头过滤：" + OooO00o(oo00oVar, o0o0oo00OooO0o0));
                                    this.OooO0oo.OooO0o = 30;
                                    break;
                                }
                                o0o0oo00OooO0o0 = OooO0Oo(oo00oVar.material.OooO0o0, oo0o000o);
                                if (o0o0oo00OooO0o0 != null) {
                                    ooooO000.OooO0O0(OooO00o, "【CMP】:域名过滤：" + OooO00o(oo00oVar, o0o0oo00OooO0o0));
                                    this.OooO0oo.OooO0o = 31;
                                    break;
                                }
                                o0o0oo00OooO0o0 = OooO0OO(oo00oVar.material.OooO0o0, oo0o000o);
                                if (o0o0oo00OooO0o0 != null) {
                                    ooooO000.OooO0O0(OooO00o, "【CMP】:落地页过滤：" + OooO00o(oo00oVar, o0o0oo00OooO0o0));
                                    this.OooO0oo.OooO0o = 32;
                                    break;
                                }
                                o0o0oo00OooO0o0 = OooO0O0(oo00oVar.material.OooO0o0, oo0o000o);
                                if (o0o0oo00OooO0o0 != null) {
                                    ooooO000.OooO0O0(OooO00o, "【CMP】:预算包名过滤：" + OooO00o(oo00oVar, o0o0oo00OooO0o0));
                                    this.OooO0oo.OooO0o = 33;
                                    break;
                                }
                                o0O0oo00 o0o0oo00OooO00o = OooO00o(oo00oVar.material.OooO0o0, oo0o000o);
                                if (o0o0oo00OooO00o != null) {
                                    ooooO000.OooO0O0(OooO00o, "【CMP】:关键词过滤：" + OooO00o(oo00oVar, o0o0oo00OooO00o));
                                    this.OooO0oo.OooO0o = 34;
                                    OooO00o(o0o0oo00OooO00o);
                                    o0O.OooO0O0.readLock().unlock();
                                    return o0o0oo00OooO00o;
                                }
                            }
                            i++;
                        } else if (this.OooO0oo != null) {
                            ooooO000.OooO0O0(OooO00o, "【CMP】: 通过！");
                            this.OooO0oo.OooO0o = 20;
                        }
                    }
                    OooO00o(o0o0oo00OooO0o0);
                    o0O.OooO0O0.readLock().unlock();
                    return o0o0oo00OooO0o0;
                }
            } catch (Exception e) {
                ooooO000.OooO00o(e);
            }
            o0O.OooO0O0.readLock().unlock();
            return null;
        } catch (Throwable th) {
            o0O.OooO0O0.readLock().unlock();
            throw th;
        }
    }

    private o0O0oo00 OooO0Oo(o0oOo0O0 o0ooo0o0, oO0O000o oo0o000o) {
        String[] strArr;
        o0O0oo00 o0o0oo00OooO0O0;
        List<oo0OOoo> list = o0ooo0o0.OooO0o;
        if (list == null || (strArr = oo0o000o.OooO0o0) == null || strArr.length <= 0) {
            return null;
        }
        for (oo0OOoo oo0oooo : list) {
            if (!TextUtils.isEmpty(oo0oooo.OooO0o0())) {
                if ("1".equals(o0ooo0o0.OooO0o0)) {
                    if (oo0oooo.OooO00o == 1) {
                        return OooO0O0(oo0oooo.OooO0o0(), oo0o000o);
                    }
                } else if ("2".equals(o0ooo0o0.OooO0o0) && oo0oooo.OooO00o == 2 && (o0o0oo00OooO0O0 = OooO0O0(oo0oooo.OooO0o0(), oo0o000o)) != null) {
                    return o0o0oo00OooO0O0;
                }
            }
        }
        return null;
    }

    private o0O0oo00 OooO0o0(o0oOo0O0 o0ooo0o0, oO0O000o oo0o000o) {
        String[] strArr;
        if (o0ooo0o0.OooO00o.isEmpty() || (strArr = oo0o000o.OooO0oO) == null || strArr.length <= 0) {
            return null;
        }
        Iterator<String> it = o0ooo0o0.OooO00o.iterator();
        while (it.hasNext()) {
            try {
                String scheme = new URI(it.next()).getScheme();
                if (!TextUtils.isEmpty(scheme)) {
                    for (String str : oo0o000o.OooO0oO) {
                        if (!str.equals("*") && !str.equals("**")) {
                            if (str.startsWith("*") && str.endsWith("*")) {
                                String strSubstring = str.substring(1, str.length() - 1);
                                if (!TextUtils.isEmpty(strSubstring) && scheme.toUpperCase().contains(strSubstring.toUpperCase())) {
                                    return new o0O0oo00(str, oo0o000o.OooO0o);
                                }
                            } else if (str.startsWith("*")) {
                                String strSubstring2 = str.substring(1);
                                if (!TextUtils.isEmpty(strSubstring2) && scheme.toUpperCase().endsWith(strSubstring2.toUpperCase())) {
                                    return new o0O0oo00(str, oo0o000o.OooO0o);
                                }
                            } else if (str.endsWith("*")) {
                                String strSubstring3 = str.substring(0, str.length() - 1);
                                if (!TextUtils.isEmpty(strSubstring3) && scheme.toUpperCase().startsWith(strSubstring3.toUpperCase())) {
                                    return new o0O0oo00(str, oo0o000o.OooO0o);
                                }
                            }
                            if (scheme.equalsIgnoreCase(str)) {
                                return new o0O0oo00(str, oo0o000o.OooO0o);
                            }
                        }
                    }
                }
            } catch (Exception e) {
                ooooO000.OooO00o(e);
            }
        }
        return null;
    }

    @Override // com.ubixnow.ooooo.o0O000
    public void OooO00o(o00O0 o00o0, oo00o oo00oVar, o0OoOoOo<oo00o> o0oooooo, o0O000O<oo00o> o0o000o) {
        g1.OooO0Oo().OooO0OO(new OooO00o(oo00oVar, o0o000o, o00o0));
    }
}
