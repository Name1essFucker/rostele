package com.example.try_69.domain;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class TechSupport {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String message;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User author;

    private String filename;

    public TechSupport(){}

    public TechSupport(
            String message,
            User user
    ){
        this.author = user;
        this.message = message;
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getMessage() { return message; }

    public void setMessage(String message) { this.message = message; }

    public User getAuthor() { return author; }

    public void setAuthor(User author) { this.author = author; }

    public String getFilename() { return filename; }

    public void setFilename(String filename) { this.filename = filename; }
}
