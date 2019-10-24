import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by liuchao on 15/11/26.
 */
public class ReflectUtil {
    static Logger logger = LoggerFactory.getLogger(ReflectUtil.class);

    /**
     * 反射对象字段
     * @param obj
     * @return
     */
    public static Map<String , Object> getHumpMap(Object obj) {
        Class<?> bindClass = obj.getClass();
        Map<String  , Object> objMap = new HashMap<>(0);

        /*
         * 得到类中的所有属性集合
         */
        try {
            Field[] fs = bindClass.getDeclaredFields();
            for(Field f : fs){
                //设置些属性是可以访问的
                f.setAccessible(true);
                Object o = f.get(obj);

            }
        } catch (IllegalAccessException e) {
            System.out.println(e.getMessage());
        }
        return objMap;
    }


    public static Class<?> wrapper(Class<?> type) {
        if (type == null) {
            return null;
        } else if (type.isPrimitive()) {
            if (boolean.class == type) {
                return Boolean.class;
            } else if (int.class == type) {
                return Integer.class;
            } else if (long.class == type) {
                return Long.class;
            } else if (short.class == type) {
                return Short.class;
            } else if (byte.class == type) {
                return Byte.class;
            } else if (double.class == type) {
                return Double.class;
            } else if (float.class == type) {
                return Float.class;
            } else if (char.class == type) {
                return Character.class;
            } else if (void.class == type) {
                return Void.class;
            }
        }
        return type;
    }
}
