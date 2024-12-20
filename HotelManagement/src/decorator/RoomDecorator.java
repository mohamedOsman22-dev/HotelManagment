/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decorator;

import Models.RoomComponent;

/**
 *
 * @author moham
 */
public abstract class RoomDecorator implements RoomComponent {
    protected RoomComponent room;
    
    public RoomDecorator(RoomComponent room) {
        this.room = room;
    }

    @Override
    public int getId() {
        return room.getId();
    }

    @Override
    public String getType() {
        return room.getType();
    }

    @Override
    public String getStatus() {
        return room.getStatus();
        
    }

    @Override
    public double getPrice() {
        return room.getPrice();
    }
    
}
