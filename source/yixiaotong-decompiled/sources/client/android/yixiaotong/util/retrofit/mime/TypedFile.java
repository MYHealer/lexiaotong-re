package client.android.yixiaotong.util.retrofit.mime;

import com.facebook.common.util.UriUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class TypedFile implements TypedInput, TypedOutput {
    private static final int BUFFER_SIZE = 4096;
    private final File file;
    private final String mimeType;

    public File file() {
        return this.file;
    }

    @Override // client.android.yixiaotong.util.retrofit.mime.TypedInput
    public String mimeType() {
        return this.mimeType;
    }

    public TypedFile(String str, File file) {
        if (str == null) {
            throw new NullPointerException("mimeType");
        }
        if (file == null) {
            throw new NullPointerException(UriUtil.LOCAL_FILE_SCHEME);
        }
        this.mimeType = str;
        this.file = file;
    }

    @Override // client.android.yixiaotong.util.retrofit.mime.TypedInput
    public long length() {
        return this.file.length();
    }

    @Override // client.android.yixiaotong.util.retrofit.mime.TypedOutput
    public String fileName() {
        return this.file.getName();
    }

    @Override // client.android.yixiaotong.util.retrofit.mime.TypedInput
    public InputStream in() throws IOException {
        return new FileInputStream(this.file);
    }

    @Override // client.android.yixiaotong.util.retrofit.mime.TypedOutput
    public void writeTo(OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[4096];
        FileInputStream fileInputStream = new FileInputStream(this.file);
        while (true) {
            try {
                int i = fileInputStream.read(bArr);
                if (i != -1) {
                    outputStream.write(bArr, 0, i);
                } else {
                    fileInputStream.close();
                    return;
                }
            } catch (Throwable th) {
                fileInputStream.close();
                throw th;
            }
        }
    }

    public void moveTo(TypedFile typedFile) throws IOException {
        if (!mimeType().equals(typedFile.mimeType())) {
            throw new IOException("Type mismatch.");
        }
        if (!this.file.renameTo(typedFile.file())) {
            throw new IOException("Rename failed!");
        }
    }

    public String toString() {
        return this.file.getAbsolutePath() + " (" + mimeType() + ")";
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof TypedFile) {
            return this.file.equals(((TypedFile) obj).file);
        }
        return false;
    }

    public int hashCode() {
        return this.file.hashCode();
    }
}
