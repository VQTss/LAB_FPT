package su22_11_thaivq_ce160568;

import java.util.Locale;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Thai Vo Quoc CE160568
 */
public class CheckProgram {

    Validate v = new Validate();
    Program p = new Program();

    public String generateCaptcha() {
        // tạo mảng chứa các kí tự có thể xuất hiện trong captcha
        char data[] = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
            'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w',
            'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I',
            'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U',
            'V', 'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6',
            '7', '8', '9'};
        // tạo mảng chứa các kí tự có trong captcha
        char index[] = new char[6];
        // tạo random
        Random r = new Random();
        for (int i = 0; i < (index.length); i++) {
            int ran = r.nextInt(data.length); // radom các số xuất từ 0 đến data.length
            index[i] = data[ran]; // gán các phần tử random vào mảng
        }
        // in ra chuổi captcha
        return new String(index);
    }
    // kiểm tra captcha có đúng hay không
    public void checkCaptcha(Locale language) {
        while (true) {
            // tạo ra mã captcha
            String strCaptcha = generateCaptcha();
            System.out.println(strCaptcha);
            // chuyển đổi ngôn ngữ
            v.wordLanguage(language, "enterCaptcha");
            // Nhập captcha
            String captchaInput = v.checkInputString(language);
            if (captchaInput.equals(strCaptcha)) { // kiểm tra captcha từ người dùng
                v.wordLanguage(language, "loginSuccess");
                System.out.println("");
                return;
            } else {
                // thông báo lỗi
                v.wordLanguage(language,  "errCaptchaIncorrect");
                System.out.println("");
            }
        }
    }

    public boolean isValidPassword(String password, Locale language) {
        int lengthPassword = password.length();
        // kiểm tra độ dài mật khẩu
        if (lengthPassword < 8 || lengthPassword > 31) {
            v.wordLanguage(language, "errCheckLengthPassword");
            v.wordLanguage(language, "errCheckAlphanumericPassword");
            System.out.println("");
            v.wordLanguage(language, "again");
            return false;
        } else {
            // kiểm tra mật khẩu có chứa ít nhât một kí tự và có chữ cái hay không. 
            // Và độ dài có phù hợp từ  8 đến  20 kí tự hay không
            String regex = "^(?=.*[0-9])(?=.*[a-z])(?=\\S+$).{8,20}$"; 
            boolean valid = isValidPassword(password, regex); // kiểm tra mật khẩu có đúng theo format hay không
            if (!valid) {
                // thông báo lỗi
                v.wordLanguage(language, "errCheckLengthPassword");
                v.wordLanguage(language, "errCheckAlphanumericPassword");
                System.out.println("");
                v.wordLanguage(language, "again");
                return false;
            }
        }
        return true;
    }

    // kiểm tra mật khẩu có đúng theo format hay không
    public boolean isValidPassword(String password, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }
    // kiểm tra mật khẩu có đúng theo format hay không
    public String checkPassword(Locale language){
        String result;
        while (true) {            
           result = v.checkInputString(language);
            if (isValidPassword(result, language)) { // checck
                return result;
            }
        }
    }
    // đăng nhập 
    void login(Locale language) {
        v.wordLanguage(language, "enterAccountNumber");
        p.setUserName(v.checkInputInt(language));
        v.wordLanguage(language, "enterPassword");
        p.setPassword(checkPassword(language));
        checkCaptcha(language);
    }
}
