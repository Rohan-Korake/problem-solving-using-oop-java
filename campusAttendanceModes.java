// Attendance class 
class AttendanceMode {
    public boolean mark(String prn) {
        return false;
    }

    public String modeName() {
        return "Generic";
    }
}

// Biometric class
class Biometric extends AttendanceMode {
    public boolean mark(String prn) {
        return prn != null && prn.length() == 10;
    }

    public String modeName() {
        return "Biometric";
    }
}

// ORCode class
class ORCode extends AttendanceMode {
    public boolean mark(String prn) {
        return prn != null && prn.startsWith("23");
    }

    public String modeName() {
        return "QRCode";
    }
}

// Manual class
class Manual extends Biometric {
    public boolean mark(String prn) {
        return super.mark(prn);
    }

    public String modeName() {
        return "Manual";
    }

    public void notifyParent(String prn) {
        System.out.println("[Parent Alert] Attendance rejected for PRN: " + prn);
    }
}

public class campusAttendanceModes {
    public static void record(AttendanceMode m, String prn) {
        boolean status = m.mark(prn);
        String statusStr = status ? "PRESENT" : "REJECTED";
        System.out.println(m.modeName() + " | " + prn + "  | " + statusStr);
    }

    public static void main(String args[]) throws Exception {

        AttendanceMode[] modes = {
                new Biometric(),
                new ORCode(),
                new Manual()
        };

        String[] prns = { "2311001234", "2311001235", "23110" };

        for (AttendanceMode mode : modes) {
            for (String prn : prns) {
                record(mode, prn);

                if (!mode.mark(prn) && mode instanceof Manual) {
                    ((Manual) mode).notifyParent(prn);
                }

            }
        }
        return;
    }

}