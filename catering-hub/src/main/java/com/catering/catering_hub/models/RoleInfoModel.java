package com.catering.catering_hub.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "roles_Master")
public class RoleInfoModel {

    @Id
    @Column(name = "role_id")
    private Integer roleId;
    @Column(name = "role_name")
    private String roleName;
    @Column(name = "role_desc")
    private String roleDescription;

    public RoleInfoModel() {
    }

    public RoleInfoModel(Integer roleId, String roleName, String roleDescription) {
        this.roleId = roleId;
        this.roleName = roleName;
        this.roleDescription = roleDescription;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDescription() {
        return roleDescription;
    }

    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }
}
