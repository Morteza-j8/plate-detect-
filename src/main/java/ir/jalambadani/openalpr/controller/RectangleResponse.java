package ir.jalambadani.openalpr.controller;

import ir.jalambadani.openalpr.alpr.response.Coordinate;

import java.io.Serializable;

/**
 * created by: Morteza
 * company: mobin
 * package: ir.jalambadani.openalpr.controller
 * project name:  openalpr
 * 07 February 2019
 **/


public class RectangleResponse implements Serializable {

    private int topLeftX;

    private int topLeftY;

    private int bottomRightX;

    private int bottomRightY;


    public RectangleResponse() {
    }

    public RectangleResponse(Coordinate c1, Coordinate c2) {
        if(c1.getX() < c2.getX()){
            this.topLeftX = c1.getX();
            this.topLeftY = c1.getY();
            this.bottomRightX = c2.getX();
            this.bottomRightY = c2.getY();
        }else{
            this.topLeftX = c2.getX();
            this.topLeftY = c2.getY();
            this.bottomRightX = c1.getX();
            this.bottomRightY = c1.getY();
        }
    }


    public int getTopLeftX() {
        return topLeftX;
    }
    public void setTopLeftX(int topLeftX) {
        this.topLeftX = topLeftX;
    }



    public int getTopLeftY() {
        return topLeftY;
    }
    public void setTopLeftY(int topLeftY) {
        this.topLeftY = topLeftY;
    }



    public int getBottomRightX() {
        return bottomRightX;
    }
    public void setBottomRightX(int bottomRightX) {
        this.bottomRightX = bottomRightX;
    }



    public int getBottomRightY() {
        return bottomRightY;
    }
    public void setBottomRightY(int bottomRightY) {
        this.bottomRightY = bottomRightY;
    }



    public String postfixLinkArea(int index){
        return
                "tlx" + index + "=" + getTopLeftX() + "&" +
                "tly" + index + "=" + getTopLeftY() + "&" +
                "brx" + index + "=" + getBottomRightX() + "&" +
                "bry" + index + "=" + getTopLeftY();
    }

}
