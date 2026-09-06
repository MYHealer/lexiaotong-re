package com.ubix.ssp.ad.e.b0.h.s;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public abstract class e implements com.ubix.ssp.ad.e.b0.h.s.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ExecutorService f8798a = Executors.newSingleThreadExecutor(new a());

    class a implements ThreadFactory {
        a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "Ubix.PingThread");
        }
    }

    private class b implements Callable<Void> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final File f8800a;

        public b(File file) {
            this.f8800a = file;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void call() throws IOException {
            e.this.b(this.f8800a);
            return null;
        }
    }

    private long a(List<File> list) {
        Iterator<File> it = list.iterator();
        long length = 0;
        while (it.hasNext()) {
            length += it.next().length();
        }
        return length;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(File file) throws IOException {
        d.e(file);
        b(d.a(file.getParentFile()));
    }

    private void b(List<File> list) {
        long jA = a(list);
        int size = list.size();
        for (File file : list) {
            if (!a(file, jA, size)) {
                long length = file.length();
                if (file.delete()) {
                    size--;
                    jA -= length;
                }
            }
        }
    }

    @Override // com.ubix.ssp.ad.e.b0.h.s.a
    public void a(File file) {
        this.f8798a.submit(new b(file));
    }

    protected abstract boolean a(File file, long j, int i);
}
