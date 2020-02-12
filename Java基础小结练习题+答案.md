# Object类&Date类&Calender类&StringBuilder类
## 练习一
简述String类中的equals方法与Object类中的equals方法的不同点。   
答：String类中的equals方法是用来判断两个对象的内容是否相同，而Object 类中的equals方法是用来判断两个对象是否是同一个对象，所谓同一个对象指的是内存中的同一块存储空间。
## 练习二：Object类的toString方法
二、不运行代码，直接说出打印结果，并解释原因。
``` java
public class ToStringTest{
    static int i = 1;
    public static void main(String args[]){
        System.out.println("love " + new ToStringTest());//love java
        ToStringTest a = new ToStringTest();
        a.i++;
        System.out.println("me " + a.i);//me 2
    }
    public String toString(){
        System.out.print("I ");//I
        return "java ";
    }
}
```
运行结果：I love java    me 2
原因：当执行代码的时候，首先加载静态变量，然后执行main方法，由于main方法内部第一行代码为输出语句，里面new了此类对象，当执行此行代码时会先创建了本类的对象，由于此类重写了toString方法，会先执行toString方法的打印输出，然后返回“java ”，再执行main方法第一行打印输出。在Java中“System.out.println(类对象名);”实际输出的是该对象的toString()方法返回的字符串，即括号中的内容等价于类对象名.toString(),toString方法的好处是在碰到println方法的时候会被自动调用，不用显示的写出来。
## 练习三：Object类equals方法
三、看下列程序，不运行说结果，写出答案后，并在IntelliJ IDEA中运行看看自己给的答案与运行结果是否正确，并分析原因。
  ``` java
(1)

		String s1 = new String("abc");
		String s2 = "abc";
		System.out.println(s1 == s2);     	//false
		System.out.println(s1.equals(s2));     	//true
	```
  (2)
  ``` java
		String s1 = "abc";
      		String s2 = "abc";
		System.out.println(s1 == s2);     	//true
		System.out.println(s1.equals(s2)); 	//true
	```
  (3)
  ``` java
		String s1 = "a" + "b" + "c";
      		String s2 = "abc";
		System.out.println(s1 == s2);    		 //true
		System.out.println(s1.equals(s2));	 //true
	```
  (4)
  ``` java
		String s1 = "ab";
     		String s2 = "abc";
     		String s3 = s1 + "c";
		System.out.println(s3 == s2);     	//false
    System.out.println(s3.equals(s2));   	//true
  ```  
