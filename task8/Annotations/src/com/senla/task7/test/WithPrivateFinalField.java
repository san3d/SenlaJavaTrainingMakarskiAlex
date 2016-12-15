package com.senla.task7.test;

import com.senla.task7.annotations.ConfigProperty;

public class WithPrivateFinalField { 
    @ConfigProperty
	private int i = 1; 
    @Deprecated
    private final String s = "String S"; 
    private String s2 = "String S2"; 
 
    public String toString() { 
        return "i = " + i + ", " + s + ", " + s2; 
    } 
} 
