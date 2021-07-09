package com.example.meetingroom.Entity;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @Column(name = "USERNAME")
    private String username;

    @Column(name = "PASSWORD")
    private String password;


    @Column(nullable = false,name = "FULL_NAME")
    private String full_name;

    public User(String username, String password, String full_name) {
        this.username = username;
        this.password = password;
        this.full_name = full_name;
    }

    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY)
    private List<Invitation>  invitations = new ArrayList<>();


    @OneToMany(mappedBy = "host",fetch = FetchType.LAZY)
    private List<Reservation> hostedMeetings = new ArrayList<>();

    public ArrayList<Room> getRooms(){
        ArrayList<Room> rooms = new ArrayList<>();
        for(Invitation res : invitations){
            rooms.add(res.getReservation().getRoom());
        }
        return rooms;
    }

    public User() {}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }
}
