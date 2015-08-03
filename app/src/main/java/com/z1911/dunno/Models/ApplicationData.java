package com.z1911.dunno.Models;

import com.sromku.simple.fb.SimpleFacebook;
import com.sromku.simple.fb.entities.Profile;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nicola on 21/07/2015.
 */
public class ApplicationData {
    public static String test = "sample";
    public List<Profile> mProfiles;

    public ApplicationData(){
        mProfiles = new ArrayList<>();
        mProfiles.add(0,new Profile());
    }
}
