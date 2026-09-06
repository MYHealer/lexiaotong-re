package com.jd.ad.sdk.jad_lu;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.PathMeasure;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_hu {
    public static final Map<String, jad_uh<jad_jt>> jad_an = new HashMap();
    public static final byte[] jad_bo = {80, 75, 3, 4};

    public class jad_an implements jad_ob<jad_jt> {
        public final /* synthetic */ String jad_an;

        public jad_an(String str) {
            this.jad_an = str;
        }

        @Override // com.jd.ad.sdk.jad_lu.jad_ob
        public void jad_an(jad_jt jad_jtVar) {
            ((HashMap) jad_hu.jad_an).remove(this.jad_an);
        }
    }

    public class jad_bo implements jad_ob<Throwable> {
        public final /* synthetic */ String jad_an;

        public jad_bo(String str) {
            this.jad_an = str;
        }

        @Override // com.jd.ad.sdk.jad_lu.jad_ob
        public void jad_an(Throwable th) {
            ((HashMap) jad_hu.jad_an).remove(this.jad_an);
        }
    }

    public class jad_cp implements Callable<jad_sf<jad_jt>> {
        public final /* synthetic */ jad_jt jad_an;

        public jad_cp(jad_jt jad_jtVar) {
            this.jad_an = jad_jtVar;
        }

        @Override // java.util.concurrent.Callable
        public jad_sf<jad_jt> call() {
            return new jad_sf<>(this.jad_an);
        }
    }

    public static jad_sf<jad_jt> jad_an(Context context, String str, String str2) {
        try {
            if (!str.endsWith(".zip") && !str.endsWith(".lottie")) {
                return jad_an(context.getAssets().open(str), str2);
            }
            return jad_an(new ZipInputStream(context.getAssets().open(str)), str2);
        } catch (IOException e) {
            return new jad_sf<>((Throwable) e);
        }
    }

    public static jad_sf<jad_jt> jad_an(ZipInputStream zipInputStream, String str) {
        try {
            return jad_bo(zipInputStream, str);
        } finally {
            com.jd.ad.sdk.jad_xg.jad_hu.jad_an(zipInputStream);
        }
    }

    public static jad_uh<jad_jt> jad_an(String str, Callable<jad_sf<jad_jt>> callable) {
        jad_jt jad_jtVar;
        if (str == null) {
            jad_jtVar = null;
        } else {
            com.jd.ad.sdk.jad_qz.jad_jt jad_jtVar2 = com.jd.ad.sdk.jad_qz.jad_jt.jad_bo;
            jad_jtVar2.getClass();
            jad_jtVar = jad_jtVar2.jad_an.get(str);
        }
        if (jad_jtVar != null) {
            return new jad_uh<>(new jad_cp(jad_jtVar), false);
        }
        if (str != null) {
            HashMap map = (HashMap) jad_an;
            if (map.containsKey(str)) {
                return (jad_uh) map.get(str);
            }
        }
        jad_uh<jad_jt> jad_uhVar = new jad_uh<>(callable, false);
        if (str != null) {
            jad_uhVar.jad_bo(new jad_an(str));
            jad_uhVar.jad_an(new jad_bo(str));
            ((HashMap) jad_an).put(str, jad_uhVar);
        }
        return jad_uhVar;
    }

    public static jad_sf<jad_jt> jad_bo(ZipInputStream zipInputStream, String str) {
        jad_na next;
        HashMap map = new HashMap();
        jad_jt jad_jtVar = null;
        while (true) {
            try {
                ZipEntry nextEntry = zipInputStream.getNextEntry();
                if (nextEntry == null) {
                    break;
                }
                String name = nextEntry.getName();
                if (name.startsWith("../") || name.contains("__MACOSX") || nextEntry.getName().equalsIgnoreCase("manifest.json")) {
                    zipInputStream.closeEntry();
                } else if (nextEntry.getName().contains(".json")) {
                    com.jd.ad.sdk.jad_hk.jad_iv jad_ivVar = new com.jd.ad.sdk.jad_hk.jad_iv(com.jd.ad.sdk.jad_hk.jad_er.jad_an(zipInputStream));
                    String[] strArr = com.jd.ad.sdk.jad_wf.jad_cp.jad_er;
                    jad_jtVar = jad_an((com.jd.ad.sdk.jad_wf.jad_cp) new com.jd.ad.sdk.jad_wf.jad_fs(jad_ivVar), (String) null, false).jad_an;
                } else if (name.contains(".png") || name.contains(".webp") || name.contains(".jpg") || name.contains(".jpeg")) {
                    String[] strArrSplit = name.split("/");
                    map.put(strArrSplit[strArrSplit.length - 1], BitmapFactory.decodeStream(zipInputStream));
                } else {
                    zipInputStream.closeEntry();
                }
            } catch (IOException e) {
                return new jad_sf<>((Throwable) e);
            }
        }
        if (jad_jtVar == null) {
            return new jad_sf<>((Throwable) new IllegalArgumentException("Unable to parse composition"));
        }
        for (Map.Entry entry : map.entrySet()) {
            String str2 = (String) entry.getKey();
            Iterator<jad_na> it = jad_jtVar.jad_dq.values().iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (!next.jad_dq.equals(str2));
            if (next != null) {
                Bitmap bitmap = (Bitmap) entry.getValue();
                int i = next.jad_an;
                int i2 = next.jad_bo;
                ThreadLocal<PathMeasure> threadLocal = com.jd.ad.sdk.jad_xg.jad_hu.jad_an;
                if (bitmap.getWidth() != i || bitmap.getHeight() != i2) {
                    Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap, i, i2, true);
                    bitmap.recycle();
                    bitmap = bitmapCreateScaledBitmap;
                }
                next.jad_er = bitmap;
            }
        }
        for (Map.Entry<String, jad_na> entry2 : jad_jtVar.jad_dq.entrySet()) {
            if (entry2.getValue().jad_er == null) {
                return new jad_sf<>((Throwable) new IllegalStateException(jad_zm.jad_an("There is no image for ").append(entry2.getValue().jad_dq).toString()));
            }
        }
        if (str != null) {
            com.jd.ad.sdk.jad_qz.jad_jt.jad_bo.jad_an(str, jad_jtVar);
        }
        return new jad_sf<>(jad_jtVar);
    }

    public static jad_sf<jad_jt> jad_an(InputStream inputStream, String str) {
        try {
            com.jd.ad.sdk.jad_hk.jad_iv jad_ivVar = new com.jd.ad.sdk.jad_hk.jad_iv(com.jd.ad.sdk.jad_hk.jad_er.jad_an(inputStream));
            String[] strArr = com.jd.ad.sdk.jad_wf.jad_cp.jad_er;
            return jad_an((com.jd.ad.sdk.jad_wf.jad_cp) new com.jd.ad.sdk.jad_wf.jad_fs(jad_ivVar), str, true);
        } finally {
            com.jd.ad.sdk.jad_xg.jad_hu.jad_an(inputStream);
        }
    }

    public static jad_sf<jad_jt> jad_an(com.jd.ad.sdk.jad_wf.jad_cp jad_cpVar, String str, boolean z) {
        try {
            jad_jt jad_jtVarJad_an = com.jd.ad.sdk.jad_ve.jad_wj.jad_an(jad_cpVar);
            if (str != null) {
                com.jd.ad.sdk.jad_qz.jad_jt.jad_bo.jad_an(str, jad_jtVarJad_an);
            }
            return new jad_sf<>(jad_jtVarJad_an);
        } catch (Exception e) {
            return new jad_sf<>((Throwable) e);
        } finally {
            if (z) {
                com.jd.ad.sdk.jad_xg.jad_hu.jad_an(jad_cpVar);
            }
        }
    }

    public static jad_sf<jad_jt> jad_an(String str, String str2) {
        com.jd.ad.sdk.jad_hk.jad_iv jad_ivVar = new com.jd.ad.sdk.jad_hk.jad_iv(com.jd.ad.sdk.jad_hk.jad_er.jad_an(new ByteArrayInputStream(str.getBytes())));
        String[] strArr = com.jd.ad.sdk.jad_wf.jad_cp.jad_er;
        return jad_an((com.jd.ad.sdk.jad_wf.jad_cp) new com.jd.ad.sdk.jad_wf.jad_fs(jad_ivVar), (String) null, true);
    }

    public static jad_sf<jad_jt> jad_an(Context context, int i, String str) {
        Boolean bool;
        try {
            com.jd.ad.sdk.jad_hk.jad_iv jad_ivVar = new com.jd.ad.sdk.jad_hk.jad_iv(com.jd.ad.sdk.jad_hk.jad_er.jad_an(context.getResources().openRawResource(i)));
            try {
                com.jd.ad.sdk.jad_hk.jad_bo jad_boVarJad_bo = jad_ivVar.jad_bo();
                byte[] bArr = jad_bo;
                int length = bArr.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        ((com.jd.ad.sdk.jad_hk.jad_iv) jad_boVarJad_bo).close();
                        bool = Boolean.TRUE;
                        break;
                    }
                    if (((com.jd.ad.sdk.jad_hk.jad_iv) jad_boVarJad_bo).jad_cp() != bArr[i2]) {
                        bool = Boolean.FALSE;
                        break;
                    }
                    i2++;
                }
            } catch (Exception unused) {
                com.jd.ad.sdk.jad_xg.jad_dq.jad_an.getClass();
                bool = Boolean.FALSE;
            }
            if (bool.booleanValue()) {
                return jad_an(new ZipInputStream(new com.jd.ad.sdk.jad_hk.jad_hu(jad_ivVar)), str);
            }
            return jad_an(new com.jd.ad.sdk.jad_hk.jad_hu(jad_ivVar), str);
        } catch (Resources.NotFoundException e) {
            return new jad_sf<>((Throwable) e);
        }
    }

    public static String jad_an(Context context, int i) {
        return jad_zm.jad_an("rawRes").append((context.getResources().getConfiguration().uiMode & 48) == 32 ? "_night_" : "_day_").append(i).toString();
    }
}
