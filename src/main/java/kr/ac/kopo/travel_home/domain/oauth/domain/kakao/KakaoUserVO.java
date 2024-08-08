package kr.ac.kopo.travel_home.domain.oauth.domain.kakao;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class KakaoUserVO {
    private Long id;

    @JsonProperty("connected_at")
    private String connectedAt;

    @JsonProperty("kakao_account")
    private KakaoAccount kakaoAccount;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class KakaoAccount {
        @JsonProperty("name_needs_agreement")
        private boolean nameNeedsAgreement;

        @JsonProperty("name")
        private String name;

        @JsonProperty("has_email")
        private boolean hasEmail;

        @JsonProperty("email_needs_agreement")
        private boolean emailNeedsAgreement;

        @JsonProperty("is_email_valid")
        private boolean isEmailValid;

        @JsonProperty("is_email_verified")
        private boolean isEmailVerified;

        @JsonProperty("email")
        private String email;

        @JsonProperty("has_phone_number")
        private boolean hasPhoneNumber;

        @JsonProperty("phone_number_needs_agreement")
        private boolean phoneNumberNeedsAgreement;

        @JsonProperty("phone_number")
        private String phoneNumber;

        @JsonProperty("has_age_range")
        private boolean hasAgeRange;

        @JsonProperty("age_range_needs_agreement")
        private boolean ageRangeNeedsAgreement;

        @JsonProperty("age_range")
        private String ageRange;

        @JsonProperty("has_birthyear")
        private boolean hasBirthyear;

        @JsonProperty("birthyear_needs_agreement")
        private boolean birthyearNeedsAgreement;

        @JsonProperty("birthyear")
        private String birthyear;

        @JsonProperty("has_birthday")
        private boolean hasBirthday;

        @JsonProperty("birthday_needs_agreement")
        private boolean birthdayNeedsAgreement;

        @JsonProperty("birthday")
        private String birthday;

        @JsonProperty("birthday_type")
        private String birthdayType;

        @JsonProperty("has_gender")
        private boolean hasGender;

        @JsonProperty("gender_needs_agreement")
        private boolean genderNeedsAgreement;

        @JsonProperty("gender")
        private String gender;
    }
}
