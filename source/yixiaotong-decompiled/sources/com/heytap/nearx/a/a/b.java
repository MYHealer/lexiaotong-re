package com.heytap.nearx.a.a;

import com.heytap.nearx.a.a.b;
import com.heytap.nearx.a.a.b.a;
import java.io.IOException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import okio.Buffer;
import okio.ByteString;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public abstract class b<M extends b<M, B>, B extends a<M, B>> implements Serializable {
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    transient int f3484a = 0;
    protected transient int b = 0;
    private final transient e<M> c;
    private final transient ByteString d;

    public static abstract class a<T extends b<T, B>, B extends a<T, B>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Buffer f3485a;
        g b;

        protected a() {
        }

        public final a<T, B> a(int i, com.heytap.nearx.a.a.a aVar, Object obj) {
            if (this.b == null) {
                this.f3485a = new Buffer();
                this.b = new g(this.f3485a);
            }
            try {
                aVar.a().a(this.b, i, obj);
                return this;
            } catch (IOException unused) {
                throw new AssertionError();
            }
        }

        public final a<T, B> a(ByteString byteString) {
            if (byteString.size() > 0) {
                if (this.b == null) {
                    this.f3485a = new Buffer();
                    this.b = new g(this.f3485a);
                }
                try {
                    this.b.a(byteString);
                } catch (IOException unused) {
                    throw new AssertionError();
                }
            }
            return this;
        }

        public final ByteString a() {
            Buffer buffer = this.f3485a;
            return buffer != null ? buffer.clone().readByteString() : ByteString.EMPTY;
        }
    }

    protected b(e<M> eVar, ByteString byteString) {
        if (eVar == null) {
            throw new NullPointerException("adapter == null");
        }
        if (byteString == null) {
            throw new NullPointerException("unknownFields == null");
        }
        this.c = eVar;
        this.d = byteString;
    }

    public final ByteString a() {
        ByteString byteString = this.d;
        return byteString != null ? byteString : ByteString.EMPTY;
    }

    public final byte[] b() {
        return this.c.b(this);
    }

    public String toString() {
        return this.c.c(this);
    }

    protected final Object writeReplace() throws ObjectStreamException {
        return new c(b(), getClass());
    }
}
