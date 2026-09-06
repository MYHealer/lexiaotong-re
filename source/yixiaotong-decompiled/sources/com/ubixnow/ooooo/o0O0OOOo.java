package com.ubixnow.ooooo;

import android.text.TextUtils;
import java.util.Random;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class o0O0OOOo {
    public static String OooO00o = "@clicktime";
    public static String OooO0O0 = "@data";

    public class OooO00o implements Runnable {
        public final /* synthetic */ oo00o OooO00o;

        public OooO00o(oo00o oo00oVar) {
            this.OooO00o = oo00oVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            StringBuilder sbAppend;
            try {
                String str = this.OooO00o.getBaseAdConfig().OooO00o.OooO0Oo + "_" + this.OooO00o.getBaseAdConfig().OooO00o.OooO0o0 + o0O0OOOo.OooO00o;
                String str2 = this.OooO00o.getBaseAdConfig().OooO00o.OooO0Oo + "_" + this.OooO00o.getBaseAdConfig().OooO00o.OooO0o0 + o0O0OOOo.OooO0O0;
                oOo00o00.OooO00o(str, System.currentTimeMillis());
                String strOooO0o0 = oOo00o00.OooO0o0(str2);
                if (TextUtils.isEmpty(strOooO0o0)) {
                    sbAppend = new StringBuilder().append(oO0000O.OooO00o()).append("@1");
                } else {
                    String[] strArrSplit = strOooO0o0.split("@");
                    if (oO0000O.OooO00o().equals(strArrSplit[0])) {
                        sbAppend = new StringBuilder().append(oO0000O.OooO00o()).append("@").append(Integer.parseInt(strArrSplit[1]) + 1);
                    } else {
                        sbAppend = new StringBuilder().append(oO0000O.OooO00o()).append("@1");
                    }
                }
                oOo00o00.OooO00o(str2, sbAppend.toString());
            } catch (Exception e) {
                ooooO000.OooO00o(e);
            }
        }
    }

    public static long OooO00o(String str) {
        return oOo00o00.OooO0Oo(str);
    }

    public static void OooO00o(oo00o oo00oVar) {
        g1.OooO00o("control").OooO0OO(new OooO00o(oo00oVar));
    }

    public static boolean OooO00o(oO0O0OoO oo0o0ooo, oOO00O ooo00o) {
        String str;
        String str2;
        String str3 = oo0o0ooo.OooO0Oo + "_" + oo0o0ooo.OooO0o0 + OooO00o;
        String str4 = oo0o0ooo.OooO0Oo + "_" + oo0o0ooo.OooO0o0 + OooO0O0;
        if (ooo00o.OooOoO0 && OooO00o(ooo00o)) {
            if (ooo00o.OooOo0 == 0) {
                ooooO000.OooO0OO(ooooO000.OooO0OO, ooooO000.OooO0OO("e15"));
                if (ooo00o.OooOo0O != 0) {
                    if (System.currentTimeMillis() - OooO00o(str3) <= ooo00o.OooOo0O * 60000) {
                        ooooO000.OooO0OO(ooooO000.OooO0OO, ooooO000.OooO0OO("e17"));
                        return false;
                    }
                    if (ooooO000.OooO00o) {
                        ooooO000.OooO0O0(ooooO000.OooO0OO, "当前时间：" + System.currentTimeMillis() + ooooO000.OooO0OO("e31") + OooO00o(str3) + " 下发的时间间隔:" + (ooo00o.OooOo0O * 60000) + ooooO000.OooO0OO("e30") + (System.currentTimeMillis() - OooO00o(str3) > ooo00o.OooOo0O * 60000) + ooooO000.OooO0OO("e28"));
                    }
                    return true;
                }
                str = ooooO000.OooO0OO;
                str2 = "e16";
            } else if (ooo00o.OooOo0O == 0) {
                ooooO000.OooO0OO(ooooO000.OooO0OO, ooooO000.OooO0OO("e18"));
                if (OooO0O0(str4) >= ooo00o.OooOo0) {
                    if (ooooO000.OooO00o) {
                        ooooO000.OooO0O0(ooooO000.OooO0OO, ooooO000.OooO0OO("e20") + OooO0O0(str4) + ooooO000.OooO0OO("e21") + ooo00o.OooOo0 + ooooO000.OooO0OO("e17"));
                    }
                    return false;
                }
                str = ooooO000.OooO0OO;
                str2 = "e19";
            } else {
                if (OooO0O0(str4) < ooo00o.OooOo0 && System.currentTimeMillis() - OooO00o(str3) > ooo00o.OooOo0O * 60000) {
                    if (ooooO000.OooO00o) {
                        ooooO000.OooO0O0(ooooO000.OooO0OO, "当天的点数" + OooO0O0(str4) + "小于" + ooooO000.OooO0OO("e22") + ooo00o.OooOo0 + ooooO000.OooO0OO("e23") + (System.currentTimeMillis() - OooO00o(str3) > ooo00o.OooOo0O * 60000) + ooooO000.OooO0OO("e28"));
                    }
                    return true;
                }
                ooooO000.OooO0O0(ooooO000.OooO0OO, ooooO000.OooO0OO("e17"));
            }
            ooooO000.OooO0OO(str, ooooO000.OooO0OO(str2));
            return true;
        }
        return false;
    }

    public static boolean OooO00o(oOO00O ooo00o) {
        try {
            int iNextInt = ooo00o.OooOo00;
            if (iNextInt != ooo00o.OooOOoo) {
                iNextInt = new Random().nextInt(ooo00o.OooOo00 - ooo00o.OooOOoo) + ooo00o.OooOOoo;
            }
            int iNextInt2 = new Random().nextInt(10000);
            boolean z = iNextInt2 <= iNextInt;
            ooooO000.OooO0O0(ooooO000.OooO0OO, ooooO000.OooO0OO("e2") + z + " r 值" + iNextInt2 + " 范围值" + iNextInt);
            return z;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static int OooO0O0(String str) {
        try {
            String strOooO0o0 = oOo00o00.OooO0o0(str);
            if (!TextUtils.isEmpty(strOooO0o0)) {
                String[] strArrSplit = strOooO0o0.split("@");
                if (oO0000O.OooO00o().equals(strArrSplit[0])) {
                    return Integer.parseInt(strArrSplit[1]);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static boolean OooO0O0(oO0O0OoO oo0o0ooo, oOO00O ooo00o) {
        String str;
        String str2;
        String str3 = oo0o0ooo.OooO0Oo + "_" + oo0o0ooo.OooO0o0 + OooO00o;
        String str4 = oo0o0ooo.OooO0Oo + "_" + oo0o0ooo.OooO0o0 + OooO0O0;
        if (ooo00o.OooOoO && OooO00o(ooo00o)) {
            if (ooo00o.OooOo0 == 0) {
                ooooO000.OooO0OO(ooooO000.OooO0OO, ooooO000.OooO0OO("e9"));
                if (ooo00o.OooOo0O != 0) {
                    if (System.currentTimeMillis() - OooO00o(str3) <= ooo00o.OooOo0O * 60000) {
                        ooooO000.OooO0OO(ooooO000.OooO0OO, ooooO000.OooO0OO("e11"));
                        return false;
                    }
                    if (ooooO000.OooO00o) {
                        ooooO000.OooO0O0(ooooO000.OooO0OO, "当前时间：" + System.currentTimeMillis() + ooooO000.OooO0OO("e31") + OooO00o(str3) + " 下发的时间间隔:" + (ooo00o.OooOo0O * 60000) + ooooO000.OooO0OO("e30") + (System.currentTimeMillis() - OooO00o(str3) > ooo00o.OooOo0O * 60000) + ooooO000.OooO0OO("e25"));
                    }
                    return true;
                }
                str = ooooO000.OooO0OO;
                str2 = "e10";
            } else if (ooo00o.OooOo0O == 0) {
                ooooO000.OooO0OO(ooooO000.OooO0OO, ooooO000.OooO0OO("e12"));
                if (OooO0O0(str4) >= ooo00o.OooOo0) {
                    if (ooooO000.OooO00o) {
                        ooooO000.OooO0O0(ooooO000.OooO0OO, ooooO000.OooO0OO("e20") + OooO0O0(str4) + ooooO000.OooO0OO("e21") + ooo00o.OooOo0 + ooooO000.OooO0OO("e27"));
                    }
                    return false;
                }
                str = ooooO000.OooO0OO;
                str2 = "e13";
            } else {
                if (OooO0O0(str4) < ooo00o.OooOo0 && System.currentTimeMillis() - OooO00o(str3) > ooo00o.OooOo0O * 60000) {
                    if (ooooO000.OooO00o) {
                        ooooO000.OooO0O0(ooooO000.OooO0OO, "当天的点数" + OooO0O0(str4) + "小于" + ooooO000.OooO0OO("e22") + ooo00o.OooOo0 + ooooO000.OooO0OO("e23") + (System.currentTimeMillis() - OooO00o(str3) > ooo00o.OooOo0O * 60000) + ooooO000.OooO0OO("e26"));
                    }
                    return true;
                }
                ooooO000.OooO0O0(ooooO000.OooO0OO, ooooO000.OooO0OO("e14"));
            }
            ooooO000.OooO0OO(str, ooooO000.OooO0OO(str2));
            return true;
        }
        return false;
    }

    public static boolean OooO0OO(oO0O0OoO oo0o0ooo, oOO00O ooo00o) {
        String str;
        String str2;
        if (ooo00o.OooOoOO) {
            String str3 = oo0o0ooo.OooO0Oo + "_" + oo0o0ooo.OooO0o0 + OooO00o;
            String str4 = oo0o0ooo.OooO0Oo + "_" + oo0o0ooo.OooO0o0 + OooO0O0;
            if (ooo00o.OooOo0 == 0) {
                ooooO000.OooO0OO(ooooO000.OooO0OO, ooooO000.OooO0OO("e3"));
                if (ooo00o.OooOo0O != 0) {
                    if (System.currentTimeMillis() - OooO00o(str3) <= ooo00o.OooOo0O * 60000) {
                        ooooO000.OooO0OO(ooooO000.OooO0OO, ooooO000.OooO0OO("e5"));
                        return false;
                    }
                    if (ooooO000.OooO00o) {
                        ooooO000.OooO0O0(ooooO000.OooO0OO, "当前时间：" + System.currentTimeMillis() + ooooO000.OooO0OO("e31") + OooO00o(str3) + " 下发的时间间隔:" + (ooo00o.OooOo0O * 60000) + ooooO000.OooO0OO("e30") + (System.currentTimeMillis() - OooO00o(str3) > ooo00o.OooOo0O * 60000) + ooooO000.OooO0OO("e28"));
                    }
                    return true;
                }
                str = ooooO000.OooO0OO;
                str2 = "e4";
            } else if (ooo00o.OooOo0O == 0) {
                ooooO000.OooO0OO(ooooO000.OooO0OO, ooooO000.OooO0OO("e6"));
                if (OooO0O0(str4) >= ooo00o.OooOo0) {
                    if (ooooO000.OooO00o) {
                        ooooO000.OooO0O0(ooooO000.OooO0OO, ooooO000.OooO0OO("e20") + OooO0O0(str4) + ooooO000.OooO0OO("e21") + ooo00o.OooOo0 + ooooO000.OooO0OO("e17"));
                    }
                    return false;
                }
                str = ooooO000.OooO0OO;
                str2 = "e7";
            } else {
                if (OooO0O0(str4) < ooo00o.OooOo0 && System.currentTimeMillis() - OooO00o(str3) > ooo00o.OooOo0O * 60000) {
                    if (ooooO000.OooO00o) {
                        ooooO000.OooO0O0(ooooO000.OooO0OO, "当天的点数" + OooO0O0(str4) + "小于" + ooooO000.OooO0OO("e22") + ooo00o.OooOo0 + ooooO000.OooO0OO("e23") + (System.currentTimeMillis() - OooO00o(str3) > ooo00o.OooOo0O * 60000) + ooooO000.OooO0OO("e24"));
                    }
                    return true;
                }
                ooooO000.OooO0O0(ooooO000.OooO0OO, ooooO000.OooO0OO("e8"));
            }
            ooooO000.OooO0OO(str, ooooO000.OooO0OO(str2));
            return true;
        }
        return false;
    }
}
