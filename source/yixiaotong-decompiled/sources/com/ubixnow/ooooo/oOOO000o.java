package com.ubixnow.ooooo;

import android.os.Process;
import android.text.TextUtils;
import com.cdo.oaps.ad.wrapper.BaseWrapper;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.ubix.ssp.BuildConfig;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class oOOO000o implements Thread.UncaughtExceptionHandler {
    private static final int OooO00o = 500;
    private static oOOO000o OooO0O0;
    private static boolean OooO0OO;
    private Thread.UncaughtExceptionHandler OooO0Oo;

    private oOOO000o() {
        if (!(Thread.getDefaultUncaughtExceptionHandler() instanceof oOOO000o)) {
            this.OooO0Oo = Thread.getDefaultUncaughtExceptionHandler();
        }
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    public static void OooO00o() {
        OooO0OO = true;
    }

    public static synchronized void OooO0O0() {
        if (OooO0O0 == null) {
            oO00000o.o00O0O.OooOOO.add(BuildConfig.LIBRARY_PACKAGE_NAME);
            oO00000o.o00O0O.OooOOO.add("com.ubixnow");
            oO00000o.o00O0O.OooOOOO.put("com.bytedance", BaseWrapper.ENTER_ID_17);
            oO00000o.o00O0O.OooOOOO.put("com.ss", BaseWrapper.ENTER_ID_17);
            oO00000o.o00O0O.OooOOOO.put("com.bykv", BaseWrapper.ENTER_ID_17);
            oO00000o.o00O0O.OooOOOO.put("com.byted", BaseWrapper.ENTER_ID_17);
            oO00000o.o00O0O.OooOOOO.put("com.qq.e", "2");
            oO00000o.o00O0O.OooOOOO.put("com.kwad", "3");
            oO00000o.o00O0O.OooOOOO.put("com.kuaishou", "3");
            oO00000o.o00O0O.OooOOOO.put("com.kwai", "3");
            oO00000o.o00O0O.OooOOOO.put("com.yxcorp", "3");
            oO00000o.o00O0O.OooOOOO.put("com.jd", "4");
            oO00000o.o00O0O.OooOOOO.put(BuildConfig.LIBRARY_PACKAGE_NAME, "5");
            oO00000o.o00O0O.OooOOOO.put("com.baidu.mobads", "6");
            oO00000o.o00O0O.OooOOOO.put("qm.qm", BaseWrapper.ENTER_ID_SHORTCUT);
            oO00000o.o00O0O.OooOOOO.put("com.inno", BaseWrapper.ENTER_ID_SHORTCUT);
            oO00000o.o00O0O.OooOOOO.put("com.qumeng", BaseWrapper.ENTER_ID_SHORTCUT);
            oO00000o.o00O0O.OooOOOO.put("com.jifen", BaseWrapper.ENTER_ID_SHORTCUT);
            oO00000o.o00O0O.OooOOOO.put("com.ptg", "24");
            oO00000o.o00O0O.OooOOOO.put("com.fo.compat", "24");
            oO00000o.o00O0O.OooOOOO.put("com.oOoo", "24");
            oO00000o.o00O0O.OooOOOO.put("com.example.ptgapi", "24");
            oO00000o.o00O0O.OooOOOO.put("com.beizi", "10");
            oO00000o.o00O0O.OooOOOO.put("com.octopus.ad", "25");
            oO00000o.o00O0O.OooOOOO.put("com.my.adpoymer", "26");
            oO00000o.o00O0O.OooOOOO.put("com.dydroid", "27");
            oO00000o.o00O0O.OooOOOO.put("com.litesuits", "27");
            oO00000o.o00O0O.OooOOOO.put("cn.haorui.sdk", "28");
            oO00000o.o00O0O.OooOOOO.put("com.anythink", "29");
            oO00000o.o00O0O.OooOOOO.put("doublejump.top", BaseWrapper.ENTER_ID_TOOLKIT);
            oO00000o.o00O0O.OooOOOO.put("com.easyjson", BaseWrapper.ENTER_ID_TOOLKIT);
            oO00000o.o00O0O.OooOOOO.put("com.xwdz", BaseWrapper.ENTER_ID_TOOLKIT);
            oO00000o.o00O0O.OooOOOO.put("com.shu.priory", BaseWrapper.ENTER_ID_OAPS_ROAMING);
            oO00000o.o00O0O.OooOOOO.put("com.ubix.wm", BaseWrapper.ENTER_ID_OAPS_ASSISTANT_SCREEN);
            oO00000o.o00O0O.OooOOOO.put("com.tide", BaseWrapper.ENTER_ID_OAPS_SPEECH_ASSIST);
            oO00000o.o00O0O.OooOOOO.put("com.zm", BaseWrapper.ENTER_ID_OAPS_SPEECH_ASSIST);
            OooO0O0 = new oOOO000o();
        }
    }

    private void OooO0OO() {
        try {
            Process.killProcess(Process.myPid());
            System.exit(10);
        } catch (Exception unused) {
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        Iterator<String> it;
        String next;
        boolean z;
        ooooO0O0 ooooo0o0OooOoO;
        try {
            if (OooO0OO && oO00000o.o00O0O.OooO0o) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    String string = null;
                    try {
                        StringWriter stringWriter = new StringWriter();
                        PrintWriter printWriter = new PrintWriter(stringWriter);
                        th.printStackTrace(printWriter);
                        Throwable cause = th;
                        while (true) {
                            cause = cause.getCause();
                            if (cause == null) {
                                break;
                            } else {
                                cause.printStackTrace(printWriter);
                            }
                        }
                        printWriter.close();
                        string = stringWriter.toString();
                        jSONObject.put("app_crashed_type", th.getClass().getSimpleName());
                        jSONObject.put("app_crashed_reason", string);
                        jSONObject.put("app_crashed_time", System.currentTimeMillis());
                        while (true) {
                            if (!it.hasNext()) {
                                next = "";
                                z = false;
                                break;
                            } else {
                                next = it.next();
                                if (string != null && string.contains(next)) {
                                    z = true;
                                    break;
                                }
                            }
                        }
                    } catch (Exception e) {
                        oOO0O0O.OooO00o(e);
                    }
                    it = oO00000o.o00O0O.OooOOO.iterator();
                    ooooO000.OooO00o("-----", "isContainsKeyword ：" + z + " keyword:" + next);
                    if (string != null && z) {
                        try {
                            if (!TextUtils.isEmpty(next) && oO00000o.o00O0O.OooOOOO.containsKey(next)) {
                                String strOooO0O0 = oO0000O.OooO0O0(Integer.parseInt(oO00000o.o00O0O.OooOOOO.get(next)));
                                jSONObject.put(o0OO000o.o000ooo0, strOooO0O0 != null ? strOooO0O0 : "");
                                jSONObject.put(o0OO000o.oooo00o, oO00000o.o00O0O.OooOOOO.get(next));
                            }
                        } catch (Exception unused) {
                        }
                        String str = oO00000o.o00O0O.OooO0o0;
                        if (str != null) {
                            if (!str.contains("none")) {
                                if (oO00000o.o00O0O.OooO0o0.contains(TtmlNode.COMBINE_ALL)) {
                                    ooooO000.OooO00o("-----", "崩溃埋点全部通过：");
                                    ooooo0o0OooOoO = ooooO0O0.OooOoO();
                                } else if (TextUtils.isEmpty(o0OO000o.o000OoOo) || oO00000o.o00O0O.OooO0o0.contains(o0OO000o.o000OoOo)) {
                                    ooooO000.OooO00o("-----", "崩溃埋点通过");
                                    ooooo0o0OooOoO = ooooO0O0.OooOoO();
                                }
                                ooooo0o0OooOoO.OooO00o(oOO0O0.TRACK, "AppCrashed", jSONObject);
                            }
                            ooooO000.OooO00o("-----", "崩溃埋点拦截：");
                        }
                        oOo00o00.OooO00o(oO00000o.o00000O0.OooO0OO, Boolean.TRUE);
                        oOo00o00.OooO0O0(oO00000o.o00000O0.OooOoO0);
                        oOo00o00.OooO00o(oO00000o.o00000O0.OooO0O0);
                        oOo00o00.OooO00o(oO00000o.o00000O0.OooO0OO, Boolean.FALSE);
                    }
                } catch (Exception e2) {
                    oOO0O0O.OooO00o(e2);
                }
            }
            ooooO0O0.OooOoO().flush();
            try {
                Thread.sleep(500L);
            } catch (InterruptedException e3) {
                oOO0O0O.OooO00o(e3);
            }
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.OooO0Oo;
            if (uncaughtExceptionHandler == null || uncaughtExceptionHandler == this || (uncaughtExceptionHandler instanceof oOOO000o)) {
                OooO0OO();
            } else {
                uncaughtExceptionHandler.uncaughtException(thread, th);
            }
        } catch (Exception unused2) {
        }
    }
}
