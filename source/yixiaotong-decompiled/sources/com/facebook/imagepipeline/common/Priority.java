package com.facebook.imagepipeline.common;

import javax.annotation.Nullable;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public enum Priority {
    LOW,
    MEDIUM,
    HIGH;

    public static Priority getHigherPriority(@Nullable Priority priority, @Nullable Priority priority2) {
        if (priority == null) {
            return priority2;
        }
        return (priority2 != null && priority.ordinal() <= priority2.ordinal()) ? priority2 : priority;
    }
}
