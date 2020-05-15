package shovel.controller;

import shovel.service.MainWork;
import shovel.service.tasks.DefaultTask;

public class Controller {
    private MainWork mainWork;

    public Controller() {
        initMainWork();
    }

    private void initMainWork() {
        mainWork = new MainWork(new DefaultTask());
    }

    private void testJoinPartyDegree() {
        mainWork.joinTeamAgree();
    }

    private void testOpenMenu() {
        mainWork.openMenu();
    }

    private void testOpenStore() {
        mainWork.openStore();
    }

    private void testSell() {
        mainWork.sell();
    }

}
