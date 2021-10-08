package stack;

import java.util.*;

public class FindMax {

    public static List<Integer> getMax(List<String> operations) {
        List<Integer> store = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        int maxValue = Integer.MAX_VALUE;
        for(String input: operations){
            String[] data = input.split(" ");
            if(data[0].equals("1")){
                int currentValue = Integer.parseInt(data[1]);
                store.add(currentValue);
                if(currentValue > maxValue){
                    maxValue = currentValue;
                }
            }
            else if(data[0].equals("2") && !store.isEmpty()){
                store.remove(store.size()-1);
                maxValue = store.stream().mapToInt(v -> v)
                        .max().getAsInt();
            }
            else if(data[0].equals("3") && !store.isEmpty()){
                result.add(maxValue);
            }
        }
        return result;

    }

    private static void getMaxElementFromStack()
    {
        Stack<Integer> stack = new Stack<Integer>();
        Stack<Integer> onlyMaxs = new Stack<Integer>();

        Scanner sc = new Scanner(System.in);

        int N = Integer.parseInt(sc.nextLine());
        int temp = 0;



        while(sc.hasNext())
        {
            String type[] = sc.nextLine().split(" ");
            switch(type[0])
            {
                case "1":
                    temp = Integer.parseInt(type[1]);
                    stack.push(temp);
                    if(onlyMaxs.isEmpty() || onlyMaxs.peek() <= temp)
                        onlyMaxs.push(temp);
                    break;
                case "2":
                    temp = stack.pop();
                    if(temp == onlyMaxs.peek())
                        onlyMaxs.pop();
                    break;
                case "3":
                    System.out.println(onlyMaxs.peek());
            }
            N--;
        }

        while(N-- > 0)
            System.out.println(onlyMaxs.peek());

    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(4);
        stack.push(3);
        Math.min(Math.min(10,5), 5);
        System.out.println(stack.peek());
    }

}
