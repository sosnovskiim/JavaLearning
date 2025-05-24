package org.knit.solutions.task42;

import org.knit.TaskDescription;
import org.knit.solutions.Solution;

import java.util.Arrays;

@TaskDescription(taskNumber = 42, taskDescription = "Тесты JUnit. Дублирование нулей в массиве")
public class Task42 implements Solution {
    public static void main(String[] args) {
        Task42 task = new Task42();
        task.execute();
    }

    @Override
    public void execute() {
        int[] array = {1, 0, 0, 2, 3};
        duplicateZeros(array);
        System.out.println(Arrays.toString(array));
    }

    /**
     * Дублирует каждый ноль в массиве, сдвигая элементы вправо.
     * Элементы, выходящие за границы массива, отбрасываются.
     *
     * @param array Входной массив (изменяется на месте).
     */
    public static void duplicateZeros(int[] array) {
        int i = 0;
        while (i + 1 < array.length) {
            if (array[i] == 0) {
                for (int j = array.length - 1; j > i; j--) {
                    array[j] = array[j - 1];
                }
                i++;
            }
            i++;
        }
    }
}
