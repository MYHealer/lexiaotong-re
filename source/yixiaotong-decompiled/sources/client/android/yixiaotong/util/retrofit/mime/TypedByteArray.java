package client.android.yixiaotong.util.retrofit.mime;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class TypedByteArray implements TypedInput, TypedOutput {
    private final byte[] bytes;
    private final String mimeType;

    @Override // client.android.yixiaotong.util.retrofit.mime.TypedOutput
    public String fileName() {
        return null;
    }

    public byte[] getBytes() {
        return this.bytes;
    }

    @Override // client.android.yixiaotong.util.retrofit.mime.TypedInput
    public String mimeType() {
        return this.mimeType;
    }

    public TypedByteArray(String str, byte[] bArr) {
        str = str == null ? "application/unknown" : str;
        if (bArr == null) {
            throw new NullPointerException("bytes");
        }
        this.mimeType = str;
        this.bytes = bArr;
    }

    @Override // client.android.yixiaotong.util.retrofit.mime.TypedInput
    public long length() {
        return this.bytes.length;
    }

    @Override // client.android.yixiaotong.util.retrofit.mime.TypedOutput
    public void writeTo(OutputStream outputStream) throws IOException {
        outputStream.write(this.bytes);
    }

    @Override // client.android.yixiaotong.util.retrofit.mime.TypedInput
    public InputStream in() throws IOException {
        return new ByteArrayInputStream(this.bytes);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        TypedByteArray typedByteArray = (TypedByteArray) obj;
        return Arrays.equals(this.bytes, typedByteArray.bytes) && this.mimeType.equals(typedByteArray.mimeType);
    }

    public int hashCode() {
        return (this.mimeType.hashCode() * 31) + Arrays.hashCode(this.bytes);
    }

    public String toString() {
        return "TypedByteArray[length=" + length() + "]";
    }
}