## 练习四：StringBuilder类与String类的区别
四、简述StringBuilder类与String类的区别。
答：String类的对象内容不可改变，所以每当进行字符串拼接时，总是会在内存中创建一个新的对象，所以经常改变内容的字符串最好不要用String，因为每次生成对象都会对系统性能产生影响。
StringBuilder又称为可变字符序列，是JDK5.0中新增加的一个类，它是一个类似于String的字符串缓冲区，通过某些方法调用可以改变该序列的长度和内容。即它是一个容器，容器中可以装很多字符串，并且能够对其中的字符串进行各种操作。它的内部拥有一个数组用来存放字符串内容，进行字符串拼接时，直接在数组中加入新内容，StringBuilder会自动维护数组的扩容。
## 练习五：Date类的使用
五、请用代码实现:获取当前的日期,并把这个日期转换为指定格式的字符串,如2088-08-08 08:08:08。
``` java
public class DateTest {
    public static void main(String[] args) {
        //获取当前日期对象 now;
        Date now = new Date();
        //创建SimpleDateFormat对象 df,并制定日期格式
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //调用df的format(Date  date) 方法,传入now; 接收返回的字符串
        String datestr = df.format(now);
        //打印这个字符串
        System.out.println(datestr);
    }
}
```
## 练习六：DateFormat类方法的使用
六、使用SimpleDateFormat类,把2018-03-04转换为2018年03月04日。 
``` java
public class DateFormatTest {
    public static void main(String[] args) throws ParseException {
        //创建SimpleDateFormat对象df1,指定日期模式为yyyy-MM-dd
        SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
        //调用df1的parse(String str)方法传入2018-03-04,得到对应日期类型
        Date date = df1.parse("2018-03-04");
        //创建日期格式化对象df2,在获取格式化对象时可以指定风格
        DateFormat df2 = new SimpleDateFormat("yyyy年MM月dd日");
        //调用df2的format(Date date) 传入刚才转换的日期
        String str = df2.format(date);
        System.out.println(str);
    }
}
```
## 练习七：Calendar类方法的使用
七、用程序判断2018年2月14日是星期几。
``` java
public class CalendarTest01 {
    public static void main(String[] args) {
        //创建Calendar对象
        Calendar c = Calendar.getInstance();
        //将给定的日历字段设置到Calendar对象中
        c.set(Calendar.YEAR, 2018);
        c.set(Calendar.MONTH, 1);
        c.set(Calendar.DATE, 14);
        //设置年
        int year = c.get(Calendar.YEAR);
        //设置月
        int month = c.get(Calendar.MONTH)+1;
        //设置日
        int date = c.get(Calendar.DATE);
        //设置星期
        char week = getWeek(c.get(Calendar.DAY_OF_WEEK));
        //输出结果
        System.out.println(year+"年"+month+"月"+date+"日是星期"+week);
    }
    //定义方法，获取星期汉字
    public static char getWeek(int a){
        char[] c = {' ','日','一','二','三','四','五','六'};
        return c[a];
    }
}
```
# Collection集合
## 练习一：集合框架
一、请简述集合框架。
集合按照其存储结构可以分为两大类，分别是单列集合java.util.Collection和双列集合java.util.Map。
Collection：单列集合类的根接口，用于存储一系列符合某种规则的元素，它有两个重要的子接口，分别是java.util.List和java.util.Set。其中，List的特点是元素有序、元素可重复。Set的特点是元素无序，而且不可重复。List接口的主要实现类有java.util.ArrayList和java.util.LinkedList，Set接口的主要实现类有java.util.HashSet和java.util.TreeSet。
## 练习二：Collection集合统计元素出现次数
二、给定以下代码，请定义方法listTest()统计集合中指定元素出现的次数，如"a": 2,"b": 2,"c" :1, "xxx":0。
``` java
Collection<String> list = new ArrayList<>();
list.add("a");
list.add("a");
list.add("b");
list.add("b");
list.add("c");
System.out.println("a:"+listTest(list, "a"));	
System.out.println("b:"+listTest(list, "b"));	
System.out.println("c:"+listTest(list, "c"));
System.out.println("xxx:"+listTest(list, "xxx"));		
```
``` java
public class CollectionTest01{
    public static void main(String[] args) {
        Collection<String> list = new ArrayList<>();
        list.add("a");
        list.add("a");
        list.add("b");
        list.add("b");
        list.add("c");
        System.out.println("a:"+listTest(list, "a"));
        System.out.println("b:"+listTest(list, "b"));
        System.out.println("c:"+listTest(list, "c"));
        System.out.println("xxx:"+listTest(list, "xxx"));
    }

    //定义方法统计集合中指定元素出现的次数
    public static int listTest(Collection<String> list,String s){
        //定义计数器，初始化为0
        int count = 0;
        //增强for遍历集合
        for (String string : list) {
            //判断传入方法的字符与遍历集合的是否一致
            if (s.equals(string)) {
                //如果一致，加1
                count++;
            }
        }
        return count;
    }
}
```
## 练习三：Collection集合数组转集合
三、定义一个方法，要求此方法把int数组转成存有相同元素的集合(集合里面的元素是Integer)，并返回。()
``` java
public class CollectionTest02 {
    public static void main(String[] args) {
        //定义int数组
        int[] arr = {1,2,3,4,5};
        ArrayList<Integer> list = listTest(arr);
        System.out.println(list);
    }

    public static ArrayList<Integer> listTest(int[] arr) {
        //定义集合
        ArrayList<Integer> list = new ArrayList<Integer>();
        //遍历数组，把元素依次添加到集合当中
        for (int a : arr) {
            list.add(a);
        }
        return list;
    }
}
```
## 练习四：Collection集合集合转数组
四、定义一个集合，并把集合(集合里面的元素是Integer)转成存有相同元素的数组，并将结果输出在控制台。（可以使用Object[]数组类型接收转换的数组）
``` java
public class CollectionTest03 {
    public static void main(String[] args) {
        //定义集合,添加数据
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(100);
        list.add(200);
        list.add(300);
        //Object[] toArray()转换成一个Object数组
        Object[] obj =  list.toArray();
        // 遍历数组
        for (int i = 0; i < obj.length; i++) {
            System.out.println(obj[i]);
        }
    }
}
```
## 练习五：Collection集合contains()方法使用
五、定义一个方法listTest(ArrayList<String> al, String s),要求使用contains()方法判断al集合里面是否包含s。
``` java
public class CollectionTest04 {
    public static void main(String[] args) {
        //定义集合，添加数据
        ArrayList<String> list = new ArrayList<String>();
        list.add("itcast");
        list.add("itheima");
        list.add("java");
        System.out.println(listTest(list,"java"));
    }
    public static boolean listTest(ArrayList<String> al, String s) {
        //判断s是否在集合中存在,存在返回true，不存在返回false
        if (al.contains(s)) {
            return true;
        }
       return false;
    }
}
```   
	
