package com.jd.ad.sdk.jad_gr;

import android.content.ComponentCallbacks2;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.util.Log;
import com.bumptech.glide.Registry;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.huawei.openalliance.ad.constant.ba;
import com.jd.ad.sdk.jad_mx.jad_mz;
import com.jd.ad.sdk.jad_qb.jad_sf;
import com.jd.ad.sdk.jad_qb.jad_tg;
import com.jd.ad.sdk.jad_qb.jad_vi;
import com.jd.ad.sdk.jad_te.jad_re;
import com.jd.ad.sdk.jad_te.jad_uh;
import com.jd.ad.sdk.jad_te.jad_wj;
import com.jd.ad.sdk.jad_te.jad_xk;
import com.jd.ad.sdk.jad_zk.jad_pc;
import com.jd.ad.sdk.logger.Logger;
import com.stub.StubApp;
import java.io.File;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_cp implements ComponentCallbacks2 {
    public static volatile jad_cp jad_iv;
    public static volatile boolean jad_jw;
    public final com.jd.ad.sdk.jad_ny.jad_er jad_an;
    public final com.jd.ad.sdk.jad_oz.jad_hu jad_bo;
    public final jad_er jad_cp;
    public final jad_hu jad_dq;
    public final com.jd.ad.sdk.jad_ny.jad_bo jad_er;
    public final jad_pc jad_fs;
    public final List<jad_jw> jad_hu = new ArrayList();
    public final com.jd.ad.sdk.jad_zk.jad_dq jad_jt;

    public interface jad_an {
    }

    public jad_cp(Context context, jad_mz jad_mzVar, com.jd.ad.sdk.jad_oz.jad_hu jad_huVar, com.jd.ad.sdk.jad_ny.jad_er jad_erVar, com.jd.ad.sdk.jad_ny.jad_bo jad_boVar, jad_pc jad_pcVar, com.jd.ad.sdk.jad_zk.jad_dq jad_dqVar, int i, jad_an jad_anVar, Map<Class<?>, jad_kx<?, ?>> map, List<com.jd.ad.sdk.jad_en.jad_jt<Object>> list, jad_fs jad_fsVar) {
        com.jd.ad.sdk.jad_ju.jad_ly jad_fsVar2;
        com.jd.ad.sdk.jad_ju.jad_ly jad_uhVar;
        jad_hu jad_huVar2;
        this.jad_an = jad_erVar;
        this.jad_er = jad_boVar;
        this.jad_bo = jad_huVar;
        this.jad_fs = jad_pcVar;
        this.jad_jt = jad_dqVar;
        Resources resources = context.getResources();
        jad_hu jad_huVar3 = new jad_hu();
        this.jad_dq = jad_huVar3;
        jad_huVar3.jad_an((com.jd.ad.sdk.jad_ju.jad_fs) new com.jd.ad.sdk.jad_te.jad_hu());
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 27) {
            jad_huVar3.jad_an((com.jd.ad.sdk.jad_ju.jad_fs) new com.jd.ad.sdk.jad_te.jad_mz());
        }
        List<com.jd.ad.sdk.jad_ju.jad_fs> listJad_an = jad_huVar3.jad_an();
        com.jd.ad.sdk.jad_xi.jad_an jad_anVar2 = new com.jd.ad.sdk.jad_xi.jad_an(context, listJad_an, jad_erVar, jad_boVar);
        com.jd.ad.sdk.jad_ju.jad_ly<ParcelFileDescriptor, Bitmap> jad_lyVarJad_cp = jad_xk.jad_cp(jad_erVar);
        com.jd.ad.sdk.jad_te.jad_jw jad_jwVar = new com.jd.ad.sdk.jad_te.jad_jw(jad_huVar3.jad_an(), resources.getDisplayMetrics(), jad_erVar, jad_boVar);
        if (i2 < 28 || !jad_fsVar.jad_an(jad_dq.jad_cp.class)) {
            jad_fsVar2 = new com.jd.ad.sdk.jad_te.jad_fs(jad_jwVar);
            jad_uhVar = new jad_uh(jad_jwVar, jad_boVar);
        } else {
            jad_uhVar = new com.jd.ad.sdk.jad_te.jad_pc();
            jad_fsVar2 = new com.jd.ad.sdk.jad_te.jad_jt();
        }
        if (i2 >= 28 && jad_fsVar.jad_an(jad_dq.jad_bo.class)) {
            jad_huVar3.jad_an("Animation", InputStream.class, Drawable.class, com.jd.ad.sdk.jad_vg.jad_an.jad_bo(listJad_an, jad_boVar));
            jad_huVar3.jad_an("Animation", ByteBuffer.class, Drawable.class, com.jd.ad.sdk.jad_vg.jad_an.jad_an(listJad_an, jad_boVar));
        }
        com.jd.ad.sdk.jad_vg.jad_er jad_erVar2 = new com.jd.ad.sdk.jad_vg.jad_er(context);
        jad_sf.jad_cp jad_cpVar = new jad_sf.jad_cp(resources);
        jad_sf.jad_dq jad_dqVar2 = new jad_sf.jad_dq(resources);
        jad_sf.jad_bo jad_boVar2 = new jad_sf.jad_bo(resources);
        jad_sf.jad_an jad_anVar3 = new jad_sf.jad_an(resources);
        com.jd.ad.sdk.jad_te.jad_cp jad_cpVar2 = new com.jd.ad.sdk.jad_te.jad_cp(jad_boVar);
        com.jd.ad.sdk.jad_yj.jad_an jad_anVar4 = new com.jd.ad.sdk.jad_yj.jad_an();
        com.jd.ad.sdk.jad_yj.jad_dq jad_dqVar3 = new com.jd.ad.sdk.jad_yj.jad_dq();
        ContentResolver contentResolver = context.getContentResolver();
        jad_huVar3.jad_an(ByteBuffer.class, new com.jd.ad.sdk.jad_qb.jad_cp()).jad_an(InputStream.class, new jad_tg(jad_boVar)).jad_an(Registry.BUCKET_BITMAP, ByteBuffer.class, Bitmap.class, jad_fsVar2).jad_an(Registry.BUCKET_BITMAP, InputStream.class, Bitmap.class, jad_uhVar);
        if (com.jd.ad.sdk.jad_kv.jad_mz.jad_cp()) {
            jad_huVar3.jad_an(Registry.BUCKET_BITMAP, ParcelFileDescriptor.class, Bitmap.class, new jad_re(jad_jwVar));
        }
        jad_hu jad_huVarJad_an = jad_huVar3.jad_an(Registry.BUCKET_BITMAP, ParcelFileDescriptor.class, Bitmap.class, jad_lyVarJad_cp).jad_an(Registry.BUCKET_BITMAP, AssetFileDescriptor.class, Bitmap.class, jad_xk.jad_an(jad_erVar));
        jad_vi.jad_an<?> jad_anVar5 = jad_vi.jad_an.jad_an;
        jad_huVarJad_an.jad_an(Bitmap.class, Bitmap.class, jad_anVar5).jad_an(Registry.BUCKET_BITMAP, Bitmap.class, Bitmap.class, new jad_wj()).jad_an(Bitmap.class, (com.jd.ad.sdk.jad_ju.jad_mz) jad_cpVar2).jad_an(Registry.BUCKET_BITMAP_DRAWABLE, ByteBuffer.class, BitmapDrawable.class, new com.jd.ad.sdk.jad_te.jad_an(resources, jad_fsVar2)).jad_an(Registry.BUCKET_BITMAP_DRAWABLE, InputStream.class, BitmapDrawable.class, new com.jd.ad.sdk.jad_te.jad_an(resources, jad_uhVar)).jad_an(Registry.BUCKET_BITMAP_DRAWABLE, ParcelFileDescriptor.class, BitmapDrawable.class, new com.jd.ad.sdk.jad_te.jad_an(resources, jad_lyVarJad_cp)).jad_an(BitmapDrawable.class, (com.jd.ad.sdk.jad_ju.jad_mz) new com.jd.ad.sdk.jad_te.jad_bo(jad_erVar, jad_cpVar2)).jad_an("Animation", InputStream.class, com.jd.ad.sdk.jad_xi.jad_cp.class, new com.jd.ad.sdk.jad_xi.jad_jw(listJad_an, jad_anVar2, jad_boVar)).jad_an("Animation", ByteBuffer.class, com.jd.ad.sdk.jad_xi.jad_cp.class, jad_anVar2).jad_an(com.jd.ad.sdk.jad_xi.jad_cp.class, (com.jd.ad.sdk.jad_ju.jad_mz) new com.jd.ad.sdk.jad_xi.jad_dq()).jad_an(com.jd.ad.sdk.jad_it.jad_an.class, com.jd.ad.sdk.jad_it.jad_an.class, jad_anVar5).jad_an(Registry.BUCKET_BITMAP, com.jd.ad.sdk.jad_it.jad_an.class, Bitmap.class, new com.jd.ad.sdk.jad_xi.jad_hu(jad_erVar)).jad_an(Uri.class, Drawable.class, jad_erVar2).jad_an(Uri.class, Bitmap.class, new com.jd.ad.sdk.jad_te.jad_tg(jad_erVar2, jad_erVar)).jad_an((com.jd.ad.sdk.jad_kv.jad_er.jad_an<?>) new com.jd.ad.sdk.jad_uf.jad_an.C0584jad_an()).jad_an(File.class, ByteBuffer.class, new com.jd.ad.sdk.jad_qb.jad_dq.jad_bo()).jad_an(File.class, InputStream.class, new com.jd.ad.sdk.jad_qb.jad_fs.jad_er()).jad_an(File.class, File.class, new com.jd.ad.sdk.jad_wh.jad_an()).jad_an(File.class, ParcelFileDescriptor.class, new com.jd.ad.sdk.jad_qb.jad_fs.jad_bo()).jad_an(File.class, File.class, jad_anVar5).jad_an((com.jd.ad.sdk.jad_kv.jad_er.jad_an<?>) new com.jd.ad.sdk.jad_kv.jad_kx.jad_an(jad_boVar));
        if (com.jd.ad.sdk.jad_kv.jad_mz.jad_cp()) {
            jad_huVar2 = jad_huVar3;
            jad_huVar2.jad_an((com.jd.ad.sdk.jad_kv.jad_er.jad_an<?>) new com.jd.ad.sdk.jad_kv.jad_mz.jad_an());
        } else {
            jad_huVar2 = jad_huVar3;
        }
        Class cls = Integer.TYPE;
        jad_huVar2.jad_an(cls, InputStream.class, jad_cpVar).jad_an(cls, ParcelFileDescriptor.class, jad_boVar2).jad_an(Integer.class, InputStream.class, jad_cpVar).jad_an(Integer.class, ParcelFileDescriptor.class, jad_boVar2).jad_an(Integer.class, Uri.class, jad_dqVar2).jad_an(cls, AssetFileDescriptor.class, jad_anVar3).jad_an(Integer.class, AssetFileDescriptor.class, jad_anVar3).jad_an(cls, Uri.class, jad_dqVar2).jad_an(String.class, InputStream.class, new com.jd.ad.sdk.jad_qb.jad_er.jad_cp()).jad_an(Uri.class, InputStream.class, new com.jd.ad.sdk.jad_qb.jad_er.jad_cp()).jad_an(String.class, InputStream.class, new com.jd.ad.sdk.jad_qb.jad_uh.jad_cp()).jad_an(String.class, ParcelFileDescriptor.class, new com.jd.ad.sdk.jad_qb.jad_uh.jad_bo()).jad_an(String.class, AssetFileDescriptor.class, new com.jd.ad.sdk.jad_qb.jad_uh.jad_an()).jad_an(Uri.class, InputStream.class, new com.jd.ad.sdk.jad_qb.jad_an.jad_cp(context.getAssets())).jad_an(Uri.class, AssetFileDescriptor.class, new com.jd.ad.sdk.jad_qb.jad_an.jad_bo(context.getAssets())).jad_an(Uri.class, InputStream.class, new com.jd.ad.sdk.jad_rc.jad_bo.jad_an(context)).jad_an(Uri.class, InputStream.class, new com.jd.ad.sdk.jad_rc.jad_cp.jad_an(context));
        if (i2 >= 29) {
            jad_huVar2.jad_an(Uri.class, InputStream.class, new com.jd.ad.sdk.jad_rc.jad_dq.jad_cp(context));
            jad_huVar2.jad_an(Uri.class, ParcelFileDescriptor.class, new com.jd.ad.sdk.jad_rc.jad_dq.jad_bo(context));
        }
        jad_huVar2.jad_an(Uri.class, InputStream.class, new com.jd.ad.sdk.jad_qb.jad_wj.jad_dq(contentResolver)).jad_an(Uri.class, ParcelFileDescriptor.class, new com.jd.ad.sdk.jad_qb.jad_wj.jad_bo(contentResolver)).jad_an(Uri.class, AssetFileDescriptor.class, new com.jd.ad.sdk.jad_qb.jad_wj.jad_an(contentResolver)).jad_an(Uri.class, InputStream.class, new com.jd.ad.sdk.jad_qb.jad_xk.jad_an()).jad_an(URL.class, InputStream.class, new com.jd.ad.sdk.jad_rc.jad_er.jad_an()).jad_an(Uri.class, File.class, new com.jd.ad.sdk.jad_qb.jad_kx.jad_an(context)).jad_an(com.jd.ad.sdk.jad_qb.jad_jt.class, InputStream.class, new com.jd.ad.sdk.jad_rc.jad_an.C0580jad_an()).jad_an(byte[].class, ByteBuffer.class, new com.jd.ad.sdk.jad_qb.jad_bo.jad_an()).jad_an(byte[].class, InputStream.class, new com.jd.ad.sdk.jad_qb.jad_bo.jad_dq()).jad_an(Uri.class, Uri.class, jad_anVar5).jad_an(Drawable.class, Drawable.class, jad_anVar5).jad_an(Drawable.class, Drawable.class, new com.jd.ad.sdk.jad_vg.jad_fs()).jad_an(Bitmap.class, BitmapDrawable.class, new com.jd.ad.sdk.jad_yj.jad_bo(resources)).jad_an(Bitmap.class, byte[].class, jad_anVar4).jad_an(Drawable.class, byte[].class, new com.jd.ad.sdk.jad_yj.jad_cp(jad_erVar, jad_anVar4, jad_dqVar3)).jad_an(com.jd.ad.sdk.jad_xi.jad_cp.class, byte[].class, jad_dqVar3);
        com.jd.ad.sdk.jad_ju.jad_ly<ByteBuffer, Bitmap> jad_lyVarJad_bo = jad_xk.jad_bo(jad_erVar);
        jad_huVar2.jad_an(ByteBuffer.class, Bitmap.class, jad_lyVarJad_bo);
        jad_huVar2.jad_an(ByteBuffer.class, BitmapDrawable.class, new com.jd.ad.sdk.jad_te.jad_an(resources, jad_lyVarJad_bo));
        this.jad_cp = new jad_er(context, jad_boVar, jad_huVar2, new com.jd.ad.sdk.jad_fo.jad_bo(), jad_anVar, map, list, jad_mzVar, jad_fsVar, i);
    }

    public static void jad_an(Context context, com.jd.ad.sdk.jad_gr.jad_an jad_anVar) {
        if (jad_jw) {
            throw new IllegalStateException("You cannot call Glide.get() in registerComponents(), use the provided Glide instance instead");
        }
        jad_jw = true;
        jad_dq jad_dqVar = new jad_dq();
        Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
        List<com.jd.ad.sdk.jad_al.jad_bo> listEmptyList = Collections.emptyList();
        if (jad_anVar != null && !jad_anVar.jad_an().isEmpty()) {
            Set<Class<?>> setJad_an = jad_anVar.jad_an();
            Iterator it = listEmptyList.iterator();
            while (it.hasNext()) {
                com.jd.ad.sdk.jad_al.jad_bo jad_boVar = (com.jd.ad.sdk.jad_al.jad_bo) it.next();
                if (setJad_an.contains(jad_boVar.getClass())) {
                    if (Log.isLoggable("Glide", 3)) {
                        Logger.d("Glide", "AppGlideModule excludes manifest GlideModule: " + jad_boVar);
                    }
                    it.remove();
                }
            }
        }
        if (Log.isLoggable("Glide", 3)) {
            Iterator it2 = listEmptyList.iterator();
            while (it2.hasNext()) {
                Logger.d("Glide", jad_ly.jad_an("Discovered GlideModule from manifest: ").append(((com.jd.ad.sdk.jad_al.jad_bo) it2.next()).getClass()).toString());
            }
        }
        jad_dqVar.jad_na = null;
        Iterator it3 = listEmptyList.iterator();
        while (it3.hasNext()) {
            ((com.jd.ad.sdk.jad_al.jad_bo) it3.next()).jad_an(origApplicationContext, jad_dqVar);
        }
        if (jad_dqVar.jad_jt == null) {
            com.jd.ad.sdk.jad_pa.jad_an.ThreadFactoryC0572jad_an threadFactoryC0572jad_an = new com.jd.ad.sdk.jad_pa.jad_an.ThreadFactoryC0572jad_an();
            int iJad_an = com.jd.ad.sdk.jad_pa.jad_an.jad_an();
            if (TextUtils.isEmpty(ba.at)) {
                throw new IllegalArgumentException(jad_ly.jad_an("Name must be non-null and non-empty, but given: ").append(ba.at).toString());
            }
            jad_dqVar.jad_jt = new com.jd.ad.sdk.jad_pa.jad_an(new ThreadPoolExecutor(iJad_an, iJad_an, 0L, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new com.jd.ad.sdk.jad_pa.jad_an.jad_bo(threadFactoryC0572jad_an, ba.at, com.jd.ad.sdk.jad_pa.jad_an.jad_cp.jad_an, false)));
        }
        if (jad_dqVar.jad_hu == null) {
            int i = com.jd.ad.sdk.jad_pa.jad_an.jad_cp;
            com.jd.ad.sdk.jad_pa.jad_an.ThreadFactoryC0572jad_an threadFactoryC0572jad_an2 = new com.jd.ad.sdk.jad_pa.jad_an.ThreadFactoryC0572jad_an();
            if (TextUtils.isEmpty("disk-cache")) {
                throw new IllegalArgumentException(jad_ly.jad_an("Name must be non-null and non-empty, but given: ").append("disk-cache").toString());
            }
            jad_dqVar.jad_hu = new com.jd.ad.sdk.jad_pa.jad_an(new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new com.jd.ad.sdk.jad_pa.jad_an.jad_bo(threadFactoryC0572jad_an2, "disk-cache", com.jd.ad.sdk.jad_pa.jad_an.jad_cp.jad_an, true)));
        }
        if (jad_dqVar.jad_ob == null) {
            int i2 = com.jd.ad.sdk.jad_pa.jad_an.jad_an() >= 4 ? 2 : 1;
            com.jd.ad.sdk.jad_pa.jad_an.ThreadFactoryC0572jad_an threadFactoryC0572jad_an3 = new com.jd.ad.sdk.jad_pa.jad_an.ThreadFactoryC0572jad_an();
            if (TextUtils.isEmpty("animation")) {
                throw new IllegalArgumentException(jad_ly.jad_an("Name must be non-null and non-empty, but given: ").append("animation").toString());
            }
            jad_dqVar.jad_ob = new com.jd.ad.sdk.jad_pa.jad_an(new ThreadPoolExecutor(i2, i2, 0L, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new com.jd.ad.sdk.jad_pa.jad_an.jad_bo(threadFactoryC0572jad_an3, "animation", com.jd.ad.sdk.jad_pa.jad_an.jad_cp.jad_an, true)));
        }
        if (jad_dqVar.jad_jw == null) {
            jad_dqVar.jad_jw = new com.jd.ad.sdk.jad_oz.jad_iv(new com.jd.ad.sdk.jad_oz.jad_iv.jad_an(origApplicationContext));
        }
        if (jad_dqVar.jad_kx == null) {
            jad_dqVar.jad_kx = new com.jd.ad.sdk.jad_zk.jad_fs();
        }
        if (jad_dqVar.jad_dq == null) {
            int i3 = jad_dqVar.jad_jw.jad_an;
            if (i3 > 0) {
                jad_dqVar.jad_dq = new com.jd.ad.sdk.jad_ny.jad_kx(i3, com.jd.ad.sdk.jad_ny.jad_kx.jad_er(), com.jd.ad.sdk.jad_ny.jad_kx.jad_dq());
            } else {
                jad_dqVar.jad_dq = new com.jd.ad.sdk.jad_ny.jad_fs();
            }
        }
        if (jad_dqVar.jad_er == null) {
            jad_dqVar.jad_er = new com.jd.ad.sdk.jad_ny.jad_jw(jad_dqVar.jad_jw.jad_dq);
        }
        if (jad_dqVar.jad_fs == null) {
            jad_dqVar.jad_fs = new com.jd.ad.sdk.jad_oz.jad_jt(jad_dqVar.jad_jw.jad_bo);
        }
        if (jad_dqVar.jad_iv == null) {
            jad_dqVar.jad_iv = new com.jd.ad.sdk.jad_oz.jad_fs(origApplicationContext, DiskCache.Factory.DEFAULT_DISK_CACHE_DIR, 262144000L);
        }
        if (jad_dqVar.jad_cp == null) {
            jad_dqVar.jad_cp = new jad_mz(jad_dqVar.jad_fs, jad_dqVar.jad_iv, jad_dqVar.jad_hu, jad_dqVar.jad_jt, new com.jd.ad.sdk.jad_pa.jad_an(new ThreadPoolExecutor(0, Integer.MAX_VALUE, com.jd.ad.sdk.jad_pa.jad_an.jad_bo, TimeUnit.MILLISECONDS, new SynchronousQueue(), new com.jd.ad.sdk.jad_pa.jad_an.jad_bo(new com.jd.ad.sdk.jad_pa.jad_an.ThreadFactoryC0572jad_an(), "source-unlimited", com.jd.ad.sdk.jad_pa.jad_an.jad_cp.jad_an, false))), jad_dqVar.jad_ob, null, null, null, null, null, null, false);
        }
        List<com.jd.ad.sdk.jad_en.jad_jt<Object>> list = jad_dqVar.jad_pc;
        jad_dqVar.jad_pc = list == null ? Collections.emptyList() : Collections.unmodifiableList(list);
        jad_fs.jad_an jad_anVar2 = jad_dqVar.jad_bo;
        jad_anVar2.getClass();
        jad_fs jad_fsVar = new jad_fs(jad_anVar2);
        jad_cp jad_cpVar = new jad_cp(origApplicationContext, jad_dqVar.jad_cp, jad_dqVar.jad_fs, jad_dqVar.jad_dq, jad_dqVar.jad_er, new jad_pc(jad_dqVar.jad_na, jad_fsVar), jad_dqVar.jad_kx, jad_dqVar.jad_ly, jad_dqVar.jad_mz, jad_dqVar.jad_an, jad_dqVar.jad_pc, jad_fsVar);
        for (com.jd.ad.sdk.jad_al.jad_bo jad_boVar2 : listEmptyList) {
            try {
                jad_boVar2.jad_an(origApplicationContext, jad_cpVar, jad_cpVar.jad_dq);
            } catch (AbstractMethodError e) {
                throw new IllegalStateException(jad_ly.jad_an("Attempting to register a Glide v3 module. If you see this, you or one of your dependencies may be including Glide v3 even though you're using Glide v4. You'll need to find and remove (or update) the offending dependency. The v3 module name is: ").append(jad_boVar2.getClass().getName()).toString(), e);
            }
        }
        origApplicationContext.registerComponentCallbacks(jad_cpVar);
        jad_iv = jad_cpVar;
        jad_jw = false;
    }

    public static void jad_an(Exception exc) {
        throw new IllegalStateException("GeneratedAppGlideModuleImpl is implemented incorrectly. If you've manually implemented this class, remove your implementation. The Annotation processor will generate a correct implementation.", exc);
    }

    public static jad_jw jad_bo(Context context) {
        if (context != null) {
            return jad_an(context).jad_fs.jad_bo(context);
        }
        throw new NullPointerException("You cannot start a load on a not yet attached View or a Fragment where getActivity() returns null (which usually occurs when getActivity() is called before the Fragment is attached or after the Fragment is destroyed).");
    }

    public com.jd.ad.sdk.jad_ny.jad_er jad_an() {
        return this.jad_an;
    }

    public void jad_an(jad_jw jad_jwVar) {
        synchronized (this.jad_hu) {
            if (this.jad_hu.contains(jad_jwVar)) {
                throw new IllegalStateException("Cannot register already registered manager");
            }
            this.jad_hu.add(jad_jwVar);
        }
    }

    public com.jd.ad.sdk.jad_zk.jad_dq jad_bo() {
        return this.jad_jt;
    }

    public Context jad_cp() {
        return this.jad_cp.getBaseContext();
    }

    public jad_er jad_dq() {
        return this.jad_cp;
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        com.jd.ad.sdk.jad_ir.jad_ly.jad_an();
        ((com.jd.ad.sdk.jad_ir.jad_hu) this.jad_bo).jad_an(0L);
        this.jad_an.jad_an();
        this.jad_er.jad_an();
    }

    @Override // android.content.ComponentCallbacks2
    public void onTrimMemory(int i) {
        long j;
        com.jd.ad.sdk.jad_ir.jad_ly.jad_an();
        synchronized (this.jad_hu) {
            Iterator<jad_jw> it = this.jad_hu.iterator();
            while (it.hasNext()) {
                it.next().getClass();
            }
        }
        com.jd.ad.sdk.jad_oz.jad_jt jad_jtVar = (com.jd.ad.sdk.jad_oz.jad_jt) this.jad_bo;
        jad_jtVar.getClass();
        if (i >= 40) {
            jad_jtVar.jad_an(0L);
        } else if (i >= 20 || i == 15) {
            synchronized (jad_jtVar) {
                j = jad_jtVar.jad_bo;
            }
            jad_jtVar.jad_an(j / 2);
        }
        this.jad_an.jad_an(i);
        this.jad_er.jad_an(i);
    }

    public static jad_cp jad_an(Context context) {
        if (jad_iv == null) {
            com.jd.ad.sdk.jad_gr.jad_an jad_anVar = null;
            try {
                jad_anVar = (com.jd.ad.sdk.jad_gr.jad_an) Class.forName("com.jd.ad.sdk.glide.GeneratedAppGlideModuleImpl").getDeclaredConstructor(Context.class).newInstance(StubApp.getOrigApplicationContext(StubApp.getOrigApplicationContext(context.getApplicationContext()).getApplicationContext()));
            } catch (ClassNotFoundException unused) {
                if (Log.isLoggable("Glide", 5)) {
                    Logger.w("Glide", "Failed to find GeneratedAppGlideModule. You should include an annotationProcessor compile dependency on com.github.bumptech.glide:compiler in your application and a @GlideModule annotated AppGlideModule implementation or LibraryGlideModules will be silently ignored");
                }
            } catch (IllegalAccessException e) {
                jad_an(e);
                throw null;
            } catch (InstantiationException e2) {
                jad_an(e2);
                throw null;
            } catch (NoSuchMethodException e3) {
                jad_an(e3);
                throw null;
            } catch (InvocationTargetException e4) {
                jad_an(e4);
                throw null;
            }
            synchronized (jad_cp.class) {
                if (jad_iv == null) {
                    jad_an(context, jad_anVar);
                }
            }
        }
        return jad_iv;
    }
}
