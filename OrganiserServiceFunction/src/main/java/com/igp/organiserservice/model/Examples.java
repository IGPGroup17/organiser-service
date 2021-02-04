package com.igp.organiserservice.model;

public class Examples {

    public static final OrganiserBasic EXAMPLE_BASIC = new OrganiserBasic("johnbernadis93", "Leon Watts", 27, "Male");

    public static final OrganiserEvents EXAMPLE_UNI = new OrganiserEvents("johnbernadis93@gmail.com", "University of Bath", 2, "Computer Science (BSc) Hons");


    public static final OrganiserDetailed EXAMPLE_DETAILED = new OrganiserDetailed(EXAMPLE_BASIC, EXAMPLE_UNI);
}
