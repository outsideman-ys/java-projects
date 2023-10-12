public class TransactionValidator {
    public static final int MIN_AMOUNT = 1;
    public static final int MAX_AMOUNT = 5000;

    public static boolean isValidAmount(int sum) {
        if (sum < MIN_AMOUNT) {
            System.out.println("Минимальная сумма перевода: " + MIN_AMOUNT + " р. Попробуйте ещё раз!");
            return false;
        } else if (sum > MAX_AMOUNT) {
            System.out.println("Максимальная сумма перевода: " + MAX_AMOUNT + " р. Попробуйте ещё раз!");
            return false;
        } else {
            return true;
        }
    }
}