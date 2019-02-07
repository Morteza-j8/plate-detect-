package ir.jalambadani.openalpr.controller;

import ir.jalambadani.openalpr.alpr.response.Coordinate;

import java.io.Serializable;
import java.util.List;

/**
 * created by: Morteza
 * company: mobin
 * package: ir.jalambadani.openalpr.controller
 * project name:  openalpr
 * 05 February 2019
 **/


public class PredicateResponse implements Serializable {

    private String fileName;

    private String label;

    private String predicateFirstTime = "-";

    private String predicateSecondTime = "-";

    private List<Coordinate > firstArea;

    private List<Coordinate> secondArea;


    private int errorPredicateFirst  = -1;

    private int errorPredicateSecond = -1;




    public PredicateResponse() {
    }



    public String getFileName() {
        return fileName;
    }
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }


    public String getLabel() {
        return label;
    }
    public void setLabel(String label) {
        this.label = label;
    }


    public String getPredicateFirstTime() {
        return predicateFirstTime;
    }
    public void setPredicateFirstTime(String predicateFirstTime) {
        this.predicateFirstTime = predicateFirstTime;
    }


    public String getPredicateSecondTime() {
        return predicateSecondTime;
    }
    public void setPredicateSecondTime(String predicateSecondTime) {
        this.predicateSecondTime = predicateSecondTime;
    }


    public List < Coordinate > getFirstArea() {
        return firstArea;
    }
    public void setFirstArea(List < Coordinate > firstArea) {
        this.firstArea = firstArea;
    }


    public List < Coordinate > getSecondArea() {
        return secondArea;
    }
    public void setSecondArea(List < Coordinate > secondArea) {
        this.secondArea = secondArea;
    }


    public int getErrorPredicateFirst() {
        return errorPredicateFirst;
    }
    public void setErrorPredicateFirst(int errorPredicateFirst) {
        this.errorPredicateFirst = errorPredicateFirst;
    }



    public int getErrorPredicateSecond() {
        return errorPredicateSecond;
    }
    public void setErrorPredicateSecond(int errorPredicateSecond) {
        this.errorPredicateSecond = errorPredicateSecond;
    }



}
