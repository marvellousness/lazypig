package shovel;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import shovel.run.ExeService;
import shovel.run.ScheduleService;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;

public class Main extends Application {
    private TextField advContentTf;
    private TextField repeatTimeTf;
    private CheckBox autoInviteJoinPartyCb = new CheckBox("Auto Invite + Join Party");
    private Button jointPartyBtn = new Button("Join Party");
    private Button invitePartyBtn = new Button("Invite Party");
    private Button sellItemsBtn = new Button("Sell Items");
    private Button advertiseBtn = new Button("Advertise");
    private Button openMenuBtn = new Button("Open Menu");
    private Button openStoreBtn = new Button("Open Store");
    private Label headerLabel = new Label("This is an automatic action simulation on the phone");

    private ExeService exeService = new ExeService(Executors.newFixedThreadPool(1));
    private ScheduleService scheduleService = new ScheduleService();
    private DeviceDetector deviceDetector = new DeviceDetector();
    private List<String> selectedDevices = new ArrayList<>();

    @Override
    public void start(Stage primaryStage) {
        buildUI(primaryStage);
    }

    private void buildUI(Stage stage) {
        advContentTf = new TextField(Constant.ADVERTISE);
        advContentTf.setPrefWidth(400);
        advContentTf.setMaxWidth(400);
        repeatTimeTf = new TextField("3");
        repeatTimeTf.setPrefWidth(50);
        repeatTimeTf.setMaxWidth(50);

        openMenuBtn.setOnMouseClicked(event -> testOpenMenu());
        openStoreBtn.setOnMouseClicked(event -> testOpenStore());
        jointPartyBtn.setOnMouseClicked(event -> testJoinParty());
        invitePartyBtn.setOnMouseClicked(event -> testInviteParty());
        sellItemsBtn.setOnMouseClicked(event -> testSellItems());
        advertiseBtn.setOnMouseClicked(event -> testAdvertise());
        autoInviteJoinPartyCb.setOnMouseClicked(event -> testAutoInviteJoinParty());

        //Creating a Grid Pane
        GridPane gridPane = new GridPane();

        //Setting size for the pane
        gridPane.setMinSize(400, 400);

        //Setting the padding
        gridPane.setPadding(new Insets(10, 10, 10, 10));

        //Setting the vertical and horizontal gaps between the columns
        gridPane.setVgap(10);
        gridPane.setHgap(10);

        //Arranging all the nodes in the grid
        gridPane.add(headerLabel, 0, 0);
        gridPane.add(openMenuBtn, 0, 1);
        gridPane.add(openStoreBtn, 0, 2);
        gridPane.add(jointPartyBtn, 0, 3);
        gridPane.add(invitePartyBtn, 0, 4);
        gridPane.add(sellItemsBtn, 0, 5);
        gridPane.add(repeatTimeTf, 0, 6);
        gridPane.add(advContentTf, 0, 7);
        gridPane.add(advertiseBtn, 0, 8);
        gridPane.add(autoInviteJoinPartyCb, 0, 9);

        GridPane primaryGrid = new GridPane();
        primaryGrid.addRow(0, headerLabel);
        primaryGrid.addRow(1, new Label("Devices"));

        List<String> devices = deviceDetector.getDevices();
        final CheckBox[] cbs = new CheckBox[devices.size()];

        final Integer rowIndex = 3;
        for (int i = 0; i < devices.size(); i++) {
            CheckBox cb = cbs[i] = new CheckBox(devices.get(i));

            // Hardcode for default emulator
            if (devices.get(i).equals(Constant.DEFAULT_DEVICE_NAME)) {
                cb.setIndeterminate(false);
                cb.setSelected(true);
            }

            int finalI = i;
            cb.selectedProperty().addListener((observable, oldValue, newValue) -> {
                if (newValue) {
                    selectedDevices.add(devices.get(finalI));
                } else {
                    selectedDevices.remove(devices.get(finalI));
                }
            });

            primaryGrid.addRow(rowIndex + i, cb);
        }

        primaryGrid.addRow(rowIndex + 1 + devices.size(), gridPane);

        //Creating a scene object
        Scene scene = new Scene(primaryGrid);

        //Setting title to the Stage
        stage.setTitle("Human simulation");

        //Adding scene to the stage
        stage.setScene(scene);

        //Displaying the contents of the stage
        stage.show();

        stage.setOnCloseRequest(e -> handleExit());
    }

    private void handleExit() {
        Platform.exit();
        System.exit(0);
    }

    public static void main(String[] args) {
        launch(args);
    }

    private void testJoinParty() {
        exeService.startJoinParty();
    }

    private void testInviteParty() {
        exeService.startInviteParty();
    }

    private void testOpenMenu() {
        exeService.startOpenMenu();
    }

    private void testOpenStore() {
        exeService.startOpenStore();
    }

    private void testSellItems() {
        exeService.startSellItems();
    }

    private void testAdvertise() {
        exeService.startAdvertise(repeatTimeTf.getText(), advContentTf.getText());
    }

    private void testAutoInviteJoinParty() {
        if (autoInviteJoinPartyCb.isSelected()) {
            scheduleService.startInviteJoinParty();
        } else {
            scheduleService.stop();
        }
    }
}
