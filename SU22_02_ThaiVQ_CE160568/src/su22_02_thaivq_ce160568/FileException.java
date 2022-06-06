package su22_02_thaivq_ce160568;

/**
 *
 * @author Thai Vo Quoc CE160568
 */
public class FileException extends Exception{
    // Tạo mới FileException
    public FileException(String message) {
        super(message);
    }
    // Lấy ngoại lệ
    @Override
    public String getMessage() {
        return "Exception: " +super.getMessage(); 
    }
    
}
