package j1.s.p0055;

import java.util.ArrayList;

/**
 *
 * @author
 */
public class Management {

    static Validate v = new Validate();
    static ArrayList<Doctor> doctors = new ArrayList<>();
    //allow user add doctor

    public static void addDoctor() {
        System.out.print("Enter code: ");
        String code = v.checkInputString();
        //check code exist or not
        if (!v.checkCodeExist(doctors, code)) {
            System.out.println("Code exist.");
            return;
        }
        System.out.print("Enter name: ");
        String name = v.checkInputString();
        System.out.print("Enter specialization: ");
        String specialization = v.checkInputString();
        System.out.print("Enter availability: ");
        int availability = v.checkInputInt();
        //check worker duplicate
        if (!v.checkDuplicate(doctors, code, name, specialization, availability)) {
            System.out.println("Doctor code [Code] is duplicate.");
            return;
        }
        doctors.add(new Doctor(code, name, specialization, availability));
        System.out.println("Add successful.");
    }

    //allow user update doctor
    public static void updateDoctor() {
        System.out.print("Enter code: ");
        String code = v.checkInputString();
        //check code exist or not
        if (v.checkCodeExist(doctors, code)) {
            System.out.println("Doctor code doesn’t exist");
            return;
        }
        System.out.print("Enter new code: ");
        String codeUpdate = v.checkInputString();
        Doctor doctor = v.getDoctorByCode(doctors, code);
        System.out.print("Enter new name: ");
        String name = v.checkInputString();
        System.out.print("Enter new specialization: ");
        String specialization = v.checkInputString();
        System.out.print("Enter  new availability: ");
        int availability = v.checkInputInt();
        //check user change infomation or not
//        if (!v.checkChangeInfo(doctor, code, name, specialization, availability)) {
//            System.out.println("No change");
//            return;
//        }
        doctor.setCode(codeUpdate);
        doctor.setName(name);
        doctor.setSpecialization(specialization);
        doctor.setAvailability(availability);
        System.out.println("Update successful");
    }

    //allow user delete doctor
    public void deleteDoctor() {
        System.out.print("Enter code: ");
        String code = v.checkInputString();
        Doctor doctor = v.getDoctorByCode(doctors, code);
        if (doctor == null) {
            System.out.println("Doctor code doesn’t exist.");
            return;
        } else {
            doctors.remove(doctor);
        }
        System.out.println("Delete successful.");
    }

    //allow user search doctor
    public void searchDoctor() {
        System.out.print("Enter name: ");
        String nameSearch = v.checkInputString();
        ArrayList<Doctor> listFoundByName = v.listFoundByName(doctors, nameSearch);
        if (listFoundByName.isEmpty()) {
            System.out.println("Database does not exist.");
        } else {
            System.out.printf("%-10s%-15s%-25s%-20s\n", "Code", "Name",
                    "Specialization", "Availability");
            for (Doctor doctor : listFoundByName) {
                System.out.printf("%-10s%-15s%-25s%-20d\n", doctor.getCode(),
                        doctor.getName(), doctor.getSpecialization(),
                        doctor.getAvailability());
            }
        }
    }

}
