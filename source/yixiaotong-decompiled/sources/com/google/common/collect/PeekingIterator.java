package com.google.common.collect;

import com.google.errorprone.annotations.DoNotMock;
import java.util.Iterator;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
@DoNotMock("Use Iterators.peekingIterator")
@ElementTypesAreNonnullByDefault
public interface PeekingIterator<E> extends Iterator<E> {
    @Override // java.util.Iterator
    @ParametricNullness
    E next();

    @ParametricNullness
    E peek();

    @Override // java.util.Iterator
    void remove();
}
