package cn.polarismesh.agent.plugin.nacos.asm;


import org.objectweb.asm.*;



public class ProxyDump implements Opcodes {




    public static byte[] createDynamicNamingProxyClass() {


        ClassWriter classWriter = new ClassWriter(0);
        FieldVisitor fieldVisitor;
        RecordComponentVisitor recordComponentVisitor;
        MethodVisitor methodVisitor;
        AnnotationVisitor annotationVisitor0;

        classWriter.visit(V1_8, ACC_PUBLIC | ACC_SUPER, "cn/polarismesh/agent/plugin/nacos/delegate/DynamicNamingProxy", null, "com/alibaba/nacos/client/naming/net/NamingProxy", null);

        classWriter.visitSource("DynamicNamingProxy.java", null);

        {
            fieldVisitor = classWriter.visitField(ACC_PRIVATE, "secondaryServer", "Ljava/lang/String;", null, null);
            fieldVisitor.visitEnd();
        }
        {
            fieldVisitor = classWriter.visitField(ACC_PRIVATE, "assist", "Lcn/polarismesh/agent/plugin/nacos/delegate/NamingProxyAssist;", null, null);
            fieldVisitor.visitEnd();
        }
        {
            fieldVisitor = classWriter.visitField(ACC_PRIVATE, "logger", "Lorg/slf4j/Logger;", null, null);
            fieldVisitor.visitEnd();
        }
        {
            methodVisitor = classWriter.visitMethod(ACC_PUBLIC, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Properties;)V", null, null);
            methodVisitor.visitCode();
            Label label0 = new Label();
            methodVisitor.visitLabel(label0);
            methodVisitor.visitLineNumber(25, label0);
            methodVisitor.visitVarInsn(ALOAD, 0);
            methodVisitor.visitVarInsn(ALOAD, 1);
            methodVisitor.visitVarInsn(ALOAD, 2);
            methodVisitor.visitVarInsn(ALOAD, 3);
            methodVisitor.visitVarInsn(ALOAD, 4);
            methodVisitor.visitMethodInsn(INVOKESPECIAL, "com/alibaba/nacos/client/naming/net/NamingProxy", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Properties;)V", false);
            Label label1 = new Label();
            methodVisitor.visitLabel(label1);
            methodVisitor.visitLineNumber(21, label1);
            methodVisitor.visitVarInsn(ALOAD, 0);
            methodVisitor.visitLdcInsn("com.alibaba.nacos.client.naming");
            methodVisitor.visitMethodInsn(INVOKESTATIC, "org/slf4j/LoggerFactory", "getLogger", "(Ljava/lang/String;)Lorg/slf4j/Logger;", false);
            methodVisitor.visitFieldInsn(PUTFIELD, "cn/polarismesh/agent/plugin/nacos/delegate/DynamicNamingProxy", "logger", "Lorg/slf4j/Logger;");
            Label label2 = new Label();
            methodVisitor.visitLabel(label2);
            methodVisitor.visitLineNumber(26, label2);
            methodVisitor.visitVarInsn(ALOAD, 0);
            methodVisitor.visitMethodInsn(INVOKESPECIAL, "cn/polarismesh/agent/plugin/nacos/delegate/DynamicNamingProxy", "init", "()V", false);
            Label label3 = new Label();
            methodVisitor.visitLabel(label3);
            methodVisitor.visitLineNumber(27, label3);
            methodVisitor.visitInsn(RETURN);
            Label label4 = new Label();
            methodVisitor.visitLabel(label4);
            methodVisitor.visitLocalVariable("this", "Lcn/polarismesh/agent/plugin/nacos/delegate/DynamicNamingProxy;", null, label0, label4, 0);
            methodVisitor.visitLocalVariable("namespaceId", "Ljava/lang/String;", null, label0, label4, 1);
            methodVisitor.visitLocalVariable("endpoint", "Ljava/lang/String;", null, label0, label4, 2);
            methodVisitor.visitLocalVariable("serverList", "Ljava/lang/String;", null, label0, label4, 3);
            methodVisitor.visitLocalVariable("properties", "Ljava/util/Properties;", null, label0, label4, 4);
            methodVisitor.visitMaxs(5, 5);
            methodVisitor.visitEnd();
        }
        {
            methodVisitor = classWriter.visitMethod(ACC_PRIVATE, "init", "()V", null, null);
            methodVisitor.visitCode();
            Label label0 = new Label();
            methodVisitor.visitLabel(label0);
            methodVisitor.visitLineNumber(30, label0);
            methodVisitor.visitVarInsn(ALOAD, 0);
            methodVisitor.visitLdcInsn("other.nacos.server.addr");
            methodVisitor.visitMethodInsn(INVOKESTATIC, "java/lang/System", "getProperty", "(Ljava/lang/String;)Ljava/lang/String;", false);
            methodVisitor.visitFieldInsn(PUTFIELD, "cn/polarismesh/agent/plugin/nacos/delegate/DynamicNamingProxy", "secondaryServer", "Ljava/lang/String;");
            Label label1 = new Label();
            methodVisitor.visitLabel(label1);
            methodVisitor.visitLineNumber(31, label1);
            methodVisitor.visitVarInsn(ALOAD, 0);
            methodVisitor.visitTypeInsn(NEW, "cn/polarismesh/agent/plugin/nacos/delegate/NamingProxyAssist");
            methodVisitor.visitInsn(DUP);
            methodVisitor.visitMethodInsn(INVOKESPECIAL, "cn/polarismesh/agent/plugin/nacos/delegate/NamingProxyAssist", "<init>", "()V", false);
            methodVisitor.visitFieldInsn(PUTFIELD, "cn/polarismesh/agent/plugin/nacos/delegate/DynamicNamingProxy", "assist", "Lcn/polarismesh/agent/plugin/nacos/delegate/NamingProxyAssist;");
            Label label2 = new Label();
            methodVisitor.visitLabel(label2);
            methodVisitor.visitLineNumber(32, label2);
            methodVisitor.visitInsn(RETURN);
            Label label3 = new Label();
            methodVisitor.visitLabel(label3);
            methodVisitor.visitLocalVariable("this", "Lcn/polarismesh/agent/plugin/nacos/delegate/DynamicNamingProxy;", null, label0, label3, 0);
            methodVisitor.visitMaxs(3, 1);
            methodVisitor.visitEnd();
        }
        {
            methodVisitor = classWriter.visitMethod(ACC_PUBLIC, "callServer", "(Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "(Ljava/lang/String;Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", new String[]{"com/alibaba/nacos/api/exception/NacosException"});
            methodVisitor.visitCode();
            Label label0 = new Label();
            Label label1 = new Label();
            Label label2 = new Label();
            methodVisitor.visitTryCatchBlock(label0, label1, label2, "java/lang/Exception");
            Label label3 = new Label();
            Label label4 = new Label();
            Label label5 = new Label();
            methodVisitor.visitTryCatchBlock(label3, label4, label5, "com/alibaba/nacos/api/exception/NacosException");
            Label label6 = new Label();
            methodVisitor.visitLabel(label6);
            methodVisitor.visitLineNumber(36, label6);
            methodVisitor.visitTypeInsn(NEW, "java/lang/StringBuilder");
            methodVisitor.visitInsn(DUP);
            methodVisitor.visitMethodInsn(INVOKESPECIAL, "java/lang/StringBuilder", "<init>", "()V", false);
            methodVisitor.visitVarInsn(ALOAD, 1);
            methodVisitor.visitMethodInsn(INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(Ljava/lang/String;)Ljava/lang/StringBuilder;", false);
            methodVisitor.visitLdcInsn("@");
            methodVisitor.visitMethodInsn(INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(Ljava/lang/String;)Ljava/lang/StringBuilder;", false);
            methodVisitor.visitVarInsn(ALOAD, 5);
            methodVisitor.visitMethodInsn(INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(Ljava/lang/String;)Ljava/lang/StringBuilder;", false);
            methodVisitor.visitMethodInsn(INVOKEVIRTUAL, "java/lang/StringBuilder", "toString", "()Ljava/lang/String;", false);
            methodVisitor.visitVarInsn(ASTORE, 6);
            Label label7 = new Label();
            methodVisitor.visitLabel(label7);
            methodVisitor.visitLineNumber(39, label7);
            methodVisitor.visitFieldInsn(GETSTATIC, "cn/polarismesh/agent/plugin/nacos/constants/NacosConstants", "REGISTER_SERVICE", "Ljava/lang/String;");
            methodVisitor.visitVarInsn(ALOAD, 6);
            methodVisitor.visitMethodInsn(INVOKEVIRTUAL, "java/lang/String", "equals", "(Ljava/lang/Object;)Z", false);
            Label label8 = new Label();
            methodVisitor.visitJumpInsn(IFEQ, label8);
            methodVisitor.visitLabel(label0);
            methodVisitor.visitLineNumber(41, label0);
            methodVisitor.visitVarInsn(ALOAD, 0);
            methodVisitor.visitFieldInsn(GETFIELD, "cn/polarismesh/agent/plugin/nacos/delegate/DynamicNamingProxy", "assist", "Lcn/polarismesh/agent/plugin/nacos/delegate/NamingProxyAssist;");
            methodVisitor.visitVarInsn(ALOAD, 2);
            methodVisitor.visitMethodInsn(INVOKEVIRTUAL, "cn/polarismesh/agent/plugin/nacos/delegate/NamingProxyAssist", "fillMetadata", "(Ljava/util/Map;)V", false);
            methodVisitor.visitLabel(label1);
            methodVisitor.visitLineNumber(44, label1);
            methodVisitor.visitJumpInsn(GOTO, label8);
            methodVisitor.visitLabel(label2);
            methodVisitor.visitLineNumber(42, label2);
            methodVisitor.visitFrame(Opcodes.F_FULL, 7, new Object[]{"cn/polarismesh/agent/plugin/nacos/delegate/DynamicNamingProxy", "java/lang/String", "java/util/Map", "java/util/Map", "java/lang/String", "java/lang/String", "java/lang/String"}, 1, new Object[]{"java/lang/Exception"});
            methodVisitor.visitVarInsn(ASTORE, 7);
            Label label9 = new Label();
            methodVisitor.visitLabel(label9);
            methodVisitor.visitLineNumber(43, label9);
            methodVisitor.visitVarInsn(ALOAD, 0);
            methodVisitor.visitFieldInsn(GETFIELD, "cn/polarismesh/agent/plugin/nacos/delegate/DynamicNamingProxy", "logger", "Lorg/slf4j/Logger;");
            methodVisitor.visitLdcInsn("register service fillMetadata failed: ");
            methodVisitor.visitVarInsn(ALOAD, 7);
            methodVisitor.visitMethodInsn(INVOKEINTERFACE, "org/slf4j/Logger", "error", "(Ljava/lang/String;Ljava/lang/Throwable;)V", true);
            methodVisitor.visitLabel(label8);
            methodVisitor.visitLineNumber(48, label8);
            methodVisitor.visitFrame(Opcodes.F_SAME, 0, null, 0, null);
            methodVisitor.visitFieldInsn(GETSTATIC, "cn/polarismesh/agent/plugin/nacos/constants/NacosConstants", "QUERY_LIST", "Ljava/lang/String;");
            methodVisitor.visitVarInsn(ALOAD, 6);
            methodVisitor.visitMethodInsn(INVOKEVIRTUAL, "java/lang/String", "equals", "(Ljava/lang/Object;)Z", false);
            Label label10 = new Label();
            methodVisitor.visitJumpInsn(IFEQ, label10);
            Label label11 = new Label();
            methodVisitor.visitLabel(label11);
            methodVisitor.visitLineNumber(49, label11);
            methodVisitor.visitVarInsn(ALOAD, 0);
            methodVisitor.visitVarInsn(ALOAD, 1);
            methodVisitor.visitVarInsn(ALOAD, 2);
            methodVisitor.visitVarInsn(ALOAD, 3);
            methodVisitor.visitVarInsn(ALOAD, 4);
            methodVisitor.visitVarInsn(ALOAD, 5);
            methodVisitor.visitMethodInsn(INVOKESPECIAL, "cn/polarismesh/agent/plugin/nacos/delegate/DynamicNamingProxy", "queryListCallServerProxy", "(Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", false);
            methodVisitor.visitInsn(ARETURN);
            methodVisitor.visitLabel(label10);
            methodVisitor.visitLineNumber(52, label10);
            methodVisitor.visitFrame(Opcodes.F_SAME, 0, null, 0, null);
            methodVisitor.visitVarInsn(ALOAD, 0);
            methodVisitor.visitVarInsn(ALOAD, 1);
            methodVisitor.visitVarInsn(ALOAD, 2);
            methodVisitor.visitVarInsn(ALOAD, 3);
            methodVisitor.visitVarInsn(ALOAD, 4);
            methodVisitor.visitVarInsn(ALOAD, 5);
            methodVisitor.visitMethodInsn(INVOKESPECIAL, "com/alibaba/nacos/client/naming/net/NamingProxy", "callServer", "(Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", false);
            methodVisitor.visitVarInsn(ASTORE, 7);
            methodVisitor.visitLabel(label3);
            methodVisitor.visitLineNumber(54, label3);
            methodVisitor.visitVarInsn(ALOAD, 0);
            methodVisitor.visitVarInsn(ALOAD, 1);
            methodVisitor.visitVarInsn(ALOAD, 2);
            methodVisitor.visitVarInsn(ALOAD, 3);
            methodVisitor.visitVarInsn(ALOAD, 0);
            methodVisitor.visitFieldInsn(GETFIELD, "cn/polarismesh/agent/plugin/nacos/delegate/DynamicNamingProxy", "secondaryServer", "Ljava/lang/String;");
            methodVisitor.visitVarInsn(ALOAD, 5);
            methodVisitor.visitMethodInsn(INVOKESPECIAL, "com/alibaba/nacos/client/naming/net/NamingProxy", "callServer", "(Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", false);
            methodVisitor.visitInsn(POP);
            methodVisitor.visitLabel(label4);
            methodVisitor.visitLineNumber(57, label4);
            Label label12 = new Label();
            methodVisitor.visitJumpInsn(GOTO, label12);
            methodVisitor.visitLabel(label5);
            methodVisitor.visitLineNumber(55, label5);
            methodVisitor.visitFrame(Opcodes.F_FULL, 8, new Object[]{"cn/polarismesh/agent/plugin/nacos/delegate/DynamicNamingProxy", "java/lang/String", "java/util/Map", "java/util/Map", "java/lang/String", "java/lang/String", "java/lang/String", "java/lang/String"}, 1, new Object[]{"com/alibaba/nacos/api/exception/NacosException"});
            methodVisitor.visitVarInsn(ASTORE, 8);
            Label label13 = new Label();
            methodVisitor.visitLabel(label13);
            methodVisitor.visitLineNumber(56, label13);
            methodVisitor.visitFieldInsn(GETSTATIC, "com/alibaba/nacos/client/utils/LogUtils", "NAMING_LOGGER", "Lorg/slf4j/Logger;");
            methodVisitor.visitLdcInsn("secondaryServer callServer failed: {} ");
            methodVisitor.visitVarInsn(ALOAD, 0);
            methodVisitor.visitFieldInsn(GETFIELD, "cn/polarismesh/agent/plugin/nacos/delegate/DynamicNamingProxy", "secondaryServer", "Ljava/lang/String;");
            methodVisitor.visitVarInsn(ALOAD, 8);
            methodVisitor.visitMethodInsn(INVOKEINTERFACE, "org/slf4j/Logger", "error", "(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V", true);
            methodVisitor.visitLabel(label12);
            methodVisitor.visitLineNumber(58, label12);
            methodVisitor.visitFrame(Opcodes.F_SAME, 0, null, 0, null);
            methodVisitor.visitVarInsn(ALOAD, 7);
            methodVisitor.visitInsn(ARETURN);
            Label label14 = new Label();
            methodVisitor.visitLabel(label14);
            methodVisitor.visitLocalVariable("e", "Ljava/lang/Exception;", null, label9, label8, 7);
            methodVisitor.visitLocalVariable("e", "Lcom/alibaba/nacos/api/exception/NacosException;", null, label13, label12, 8);
            methodVisitor.visitLocalVariable("this", "Lcn/polarismesh/agent/plugin/nacos/delegate/DynamicNamingProxy;", null, label6, label14, 0);
            methodVisitor.visitLocalVariable("api", "Ljava/lang/String;", null, label6, label14, 1);
            methodVisitor.visitLocalVariable("params", "Ljava/util/Map;", "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;", label6, label14, 2);
            methodVisitor.visitLocalVariable("body", "Ljava/util/Map;", "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;", label6, label14, 3);
            methodVisitor.visitLocalVariable("curServer", "Ljava/lang/String;", null, label6, label14, 4);
            methodVisitor.visitLocalVariable("method", "Ljava/lang/String;", null, label6, label14, 5);
            methodVisitor.visitLocalVariable("fullApi", "Ljava/lang/String;", null, label7, label14, 6);
            methodVisitor.visitLocalVariable("s", "Ljava/lang/String;", null, label3, label14, 7);
            methodVisitor.visitMaxs(6, 9);
            methodVisitor.visitEnd();
        }
        {
            methodVisitor = classWriter.visitMethod(ACC_PRIVATE, "queryListCallServerProxy", "(Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "(Ljava/lang/String;Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", new String[]{"com/alibaba/nacos/api/exception/NacosException"});
            methodVisitor.visitCode();
            Label label0 = new Label();
            Label label1 = new Label();
            Label label2 = new Label();
            methodVisitor.visitTryCatchBlock(label0, label1, label2, "com/alibaba/nacos/api/exception/NacosException");
            Label label3 = new Label();
            Label label4 = new Label();
            Label label5 = new Label();
            methodVisitor.visitTryCatchBlock(label3, label4, label5, "java/lang/Exception");
            Label label6 = new Label();
            methodVisitor.visitLabel(label6);
            methodVisitor.visitLineNumber(62, label6);
            methodVisitor.visitVarInsn(ALOAD, 0);
            methodVisitor.visitVarInsn(ALOAD, 1);
            methodVisitor.visitVarInsn(ALOAD, 2);
            methodVisitor.visitVarInsn(ALOAD, 3);
            methodVisitor.visitVarInsn(ALOAD, 4);
            methodVisitor.visitVarInsn(ALOAD, 5);
            methodVisitor.visitMethodInsn(INVOKESPECIAL, "com/alibaba/nacos/client/naming/net/NamingProxy", "callServer", "(Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", false);
            methodVisitor.visitVarInsn(ASTORE, 6);
            Label label7 = new Label();
            methodVisitor.visitLabel(label7);
            methodVisitor.visitLineNumber(63, label7);
            methodVisitor.visitLdcInsn("");
            methodVisitor.visitVarInsn(ASTORE, 7);
            methodVisitor.visitLabel(label0);
            methodVisitor.visitLineNumber(65, label0);
            methodVisitor.visitVarInsn(ALOAD, 0);
            methodVisitor.visitVarInsn(ALOAD, 1);
            methodVisitor.visitVarInsn(ALOAD, 2);
            methodVisitor.visitVarInsn(ALOAD, 3);
            methodVisitor.visitVarInsn(ALOAD, 0);
            methodVisitor.visitFieldInsn(GETFIELD, "cn/polarismesh/agent/plugin/nacos/delegate/DynamicNamingProxy", "secondaryServer", "Ljava/lang/String;");
            methodVisitor.visitVarInsn(ALOAD, 5);
            methodVisitor.visitMethodInsn(INVOKESPECIAL, "com/alibaba/nacos/client/naming/net/NamingProxy", "callServer", "(Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", false);
            methodVisitor.visitVarInsn(ASTORE, 7);
            methodVisitor.visitLabel(label1);
            methodVisitor.visitLineNumber(68, label1);
            methodVisitor.visitJumpInsn(GOTO, label3);
            methodVisitor.visitLabel(label2);
            methodVisitor.visitLineNumber(66, label2);
            methodVisitor.visitFrame(Opcodes.F_FULL, 8, new Object[]{"cn/polarismesh/agent/plugin/nacos/delegate/DynamicNamingProxy", "java/lang/String", "java/util/Map", "java/util/Map", "java/lang/String", "java/lang/String", "java/lang/String", "java/lang/String"}, 1, new Object[]{"com/alibaba/nacos/api/exception/NacosException"});
            methodVisitor.visitVarInsn(ASTORE, 8);
            Label label8 = new Label();
            methodVisitor.visitLabel(label8);
            methodVisitor.visitLineNumber(67, label8);
            methodVisitor.visitVarInsn(ALOAD, 0);
            methodVisitor.visitFieldInsn(GETFIELD, "cn/polarismesh/agent/plugin/nacos/delegate/DynamicNamingProxy", "logger", "Lorg/slf4j/Logger;");
            methodVisitor.visitLdcInsn("queryListCallServerProxy  {} failed.");
            methodVisitor.visitVarInsn(ALOAD, 0);
            methodVisitor.visitFieldInsn(GETFIELD, "cn/polarismesh/agent/plugin/nacos/delegate/DynamicNamingProxy", "secondaryServer", "Ljava/lang/String;");
            methodVisitor.visitVarInsn(ALOAD, 8);
            methodVisitor.visitMethodInsn(INVOKEINTERFACE, "org/slf4j/Logger", "error", "(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V", true);
            methodVisitor.visitLabel(label3);
            methodVisitor.visitLineNumber(70, label3);
            methodVisitor.visitFrame(Opcodes.F_SAME, 0, null, 0, null);
            methodVisitor.visitVarInsn(ALOAD, 0);
            methodVisitor.visitFieldInsn(GETFIELD, "cn/polarismesh/agent/plugin/nacos/delegate/DynamicNamingProxy", "assist", "Lcn/polarismesh/agent/plugin/nacos/delegate/NamingProxyAssist;");
            methodVisitor.visitVarInsn(ALOAD, 6);
            methodVisitor.visitVarInsn(ALOAD, 7);
            methodVisitor.visitMethodInsn(INVOKEVIRTUAL, "cn/polarismesh/agent/plugin/nacos/delegate/NamingProxyAssist", "mergeResult", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", false);
            methodVisitor.visitLabel(label4);
            methodVisitor.visitInsn(ARETURN);
            methodVisitor.visitLabel(label5);
            methodVisitor.visitLineNumber(71, label5);
            methodVisitor.visitFrame(Opcodes.F_SAME1, 0, null, 1, new Object[]{"java/lang/Exception"});
            methodVisitor.visitVarInsn(ASTORE, 8);
            Label label9 = new Label();
            methodVisitor.visitLabel(label9);
            methodVisitor.visitLineNumber(72, label9);
            methodVisitor.visitVarInsn(ALOAD, 0);
            methodVisitor.visitFieldInsn(GETFIELD, "cn/polarismesh/agent/plugin/nacos/delegate/DynamicNamingProxy", "logger", "Lorg/slf4j/Logger;");
            methodVisitor.visitLdcInsn("mergeResult failed: ");
            methodVisitor.visitVarInsn(ALOAD, 8);
            methodVisitor.visitMethodInsn(INVOKEINTERFACE, "org/slf4j/Logger", "error", "(Ljava/lang/String;Ljava/lang/Throwable;)V", true);
            Label label10 = new Label();
            methodVisitor.visitLabel(label10);
            methodVisitor.visitLineNumber(73, label10);
            methodVisitor.visitVarInsn(ALOAD, 6);
            methodVisitor.visitInsn(ARETURN);
            Label label11 = new Label();
            methodVisitor.visitLabel(label11);
            methodVisitor.visitLocalVariable("e", "Lcom/alibaba/nacos/api/exception/NacosException;", null, label8, label3, 8);
            methodVisitor.visitLocalVariable("e", "Ljava/lang/Exception;", null, label9, label11, 8);
            methodVisitor.visitLocalVariable("this", "Lcn/polarismesh/agent/plugin/nacos/delegate/DynamicNamingProxy;", null, label6, label11, 0);
            methodVisitor.visitLocalVariable("api", "Ljava/lang/String;", null, label6, label11, 1);
            methodVisitor.visitLocalVariable("params", "Ljava/util/Map;", "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;", label6, label11, 2);
            methodVisitor.visitLocalVariable("body", "Ljava/util/Map;", "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;", label6, label11, 3);
            methodVisitor.visitLocalVariable("curServer", "Ljava/lang/String;", null, label6, label11, 4);
            methodVisitor.visitLocalVariable("method", "Ljava/lang/String;", null, label6, label11, 5);
            methodVisitor.visitLocalVariable("primaryList", "Ljava/lang/String;", null, label7, label11, 6);
            methodVisitor.visitLocalVariable("secondaryList", "Ljava/lang/String;", null, label0, label11, 7);
            methodVisitor.visitMaxs(6, 9);
            methodVisitor.visitEnd();
        }
        classWriter.visitEnd();

        return classWriter.toByteArray();
    }
}