import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

class SpinnerEventChanger implements ChangeListener {
    SliderMoverJob threadFirst;
    SliderMoverJob threadSecond;
    SliderUI sliderUi;

    public SpinnerEventChanger(SliderMoverJob threadFirst, SliderMoverJob threadSecond, SliderUI sliderUi) {
        this.threadFirst = threadFirst;
        this.threadSecond = threadSecond;
        this.sliderUi = sliderUi;
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        JSpinner source = (JSpinner) e.getSource();
        int value = (int) source.getValue();

        if (source.equals(sliderUi.SpinnerFirstThread)) {
            threadFirst.setPriority(value + 4);
        } else if (source.equals(sliderUi.SpinnerSecondThread)) {
            threadSecond.setPriority(value + 4);
        }
    }
}