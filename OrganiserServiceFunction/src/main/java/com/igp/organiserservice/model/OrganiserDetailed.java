package com.igp.organiserservice.model;

public class OrganiserDetailed {

    private OrganiserBasic basic;

    private OrganiserEvents uni;

    public OrganiserDetailed(OrganiserBasic studentBasic, OrganiserEvents organiserEvents) {
        this.basic = studentBasic;
        this.uni = organiserEvents;
    }

    public OrganiserBasic getBasic() {
        return basic;
    }

    public OrganiserEvents getUni() {
        return uni;
    }

    public void setBasic(OrganiserBasic basic) {
        this.basic = basic;
    }

    public void setUni(OrganiserEvents uni) {
        this.uni = uni;
    }

    @Override
    public String toString() {
        return "StudentDetailed{}";
    }
}
