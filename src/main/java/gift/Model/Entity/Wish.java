package gift.Model.Entity;

import gift.Model.Value.Count;
import jakarta.persistence.*;

@Entity
public class Wish {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn (nullable = false)
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private Product product;

    @Embedded
    @Column(nullable = false)
    private Count count;

    protected Wish(){}

    public Wish(Member member, Product product, Count count) {
        this.member = member;
        this.product = product;
        this.count = count;
    }

    public Long getId() {
        return id;
    }

    public Member getMember() {
        return member;
    }

    public Product getProduct() {
        return product;
    }

    public Count getCount() {
        return count;
    }

    public void update(Member member, Product product, Count count){
        this.member = member;
        this.product = product;
        this.count = count;
    }
}
