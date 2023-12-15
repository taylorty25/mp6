import java.util.Comparator;

/**
 * Sort using Quicksort.
 *
 * @author Tyrell Taylor
 */

public class Quicksort implements Sorter {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The one sorter you can access.
   */
  public static Sorter SORTER = new Quicksort();

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a sorter.
   */
  Quicksort() {
  } // Quicksort()

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  @Override
  public <T> void sort(T[] values, Comparator<? super T> order) {
    sort(values, order, 0, values.length);
  } // sort(T[], Comparator<? super T>

  public static <T> void sort(T[] values, Comparator<? super T> order, int lb, int ub) {
    // Sub-arrays of one element or fewer are sorted.
    if (lb >= ub-1) {
      return;
    } else {
      int mid = partition(values, order, lb, ub);
      sort(values, order, lb, mid);
      sort(values, order, mid+1, ub);
    } // if/else
  } // quickSort(T[], Comparator, int, int)
  /**
   * Select a pivot and partition the subarray from [lb .. ub) into
   * the following form.
   *
   * <pre>
   * ---+-----------------+-+----------------+---
   *    | values <= pivot |p| values > pivot |
   * ---+-----------------+-+----------------+---
   *    |                 |                  |
   *    lb                pivotLoc           ub
   * </pre>
   *
   * @return pivotLoc.
   */
  public static <T> int partition(T[] arr, Comparator<? super T> compare, int lb, int ub) {
    int pivot = (ub + lb) / 2;
    T tmp = arr[lb];
    arr[lb] = arr[pivot];
    arr[pivot] = tmp;
    int small = lb + 1;
    int large = ub - 1;
    while (small <= large) {
      if (compare.compare(arr[small], arr[lb]) > 0 && compare.compare(arr[large], arr[pivot]) <= 0) {
        tmp = arr[large];
        arr[large] = arr[small];
        arr[small++] = tmp;
      } else if (compare.compare(arr[small], arr[lb]) <= 0) {
        small++;
      } else if (compare.compare(arr[large], arr[lb]) > 0) {
        large--;
      }
    }
    tmp = arr[--small];
    arr[small] = arr[lb];
    arr[lb] = tmp;
    return small;
  } // partition
} // class Quicksort
