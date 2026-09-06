package com.huawei.hms.common.util;

import com.huawei.hms.common.Preconditions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class Objects {

    public static final class ToStringHelper {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<String> f3994a;
        public final Object b;

        public ToStringHelper(Object obj) {
            this.b = Preconditions.checkNotNull(obj);
            this.f3994a = new ArrayList();
        }

        public /* synthetic */ ToStringHelper(Object obj, a aVar) {
            this(obj);
        }

        public ToStringHelper add(String str, Object obj) {
            this.f3994a.add(((String) Preconditions.checkNotNull(str)) + "=" + String.valueOf(obj));
            return this;
        }

        public String toString() {
            StringBuilder sbAppend = new StringBuilder(100).append(this.b.getClass().getSimpleName()).append('{');
            int size = this.f3994a.size();
            for (int i = 0; i < size; i++) {
                sbAppend.append(this.f3994a.get(i));
                if (i < size - 1) {
                    sbAppend.append(", ");
                }
            }
            return sbAppend.append('}').toString();
        }
    }

    public static /* synthetic */ class a {
    }

    public Objects() {
        throw new AssertionError("illegal argument");
    }

    public static boolean equal(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static int hashCode(Object... objArr) {
        return Arrays.hashCode(objArr);
    }

    public static ToStringHelper toStringHelper(Object obj) {
        return new ToStringHelper(obj, null);
    }
}
