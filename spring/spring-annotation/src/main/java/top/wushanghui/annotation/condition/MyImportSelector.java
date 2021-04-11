package top.wushanghui.annotation.condition;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.function.Predicate;

/**
 * @author jue
 * @date 2021/4/10 18:06
 * @describe
 */
public class MyImportSelector implements ImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        // 千万不能返回空值
        return new String[]{"top.wushanghui.annotation.entity.Cat"};
    }

    @Override
    public Predicate<String> getExclusionFilter() {
        return null;
    }
}
