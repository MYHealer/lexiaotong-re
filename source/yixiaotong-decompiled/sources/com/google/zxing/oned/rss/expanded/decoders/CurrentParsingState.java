package com.google.zxing.oned.rss.expanded.decoders;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
final class CurrentParsingState {
    private int position = 0;
    private State encoding = State.NUMERIC;

    private enum State {
        NUMERIC,
        ALPHA,
        ISO_IEC_646;

        /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
        public static State[] valuesCustom() {
            State[] stateArrValuesCustom = values();
            int length = stateArrValuesCustom.length;
            State[] stateArr = new State[length];
            System.arraycopy(stateArrValuesCustom, 0, stateArr, 0, length);
            return stateArr;
        }
    }

    int getPosition() {
        return this.position;
    }

    void incrementPosition(int i) {
        this.position += i;
    }

    void setPosition(int i) {
        this.position = i;
    }

    CurrentParsingState() {
    }

    boolean isAlpha() {
        return this.encoding == State.ALPHA;
    }

    boolean isNumeric() {
        return this.encoding == State.NUMERIC;
    }

    boolean isIsoIec646() {
        return this.encoding == State.ISO_IEC_646;
    }

    void setNumeric() {
        this.encoding = State.NUMERIC;
    }

    void setAlpha() {
        this.encoding = State.ALPHA;
    }

    void setIsoIec646() {
        this.encoding = State.ISO_IEC_646;
    }
}
