package lad1.example.englishapp;

import java.io.Serializable;

public class Courses implements Serializable {

    String name;
    int image, noidung, title;
    int image2;

    public Courses(String name, int image, int noidung, int image2) {
        this.name = name;
        this.image = image;
        this.noidung = noidung;
        this.image2 = image2;
    }

    public int getImage2() {
        return image2;
    }

    public void setImage2(int image2) {
        this.image2 = image2;
    }

    public Courses(String name, int image, int noidung) {
        this.name = name;
        this.image = image;
        this.noidung = noidung;
    }

    public int getTitle() {
        return title;
    }

    public void setTitle(int title) {
        this.title = title;
    }

    public int getNoidung() {
        return noidung;
    }

    public void setNoidung(int noidung) {
        this.noidung = noidung;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public Courses(String name, int image) {
        this.name = name;
        this.image = image;
    }

    public Courses(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
