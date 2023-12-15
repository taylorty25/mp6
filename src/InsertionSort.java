import java.util.Comparator;

/**
 * Sort using insertion sort.
 *
 * @author Your Name Here
 */

public class InsertionSort implements Sorter {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The one sorter you can access.
   */
  public static Sorter SORTER = new InsertionSort();

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a sorter.
   */
  InsertionSort() {
  } // InsertionSort()

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Sort.
   */
  @Override
  public <T> void sort(T[] values, Comparator<? super T> order) {
    sort(values, order, 0);
  } // sort(T[], Comparator<? super T>, i)

  /**
   * Sort helper.
   */
  public <T> void sort(T[] values, Comparator<? super T> order, int i) {
    if (i == values.length - 2) {
      return;
    } else {
      if (order.compare(values[i], values[i + 1]) < 0) {
        T temp = values[i];
        values[i] = values[i + 1];
        values[i + 1] = temp;
      } // if
    } // if/else
    sort(values, order, ++i);
  } // sort(T[], Comparator<? super T>, i)
} // class InsertionSort
