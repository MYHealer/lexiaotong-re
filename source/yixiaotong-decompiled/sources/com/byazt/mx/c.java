package com.byazt.mx;

import com.byazt.is.uj;
import com.byazt.is.ve;
import com.byazt.uq.i;
import com.byazt.uq.sp;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.kuaishou.weapon.p0.t;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.zip.ZipException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SIDX_INFOS, 20})
public class c {
    public final uj c;
    public final com.byazt.po.tt tt = new com.byazt.po.tt();

    public c(uj ujVar) {
        this.c = ujVar;
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0115 A[Catch: all -> 0x013a, TryCatch #4 {all -> 0x013a, blocks: (B:25:0x00c8, B:27:0x012a, B:26:0x0115), top: B:65:0x00c8 }] */
    /* JADX WARN: Code duplicated, block: B:52:0x017c  */
    /* JADX WARN: Code duplicated, block: B:54:0x0181  */
    public void c(boolean z, boolean z2) throws Throwable {
        File file;
        RandomAccessFile randomAccessFile;
        File file2;
        File file3 = new File(this.c.ve().getAbsolutePath() + ".rm_tmp");
        if (file3.exists()) {
            file3.delete();
        }
        RandomAccessFile randomAccessFile2 = null;
        try {
            randomAccessFile = new RandomAccessFile(file3, "rw");
            try {
                RandomAccessFile randomAccessFile3 = new RandomAccessFile(this.c.ve(), t.k);
                try {
                    List<ve> listC = this.c.c().c();
                    HashSet hashSet = new HashSet();
                    Iterator<ve> it = listC.iterator();
                    int iVe = 0;
                    while (it.hasNext()) {
                        try {
                            ve next = it.next();
                            if (c(next, z, z2)) {
                                hashSet.add(next.t());
                            } else {
                                long jU = next.u();
                                if ("resources.arsc".equals(next.t())) {
                                    long filePointer = randomAccessFile.getFilePointer() + next.uj();
                                    long jA = filePointer % 4096 == 0 ? 0L : 4096 - ((filePointer - ((long) next.a())) % 4096);
                                    if (jA != 0) {
                                        int iA = next.a();
                                        int i = (int) jA;
                                        next.tt(i);
                                        file2 = file3;
                                        try {
                                            c(randomAccessFile3, randomAccessFile, jU, next.n(), next.t());
                                            this.c.uj().c(randomAccessFile, i);
                                            c(randomAccessFile3, randomAccessFile, jU + next.n() + 2, next.da(), next.t());
                                            randomAccessFile.write(new byte[i]);
                                            c(randomAccessFile3, randomAccessFile, jU + next.n() + 2 + ((long) next.da()) + ((long) iA), next.tt(), next.t());
                                        } catch (Throwable th) {
                                            th = th;
                                            randomAccessFile2 = randomAccessFile3;
                                            file = file2;
                                            if (randomAccessFile2 != null) {
                                                randomAccessFile2.close();
                                            }
                                            if (randomAccessFile != null) {
                                                randomAccessFile.close();
                                            }
                                            c(file);
                                            throw th;
                                        }
                                    } else {
                                        file2 = file3;
                                        c(randomAccessFile3, randomAccessFile, jU, next.ve(), next.t());
                                    }
                                } else {
                                    file2 = file3;
                                    c(randomAccessFile3, randomAccessFile, jU, next.ve(), next.t());
                                }
                                long j = iVe;
                                next.uj(j);
                                iVe = (int) (j + next.ve());
                                it = it;
                                file3 = file2;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            file2 = file3;
                        }
                    }
                    File file4 = file3;
                    try {
                        this.c.c().c(hashSet);
                        this.tt.c(this.c, randomAccessFile);
                        file = file4;
                        try {
                            c(this.c.ve(), file);
                            randomAccessFile3.close();
                            randomAccessFile.close();
                            c(file);
                        } catch (Throwable th3) {
                            th = th3;
                            randomAccessFile2 = randomAccessFile3;
                            if (randomAccessFile2 != null) {
                                randomAccessFile2.close();
                            }
                            if (randomAccessFile != null) {
                                randomAccessFile.close();
                            }
                            c(file);
                            throw th;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        file = file4;
                    }
                } catch (Throwable th5) {
                    th = th5;
                    file = file3;
                }
            } catch (Throwable th6) {
                th = th6;
                file = file3;
            }
        } catch (Throwable th7) {
            th = th7;
            file = file3;
            randomAccessFile = null;
        }
    }

    private boolean c(ve veVar, boolean z, boolean z2) {
        if (z) {
            if (i.n() && veVar.t().equals("classes.dex")) {
                return false;
            }
            if (veVar.t().startsWith("classes") && veVar.t().endsWith(".dex")) {
                return true;
            }
        }
        return z2 && veVar.t().startsWith("lib/") && veVar.t().endsWith(".so");
    }

    public void c(File file) throws ZipException {
        if (file.exists() && !file.delete()) {
            throw new ZipException("Could not delete temporary file");
        }
    }

    public void c(RandomAccessFile randomAccessFile, RandomAccessFile randomAccessFile2, long j, long j2, String str) throws IOException {
        sp.c(randomAccessFile, randomAccessFile2, j, j + j2, str);
    }

    private void c(File file, File file2) throws ZipException {
        if (!file2.renameTo(file)) {
            throw new ZipException("cannot rename modified zip file");
        }
    }
}
