package shovel.service.tasks;

import shovel.Constant;
import shovel.model.Point;
import shovel.service.tasks.base.BaseTask;

import java.util.Arrays;
import java.util.List;

public class DefaultTask extends BaseTask {

    @Override
    protected List<Point> coordinates() {
        return Arrays.asList(
                Constant.MENU_NHAN_VAT,
                Constant.MENU_NHAN_VAT,
                Constant.MENU_HANH_TRANG,
                Constant.MENU_HANH_TRANG,
                Constant.MENU_KY_NANG,
                Constant.MENU_KY_NANG,
                Constant.MENU_DOI_NGU,
                Constant.MENU_DOI_NGU);
    }

    @Override
    protected boolean allowClosePanel() {
        return false;
    }

    @Override
    protected int delay() {
        return 500;
    }
}
