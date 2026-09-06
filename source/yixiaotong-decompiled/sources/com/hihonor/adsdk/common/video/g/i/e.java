package com.hihonor.adsdk.common.video.g.i;

import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public abstract class e implements com.hihonor.adsdk.common.video.g.i.a {
    private static final String hnadsb = "LruDiskUsage";
    private final ExecutorService hnadsa = Executors.newSingleThreadExecutor();

    private class a implements Callable<Void> {
        private final File hnadsa;

        public a(File file) {
            this.hnadsa = file;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: hnadsa, reason: merged with bridge method [inline-methods] */
        public Void call() {
            try {
                e.this.hnadsb(this.hnadsa);
                return null;
            } catch (com.hihonor.adsdk.common.video.g.f e) {
                com.hihonor.adsdk.common.b.b.hnadsb(e.hnadsb, "Touch in background error " + e.getMessage(), new Object[0]);
                return null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hnadsb(File file) throws com.hihonor.adsdk.common.video.g.f {
        d.hnadse(file);
        if (file.getParentFile() == null) {
            throw new com.hihonor.adsdk.common.video.g.f(com.hihonor.adsdk.common.video.g.d.hnadsb, "Error touchInBackground parent file is null");
        }
        hnadsb(d.hnadsa(file.getParentFile()));
    }

    protected abstract boolean hnadsa(File file, long j, int i);

    @Override // com.hihonor.adsdk.common.video.g.i.a
    public void hnadsa(File file) throws com.hihonor.adsdk.common.video.g.f {
        this.hnadsa.submit(new a(file));
    }

    private long hnadsa(List<File> list) {
        Iterator<File> it = list.iterator();
        long length = 0;
        while (it.hasNext()) {
            length += it.next().length();
        }
        return length;
    }

    private void hnadsb(List<File> list) {
        long jHnadsa = hnadsa(list);
        int size = list.size();
        for (File file : list) {
            if (!hnadsa(file, jHnadsa, size)) {
                long length = file.length();
                if (file.delete()) {
                    size--;
                    jHnadsa -= length;
                    com.hihonor.adsdk.common.b.b.hnadsc(hnadsb, "Cache file " + file + " is deleted because it exceeds cache limit", new Object[0]);
                } else {
                    com.hihonor.adsdk.common.b.b.hnadsc(hnadsb, "Error deleting file " + file + " for trimming cache", new Object[0]);
                }
            }
        }
    }
}
