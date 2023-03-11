package annotation.Processors;

import javax.annotation.processing.Filer;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.Elements;
import javax.tools.JavaFileObject;
import java.io.IOException;
import java.io.Writer;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @auther 齿轮
 * @create 2023-03-11-17:05
 */
public class FactoryGroupedClasses {
    private String qualifiedClassName;
    private Map<String, FactoryAnnotatedClass> itemsMap =
            new LinkedHashMap<String, FactoryAnnotatedClass>();

    public FactoryGroupedClasses(String qualifiedClassName) {
        this.qualifiedClassName = qualifiedClassName;
    }

    public void add(FactoryAnnotatedClass toInsert) throws Exception {

        FactoryAnnotatedClass existing = itemsMap.get(toInsert.getId());
        if (existing != null) {
            throw new Exception("IdAlreadyUsed:" + existing.toString());
        }

        itemsMap.put(toInsert.getId(), toInsert);
    }

    private static final String SUFFIX = "Factory";

    public void generateCode(Elements elementUtils, Filer filer) throws IOException {
        TypeElement superClassName = elementUtils.getTypeElement(qualifiedClassName);
        String factoryClassName = superClassName.getSimpleName() + SUFFIX;

        JavaFileObject jfo = filer.createSourceFile(qualifiedClassName + SUFFIX);
        Writer writer = jfo.openWriter();
//        JavaWriter jw = new JavaWriter(writer);
//
//        // 写包名
//        PackageElement pkg = elementUtils.getPackageOf(superClassName);
//        if (!pkg.isUnnamed()) {
//            jw.emitPackage(pkg.getQualifiedName().toString());
//            jw.emitEmptyLine();
//        } else {
//            jw.emitPackage("");
//        }
//
//        jw.beginType(factoryClassName, "class", EnumSet.of(Modifier.PUBLIC));
//        jw.emitEmptyLine();
//        jw.beginMethod(qualifiedClassName, "create", EnumSet.of(Modifier.PUBLIC), "String", "id");
//
//        jw.beginControlFlow("if (id == null)");
//        jw.emitStatement("throw new IllegalArgumentException(\"id is null!\")");
//        jw.endControlFlow();
//
//        for (FactoryAnnotatedClass item : itemsMap.values()) {
//            jw.beginControlFlow("if (\"%s\".equals(id))", item.getId());
//            jw.emitStatement("return new %s()", item.getTypeElement().getQualifiedName().toString());
//            jw.endControlFlow();
//            jw.emitEmptyLine();
//        }
//
//        jw.emitStatement("throw new IllegalArgumentException(\"Unknown id = \" + id)");
//        jw.endMethod();
//        jw.endType();
//        jw.close();


    }
}
