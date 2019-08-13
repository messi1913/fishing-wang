package com.ddastudio.fishing.exception;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

public class ErrorResource extends Resource<ErrorVO> {

    public ErrorResource(ErrorVO vo, Link... links) {
        super(vo, links);
    }
}