package ru.kpfu.itis.gnt.model;

import lombok.*;

@Builder
@Data
@AllArgsConstructor
public class TestDataObject {

    private String password;
    private String email;
    private String accountCode;
    private String text;
    private String baseUrl;
}
