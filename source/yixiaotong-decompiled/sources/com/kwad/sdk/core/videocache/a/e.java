package com.kwad.sdk.core.videocache.a;

import com.kwad.sdk.core.threads.GlobalThreadPools;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public abstract class e implements com.kwad.sdk.core.videocache.a.a {
    private final ExecutorService baE = GlobalThreadPools.NV();

    protected abstract boolean aQ(long j);

    @Override // com.kwad.sdk.core.videocache.a.a
    public final void s(File file) {
        this.baE.submit(new a(file));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(File file) throws Throwable {
        d.w(file);
        K(d.v(file.getParentFile()));
    }

    private void K(List<File> list) {
        long jL = L(list);
        list.size();
        for (File file : list) {
            if (!aQ(jL)) {
                long length = file.length();
                if (file.delete()) {
                    jL -= length;
                } else {
                    com.kwad.sdk.core.d.c.e("LruDiskUsage", "Error deleting file " + file + " for trimming cache");
                }
            }
        }
    }

    private static long L(List<File> list) {
        Iterator<File> it = list.iterator();
        long length = 0;
        while (it.hasNext()) {
            length += it.next().length();
        }
        return length;
    }

    class a implements Callable<Void> {
        private final File file;

        public a(File file) {
            this.file = file;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: Ln, reason: merged with bridge method [inline-methods] */
        public Void call() throws Throwable {
            e.this.z(this.file);
            return null;
        }
    }
}
