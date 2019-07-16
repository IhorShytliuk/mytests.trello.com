package exam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Practice1 {
//    Найти количество различных элементов массива. Пример: для 1 4 5 1 1 3 ответ 4.

    public static void main(String[] args) {

        List<Integer> arr = Arrays.asList(1, 4, 5, 1, 1, 3);
        List<Integer> unique = new ArrayList<>();

        for (int i = 0; i < arr.size(); i++) {
                if(!unique.contains(arr.get(i))) {
                    unique.add(arr.get(i));
                }
        }

        System.out.println(unique.size());

    }

}
