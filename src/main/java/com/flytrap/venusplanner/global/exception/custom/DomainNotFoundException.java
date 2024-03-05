package com.flytrap.venusplanner.global.exception.custom;

/**
 * 데이터베이스에서 도메인 엔티티를 조회할 때, 해당 엔티티가 데이터베이스에 존재하지 않는 경우에 사용합니다.
 */
public class DomainNotFoundException extends RuntimeException {

    /**
     * DomainNotFoundException 생성자
     *
     * @param domainClazz 찾을 수 없는 도메인의 Class 인스턴스.
     * @param domainId 찾을 수 없는 도메인의 ID.
     */
    public DomainNotFoundException(Class<?> domainClazz, Long domainId) {
        super(String.format("[id = %d]에 해당하는 [%s] 도메인을 찾을 수 없습니다.", domainId, domainClazz.getSimpleName()));
    }
}
