    public class Main {
        public static void main(String[] args) {

            squareTableArray();
        }

        static void squareTableArray() {
            String[][] table = {
                 /*   {"1", "10", "2", "4", "10"},
                    {"7", "*", "2", "4", "5"},
                    {"3", "5", "16", "4", "4"},
                    {"11", "8", "6", "9", "10"}*/
                    {"1", "10", "2", "4"},
                    {"7", "*", "2", "4"},
                    {"3",  "16", "4", "4"},
                    {"11", "8", "9", "10"}

            };


            try {
                int sum = processArray(table);
                System.out.println("Сумма: " + sum);
            } catch (MyArraySizeException | MyArrayDataException e) {
                System.out.println(e.getMessage());
            }
        }

        static class MyArraySizeException extends RuntimeException {
            public MyArraySizeException(String message) {
                super(message);
            }
        }

        static class MyArrayDataException extends RuntimeException {
            public MyArrayDataException(String message) {
                super(message);
            }
        }

        static int processArray(String[][] array) {
            if (array.length != 4 || array[0].length != 4) {
                throw new MyArraySizeException("Неверный размер массива. Ожидается массив размером 4x4.");
            }

            int sum = 0;
            for (int t = 0; t < array.length; ++t) {
                for (int i = 0; i < array.length; ++i) {
                    try {
                        sum += Integer.parseInt(array[t][i]);
                    } catch (NumberFormatException exc) {
                        try {
                            throw new MyArrayDataException("Не удалось преобразовать значение в число /table [" + t + "][" + i + "] = "
                                    + array[t][i] + "/. Значение заменено на 0.");
                        } catch (MyArrayDataException exce) {
                            System.out.println(exce.getMessage());
                            array[t][i] = "0";
                            sum += Integer.parseInt(array[t][i]);
                        }
                    }
                }

            }
            return sum;
        }
    }

