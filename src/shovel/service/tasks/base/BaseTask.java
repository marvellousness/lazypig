package shovel.service.tasks.base;

import shovel.Constant;
import shovel.model.Point;
import shovel.service.runable.Runnable;
import shovel.service.runable.RunnableImpl;

import java.util.List;

public abstract class BaseTask {
    protected Runnable runnable;
    protected List<Point> points;

    public BaseTask() {
        runnable = new RunnableImpl(delay());
    }

    /**
     * Run in steps
     * step 2: build points
     * step 1: open panel in time based on the list of items
     * step 3: execute
     * step 4: close panel
     */
    public void execute() {
        points = coordinates();
        for (Point point : points) {
            runnable.doSingleTap(point);
        }

        if (allowClosePanel()) {
            closePanel();
        }
    }

    private void closePanel() {
        runnable.doSingleTap(points.get(0));
    }

    /**
     * The delay perform in n time
     *
     * @return mount of time
     */
    protected int delay() {
        return Constant.DELAY;
    }

    /**
     * Build the list of points need to tap on it
     *
     * @return The list of points
     */
    protected abstract List<Point> coordinates();

    /**
     * This indicate that allow to close the dialog
     *
     * @return true if you want to close the dialog
     */
    protected boolean allowClosePanel() {
        return false;
    }

}
