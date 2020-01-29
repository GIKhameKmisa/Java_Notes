package HashMapPractice;

import java.util.*;

/*
具体规则：

1. 组装54张扑克牌将
2. 54张牌顺序打乱
3. 三个玩家参与游戏，三人交替摸牌，每人17张牌，最后三张留作底牌。
4. 查看三人各自手中的牌（按照牌的大小排序）、底牌

> 规则：手中扑克牌从大到小的摆放顺序：大王,小王,2,A,K,Q,J,10,9,8,7,6,5,4,3
 */
public class Demo01HashMapPractice {
    public static void main(String[] args) {
        ArrayList<String> color = new ArrayList<>();
        Collections.addAll(color, "♠", "♥", "♦", "♣"); // 花色
        ArrayList<String> num = new ArrayList<>();
        Collections.addAll(num, "2", "A", "K", "Q", "J", "10", "9", "8", "7", "6", "5", "4", "3");
        // 牌面 2 A K Q J 10 9 8 7 6 5 4 3
        HashMap<Integer, String> map = new HashMap<>();
        for (int i = 0; i < num.size(); i++) {
            for (int j = 0; j < color.size(); j++) {
                map.put(i * 4 + j + 2, num.get(i) + color.get(j));
                // 将花色和牌面结合起来并编号 编号规则: 牌面大小 从 0 - 53 进行编号
                // key: 编号 value: 牌面
            }
        }
        map.put(0, "大王"); // 大王
        map.put(1, "小王"); // 小王
        Set<Integer> set = map.keySet(); // 将key: 编号 转化为Set<String> 储存
        ArrayList<Integer> list = new ArrayList<>();
        list.addAll(set); // 将key: 编号 插入 list
        ArrayList<Integer> remain = new ArrayList<>();
        remain.add(Select(list)); //调用Select方法抽牌
        remain.add(Select(list));
        remain.add(Select(list));
        ArrayList<Integer> player1 = new ArrayList<>();
        ArrayList<Integer> player2 = new ArrayList<>();
        ArrayList<Integer> player3 = new ArrayList<>();
        for (int i = 0; i < 17; i++) {
            // 轮流抽牌 17次
            player1.add(Select(list));
            player2.add(Select(list));
            player3.add(Select(list));
        }
        Collections.sort(remain); // 使用Collections工具类的sort方法从小到大排序
        Collections.sort(player1);
        Collections.sort(player2);
        Collections.sort(player3);
        System.out.println(remain);
        System.out.println(player1);
        System.out.println(player2);
        System.out.println(player3);
        System.out.println();
        LinkedList<String> play1 = new LinkedList<>();
        LinkedList<String> play2 = new LinkedList<>();
        LinkedList<String> play3 = new LinkedList<>();
        for (int i = 0; i < 17; i++) {
            // 将集合中的编号转化为对应的牌
            play1.add(map.get(player1.get(i)));
            play2.add(map.get(player2.get(i)));
            play3.add(map.get(player3.get(i)));
        }
        System.out.println(play1);
        System.out.println(play2);
        System.out.println(play3);
    }

    public static int Select(ArrayList<Integer> list) {
        // 抽牌方法实现逻辑: list集合大小为 list.size() 以此为范围进行随机数抽取
        // 抽牌后将抽到的牌从list集合中删除, 并返回抽到的牌编号
        // 在main方法中每调用一次, 抽一张牌, 且调用时抽到的牌被删除, 避免再抽牌时抽到
        Random r = new Random();
        int ran = r.nextInt(list.size());
        int select = list.remove(ran);
        return select;
    }
}
