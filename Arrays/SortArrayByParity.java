package Arrays;

/**
 * PROMPT:
 * SORT ARRAY BY PARITY
 * Given an array A of non-negative integers,
 * return an array consisting of all the even
 * elements of A, followed by all the odd elements
 * of A.
 * 
 * You may return any answer array that satisfies 
 * this condition.
 * 
 * Example 1:
 * Input: [3,1,2,4]
 * Output: [2,4,3,1]
 * The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
 * 
 * Note:
 * 1 <= A.length <= 5000
 * 0 <= A[i] <= 5000
 * 
 */
import java.util.HashSet;

class SortArrayByParity {

  public int[] sortArrayByParity(int[] A) {
    HashSet<Integer> odd = new HashSet<Integer>();
    int k = A.length;
    int count = 0;
    for (int i = 0; i < k; i++) {
      if (A[i] % 2 == 0) {
        A[count++] = A[i];
      } else {
        odd.add(A[i]);
      }
    }

    for (int value : odd) {
      A[count++] = value;
    }

    return A;
  }

  public int[] optimizeSolution11(int[] A) {
    int i = 0, j = A.length - 1;
    while (i < j) {
        if (A[i] % 2 > A[j] % 2) {
            int tmp = A[i];
            A[i] = A[j];
            A[j] = tmp;
        }

        if (A[i] % 2 == 0) i++;
        if (A[j] % 2 == 1) j--;
    }
    return A;
  }
}
