package tree.hard;

import java.util.*;

/*
* https://www.youtube.com/watch?v=khddrw6Bfyw
* Asked in google
* */
public class QueueReconstruction {

    /* n2 + nlogn = n2*/
    int[][] queueReconstructionByHeight(int[][] nums){
        int[][] list = new int[nums.length][2];
        Arrays.sort(nums, Comparator.comparingInt(o -> o[0]));

        for(int i = 0; i< nums.length; i++){
            int count = nums[i][1];
            for (int j = 0; j < nums.length; j++){
                if(list[j][0] == 0 && count == 0){
                    list[j] = nums[i];
                    break;
                }else if(list[j][0] == 0 || list[j][0] >= nums[i][0]){
                    count--;
                }
            }
        }
        return list;
    }

    /* n2 + nlogn = n2*/
    int[][] queueReconstructionByHeight2(int[][] people){
        List<int[]> result= new LinkedList<>();

        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) {
                    return o2[0]-o1[0];
                } else {
                    return o1[1]-o2[1];
                }
            }
        });

        for (int[] p: people) {
            result.add(p[1],p);
        }

        return result.toArray(new int[people.length][]);
    }

    public static void main(String[] args) {
        int[][] i = new int[][]{{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};

        //new QueueReconstruction().queueReconstructionByHeight(i);
        new QueueReconstruction().queueReconstructionByHeight2(i);
    }
}
