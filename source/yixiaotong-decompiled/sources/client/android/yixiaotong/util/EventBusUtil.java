package client.android.yixiaotong.util;

import de.greenrobot.event.EventBus;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class EventBusUtil {
    private EventBus mCommonEventBus;
    private EventBus mMessageEventBus;

    /* JADX INFO: renamed from: client.android.yixiaotong.util.EventBusUtil$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public EventBus getCommonEventBus() {
        return this.mCommonEventBus;
    }

    public EventBus getMessageEventBus() {
        return this.mMessageEventBus;
    }

    /* synthetic */ EventBusUtil(AnonymousClass1 anonymousClass1) {
        this();
    }

    private EventBusUtil() {
        this.mMessageEventBus = new EventBus();
        this.mCommonEventBus = EventBus.getDefault();
    }

    private static class SingletonHolder {
        public static final EventBusUtil INSTANCE = new EventBusUtil(null);

        private SingletonHolder() {
        }
    }

    public static EventBusUtil getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public EventBus newEventBus() {
        return new EventBus();
    }
}
