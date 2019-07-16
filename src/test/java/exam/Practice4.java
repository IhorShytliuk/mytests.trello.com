package exam;

public class Practice4 {
    //    Дан массив названий переменных в camelCase.
    // Преобразовать названия в snake_case. пример массива [myAwsomePhrase, iLoveJustinBieber, captainJackSparrow]

    public static void main(String[] args) {
        String[] arr = {"myAwsomePhrase", "iHateJustinBieber", "captainJackSparrow"};

        for (String s : arr) {
            System.out.println(toSnakeCase(s));
        }

    }

    public static String toSnakeCase(String s) {
        String res = "";
        char[] arr = s.toCharArray();

        for (char ch : arr) {
            if (Character.isUpperCase(ch)) {
                res += "_" + Character.toLowerCase(ch);
            } else {
                res += ch;
            }
        }

        return res;
    }

}
