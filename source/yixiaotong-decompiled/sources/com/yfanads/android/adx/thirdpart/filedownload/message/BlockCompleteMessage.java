package com.yfanads.android.adx.thirdpart.filedownload.message;

import com.yfanads.android.adx.thirdpart.filedownload.util.FileDownloadUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public interface BlockCompleteMessage {

    public static class BlockCompleteMessageImpl extends MessageSnapshot implements BlockCompleteMessage {
        private final MessageSnapshot mCompletedSnapshot;

        public BlockCompleteMessageImpl(MessageSnapshot messageSnapshot) {
            super(messageSnapshot.getId());
            if (messageSnapshot.getStatus() != -3) {
                throw new IllegalArgumentException(FileDownloadUtils.formatString("can't create the block complete message for id[%d], status[%d]", Integer.valueOf(messageSnapshot.getId()), Byte.valueOf(messageSnapshot.getStatus())));
            }
            this.mCompletedSnapshot = messageSnapshot;
        }

        @Override // com.yfanads.android.adx.thirdpart.filedownload.message.MessageSnapshot, com.yfanads.android.adx.thirdpart.filedownload.message.IMessageSnapshot
        public byte getStatus() {
            return (byte) 4;
        }

        @Override // com.yfanads.android.adx.thirdpart.filedownload.message.BlockCompleteMessage
        public MessageSnapshot transmitToCompleted() {
            return this.mCompletedSnapshot;
        }
    }

    MessageSnapshot transmitToCompleted();
}
