package com.sda;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class Question {
private String question;

private String answerA;
private String answerB;
private String answerC;
private String answerD;

private String correctAnswer;


}
