
/**
 * Created by fotih on 9/30/2016.
 */
public class ISBN {
    private static char check1(int[] digits) {
        int sum = 0;
        for (int i = 0; i < digits.length; i++) {
            sum += (digits[i] * (i + 1));
        }
        int checkDig = sum % 11;
        char checkChar = checkDig == 10 ? 'X' : (char) (checkDig + '0');
        return checkChar;
    }

    private static char check2and3(int isbn) {
        int[] digits = new int[9];
        int startVal = 0;
        if ((isbn / (int) Math.pow(10, 8)) == 0) {
            startVal = 1;
            digits[0] = 0;
        }
        for (int i = startVal; i < digits.length; i++) {
            digits[i] = (isbn / (int) Math.pow(10, 8 - i)) % 10;
        }
        char checkChar = check1(digits);
        return checkChar;
    }

    private static char check4(double isbn) {
        String strIsbn = Double.toString(isbn);
        if (isbn < 0) strIsbn = "0" + strIsbn;
        char checkChar = check5(strIsbn);
        return checkChar;
    }

    private static char check5(String isbn) {
        int[] digits = new int[9];
        int strCheck = 0;
        for (int i = 0; i < digits.length; i++) {
            try {
                digits[i] = Integer.parseInt(Character.toString(isbn.charAt(strCheck)));
            } catch (Exception e) {
                i--;
            }
            strCheck++;
        }

        char checkChar = check1(digits);
        return checkChar;
    }

    private static class BookNumber {
        int isbnSansCheck;
        char checkChar;
        boolean isValid;

        BookNumber(int isbn) {
            isbnSansCheck = isbn;
            checkChar = check2and3(isbn);
            isValid = true;
        }

        BookNumber(String isbn) {
            isbnSansCheck = Integer.parseInt(isbn);
            checkChar = check5(isbn);
            isValid = true;
        }

        BookNumber(int[] isbn) {
            String temp = "";
            for (int j : isbn) {
                temp += j;
            }
            isbnSansCheck = Integer.parseInt(temp);
            checkChar = check1(isbn);
            isValid = true;
        }

        BookNumber(int isbn, char checkChar) {
            isbnSansCheck = isbn;
            this.checkChar = checkChar;
            isValid = (check2and3(isbn) == checkChar);
        }

        boolean isISBNValid() {
            return isValid;
        }
    }

    public static void main(String[] args) {
        System.out.println(check1(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}));
        System.out.println(check2and3(123456789));
        System.out.println(check4(0.23456789));
        System.out.println(check5("023456789"));
        BookNumber myBook = new BookNumber(201402876, '1');
        System.out.println(myBook.isISBNValid());
    }
}
