package com.example.try_69.domain;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;

@Entity
public class Message {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Please fill the message")
    @Length(max = 2048, message = "Message too long (more than 2kB)")
    private String text;

    @Length(max = 255, message = "Message too long (more than 255)")
    private String email;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User author;

    private String filename;

    public Message() {
    }

    public Message(String text, String email, User user) {
        this.author = user;
        this.text = text;
        this.email = email;
    }

    public String getAuthorName() { return author != null ? author.getUsername() : "<none>"; }

    public User getAuthor() { return author; }

    public void setAuthor(User author) { this.author = author; }

    public void setText(String text) { this.text = text; }

    public String getText() { return text; }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getFilename() { return filename; }

    public void setFilename(String filename) { this.filename = filename; }
}
