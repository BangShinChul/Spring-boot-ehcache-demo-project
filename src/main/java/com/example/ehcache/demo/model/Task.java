package com.example.ehcache.demo.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@RequiredArgsConstructor
public class Task implements Serializable {

    private final long id;
    private final String task;
    private final boolean completed;

    /**
     * 해당 클래스에서 Serializable을 상속받는 이유는 아래와 같다.
     *
     * ehcache3는 캐싱할 데이터를 3가지 저장소에 옮겨 캐싱할 수 있다.
     * 1. 힙 메모리 : <heap></heap>
     * 2. 힙 메모리의 밖 메모리 <offheap></offheap>
     * 3. 디스크 <disk></disk>
     *
     * 2,3번 저장소의 경우 캐시 데이터가 삭제되지 않지만 1번의 경우에는 GC에 의해 삭제가 될 수 있다.
     * 따라서 ehcache3는 여러 종류의 저장소에 캐싱할 수 있는 선택지를 주는 것인데,
     * 힙 메모리는 JVM 내부에 있는 메모리이기 때문에 상관 없지만 2,3번의 경우에는 JVM을 벗어난 저장소이기 때문에
     * JVM의 힙 메모리가 아닌 곳에 JVM의 데이터를 저장하기 위해서는 직렬화(Serialize)가 필요하다.
     *
     * 직렬화란?
     * - 자바 시스템 내부에서 사용되는 Object 또는 Data를 외부의 자바 시스템에서도 사용할 수 있도록 byte 형태로 데이터를 변환하는 기술.
     * - JVM(Java Virtual Machine 이하 JVM)의 메모리에 상주(힙 또는 스택)되어 있는 객체 데이터를 바이트 형태로 변환하는 기술
     *
     * 직렬화 관련 참고 : https://nesoy.github.io/articles/2018-04/Java-Serialize
     *
     * 따라서 해당 Task 모델을 외부 저장소에 캐시하기 위해 Serializable을 상속받아 직렬화한 것이다.
     *
     * +추가
     *
     * 반대로 역 직렬화란?
     * - byte로 변환된 Data를 원래대로 Object나 Data로 변환하는 기술을 역직렬화(Deserialize)라고 부름.
     * - 직렬화된 바이트 형태의 데이터를 객체로 변환해서 JVM으로 상주시키는 형태.
     * */

}
