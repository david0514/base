package hu.bme.mit.train.system;
import hu.bme.mit.train.interfaces.TrainController;

public class TimerThread implements Runnable{
    TrainController c;
    TimerThread(TrainController c){
        this.c=c;
    }
    @Override
    public void run() {
        while(true){
            c.followSpeed();
            System.out.println("Jelenlegi sebesseg: " + c.getReferenceSpeed());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
