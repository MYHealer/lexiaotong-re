package cz.msebera.android.httpclient.config;

import com.opos.acs.st.STManager;
import cz.msebera.android.httpclient.util.Args;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public final class RegistryBuilder<I> {
    private final Map<String, I> items = new HashMap();

    public static <I> RegistryBuilder<I> create() {
        return new RegistryBuilder<>();
    }

    RegistryBuilder() {
    }

    public RegistryBuilder<I> register(String str, I i) {
        Args.notEmpty(str, STManager.REGION_OF_ID);
        Args.notNull(i, "Item");
        this.items.put(str.toLowerCase(Locale.ENGLISH), i);
        return this;
    }

    public Registry<I> build() {
        return new Registry<>(this.items);
    }

    public String toString() {
        return this.items.toString();
    }
}
