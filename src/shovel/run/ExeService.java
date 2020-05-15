package shovel.run;

import shovel.service.MainWork;
import shovel.service.tasks.DefaultTask;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public class ExeService {
    private ExecutorService executor;
    private MainWork mainWork;

    public ExeService(ExecutorService executorService) {
        this.executor = executorService;
        mainWork = new MainWork(new DefaultTask());
    }

    public void startInviteParty() {
        executor.execute(invitePartyRunnable());
    }

    public void startJoinParty() {
        executor.execute(joinPartyRunnable());
    }

    public void startSellItems() {
        executor.execute(sellItemsRunnable());
    }

    public void startAdvertise(String repeat, String content) {
        executor.execute(advertiseRunnable(repeat, content));
    }

    public void startOpenMenu() {
        executor.execute(openMenuRunnable());
    }

    public void startOpenStore() {
        executor.execute(openStoreRunnable());
    }

    private Runnable advertiseRunnable(String repeat, String content) {
        return () -> {
            for (int i = 0; i < Integer.parseInt(repeat); i++) {
                mainWork.advertise("\"" + content + "\"");
            }
        };
    }

    private Runnable invitePartyRunnable() {
        return () -> {
            mainWork.inviteParty();
        };
    }

    private Runnable joinPartyRunnable() {
        return () -> {
            mainWork.joinTeamAgree();
        };
    }

    private Runnable sellItemsRunnable() {
        return () -> {
            mainWork.sell();
        };
    }

    private Runnable openMenuRunnable() {
        return () -> {
            mainWork.openMenu();
        };
    }

    private Runnable openStoreRunnable() {
        return () -> {
            mainWork.openStore();
        };
    }

    public void stop() {
        executor.shutdown();
        try {
            if (!executor.awaitTermination(800, TimeUnit.MILLISECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }
}
