package com.kwad.framework.filedownloader.message;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public interface a {
    MessageSnapshot CJ();

    /* JADX INFO: renamed from: com.kwad.framework.filedownloader.message.a$a, reason: collision with other inner class name */
    public static class C0719a extends MessageSnapshot implements a {
        private final MessageSnapshot aCs;

        @Override // com.kwad.framework.filedownloader.message.c
        public final byte AH() {
            return (byte) 4;
        }

        @Override // com.kwad.framework.filedownloader.message.a
        public final MessageSnapshot CJ() {
            return this.aCs;
        }

        public C0719a(MessageSnapshot messageSnapshot) {
            super(messageSnapshot.getId());
            if (messageSnapshot.AH() != -3) {
                throw new IllegalArgumentException(com.kwad.framework.filedownloader.f.f.c("can't create the block complete message for id[%d], status[%d]", Integer.valueOf(messageSnapshot.getId()), Byte.valueOf(messageSnapshot.AH())));
            }
            this.aCs = messageSnapshot;
        }
    }
}
