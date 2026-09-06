package com.opos.videocache.a;

import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public abstract class d implements com.opos.videocache.a.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ExecutorService f8427a = Executors.newSingleThreadExecutor();

    private class a implements Callable<Void> {
        private final File b;

        public a(File file) {
            this.b = file;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void call() throws Throwable {
            d.this.b(this.b);
            return null;
        }
    }

    private void a(List<File> list) {
        long jB = b(list);
        int size = list.size();
        for (File file : list) {
            if (!a(file, jB, size)) {
                long length = file.length();
                if (file.delete()) {
                    size--;
                    jB -= length;
                    com.opos.cmn.an.f.a.a("LruDiskUsage", "Cache file " + file + " is deleted because it exceeds cache limit");
                } else {
                    com.opos.cmn.an.f.a.d("LruDiskUsage", "Error deleting file " + file + " for trimming cache");
                }
            }
        }
    }

    private long b(List<File> list) {
        Iterator<File> it = list.iterator();
        long length = 0;
        while (it.hasNext()) {
            length += it.next().length();
        }
        return length;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(File file) throws Throwable {
        h.c(file);
        a(h.b(file.getParentFile()));
    }

    @Override // com.opos.videocache.a.a
    public void a(File file) {
        this.f8427a.submit(new a(file));
    }

    protected abstract boolean a(File file, long j, int i);
}
