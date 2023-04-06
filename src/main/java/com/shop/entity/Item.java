package com.shop.entity;

import com.shop.constant.ItemSellStatus;
import com.shop.dto.ItemFormDto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

// Entity : Item 클래스를 entity로 선언
// Table : item 테이블과 매핑되도록 name을 item으로 지정
@Entity
@Table(name="item")
@Getter
@Setter
@ToString
public class Item extends BaseEntity{

    // Id : 기본키가 되는 멤버변수
    // Column : 테이블에 매핑될 컬럼의 이름 설정
    // GeneratedValue : 기본키 생성 전략을 자동으로 지정
    @Id
    @Column(name="item_id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id; // 상품 코드

    // Column 의 nullable 속성 : 항상 값이 있어야 하는 필드를 not null 설정
    @Column(nullable=false, length=50)
    private String itemNm; // 상품명

    @Column(name="price", nullable=false)
    private int price; // 가격

    @Column(nullable=false)
    private int stockNumber; // 재고 수량

    @Lob
    @Column(nullable=false)
    private String itemDetail; // 상품 상세 설명

    @Enumerated(EnumType.STRING)
    private ItemSellStatus itemSellStatus; // 상품 판매 상태

    public void updateItem(ItemFormDto itemFormDto) {
        this.itemNm = itemFormDto.getItemNm();
        this.price = itemFormDto.getPrice();
        this.stockNumber = itemFormDto.getStockNumber();
        this.itemDetail = itemFormDto.getItemDetail();
        this.itemSellStatus = itemFormDto.getItemSellStatus();
    }

}   
