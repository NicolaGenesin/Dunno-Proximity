package com.z1911.dunno.Models;

import com.sromku.simple.fb.entities.Profile;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nicola Genesin on 21/07/2015.
 * Copyright (C) 2015 1911.
 */
public class ApplicationData {
    private static ApplicationData instance;
    public List<Profile> mProfiles;

    public ApplicationData() {
        mProfiles = new ArrayList<>();
        mProfiles.add(new Profile());
    }

    public static ApplicationData getInstance() {
        if (instance == null) {
            return new ApplicationData();
        }
        return instance;
    }
}
