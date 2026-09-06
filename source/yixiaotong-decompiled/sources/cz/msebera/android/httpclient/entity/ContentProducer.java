package cz.msebera.android.httpclient.entity;

import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public interface ContentProducer {
    void writeTo(OutputStream outputStream) throws IOException;
}
