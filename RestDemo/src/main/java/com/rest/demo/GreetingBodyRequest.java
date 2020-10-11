package com.rest.demo;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
public class GreetingBodyRequest {
    @NotNull(message = "msg不能为空")
    @Size(min = 1, message = "msg长度不能小于1")

    private String msg;
}