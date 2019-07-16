package exam;

public class Practice5 {
    //    Создать класс с двумя переменными.
    // Добавить функцию вывода на экран и функцию изменения этих переменных.
    // Добавить функцию, которая находит сумму значений этих переменных,
    // и функцию которая находит наибольшее значение из этих двух переменных.

    public static void main(String[] args) {
        TestClass demo = new TestClass();
        demo.var1 = 10;
        demo.var2 = 15;

        demo.setVars(-10, 15);
        demo.printVars();
        System.out.println(demo.sumVars());
        System.out.println(demo.maxVar());
    }
}

class TestClass {
    int var1;
    int var2;

    public void printVars() {
        System.out.println("var1:" + var1);
        System.out.println("var2:" + var2);
    }

    public void setVars(int var1, int var2) {
        this.var1 = var1;
        this.var2 = var2;
    }

    public int sumVars() {
        return var1 + var2;
    }

    public int maxVar() {
        return var1 > var2 ? var1 : var2;
    }
}