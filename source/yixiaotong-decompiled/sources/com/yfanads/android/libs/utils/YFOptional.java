package com.yfanads.android.libs.utils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public final class YFOptional<T> {
    private static final YFOptional<?> EMPTY = new YFOptional<>();
    private final T value;

    @FunctionalInterface
    public interface Consumer<T> {
        void accept(T t);
    }

    private YFOptional() {
        this.value = null;
    }

    private YFOptional(T t) {
        this.value = t;
    }

    public static <T> YFOptional<T> empty() {
        return (YFOptional<T>) EMPTY;
    }

    public static <T> YFOptional<T> ofNullable(T t) {
        return t == null ? empty() : new YFOptional<>(t);
    }

    public void ifPresentOrElse(Consumer<? super T> consumer, Runnable runnable) {
        T t = this.value;
        if (t != null) {
            consumer.accept(t);
        } else {
            runnable.run();
        }
    }

    public void ifPresentRun(Consumer<? super T> consumer) {
        T t = this.value;
        if (t != null) {
            consumer.accept(t);
        }
    }

    public boolean isPresent() {
        return this.value != null;
    }
}
