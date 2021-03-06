package us.cyrien.minecordbot.events;

import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import us.cyrien.minecordbot.Minecordbot;
import us.cyrien.minecordbot.configuration.BroadcastConfig;

public class ShutdownEvent extends Event implements Cancellable {

    private static HandlerList handlerList = new HandlerList();
    private Minecordbot mcb;
    private boolean isCancelled;

    public ShutdownEvent(Minecordbot mcb) {
        this.mcb = mcb;
        isCancelled = false;
    }

    public static HandlerList getHandlerList() {
        return handlerList;
    }

    @Override
    public HandlerList getHandlers() {
        return handlerList;
    }

    @Override
    public boolean isCancelled() {
        isCancelled = !mcb.getMcbConfigsManager().getBroadcastConfig().getBoolean(BroadcastConfig.Nodes.SERVER_SHUT);
        return isCancelled;
    }

    @Override
    public void setCancelled(boolean b) {
        isCancelled = b;
    }
}
