import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLOutput;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Main {

    static SliderMoverJob threadFirst;
    static SliderMoverJob threadSecond;
    static SliderUI sliderUi;
    static SpinnerEventChanger spinnerEventChanger;

    public static void main(String[] args) {
        sliderUi = new SliderUI();
        threadFirst = new SliderMoverJob(sliderUi.SliderThread, 10);
        threadSecond = new SliderMoverJob(sliderUi.SliderThread, 90);
        spinnerEventChanger = new SpinnerEventChanger(threadFirst, threadSecond, sliderUi);


        int numOfJobs = Runtime.getRuntime().availableProcessors();
        ExecutorService executorService = Executors.newFixedThreadPool(numOfJobs);
        for (int i = 0; i < numOfJobs; i++) {
            executorService.execute(new DoNothingJob());
        }
        sliderUi.StartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!threadFirst.isAlive() && !threadSecond.isAlive()) {
                    threadFirst.start();
                    threadSecond.start();
                }
            }
        });

        sliderUi.SpinnerFirstThread.addChangeListener(spinnerEventChanger);
        sliderUi.SpinnerSecondThread.addChangeListener(spinnerEventChanger);

        sliderUi.Frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                threadFirst.stopJob();
                threadSecond.stopJob();
                executorService.shutdownNow();
                try {
                    executorService.awaitTermination(10, TimeUnit.SECONDS);
                } catch (InterruptedException ex) {
                    System.exit(-1);

                }
                System.exit(0);
            }
        });
    }

    static class DoNothingJob implements Runnable {
        @Override
        public void run() {
            while (true) {
                try {
                    System.out.println(Thread.currentThread().getName());
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    break;
                }
            }
        }
    }
}






