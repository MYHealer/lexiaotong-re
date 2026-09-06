package cz.msebera.android.httpclient.client.cache;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public interface Resource extends Serializable {
    void dispose();

    InputStream getInputStream() throws IOException;

    long length();
}
