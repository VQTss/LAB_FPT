package su22_09_thaivq_ce160568;

/**
 *
 * @author Thai Vo Quoc CE160568
 */
public class EquationNumber {

    private double numberA; // thuộc tính numberA
    private double numberB; // thuộc tính numberB
    private double numberC; // thuộc tính numberC
    Validate v = new Validate();
    public EquationNumber() {
    }
    //allow user calculate Superlative Equation
    public void superlativeEquation() {
        System.out.print("Enter A: ");
        numberA = v.checkInputDouble();
        System.out.print("Enter B: ");
        numberB = v.checkInputDouble();
        double x = 0;
        // Kiểm tra dữ liệu đầu vào
        if (numberA == 0) { // Kiểm a có trong phương trình có bằng 0 hay không
            if (numberB == 0) { // Kiểm b có trong phương trình có bằng 0 hay không
                System.out.println("The equation has infinitely many solutions.");
            } else {
                System.out.println("The equation has no solution.");
            }
        } else {
            // tính toán phương trình bậc nhất
            x = - numberB / numberA;   // ép kiểu để cho ra kết quả chính xác
            System.out.println("Solution: x=" + x);
        }
        double[] arr = new double[3]; // tạo mảng gồm 3 phần tử lưu các giá trị
        arr[0] = numberA;
        arr[1] = numberB;
        arr[2] = x;
        System.out.print("Number is even: ");
        v.checkEven(arr); // kiểm tra số chẳn
        System.out.print("Number is odd: ");
        v.checkOdd(); // kiểm tra số lẻ
        System.out.print("Number is perfect square: ");
        v.checkSquareNumber(arr); // kiểm tra square number
    }

    //allow user calculate Quadratic Equation
    public void quadraticEquation() {
        System.out.print("Enter A: ");
        numberA = v.checkInputDouble();
        System.out.print("Enter B: ");
        numberB = v.checkInputDouble();
        System.out.print("Enter C: ");
        numberC = v.checkInputDouble();
        // kiểm tra các hệ số
        if (numberA == 0) {
            if (numberB == 0) {
                System.out.println("The equation has no solution!");
            } else {
                // nếu b khác 0 mà a = 0 thì sẽ thành phương trình bậc nhất 
                System.out.println("Equation with one solution: "
                        + "x = " + (-numberC / numberB));
            }
            return;
        }
        // tính delta
        double delta = numberB * numberB - 4 * numberA * numberC;
        double x1 = 0;
        double x2 = 0;
        // tính nghiệm
        // kiểm tra giá trị của delta
        if (delta > 0) {
            x1 = (-numberB + Math.sqrt(delta)) / (2 * numberA); // tính nghiệm
            x2 = (-numberB - Math.sqrt(delta)) / (2 * numberA); // tính nghiệm
            System.out.println("Solution: x1 = " + x1 + " and x2 = " + x2);
        } else if (delta == 0) {
            x1 = (-numberB / (2 * numberA)); //tính nghiệm
            x2 = x1; // do delta = 0 nên là nghiệm kép nên x1 = x2 
            System.out.println("Equation with double solution: "
                    + "x1 = x2 = " + x1);
        } else {
            System.out.println("The equation has no solution!");
        }
        double[] arr = new double[5]; // gián các giá trị của phương trình vào mảng
        arr[0] = numberA;
        arr[1] = numberB;
        arr[2] = x1;
        arr[3] = x2;
        arr[4] = numberC;
        System.out.print("Number is even: ");
        v.checkEven(arr); // kiểm số chẳn
        System.out.print("Number is odd: ");
        v.checkOdd(); // kiểm tra số lẻ
        System.out.print("Number is perfect square: ");
        v.checkSquareNumber(arr); // kiểm tra square number
    }
}
