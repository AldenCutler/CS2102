import java.util.LinkedList;
public class Speedway {

    public Speedway(){

    }

    public class TwoNames {
        public LinkedList<TwoNames.Runner> participants = new LinkedList<TwoNames.Runner>();
        public Runner mascot = new Runner("Corporate Mascot",0);
        TwoNames.Runner fastest = mascot;
        Runner slowest = mascot;
        String nameTwo;
        String nameOne;

        public Speedway addRunner(Runner runner) {
            participants.add(runner);
            return this;
        }

        public TwoNames(String nameOne, String nameTwo) {
            this.nameTwo = nameTwo;
            this.nameOne = nameOne;
            participants.add(mascot);
        }

        public TwoNames fastestAndSlowest() {

            for (Runner runner : this.participants) {
                if (runner.lapTime <= slowest.lapTime) {
                    slowest = runner;
                }
                if (runner.lapTime >= fastest.lapTime) {
                    fastest = runner;

                }
            }
            return new TwoNames(fastest.name, slowest.name);
        }

        public class Runner {
            String name;
            int lapTime;

            public Runner(String name, int lapTime) {
                this.name = name;
                this.lapTime = lapTime;
            }


        }
    }
}

