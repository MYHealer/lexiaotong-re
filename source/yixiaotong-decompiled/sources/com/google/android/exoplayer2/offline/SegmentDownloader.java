package com.google.android.exoplayer2.offline;

import android.net.Uri;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.offline.FilterableManifest;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.ParsingLoadable;
import com.google.android.exoplayer2.upstream.cache.Cache;
import com.google.android.exoplayer2.upstream.cache.CacheDataSource;
import com.google.android.exoplayer2.upstream.cache.CacheKeyFactory;
import com.google.android.exoplayer2.upstream.cache.CacheWriter;
import com.google.android.exoplayer2.upstream.cache.ContentMetadata;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.PriorityTaskManager;
import com.google.android.exoplayer2.util.RunnableFutureTask;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public abstract class SegmentDownloader<M extends FilterableManifest<M>> implements Downloader {
    private static final int BUFFER_SIZE_BYTES = 131072;
    private static final long MAX_MERGED_SEGMENT_START_TIME_DIFF_US = 20000000;
    private final ArrayList<RunnableFutureTask<?, ?>> activeRunnables;
    private final Cache cache;
    private final CacheDataSource.Factory cacheDataSourceFactory;
    private final CacheKeyFactory cacheKeyFactory;
    private final Executor executor;
    private volatile boolean isCanceled;
    private final DataSpec manifestDataSpec;
    private final ParsingLoadable.Parser<M> manifestParser;
    private final PriorityTaskManager priorityTaskManager;
    private final ArrayList<StreamKey> streamKeys;

    protected abstract List<Segment> getSegments(DataSource dataSource, M m, boolean z) throws InterruptedException, IOException;

    protected static class Segment implements Comparable<Segment> {
        public final DataSpec dataSpec;
        public final long startTimeUs;

        public Segment(long j, DataSpec dataSpec) {
            this.startTimeUs = j;
            this.dataSpec = dataSpec;
        }

        @Override // java.lang.Comparable
        public int compareTo(Segment segment) {
            return Util.compareLong(this.startTimeUs, segment.startTimeUs);
        }
    }

    public SegmentDownloader(MediaItem mediaItem, ParsingLoadable.Parser<M> parser, CacheDataSource.Factory factory, Executor executor) {
        Assertions.checkNotNull(mediaItem.localConfiguration);
        this.manifestDataSpec = getCompressibleDataSpec(mediaItem.localConfiguration.uri);
        this.manifestParser = parser;
        this.streamKeys = new ArrayList<>(mediaItem.localConfiguration.streamKeys);
        this.cacheDataSourceFactory = factory;
        this.executor = executor;
        this.cache = (Cache) Assertions.checkNotNull(factory.getCache());
        this.cacheKeyFactory = factory.getCacheKeyFactory();
        this.priorityTaskManager = factory.getUpstreamPriorityTaskManager();
        this.activeRunnables = new ArrayList<>();
    }

    /* JADX WARN: Code duplicated, block: B:86:0x01a6 A[LOOP:1: B:84:0x019e->B:86:0x01a6, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:89:0x01bf A[LOOP:2: B:88:0x01bd->B:89:0x01bf, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:92:0x01d4  */
    @Override // com.google.android.exoplayer2.offline.Downloader
    public final void download(Downloader.ProgressListener progressListener) throws Throwable {
        SegmentDownloader<M> segmentDownloader;
        int i;
        int size;
        PriorityTaskManager priorityTaskManager;
        CacheDataSource cacheDataSourceCreateDataSourceForDownloading;
        byte[] bArr;
        SegmentDownloader<M> segmentDownloader2 = this;
        ArrayDeque arrayDeque = new ArrayDeque();
        ArrayDeque arrayDeque2 = new ArrayDeque();
        PriorityTaskManager priorityTaskManager2 = segmentDownloader2.priorityTaskManager;
        if (priorityTaskManager2 != null) {
            priorityTaskManager2.add(-1000);
        }
        try {
            CacheDataSource cacheDataSourceCreateDataSourceForDownloading2 = segmentDownloader2.cacheDataSourceFactory.createDataSourceForDownloading();
            FilterableManifest manifest = segmentDownloader2.getManifest(cacheDataSourceCreateDataSourceForDownloading2, segmentDownloader2.manifestDataSpec, false);
            if (!segmentDownloader2.streamKeys.isEmpty()) {
                manifest = (FilterableManifest) manifest.copy(segmentDownloader2.streamKeys);
            }
            List<Segment> segments = segmentDownloader2.getSegments(cacheDataSourceCreateDataSourceForDownloading2, manifest, false);
            Collections.sort(segments);
            mergeSegments(segments, segmentDownloader2.cacheKeyFactory);
            int size2 = segments.size();
            int size3 = segments.size() - 1;
            int i2 = 0;
            long j = 0;
            long j2 = 0;
            while (size3 >= 0) {
                try {
                    DataSpec dataSpec = segments.get(size3).dataSpec;
                    String strBuildCacheKey = segmentDownloader2.cacheKeyFactory.buildCacheKey(dataSpec);
                    long j3 = dataSpec.length;
                    if (j3 == -1) {
                        long contentLength = ContentMetadata.getContentLength(segmentDownloader2.cache.getContentMetadata(strBuildCacheKey));
                        if (contentLength != -1) {
                            j3 = contentLength - dataSpec.position;
                        }
                    }
                    ArrayDeque arrayDeque3 = arrayDeque;
                    long cachedBytes = segmentDownloader2.cache.getCachedBytes(strBuildCacheKey, dataSpec.position, j3);
                    j2 += cachedBytes;
                    if (j3 != -1) {
                        if (j3 == cachedBytes) {
                            i2++;
                            segments.remove(size3);
                        }
                        if (j != -1) {
                            j += j3;
                        }
                    } else {
                        j = -1;
                    }
                    size3--;
                    segmentDownloader2 = this;
                    arrayDeque = arrayDeque3;
                } catch (Throwable th) {
                    th = th;
                    segmentDownloader = this;
                    for (i = 0; i < segmentDownloader.activeRunnables.size(); i++) {
                        segmentDownloader.activeRunnables.get(i).cancel(true);
                    }
                    for (size = segmentDownloader.activeRunnables.size() - 1; size >= 0; size--) {
                        segmentDownloader.activeRunnables.get(size).blockUntilFinished();
                        segmentDownloader.removeActiveRunnable(size);
                    }
                    priorityTaskManager = segmentDownloader.priorityTaskManager;
                    if (priorityTaskManager != null) {
                        priorityTaskManager.remove(-1000);
                    }
                    throw th;
                }
            }
            ArrayDeque arrayDeque4 = arrayDeque;
            ProgressNotifier progressNotifier = progressListener != null ? new ProgressNotifier(progressListener, j, size2, j2, i2) : null;
            arrayDeque4.addAll(segments);
            segmentDownloader = this;
            while (!segmentDownloader.isCanceled && !arrayDeque4.isEmpty()) {
                try {
                    PriorityTaskManager priorityTaskManager3 = segmentDownloader.priorityTaskManager;
                    if (priorityTaskManager3 != null) {
                        priorityTaskManager3.proceed(-1000);
                    }
                    if (!arrayDeque2.isEmpty()) {
                        SegmentDownloadRunnable segmentDownloadRunnable = (SegmentDownloadRunnable) arrayDeque2.removeFirst();
                        cacheDataSourceCreateDataSourceForDownloading = segmentDownloadRunnable.dataSource;
                        bArr = segmentDownloadRunnable.temporaryBuffer;
                    } else {
                        cacheDataSourceCreateDataSourceForDownloading = segmentDownloader.cacheDataSourceFactory.createDataSourceForDownloading();
                        bArr = new byte[131072];
                    }
                    SegmentDownloadRunnable segmentDownloadRunnable2 = new SegmentDownloadRunnable((Segment) arrayDeque4.removeFirst(), cacheDataSourceCreateDataSourceForDownloading, progressNotifier, bArr);
                    segmentDownloader.addActiveRunnable(segmentDownloadRunnable2);
                    segmentDownloader.executor.execute(segmentDownloadRunnable2);
                    for (int size4 = segmentDownloader.activeRunnables.size() - 1; size4 >= 0; size4--) {
                        SegmentDownloadRunnable segmentDownloadRunnable3 = (SegmentDownloadRunnable) segmentDownloader.activeRunnables.get(size4);
                        if (arrayDeque4.isEmpty() || segmentDownloadRunnable3.isDone()) {
                            try {
                                segmentDownloadRunnable3.get();
                                segmentDownloader.removeActiveRunnable(size4);
                                arrayDeque2.addLast(segmentDownloadRunnable3);
                            } catch (ExecutionException e) {
                                Throwable th2 = (Throwable) Assertions.checkNotNull(e.getCause());
                                if (th2 instanceof PriorityTaskManager.PriorityTooLowException) {
                                    arrayDeque4.addFirst(segmentDownloadRunnable3.segment);
                                    segmentDownloader.removeActiveRunnable(size4);
                                    arrayDeque2.addLast(segmentDownloadRunnable3);
                                } else {
                                    if (th2 instanceof IOException) {
                                        throw ((IOException) th2);
                                    }
                                    Util.sneakyThrow(th2);
                                }
                            }
                        }
                    }
                    segmentDownloadRunnable2.blockUntilStarted();
                } catch (Throwable th3) {
                    th = th3;
                    while (i < segmentDownloader.activeRunnables.size()) {
                        segmentDownloader.activeRunnables.get(i).cancel(true);
                    }
                    while (size >= 0) {
                        segmentDownloader.activeRunnables.get(size).blockUntilFinished();
                        segmentDownloader.removeActiveRunnable(size);
                    }
                    priorityTaskManager = segmentDownloader.priorityTaskManager;
                    if (priorityTaskManager != null) {
                        priorityTaskManager.remove(-1000);
                    }
                    throw th;
                }
            }
            for (int i3 = 0; i3 < segmentDownloader.activeRunnables.size(); i3++) {
                segmentDownloader.activeRunnables.get(i3).cancel(true);
            }
            for (int size5 = segmentDownloader.activeRunnables.size() - 1; size5 >= 0; size5--) {
                segmentDownloader.activeRunnables.get(size5).blockUntilFinished();
                segmentDownloader.removeActiveRunnable(size5);
            }
            PriorityTaskManager priorityTaskManager4 = segmentDownloader.priorityTaskManager;
            if (priorityTaskManager4 != null) {
                priorityTaskManager4.remove(-1000);
            }
        } catch (Throwable th4) {
            th = th4;
            segmentDownloader = segmentDownloader2;
        }
    }

    @Override // com.google.android.exoplayer2.offline.Downloader
    public void cancel() {
        synchronized (this.activeRunnables) {
            this.isCanceled = true;
            for (int i = 0; i < this.activeRunnables.size(); i++) {
                this.activeRunnables.get(i).cancel(true);
            }
        }
    }

    @Override // com.google.android.exoplayer2.offline.Downloader
    public final void remove() {
        CacheDataSource cacheDataSourceCreateDataSourceForRemovingDownload = this.cacheDataSourceFactory.createDataSourceForRemovingDownload();
        try {
            List<Segment> segments = getSegments(cacheDataSourceCreateDataSourceForRemovingDownload, getManifest(cacheDataSourceCreateDataSourceForRemovingDownload, this.manifestDataSpec, true), true);
            for (int i = 0; i < segments.size(); i++) {
                this.cache.removeResource(this.cacheKeyFactory.buildCacheKey(segments.get(i).dataSpec));
            }
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        } catch (Exception unused2) {
        } finally {
            this.cache.removeResource(this.cacheKeyFactory.buildCacheKey(this.manifestDataSpec));
        }
    }

    protected final M getManifest(final DataSource dataSource, final DataSpec dataSpec, boolean z) throws InterruptedException, IOException {
        return (M) execute(new RunnableFutureTask<M, IOException>() { // from class: com.google.android.exoplayer2.offline.SegmentDownloader.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.exoplayer2.util.RunnableFutureTask
            public M doWork() throws IOException {
                return (M) ParsingLoadable.load(dataSource, SegmentDownloader.this.manifestParser, dataSpec, 4);
            }
        }, z);
    }

    protected final <T> T execute(RunnableFutureTask<T, ?> runnableFutureTask, boolean z) throws Throwable {
        if (z) {
            runnableFutureTask.run();
            try {
                return runnableFutureTask.get();
            } catch (ExecutionException e) {
                Throwable th = (Throwable) Assertions.checkNotNull(e.getCause());
                if (th instanceof IOException) {
                    throw ((IOException) th);
                }
                Util.sneakyThrow(e);
            }
        }
        while (!this.isCanceled) {
            PriorityTaskManager priorityTaskManager = this.priorityTaskManager;
            if (priorityTaskManager != null) {
                priorityTaskManager.proceed(-1000);
            }
            addActiveRunnable(runnableFutureTask);
            this.executor.execute(runnableFutureTask);
            try {
                T t = runnableFutureTask.get();
                runnableFutureTask.blockUntilFinished();
                removeActiveRunnable((RunnableFutureTask<?, ?>) runnableFutureTask);
                return t;
            } catch (ExecutionException e2) {
                try {
                    Throwable th2 = (Throwable) Assertions.checkNotNull(e2.getCause());
                    if (!(th2 instanceof PriorityTaskManager.PriorityTooLowException)) {
                        if (th2 instanceof IOException) {
                            throw ((IOException) th2);
                        }
                        Util.sneakyThrow(e2);
                    }
                    runnableFutureTask.blockUntilFinished();
                    removeActiveRunnable((RunnableFutureTask<?, ?>) runnableFutureTask);
                } catch (Throwable th3) {
                    runnableFutureTask.blockUntilFinished();
                    removeActiveRunnable((RunnableFutureTask<?, ?>) runnableFutureTask);
                    throw th3;
                }
            }
        }
        throw new InterruptedException();
    }

    protected static DataSpec getCompressibleDataSpec(Uri uri) {
        return new DataSpec.Builder().setUri(uri).setFlags(1).build();
    }

    private <T> void addActiveRunnable(RunnableFutureTask<T, ?> runnableFutureTask) throws InterruptedException {
        synchronized (this.activeRunnables) {
            if (this.isCanceled) {
                throw new InterruptedException();
            }
            this.activeRunnables.add(runnableFutureTask);
        }
    }

    private void removeActiveRunnable(RunnableFutureTask<?, ?> runnableFutureTask) {
        synchronized (this.activeRunnables) {
            this.activeRunnables.remove(runnableFutureTask);
        }
    }

    private void removeActiveRunnable(int i) {
        synchronized (this.activeRunnables) {
            this.activeRunnables.remove(i);
        }
    }

    private static void mergeSegments(List<Segment> list, CacheKeyFactory cacheKeyFactory) {
        HashMap map = new HashMap();
        int i = 0;
        for (int i2 = 0; i2 < list.size(); i2++) {
            Segment segment = list.get(i2);
            String strBuildCacheKey = cacheKeyFactory.buildCacheKey(segment.dataSpec);
            Integer num = (Integer) map.get(strBuildCacheKey);
            Segment segment2 = num == null ? null : list.get(num.intValue());
            if (segment2 == null || segment.startTimeUs > segment2.startTimeUs + MAX_MERGED_SEGMENT_START_TIME_DIFF_US || !canMergeSegments(segment2.dataSpec, segment.dataSpec)) {
                map.put(strBuildCacheKey, Integer.valueOf(i));
                list.set(i, segment);
                i++;
            } else {
                list.set(((Integer) Assertions.checkNotNull(num)).intValue(), new Segment(segment2.startTimeUs, segment2.dataSpec.subrange(0L, segment.dataSpec.length != -1 ? segment2.dataSpec.length + segment.dataSpec.length : -1L)));
            }
        }
        Util.removeRange(list, i, list.size());
    }

    private static boolean canMergeSegments(DataSpec dataSpec, DataSpec dataSpec2) {
        return dataSpec.uri.equals(dataSpec2.uri) && dataSpec.length != -1 && dataSpec.position + dataSpec.length == dataSpec2.position && Util.areEqual(dataSpec.key, dataSpec2.key) && dataSpec.flags == dataSpec2.flags && dataSpec.httpMethod == dataSpec2.httpMethod && dataSpec.httpRequestHeaders.equals(dataSpec2.httpRequestHeaders);
    }

    private static final class SegmentDownloadRunnable extends RunnableFutureTask<Void, IOException> {
        private final CacheWriter cacheWriter;
        public final CacheDataSource dataSource;
        private final ProgressNotifier progressNotifier;
        public final Segment segment;
        public final byte[] temporaryBuffer;

        public SegmentDownloadRunnable(Segment segment, CacheDataSource cacheDataSource, ProgressNotifier progressNotifier, byte[] bArr) {
            this.segment = segment;
            this.dataSource = cacheDataSource;
            this.progressNotifier = progressNotifier;
            this.temporaryBuffer = bArr;
            this.cacheWriter = new CacheWriter(cacheDataSource, segment.dataSpec, bArr, progressNotifier);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.exoplayer2.util.RunnableFutureTask
        public Void doWork() throws IOException {
            this.cacheWriter.cache();
            ProgressNotifier progressNotifier = this.progressNotifier;
            if (progressNotifier == null) {
                return null;
            }
            progressNotifier.onSegmentDownloaded();
            return null;
        }

        @Override // com.google.android.exoplayer2.util.RunnableFutureTask
        protected void cancelWork() {
            this.cacheWriter.cancel();
        }
    }

    private static final class ProgressNotifier implements CacheWriter.ProgressListener {
        private long bytesDownloaded;
        private final long contentLength;
        private final Downloader.ProgressListener progressListener;
        private int segmentsDownloaded;
        private final int totalSegments;

        private float getPercentDownloaded() {
            long j = this.contentLength;
            if (j != -1 && j != 0) {
                return (this.bytesDownloaded * 100.0f) / j;
            }
            int i = this.totalSegments;
            if (i != 0) {
                return (this.segmentsDownloaded * 100.0f) / i;
            }
            return -1.0f;
        }

        public ProgressNotifier(Downloader.ProgressListener progressListener, long j, int i, long j2, int i2) {
            this.progressListener = progressListener;
            this.contentLength = j;
            this.totalSegments = i;
            this.bytesDownloaded = j2;
            this.segmentsDownloaded = i2;
        }

        @Override // com.google.android.exoplayer2.upstream.cache.CacheWriter.ProgressListener
        public void onProgress(long j, long j2, long j3) {
            long j4 = this.bytesDownloaded + j3;
            this.bytesDownloaded = j4;
            this.progressListener.onProgress(this.contentLength, j4, getPercentDownloaded());
        }

        public void onSegmentDownloaded() {
            this.segmentsDownloaded++;
            this.progressListener.onProgress(this.contentLength, this.bytesDownloaded, getPercentDownloaded());
        }
    }
}
