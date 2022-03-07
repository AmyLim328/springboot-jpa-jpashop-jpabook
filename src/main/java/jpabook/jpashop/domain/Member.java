package jpabook.jpashop.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Member {

    @Id
    @GeneratedValue
    @Column(name = "MEMBER_ID") // 대문자 or 소문자 : 각자 회사의 rule에 따르면 된다
    private Long id;
    private String name;
    private String city;
    private String street;
    private String zipcode;

    @OneToMany(mappedBy = "member") // 연관관계의 주인은 member
    private List<Order> orders = new ArrayList<>(); // JPA/hibernate 관례 상 ArrayList로 초기화하는 걸 많이 사용 // NullPointerException 방지하는 등의 여러가지 장점이 있음
    // 잘못된 코드라고 생각 (예시라서 이렇게 작성)
    // MEMBER ENTITY 에서 MEMBER의 ORDERS를 꺼낼 일이 있을까? // 멤버 조회 주문 조회 따로 조회하는 게 맞다

    // getter 가급적이면 만들어 줄 필요가 있고, setter 고민할 필요가 있음 (setter 만들면 아무데서나 set 할 수 있으니까) // 예제니까 일단 모두 만듦
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }
}
