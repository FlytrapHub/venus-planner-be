package com.flytrap.venusplanner.global.exception.custom;

/**
 * Enum 타입 불일치 시 발생하는 예외입니다.
 * 주어진 타입 이름이 Enum 클래스의에 존재하는 타입과 일치하지 않을 때 이 예외를 사용합니다.
 */
public class NoSuchEnumTypeException extends RuntimeException {

    /**
     * NoSuchEnumTypeException 생성자
     *
     * @param enumClazz 타입을 체크할 Enum의 Class 인스턴스
     * @param mismatchedTypeName 타입을 체크할 Enum에 존재하지 않는 타입 이름
     */
    public NoSuchEnumTypeException(Class<?> enumClazz, String mismatchedTypeName) {
        super(String.format("[%s]은(는) [%s]의 타입이 아닙니다.", mismatchedTypeName, enumClazz.getSimpleName()));
    }
}
