package ch.zhaw.bauersteine.model;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
public class Mail {

    private String to;
    private String subject;
    private String message;
}