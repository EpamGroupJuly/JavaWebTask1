package com.teamcore.site.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(exclude = "users")
public @Data class Skill extends AbstractDomainClass {
    private String name;

}
