package threaad.bounded;

public interface BoundedQueue { //버퍼 역할
    void put(String data); // 버퍼에 데이터 보관

    String take(); // 버퍼에 보관된 값을 가져간다.
}
