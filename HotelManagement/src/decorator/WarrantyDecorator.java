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
public class WarrantyDecorator extends RoomDecorator {
    private static final double WARRANTY_COST = 15.0;

    public WarrantyDecorator(RoomComponent room) {
        super(room);
    }
    @Override
    public double getPrice() {
        return super.getPrice() + WARRANTY_COST;
    }

}
