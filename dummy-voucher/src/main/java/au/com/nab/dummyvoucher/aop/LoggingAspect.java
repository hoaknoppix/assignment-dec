package au.com.nab.dummyvoucher.aop;

import java.util.Arrays;
import java.util.stream.Collectors;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class LoggingAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(au.com.nab.dummyvoucher.aop.LoggingAspect.class);

    @Around("within(au.com.nab.dummyvoucher.service..*)")
    public Object logServiceInvocation(ProceedingJoinPoint joinPoint) throws Throwable {

        Object proceedResult = joinPoint.proceed();
        String arguments = Arrays.stream(joinPoint.getArgs())
            .map(String::valueOf)
            .collect(Collectors.joining(", "));

        String result = "Void";
        Class returnType = ((MethodSignature) joinPoint.getSignature()).getReturnType();
        if (!returnType.equals(Void.TYPE)) {
            if (proceedResult != null) {
                result = String.valueOf(proceedResult);
            } else {
                result = "null";
            }
        }

        LOGGER.info("{}.{}[{}] = {}", joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName(), arguments, result);
        return proceedResult;
    }
}
