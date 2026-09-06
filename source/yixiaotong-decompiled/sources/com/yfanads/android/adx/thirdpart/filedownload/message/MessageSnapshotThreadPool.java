package com.yfanads.android.adx.thirdpart.filedownload.message;

import com.yfanads.android.adx.thirdpart.filedownload.util.FileDownloadExecutors;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class MessageSnapshotThreadPool {
    private final List<FlowSingleExecutor> executorList = new ArrayList();
    private final MessageSnapshotFlow.MessageReceiver receiver;

    public class FlowSingleExecutor {
        private final List<Integer> enQueueTaskIdList = new ArrayList();
        private final Executor mExecutor;

        public FlowSingleExecutor(int i) {
            this.mExecutor = FileDownloadExecutors.newDefaultThreadPool(1, "Flow-" + i);
        }

        public void enqueue(int i) {
            this.enQueueTaskIdList.add(Integer.valueOf(i));
        }

        public void execute(final MessageSnapshot messageSnapshot) {
            this.mExecutor.execute(new Runnable() { // from class: com.yfanads.android.adx.thirdpart.filedownload.message.MessageSnapshotThreadPool.FlowSingleExecutor.1
                @Override // java.lang.Runnable
                public void run() {
                    MessageSnapshotThreadPool.this.receiver.receive(messageSnapshot);
                    FlowSingleExecutor.this.enQueueTaskIdList.remove(Integer.valueOf(messageSnapshot.getId()));
                }
            });
        }
    }

    public MessageSnapshotThreadPool(int i, MessageSnapshotFlow.MessageReceiver messageReceiver) {
        this.receiver = messageReceiver;
        for (int i2 = 0; i2 < i; i2++) {
            this.executorList.add(new FlowSingleExecutor(i2));
        }
    }

    public void execute(MessageSnapshot messageSnapshot) {
        FlowSingleExecutor flowSingleExecutor = null;
        try {
            synchronized (this.executorList) {
                int id = messageSnapshot.getId();
                for (FlowSingleExecutor flowSingleExecutor2 : this.executorList) {
                    if (flowSingleExecutor2.enQueueTaskIdList.contains(Integer.valueOf(id))) {
                        flowSingleExecutor = flowSingleExecutor2;
                        break;
                    }
                }
                if (flowSingleExecutor == null) {
                    int size = 0;
                    for (FlowSingleExecutor flowSingleExecutor3 : this.executorList) {
                        if (flowSingleExecutor3.enQueueTaskIdList.size() <= 0) {
                            flowSingleExecutor = flowSingleExecutor3;
                            break;
                        } else if (size == 0 || flowSingleExecutor3.enQueueTaskIdList.size() < size) {
                            size = flowSingleExecutor3.enQueueTaskIdList.size();
                            flowSingleExecutor = flowSingleExecutor3;
                        }
                    }
                }
                flowSingleExecutor.enqueue(id);
            }
            flowSingleExecutor.execute(messageSnapshot);
        } catch (Throwable th) {
            flowSingleExecutor.execute(messageSnapshot);
            throw th;
        }
    }
}
