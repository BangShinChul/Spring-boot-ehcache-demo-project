package com.example.ehcache.demo.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@RequiredArgsConstructor
public class Task implements Serializable {
    /**
     * 해당 클래스에서 Serializable을 상속받는 이유는 아래와 같다.
     *
     * ehcache3는 캐싱할 데이터를 3가지 저장소에 옮겨 캐싱할 수 있다.
     * 1. 힙 메모리
     * 2. 힙 메모리의 밖 메모리
     * 3. 디스크
     *
     * 2,3번 저장소의 경우 캐시 데이터가 삭제되지 않지만 1번의 경우에는 GC에 의해 삭제가 될 수 있다.
     * 따라서 ehcache3는 여러 종류의 저장소에 캐싱할 수 있는 선택지를 주는 것인데,
     * 힙 메모리는 JVM 내부에 있는 메모리이기 때문에 상관 없지만 2,3번의 경우에는 JVM을 벗어난 저장소이기 때문에
     * JVM의 힙 메모리가 아닌 곳에 JVM의 데이터를 저장하기 위해서는 직렬화(Serialize)가 필요하다.
     *
     * 직렬화 관련 참고 : https://nesoy.github.io/articles/2018-04/Java-Serialize
     *
     * 따라서 해당 Task 모델을 외부 저장소에 캐시하기 위해 Serializable을 상속받아 직렬화한 것이다.
     * */

    private final long id;
    private final String task;
    private final boolean completed;
}
