package com.example.ayanbadejo.tourapp;

import android.os.Parcel;
import android.os.Parcelable;

public class Tour implements Parcelable {
    /*
    In this case, we will define a Tour class which represents the data model being displayed by the RecyclerView
    and implement interface parcelable to accessibility
     */
    private String topic;
    private String summary;
    private int imageTour;

    Tour(String summary, String topic, int imageTour) {
        this.imageTour = imageTour;
        this.topic = topic;
        this.summary = summary;
    }

    Tour(String summary,int imageTour) {
        this.imageTour = imageTour;
        this.summary = summary;
    }
    Tour(String summary,String topic) {
        this.topic = topic;
        this.summary = summary;
    }

    private Tour(Parcel in) {
        topic = in.readString ();
        summary = in.readString ();
        imageTour = in.readInt ();
    }

    public static final Creator<Tour> CREATOR = new Creator<Tour> () {
        @Override
        public Tour createFromParcel(Parcel in) {
            return new Tour (in);
        }

        @Override
        public Tour[] newArray(int size) {
            return new Tour[size];
        }
    };


    public String getTopic() {
        return topic;
    }

    public String getSummary() {
        return summary;
    }

    public int getImageTour() {
        return imageTour;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString (topic);
        parcel.writeString (summary);
        parcel.writeInt (imageTour);
    }
}