package gift.Model.Entity;

import gift.Model.Value.Name;
import gift.Model.Value.Quantity;
import jakarta.persistence.*;

import java.util.regex.Pattern;

@Entity
public class Option {

    private static final Pattern NAME_PATTERN = Pattern.compile(
            "^[a-zA-Z0-9ㄱ-ㅎㅏ-ㅣ가-힣 ()\\[\\]+\\-\\&/_]*$"
    );

    private static final int NAME_MAX_LENGTH = 50;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Embedded
    @Column(nullable = false)
    private Name name;

    @Embedded
    private Quantity quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Product product;

    private Option() {}

    public Option(Name name, Quantity quantity, Product product) {
        name.checkNameLength(NAME_MAX_LENGTH);
        name.checkNamePattern(NAME_PATTERN);
        validateProduct(product);

        this.name = name;
        this.quantity = quantity;
        this.product = product;
    }

    public void validateProduct(Product product) {
        if (product == null)
            throw new IllegalArgumentException("옵션에 product 지정은 필수입니다");
    }

    public Long getId() {
        return id;
    }

    public Name getName() {
        return name;
    }

    public Quantity getQuantity() {
        return quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void update(Name name, Quantity quantity){
        name.checkNameLength(NAME_MAX_LENGTH);
        name.checkNamePattern(NAME_PATTERN);

        this.name = name;
        this.quantity = quantity;
    }

    public void subtract(int quantity){
        this.quantity.subtract(quantity);
    }

    public boolean hasSameName(String name){
        return this.name.isSame(name);
    }

    public boolean isBelongToProduct(Long productId){
        return this.product.isSameId(productId);
    }
}
