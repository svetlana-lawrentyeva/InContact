package com.skillsup.model;

/**
 * Created with IntelliJ IDEA.
 * User: nau
 * Date: 12/20/14
 * Time: 4:38 PM
 * To change this template use File | Settings | File Templates.
 */
public interface Place {
    String getTitle();

    void setTitle(String title);

    double getLongitude();

    void setLongitude(double longitude);

    double getLatitude();

    void setLatitude(double latitude);

    String getDescription();

    void setDescription(String description);

    public int getId();

    public void setId(int id);
}
