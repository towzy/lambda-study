import java.sql.SQLOutput;
import java.util.*;
import java.util.stream.Collectors;

interface MyInterface{
    public void Do(String s);
}

public class TestLambda {


    public static void main(String[] args) {

        // 使用lambda进行集合遍历
        List<String> list = Arrays.asList("lastDay","today","tomorrow");
        for (String s : list){
            System.out.println(s);
        }

        List<String> list1 = Arrays.asList("lastDay","today","tomorrow");
        list1.forEach(s -> System.out.println(s));

        // 排序
        List<Integer> list2 = Arrays.asList(6,8,7);
        Collections.sort(list2, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        System.out.println(list2);

        List<Integer> list3 = Arrays.asList(6,8,7);
        Collections.sort(list3);
        System.out.println(list3);

        //计算
        List<Integer> list4 = Arrays.asList(6,8,7);
        int sum = list4.stream().reduce(0, (a, b) -> a + b);
        System.out.println(sum);

        //分组
        List<String> fruit = Arrays.asList("apple","banana","orange");

        Map<Integer, List<String>> groups1 = new HashMap<>();
        for (String s : fruit){
            int length = s.length();
            if (!groups1.containsKey(length)){
                groups1.put(length,new ArrayList<>());
            }
            groups1.get(length).add(s);
        }
        System.out.println(groups1);

        Map<Integer, List<String>> groups = fruit.stream().collect(Collectors.groupingBy(String::length));
        System.out.println(groups);

        //接口调用
        MyInterface myInterface = new MyInterface() {
            @Override
            public void Do(String s) {
                System.out.println(s);
            }
        };
        myInterface.Do("hello");

        MyInterface myInterface1 = (s) -> System.out.println(s);
        myInterface.Do("hello lambda");

        //线程
        Thread thread = new Thread(() -> System.out.println("hello lambda"));
        thread.start();

        //toUpperCase
        String str = new String("hello Lambda");
        System.out.println(str.toUpperCase());

        Optional.ofNullable(str).map(String::toUpperCase).ifPresent(System.out::println);

        //
        List<String> fruit1 = Arrays.asList("apple","banana","orange");
        List<String> res = new ArrayList<>();
        for (String s : fruit1){
            if (s.startsWith("a")){
                res.add(s.toUpperCase());
            }
        }
        System.out.println(res);

        List<String> res1 = fruit1.stream().filter(s -> s.startsWith("a"))
                .map(String::toUpperCase).sorted().collect(Collectors.toList());
        System.out.println(res1);
    }
}
