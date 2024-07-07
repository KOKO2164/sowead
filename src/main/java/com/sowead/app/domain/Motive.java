package com.sowead.app.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Motive {
    private int motiveId;
    private String name;
    private String category;
    private boolean status;
}
