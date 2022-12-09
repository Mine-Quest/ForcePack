package com.convallyria.forcepack.velocity.command;

import com.convallyria.forcepack.velocity.ForcePackVelocity;
import com.velocitypowered.api.command.CommandSource;
import com.velocitypowered.api.command.SimpleCommand;
import com.velocitypowered.api.proxy.Player;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;

public class ForcePackUnloadCommand implements SimpleCommand {

    private final ForcePackVelocity plugin;

    public ForcePackUnloadCommand(final ForcePackVelocity plugin) {
        this.plugin = plugin;
    }

    @Override
    public void execute(final Invocation invocation) {
        final CommandSource source = invocation.source();
        if (!(source instanceof Player)) {
            return;
        }

        Player player = (Player) source;

        plugin.getPackHandler().unloadPack(player);
        player.sendMessage(Component.text("Your resource pack has been unloaded.").color(NamedTextColor.RED));
    }

    @Override
    public boolean hasPermission(final Invocation invocation) {
        return invocation.source().hasPermission("forcepack.reload");
    }
}