package com.example.try_69.domain;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Building {
        @Id
        @GeneratedValue(strategy=GenerationType.AUTO)
        private Long id;

        @NotBlank(message = "Please fill the title!")
        @Length(max = 2048, message = "Title too long!")
        private String title;

        @NotBlank(message = "Please fill the address!")
        private String address;

        @NotNull(message = "Please fill the price!")
        private Long price;

        @NotBlank(message = "Please fill the category!")
        private String category;

        @NotNull(message = "Please fill the area!")
        private String area;

        @NotBlank(message = "Please fill the description!")
        private String description;

        @NotBlank(message="Please type your e-mail, so other users can contact you")
        private String email;

        @NotBlank(message="Please type your phone number, so other users can contact you")
        private String phoneNumber;

        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "user_id")
        private User author;

        private String filename;

    public Building() {
    }

    public Building(
            String title,
            String address,
            User user,
            Long price,
            String category,
            String area,
            String description,
            String email,
            String phoneNumber
    ) {
        this.author = user;
        this.title = title;
        this.address = address;
        this.price = price;
        this.category = category;
        this.area = area;
        this.description = description;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getAuthorName(){ return author!=null ? author.getUsername() : "<none>"; }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public User getAuthor() { return author; }

    public void setAuthor(User author) { this.author = author; }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public String getAddress() { return address; }

    public void setAddress(String address) { this.address = address; }

    public Long getPrice() { return price; }

    public void setPrice(Long price) { this.price = price; }

    public String getFilename() { return filename; }

    public void setFilename(String filename) { this.filename = filename; }

    public String getCategory() { return category; }

    public void setCategory(String category) { this.category = category; }

    public String getArea() { return area; }

    public void setArea(String area) { this.area = area; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public String getEmail() { return email; }

    public void setEmail(String mail) { this.email = mail; }

    public String getPhoneNumber() { return phoneNumber; }

    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
}
