package com.teamcore.site.domain;

public class AbstractDomainClass implements DomainObject {
    private Integer id;

    @Override
    public Integer getId() {
        return this.id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }
}
