package com.yfanads.android.adx.newplayer.videocache;

import com.yfanads.android.adx.newplayer.videocache.file.DiskUsage;
import com.yfanads.android.adx.newplayer.videocache.file.FileNameGenerator;
import com.yfanads.android.adx.newplayer.videocache.headers.HeaderInjector;
import com.yfanads.android.adx.newplayer.videocache.sourcestorage.SourceInfoStorage;
import java.io.File;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
class Config {
    public final File cacheRoot;
    public final DiskUsage diskUsage;
    public final FileNameGenerator fileNameGenerator;
    public final HeaderInjector headerInjector;
    public final SourceInfoStorage sourceInfoStorage;

    public Config(File file, FileNameGenerator fileNameGenerator, DiskUsage diskUsage, SourceInfoStorage sourceInfoStorage, HeaderInjector headerInjector) {
        this.cacheRoot = file;
        this.fileNameGenerator = fileNameGenerator;
        this.diskUsage = diskUsage;
        this.sourceInfoStorage = sourceInfoStorage;
        this.headerInjector = headerInjector;
    }

    public File generateCacheFile(String str) {
        return new File(this.cacheRoot, this.fileNameGenerator.generate(str));
    }
}
