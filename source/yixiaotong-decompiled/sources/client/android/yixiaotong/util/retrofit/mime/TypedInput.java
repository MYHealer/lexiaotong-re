package client.android.yixiaotong.util.retrofit.mime;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public interface TypedInput {
    InputStream in() throws IOException;

    long length();

    String mimeType();
}
