package exam;

import java.util.ArrayList;
import java.util.List;

public class Practice3 {
    public static void main(String[] args) {
        //    Дан текст. Некоторые его фрагменты выделены группами символов ##.
        // Заменить выделение группами символов '<' и '>)'.
        // Пример: 'Это ##тестовый пример## для задачи ##на## строки'
        // преобразуется в 'Это <тестовый> пример для задачи <на> строки'

        String text = "Это ##тестовый пример## для задачи ##на## строки";

        char[] arr = text.replace("##", "#").toCharArray();
        int i = 0;
        String res = "";


        for (char ch : arr)
            if (ch == '#' && i % 2 == 0) {
                res += "<";
                i++;
            } else if (ch == '#' && i % 2 == 1) {
                res += ">";
                i++;
            } else {
                res += ch;
            }
        System.out.println(res);
    }
}

