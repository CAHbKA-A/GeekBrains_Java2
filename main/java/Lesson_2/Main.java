package Lesson_2;

public class Main {
    private static int count;

/*
1. Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4,
при подаче массива другого размера необходимо бросить исключение MyArraySizeException.
2. Далее метод должен пройтись по всем элементам массива, преобразовать в int, и просуммировать. Если в каком-то элементе массива преобразование не удалось
(например, в ячейке лежит символ или текст вместо числа),
должно быть брошено исключение MyArrayDataException, с детализацией в какой именно ячейке лежат неверные данные.
3. В методе main() вызвать полученный метод, обработать возможные исключения MySizeArrayException и MyArrayDataException, и вывести результат расчета.
 */
    public static void main(String[] args) {

        String[][] arr1;
        // Коррекный массив
        arr1 = new String[][]{{"1", "2", "5", "4"}, {"2", "44", "55", "44"}, {"2", "66", "88", "99"}, {"24", "266", "858", "949"}};
        // Массив не той размерности
        // arr1 = new String[][]{ {"1", "3", "5", "3"}, {"2", "44", "rtr", "222", "2222"}, {"2", "66", "88", "99"},  {"24", "266", "858",}};
        // Корректный размер, с кривыми данными
        // arr1 = new String[][]{{"1", "2", "5", "4"},{"2", "7", "55", "44"},  {"2", "6t6", "88", "99"}, {"24", "266", "858", "949"}};
       //одномерный массив
       // String[] arr2 = new String[]{"1", "2", "5", "4"};

        try {
           printArr(arr1);
            System.out.println();
        } catch (MyArraySizeException e) {
            System.out.println("Не та размерность массива");
        } catch (MyArrayDataException e) {
            System.out.println();
            System.out.println("Кривые данные в строке " + (e.getI() + 1) + ", в столбце " + (e.getJ() + 1));
        }


    }

    private static void printArr(String[][] inputStreem) throws MyArraySizeException, MyArrayDataException {
        int parsedInt;
        if (inputStreem.length != 4) {
            throw new MyArraySizeException();
        }

        for (int i = 0; i < 4; i++) {
            if (inputStreem[i].length != 4) {
                throw new MyArraySizeException();
            }
            for (int j = 0; j < 4; j++) {
                try {
                    parsedInt = Integer.parseInt(inputStreem[i][j]);
                } catch (NumberFormatException exceptionData) {
                    throw new MyArrayDataException(i, j);
                }
                count = count + parsedInt;
            //    System.out.print(inputStreem[i][j] + " "); //for check
            }
          //  System.out.println();
        }
        System.out.println("Сумма = " + count);
    }

    private static void printArr(String[] inputStreem) throws MyArraySizeException, MyArrayDataException {
        System.out.println("Ошибка.Одномерный массив.");

}}
