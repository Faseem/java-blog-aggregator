package com.fsm.app.annotation;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.Size;

@Target({ FIELD })
@Retention(RUNTIME)
@Constraint(validatedBy = {UniqueUserNameValidator.class })
public @interface UniqueUserName {
	
	String message();

	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };


}
