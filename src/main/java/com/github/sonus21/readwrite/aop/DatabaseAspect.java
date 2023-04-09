package com.github.sonus21.readwrite.aop;

import com.github.sonus21.readwrite.database.DatabaseContext;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Optional;

@Aspect
@Component
public class DatabaseAspect {
    @Around("@within(Database) || @annotation(Database)")
    public Object database(ProceedingJoinPoint jointPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) jointPoint.getSignature();
        Method method = signature.getMethod();
        String name = findDatabaseName(method).orElse("");
        try {
            DatabaseContext.set(name);
            return jointPoint.proceed();
        } finally {
            DatabaseContext.clear();
        }
    }

    private Optional<String> findDatabaseName(Method method) {
        Database database = Optional.ofNullable(method.getAnnotation(Database.class)).orElseGet(() -> {
            Class<?> klass = method.getDeclaringClass();
            return AnnotationUtils.findAnnotation(klass, Database.class);
        });
        return Optional.ofNullable(database).map(Database::value);
    }
}
