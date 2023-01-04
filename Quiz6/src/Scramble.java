import java.util.HashMap;

class InvalidStartTimeException extends Exception {
    private int value;
    public InvalidStartTimeException(int value) {
        this.value = value;
    }
    public void print() {
        System.out.println(this.value + " is not a valid start time.");
    }
}

class Main {
    public static void main(String args[]) {
        SchoolSchedule aSchedule = new SchoolSchedule(new HashMap<String, SchoolClass>());
        try {
            aSchedule.addPeriod("Calculus", new SchoolClass("Calculus", 400));
        } catch (InvalidStartTimeException e) {
            e.print();
        }
    }
}
class SchoolClass {
    private int startTime;
    private String className;
    public SchoolClass(String className, int startTime) {
        this.startTime = startTime;
        this.className = className;
    }
    public boolean checkStartTime() throws InvalidStartTimeException {
        if (this.startTime < 800 || this.startTime > 1400) throw new InvalidStartTimeException(startTime);
        return true;
    }
}
class SchoolSchedule {
    private HashMap<String, SchoolClass> schedule;
    public SchoolSchedule(HashMap<String, SchoolClass> schedule) {
        this.schedule = schedule;
    }

    public void addPeriod(String className, SchoolClass aClass) throws InvalidStartTimeException {
        if (aClass.checkStartTime()) schedule.put(className, aClass);
    }
}




