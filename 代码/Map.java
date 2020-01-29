package Map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
通过查看Map接口描述，看到Map有多个子类，这里我们主要讲解常用的HashMap集合、LinkedHashMap集合。

* **HashMap<K,V>**：存储数据采用的哈希表结构，元素的存取顺序不能保证一致。由于要保证键的唯一、不重复，
* 需要重写键的hashCode()方法、equals()方法。
*
* **LinkedHashMap<K,V>**：HashMap下有个子类LinkedHashMap，存储数据采用的哈希表结构+链表结构。
* 通过链表结构可以保证元素的存取顺序一致；通过哈希表结构可以保证的键的唯一、不重复，
* 需要重写键的hashCode()方法、equals()方法。

> tips：Map接口中的集合都有两个泛型变量<K,V>,在使用时，要为两个泛型变量赋予数据类型。
  两个泛型变量<K,V>的数据类型可以相同，也可以不同。

  Map接口中定义了很多方法，常用的如下：

* `public V put(K key, V value)`:  把指定的键与指定的值添加到Map集合中。
* `public V remove(Object key)`: 把指定的键 所对应的键值对元素 在Map集合中删除，返回被删除元素的值。
* `public V get(Object key)` 根据指定的键，在Map集合中获取对应的值。
* `boolean containsKey(Object key)  ` 判断集合中是否包含指定的键。
* `public Set<K> keySet()`: 获取Map集合中所有的键，存储到Set集合中。
* `public Set<Map.Entry<K,V>> entrySet()`: 获取到Map集合中所有的键值对对象的集合(Set集合)。
 */
public class Demo01Map {
    public static void main(String[] args) {
        HashMap<String, String> stringHashMap = new HashMap<>();
        stringHashMap.put("1", "one");
        stringHashMap.put("2", "two");
        stringHashMap.put("3", "three");
        System.out.println(stringHashMap); // {1=one, 2=two, 3=three}
        stringHashMap.remove("1");
        System.out.println(stringHashMap); // {2=two, 3=three}
        String str1 = stringHashMap.get("2");
        System.out.println(str1); // two
        boolean b1 = stringHashMap.containsKey("1");
        boolean b2 = stringHashMap.containsKey("2");
        System.out.println("b1:" + b1 + " b2:" + b2); // b1:false b2:true
        Set<String> list = stringHashMap.keySet();
        System.out.println(list); // [2, 3]
        // 遍历键找值
        String strY;
        for (String strX : list
                ) {
            strY = stringHashMap.get(strX);
            System.out.println("数字" + strX + "对应的英文单词为:" + strY);
            //数字2对应的英文单词为:two
            // 数字3对应的英文单词为:three
        }
        // 遍历键值对
        Set<Map.Entry<String, String>> entrySet = stringHashMap.entrySet();
        for (Map.Entry<String, String> entry : entrySet) {
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println("数字" + key + "对应的英文单词为:" + value);
            //数字2对应的英文单词为:two
            // 数字3对应的英文单词为:three
        }
    }
}
