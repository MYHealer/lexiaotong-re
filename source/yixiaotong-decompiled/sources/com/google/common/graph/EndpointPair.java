package com.google.common.graph;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.Iterators;
import com.google.common.collect.UnmodifiableIterator;
import com.google.errorprone.annotations.Immutable;
import com.j256.ormlite.stmt.query.SimpleComparison;
import java.util.Iterator;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
@Immutable(containerOf = {"N"})
@ElementTypesAreNonnullByDefault
public abstract class EndpointPair<N> implements Iterable<N> {
    private final N nodeU;
    private final N nodeV;

    /* JADX INFO: renamed from: com.google.common.graph.EndpointPair$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public abstract boolean equals(@CheckForNull Object obj);

    public abstract int hashCode();

    public abstract boolean isOrdered();

    public final N nodeU() {
        return this.nodeU;
    }

    public final N nodeV() {
        return this.nodeV;
    }

    public abstract N source();

    public abstract N target();

    /* synthetic */ EndpointPair(Object obj, Object obj2, AnonymousClass1 anonymousClass1) {
        this(obj, obj2);
    }

    private EndpointPair(N n, N n2) {
        this.nodeU = (N) Preconditions.checkNotNull(n);
        this.nodeV = (N) Preconditions.checkNotNull(n2);
    }

    public static <N> EndpointPair<N> ordered(N n, N n2) {
        return new Ordered(n, n2, null);
    }

    public static <N> EndpointPair<N> unordered(N n, N n2) {
        return new Unordered(n2, n, null);
    }

    static <N> EndpointPair<N> of(Graph<?> graph, N n, N n2) {
        return graph.isDirected() ? ordered(n, n2) : unordered(n, n2);
    }

    static <N> EndpointPair<N> of(Network<?, ?> network, N n, N n2) {
        return network.isDirected() ? ordered(n, n2) : unordered(n, n2);
    }

    public final N adjacentNode(N n) {
        if (n.equals(this.nodeU)) {
            return this.nodeV;
        }
        if (n.equals(this.nodeV)) {
            return this.nodeU;
        }
        String strValueOf = String.valueOf(this);
        String strValueOf2 = String.valueOf(n);
        throw new IllegalArgumentException(new StringBuilder(String.valueOf(strValueOf).length() + 36 + String.valueOf(strValueOf2).length()).append("EndpointPair ").append(strValueOf).append(" does not contain node ").append(strValueOf2).toString());
    }

    @Override // java.lang.Iterable
    public final UnmodifiableIterator<N> iterator() {
        return Iterators.forArray(this.nodeU, this.nodeV);
    }

    private static final class Ordered<N> extends EndpointPair<N> {
        @Override // com.google.common.graph.EndpointPair
        public boolean isOrdered() {
            return true;
        }

        /* synthetic */ Ordered(Object obj, Object obj2, AnonymousClass1 anonymousClass1) {
            this(obj, obj2);
        }

        @Override // com.google.common.graph.EndpointPair, java.lang.Iterable
        public /* bridge */ /* synthetic */ Iterator iterator() {
            return super.iterator();
        }

        private Ordered(N n, N n2) {
            super(n, n2, null);
        }

        @Override // com.google.common.graph.EndpointPair
        public N source() {
            return nodeU();
        }

        @Override // com.google.common.graph.EndpointPair
        public N target() {
            return nodeV();
        }

        @Override // com.google.common.graph.EndpointPair
        public boolean equals(@CheckForNull Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof EndpointPair)) {
                return false;
            }
            EndpointPair endpointPair = (EndpointPair) obj;
            if (isOrdered() != endpointPair.isOrdered()) {
                return false;
            }
            return source().equals(endpointPair.source()) && target().equals(endpointPair.target());
        }

        @Override // com.google.common.graph.EndpointPair
        public int hashCode() {
            return Objects.hashCode(source(), target());
        }

        public String toString() {
            String strValueOf = String.valueOf(source());
            String strValueOf2 = String.valueOf(target());
            return new StringBuilder(String.valueOf(strValueOf).length() + 6 + String.valueOf(strValueOf2).length()).append(SimpleComparison.LESS_THAN_OPERATION).append(strValueOf).append(" -> ").append(strValueOf2).append(SimpleComparison.GREATER_THAN_OPERATION).toString();
        }
    }

    private static final class Unordered<N> extends EndpointPair<N> {
        @Override // com.google.common.graph.EndpointPair
        public boolean isOrdered() {
            return false;
        }

        /* synthetic */ Unordered(Object obj, Object obj2, AnonymousClass1 anonymousClass1) {
            this(obj, obj2);
        }

        @Override // com.google.common.graph.EndpointPair, java.lang.Iterable
        public /* bridge */ /* synthetic */ Iterator iterator() {
            return super.iterator();
        }

        private Unordered(N n, N n2) {
            super(n, n2, null);
        }

        @Override // com.google.common.graph.EndpointPair
        public N source() {
            throw new UnsupportedOperationException("Cannot call source()/target() on a EndpointPair from an undirected graph. Consider calling adjacentNode(node) if you already have a node, or nodeU()/nodeV() if you don't.");
        }

        @Override // com.google.common.graph.EndpointPair
        public N target() {
            throw new UnsupportedOperationException("Cannot call source()/target() on a EndpointPair from an undirected graph. Consider calling adjacentNode(node) if you already have a node, or nodeU()/nodeV() if you don't.");
        }

        @Override // com.google.common.graph.EndpointPair
        public boolean equals(@CheckForNull Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof EndpointPair)) {
                return false;
            }
            EndpointPair endpointPair = (EndpointPair) obj;
            if (isOrdered() != endpointPair.isOrdered()) {
                return false;
            }
            if (nodeU().equals(endpointPair.nodeU())) {
                return nodeV().equals(endpointPair.nodeV());
            }
            return nodeU().equals(endpointPair.nodeV()) && nodeV().equals(endpointPair.nodeU());
        }

        @Override // com.google.common.graph.EndpointPair
        public int hashCode() {
            return nodeU().hashCode() + nodeV().hashCode();
        }

        public String toString() {
            String strValueOf = String.valueOf(nodeU());
            String strValueOf2 = String.valueOf(nodeV());
            return new StringBuilder(String.valueOf(strValueOf).length() + 4 + String.valueOf(strValueOf2).length()).append("[").append(strValueOf).append(", ").append(strValueOf2).append("]").toString();
        }
    }
}
