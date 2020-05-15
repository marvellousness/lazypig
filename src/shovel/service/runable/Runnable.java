package shovel.service.runable;

import shovel.model.Point;

public interface Runnable {
    void doSingleTap(Point point);

    void doDoubleTap(Point point);

    void doSwipe(Point from, Point to, Long duration);

    void doInputText(String text);
}
