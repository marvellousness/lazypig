package shovel.run;

import shovel.Constant;
import shovel.service.MainWork;
import shovel.service.tasks.DefaultTask;

import java.util.concurrent.*;

public class ScheduleService {
    private ScheduledExecutorService scheduledExecutor;
    private MainWork mainWork;

    public ScheduleService() {
        scheduledExecutor = Executors.newScheduledThreadPool(1);
        mainWork = new MainWork(new DefaultTask());
    }

    public void startInviteJoinParty() {
        initScheduledExecutor();
        scheduledExecutor.scheduleAtFixedRate(invitePartySchedule(), 0, Constant.INVITE_PARTY_MINUTE, TimeUnit.MINUTES);
        scheduledExecutor.scheduleAtFixedRate(joinPartySchedule(), 0, Constant.JOIN_PARTY__MINUTE, TimeUnit.MINUTES);
    }

    private Runnable invitePartySchedule() {
        return () -> {
            mainWork.inviteParty();
        };
    }

    private Runnable joinPartySchedule() {
        return () -> {
            mainWork.joinTeamAgree();
        };
    }

    public void stop() {
        scheduledExecutor.shutdown();
        try {
            if (!scheduledExecutor.awaitTermination(800, TimeUnit.MILLISECONDS)) {
                scheduledExecutor.shutdownNow();
            }
        } catch (InterruptedException e) {
            scheduledExecutor.shutdownNow();
        }
    }

    private void initScheduledExecutor() {
        if (scheduledExecutor != null && scheduledExecutor.isTerminated() || scheduledExecutor.isShutdown()) {
            scheduledExecutor = Executors.newScheduledThreadPool(1);
        }
    }
}
