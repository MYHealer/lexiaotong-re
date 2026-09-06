package com.jd.ad.sdk.jad_fq;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_er {
    /* JADX WARN: Code duplicated, block: B:77:0x0095 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:86:0x008b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:99:? A[SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v9, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v14, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v19, types: [java.io.IOException] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v23 */
    /* JADX WARN: Type inference failed for: r1v25 */
    /* JADX WARN: Type inference failed for: r1v27, types: [java.lang.String[]] */
    /* JADX WARN: Type inference failed for: r1v28, types: [java.io.IOException] */
    /* JADX WARN: Type inference failed for: r1v30 */
    /* JADX WARN: Type inference failed for: r1v31 */
    /* JADX WARN: Type inference failed for: r1v32 */
    /* JADX WARN: Type inference failed for: r1v33 */
    /* JADX WARN: Type inference failed for: r1v34 */
    /* JADX WARN: Type inference failed for: r1v35 */
    /* JADX WARN: Type inference failed for: r1v36 */
    /* JADX WARN: Type inference failed for: r1v37 */
    /* JADX WARN: Type inference failed for: r1v38 */
    /* JADX WARN: Type inference failed for: r1v39 */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r1v40 */
    /* JADX WARN: Type inference failed for: r1v41 */
    /* JADX WARN: Type inference failed for: r1v42 */
    /* JADX WARN: Type inference failed for: r1v43 */
    /* JADX WARN: Type inference failed for: r1v44 */
    /* JADX WARN: Type inference failed for: r1v45 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v14, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    public static String jad_an() throws Throwable {
        ?? bufferedReader;
        FileReader fileReader;
        ?? r0 = "";
        ?? e = 0;
         = 0;
         = 0;
         = 0;
        ?? r1 = 0;
        ?? r2 = 0;
        ?? r3 = 0;
        ?? r4 = 0;
        FileReader fileReader2 = null;
        try {
            try {
                try {
                    fileReader = new FileReader("/proc/meminfo");
                    try {
                        bufferedReader = new BufferedReader(fileReader, 4096);
                        try {
                            e = bufferedReader.readLine().split("\\s+");
                            r0 = e[1];
                            try {
                                bufferedReader.close();
                            } catch (IOException e2) {
                                e = e2;
                                e.printStackTrace();
                            }
                        } catch (FileNotFoundException e3) {
                            e = e3;
                            r2 = bufferedReader;
                            e.printStackTrace();
                            e = r2;
                            if (r2 != 0) {
                                try {
                                    r2.close();
                                    e = r2;
                                } catch (IOException e4) {
                                    e4.printStackTrace();
                                    e = e4;
                                }
                            }
                            if (fileReader != null) {
                            }
                            return r0;
                        } catch (IOException e5) {
                            e = e5;
                            r3 = bufferedReader;
                            e.printStackTrace();
                            e = r3;
                            if (r3 != 0) {
                                try {
                                    r3.close();
                                    e = r3;
                                } catch (IOException e6) {
                                    e6.printStackTrace();
                                    e = e6;
                                }
                            }
                            if (fileReader != null) {
                            }
                            return r0;
                        } catch (Exception e7) {
                            e = e7;
                            r4 = bufferedReader;
                            e.printStackTrace();
                            e = r4;
                            if (r4 != 0) {
                                try {
                                    r4.close();
                                    e = r4;
                                } catch (IOException e8) {
                                    e8.printStackTrace();
                                    e = e8;
                                }
                            }
                            if (fileReader != null) {
                            }
                            return r0;
                        } catch (Throwable th) {
                            th = th;
                            r1 = bufferedReader;
                            if (r1 != 0) {
                                try {
                                    r1.close();
                                } catch (IOException e9) {
                                    e9.printStackTrace();
                                }
                            }
                            if (fileReader != null) {
                                throw th;
                            }
                            try {
                                fileReader.close();
                                throw th;
                            } catch (IOException e10) {
                                e10.printStackTrace();
                                throw th;
                            }
                        }
                    } catch (FileNotFoundException e11) {
                        e = e11;
                    } catch (IOException e12) {
                        e = e12;
                    } catch (Exception e13) {
                        e = e13;
                    } catch (Throwable th2) {
                        th = th2;
                        if (r1 != 0) {
                            r1.close();
                        }
                        if (fileReader != null) {
                            throw th;
                        }
                        fileReader.close();
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    bufferedReader = e;
                    fileReader2 = fileReader;
                    fileReader = fileReader2;
                    r1 = bufferedReader;
                    if (r1 != 0) {
                        r1.close();
                    }
                    if (fileReader != null) {
                        throw th;
                    }
                    fileReader.close();
                    throw th;
                }
            } catch (FileNotFoundException e14) {
                e = e14;
                fileReader = null;
            } catch (IOException e15) {
                e = e15;
                fileReader = null;
            } catch (Exception e16) {
                e = e16;
                fileReader = null;
            } catch (Throwable th4) {
                th = th4;
                bufferedReader = 0;
                fileReader = fileReader2;
                r1 = bufferedReader;
                if (r1 != 0) {
                    r1.close();
                }
                if (fileReader != null) {
                    throw th;
                }
                fileReader.close();
                throw th;
            }
            fileReader.close();
        } catch (IOException e17) {
            e = e17;
            e.printStackTrace();
        }
        return r0;
    }
}
