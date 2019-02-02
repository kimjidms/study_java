package 김은지_ch09;

public interface StringList<T> {

    void add(T value); // 리스트 마지막에 값 추가
    void add(int index, T value);
    T get(int index); // 인덱스의 값 반환
    void remove(int index); // 인덱스의 값 삭제
    boolean isEmpty(); // 리스트가 비었는지 확인
    int size(); // 리스트에 저장된 사이즈
    void clear(); // 리스트를 비움
}