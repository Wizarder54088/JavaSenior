package com.atnjupt.exer1;

import java.util.*;

/**
 * 定义个泛型类 DAO<T>，在其中定义一个Map 成员变量，Map 的键为 String 类型，值为 T 类型。
 * <p>
 * 分别创建以下方法：
 * public void save(String id,T entity)： 保存 T 类型的对象到 Map 成员变量中
 * public T get(String id)：从 map 中获取 id 对应的对象
 * public void update(String id,T entity)：替换 map 中key为id的内容,改为 entity 对象
 * public List<T> list()：返回 map 中存放的所有 T 对象
 * public void delete(String id)：删除指定 id 对象
 *
 * @author Wizarder
 * @create 2021-03-03 20:10
 */
public class DAO<T> {
    Map<String, T> map = new HashMap<>();

    public DAO() {
    }

    //保存 T 类型的对象到 Map 成员变量中
    public void save(String id, T entity) {
        map.put(id, entity);
    }

    //从 map 中获取 id 对应的对象
    public T get(String id) {
        T t = map.get(id);
        return t;
    }

    //替换 map 中key为id的内容,改为 entity 对象
    public void update(String id, T entity) {
        if (map.containsKey(id)) {
            map.put(id, entity);
        }
        return;
    }

    //返回 map 中存放的所有 T 对象
    public List<T> list() {
        Collection<T> values = map.values();
        List<T> list = new ArrayList<>();

        for (T t : values) {
            list.add(t);
        }
        return list;
    }

    //删除指定 id 对象
    public void delete(String key) {
        map.remove(key);
    }

}
