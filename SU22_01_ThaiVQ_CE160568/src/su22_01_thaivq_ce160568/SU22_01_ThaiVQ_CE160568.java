package su22_01_thaivq_ce160568;

import java.io.File;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Thai Vo Quoc CE160568
 */
public class SU22_01_ThaiVQ_CE160568 {

    private static FileManagement fm;
    private static boolean isValid = true;

    public static void main(String[] args) throws IOException {
        int choice;
        Scanner sc = new Scanner(System.in);
        do {
            isValid = true;
            System.out.println("============== File Processing ==============");
            System.out.println("1. Check path");
            System.out.println("2. Get file name with type java");
            System.out.println("3. Get file with size greater than input");
            System.out.println("4. Write more content to file");
            System.out.println("5. Read file and count characters");
            System.out.println("6. Exit");
            System.out.print("Please choice one option: ");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    do {
                        System.out.println("------------Check path------------");
                        System.out.print("Vui lòng nhập đường dẫn: ");
                        String path = sc.nextLine();
                        isValid = true;
                        try {
                            fm = new FileManagement(new FileAndDic(path));
                            fm.checkInputPath(fm.getPath());
                        } catch (FileException ex) {
                            System.out.println(ex.getMessage());
                            isValid = false;
                            sc.nextLine();
                        }
                    } while (isValid == false);
                    break;
                case 2:
                    do {
                        System.out.println("------------Get file name with type java------------");
                        System.out.print("Vui lòng nhập đường dẫn: ");
                        String path = sc.nextLine();
                        isValid = true;
                        try {
                            fm = new FileManagement(new FileAndDic(path));
                            int count = 0;
                            List<String> list = fm.getAllFileNameJavaInDirectory(fm.getPath());
                            for (int i = 0; i < list.size(); i++) {
                                System.out.printf("%d. ", i + 1);
                                System.out.println(list.get(i));
                                count++;
                            }
                            if (count == 0) {
                                System.out.println("Kết quả: " + count);
                            } else {
                                System.out.println("Kết quả: " + count);
                            }
                        } catch (FileException ex) {
                            System.out.println(ex.getMessage());
                            isValid = false;
                            sc.nextLine();
                        }
                    } while (isValid == false);
                    break;
                case 3:
                    int size = 0;
                    try {
                        System.out.println("------------Get file with size greater than input------------");
                        System.out.print("Vui lòng nhập đường dẫn: ");
                        String path = sc.nextLine();
                        fm = new FileManagement(new FileAndDic(path));
                        do {
                            try {
                                isValid = true;
                                System.out.print("Số kích thước: ");
                                size = sc.nextInt();
                                sc.nextLine();
                            } catch (InputMismatchException e) {
                                // Alert error if user input wrong data
                                System.out.println("    Số kích thước phải là số nguyên!");
                                isValid = false;
                                sc.nextLine();
                            }
                        } while (isValid == false);
                        File[] fileList = FileManagement.getFileWithSizeGreaterThanInput(fm.getPath(), size);
                        int n = fileList.length;
                        if (n == 0) {
                            System.out.println("Kết quả: " + n);
                        } else {
                            for (int i = 0; i < n; i++) {
                                System.out.printf("%d. ", i + 1);
                                System.out.println(fileList[i].getName());
                            }
                            System.out.println("Kết quả: " + n);
                        }
                    } catch (FileException ex) {
                        System.out.println(ex.getMessage());
                        isValid = false;
                        sc.nextLine();
                    }
                    break;
                case 4:
                    try {
                        System.out.println("------------Write more content to file------------");
                        System.out.print("Vui lòng nhập đường dẫn: ");
                        String path = sc.nextLine();
                        fm = new FileManagement(new FileAndDic(path));
                        System.out.print("Vui lòng nhập nội dung: ");
                        String content = sc.nextLine();
                        boolean check = fm.appendContentToFile(fm.getPath(), content);
                        if (check == true) {
                            System.out.println("Viết xong");
                        } else {
                            System.out.println("Đường dẫn không tồn tại");
                        }
                    } catch (FileException ex) {
                        System.out.println(ex.getMessage());
                        isValid = false;
                        sc.nextLine();
                    }
                    break;
                case 5:
                    try {
                        System.out.println("------------Read file and count characters------------");
                        System.out.print("Vui lòng nhập đường dẫn: ");
                        String path = sc.nextLine();
                        fm = new FileManagement(new FileAndDic(path));
                        int countChar = fm.countCharacter(fm.getPath());
                        System.out.println("Total: " + countChar);
                    } catch (FileException ex) {
                        System.out.println(ex.getMessage());
                        isValid = false;
                        sc.nextLine();
                    }
                    break;
                case 6:

                    System.out.println("\n--------------------------------------");
                    System.out.println("Cảm ơn đã dùng software của chúng tôi!\n"
                            + "Hẹn gặp lại!");
                    isValid = true;
                    break;
                default:
                    System.out.println("Lỗi: Vui lòng chọn từ 1 đến 6 và phải là số nguyên");
                    isValid = false;
                    break;
            }
        } while (isValid == false || choice != 6);

    }
}
