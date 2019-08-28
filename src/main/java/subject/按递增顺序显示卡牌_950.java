package subject;

import java.util.Arrays;
import java.util.LinkedList;

public class 按递增顺序显示卡牌_950 {
    /*
    牌组中的每张卡牌都对应有一个唯一的整数。你可以按你想要的顺序对这套卡片进行排序。

最初，这些卡牌在牌组里是正面朝下的（即，未显示状态）。

现在，重复执行以下步骤，直到显示所有卡牌为止：

从牌组顶部抽一张牌，显示它，然后将其从牌组中移出。
如果牌组中仍有牌，则将下一张处于牌组顶部的牌放在牌组的底部。
如果仍有未显示的牌，那么返回步骤 1。否则，停止行动。
返回能以递增顺序显示卡牌的牌组顺序。

答案中的第一张牌被认为处于牌堆顶部。

 

示例：

输入：[17,13,11,2,3,5,7]
输出：[2,13,3,11,5,17,7]
解释：
我们得到的牌组顺序为 [17,13,11,2,3,5,7]（这个顺序不重要），然后将其重新排序。
重新排序后，牌组以 [2,13,3,11,5,17,7] 开始，其中 2 位于牌组的顶部。
2   3   5  7  11   13 17
我们显示 2，然后将 13 移到底部。牌组现在是 [3,11,5,17,7,13]。
我们显示 3，并将 11 移到底部。牌组现在是 [5,17,7,13,11]。
我们显示 5，然后将 17 移到底部。牌组现在是 [7,13,11,17]。
我们显示 7，并将 13 移到底部。牌组现在是 [11,17,13]。
我们显示 11，然后将 17 移到底部。牌组现在是 [13,17]。
我们展示 13，然后将 17 移到底部。牌组现在是 [17]。
我们显示 17。
由于所有卡片都是按递增顺序排列显示的，所以答案是正确的。


笔记：poll：Queue(队列)的一个方法，获取并移除此队列的头，如果此队列为空，则返回null
      pop：Stack(栈)的方法，移除堆栈顶部的对象，并作为此函数的值返回该对象
      题没做出来，但还是学到了点东西
     */

    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        LinkedList<Integer> queue = new LinkedList();
        for (int i = deck.length - 1; i >= 0; i--) {
            queue.add(deck[i]);
            if (i == 0) {
                break;
            }
            queue.add(queue.poll());
        }

        for (int i = queue.size(); i >=0 ; i--) {
            deck[i] = queue.poll();
        }

        return deck;
    }


    public int[] xx(int[] deck){
        int length = deck.length;
        int[] result = new int[length];
        Arrays.sort(deck);
        //index为结果数组中的索引，用来找到下一张牌的位置然后给它赋值
        int index = 0, count = 0;
        while(true) {
            result[index] = deck[count];
            count++;
            //判断循环是否要结束
            if(count==length) break;
            //找到下一张未显示的牌的位置，但是这一张是要放到最下面的，不是下一张要显示的牌的位置，不赋值
            while(result[index]!=0) {
                index = (index+1)%length;
            }
            //还是找到下一张牌，但是这一张可能已经拿出去了，所以下一步要判断一下
            //下一次循环要赋值的位置
            index = (index + 1)%length;
            while(result[index]!=0) {
                index = (index+1)%length;
            }
        }
        return result;
    }


    public int[] deckRevealedIncreasing1(int[] deck) {
        Arrays.sort(deck);
        int[] res = new int[deck.length];
        LinkedList<Integer> list = new LinkedList<>();
        list.add(deck[deck.length - 1]);
        for(int i = deck.length - 2; i >= 0; i--){
            //底部放到顶部
            list.addFirst(list.removeLast());
            //放回一张牌到顶部
            list.addFirst(deck[i]);
        }
        return list.stream().mapToInt(Integer::valueOf).toArray();
    }
}
