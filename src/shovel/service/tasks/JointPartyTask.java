package shovel.service.tasks;

import shovel.Constant;
import shovel.model.Point;
import shovel.service.tasks.base.BaseTask;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JointPartyTask extends BaseTask {
    private boolean isAgree;

    public JointPartyTask(boolean isAgree) {
        this.isAgree = isAgree;
    }

    @Override
    protected List<Point> coordinates() {
        List<Point> list = new ArrayList<>();

        // FIXME:: Find the best way to repeat this action to 5 times
        for (int i = 0; i < 5; i++) {
            if (isAgree) {
                list.addAll(Arrays.asList(Constant.JOIN_PARTY_EXCLAMATION_ICON, Constant.DIALOG_AGREE));
            } else {
                list.addAll(Arrays.asList(Constant.JOIN_PARTY_EXCLAMATION_ICON, Constant.DIALOG_DEGREE));
            }
        }

        return list;
    }

    @Override
    protected int delay() {
        return 500;
    }
}
