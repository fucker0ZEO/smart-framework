package org.smart4j.framework.helper;

import org.smart4j.framework.annotation.Controller;
import org.smart4j.framework.util.ClassUtil;

import java.util.HashSet;
import java.util.Set;

/**操作助手类
 * @author
 */
public class ClassHelper {
    /**
     * 定义类集合（用于存放所加载的类）
     */
    private static final Set<Class<?>> CLASS_SET;

    static {
        String basePackage =ConfigHelper.getAppBasePackage();
        CLASS_SET= ClassUtil.getClassSet(basePackage);
    }
    /**
     * 获取应用包名下的所有类
     */
    public static Set<Class<?>> getClassSet(){
        return CLASS_SET;
    }
    /**
     * 获取应用包名下所有Controller类
     */
    public static Set<Class<?>> getControllerClassSet(){
        HashSet<Class<?>> classSet = new HashSet<>();
        for (Class<?> cls:CLASS_SET){
            if (cls.isAnnotationPresent(Controller.class)){
                classSet.add(cls);
            }
        }
        return classSet;
    }
    /**
     * 获取应用包下所有Bean类（包括：Service,Controller等）
     *
     */
    public static Set<Class<?>> getBeanClassSet(){
        Set<Class<?>> beanClassSet =new HashSet<Class<?>>();
        beanClassSet.addAll(getControllerClassSet());
        beanClassSet.addAll(getControllerClassSet());
        return beanClassSet;
    }
}
