package com.palmergames.bukkit.towny.event;

import com.palmergames.bukkit.towny.object.TownBlock;
import com.palmergames.bukkit.towny.object.TownBlockType;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class PlotChangeTypeEvent extends Event {
    public static final HandlerList handlers = new HandlerList();
    private TownBlockType oldType;
    private TownBlockType newType;
    private TownBlock townBlock;

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

    /**
     * @param oldType- Old Type
     * @param newType - New Type
     */
    public PlotChangeTypeEvent(TownBlockType oldType, TownBlockType newType, TownBlock townBlock, boolean async) {
    	super(async);
        this.newType = newType;
        this.oldType = oldType;
        this.townBlock = townBlock;
    }

    public TownBlockType getNewType() {
        return newType;
    }

    public TownBlockType getOldType() {
        if (oldType == null) {
            return TownBlockType.WILDS; // Considering the further fact we know null is wilderness if there is no old type, it has to have been wilderness.
        }
        return oldType;
    }

    public TownBlock getTownBlock() {
        return townBlock;
    }
}
