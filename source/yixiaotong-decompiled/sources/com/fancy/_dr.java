package com.fancy;

import com.fancy._fs._c;
import com.kuaishou.weapon.p0.t;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _dr implements _az {
    public final _cc _a;
    public File _b;
    public RandomAccessFile _c;

    public _dr(File file, _cc _ccVar) throws _i3 {
        try {
            if (_ccVar == null) {
                throw new NullPointerException();
            }
            this._a = _ccVar;
            _dt._a(file.getParentFile());
            boolean zExists = file.exists();
            this._b = zExists ? file : new File(file.getParentFile(), file.getName() + ".download");
            this._c = new RandomAccessFile(this._b, zExists ? t.k : "rw");
        } catch (IOException e) {
            throw new _i3("Error using file " + file + " as disc cache", e);
        }
    }

    @Override // com.fancy._az
    public final synchronized int _a(byte[] bArr, long j) {
        try {
            this._c.seek(j);
        } catch (IOException e) {
            throw new _i3(String.format("Error reading %d bytes with offset %d from file[%d bytes] to buffer[%d bytes]", 8192, Long.valueOf(j), Long.valueOf(available()), Integer.valueOf(bArr.length)), e);
        }
        return this._c.read(bArr, 0, 8192);
    }

    @Override // com.fancy._az
    public final synchronized void _a() {
        if (_b()) {
            return;
        }
        close();
        File file = new File(this._b.getParentFile(), this._b.getName().substring(0, this._b.getName().length() - 9));
        if (!this._b.renameTo(file)) {
            throw new _i3(_ie._a("Error renaming file ").append(this._b).append(" to ").append(file).append(" for completion!").toString());
        }
        this._b = file;
        try {
            this._c = new RandomAccessFile(this._b, t.k);
            _cc _ccVar = this._a;
            File file2 = this._b;
            _fs _fsVar = (_fs) _ccVar;
            _fsVar.getClass();
            _fs._a.submit(_fsVar.new _c(file2));
        } catch (IOException e) {
            throw new _i3(_ie._a("Error opening ").append(this._b).append(" as disc cache").toString(), e);
        }
    }

    @Override // com.fancy._az
    public final synchronized void _a(int i, byte[] bArr) {
        try {
            if (_b()) {
                throw new _i3("Error append cache: cache file " + this._b + " is completed!");
            }
            this._c.seek(available());
            this._c.write(bArr, 0, i);
        } catch (IOException e) {
            throw new _i3(String.format("Error writing %d bytes to %s from buffer with size %d", Integer.valueOf(i), this._c, Integer.valueOf(bArr.length)), e);
        }
    }

    @Override // com.fancy._az
    public final synchronized boolean _b() {
        return !this._b.getName().endsWith(".download");
    }

    @Override // com.fancy._az
    public final synchronized long available() {
        try {
        } catch (IOException e) {
            throw new _i3(_ie._a("Error reading length of file ").append(this._b).toString(), e);
        }
        return (int) this._c.length();
    }

    @Override // com.fancy._az
    public final synchronized void close() {
        try {
            this._c.close();
            _cc _ccVar = this._a;
            File file = this._b;
            _fs _fsVar = (_fs) _ccVar;
            _fsVar.getClass();
            _fs._a.submit(_fsVar.new _c(file));
        } catch (IOException e) {
            throw new _i3(_ie._a("Error closing file ").append(this._b).toString(), e);
        }
    }
}
