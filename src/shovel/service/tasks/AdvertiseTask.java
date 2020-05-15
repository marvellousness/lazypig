package shovel.service.tasks;

import shovel.model.Point;
import shovel.service.tasks.base.BaseTask;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Thread.sleep;

public class AdvertiseTask extends BaseTask {
    protected String text;

    @Override
    protected List<Point> coordinates() {
        List<Point> points = new ArrayList<>();
        points.add(new Point(570, 930));
        points.add(new Point(60, 1024));
        points.add(new Point(1660, 440));
        return points;
    }

    @Override
    public void execute() {
        try {
            points = coordinates();
            runnable.doSingleTap(points.get(0));
            runnable.doInputText(text);
            sleep(3000);
            runnable.doSingleTap(points.get(2));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected int delay() {
        return 700;
    }

    public void setText(String text) {
        this.text = text;
    }
}