# File类&递归&FileFilter
## 练习一:相对路径和绝对路径的使用
描述:创建两个文件对象，分别使用相对路径和绝对路径创建。
答案
操作步骤:
绝对路径创建文件对象：使用File类一个参数的构造方法。
相对路径创建文件对象：使用File类两个参数的构造方法。
代码:
``` java
public class Test01_01 {
public static void main(String[] args) {
// 创建文件对象：绝对路径
		File f1 = new File("d:/aaa/a.txt");
		// 创建文件对象：相对路径
		File f2 = new File("a.txt");
	}
}
```
## 练习二:检查文件是否存在,文件的创建
描述:检查D盘下是否存在文件a.txt,如果不存在则创建该文件。
答案
操作步骤:
1.	使用绝对路径创建对象关联到D盘的a.txt。
2.	通过文件对象方法判断文件是否存在。
3.	不存在则调用创建文件的方法创建文件。
代码:
``` java
public class Test01_02 {
	public static void main(String[] args) throws IOException{
		// 创建文件对象：绝对路径
		File f = new File("d:/a.txt");
		// 如果文件不存在，则创建文件
		if(!f.exists()) {
			f.createNewFile();
		}
	}
}
```
## 练习三:单级文件夹的创建
描述:在D盘下创建一个名为bbb的文件夹。
答案
操作步骤:
1.	创建文件对象指定路径为d:/bbb
2.	调用文件对象创建文件夹的方法
代码:
``` java
public class Test01_03 {
	public static void main(String[] args) {
		// 创建文件对象
		File f = new File("d:/bbb");
		// 创建单级文件夹
		f.mkdir();
	}
}
```
## 练习四:多级文件夹的创建
描述:在D盘下创建一个名为ccc的文件夹，要求如下：
1.ccc文件夹中要求包含bbb子文件夹
2.bbb子文件夹要求包含aaa文件夹
答案:
操作步骤:
1.	创建文件对象关联路径：d:/ccc/bbb/aaa
2.	调用文件对象创建多级文件夹的方法
代码:
``` java
public class Test01_04 {
	public static void main(String[] args) {
		// 创建文件对象
		File f = new File("d:/ccc/bbb/aaa");
		// 创建多级文件夹
		f.mkdirs();
	}
}
```
## 练习五:删除文件和文件夹
描述:
将D盘下a.txt文件删除
将D盘下aaa文件夹删除,要求文件夹aaa是一个空文件夹。
答案:
操作步骤:
1.	创建文件对象关联路径：d:/a.txt
2.	调用文件对象删除文件的方法
3.	创建文件对象关联路径：d:/aaa
4.	调用文件对象删除文件夹的方法
代码:
``` java
public class Test01_05 {
	public static void main(String[] args) {
		// 创建文件对象
		File f = new File("d:/a.txt");
		// 删除文件
		f.delete();
		
		// 创建文件夹对象
		File dir = new File("d:/aaa");
		// 删除文件夹
		dir.delete();
	}
}
```
## 练习六:获取文件信息:文件名,文件大小,文件的绝对路径,文件的父路径
描述:
获取D盘aaa文件夹中b.txt文件的文件名，文件大小，文件的绝对路径和父路径等信息，并将信息输出在控制台。
答案:
操作步骤:
1.	在D盘aaa文件夹中创建一个b.txt文件并输入数据
2.	创建文件对象关联路径：d:/aaa/b.txt
3.	调用文件对象的相关方法获得信息并输出。可以通过API帮助文档查询方法。
代码:
``` java
public class Test01_06 {
	public static void main(String[] args) {
		// 创建文件对象
		File f = new File("d:/aaa/b.txt");
		// 获得文件名
		String filename = f.getName();
		// 获得文件大小
		longfilesize = f.length();
		// 获得文件的绝对路径
		String path = f.getAbsolutePath();
		// 获得父文件夹路径，返回字符串
		String parentPath = f.getParent();
		// 获得父文件夹路径，返回文件对象
		File parentFile = f.getParentFile();
		// 输出信息
		System.out.println("文件名：" + filename);
		System.out.println("文件大小：" + filesize);
		System.out.println("文件路径：" + path);
		System.out.println("文件父路径：" + parentPath);
		System.out.println("文件父路径：" + parentFile);
	}
}
```
## 练习七:文件夹或文件的判断
描述:
1.判断File对象是否是文件,是文件则输出：xxx是一个文件，否则输出：xxx不是一个文件。
2.判断File对象是否是文件夹,是文件夹则输出：xxx是一个文件夹，否则输出：xxx不是一个文件夹。(xxx是文件名或文件夹名)
答案:
操作步骤:
1.	创建两个文件对象分别关联到不同的文件，比如：d:/a.txt，d:/aaa
2.	调用文件对象的判断是否是文件或是否是文件夹的方法
3.	获得文件名，根据判断结果输出信息。
代码:
``` java
public class Test01_07 {
	public static void main(String[] args) {
		// 创建文件对象
		File f1 = new File("d:/b.txt");
		// 判断是否是一个文件
		if(f1.isFile()) {
			System.out.println(f1.getName()+"是一个文件");
		}  else {
			System.out.println(f1.getName()+"不是一个文件");
		}
		// 创建文件对象
		File f2 = new File("d:/aaaa");
		// 判断是否是一个文件夹
		if(f2.isDirectory()) {
			System.out.println(f2.getName()+"是一个文件夹");
		}  else {
			System.out.println(f2.getName()+"不是一个文件夹");
		}
	}
}
```
## 练习八:文件夹的获取方法
描述:
获取指定文件夹下所有的文件，并将所有文件的名字输出到控制台。
注意：不包含子文件夹下的文件
答案
操作步骤:
1.	创建文件对象关联到指定文件夹，比如：c:/aaa
2.	调用文件对象的listFiles方法获得文件数组
3.	遍历文件数组将每一个文件的名字输出到控制台
代码:
``` java
public class Test01_08 {
	public static void main(String[] args) {
		// 创建文件对象
		File f = new File("d:/aaa");
		// 获得文件夹下所有文件
		File[] files = f.listFiles();
		// 遍历文件数组
		for (File file :files) {
			// 将文件的名字打印到控制台
			System.out.println(file.getName());
		}
	}
```
# List&Set集合
## 练习一：List接口的特点
一、请简述List接口的特点。
1.它是一个元素存取有序的集合。例如，存元素的顺序是11、22、33。那么集合中，元素的存储就是按照11、22、33的顺序完成的）。
2.它是一个带有索引的集合，通过索引就可以精确的操作集合中的元素（与数组的索引是一个道理）。
3.集合中可以有重复的元素，通过元素的equals方法，来比较是否为重复的元素。
## 练习二：hashCode和equals方法
二、请简述HashSet去除重复元素的原理。
1.调用被添加元素的hashCode()，和HashSet中已有元素的hashCode比较是否相同
2.如果不相同，直接存储
3.如果相同，调用equals方法比较是否相同
4.不相同，直接存储元素    
5.相同，认为是同一元素.不存储
## 练习三：数据结构
三、简述常见的数据结构中元素的存取特点。
栈：stack，又称堆栈，对元素的存取特点是：先进后出。即，存进去的元素，要在后它后面的元素依次取出后，才能取出该元素。   
队列：queue，简称队，对元素的存取特点是：先进先出。即，存进去的元素，要在后它前面的元素依次取出后，才能取出该元素。
数组:Array，是有序的元素序列，对元素的存取特点是：
1、查找元素快：通过索引，可以快速访问指定位置的元素
2、增删元素慢
（1）指定索引位置增加元素：需要创建一个新数组，将指定新元素存储在指定索引位置，再把原数组元素根据索引，复制到新数组对应索引的位置。
（2）指定索引位置删除元素：需要创建一个新数组，把原数组元素根据索引，复制到新数组对应索引的位置，原数组中指定索引位置元素不复制到新数组中。
链表:linked list，对元素的存取有如下的特点：
1、多个结点之间，通过地址进行连接。例如，多个人手拉手，每个人使用自己的右手拉住下个人的左手，依次类推，这样多个人就连在一起了。
2、查找元素慢：想查找某个元素，需要通过连接的节点，依次向后查找指定元素。
3、增删元素快：
增加元素：只需要修改连接下个元素的地址即可。
删除元素：只需要修改连接下个元素的地址即可。
## 练习四：Comparable和Comparator比较器
四、简述Comparable和Comparator两个接口的区别。
Comparable：强行对实现它的每个类的对象进行整体排序。这种排序被称为类的自然排序，类的compareTo方法被称为它的自然比较方法。只能在类中实现compareTo()一次，不能经常修改类的代码实现自己想要的排序。实现此接口的对象列表（和数组）可以通过Collections.sort（和Arrays.sort）进行自动排序，对象可以用作有序映射中的键或有序集合中的元素，无需指定比较器。
Comparator强行对某个对象进行整体排序。可以将Comparator 传递给sort方法（如Collections.sort或 Arrays.sort），从而允许在排序顺序上实现精确控制。还可以使用Comparator来控制某些数据结构（如有序set或有序映射）的顺序，或者为那些没有自然顺序的对象collection提供排序。
## 练习五：LinkedList方法的使用
五、根据要求练习LinkedList方法：
（1）基本方法：add, set, get, remove, clear, size等方法；
（2）特有方法：addFirst, addLast, getFirst, getLast, removeFirst, removeLast, push, pop, clear等方法。
（1）基本方法：
``` java
public class LinkedListTest01 {
    public static void main(String[] args) {
        // 1.创建LinkedList
        LinkedList<String> arr = new LinkedList<String>();

        // 2.使用add方法添加元素
        arr.add("西门吹雪");
        arr.add("西门吹雪");
        arr.add("西门吹雪");
        arr.add("西门吹风");
        arr.add("西门吹水");

        // 3.使用add方法在指定索引添加元素
        arr.add(2, "西门吹雨");

        // 4.使用set方法修改指定位置索引
        arr.set(0, "东门");

        for (String str : arr) {
            System.out.println(str);
        }
        System.out.println("--------------");
        // 5.使用get方法获取指定索引的元素
        System.out.println(arr.get(1));

        // 6.使用size方法获取集合大小
        System.out.println(arr.size());

        // 7.使用remove方法删除指定索引的元素
        arr.remove(3);

        // 8.使用clear清空集合中的元素
        arr.clear();
        System.out.println(arr);
    }
}
（2）特有方法
public class LinkedListTest02 {
    public static void main(String[] args) {
        // 1.创建LinkedList
        LinkedList<String> linked = new LinkedList<String>();

        // 2.使用add方法添加元素
        linked.add("周杰伦");
        linked.add("周星驰");
        linked.add("周华健");
        linked.add("周润发");

        // 3.使用addFirst添加元素到集合最前面
        linked.addFirst("周传雄");

        // 4.使用addLast添加元素到集合最后面
        linked.addLast("周渝民");

        System.out.println(linked);

        // 5.使用getFirst获取集合第一个元素
        System.out.println(linked.getFirst());

        // 6.使用getLast获取集合最后一个元素
        System.out.println(linked.getLast());

        // 7.使用removeLast删除集合第一个元素
        String first = linked.removeFirst();
        System.out.println(first);

        // 8.使用removeLast删除集合最后一个元素
        String last = linked.removeLast();
        System.out.println(last);
        System.out.println(linked);


        // 9.使用pop弹出第一个元素
        String p = linked.pop();
        System.out.println(p);

        // 10.使用push在集合开头插入元素
        linked.push("周立波");
        System.out.println(linked);

        // 11.使用clear清空集合
        linked.clear();
        System.out.println(linked);
    }
}
```
## 练习六：HashSet存储自定义类型
六、定义人类，包含姓名和年龄属性。创建4个人存储到HashSet中，姓名和年龄相同的人看做同一人不存储。
``` java
Person类:
// 1.定义Person类.包好姓名年龄属性,重写hashCode()和equals()方法
public class Person {
    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;

        Person person = (Person) o;

        if (age != person.age) return false;
        return name != null ? name.equals(person.name) : person.name == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        return result;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
```
``` java
测试类
public class HashSetTest01 {
    public static void main(String[] args) {
        // 2.创建HashSet用于存储Person类型
        HashSet<Person> hashSet = new HashSet<Person>();

        // 3.添加多个Person到HashSet中
        hashSet.add(new Person("王昭君", 21));
        hashSet.add(new Person("西施", 21));
        hashSet.add(new Person("杨玉环", 20));
        hashSet.add(new Person("貂蝉", 19));
        hashSet.add(new Person("杨玉环", 20));
        hashSet.add(new Person("貂蝉", 19));

        // 4.遍历获取HashSet中的内容
        for (Person p : hashSet) {
            System.out.println(p);
        }
    }
}
```
## 练习七：List集合元素替换
七、向list集合添加姓名{张三,李四,王五,二丫,钱六,孙七},将二丫替换为王小丫。
``` java
public class ListTest01 {
    public static void main(String[] args) {
        //1.创建List集合对象
        List<String> list = new ArrayList<>();
        //2.存入数据
        list.add("张三");
        list.add("李四");
        list.add("王五");
        list.add("二丫");
        list.add("钱六");
        list.add("孙七");
        //3.遍历集合，找到"二丫",便将其替换为"王小丫"
        //利用普通for循环遍历List集合
        for(int i = 0;i<list.size();i++) {
            //获取当前元素
            String thisName = list.get(i);
            //如果当前元素是"二丫"
            if("二丫".equals(thisName)) {
                //将其改为"王小丫"
                list.set(i, "王小丫");
            }
        }
        System.out.println(list);
    }
}
```

