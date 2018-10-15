package com.sanjogstha.codewars.di;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

/*
 * Created by sanjogstha on 2/13/18.
 * sanjogshrestha.nepal@gmail.com
 */

@Qualifier
@Retention(RetentionPolicy.RUNTIME)
public @interface ApplicationContext {}
