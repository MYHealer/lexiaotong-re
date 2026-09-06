package com.jd.ad.sdk.jad_dq;

import com.jd.android.sdk.coreinfo.util.Logger;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class jad_cp {
    public static Map<String, String> jad_an = null;
    public static String jad_bo = "";

    /* JADX WARN: Code duplicated, block: B:104:0x00d2 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:106:0x00bc A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:57:0x00c2  */
    /* JADX WARN: Code duplicated, block: B:82:0x0092 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:92:0x009c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public static String jad_an(String str) {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2;
        Pattern patternCompile;
        Iterator it;
        Matcher matcher;
        if (str.trim().equals("")) {
            return "";
        }
        if (jad_an == null) {
            jad_an = new HashMap();
            String[] strArr = {"/system/bin/sh", "-c", "getprop"};
            ArrayList arrayList = new ArrayList();
            try {
                Process processExec = Runtime.getRuntime().exec(strArr);
                bufferedReader = new BufferedReader(new InputStreamReader(processExec.getInputStream()));
                try {
                    try {
                        try {
                            while (true) {
                                try {
                                    String line = bufferedReader.readLine();
                                    if (line == null) {
                                        break;
                                    }
                                    arrayList.add(line);
                                } catch (Throwable th) {
                                    th = th;
                                    bufferedReader2 = null;
                                }
                                try {
                                    Logger.e("CoreInfo.RomNameUtil", "RomNameUtil.exec() exception", th);
                                    if (bufferedReader != null) {
                                        try {
                                            bufferedReader.close();
                                        } catch (IOException e) {
                                            Logger.e("CoreInfo.RomNameUtil", "RomNameUtil.exec() exception", e);
                                        }
                                    }
                                    if (bufferedReader2 != null) {
                                        try {
                                            bufferedReader2.close();
                                        } catch (IOException e2) {
                                            Logger.e("CoreInfo.RomNameUtil", "RomNameUtil.exec() exception", e2);
                                        }
                                    }
                                    arrayList = null;
                                    if (arrayList != null && arrayList.size() > 0) {
                                        Logger.d("CoreInfo.RomNameUtil", "Successfully get 'getprop' list.");
                                        patternCompile = Pattern.compile("\\[(.+)\\]: \\[(.*)\\]");
                                        it = arrayList.iterator();
                                        while (it.hasNext()) {
                                            matcher = patternCompile.matcher((String) it.next());
                                            if (matcher.find()) {
                                                jad_an.put(matcher.group(1), matcher.group(2));
                                            }
                                        }
                                        Logger.d("CoreInfo.RomNameUtil", "System properties number: " + jad_an.size());
                                    }
                                } catch (Throwable th2) {
                                    if (bufferedReader != null) {
                                        try {
                                            bufferedReader.close();
                                        } catch (IOException e3) {
                                            Logger.e("CoreInfo.RomNameUtil", "RomNameUtil.exec() exception", e3);
                                        }
                                    }
                                    if (bufferedReader2 == null) {
                                        throw th2;
                                    }
                                    try {
                                        bufferedReader2.close();
                                        throw th2;
                                    } catch (IOException e4) {
                                        Logger.e("CoreInfo.RomNameUtil", "RomNameUtil.exec() exception", e4);
                                        throw th2;
                                    }
                                }
                            }
                            bufferedReader2.close();
                        } catch (IOException e5) {
                            Logger.e("CoreInfo.RomNameUtil", "RomNameUtil.exec() exception", e5);
                        }
                        bufferedReader2.close();
                    } catch (IOException e6) {
                        Logger.e("CoreInfo.RomNameUtil", "RomNameUtil.exec() exception", e6);
                    }
                    bufferedReader.close();
                } catch (IOException e7) {
                    Logger.e("CoreInfo.RomNameUtil", "RomNameUtil.exec() exception", e7);
                }
                bufferedReader2 = new BufferedReader(new InputStreamReader(processExec.getErrorStream()));
                while (true) {
                    try {
                        String line2 = bufferedReader2.readLine();
                        if (line2 != null) {
                            arrayList.add(line2);
                        } else {
                            try {
                                break;
                            } catch (IOException e8) {
                                Logger.e("CoreInfo.RomNameUtil", "RomNameUtil.exec() exception", e8);
                            }
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        Logger.e("CoreInfo.RomNameUtil", "RomNameUtil.exec() exception", th);
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                        if (bufferedReader2 != null) {
                            bufferedReader2.close();
                        }
                        arrayList = null;
                    }
                }
                bufferedReader.close();
            } catch (Throwable th4) {
                th = th4;
                bufferedReader = null;
                bufferedReader2 = null;
            }
            if (arrayList != null) {
                Logger.d("CoreInfo.RomNameUtil", "Successfully get 'getprop' list.");
                patternCompile = Pattern.compile("\\[(.+)\\]: \\[(.*)\\]");
                it = arrayList.iterator();
                while (it.hasNext()) {
                    matcher = patternCompile.matcher((String) it.next());
                    if (matcher.find()) {
                        jad_an.put(matcher.group(1), matcher.group(2));
                    }
                }
                Logger.d("CoreInfo.RomNameUtil", "System properties number: " + jad_an.size());
            }
        }
        return jad_an.containsKey(str) ? jad_an.get(str) : "";
    }
}
