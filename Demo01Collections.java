package Collectins;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
    * `java.utils.Collections`是集合工具类，用来对集合进行操作。部分方法如下：

    - `public static <T> boolean addAll(Collection<T> c, T... elements)  `:往集合中添加一些元素。
    - `public static void shuffle(List<?> list) 打乱顺序`:打乱集合顺序。
    - `public static <T> void sort(List<T> list)`:将集合中元素按照默认规则排序。
    - `public static <T> void sort(List<T> list，Comparator<? super T> c )`:将集合中元素按照指定规则排序。
 */
public class Demo01Collections {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<>();
        Collections.addAll(strings, "abc", "mbc", "cbc");
        System.out.println(strings);
//        Collections.shuffle((strings));
//        System.out.println(strings);
//        Collections.sort(strings);
//        System.out.println(strings);
        Collections.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.charAt(0)-o2.charAt(0);
                //o1和o2每次只取两个相邻的数据,且顺序相反
                //例如:在这段代码,{abc,mbc}相邻,则o1取"mbc",o2取"abc"
                //依据第一个字母排序,o1.charAt(0) o2.charAt(0)
                //若o1.charAt(0)-o2.charAt(0) >= 0, 则o1,o2不做改变
                //若o1.charAt(0)-o2.charAt(0) < 0, 则o1,o2互换位置
                //由此即可总结规律, 若想如 abc 升序排列 则 o1 - o2 >= o;反之则, o1 - o2 < 0
                //扩展: 若想按复杂条件排序需要使用if语句
            }

            @Override
            public boolean equals(Object obj) {
                return false;
            }
        });
        System.out.println(strings);
    }
}
