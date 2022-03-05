package com.ravi.major.dto.requestentity;
import com.ravi.major.dto.UserDto;
import com.ravi.major.enums.Gender;

public class CustomerSignUpRequest extends UserDto {
    private String name;
    private Gender gender;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
