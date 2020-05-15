package shovel.service.tasks;

import shovel.Constant;
import shovel.model.Point;
import shovel.service.tasks.base.BaseTask;

import java.util.ArrayList;
import java.util.List;

public class StorageTask extends BaseTask {

    @Override
    protected List<Point> coordinates() {
        List<Point> points = new ArrayList<>();
        points.add(Constant.MENU_HANH_TRANG);

        int row = 320;
        for (int i = 0; i < 5; i++) {
            int delta = 100;
            row = i == 0 ? row : row + delta;
            int col = 1260;
            for (int j = 0; j < 6; j++) {
                col = j == 0 ? col : col + delta;
                points.add(new Point(col, row));
            }
        }

        points.add(Constant.MENU_HANH_TRANG);
        return points;
    }

    @Override
    protected int delay() {
        return 500;
    }
}
