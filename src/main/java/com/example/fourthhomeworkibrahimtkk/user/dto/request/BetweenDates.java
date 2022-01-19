package com.example.fourthhomeworkibrahimtkk.user.dto.request;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class BetweenDates {

    private String startDate;
    private String endDate;
}
