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
