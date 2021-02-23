package com.igp.organiserservice.dao;

import com.igp.organiserservice.model.Organiser;

public interface OrganiserCrudDao {
     Organiser createOrganiser(Organiser organiser);
     Organiser readOrganiser(String organiserId);
     Organiser updateOrganiser(Organiser organiser);
     void deleteOrganiser(String organiserId);
}
