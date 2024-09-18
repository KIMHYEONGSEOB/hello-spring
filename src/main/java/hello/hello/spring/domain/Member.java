package hello.hello.spring.domain;

public class Member {
    //id 식별자와 이름이 있어야함
    private long id;//임의의 값 시스템이 저장함
    private String name; //그냥 이름

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
