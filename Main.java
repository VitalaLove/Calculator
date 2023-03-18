import java.util.Scanner;

public class Main {
    static int num1;
    static int num2;
    static String result;
    static int result1;
    static String[] romanArray = new String[]{"0", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI",
            "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV",
            "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI",
            "XXXVII", "XXXVIII", "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII",
            "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX", "LXI", "LXII",
            "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV",
            "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV",
            "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII",
            "XCVIII", "XCIX", "C"};

    public static boolean isRoman(String val) {
        for (int i = 0; i < romanArray.length; i++) {
            if (val.equals(romanArray[i])) {
                return true;
            }
        }
        return false;
    }

    public static int convertToArabian(String roman) {
        for (int i = 0; i < romanArray.length; i++) {
            if (roman.equals(romanArray[i])) {
                return i;
            }
        }
        return -1;
    }

    public static String convertToRoman(int arabian) {
        return romanArray[arabian];
    }

    static boolean romanOrArabic(String[] b) throws Exception {
        if (b[0]!="") {
            if (isRoman(b[0]) && isRoman(b[1])) {
                return true;
            } else if (!isRoman(b[0]) && !isRoman(b[1])) {
                return false;
            } else {
                throw new Exception("используются одновременно разные системы счисления");
            }
        } else {
            throw new Exception("строка не является математической операцией");
        }
    }

    public static String calc(String input) throws Exception {
        String[] operands = input.split("[*+/-]");
        if (operands.length < 3) {
            if (operands.length == 2) {
                if (romanOrArabic(operands)) {
                    num1 = convertToArabian(operands[0]);
                    num2 = convertToArabian(operands[1]);
                    if (num1 < 11 && num2 < 11) {
                        if (num1 > 0 && num2 > 0) {
                            String[] operator = input.split("[IVX]");
                            switch (operator[operator.length - 1]) {
                                case "/":
                                    result1 = num1 / num2;
                                    break;
                                case "*":
                                    result1 = num1 * num2;
                                    break;
                                case "+":
                                    result1 = num1 + num2;
                                    break;
                                case "-":
                                    result1 = num1 - num2;
                                    break;
                                default:
                                    throw new Exception("Неправильный оператор");

                            }
                        } else throw new Exception("в римской системе нет отрицательных чисел и нуля");
                    } else throw new Exception("Вводимые значения больше 10");

                    if (result1 > 0) {
                        result = convertToRoman(result1);
                    } else throw new Exception("в римской системе нет отрицательных чисел и нуля");
                } else {
                    num1 = Integer.parseInt(operands[0]);
                    num2 = Integer.parseInt(operands[1]);
                    if (num1 < 11 && num2 < 11) {
                        if (num1 >= 0 && num2 >= 0) {
                            String[] operator = input.split("[0123456789]");
                            switch (operator[operator.length - 1]) {
                                case "/":
                                    result1 = num1 / num2;
                                    break;
                                case "*":
                                    result1 = num1 * num2;
                                    break;
                                case "+":
                                    result1 = num1 + num2;
                                    break;
                                case "-":
                                    result1 = num1 - num2;
                                    break;
                                default:
                                    throw new Exception("Неправильный оператор");

                            }
                            result = Integer.toString(result1);
                        } else throw new Exception("Вводимые значения больше 10");
                    } else throw new Exception("Вводимые значения больше 10");
                }
            } else throw new Exception("строка не является математической операцией");
        } else
            throw new Exception("формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        return result;
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String a = scanner.nextLine();
            System.out.println(calc(a));
        }
    }
}

