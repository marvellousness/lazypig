package shovel.service.runable;

import shovel.model.Point;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;
import static shovel.Constant.DEFAULT_DEVICE_NAME;

public class RunnableImpl implements Runnable {
    private Runtime r = Runtime.getRuntime();
    private String server = "adb -s " + DEFAULT_DEVICE_NAME;
    private String tapCommand = server + " shell input tap ";
    private String inputTextCommand = server + " shell input text ";
    private int delay;

    public RunnableImpl(int delay) {
        this.delay = delay;
    }

    @Override
    public void doSingleTap(Point point) {
        try {
            r.exec(tapCommand + point.getX() + " " + point.getY());
            sleep(delay);
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void doDoubleTap(Point point) {
        try {
            r.exec(tapCommand + point.getX() + " " + point.getY());
            sleep(delay / 2);
            r.exec(tapCommand + point.getX() + " " + point.getY());
            sleep(delay);
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void doSwipe(Point from, Point to, Long duration) {

    }

    @Override
    public void doInputText(String text) {
        try {
            r.exec(inputTextCommand + text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private long millisecondToSecond(int millis) {
        return TimeUnit.MILLISECONDS.toSeconds(millis);
    }

}
