package DataSource.Model;

import DataSource.Enums.Enums;

public class User {
    private String userID, email, nama, password;
    private Enums.UserRole role;

    public User(String userID, String email, String nama, Enums.UserRole role, String password) {
        this.userID = userID;
        this.email = email;
        this.nama = nama;
        this.role = role;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Enums.UserRole getRole() {
        return role;
    }

    public void setRole(Enums.UserRole role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
