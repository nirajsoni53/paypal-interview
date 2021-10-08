package heap;

/*

  Time: O(n * k)
  Space: O(n)

* l1 : 1 -> 5 -> 9
* l2 : 2 -> 4 -> 8
* l3 : 2 -> 6
* l4 : 1 -> 7
*
* Step 1: l1 + l2 = l12 merge first 2 array and sort it
* Step 2: l12 + l3 = l13
* Step 3: l13 + l4 = l14
*
* Merging 2 Array:
*      0    1    2
* l1 : 1 -> 5 -> 9
* l2 : 2 -> 4 -> 8
*
* here we compare every element and the smallest element we put first
* answer array : 1 -> 2 -> 4 -> 5 -> 8 -> 9
*
* */
public class KSortedArrayByMerging2Array {
}
