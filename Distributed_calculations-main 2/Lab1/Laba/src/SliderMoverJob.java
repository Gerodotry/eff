import javax.swing.*;

class SliderMoverJob extends Thread {
    final JSlider slider;
    int numberToSlider;
    boolean stop = false;

    public volatile int timeout = 10;

    public SliderMoverJob(JSlider slider, int numberToSlider) {
        this.slider = slider;
        this.numberToSlider = numberToSlider;
    }

    public void stopJob() {
        stop = true;
    }

    public void run() {
        while (!stop) {
            try {
                synchronized (slider) {
                    int newSliderNumber = (int) slider.getValue();
                    if (newSliderNumber > numberToSlider)
                        newSliderNumber -= 1;
                    else if (newSliderNumber < numberToSlider)
                        newSliderNumber += 1;
                    slider.setValue(newSliderNumber);
                }
                Thread.sleep(timeout);
            } catch (Exception e) {
                System.out.println("Exception is caught");
            }
        }
    }


}