## 练习八：LinkedHashSet基本使用
八、使用LinkedHashSet存储以下元素："王昭君","王昭君","西施","杨玉环","貂蝉"。使用迭代器和增强for循环遍历LinkedHashSet。
``` java
public class LinkedHashSetTest01 {
    public static void main(String[] args) {
        // 1.创建LinkedHashSet
        LinkedHashSet<String> lhSet = new LinkedHashSet<String>();

        // 2.使用add方法添加元素到LinkedHashSet
        lhSet.add("王昭君");
        lhSet.add("王昭君");
        lhSet.add("王昭君");
        lhSet.add("西施");
        lhSet.add("杨玉环");
        lhSet.add("貂蝉");

        // 3.使用迭代器获取LinkedHashSet中的元素
        Iterator<String> iterator = lhSet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        // 4.使用增强for获取LinkedHashSet中的元素
        System.out.println("---------------------");
        for (String string : lhSet) {
            System.out.println(string);
        }
    }
}
```    
## 练习九：Collections工具类使用
九、ArrayList集合中有如下内容： {33,11,77,55}，使用Collections.sort()对ArrayList集合中的数据进行排序，并打印出排序后的结果。
``` java
public class CollectionsTest01 {
    public static void main(String[] args) {
        // 1.创建ArrayList
        ArrayList<Integer> arr = new ArrayList<Integer>();

        // 2.使用add方法添加{33,11,77,55}四个元素
        arr.add(33);
        arr.add(11);
        arr.add(77);
        arr.add(55);

        // 3.调用Collections的sort方法,对集合排序
        Collections.sort(arr);

        // 4.使用增强for遍历ArrayList集合
        for (Integer integer : arr) {
            System.out.println(integer);
        }
    }
}
```
# Map集合
## 练习一：Map接口的特点
一、请简述Map 的特点。
1.Map每个元素由键与值两部分组成
2.Map键不能重复,每个键对应一个值
3.键和值可以为null
## 练习二：Entry键值对对象
二、说出Entry键值对对象遍历Map集合的原理。    
Map中存放的是两种对象，一种称为key(键)，一种称为value(值)，它们在在Map中是一一对应关系，这一对对象又称做Map 中的一个Entry(项)。Entry将键值对的对应关系封装成了对象。即键值对对象，这样我们在遍历Map集合时，就可以从每一个键值对（Entry）对象中获取对应的键与对应的值。
练习三：Map接口中的常用方法
## 三、请使用Map集合的方法完成添加元素，根据键删除，以及根据键获取值操作。
``` java
public class MapTest01{
public static void main(String[] args) {
// 1.创建HashMap
HashMap<String, String> hm = new HashMap<String, String>();

// 2.使用put添加元素
hm.put("黄晓明", "Baby");
        hm.put("邓超", "孙俪");
        hm.put("李晨", "范冰冰");
        hm.put("大黑牛", "范冰冰");

// 3.使用put修改元素
String v1 = hm.put("李晨", "白百合");

// 4.使用get获取元素
String string = hm.get("大黑牛");

// 5.使用remove删除元素
String v2 = hm.remove("大黑牛");
        System.out.println(v2);

// 6.打印集合中的元素
System.out.println(hm);
    }
}
```
## 练习四：Map接口中的方法
四、往一个Map集合中添加若干元素。获取Map中的所有value，并使用增强for和迭代器遍历输出每个value。
``` java
public class MapTest02 {
public static void main(String[] args) {
// 1.创建HashMap
HashMap<String, String> hm = new HashMap<String, String>();

// 2.使用put添加元素
hm.put("黄晓明", "Baby");
        hm.put("邓超", "孙俪");
        hm.put("李晨", "范冰冰");
        hm.put("大黑牛", "范冰冰");

// 3.使用Map的values方法获取到所有的value
Collection<String> values = hm.values();

// 4.使用增强for获取每个value
for (String value : values) {
            System.out.println(value);
        }

        System.out.println("----------------");
// 5.使用迭代器获取每个value
Iterator<String> itr = values.iterator();
while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }
}
```

