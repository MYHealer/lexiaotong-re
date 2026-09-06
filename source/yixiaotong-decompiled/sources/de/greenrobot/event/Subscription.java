package de.greenrobot.event;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
final class Subscription {
    volatile boolean active = true;
    final int priority;
    final Object subscriber;
    final SubscriberMethod subscriberMethod;

    Subscription(Object obj, SubscriberMethod subscriberMethod, int i) {
        this.subscriber = obj;
        this.subscriberMethod = subscriberMethod;
        this.priority = i;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Subscription)) {
            return false;
        }
        Subscription subscription = (Subscription) obj;
        return this.subscriber == subscription.subscriber && this.subscriberMethod.equals(subscription.subscriberMethod);
    }

    public int hashCode() {
        return this.subscriber.hashCode() + this.subscriberMethod.methodString.hashCode();
    }
}
