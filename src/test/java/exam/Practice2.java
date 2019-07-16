package exam;

public class Practice2 {
    public static void main(String[] args) {
        //    Дана строка, содержащая полное имя файла (например, 'c:\WebServers\home\testsite\www\myfile.txt'). Выделите из этой строки имя файла без расширения.
//            10 балів
        String path = "c:\\WebServers\\home\\testsite\\www\\myfile.txt";

        String filename = path.substring(path.lastIndexOf("\\") + 1);
        filename = filename.substring(0, filename.indexOf("."));
        System.out.println(filename);
    }
}
