package com.opos.mobad.activity.webview.a;

import android.content.Context;
import android.webkit.JavascriptInterface;
import com.opos.cmn.biz.web.c.b.c;
import com.opos.mobad.ad.e;
import com.opos.mobad.service.e.d;
import java.util.StringTokenizer;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class b extends com.opos.cmn.biz.web.c.b.b {
    private com.opos.mobad.activity.webview.b.b e;

    public b(Context context, c cVar, com.opos.mobad.activity.webview.b.b bVar) {
        super(context, cVar);
        this.e = bVar;
    }

    public void a() {
        this.e = null;
    }

    @JavascriptInterface
    public void actionDownloader(String str, String str2, String str3, String str4, int i) {
        actionDownloader(str, str2, str3, str4, i, null);
    }

    @JavascriptInterface
    public void actionDownloader(String str, String str2, String str3, String str4, int i, String str5) {
        if (this.b) {
            try {
                com.opos.mobad.activity.webview.b.b bVar = this.e;
                if (bVar != null) {
                    bVar.a(str, str2, str3, str4, i, str5);
                }
            } catch (Exception e) {
                com.opos.cmn.an.f.a.a("MixAdJsEngine", "", (Throwable) e);
            }
        }
        com.opos.cmn.an.f.a.b("MixAdJsEngine", "actionDownloader=" + str + "," + str2 + "," + i + "," + str5);
    }

    @JavascriptInterface
    public void addCallableName(String str, String str2) {
        com.opos.mobad.activity.webview.b.b bVar = this.e;
        if (bVar == null) {
            return;
        }
        bVar.e(str, str2);
        com.opos.cmn.an.f.a.b("MixAdJsEngine", "addCallableFunc: key = " + str + ", funcName = " + str2);
    }

    @JavascriptInterface
    public void closeWebview() {
        if (this.b) {
            com.opos.mobad.service.c.c(new Runnable() { // from class: com.opos.mobad.activity.webview.a.b.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (b.this.e != null) {
                            b.this.e.c();
                        }
                    } catch (Exception e) {
                        com.opos.cmn.an.f.a.a("MixAdJsEngine", "", (Throwable) e);
                    }
                }
            });
        }
    }

    @JavascriptInterface
    public int getApiVer() {
        int iA = com.opos.mobad.activity.webview.a.a.a.a();
        com.opos.cmn.an.f.a.b("MixAdJsEngine", "getApiVer=" + iA);
        return iA;
    }

    @JavascriptInterface
    public String getDownloaderStatus(String str, String str2) {
        String strB = "";
        if (this.b) {
            try {
                com.opos.mobad.activity.webview.b.b bVar = this.e;
                if (bVar != null) {
                    strB = bVar.b(str, str2);
                }
            } catch (Exception e) {
                com.opos.cmn.an.f.a.a("MixAdJsEngine", "", (Throwable) e);
            }
        }
        com.opos.cmn.an.f.a.b("MixAdJsEngine", "getDownloaderStatus url=" + str + ",pkgName:" + str2 + ",downloadStatus:" + strB);
        return strB;
    }

    @Override // com.opos.cmn.biz.web.c.b.b
    @JavascriptInterface
    public String getDuId() {
        String strH = "";
        if (this.b) {
            try {
                strH = com.opos.mobad.service.d.a.a().h();
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("MixAdJsEngine", "", e);
            }
        }
        com.opos.cmn.an.f.a.b("MixAdJsEngine", "getDuId=" + (strH != null ? strH : "null"));
        return strH;
    }

    @JavascriptInterface
    public String getGps() {
        String string = "";
        if (this.b) {
            try {
                JSONObject jSONObject = new JSONObject();
                double[] dArr = {0.0d, 0.0d};
                e.a aVarC = com.opos.mobad.service.e.b.n().c();
                if (aVarC != null) {
                    dArr[0] = aVarC.a();
                    dArr[1] = aVarC.b();
                }
                jSONObject.put("lt", String.valueOf(dArr[0]));
                jSONObject.put("lg", String.valueOf(dArr[1]));
                string = jSONObject.toString();
            } catch (Exception e) {
                com.opos.cmn.an.f.a.a("MixAdJsEngine", "", (Throwable) e);
            }
        }
        com.opos.cmn.an.f.a.b("MixAdJsEngine", "getGps=" + string);
        return string;
    }

    @Override // com.opos.cmn.biz.web.c.b.b
    @JavascriptInterface
    public String getGuId() {
        String strI = "";
        if (this.b) {
            try {
                strI = com.opos.mobad.service.d.a.a().i();
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("MixAdJsEngine", "", e);
            }
        }
        com.opos.cmn.an.f.a.b("MixAdJsEngine", "getGuId=" + (strI != null ? strI : "null"));
        return strI;
    }

    @Override // com.opos.cmn.biz.web.c.b.b
    @JavascriptInterface
    public String getImei() {
        String str = "";
        if (this.b) {
            try {
                com.opos.mobad.service.d.a.C0991a c0991aL = com.opos.mobad.service.d.a.a().l();
                if (c0991aL != null) {
                    str = c0991aL.f7355a;
                }
            } catch (Exception e) {
                com.opos.cmn.an.f.a.a("MixAdJsEngine", "", (Throwable) e);
            }
        }
        com.opos.cmn.an.f.a.b("MixAdJsEngine", "getImei=" + str);
        return str;
    }

    @JavascriptInterface
    public String getInstantSdkVer() {
        String strB = "";
        if (this.b) {
            try {
                strB = d.a().b();
            } catch (Exception e) {
                com.opos.cmn.an.f.a.a("MixAdJsEngine", "", (Throwable) e);
            }
        }
        com.opos.cmn.an.f.a.b("MixAdJsEngine", "getInstantSdkVer=" + (strB != null ? strB : "null"));
        return strB;
    }

    @JavascriptInterface
    public String getInstantVer() {
        String strD = "";
        if (this.b) {
            try {
                strD = d.a().d();
            } catch (Exception e) {
                com.opos.cmn.an.f.a.a("MixAdJsEngine", "", (Throwable) e);
            }
        }
        com.opos.cmn.an.f.a.b("MixAdJsEngine", "getInstantVer=" + (strD != null ? strD : "null"));
        return strD;
    }

    @Override // com.opos.cmn.biz.web.c.b.b
    @JavascriptInterface
    public boolean getOUIDStatus() {
        boolean zK;
        if (this.b) {
            try {
                zK = com.opos.mobad.service.d.a.a().k();
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("MixAdJsEngine", "", e);
                zK = false;
            }
        } else {
            zK = false;
        }
        com.opos.cmn.an.f.a.b("MixAdJsEngine", "getOUIDStatus=" + zK);
        return zK;
    }

    @Override // com.opos.cmn.biz.web.c.b.b
    @JavascriptInterface
    public int getOri() {
        int i;
        if (this.b) {
            try {
                i = com.opos.cmn.an.h.f.a.i(this.f6053a);
            } catch (Exception e) {
                com.opos.cmn.an.f.a.a("MixAdJsEngine", "", (Throwable) e);
                i = 0;
            }
        } else {
            i = 0;
        }
        com.opos.cmn.an.f.a.b("MixAdJsEngine", "getOri=" + i);
        return i;
    }

    @Override // com.opos.cmn.biz.web.c.b.b
    @JavascriptInterface
    public String getOuId() {
        String strG = "";
        if (this.b) {
            try {
                strG = com.opos.mobad.service.d.a.a().g();
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("MixAdJsEngine", "", e);
            }
        }
        com.opos.cmn.an.f.a.b("MixAdJsEngine", "getOuId=" + (strG != null ? strG : "null"));
        return strG;
    }

    @JavascriptInterface
    public String getPosId() {
        String strE = "";
        if (this.b) {
            try {
                com.opos.mobad.activity.webview.b.b bVar = this.e;
                if (bVar != null) {
                    strE = bVar.e();
                }
            } catch (Exception e) {
                com.opos.cmn.an.f.a.a("MixAdJsEngine", "", (Throwable) e);
            }
        }
        com.opos.cmn.an.f.a.b("MixAdJsEngine", "getPosId=" + (strE != null ? strE : "null"));
        return strE;
    }

    @JavascriptInterface
    public String getSdkInfo() {
        String string = "";
        if (this.b) {
            try {
                JSONObject jSONObject = new JSONObject();
                com.opos.mobad.activity.webview.b.b bVar = this.e;
                jSONObject.put("verName", bVar != null ? bVar.b() : "");
                com.opos.mobad.activity.webview.b.b bVar2 = this.e;
                jSONObject.put("verCode", bVar2 != null ? bVar2.a() : 0);
                string = jSONObject.toString();
            } catch (Exception e) {
                com.opos.cmn.an.f.a.a("MixAdJsEngine", "", (Throwable) e);
            }
        }
        com.opos.cmn.an.f.a.b("MixAdJsEngine", "getSdkInfo=" + string);
        return string;
    }

    @JavascriptInterface
    public void goBackOrFinish() {
        com.opos.mobad.activity.webview.b.b bVar = this.e;
        if (bVar == null) {
            return;
        }
        bVar.d();
        com.opos.cmn.an.f.a.b("MixAdJsEngine", "goBackOrFinish");
    }

    @Override // com.opos.cmn.biz.web.c.b.b
    @JavascriptInterface
    public String hasPkgListInstalled(String str) {
        String string = "";
        if (this.b) {
            try {
                if (!com.opos.cmn.an.d.a.a(str) && 2 <= str.length()) {
                    com.opos.cmn.an.f.a.b("MixAdJsEngine", "pkgList=" + str);
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
                com.opos.cmn.an.f.a.a("MixAdJsEngine", "", (Throwable) e);
            }
        }
        com.opos.cmn.an.f.a.b("MixAdJsEngine", "hasPkgListInstalled = " + (string != null ? string : "null"));
        return string;
    }

    @JavascriptInterface
    public boolean isSupportSensorType(String str) {
        com.opos.mobad.activity.webview.b.b bVar = this.e;
        if (bVar == null) {
            return false;
        }
        return bVar.a(str);
    }

    @JavascriptInterface
    public boolean launchAppHomePage(String str) {
        return launchAppHomePage(str, null);
    }

    @JavascriptInterface
    public boolean launchAppHomePage(String str, String str2) {
        boolean zC = false;
        if (this.b) {
            try {
                com.opos.mobad.activity.webview.b.b bVar = this.e;
                if (bVar != null) {
                    zC = bVar.c(str, str2);
                }
            } catch (Exception e) {
                com.opos.cmn.an.f.a.a("MixAdJsEngine", "", (Throwable) e);
            }
        }
        StringBuilder sb = new StringBuilder("launchAppHomePage pkgName=");
        if (str == null) {
            str = "null";
        }
        com.opos.cmn.an.f.a.b("MixAdJsEngine", sb.append(str).append(",result=").append(zC).append(",").append(str2).toString());
        return zC;
    }

    @JavascriptInterface
    public boolean launchAppPage(String str) {
        return launchAppPage(str, null);
    }

    @JavascriptInterface
    public boolean launchAppPage(String str, String str2) {
        boolean zD = false;
        if (this.b) {
            try {
                com.opos.mobad.activity.webview.b.b bVar = this.e;
                if (bVar != null) {
                    zD = bVar.d(str, str2);
                }
            } catch (Exception e) {
                com.opos.cmn.an.f.a.a("MixAdJsEngine", "", (Throwable) e);
            }
        }
        StringBuilder sb = new StringBuilder("launchAppPage url=");
        if (str == null) {
            str = "null";
        }
        com.opos.cmn.an.f.a.b("MixAdJsEngine", sb.append(str).append(",result=").append(zD).append(",").append(str2).toString());
        return zD;
    }

    @JavascriptInterface
    public boolean launchBrowserViewPage(String str) {
        boolean zA;
        if (this.b) {
            try {
                zA = com.opos.mobad.activity.webview.a.a.a.a(this.f6053a, str);
            } catch (Exception e) {
                com.opos.cmn.an.f.a.a("MixAdJsEngine", "", (Throwable) e);
                zA = false;
            }
        } else {
            zA = false;
        }
        StringBuilder sb = new StringBuilder("launchBrowserViewPage url=");
        if (str == null) {
            str = "null";
        }
        com.opos.cmn.an.f.a.b("MixAdJsEngine", sb.append(str).append(",result=").append(zA).toString());
        return zA;
    }

    @JavascriptInterface
    public void launchInstant(String str, String str2, String str3, String str4, String str5) {
        if (this.b) {
            try {
                com.opos.mobad.activity.webview.b.b bVar = this.e;
                if (bVar != null) {
                    bVar.a(str, str5);
                }
            } catch (Exception e) {
                com.opos.cmn.an.f.a.a("MixAdJsEngine", "", (Throwable) e);
            }
        }
        StringBuilder sb = new StringBuilder("launchInstant instantUrl=");
        if (str == null) {
            str = "null";
        }
        com.opos.cmn.an.f.a.b("MixAdJsEngine", sb.append(str).toString());
    }

    @JavascriptInterface
    public void launchMarketDLPage(String str, String str2, String str3, String str4, boolean z) {
        launchMarketDLPage(str, str2, str3, str4, z, null);
    }

    @JavascriptInterface
    public void launchMarketDLPage(String str, String str2, String str3, String str4, boolean z, String str5) {
        if (this.b) {
            try {
                com.opos.mobad.activity.webview.b.b bVar = this.e;
                if (bVar != null) {
                    bVar.a(str, z, str5);
                }
            } catch (Exception e) {
                com.opos.cmn.an.f.a.a("MixAdJsEngine", "", (Throwable) e);
            }
        }
        StringBuilder sb = new StringBuilder("launchMarketDLPage pkgName=");
        if (str == null) {
            str = "null";
        }
        com.opos.cmn.an.f.a.b("MixAdJsEngine", sb.append(str).append(",exchange=").append(z).append(",").append(str5).toString());
    }

    @JavascriptInterface
    public void launchMarketDLPageForTrack(String str, String str2, String str3, String str4, String str5, String str6, boolean z) {
        launchMarketDLPageForTrack(str, str2, str3, str4, str5, str6, z, null);
    }

    @JavascriptInterface
    public void launchMarketDLPageForTrack(String str, String str2, String str3, String str4, String str5, String str6, boolean z, String str7) {
        if (this.b) {
            try {
                com.opos.mobad.activity.webview.b.b bVar = this.e;
                if (bVar != null) {
                    bVar.a(str, z, str5, str6, str7);
                }
            } catch (Exception e) {
                com.opos.cmn.an.f.a.a("MixAdJsEngine", "", (Throwable) e);
            }
        }
        StringBuilder sb = new StringBuilder("launchMarketDLPage pkgName=");
        if (str == null) {
            str = "null";
        }
        com.opos.cmn.an.f.a.b("MixAdJsEngine", sb.append(str).append(",exchange=").append(z).append(",trackContent=").append(str5).append(",trackReference=").append(str6).append(",").append(str7).toString());
    }

    @JavascriptInterface
    public void launchMarketDeeplinkDLApk(String str, String str2) {
        launchMarketDeeplinkDLApk(str, str2, null);
    }

    @JavascriptInterface
    public void launchMarketDeeplinkDLApk(String str, String str2, String str3) {
        if (this.b) {
            try {
                com.opos.mobad.activity.webview.b.b bVar = this.e;
                if (bVar != null) {
                    bVar.b(str, str2, str3);
                }
            } catch (Exception e) {
                com.opos.cmn.an.f.a.a("MixAdJsEngine", "", (Throwable) e);
            }
        }
        com.opos.cmn.an.f.a.b("MixAdJsEngine", "launchMarketDeeplinkDLApk url=" + str + ",pkgName:" + str2 + "," + str3);
    }

    @JavascriptInterface
    public void launchMarketDeeplinkDLApkForSafe(String str, String str2) {
        launchMarketDeeplinkDLApkForSafe(str, str2, null);
    }

    @JavascriptInterface
    public void launchMarketDeeplinkDLApkForSafe(String str, String str2, String str3) {
        if (this.b) {
            try {
                com.opos.mobad.activity.webview.b.b bVar = this.e;
                if (bVar != null) {
                    bVar.c(str, str2, str3);
                }
            } catch (Exception e) {
                com.opos.cmn.an.f.a.a("MixAdJsEngine", "", (Throwable) e);
            }
        }
        com.opos.cmn.an.f.a.b("MixAdJsEngine", "launchMarketDeeplinkDLApkForSafe url=" + str + ",pkgName:" + str2 + "," + str3);
    }

    @JavascriptInterface
    public boolean openMiniProgram(String str, String str2) {
        return openMiniProgram(str, str2, null);
    }

    @JavascriptInterface
    public boolean openMiniProgram(String str, String str2, String str3) {
        boolean zA;
        if (this.b) {
            try {
                zA = this.e.a(str, str2, str3);
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("MixAdJsEngine", "", e);
                zA = false;
            }
        } else {
            zA = false;
        }
        com.opos.cmn.an.f.a.b("MixAdJsEngine", "openMiniProgram=" + str + "," + str2 + "," + zA + "," + str3);
        return zA;
    }

    @JavascriptInterface
    public void removeCallableName(String str) {
        com.opos.mobad.activity.webview.b.b bVar = this.e;
        if (bVar == null) {
            return;
        }
        bVar.d(str);
        com.opos.cmn.an.f.a.b("MixAdJsEngine", "removeCallableFunc: key = " + str);
    }

    @JavascriptInterface
    public void request(final String str, final String str2) {
        if (this.b) {
            com.opos.cmn.an.j.b.a(new Runnable() { // from class: com.opos.mobad.activity.webview.a.b.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        com.opos.cmn.func.a.a.b.a().a(b.this.f6053a, new com.opos.cmn.func.a.a.d.a().b(str).a(str2.getBytes()).a("POST").a());
                    } catch (Exception e) {
                        com.opos.cmn.an.f.a.b("MixAdJsEngine", "request fail", e);
                    }
                }
            });
        }
        com.opos.cmn.an.f.a.b("MixAdJsEngine", "request url=" + str + ",data:" + str2);
    }
}
