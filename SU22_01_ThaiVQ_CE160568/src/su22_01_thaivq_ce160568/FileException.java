package su22_01_thaivq_ce160568;

/**
 *
 * @author Thai Vo Quoc CE160568
 */
public class FileException extends Exception {

    // Tạo một FileException
    public FileException(String message) {
        super(message);
    }

    // Lấy message của FileException
    @Override
    public String getMessage() {
        return "FileException: " + super.getMessage();
    }

}
