/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superhero.form;

/**
 *
 * @author Burke Treboni
 */
public class AddSuperForm {

    private String superName;
    private String superDescription;
    private Integer superPowerId;
    private Integer organizationId;

    public String getSuperName() {
        return superName;
    }

    public void setSuperName(String superName) {
        this.superName = superName;
    }

    public String getSuperDescription() {
        return superDescription;
    }

    public void setSuperDescription(String superDescription) {
        this.superDescription = superDescription;
    }

    public Integer getSuperPowerId() {
        return superPowerId;
    }

    public void setSuperPowerId(Integer superPowerId) {
        this.superPowerId = superPowerId;
    }

    public Integer getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Integer organizationId) {
        this.organizationId = organizationId;
    }

}
