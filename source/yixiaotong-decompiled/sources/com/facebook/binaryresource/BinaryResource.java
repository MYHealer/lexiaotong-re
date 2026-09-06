package com.facebook.binaryresource;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public interface BinaryResource {
    InputStream openStream() throws IOException;

    byte[] read() throws IOException;

    long size();
}