## 练习五：HashMap存储键是自定义对象值是String
 五、请使用Map集合存储自定义数据类型Car做键，对应的价格做值。并使用keySet和entrySet两种方式遍历Map集合。
``` java
汽车类:
// 1.定义汽车类.包含名称和价格属性,重写hashCode和equals方法
public class Car {

private String name;

private String color;

public Car() {
    }

public Car(String name, String color) {
this.name = name;
this.color = color;
    }

public String getName() {
return name;
    }

public void setName(String name) {
this.name = name;
    }

public String getColor() {
return color;
    }

public void setColor(String color) {
this.color = color;
    }

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof Car)) return false;

        Car car = (Car) o;

if (name != null ? !name.equals(car.name) : car.name != null) return false;
return color != null ? color.equals(car.color) : car.color == null;
    }

@Override
public int hashCode() {
int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (color != null ? color.hashCode() : 0);
return result;
    }
}
测试类:
public class MapTest03 {
public static void main(String[] args) {
// 2.创建HashMapkey保存汽车对象,value是汽车价格
HashMap<Car, Integer> hm = new HashMap<>();

// 3.添加汽车到HashMap中
Car c1 = new Car("长安奔奔", "黄色");
        Car c3 = new Car("奇瑞QQ", "黑色");
        Car c2 = new Car("铃木奥拓", "白色");

        hm.put(c1, 10000);
        hm.put(c2, 20000);
        hm.put(c3, 30000);

// 4.使用keySet方式遍历Map
Set<Car> keySet = hm.keySet();
for (Car c : keySet) {
// 根据key获取value
Integer value = hm.get(c);
            System.out.println(c.getName() + ","+ c.getPrice() + " - "+ value);
        }

        System.out.println("-------------");

// 5.使用entrySet方式遍历Map
Set<Map.Entry<Car, Integer>> entrySet = hm.entrySet();
for (Map.Entry<Car, Integer> entry : entrySet) {
            Car key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println(key.getName() + ","+ key.getPrice() + " - "+ value);
        }
    }
}
```
## 练习六：Map集合的使用（一）
六、现在有一个map集合如下：
``` java
Map<Integer,String> map = new HashMap<Integer, String>();
        map.put(1, "张三丰");
        map.put(2, "周芷若");
        map.put(3, "汪峰");
        map.put(4, "灭绝师太");
```
要求：
1.遍历集合，并将序号与对应人名打印。
2.向该map集合中插入一个编码为5姓名为李晓红的信息
3.移除该map中的编号为1的信息 
4.将map集合中编号为2的姓名信息修改为"周林"
``` java
public class MapTest04 {
public static void main(String[] args) {
// 1.定义HashMap,编号作为key,姓名作为value
Map<Integer,String> map = new HashMap<Integer, String>();

// 2.使用put方法添加元素
map.put(1, "张三丰");
        map.put(2, "周芷若");
        map.put(3, "汪峰");
        map.put(4, "灭绝师太");

// 3.使用keySet+增强for迭代map中的元素,并打印
Set<Integer> keySet = map.keySet();
for (Integer key : keySet) {
            String value = map.get(key);
            System.out.println(key + " -- "+ value);
        }

// 4.使用put向该map集合中插入一个编码为5姓名为李晓红的信息
map.put(5, "李晓红");

// 5.使用remove移除该map中的编号为1的信息
map.remove(1);

// 6.使用put将map集合中编号为2的姓名信息修改为"周林"
map.put(2, "周林");
        System.out.println(map);
    }
}
```
## 练习七：Map集合的使用（二）
七、有2个数组，第一个数组内容为：[黑龙江省,浙江省,江西省,广东省,福建省]，第二个数组为：[哈尔滨,杭州,南昌,广州,福州]，将第一个数组元素作为key，第二个数组元素作为value存储到Map集合中。如{黑龙江省=哈尔滨, 浙江省=杭州, …}。
``` java
public class MapTest05 {
public static void main(String[] args) {
// 1.定义第一个数组arr1
String[] arr1 = {"黑龙江省", "浙江省", "江西省", "广东省", "福建省"};
// 2.定义第二个数组arr2
String[] arr2 = {"哈尔滨", "杭州", "南昌", "广州", "福州"};

// 3.创建HashMap,key存放省,value存放市
HashMap<String, String> hm = new HashMap<>();

// 4.使用普通for循环遍历arr1
for (int i = 0; i < arr1.length; i++) {
// 5.根据索引到arr1中获取到省
String key = arr1[i];
// 6.根据索引到arr2中获取到省会城市
String value = arr2[i];

// 7.将省和省会城市添加到HashMap中
hm.put(key, value);
        }
// 8.输出HashMap中的内容
System.out.println(hm);
    }
}
```
# 
