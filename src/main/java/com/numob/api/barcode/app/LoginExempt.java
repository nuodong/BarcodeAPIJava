package com.numob.api.barcode.app;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Add this annotation to controller's request handler method if it does not require user to login.
 * Login is required for each request by default. It is enabled by the {@link LoginInterceptor}.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface LoginExempt {

}
