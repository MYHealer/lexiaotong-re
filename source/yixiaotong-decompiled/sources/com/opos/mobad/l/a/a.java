package com.opos.mobad.l.a;

import android.content.Context;
import android.util.Log;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class a implements com.opos.mobad.l.d {
    private int a(long j) {
        long j2 = (j / 1048576) + ((long) (j % 1048576 == 0 ? 0 : 1));
        if (j2 > 5) {
            j2 = 5;
        }
        com.opos.cmn.an.f.a.b("DownloadEngineImpl", "getBlockNum=" + j2);
        return (int) j2;
    }

    private int a(long j, int i) {
        long j2 = 5 == i ? j / 5 : 1048576L;
        com.opos.cmn.an.f.a.b("DownloadEngineImpl", "getBlockSize=" + j2);
        return (int) j2;
    }

    private String a(com.opos.mobad.l.a aVar) {
        if (aVar != null) {
            int i = aVar.c;
            if (i == 0) {
                return aVar.d;
            }
            if (i == 1) {
                return aVar.g;
            }
            if (i == 2) {
                return aVar.f + File.separator + aVar.g;
            }
        }
        return "";
    }

    private void a(File file) {
        if (file == null || com.opos.cmn.an.e.b.a.a(file)) {
            return;
        }
        if (!com.opos.cmn.an.e.b.a.b(com.opos.cmn.an.e.b.a.d(file))) {
            com.opos.cmn.an.e.b.a.c(file);
        }
        com.opos.cmn.an.e.b.a.f(file);
    }

    private void a(String str) {
        if (com.opos.cmn.an.d.a.a(str)) {
            return;
        }
        a(new File(str));
    }

    private boolean a(int i) {
        boolean z = i == 0;
        com.opos.cmn.an.f.a.b("DownloadEngineImpl", "needLockFile result=" + z);
        return z;
    }

    private boolean a(Context context, com.opos.mobad.l.a aVar, long j) {
        boolean zA;
        if (context == null || aVar == null) {
            zA = false;
        } else {
            try {
                zA = a(d.a(context, aVar), aVar.b, j);
            } catch (Exception e) {
                com.opos.cmn.an.f.a.a("DownloadEngineImpl", "verifyFileIntegrity", (Throwable) e);
                zA = false;
            }
        }
        com.opos.cmn.an.f.a.b("DownloadEngineImpl", "verifyFileIntegrity downloadRequest=", aVar, "contentLength=", Long.valueOf(j), "result=", Boolean.valueOf(zA));
        return zA;
    }

    private boolean a(Context context, com.opos.mobad.l.a aVar, com.opos.cmn.func.a.a.e eVar) {
        if (context != null && aVar != null && eVar != null) {
            try {
                if (eVar.d >= 1048576) {
                    com.opos.cmn.func.a.a.a aVar2 = eVar.f;
                    String strA = aVar2 != null ? aVar2.a("Accept-Ranges") : "";
                    com.opos.cmn.an.f.a.b("DownloadEngineImpl", "download acceptRange=" + (strA != null ? strA : ""));
                    if (!com.opos.cmn.an.d.a.a(strA)) {
                        com.opos.cmn.an.f.a.b("DownloadEngineImpl", "server support multi thread download ");
                        return d(context, aVar, eVar);
                    }
                    com.opos.cmn.an.f.a.b("DownloadEngineImpl", "server don't support multi thread download,download as normal file.");
                } else {
                    com.opos.cmn.an.f.a.b("DownloadEngineImpl", "download normal file=" + aVar.d);
                }
                return b(context, aVar, eVar);
            } catch (Exception e) {
                com.opos.cmn.an.f.a.a("DownloadEngineImpl", "download", (Throwable) e);
            }
        }
        return false;
    }

    private boolean a(File file, File file2, InputStream inputStream, long j, String str) {
        boolean zA;
        boolean z = false;
        if (file != null && file2 != null && inputStream != null) {
            try {
                if (com.opos.cmn.an.e.b.a.a(file)) {
                    com.opos.cmn.an.f.a.b("DownloadEngineImpl", "target file exists." + file.getAbsolutePath());
                    try {
                        if (a(file, str, j)) {
                            com.opos.cmn.an.f.a.b("DownloadEngineImpl", "targetFile exists and valid, don't need rename!" + file.getAbsolutePath());
                        } else {
                            com.opos.cmn.an.f.a.b("DownloadEngineImpl", "targetFile exists but not valid, rename tmp file!");
                            com.opos.cmn.an.e.b.a.e(file);
                            zA = com.opos.cmn.an.e.b.a.a(inputStream, file2) ? a(file, file2, str, j) : true;
                        }
                        z = zA;
                    } catch (Throwable th) {
                        th = th;
                        try {
                            com.opos.cmn.an.f.a.a("DownloadEngineImpl", "saveSdFile", th);
                        } finally {
                            com.opos.cmn.an.e.b.a.e(file2);
                        }
                    }
                } else {
                    com.opos.cmn.an.f.a.b("DownloadEngineImpl", "target file not exists." + file.getAbsolutePath());
                    if (com.opos.cmn.an.e.b.a.a(inputStream, file2)) {
                        zA = a(file, file2, str, j);
                        z = zA;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
        return z;
    }

    private boolean a(File file, File file2, String str, long j) {
        boolean z = file != null && file2 != null && a(file2, str, j) && com.opos.cmn.an.e.b.a.a(file2, file);
        StringBuilder sbAppend = new StringBuilder("verifyTmpFileAndRename destFile=").append(file != null ? file.getAbsolutePath() : "null").append(",tmpFile=").append(file2 != null ? file2.getAbsolutePath() : "null").append(",md5=");
        if (str == null) {
            str = "null";
        }
        com.opos.cmn.an.f.a.b("DownloadEngineImpl", sbAppend.append(str).append("contentLength=").append(j).append(",result=").append(z).toString());
        return z;
    }

    private boolean a(File file, String str) {
        boolean zEquals = !com.opos.cmn.an.d.a.a(str) ? com.opos.cmn.an.b.c.a(file).equals(str) : true;
        StringBuilder sbAppend = new StringBuilder("verifyFileIntegrity filePath=").append(file != null ? file.getAbsolutePath() : "null").append(",md5=");
        if (str == null) {
            str = "null";
        }
        com.opos.cmn.an.f.a.b("DownloadEngineImpl", sbAppend.append(str).append(",result=").append(zEquals).toString());
        return zEquals;
    }

    private boolean a(File file, String str, long j) {
        boolean z = true;
        if (j <= 0 ? !com.opos.cmn.an.e.b.a.a(file) || !a(file, str) : j != com.opos.cmn.an.e.b.a.g(file) || !a(file, str)) {
            z = false;
        }
        StringBuilder sbAppend = new StringBuilder("verifyFileIntegrity filePath=").append(file != null ? file.getAbsolutePath() : "null").append(",md5=");
        if (str == null) {
            str = "null";
        }
        com.opos.cmn.an.f.a.b("DownloadEngineImpl", sbAppend.append(str).append(",contentLength=").append(j).append(",result=").append(z).toString());
        return z;
    }

    private boolean b(Context context, com.opos.mobad.l.a aVar, com.opos.cmn.func.a.a.e eVar) {
        boolean z = false;
        if (context != null && aVar != null) {
            try {
                if (eVar != null) {
                    try {
                        if (200 != eVar.f6077a) {
                            Log.d("DownloadEngineImpl", "downloadNormalFile httpResponseEntity.getResponseCode()=" + eVar.f6077a);
                        } else if (c(context, aVar, eVar)) {
                            z = true;
                        }
                    } catch (Exception e) {
                        com.opos.cmn.an.f.a.a("DownloadEngineImpl", "", (Throwable) e);
                    }
                    eVar.a();
                }
            } catch (Throwable th) {
                eVar.a();
                throw th;
            }
        }
        com.opos.cmn.an.f.a.b("DownloadEngineImpl", "downloadNormalFile downloadRequest=", aVar, "netResponse=", eVar, "result=", Boolean.valueOf(z));
        return z;
    }

    private boolean c(Context context, com.opos.mobad.l.a aVar, com.opos.cmn.func.a.a.e eVar) {
        boolean zA = (context == null || aVar == null || eVar == null) ? false : a(d.a(context, aVar), d.b(context, aVar), eVar.c, eVar.d, aVar.b);
        com.opos.cmn.an.f.a.b("DownloadEngineImpl", "saveNormalFile downloadRequest=", aVar, "netResponse=", eVar, "result=", Boolean.valueOf(zA));
        return zA;
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x0103 */
    /* JADX WARN: Code duplicated, block: B:101:0x01af A[Catch: Exception -> 0x03ef, all -> 0x0401, TryCatch #1 {Exception -> 0x03ef, blocks: (B:97:0x0182, B:99:0x019f, B:101:0x01af, B:103:0x01d7, B:105:0x01e4, B:104:0x01dc, B:123:0x0230, B:125:0x0245), top: B:219:0x0182 }] */
    /* JADX WARN: Code duplicated, block: B:103:0x01d7 A[Catch: Exception -> 0x03ef, all -> 0x0401, TryCatch #1 {Exception -> 0x03ef, blocks: (B:97:0x0182, B:99:0x019f, B:101:0x01af, B:103:0x01d7, B:105:0x01e4, B:104:0x01dc, B:123:0x0230, B:125:0x0245), top: B:219:0x0182 }] */
    /* JADX WARN: Code duplicated, block: B:104:0x01dc A[Catch: Exception -> 0x03ef, all -> 0x0401, TryCatch #1 {Exception -> 0x03ef, blocks: (B:97:0x0182, B:99:0x019f, B:101:0x01af, B:103:0x01d7, B:105:0x01e4, B:104:0x01dc, B:123:0x0230, B:125:0x0245), top: B:219:0x0182 }] */
    /* JADX WARN: Code duplicated, block: B:106:0x0207  */
    /* JADX WARN: Code duplicated, block: B:119:0x0222  */
    /* JADX WARN: Code duplicated, block: B:121:0x022d  */
    /* JADX WARN: Code duplicated, block: B:123:0x0230 A[Catch: Exception -> 0x03ef, all -> 0x0401, TryCatch #1 {Exception -> 0x03ef, blocks: (B:97:0x0182, B:99:0x019f, B:101:0x01af, B:103:0x01d7, B:105:0x01e4, B:104:0x01dc, B:123:0x0230, B:125:0x0245), top: B:219:0x0182 }] */
    /* JADX WARN: Code duplicated, block: B:125:0x0245 A[Catch: Exception -> 0x03ef, all -> 0x0401, TRY_LEAVE, TryCatch #1 {Exception -> 0x03ef, blocks: (B:97:0x0182, B:99:0x019f, B:101:0x01af, B:103:0x01d7, B:105:0x01e4, B:104:0x01dc, B:123:0x0230, B:125:0x0245), top: B:219:0x0182 }] */
    /* JADX WARN: Code duplicated, block: B:135:0x029a A[Catch: all -> 0x03e1, Exception -> 0x03e5, TRY_LEAVE, TryCatch #0 {all -> 0x03e1, blocks: (B:128:0x0250, B:130:0x0271, B:133:0x0287, B:135:0x029a, B:137:0x02a2, B:144:0x02b2, B:147:0x02bc, B:149:0x02f3, B:148:0x02d9, B:150:0x02f6, B:152:0x0312, B:154:0x031a, B:141:0x02a8), top: B:217:0x0250 }] */
    /* JADX WARN: Code duplicated, block: B:144:0x02b2 A[Catch: all -> 0x03e1, Exception -> 0x03e5, TRY_LEAVE, TryCatch #0 {all -> 0x03e1, blocks: (B:128:0x0250, B:130:0x0271, B:133:0x0287, B:135:0x029a, B:137:0x02a2, B:144:0x02b2, B:147:0x02bc, B:149:0x02f3, B:148:0x02d9, B:150:0x02f6, B:152:0x0312, B:154:0x031a, B:141:0x02a8), top: B:217:0x0250 }] */
    /* JADX WARN: Code duplicated, block: B:147:0x02bc A[Catch: all -> 0x03e1, Exception -> 0x03e5, TRY_ENTER, TryCatch #0 {all -> 0x03e1, blocks: (B:128:0x0250, B:130:0x0271, B:133:0x0287, B:135:0x029a, B:137:0x02a2, B:144:0x02b2, B:147:0x02bc, B:149:0x02f3, B:148:0x02d9, B:150:0x02f6, B:152:0x0312, B:154:0x031a, B:141:0x02a8), top: B:217:0x0250 }] */
    /* JADX WARN: Code duplicated, block: B:148:0x02d9 A[Catch: all -> 0x03e1, Exception -> 0x03e5, TryCatch #0 {all -> 0x03e1, blocks: (B:128:0x0250, B:130:0x0271, B:133:0x0287, B:135:0x029a, B:137:0x02a2, B:144:0x02b2, B:147:0x02bc, B:149:0x02f3, B:148:0x02d9, B:150:0x02f6, B:152:0x0312, B:154:0x031a, B:141:0x02a8), top: B:217:0x0250 }] */
    /* JADX WARN: Code duplicated, block: B:152:0x0312 A[Catch: all -> 0x03e1, Exception -> 0x03e5, TRY_LEAVE, TryCatch #0 {all -> 0x03e1, blocks: (B:128:0x0250, B:130:0x0271, B:133:0x0287, B:135:0x029a, B:137:0x02a2, B:144:0x02b2, B:147:0x02bc, B:149:0x02f3, B:148:0x02d9, B:150:0x02f6, B:152:0x0312, B:154:0x031a, B:141:0x02a8), top: B:217:0x0250 }] */
    /* JADX WARN: Code duplicated, block: B:161:0x033e A[Catch: all -> 0x03a3, Exception -> 0x03a5, TryCatch #37 {Exception -> 0x03a5, all -> 0x03a3, blocks: (B:159:0x0338, B:161:0x033e, B:163:0x0348, B:170:0x0360), top: B:266:0x0325 }] */
    /* JADX WARN: Code duplicated, block: B:163:0x0348 A[Catch: all -> 0x03a3, Exception -> 0x03a5, TryCatch #37 {Exception -> 0x03a5, all -> 0x03a3, blocks: (B:159:0x0338, B:161:0x033e, B:163:0x0348, B:170:0x0360), top: B:266:0x0325 }] */
    /* JADX WARN: Code duplicated, block: B:170:0x0360 A[Catch: all -> 0x03a3, Exception -> 0x03a5, TRY_LEAVE, TryCatch #37 {Exception -> 0x03a5, all -> 0x03a3, blocks: (B:159:0x0338, B:161:0x033e, B:163:0x0348, B:170:0x0360), top: B:266:0x0325 }] */
    /* JADX WARN: Code duplicated, block: B:174:0x037b A[Catch: Exception -> 0x03ff, all -> 0x0410, TryCatch #28 {all -> 0x0410, blocks: (B:200:0x03f8, B:209:0x0409, B:172:0x0375, B:174:0x037b, B:175:0x0381, B:177:0x0397, B:178:0x039b, B:179:0x039e, B:186:0x03ad, B:188:0x03cf, B:190:0x03dd), top: B:253:0x0010 }] */
    /* JADX WARN: Code duplicated, block: B:175:0x0381 A[Catch: Exception -> 0x03ff, all -> 0x0410, TryCatch #28 {all -> 0x0410, blocks: (B:200:0x03f8, B:209:0x0409, B:172:0x0375, B:174:0x037b, B:175:0x0381, B:177:0x0397, B:178:0x039b, B:179:0x039e, B:186:0x03ad, B:188:0x03cf, B:190:0x03dd), top: B:253:0x0010 }] */
    /* JADX WARN: Code duplicated, block: B:177:0x0397 A[Catch: Exception -> 0x03ff, all -> 0x0410, TryCatch #28 {all -> 0x0410, blocks: (B:200:0x03f8, B:209:0x0409, B:172:0x0375, B:174:0x037b, B:175:0x0381, B:177:0x0397, B:178:0x039b, B:179:0x039e, B:186:0x03ad, B:188:0x03cf, B:190:0x03dd), top: B:253:0x0010 }] */
    /* JADX WARN: Code duplicated, block: B:178:0x039b A[Catch: Exception -> 0x03ff, all -> 0x0410, TryCatch #28 {all -> 0x0410, blocks: (B:200:0x03f8, B:209:0x0409, B:172:0x0375, B:174:0x037b, B:175:0x0381, B:177:0x0397, B:178:0x039b, B:179:0x039e, B:186:0x03ad, B:188:0x03cf, B:190:0x03dd), top: B:253:0x0010 }] */
    /* JADX WARN: Code duplicated, block: B:186:0x03ad A[Catch: Exception -> 0x03ff, all -> 0x0410, TryCatch #28 {all -> 0x0410, blocks: (B:200:0x03f8, B:209:0x0409, B:172:0x0375, B:174:0x037b, B:175:0x0381, B:177:0x0397, B:178:0x039b, B:179:0x039e, B:186:0x03ad, B:188:0x03cf, B:190:0x03dd), top: B:253:0x0010 }] */
    /* JADX WARN: Code duplicated, block: B:188:0x03cf A[Catch: Exception -> 0x03ff, all -> 0x0410, TryCatch #28 {all -> 0x0410, blocks: (B:200:0x03f8, B:209:0x0409, B:172:0x0375, B:174:0x037b, B:175:0x0381, B:177:0x0397, B:178:0x039b, B:179:0x039e, B:186:0x03ad, B:188:0x03cf, B:190:0x03dd), top: B:253:0x0010 }] */
    /* JADX WARN: Code duplicated, block: B:190:0x03dd A[Catch: Exception -> 0x03ff, all -> 0x0410, TryCatch #28 {all -> 0x0410, blocks: (B:200:0x03f8, B:209:0x0409, B:172:0x0375, B:174:0x037b, B:175:0x0381, B:177:0x0397, B:178:0x039b, B:179:0x039e, B:186:0x03ad, B:188:0x03cf, B:190:0x03dd), top: B:253:0x0010 }] */
    /* JADX WARN: Code duplicated, block: B:198:0x03f2  */
    /* JADX WARN: Code duplicated, block: B:200:0x03f8 A[Catch: Exception -> 0x03ff, all -> 0x0410, TRY_LEAVE, TryCatch #28 {all -> 0x0410, blocks: (B:200:0x03f8, B:209:0x0409, B:172:0x0375, B:174:0x037b, B:175:0x0381, B:177:0x0397, B:178:0x039b, B:179:0x039e, B:186:0x03ad, B:188:0x03cf, B:190:0x03dd), top: B:253:0x0010 }] */
    /* JADX WARN: Code duplicated, block: B:214:0x0415  */
    /* JADX WARN: Code duplicated, block: B:217:0x0250 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:269:0x0160 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:271:0x0327 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:85:0x0140  */
    /* JADX WARN: Code duplicated, block: B:90:0x016b A[Catch: all -> 0x012e, Exception -> 0x0135, TRY_ENTER, TRY_LEAVE, TryCatch #5 {Exception -> 0x0135, blocks: (B:9:0x002c, B:11:0x0032, B:80:0x012a, B:86:0x0148, B:90:0x016b, B:93:0x0174), top: B:224:0x002c }] */
    /* JADX WARN: Code duplicated, block: B:93:0x0174 A[Catch: all -> 0x012e, Exception -> 0x0135, TRY_ENTER, TRY_LEAVE, TryCatch #5 {Exception -> 0x0135, blocks: (B:9:0x002c, B:11:0x0032, B:80:0x012a, B:86:0x0148, B:90:0x016b, B:93:0x0174), top: B:224:0x002c }] */
    /* JADX WARN: Code duplicated, block: B:99:0x019f A[Catch: Exception -> 0x03ef, all -> 0x0401, TryCatch #1 {Exception -> 0x03ef, blocks: (B:97:0x0182, B:99:0x019f, B:101:0x01af, B:103:0x01d7, B:105:0x01e4, B:104:0x01dc, B:123:0x0230, B:125:0x0245), top: B:219:0x0182 }] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r13v24 */
    /* JADX WARN: Type inference failed for: r13v31 */
    /* JADX WARN: Type inference failed for: r13v32 */
    /* JADX WARN: Type inference failed for: r13v33 */
    /* JADX WARN: Type inference failed for: r13v34 */
    /* JADX WARN: Type inference failed for: r13v37 */
    /* JADX WARN: Type inference failed for: r13v38 */
    /* JADX WARN: Type inference failed for: r13v39 */
    /* JADX WARN: Type inference failed for: r13v40 */
    /* JADX WARN: Type inference failed for: r13v41 */
    /* JADX WARN: Type inference failed for: r13v42 */
    /* JADX WARN: Type inference failed for: r13v43 */
    /* JADX WARN: Type inference failed for: r13v44 */
    /* JADX WARN: Type inference failed for: r13v50 */
    /* JADX WARN: Type inference failed for: r13v51 */
    /* JADX WARN: Type inference failed for: r13v52 */
    /* JADX WARN: Type inference failed for: r13v53 */
    /* JADX WARN: Type inference failed for: r13v55 */
    /* JADX WARN: Type inference failed for: r13v56 */
    /* JADX WARN: Type inference failed for: r13v57 */
    /* JADX WARN: Type inference failed for: r13v58 */
    /* JADX WARN: Type inference failed for: r13v59 */
    /* JADX WARN: Type inference failed for: r13v60 */
    /* JADX WARN: Type inference failed for: r24v0 */
    /* JADX WARN: Type inference failed for: r24v1 */
    /* JADX WARN: Type inference failed for: r24v2 */
    /* JADX WARN: Type inference failed for: r24v3 */
    /* JADX WARN: Type inference failed for: r24v4 */
    /* JADX WARN: Type inference failed for: r24v6 */
    /* JADX WARN: Type inference failed for: r24v7 */
    /* JADX WARN: Type inference failed for: r24v8 */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean d(Context context, com.opos.mobad.l.a aVar, com.opos.cmn.func.a.a.e eVar) throws Throwable {
        String str;
        File file;
        String str2;
        int i;
        boolean z;
        long[] jArr;
        long[] jArr2;
        Throwable th;
        Throwable th2;
        long[] jArr3;
        String str3;
        String str4;
        String str5;
        String str6;
        int iA;
        int i2;
        long[] jArr4;
        int iA2;
        int i3;
        File file2;
        File file3;
        boolean z2;
        c[] cVarArr;
        int i4;
        CountDownLatch countDownLatch;
        ?? r4;
        boolean z3;
        ?? r24;
        c[] cVarArr2;
        int i5;
        int i6;
        int i7;
        String str7;
        ?? r13;
        ?? r14;
        String str8;
        ?? r15;
        String str9;
        String str10;
        String str11;
        com.opos.cmn.func.a.a.e eVar2;
        ?? r16;
        File file4;
        ?? r25;
        com.opos.cmn.func.a.a.e eVar3 = eVar;
        ?? r5 = "downloadLargeFile";
        String str12 = "DownloadEngineImpl";
        boolean zB = false;
        zB = false;
        zB = false;
        zB = false;
        zB = false;
        zB = false;
        zB = false;
        zB = false;
        zB = false;
        if (context == null || aVar == null) {
            str = "DownloadEngineImpl";
        } else {
            try {
                if (eVar3 != null) {
                    try {
                        try {
                            File fileA = d.a(context, aVar);
                            File fileB = d.b(context, aVar);
                            File fileC = d.c(context, aVar);
                            String str13 = "endPos[";
                            String str14 = "blockNum=";
                            if (com.opos.cmn.an.e.b.a.a(fileC)) {
                                try {
                                    try {
                                        if (com.opos.cmn.an.e.b.a.a(fileB)) {
                                            com.opos.cmn.an.f.a.b("DownloadEngineImpl", "tmpFile and posFile all exists.");
                                            com.opos.cmn.an.f.a.b("DownloadEngineImpl", "read pos info from posFile.");
                                            try {
                                                FileInputStream fileInputStream = new FileInputStream(fileC);
                                                try {
                                                    DataInputStream dataInputStream = new DataInputStream(fileInputStream);
                                                    try {
                                                        int i8 = dataInputStream.readInt();
                                                        try {
                                                            com.opos.cmn.an.f.a.b("DownloadEngineImpl", "blockNum=" + i8);
                                                            file = fileA;
                                                            try {
                                                                jArr3 = new long[i8];
                                                                try {
                                                                    jArr = new long[i8];
                                                                    int i9 = 0;
                                                                    String str15 = str13;
                                                                    while (i9 < i8) {
                                                                        try {
                                                                            jArr3[i9] = dataInputStream.readLong();
                                                                            i = i8;
                                                                            try {
                                                                                com.opos.cmn.an.f.a.b("DownloadEngineImpl", "startPos[" + i9 + "]=" + jArr3[i9]);
                                                                                jArr[i9] = dataInputStream.readLong();
                                                                                str5 = str15;
                                                                                try {
                                                                                    com.opos.cmn.an.f.a.b("DownloadEngineImpl", str15 + i9 + "]=" + jArr[i9]);
                                                                                    i9++;
                                                                                    str15 = str5;
                                                                                    i8 = i;
                                                                                } catch (Throwable th3) {
                                                                                    th = th3;
                                                                                    th2 = th;
                                                                                    str4 = str5;
                                                                                    try {
                                                                                        throw th2;
                                                                                    } catch (Throwable th4) {
                                                                                        try {
                                                                                            dataInputStream.close();
                                                                                            throw th4;
                                                                                        } catch (Throwable th5) {
                                                                                            th2.addSuppressed(th5);
                                                                                            throw th4;
                                                                                        }
                                                                                    }
                                                                                }
                                                                            } catch (Throwable th6) {
                                                                                th = th6;
                                                                                str5 = str15;
                                                                                th2 = th;
                                                                                str4 = str5;
                                                                                throw th2;
                                                                            }
                                                                        } catch (Throwable th7) {
                                                                            th = th7;
                                                                            i = i8;
                                                                        }
                                                                    }
                                                                    i = i8;
                                                                    str2 = str15;
                                                                    try {
                                                                        dataInputStream.close();
                                                                        try {
                                                                            fileInputStream.close();
                                                                            jArr2 = jArr3;
                                                                            z = false;
                                                                            str6 = str2;
                                                                        } catch (Exception e) {
                                                                            e = e;
                                                                            jArr2 = jArr3;
                                                                            z = false;
                                                                            com.opos.cmn.an.f.a.a("DownloadEngineImpl", "downloadLargeFile", (Throwable) e);
                                                                            str6 = str2;
                                                                        }
                                                                    } catch (Throwable th8) {
                                                                        th = th8;
                                                                        jArr2 = jArr3;
                                                                        z = false;
                                                                        str2 = str2;
                                                                        try {
                                                                            throw th;
                                                                        } catch (Throwable th9) {
                                                                            try {
                                                                                fileInputStream.close();
                                                                                throw th9;
                                                                            } catch (Throwable th10) {
                                                                                try {
                                                                                    th.addSuppressed(th10);
                                                                                    throw th9;
                                                                                } catch (Exception e2) {
                                                                                    e = e2;
                                                                                    com.opos.cmn.an.f.a.a("DownloadEngineImpl", "downloadLargeFile", (Throwable) e);
                                                                                    str6 = str2;
                                                                                    com.opos.cmn.an.f.a.b("DownloadEngineImpl", "needInitPosInfo=" + z);
                                                                                    if (z) {
                                                                                        try {
                                                                                            com.opos.cmn.an.f.a.b("DownloadEngineImpl", "tmpFile or posFile not exists.");
                                                                                            if (com.opos.cmn.an.e.b.a.a(fileC)) {
                                                                                                com.opos.cmn.an.e.b.a.e(fileC);
                                                                                            }
                                                                                            if (com.opos.cmn.an.e.b.a.a(fileB)) {
                                                                                                com.opos.cmn.an.e.b.a.e(fileB);
                                                                                            }
                                                                                            try {
                                                                                                a(fileC);
                                                                                                a(fileB);
                                                                                                eVar3 = eVar;
                                                                                                try {
                                                                                                    iA = a(eVar3.d);
                                                                                                    com.opos.cmn.an.f.a.b("DownloadEngineImpl", "blockNum=" + iA);
                                                                                                    if (iA > 1) {
                                                                                                        iA2 = a(eVar3.d, iA);
                                                                                                        jArr2 = new long[iA];
                                                                                                        jArr = new long[iA];
                                                                                                        i3 = 0;
                                                                                                        while (i3 < iA) {
                                                                                                            String str16 = str6;
                                                                                                            jArr2[i3] = i3 * iA2;
                                                                                                            com.opos.cmn.an.f.a.b("DownloadEngineImpl", "startPos[" + i3 + "]=" + jArr2[i3]);
                                                                                                            if (i3 == iA - 1) {
                                                                                                                str14 = str14;
                                                                                                                str6 = str6;
                                                                                                                jArr[i3] = eVar3.d;
                                                                                                            } else {
                                                                                                                str14 = str14;
                                                                                                                str6 = str6;
                                                                                                                jArr[i3] = ((i3 + 1) * iA2) - 1;
                                                                                                            }
                                                                                                            String str17 = str16;
                                                                                                            com.opos.cmn.an.f.a.b("DownloadEngineImpl", str17 + i3 + "]=" + jArr[i3]);
                                                                                                            i3++;
                                                                                                            str6 = str17;
                                                                                                            str14 = str17;
                                                                                                        }
                                                                                                        str14 = str14;
                                                                                                        str6 = str6;
                                                                                                    }
                                                                                                    i2 = iA;
                                                                                                    jArr4 = jArr2;
                                                                                                    str12 = str14;
                                                                                                    r5 = str6;
                                                                                                } catch (Exception e3) {
                                                                                                    e = e3;
                                                                                                    com.opos.cmn.an.f.a.a(str12, (String) r5, (Throwable) e);
                                                                                                    eVar.a();
                                                                                                    str = str12;
                                                                                                    com.opos.cmn.an.f.a.b(str, "downloadLargeFile downloadRequest", aVar, "netResponse=", eVar, "result=", Boolean.valueOf(zB));
                                                                                                    return zB;
                                                                                                }
                                                                                            } catch (Exception e4) {
                                                                                                e = e4;
                                                                                                eVar3 = eVar;
                                                                                                com.opos.cmn.an.f.a.a(str12, (String) r5, (Throwable) e);
                                                                                                eVar.a();
                                                                                                str = str12;
                                                                                                com.opos.cmn.an.f.a.b(str, "downloadLargeFile downloadRequest", aVar, "netResponse=", eVar, "result=", Boolean.valueOf(zB));
                                                                                                return zB;
                                                                                            } catch (Throwable th11) {
                                                                                                th = th11;
                                                                                                eVar3 = eVar;
                                                                                                eVar.a();
                                                                                                throw th;
                                                                                            }
                                                                                        } catch (Exception e5) {
                                                                                            e = e5;
                                                                                        } catch (Throwable th12) {
                                                                                            th = th12;
                                                                                        }
                                                                                    } else {
                                                                                        eVar3 = eVar;
                                                                                        jArr4 = jArr2;
                                                                                        i2 = i;
                                                                                        str12 = str14;
                                                                                        r5 = str6;
                                                                                    }
                                                                                    if (i2 > 0) {
                                                                                        z2 = true;
                                                                                        if (1 == i2) {
                                                                                            com.opos.cmn.an.f.a.b("DownloadEngineImpl", "blockNum=1,just download as normal file.");
                                                                                            zB = b(context, aVar, eVar);
                                                                                        } else {
                                                                                            cVarArr = new c[i2];
                                                                                            i4 = 0;
                                                                                            r4 = r5;
                                                                                            countDownLatch = new CountDownLatch(i2);
                                                                                            while (i4 < i2) {
                                                                                                try {
                                                                                                    try {
                                                                                                        int i10 = i4;
                                                                                                        boolean z4 = z2;
                                                                                                        r24 = r4;
                                                                                                        CountDownLatch countDownLatch2 = countDownLatch;
                                                                                                        c[] cVarArr3 = cVarArr;
                                                                                                        File file5 = fileC;
                                                                                                        try {
                                                                                                            cVarArr3[i10] = new c(context, aVar, eVar3.d, jArr4[i4], jArr[i4], countDownLatch2);
                                                                                                            i4 = i10 + 1;
                                                                                                            countDownLatch = countDownLatch2;
                                                                                                            cVarArr = cVarArr3;
                                                                                                            fileC = file5;
                                                                                                            r4 = r24;
                                                                                                            z2 = z4;
                                                                                                        } catch (Exception e6) {
                                                                                                            e = e6;
                                                                                                            r25 = r24;
                                                                                                            r5 = r25;
                                                                                                            com.opos.cmn.an.f.a.a(str12, (String) r5, (Throwable) e);
                                                                                                            eVar.a();
                                                                                                            str = str12;
                                                                                                            com.opos.cmn.an.f.a.b(str, "downloadLargeFile downloadRequest", aVar, "netResponse=", eVar, "result=", Boolean.valueOf(zB));
                                                                                                            return zB;
                                                                                                        }
                                                                                                    } catch (Throwable th13) {
                                                                                                        th = th13;
                                                                                                        eVar.a();
                                                                                                        throw th;
                                                                                                    }
                                                                                                } catch (Exception e7) {
                                                                                                    e = e7;
                                                                                                    r24 = r4;
                                                                                                    r25 = r24;
                                                                                                    r5 = r25;
                                                                                                    com.opos.cmn.an.f.a.a(str12, (String) r5, (Throwable) e);
                                                                                                    eVar.a();
                                                                                                    str = str12;
                                                                                                    com.opos.cmn.an.f.a.b(str, "downloadLargeFile downloadRequest", aVar, "netResponse=", eVar, "result=", Boolean.valueOf(zB));
                                                                                                    return zB;
                                                                                                }
                                                                                            }
                                                                                            z3 = z2;
                                                                                            r24 = r4;
                                                                                            CountDownLatch countDownLatch3 = countDownLatch;
                                                                                            cVarArr2 = cVarArr;
                                                                                            file3 = fileC;
                                                                                            b bVar = new b(file3, i2, cVarArr2);
                                                                                            bVar.start();
                                                                                            for (i5 = 0; i5 < i2; i5++) {
                                                                                                com.opos.cmn.an.j.b.e(cVarArr2[i5]);
                                                                                            }
                                                                                            try {
                                                                                                countDownLatch3.await();
                                                                                            } catch (InterruptedException e8) {
                                                                                                com.opos.cmn.an.f.a.a("DownloadEngineImpl", "countDownLatch.await()", (Throwable) e8);
                                                                                            }
                                                                                            i7 = 0;
                                                                                            for (i6 = 0; i6 < i2; i6++) {
                                                                                                if (cVarArr2[i6].c()) {
                                                                                                    com.opos.cmn.an.f.a.b("DownloadEngineImpl", "dlThreads[" + i6 + "] download success.");
                                                                                                    i7++;
                                                                                                } else {
                                                                                                    com.opos.cmn.an.f.a.b("DownloadEngineImpl", "dlThreads[" + i6 + "] download fail.");
                                                                                                }
                                                                                            }
                                                                                            com.opos.cmn.an.f.a.b("DownloadEngineImpl", "successCount=" + i7);
                                                                                            bVar.a();
                                                                                            if (i7 == i2) {
                                                                                                Object[] objArr = new Object[2];
                                                                                                objArr[0] = "successCount = blockNum,download success.";
                                                                                                try {
                                                                                                    objArr[z3 ? 1 : 0] = aVar;
                                                                                                    com.opos.cmn.an.f.a.b("DownloadEngineImpl", objArr);
                                                                                                    try {
                                                                                                        if (com.opos.cmn.an.e.b.a.a(file)) {
                                                                                                            str11 = "DownloadEngineImpl";
                                                                                                            eVar2 = eVar3;
                                                                                                            file2 = fileB;
                                                                                                            r16 = r24;
                                                                                                            com.opos.cmn.an.f.a.b(str11, "target file exists.");
                                                                                                            file3 = file3;
                                                                                                            file4 = file;
                                                                                                            if (a(file4, aVar.b, eVar2.d)) {
                                                                                                                com.opos.cmn.an.f.a.b(str11, "targetFile exists and valid, don't need rename!");
                                                                                                                str9 = str11;
                                                                                                                r15 = r16;
                                                                                                            } else {
                                                                                                                com.opos.cmn.an.f.a.b(str11, "targetFile exists but not valid, rename it!");
                                                                                                                com.opos.cmn.an.e.b.a.e(file4);
                                                                                                                if (a(file4, file2, aVar.b, eVar2.d)) {
                                                                                                                    com.opos.cmn.an.f.a.b(str11, "target file not exists.");
                                                                                                                    str9 = str11;
                                                                                                                    r15 = r16;
                                                                                                                } else {
                                                                                                                    com.opos.cmn.an.e.b.a.e(file2);
                                                                                                                    str8 = str11;
                                                                                                                    r14 = r16;
                                                                                                                    com.opos.cmn.an.e.b.a.e(file3);
                                                                                                                    str12 = str8;
                                                                                                                    r5 = r14;
                                                                                                                }
                                                                                                            }
                                                                                                            zB = z3 ? 1 : 0;
                                                                                                            str12 = str9;
                                                                                                            r5 = r15;
                                                                                                        } else {
                                                                                                            try {
                                                                                                                file2 = fileB;
                                                                                                                str10 = "DownloadEngineImpl";
                                                                                                                r5 = r24;
                                                                                                                if (a(file, file2, aVar.b, eVar3.d)) {
                                                                                                                    com.opos.cmn.an.f.a.b(str10, "target file not exists.");
                                                                                                                    zB = z3 ? 1 : 0;
                                                                                                                } else {
                                                                                                                    com.opos.cmn.an.e.b.a.e(file2);
                                                                                                                    com.opos.cmn.an.e.b.a.e(file3);
                                                                                                                }
                                                                                                                str12 = str10;
                                                                                                            } catch (Exception e9) {
                                                                                                                e = e9;
                                                                                                                str12 = "DownloadEngineImpl";
                                                                                                                r5 = r24;
                                                                                                                com.opos.cmn.an.f.a.a(str12, (String) r5, (Throwable) e);
                                                                                                            } catch (Throwable th14) {
                                                                                                                th = th14;
                                                                                                                eVar.a();
                                                                                                                throw th;
                                                                                                            }
                                                                                                        }
                                                                                                    } catch (Exception e10) {
                                                                                                        e = e10;
                                                                                                        str12 = str12;
                                                                                                        r5 = countDownLatch;
                                                                                                    } catch (Throwable th15) {
                                                                                                        th = th15;
                                                                                                    }
                                                                                                } catch (Exception e11) {
                                                                                                    e = e11;
                                                                                                    r25 = r24;
                                                                                                    r5 = r25;
                                                                                                    com.opos.cmn.an.f.a.a(str12, (String) r5, (Throwable) e);
                                                                                                    eVar.a();
                                                                                                    str = str12;
                                                                                                    com.opos.cmn.an.f.a.b(str, "downloadLargeFile downloadRequest", aVar, "netResponse=", eVar, "result=", Boolean.valueOf(zB));
                                                                                                    return zB;
                                                                                                }
                                                                                            } else {
                                                                                                str7 = "DownloadEngineImpl";
                                                                                                file3 = file3;
                                                                                                file2 = fileB;
                                                                                                r13 = r24;
                                                                                                Object[] objArr2 = new Object[2];
                                                                                                objArr2[0] = "successCount != blockNum,maybe target file has download success,try it.";
                                                                                                objArr2[z3 ? 1 : 0] = aVar;
                                                                                                com.opos.cmn.an.f.a.b(str7, objArr2);
                                                                                                if (a(file, aVar.b, eVar3.d)) {
                                                                                                    Object[] objArr3 = new Object[2];
                                                                                                    objArr3[0] = "target file exists and valid,don't need rename.";
                                                                                                    objArr3[z3 ? 1 : 0] = aVar;
                                                                                                    com.opos.cmn.an.f.a.b(str7, objArr3);
                                                                                                    str9 = str7;
                                                                                                    r15 = r13;
                                                                                                    zB = z3 ? 1 : 0;
                                                                                                    str12 = str9;
                                                                                                    r5 = r15;
                                                                                                } else {
                                                                                                    com.opos.cmn.an.e.b.a.e(file2);
                                                                                                    str8 = str7;
                                                                                                    r14 = r13;
                                                                                                    com.opos.cmn.an.e.b.a.e(file3);
                                                                                                    str12 = str8;
                                                                                                    r5 = r14;
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                        if (zB) {
                                                                                            com.opos.cmn.an.e.b.a.e(file2);
                                                                                            com.opos.cmn.an.e.b.a.e(file3);
                                                                                        }
                                                                                        eVar.a();
                                                                                        str = str12;
                                                                                        com.opos.cmn.an.f.a.b(str, "downloadLargeFile downloadRequest", aVar, "netResponse=", eVar, "result=", Boolean.valueOf(zB));
                                                                                        return zB;
                                                                                    }
                                                                                    str12 = "DownloadEngineImpl";
                                                                                    r5 = "downloadLargeFile";
                                                                                    file3 = fileC;
                                                                                    file2 = fileB;
                                                                                    if (zB) {
                                                                                        com.opos.cmn.an.e.b.a.e(file2);
                                                                                        com.opos.cmn.an.e.b.a.e(file3);
                                                                                    }
                                                                                    eVar.a();
                                                                                    str = str12;
                                                                                    com.opos.cmn.an.f.a.b(str, "downloadLargeFile downloadRequest", aVar, "netResponse=", eVar, "result=", Boolean.valueOf(zB));
                                                                                    return zB;
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                } catch (Throwable th16) {
                                                                    i = i8;
                                                                    str3 = "endPos[";
                                                                    th2 = th16;
                                                                    jArr = null;
                                                                    str4 = str3;
                                                                    throw th2;
                                                                }
                                                            } catch (Throwable th17) {
                                                                th = th17;
                                                                i = i8;
                                                                th2 = th;
                                                                jArr3 = null;
                                                                str3 = str13;
                                                                jArr = null;
                                                                str4 = str3;
                                                                throw th2;
                                                            }
                                                        } catch (Throwable th18) {
                                                            th = th18;
                                                            file = fileA;
                                                        }
                                                    } catch (Throwable th19) {
                                                        file = fileA;
                                                        th2 = th19;
                                                        i = 0;
                                                    }
                                                } catch (Throwable th20) {
                                                    file = fileA;
                                                    str2 = "endPos[";
                                                    th = th20;
                                                    i = 0;
                                                    z = true;
                                                    jArr = null;
                                                    jArr2 = null;
                                                }
                                            } catch (Exception e12) {
                                                e = e12;
                                                file = fileA;
                                                str2 = "endPos[";
                                                i = 0;
                                                z = true;
                                                jArr = null;
                                                jArr2 = null;
                                            }
                                        } else {
                                            file = fileA;
                                            str6 = "endPos[";
                                            i = 0;
                                            z = true;
                                            jArr = null;
                                            jArr2 = null;
                                        }
                                        com.opos.cmn.an.f.a.b("DownloadEngineImpl", "needInitPosInfo=" + z);
                                        if (z) {
                                            com.opos.cmn.an.f.a.b("DownloadEngineImpl", "tmpFile or posFile not exists.");
                                            if (com.opos.cmn.an.e.b.a.a(fileC)) {
                                                com.opos.cmn.an.e.b.a.e(fileC);
                                            }
                                            if (com.opos.cmn.an.e.b.a.a(fileB)) {
                                                com.opos.cmn.an.e.b.a.e(fileB);
                                            }
                                            a(fileC);
                                            a(fileB);
                                            eVar3 = eVar;
                                            iA = a(eVar3.d);
                                            com.opos.cmn.an.f.a.b("DownloadEngineImpl", "blockNum=" + iA);
                                            if (iA > 1) {
                                                iA2 = a(eVar3.d, iA);
                                                jArr2 = new long[iA];
                                                jArr = new long[iA];
                                                i3 = 0;
                                                while (i3 < iA) {
                                                    String str18 = str6;
                                                    jArr2[i3] = i3 * iA2;
                                                    com.opos.cmn.an.f.a.b("DownloadEngineImpl", "startPos[" + i3 + "]=" + jArr2[i3]);
                                                    if (i3 == iA - 1) {
                                                        str14 = str14;
                                                        str6 = str6;
                                                        jArr[i3] = eVar3.d;
                                                    } else {
                                                        str14 = str14;
                                                        str6 = str6;
                                                        jArr[i3] = ((i3 + 1) * iA2) - 1;
                                                    }
                                                    String str19 = str18;
                                                    com.opos.cmn.an.f.a.b("DownloadEngineImpl", str19 + i3 + "]=" + jArr[i3]);
                                                    i3++;
                                                    str6 = str19;
                                                    str14 = str19;
                                                }
                                                str14 = str14;
                                                str6 = str6;
                                            }
                                            i2 = iA;
                                            jArr4 = jArr2;
                                            str12 = str14;
                                            r5 = str6;
                                        } else {
                                            eVar3 = eVar;
                                            jArr4 = jArr2;
                                            i2 = i;
                                            str12 = str14;
                                            r5 = str6;
                                        }
                                        try {
                                            if (i2 > 0) {
                                                z2 = true;
                                                if (1 == i2) {
                                                    com.opos.cmn.an.f.a.b("DownloadEngineImpl", "blockNum=1,just download as normal file.");
                                                    zB = b(context, aVar, eVar);
                                                } else {
                                                    cVarArr = new c[i2];
                                                    i4 = 0;
                                                    r4 = r5;
                                                    countDownLatch = new CountDownLatch(i2);
                                                    while (i4 < i2) {
                                                        int i11 = i4;
                                                        boolean z5 = z2;
                                                        r24 = r4;
                                                        CountDownLatch countDownLatch4 = countDownLatch;
                                                        c[] cVarArr4 = cVarArr;
                                                        File file6 = fileC;
                                                        cVarArr4[i11] = new c(context, aVar, eVar3.d, jArr4[i4], jArr[i4], countDownLatch4);
                                                        i4 = i11 + 1;
                                                        countDownLatch = countDownLatch4;
                                                        cVarArr = cVarArr4;
                                                        fileC = file6;
                                                        r4 = r24;
                                                        z2 = z5;
                                                    }
                                                    z3 = z2;
                                                    r24 = r4;
                                                    CountDownLatch countDownLatch5 = countDownLatch;
                                                    cVarArr2 = cVarArr;
                                                    file3 = fileC;
                                                    b bVar2 = new b(file3, i2, cVarArr2);
                                                    bVar2.start();
                                                    while (i5 < i2) {
                                                        com.opos.cmn.an.j.b.e(cVarArr2[i5]);
                                                    }
                                                    countDownLatch5.await();
                                                    i7 = 0;
                                                    while (i6 < i2) {
                                                        if (cVarArr2[i6].c()) {
                                                            com.opos.cmn.an.f.a.b("DownloadEngineImpl", "dlThreads[" + i6 + "] download success.");
                                                            i7++;
                                                        } else {
                                                            com.opos.cmn.an.f.a.b("DownloadEngineImpl", "dlThreads[" + i6 + "] download fail.");
                                                        }
                                                    }
                                                    com.opos.cmn.an.f.a.b("DownloadEngineImpl", "successCount=" + i7);
                                                    bVar2.a();
                                                    if (i7 == i2) {
                                                        Object[] objArr4 = new Object[2];
                                                        objArr4[0] = "successCount = blockNum,download success.";
                                                        objArr4[z3 ? 1 : 0] = aVar;
                                                        com.opos.cmn.an.f.a.b("DownloadEngineImpl", objArr4);
                                                        if (com.opos.cmn.an.e.b.a.a(file)) {
                                                            file2 = fileB;
                                                            str10 = "DownloadEngineImpl";
                                                            r5 = r24;
                                                            if (a(file, file2, aVar.b, eVar3.d)) {
                                                                com.opos.cmn.an.f.a.b(str10, "target file not exists.");
                                                                zB = z3 ? 1 : 0;
                                                            } else {
                                                                com.opos.cmn.an.e.b.a.e(file2);
                                                                com.opos.cmn.an.e.b.a.e(file3);
                                                            }
                                                            str12 = str10;
                                                        } else {
                                                            str11 = "DownloadEngineImpl";
                                                            eVar2 = eVar3;
                                                            file2 = fileB;
                                                            r16 = r24;
                                                            com.opos.cmn.an.f.a.b(str11, "target file exists.");
                                                            file3 = file3;
                                                            file4 = file;
                                                            if (a(file4, aVar.b, eVar2.d)) {
                                                                com.opos.cmn.an.f.a.b(str11, "targetFile exists and valid, don't need rename!");
                                                                str9 = str11;
                                                                r15 = r16;
                                                            } else {
                                                                com.opos.cmn.an.f.a.b(str11, "targetFile exists but not valid, rename it!");
                                                                com.opos.cmn.an.e.b.a.e(file4);
                                                                if (a(file4, file2, aVar.b, eVar2.d)) {
                                                                    com.opos.cmn.an.f.a.b(str11, "target file not exists.");
                                                                    str9 = str11;
                                                                    r15 = r16;
                                                                } else {
                                                                    com.opos.cmn.an.e.b.a.e(file2);
                                                                    str8 = str11;
                                                                    r14 = r16;
                                                                    com.opos.cmn.an.e.b.a.e(file3);
                                                                    str12 = str8;
                                                                    r5 = r14;
                                                                }
                                                            }
                                                            zB = z3 ? 1 : 0;
                                                            str12 = str9;
                                                            r5 = r15;
                                                        }
                                                    } else {
                                                        str7 = "DownloadEngineImpl";
                                                        file3 = file3;
                                                        file2 = fileB;
                                                        r13 = r24;
                                                        Object[] objArr5 = new Object[2];
                                                        objArr5[0] = "successCount != blockNum,maybe target file has download success,try it.";
                                                        objArr5[z3 ? 1 : 0] = aVar;
                                                        com.opos.cmn.an.f.a.b(str7, objArr5);
                                                        if (a(file, aVar.b, eVar3.d)) {
                                                            Object[] objArr6 = new Object[2];
                                                            objArr6[0] = "target file exists and valid,don't need rename.";
                                                            objArr6[z3 ? 1 : 0] = aVar;
                                                            com.opos.cmn.an.f.a.b(str7, objArr6);
                                                            str9 = str7;
                                                            r15 = r13;
                                                            zB = z3 ? 1 : 0;
                                                            str12 = str9;
                                                            r5 = r15;
                                                        } else {
                                                            com.opos.cmn.an.e.b.a.e(file2);
                                                            str8 = str7;
                                                            r14 = r13;
                                                            com.opos.cmn.an.e.b.a.e(file3);
                                                            str12 = str8;
                                                            r5 = r14;
                                                        }
                                                    }
                                                }
                                                if (zB) {
                                                    com.opos.cmn.an.e.b.a.e(file2);
                                                    com.opos.cmn.an.e.b.a.e(file3);
                                                }
                                                eVar.a();
                                                str = str12;
                                            }
                                            str12 = "DownloadEngineImpl";
                                            r5 = "downloadLargeFile";
                                            file3 = fileC;
                                            file2 = fileB;
                                            if (zB) {
                                                com.opos.cmn.an.e.b.a.e(file2);
                                                com.opos.cmn.an.e.b.a.e(file3);
                                            }
                                        } catch (Exception e13) {
                                            e = e13;
                                        }
                                    } catch (Exception e14) {
                                        e = e14;
                                        str12 = "DownloadEngineImpl";
                                        r5 = "downloadLargeFile";
                                        com.opos.cmn.an.f.a.a(str12, (String) r5, (Throwable) e);
                                        eVar.a();
                                        str = str12;
                                        com.opos.cmn.an.f.a.b(str, "downloadLargeFile downloadRequest", aVar, "netResponse=", eVar, "result=", Boolean.valueOf(zB));
                                        return zB;
                                    }
                                    eVar.a();
                                    str = str12;
                                } catch (Throwable th21) {
                                    th = th21;
                                    eVar.a();
                                    throw th;
                                }
                            } else {
                                file = fileA;
                                str6 = "endPos[";
                                i = 0;
                                z = true;
                                jArr = null;
                                jArr2 = null;
                                com.opos.cmn.an.f.a.b("DownloadEngineImpl", "needInitPosInfo=" + z);
                                if (z) {
                                    com.opos.cmn.an.f.a.b("DownloadEngineImpl", "tmpFile or posFile not exists.");
                                    if (com.opos.cmn.an.e.b.a.a(fileC)) {
                                        com.opos.cmn.an.e.b.a.e(fileC);
                                    }
                                    if (com.opos.cmn.an.e.b.a.a(fileB)) {
                                        com.opos.cmn.an.e.b.a.e(fileB);
                                    }
                                    a(fileC);
                                    a(fileB);
                                    eVar3 = eVar;
                                    iA = a(eVar3.d);
                                    com.opos.cmn.an.f.a.b("DownloadEngineImpl", "blockNum=" + iA);
                                    if (iA > 1) {
                                        iA2 = a(eVar3.d, iA);
                                        jArr2 = new long[iA];
                                        jArr = new long[iA];
                                        i3 = 0;
                                        while (i3 < iA) {
                                            String str110 = str6;
                                            jArr2[i3] = i3 * iA2;
                                            com.opos.cmn.an.f.a.b("DownloadEngineImpl", "startPos[" + i3 + "]=" + jArr2[i3]);
                                            if (i3 == iA - 1) {
                                                str14 = str14;
                                                str6 = str6;
                                                jArr[i3] = eVar3.d;
                                            } else {
                                                str14 = str14;
                                                str6 = str6;
                                                jArr[i3] = ((i3 + 1) * iA2) - 1;
                                            }
                                            String str111 = str110;
                                            com.opos.cmn.an.f.a.b("DownloadEngineImpl", str111 + i3 + "]=" + jArr[i3]);
                                            i3++;
                                            str6 = str111;
                                            str14 = str111;
                                        }
                                        str14 = str14;
                                        str6 = str6;
                                    }
                                    i2 = iA;
                                    jArr4 = jArr2;
                                    str12 = str14;
                                    r5 = str6;
                                } else {
                                    eVar3 = eVar;
                                    jArr4 = jArr2;
                                    i2 = i;
                                    str12 = str14;
                                    r5 = str6;
                                }
                                if (i2 > 0) {
                                    z2 = true;
                                    if (1 == i2) {
                                        com.opos.cmn.an.f.a.b("DownloadEngineImpl", "blockNum=1,just download as normal file.");
                                        zB = b(context, aVar, eVar);
                                    } else {
                                        cVarArr = new c[i2];
                                        i4 = 0;
                                        r4 = r5;
                                        countDownLatch = new CountDownLatch(i2);
                                        while (i4 < i2) {
                                            int i12 = i4;
                                            boolean z6 = z2;
                                            r24 = r4;
                                            CountDownLatch countDownLatch6 = countDownLatch;
                                            c[] cVarArr5 = cVarArr;
                                            File file7 = fileC;
                                            cVarArr5[i12] = new c(context, aVar, eVar3.d, jArr4[i4], jArr[i4], countDownLatch6);
                                            i4 = i12 + 1;
                                            countDownLatch = countDownLatch6;
                                            cVarArr = cVarArr5;
                                            fileC = file7;
                                            r4 = r24;
                                            z2 = z6;
                                        }
                                        z3 = z2;
                                        r24 = r4;
                                        CountDownLatch countDownLatch7 = countDownLatch;
                                        cVarArr2 = cVarArr;
                                        file3 = fileC;
                                        b bVar3 = new b(file3, i2, cVarArr2);
                                        bVar3.start();
                                        while (i5 < i2) {
                                            com.opos.cmn.an.j.b.e(cVarArr2[i5]);
                                        }
                                        countDownLatch7.await();
                                        i7 = 0;
                                        while (i6 < i2) {
                                            if (cVarArr2[i6].c()) {
                                                com.opos.cmn.an.f.a.b("DownloadEngineImpl", "dlThreads[" + i6 + "] download success.");
                                                i7++;
                                            } else {
                                                com.opos.cmn.an.f.a.b("DownloadEngineImpl", "dlThreads[" + i6 + "] download fail.");
                                            }
                                        }
                                        com.opos.cmn.an.f.a.b("DownloadEngineImpl", "successCount=" + i7);
                                        bVar3.a();
                                        if (i7 == i2) {
                                            Object[] objArr7 = new Object[2];
                                            objArr7[0] = "successCount = blockNum,download success.";
                                            objArr7[z3 ? 1 : 0] = aVar;
                                            com.opos.cmn.an.f.a.b("DownloadEngineImpl", objArr7);
                                            if (com.opos.cmn.an.e.b.a.a(file)) {
                                                file2 = fileB;
                                                str10 = "DownloadEngineImpl";
                                                r5 = r24;
                                                if (a(file, file2, aVar.b, eVar3.d)) {
                                                    com.opos.cmn.an.f.a.b(str10, "target file not exists.");
                                                    zB = z3 ? 1 : 0;
                                                } else {
                                                    com.opos.cmn.an.e.b.a.e(file2);
                                                    com.opos.cmn.an.e.b.a.e(file3);
                                                }
                                                str12 = str10;
                                            } else {
                                                str11 = "DownloadEngineImpl";
                                                eVar2 = eVar3;
                                                file2 = fileB;
                                                r16 = r24;
                                                com.opos.cmn.an.f.a.b(str11, "target file exists.");
                                                file3 = file3;
                                                file4 = file;
                                                if (a(file4, aVar.b, eVar2.d)) {
                                                    com.opos.cmn.an.f.a.b(str11, "targetFile exists and valid, don't need rename!");
                                                    str9 = str11;
                                                    r15 = r16;
                                                } else {
                                                    com.opos.cmn.an.f.a.b(str11, "targetFile exists but not valid, rename it!");
                                                    com.opos.cmn.an.e.b.a.e(file4);
                                                    if (a(file4, file2, aVar.b, eVar2.d)) {
                                                        com.opos.cmn.an.f.a.b(str11, "target file not exists.");
                                                        str9 = str11;
                                                        r15 = r16;
                                                    } else {
                                                        com.opos.cmn.an.e.b.a.e(file2);
                                                        str8 = str11;
                                                        r14 = r16;
                                                        com.opos.cmn.an.e.b.a.e(file3);
                                                        str12 = str8;
                                                        r5 = r14;
                                                    }
                                                }
                                                zB = z3 ? 1 : 0;
                                                str12 = str9;
                                                r5 = r15;
                                            }
                                        } else {
                                            str7 = "DownloadEngineImpl";
                                            file3 = file3;
                                            file2 = fileB;
                                            r13 = r24;
                                            Object[] objArr8 = new Object[2];
                                            objArr8[0] = "successCount != blockNum,maybe target file has download success,try it.";
                                            objArr8[z3 ? 1 : 0] = aVar;
                                            com.opos.cmn.an.f.a.b(str7, objArr8);
                                            if (a(file, aVar.b, eVar3.d)) {
                                                Object[] objArr9 = new Object[2];
                                                objArr9[0] = "target file exists and valid,don't need rename.";
                                                objArr9[z3 ? 1 : 0] = aVar;
                                                com.opos.cmn.an.f.a.b(str7, objArr9);
                                                str9 = str7;
                                                r15 = r13;
                                                zB = z3 ? 1 : 0;
                                                str12 = str9;
                                                r5 = r15;
                                            } else {
                                                com.opos.cmn.an.e.b.a.e(file2);
                                                str8 = str7;
                                                r14 = r13;
                                                com.opos.cmn.an.e.b.a.e(file3);
                                                str12 = str8;
                                                r5 = r14;
                                            }
                                        }
                                    }
                                    if (zB) {
                                        com.opos.cmn.an.e.b.a.e(file2);
                                        com.opos.cmn.an.e.b.a.e(file3);
                                    }
                                    eVar.a();
                                    str = str12;
                                }
                                str12 = "DownloadEngineImpl";
                                r5 = "downloadLargeFile";
                                file3 = fileC;
                                file2 = fileB;
                                if (zB) {
                                    com.opos.cmn.an.e.b.a.e(file2);
                                    com.opos.cmn.an.e.b.a.e(file3);
                                }
                                eVar.a();
                                str = str12;
                            }
                        } catch (Throwable th22) {
                            th = th22;
                        }
                    } catch (Exception e15) {
                        e = e15;
                    }
                } else {
                    str = "DownloadEngineImpl";
                }
            } catch (Throwable th23) {
                th = th23;
            }
        }
        com.opos.cmn.an.f.a.b(str, "downloadLargeFile downloadRequest", aVar, "netResponse=", eVar, "result=", Boolean.valueOf(zB));
        return zB;
    }

    @Override // com.opos.mobad.l.d
    public com.opos.mobad.l.b a(Context context, com.opos.mobad.l.a aVar) {
        com.opos.mobad.l.b.a aVar2 = new com.opos.mobad.l.b.a();
        boolean zA = false;
        if (context == null || aVar == null) {
            com.opos.cmn.an.f.a.b("DownloadEngineImpl", "context or downloadRequest  is null.");
        } else {
            com.opos.cmn.func.a.a.e eVarA = com.opos.cmn.func.a.a.b.a().a(context, aVar.f7114a);
            long j = eVarA != null ? eVarA.d : 0L;
            com.opos.cmn.an.f.a.b("DownloadEngineImpl", "download contentLength=" + j);
            aVar2.a(j);
            if (a(context, aVar, j)) {
                com.opos.cmn.an.f.a.b("DownloadEngineImpl", "target file exists!don't need download again.fileInfo=" + a(aVar));
                zA = true;
            } else {
                com.opos.cmn.an.f.a.b("DownloadEngineImpl", "target not exists,start download it now.fileInfo=" + a(aVar));
                if (a(aVar.c)) {
                    String str = aVar.d + ".lk";
                    a(str);
                    e eVar = new e(str);
                    try {
                        try {
                            if (eVar.a()) {
                                if (a(context, aVar, j)) {
                                    com.opos.cmn.an.f.a.b("DownloadEngineImpl", "target file exists!don't need download again.fileInfo=" + a(aVar));
                                    zA = true;
                                } else {
                                    zA = a(context, aVar, eVarA);
                                }
                            }
                        } catch (Exception e) {
                            com.opos.cmn.an.f.a.a("DownloadEngineImpl", "", (Throwable) e);
                        }
                        eVar.b();
                        com.opos.cmn.an.e.b.a.d(str);
                    } catch (Throwable th) {
                        eVar.b();
                        com.opos.cmn.an.e.b.a.d(str);
                        throw th;
                    }
                } else {
                    zA = a(context, aVar, eVarA);
                }
            }
        }
        aVar2.a(zA);
        com.opos.mobad.l.b bVarA = aVar2.a();
        com.opos.cmn.an.f.a.b("DownloadEngineImpl", "download downloadRequest=", aVar, "downloadResponse=", bVarA);
        return bVarA;
    }
}
