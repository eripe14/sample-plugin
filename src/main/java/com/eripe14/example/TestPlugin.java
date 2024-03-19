package com.eripe14.example;


import com.eripe14.example.command.FlyCommand;
import com.eripe14.example.command.GamemodeCommand;
import com.eripe14.example.notification.NotificationAnnouncer;
import com.eripe14.example.util.LegacyColorProcessor;
import dev.rollczi.litecommands.LiteCommands;
import dev.rollczi.litecommands.bukkit.LiteCommandsBukkit;
import net.kyori.adventure.platform.AudienceProvider;
import net.kyori.adventure.platform.bukkit.BukkitAudiences;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class TestPlugin extends JavaPlugin {

    private AudienceProvider audienceProvider;
    private MiniMessage miniMessage;
    private NotificationAnnouncer notificationAnnouncer;

    private LiteCommands<CommandSender> liteCommands;

    @Override
    public void onEnable() {
        this.audienceProvider = BukkitAudiences.create(this);
        this.miniMessage = MiniMessage.builder()
                .postProcessor(new LegacyColorProcessor())
                .build();
        this.notificationAnnouncer = new NotificationAnnouncer(this.audienceProvider, this.miniMessage);

        this.liteCommands = LiteCommandsBukkit.builder()
                .settings(settings -> settings
                        .fallbackPrefix("test")
                        .nativePermissions(false)
                )
                .commands(
                        new GamemodeCommand(this.notificationAnnouncer),
                        new FlyCommand(this.notificationAnnouncer))
                .build();
    }

}