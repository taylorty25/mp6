import java.util.Arrays;
import java.util.Comparator;
/**
 * A simple way to sort arrays using merge sort.
 *
 * @author Tyrell Taylor
 * @author Samuel A. Rebelsky
 */
public class MergeSort implements Sorter {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The one sorter you can access.
   */
  public static Sorter SORTER = new MergeSort();

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+
  /**
   * Create a sorter.
   */
  MergeSort() {
  } // MergeSort()

  /**
   * Sort an array using the merge sort algorithm.
   */
  @Override
  public <T> void sort(T[] values, Comparator<? super T> order) {
    sort(0, values.length, values, order);
  } // sort

  /**
   * Recursive helper for the sort method.
   */
  public <T> void sort(int i, int size, T[] values, Comparator<? super T> order) {
    while (i < size) {
      merge(values, i++, (i + size) / 2, size - 1, order);
    }
  } // sort

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Merge the values from positions [lo...mid) and [mid...hi) back into
   * the same part of the array.
   * <p>
   * Preconditions: Each subarray is sorted according to comparator.
   */
 public <T> void merge(T[] values, int lo, int mid, int hi, Comparator<? super T> comparator) {
    T[] left = Arrays.copyOfRange(values, lo, mid);
    T[] right = Arrays.copyOfRange(values, mid, hi);
    int l = 0;
    int r = 0;
    int commonRange = Math.min(left.length, right.length);
    for (int i = 0; i < commonRange; i++) {
      int difference = comparator.compare(values[lo], values[mid]);
      if (difference < 0) {
        values[lo + i] = left[l++];
      } else if (difference > 0) {
        values[lo + i] = right[r++];
      } else {
        values[lo + i] = left[l++];
      } // if
    } // for
    T[] longer = (left.length > right.length) ? left : right;
    for (int i = 0; i < longer.length; i++) {
      values[lo + commonRange + i] = longer[commonRange + i];
    } // for
  } // merge
} // class MergeSort
