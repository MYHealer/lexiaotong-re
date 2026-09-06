package com.byazt.wgf;

import com.byazt.bwm.a;
import com.byazt.bwm.n;
import com.byazt.bwm.sp;
import com.byazt.nr.m;
import com.byazt.nr.x;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 178, 20})
public abstract class c {
    public abstract void c(List<File> list);

    public abstract boolean c(long j, int i);

    public abstract boolean c(File file, long j, int i);

    public void c(File file) throws IOException {
        final a aVar = new a(new CallableC0311c(file), 1, 2);
        n.tt(new sp("touch", aVar.c()) { // from class: com.byazt.wgf.c.1
            @Override // java.lang.Runnable
            public void run() {
                aVar.run();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tt(File file) throws IOException {
        try {
            x.tt(file);
        } catch (Throwable unused) {
        }
        List<File> listC = x.c(file.getParentFile());
        m.uj("splashLoadAd", "LruDiskFile touchInBackground files.size() " + listC.size());
        c(listC);
    }

    public long tt(List<File> list) {
        Iterator<File> it = list.iterator();
        long length = 0;
        while (it.hasNext()) {
            length += it.next().length();
        }
        return length;
    }

    /* JADX INFO: renamed from: com.byazt.wgf.c$c, reason: collision with other inner class name */
    @com.byazt.zqa.c(c = {0, 1, 178, 44})
    private class CallableC0311c implements Callable<Void> {
        public final File tt;

        private CallableC0311c(File file) {
            this.tt = file;
        }

        @Override // java.util.concurrent.Callable
        public Void call() throws Exception {
            c.this.tt(this.tt);
            return null;
        }
    }
}
