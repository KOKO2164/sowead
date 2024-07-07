package com.sowead.app.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Storage {
    private int storageId;
    private String code;
    private String name;
    private String description;
    private boolean status;
}
