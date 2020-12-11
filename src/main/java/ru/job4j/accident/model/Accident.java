package ru.job4j.accident.model;

import java.util.Objects;

public class Accident {
    private int id;
    private String description;
    private String carNumber;
    private String address;
    private String photoPath;
    private String status;

    public Accident(String description, String carNumber, String address, String photoPath, String status) {
        this.description = description;
        this.carNumber = carNumber;
        this.address = address;
        this.photoPath = photoPath;
        this.status = status;
    }

    public Accident() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Accident accident = (Accident) o;
        return id == accident.id &&
                Objects.equals(description, accident.description) &&
                Objects.equals(carNumber, accident.carNumber) &&
                Objects.equals(address, accident.address) &&
                Objects.equals(photoPath, accident.photoPath) &&
                Objects.equals(status, accident.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, carNumber, address, photoPath, status);
    }

    @Override
    public String toString() {
        return "Accident{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", carNumber='" + carNumber + '\'' +
                ", address='" + address + '\'' +
                ", photoPath='" + photoPath + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
