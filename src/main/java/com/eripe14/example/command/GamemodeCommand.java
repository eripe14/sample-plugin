package com.eripe14.example.command;


import com.eripe14.example.notification.NotificationAnnouncer;
import dev.rollczi.litecommands.annotations.argument.Arg;
import dev.rollczi.litecommands.annotations.command.Command;
import dev.rollczi.litecommands.annotations.context.Context;
import dev.rollczi.litecommands.annotations.execute.Execute;
import dev.rollczi.litecommands.annotations.optional.OptionalArg;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;

@Command(name = "gamemode", aliases = "gm")
public class GamemodeCommand {

    private final NotificationAnnouncer notificationAnnouncer;

    public GamemodeCommand(NotificationAnnouncer notificationAnnouncer) {
        this.notificationAnnouncer = notificationAnnouncer;
    }

    @Execute
    void execute(@Context Player sender, @Arg GameMode gameMode, @OptionalArg Player target) {
        if (target != null) {
            target.setGameMode(gameMode);

            this.notificationAnnouncer.sendMessage(sender, "<gradient:#5555ff:#ffffff>Ustawiłeś tryb gry " + gameMode + "</gradient> <gradient:#ffffff:#5555ff>graczowi " + target.getName());
            return;
        }

        sender.setGameMode(gameMode);
        this.notificationAnnouncer.sendMessage(sender, "<gradient:#5555ff:#ffffff>Zmieniono tryb gry na " + gameMode);
    }

}