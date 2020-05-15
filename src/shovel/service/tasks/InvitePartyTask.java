package shovel.service.tasks;

import shovel.Constant;
import shovel.model.Point;
import shovel.service.tasks.base.BaseTask;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class InvitePartyTask extends BaseTask {
    int x = 960;
    int y = 480;
    int d = 200;
    int minX = x - d;
    int maxX = x + d;
    int minY = y - d;
    int maxY = y + d;

    @Override
    protected List<Point> coordinates() {
        List<Point> points = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                int deltaX = random(minX, maxX);
                int deltaY = random(minY, maxY);
                points.add(new Point(deltaX, deltaY));
                points.add(Constant.MENU_INVITE_PARTY);
            }
        }
        return points;
    }

    @Override
    protected int delay() {
        return 200;
    }

    private int random(int min, int max) {
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
}
