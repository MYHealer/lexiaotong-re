package com.jd.ad.sdk.jad_uh;

import android.text.TextUtils;
import com.jd.ad.sdk.fdt.thread.WorkExecutor;
import com.jd.ad.sdk.fdt.utils.ANEProxy;
import com.jd.ad.sdk.jad_qd.jad_jw;
import com.jd.ad.sdk.jad_xk.jad_fs;
import com.jd.ad.sdk.logger.Logger;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: compiled from: DataCache.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class jad_an {
    public final Map<String, Object> jad_an = new HashMap();
    public final ReadWriteLock jad_bo = new ReentrantReadWriteLock();

    /* JADX INFO: renamed from: com.jd.ad.sdk.jad_uh.jad_an$jad_an, reason: collision with other inner class name */
    /* JADX INFO: compiled from: DataCache.java */
    public class RunnableC0585jad_an implements Runnable {
        public final /* synthetic */ String jad_an;
        public final /* synthetic */ Object jad_bo;

        public RunnableC0585jad_an(jad_an jad_anVar, String str, Object obj) {
            this.jad_an = str;
            this.jad_bo = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            jad_cp.jad_an((jad_dq) null, this.jad_an, this.jad_bo);
        }
    }

    /* JADX INFO: compiled from: DataCache.java */
    public static final class jad_bo {
        public static final jad_an jad_an = new jad_an();
    }

    public boolean jad_an(String str, boolean z) {
        try {
            if (z) {
                return this.jad_an.containsKey(str);
            }
            return jad_jw.jad_dq(com.jd.ad.sdk.jad_fq.jad_cp.jad_an()) ? com.jd.ad.sdk.jad_uh.jad_bo.jad_an.jad_an.jad_an(str, z) : jad_cp.jad_an(str);
        } catch (Exception unused) {
            return false;
        }
    }

    public synchronized void jad_bo(String str, Object obj) {
        try {
            if (this.jad_an.containsKey(str)) {
                Object obj2 = this.jad_an.get(str);
                if (obj2 != null && !obj2.equals(obj)) {
                    this.jad_an.put(str, obj);
                }
            } else {
                this.jad_an.put(str, obj);
            }
        } catch (Exception e) {
            Logger.w("Exception while mem: ", e.getMessage());
        }
    }

    public int jad_cp(String str) {
        Object objJad_bo = jad_bo.jad_an.jad_bo(str);
        if (objJad_bo == null || !(objJad_bo instanceof Integer)) {
            return -1;
        }
        return ((Integer) objJad_bo).intValue();
    }

    public String jad_dq(String str) {
        Object objJad_bo = jad_bo.jad_an.jad_bo(str);
        return (objJad_bo == null || !(objJad_bo instanceof String)) ? "" : (String) objJad_bo;
    }

    public void jad_an(String str, Object obj) {
        this.jad_bo.writeLock().lock();
        try {
            if (jad_jw.jad_dq(com.jd.ad.sdk.jad_fq.jad_cp.jad_an())) {
                com.jd.ad.sdk.jad_uh.jad_bo.jad_an.jad_an.jad_an(str, obj);
            } else {
                WorkExecutor.execute(new RunnableC0585jad_an(this, str, obj));
            }
        } catch (Exception e) {
            com.jd.ad.sdk.jad_wj.jad_an jad_anVar = com.jd.ad.sdk.jad_wj.jad_an.CACHE_SAVE_CACHE_OTHER_ERROR;
            jad_fs.jad_an("", jad_anVar.jad_an, jad_anVar.jad_an(e.getMessage()));
        } finally {
            this.jad_bo.writeLock().unlock();
        }
    }

    public Object jad_bo(String str) {
        Object obj;
        this.jad_bo.readLock().lock();
        try {
            obj = this.jad_an.containsKey(str) ? this.jad_an.get(str) : null;
        } catch (Exception unused) {
        } catch (Throwable th) {
            this.jad_bo.readLock().unlock();
            throw th;
        }
        this.jad_bo.readLock().unlock();
        return obj;
    }

    public <T> T jad_an(String str, Class<T> cls) {
        Object objJad_an;
        this.jad_bo.readLock().lock();
        T t = null;
        try {
            if (jad_jw.jad_dq(com.jd.ad.sdk.jad_fq.jad_cp.jad_an())) {
                objJad_an = com.jd.ad.sdk.jad_uh.jad_bo.jad_an.jad_an.jad_an(str, (Class<Object>) cls);
            } else if (this.jad_an.containsKey(str)) {
                objJad_an = jad_an(cls, this.jad_an.get(str));
            } else {
                objJad_an = jad_an(cls, jad_cp.jad_an((jad_dq) null, str, (Class<?>) cls));
            }
            t = (T) objJad_an;
        } catch (Exception e) {
            com.jd.ad.sdk.jad_wj.jad_an jad_anVar = com.jd.ad.sdk.jad_wj.jad_an.CACHE_READ_CACHE_ERROR;
            jad_fs.jad_an("", jad_anVar.jad_an, jad_anVar.jad_an(e.getMessage()));
        } finally {
            this.jad_bo.readLock().unlock();
        }
        return t;
    }

    public final <T> T jad_an(Class<T> cls, Object obj) {
        if (obj == null) {
            return null;
        }
        try {
            String strValueOf = String.valueOf(obj);
            if (TextUtils.isEmpty(strValueOf)) {
                return null;
            }
            if (cls == String.class) {
                obj = (T) strValueOf;
            } else if (cls == Integer.TYPE) {
                obj = (T) Integer.valueOf(strValueOf);
            } else if (cls == Long.TYPE) {
                obj = (T) Long.valueOf(strValueOf);
            } else if (cls == Float.TYPE) {
                obj = (T) Float.valueOf(strValueOf);
            } else if (cls == Boolean.TYPE) {
                obj = (T) Boolean.valueOf(strValueOf);
            } else if (cls == Double.TYPE) {
                obj = (T) Double.valueOf(strValueOf);
            }
            return (T) obj;
        } catch (Exception e) {
            com.jd.ad.sdk.jad_wj.jad_an jad_anVar = com.jd.ad.sdk.jad_wj.jad_an.CACHE_READ_CACHE_ERROR;
            jad_fs.jad_an("", jad_anVar.jad_an, jad_anVar.jad_an(e.getMessage()));
            return null;
        }
    }

    public void jad_an(String str, String str2) {
        byte[] bytes;
        try {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                String strJa = ANEProxy.ja(str2);
                if (!TextUtils.isEmpty(strJa) && (bytes = strJa.getBytes(StandardCharsets.UTF_8)) != null && bytes.length > 0) {
                    jad_bo.jad_an.jad_an(str, (Object) new String(bytes));
                }
            }
        } catch (Exception e) {
            Logger.w(com.jd.ad.sdk.jad_bo.jad_bo.jad_an("Exception while s2ce: ").append(e.getMessage()).toString(), new Object[0]);
        }
    }

    public String jad_an(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            String str2 = (String) jad_bo.jad_an.jad_an(str, String.class);
            if (TextUtils.isEmpty(str2)) {
                return "";
            }
            String strJb = ANEProxy.jb(str2);
            return TextUtils.isEmpty(strJb) ? "" : strJb;
        } catch (Exception e) {
            Logger.w(com.jd.ad.sdk.jad_bo.jad_bo.jad_an("Exception while gfcd: ").append(e.getMessage()).toString(), new Object[0]);
            return "";
        }
    }
}
