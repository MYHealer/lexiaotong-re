package com.kwad.sdk.pngencrypt;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public abstract class ChunkReader implements f {
    public final ChunkReaderMode bjt;
    private final com.kwad.sdk.pngencrypt.chunk.d bju;
    private boolean bjx;
    protected int bjv = 0;
    private int bjw = 0;
    protected ErrorBehaviour bjy = ErrorBehaviour.STRICT;

    public enum ChunkReaderMode {
        BUFFER,
        PROCESS,
        SKIP
    }

    public final com.kwad.sdk.pngencrypt.chunk.d SD() {
        return this.bju;
    }

    protected abstract void SE();

    protected abstract void a(int i, byte[] bArr, int i2, int i3);

    public final void ci(boolean z) {
        this.bjx = false;
    }

    @Override // com.kwad.sdk.pngencrypt.f
    public final boolean isDone() {
        return this.bjw == 4;
    }

    public ChunkReader(int i, String str, long j, ChunkReaderMode chunkReaderMode) {
        if (chunkReaderMode == null || str.length() != 4 || i < 0) {
            new PngjException("Bad chunk paramenters: " + chunkReaderMode);
        }
        this.bjt = chunkReaderMode;
        com.kwad.sdk.pngencrypt.chunk.d dVar = new com.kwad.sdk.pngencrypt.chunk.d(i, str, chunkReaderMode == ChunkReaderMode.BUFFER);
        this.bju = dVar;
        dVar.aZ(j);
        this.bjx = chunkReaderMode != ChunkReaderMode.SKIP;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.kwad.sdk.pngencrypt.f
    public final int a(byte[] bArr, int i, int i2) {
        int i3 = 0;
        if (i2 == 0) {
            return 0;
        }
        if (i2 < 0) {
            new PngjException("negative length??");
        }
        if (this.bjv == 0 && this.bjw == 0 && this.bjx) {
            com.kwad.sdk.pngencrypt.chunk.d dVar = this.bju;
            dVar.e(dVar.blB, 0, 4);
        }
        int i4 = this.bju.len - this.bjv;
        if (i4 > i2) {
            i4 = i2;
        }
        if (i4 > 0 || this.bjw == 0) {
            if (this.bjx && this.bjt != ChunkReaderMode.BUFFER && i4 > 0) {
                this.bju.e(bArr, i, i4);
            }
            if (this.bjt == ChunkReaderMode.BUFFER) {
                if (this.bju.data != bArr && i4 > 0) {
                    System.arraycopy(bArr, i, this.bju.data, this.bjv, i4);
                }
            } else if (this.bjt == ChunkReaderMode.PROCESS) {
                a(this.bjv, bArr, i, i4);
            }
            this.bjv += i4;
            i += i4;
            i2 -= i4;
        }
        if (this.bjv == this.bju.len) {
            int i5 = 4 - this.bjw;
            if (i5 <= i2) {
                i2 = i5;
            }
            if (i2 > 0) {
                if (bArr != this.bju.blD) {
                    System.arraycopy(bArr, i, this.bju.blD, this.bjw, i2);
                }
                int i6 = this.bjw + i2;
                this.bjw = i6;
                if (i6 == 4) {
                    if (this.bjx) {
                        if (this.bjt == ChunkReaderMode.BUFFER) {
                            com.kwad.sdk.pngencrypt.chunk.d dVar2 = this.bju;
                            dVar2.e(dVar2.data, 0, this.bju.len);
                        }
                        this.bju.ck(this.bjy == ErrorBehaviour.STRICT);
                    }
                    SE();
                }
            }
            i3 = i2;
        }
        if (i4 > 0 || i3 > 0) {
            return i4 + i3;
        }
        return -1;
    }

    public int hashCode() {
        com.kwad.sdk.pngencrypt.chunk.d dVar = this.bju;
        return (dVar == null ? 0 : dVar.hashCode()) + 31;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ChunkReader chunkReader = (ChunkReader) obj;
        com.kwad.sdk.pngencrypt.chunk.d dVar = this.bju;
        if (dVar == null) {
            if (chunkReader.bju != null) {
                return false;
            }
        } else if (!dVar.equals(chunkReader.bju)) {
            return false;
        }
        return true;
    }

    public String toString() {
        return this.bju.toString();
    }
}
