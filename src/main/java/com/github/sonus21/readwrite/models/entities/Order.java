package com.github.sonus21.readwrite.models.entities;

import com.github.sonus21.readwrite.db.converter.CurrencyCodeAttributeConverter;
import com.github.sonus21.readwrite.models.enums.CurrencyCode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.Instant;

@Builder
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "tracking_id")
    private String trackingId;

    @Column(name = "merchant_id")
    private String merchantId;

    @Column(name = "merchant_order_id")
    private String merchantOrderId;

    @Column(name = "user_id")
    private String userId;

    @CreationTimestamp
    @Column(name = "created_at")
    private Instant createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private Instant updatedAt;

    @Column(name = "amount")
    private Double amount;

    @Column(name = "currency")
    @Convert(converter = CurrencyCodeAttributeConverter.class)
    private CurrencyCode currency;
}
