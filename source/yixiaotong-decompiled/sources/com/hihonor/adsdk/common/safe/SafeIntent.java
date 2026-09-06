package com.hihonor.adsdk.common.safe;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import java.io.Serializable;
import java.util.ArrayList;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class SafeIntent extends Intent {
    private static final String TAG = "SafeIntent";

    public SafeIntent(Intent intent) {
        super(intent == null ? new Intent() : intent);
    }

    @Override // android.content.Intent
    public String getAction() {
        try {
            return super.getAction();
        } catch (Throwable th) {
            hnadsa("getAction", th);
            return "";
        }
    }

    @Override // android.content.Intent
    public boolean[] getBooleanArrayExtra(String str) {
        try {
            return super.getBooleanArrayExtra(str);
        } catch (Throwable th) {
            hnadsa("getBooleanArrayExtra", th);
            return new boolean[0];
        }
    }

    @Override // android.content.Intent
    public boolean getBooleanExtra(String str, boolean z) {
        try {
            return super.getBooleanExtra(str, z);
        } catch (Throwable th) {
            hnadsa("getBooleanExtra", th);
            return z;
        }
    }

    @Override // android.content.Intent
    public Bundle getBundleExtra(String str) {
        try {
            return super.getBundleExtra(str);
        } catch (Throwable th) {
            hnadsa("getBundleExtra", th);
            return new Bundle();
        }
    }

    @Override // android.content.Intent
    public byte[] getByteArrayExtra(String str) {
        try {
            return super.getByteArrayExtra(str);
        } catch (Throwable th) {
            hnadsa("getByteArrayExtra", th);
            return new byte[0];
        }
    }

    @Override // android.content.Intent
    public byte getByteExtra(String str, byte b) {
        try {
            return super.getByteExtra(str, b);
        } catch (Throwable th) {
            hnadsa("getByteExtra", th);
            return b;
        }
    }

    @Override // android.content.Intent
    public char[] getCharArrayExtra(String str) {
        try {
            return super.getCharArrayExtra(str);
        } catch (Throwable th) {
            hnadsa("getCharArrayExtra", th);
            return new char[0];
        }
    }

    @Override // android.content.Intent
    public char getCharExtra(String str, char c) {
        try {
            return super.getCharExtra(str, c);
        } catch (Throwable th) {
            hnadsa("getCharExtra", th);
            return c;
        }
    }

    @Override // android.content.Intent
    public CharSequence[] getCharSequenceArrayExtra(String str) {
        try {
            return super.getCharSequenceArrayExtra(str);
        } catch (Throwable th) {
            hnadsa("getCharSequenceArrayExtra", th);
            return new CharSequence[0];
        }
    }

    @Override // android.content.Intent
    public ArrayList<CharSequence> getCharSequenceArrayListExtra(String str) {
        try {
            return super.getCharSequenceArrayListExtra(str);
        } catch (Throwable th) {
            hnadsa("getCharSequenceArrayListExtra", th);
            return new ArrayList<>();
        }
    }

    @Override // android.content.Intent
    public CharSequence getCharSequenceExtra(String str) {
        try {
            return super.getCharSequenceExtra(str);
        } catch (Throwable th) {
            hnadsa("getCharSequenceExtra", th);
            return "";
        }
    }

    @Override // android.content.Intent
    public double[] getDoubleArrayExtra(String str) {
        try {
            return super.getDoubleArrayExtra(str);
        } catch (Throwable th) {
            hnadsa("getDoubleArrayExtra", th);
            return new double[0];
        }
    }

    @Override // android.content.Intent
    public double getDoubleExtra(String str, double d) {
        try {
            return super.getDoubleExtra(str, d);
        } catch (Throwable th) {
            hnadsa("getDoubleExtra", th);
            return d;
        }
    }

    @Override // android.content.Intent
    public Bundle getExtras() {
        try {
            return super.getExtras();
        } catch (Throwable th) {
            hnadsa("getExtras", th);
            return new Bundle();
        }
    }

    @Override // android.content.Intent
    public float[] getFloatArrayExtra(String str) {
        try {
            return super.getFloatArrayExtra(str);
        } catch (Throwable th) {
            hnadsa("getFloatArrayExtra", th);
            return new float[0];
        }
    }

    @Override // android.content.Intent
    public float getFloatExtra(String str, float f) {
        try {
            return super.getFloatExtra(str, f);
        } catch (Throwable th) {
            hnadsa("getFloatExtra", th);
            return f;
        }
    }

    @Override // android.content.Intent
    public int[] getIntArrayExtra(String str) {
        try {
            return super.getIntArrayExtra(str);
        } catch (Throwable th) {
            hnadsa("getIntArrayExtra", th);
            return new int[0];
        }
    }

    @Override // android.content.Intent
    public int getIntExtra(String str, int i) {
        try {
            return super.getIntExtra(str, i);
        } catch (Throwable th) {
            hnadsa("getIntExtra", th);
            return i;
        }
    }

    @Override // android.content.Intent
    public ArrayList<Integer> getIntegerArrayListExtra(String str) {
        try {
            return super.getIntegerArrayListExtra(str);
        } catch (Throwable th) {
            hnadsa("getIntegerArrayListExtra", th);
            return new ArrayList<>();
        }
    }

    @Override // android.content.Intent
    public long[] getLongArrayExtra(String str) {
        try {
            return super.getLongArrayExtra(str);
        } catch (Throwable th) {
            hnadsa("getLongArrayExtra", th);
            return new long[0];
        }
    }

    @Override // android.content.Intent
    public long getLongExtra(String str, long j) {
        try {
            return super.getLongExtra(str, j);
        } catch (Throwable th) {
            hnadsa("getLongExtra", th);
            return j;
        }
    }

    @Override // android.content.Intent
    public Parcelable[] getParcelableArrayExtra(String str) {
        try {
            return super.getParcelableArrayExtra(str);
        } catch (Throwable th) {
            hnadsa("getParcelableArrayExtra", th);
            return new Parcelable[0];
        }
    }

    @Override // android.content.Intent
    public <T extends Parcelable> ArrayList<T> getParcelableArrayListExtra(String str) {
        try {
            return super.getParcelableArrayListExtra(str);
        } catch (Throwable th) {
            hnadsa("getParcelableArrayListExtra", th);
            return null;
        }
    }

    @Override // android.content.Intent
    public <T extends Parcelable> T getParcelableExtra(String str) {
        try {
            return (T) super.getParcelableExtra(str);
        } catch (Exception e) {
            hnadsa("getParcelableExtra", e);
            return null;
        }
    }

    @Override // android.content.Intent
    public Serializable getSerializableExtra(String str) {
        try {
            return super.getSerializableExtra(str);
        } catch (Throwable th) {
            hnadsa("getSerializableExtra", th);
            return null;
        }
    }

    @Override // android.content.Intent
    public short[] getShortArrayExtra(String str) {
        try {
            return super.getShortArrayExtra(str);
        } catch (Throwable th) {
            hnadsa("getShortArrayExtra", th);
            return new short[0];
        }
    }

    @Override // android.content.Intent
    public short getShortExtra(String str, short s) {
        try {
            return super.getShortExtra(str, s);
        } catch (Throwable th) {
            hnadsa("getShortExtra", th);
            return s;
        }
    }

    @Override // android.content.Intent
    public String[] getStringArrayExtra(String str) {
        try {
            return super.getStringArrayExtra(str);
        } catch (Throwable th) {
            hnadsa("getStringArrayExtra", th);
            return new String[0];
        }
    }

    @Override // android.content.Intent
    public ArrayList<String> getStringArrayListExtra(String str) {
        try {
            return super.getStringArrayListExtra(str);
        } catch (Throwable th) {
            hnadsa("getStringArrayListExtra", th);
            return new ArrayList<>();
        }
    }

    @Override // android.content.Intent
    public String getStringExtra(String str) {
        try {
            return super.getStringExtra(str);
        } catch (Throwable th) {
            hnadsa("getStringExtra", th);
            return "";
        }
    }

    @Override // android.content.Intent
    public boolean hasExtra(String str) {
        try {
            return super.hasExtra(str);
        } catch (Throwable th) {
            hnadsa("hasExtra", th);
            return false;
        }
    }

    public String hnadsa(String str, String str2) {
        try {
            return TextUtils.isEmpty(super.getStringExtra(str)) ? str2 : super.getStringExtra(str);
        } catch (Throwable th) {
            hnadsa("getStringExtra", th);
            return str2;
        }
    }

    private void hnadsa(String str, Throwable th) {
        com.hihonor.adsdk.common.b.b.hnadsb(TAG, str + " msg: " + th.getMessage(), new Object[0]);
    }
}
