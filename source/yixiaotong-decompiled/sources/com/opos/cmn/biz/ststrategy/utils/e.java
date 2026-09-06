package com.opos.cmn.biz.ststrategy.utils;

import android.content.Context;
import com.huawei.hms.ads.ez;
import com.opos.cmn.biz.ststrategy.entity.STConfigEntity;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f6029a = "e";
    private static final ReentrantReadWriteLock b = new ReentrantReadWriteLock();
    private static final ReentrantReadWriteLock c = new ReentrantReadWriteLock();
    private static STConfigEntity d = null;

    public static int a(Context context, JSONObject jSONObject) throws JSONException {
        int i = 0;
        if (context != null && jSONObject != null) {
            try {
                if (jSONObject.has("data") && !jSONObject.isNull("data")) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject("data");
                    if (jSONObject2.has("currTime") && !jSONObject2.isNull("currTime")) {
                        i = jSONObject2.getInt("currTime");
                    }
                }
            } catch (JSONException e) {
                com.opos.cmn.an.f.a.c(f6029a, "", e);
            }
        }
        com.opos.cmn.an.f.a.b(f6029a, "currTime=" + i);
        return i;
    }

    public static STConfigEntity a() {
        try {
            b.readLock().lock();
            return d;
        } finally {
            b.readLock().unlock();
        }
    }

    public static synchronized STConfigEntity a(Context context) {
        STConfigEntity sTConfigEntityA;
        if (context != null) {
            boolean z = a() == null;
            String str = f6029a;
            com.opos.cmn.an.f.a.b(str, "get stConfig Entity，is read from file=" + z);
            if (z) {
                STConfigEntity sTConfigEntityA2 = g.a(context);
                if (a() != null || sTConfigEntityA2 == null) {
                    com.opos.cmn.an.f.a.b(str, "getSTConfigEntity != null || tempSTConfigEntity == null");
                } else {
                    a(sTConfigEntityA2);
                }
            }
            sTConfigEntityA = a();
        } else {
            sTConfigEntityA = null;
        }
        return sTConfigEntityA;
    }

    /* JADX WARN: Code duplicated, block: B:60:0x0133  */
    public static JSONObject a(Context context, com.opos.cmn.func.a.a.e eVar) {
        JSONObject jSONObject;
        InputStream inputStream;
        byte[] bArrA;
        String str;
        if (context == null || eVar == null || (inputStream = eVar.c) == null || (bArrA = a(inputStream)) == null || bArrA.length <= 0) {
            jSONObject = null;
        } else {
            try {
                str = "";
                try {
                    JSONObject jSONObject2 = new JSONObject(new String(bArrA, 0, bArrA.length, "UTF-8"));
                    if (!jSONObject2.has("code") || jSONObject2.isNull("code")) {
                        jSONObject = null;
                    } else {
                        int i = jSONObject2.getInt("code");
                        if (i == 0) {
                            try {
                                if (jSONObject2.has("data") && !jSONObject2.isNull("data")) {
                                    JSONObject jSONObject3 = jSONObject2.getJSONObject("data");
                                    if (jSONObject3.has("strategy") && !jSONObject3.isNull("strategy")) {
                                        JSONObject jSONObject4 = jSONObject3.getJSONObject("strategy");
                                        if (jSONObject4.has("nxLimit") && !jSONObject4.isNull("nxLimit")) {
                                            long j = jSONObject4.getLong("nxLimit");
                                            com.opos.cmn.an.f.a.b(f6029a, "set ntLimit=" + j);
                                            d.a(context, j);
                                        }
                                        if (jSONObject4.has("dtLimit") && !jSONObject4.isNull("dtLimit")) {
                                            int i2 = jSONObject4.getInt("dtLimit");
                                            com.opos.cmn.an.f.a.b(f6029a, "set dtLimit=" + i2);
                                            d.a(context, i2);
                                        }
                                        if (jSONObject4.has("blackListLimit") && !jSONObject4.isNull("blackListLimit")) {
                                            int i3 = jSONObject4.getInt("blackListLimit");
                                            com.opos.cmn.an.f.a.b(f6029a, "set blaLimit=" + i3);
                                            d.b(context, i3);
                                        }
                                    }
                                }
                                d.a(context, com.opos.cmn.biz.a.d.a(context));
                            } catch (Exception e) {
                                e = e;
                                jSONObject = jSONObject2;
                                com.opos.cmn.an.f.a.c(f6029a, str, e);
                            }
                        } else if (-3 != i) {
                            String string = jSONObject2.getString("msg");
                            String str2 = f6029a;
                            StringBuilder sbAppend = new StringBuilder("netResponseToJsonObject code=").append(i).append(",msg=");
                            if (string == null) {
                                string = str;
                            }
                            com.opos.cmn.an.f.a.b(str2, sbAppend.append(string).append(",json=").append(jSONObject2.toString()).toString());
                            jSONObject = null;
                        }
                        jSONObject = jSONObject2;
                    }
                } catch (Exception e2) {
                    e = e2;
                    jSONObject = null;
                    com.opos.cmn.an.f.a.c(f6029a, str, e);
                    com.opos.cmn.an.f.a.a(f6029a, "netResponseToJsonObject result:" + jSONObject);
                    return jSONObject;
                }
            } catch (Exception e3) {
                e = e3;
                str = "";
            }
        }
        com.opos.cmn.an.f.a.a(f6029a, "netResponseToJsonObject result:" + jSONObject);
        return jSONObject;
    }

    private static void a(STConfigEntity sTConfigEntity) {
        try {
            b.writeLock().lock();
            d = sTConfigEntity;
        } finally {
            b.writeLock().unlock();
        }
    }

    private static boolean a(Context context, byte[] bArr) {
        boolean z = false;
        if (context != null && bArr != null && bArr.length > 0) {
            FileOutputStream fileOutputStreamOpenFileOutput = null;
            try {
                try {
                    c.writeLock().lock();
                    fileOutputStreamOpenFileOutput = context.openFileOutput(d(context), 0);
                    if (fileOutputStreamOpenFileOutput != null) {
                        fileOutputStreamOpenFileOutput.write(bArr, 0, bArr.length);
                        fileOutputStreamOpenFileOutput.flush();
                        com.opos.cmn.an.f.a.b(f6029a, "fileOutputStream flush!!!");
                        z = true;
                    }
                    if (fileOutputStreamOpenFileOutput != null) {
                        try {
                        } catch (IOException e) {
                            e = e;
                            com.opos.cmn.an.f.a.c(f6029a, "", e);
                        }
                    }
                } finally {
                    if (fileOutputStreamOpenFileOutput != null) {
                        try {
                            fileOutputStreamOpenFileOutput.close();
                        } catch (IOException e2) {
                            com.opos.cmn.an.f.a.c(f6029a, "", e2);
                        }
                    }
                    c.writeLock().unlock();
                }
            } catch (FileNotFoundException e3) {
                com.opos.cmn.an.f.a.c(f6029a, "", e3);
                if (fileOutputStreamOpenFileOutput != null) {
                    try {
                    } catch (IOException e4) {
                        e = e4;
                        com.opos.cmn.an.f.a.c(f6029a, "", e);
                    }
                }
            } catch (IOException e5) {
                com.opos.cmn.an.f.a.c(f6029a, "", e5);
                if (fileOutputStreamOpenFileOutput != null) {
                    try {
                    } catch (IOException e6) {
                        e = e6;
                        com.opos.cmn.an.f.a.c(f6029a, "", e);
                    }
                }
            }
        }
        return z;
    }

    private static byte[] a(InputStream inputStream) {
        if (inputStream == null) {
            return null;
        }
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                int i = inputStream.read(bArr);
                if (-1 == i) {
                    return byteArrayOutputStream.toByteArray();
                }
                byteArrayOutputStream.write(bArr, 0, i);
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c(f6029a, "", e);
            return null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0071 A[Catch: all -> 0x006d, Exception -> 0x006f, TRY_LEAVE, TryCatch #0 {Exception -> 0x006f, blocks: (B:8:0x0029, B:10:0x002f, B:12:0x0049, B:14:0x004c, B:19:0x0071), top: B:51:0x0029, outer: #5 }] */
    /* JADX WARN: Code duplicated, block: B:60:0x0078 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public static JSONObject b(Context context) {
        IOException e;
        String str;
        JSONObject jSONObject = null;
        try {
            if (context != null) {
                try {
                    c.readLock().lock();
                    if (c(context)) {
                        String str2 = f6029a;
                        com.opos.cmn.an.f.a.b(str2, "st config file exists.");
                        FileInputStream fileInputStreamOpenFileInput = context.openFileInput(d(context));
                        if (fileInputStreamOpenFileInput != null) {
                            try {
                                try {
                                    if (fileInputStreamOpenFileInput.available() > 0) {
                                        com.opos.cmn.an.f.a.b(str2, "fileInputStream=" + fileInputStreamOpenFileInput.available());
                                        byte[] bArrA = a(fileInputStreamOpenFileInput);
                                        if (bArrA != null && bArrA.length > 0) {
                                            com.opos.cmn.an.f.a.b(str2, "bytes=" + bArrA.length);
                                            jSONObject = new JSONObject(new String(bArrA, 0, bArrA.length, "UTF-8"));
                                        }
                                    } else {
                                        com.opos.cmn.an.f.a.b(str2, "fileInputStream=null.");
                                    }
                                    if (fileInputStreamOpenFileInput != null) {
                                        try {
                                            fileInputStreamOpenFileInput.close();
                                        } catch (IOException e2) {
                                            e = e2;
                                            str = f6029a;
                                            com.opos.cmn.an.f.a.c(str, "", e);
                                        }
                                    }
                                } catch (Exception e3) {
                                    com.opos.cmn.an.f.a.c(f6029a, "", e3);
                                    if (fileInputStreamOpenFileInput != null) {
                                        try {
                                            fileInputStreamOpenFileInput.close();
                                        } catch (IOException e4) {
                                            e = e4;
                                            str = f6029a;
                                            com.opos.cmn.an.f.a.c(str, "", e);
                                        }
                                    }
                                }
                            } catch (Throwable th) {
                                if (fileInputStreamOpenFileInput != null) {
                                    try {
                                        fileInputStreamOpenFileInput.close();
                                    } catch (IOException e5) {
                                        com.opos.cmn.an.f.a.c(f6029a, "", e5);
                                    }
                                }
                                throw th;
                            }
                        } else {
                            com.opos.cmn.an.f.a.b(str2, "fileInputStream=null.");
                            if (fileInputStreamOpenFileInput != null) {
                                fileInputStreamOpenFileInput.close();
                            }
                        }
                    } else {
                        com.opos.cmn.an.f.a.a(f6029a, "st config file not exists!!!");
                    }
                } catch (FileNotFoundException e6) {
                    com.opos.cmn.an.f.a.c(f6029a, "", e6);
                }
                c.readLock().unlock();
            }
            com.opos.cmn.an.f.a.b(f6029a, "get local STConfig json=" + jSONObject);
            return jSONObject;
        } catch (Throwable th2) {
            c.readLock().unlock();
            throw th2;
        }
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0057 A[Catch: all -> 0x0073, TryCatch #0 {, blocks: (B:4:0x0005, B:7:0x0011, B:9:0x0017, B:11:0x001d, B:12:0x0020, B:13:0x0025, B:15:0x0030, B:17:0x0036, B:19:0x0040, B:21:0x004b, B:23:0x0051, B:25:0x0057, B:27:0x005d, B:28:0x0061), top: B:34:0x0005 }] */
    /* JADX WARN: Code duplicated, block: B:27:0x005d A[Catch: all -> 0x0073, TryCatch #0 {, blocks: (B:4:0x0005, B:7:0x0011, B:9:0x0017, B:11:0x001d, B:12:0x0020, B:13:0x0025, B:15:0x0030, B:17:0x0036, B:19:0x0040, B:21:0x004b, B:23:0x0051, B:25:0x0057, B:27:0x005d, B:28:0x0061), top: B:34:0x0005 }] */
    public static synchronized boolean b(Context context, JSONObject jSONObject) {
        boolean zC;
        STConfigEntity sTConfigEntityA;
        String str = f6029a;
        com.opos.cmn.an.f.a.b(str, "saveOrMergeSTConfig begin");
        zC = false;
        if (context != null && jSONObject != null) {
            if (c(context)) {
                com.opos.cmn.an.f.a.b(str, "onlineJsonArray getMetaListArray");
                JSONArray jSONArrayA = c.a(context, jSONObject);
                if (jSONArrayA != null && jSONArrayA.length() > 0) {
                    HashSet<String> hashSetB = c.b(context, jSONObject);
                    JSONObject jSONObjectB = b(context);
                    if (jSONObjectB != null) {
                        com.opos.cmn.an.f.a.b(str, "localJsonArray getMetaListArray");
                        JSONArray jSONArrayA2 = c.a(context, jSONObjectB);
                        if (jSONArrayA2 == null || jSONArrayA2.length() <= 0 || c.a(jSONArrayA2, jSONArrayA, hashSetB)) {
                            sTConfigEntityA = g.a(jSONObject);
                            if (sTConfigEntityA != null) {
                                a(sTConfigEntityA);
                                zC = c(context, jSONObject);
                            }
                        }
                    } else {
                        sTConfigEntityA = g.a(jSONObject);
                        if (sTConfigEntityA != null) {
                            a(sTConfigEntityA);
                            zC = c(context, jSONObject);
                        }
                    }
                }
            } else {
                STConfigEntity sTConfigEntityA2 = g.a(jSONObject);
                if (sTConfigEntityA2 != null) {
                    a(sTConfigEntityA2);
                    zC = c(context, jSONObject);
                }
            }
        }
        com.opos.cmn.an.f.a.b(str, "saveOrMergeSTConfig end result:" + zC);
        return zC;
    }

    public static boolean c(Context context) {
        if (context != null) {
            try {
                return new File(context.getFilesDir(), d(context)).exists();
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c(f6029a, "", e);
            }
        }
        return false;
    }

    private static boolean c(Context context, JSONObject jSONObject) {
        byte[] bArrD;
        boolean zA = (context == null || jSONObject == null || (bArrD = d(context, jSONObject)) == null || bArrD.length <= 0) ? false : a(context, bArrD);
        com.opos.cmn.an.f.a.b(f6029a, "savejsonObjectSTConfig to file result: " + zA);
        return zA;
    }

    public static String d(Context context) {
        com.opos.cmn.an.f.a.b(f6029a, "getSTConfigFileName=acs_st_config_merge.ini");
        return "acs_st_config_merge.ini";
    }

    private static byte[] d(Context context, JSONObject jSONObject) {
        byte[] bytes;
        byte[] bArr = null;
        if (context != null && jSONObject != null) {
            try {
                String string = jSONObject.toString();
                if (string != null) {
                    try {
                        bytes = string.getBytes("UTF-8");
                    } catch (Exception unused) {
                        bytes = string.getBytes();
                    }
                    bArr = bytes;
                }
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c(f6029a, "", e);
            }
        }
        com.opos.cmn.an.f.a.b(f6029a, "getJsonObjectBytes bytes is null ?".concat(bArr == null ? ez.Code : ez.V));
        return bArr;
    }
}
