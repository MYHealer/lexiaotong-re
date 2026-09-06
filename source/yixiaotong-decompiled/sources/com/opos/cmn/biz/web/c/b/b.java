package com.opos.cmn.biz.web.c.b;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.webkit.JavascriptInterface;
import android.widget.Toast;
import com.huawei.openalliance.ad.constant.bf;
import com.opos.cmn.an.c.d;
import com.opos.cmn.biz.ststrategy.StStrategyManager;
import com.stub.StubApp;
import com.umeng.analytics.pro.am;
import com.unionpay.tsmservice.mi.data.Constant;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class b extends a {
    private final Handler e;
    private String f;

    public b(Context context, c cVar) {
        super(context, cVar != null ? cVar.c : "", cVar != null ? cVar.b : true);
        this.e = new Handler(Looper.getMainLooper());
        this.f6053a = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.f = cVar != null ? cVar.f6055a : "";
    }

    private String a() {
        try {
            return !com.opos.cmn.an.f.a.b(this.f6053a) ? StStrategyManager.getInstance(this.f6053a).getAnId(this.f6053a) : "";
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("JSCommonEngine", "", e);
            return "";
        }
    }

    @JavascriptInterface
    public String getAllInstalledPkgName() {
        String string = "";
        if (this.b) {
            try {
                List<String> listB = com.opos.cmn.an.h.d.a.b(this.f6053a);
                if (listB != null && listB.size() > 0) {
                    String[] strArr = new String[listB.size()];
                    listB.toArray(strArr);
                    string = Arrays.toString(strArr);
                }
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("JSCommonEngine", "", e);
            }
        }
        com.opos.cmn.an.f.a.b("JSCommonEngine", "getAllInstalledPkgName=" + (string != null ? string : "null"));
        return string;
    }

    @JavascriptInterface
    public String getAndroidInfo() {
        String string = "";
        if (this.b) {
            try {
                JSONObject jSONObject = new JSONObject();
                String packageName = this.f6053a.getPackageName();
                jSONObject.put(com.hihonor.adsdk.base.c.r1.hnadse, packageName);
                jSONObject.put("verName", com.opos.cmn.an.h.d.a.c(this.f6053a, packageName));
                jSONObject.put("verCode", com.opos.cmn.an.h.d.a.b(this.f6053a, packageName));
                jSONObject.put("imei", getImei());
                jSONObject.put("localId", getLocalId());
                jSONObject.put("anId", a());
                jSONObject.put(Constant.KEY_MAC, "");
                jSONObject.put("osVer", d.b());
                jSONObject.put("romVer", d.a());
                jSONObject.put("anVer", com.opos.cmn.an.c.c.c());
                jSONObject.put("net", com.opos.cmn.biz.web.c.a.a.a.a(this.f6053a));
                jSONObject.put("opt", com.opos.cmn.an.h.e.a.c(this.f6053a));
                jSONObject.put("ori", com.opos.cmn.an.h.f.a.i(this.f6053a));
                jSONObject.put("hg", com.opos.cmn.an.h.f.a.c(this.f6053a));
                jSONObject.put("wd", com.opos.cmn.an.h.f.a.b(this.f6053a));
                jSONObject.put(bf.ar, com.opos.cmn.an.h.f.a.f(this.f6053a));
                jSONObject.put("model", com.opos.cmn.an.c.c.a());
                jSONObject.put("brand", com.opos.cmn.biz.a.b.a(this.f6053a));
                jSONObject.put("lang", com.opos.cmn.an.c.b.a());
                jSONObject.put(am.O, com.opos.cmn.an.c.b.b());
                jSONObject.put("ouId", getOuId());
                jSONObject.put("duId", getDuId());
                jSONObject.put("guId", getGuId());
                jSONObject.put("ouIdStatus", getOUIDStatus());
                string = jSONObject.toString();
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("JSCommonEngine", "", e);
            }
        }
        com.opos.cmn.an.f.a.b("JSCommonEngine", "getAndroidInfo = " + string);
        return string;
    }

    @JavascriptInterface
    public String getBrand() {
        String strA = "";
        if (this.b) {
            try {
                strA = com.opos.cmn.biz.a.b.a(this.f6053a);
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("JSCommonEngine", "", e);
            }
        }
        com.opos.cmn.an.f.a.b("JSCommonEngine", "getBrand=" + (strA != null ? strA : "null"));
        return strA;
    }

    @JavascriptInterface
    public String getBuildInfo() {
        String string = "";
        if (this.b) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("model", com.opos.cmn.an.c.c.a());
                jSONObject.put("brand", com.opos.cmn.biz.a.b.a(this.f6053a));
                string = jSONObject.toString();
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("JSCommonEngine", "", e);
            }
        }
        com.opos.cmn.an.f.a.b("JSCommonEngine", "getBuildInfo=" + string);
        return string;
    }

    @JavascriptInterface
    public String getBusinessType() {
        return this.f;
    }

    @JavascriptInterface
    public int getCommonApiVer() {
        int iA = com.opos.cmn.biz.web.c.a.a.a.a();
        com.opos.cmn.an.f.a.b("JSCommonEngine", "getCommonApiVer=" + iA);
        return iA;
    }

    @JavascriptInterface
    public String getDevId() {
        String string = "";
        if (this.b) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("imei", getImei());
                jSONObject.put("localId", getLocalId());
                jSONObject.put("anId", a());
                jSONObject.put(Constant.KEY_MAC, "");
                jSONObject.put("ouId", getOuId());
                jSONObject.put("duId", getDuId());
                jSONObject.put("guId", getGuId());
                jSONObject.put("ouIdStatus", getOUIDStatus());
                string = jSONObject.toString();
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("JSCommonEngine", "", e);
            }
        }
        com.opos.cmn.an.f.a.b("JSCommonEngine", "getDevId=" + string);
        return string;
    }

    @JavascriptInterface
    public String getDevOS() {
        String string = "";
        if (this.b) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("osVer", d.b());
                jSONObject.put("romVer", d.a());
                jSONObject.put("anVer", com.opos.cmn.an.c.c.c());
                string = jSONObject.toString();
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("JSCommonEngine", "", e);
            }
        }
        com.opos.cmn.an.f.a.b("JSCommonEngine", "getDevOS=" + string);
        return string;
    }

    @JavascriptInterface
    public String getDuId() {
        String strB = "";
        if (this.b) {
            try {
                strB = com.opos.cmn.g.a.b.b(this.f6053a);
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("JSCommonEngine", "", e);
            }
        }
        com.opos.cmn.an.f.a.b("JSCommonEngine", "getDuId=" + (strB != null ? strB : "null"));
        return strB;
    }

    @JavascriptInterface
    public String getGuId() {
        String guid = "";
        if (this.b) {
            try {
                if (!com.opos.cmn.an.f.a.b(this.f6053a)) {
                    guid = StStrategyManager.getInstance(this.f6053a).getGUID();
                }
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("JSCommonEngine", "", e);
            }
        }
        com.opos.cmn.an.f.a.b("JSCommonEngine", "getGuId=" + (guid != null ? guid : "null"));
        return guid;
    }

    @JavascriptInterface
    public String getImei() {
        String imei = "";
        if (this.b) {
            try {
                if (!com.opos.cmn.an.f.a.b(this.f6053a)) {
                    imei = StStrategyManager.getInstance(this.f6053a).getImei();
                }
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("JSCommonEngine", "", e);
            }
        }
        com.opos.cmn.an.f.a.b("JSCommonEngine", "getImei=" + imei);
        return imei;
    }

    @JavascriptInterface
    public String getLocal() {
        String string = "";
        if (this.b) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("lang", com.opos.cmn.an.c.b.a());
                jSONObject.put(am.O, com.opos.cmn.an.c.b.b());
                string = jSONObject.toString();
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("JSCommonEngine", "", e);
            }
        }
        com.opos.cmn.an.f.a.b("JSCommonEngine", "getLocal=" + string);
        return string;
    }

    @JavascriptInterface
    public String getLocalId() {
        String strB = "";
        if (this.b) {
            try {
                strB = com.opos.cmn.g.a.c.b(this.f6053a);
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("JSCommonEngine", "", e);
            }
        }
        com.opos.cmn.an.f.a.b("JSCommonEngine", "getLocalId=" + strB);
        return strB;
    }

    @JavascriptInterface
    public String getNetType() {
        String strA = "";
        if (this.b) {
            try {
                strA = com.opos.cmn.biz.web.c.a.a.a.a(this.f6053a);
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("JSCommonEngine", "", e);
            }
        }
        com.opos.cmn.an.f.a.b("JSCommonEngine", "getNetType=" + strA);
        return strA;
    }

    @JavascriptInterface
    public boolean getOUIDStatus() {
        boolean zG;
        if (this.b) {
            try {
                zG = com.opos.cmn.g.a.b.g(this.f6053a);
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("JSCommonEngine", "", e);
                zG = false;
            }
        } else {
            zG = false;
        }
        com.opos.cmn.an.f.a.b("JSCommonEngine", "getOUIDStatus=" + zG);
        return zG;
    }

    @JavascriptInterface
    public String getOperator() {
        String strC = "";
        if (this.b) {
            try {
                strC = com.opos.cmn.an.h.e.a.c(this.f6053a);
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("JSCommonEngine", "", e);
            }
        }
        com.opos.cmn.an.f.a.b("JSCommonEngine", "getOperator=" + strC);
        return strC;
    }

    @JavascriptInterface
    public int getOri() {
        int i;
        if (this.b) {
            try {
                i = com.opos.cmn.an.h.f.a.i(this.f6053a);
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("JSCommonEngine", "", e);
                i = 0;
            }
        } else {
            i = 0;
        }
        com.opos.cmn.an.f.a.b("JSCommonEngine", "getOri=" + i);
        return i;
    }

    @JavascriptInterface
    public String getOuId() {
        String strA = "";
        if (this.b) {
            try {
                strA = com.opos.cmn.g.a.b.a(this.f6053a);
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("JSCommonEngine", "", e);
            }
        }
        com.opos.cmn.an.f.a.b("JSCommonEngine", "getOUID=" + (strA != null ? strA : "null"));
        return strA;
    }

    @JavascriptInterface
    public String getPkgInfo(String str) {
        String string = "";
        if (this.b) {
            try {
                JSONObject jSONObject = new JSONObject();
                String packageName = com.opos.cmn.an.d.a.a(str) ? this.f6053a.getPackageName() : str;
                jSONObject.put(com.hihonor.adsdk.base.c.r1.hnadse, packageName);
                jSONObject.put("verName", com.opos.cmn.an.h.d.a.c(this.f6053a, packageName));
                jSONObject.put("verCode", com.opos.cmn.an.h.d.a.b(this.f6053a, packageName));
                string = jSONObject.toString();
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("JSCommonEngine", "", e);
            }
        }
        StringBuilder sb = new StringBuilder("getPkgInfo pkgName=");
        if (str == null) {
            str = "null";
        }
        com.opos.cmn.an.f.a.b("JSCommonEngine", sb.append(str).append(string).toString());
        return string;
    }

    @JavascriptInterface
    public String getRegion() {
        String strA = "";
        if (this.b) {
            try {
                strA = com.opos.cmn.biz.a.d.a(this.f6053a);
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("JSCommonEngine", "", e);
            }
        }
        com.opos.cmn.an.f.a.b("JSCommonEngine", "getRegion=" + (strA != null ? strA : "null"));
        return strA;
    }

    @JavascriptInterface
    public String getScreen() {
        String string = "";
        if (this.b) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("hg", com.opos.cmn.an.h.f.a.c(this.f6053a));
                jSONObject.put("wd", com.opos.cmn.an.h.f.a.b(this.f6053a));
                jSONObject.put(bf.ar, com.opos.cmn.an.h.f.a.f(this.f6053a));
                string = jSONObject.toString();
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("JSCommonEngine", "", e);
            }
        }
        com.opos.cmn.an.f.a.b("JSCommonEngine", "getScreen=" + string);
        return string;
    }

    @JavascriptInterface
    public boolean getTouristModeSwitch() {
        boolean zB;
        if (this.b) {
            try {
                zB = com.opos.cmn.an.f.a.b(this.f6053a);
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("JSCommonEngine", "", e);
                zB = false;
            }
        } else {
            zB = false;
        }
        com.opos.cmn.an.f.a.b("JSCommonEngine", "getTouristModeSwitch=" + zB);
        return zB;
    }

    @JavascriptInterface
    public boolean hasPkgInstalled(String str) {
        boolean zD;
        if (this.b) {
            try {
                zD = com.opos.cmn.an.h.d.a.d(this.f6053a, str);
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("JSCommonEngine", "", e);
                zD = false;
            }
        } else {
            zD = false;
        }
        StringBuilder sb = new StringBuilder("hasPkgInstalled pkgName=");
        if (str == null) {
            str = "null";
        }
        com.opos.cmn.an.f.a.b("JSCommonEngine", sb.append(str).append(",result=").append(zD).toString());
        return zD;
    }

    @JavascriptInterface
    public String hasPkgListInstalled(String str) {
        String string = "";
        if (this.b) {
            try {
                if (!com.opos.cmn.an.d.a.a(str) && 2 <= str.length()) {
                    com.opos.cmn.an.f.a.b("JSCommonEngine", "pkgList=" + str);
                    String strSubstring = str.substring(1, str.length() - 1);
                    if (strSubstring.length() > 0) {
                        JSONObject jSONObject = new JSONObject();
                        StringTokenizer stringTokenizer = new StringTokenizer(strSubstring, ",");
                        while (stringTokenizer.hasMoreTokens()) {
                            String strNextToken = stringTokenizer.nextToken();
                            if (!com.opos.cmn.an.d.a.a(strNextToken)) {
                                jSONObject.put(strNextToken, com.opos.cmn.an.h.d.a.d(this.f6053a, strNextToken));
                            }
                        }
                        string = jSONObject.toString();
                    }
                }
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("JSCommonEngine", "", e);
            }
        }
        com.opos.cmn.an.f.a.b("JSCommonEngine", "hasPkgListInstalled = " + (string != null ? string : "null"));
        return string;
    }

    @JavascriptInterface
    public boolean installApk(String str) {
        boolean zA;
        if (this.b) {
            try {
                zA = com.opos.cmn.biz.web.c.a.a.a.a(this.f6053a, str);
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("JSCommonEngine", "", e);
                zA = false;
            }
        } else {
            zA = false;
        }
        StringBuilder sb = new StringBuilder("installApk url=");
        if (str == null) {
            str = "null";
        }
        com.opos.cmn.an.f.a.b("JSCommonEngine", sb.append(str).append(",result=").append(zA).toString());
        return zA;
    }

    @JavascriptInterface
    public void showToast(final String str, final boolean z) {
        if (this.b) {
            this.e.post(new Runnable() { // from class: com.opos.cmn.biz.web.c.b.b.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        Toast.makeText(b.this.f6053a, str, !z ? 1 : 0).show();
                    } catch (Exception e) {
                        com.opos.cmn.an.f.a.c("JSCommonEngine", "", e);
                    }
                }
            });
        }
    }
}
