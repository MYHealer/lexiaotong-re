package com.google.common.eventbus;

import androidx.core.app.NotificationCompat;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.huawei.openalliance.ad.constant.ba;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
@ElementTypesAreNonnullByDefault
public class DeadEvent {
    private final Object event;
    private final Object source;

    public Object getEvent() {
        return this.event;
    }

    public Object getSource() {
        return this.source;
    }

    public DeadEvent(Object obj, Object obj2) {
        this.source = Preconditions.checkNotNull(obj);
        this.event = Preconditions.checkNotNull(obj2);
    }

    public String toString() {
        return MoreObjects.toStringHelper(this).add(ba.at, this.source).add(NotificationCompat.CATEGORY_EVENT, this.event).toString();
    }
}
