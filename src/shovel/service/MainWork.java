package shovel.service;

import shovel.service.tasks.*;
import shovel.service.tasks.base.BaseTask;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainWork {
    private static final int N_THREADS = 5;
    private BaseTask task;
    ExecutorService executor;

    public MainWork(BaseTask task) {
        this.task = task;
        this.executor = Executors.newFixedThreadPool(N_THREADS);
    }

    public void openMenu() {
        task = new DefaultTask();
        task.execute();
    }

    public void openStore() {
        task = new StorageTask();
        task.execute();
    }

    public void joinTeamAgree() {
        task = new JointPartyTask(true);
        task.execute();
    }

    public void joinTeamDegree() {
        task = new JointPartyTask(false);
        task.execute();
    }

    public void inviteParty() {
        task = new InvitePartyTask();
        task.execute();
    }

    public void sell() {
        new SellTask().execute();
    }

    public void advertise(String text) {
        AdvertiseTask advertiseTask = new AdvertiseTask();
        advertiseTask.setText(text);
        advertiseTask.execute();
    }
}
