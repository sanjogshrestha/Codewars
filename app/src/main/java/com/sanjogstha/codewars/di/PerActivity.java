package com.sanjogstha.codewars.di;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/*
 * Created by sanjogstha on 2/13/18.
 * sanjogshrestha.nepal@gmail.com
 */

@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface PerActivity {}

