import java.util.LinkedList;
public class Speedway {
    public LinkedList<Runner> participants = new LinkedList<Runner>();
    public Runner mascot = new Runner("Corporate Mascot",0);
    Runner slowest = mascot;
    Runner fastest = mascot;

    public Speedway(){
        participants.add(mascot);
    }

    public class Runner {
        String name;
        int lapTime;
        public Runner(String name, int lapTime) {
            this.name = name;
            this.lapTime = lapTime;

        }
    }

    public class TwoNames {
        String nameOne;
        String nameTwo;


        public TwoNames(String nameOne, String nameTwo) {
            this.nameOne = nameOne;
            this.nameTwo = nameTwo;
        }
    }

    public TwoNames fastestAndSlowest(){
        for(Runner runner: this.participants){
            if(runner.lapTime <= slowest.lapTime){
                slowest = runner;
            }
            if(runner.lapTime >= fastest.lapTime){
                fastest = runner;
            }
        }
        return new TwoNames(fastest.name,slowest.name);
    }

    public Speedway addRunner(Runner runner) {
        participants.add(runner);
        return this;
    }

}