package com.jd.ad.sdk.jad_oz;

import android.util.Log;
import com.jd.ad.sdk.logger.Logger;
import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_er implements jad_an {
    public final File jad_bo;
    public final long jad_cp;
    public com.jd.ad.sdk.jad_hs.jad_an jad_er;
    public final jad_cp jad_dq = new jad_cp();
    public final jad_jw jad_an = new jad_jw();

    @Deprecated
    public jad_er(File file, long j) {
        this.jad_bo = file;
        this.jad_cp = j;
    }

    public final synchronized com.jd.ad.sdk.jad_hs.jad_an jad_an() {
        if (this.jad_er == null) {
            File file = this.jad_bo;
            long j = this.jad_cp;
            if (j <= 0) {
                throw new IllegalArgumentException("maxSize <= 0");
            }
            File file2 = new File(file, "journal.bkp");
            if (file2.exists()) {
                File file3 = new File(file, "journal");
                if (file3.exists()) {
                    file2.delete();
                } else {
                    com.jd.ad.sdk.jad_hs.jad_an.jad_an(file2, file3, false);
                }
            }
            com.jd.ad.sdk.jad_hs.jad_an jad_anVar = new com.jd.ad.sdk.jad_hs.jad_an(file, 1, 1, j);
            if (jad_anVar.jad_bo.exists()) {
                try {
                    jad_anVar.jad_er();
                    jad_anVar.jad_dq();
                } catch (IOException e) {
                    System.out.println("DiskLruCache " + file + " is corrupt: " + e.getMessage() + ", removing");
                    jad_anVar.close();
                    com.jd.ad.sdk.jad_hs.jad_cp.jad_an(jad_anVar.jad_an);
                    file.mkdirs();
                    jad_anVar = new com.jd.ad.sdk.jad_hs.jad_an(file, 1, 1, j);
                    jad_anVar.jad_fs();
                }
            } else {
                file.mkdirs();
                jad_anVar = new com.jd.ad.sdk.jad_hs.jad_an(file, 1, 1, j);
                jad_anVar.jad_fs();
            }
            this.jad_er = jad_anVar;
        }
        return this.jad_er;
    }

    @Override // com.jd.ad.sdk.jad_oz.jad_an
    public File jad_an(com.jd.ad.sdk.jad_ju.jad_hu jad_huVar) {
        String strJad_an = this.jad_an.jad_an(jad_huVar);
        if (Log.isLoggable("DiskLruCacheWrapper", 2)) {
            Logger.v("DiskLruCacheWrapper", "Get: Obtained: " + strJad_an + " for for Key: " + jad_huVar);
        }
        try {
            com.jd.ad.sdk.jad_hs.jad_an.jad_er jad_erVarJad_bo = jad_an().jad_bo(strJad_an);
            if (jad_erVarJad_bo != null) {
                return jad_erVarJad_bo.jad_an(0);
            }
        } catch (IOException e) {
            if (Log.isLoggable("DiskLruCacheWrapper", 5)) {
                Logger.w("DiskLruCacheWrapper", "Unable to get from disk cache", e);
            }
        }
        return null;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.jd.ad.sdk.jad_oz.jad_an
    public void jad_an(com.jd.ad.sdk.jad_ju.jad_hu jad_huVar, jad_an.jad_bo jad_boVar) {
        jad_cp.jad_an jad_anVarPoll;
        String strJad_an = this.jad_an.jad_an(jad_huVar);
        jad_cp jad_cpVar = this.jad_dq;
        synchronized (jad_cpVar) {
            jad_anVarPoll = jad_cpVar.jad_an.get(strJad_an);
            if (jad_anVarPoll == null) {
                jad_cp.jad_bo jad_boVar2 = jad_cpVar.jad_bo;
                synchronized (jad_boVar2.jad_an) {
                    jad_anVarPoll = jad_boVar2.jad_an.poll();
                }
                if (jad_anVarPoll == null) {
                    jad_anVarPoll = new jad_cp.jad_an();
                }
                jad_cpVar.jad_an.put(strJad_an, jad_anVarPoll);
            }
            jad_anVarPoll.jad_bo++;
        }
        jad_anVarPoll.jad_an.lock();
        try {
            if (Log.isLoggable("DiskLruCacheWrapper", 2)) {
                Logger.v("DiskLruCacheWrapper", "Put: Obtained: " + strJad_an + " for for Key: " + jad_huVar);
            }
            try {
                com.jd.ad.sdk.jad_hs.jad_an jad_anVarJad_an = jad_an();
                if (jad_anVarJad_an.jad_bo(strJad_an) != null) {
                    this.jad_dq.jad_an(strJad_an);
                    return;
                }
                com.jd.ad.sdk.jad_hs.jad_an.jad_cp jad_cpVarJad_an = jad_anVarJad_an.jad_an(strJad_an);
                if (jad_cpVarJad_an == null) {
                    throw new IllegalStateException("Had two simultaneous puts for: " + strJad_an);
                }
                try {
                    com.jd.ad.sdk.jad_mx.jad_er jad_erVar = (com.jd.ad.sdk.jad_mx.jad_er) jad_boVar;
                    if (jad_erVar.jad_an.jad_an(jad_erVar.jad_bo, jad_cpVarJad_an.jad_an(0), jad_erVar.jad_cp)) {
                        com.jd.ad.sdk.jad_hs.jad_an.jad_an(com.jd.ad.sdk.jad_hs.jad_an.this, jad_cpVarJad_an, true);
                        jad_cpVarJad_an.jad_cp = true;
                    }
                    if (!jad_cpVarJad_an.jad_cp) {
                        try {
                            jad_cpVarJad_an.jad_an();
                        } catch (IOException unused) {
                        }
                    }
                    this.jad_dq.jad_an(strJad_an);
                } catch (Throwable th) {
                    if (!jad_cpVarJad_an.jad_cp) {
                        try {
                            jad_cpVarJad_an.jad_an();
                        } catch (IOException unused2) {
                        }
                    }
                    throw th;
                }
            } catch (IOException e) {
                if (Log.isLoggable("DiskLruCacheWrapper", 5)) {
                    Logger.w("DiskLruCacheWrapper", "Unable to put to disk cache", e);
                }
            }
        } catch (Throwable th2) {
            this.jad_dq.jad_an(strJad_an);
            throw th2;
        }
    }
}
