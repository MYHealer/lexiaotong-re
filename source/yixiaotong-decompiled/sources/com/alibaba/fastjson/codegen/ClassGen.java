package com.alibaba.fastjson.codegen;

import com.alipay.sdk.util.i;
import com.huawei.openalliance.ad.views.PPSLabelView;
import java.io.IOException;
import java.lang.reflect.Type;
import kotlin.text.Typography;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public abstract class ClassGen {
    protected Class<?> clazz;
    private String indent;
    private int indentCount;
    protected Appendable out;
    protected Type type;

    public void decrementIndent() {
        this.indentCount--;
    }

    public abstract void gen() throws IOException;

    public void incrementIndent() {
        this.indentCount++;
    }

    public ClassGen(Class<?> cls, Appendable appendable) {
        this(cls, null, appendable);
    }

    public ClassGen(Class<?> cls, Type type, Appendable appendable) {
        this.indent = "\t";
        this.indentCount = 0;
        this.clazz = cls;
        this.type = type;
        this.out = appendable;
    }

    protected void println() throws IOException {
        this.out.append(IOUtils.LINE_SEPARATOR_UNIX);
        printIndent();
    }

    protected void println(String str) throws IOException {
        this.out.append(str);
        this.out.append(IOUtils.LINE_SEPARATOR_UNIX);
        printIndent();
    }

    protected void print(String str) throws IOException {
        this.out.append(str);
    }

    protected void printPackage() throws IOException {
        print("package ");
        print(this.clazz.getPackage().getName());
        println(";");
    }

    protected void beginClass(String str) throws IOException {
        print("public class ");
        print(str);
        print(" implements ObjectDeserializer {");
        incrementIndent();
        println();
    }

    protected void endClass() throws IOException {
        decrementIndent();
        println();
        print(i.d);
        println();
    }

    protected void genField(String str, Class<?> cls) throws IOException {
        if (cls == char[].class) {
            print("char[]");
        }
        print(PPSLabelView.Code);
        print(str);
        println(";");
    }

    protected void beginInit(String str) throws IOException {
        print("public ");
        print(str);
        println(" () {");
        incrementIndent();
    }

    protected void endInit() throws IOException {
        decrementIndent();
        print(i.d);
        println();
    }

    public void printIndent() throws IOException {
        for (int i = 0; i < this.indentCount; i++) {
            print(this.indent);
        }
    }

    protected void printClassName(Class<?> cls) throws IOException {
        print(cls.getName().replace(Typography.dollar, FilenameUtils.EXTENSION_SEPARATOR));
    }
}
