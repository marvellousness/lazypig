package shovel;


import shovel.model.Point;

public class Constant {
    public static final int INTERVAL = 2000;
    public static final int DELAY = 2000;

    // Menus
    public static Point MENU_NHAN_VAT = new Point(720, 60);
    public static Point MENU_HANH_TRANG = new Point(830, 60);
    public static Point MENU_KY_NANG = new Point(960, 60);
    public static Point MENU_DOI_NGU = new Point(1080, 60);
    public static Point MENU_BANG_HOI = new Point(1200, 60);
    public static Point MENU_BAO_VAT = new Point(1330, 60);
    public static Point MENU_CAU_HINH = new Point(1440, 60);

    // Yes/No Dialog
    public static Point DIALOG_AGREE = new Point(700, 590);
    public static Point DIALOG_DEGREE = new Point(1200, 590);

    // Storage Dialog
    public static Point DIALOG_STORE_GIAO_DICH = new Point(580, 590);
    public static Point DIALOG_STORE_KET_THUC_DOI_THOAI = new Point(580, 590);
    public static Point DIALOG_STORE_XAC_NHAN = new Point(850, 644);
    public static Point DIALOG_STORE_HUY_BO = new Point(1060, 644);

    // Storage
    public static Point STORAGE_BUY = new Point(100, 900);
    public static Point STORAGE_SELL = new Point(240, 900);
    public static Point STORAGE_REPAIR = new Point(360, 900);
    public static Point STORAGE_CLOSE = new Point(420, 990);

    // Hanh trang
    public static Point HANH_TRANG_CLOSE = new Point(1640, 1000);

    // Invite Party
    public static Point MENU_INVITE_PARTY = new Point(950, 160);

    // Join Party
    public static Point JOIN_PARTY_EXCLAMATION_ICON = new Point(70, 890);

    // Period time
    public static Integer INVITE_PARTY_MINUTE = 5; // 5 min
    public static Integer JOIN_PARTY__MINUTE = INVITE_PARTY_MINUTE + 2; // 7 min

    public static String ADVERTISE = "mua boi phnl2 nam moc gia hs ngheo -- ai co pm";

    public static String DEFAULT_DEVICE_NAME = "emulator-5554";
}
