package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.asm.ClassWriter;
import com.alibaba.fastjson.asm.Label;
import com.alibaba.fastjson.asm.MethodVisitor;
import com.alibaba.fastjson.asm.Opcodes;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.util.ASMClassLoader;
import com.alibaba.fastjson.util.ASMUtils;
import com.alibaba.fastjson.util.DeserializeBeanInfo;
import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.TypeUtils;
import com.cdo.oaps.ad.OapsKey;
import java.io.File;
import java.io.FileOutputStream;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class ASMDeserializerFactory implements Opcodes {
    private static final ASMDeserializerFactory instance = new ASMDeserializerFactory();
    private final ASMClassLoader classLoader;
    private final AtomicLong seed;

    public static final ASMDeserializerFactory getInstance() {
        return instance;
    }

    public String getGenClassName(Class<?> cls) {
        return "Fastjson_ASM_" + cls.getSimpleName() + "_" + this.seed.incrementAndGet();
    }

    public String getGenFieldDeserializer(Class<?> cls, FieldInfo fieldInfo) {
        return ("Fastjson_ASM__Field_" + cls.getSimpleName()) + "_" + fieldInfo.getName() + "_" + this.seed.incrementAndGet();
    }

    public ASMDeserializerFactory() {
        this.seed = new AtomicLong();
        this.classLoader = new ASMClassLoader();
    }

    public ASMDeserializerFactory(ClassLoader classLoader) {
        this.seed = new AtomicLong();
        this.classLoader = new ASMClassLoader(classLoader);
    }

    public boolean isExternalClass(Class<?> cls) {
        return this.classLoader.isExternalClass(cls);
    }

    /* JADX WARN: Code duplicated, block: B:22:0x00a6  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v10, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v8, types: [java.io.FileOutputStream] */
    public ObjectDeserializer createJavaBeanDeserializer(ParserConfig parserConfig, Class<?> cls, Type type) throws Exception {
        FileOutputStream fileOutputStream;
        Exception e;
        if (cls.isPrimitive()) {
            throw new IllegalArgumentException("not support type :" + cls.getName());
        }
        String genClassName = getGenClassName(cls);
        ClassWriter classWriter = new ClassWriter();
        classWriter.visit(49, 33, genClassName, "com/alibaba/fastjson/parser/deserializer/ASMJavaBeanDeserializer", null);
        DeserializeBeanInfo deserializeBeanInfoComputeSetters = DeserializeBeanInfo.computeSetters(cls, type);
        _init(classWriter, new Context(genClassName, parserConfig, deserializeBeanInfoComputeSetters, 3));
        _createInstance(classWriter, new Context(genClassName, parserConfig, deserializeBeanInfoComputeSetters, 3));
        ?? r3 = 4;
        _deserialze(classWriter, new Context(genClassName, parserConfig, deserializeBeanInfoComputeSetters, 4));
        _deserialzeArrayMapping(classWriter, new Context(genClassName, parserConfig, deserializeBeanInfoComputeSetters, 4));
        byte[] byteArray = classWriter.toByteArray();
        if (JSON.DUMP_CLASS != null) {
            ?? r2 = 0;
            try {
                try {
                    fileOutputStream = new FileOutputStream(JSON.DUMP_CLASS + File.separator + genClassName + ".class");
                    try {
                        fileOutputStream.write(byteArray);
                        r3 = fileOutputStream;
                    } catch (Exception e2) {
                        e = e2;
                        System.err.println("FASTJSON dump class:" + genClassName + "失败:" + e.getMessage());
                        r3 = fileOutputStream;
                        if (fileOutputStream != null) {
                        }
                        return (ObjectDeserializer) this.classLoader.defineClassPublic(genClassName, byteArray, 0, byteArray.length).getConstructor(ParserConfig.class, Class.class).newInstance(parserConfig, cls);
                    }
                } catch (Throwable th) {
                    th = th;
                    r2 = r3;
                    if (r2 != 0) {
                        r2.close();
                    }
                    throw th;
                }
            } catch (Exception e3) {
                fileOutputStream = null;
                e = e3;
            } catch (Throwable th2) {
                th = th2;
                if (r2 != 0) {
                    r2.close();
                }
                throw th;
            }
            r3.close();
        }
        return (ObjectDeserializer) this.classLoader.defineClassPublic(genClassName, byteArray, 0, byteArray.length).getConstructor(ParserConfig.class, Class.class).newInstance(parserConfig, cls);
    }

    void _setFlag(MethodVisitor methodVisitor, Context context, int i) {
        String str = "_asm_flag_" + (i / 32);
        methodVisitor.visitVarInsn(21, context.var(str));
        methodVisitor.visitLdcInsn(Integer.valueOf(1 << i));
        methodVisitor.visitInsn(128);
        methodVisitor.visitVarInsn(54, context.var(str));
    }

    void _isFlag(MethodVisitor methodVisitor, Context context, int i, Label label) {
        methodVisitor.visitVarInsn(21, context.var("_asm_flag_" + (i / 32)));
        methodVisitor.visitLdcInsn(Integer.valueOf(1 << i));
        methodVisitor.visitInsn(126);
        methodVisitor.visitJumpInsn(153, label);
    }

    void _deserialzeArrayMapping(ClassWriter classWriter, Context context) {
        ASMDeserializerFactory aSMDeserializerFactory;
        int i;
        int i2;
        int i3;
        ASMDeserializerFactory aSMDeserializerFactory2 = this;
        MethodVisitor methodVisitorVisitMethod = classWriter.visitMethod(1, "deserialzeArrayMapping", "(Lcom/alibaba/fastjson/parser/DefaultJSONParser;Ljava/lang/reflect/Type;Ljava/lang/Object;)Ljava/lang/Object;", null, null);
        aSMDeserializerFactory2.defineVarLexer(context, methodVisitorVisitMethod);
        aSMDeserializerFactory2._createInstance(context, methodVisitorVisitMethod);
        List<FieldInfo> sortedFieldList = context.getBeanInfo().getSortedFieldList();
        int size = sortedFieldList.size();
        int i4 = 0;
        while (i4 < size) {
            boolean z = i4 == size + (-1);
            int i5 = z ? 93 : 44;
            FieldInfo fieldInfo = sortedFieldList.get(i4);
            Class<?> fieldClass = fieldInfo.getFieldClass();
            Type fieldType = fieldInfo.getFieldType();
            List<FieldInfo> list = sortedFieldList;
            if (fieldClass == Byte.TYPE || fieldClass == Short.TYPE || fieldClass == Integer.TYPE) {
                aSMDeserializerFactory = aSMDeserializerFactory2;
                i = size;
                methodVisitorVisitMethod.visitVarInsn(25, context.var("lexer"));
                methodVisitorVisitMethod.visitVarInsn(16, i5);
                methodVisitorVisitMethod.visitMethodInsn(182, "com/alibaba/fastjson/parser/JSONLexerBase", "scanInt", "(C)I");
                methodVisitorVisitMethod.visitVarInsn(54, context.var(fieldInfo.getName() + "_asm"));
            } else {
                i = size;
                if (fieldClass == Long.TYPE) {
                    methodVisitorVisitMethod.visitVarInsn(25, context.var("lexer"));
                    methodVisitorVisitMethod.visitVarInsn(16, i5);
                    methodVisitorVisitMethod.visitMethodInsn(182, "com/alibaba/fastjson/parser/JSONLexerBase", "scanLong", "(C)J");
                    methodVisitorVisitMethod.visitVarInsn(55, context.var(fieldInfo.getName() + "_asm", 2));
                } else if (fieldClass == Boolean.TYPE) {
                    methodVisitorVisitMethod.visitVarInsn(25, context.var("lexer"));
                    methodVisitorVisitMethod.visitVarInsn(16, i5);
                    methodVisitorVisitMethod.visitMethodInsn(182, "com/alibaba/fastjson/parser/JSONLexerBase", "scanBoolean", "(C)Z");
                    methodVisitorVisitMethod.visitVarInsn(54, context.var(fieldInfo.getName() + "_asm"));
                } else if (fieldClass == Float.TYPE) {
                    methodVisitorVisitMethod.visitVarInsn(25, context.var("lexer"));
                    methodVisitorVisitMethod.visitVarInsn(16, i5);
                    methodVisitorVisitMethod.visitMethodInsn(182, "com/alibaba/fastjson/parser/JSONLexerBase", "scanFloat", "(C)F");
                    methodVisitorVisitMethod.visitVarInsn(56, context.var(fieldInfo.getName() + "_asm"));
                } else if (fieldClass == Double.TYPE) {
                    methodVisitorVisitMethod.visitVarInsn(25, context.var("lexer"));
                    methodVisitorVisitMethod.visitVarInsn(16, i5);
                    methodVisitorVisitMethod.visitMethodInsn(182, "com/alibaba/fastjson/parser/JSONLexerBase", "scanDouble", "(C)D");
                    methodVisitorVisitMethod.visitVarInsn(57, context.var(fieldInfo.getName() + "_asm", 2));
                } else {
                    boolean z2 = z;
                    if (fieldClass == Character.TYPE) {
                        methodVisitorVisitMethod.visitVarInsn(25, context.var("lexer"));
                        methodVisitorVisitMethod.visitVarInsn(16, i5);
                        methodVisitorVisitMethod.visitMethodInsn(182, "com/alibaba/fastjson/parser/JSONLexerBase", "scanString", "(C)Ljava/lang/String;");
                        methodVisitorVisitMethod.visitInsn(3);
                        methodVisitorVisitMethod.visitMethodInsn(182, "java/lang/String", "charAt", "(I)C");
                        methodVisitorVisitMethod.visitVarInsn(54, context.var(fieldInfo.getName() + "_asm"));
                    } else {
                        if (fieldClass == String.class) {
                            methodVisitorVisitMethod.visitVarInsn(25, context.var("lexer"));
                            methodVisitorVisitMethod.visitVarInsn(16, i5);
                            methodVisitorVisitMethod.visitMethodInsn(182, "com/alibaba/fastjson/parser/JSONLexerBase", "scanString", "(C)Ljava/lang/String;");
                            methodVisitorVisitMethod.visitVarInsn(58, context.var(fieldInfo.getName() + "_asm"));
                        } else if (fieldClass.isEnum()) {
                            methodVisitorVisitMethod.visitVarInsn(25, context.var("lexer"));
                            methodVisitorVisitMethod.visitLdcInsn(com.alibaba.fastjson.asm.Type.getType(ASMUtils.getDesc(fieldClass)));
                            methodVisitorVisitMethod.visitVarInsn(25, 1);
                            methodVisitorVisitMethod.visitMethodInsn(182, "com/alibaba/fastjson/parser/DefaultJSONParser", "getSymbolTable", "()Lcom/alibaba/fastjson/parser/SymbolTable;");
                            methodVisitorVisitMethod.visitVarInsn(16, i5);
                            methodVisitorVisitMethod.visitMethodInsn(182, "com/alibaba/fastjson/parser/JSONLexerBase", "scanEnum", "(Ljava/lang/Class;Lcom/alibaba/fastjson/parser/SymbolTable;C)Ljava/lang/Enum;");
                            methodVisitorVisitMethod.visitTypeInsn(192, ASMUtils.getType(fieldClass));
                            methodVisitorVisitMethod.visitVarInsn(58, context.var(fieldInfo.getName() + "_asm"));
                        } else if (Collection.class.isAssignableFrom(fieldClass)) {
                            Class<?> collectionItemClass = TypeUtils.getCollectionItemClass(fieldType);
                            if (collectionItemClass == String.class) {
                                methodVisitorVisitMethod.visitVarInsn(25, context.var("lexer"));
                                methodVisitorVisitMethod.visitLdcInsn(com.alibaba.fastjson.asm.Type.getType(ASMUtils.getDesc(fieldClass)));
                                methodVisitorVisitMethod.visitVarInsn(16, i5);
                                methodVisitorVisitMethod.visitMethodInsn(182, "com/alibaba/fastjson/parser/JSONLexerBase", "scanStringArray", "(Ljava/lang/Class;C)Ljava/util/Collection;");
                                methodVisitorVisitMethod.visitVarInsn(58, context.var(fieldInfo.getName() + "_asm"));
                            } else {
                                methodVisitorVisitMethod.visitVarInsn(25, 1);
                                if (i4 == 0) {
                                    i3 = 178;
                                    methodVisitorVisitMethod.visitFieldInsn(178, "com/alibaba/fastjson/parser/JSONToken", "LBRACKET", "I");
                                } else {
                                    i3 = 178;
                                    methodVisitorVisitMethod.visitFieldInsn(178, "com/alibaba/fastjson/parser/JSONToken", "COMMA", "I");
                                }
                                methodVisitorVisitMethod.visitFieldInsn(i3, "com/alibaba/fastjson/parser/JSONToken", "LBRACKET", "I");
                                methodVisitorVisitMethod.visitMethodInsn(182, "com/alibaba/fastjson/parser/DefaultJSONParser", "accept", "(II)V");
                                aSMDeserializerFactory = this;
                                aSMDeserializerFactory._newCollection(methodVisitorVisitMethod, fieldClass);
                                methodVisitorVisitMethod.visitInsn(89);
                                methodVisitorVisitMethod.visitVarInsn(58, context.var(fieldInfo.getName() + "_asm"));
                                aSMDeserializerFactory._getCollectionFieldItemDeser(context, methodVisitorVisitMethod, fieldInfo, collectionItemClass);
                                methodVisitorVisitMethod.visitVarInsn(25, 1);
                                methodVisitorVisitMethod.visitLdcInsn(com.alibaba.fastjson.asm.Type.getType(ASMUtils.getDesc(collectionItemClass)));
                                methodVisitorVisitMethod.visitVarInsn(25, 3);
                                methodVisitorVisitMethod.visitMethodInsn(184, "com/alibaba/fastjson/util/ASMUtils", "parseArray", "(Ljava/util/Collection;Lcom/alibaba/fastjson/parser/deserializer/ObjectDeserializer;Lcom/alibaba/fastjson/parser/DefaultJSONParser;Ljava/lang/reflect/Type;Ljava/lang/Object;)V");
                            }
                        } else {
                            aSMDeserializerFactory = this;
                            methodVisitorVisitMethod.visitVarInsn(25, 1);
                            if (i4 == 0) {
                                i2 = 178;
                                methodVisitorVisitMethod.visitFieldInsn(178, "com/alibaba/fastjson/parser/JSONToken", "LBRACKET", "I");
                            } else {
                                i2 = 178;
                                methodVisitorVisitMethod.visitFieldInsn(178, "com/alibaba/fastjson/parser/JSONToken", "COMMA", "I");
                            }
                            methodVisitorVisitMethod.visitFieldInsn(i2, "com/alibaba/fastjson/parser/JSONToken", "LBRACKET", "I");
                            methodVisitorVisitMethod.visitMethodInsn(182, "com/alibaba/fastjson/parser/DefaultJSONParser", "accept", "(II)V");
                            aSMDeserializerFactory._deserObject(context, methodVisitorVisitMethod, fieldInfo, fieldClass);
                            methodVisitorVisitMethod.visitVarInsn(25, 1);
                            if (!z2) {
                                methodVisitorVisitMethod.visitFieldInsn(178, "com/alibaba/fastjson/parser/JSONToken", "COMMA", "I");
                                methodVisitorVisitMethod.visitFieldInsn(178, "com/alibaba/fastjson/parser/JSONToken", "LBRACKET", "I");
                            } else {
                                methodVisitorVisitMethod.visitFieldInsn(178, "com/alibaba/fastjson/parser/JSONToken", "RBRACKET", "I");
                                methodVisitorVisitMethod.visitFieldInsn(178, "com/alibaba/fastjson/parser/JSONToken", "EOF", "I");
                            }
                            methodVisitorVisitMethod.visitMethodInsn(182, "com/alibaba/fastjson/parser/DefaultJSONParser", "accept", "(II)V");
                        }
                        aSMDeserializerFactory = this;
                    }
                }
                aSMDeserializerFactory = aSMDeserializerFactory2;
            }
            i4++;
            aSMDeserializerFactory2 = aSMDeserializerFactory;
            sortedFieldList = list;
            size = i;
        }
        aSMDeserializerFactory2._batchSet(context, methodVisitorVisitMethod, false);
        methodVisitorVisitMethod.visitVarInsn(25, context.var("lexer"));
        methodVisitorVisitMethod.visitFieldInsn(178, "com/alibaba/fastjson/parser/JSONToken", "COMMA", "I");
        methodVisitorVisitMethod.visitMethodInsn(182, "com/alibaba/fastjson/parser/JSONLexerBase", "nextToken", "(I)V");
        methodVisitorVisitMethod.visitVarInsn(25, context.var("instance"));
        methodVisitorVisitMethod.visitInsn(176);
        methodVisitorVisitMethod.visitMaxs(5, context.getVariantCount());
        methodVisitorVisitMethod.visitEnd();
    }

    /* JADX WARN: Code duplicated, block: B:88:0x081e  */
    /* JADX WARN: Code duplicated, block: B:89:0x084a  */
    void _deserialze(ClassWriter classWriter, Context context) {
        String str;
        ASMDeserializerFactory aSMDeserializerFactory;
        String str2;
        String str3;
        Label label;
        Label label2;
        Label label3;
        ASMDeserializerFactory aSMDeserializerFactory2 = this;
        if (context.getFieldInfoList().size() == 0) {
            return;
        }
        for (FieldInfo fieldInfo : context.getFieldInfoList()) {
            Class<?> fieldClass = fieldInfo.getFieldClass();
            Type fieldType = fieldInfo.getFieldType();
            if (fieldClass == Character.TYPE) {
                return;
            }
            if (Collection.class.isAssignableFrom(fieldClass) && (!(fieldType instanceof ParameterizedType) || !(((ParameterizedType) fieldType).getActualTypeArguments()[0] instanceof Class))) {
                return;
            }
        }
        Collections.sort(context.getFieldInfoList());
        MethodVisitor methodVisitorVisitMethod = classWriter.visitMethod(1, "deserialze", "(Lcom/alibaba/fastjson/parser/DefaultJSONParser;Ljava/lang/reflect/Type;Ljava/lang/Object;)Ljava/lang/Object;", null, null);
        Label label4 = new Label();
        Label label5 = new Label();
        Label label6 = new Label();
        Label label7 = new Label();
        aSMDeserializerFactory2.defineVarLexer(context, methodVisitorVisitMethod);
        aSMDeserializerFactory2._isEnable(context, methodVisitorVisitMethod, Feature.SortFeidFastMatch);
        methodVisitorVisitMethod.visitJumpInsn(153, label5);
        Label label8 = new Label();
        methodVisitorVisitMethod.visitVarInsn(25, 0);
        String str4 = "lexer";
        methodVisitorVisitMethod.visitVarInsn(25, context.var("lexer"));
        methodVisitorVisitMethod.visitMethodInsn(183, "com/alibaba/fastjson/parser/deserializer/ASMJavaBeanDeserializer", "isSupportArrayToBean", "(Lcom/alibaba/fastjson/parser/JSONLexer;)Z");
        methodVisitorVisitMethod.visitJumpInsn(153, label8);
        methodVisitorVisitMethod.visitVarInsn(25, context.var("lexer"));
        String str5 = "com/alibaba/fastjson/parser/JSONLexerBase";
        methodVisitorVisitMethod.visitMethodInsn(182, "com/alibaba/fastjson/parser/JSONLexerBase", OapsKey.KEY_TOKEN, "()I");
        String str6 = "I";
        methodVisitorVisitMethod.visitFieldInsn(178, "com/alibaba/fastjson/parser/JSONToken", "LBRACKET", "I");
        methodVisitorVisitMethod.visitJumpInsn(160, label8);
        methodVisitorVisitMethod.visitVarInsn(25, 0);
        methodVisitorVisitMethod.visitVarInsn(25, 1);
        methodVisitorVisitMethod.visitVarInsn(25, 2);
        methodVisitorVisitMethod.visitVarInsn(25, 3);
        methodVisitorVisitMethod.visitMethodInsn(183, context.getClassName(), "deserialzeArrayMapping", "(Lcom/alibaba/fastjson/parser/DefaultJSONParser;Ljava/lang/reflect/Type;Ljava/lang/Object;)Ljava/lang/Object;");
        methodVisitorVisitMethod.visitInsn(176);
        methodVisitorVisitMethod.visitLabel(label8);
        methodVisitorVisitMethod.visitVarInsn(25, context.var("lexer"));
        methodVisitorVisitMethod.visitLdcInsn(context.getClazz().getName());
        methodVisitorVisitMethod.visitMethodInsn(182, "com/alibaba/fastjson/parser/JSONLexerBase", "scanType", "(Ljava/lang/String;)I");
        methodVisitorVisitMethod.visitFieldInsn(178, "com/alibaba/fastjson/parser/JSONLexerBase", "NOT_MATCH", "I");
        methodVisitorVisitMethod.visitJumpInsn(159, label5);
        methodVisitorVisitMethod.visitVarInsn(25, 1);
        String str7 = "com/alibaba/fastjson/parser/DefaultJSONParser";
        methodVisitorVisitMethod.visitMethodInsn(182, "com/alibaba/fastjson/parser/DefaultJSONParser", "getContext", "()Lcom/alibaba/fastjson/parser/ParseContext;");
        methodVisitorVisitMethod.visitVarInsn(58, context.var("mark_context"));
        methodVisitorVisitMethod.visitInsn(3);
        methodVisitorVisitMethod.visitVarInsn(54, context.var("matchedCount"));
        aSMDeserializerFactory2._createInstance(context, methodVisitorVisitMethod);
        methodVisitorVisitMethod.visitVarInsn(25, 1);
        methodVisitorVisitMethod.visitMethodInsn(182, "com/alibaba/fastjson/parser/DefaultJSONParser", "getContext", "()Lcom/alibaba/fastjson/parser/ParseContext;");
        methodVisitorVisitMethod.visitVarInsn(58, context.var("context"));
        methodVisitorVisitMethod.visitVarInsn(25, 1);
        methodVisitorVisitMethod.visitVarInsn(25, context.var("context"));
        methodVisitorVisitMethod.visitVarInsn(25, context.var("instance"));
        methodVisitorVisitMethod.visitVarInsn(25, 3);
        methodVisitorVisitMethod.visitMethodInsn(182, "com/alibaba/fastjson/parser/DefaultJSONParser", "setContext", "(Lcom/alibaba/fastjson/parser/ParseContext;Ljava/lang/Object;Ljava/lang/Object;)Lcom/alibaba/fastjson/parser/ParseContext;");
        methodVisitorVisitMethod.visitVarInsn(58, context.var("childContext"));
        methodVisitorVisitMethod.visitVarInsn(25, context.var("lexer"));
        String str8 = "matchStat";
        methodVisitorVisitMethod.visitFieldInsn(180, "com/alibaba/fastjson/parser/JSONLexerBase", "matchStat", "I");
        methodVisitorVisitMethod.visitFieldInsn(178, "com/alibaba/fastjson/parser/JSONLexerBase", "END", "I");
        methodVisitorVisitMethod.visitJumpInsn(159, label6);
        int i = 3;
        methodVisitorVisitMethod.visitInsn(3);
        methodVisitorVisitMethod.visitIntInsn(54, context.var("matchStat"));
        int size = context.getFieldInfoList().size();
        int i2 = 0;
        while (i2 < size) {
            methodVisitorVisitMethod.visitInsn(i);
            methodVisitorVisitMethod.visitVarInsn(54, context.var("_asm_flag_" + (i2 / 32)));
            i2 += 32;
            i = 3;
        }
        int i3 = 0;
        while (true) {
            str = "_asm";
            if (i3 >= size) {
                break;
            }
            FieldInfo fieldInfo2 = context.getFieldInfoList().get(i3);
            Label label9 = label5;
            Class<?> fieldClass2 = fieldInfo2.getFieldClass();
            Label label10 = label6;
            if (fieldClass2 == Boolean.TYPE || fieldClass2 == Byte.TYPE || fieldClass2 == Short.TYPE || fieldClass2 == Integer.TYPE) {
                label4 = label4;
                label7 = label7;
                methodVisitorVisitMethod.visitInsn(3);
                methodVisitorVisitMethod.visitVarInsn(54, context.var(fieldInfo2.getName() + "_asm"));
            } else {
                if (fieldClass2 == Long.TYPE) {
                    methodVisitorVisitMethod.visitInsn(9);
                    methodVisitorVisitMethod.visitVarInsn(55, context.var(fieldInfo2.getName() + "_asm", 2));
                } else if (fieldClass2 == Float.TYPE) {
                    methodVisitorVisitMethod.visitInsn(11);
                    methodVisitorVisitMethod.visitVarInsn(56, context.var(fieldInfo2.getName() + "_asm"));
                } else if (fieldClass2 == Double.TYPE) {
                    methodVisitorVisitMethod.visitInsn(14);
                    methodVisitorVisitMethod.visitVarInsn(57, context.var(fieldInfo2.getName() + "_asm", 2));
                } else {
                    if (fieldClass2 == String.class) {
                        Label label11 = new Label();
                        aSMDeserializerFactory2._isEnable(context, methodVisitorVisitMethod, Feature.InitStringFieldAsEmpty);
                        methodVisitorVisitMethod.visitJumpInsn(153, label11);
                        aSMDeserializerFactory2._setFlag(methodVisitorVisitMethod, context, i3);
                        methodVisitorVisitMethod.visitLabel(label11);
                        methodVisitorVisitMethod.visitVarInsn(25, context.var("lexer"));
                        methodVisitorVisitMethod.visitMethodInsn(182, "com/alibaba/fastjson/parser/JSONLexerBase", "stringDefaultValue", "()Ljava/lang/String;");
                    } else {
                        methodVisitorVisitMethod.visitInsn(1);
                    }
                    methodVisitorVisitMethod.visitTypeInsn(192, ASMUtils.getType(fieldClass2));
                    methodVisitorVisitMethod.visitVarInsn(58, context.var(fieldInfo2.getName() + "_asm"));
                }
                label4 = label4;
                label7 = label7;
            }
            i3++;
            label5 = label9;
            label6 = label10;
            label7 = label7;
            label4 = label4;
        }
        Label label12 = label4;
        Label label13 = label5;
        Label label14 = label6;
        Label label15 = label7;
        int i4 = 0;
        while (i4 < size) {
            FieldInfo fieldInfo3 = context.getFieldInfoList().get(i4);
            Class<?> fieldClass3 = fieldInfo3.getFieldClass();
            Type fieldType2 = fieldInfo3.getFieldType();
            Label label16 = new Label();
            int i5 = size;
            if (fieldClass3 == Boolean.TYPE) {
                methodVisitorVisitMethod.visitVarInsn(25, context.var(str4));
                methodVisitorVisitMethod.visitVarInsn(25, 0);
                methodVisitorVisitMethod.visitFieldInsn(180, context.getClassName(), fieldInfo3.getName() + "_asm_prefix__", "[C");
                methodVisitorVisitMethod.visitMethodInsn(182, str5, "scanFieldBoolean", "([C)Z");
                methodVisitorVisitMethod.visitVarInsn(54, context.var(fieldInfo3.getName() + str));
            } else if (fieldClass3 == Byte.TYPE || fieldClass3 == Short.TYPE || fieldClass3 == Integer.TYPE) {
                methodVisitorVisitMethod.visitVarInsn(25, context.var(str4));
                methodVisitorVisitMethod.visitVarInsn(25, 0);
                methodVisitorVisitMethod.visitFieldInsn(180, context.getClassName(), fieldInfo3.getName() + "_asm_prefix__", "[C");
                methodVisitorVisitMethod.visitMethodInsn(182, str5, "scanFieldInt", "([C)I");
                methodVisitorVisitMethod.visitVarInsn(54, context.var(fieldInfo3.getName() + str));
            } else if (fieldClass3 == Long.TYPE) {
                methodVisitorVisitMethod.visitVarInsn(25, context.var(str4));
                methodVisitorVisitMethod.visitVarInsn(25, 0);
                methodVisitorVisitMethod.visitFieldInsn(180, context.getClassName(), fieldInfo3.getName() + "_asm_prefix__", "[C");
                methodVisitorVisitMethod.visitMethodInsn(182, str5, "scanFieldLong", "([C)J");
                methodVisitorVisitMethod.visitVarInsn(55, context.var(fieldInfo3.getName() + str, 2));
            } else if (fieldClass3 == Float.TYPE) {
                methodVisitorVisitMethod.visitVarInsn(25, context.var(str4));
                methodVisitorVisitMethod.visitVarInsn(25, 0);
                methodVisitorVisitMethod.visitFieldInsn(180, context.getClassName(), fieldInfo3.getName() + "_asm_prefix__", "[C");
                methodVisitorVisitMethod.visitMethodInsn(182, str5, "scanFieldFloat", "([C)F");
                methodVisitorVisitMethod.visitVarInsn(56, context.var(fieldInfo3.getName() + str));
            } else if (fieldClass3 == Double.TYPE) {
                methodVisitorVisitMethod.visitVarInsn(25, context.var(str4));
                methodVisitorVisitMethod.visitVarInsn(25, 0);
                methodVisitorVisitMethod.visitFieldInsn(180, context.getClassName(), fieldInfo3.getName() + "_asm_prefix__", "[C");
                methodVisitorVisitMethod.visitMethodInsn(182, str5, "scanFieldDouble", "([C)D");
                methodVisitorVisitMethod.visitVarInsn(57, context.var(fieldInfo3.getName() + str, 2));
            } else {
                if (fieldClass3 == String.class) {
                    methodVisitorVisitMethod.visitVarInsn(25, context.var(str4));
                    methodVisitorVisitMethod.visitVarInsn(25, 0);
                    methodVisitorVisitMethod.visitFieldInsn(180, context.getClassName(), fieldInfo3.getName() + "_asm_prefix__", "[C");
                    methodVisitorVisitMethod.visitMethodInsn(182, str5, "scanFieldString", "([C)Ljava/lang/String;");
                    methodVisitorVisitMethod.visitVarInsn(58, context.var(fieldInfo3.getName() + str));
                    str3 = str7;
                } else {
                    if (fieldClass3.isEnum()) {
                        methodVisitorVisitMethod.visitVarInsn(25, context.var(str4));
                        methodVisitorVisitMethod.visitVarInsn(25, 0);
                        methodVisitorVisitMethod.visitFieldInsn(180, context.getClassName(), fieldInfo3.getName() + "_asm_prefix__", "[C");
                        Label label17 = new Label();
                        methodVisitorVisitMethod.visitInsn(1);
                        methodVisitorVisitMethod.visitTypeInsn(192, ASMUtils.getType(fieldClass3));
                        methodVisitorVisitMethod.visitVarInsn(58, context.var(fieldInfo3.getName() + str));
                        methodVisitorVisitMethod.visitVarInsn(25, 1);
                        methodVisitorVisitMethod.visitMethodInsn(182, str7, "getSymbolTable", "()Lcom/alibaba/fastjson/parser/SymbolTable;");
                        methodVisitorVisitMethod.visitMethodInsn(182, str5, "scanFieldSymbol", "([CLcom/alibaba/fastjson/parser/SymbolTable;)Ljava/lang/String;");
                        methodVisitorVisitMethod.visitInsn(89);
                        methodVisitorVisitMethod.visitVarInsn(58, context.var(fieldInfo3.getName() + "_asm_enumName"));
                        methodVisitorVisitMethod.visitJumpInsn(198, label17);
                        methodVisitorVisitMethod.visitVarInsn(25, context.var(fieldInfo3.getName() + "_asm_enumName"));
                        methodVisitorVisitMethod.visitMethodInsn(184, ASMUtils.getType(fieldClass3), "valueOf", "(Ljava/lang/String;)" + ASMUtils.getDesc(fieldClass3));
                        methodVisitorVisitMethod.visitVarInsn(58, context.var(fieldInfo3.getName() + str));
                        methodVisitorVisitMethod.visitLabel(label17);
                    } else if (Collection.class.isAssignableFrom(fieldClass3)) {
                        methodVisitorVisitMethod.visitVarInsn(25, context.var(str4));
                        methodVisitorVisitMethod.visitVarInsn(25, 0);
                        str3 = str7;
                        methodVisitorVisitMethod.visitFieldInsn(180, context.getClassName(), fieldInfo3.getName() + "_asm_prefix__", "[C");
                        Class<?> collectionItemClass = TypeUtils.getCollectionItemClass(fieldType2);
                        if (collectionItemClass == String.class) {
                            methodVisitorVisitMethod.visitLdcInsn(com.alibaba.fastjson.asm.Type.getType(ASMUtils.getDesc(fieldClass3)));
                            methodVisitorVisitMethod.visitMethodInsn(182, str5, "scanFieldStringArray", "([CLjava/lang/Class;)" + ASMUtils.getDesc((Class<?>) Collection.class));
                            methodVisitorVisitMethod.visitVarInsn(58, context.var(fieldInfo3.getName() + str));
                        } else {
                            aSMDeserializerFactory = this;
                            str5 = str5;
                            str8 = str8;
                            i5 = i5;
                            label = label15;
                            str6 = str6;
                            str4 = str4;
                            str2 = str;
                            _deserialze_list_obj(context, methodVisitorVisitMethod, label12, fieldInfo3, fieldClass3, collectionItemClass, i4);
                            label2 = label12;
                            if (i4 == i5 - 1) {
                                aSMDeserializerFactory._deserialize_endCheck(context, methodVisitorVisitMethod, label2);
                            }
                        }
                    } else {
                        aSMDeserializerFactory = this;
                        i5 = i5;
                        str5 = str5;
                        str8 = str8;
                        str6 = str6;
                        str4 = str4;
                        str2 = str;
                        str3 = str7;
                        label = label15;
                        label2 = label12;
                        _deserialze_obj(context, methodVisitorVisitMethod, label2, fieldInfo3, fieldClass3, i4);
                        if (i4 == i5 - 1) {
                            aSMDeserializerFactory._deserialize_endCheck(context, methodVisitorVisitMethod, label2);
                        }
                    }
                    i4++;
                    label12 = label2;
                    str = str2;
                    label15 = label;
                    aSMDeserializerFactory2 = aSMDeserializerFactory;
                    size = i5;
                    str6 = str6;
                    str5 = str5;
                    str8 = str8;
                    str7 = str3;
                    str4 = str4;
                }
                methodVisitorVisitMethod.visitVarInsn(25, context.var(str4));
                methodVisitorVisitMethod.visitFieldInsn(180, str5, str8, str6);
                Label label18 = new Label();
                methodVisitorVisitMethod.visitJumpInsn(158, label18);
                aSMDeserializerFactory = this;
                aSMDeserializerFactory._setFlag(methodVisitorVisitMethod, context, i4);
                methodVisitorVisitMethod.visitLabel(label18);
                methodVisitorVisitMethod.visitVarInsn(25, context.var(str4));
                methodVisitorVisitMethod.visitFieldInsn(180, str5, str8, str6);
                methodVisitorVisitMethod.visitInsn(89);
                methodVisitorVisitMethod.visitVarInsn(54, context.var(str8));
                methodVisitorVisitMethod.visitFieldInsn(178, str5, "NOT_MATCH", str6);
                label3 = label12;
                methodVisitorVisitMethod.visitJumpInsn(159, label3);
                methodVisitorVisitMethod.visitVarInsn(25, context.var(str4));
                methodVisitorVisitMethod.visitFieldInsn(180, str5, str8, str6);
                methodVisitorVisitMethod.visitJumpInsn(158, label16);
                methodVisitorVisitMethod.visitVarInsn(21, context.var("matchedCount"));
                methodVisitorVisitMethod.visitInsn(4);
                methodVisitorVisitMethod.visitInsn(96);
                methodVisitorVisitMethod.visitVarInsn(54, context.var("matchedCount"));
                methodVisitorVisitMethod.visitVarInsn(25, context.var(str4));
                methodVisitorVisitMethod.visitFieldInsn(180, str5, str8, str6);
                methodVisitorVisitMethod.visitFieldInsn(178, str5, "END", str6);
                Label label19 = label15;
                methodVisitorVisitMethod.visitJumpInsn(159, label19);
                methodVisitorVisitMethod.visitLabel(label16);
                if (i4 == i5 - 1) {
                    methodVisitorVisitMethod.visitVarInsn(25, context.var(str4));
                    methodVisitorVisitMethod.visitFieldInsn(180, str5, str8, str6);
                    methodVisitorVisitMethod.visitFieldInsn(178, str5, "END", str6);
                    methodVisitorVisitMethod.visitJumpInsn(160, label3);
                }
                label = label19;
                str2 = str;
                label2 = label3;
                i4++;
                label12 = label2;
                str = str2;
                label15 = label;
                aSMDeserializerFactory2 = aSMDeserializerFactory;
                size = i5;
                str6 = str6;
                str5 = str5;
                str8 = str8;
                str7 = str3;
                str4 = str4;
            }
            str3 = str7;
            methodVisitorVisitMethod.visitVarInsn(25, context.var(str4));
            methodVisitorVisitMethod.visitFieldInsn(180, str5, str8, str6);
            Label label110 = new Label();
            methodVisitorVisitMethod.visitJumpInsn(158, label110);
            aSMDeserializerFactory = this;
            aSMDeserializerFactory._setFlag(methodVisitorVisitMethod, context, i4);
            methodVisitorVisitMethod.visitLabel(label110);
            methodVisitorVisitMethod.visitVarInsn(25, context.var(str4));
            methodVisitorVisitMethod.visitFieldInsn(180, str5, str8, str6);
            methodVisitorVisitMethod.visitInsn(89);
            methodVisitorVisitMethod.visitVarInsn(54, context.var(str8));
            methodVisitorVisitMethod.visitFieldInsn(178, str5, "NOT_MATCH", str6);
            label3 = label12;
            methodVisitorVisitMethod.visitJumpInsn(159, label3);
            methodVisitorVisitMethod.visitVarInsn(25, context.var(str4));
            methodVisitorVisitMethod.visitFieldInsn(180, str5, str8, str6);
            methodVisitorVisitMethod.visitJumpInsn(158, label16);
            methodVisitorVisitMethod.visitVarInsn(21, context.var("matchedCount"));
            methodVisitorVisitMethod.visitInsn(4);
            methodVisitorVisitMethod.visitInsn(96);
            methodVisitorVisitMethod.visitVarInsn(54, context.var("matchedCount"));
            methodVisitorVisitMethod.visitVarInsn(25, context.var(str4));
            methodVisitorVisitMethod.visitFieldInsn(180, str5, str8, str6);
            methodVisitorVisitMethod.visitFieldInsn(178, str5, "END", str6);
            Label label111 = label15;
            methodVisitorVisitMethod.visitJumpInsn(159, label111);
            methodVisitorVisitMethod.visitLabel(label16);
            if (i4 == i5 - 1) {
                methodVisitorVisitMethod.visitVarInsn(25, context.var(str4));
                methodVisitorVisitMethod.visitFieldInsn(180, str5, str8, str6);
                methodVisitorVisitMethod.visitFieldInsn(178, str5, "END", str6);
                methodVisitorVisitMethod.visitJumpInsn(160, label3);
            }
            label = label111;
            str2 = str;
            label2 = label3;
            i4++;
            label12 = label2;
            str = str2;
            label15 = label;
            aSMDeserializerFactory2 = aSMDeserializerFactory;
            size = i5;
            str6 = str6;
            str5 = str5;
            str8 = str8;
            str7 = str3;
            str4 = str4;
        }
        ASMDeserializerFactory aSMDeserializerFactory3 = aSMDeserializerFactory2;
        Label label20 = label12;
        methodVisitorVisitMethod.visitLabel(label15);
        if (!context.getClazz().isInterface() && !Modifier.isAbstract(context.getClazz().getModifiers())) {
            aSMDeserializerFactory3._batchSet(context, methodVisitorVisitMethod);
        }
        methodVisitorVisitMethod.visitLabel(label14);
        aSMDeserializerFactory3._setContext(context, methodVisitorVisitMethod);
        methodVisitorVisitMethod.visitVarInsn(25, context.var("instance"));
        methodVisitorVisitMethod.visitInsn(176);
        methodVisitorVisitMethod.visitLabel(label20);
        aSMDeserializerFactory3._batchSet(context, methodVisitorVisitMethod);
        methodVisitorVisitMethod.visitVarInsn(25, 0);
        methodVisitorVisitMethod.visitVarInsn(25, 1);
        methodVisitorVisitMethod.visitVarInsn(25, 2);
        methodVisitorVisitMethod.visitVarInsn(25, 3);
        methodVisitorVisitMethod.visitVarInsn(25, context.var("instance"));
        methodVisitorVisitMethod.visitMethodInsn(182, "com/alibaba/fastjson/parser/deserializer/ASMJavaBeanDeserializer", "parseRest", "(Lcom/alibaba/fastjson/parser/DefaultJSONParser;Ljava/lang/reflect/Type;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;");
        methodVisitorVisitMethod.visitTypeInsn(192, ASMUtils.getType(context.getClazz()));
        methodVisitorVisitMethod.visitInsn(176);
        methodVisitorVisitMethod.visitLabel(label13);
        methodVisitorVisitMethod.visitVarInsn(25, 0);
        methodVisitorVisitMethod.visitVarInsn(25, 1);
        methodVisitorVisitMethod.visitVarInsn(25, 2);
        methodVisitorVisitMethod.visitVarInsn(25, 3);
        methodVisitorVisitMethod.visitMethodInsn(183, "com/alibaba/fastjson/parser/deserializer/ASMJavaBeanDeserializer", "deserialze", "(Lcom/alibaba/fastjson/parser/DefaultJSONParser;Ljava/lang/reflect/Type;Ljava/lang/Object;)Ljava/lang/Object;");
        methodVisitorVisitMethod.visitInsn(176);
        methodVisitorVisitMethod.visitMaxs(5, context.getVariantCount());
        methodVisitorVisitMethod.visitEnd();
    }

    private void _isEnable(Context context, MethodVisitor methodVisitor, Feature feature) {
        methodVisitor.visitVarInsn(25, context.var("lexer"));
        methodVisitor.visitFieldInsn(178, "com/alibaba/fastjson/parser/Feature", feature.name(), "Lcom/alibaba/fastjson/parser/Feature;");
        methodVisitor.visitMethodInsn(182, "com/alibaba/fastjson/parser/JSONLexerBase", "isEnabled", "(Lcom/alibaba/fastjson/parser/Feature;)Z");
    }

    private void defineVarLexer(Context context, MethodVisitor methodVisitor) {
        methodVisitor.visitVarInsn(25, 1);
        methodVisitor.visitMethodInsn(182, "com/alibaba/fastjson/parser/DefaultJSONParser", "getLexer", "()Lcom/alibaba/fastjson/parser/JSONLexer;");
        methodVisitor.visitTypeInsn(192, "com/alibaba/fastjson/parser/JSONLexerBase");
        methodVisitor.visitVarInsn(58, context.var("lexer"));
    }

    private void _createInstance(Context context, MethodVisitor methodVisitor) {
        if (Modifier.isPublic(context.getBeanInfo().getDefaultConstructor().getModifiers())) {
            methodVisitor.visitTypeInsn(187, ASMUtils.getType(context.getClazz()));
            methodVisitor.visitInsn(89);
            methodVisitor.visitMethodInsn(183, ASMUtils.getType(context.getClazz()), "<init>", "()V");
            methodVisitor.visitVarInsn(58, context.var("instance"));
            return;
        }
        methodVisitor.visitVarInsn(25, 0);
        methodVisitor.visitVarInsn(25, 1);
        methodVisitor.visitMethodInsn(183, "com/alibaba/fastjson/parser/deserializer/ASMJavaBeanDeserializer", "createInstance", "(Lcom/alibaba/fastjson/parser/DefaultJSONParser;)Ljava/lang/Object;");
        methodVisitor.visitTypeInsn(192, ASMUtils.getType(context.getClazz()));
        methodVisitor.visitVarInsn(58, context.var("instance"));
    }

    private void _batchSet(Context context, MethodVisitor methodVisitor) {
        _batchSet(context, methodVisitor, true);
    }

    private void _batchSet(Context context, MethodVisitor methodVisitor, boolean z) {
        int size = context.getFieldInfoList().size();
        for (int i = 0; i < size; i++) {
            Label label = new Label();
            if (z) {
                _isFlag(methodVisitor, context, i, label);
            }
            _loadAndSet(context, methodVisitor, context.getFieldInfoList().get(i));
            if (z) {
                methodVisitor.visitLabel(label);
            }
        }
    }

    private void _loadAndSet(Context context, MethodVisitor methodVisitor, FieldInfo fieldInfo) {
        Class<?> fieldClass = fieldInfo.getFieldClass();
        Type fieldType = fieldInfo.getFieldType();
        if (fieldClass == Boolean.TYPE) {
            methodVisitor.visitVarInsn(25, context.var("instance"));
            methodVisitor.visitVarInsn(21, context.var(fieldInfo.getName() + "_asm"));
            _set(context, methodVisitor, fieldInfo);
            return;
        }
        if (fieldClass == Byte.TYPE || fieldClass == Short.TYPE || fieldClass == Integer.TYPE || fieldClass == Character.TYPE) {
            methodVisitor.visitVarInsn(25, context.var("instance"));
            methodVisitor.visitVarInsn(21, context.var(fieldInfo.getName() + "_asm"));
            _set(context, methodVisitor, fieldInfo);
            return;
        }
        if (fieldClass == Long.TYPE) {
            methodVisitor.visitVarInsn(25, context.var("instance"));
            methodVisitor.visitVarInsn(22, context.var(fieldInfo.getName() + "_asm", 2));
            if (fieldInfo.getMethod() != null) {
                methodVisitor.visitMethodInsn(182, ASMUtils.getType(context.getClazz()), fieldInfo.getMethod().getName(), ASMUtils.getDesc(fieldInfo.getMethod()));
                if (fieldInfo.getMethod().getReturnType().equals(Void.TYPE)) {
                    return;
                }
                methodVisitor.visitInsn(87);
                return;
            }
            methodVisitor.visitFieldInsn(181, ASMUtils.getType(fieldInfo.getDeclaringClass()), fieldInfo.getField().getName(), ASMUtils.getDesc(fieldInfo.getFieldClass()));
            return;
        }
        if (fieldClass == Float.TYPE) {
            methodVisitor.visitVarInsn(25, context.var("instance"));
            methodVisitor.visitVarInsn(23, context.var(fieldInfo.getName() + "_asm"));
            _set(context, methodVisitor, fieldInfo);
            return;
        }
        if (fieldClass == Double.TYPE) {
            methodVisitor.visitVarInsn(25, context.var("instance"));
            methodVisitor.visitVarInsn(24, context.var(fieldInfo.getName() + "_asm", 2));
            _set(context, methodVisitor, fieldInfo);
            return;
        }
        if (fieldClass == String.class) {
            methodVisitor.visitVarInsn(25, context.var("instance"));
            methodVisitor.visitVarInsn(25, context.var(fieldInfo.getName() + "_asm"));
            _set(context, methodVisitor, fieldInfo);
            return;
        }
        if (fieldClass.isEnum()) {
            methodVisitor.visitVarInsn(25, context.var("instance"));
            methodVisitor.visitVarInsn(25, context.var(fieldInfo.getName() + "_asm"));
            _set(context, methodVisitor, fieldInfo);
        } else {
            if (Collection.class.isAssignableFrom(fieldClass)) {
                methodVisitor.visitVarInsn(25, context.var("instance"));
                if (TypeUtils.getCollectionItemClass(fieldType) == String.class) {
                    methodVisitor.visitVarInsn(25, context.var(fieldInfo.getName() + "_asm"));
                    methodVisitor.visitTypeInsn(192, ASMUtils.getType(fieldClass));
                } else {
                    methodVisitor.visitVarInsn(25, context.var(fieldInfo.getName() + "_asm"));
                }
                _set(context, methodVisitor, fieldInfo);
                return;
            }
            methodVisitor.visitVarInsn(25, context.var("instance"));
            methodVisitor.visitVarInsn(25, context.var(fieldInfo.getName() + "_asm"));
            _set(context, methodVisitor, fieldInfo);
        }
    }

    private void _set(Context context, MethodVisitor methodVisitor, FieldInfo fieldInfo) {
        if (fieldInfo.getMethod() != null) {
            methodVisitor.visitMethodInsn(182, ASMUtils.getType(fieldInfo.getDeclaringClass()), fieldInfo.getMethod().getName(), ASMUtils.getDesc(fieldInfo.getMethod()));
            if (fieldInfo.getMethod().getReturnType().equals(Void.TYPE)) {
                return;
            }
            methodVisitor.visitInsn(87);
            return;
        }
        methodVisitor.visitFieldInsn(181, ASMUtils.getType(fieldInfo.getDeclaringClass()), fieldInfo.getField().getName(), ASMUtils.getDesc(fieldInfo.getFieldClass()));
    }

    private void _setContext(Context context, MethodVisitor methodVisitor) {
        methodVisitor.visitVarInsn(25, 1);
        methodVisitor.visitVarInsn(25, context.var("context"));
        methodVisitor.visitMethodInsn(182, "com/alibaba/fastjson/parser/DefaultJSONParser", "setContext", "(Lcom/alibaba/fastjson/parser/ParseContext;)V");
        Label label = new Label();
        methodVisitor.visitVarInsn(25, context.var("childContext"));
        methodVisitor.visitJumpInsn(198, label);
        methodVisitor.visitVarInsn(25, context.var("childContext"));
        methodVisitor.visitVarInsn(25, context.var("instance"));
        methodVisitor.visitMethodInsn(182, "com/alibaba/fastjson/parser/ParseContext", "setObject", "(Ljava/lang/Object;)V");
        methodVisitor.visitLabel(label);
    }

    private void _deserialize_endCheck(Context context, MethodVisitor methodVisitor, Label label) {
        methodVisitor.visitIntInsn(21, context.var("matchedCount"));
        methodVisitor.visitJumpInsn(158, label);
        methodVisitor.visitVarInsn(25, context.var("lexer"));
        methodVisitor.visitMethodInsn(182, "com/alibaba/fastjson/parser/JSONLexerBase", OapsKey.KEY_TOKEN, "()I");
        methodVisitor.visitFieldInsn(178, "com/alibaba/fastjson/parser/JSONToken", "RBRACE", "I");
        methodVisitor.visitJumpInsn(160, label);
        methodVisitor.visitVarInsn(25, context.var("lexer"));
        methodVisitor.visitFieldInsn(178, "com/alibaba/fastjson/parser/JSONToken", "COMMA", "I");
        methodVisitor.visitMethodInsn(182, "com/alibaba/fastjson/parser/JSONLexerBase", "nextToken", "(I)V");
    }

    private void _deserialze_list_obj(Context context, MethodVisitor methodVisitor, Label label, FieldInfo fieldInfo, Class<?> cls, Class<?> cls2, int i) {
        Label label2 = new Label();
        methodVisitor.visitMethodInsn(182, "com/alibaba/fastjson/parser/JSONLexerBase", "matchField", "([C)Z");
        methodVisitor.visitJumpInsn(153, label2);
        _setFlag(methodVisitor, context, i);
        Label label3 = new Label();
        methodVisitor.visitVarInsn(25, context.var("lexer"));
        methodVisitor.visitMethodInsn(182, "com/alibaba/fastjson/parser/JSONLexerBase", OapsKey.KEY_TOKEN, "()I");
        methodVisitor.visitFieldInsn(178, "com/alibaba/fastjson/parser/JSONToken", "NULL", "I");
        methodVisitor.visitJumpInsn(160, label3);
        methodVisitor.visitVarInsn(25, context.var("lexer"));
        methodVisitor.visitFieldInsn(178, "com/alibaba/fastjson/parser/JSONToken", "COMMA", "I");
        methodVisitor.visitMethodInsn(182, "com/alibaba/fastjson/parser/JSONLexerBase", "nextToken", "(I)V");
        methodVisitor.visitJumpInsn(167, label2);
        methodVisitor.visitLabel(label3);
        methodVisitor.visitVarInsn(25, context.var("lexer"));
        methodVisitor.visitMethodInsn(182, "com/alibaba/fastjson/parser/JSONLexerBase", OapsKey.KEY_TOKEN, "()I");
        methodVisitor.visitFieldInsn(178, "com/alibaba/fastjson/parser/JSONToken", "LBRACKET", "I");
        methodVisitor.visitJumpInsn(160, label);
        _getCollectionFieldItemDeser(context, methodVisitor, fieldInfo, cls2);
        methodVisitor.visitMethodInsn(185, "com/alibaba/fastjson/parser/deserializer/ObjectDeserializer", "getFastMatchToken", "()I");
        methodVisitor.visitVarInsn(54, context.var("fastMatchToken"));
        methodVisitor.visitVarInsn(25, context.var("lexer"));
        methodVisitor.visitVarInsn(21, context.var("fastMatchToken"));
        methodVisitor.visitMethodInsn(182, "com/alibaba/fastjson/parser/JSONLexerBase", "nextToken", "(I)V");
        _newCollection(methodVisitor, cls);
        methodVisitor.visitVarInsn(58, context.var(fieldInfo.getName() + "_asm"));
        methodVisitor.visitVarInsn(25, 1);
        methodVisitor.visitMethodInsn(182, "com/alibaba/fastjson/parser/DefaultJSONParser", "getContext", "()Lcom/alibaba/fastjson/parser/ParseContext;");
        methodVisitor.visitVarInsn(58, context.var("listContext"));
        methodVisitor.visitVarInsn(25, 1);
        methodVisitor.visitVarInsn(25, context.var(fieldInfo.getName() + "_asm"));
        methodVisitor.visitLdcInsn(fieldInfo.getName());
        methodVisitor.visitMethodInsn(182, "com/alibaba/fastjson/parser/DefaultJSONParser", "setContext", "(Ljava/lang/Object;Ljava/lang/Object;)Lcom/alibaba/fastjson/parser/ParseContext;");
        methodVisitor.visitInsn(87);
        Label label4 = new Label();
        Label label5 = new Label();
        methodVisitor.visitInsn(3);
        methodVisitor.visitVarInsn(54, context.var("i"));
        methodVisitor.visitLabel(label4);
        methodVisitor.visitVarInsn(25, context.var("lexer"));
        methodVisitor.visitMethodInsn(182, "com/alibaba/fastjson/parser/JSONLexerBase", OapsKey.KEY_TOKEN, "()I");
        methodVisitor.visitFieldInsn(178, "com/alibaba/fastjson/parser/JSONToken", "RBRACKET", "I");
        methodVisitor.visitJumpInsn(159, label5);
        methodVisitor.visitVarInsn(25, 0);
        methodVisitor.visitFieldInsn(180, context.getClassName(), fieldInfo.getName() + "_asm_list_item_deser__", "Lcom/alibaba/fastjson/parser/deserializer/ObjectDeserializer;");
        methodVisitor.visitVarInsn(25, 1);
        methodVisitor.visitLdcInsn(com.alibaba.fastjson.asm.Type.getType(ASMUtils.getDesc(cls2)));
        methodVisitor.visitVarInsn(21, context.var("i"));
        methodVisitor.visitMethodInsn(184, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
        methodVisitor.visitMethodInsn(185, "com/alibaba/fastjson/parser/deserializer/ObjectDeserializer", "deserialze", "(Lcom/alibaba/fastjson/parser/DefaultJSONParser;Ljava/lang/reflect/Type;Ljava/lang/Object;)Ljava/lang/Object;");
        methodVisitor.visitVarInsn(58, context.var("list_item_value"));
        methodVisitor.visitIincInsn(context.var("i"), 1);
        methodVisitor.visitVarInsn(25, context.var(fieldInfo.getName() + "_asm"));
        methodVisitor.visitVarInsn(25, context.var("list_item_value"));
        if (cls.isInterface()) {
            methodVisitor.visitMethodInsn(185, ASMUtils.getType(cls), "add", "(Ljava/lang/Object;)Z");
        } else {
            methodVisitor.visitMethodInsn(182, ASMUtils.getType(cls), "add", "(Ljava/lang/Object;)Z");
        }
        methodVisitor.visitInsn(87);
        methodVisitor.visitVarInsn(25, 1);
        methodVisitor.visitVarInsn(25, context.var(fieldInfo.getName() + "_asm"));
        methodVisitor.visitMethodInsn(182, "com/alibaba/fastjson/parser/DefaultJSONParser", "checkListResolve", "(Ljava/util/Collection;)V");
        methodVisitor.visitVarInsn(25, context.var("lexer"));
        methodVisitor.visitMethodInsn(182, "com/alibaba/fastjson/parser/JSONLexerBase", OapsKey.KEY_TOKEN, "()I");
        methodVisitor.visitFieldInsn(178, "com/alibaba/fastjson/parser/JSONToken", "COMMA", "I");
        methodVisitor.visitJumpInsn(160, label4);
        methodVisitor.visitVarInsn(25, context.var("lexer"));
        methodVisitor.visitVarInsn(21, context.var("fastMatchToken"));
        methodVisitor.visitMethodInsn(182, "com/alibaba/fastjson/parser/JSONLexerBase", "nextToken", "(I)V");
        methodVisitor.visitJumpInsn(167, label4);
        methodVisitor.visitLabel(label5);
        methodVisitor.visitVarInsn(25, 1);
        methodVisitor.visitVarInsn(25, context.var("listContext"));
        methodVisitor.visitMethodInsn(182, "com/alibaba/fastjson/parser/DefaultJSONParser", "setContext", "(Lcom/alibaba/fastjson/parser/ParseContext;)V");
        methodVisitor.visitVarInsn(25, context.var("lexer"));
        methodVisitor.visitMethodInsn(182, "com/alibaba/fastjson/parser/JSONLexerBase", OapsKey.KEY_TOKEN, "()I");
        methodVisitor.visitFieldInsn(178, "com/alibaba/fastjson/parser/JSONToken", "RBRACKET", "I");
        methodVisitor.visitJumpInsn(160, label);
        methodVisitor.visitVarInsn(25, context.var("lexer"));
        methodVisitor.visitFieldInsn(178, "com/alibaba/fastjson/parser/JSONToken", "COMMA", "I");
        methodVisitor.visitMethodInsn(182, "com/alibaba/fastjson/parser/JSONLexerBase", "nextToken", "(I)V");
        methodVisitor.visitLabel(label2);
    }

    private void _getCollectionFieldItemDeser(Context context, MethodVisitor methodVisitor, FieldInfo fieldInfo, Class<?> cls) {
        Label label = new Label();
        methodVisitor.visitVarInsn(25, 0);
        methodVisitor.visitFieldInsn(180, context.getClassName(), fieldInfo.getName() + "_asm_list_item_deser__", "Lcom/alibaba/fastjson/parser/deserializer/ObjectDeserializer;");
        methodVisitor.visitJumpInsn(199, label);
        methodVisitor.visitVarInsn(25, 0);
        methodVisitor.visitVarInsn(25, 1);
        methodVisitor.visitMethodInsn(182, "com/alibaba/fastjson/parser/DefaultJSONParser", "getConfig", "()Lcom/alibaba/fastjson/parser/ParserConfig;");
        methodVisitor.visitLdcInsn(com.alibaba.fastjson.asm.Type.getType(ASMUtils.getDesc(cls)));
        methodVisitor.visitMethodInsn(182, "com/alibaba/fastjson/parser/ParserConfig", "getDeserializer", "(Ljava/lang/reflect/Type;)Lcom/alibaba/fastjson/parser/deserializer/ObjectDeserializer;");
        methodVisitor.visitFieldInsn(181, context.getClassName(), fieldInfo.getName() + "_asm_list_item_deser__", "Lcom/alibaba/fastjson/parser/deserializer/ObjectDeserializer;");
        methodVisitor.visitLabel(label);
        methodVisitor.visitVarInsn(25, 0);
        methodVisitor.visitFieldInsn(180, context.getClassName(), fieldInfo.getName() + "_asm_list_item_deser__", "Lcom/alibaba/fastjson/parser/deserializer/ObjectDeserializer;");
    }

    private void _newCollection(MethodVisitor methodVisitor, Class<?> cls) {
        if (cls.isAssignableFrom(ArrayList.class)) {
            methodVisitor.visitTypeInsn(187, "java/util/ArrayList");
            methodVisitor.visitInsn(89);
            methodVisitor.visitMethodInsn(183, "java/util/ArrayList", "<init>", "()V");
        } else if (cls.isAssignableFrom(LinkedList.class)) {
            methodVisitor.visitTypeInsn(187, ASMUtils.getType(LinkedList.class));
            methodVisitor.visitInsn(89);
            methodVisitor.visitMethodInsn(183, ASMUtils.getType(LinkedList.class), "<init>", "()V");
        } else if (cls.isAssignableFrom(HashSet.class)) {
            methodVisitor.visitTypeInsn(187, ASMUtils.getType(HashSet.class));
            methodVisitor.visitInsn(89);
            methodVisitor.visitMethodInsn(183, ASMUtils.getType(HashSet.class), "<init>", "()V");
        } else if (cls.isAssignableFrom(TreeSet.class)) {
            methodVisitor.visitTypeInsn(187, ASMUtils.getType(TreeSet.class));
            methodVisitor.visitInsn(89);
            methodVisitor.visitMethodInsn(183, ASMUtils.getType(TreeSet.class), "<init>", "()V");
        } else {
            methodVisitor.visitTypeInsn(187, ASMUtils.getType(cls));
            methodVisitor.visitInsn(89);
            methodVisitor.visitMethodInsn(183, ASMUtils.getType(cls), "<init>", "()V");
        }
        methodVisitor.visitTypeInsn(192, ASMUtils.getType(cls));
    }

    private void _deserialze_obj(Context context, MethodVisitor methodVisitor, Label label, FieldInfo fieldInfo, Class<?> cls, int i) {
        Label label2 = new Label();
        Label label3 = new Label();
        methodVisitor.visitVarInsn(25, context.var("lexer"));
        methodVisitor.visitVarInsn(25, 0);
        methodVisitor.visitFieldInsn(180, context.getClassName(), fieldInfo.getName() + "_asm_prefix__", "[C");
        methodVisitor.visitMethodInsn(182, "com/alibaba/fastjson/parser/JSONLexerBase", "matchField", "([C)Z");
        methodVisitor.visitJumpInsn(154, label2);
        methodVisitor.visitInsn(1);
        methodVisitor.visitVarInsn(58, context.var(fieldInfo.getName() + "_asm"));
        methodVisitor.visitJumpInsn(167, label3);
        methodVisitor.visitLabel(label2);
        _setFlag(methodVisitor, context, i);
        methodVisitor.visitVarInsn(21, context.var("matchedCount"));
        methodVisitor.visitInsn(4);
        methodVisitor.visitInsn(96);
        methodVisitor.visitVarInsn(54, context.var("matchedCount"));
        _deserObject(context, methodVisitor, fieldInfo, cls);
        methodVisitor.visitVarInsn(25, 1);
        methodVisitor.visitMethodInsn(182, "com/alibaba/fastjson/parser/DefaultJSONParser", "getResolveStatus", "()I");
        methodVisitor.visitFieldInsn(178, "com/alibaba/fastjson/parser/DefaultJSONParser", "NeedToResolve", "I");
        methodVisitor.visitJumpInsn(160, label3);
        methodVisitor.visitVarInsn(25, 1);
        methodVisitor.visitMethodInsn(182, "com/alibaba/fastjson/parser/DefaultJSONParser", "getLastResolveTask", "()Lcom/alibaba/fastjson/parser/DefaultJSONParser$ResolveTask;");
        methodVisitor.visitVarInsn(58, context.var("resolveTask"));
        methodVisitor.visitVarInsn(25, context.var("resolveTask"));
        methodVisitor.visitVarInsn(25, 1);
        methodVisitor.visitMethodInsn(182, "com/alibaba/fastjson/parser/DefaultJSONParser", "getContext", "()Lcom/alibaba/fastjson/parser/ParseContext;");
        methodVisitor.visitMethodInsn(182, "com/alibaba/fastjson/parser/DefaultJSONParser$ResolveTask", "setOwnerContext", "(Lcom/alibaba/fastjson/parser/ParseContext;)V");
        methodVisitor.visitVarInsn(25, context.var("resolveTask"));
        methodVisitor.visitVarInsn(25, 0);
        methodVisitor.visitLdcInsn(fieldInfo.getName());
        methodVisitor.visitMethodInsn(182, "com/alibaba/fastjson/parser/deserializer/ASMJavaBeanDeserializer", "getFieldDeserializer", "(Ljava/lang/String;)Lcom/alibaba/fastjson/parser/deserializer/FieldDeserializer;");
        methodVisitor.visitMethodInsn(182, "com/alibaba/fastjson/parser/DefaultJSONParser$ResolveTask", "setFieldDeserializer", "(Lcom/alibaba/fastjson/parser/deserializer/FieldDeserializer;)V");
        methodVisitor.visitVarInsn(25, 1);
        methodVisitor.visitFieldInsn(178, "com/alibaba/fastjson/parser/DefaultJSONParser", "NONE", "I");
        methodVisitor.visitMethodInsn(182, "com/alibaba/fastjson/parser/DefaultJSONParser", "setResolveStatus", "(I)V");
        methodVisitor.visitLabel(label3);
    }

    private void _deserObject(Context context, MethodVisitor methodVisitor, FieldInfo fieldInfo, Class<?> cls) {
        _getFieldDeser(context, methodVisitor, fieldInfo);
        methodVisitor.visitVarInsn(25, 1);
        if (fieldInfo.getFieldType() instanceof Class) {
            methodVisitor.visitLdcInsn(com.alibaba.fastjson.asm.Type.getType(ASMUtils.getDesc(fieldInfo.getFieldClass())));
        } else {
            methodVisitor.visitVarInsn(25, 0);
            methodVisitor.visitLdcInsn(fieldInfo.getName());
            methodVisitor.visitMethodInsn(182, "com/alibaba/fastjson/parser/deserializer/ASMJavaBeanDeserializer", "getFieldType", "(Ljava/lang/String;)Ljava/lang/reflect/Type;");
        }
        methodVisitor.visitLdcInsn(fieldInfo.getName());
        methodVisitor.visitMethodInsn(185, "com/alibaba/fastjson/parser/deserializer/ObjectDeserializer", "deserialze", "(Lcom/alibaba/fastjson/parser/DefaultJSONParser;Ljava/lang/reflect/Type;Ljava/lang/Object;)Ljava/lang/Object;");
        methodVisitor.visitTypeInsn(192, ASMUtils.getType(cls));
        methodVisitor.visitVarInsn(58, context.var(fieldInfo.getName() + "_asm"));
    }

    private void _getFieldDeser(Context context, MethodVisitor methodVisitor, FieldInfo fieldInfo) {
        Label label = new Label();
        methodVisitor.visitVarInsn(25, 0);
        methodVisitor.visitFieldInsn(180, context.getClassName(), fieldInfo.getName() + "_asm_deser__", "Lcom/alibaba/fastjson/parser/deserializer/ObjectDeserializer;");
        methodVisitor.visitJumpInsn(199, label);
        methodVisitor.visitVarInsn(25, 0);
        methodVisitor.visitVarInsn(25, 1);
        methodVisitor.visitMethodInsn(182, "com/alibaba/fastjson/parser/DefaultJSONParser", "getConfig", "()Lcom/alibaba/fastjson/parser/ParserConfig;");
        methodVisitor.visitLdcInsn(com.alibaba.fastjson.asm.Type.getType(ASMUtils.getDesc(fieldInfo.getFieldClass())));
        methodVisitor.visitMethodInsn(182, "com/alibaba/fastjson/parser/ParserConfig", "getDeserializer", "(Ljava/lang/reflect/Type;)Lcom/alibaba/fastjson/parser/deserializer/ObjectDeserializer;");
        methodVisitor.visitFieldInsn(181, context.getClassName(), fieldInfo.getName() + "_asm_deser__", "Lcom/alibaba/fastjson/parser/deserializer/ObjectDeserializer;");
        methodVisitor.visitLabel(label);
        methodVisitor.visitVarInsn(25, 0);
        methodVisitor.visitFieldInsn(180, context.getClassName(), fieldInfo.getName() + "_asm_deser__", "Lcom/alibaba/fastjson/parser/deserializer/ObjectDeserializer;");
    }

    public FieldDeserializer createFieldDeserializer(ParserConfig parserConfig, Class<?> cls, FieldInfo fieldInfo) throws Exception {
        Class<?> fieldClass = fieldInfo.getFieldClass();
        if (fieldClass == Integer.TYPE || fieldClass == Long.TYPE || fieldClass == String.class) {
            return createStringFieldDeserializer(parserConfig, cls, fieldInfo);
        }
        return parserConfig.createFieldDeserializerWithoutASM(parserConfig, cls, fieldInfo);
    }

    public FieldDeserializer createStringFieldDeserializer(ParserConfig parserConfig, Class<?> cls, FieldInfo fieldInfo) throws Exception {
        Class cls2;
        char c;
        int i;
        char c2;
        Class<?> fieldClass = fieldInfo.getFieldClass();
        Method method = fieldInfo.getMethod();
        String genFieldDeserializer = getGenFieldDeserializer(cls, fieldInfo);
        ClassWriter classWriter = new ClassWriter();
        if (fieldClass == Integer.TYPE) {
            cls2 = IntegerFieldDeserializer.class;
        } else if (fieldClass == Long.TYPE) {
            cls2 = LongFieldDeserializer.class;
        } else {
            cls2 = StringFieldDeserializer.class;
        }
        Class cls3 = cls2;
        int i2 = cls.isInterface() ? 185 : 182;
        classWriter.visit(49, 33, genFieldDeserializer, ASMUtils.getType(cls3), null);
        MethodVisitor methodVisitorVisitMethod = classWriter.visitMethod(1, "<init>", "(Lcom/alibaba/fastjson/parser/ParserConfig;Ljava/lang/Class;Lcom/alibaba/fastjson/util/FieldInfo;)V", null, null);
        methodVisitorVisitMethod.visitVarInsn(25, 0);
        methodVisitorVisitMethod.visitVarInsn(25, 1);
        methodVisitorVisitMethod.visitVarInsn(25, 2);
        methodVisitorVisitMethod.visitVarInsn(25, 3);
        methodVisitorVisitMethod.visitMethodInsn(183, ASMUtils.getType(cls3), "<init>", "(Lcom/alibaba/fastjson/parser/ParserConfig;Ljava/lang/Class;Lcom/alibaba/fastjson/util/FieldInfo;)V");
        methodVisitorVisitMethod.visitInsn(177);
        methodVisitorVisitMethod.visitMaxs(4, 6);
        methodVisitorVisitMethod.visitEnd();
        if (method == null) {
            c = 1;
            i = 3;
            c2 = 2;
        } else if (fieldClass == Integer.TYPE) {
            c = 1;
            MethodVisitor methodVisitorVisitMethod2 = classWriter.visitMethod(1, "setValue", "(Ljava/lang/Object;I)V", null, null);
            methodVisitorVisitMethod2.visitVarInsn(25, 1);
            methodVisitorVisitMethod2.visitTypeInsn(192, ASMUtils.getType(method.getDeclaringClass()));
            methodVisitorVisitMethod2.visitVarInsn(21, 2);
            methodVisitorVisitMethod2.visitMethodInsn(i2, ASMUtils.getType(method.getDeclaringClass()), method.getName(), ASMUtils.getDesc(method));
            methodVisitorVisitMethod2.visitInsn(177);
            methodVisitorVisitMethod2.visitMaxs(3, 3);
            methodVisitorVisitMethod2.visitEnd();
            c2 = 2;
            i = 3;
        } else {
            c = 1;
            if (fieldClass == Long.TYPE) {
                MethodVisitor methodVisitorVisitMethod3 = classWriter.visitMethod(1, "setValue", "(Ljava/lang/Object;J)V", null, null);
                methodVisitorVisitMethod3.visitVarInsn(25, 1);
                methodVisitorVisitMethod3.visitTypeInsn(192, ASMUtils.getType(method.getDeclaringClass()));
                methodVisitorVisitMethod3.visitVarInsn(22, 2);
                methodVisitorVisitMethod3.visitMethodInsn(i2, ASMUtils.getType(method.getDeclaringClass()), method.getName(), ASMUtils.getDesc(method));
                methodVisitorVisitMethod3.visitInsn(177);
                methodVisitorVisitMethod3.visitMaxs(3, 4);
                methodVisitorVisitMethod3.visitEnd();
                i = 3;
                c2 = 2;
            } else {
                MethodVisitor methodVisitorVisitMethod4 = classWriter.visitMethod(1, "setValue", "(Ljava/lang/Object;Ljava/lang/Object;)V", null, null);
                methodVisitorVisitMethod4.visitVarInsn(25, 1);
                methodVisitorVisitMethod4.visitTypeInsn(192, ASMUtils.getType(method.getDeclaringClass()));
                c2 = 2;
                methodVisitorVisitMethod4.visitVarInsn(25, 2);
                methodVisitorVisitMethod4.visitTypeInsn(192, ASMUtils.getType(fieldClass));
                methodVisitorVisitMethod4.visitMethodInsn(i2, ASMUtils.getType(method.getDeclaringClass()), method.getName(), ASMUtils.getDesc(method));
                methodVisitorVisitMethod4.visitInsn(177);
                i = 3;
                methodVisitorVisitMethod4.visitMaxs(3, 3);
                methodVisitorVisitMethod4.visitEnd();
            }
        }
        byte[] byteArray = classWriter.toByteArray();
        Class<?> clsDefineClassPublic = this.classLoader.defineClassPublic(genFieldDeserializer, byteArray, 0, byteArray.length);
        Class<?>[] clsArr = new Class[i];
        clsArr[0] = ParserConfig.class;
        clsArr[c] = Class.class;
        clsArr[c2] = FieldInfo.class;
        return (FieldDeserializer) clsDefineClassPublic.getConstructor(clsArr).newInstance(parserConfig, cls, fieldInfo);
    }

    static class Context {
        private final DeserializeBeanInfo beanInfo;
        private String className;
        private Class<?> clazz;
        private List<FieldInfo> fieldInfoList;
        private int variantIndex;
        private Map<String, Integer> variants = new HashMap();

        public DeserializeBeanInfo getBeanInfo() {
            return this.beanInfo;
        }

        public String getClassName() {
            return this.className;
        }

        public Class<?> getClazz() {
            return this.clazz;
        }

        public List<FieldInfo> getFieldInfoList() {
            return this.fieldInfoList;
        }

        public int getVariantCount() {
            return this.variantIndex;
        }

        public Context(String str, ParserConfig parserConfig, DeserializeBeanInfo deserializeBeanInfo, int i) {
            this.variantIndex = 5;
            this.className = str;
            this.clazz = deserializeBeanInfo.getClazz();
            this.variantIndex = i;
            this.beanInfo = deserializeBeanInfo;
            this.fieldInfoList = new ArrayList(deserializeBeanInfo.getFieldList());
        }

        public int var(String str, int i) {
            if (this.variants.get(str) == null) {
                this.variants.put(str, Integer.valueOf(this.variantIndex));
                this.variantIndex += i;
            }
            return this.variants.get(str).intValue();
        }

        public int var(String str) {
            if (this.variants.get(str) == null) {
                Map<String, Integer> map = this.variants;
                int i = this.variantIndex;
                this.variantIndex = i + 1;
                map.put(str, Integer.valueOf(i));
            }
            return this.variants.get(str).intValue();
        }
    }

    private void _init(ClassWriter classWriter, Context context) {
        int size = context.getFieldInfoList().size();
        for (int i = 0; i < size; i++) {
            classWriter.visitField(1, context.getFieldInfoList().get(i).getName() + "_asm_prefix__", "[C").visitEnd();
        }
        int size2 = context.getFieldInfoList().size();
        for (int i2 = 0; i2 < size2; i2++) {
            FieldInfo fieldInfo = context.getFieldInfoList().get(i2);
            Class<?> fieldClass = fieldInfo.getFieldClass();
            if (!fieldClass.isPrimitive() && !fieldClass.isEnum()) {
                if (Collection.class.isAssignableFrom(fieldClass)) {
                    classWriter.visitField(1, fieldInfo.getName() + "_asm_list_item_deser__", "Lcom/alibaba/fastjson/parser/deserializer/ObjectDeserializer;").visitEnd();
                } else {
                    classWriter.visitField(1, fieldInfo.getName() + "_asm_deser__", "Lcom/alibaba/fastjson/parser/deserializer/ObjectDeserializer;").visitEnd();
                }
            }
        }
        MethodVisitor methodVisitorVisitMethod = classWriter.visitMethod(1, "<init>", "(Lcom/alibaba/fastjson/parser/ParserConfig;Ljava/lang/Class;)V", null, null);
        methodVisitorVisitMethod.visitVarInsn(25, 0);
        methodVisitorVisitMethod.visitVarInsn(25, 1);
        methodVisitorVisitMethod.visitVarInsn(25, 2);
        methodVisitorVisitMethod.visitMethodInsn(183, "com/alibaba/fastjson/parser/deserializer/ASMJavaBeanDeserializer", "<init>", "(Lcom/alibaba/fastjson/parser/ParserConfig;Ljava/lang/Class;)V");
        methodVisitorVisitMethod.visitVarInsn(25, 0);
        methodVisitorVisitMethod.visitFieldInsn(180, "com/alibaba/fastjson/parser/deserializer/ASMJavaBeanDeserializer", "serializer", "Lcom/alibaba/fastjson/parser/deserializer/ASMJavaBeanDeserializer$InnerJavaBeanDeserializer;");
        methodVisitorVisitMethod.visitMethodInsn(182, "com/alibaba/fastjson/parser/deserializer/JavaBeanDeserializer", "getFieldDeserializerMap", "()Ljava/util/Map;");
        methodVisitorVisitMethod.visitInsn(87);
        int size3 = context.getFieldInfoList().size();
        for (int i3 = 0; i3 < size3; i3++) {
            FieldInfo fieldInfo2 = context.getFieldInfoList().get(i3);
            methodVisitorVisitMethod.visitVarInsn(25, 0);
            methodVisitorVisitMethod.visitLdcInsn("\"" + fieldInfo2.getName() + "\":");
            methodVisitorVisitMethod.visitMethodInsn(182, "java/lang/String", "toCharArray", "()[C");
            methodVisitorVisitMethod.visitFieldInsn(181, context.getClassName(), fieldInfo2.getName() + "_asm_prefix__", "[C");
        }
        methodVisitorVisitMethod.visitInsn(177);
        methodVisitorVisitMethod.visitMaxs(4, 4);
        methodVisitorVisitMethod.visitEnd();
    }

    private void _createInstance(ClassWriter classWriter, Context context) {
        MethodVisitor methodVisitorVisitMethod = classWriter.visitMethod(1, "createInstance", "(Lcom/alibaba/fastjson/parser/DefaultJSONParser;Ljava/lang/reflect/Type;)Ljava/lang/Object;", null, null);
        methodVisitorVisitMethod.visitTypeInsn(187, ASMUtils.getType(context.getClazz()));
        methodVisitorVisitMethod.visitInsn(89);
        methodVisitorVisitMethod.visitMethodInsn(183, ASMUtils.getType(context.getClazz()), "<init>", "()V");
        methodVisitorVisitMethod.visitInsn(176);
        methodVisitorVisitMethod.visitMaxs(3, 3);
        methodVisitorVisitMethod.visitEnd();
    }
}
