package com.bookmark.sse;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;

/**
 * @author: hj
 * @date: 2021-08-03 09:46
 * @description:
 **/
@Setter
@Getter
public class BackTestCompletedEvent extends ApplicationEvent {
    private String backTestId;

    public BackTestCompletedEvent(Object source, String backTestId) {
        super(source);
        this.backTestId = backTestId;
    }
}
