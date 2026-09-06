package com.alibaba.fastjson.asm;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class ClassWriter {
    static final int ACC_SYNTHETIC_ATTRIBUTE = 262144;
    static final int CLASS = 7;
    public static final int COMPUTE_FRAMES = 2;
    public static final int COMPUTE_MAXS = 1;
    static final int DOUBLE = 6;
    static final int FIELD = 9;
    static final int FIELDORMETH_INSN = 6;
    static final int FLOAT = 4;
    static final int IINC_INSN = 12;
    static final int IMETH = 11;
    static final int IMPLVAR_INSN = 4;
    static final int INT = 3;
    static final int ITFDYNMETH_INSN = 7;
    static final int LABELW_INSN = 9;
    static final int LABEL_INSN = 8;
    static final int LDCW_INSN = 11;
    static final int LDC_INSN = 10;
    static final int LONG = 5;
    static final int LOOK_INSN = 14;
    static final int MANA_INSN = 15;
    static final int METH = 10;
    static final int NAME_TYPE = 12;
    static final int NOARG_INSN = 0;
    static final int SBYTE_INSN = 1;
    static final int SHORT_INSN = 2;
    static final int STR = 8;
    static final int TABL_INSN = 13;
    static final byte[] TYPE;
    static final int TYPE_INSN = 5;
    static final int TYPE_MERGED = 15;
    static final int TYPE_NORMAL = 13;
    static final int TYPE_UNINIT = 14;
    static final int UTF8 = 1;
    static final int VAR_INSN = 3;
    static final int WIDE_INSN = 16;
    private int access;
    FieldWriter firstField;
    MethodWriter firstMethod;
    int index;
    private int interfaceCount;
    private int[] interfaces;
    Item[] items;
    final Item key;
    final Item key2;
    final Item key3;
    FieldWriter lastField;
    MethodWriter lastMethod;
    private int name;
    final ByteVector pool;
    private int superName;
    String thisName;
    int threshold;
    Item[] typeTable;
    int version;

    static {
        byte[] bArr = new byte[220];
        for (int i = 0; i < 220; i++) {
            bArr[i] = (byte) ("AAAAAAAAAAAAAAAABCKLLDDDDDEEEEEEEEEEEEEEEEEEEEAAAAAAAADDDDDEEEEEEEEEEEEEEEEEEEEAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAMAAAAAAAAAAAAAAAAAAAAIIIIIIIIIIIIIIIIDNOAAAAAAGGGGGGGHHFBFAAFFAAQPIIJJIIIIIIIIIIIIIIIIII".charAt(i) - 'A');
        }
        TYPE = bArr;
    }

    public ClassWriter() {
        this(0);
    }

    private ClassWriter(int i) {
        this.index = 1;
        this.pool = new ByteVector();
        Item[] itemArr = new Item[256];
        this.items = itemArr;
        this.threshold = (int) (((double) itemArr.length) * 0.75d);
        this.key = new Item();
        this.key2 = new Item();
        this.key3 = new Item();
    }

    public void visit(int i, int i2, String str, String str2, String[] strArr) {
        this.version = i;
        this.access = i2;
        this.name = newClass(str);
        this.thisName = str;
        this.superName = str2 == null ? 0 : newClass(str2);
        if (strArr == null || strArr.length <= 0) {
            return;
        }
        int length = strArr.length;
        this.interfaceCount = length;
        this.interfaces = new int[length];
        for (int i3 = 0; i3 < this.interfaceCount; i3++) {
            this.interfaces[i3] = newClass(strArr[i3]);
        }
    }

    public FieldVisitor visitField(int i, String str, String str2) {
        return new FieldWriter(this, i, str, str2);
    }

    public MethodVisitor visitMethod(int i, String str, String str2, String str3, String[] strArr) {
        return new MethodWriter(this, i, str, str2, str3, strArr);
    }

    public byte[] toByteArray() {
        int size = (this.interfaceCount * 2) + 24;
        int i = 0;
        for (FieldWriter fieldWriter = this.firstField; fieldWriter != null; fieldWriter = fieldWriter.next) {
            i++;
            size += fieldWriter.getSize();
        }
        int i2 = 0;
        for (MethodWriter methodWriter = this.firstMethod; methodWriter != null; methodWriter = methodWriter.next) {
            i2++;
            size += methodWriter.getSize();
        }
        ByteVector byteVector = new ByteVector(size + this.pool.length);
        byteVector.putInt(-889275714).putInt(this.version);
        byteVector.putShort(this.index).putByteArray(this.pool.data, 0, this.pool.length);
        int i3 = this.access;
        byteVector.putShort(i3 & (~(((262144 & i3) / 64) | 393216))).putShort(this.name).putShort(this.superName);
        byteVector.putShort(this.interfaceCount);
        for (int i4 = 0; i4 < this.interfaceCount; i4++) {
            byteVector.putShort(this.interfaces[i4]);
        }
        byteVector.putShort(i);
        for (FieldWriter fieldWriter2 = this.firstField; fieldWriter2 != null; fieldWriter2 = fieldWriter2.next) {
            fieldWriter2.put(byteVector);
        }
        byteVector.putShort(i2);
        for (MethodWriter methodWriter2 = this.firstMethod; methodWriter2 != null; methodWriter2 = methodWriter2.next) {
            methodWriter2.put(byteVector);
        }
        byteVector.putShort(0);
        return byteVector.data;
    }

    Item newConstItem(Object obj) {
        if (obj instanceof Integer) {
            return newInteger(((Integer) obj).intValue());
        }
        if (obj instanceof String) {
            return newString((String) obj);
        }
        if (obj instanceof Type) {
            Type type = (Type) obj;
            return newClassItem(type.getSort() == 10 ? type.getInternalName() : type.getDescriptor());
        }
        throw new IllegalArgumentException("value " + obj);
    }

    Item newInteger(int i) {
        this.key.set(i);
        Item item = get(this.key);
        if (item != null) {
            return item;
        }
        this.pool.putByte(3).putInt(i);
        int i2 = this.index;
        this.index = i2 + 1;
        Item item2 = new Item(i2, this.key);
        put(item2);
        return item2;
    }

    public int newUTF8(String str) {
        this.key.set(1, str, null, null);
        Item item = get(this.key);
        if (item == null) {
            this.pool.putByte(1).putUTF8(str);
            int i = this.index;
            this.index = i + 1;
            item = new Item(i, this.key);
            put(item);
        }
        return item.index;
    }

    Item newClassItem(String str) {
        this.key2.set(7, str, null, null);
        Item item = get(this.key2);
        if (item != null) {
            return item;
        }
        this.pool.put12(7, newUTF8(str));
        int i = this.index;
        this.index = i + 1;
        Item item2 = new Item(i, this.key2);
        put(item2);
        return item2;
    }

    public int newClass(String str) {
        return newClassItem(str).index;
    }

    Item newFieldItem(String str, String str2, String str3) {
        this.key3.set(9, str, str2, str3);
        Item item = get(this.key3);
        if (item != null) {
            return item;
        }
        put122(9, newClass(str), newNameType(str2, str3));
        int i = this.index;
        this.index = i + 1;
        Item item2 = new Item(i, this.key3);
        put(item2);
        return item2;
    }

    Item newMethodItem(String str, String str2, String str3, boolean z) {
        int i = z ? 11 : 10;
        this.key3.set(i, str, str2, str3);
        Item item = get(this.key3);
        if (item != null) {
            return item;
        }
        put122(i, newClass(str), newNameType(str2, str3));
        int i2 = this.index;
        this.index = i2 + 1;
        Item item2 = new Item(i2, this.key3);
        put(item2);
        return item2;
    }

    private Item newString(String str) {
        this.key2.set(8, str, null, null);
        Item item = get(this.key2);
        if (item != null) {
            return item;
        }
        this.pool.put12(8, newUTF8(str));
        int i = this.index;
        this.index = i + 1;
        Item item2 = new Item(i, this.key2);
        put(item2);
        return item2;
    }

    public int newNameType(String str, String str2) {
        return newNameTypeItem(str, str2).index;
    }

    Item newNameTypeItem(String str, String str2) {
        this.key2.set(12, str, str2, null);
        Item item = get(this.key2);
        if (item != null) {
            return item;
        }
        put122(12, newUTF8(str), newUTF8(str2));
        int i = this.index;
        this.index = i + 1;
        Item item2 = new Item(i, this.key2);
        put(item2);
        return item2;
    }

    private Item get(Item item) {
        Item item2 = this.items[item.hashCode % this.items.length];
        while (item2 != null && (item2.type != item.type || !item.isEqualTo(item2))) {
            item2 = item2.next;
        }
        return item2;
    }

    private void put(Item item) {
        if (this.index > this.threshold) {
            int length = this.items.length;
            int i = (length * 2) + 1;
            Item[] itemArr = new Item[i];
            for (int i2 = length - 1; i2 >= 0; i2--) {
                Item item2 = this.items[i2];
                while (item2 != null) {
                    int i3 = item2.hashCode % i;
                    Item item3 = item2.next;
                    item2.next = itemArr[i3];
                    itemArr[i3] = item2;
                    item2 = item3;
                }
            }
            this.items = itemArr;
            this.threshold = (int) (((double) i) * 0.75d);
        }
        int i4 = item.hashCode;
        Item[] itemArr2 = this.items;
        int length2 = i4 % itemArr2.length;
        item.next = itemArr2[length2];
        this.items[length2] = item;
    }

    private void put122(int i, int i2, int i3) {
        this.pool.put12(i, i2).putShort(i3);
    }
}
