package com.mjc.stage2.impl;

import com.mjc.stage2.Observer;
import com.mjc.stage2.entity.Rectangle;
import com.mjc.stage2.entity.RectangleValues;
import com.mjc.stage2.event.RectangleEvent;
import com.mjc.stage2.warehouse.RectangleWarehouse;

public class RectangleObserver implements Observer {
    // Write your code here!
    @Override
    public void handleEvent(RectangleEvent event) {
        Rectangle rectangle = event.getSource();
        int rectangleId = rectangle.getId();
        double updatedSquare = rectangle.getSideA() * rectangle.getSideB();
        double updatedPerimeter = 2 * (rectangle.getSideA() + rectangle.getSideB());
        RectangleValues updatedRectangleValues = new RectangleValues(updatedSquare, updatedPerimeter);
        RectangleWarehouse rectangleWarehouse = RectangleWarehouse.getInstance();
        rectangleWarehouse.put(rectangleId, updatedRectangleValues);
    }
}
