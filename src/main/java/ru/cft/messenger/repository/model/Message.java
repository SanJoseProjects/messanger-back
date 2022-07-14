package ru.cft.messenger.repository.model;

import javax.persistence.*;

@Entity
@Table(name = "message")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "sender_id", nullable = false)
    private long senderId;

    @Column(name = "receiver_id", nullable = false)
    private long receiverId;

    @Column(name = "message", nullable = false)
    private String message;

    public long getId() { return id; }
    public long getSenderId() { return senderId; }
    public long getReceiverId() { return receiverId; }
    public String getMessage() { return message; }

    public void setId(long id) { this.id = id; }
    public void setSenderId(long senderId) { this.senderId = senderId; }
    public void setReceiverId(long receiverId) { this.receiverId = receiverId; }
    public void setMessage(String message) { this.message = message; }
}
