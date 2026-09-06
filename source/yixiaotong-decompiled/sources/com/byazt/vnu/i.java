package com.byazt.vnu;

import com.google.common.base.Ascii;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FilterInputStream;
import java.io.IOException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 699, 42})
public final class i extends FilterInputStream implements DataInput {
    public static int c(byte b, byte b2, byte b3, byte b4) {
        return (b << Ascii.CAN) | ((b2 & 255) << 16) | ((b3 & 255) << 8) | (b4 & 255);
    }

    public static long c(byte b, byte b2, byte b3, byte b4, byte b5, byte b6, byte b7, byte b8) {
        return ((((long) b2) & 255) << 48) | ((((long) b) & 255) << 56) | ((((long) b3) & 255) << 40) | ((((long) b4) & 255) << 32) | ((((long) b5) & 255) << 24) | ((((long) b6) & 255) << 16) | ((((long) b7) & 255) << 8) | (((long) b8) & 255);
    }

    public i(n nVar) {
        super(nVar);
    }

    @Override // java.io.DataInput
    public String readLine() {
        throw new UnsupportedOperationException("readLine is not supported");
    }

    @Override // java.io.DataInput
    public void readFully(byte[] bArr) throws IOException {
        uj.c(this, bArr);
    }

    @Override // java.io.DataInput
    public void readFully(byte[] bArr, int i, int i2) throws IOException {
        uj.c(this, bArr, i, i2);
    }

    @Override // java.io.DataInput
    public int skipBytes(int i) throws IOException {
        return (int) this.in.skip(i);
    }

    @Override // java.io.DataInput
    public int readUnsignedByte() throws IOException {
        int i = this.in.read();
        if (i >= 0) {
            return i;
        }
        throw new EOFException();
    }

    @Override // java.io.DataInput
    public int readUnsignedShort() throws IOException {
        return c((byte) 0, (byte) 0, tt(), tt());
    }

    @Override // java.io.DataInput
    public int readInt() throws IOException {
        byte bTt = tt();
        byte bTt2 = tt();
        return c(tt(), tt(), bTt2, bTt);
    }

    @Override // java.io.DataInput
    public long readLong() throws IOException {
        byte bTt = tt();
        byte bTt2 = tt();
        byte bTt3 = tt();
        byte bTt4 = tt();
        byte bTt5 = tt();
        byte bTt6 = tt();
        return c(tt(), tt(), bTt6, bTt5, bTt4, bTt3, bTt2, bTt);
    }

    @Override // java.io.DataInput
    public float readFloat() throws IOException {
        return Float.intBitsToFloat(readInt());
    }

    @Override // java.io.DataInput
    public double readDouble() throws IOException {
        return Double.longBitsToDouble(readLong());
    }

    @Override // java.io.DataInput
    public String readUTF() throws IOException {
        return new DataInputStream(this.in).readUTF();
    }

    @Override // java.io.DataInput
    public short readShort() throws IOException {
        return (short) readUnsignedShort();
    }

    @Override // java.io.DataInput
    public char readChar() throws IOException {
        return (char) readUnsignedShort();
    }

    @Override // java.io.DataInput
    public byte readByte() throws IOException {
        return (byte) readUnsignedByte();
    }

    @Override // java.io.DataInput
    public boolean readBoolean() throws IOException {
        return readUnsignedByte() != 0;
    }

    private byte tt() throws IOException {
        int i = this.in.read();
        if (-1 != i) {
            return (byte) i;
        }
        throw new EOFException();
    }

    public n c() {
        return (n) this.in;
    }
}
