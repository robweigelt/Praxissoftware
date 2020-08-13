package r.w;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class AppointmentManager {

    private String filepath = "Appointments.csv";
    private List<Appointment> appointments = new ArrayList<Appointment>();
    private Scanner input = new Scanner(System.in);

    public List<Appointment> readAppointmentCSV() {
        appointments.clear();
        List<String> Helper = new ArrayList<>();
        File f = new File(filepath);
        try (Scanner scCSV = new Scanner(f)) {
            while (scCSV.hasNextLine()) {
                Helper.add(scCSV.nextLine());
            }
            scCSV.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        for (int i = 0; Helper.size() > i; i++) {
            Appointment apot = new Appointment(0, 0, null, null, null, null);

            String CSVline = Helper.get(i);
            String[] parts = CSVline.split(";");

            apot.setAppointmentID(Integer.parseInt(parts[0]));
            apot.setPatientID(Integer.parseInt(parts[1]));
            apot.setTitle(parts[2]);
            apot.setDate(parts[3]);
            apot.setStartTime(parts[4]);
            apot.setEndTime(parts[5]);
            appointments.add(apot);
        }
        return appointments;
    }

    public void printAppointments() {
        String[] aCol = {"ID", "PatID", "Title", "Date", "Start Time", "End Time"};
        System.out.println("__________________________________________");
        System.out.println("List of Appointments\n");
        for (String aCol1 : aCol) {
            System.out.print(aCol1 + "\t");
        }
        System.out.println();
        for (Appointment appointment : appointments) {
            System.out.println(appointment.getAppointmentID() + "\t\t" + appointment.getPatientID() + "\t\t" + appointment.getTitle()
                    + "\t" + appointment.getDate() + "\t" + appointment.getStartTime() + "\t" + appointment.getEndTime());
        }
    }

    public List<Appointment> addAppointment(int appointmentID, int patientID, String title, String date, String startTime, String endTime) {
        try {
            Appointment apt = new Appointment(appointmentID, patientID, title, date, startTime, endTime);
            appointments.add(apt);
            System.out.println("Appointment saved!");
        } catch (Exception e) {
            System.out.println("Appointment could not be saved!");
        }
        return appointments;
    }

    public List<Appointment> deleteAppointment(Appointment foundappointment) {
        try {
            appointments.remove(foundappointment);
        } catch (Exception e) {
            System.out.println("Appointment could not be removed!");
        }
        return appointments;
    }

    public List<Appointment> showAppointmentById(Appointment foundappointment) {
        try {
            System.out.println(foundappointment);
        } catch (Exception e) {
            System.out.println("Appointment could not be found!");
        }
        return appointments;
    }

    public Appointment searchAppointmentByID(int apatId) {
        for (Appointment foundAppointment : appointments) {
            if (foundAppointment.getAppointmentID() == apatId) {
                return foundAppointment;
            }
        }
        return null;
    }

    public void writeAppointmentToCSV() {
        ListIterator<Appointment> lItr = appointments.listIterator();

        String tempFile = "temp.csv";
        File newFile = new File(tempFile);
        File oldFile = new File(filepath);

        try {
            FileWriter fw = new FileWriter(tempFile, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            Appointment apatIt1 = lItr.next();

            pw.print(apatIt1.getAppointmentID() + ";" + apatIt1.getPatientID() + ";" + apatIt1.getTitle() + ";" + apatIt1.getDate() + ";" + apatIt1.getStartTime() + ";" + apatIt1.getEndTime() + ";");
            while (lItr.hasNext()) {
                Appointment apatIt = lItr.next();
                pw.print("\n" + apatIt.getAppointmentID() + ";" + apatIt.getPatientID() + ";" + apatIt.getTitle() + ";" + apatIt.getDate() + ";" + apatIt.getStartTime() + ";" + apatIt.getEndTime() + ";");
            }
            pw.flush();
            pw.close();
            System.out.println("Appointments were successfully written to CSV!");
            oldFile.delete();
            File dump = new File(filepath);
            newFile.renameTo(dump);
        } catch (Exception e) {
            System.out.println("Appointments could not be written to CSV!");
        }
    }

    public boolean checkIfIDExists(int id) {
        for (Appointment apat : appointments) {
            if (apat.getAppointmentID() == id) {
                return true;
            }
        }
        return false;
    }

    public void editAppointment(int id) {
        System.out.println("");
        System.out.println("Existing details: ");

        Appointment foundAppointment = searchAppointmentByID(id);
        showAppointmentById(foundAppointment);
        deleteAppointment(foundAppointment);
        addingAppointment();
    }

    public void addingAppointment() {
        System.out.println("");
        System.out.println("Enter Appointment ID: ");
        int appointmentID = input.nextInt();
        while (checkIfIDExists(appointmentID)) {
            System.out.println("ID already taken, try a new one:");
            int newID = input.nextInt();
            appointmentID = newID;
        }
        System.out.println("Enter Patient Id: ");
        int patientID = input.nextInt();
        System.out.println("Enter Title: ");
        input.nextLine();
        String title = input.nextLine();
        System.out.println("Enter Date: ");
        String date = input.nextLine();
        System.out.println("Enter Start Time: ");
        String startTime = input.nextLine();
        System.out.println("Enter End Time: ");
        String endTime = input.nextLine();
        addAppointment(appointmentID, patientID, title, date, startTime, endTime);
    }
}
