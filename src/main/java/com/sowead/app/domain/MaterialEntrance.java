package com.sowead.app.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MaterialEntrance {
    private int materialEntranceId;
    private String description;
    private int quantity;
    private double price;
    private boolean status;
    private User user;
    private Motive motive;
    private Storage storage;
}
