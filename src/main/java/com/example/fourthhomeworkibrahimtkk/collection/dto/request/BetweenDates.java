package com.example.fourthhomeworkibrahimtkk.collection.dto.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BetweenDates {

    private String startDate;
    private String endDate;
}
