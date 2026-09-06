package client.android.yixiaotong.util.retrofit;

import client.android.yixiaotong.util.retrofit.mime.TypedInput;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
class ExceptionCatchingTypedInput implements TypedInput {
    private final TypedInput delegate;
    private final ExceptionCatchingInputStream delegateStream;

    @Override // client.android.yixiaotong.util.retrofit.mime.TypedInput
    public InputStream in() throws IOException {
        return this.delegateStream;
    }

    ExceptionCatchingTypedInput(TypedInput typedInput) throws IOException {
        this.delegate = typedInput;
        this.delegateStream = new ExceptionCatchingInputStream(typedInput.in());
    }

    @Override // client.android.yixiaotong.util.retrofit.mime.TypedInput
    public String mimeType() {
        return this.delegate.mimeType();
    }

    @Override // client.android.yixiaotong.util.retrofit.mime.TypedInput
    public long length() {
        return this.delegate.length();
    }

    IOException getThrownException() {
        return this.delegateStream.thrownException;
    }

    boolean threwException() {
        return this.delegateStream.thrownException != null;
    }

    private static class ExceptionCatchingInputStream extends InputStream {
        private final InputStream delegate;
        private IOException thrownException;

        ExceptionCatchingInputStream(InputStream inputStream) {
            this.delegate = inputStream;
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            try {
                return this.delegate.read();
            } catch (IOException e) {
                this.thrownException = e;
                throw e;
            }
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr) throws IOException {
            try {
                return this.delegate.read(bArr);
            } catch (IOException e) {
                this.thrownException = e;
                throw e;
            }
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) throws IOException {
            try {
                return this.delegate.read(bArr, i, i2);
            } catch (IOException e) {
                this.thrownException = e;
                throw e;
            }
        }

        @Override // java.io.InputStream
        public long skip(long j) throws IOException {
            try {
                return this.delegate.skip(j);
            } catch (IOException e) {
                this.thrownException = e;
                throw e;
            }
        }

        @Override // java.io.InputStream
        public int available() throws IOException {
            try {
                return this.delegate.available();
            } catch (IOException e) {
                this.thrownException = e;
                throw e;
            }
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            try {
                this.delegate.close();
            } catch (IOException e) {
                this.thrownException = e;
                throw e;
            }
        }

        @Override // java.io.InputStream
        public synchronized void mark(int i) {
            this.delegate.mark(i);
        }

        @Override // java.io.InputStream
        public synchronized void reset() throws IOException {
            try {
                this.delegate.reset();
            } catch (IOException e) {
                this.thrownException = e;
                throw e;
            }
        }

        @Override // java.io.InputStream
        public boolean markSupported() {
            return this.delegate.markSupported();
        }
    }
}
