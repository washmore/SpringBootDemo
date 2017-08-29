package tech.washmore.demo.springboot;

import org.junit.Assert;
import org.junit.Test;
import tech.washmore.demo.springboot.sorted.Student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Java8SortedDemo extends BaseTest {

    /**
     * 初始化数据
     *
     * @return
     */
    public static List<Student> initData() {
        List<Student> list = new ArrayList<>();
        list.add(new Student(11, "zhangsan", 5));
        list.add(new Student(12, "lisi", 5));
        list.add(new Student(9, "wangwu", 6));
        list.add(new Student(13, "zhaoliu", 6));
        list.add(new Student(8, "tianqi", 3));
        list.add(new Student(6, "wangba", 1));
        list.add(new Student(8, "jiujiu", 2));
        return list;
    }

    /**
     * 传统匿名内部类比较器
     */
    @Test
    public void soreted1() {
        List<Student> list = Java8SortedDemo.initData();
        list.sort(new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return Integer.compare(s1.getAge(), s2.getAge());
            }
        });
        Assert.assertEquals(list.get(0).getNameEn(), "wangba");
    }

    /**
     * 实现Comparable接口
     */
    @Test
    public void soreted2() {
        List<Student> list = Java8SortedDemo.initData();
        Collections.sort(list);
        Assert.assertEquals(list.get(0).getNameEn(), "wangba");
    }

    /**
     * java8的Lambda,显式指定比较类型
     */
    @Test
    public void soreted3() {
        List<Student> list = Java8SortedDemo.initData();
        list.sort((Student s1, Student s2) -> Integer.compare(s1.getAge(), s2.getAge()));
        Assert.assertEquals(list.get(0).getNameEn(), "wangba");
    }

    /**
     * java8的Lambda,不指定比较类型
     */
    @Test
    public void soreted4() {
        List<Student> list = Java8SortedDemo.initData();
        list.sort((s1, s2) -> Integer.compare(s1.getAge(), s2.getAge()));
        Assert.assertEquals(list.get(0).getNameEn(), "wangba");
    }

    /**
     * 自定义静态方法
     */
    @Test
    public void soreted5() {
        List<Student> list = Java8SortedDemo.initData();
        list.sort(Student::compare);
        Assert.assertEquals(list.get(0).getNameEn(), "wangba");
    }

    /**
     * Comparator提供的静态方法
     */
    @Test
    public void soreted6() {
        List<Student> list = Java8SortedDemo.initData();
        list.sort(Comparator.comparing(Student::getAge));
        Assert.assertEquals(list.get(0).getNameEn(), "wangba");
    }

    /**
     * 反转排序
     */
    @Test
    public void soreted7() {
        List<Student> list = Java8SortedDemo.initData();
        list.sort(Comparator.comparing(Student::getAge).reversed());
        Assert.assertEquals(list.get(0).getNameEn(), "zhaoliu");
    }

    /**
     * 多字段组合排序(匿名类方式)
     */
    @Test
    public void soreted8() {
        List<Student> list = Java8SortedDemo.initData();
        list.sort((s1, s2) -> {
            if (Integer.compare(s1.getGrade(), s2.getGrade()) != 0) {
                return Integer.compare(s2.getGrade(), s1.getGrade());
            }
            return Integer.compare(s2.getAge(), s1.getAge());
        });
        Assert.assertEquals(list.get(0).getNameEn(), "zhaoliu");
    }

    /**
     * 多字段组合排序(链式接口)
     */
    @Test
    public void soreted9() {
        List<Student> list = Java8SortedDemo.initData();
        list.sort(Comparator.comparing(Student::getGrade).reversed().thenComparing(Student::getAge));
        Assert.assertEquals(list.get(0).getNameEn(), "wangwu");
    }


}
