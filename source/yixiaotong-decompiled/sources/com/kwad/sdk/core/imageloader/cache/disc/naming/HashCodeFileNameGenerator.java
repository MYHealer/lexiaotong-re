package com.kwad.sdk.core.imageloader.cache.disc.naming;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class HashCodeFileNameGenerator implements FileNameGenerator {
    @Override // com.kwad.sdk.core.imageloader.cache.disc.naming.FileNameGenerator
    public String generate(String str) {
        return String.valueOf(str.hashCode());
    }
}
