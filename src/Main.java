public class Main {
    public static void main(String[] args) {
        // TODO: подставлять номер карты нужно сюда между двойными кавычками, без пробелов
        String number;
        number = "5351719427810741";
////        *** Some examples, should be FAIL ***
//        number = "a123412341234123"; // FAIL
//        number = "01234123 1234123"; // FAIL
//        number = "1234123412341234"; // FAIL
//        number = "12@#$12412341234"; // FAIL
//        number = "1000000000000000"; // FAIL
//        number = "0000000000000001"; // FAIL
//        number = "1111111111111111"; // FAIL
//        number = "2222222222222222"; // FAIL
//          *** Card numbers generated online, should be OK ***
////        AmericanExpress
//        number = "373672535349182"; // FAIL
//        number = "346572023722748"; // FAIL
//        number = "346851554456391"; // FAIL
//        number = "346377015621100"; // FAIL
//        number = "377264765953416"; // FAIL
////        Visa
//        number = "4532437265264819921"; // FAIL
//        number = "4129597601032637";
//        number = "4319881637975658";
//        number = "4815451784915649";
//        number = "4193750160124987";
//        number = "4905211961467025";
////        MasterCard
//        number = "5290246512617637";
//        number = "5247903435824468";
//        number = "5252809996837744";
//        number = "5516047249025377";
//        number = "5552787846428855";
////        Discover
//        number = "6011243589829191";
//        number = "6011216648088256";
//        number = "6011301465313621";
//        number = "6011431094661171";
//        number = "6011683005348195";
////        JCB
//        number = "3538865190963521";
//        number = "3548557982837306";
//        number = "3538385981304710";
//        number = "3549117452304797";
//        number = "3589627284541466";
////        China UnionPay
//        number = "6280770061219115";
//        number = "6272627808649956";
//        number = "8848749101983048";

        System.out.println(String.format("Result is %s", isValidCardNumber(number) ? "OK" : "FAIL"));
    }

    public static boolean isValidCardNumber(String number) {
        if (number == null) {
            return false;
        }

        if (number.length() != 16) {
            return false;
        }

        long result = 0;
        for (int i = 0; i < number.length(); i++) {
            int digit;
            try {
                digit = Integer.parseInt(number.charAt(i) + "");
            } catch (NumberFormatException e) {
                return false;
            }

            if (i % 2 == 0) {
                digit *= 2;
                if (digit > 9) {
                    digit -= 9;
                }
            }
            result += digit;
        }

        return (result != 0) && (result % 10 == 0);
    }
}