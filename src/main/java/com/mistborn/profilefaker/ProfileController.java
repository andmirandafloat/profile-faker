package com.mistborn.profilefaker;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Month;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
public class ProfileController {

  @GetMapping("/{userId}")
  public SimpleItemResponse<UserProfileResponse> getProfile(@PathVariable Long userId) {
    UserProfileResponse response = UserProfileResponse.builder()
        .dateOfBirth(LocalDate.of(1992, Month.NOVEMBER, 14))
        .favoriteStore("Santa Fe")
        .firstName("Alfredo")
        .idUser(String.valueOf(userId))
        .lastName("Miranda")
        .loginEmail("amirandaf@liverpool.com.mx")
        .sex("H")
        .notificationEmail("amirandaf@liverpool.com.mx")
        .build();
    SimpleItemResponse<UserProfileResponse> itemResponse = new SimpleItemResponse<>();
    itemResponse.setData(response);
    return itemResponse;
  }
}

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
class UserProfileResponse {
  private String idUser;
  private String loginEmail;
  private String firstName;
  private String lastName;
  private String sex;
  private String middleName;
  private LocalDate dateOfBirth;
  private String favoriteStore;
  private String notificationEmail;
}

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
class SimpleItemResponse<T> implements Serializable {
  private T data;
}
