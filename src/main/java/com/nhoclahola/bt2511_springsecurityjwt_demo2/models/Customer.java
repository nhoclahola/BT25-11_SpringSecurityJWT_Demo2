package com.nhoclahola.bt2511_springsecurityjwt_demo2.models;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Customer
{
    private String id;
    private String name;
    private String phoneNumber;
    private String email;
}
