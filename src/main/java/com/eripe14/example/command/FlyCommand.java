package com.eripe14.example.command;

import com.eripe14.example.notification.NotificationAnnouncer;
import dev.rollczi.litecommands.annotations.command.Command;
import dev.rollczi.litecommands.annotations.context.Context;
import dev.rollczi.litecommands.annotations.execute.Execute;
import dev.rollczi.litecommands.annotations.optional.OptionalArg;
import org.bukkit.entity.Player;

// random comment 14

@Command(name = "fly")
public class FlyCommand {

    private final NotificationAnnouncer notificationAnnouncer;

    public FlyCommand(NotificationAnnouncer notificationAnnouncer) {
        this.notificationAnnouncer = notificationAnnouncer;
    }

    @Execute
    void execute(@Context Player sender, @OptionalArg Player target) {
        if (target != null) {
            target.setAllowFlight(!target.getAllowFlight());
            this.notificationAnnouncer.sendMessage(sender, "<gradient:#5555ff:#ffffff>Zmieniłeś status latania gracza " + target.getName() + " na <yellow>" + target.getAllowFlight());

            return;
        }

        sender.setAllowFlight(!sender.getAllowFlight());
        this.notificationAnnouncer.sendMessage(sender, "<gradient:#5555ff:white>Zmieniłeś swój status latania na " + sender.getAllowFlight());
    }

}