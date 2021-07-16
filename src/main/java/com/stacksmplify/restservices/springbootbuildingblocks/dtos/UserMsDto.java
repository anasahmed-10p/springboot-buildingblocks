package com.stacksmplify.restservices.springbootbuildingblocks.dtos;

public class UserMsDto {

    private Long userId;
    private String userName;
    private String emailAddress;

    public UserMsDto() {
    }

    public UserMsDto(Long userId, String userName, String emailAddress) {
        this.userId = userId;
        this.userName = userName;
        this.emailAddress = emailAddress;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
}
