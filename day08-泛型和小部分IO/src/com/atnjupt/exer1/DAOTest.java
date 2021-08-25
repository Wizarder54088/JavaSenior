package com.atnjupt.exer1;

import java.util.Iterator;
import java.util.List;

/**
 * 创建 DAO 类的对象， 分别调用其 save、get、update、list、delete 方法来操作 User 对象，
 * 使用 Junit 单元测试类进行测试。
 *
 * @author Wizarder
 * @create 2021-03-03 20:53
 */
public class DAOTest {
    public static void main(String[] args) {
        DAO<User> dao = new DAO<>();

        dao.save("AA", new User(1001, 33, "王力宏"));
        dao.save("BB", new User(1002, 27, "林俊杰"));
        dao.save("CC", new User(1003, 45, "周杰伦"));

        dao.update("CC", new User(1004, 55, "许嵩"));
        dao.delete("BB");
        List<User> list = dao.list();
        Iterator<User> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
